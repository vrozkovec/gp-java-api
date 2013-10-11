package cz.gopay.api.v2.helper;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;


/**
 * Pomocna trida pro sifrovani.  
 */

public class CryptoHelper {

	private static final Logger logger = Logger.getLogger(CryptoHelper.class.getName());
	
	private static MessageDigest messageDigest = null;

	static{
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		}
	}

	/**
	 * Vytvori hash ze zpravy
	 * @param message zprava
	 * @return SHA hash zpravy, HEX reprezentace
	 * @throws CryptoException pokud neni dostupny algoritmus pro vytvoreni hash
	 * @throws NullPointerException pokud je message null 
	 */
	public static String hash(String message) throws CryptoException {
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
			
			logger.log(Level.FINE, "to be hashed["+message+"]");
			return new String(Hex.encodeHex(messageDigest.digest(message.getBytes())));
			
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		}
	}
	
  	/**
  	 * Desifrovani dat
  	 *
  	 * @param encryptedHEX
  	 * @param key
  	 * @return desifrovany retezec
  	 * @throws IllegalStateException kdyz je klic kratsi nez 24 znaku
  	 * @throws CryptoException kdyz dojde k chybe pri desifrovani
  	 */
	public static String decrypt(String encryptedHEX, String key) throws CryptoException {
		
		assert encryptedHEX != null && key != null;
		
		try {
			if(key.length() < 24){
				throw new IllegalStateException("encryption key must have lengt at least 24");
			}

			SecretKeySpec keyspec = new SecretKeySpec(key.substring(0,24).getBytes(), "TripleDES");		
			Cipher cipher = Cipher.getInstance("TripleDES/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, keyspec);
			
			byte[] encryptedB = Hex.decodeHex(encryptedHEX.toCharArray());
			byte[] decrypted = cipher.doFinal(encryptedB);		
			
			return new String(decrypted).trim();
			
		} catch (InvalidKeyException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (BadPaddingException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (DecoderException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		}
	}
	
  	/**
  	 * Sifrovani dat 3DES
  	 *
  	 * @param message
  	 * @param key
  	 * @return sifrovany obsah v HEX forme
  	 * @throws IllegalStateException kdyz je klic kratsi nez 24 znaku
  	 * @throws CryptoException kdyz dojde k chybe pri sifrovani
  	 */
	public static String encrypt(String message, String key) throws CryptoException {
		
		try {
			if(key.length() < 24){
				throw new IllegalStateException("encryption key must have lengt at least 24");
			}

			SecretKeySpec keyspec = new SecretKeySpec(key.substring(0, 24).getBytes(), "TripleDES");		
			Cipher cipher = Cipher.getInstance("TripleDES/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, keyspec);
			
			int fullfill = (8-message.length()%8);
			StringBuffer sb = new StringBuffer(message);
			for(int i = 0; i<fullfill;i++)sb.append("\u0000");

			byte[] encrypted = cipher.doFinal(sb.toString().getBytes());		
			
			return new String(Hex.encodeHex(encrypted));
			
		} catch (InvalidKeyException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		} catch (BadPaddingException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new CryptoException(e.getMessage());
		}
	}
}
