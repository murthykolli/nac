package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.UserInformationService;


/**
 * @author MurthyK
 *
 */

@Controller
public class UserInformationController {
	
	@Autowired
	private UserInformationService userInformationService;	
	
	@RequestMapping(method = RequestMethod.GET, value = "/design")
	@ResponseBody
	public ModelAndView design(HttpServletRequest req, HttpSession sn) {
		return userInformationService.designHomeRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registration")
	@ResponseBody
	public ModelAndView registration(HttpServletRequest req, HttpSession sn) {
		return userInformationService.registrationRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/registrationDataSaving")
	@ResponseBody
	public ModelAndView registrationDataSaving(HttpServletRequest req, HttpSession sn) {
		return userInformationService.registredDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/alreadyHaveAnAccount")
	@ResponseBody
	public ModelAndView alreadyHaveAnAccount(HttpServletRequest req, HttpSession sn) {
		return userInformationService.alreadyHaveAnAccountRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	@ResponseBody
	public ModelAndView login(HttpServletRequest req, HttpSession sn) {
		return userInformationService.loginRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/loginVerification")
	@ResponseBody
	public ModelAndView loginVerification(HttpServletRequest req, HttpSession sn) {
		return userInformationService.twoLoginPagesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/forgotPassword")
	@ResponseBody
	public ModelAndView forgotPassword(HttpServletRequest req, HttpSession sn) {
		return userInformationService.forgotPasswordRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/forgotPasswordSendingToEmail")
	@ResponseBody
	public ModelAndView forgotPasswordSendingToEmail(HttpServletRequest req, HttpSession sn) {
		return userInformationService.forgotPasswordSentToMail(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/forgotPassSecPinChecking")
	@ResponseBody
	public ModelAndView forgotPassSecPinChecking(HttpServletRequest req, HttpSession sn) {
		return userInformationService.forgetPasswordSecurityPinVerification(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/howItWorks")
	@ResponseBody
	public ModelAndView howItWorks(HttpServletRequest req, HttpSession sn) {
		return userInformationService.howItWorksRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/logOut")
	@ResponseBody
	public ModelAndView logOut(HttpServletRequest req, HttpSession sn) {
		return userInformationService.logOutRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sessionTimeOut")
	public ModelAndView sessionTimeOut(HttpServletRequest req, HttpSession sn) {
		return userInformationService.userSessionTimeOutRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/designRegistry")
	@ResponseBody
	public ModelAndView designRegistry(HttpServletRequest req, HttpSession sn) {		
		return userInformationService.designRegistryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/frequentlyAskedQuestions")
	@ResponseBody
	public ModelAndView frequentlyAskedQuestions(HttpServletRequest req, HttpSession sn) {		
		return userInformationService.frequentlyAskedQuestionsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/terms")
	@ResponseBody
	public ModelAndView terms(HttpServletRequest req, HttpSession sn) {		
		return userInformationService.termsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/privacyPolicy")
	@ResponseBody
	public ModelAndView privacyPolicy(HttpServletRequest req, HttpSession sn) {		
		return userInformationService.privacyPolicyRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regTermsPopupDisplay")
	@ResponseBody
	public ModelAndView regTermsPopupDisplay(HttpServletRequest req, HttpSession sn) {		
		return userInformationService.regTermsPopupDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regPrivacyPolicyPopupDisplay")
	@ResponseBody
	public ModelAndView regPrivacyPolicyPopupDisplay(HttpServletRequest req, HttpSession sn) {		
		return userInformationService.regPrivacyPolicyPopupDisplayRedirection(req, sn);
	}

}
