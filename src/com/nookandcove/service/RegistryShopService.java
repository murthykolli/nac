package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface RegistryShopService {
	
	public ModelAndView registryShopRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopSelectedRoomConceptBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView previousShopCBProductsDisplayFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView nextShopCBProductsDisplayFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopViewAllDesignsConceptBoards(HttpServletRequest req, HttpSession sn);
	public ModelAndView viewShopDesignSelectedConceptBoards(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView shopSelectedCBProductsAddToShoppingCart(HttpServletRequest req, HttpSession sn);
	public ModelAndView redirectShopSelectedProductConceptBoards(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopShoppingCartInfoDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonAddCartShopCBProductsValueUpdateInSn(String shopCBProductsInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonShopCBProductsInfoDeleteFromSn(String shopCBProductSavingId, HttpSession sn, HttpServletRequest req);
	public ModelAndView shopCheckoutBillingAndShippingInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopBillAndShipInfoSavingInSn(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopCheckoutPaymentInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopGiftOrPromoCodePaymentInfoRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView shopReferralCustomGiftCardPaymentInfoOnly(HttpServletRequest req, HttpSession sn, String shNameOnCard, String shPayCardNumber, String shPayExpMonth, String shPayExpYear, String shPayCvvNumber);
	public ModelAndView shopUserGiftPromoCodePaymentInfoOnly(HttpServletRequest req, HttpSession sn, String shNameOnCard, String shPayCardNumber, String shPayExpMonth, String shPayExpYear, String shPayCvvNumber);
	
	public ModelAndView shopCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopPaymentSuccessRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopCartPaymentPurchaseToGatewayWithCCRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopCouponZeroPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView shopTermsPopupDisplayDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopPrivacyPolicyPopupDisplay(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();
}