package cz.gopay.example;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import cz.gopay.api.v2.EStatementRequest;
import cz.gopay.api.v2.helper.GopayHelper;

/**
 * Demonstruje uziti API pro stazeni vypisu pohybu na uctu 
 *
 * @author Michal Rottner
 * 
 */
public class GetAccountStatement {
	
	public static final Long ESHOP_GOID = 8540279704l; // zadejte vase testovaci EshopGoID
	public static final String SECURE_KEY = "ocxgXEL5psb7PAllKuCSblc9"; // zadejte vas testovaci secret
	public static final String dateFrom = "2013-01-01";
	public static final String dateTo = "2013-05-28";
	
	public static final String ENCODING = "CP1250";
	public static final String CONTENT_TYPE = "TYPE_CSV"; // podporovane formaty - TYPE_ABO, TYPE_CSV, TYPE_XLS 

	/**
	 * Vytvoreni testovaci pozadavku na vypis pohybu na uctu
	 * 
	 * @return statementRequest - pozadavek na vypis pohybu na uctu
	 */
	private EStatementRequest createEStatementRequest() {
		EStatementRequest statementRequest = new EStatementRequest();
		statementRequest.setDateFrom(dateFrom);
		statementRequest.setDateTo(dateTo);
		statementRequest.setTargetGoId(ESHOP_GOID);
		statementRequest.setContentType(CONTENT_TYPE);
		
		GopayHelper.signEStatementRequest(statementRequest, SECURE_KEY);

		return statementRequest;
	}
	
	/**
	 * Stazeni vypisu pohybu na uctu
	 * 
	 * @return CSV formatovana data s vypisem pohybu na uctu
	 */
	private String getAccountStatement(EStatementRequest statementRequest) {
		String data = null; 
		
		String url = statementRequest.createURL();

		try {
			GetMethod method = new GetMethod(url);
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, ENCODING);
	
			int code = client.executeMethod(method);
	
			if (code != HttpStatus.SC_OK) {
				data = "Server is not responding";

			} else {
				data = new String(method.getResponseBody(), ENCODING);

			}
		
		} catch (IllegalArgumentException  e) {
			data = "Error in server communication";

		} catch (IllegalStateException e) {
			data = "Error in server communication";

		} catch (IOException e) {
			data = "Error in server communication";
			
		}

		return data;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GetAccountStatement st = new GetAccountStatement();
		
		EStatementRequest statementRequest = st.createEStatementRequest();

		String data = st.getAccountStatement(statementRequest);

		System.out.print(data);
	}

}
