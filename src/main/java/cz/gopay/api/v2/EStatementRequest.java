package cz.gopay.api.v2;

import cz.gopay.api.v2.helper.EPaymentConstants;

/**
 * Informační element pozadavku výpisu plateb účtu * 
 */
public class EStatementRequest {

	private String dateFrom;
	private String dateTo;

	private Long targetGoId;
	
	private String contentType;

	private String encryptedSignature;

	public EStatementRequest() {}

	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public Long getTargetGoId() {
		return targetGoId;
	}
	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}
	public String getEncryptedSignature() {
		return encryptedSignature;
	}
	public void setEncryptedSignature(String encryptedSignature) {
		this.encryptedSignature = encryptedSignature;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String createURL() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(EPaymentConstants.GOPAY_ACCOUNT_STATEMENT);		
		sb.append("?statementRequest.dateFrom=" + this.dateFrom);
		sb.append("&statementRequest.dateTo=" + this.dateTo);
		sb.append("&statementRequest.targetGoId=" + this.targetGoId);
		sb.append("&statementRequest.encryptedSignature=" + this.encryptedSignature);
		sb.append("&statementRequest.contentType=" + this.contentType);
				
		return sb.toString();

	}
}
