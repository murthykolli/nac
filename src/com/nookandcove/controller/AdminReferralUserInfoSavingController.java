package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.AdminReferralUserInfoSavingService;

@Controller
public class AdminReferralUserInfoSavingController {
	
	@Autowired
	private AdminReferralUserInfoSavingService adminReferralUserInfoSavingService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminNewApplicants")
	@ResponseBody
	public ModelAndView adminNewApplicants(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminNewApplicantsDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminViewNewApplicantsInfo")
	@ResponseBody
	public ModelAndView adminViewNewApplicantsInfo(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminViewNewApplicantsInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminApproveToReferralUser")
	@ResponseBody
	public ModelAndView adminApproveToReferralUser(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminApproveToReferralUserAccountAccess(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminDonotApproveToReferralUser")
	@ResponseBody
	public ModelAndView adminDonotApproveToReferralUser(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminDonotApproveToReferralUserAccountAccess(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminNoteInfoSaving")
	@ResponseBody
	public ModelAndView adminNoteInfoSaving(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminNoteInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminViewNoteReferralInfo")
	@ResponseBody
	public ModelAndView adminViewNoteReferralInfo(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminViewNoteReferralInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminDeleteReferralUser")
	@ResponseBody
	public ModelAndView adminDeleteReferralUser(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminDeleteReferralUserInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminViewNoteInfoBackMove")
	@ResponseBody
	public ModelAndView adminViewNoteInfoBackMove(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminViewNoteInfoBackMoveRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminCurrentVendors")
	@ResponseBody
	public ModelAndView adminCurrentVendors(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminCurrentVendorsDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminCurrentApplicantsInfo")
	@ResponseBody
	public ModelAndView adminCurrentApplicantsInfo(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminCurrentApplicantsInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminVisaGiftCards")
	@ResponseBody
	public ModelAndView adminVisaGiftCards(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminNewVisaGiftCardsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminIssuedVisaGiftCardsInfo")
	@ResponseBody
	public ModelAndView adminIssuedVisaGiftCardsInfo(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminIssuedVisaGiftCardsInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminIssuedVisaGiftCards")
	@ResponseBody
	public ModelAndView adminIssuedVisaGiftCards(HttpServletRequest req, HttpSession sn) {		
		return adminReferralUserInfoSavingService.adminIssuedVisaGiftCardsRedirection(req, sn);
	}
	
}
