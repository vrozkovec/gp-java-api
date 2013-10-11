package cz.gopay.api.v2;

import java.io.Serializable;

/**
 * Informacni element, ktery se pouziva pro informovani
 * o stavu zpracovaní pozadavku. 
 */
public class EPaymentResult implements Serializable {
	private static final long serialVersionUID = 5008511725133076912L;
	
	public static final String RES_ACCEPTED = "ACCEPTED";
	public static final String RES_FINISHED = "FINISHED";
	public static final String RES_FAILED = "FAILED";
	
	private Long paymentSessionId;
	private String result;
	private String resultDescription;
	private String encryptedSignature;
	
	/**
	 * Zakladni konstruktor
	 */
	public EPaymentResult() {}

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
	 * Vraci stav zpracování požadavku
	 * 
	 * {@link #RES_ACCEPTED} - požadavek zařazen do fronty
	 * {@link #RES_FINISHED} -požadavek úspěšně zpracován
	 * {@link #RES_FAILED} - zpracování skončilo chybou
	 * 
	 * @return stav zpracování
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Nastavuje stav zpracování požadavku
	 * 
	 * @param result stav zpracování
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Vrací textový popis reprezentující stav zpracování požadavku
	 * 
	 * @return textový popis
	 */
	public String getResultDescription() {
		return resultDescription;
	}

	/**
	 * Nastavuje textový popis zpracování požadavku
	 * 
	 * @param resultDescription
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
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
