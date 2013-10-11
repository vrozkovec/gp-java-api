package cz.gopay.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import cz.gopay.api.v2.EPaymentResult;
import cz.gopay.api.v2.EPaymentSessionInfo;
import cz.gopay.api.v2.ERefundRequest;
import cz.gopay.api.v2.axis.AxisEPaymentProviderV2;
import cz.gopay.api.v2.axis.AxisEPaymentProviderV2ServiceLocator;
import cz.gopay.api.v2.helper.EPaymentConstants;
import cz.gopay.api.v2.helper.GopayException;
import cz.gopay.api.v2.helper.GopayHelper;

/**
 * @author Michal Rottner
 * 
 * Demonstruje uziti API pro uplnou integraci GoPay
 * - refundace platby
 */
public class RefundPayment {
		
	public static final Long ESHOP_GOID = 8540279704l;//  zadejte vase testovaci EshopGoID
	public static final String SECURE_KEY = " ocxgXEL5psb7PAllKuCSblc9 ";//zadejte vas testovaci secret

	public static final Long AMOUNT_TO_REFUND = 50l;
	public static final String CURRENCY = "CZK";
	
	public static final String WS = EPaymentConstants.GOPAY_WS_ENDPOINT_TEST; //Zadejte spravne URL
	
	public static final String DESCRIPTION = "Poznamka k refundaci";
	

	public Long performRefund(Long paymentSessionId) throws ServiceException, GopayException {
		EPaymentResult result = null;
		try {
			
			AxisEPaymentProviderV2 provider = new AxisEPaymentProviderV2ServiceLocator().getEPaymentServiceV2(new URL(WS));
			
			EPaymentSessionInfo paymentSessionInfo = new EPaymentSessionInfo();
			paymentSessionInfo.setPaymentSessionId(paymentSessionId);
			paymentSessionInfo.setTargetGoId(ESHOP_GOID);
			
			GopayHelper.signEPaymentSession(paymentSessionInfo, SECURE_KEY);

			result = provider.refundPayment(paymentSessionInfo);

			if (! EPaymentResult.RES_FINISHED.equals(result.getResult())) {
				//status.getResultDescription() - popisuje chybovy stav
				throw new GopayException(GopayException.Reason.OTHER,
						"Payment cannot be refunded [" + result.getResultDescription() + "] ");
			}
			
			//Overeni podpisu
			GopayHelper.checkPaymentResult(result,
					paymentSessionId,
					SECURE_KEY);
			
		} catch (RemoteException e) {
			throw new GopayException(GopayException.Reason.OTHER,
					"WS failure [" + e + "] ", e);
			
		} catch (MalformedURLException e) {
			throw new GopayException(GopayException.Reason.OTHER,
					"URL failure [" + e + "] ", e);
		}
		
		return result.getPaymentSessionId();
		
	}
	
	public Long performPartialRefund(Long paymentSessionId) throws ServiceException, GopayException {
		EPaymentResult result = null;
		try {
			
			AxisEPaymentProviderV2 provider = new AxisEPaymentProviderV2ServiceLocator().getEPaymentServiceV2(new URL(WS));
	
			ERefundRequest refundRequest = new ERefundRequest();
			refundRequest.setPaymentSessionId(paymentSessionId);
			refundRequest.setTargetGoId(ESHOP_GOID);
			refundRequest.setAmount(AMOUNT_TO_REFUND);
			refundRequest.setCurrency(CURRENCY);			
			refundRequest.setDescription(DESCRIPTION);
			
			GopayHelper.signERefundRequest(refundRequest, SECURE_KEY);

			result = provider.refundPayment(refundRequest);

			if (! EPaymentResult.RES_FINISHED.equals(result.getResult())) {				
				//status.getResultDescription() - popisuje chybovy stav
				throw new GopayException(GopayException.Reason.OTHER,
						"Payment cannot be refunded [" + result.getResultDescription() + "] ");
			}
			
			//Overeni podpisu
			GopayHelper.checkPaymentResult(result, 
					paymentSessionId, 
					SECURE_KEY);

		} catch (RemoteException e) {
			throw new GopayException(GopayException.Reason.OTHER,
					"WS failure [" + e + "] ", e);

		} catch (MalformedURLException e) {
			throw new GopayException(GopayException.Reason.OTHER,
					"URL failure [" + e + "] ", e);
		}		
			
		return result.getPaymentSessionId();
		
	}	

	/**
	 * Simulace refundace platby a castecne refundace
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			RefundPayment rp = new RefundPayment();
			
			//simulace refundace - zadejte ID platby, kterou chcete refundovat
			rp.performRefund(3000000000l);
			System.out.println("\nPAYMENT refunded");
			
			//simulace refundace - zadejte ID platby, kterou chcete castecne refundovat, z platby bude refundovana castka AMOUNT_TO_REFUND
			rp.performRefund(3000000000l);
			System.out.println("\nPAYMENT partially refunded, refunded amount: " + AMOUNT_TO_REFUND / 100 + " " + CURRENCY);
		
		} catch (ServiceException e) {
			System.out.println(e);
			
		} catch (GopayException e) {
			System.out.println(e);
		}

	}

}