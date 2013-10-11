package cz.gopay.api.v2.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import cz.gopay.api.v2.EBuyerCreate;
import cz.gopay.api.v2.EBuyerCreateResult;
import cz.gopay.api.v2.EPaymentCommand;
import cz.gopay.api.v2.EPaymentIdentity;
import cz.gopay.api.v2.EPaymentResult;
import cz.gopay.api.v2.EPaymentSessionInfo;
import cz.gopay.api.v2.EPaymentStatus;
import cz.gopay.api.v2.ERecurrenceRequest;
import cz.gopay.api.v2.ERefundRequest;
import cz.gopay.api.v2.EStatementRequest;
import cz.gopay.api.v2.helper.GopayException.Reason;

/**
 * Pomocna trida pro platbu v systemu GoPay
 * 
 * - sestavovani retezcu pro podpis komunikacnich elementu
 * - sifrovani/desifrovani retezcu
 * - verifikace podpisu informacnich retezcu
 * 
 */
public class GopayHelper {
	private static final String FORMAT_DATE = "yyyy-MM-dd";
	
	/**
	 * Sestaveni retezce pro podpis platebniho prikazu.
	 *
	 * @param key 					heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis 
	 */
  	public static String concatPaymentCommand(
  		Long goId,
  		String productName,
  		Long totalPriceInCents, 
  		String currency,
  		String orderNumber,
  		String failedURL,
  		String successURL,
  		Boolean preAuthorization,
  		Boolean recurrentPayment,
  		String recurrenceDateTo,
  		String recurrenceCycle,
  		Integer recurrencePeriod,
  		String paymentChannels,
  		String key) {

        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(goId));
        sb.append(concatAppendix(productName));
        sb.append(concatAppendix(totalPriceInCents));
        sb.append(concatAppendix(currency));
        sb.append(concatAppendix(orderNumber));
        sb.append(concatAppendix(failedURL));
        sb.append(concatAppendix(successURL));
        sb.append(concatAppendix(preAuthorization));
        sb.append(concatAppendix(recurrentPayment));
        sb.append(concatAppendix(recurrenceDateTo));
        sb.append(concatAppendix(recurrenceCycle));
        sb.append(concatAppendix(recurrencePeriod));
        sb.append(concatAppendix(paymentChannels));        
        sb.append(concatStr(key));
        
		return sb.toString();
  	}
  	
  	public static String concatPaymentCommand(EPaymentCommand paymentCommand, String key) {
  		return concatPaymentCommand(
  				paymentCommand.getTargetGoId(), 
  				paymentCommand.getProductName(), 
  				paymentCommand.getTotalPrice(),
  				paymentCommand.getCurrency(), 
  				paymentCommand.getOrderNumber(),
  				paymentCommand.getFailedURL(), 
  				paymentCommand.getSuccessURL(), 
  				paymentCommand.getPreAuthorization(), 
  				paymentCommand.getRecurrentPayment(), 
  				paymentCommand.getRecurrenceDateTo() != null ? paymentCommand.getRecurrenceDateTo() : "", 
  				paymentCommand.getRecurrenceCycle(), 
  				paymentCommand.getRecurrencePeriod(), 
  				paymentCommand.getPaymentChannels(),
  				key);
  	}
  	
  	
	/**
	 * Sestaveni retezce pro podpis pozadavku opakovane platby.
	 *
	 * @param key 					heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis 
	 */
  	public static String concatRecurrenceRequest(
  		Long parentPaymentSessionId,
  		Long targetGoId,
  		String orderNumber,
  		Long totalAmount,
  		String key) {

        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(parentPaymentSessionId));
        sb.append(concatAppendix(targetGoId));
        sb.append(concatAppendix(orderNumber));
        sb.append(concatAppendix(totalAmount));
        sb.append(concatStr(key));
        
		return sb.toString();
  	}

  	/**
  	 * Sestaveni retezce pro podpis pozadavku opakovane platby.
  	 * 
  	 * @param recurrenceRequest
  	 * @param key
  	 * @return retezec pro podpis
  	 */
  	public static String concatRecurrenceRequest(ERecurrenceRequest recurrenceRequest, String key) {
  		return concatRecurrenceRequest(
  				recurrenceRequest.getParentPaymentSessionId(), 
  				recurrenceRequest.getTargetGoId(), 
  				recurrenceRequest.getOrderNumber(),
  				recurrenceRequest.getTotalPrice(),
  				key);
  	}
  	

  	
  	/**
  	 * Sestaveni retezce pro podpis vysledku stav platby.
  	 *
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
  	public static String concatPaymentStatus(
  		Long goId,
  		String productName, 
  		Long totalPriceInCents, 
  		String currency,
  		String orderNumber,
  		Boolean recurrencePayment,
  		Long parentPaymentSessionId,
  		Boolean preAuthorization,
  		String result,
  		String sessionState,
  		String sessionSubState,
  		String paymentChannel,
  		String key){
        
        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(goId));
        sb.append(concatAppendix(productName));
        sb.append(concatAppendix(totalPriceInCents));
        sb.append(concatAppendix(currency));
        sb.append(concatAppendix(orderNumber));
        sb.append(concatAppendix(recurrencePayment));
        sb.append(concatAppendix(parentPaymentSessionId));
        sb.append(concatAppendix(preAuthorization));
        sb.append(concatAppendix(result));
        sb.append(concatAppendix(sessionState));
        sb.append(concatAppendix(sessionSubState));
        sb.append(concatAppendix(paymentChannel));
        sb.append(concatStr(key));
  		
        return sb.toString(); 
  	}
  	
	/**
	 * Sestaveni retezce pro podpis vysledku stav platby.
	 * 
	 * @param paymentStatus 	vysledek overeni stavu platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatPaymentStatus(EPaymentStatus paymentStatus, 
		String key) {
		
		return concatPaymentStatus(
			paymentStatus.getTargetGoId(),
			paymentStatus.getProductName(),
			paymentStatus.getTotalPrice(),
			paymentStatus.getCurrency(),
			paymentStatus.getOrderNumber(),
			paymentStatus.getRecurrentPayment(),
			paymentStatus.getParentPaymentSessionId(),
			paymentStatus.getPreAuthorization(),
			paymentStatus.getResult(),
			paymentStatus.getSessionState(),
			paymentStatus.getSessionSubState(),
			paymentStatus.getPaymentChannel(),
			key);
	}

  	/**
  	 * Sestaveni retezce pro podpis sessionInfo.
  	 *
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
  	public static String concatPaymentSession(
  		Long goId,
  	 	Long paymentSessionId,  	 	 
  	 	String key) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(goId));
        sb.append(concatAppendix(paymentSessionId));
        sb.append(concatStr(key));
  		
        return sb.toString(); 
  	}
  	
	/**
	 * Sestaveni retezce pro podpis sessionInfo.
	 * 
	 * @param paymentSession 	objekt obsahujici data pro dotazani se na stav platby 
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatPaymentSession(EPaymentSessionInfo paymentSession, 
		String key) {
		
		return concatPaymentSession(
			paymentSession.getTargetGoId(),
			paymentSession.getPaymentSessionId(),
			key);
	}

	/**
  	 * Sestaveni retezce pro podpis refundRequest.
  	 *
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
  	public static String concatRefundRequest(
  		Long goId,
  	 	Long paymentSessionId,
  	 	Long amount,
  	 	String currency,
  	 	String desc,
  	 	String key) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(goId));
        sb.append(concatAppendix(paymentSessionId));
        sb.append(concatAppendix(amount));
        sb.append(concatAppendix(currency));
        sb.append(concatAppendix(desc));
        sb.append(concatStr(key));
  		
        return sb.toString(); 
  	}
  	
	/**
	 * Sestaveni retezce pro podpis refundRequest.
	 * 
	 * @param request 	objekt obsahujici data pro castecnou refundaci
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatRefundRequest(ERefundRequest request, 
		String key) {
		
		return concatRefundRequest(
			request.getTargetGoId(),
			request.getPaymentSessionId(),
			request.getAmount(),
			request.getCurrency(),
			request.getDescription(),
			key);
	}

  	/**
  	 * Sestaveni retezce pro podpis popisu platby (paymentIdentity).
  	 *
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
  	public static String concatPaymentIdentity(
  		Long goId,
  	 	Long paymentSessionId,
  	 	Long parentPaymentSessionId,
  	 	String orderNumber, 
  	 	String key){

        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(goId));
        sb.append(concatAppendix(paymentSessionId));
        sb.append(concatAppendix(parentPaymentSessionId));
        sb.append(concatAppendix(orderNumber));
        sb.append(concatStr(key));
        
        return sb.toString();
  	}

  	/**
  	 * Sestaveni retezce pro podpis popisu platby (paymentIdentity).
  	 * 
  	 * @param paymentIdentity 	popis platby 
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
	public static String concatPaymentIdentity(
		EPaymentIdentity paymentIdentity, 
		String key) {
		
		return concatPaymentIdentity(
			paymentIdentity.getTargetGoId(),				
			paymentIdentity.getPaymentSessionId(),
			paymentIdentity.getParentPaymentSessionId(),
			paymentIdentity.getOrderNumber(),
			key);
	}
	
  	/**
  	 * Sestaveni retezce pro podpis.
  	 *
  	 * @param key heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
  	public static String concatPaymentResult(
  	 	Long paymentSessionId,
  	 	String result, 
  	 	String key){

        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(paymentSessionId));
        sb.append(concatAppendix(result));
        sb.append(concatStr(key));
        
        return sb.toString();
  	}

  	/**
  	 * Sestaveni retezce pro podpis.
  	 *
  	 * @param key heslo subjektu pro komunikaci s GoPay
  	 * @return retezec pro podpis
  	 */
  	public static String concatPaymentResult(
  			EPaymentResult ePaymentResult,
  	  	 	String key){  		
  	        
  		return concatPaymentResult(ePaymentResult.getPaymentSessionId(),
  	       		ePaymentResult.getResult(),
  	       		key);
  	  }

	
	/**
	 * Sestaveni retezce pro podpis prikazu pro vytvoreni uzivatele.
	 * 
	 * @param eshopGoId		Identifikace partnerskeho obchodnika
	 * @param buyerUsername uzivatelske jmeno, ktere ma byt pro uzivatele pouzito  
	 * 						v systemu GoPay. Pokud je null, pak bude mit
	 * 						uzivatel pri aktivaci sve uzivatelske jmeno vybrat.
	 * @param buyerEmail	email uzivatele
	 * @param key			heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatBuyerCreate(
	  		Long eshopGoId,
	  		String buyerUsername,
	  		String buyerEmail,
	  		String key) {
		
		StringBuilder sb = new StringBuilder();	        
        sb.append(concatAppendix(eshopGoId));
        sb.append(concatAppendix(buyerUsername));
        sb.append(concatAppendix(buyerEmail));
        sb.append(concatStr(key));
	        
		return sb.toString();
	}

	/**
	 * Sestaveni retezce pro podpis prikazu pro vytvoreni uzivatele.
	 * 
	 * @param buyerCreate	prikaz pro vytvoreni uzivatele
	 * @param key 			heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatBuyerCreate(
			EBuyerCreate buyerCreate,
			String key){
		
		return concatBuyerCreate(
			buyerCreate.getEshopGoId(),
			buyerCreate.getBuyerUsername(),
			buyerCreate.getBuyerEmail(),
			key);
	}

	/**
	 * Sestaveni retezce pro podpis vysledku vytvoreni uzivatele.
	 * 
	 * @param eshopGoId			identifikace partnerskeho obchodnika
	 * @param buyerUsername		uzivatelske jmeno vytvoreneho uzivatele
	 * @param buyerGoId			identifikace vytvoreneho uzivatele
	 * @param result			vysledek volani
	 * @param resultDescription	popis vysledku volani
	 * @param key				heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatBuyerCreateResult(
	  		Long eshopGoId,
	  		String buyerUsername,
	  		Long buyerGoId,
	  		String result,
	  		String resultDescription,
	  		String key) {
		
		StringBuilder sb = new StringBuilder();	        
        sb.append(concatAppendix(eshopGoId));
        sb.append(concatAppendix(buyerUsername));
        sb.append(concatAppendix(buyerGoId));
        sb.append(concatAppendix(result));
        sb.append(concatAppendix(resultDescription));
        sb.append(concatStr(key));
	        
		return sb.toString();
	}
	
	/**
	 * Sestaveni retezce pro podpis vysledku vytvoreni uzivatele.
	 * 
	 * @param createResult	vysledek vytvoreni uzivatele
	 * @param key			heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatBuyerCreateResult(
			EBuyerCreateResult createResult,
			String key){
		
		return concatBuyerCreateResult(
			createResult.getEshopGoId(),
			createResult.getBuyerUsername(),
			createResult.getBuyerGoId(),
			createResult.getResult(),
			createResult.getResultDescription(),
			key);
	}
  	
	/**
	 * Sestaveni retezce pro podpis pozadavku na vypis plateb uctu
	 * 
	 * @param statementRequest 	pozadavek na vypis plateb uctu
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return retezec pro podpis
	 */
	public static String concatStatementRequest(EStatementRequest statementRequest, String key) {
		
        StringBuilder sb = new StringBuilder();
        sb.append(concatAppendix(statementRequest.getDateFrom()));
        sb.append(concatAppendix(statementRequest.getDateTo()));
        sb.append(concatAppendix(statementRequest.getTargetGoId()));
        sb.append(concatStr(key));
  		
        return sb.toString(); 
	}

  		
  	/**
  	 * Sifrovani dat 3DES.
  	 *
  	 * @param data
  	 * @param key
  	 * @return sifrovany obsah v HEX forme
  	 * @throws IllegalStateException kdyz je klic kratsi nez 24 znaku
  	 * @throws CryptoException kdyz dojde k chybe pri sifrovani
  	 */
  	public static String encrypt(String data, String key) throws CryptoException, IllegalStateException {
  		return CryptoHelper.encrypt(data, key);
  	}

  	/**
  	 * Desifrovani dat
  	 *
  	 * @param data
  	 * @param key
  	 * @return desifrovany retezec
  	 * @throws IllegalStateException kdyz je klic kratsi nez 24 znaku
  	 * @throws CryptoException kdyz dojde k chybe pri sifrovani
  	 */
  	public static String decrypt(String data, String key) throws CryptoException, IllegalStateException {
  		return CryptoHelper.decrypt(data, key);
  	}  	

	/**
	 * Vytvori hash ze zpravy.
	 * 
	 * @param data zprava
	 * @return SHA hash zpravy, HEX reprezentace
	 * @throws CryptoException pokud neni dostupny algoritmus pro vytvoreni hash
	 * @throws NullPointerException pokud je message null 
	 */
  	public static String hash(String data) throws CryptoException {
  		return CryptoHelper.hash(data);
  	}

  	/**
  	 * Vytvoreni hash platebniho prikazu.
  	 * 
  	 * @param paymentCommand 	platebni prikaz
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return hash platebniho prikazu
  	 * @throws CryptoException 	pokud neni dostupny algoritmus pro vytvoreni hash
  	 */
	public static String createEPaymentCommandHash(
		EPaymentCommand paymentCommand, 
		String key) throws CryptoException {

		return hash(
			concatPaymentCommand(
				paymentCommand, key));
	}
	
  	/**
  	 * Vytvoreni hash pozadavku opakovani platby
  	 * 
  	 * @param recurrenceRequest poyadavek
  	 * @param key 				heslo subjektu pro komunikaci s GoPay
  	 * @return hash poyadavku
  	 * @throws CryptoException 	pokud neni dostupny algoritmus pro vytvoreni hash
  	 */
	public static String createERecurrenceRequestHash(
		ERecurrenceRequest recurrenceRequest,
		String key) throws CryptoException {

		return hash(
			concatRecurrenceRequest(recurrenceRequest, key));
	}


	/**
	 * Vytvoreni hash popisu platby.
	 * 
	 * @param paymentSession 	popis platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return hash popisu platby
  	 * @throws CryptoException	pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createEPaymentSessionHash(
		EPaymentSessionInfo paymentSession, 
		String key) throws CryptoException {

		return hash(
			concatPaymentSession(
				paymentSession, key));
	}


	/**
	 * Vytvoreni hash stavu platby.
	 * 
	 * @param paymentStatus 	stav platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return hash stavu platby
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createEPaymentStatusHash(
		EPaymentStatus paymentStatus, 
		String key) throws CryptoException {

		return hash(
			concatPaymentStatus(
				paymentStatus, key));
	}

	/**
	 * Vytvoreni hash navratove hodnoty z platby.
	 * 
	 * @param paymentIdentity 	navratove hodnoty z platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return hash navratove hodnoty z platby
	 * @throws CryptoException	pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createEPaymentIdentityHash(
		EPaymentIdentity paymentIdentity, 
		String key) throws CryptoException {

		return hash(
			concatPaymentIdentity(
				paymentIdentity, key));
	}
	
	/**
	 * Vytvoreni hash prikazu pro vytvoreni uzivatele.
	 * @param buyerCreate	prikaz pro vytvoreni uzivatele
	 * @param key			heslo subjektu pro komunikaci s GoPay
	 * @return hash prikazu pro vytvoreni uzivatele
	 * @throws CryptoException pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createEBuyerCreateHash(
			EBuyerCreate buyerCreate, 
			String key) throws CryptoException {

		return hash(
			concatBuyerCreate(
				buyerCreate, key));	
	}
	
	/**
	 * Vytvoreni hash navratove po vytvoreni uzivatele.
	 * @param buyerCreateResult	vysledek vytvoreni uzivatele
	 * @param key				heslo subjektu pro komunikaci s GoPay
	 * @return hash navratove po vytvoreni uzivatele
	 * @throws CryptoException pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createEBuyerCreateResultHash(
			EBuyerCreateResult buyerCreateResult, 
			String key) throws CryptoException {
		
		return hash(
			concatBuyerCreateResult(
				buyerCreateResult, key));
	}

	/**
	 * Vytvoreni hash pro podpis pozadavku na vypis plateb uctu
	 * @param statementRequest 	pozadavek na vypis plateb uctu
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return hash pro podpis pozadavku na vypis plateb uctu
	 * @throws CryptoException pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createEStatementRequestHash(
			EStatementRequest statementRequest, 
			String key) throws CryptoException {
		
		return hash(
				concatStatementRequest(statementRequest, key));
	}
	
	/**
	 * Vytvoreni hash pro podpis pozadavku na castecnou refundaci
	 * @param request 			pozadavek na castecnou refundaci
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @return hash pro podpis pozadavku na vypis plateb uctu
	 * @throws CryptoException pokud neni dostupny algoritmus pro vytvoreni hash
	 */
	public static String createERefundRequestHash(
			ERefundRequest request, 
			String key) throws CryptoException {
		
		return hash(
				concatRefundRequest(request, key));
	}

	/**
	 * Podepsani platebniho prikazu. Nastavuje vlastnost encryptedSignature objektu EPaymentCommand. 
	 * @param paymentCommand 	platebni prikaz
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signEPaymentCommand(
		EPaymentCommand paymentCommand, 
		String key) throws CryptoException {

		paymentCommand.setEncryptedSignature(
			encrypt(
				createEPaymentCommandHash(paymentCommand, key), 
				key));
	}
	
	/**
	 * Podepsani pozadavku o opakovani platby. Nastavuje vlastnost encryptedSignature objektu EPaymentCommand. 
	 * @param recurrenceRequest pozadavek opakovani platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signERecurrenceRequest(
		ERecurrenceRequest recurrenceRequest, 
		String key) throws CryptoException {
		
		recurrenceRequest.setEncryptedSignature(
			encrypt(
				createERecurrenceRequestHash(recurrenceRequest, key), 
				key));
	}


	/**
	 * Podepsani dotazu na stav platby. Nastavuje vlastnost encryptedSignature 
	 * objektu EPaymentSessionInfo.
	 * @param paymentSession 	objekt obsahujici data pro dotazani se na stav platby 
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signEPaymentSession(
		EPaymentSessionInfo paymentSession, 
		String key) throws CryptoException {

		paymentSession.setEncryptedSignature(
			encrypt(
				createEPaymentSessionHash(paymentSession, key), 
				key));
	}

	/**
	 * Podepsani stavu platby. Nastavuje vlastnost encryptedSignature objektu EPaymentStatus.
	 * @param paymentStatus 	stav platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signEPaymentStatus(
		EPaymentStatus paymentStatus, 
		String key) throws CryptoException {

		paymentStatus.setEncryptedSignature(
			encrypt(createEPaymentStatusHash(
				paymentStatus, key),
				key));
	}

	/**
	 * Podepsani navratove hodnoty z platby. Nastavuje vlastnost encryptedSignature objektu EPaymentIdentity.
	 * @param paymentIdentity 	navrata hodnoty z platby
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signEPaymentIdentity(
		EPaymentIdentity paymentIdentity, 
		String key) throws CryptoException {

		paymentIdentity.setEncryptedSignature(
			encrypt(createEPaymentIdentityHash(
				paymentIdentity, key),
				key));
	}

	/**
	 * Podepsani prikazu pro vytvoreni uzivatele. Nastavuje vlastnost encryptedSignature 
	 * objektu EBuyerCreate. 
	 * 
	 * @param buyerCreate	prikaz pro vytvoreni uzivatele
	 * @param key			heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException pokud neni dostupny algoritmus pro sifrovani
	 */
	public static void signEBuyerCreate(
		EBuyerCreate buyerCreate, 
		String key) throws CryptoException {

		buyerCreate.setEncryptedSignature(
			encrypt(createEBuyerCreateHash(buyerCreate, key),
				key));
	}

	/**
	 * Podepsani navratove hodnoty z vytvoreni uzivatele. Nastavuje vlastnost 
	 * encryptedSignature objektu EBuyerCreateResult.
	 * 
	 * @param buyerCreateResult	navratova hodnota po vytvoreni uzivatele
	 * @param key				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException pokud neni dostupny algoritmus pro sifrovani
	 */
	public static void signEBuyerCreateResult(
		EBuyerCreateResult buyerCreateResult, 
		String key) throws CryptoException {

		buyerCreateResult.setEncryptedSignature(
			encrypt(createEBuyerCreateResultHash(buyerCreateResult, key),
				key));
	}

	/**
	 * Podepsani pozadavku na vypis plateb uctu
	 * @param statementRequest 	pozadavek na vypis plateb uctu
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signEStatementRequest(
			EStatementRequest statementRequest, 
			String key) throws CryptoException {

		statementRequest.setEncryptedSignature(
			encrypt(
				createEStatementRequestHash(statementRequest, key), 
				key));
	}
	
	/**
	 * Podepsani pozadavku na castecnou refundaci
	 * @param request 			pozadavek na castecnou refundaci
	 * @param key 				heslo subjektu pro komunikaci s GoPay
	 * @throws CryptoException 	pokud neni dostupny algoritmus pro sifrovani 
	 */
	public static void signERefundRequest(
			ERefundRequest request, 
			String key) throws CryptoException {

		request.setEncryptedSignature(
			encrypt(
				createERefundRequestHash(request, key), 
				key));
	}
	
  	
  	/**
	 * Kontrola stavu platby proti internim udajum objednavky - verifikace podpisu.
	 *
	 * @param paymentStatus 	vysledek volani paymentStatus
	 * @param goId 				pri platbe u obchodnika eshopGoId (identifikace obchodnika), 
	 * 							pri platbe pres tlacitko buyerGoId (identifikace uzivatele).
	 * @param orderNumber 	variabilni symbol - identifikace akt. objednavky
	 * @param priceInCents 		cena objednavky v halerich
	 * @param productName 		nazev zbozi
	 * @param key				heslo subjektu pro komunikaci s GoPay 
	 * 
	 * @throws GopayException  	pokud nesouhlasi udaje nebo pri chybe podepisovani 
	 * @return true kdyz je vse OK
	 */
	
	public static boolean checkPaymentStatus(
		EPaymentStatus paymentStatus,
		Long goId,
		String orderNumber,  	 			
		Long priceInCents,
		String currency,
		String productName,
		String key) throws GopayException {
		
    	if (! EPaymentStatus.RESULT_CALL_COMPLETED.equals(paymentStatus.getResult())) {
            throw new GopayException(Reason.INVALID_CALL_STATE_STATE, "PS invalid call state state [" + paymentStatus.getResultDescription() + "]");
        }

        if (! strEquals(orderNumber, paymentStatus.getOrderNumber())) {
            throw new GopayException(Reason.INVALID_VS, "PS invalid Order number orig[" + orderNumber + "] current[" + paymentStatus.getOrderNumber() + "]");
        }

        if (! strEquals(productName, paymentStatus.getProductName())) {
            throw new GopayException(Reason.INVALID_PN, "PS invalid product name orig[" + productName + "] current[" + paymentStatus.getProductName() + "]");
        }

        if (! numEquals(goId, paymentStatus.getTargetGoId())) {
            throw new GopayException(Reason.INVALID_GOID, "PS invalid GoID orig[" + goId + "] current[" + paymentStatus.getTargetGoId() + "]");
        }

        if (! numEquals(priceInCents, paymentStatus.getTotalPrice())) {
            throw new GopayException(Reason.INVALID_PRICE, "PS invalid price orig[" + priceInCents + "] current[" + paymentStatus.getTotalPrice() + "]");
        }
        
        if (currency != null
        		&& ! strEquals(currency, paymentStatus.getCurrency())) {
        	throw new GopayException(Reason.INVALID_PRICE, "PS invalid currency orig[" + currency + "] current[" + paymentStatus.getCurrency() + "]");
        }
        

		String hashedSignature = createEPaymentStatusHash(paymentStatus, key);

		String decryptedHash = decrypt(paymentStatus.getEncryptedSignature(), key);

		if( ! strEquals(hashedSignature, decryptedHash)) {
			throw new GopayException(Reason.INVALID_STATUS_SIGNATURE, "PS invalid status signature");
		}

		return true;
	}
    
  	/**
	 * Kontrola parametru predavanych ve zpetnem volani po potvrzeni/zruseni platby - verifikace podpisu.
	 *
	 * @param returnedGoId					goId vracene v redirectu
	 * @param returnedPaymentSessionId		paymentSessionId vracene v redirectu
	 * @param returnedOrderNumber			orderNumber vracene v redirectu
	 * @param returnedEncryptedSignature	encryptedSignature vracene v redirectu
	 *  
	 * @param targetGoId					identifikace prijemce
	 * @param orderNumber				oznaceni objednavky
	 * 
	 * @param key							heslo subjektu pro komunikaci s GoPay
	 * 
	 * @throws GopayException				pokud nesouhlasi udaje nebo pri chybe podepisovani 
	 * @return true kdyz je vse OK
	 */
  	public static boolean checkPaymentIdentity(
		Long returnedGoId,
		Long returnedPaymentSessionId,  				
		Long returnedParentPaymentSessionId,  				
		String returnedOrderNumber,
		String returnedEncryptedSignature,
		Long targetGoId,
		String orderNumber,  	 			
		String key) throws GopayException {
  		
  		Long goId = null;
		EPaymentIdentity identity = new EPaymentIdentity();
		identity.setTargetGoId(targetGoId);	
		identity.setEncryptedSignature(returnedEncryptedSignature);
		identity.setPaymentSessionId(returnedPaymentSessionId);
		identity.setParentPaymentSessionId(returnedParentPaymentSessionId);
		identity.setOrderNumber(returnedOrderNumber);

		return checkPaymentIdentity(identity, goId, orderNumber, key);
	}

  	
	/**
	 * Kontrola parametru predavanych ve zpetnem volani po potvrzeni/zruseni platby - verifikace podpisu.
  	 * 
  	 * @param paymentIdentity		vracena navratova hodnota z platby 
  	 * @param goId					identifikace eshopu nebo uzivatele
  	 * @param orderNumber			orderNumber vracene v redirectu
	 * @param key 					heslo subjektu pro komunikaci s GoPay
	 * 
	 * @throws GopayException 		pokud nesouhlasi udaje nebo pri chybe podepisovani 
	 * @return true kdyz je vse OK
  	 */
  	public static boolean checkPaymentIdentity(
		EPaymentIdentity paymentIdentity,
		Long goId,
		String orderNumber,  	 			
		String key) throws GopayException {
		
  		if (! strEquals(paymentIdentity.getOrderNumber(), orderNumber)) {
			throw new GopayException(Reason.INVALID_VS, "PI invalid order number");
		}

		if (! numEquals(paymentIdentity.getTargetGoId(), goId)) {
			throw new GopayException(Reason.INVALID_GOID, "PI invalid GoID");
		}

		String hashedSignature = createEPaymentIdentityHash(paymentIdentity, key);
		
		String decryptedHash = decrypt(paymentIdentity.getEncryptedSignature(), key);

		if(! strEquals(hashedSignature, decryptedHash)) {
			throw new GopayException(Reason.INVALID_SIGNATURE,  "PI invalid signature");
		}

		return true;
	}
  	
	/**
	 * Kontrola parametru predavanych ve zpetnem volani po vytvoreni uzivatele - verifikace podpisu.
  	 * 
  	 * @param buyerCreateResult		vracena navratova hodnota z vytvoreni uzivatele
  	 * @param eshopGoId				identifikace partnerskeho obchodnika 
  	 * @param username				uzivatelske jmeno vytvareneho uzivatele. Pokud je hodnota
  	 * 								null, pak se bude vyzadovat null hodnota i 
  	 * 								buyerCreateResult.buyerUsername
	 * @param key 					heslo subjektu pro komunikaci s GoPay
	 * 
	 * @throws GopayException 		pokud nesouhlasi udaje nebo pri chybe podepisovani 
	 * @return true kdyz je vse OK
  	 */
  	public static boolean checkBuyerCreateResult(
		EBuyerCreateResult buyerCreateResult,
		Long eshopGoId,
		String username,
		String key) throws GopayException {
		
  		if (! numEquals(buyerCreateResult.getEshopGoId(), eshopGoId)) {
  			throw new GopayException(Reason.INVALID_GOID, "BCR invalid EID");
		}

  		if (! isEmpty(username) && ! strEquals(buyerCreateResult.getBuyerUsername(), username)) {
  			throw new GopayException(Reason.INVALID_USERNAME, "BCR invalid Username");
		}

  		if (! strEquals(buyerCreateResult.getResult(), EBuyerCreateResult.CALL_COMPLETED)) {
  			throw new GopayException(Reason.INVALID_CALL_RESULT, "BCR invalid result");
		}

  		if (! strEquals(buyerCreateResult.getResultDescription(), EBuyerCreateResult.DESC_BUYER_CREATED)) {
  			throw new GopayException(Reason.INVALID_DESCRIPTION, "BCR invalid description");
		}

		String hashedSignature = createEBuyerCreateResultHash(buyerCreateResult, key);
		
		String decryptedHash = decrypt(buyerCreateResult.getEncryptedSignature(), key);

		if(! strEquals(hashedSignature, decryptedHash)) {
			throw new GopayException(Reason.INVALID_SIGNATURE,  "BCR invalid signature");
		}

		return true;
	}
  	
  	
  	public static boolean checkPaymentResult(
  			EPaymentResult paymentResult,
  			Long paymentSessionId,  	 			
  			String key) throws GopayException {
  			
  			if (! numEquals(paymentResult.getPaymentSessionId(), paymentSessionId)) {
  				throw new GopayException(Reason.INVALID_PSID, "EPaymentResult invalid PSID");
  			}

  			String hashedSignature = CryptoHelper.hash(GopayHelper.concatPaymentResult(paymentResult, key));  			
  			String decryptedHash = decrypt(paymentResult.getEncryptedSignature(), key);

  			if(! strEquals(hashedSignature, decryptedHash)) {
  				throw new GopayException(Reason.INVALID_SIGNATURE,  "EPaymentResult invalid signature");
  			}

  			return true;
  		}

  	
	/**
	 * Vrati carkou oddeleny seznam platebnich metod
	 * @param paymentChannels jednotlive plateni metody 
	 */
	public static String concatPaymentChannels(String ... paymentChannels) {
		String result = null;
		if (paymentChannels == null || paymentChannels.length < 1) {
			return result;
		}
		StringBuilder b = new StringBuilder(); 
		String delimiter = "";
		for (String paymentMethod : paymentChannels) {
			b.append(delimiter);
			b.append(paymentMethod);
			delimiter = ", ";
		}
		result = b.toString();
		return result;
	}
  	
  	/**
  	 * Vrati predavany retezec zakonceny znakem '|'
  	 * @param string retezec, ktery se ma zakoncit znakem  '|'
  	 * @return rozsireny retezec
  	 */
  	public static String concatAppendix(String string) {
  		return (isEmpty(string) ? "" : string) + "|";
  	}

  	/**
  	 * 
  	 * @param string
  	 * @return concated string
  	 */
  	public static String concatStr(String string) {
  		return isEmpty(string) ? "" : string;
  	}

  	/**
  	 * Vrati cislo jako retezec zakoncene znakem '|'
  	 * @param number cislo, ktere se ma zakoncit znakem  '|'
  	 * @return rozsireny retezec
  	 */
  	public static String concatAppendix(Number number) {
  		return (isEmpty(number) ? "" : number) + "|";
  	}

  	/**
  	 * Serializuje boolean
  	 * 
  	 * @param bool
  	 * @return concated boolean
  	 */
  	public static String concatAppendix(Boolean bool) {
  		return (isEmpty(bool) ? "" : Boolean.TRUE.equals(bool) ? "1" : "0" ) + "|";
  	}
  	
  	/**
  	 * Serializuje datum
  	 * @param date
  	 * @return concated date
  	 */
  	public static String concatAppendix(Date date) {
  		return (isEmpty(date) ? "" : new SimpleDateFormat(FORMAT_DATE).format(date) ) + "|";
  	}

  	/**
  	 * Rozhoduje, zda je retezec prazdny
  	 * @param string retezec
  	 * @return true je-li retezec prazdny (po odstraneni bilych znaku na zacatku i na konci) nebo null, jinak false
  	 */
  	public static boolean isEmpty(String string) {
  		return (string == null || "".equals(string.trim()));
  	}
  	
  	/**
  	 * Rozhoduje, zda je objekt null
  	 */
  	public static boolean isEmpty(Object number) {
  		return (number == null);
  	}

  	/**
  	 * Rozhoduje, zda jsou dva retezce shodne
  	 * @param str1 prvni retezec
  	 * @param str2 druhy retezec
  	 * @return vraci true pokud jsou oba retezce nenullove a shodne, jinak false
  	 */
  	protected static boolean strEquals(String str1, String str2) {
  		if (str1 != null) return str1.equals(str2);
  		if (str2 != null) return str2.equals(str1);
  		return false;
  	}

 	/**
  	 * Rozhoduje, zda jsou dve cisla shodna
  	 * @param num1 prvni cislo
  	 * @param num2 druhe cislo
  	 * @return vraci true pokud jsou obe cisla nenullova, stejneho typu a shodna, jinak false
  	 */
   	protected static boolean numEquals(Number num1, Number num2) {
  		if (num1 != null) return num1.equals(num2);
  		if (num2 != null) return num2.equals(num1);
  		return false;
  	}
  	
}
