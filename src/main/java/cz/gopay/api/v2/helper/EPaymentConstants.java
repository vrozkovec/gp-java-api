package cz.gopay.api.v2.helper;

import java.util.HashMap;
import java.util.Map;

import cz.gopay.api.v2.EPaymentStatus;


/**
 * Konstanty pouzivane v komunikaci s GoPay
 */
public class EPaymentConstants {

	/** URL webove sluzby */
	public static final String GOPAY_WS_ENDPOINT = "https://gate.gopay.cz/axis/EPaymentServiceV2";
	
	/** URL testovaci webove sluzby */
	public static final String GOPAY_WS_ENDPOINT_TEST = "http://testgw.gopay.cz/axis/EPaymentServiceV2";

	/** URL testovaci platebni brany  -- uplna integrace*/
	public static final String GOPAY_FULL_TEST = "http://testgw.gopay.cz/gw/pay-full-v2";

	/** URL platebni brany  -- uplna integrace */
	public static final String GOPAY_FULL = "https://gate.gopay.cz/gw/pay-full-v2";

	/** URL vypisu plateb - testovaci brana*/
	public static final String GOPAY_ACCOUNT_STATEMENT = "https://testgw.gopay.cz/gw/services/get-account-statement";
	
		
	/**
	 * Popis stavu platby - messages
	 */
	public static final Map<String, String> RETURN_URL_MESSAGES;
	
	public static final Map<String, String> ADDITIONAL_MESSAGES;
	
	
	/**
	 * inicializace messages
	 */
	static {
		RETURN_URL_MESSAGES = new HashMap<String, String>();
		RETURN_URL_MESSAGES.put(EPaymentStatus.STATE_CREATED, "Na platební bráně GoPay nebyla vybrána platební metoda. Pro dokončení platby pokračujte výběrem platební metody.");
		RETURN_URL_MESSAGES.put(EPaymentStatus.STATE_PAYMENT_METHOD_CHOSEN, "Platba byla úspěšně založena.");
		RETURN_URL_MESSAGES.put(EPaymentStatus.STATE_CANCELED, "Platba byla zrušena.");
		RETURN_URL_MESSAGES.put(EPaymentStatus.STATE_TIMEOUTED, "Platba byla zrušena.");
		RETURN_URL_MESSAGES.put(EPaymentStatus.STATE_PAID, "Platba byla úspěšně provedena.");
		
		ADDITIONAL_MESSAGES = new HashMap<String, String>();
		ADDITIONAL_MESSAGES.put("101", "Čekáme na dokončení online platby. O jejím provedení Vás budeme neprodleně informovat.");
		ADDITIONAL_MESSAGES.put("102", "Instrukce pro dokončení platby Vám byly zaslány na emailovou adresu. O provedení platby Vás budeme budeme neprodleně informovat.");
		
	}
	
	public static String msgReturnUrl(String key) {
		return RETURN_URL_MESSAGES.get(key);
	}
	
	public static String addMessage(String key) {
		return ADDITIONAL_MESSAGES.get(key);
	}

}
