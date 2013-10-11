package cz.gopay.api.v2.helper;

public class GopayException extends Exception {
	private static final long serialVersionUID = -405259652707493992L;

	/**
	 * Duvod vyhozeni vyjimky 
	 */
    public enum Reason
    {
        OTHER,
        INVALID_VS,
        INVALID_GOID,
        INVALID_SIGNATURE,
        INVALID_CALL_STATE_STATE,
        INVALID_PN,
        INVALID_PRICE,
        INVALID_PSID,
        INVALID_STATUS_SIGNATURE,
        INVALID_USERNAME,
        INVALID_DESCRIPTION,
        INVALID_CALL_RESULT,
        INVALID_REFUND_AMOUNT
                        
    }
    

    private Reason reason = Reason.OTHER;

	
	/**
	 * 
	 */
	public GopayException() {
		super();
	}
	
	/**
	 * @param reason 
	 */
	public GopayException(Reason reason) {
		super();
		this.reason = reason;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GopayException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param reason
	 * @param message
	 * @param cause
	 */
	public GopayException(Reason reason, String message, Throwable cause) {
		super(message, cause);
		this.reason = reason;
	}

	/**
	 * @param message
	 */
	public GopayException(String message) {
		super(message);
	}

	/**
	 * @param reason
	 * @param message
	 */
	public GopayException(Reason reason, String message) {
		super(message);
		this.reason = reason;
	}

	/**
	 * @param cause
	 */
	public GopayException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param reason
	 * @param cause
	 */
	public GopayException(Reason reason, Throwable cause) {
		super(cause);
		this.reason = reason;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}
}
