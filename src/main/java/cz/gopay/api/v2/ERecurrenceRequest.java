/**
 * ERecurrenceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.gopay.api.v2;


public class ERecurrenceRequest {	
	private Long parentPaymentSessionId;
	private Long targetGoId;
	private String orderNumber;
	private Long totalPrice;
	private String encryptedSignature;
	
	public Long getParentPaymentSessionId() {
		return parentPaymentSessionId;
	}

	public void setParentPaymentSessionId(Long parentPaymentSessionId) {
		this.parentPaymentSessionId = parentPaymentSessionId;
	}

	public Long getTargetGoId() {
		return targetGoId;
	}

	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getEncryptedSignature() {
		return encryptedSignature;
	}

	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
