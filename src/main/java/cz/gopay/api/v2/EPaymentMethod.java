package cz.gopay.api.v2;


/**
 * Informační element popisuje platebni metodu a jeji vlastnosti * 
 */
public class EPaymentMethod {
	
	private String code;
	private String paymentMethod;
	private boolean isOffline;
	private String description;
	private String logo;
	private boolean supportRecurrent;
	private boolean supportPreauthorization;
	private String supportedCurrency;
	
	public EPaymentMethod() {}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public boolean isOffline() {
		return isOffline;
	}
	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}
	
	public boolean isSupportRecurrent() {
		return supportRecurrent;
	}
	public void setSupportRecurrent(boolean supportRecurrent) {
		this.supportRecurrent = supportRecurrent;
	}
	
	public boolean isSupportPreauthorization() {
		return supportPreauthorization;
	}
	public void setSupportPreauthorization(boolean supportPreauthorization) {
		this.supportPreauthorization = supportPreauthorization;
	}
	
	public String getSupportedCurrency() {
		return supportedCurrency;
	}
	public void setSupportedCurrency(String supportedCurrency) {
		this.supportedCurrency = supportedCurrency;
	}
	
}