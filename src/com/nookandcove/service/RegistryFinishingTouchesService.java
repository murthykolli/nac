package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface RegistryFinishingTouchesService {
	
	public ModelAndView registrySelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regFinishingTouchesSelectedProductsTakeFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantFinTouchesSelectedProdInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantFinTouchesContributedProductInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate, String regiFTSelectedCategory);
	public ModelAndView registrantFinTouchesIndividualProductInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate, String regiFTSelectedCategory);
	public String registryFinishingTouchesContributedProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public String registryFinishingTouchesIndividualProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public ModelAndView redirectRegistrySelectedFinishingTouchesData(HttpServletRequest req, HttpSession sn);
	public int registryTotalFinishingTouchesContributedCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public int registryTotalFinishingTouchesIndividualCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public ModelAndView editFinishingTouchesContributedProductsInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView editFinishingTouchesIndividualProductsInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView finishingTouchesContributedProductsAddToCart(HttpServletRequest req, HttpSession sn);
	public ModelAndView finTouchesContributedProductDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView finishingTouchesSelectedProductDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonFinishingTouchesContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn);
	public JSONArray jSonFinishingTouchesIndividualInfoDeleteFromDB(String regFTIndividualSavingId, HttpServletRequest req, HttpSession sn);
	public JSONArray jSonFinishingTouchesIndividualInfoAddToCartRedirection(String regFTIndividualCombVal, HttpServletRequest req, HttpSession sn);
	public String registrantFTContributedAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn);
	public String registrantFTIndividualAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn);
	public double registrantFTContributedAddCartTotalPrice(HttpServletRequest req, HttpSession sn);
	public double registrantFTIndividualAddCartTotalPrice(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonAddCartFTContributedValueUpdateInDB(String ftContributedInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonAddCartFTIndividualValueUpdateInDB(String ftIndividualInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonFTContributedInfoDeleteFromDB(String regiFTContributedPaymentSavingId, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonFTIndividualInfoDeleteFromDB(String regiFTIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req);
	public String registrantFinishingTouchesPaymentInfoUpdateInDB(HttpSession sn, HttpServletRequest req, long registrantUserId, String paymentStatus, long regiPaymentInfoSavingId);
	
	
	
	public Timestamp currentDate();
}