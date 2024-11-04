package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.AdminShopDataDisplayService;

@Controller
public class AdminShopDataDisplayController {
	
	@Autowired
	private AdminShopDataDisplayService adminShopDataDisplayService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminShopPurchases")
	@ResponseBody
	public ModelAndView adminShopPurchases(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopPurchasesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopPlaceOrderData")
	@ResponseBody
	public ModelAndView adminShopPlaceOrderData(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopPlaceOrderDataRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopOrderedStatusUpdate")
	@ResponseBody
	public ModelAndView adminShopOrderedStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopOrderedStatusUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopOrdered")
	@ResponseBody
	public ModelAndView adminShopOrdered(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopOrderedRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopTrackingLink")
	@ResponseBody
	public ModelAndView adminShopTrackingLink(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopTrackingLinkRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopTrackingLinkUpdate")
	@ResponseBody
	public ModelAndView adminShopTrackingLinkUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopTrackingLinkUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopTracking")
	@ResponseBody
	public ModelAndView adminShopTracking(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopTrackingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopDeliveredDataUpdate")
	@ResponseBody
	public ModelAndView adminShopDeliveredDataUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopDeliveredDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopDelivered")
	@ResponseBody
	public ModelAndView adminShopDelivered(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopDeliveredRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackOrderedDateDisplay")
	@ResponseBody
	public ModelAndView adminShopBackOrderedDateDisplay(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackOrderedDateDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackOrderedDateUpdate")
	@ResponseBody
	public ModelAndView adminShopBackOrderedDateUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackOrderedDateUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackOrdered")
	@ResponseBody
	public ModelAndView adminShopBackOrdered(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackOrderedRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dminShopBackOrderedViewDetails")
	@ResponseBody
	public ModelAndView dminShopBackOrderedViewDetails(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.dminShopBackOrderedViewDetailsDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackOrderedTextUpdate")
	@ResponseBody
	public ModelAndView adminGRBackOrderTextUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackOrderedTextUpdateDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackOrderedModifyDate")
	@ResponseBody
	public ModelAndView adminShopBackOrderedModifyDate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackOrderedModifyDateDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackOrderedDateModification")
	@ResponseBody
	public ModelAndView adminShopBackOrderedDateModification(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackOrderedDateModificationInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopBackInStockStatusUpdate")
	@ResponseBody
	public ModelAndView adminShopBackInStockStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopBackInStockStatusUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopOutOfStockStatusUpdate")
	@ResponseBody
	public ModelAndView adminShopOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopOutOfStockStatusUpdateInDB(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopOutOfStockDataDisplay")
	@ResponseBody
	public ModelAndView adminShopOutOfStockDataDisplay(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopOutOfStockDataDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopOutOfStock")
	@ResponseBody
	public ModelAndView adminShopOutOfStock(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopOutOfStockRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminShopOutOfStockViewDisplay")
	@ResponseBody
	public ModelAndView adminShopOutOfStockViewDisplay(HttpServletRequest req, HttpSession sn) {		
		return adminShopDataDisplayService.adminShopOutOfStockViewDisplayRedirection(req, sn);
	}
	
	
	
	
	
}
