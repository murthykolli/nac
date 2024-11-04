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

import com.nookandcove.service.RegistryInfoSavingService;

@Controller
public class RegistryInfoSavingController {
	
	@Autowired
	private RegistryInfoSavingService registryInfoSavingService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	@ResponseBody
	public ModelAndView home(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryHomeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryHowItWorks")
	@ResponseBody
	public ModelAndView registryHowItWorks(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryHowItWorksALRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryBenefits")
	@ResponseBody
	public ModelAndView registryBenefits(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryBenefitsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/lmDesignServices")
	@ResponseBody
	public ModelAndView lmDesignServices(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryLMDesignServicesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/createRegistry")
	@ResponseBody
	public ModelAndView createRegistry(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.createRegistryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registrentInfoSaving")
	@ResponseBody
	public ModelAndView registrentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrentLandingDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registryDataSaving")
	@ResponseBody
	public ModelAndView registryDataSaving(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registryDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/registryLoginVerification")
	@ResponseBody
	public ModelAndView registryLoginVerification(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.twoLoginPagesForRegRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryLanding")
	@ResponseBody
	public ModelAndView registryLanding(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryLandingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryOverview")
	@ResponseBody
	public ModelAndView registryOverview(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryOverviewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/createRoomFunds")
	@ResponseBody
	public ModelAndView createRoomFunds(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.createdRoomFundsInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/createCashFunds")
	@ResponseBody
	public ModelAndView createCashFunds(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.createCashFundsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/uploadRegistrantProfile")
	@ResponseBody
	public ModelAndView uploadRegistrantProfile(@RequestParam("regPhotoUpload") MultipartFile regPhotoUpload, String uploadImgReferance, HttpServletRequest req, HttpSession sn) throws Exception {
		return registryInfoSavingService.uploadRegistrantProfileInDB(regPhotoUpload, uploadImgReferance, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryUploadImageRedirect")
	@ResponseBody
	public ModelAndView registryUploadImageRedirect(String uploadImageReferance, HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryUploadImageRedirectToJSP(uploadImageReferance, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveRegiMessageData")
	@ResponseBody
	public ModelAndView saveRegiMessageData(String regMesReferance, HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.saveRegiMessageDataInDB(regMesReferance, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regEditBackgroundForGuest")
	@ResponseBody
	public ModelAndView regEditBackgroundForGuest(String regReferance, HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.regEditBackgroundImageForGuest(regReferance, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regEditBackgroundBackMove")
	@ResponseBody
	public ModelAndView regEditBackgroundBackMove(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registryOverviewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantBackgroundImageUpload")
	@ResponseBody
	public ModelAndView registrantBackgroundImageUpload(@RequestParam("regBackgroundUploadImage") MultipartFile regBackgroundUploadImage, HttpServletRequest req, HttpSession sn) throws Exception {
		return registryInfoSavingService.registrantBackgroundImageUploadInDB(regBackgroundUploadImage, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regEditBackgroundImageSave")
	@ResponseBody
	public ModelAndView regEditBackgroundImageSave(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.regEditBackgroundImageSaveInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/previewGuestRegistry")
	@ResponseBody
	public ModelAndView previewGuestRegistry(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.previewGuestRegistryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regSpaceBackMove")
	@ResponseBody
	public ModelAndView regSpaceBackMove(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.regSpaceBackMoveRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registryRoomFundsInfoDisplay")
	@ResponseBody
	public ModelAndView registryRoomFundsInfoDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryRoomFundsInfoDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registryRoomFoundInfoSaving")
	@ResponseBody
	public ModelAndView registryRoomFoundInfoSaving(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryRoomFoundInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryRoomFundsLandingInfoEdit")
	@ResponseBody
	public ModelAndView registryRoomFundsLandingInfoEdit(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryRoomFundsLandingInfoEditInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonRegistryMakeVisibleAccess")
	@ResponseBody
	public JSONArray jSonRegistryMakeVisibleAccess(@RequestParam("liveStatusRef") String liveStatusRef, HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.jSonRegistryMakeVisibleAccessInDB(liveStatusRef, req, sn);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registryLogin")
	@ResponseBody
	public ModelAndView registryLogin(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryLoginRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/regLogOut")
	@ResponseBody
	public ModelAndView regLogOut(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.regLogOutRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryForgotPassword")
	@ResponseBody
	public ModelAndView registryForgotPassword(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registryForgotPasswordRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/regForgotPasswordSendingToEmail")
	@ResponseBody
	public ModelAndView regForgotPasswordSendingToEmail(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.regForgotPasswordSentToMail(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regForgotPassSecPinChecking")
	@ResponseBody
	public ModelAndView regForgotPassSecPinChecking(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.regForgotPassSecPinCheVerification(req, sn);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/registrySpaceContributeInfoRed")
//	@ResponseBody
//	public ModelAndView registrySpaceContributeInfoRed(HttpServletRequest req, HttpSession sn) {
//		return registryInfoSavingService.registrySpaceContributeInfoRedirection(req, sn);
//	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonRoomFundContributedLandingInfoDelete")
	@ResponseBody
	public JSONArray jSonRoomFundContributedLandingInfoDelete(@RequestParam("totalRoomFundInfo") String totalRoomFundInfo, HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.jSonRoomFundContributedLandingInfoDeleteFromDB(totalRoomFundInfo, req, sn);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registrySpaceInfoAddToCart")
	@ResponseBody
	public ModelAndView registrySpaceInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrySpaceInfoAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registrantShoppingCartDisplay")
	@ResponseBody
	public ModelAndView registrantShoppingCartDisplay(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantTotalShoppingCartDisplay(req, sn);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartCashFundContributedValueUpdate")
//	@ResponseBody
//	public JSONArray jSonAddCartCashFundContributedValueUpdate(@RequestParam("cfContributedInfoValue") String cfContributedInfoValue, HttpSession sn, HttpServletRequest req) {
//		return registryInfoSavingService.jSonAddCartCashFundContributedValueUpdateInDB(cfContributedInfoValue, req, sn);		
//	}

//	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartCustomFundContributedValueUpdate")
//	@ResponseBody
//	public JSONArray jSonAddCartCustomFundContributedValueUpdate(@RequestParam("cfContributedInfoValue") String cfContributedInfoValue, HttpSession sn, HttpServletRequest req) {
//		return registryInfoSavingService.jSonAddCartCustomFundContributedValueUpdateInDB(cfContributedInfoValue, req, sn);		
//	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/jSonCashFundContributedInfoDelete")
//	@ResponseBody
//	public JSONArray jSonCashFundContributedInfoDelete(@RequestParam("cfContributedPaymentSavingId") String cfContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
//		return registryInfoSavingService.jSonCashFundContributedInfoDeleteFromDB(cfContributedPaymentSavingId, req, sn);		
//	}

//	@RequestMapping(method = RequestMethod.POST, value = "/jSonCustomFundContributedInfoDelete")
//	@ResponseBody
//	public JSONArray jSonCustomFundContributedInfoDelete(@RequestParam("cfContributedPaymentSavingId") String cfContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
//		return registryInfoSavingService.jSonCustomFundContributedInfoDeleteFromDB(cfContributedPaymentSavingId, req, sn);		
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiSpaceUpdatedInfoAddToCart")
	@ResponseBody
	public ModelAndView regiSpaceUpdatedInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrySpaceInfoAddToCartRedirection(req, sn);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/regCashFundContributeEditInfoRed")
//	@ResponseBody
//	public ModelAndView regCashFundContributeEditInfoRed(HttpServletRequest req, HttpSession sn) {
//		return registryInfoSavingService.regCashFundContributeEditInfoRedirection(req, sn);
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/registrantFundsCheckOutContact")
	@ResponseBody
	public ModelAndView registrantFundsCheckOutContact(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantFundsCheckOutContactRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantBillingInfoSaving")
	@ResponseBody
	public ModelAndView registrantBillingInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantBillingAndShippingInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantPaymentInfoRed")
	@ResponseBody
	public ModelAndView registrantPaymentInfoRed(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantPaymentInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantCartPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView registrantCartPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantCartPaymentPurchaseToGatewayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registrantSessionTimeOut")
	public ModelAndView registrantSessionTimeOut(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantSessionTimeOutRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/aboutUsForGuest")
	public ModelAndView aboutUsForGuest(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.aboutUsForGuestRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryTerms")
	@ResponseBody
	public ModelAndView registryTerms(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryTermsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryPrivacyPolicy")
	@ResponseBody
	public ModelAndView registryPrivacyPolicy(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registryPrivacyPolicyRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/redirectRegSpaceAllCartInfoDisplay")
	@ResponseBody
	public ModelAndView redirectRegSpaceAllCartInfoDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.registrantTotalShoppingCartDisplay(req, sn);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/jSonRegistryRoomFundContributeInfoDelete")
//	@ResponseBody
//	public JSONArray jSonRegistryRoomFundContributeInfoDelete(@RequestParam("roomFundsName") String roomFundsName, HttpServletRequest req, HttpSession sn) {
//		return registryInfoSavingService.jSonRegistryRoomFundContributeInfoDeleteInDB(roomFundsName, req, sn);		
//	}

//	@RequestMapping(method = RequestMethod.POST, value = "/jSonRegistryRoomFundContributeValueUpdate")
//	@ResponseBody
//	public JSONArray jSonRegistryRoomFundContributeValueUpdate(@RequestParam("roomFundsName") String roomFundsName, HttpServletRequest req, HttpSession sn) {
//		return registryInfoSavingService.jSonRegistryRoomFundContributeValueUpdateInDB(roomFundsName, req, sn);		
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/regFullRoomPaymentInfoDelete")
	@ResponseBody
	public ModelAndView regFullRoomPaymentInfoDelete(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.regFullRoomPaymentInfoDeleteFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regAccDsnPaymentInfoDelete")
	@ResponseBody
	public ModelAndView regAccDsnPaymentInfoDelete(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.regAccDsnPaymentInfoDeleteFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regCashFundPaymentInfoDelete")
	@ResponseBody
	public ModelAndView regCashFundPaymentInfoDelete(HttpServletRequest req, HttpSession sn) {		
		return registryInfoSavingService.regCashFundPaymentInfoDeleteFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantGiftCardPaymentInfo")
	@ResponseBody
	public ModelAndView registrantGiftCardPaymentInfo(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantGiftCardPaymentInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantGiftCardPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView registrantGiftCardPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantGiftCardPaymentPurchaseToGatewayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantGiftCardZeroPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView registrantGiftCardZeroPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return registryInfoSavingService.registrantGiftCardZeroPaymentPurchaseToGatewayRedirection(req, sn);
	}


	
}
