package com.nookandcove.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface AdminShopDataDisplayService {
	
	public ModelAndView adminShopPurchasesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopPlaceOrderDataRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopOrderedStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopOrderedRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopTrackingLinkRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopTrackingRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopDeliveredDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopDeliveredRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackOrderedDateDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackOrderedRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView dminShopBackOrderedViewDetailsDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackOrderedTextUpdateDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackOrderedModifyDateDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackOrderedDateModificationInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopOutOfStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopOutOfStockDataDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopOutOfStockRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminShopOutOfStockViewDisplayRedirection(HttpServletRequest req, HttpSession sn);
		
	public Timestamp currentDate();
	
}
