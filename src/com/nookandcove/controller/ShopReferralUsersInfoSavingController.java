package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.ShopReferralUsersInfoSavingService;

@Controller
public class ShopReferralUsersInfoSavingController {
	
	@Autowired
	private ShopReferralUsersInfoSavingService shopReferralUsersInfoSavingService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/referralUserLogin")
	@ResponseBody
	public ModelAndView referralUserLogin(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.referralUserLoginRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralLearnMore")
	@ResponseBody
	public ModelAndView referralLearnMore(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.referralLearnMoreRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralFormCreation")
	@ResponseBody
	public ModelAndView referralFormCreation(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.referralFormCreationRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralFormInfoSaving")
	@ResponseBody
	public ModelAndView referralFormInfoSaving(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.referralFormInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/refferalForgotPassword")
	@ResponseBody
	public ModelAndView refferalForgotPassword(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.refferalForgotPasswordRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralForgotPasswordSendingToEmail")
	@ResponseBody
	public ModelAndView referralForgotPasswordSendingToEmail(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.refferalForgotPasswordSentToMail(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralForgotPassSecPinChecking")
	@ResponseBody
	public ModelAndView referralForgotPassSecPinChecking(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.refferalForgotPassSecPinCheVerification(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralLoginVerification")
	@ResponseBody
	public ModelAndView referralLoginVerification(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralLoginVerificationRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralLanding")
	@ResponseBody
	public ModelAndView referralLanding(HttpServletRequest req, HttpSession sn) {		
		return shopReferralUsersInfoSavingService.referralLandingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralLogOut")
	@ResponseBody
	public ModelAndView referralLogOut(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralLogOutRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralContactInfo")
	@ResponseBody
	public ModelAndView referralContactInfo(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralLandingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralContactInfoUpdate")
	@ResponseBody
	public ModelAndView referralContactInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralContactInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralShippingInfo")
	@ResponseBody
	public ModelAndView referralShippingInfo(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralShippingInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralShippingInfoUpdate")
	@ResponseBody
	public ModelAndView referralShippingInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralShippingInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/referralPasswordInfo")
	@ResponseBody
	public ModelAndView referralPasswordInfo(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralPasswordInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/referralPasswordInfoUpdate")
	@ResponseBody
	public ModelAndView referralPasswordInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralPasswordInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/myReferralCodeInfo")
	@ResponseBody
	public ModelAndView myReferralCodeInfo(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.myReferralCodeInfoTakeFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/activeReferralsInfo")
	@ResponseBody
	public ModelAndView activeReferralsInfo(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.activeReferralsInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/rewardsNookAndCoveCredit")
	@ResponseBody
	public ModelAndView rewardsNookAndCoveCredit(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.rewardsNookAndCoveCreditRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/nookAndCoveStoreCredit")
	@ResponseBody
	public ModelAndView nookAndCoveStoreCredit(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralNookAndCoveStoreCreditRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/rewardsVisaGiftCards")
	@ResponseBody
	public ModelAndView rewardsVisaGiftCards(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.rewardsVisaGiftCardsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/visaGiftCards")
	@ResponseBody
	public ModelAndView visaGiftCards(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.referralVisaGiftCardsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/visaGiftCardsRequestForAdmin")
	@ResponseBody
	public ModelAndView visaGiftCardsRequestForAdmin(HttpServletRequest req, HttpSession sn) {
		return shopReferralUsersInfoSavingService.visaGiftCardsRequestForAdminRedirection(req, sn);
	}

	
}
