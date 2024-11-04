package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.GiftInfoSavingService;

@Controller
public class GiftInfoSavingController {	

	@Autowired
	private GiftInfoSavingService giftInfoSavingService;	
	
	@RequestMapping(method = RequestMethod.GET, value = "/gift")
	@ResponseBody
	public ModelAndView gift(HttpServletRequest req, HttpSession sn) {		
		return giftInfoSavingService.giftRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/giftDataSaving")
	@ResponseBody
	public ModelAndView giftDataSaving(HttpServletRequest req, HttpSession sn) {
		return giftInfoSavingService.giftDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/promoCodePayInGiftCardRed")
	@ResponseBody
	public ModelAndView promoCodePayInGiftCardRed(HttpServletRequest req, HttpSession sn) {
		return giftInfoSavingService.promoCodePayInGiftCardRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/giftCardPaymentInfoSaving")
	@ResponseBody
	public ModelAndView giftCardPaymentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return giftInfoSavingService.giftCardPaymentInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/giftCardPromoCodePaymentInfoSaving")
	@ResponseBody
	public ModelAndView giftCardPromoCodePaymentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return giftInfoSavingService.giftCardPromoCodePaymentInfoSavingInDB(req, sn);
	}
}
