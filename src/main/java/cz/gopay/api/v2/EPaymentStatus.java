/**
 * EPaymentStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.gopay.api.v2;


public class EPaymentStatus  implements java.io.Serializable {

	public static final String RESULT_CALL_COMPLETED = "CALL_COMPLETED";
	public static final String RESULT_CALL_FAILED = "CALL_FAILED";	
	
	public static final String STATE_CREATED = "CREATED";
	public static final String STATE_PAYMENT_METHOD_CHOSEN = "PAYMENT_METHOD_CHOSEN";
	public static final String STATE_AUTHORIZED = "AUTHORIZED";
	public static final String STATE_PAID = "PAID";
	public static final String STATE_CANCELED = "CANCELED";
	public static final String STATE_TIMEOUTED = "TIMEOUTED";
	public static final String STATE_REFUNDED = "REFUNDED";
	
    private Long paymentSessionId;
    private Long parentPaymentSessionId;

    private String sessionState;
    private String sessionSubState;
    private String sessionSubStateDesc;
    
    private String orderNumber;
    private String productName;
    private Long totalPrice;
    private String currency;
    
    private Long targetGoId;

    private String paymentChannel;
    
    private Boolean preAuthorization;
    private Boolean recurrentPayment;

    private String result;
    private String resultDescription;
    
    private String encryptedSignature;

    private String p1;
    private String p2;
    private String p3;
    private String p4;


    public EPaymentStatus() {}


	public Long getPaymentSessionId() {
		return paymentSessionId;
	}


	public void setPaymentSessionId(Long paymentSessionId) {
		this.paymentSessionId = paymentSessionId;
	}


	public Long getParentPaymentSessionId() {
		return parentPaymentSessionId;
	}


	public void setParentPaymentSessionId(Long parentPaymentSessionId) {
		this.parentPaymentSessionId = parentPaymentSessionId;
	}


	public String getSessionState() {
		return sessionState;
	}


	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}


	public String getSessionSubState() {
		return sessionSubState;
	}


	public void setSessionSubState(String sessionSubState) {
		this.sessionSubState = sessionSubState;
	}


	public String getSessionSubStateDesc() {
		return sessionSubStateDesc;
	}


	public void setSessionSubStateDesc(String sessionSubStateDesc) {
		this.sessionSubStateDesc = sessionSubStateDesc;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Long getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Long getTargetGoId() {
		return targetGoId;
	}


	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}


	public String getPaymentChannel() {
		return paymentChannel;
	}


	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}


	public Boolean getPreAuthorization() {
		return preAuthorization;
	}


	public void setPreAuthorization(Boolean preAuthorization) {
		this.preAuthorization = preAuthorization;
	}


	public Boolean getRecurrentPayment() {
		return recurrentPayment;
	}


	public void setRecurrentPayment(Boolean recurrencePayment) {
		this.recurrentPayment = recurrencePayment;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getResultDescription() {
		return resultDescription;
	}


	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}


	public String getEncryptedSignature() {
		return encryptedSignature;
	}


	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}


	public String getP1() {
		return p1;
	}


	public void setP1(String p1) {
		this.p1 = p1;
	}


	public String getP2() {
		return p2;
	}


	public void setP2(String p2) {
		this.p2 = p2;
	}


	public String getP3() {
		return p3;
	}


	public void setP3(String p3) {
		this.p3 = p3;
	}


	public String getP4() {
		return p4;
	}


	public void setP4(String p4) {
		this.p4 = p4;
	}


}
