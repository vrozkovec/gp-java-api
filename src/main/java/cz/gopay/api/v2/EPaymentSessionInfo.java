package cz.gopay.api.v2;

import java.io.Serializable;

/**
 * Informacni element, ktery se pouziva pri
 * - presmerovani na platebni branu
 * - dotaz WS stav platby
 * - atd. 
 */
public class EPaymentSessionInfo implements Serializable {
	private static final long serialVersionUID = 5008511725133076912L;
	
	private Long paymentSessionId;
	private Long targetGoId;
	private String encryptedSignature;
	
	/**
	 * Zakladni konstruktor
	 */
	public EPaymentSessionInfo() {}

	/**
	 * Vraci jedinecny identifikator platby 
	 * 
	 * @return identifikator platby
	 */
	public Long getPaymentSessionId() {
		return paymentSessionId;
	}
	
	/**
	 * Nastaveni jedinecneho identifikatoru platby
	 * 
	 * @param paymentSessionId
	 */
	public void setPaymentSessionId(Long paymentSessionId) {
		this.paymentSessionId = paymentSessionId;
	}

	/**
	 * Vraci jedinecny identifikator prijemce platby
	 * - EshopGoID - identifikator eshopu
	 * - GoID - GoPay penezenky
	 * 
	 * @return identifikator prijemce platby
	 */
	public Long getTargetGoId() {
		return targetGoId;
	}

	/**
	 * Nastavi prijemce platby
	 * 
	 * @param targetGoId prijemce platby
	 */
	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}

	/**
	 * Vrati sifrovany podpis platby
	 * 
	 * @return sifrovany podpis
	 */
	public String getEncryptedSignature() {
		return encryptedSignature;
	}

	/**
	 * Nastavi sifrovany podpis
	 * 
	 * @param encryptedSignature - sifrovany podpis
	 */
	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}
	
	
}
