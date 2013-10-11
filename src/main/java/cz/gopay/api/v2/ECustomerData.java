package cz.gopay.api.v2;

import cz.gopay.api.v2.helper.CountryCode;

/** 
 *  Komunikacni element predstavuje informace o zakaznikovi {@link EPaymentCommand#setCustomerData(ECustomerData)} 
 */
public class ECustomerData{
	private static final long serialVersionUID = -2169248451211440257L;
	
	private String firstName;
	private String lastName;
	
	private String city;
	private String street;
	private String postalCode;
	private String countryCode;
	
	private String email;
	private String phoneNumber;

	
	/**
	 * Vrátí jméno zákazníka
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	
	/**
	 * Nastaví jméno zákazníka
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Vrátí příjmení zákazníka
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Nastaví příjmení zákazníka
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Vrátí bydliště zákazníka - město 
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * Nastaví bydliště zákazníka - město
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * Vrátí bydliště zákazníka - ulice
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}


	/**
	 * Nastaví bydliště zákazníka - ulice
	 * 
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}


	/**
	 * Vrátí bydliště zákazníka - poštovní směrovací číslo
	 * 
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}


	/**
	 * 
	 * Nastaví bydliště zákazníka - poštovní směrovací číslo
	 * 
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	/**
	 * 
	 * Vrátí bydliště zákazníka - kód země
	 * @see CountryCode
	 * 
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}


	/** 
	 * Nastaví bydliště zákazníka - kód země
	 * @see CountryCode
	 * 
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return firstName + 
		"," + lastName +
		"," + city +
		"," + street +
		"," + postalCode +
		"," + countryCode +
		"," + phoneNumber +
		"," + email;
	}

}
