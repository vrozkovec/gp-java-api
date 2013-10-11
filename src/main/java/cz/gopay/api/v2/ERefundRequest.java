package cz.gopay.api.v2;


/**
 * Represents base electronic payment info
 *  
 * @author Zbynek Novak | Terms a.s | novak.zbynek@gmail.com
 * 
 */
public class ERefundRequest {	
	private Long paymentSessionId;
	private Long targetGoId;
	private Long amount;
	private String currency;
	private String description;
	private String encryptedSignature;
	
	public Long getPaymentSessionId() {
		return paymentSessionId;
	}

	public void setPaymentSessionId(Long paymentSessionId) {
		this.paymentSessionId = paymentSessionId;
	}

	public String getEncryptedSignature() {
		return encryptedSignature;
	}
	
	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}
		
	public Long getTargetGoId() {
		return targetGoId;
	}
	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
