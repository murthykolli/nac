package com.nookandcove.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface UserInformationService {
	
	public ModelAndView designHomeRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView registrationRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView registredDataSavingInDB(HttpServletRequest request, HttpSession session);	
	public ModelAndView loginRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView twoLoginPagesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView userDetailsVerificationFromDB(HttpServletRequest req, HttpSession sn, String uName, String uPassword);
	public ModelAndView userDetailsVerificationForRegFromDB(HttpServletRequest req, HttpSession sn, String uName, String uPassword);
	public ModelAndView howItWorksRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView forgotPasswordRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView forgotPasswordSentToMail(HttpServletRequest req, HttpSession sn);
	public ModelAndView forgotPasswordPinSendToUserEmail(HttpServletRequest req, HttpSession sn, String securityPin, String userName, String firstName);
	public ModelAndView forgetPasswordSecurityPinVerification(HttpServletRequest req, HttpSession sn);	
	public ModelAndView logOutRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView userLoginDetailsRedirection(HttpServletRequest req, HttpSession sn, long uID);	
	public ModelAndView designerLoginDetailsRedirection(HttpServletRequest req, HttpSession sn, long uID);	
	public ModelAndView changePasswordInDB(HttpServletRequest req, HttpSession sn);	
	public ModelAndView adminLoginDetailsRedirection(HttpServletRequest req, HttpSession sn, long uID);	
	public ModelAndView packagePaymentRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView userTypeVerificationInDB(HttpServletRequest req, HttpSession sn, String typeOfUser, long uID);
	public ModelAndView alreadyHaveAnAccountRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accountRedirectionToPayment(HttpServletRequest req, HttpSession sn, long uID);
	public ModelAndView designRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView frequentlyAskedQuestionsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView termsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView privacyPolicyRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView regTermsPopupDisplayRedirection(HttpServletRequest req, HttpSession sn);
    public ModelAndView regPrivacyPolicyPopupDisplayRedirection(HttpServletRequest req, HttpSession sn);
    
	public Timestamp currentDate();
	public ModelAndView userSessionTimeOutRedirection(HttpServletRequest req, HttpSession sn);	
}
