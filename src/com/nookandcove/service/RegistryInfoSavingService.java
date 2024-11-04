package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface RegistryInfoSavingService {
	
	public ModelAndView registryHomeRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView registryHowItWorksALRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryBenefitsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryLMDesignServicesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView createRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryDataSavingInDB(HttpServletRequest req, HttpSession sn);	
	public ModelAndView registrantHomeLandingPageRedirection(HttpServletRequest req, HttpSession sn, String regiUserName, String uPassword);
	public ModelAndView twoLoginPagesForRegRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryLoginVerificationFromDB(HttpServletRequest req, HttpSession sn, String regiUserName, String uPassword);
	public ModelAndView registryLandingRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrentLandingDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryOverviewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantBackgroundImageUploadInDB(MultipartFile regPhotoUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView createdRoomFundsInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView createCashFundsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView uploadRegistrantProfileInDB(MultipartFile regPhotoUpload, String uploadImgReferance, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView registryUploadImageRedirectToJSP(String uploadImgReferance, HttpServletRequest req, HttpSession sn);
	public ModelAndView saveRegiMessageDataInDB(String regMesReferance, HttpServletRequest req, HttpSession sn);
	public ModelAndView designConceptsBoardsForLandingDataMaintain(HttpServletRequest req, HttpSession sn);
	public ModelAndView regEditBackgroundImageForGuest(String regReferance, HttpServletRequest req, HttpSession sn);
	public ModelAndView regEditBackgroundImageSaveInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView previewGuestRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regSpaceBackMoveRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryRoomFundsInfoDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryRoomFoundInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryRoomFundsLandingInfoEditInDB(HttpServletRequest req, HttpSession sn);	
	public ModelAndView roomFundAndLandingPageRedirections(HttpServletRequest req, HttpSession sn);

	public JSONArray jSonRegistryMakeVisibleAccessInDB(String liveStatusRef, HttpServletRequest req, HttpSession sn);
	public ModelAndView registryLoginRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView regLogOutRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryForgotPasswordRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regForgotPasswordSentToMail(HttpServletRequest req, HttpSession sn);
	public ModelAndView regForgotPassSecPinCheVerification(HttpServletRequest req, HttpSession sn);
	
	public JSONArray jSonRoomFundContributedLandingInfoDeleteFromDB(String totalRoomFundInfo, HttpServletRequest req, HttpSession sn);
	public ModelAndView registrySpaceSelContributeCartInfoDeleteFromDB(long registrantUserId, HttpServletRequest req, HttpSession sn);	
	public ModelAndView registrySpaceInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantTotalShoppingCartDisplay(HttpServletRequest req, HttpSession sn);
//	public ModelAndView regCashFundContributeEditInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantFundsCheckOutContactRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantBillingAndShippingInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantPaymentInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView registrantSessionTimeOutRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView aboutUsForGuestRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryTermsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryPrivacyPolicyRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regFullRoomPaymentInfoDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView regAccDsnPaymentInfoDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCashFundPaymentInfoDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantGiftCardPaymentInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantGiftCardZeroPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantGiftCardPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();
}