package cz.gopay.api.v2.helper;

public class CryptoException extends RuntimeException {

	private static final long serialVersionUID = 21531912368715294L;

	/**
	 * 
	 */
	public CryptoException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CryptoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public CryptoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CryptoException(Throwable cause) {
		super(cause);
	}
}
