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

import com.nookandcove.service.RegistryFinishingTouchesService;

@Controller
public class RegistryFinishingTouchesController {
	
	@Autowired
	private RegistryFinishingTouchesService registryFinishingTouchesService;	

	@RequestMapping(method = RequestMethod.POST, value = "/registrySelectedFinishingTouches")
	@ResponseBody
	public ModelAndView registrySelectedFinishingTouches(HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.registrySelectedFinishingTouchesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regFinTouchesSelectedProducts")
	@ResponseBody
	public ModelAndView regFinTouchesSelectedProducts(HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.regFinishingTouchesSelectedProductsTakeFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/regFinTouchesSelectedProdInfoSaving")
	@ResponseBody
	public ModelAndView regFinTouchesSelectedProdInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.registrantFinTouchesSelectedProdInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/redirectRegistrySelectedFinishingTouches")
	@ResponseBody
	public ModelAndView redirectRegistrySelectedFinishingTouches(HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.redirectRegistrySelectedFinishingTouchesData(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editFinishingTouchesContributedProduct")
	@ResponseBody
	public ModelAndView editFinishingTouchesContributedProduct(HttpServletRequest req, HttpSession sn) {		
		return registryFinishingTouchesService.editFinishingTouchesContributedProductsInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editFinishingTouchesIndividualProduct")
	@ResponseBody
	public ModelAndView editFinishingTouchesIndividualProduct(HttpServletRequest req, HttpSession sn) {		
		return registryFinishingTouchesService.editFinishingTouchesIndividualProductsInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finishingTouchesContributedProductAddToCart")
	@ResponseBody
	public ModelAndView finishingTouchesContributedProductAddToCart(HttpServletRequest req, HttpSession sn) {		
		return registryFinishingTouchesService.finishingTouchesContributedProductsAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finTouchesContributedProductDataUpdate")
	@ResponseBody
	public ModelAndView finTouchesContributedProductDataUpdate(HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.finTouchesContributedProductDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finTouchesSelectedProductDataUpdate")
	@ResponseBody
	public ModelAndView finTouchesSelectedProductDataUpdate(HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.finishingTouchesSelectedProductDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonFinishingTouchesContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonFinishingTouchesContributedInfoDelete(@RequestParam("regFTCotributedSavingId") String regFTCotributedSavingId, HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.jSonFinishingTouchesContributedInfoDeleteFromDB(regFTCotributedSavingId, req, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonFinishingTouchesIndividualInfoDelete")
	@ResponseBody
	public JSONArray jSonFinishingTouchesIndividualInfoDelete(@RequestParam("regFTIndividualSavingId") String regFTIndividualSavingId, HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.jSonFinishingTouchesIndividualInfoDeleteFromDB(regFTIndividualSavingId, req, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonFinishingTouchesIndividualInfoAddToCart")
	@ResponseBody
	public JSONArray jSonFinishingTouchesIndividualInfoAddToCart(@RequestParam("regFTIndividualCombVal") String regFTIndividualCombVal, HttpServletRequest req, HttpSession sn) {
		return registryFinishingTouchesService.jSonFinishingTouchesIndividualInfoAddToCartRedirection(regFTIndividualCombVal, req, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartFTContributedValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartFTContributedValueUpdate(@RequestParam("ftContributedInfoValue") String ftContributedInfoValue, HttpSession sn, HttpServletRequest req) {
		return registryFinishingTouchesService.jSonAddCartFTContributedValueUpdateInDB(ftContributedInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartFTIndividualValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartFTIndividualValueUpdate(@RequestParam("ftIndividualInfoValue") String ftIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
		return registryFinishingTouchesService.jSonAddCartFTIndividualValueUpdateInDB(ftIndividualInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonFTContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonFTContributedInfoDelete(@RequestParam("regFTContributedPaymentSavingId") String regFTContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return registryFinishingTouchesService.jSonFTContributedInfoDeleteFromDB(regFTContributedPaymentSavingId, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonFTIndividualInfoDelete")
	@ResponseBody
	public JSONArray jSonFTIndividualInfoDelete(@RequestParam("regFTIndividualPaymentSavingId") String regFTIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return registryFinishingTouchesService.jSonFTIndividualInfoDeleteFromDB(regFTIndividualPaymentSavingId, sn, req);		
	}

	
}
