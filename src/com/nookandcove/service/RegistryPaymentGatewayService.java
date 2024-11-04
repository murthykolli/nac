package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

public interface RegistryPaymentGatewayService {
	
	public String totalPaymentInfoSendToAuthorizeNetGateway(HttpServletRequest req, HttpSession sn, String amount, long cardNumber, String expirationDate, Integer cardCode, String fullName, String emailAddress, String fullAddress, String cityName, String stateName, String zipCode);
	
	public JSONObject convertFromStringToJSONFormat(String jSonResponse);	
	public String resBodyFromAPIToApplication(String jSONObject);	
	public Timestamp currentDate();
	
}
