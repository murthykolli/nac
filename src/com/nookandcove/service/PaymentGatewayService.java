package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface PaymentGatewayService {
	
	public ModelAndView packagePaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard, String totalAmount, String giftAmount, String promoCodePrice);
	public ModelAndView secRenderingPaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard, String totalAmount, String giftAmount);
	public ModelAndView catCheckoutPaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard);
	public JSONObject convertFromStringToJSONFormat(String jSonResponse);	
	public String resBodyFromAPIToApplication(String jSONObject);	
	public Timestamp currentDate();
	
}
