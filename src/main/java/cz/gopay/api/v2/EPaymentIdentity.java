package cz.gopay.api.v2;


/**
 * Reprezentuje infomacni element, ktery je vracen pri presmerovani zpet
 * na eshop z platebni brany GoPay.  
 */
public class EPaymentIdentity {	
	
	private String orderNumber;
	private Long paymentSessionId;
	private Long parentPaymentSessionId;
	private Long targetGoId;
	private String encryptedSignature;
	private String p1;
	private String p2;
	private String p3;
	private String p4;

	public EPaymentIdentity() {}
	
	/**
	 * Vraci identifikator objednavky obchodnika
	 * 
	 * @return identifikator objednavky ochodnika
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Nastaveni identifikatoru objednavky obchodnika
	 * 
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Interni identifikator platby GoPay
	 * 
	 * @return identifikator platby
	 */
	public Long getPaymentSessionId() {
		return paymentSessionId;
	}

	/**
	 * Nastavuje interni identifikator platby GoPay
	 * 
	 * @param paymentSessionId
	 */
	public void setPaymentSessionId(Long paymentSessionId) {
		this.paymentSessionId = paymentSessionId;
	}

	/**
	 * Vraci jedinecny identifikator rodicovske platby obchodnika u opakovane platby
	 * 
	 * @return identifikator platby
	 */
	public Long getParentPaymentSessionId() {
		return parentPaymentSessionId;
	}

	/**
	 * Nastavuje jedinecny identifikator rodicovske platby obchodnika u opakovane platby
	 * 
	 */
	public void setParentPaymentSessionId(Long parentPaymentSessionId) {
		this.parentPaymentSessionId = parentPaymentSessionId;
	}

	/**
	 * Vraci jedinecny identifikator prijemce platby
	 * - EshopGoID - GoID - eshopu
	 * - GoID - uzivatele GoPay penezenky
	 * 
	 * @return GoID prijemce platby
	 */
	public Long getTargetGoId() {
		return targetGoId;
	}

	/**
	 * Nastavuje GoID prijemce platby
	 * 
	 * @param targetGoId
	 */
	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}

	/**
	 * Vraci sifrovany podpis komunikacniho elementu
	 * 
	 * @return sifrovany podpis
	 */
	public String getEncryptedSignature() {
		return encryptedSignature;
	}

	/**
	 * Nastavuje sifrovany podpis
	 * 
	 * @param encryptedSignature
	 */
	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}

	/**
	 * Obecny parametr definovany pri zalozeni platby {@link EPaymentCommand}
	 * 
	 * @return obecny parametr
	 */
	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	/**
	 * Obecny parametr definovany pri zalozeni platby {@link EPaymentCommand}
	 * 
	 * @return obecny parametr
	 */
	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Obecny parametr definovany pri zalozeni platby {@link EPaymentCommand}
	 * 
	 * @return obecny parametr
	 */
	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}
	
	/**
	 * Obecny parametr definovany pri zalozeni platby {@link EPaymentCommand}
	 * 
	 * @return obecny parametr
	 */
	public String getP4() {
		return p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

}