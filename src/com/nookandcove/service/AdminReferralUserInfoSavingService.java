package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface AdminReferralUserInfoSavingService {
	public ModelAndView adminNewApplicantsDataDisplay(HttpServletRequest req, HttpSession sn);	
	public ModelAndView adminViewNewApplicantsInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApproveToReferralUserAccountAccess(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDonotApproveToReferralUserAccountAccess(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminNoteInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminViewNoteReferralInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDeleteReferralUserInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminViewNoteInfoBackMoveRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView adminCurrentVendorsDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminCurrentApplicantsInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminViewVendorDetailsDisplayRedirection(HttpServletRequest req, HttpSession sn, long adminReferralUsersId);
	public ModelAndView adminViewWPSentDetailsRedirection(HttpServletRequest req, HttpSession sn, long adminReferralUsersId);
	public ModelAndView adminViewVendorClientsDetailsRedirection(HttpServletRequest req, HttpSession sn, long adminReferralUsersId);
	public ModelAndView adminNewVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminIssuedVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminIssuedVisaGiftCardsInfoRedirection(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();
}