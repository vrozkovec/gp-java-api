package cz.gopay.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import cz.gopay.api.v2.ECustomerData;
import cz.gopay.api.v2.EPaymentCommand;
import cz.gopay.api.v2.EPaymentIdentity;
import cz.gopay.api.v2.EPaymentMethod;
import cz.gopay.api.v2.EPaymentSessionInfo;
import cz.gopay.api.v2.EPaymentStatus;
import cz.gopay.api.v2.axis.AxisEPaymentProviderV2;
import cz.gopay.api.v2.axis.AxisEPaymentProviderV2ServiceLocator;
import cz.gopay.api.v2.helper.CountryCode;
import cz.gopay.api.v2.helper.EPaymentConstants;
import cz.gopay.api.v2.helper.GopayException;
import cz.gopay.api.v2.helper.GopayHelper;

/**
 * @author Zbynek Novak
 * 
 * Demonstruje uziti API pro uplnou integraci GoPay
 * - zalozeni platby
 * - presmerovani na platebni branu
 * - kontrola stavu platby
 */
public class SimplePayment {
		
	public static final Long ESHOP_GOID = 8540279704l;//  zadejte vase testovaci EshopGoID
	public static final String SECURE_KEY = " ocxgXEL5psb7PAllKuCSblc9 ";//zadejte vas testovaci secret

	public static final String PRODUCT_NAME = "Testovaci platba";
	public static final String ORDER_ID = "OV1234556";
	public static final Long TOTAL_PRICE_IN_CENTS = 1011l;
	public static final String CURRENCY = "CZK";
	
	public static final String SUCCESS_URL = "http://success-test.cz";
	public static final String FAILED_URL = "http://fail-test.cz";
	
	////viz Kody platebnich metod - integracni manual;
	public static final String ALLOWED_PAYMENT_CHANNELS = GopayHelper.concatPaymentChannels(
															"eu_gp_u",
															"cz_kb", 
															"cz_rb",
															"cz_mb",
															"cz_fb",
															"eu_bank",
															"eu_gp_w",
															"SUPERCASH",
															"cz_mp",
															"eu_pr_sms");
	//viz Kody platebnich metod - integracni manual;
	public static final String DEFAULT_PAYMENT_CHANNELS = "cz_kb";
		
	public static final String CUST_FIRST_NAME = "Franta";
	public static final String CUST_LAST_NAME = "Vrana";
	
	public static final String CUST_EMAIL = "franta.vrana@gopay.cz";
	public static final String CUST_PHONE = "+420725698965s";
	
	public static final String CUST_CITY = "České Budějovice";	
	public static final String CUST_STREET = "Planá 67";
	public static final String CUST_ZIP = "37001";
	public static final String CUST_COUNTRY = String.valueOf(CountryCode.CZE);
		
	public static final String P1 = String.valueOf("P1");
	public static final String P2 = String.valueOf("P2");
	public static final String P3 = String.valueOf("P3");
	public static final String P4 = String.valueOf("P4 příliš žluťoučký text");
	
	//viz Kody jazyka - integracni manual;
	public static final String LANG = String.valueOf("CS");
	
	public static final String WS = EPaymentConstants.GOPAY_WS_ENDPOINT_TEST; //Zadejte spravne URL
	public static final String REDIRECT = EPaymentConstants.GOPAY_FULL_TEST;  //Zadejte spravne URL
	

	/**
	 * Vytvoreni testovaci platby
	 * 
	 * Platba musi byt vytvorena pred presmerovanim na platebni branu GoPay.
	 * 
	 * @return id of created payment - paymentSessionId
	 * 
	 * @throws ServiceException 
	 * @throws GopayException 
	 */
	public Long createPayment() throws ServiceException, GopayException {
		EPaymentStatus status = null;
		try {
			
			AxisEPaymentProviderV2 provider = new AxisEPaymentProviderV2ServiceLocator().getEPaymentServiceV2(new URL(WS));
	
			EPaymentCommand command = new EPaymentCommand();
			command.setProductName(PRODUCT_NAME);
			command.setOrderNumber(ORDER_ID);
			command.setTotalPrice(TOTAL_PRICE_IN_CENTS);
			command.setCurrency(CURRENCY);

			command.setTargetGoId(ESHOP_GOID);	//GoID eshopu

			command.setFailedURL(FAILED_URL);
			command.setSuccessURL(SUCCESS_URL);

			command.setPaymentChannels(ALLOWED_PAYMENT_CHANNELS);
			command.setDefaultPaymentChannel(DEFAULT_PAYMENT_CHANNELS);
					
			ECustomerData customerData = new ECustomerData();
			customerData.setFirstName(CUST_FIRST_NAME);
			customerData.setLastName(CUST_LAST_NAME);
			customerData.setEmail(CUST_EMAIL);
			customerData.setPhoneNumber(CUST_PHONE);
			customerData.setPostalCode(CUST_ZIP);
			customerData.setStreet(CUST_STREET);
			customerData.setCity(CUST_CITY);
			customerData.setCountryCode(CUST_COUNTRY);			
			command.setCustomerData(customerData);
			
			command.setP1(P1);
			command.setP2(P2);
			command.setP3(P3);
			command.setP4(P4);
			
			command.setLang(LANG);
			
			GopayHelper.signEPaymentCommand(command, SECURE_KEY);

			status = provider.createPayment(command);

			if (!EPaymentStatus.RESULT_CALL_COMPLETED.equals(status.getResult())) {				
				//status.getResultDescription() - popisuje chybovy stav
				throw new GopayException(GopayException.Reason.OTHER,
						"payment not created [" + status.getResultDescription() + "] ");
			}
			
			//Overeni podpisu
			GopayHelper.checkPaymentStatus(status, 
					ESHOP_GOID, 
					ORDER_ID, 
					TOTAL_PRICE_IN_CENTS, 
					CURRENCY, 
					PRODUCT_NAME, 
					SECURE_KEY);

		} catch (RemoteException e) {
			throw new GopayException(GopayException.Reason.OTHER,
					"WS failure [" + e + "] ", e);

		} catch (MalformedURLException e) {
			throw new GopayException(GopayException.Reason.OTHER,
					"URL failure [" + e + "] ", e);
		}		
			
		return status.getPaymentSessionId();
		
	}
	
	/**
	 * Priprava formulare pro presmerovani na platebni branu GoPay. 
	 * 
	 * @return formular
	 */
	public String redirectToGW(Long paymentSessionId){
		
		EPaymentSessionInfo info = new EPaymentSessionInfo();
		info.setTargetGoId(ESHOP_GOID);
		info.setPaymentSessionId(paymentSessionId);		
		GopayHelper.signEPaymentSession(info, SECURE_KEY);

		StringBuffer sb = new StringBuffer();		
		sb.append("<form action=\"" + REDIRECT + "\" method=\"post\" >");		
		sb.append("<input name=\"sessionInfo.targetGoId\" value=\"" + String.valueOf(info.getTargetGoId()) + "\" type=\"hidden\">");
		sb.append("<input name=\"sessionInfo.paymentSessionId\" value=\"" + String.valueOf(info.getPaymentSessionId()) + "\" type=\"hidden\">");
		sb.append("<input name=\"sessionInfo.encryptedSignature\" value=\"" + String.valueOf(info.getEncryptedSignature()) + "\" type=\"hidden\">");
		sb.append("<input name=\"pay\" value=\"Zaplatit - úplná integrace\" type=\"submit\">");		        
		sb.append("</form>");
				
		return sb.toString();
	}
	
	/**  
	 * Provede overeni zaplacenosti objednavky po zpetnem presmerovani z platebni brany na success URL.
	 * 
	 * @throws ServiceException 
	 * @throws GopayException 
	 */
	public void successUrl(EPaymentIdentity identity) throws ServiceException, GopayException {
		try {
			
			AxisEPaymentProviderV2 provider = new AxisEPaymentProviderV2ServiceLocator().getEPaymentServiceV2(new URL(WS));
		    
		    //kontrola parametru z redirectu - podpis, vazba na spravnou objednavku 
		    GopayHelper.checkPaymentIdentity(identity, ESHOP_GOID, ORDER_ID, SECURE_KEY);	    
			
			EPaymentSessionInfo info = new EPaymentSessionInfo();
			info.setTargetGoId(ESHOP_GOID);
			info.setPaymentSessionId(identity.getPaymentSessionId());
			GopayHelper.signEPaymentSession(info, SECURE_KEY);
				
			EPaymentStatus status = provider.paymentStatus(info);
	
			if (!EPaymentStatus.RESULT_CALL_COMPLETED.equals(status.getResult())) {
				throw new GopayException(GopayException.Reason.OTHER,
						"status failed [" + status.getResultDescription() + "] ");
			}
			//kontrola parametru ve stavu platby
			GopayHelper.checkPaymentStatus(status, 
					ESHOP_GOID, 
					ORDER_ID, 
					TOTAL_PRICE_IN_CENTS, 
					CURRENCY, 
					PRODUCT_NAME, 
					SECURE_KEY);
			
		    System.out.println("PAYMENT STATUS [paymentSessionId=" + status.getPaymentSessionId() + ", state="  + status.getSessionState() + "]");
			
			String forward = null;
			String message = null;
			String addMessage = null;
			
			if (EPaymentStatus.STATE_PAID.equals(status.getSessionState())) {
				//platba byla dokoncena - uhradte objednavku
				//prechazime na success url a prezentujeme message
				forward = "successURL";
				message = EPaymentConstants.msgReturnUrl(status.getSessionState());
				
			} else if (EPaymentStatus.STATE_PAYMENT_METHOD_CHOSEN.equals(status.getSessionState())) {
				//zakaznik uspesne zalozil platbu (napr. superCASH, bankovni platba) 
				forward = "successURL";
				message = EPaymentConstants.msgReturnUrl(status.getSessionState());				
				addMessage = EPaymentConstants.addMessage(status.getSessionSubState());
				
			} else if (EPaymentStatus.STATE_CANCELED.equals(status.getSessionState())) {
				//zakaznik provedl zruseni platby
				forward = "failedURL";
				message = EPaymentConstants.msgReturnUrl(status.getSessionState());				
				
			} else {
				forward = "failedURL";
				message = "Illegal state";				
				
			}
			
			//prechod na relevatni page + prezentace message	
			System.out.println("PAYMENT processing [page=" + forward + ", message=" + message + ", add-message=" + addMessage + "]");
		    
		} catch (Exception e) {
			System.out.println("E[" + e + "]");
		}
		
	}

	/**
	 * Zpracování návratu na failed URL
	 * 
	 * @param identity
	 * @throws ServiceException
	 * @throws GopayException
	 */
	public void failedUrl(EPaymentIdentity identity) throws ServiceException, GopayException {
	    //kontrola parametru z redirectu - podpis, vazba na spravnou objednavku 
	    GopayHelper.checkPaymentIdentity(identity, ESHOP_GOID, ORDER_ID, SECURE_KEY);	    

		String forward = "failedURL";
		String message = "Platba byla zrušena";				

		//prechod na relevatni page + prezentace message	
		System.out.println("FW[" + forward + "] " +
				"message[" + message + "]");

	}
	
	/**
	 * Overeni platby po prichodu HTTP notifikace
	 * 
	 * @param paymentSessionId
	 * @throws ServiceException 
	 * @throws GopayException 
	 */
	public void notify(EPaymentIdentity identity) throws ServiceException, GopayException {
		
		try {
			
			AxisEPaymentProviderV2 provider = new AxisEPaymentProviderV2ServiceLocator().getEPaymentServiceV2(new URL(WS));
		    
		    //kontrola parametru z redirectu - podpis, vazba na spravnou objednavku 
		    GopayHelper.checkPaymentIdentity(identity, ESHOP_GOID, ORDER_ID, SECURE_KEY);	    
			
			EPaymentSessionInfo info = new EPaymentSessionInfo();
			info.setTargetGoId(ESHOP_GOID);
			info.setPaymentSessionId(identity.getPaymentSessionId());
			GopayHelper.signEPaymentSession(info, SECURE_KEY);
				
			EPaymentStatus status = provider.paymentStatus(info);
	
			if (!EPaymentStatus.RESULT_CALL_COMPLETED.equals(status.getResult())) {
				throw new GopayException(GopayException.Reason.OTHER,
						"status failed [" + status.getResultDescription() + "] ");
			}
			//kontrola parametru ve stavu platby
			GopayHelper.checkPaymentStatus(status, 
					ESHOP_GOID, 
					ORDER_ID, 
					TOTAL_PRICE_IN_CENTS, 
					CURRENCY, 
					PRODUCT_NAME, 
					SECURE_KEY);
			
			System.out.println("PAYMENT STATUS[paymentSessionId=" + status.getPaymentSessionId() + ", state="  + status.getSessionState() + "]");
						
			if (EPaymentStatus.STATE_PAID.equals(status.getSessionState())) {
				//overeni stavu objednavky v ramci eshop
				//a) objednavka neni uhrazena => uhrada objednavky
				//b) objednavka je uhrazena => OK - znovu jiz nehradime - notifikace je dorucovana, 
				//dokud E-shop nevrati HTTP result code 200
				//c) objednavka v jinem stavu => zalogovani situace - informovani spravce systemu
				//HTTP result code 200 - notifikaci dorucujeme, dokud neni prijata
				
			} else if (EPaymentStatus.STATE_CANCELED.equals(status.getSessionState())) {
				//kontrola stavu objednavky v E-shopu
				//a) objednavku je mozne zrusit - zruseni objednavky
				//b) objednavku neni mozne zrusit - zalogovani situace - informovani spravce
				//HTTP result code 200 - notifikaci dorucujeme, dokud neni prijata
				
			} else if (EPaymentStatus.STATE_REFUNDED.equals(status.getSessionState())) {
				//storno platby na zaklade pozadavku obchodnika, nebo zakaznika
				//HTTP result code 200 - notifikaci dorucujeme, dokud neni prijata
				
			} else {
				//zalogovani situace - informovani spravce
				//HTTP result code 200 - notifikaci dorucujeme, dokud neni prijata 
			}
					    
		} catch (Exception e) {
			System.out.println("E[" + e + "]");
			
		}

	}
	

	/**
	 * Prehled dostupnych platebnich metod
	 */
	public void paymentMethodList() {
		
		try {
			
			AxisEPaymentProviderV2 provider = new AxisEPaymentProviderV2ServiceLocator().getEPaymentServiceV2(new URL(WS));
			EPaymentMethod[] paymentMethods = provider.paymentMethodList();
			
			for (EPaymentMethod ePaymentMethod : paymentMethods) {
				System.out.println("PM[ code=" + ePaymentMethod.getCode() + ", offline=" + ePaymentMethod.isOffline() + ", currencies=" + ePaymentMethod.getSupportedCurrency() + "]");
				
			}
			
			
					    
		} catch (Exception e) {
			System.out.println("E[" + e + "]");
			
		}

	}

	/**
	 * Simulace 
	 * - vytvoreni platby
	 * - overeni platby
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			SimplePayment sp = new SimplePayment();
						
			//Zalozeni platby
			Long paymentSessionId = sp.createPayment();
			System.out.println("\nCREATE [paymentSessionId=" + paymentSessionId + "]");
			
			//Sestaveni presmerovani na platebni branu GoPay
			System.out.println("\nFORM [" + sp.redirectToGW(paymentSessionId) + "]");
			
			
			//.......... provedeni platby....................//
			
			
			//sestaveni navratovych hodnot pri presmerovani na successURL
			EPaymentIdentity successElement = new EPaymentIdentity();
			successElement.setTargetGoId(ESHOP_GOID);
			successElement.setOrderNumber(ORDER_ID);
			successElement.setPaymentSessionId(paymentSessionId);
			successElement.setP1(P1);
			successElement.setP2(P2);
			successElement.setP2(P3);
			successElement.setP2(P4);
			GopayHelper.signEPaymentIdentity(successElement, SECURE_KEY);

			//simulace - prichod na success URL
			System.out.println("\nSUCCESS URL [paymentSessionId=" + successElement.getPaymentSessionId() + "]");
			sp.successUrl(successElement);			

			
			//simulace - prichod HTTP notifikace o zmene stavu platby
			//(HTTP notifikace muze prijit pred navratem na success URL)
			System.out.println("\nHTTP NOTIFY [paymentSessionId=" + successElement.getPaymentSessionId() + "]");
			sp.notify(successElement);
		

			System.out.println("\nList of payment methods");
			sp.paymentMethodList();

		} catch (ServiceException e) {
			System.out.println(e);
			
		} catch (GopayException e) {
			System.out.println(e);
		}

	}

}