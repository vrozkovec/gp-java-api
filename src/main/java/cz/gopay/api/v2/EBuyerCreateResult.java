package cz.gopay.api.v2;

import java.io.Serializable;

import cz.gopay.api.v2.axis.AxisEPaymentProviderV2;

/**
 * Komunikacni element reprezentuje navratovou hodnotu volani WS {@link AxisEPaymentProviderV2#createBuyer(EBuyerCreate)}   
 */
public class EBuyerCreateResult implements Serializable {
	private static final long serialVersionUID = 6676388017620691103L;

	/** 
	 * Vysledek volani webove sluzby - OK
	 * @see EBuyerCreateResult#getResult() 
	 */
	public static final String CALL_COMPLETED="CALL_COMPLETED";
	
	/** 
	 * Vysledek volani webove sluzby - Chyba
	 * @see EBuyerCreateResult#getResult()
	 */  
	public static String CALL_FAILED="CALL_FAILED";	
	
	
	/** 
	 * Popis vysledku zalozeni uzivatele - Systemova chyba 
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_SYSTEM_ERROR="SYSTEM_ERROR";
	
	/** 
	 * Popis vysledku zalozeni uzivatele - Nevalidni vstup
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_INVALID_INPUT="INVALID_INPUT";

	/** 
	 * Popis vysledku zalozeni uzivatele - Uzivatel zalozen 
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static final String DESC_BUYER_CREATED="BUYER_CREATED";

	/** 
	 * Popis vysledku zalozeni uzivatele - blize nespecifikovana chyba 
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_INTERNAL_ERROR="INTERNAL_ERROR";

	/** 
	 * Popis vysledku zalozeni uzivatele - email neni unikatni 
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_EMAIL_NOT_UNIQUE="EMAIL_NOT_UNIQUE";
	
	/** 
	 * Popis vysledku zalozeni uzivatele - uzivatelske jmeno neni unikatni 
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_USERNAME_NOT_UNIQUE="USERNAME_NOT_UNIQUE";

	/** 
	 * Popis vysledku zalozeni uzivatele - neplatny email 
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_INVALID_EMAIL="INVALID_EMAIL";
	
	/** 
	 * Popis vysledku zalozeni uzivatele - neplatne uzivatelske jmeno
	 * @see EBuyerCreateResult#getResultDescription() 
	 */
	public static String DESC_INVALID_USERNAME="INVALID_USERNAME";
	
	private Long eshopGoId;
	private String buyerUsername;
	private Long buyerGoId;
	private String result;
	private String resultDescription;
	private String encryptedSignature;

	/**
	 * Zakladni konstruktor
	 */
	public EBuyerCreateResult() {

	}

	/**
	 * Kopirovaci konstruktor
	 * @param buyerCreateResult navratova hodnota po vytvoreni uzivatele 
	 */
	public EBuyerCreateResult(EBuyerCreateResult buyerCreateResult) {
		setEshopGoId(buyerCreateResult.getEshopGoId());
		setBuyerUsername(buyerCreateResult.getBuyerUsername());
		setBuyerGoId(buyerCreateResult.getBuyerGoId());
		setResult(buyerCreateResult.getResult());
		setResultDescription(buyerCreateResult.getResultDescription());
		setEncryptedSignature(buyerCreateResult.getEncryptedSignature());
	}

	
	/**
	 * Vraci identifikace obchodnika.
	 * @return identifikace obchodnika
	 */
	public Long getEshopGoId() {
		return eshopGoId;
	}

	/**
	 * Nastavi identifikaci obchodnika.
	 * @param eshopGoId identifikace obchodnika
	 */
	public void setEshopGoId(Long eshopGoId) {
		this.eshopGoId = eshopGoId;
	}

	/**
	 * Vraci uzivatelske jmeno vytvarenoho uzivatele. Pokud byl uzivatel 
	 * vytvaren bez uzivatelskeho jmena, pak vraci null.
	 * @return uzivatelske jmeno
	 */
	public String getBuyerUsername() {
		return buyerUsername;
	}

	/**
	 * Nastavi uzivatelske jmeno 
	 * @param buyerUsername uzivatelske jmeno
	 */
	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}

	/**
	 * Vraci podpis obsahu tohoto objektu. Tento samotny retezec se nepodepisuje.
	 * @see cz.gopay.api.v2.helper.GopayHelper
	 * @return podpis obsahu tohoto objektu
	 */
	public String getEncryptedSignature() {
		return encryptedSignature;
	}

	/**
	 * Nastavi podpis obsahu tohoto objektu  
	 * @param encryptedSignature podpis obsahu tohoto objektu
	 */
	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}

	/**
	 * Vraci identifikaci uzivatele.
	 * @return identifikace uzivatele
	 */
	public Long getBuyerGoId() {
		return buyerGoId;
	}

	/**
	 * Nastavi identifikaci uzivatele
	 * @param buyerGoId identifikace uzivatele
	 */
	public void setBuyerGoId(Long buyerGoId) {
		this.buyerGoId = buyerGoId;
	}

	/**
	 * Vrati vysledek volani
	 * @see cz.gopay.api.v2.EBuyerCreateResult#CALL_COMPLETED
	 * @see cz.gopay.api.v2.EBuyerCreateResult#CALL_FAILED
	 * @return vysledek volani
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Nastavi vysledek volani
	 * @see cz.gopay.api.v2.EBuyerCreateResult#CALL_COMPLETED
	 * @see cz.gopay.api.v2.EBuyerCreateResult#CALL_FAILED
	 * @param result vysledek volani
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Vrati textovy popis vysledku volani
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_SYSTEM_ERROR
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INVALID_INPUT
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_BUYER_CREATED
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INTERNAL_ERROR
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_EMAIL_NOT_UNIQUE
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_USERNAME_NOT_UNIQUE
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INVALID_EMAIL
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INVALID_USERNAME
	 * @return textovy popis vysledku volani
	 */
	public String getResultDescription() {
		return resultDescription;
	}

	/**
	 * Nastavi textovy popis vysledku volani
	 * @param resultDescription textovy popis vysledku volani
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_SYSTEM_ERROR
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INVALID_INPUT
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_BUYER_CREATED
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INTERNAL_ERROR
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_EMAIL_NOT_UNIQUE
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_USERNAME_NOT_UNIQUE
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INVALID_EMAIL
	 * @see cz.gopay.api.v2.EBuyerCreateResult#DESC_INVALID_USERNAME
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
}
