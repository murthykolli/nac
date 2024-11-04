package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface GiftInfoSavingService {

	public ModelAndView giftRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView giftDataSavingInDB(HttpServletRequest request, HttpSession session);
	public ModelAndView giftCardPaymentInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView giftCardPromoCodePaymentInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView promoCodePayInGiftCardRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView giftCardPaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String userName);
	public String resBodyFromAPIToApplication(String jSONObject);
	public JSONObject convertFromStringToJSONFormat(String jSonResponse);
	public ModelAndView clientGiftCardSentMailToAdmin(HttpServletRequest req, HttpSession sn);
	public Timestamp currentDate();
}