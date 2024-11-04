package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface ShopFinishingTouchesService {
	
	public ModelAndView shopSelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopViewSelectedFinTouchesProductsFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView shopSelectedFTProductsAddToShoppingCart(HttpServletRequest req, HttpSession sn);
	public ModelAndView redirectShopSelectedFinishingTouchesProducts(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonAddCartShopFTProductsValueUpdateInSn(String shopFTProductsInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonShopFTProductsInfoDeleteFromSn(String shopFTProductSavingId, HttpSession sn, HttpServletRequest req);
	public String shopFinishingTouchesInfoSavingInDB(HttpServletRequest req, HttpSession sn, long shopCartPaymentInfoSavingId, String returnType, Timestamp currentDate, long transactionNumber);
	
	
	
	public Timestamp currentDate();
}