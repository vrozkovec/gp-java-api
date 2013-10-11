package cz.gopay.api.v2;

import java.io.Serializable;

import cz.gopay.api.v2.axis.AxisEPaymentProviderV2;

 
/**
 * Komunikacni element je parametrem volani WS {@link AxisEPaymentProviderV2#createBuyer(EBuyerCreate)}  
 */
public class EBuyerCreate implements Serializable {		
	private static final long serialVersionUID = -5776514272868551067L;

	private Long eshopGoId;
	private String buyerUsername;
	private String buyerEmail;
	private String encryptedSignature;

	
	/**
	 * Zakladni konstruktor
	 */
	public EBuyerCreate() {

	}

	/**
	 * Kopirovaci konstruktor
	 * @param buyerCreate prikaz pro vytvoreni uzivatele 
	 */
	public EBuyerCreate(EBuyerCreate buyerCreate) {
		setEshopGoId(buyerCreate.getEshopGoId());
		setBuyerUsername(buyerCreate.getBuyerUsername());
		setBuyerEmail(buyerCreate.getBuyerEmail());
		setEncryptedSignature(buyerCreate.getEncryptedSignature());
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
	 * Pokud objekt bude pri vytvoreni obsahovat null, tak bude mit uzivatel 
	 * pri pozdejsi aktivaci moznost sve uzivatelske jmeno nastavit. V opacnem 
	 * pripade jiz uzivatelske jmeno zmenit nepujde. 
	 * @return buyerUsername uzivatelske jmeno
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
	 * Vraci email uzivatele
	 * @return email uzivatele
	 */
	public String getBuyerEmail() {
		return buyerEmail;
	}
	
	/**
	 * Nastavi email uzivatele
	 * @param buyerEmail email uzivatele
	 */
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
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
	
	@Override
	public String toString() {
		return "BU:" + getBuyerUsername() + "-" + 
		"BE:" + getBuyerEmail() + "-" + 
		"E:" + getEshopGoId() + "-" + 
		"S:" + getEncryptedSignature() + ";";
	}
}
