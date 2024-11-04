package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.ShopFinishingTouchesService;

@Controller
public class ShopFinishingTouchesController {
	
	@Autowired
	private ShopFinishingTouchesService shopFinishingTouchesService;	

	@RequestMapping(method = RequestMethod.POST, value = "/shopSelectedFinishingTouches")
	@ResponseBody
	public ModelAndView shopSelectedFinishingTouches(HttpServletRequest req, HttpSession sn) {
		return shopFinishingTouchesService.shopSelectedFinishingTouchesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopFinTouchesSelectedProducts")
	@ResponseBody
	public ModelAndView shopFinTouchesSelectedProducts(HttpServletRequest req, HttpSession sn) {		
		return shopFinishingTouchesService.shopViewSelectedFinTouchesProductsFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopSelectedFTProductsAddToCart")
	@ResponseBody
	public ModelAndView shopSelectedFTProductsAddToCart(HttpServletRequest req, HttpSession sn) {		
		return shopFinishingTouchesService.shopSelectedFTProductsAddToShoppingCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/redirectShopSelectedFinishingTouches")
	@ResponseBody
	public ModelAndView redirectShopSelectedFinishingTouches(HttpServletRequest req, HttpSession sn) {		
		return shopFinishingTouchesService.redirectShopSelectedFinishingTouchesProducts(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartShopFTProductsValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartShopFTProductsValueUpdate(@RequestParam("shopFTProductInfoValue") String shopFTProductsInfoValue, HttpSession sn, HttpServletRequest req) {
		return shopFinishingTouchesService.jSonAddCartShopFTProductsValueUpdateInSn(shopFTProductsInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonShopFTProductsInfoDelete")
	@ResponseBody
	public JSONArray jSonShopFTProductsInfoDelete(@RequestParam("shopFTProductsSavingId") String shopFTProductSavingId, HttpSession sn, HttpServletRequest req) {
		return shopFinishingTouchesService.jSonShopFTProductsInfoDeleteFromSn(shopFTProductSavingId, sn, req);		
	}


	
}
