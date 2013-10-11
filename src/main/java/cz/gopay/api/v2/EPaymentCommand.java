package cz.gopay.api.v2;

import java.io.Serializable;


/**
 * 
 * Informacni element pouzivany pro zalozeni platby
 *  
 */
public class EPaymentCommand implements Serializable {
	private static final long serialVersionUID = -4724829621790974371L;
	
	public static final String REC_CYCLE_DAY="DAY";
	public static final String REC_CYCLE_WEEK="WEEK";
	public static final String REC_CYCLE_MONTH="MONTH";
	
	private Long targetGoId;
    private Long partnerGoId;

	private String productName;	
	private String orderNumber;
	private Long totalPrice;
	private String currency;
	
	private String successURL;
	private String failedURL;

	private String paymentChannels;
	private String defaultPaymentChannel;
	
    private Boolean preAuthorization;

    private Boolean recurrentPayment;
    
    private String recurrenceCycle;

    private String recurrenceDateTo;

    private Integer recurrencePeriod;


	private String encryptedSignature;
	
	private ECustomerData customerData;
		
    private String p1;
    private String p2;
    private String p3;
    private String p4;

    private String lang;
	
	/**
	 * Zakladni konstruktor
	 */
	public EPaymentCommand() {
		
	}

	/**
	 * Vraci GoID prijemce platby - identifikator ziskate pri integraci GoPay
	 * 
	 * @return GoID prijemce platby
	 */
	public Long getTargetGoId() {
		return targetGoId;
	}
	
	/**
	 * Nastavi GoID prijemce platby
	 * 
	 * @param targetGoId GoID prijemce
	 */
	public void setTargetGoId(Long targetGoId) {
		this.targetGoId = targetGoId;
	}
	
	/**
	 * Vraci podpis obsahu tohoto objektu.
	 * @see cz.gopay.api.v2.helper.GopayHelper#signEPaymentCommand(EPaymentCommand, String)
	 *   
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
	 * Vraci URL eshopu, na ktere bude zakaznik presmerovan pri zruseni platby 
	 * @return URL neplatne platby
	 */
	public String getFailedURL() {
		return failedURL;
	}
	
	/**
	 * Nastavi URL eshopu, na ktere bude zakaznik presmerovan pri zruseni platby
	 * @param failedURL URL neplatne platby
	 */
	public void setFailedURL(String failedURL) {
		this.failedURL = failedURL;
	}

	/**
	 * Vraci URL eshopu, na ktere bude zakaznik presmerovan po provedeni platby na brane 
	 * @return URL uspesne platby
	 */
	public String getSuccessURL() {
		return successURL;
	}
	
	/**
	 * Nastavi URL uspesne platby
	 * @param successURL URL uspesne platby
	 */
	public void setSuccessURL(String successURL) {
		this.successURL = successURL;
	}

	/**
	 * Vraci nazev produktu
	 * @return nazev produktu
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * Nastavi nazvu produktu
	 * @param productName nazev produktu
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Vraci cenu zbozi v centech/halerich
	 * 
	 * @return cena 
	 */
	public Long getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * Nastavi cenu zbozi
	 * @param totalPrice cena
	 */
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Vrati kod meny ISO 4217
	 * - CZK, EUR
	 * 
	 * @return kod meny
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Nastavi menu platby
	 * 
	 * @param currency - kod meny podle ISO 4217
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}


	/**
	 * Vraci seznam povolenych platebnich metod
	 * 
	 * @return seznam povolenych platebnich metod oddelenych carkou
	 */
	public String getPaymentChannels() {
		return paymentChannels;
	}

	/**
	 * Nastavi seznam povolenych platebnich metod
	 * - platbu lze uskutecnit pouze jednou z predanych platebnich metod
	 * - kody platebnich metod naleznete v integracnim manualu 
	 * 
	 * @param paymentChannel seznam povolenych platebnich metod oddelenych carkou
	 */
	public void setPaymentChannels(String paymentChannel) {
		this.paymentChannels = paymentChannel;
	}

	
	/**
	 * Vraci kod pred-vybrane platebni metody
	 * - kody platebnich metod naleznete v integracnim manualu
	 * 
	 * @return pred-vybrana platebni metoda
	 */
	public String getDefaultPaymentChannel() {
		return defaultPaymentChannel;
	}
	
	/**
	 * Nastavuje predvybranou platbeni metodu na platebni brane
	 * - kody platebnich metod naleznete v integracnim manualu
	 *  
	 * @param defaultPaymentChannel
	 */
	public void setDefaultPaymentChannel(String defaultPaymentChannel) {
		this.defaultPaymentChannel = defaultPaymentChannel;
	}

	/**
	 * Identifikator objednavky obchodnika 
	 * - cislo faktury, cislo objednavky
	 * 
	 * @return alfa-numericky kod objednavky
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Nastavi identifikator objednavky
	 * - interni identifikator obchodnika
	 * - cislo faktury, cislo objednavky  
	 * 
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Vrati typ platby - predautorizovana platba 
	 * 
	 * @return pred-autorizovana platba
	 */
	public Boolean getPreAuthorization() {
		return preAuthorization;
	}

	/**
	 * Nastavi typ platby
	 * true - predautorizovana platba
	 * false - okamzita platba
	 * 
	 * @param preAuthorization
	 */
	public void setPreAuthorization(Boolean preAuthorization) {
		this.preAuthorization = preAuthorization;
	}

	/**
	 * Vrati typ platby - opakovana platba
	 * - opakovani dle parametru {@link #getRecurrenceCycle()}, {@link #getRecurrencePeriod()}, {@link #getRecurrenceDateTo()}
	 * 
	 * @return opakovana platba
	 */
	public Boolean getRecurrentPayment() {
		return recurrentPayment;
	}

	/**
	 * Nastavi typ platby - opakovana platba
	 * - opakovani dle parametru {@link #getRecurrenceCycle()}, {@link #getRecurrencePeriod()}, {@link #getRecurrenceDateTo()}
	 * 
	 * @param recurrentPayment
	 */
	public void setRecurrentPayment(Boolean recurrentPayment) {
		this.recurrentPayment = recurrentPayment;
	}

	/**
	 * Vrati zakladni jednotku opakovani. Spolecne s {@link #getRecurrencePeriod()} periodou
	 * definuje opakovani platby.
	 * 
	 * {@link #REC_CYCLE_DAY}, {@value #REC_CYCLE_WEEK}, {@value #REC_CYCLE_MONTH}
	 * 
	 * @return typ opakovani
	 */
	public String getRecurrenceCycle() {
		return recurrenceCycle;
	}
	
	/**
	 * Nastavuje zakladni jednotku opakovani.
	 * 
	 * {@link #REC_CYCLE_DAY}, {@value #REC_CYCLE_WEEK}, {@value #REC_CYCLE_MONTH}
	 *  
	 * @param recurrenceCycle - jednotka opakovani
	 */
	public void setRecurrenceCycle(String recurrenceCycle) {
		this.recurrenceCycle = recurrenceCycle;
	}

	/**
	 * Vrati pocet zakladnich jednotek {@link #getRecurrenceCycle()} mezi jednotlivymi platbami 
	 * 
	 * @return pocet zakladnich jednotek mezi platbami
	 */
	public Integer getRecurrencePeriod() {
		return recurrencePeriod;
	}
	
	/**
	 * Nastavi pocet zakladnich jednotek {@link #getRecurrenceCycle()} mezi jednotlivymi platbami
	 * 
	 * @param recurrencePeriod
	 */
	public void setRecurrencePeriod(Integer recurrencePeriod) {
		this.recurrencePeriod = recurrencePeriod;
	}


	/**
	 * Vrati dobu, po kterou bude opakovana platba provadena.
	 * 
	 * @return opakovana platba do data
	 */
	public String getRecurrenceDateTo() {
		return recurrenceDateTo;
	}

	/**
	 * Nastavi dobu, po kterou bude opakovana platba provadena.
	 *  
	 * @param recurrenceDateTo
	 */	
	public void setRecurrenceDateTo(String recurrenceDateTo) {
		this.recurrenceDateTo = recurrenceDateTo;
	}


	/**
	 * Vrati zakaznicke informace
	 * 
	 * @return zakaznicke informace
	 */
	public ECustomerData getCustomerData() {
		return customerData;
	}
	
	/**
	 * Natavi zakaznike informace
	 * 
	 * @param customerData
	 */
	public void setCustomerData(ECustomerData customerData) {
		this.customerData = customerData;
	}
	
	/**
	 * Vrati GoID partnerskeho reseni
	 * - element musi byt sifrovan pomoci sifrovaciho klice prirazeneho partnerovi
	 * 
	 * @return GoID partnera
	 */
	public Long getPartnerGoId() {
		return partnerGoId;
	}

	/**
	 * Nastavi GoID partnerskeho reseni
	 * - element musi byt sifrovan pomoci sifrovaciho klice prirazeneho partnerovi
	 * 
	 */
	public void setPartnerGoId(Long partnerGoId) {
		this.partnerGoId = partnerGoId;
	}

	/**
	 * Vrati obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 * 
	 * @return obecny parametr
	 */
	public String getP1() {
		return p1;
	}
	
	/**
	 * Nastavi obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 * 
	 */
	public void setP1(String p1) {
		this.p1 = p1;
	}

	/**
	 * Vrati obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 * 
	 * @return obecny parametr
	 */
	public String getP2() {
		return p2;
	}
	
	/**
	 * Nastavi obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 * 
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}

	/**
	 * Vrati obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 * 
	 * @return obecny parametr
	 */
	public String getP3() {
		return p3;
	}
	
	/**
	 * Nastavi obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 *
	 */
	public void setP3(String p3) {
		this.p3 = p3;
	}

	/**
	 * Vrati obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 * 
	 * @return obecny parametr
	 */
	public String getP4() {
		return p4;
	}
	
	/**
	 * Nastavi obecny parametr
	 * - je pouzit pri presmerovani
	 * - je pouzit ve stavu platby
	 *
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}

	/**
	 * Vraci implicitni lokalizaci platebni brany
	 * - viz integracni manual 
	 * 
	 * @return jazyk
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Nastavuje implicitni lokalizaci platebni brany
	 * @param lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

}