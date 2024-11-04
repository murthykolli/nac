package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface ShopReferralUsersInfoSavingService {
	public ModelAndView referralUserLoginRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralLearnMoreRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralFormCreationRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralFormInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView refferalForgotPasswordRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView refferalForgotPasswordSentToMail(HttpServletRequest req, HttpSession sn);
	public ModelAndView refferalForgotPassSecPinCheVerification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView referralLoginVerificationRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralLandingRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralLogOutRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralContactInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralShippingInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralShippingInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralPasswordInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralPasswordInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView myReferralCodeInfoTakeFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView activeReferralsInfoRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView rewardsNookAndCoveCreditRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralNookAndCoveStoreCreditRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView rewardsVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView referralVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView visaGiftCardsRequestForAdminRedirection(HttpServletRequest req, HttpSession sn);
		
	public Timestamp currentDate();
}