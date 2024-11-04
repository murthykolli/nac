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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.RegistrantCashFundsService;

@Controller
public class RegistrantCashFundsController {
	
	@Autowired
	private RegistrantCashFundsService registrantCashFundsService;	
		
	@RequestMapping(method = RequestMethod.GET, value = "/registryFundsCreation")
	@ResponseBody
	public ModelAndView registryCharityFund(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.registryCharityFundRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/regTopCashFundsInfoSaving")
	@ResponseBody
	public ModelAndView regTopCashFundsInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regTopCashFundsInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regTopCashFundsInfoUpdating")
	@ResponseBody
	public ModelAndView regTopCashFundsInfoUpdating(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regTopCashFundsInfoUpdatingInDB(req, sn);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/regCashFundContributeInfoRed")
//	@ResponseBody
//	public ModelAndView regCashFundContributeInfoRed(HttpServletRequest req, HttpSession sn) {
//		return registrantCashFundsService.regCashFundContributeInfoRedirection(req, sn);
//	}

	@RequestMapping(method = RequestMethod.POST, value = "/regCashFundInfoAddToCart")
	@ResponseBody
	public ModelAndView regCashFundInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCashFundInfoAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryEditCashFund")
	@ResponseBody
	public ModelAndView registryEditCashFund(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.registryEditCashFundRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryEditACustomFund")
	@ResponseBody
	public ModelAndView registryEditACustomFund(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.registryEditACustomFundRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regCashFundBack")
	@ResponseBody
	public ModelAndView regCashFundBack(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCashFundBackRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCashFundLandingContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonCashFundLandingContributedInfoDelete(@RequestParam("cfContributedSavingId") String cfContributedSavingId, HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.jSonCashFundLandingContributedInfoDeleteFromDB(cfContributedSavingId, req, sn);		
	}

//	Custom Fund Coding

	@RequestMapping(method = RequestMethod.GET, value = "/registryCreateACustomFund")
	@ResponseBody
	public ModelAndView registryCreateACustomFund(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.registryCreateACustomFundRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regCustomCashFundsInfoSaving")
	@ResponseBody
	public ModelAndView regCustomCashFundsInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCustomCashFundsInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regCustomCashFundsInfoUpdating")
	@ResponseBody
	public ModelAndView regCustomCashFundsInfoUpdating(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCustomCashFundsInfoUpdatingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/uploadCustomCashFundImage")
	@ResponseBody
	public ModelAndView uploadCustomCashFundImage(@RequestParam("regPhotoUpload") MultipartFile cashFundUploadImg, HttpServletRequest req, HttpSession sn) throws Exception {
		return registrantCashFundsService.uploadCustomCashFundImageInDB(cashFundUploadImg, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryEditCustomFund")
	@ResponseBody
	public ModelAndView registryEditCustomFund(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.registryEditCustomFundRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regCustomFundBack")
	@ResponseBody
	public ModelAndView regCustomFundBack(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCustomFundBackRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regCustomCashFundDataEditing")
	@ResponseBody
	public ModelAndView regCustomCashFundDataEditing(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCustomCashFundDataEditingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/landingEditImageUploadCustomFund")
	@ResponseBody
	public ModelAndView landingEditImageUploadCustomFund(@RequestParam("regPhotoUpload") MultipartFile cashFundUploadImg, HttpServletRequest req, HttpSession sn) throws Exception {
		return registrantCashFundsService.landingEditImageUploadCustomFundInDB(cashFundUploadImg, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCustomFundLandingContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonCustomFundLandingContributedInfoDelete(@RequestParam("cfContributedSavingId") String cfContributedSavingId, HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.jSonCustomFundLandingContributedInfoDeleteFromDB(cfContributedSavingId, req, sn);		
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/regCustomFundContributeInfoRed")
//	@ResponseBody
//	public ModelAndView regCustomFundContributeInfoRed(HttpServletRequest req, HttpSession sn) {
//		return registrantCashFundsService.regCustomFundContributeInfoRedirection(req, sn);
//	}

	@RequestMapping(method = RequestMethod.POST, value = "/regCustomFundInfoAddToCart")
	@ResponseBody
	public ModelAndView regCustomFundInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return registrantCashFundsService.regCustomFundInfoAddToCartRedirection(req, sn);
	}

	
	
	
}
