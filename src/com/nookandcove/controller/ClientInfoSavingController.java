package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.ClientInfoSavingService;

@Controller
public class ClientInfoSavingController {
	
	@Autowired
	private ClientInfoSavingService myRoomInfoSavingService;	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientInfoSavingController.class);
		
	@RequestMapping(method = RequestMethod.GET, value = "/getStartedBuss")
	@ResponseBody
	public ModelAndView getStartedBuss(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.startTheBusiness(req, sn);
	}	
		
	@RequestMapping(method = RequestMethod.GET, value = "/signUp")
	@ResponseBody
	public ModelAndView signUp(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.signUpRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/selectedSpace")
	@ResponseBody
	public ModelAndView selectedSpace(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.selectedSpace(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/styleBackMove")
	@ResponseBody
	public ModelAndView styleBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.selStyleBackMove(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/selectedStyle")
	@ResponseBody
	public ModelAndView selectedStyle(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.selectedStyle(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/desnPackageBackMove")
	@ResponseBody
	public ModelAndView desnPackageBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.designPackBackMove(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/selectedDesignPackage")
	@ResponseBody
	public ModelAndView selectedDesignPackage(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.selectedDesignPackage(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/paymentInfoSaving")
	@ResponseBody
	public ModelAndView paymentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.paymentInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/zeroPaymentInfoSaving")
	@ResponseBody
	public ModelAndView zeroPaymentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.zeroPaymentInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/paymentSuccessRed")
	@ResponseBody
	public ModelAndView paymentSuccessRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.paymentInfoSuccessRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/giftCardPayInPackgeRed")
	@ResponseBody
	public ModelAndView giftCardPayInPackgeRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.giftCardPayInPackgeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/promoCodePayInPackgeRed")
	@ResponseBody
	public ModelAndView promoCodePayInPackgeRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.promoCodePayInPackgeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allocateBudget")
	@ResponseBody
	public ModelAndView allocateBudget(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.allocateBudget(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dimensionBackMove")
	@ResponseBody
	public ModelAndView dimensionBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.dimensionBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/roomDimensions")
	@ResponseBody
	public ModelAndView roomDimensions(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.roomDimensions(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/typeOfColorBackMove")
	@ResponseBody
	public ModelAndView typeOfColorBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.typeOfColorBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/feelAboutColorRedirection")
	@ResponseBody
	public ModelAndView feelAboutColorRedirection(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.feelAboutColorRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/needSpaceItemsBackMove")
	@ResponseBody
	public ModelAndView needSpaceItemsBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.needSpaceItemsBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/needSpaceItemsDataSaving")
	@ResponseBody
	public ModelAndView needSpaceItemsDataSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.needSpaceItemsDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/typeOfArtBackMove")
	@ResponseBody
	public ModelAndView typeOfArtBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.typeOfArtBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/typeOfArtDataSaving")
	@ResponseBody
	public ModelAndView typeOfArtDataSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.typeOfArtDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/uploadImagesInDB")
	@ResponseBody
	public ModelAndView uploadImagesInDB(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		LOGGER.debug("uploadImagesInDB...Controller"+fileUpload);
		return myRoomInfoSavingService.moreAboutSpaceUploadImagesInDB(fileUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirMoreAboutSpaceUpImgs")
	@ResponseBody
	public ModelAndView reDirInspireByModSty(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirMoreAboutSpaceUpImgsInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/aboutSpaceImgBackMove")
	@ResponseBody
	public ModelAndView aboutSpaceImgBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.aboutSpaceImgBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteImageFromDBJSON")
	@ResponseBody
	public JSONArray stateFormsAttrFieldNameUpdate(@RequestParam("deleteImage") String deleteImage, HttpSession sn) {
		LOGGER.info("attributeName : "+deleteImage);		
		return myRoomInfoSavingService.deleteImageFromDBUsingJSON(deleteImage, sn);		
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/aboutSpaceDataSaving")
	@ResponseBody
	public ModelAndView aboutSpaceDataSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.aboutSpaceDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirShareInspirationUpImgs")
	@ResponseBody
	public ModelAndView reDirShareInspirationUpImgs(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirShareInspirationUpImgsInDB(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/shareInspImgBackMove")
	@ResponseBody
	public ModelAndView shareInspImgBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.shareInspImgBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shareInspirationUpImg")
	@ResponseBody
	public ModelAndView shareInspirationUpImg(@RequestParam("shareInspImgUpload") MultipartFile shareInspImgUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		LOGGER.debug("shareInspirationUpImg...Controller"+shareInspImgUpload);
		return myRoomInfoSavingService.shareInspirationUpImgInDB(shareInspImgUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shareInspDeleteImgFromDBJSON")
	@ResponseBody
	public JSONArray shareInspDeleteImgFromDBJSON(@RequestParam("deleteImage") String deleteImage, HttpSession sn) {
		LOGGER.info("attributeName : "+deleteImage);		
		return myRoomInfoSavingService.shareInspDeleteImageFromDBUsingJSON(deleteImage, sn);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/shareInspirationDataSaving")
	@ResponseBody
	public ModelAndView shareInspirationDataSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.shareInspirationDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/justAboutFinishedQuestionnaire")
	@ResponseBody
	public ModelAndView justAboutFinishedQuestionnaire(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.justAboutFinishedQuestionnaireSavingInDB(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/myDashBoardRed")
	@ResponseBody
	public ModelAndView myDashBoardRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.myDashBoardRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/clientInfoDisplaySaving")
	@ResponseBody
	public ModelAndView clientInfoDisplaySaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientInfoDisplaySavingRed(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientsInformationDisplay")
	@ResponseBody
	public ModelAndView clientsInformationDisplay(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientsInformationDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/roomManagement")
	@ResponseBody
	public ModelAndView roomManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.roomManagement(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/roomModification")
	@ResponseBody
	public ModelAndView roomModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.roomModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/styleManagement")
	@ResponseBody
	public ModelAndView styleManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.styleManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/styleModification")
	@ResponseBody
	public ModelAndView styleModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.styleModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/budgetManagement")
	@ResponseBody
	public ModelAndView budgetManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.budgetManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/budgetModification")
	@ResponseBody
	public ModelAndView budgetModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.budgetModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dimensionsManagement")
	@ResponseBody
	public ModelAndView dimensionsManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.dimensionsManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dimensionsModification")
	@ResponseBody
	public ModelAndView dimensionsModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.dimensionsModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/colorManagement")
	@ResponseBody
	public ModelAndView colorManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.colorManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/colorModification")
	@ResponseBody
	public ModelAndView colorModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.colorModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureManagement")
	@ResponseBody
	public ModelAndView furnitureManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.furnitureManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureModification")
	@ResponseBody
	public ModelAndView furnitureModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.furnitureModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/artManagement")
	@ResponseBody
	public ModelAndView artManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.artManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/artModification")
	@ResponseBody
	public ModelAndView artModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.artModificationRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/myRoomManagement")
	@ResponseBody
	public ModelAndView myRoomManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.myRoomManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/myRoomModification")
	@ResponseBody
	public ModelAndView myRoomModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.myRoomModificationRed(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modClUploadImagesInDB")
	@ResponseBody
	public ModelAndView modClUploadImagesInDB(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		LOGGER.debug("modClUploadImagesInDB...Controller"+fileUpload);
		return myRoomInfoSavingService.modClMoreAboutSpaceUploadImagesInDB(fileUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirModClMoreAboutSpaceUpImgs")
	@ResponseBody
	public ModelAndView reDirModClMoreAboutSpaceUpImgs(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirModClMoreAboutSpaceUpImgsInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/inspirationManagement")
	@ResponseBody
	public ModelAndView inspirationManagement(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.inspirationManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/inspirationModification")
	@ResponseBody
	public ModelAndView inspirationModification(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.inspirationModificationRed(req, sn);
	}	

	@RequestMapping(method = RequestMethod.POST, value = "/modClShareInspirationUpImg")
	@ResponseBody
	public ModelAndView modClShareInspirationUpImg(@RequestParam("shareInspImgUpload") MultipartFile shareInspImgUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		LOGGER.debug("modClShareInspirationUpImg...Controller"+shareInspImgUpload);
		return myRoomInfoSavingService.modClShareInspirationUpImgInDB(shareInspImgUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirModClShareInspirationUpImgs")
	@ResponseBody
	public ModelAndView reDirModClShareInspirationUpImgs(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirModClShareInspirationUpImgsInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/myRoomInformationRed")
	@ResponseBody
	public ModelAndView myRoomInformationRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.myRoomInformationRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accConcepts")
	@ResponseBody
	public ModelAndView accConcepts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.accConceptsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/conceptsLikeUpdate")
	@ResponseBody
	public JSONArray conceptsLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		LOGGER.debug("conceptsLikeUpdate ...Controller"+status);			
		return myRoomInfoSavingService.conceptsLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/revisedConceptsRequest")
	@ResponseBody
	public ModelAndView revisedConceptsRequest(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.revisedConceptsRequestRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/concept1ViewShopProducts")
	@ResponseBody
	public ModelAndView concept1ViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.concept1ViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/concept2ViewShopProducts")
	@ResponseBody
	public ModelAndView concept2ViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.concept2ViewShopProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/concept1ProductAddToCart")
	@ResponseBody
	public ModelAndView concept1ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirConcept1ProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirConcept1ProductAddToCart")
	@ResponseBody
	public ModelAndView reDirConcept1ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.concept1ProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/concept2ProductAddToCart")
	@ResponseBody
	public ModelAndView concept2ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirConcept2ProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirConcept2ProductAddToCart")
	@ResponseBody
	public ModelAndView reDirConcept2ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.concept2ProductAddToCartRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accFinalConcepts")
	@ResponseBody
	public ModelAndView accFinalConcepts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.accFinalConceptsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finalConceptLikeUpdate")
	@ResponseBody
	public JSONArray finalConceptLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		return myRoomInfoSavingService.finalConceptsLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/finalConceptViewShopProducts")
	@ResponseBody
	public ModelAndView finalConceptViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.finalConceptViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/finalConceptProductAddToCart")
	@ResponseBody
	public ModelAndView finalConceptProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFinalConceptProductAddToCart(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirFinalConceptProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFinalConceptProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.finalConceptProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accShopRedir")
	@ResponseBody
	public ModelAndView accShopRedir(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.accShopRedirRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/finalShopProductAddToCart")
	@ResponseBody
	public ModelAndView finalShopProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirShopFinalProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirShopFinalProductAddToCart")
	@ResponseBody
	public ModelAndView reDirShopFinalProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.shopProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/messageRed")
	@ResponseBody
	public ModelAndView messageRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.messageMyDesigners(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/clientMessageSendToDesigner")
	@ResponseBody
	public ModelAndView clientMessageSendToDesigner(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientMessageSendToDesignerRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirClientAndDesignerMes")
	@ResponseBody
	public ModelAndView reDirClientAndDesignerMes(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientAndDesignerMessageInfoRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fullRmConcepts")
	@ResponseBody
	public ModelAndView fullRmConcepts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmConceptsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRmConceptsLikeUpdate")
	@ResponseBody
	public JSONArray fullRmConceptsLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		LOGGER.debug("fullRmConceptsLikeUpdate ...Controller"+status);			
		return myRoomInfoSavingService.fullRoomConceptsLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/renderingConsRequest")
	@ResponseBody
	public ModelAndView renderingConsRequest(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.renderingConsRequestRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/secRenderingConsRequest")
	@ResponseBody
	public ModelAndView secRenderingConsRequest(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.secRenderingConsRequestRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmRendering")
	@ResponseBody
	public ModelAndView fullRmRendering(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmRenderingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmDesnRenderingReqRevision")
	@ResponseBody
	public ModelAndView fullRmDesnRenderingReqRevision(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmDesnRenderingReqRevisionRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmConcept1ViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmConcept1ViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmConcept1ViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmConcept2ViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmConcept2ViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmConcept2ViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmRenderingViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmRenderingViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmRenderingViewShopProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fullRmDoubleRenderingViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmDoubleRenderingViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmDoubleRenderingViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmSingle2ndRenderingViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmSingle2ndRenderingViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmSingle2ndRenderingViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmDouble2ndRenderingViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmDouble2ndRenderingViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmDouble2ndRenderingViewShopProductsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmSingleRevisedRenderingViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmSingleRevisedRenderingViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmSingleRevisedRenderingViewShopProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fullRmDoubleRevisedRenderingViewShopProducts")
	@ResponseBody
	public ModelAndView fullRmDoubleRevisedRenderingViewShopProducts(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmDoubleRevisedRenderingViewShopProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fullRmConcept1ProductAddToCart")
	@ResponseBody
	public ModelAndView fullRmConcept1ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRmConcept1ProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRmConcept1ProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRmConcept1ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmConcept1ProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmConcept2ProductAddToCart")
	@ResponseBody
	public ModelAndView fullRmConcept2ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRmConcept2ProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRmConcept2ProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRmConcept2ProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmConcept2ProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView fullRmRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRmRenderingProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRmRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRmRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmRenderingProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmRevisedDoubleRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView fullRmRevisedDoubleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRmRevisedDoubleRenderingProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRmRevisedDoubleRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRmRevisedDoubleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmRevisedDoubleRenderingProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRm2ndSingleRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView fullRm2ndSingleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRm2ndSingleRenderingProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRm2ndSingleRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRm2ndSingleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRm2ndSingleRenderingProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRm2ndDoubleRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView fullRm2ndDoubleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRm2ndDoubleRenderingProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRm2ndDoubleRenderingProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRm2ndDoubleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRm2ndDoubleRenderingProductAddToCartRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fullRmShopRedir")
	@ResponseBody
	public ModelAndView fullRmShopRedir(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmShopRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmShopProductAddToCart")
	@ResponseBody
	public ModelAndView fullRmShopProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reDirFullRmShopProductAddToCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRmShopProductAddToCart")
	@ResponseBody
	public ModelAndView reDirFullRmShopProductAddToCart(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmShopProductAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRmSecRendering")
	@ResponseBody
	public ModelAndView fullRmSecRendering(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.fullRmSecRenderingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/secRenderingConsPaymentRed")
	@ResponseBody
	public ModelAndView secRenderingConsPaymentRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.secRenderingConsPaymentRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/secondRenderingPaymentInfoSaving")
	@ResponseBody
	public ModelAndView secondRenderingPaymentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.secondRenderingPaymentInfoSavingInDb(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/zeroSecondRenderingPaymentInfoSaving")
	@ResponseBody
	public ModelAndView zeroSecondRenderingPaymentInfoSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.zeroSecondRenderingPaymentInfoSavingInDb(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/giftCardInfoChecInRendering")
	@ResponseBody
	public ModelAndView giftCardInfoChecInRendering(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.giftCardInfoChecInRenderingRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/paymentCartInfoDisp")
	@ResponseBody
	public ModelAndView paymentCartInfoDisp(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.paymentShoppingCartInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addProductsToCart")
	@ResponseBody
	public JSONArray addProductsToCart(@RequestParam("addClientProductsToCartSavingId") long addClientProductsToCartSavingId, @RequestParam("productCount") String productCount, HttpSession sn) {
		LOGGER.info("addClientProductsToCartSavingId : "+addClientProductsToCartSavingId+"productCount: "+productCount);
		int productsCount = Integer.parseInt(productCount);
		return myRoomInfoSavingService.addSelectedProductsToCart(addClientProductsToCartSavingId, productsCount, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteProductFromCart")
	@ResponseBody
	public JSONArray deleteProductFromCart(@RequestParam("addClientProductsToCartSavingId") long addClientProductsToCartSavingId, HttpSession sn) {
		LOGGER.info("addClientProductsToCartSavingId : "+addClientProductsToCartSavingId);	
		return myRoomInfoSavingService.deleteSelectedProductFromCart(addClientProductsToCartSavingId, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/singleSecRendLikeUpdate")
	@ResponseBody
	public JSONArray singleSecRendLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		return myRoomInfoSavingService.singleSecRendLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/doubleSecRendLikeUpdate")
	@ResponseBody
	public JSONArray doubleSecRendLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		return myRoomInfoSavingService.doubleSecRendLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/doubleRenderingLikeUpdate")
	@ResponseBody
	public JSONArray doubleRenderingLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		return myRoomInfoSavingService.doubleRenderingLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/doubleRevisedRenderingLikeUpdate")
	@ResponseBody
	public JSONArray doubleRevisedRenderingLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		return myRoomInfoSavingService.doubleRevisedRenderingLikeUpdateInDB(status, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/doubleRoomRenderingLikeUpdate")
	@ResponseBody
	public JSONArray doubleRoomRenderingLikeUpdate(@RequestParam("status") String status, HttpSession sn) {
		return myRoomInfoSavingService.doubleRoomRenderingLikeUpdateInDB(status, sn);		
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/changeShippingInfo")
	@ResponseBody
	public ModelAndView changeShippingInfo(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.changeShippingInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/changeBillingInfo")
	@ResponseBody
	public ModelAndView changeBillingInfo(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.changeBillingInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/changeShippingInfoSaving")
	@ResponseBody
	public ModelAndView changeShippingInfoSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.changeShippingInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/changeBillingInfoSaving")
	@ResponseBody
	public ModelAndView changeBillingInfoSaving(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("changeBillingInfoSaving...Controller");
		return myRoomInfoSavingService.changeBillingInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/proceedToCheckout")
	@ResponseBody
	public ModelAndView proceedToCheckout(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.shippingInformationDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shippingInfoSavingInDB")
	@ResponseBody
	public ModelAndView shippingInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.billingInformationDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/paymentReviewBackMove")
	@ResponseBody
	public ModelAndView paymentReviewBackMove(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.paymentReviewBackMoveRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/paymentInfomationSaving")
	@ResponseBody
	public ModelAndView paymentInfomationSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.billingInformationDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/changeAllInfosCloseBut")
	@ResponseBody
	public ModelAndView changeShippingCloseBut(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reviewAndPlaceOrderDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/reviewPlaceOrderDataSaving")
	@ResponseBody
	public ModelAndView reviewPlaceOrderDataSaving(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.reviewPlaceOrderDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cartPaymentGiftCardInfoRed")
	@ResponseBody
	public ModelAndView cartPaymentGiftCardInfoRed(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.cartPaymentGiftCardInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cartPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView cartPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.cartPaymentPurchaseToGatewayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/zeroCartPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView zeroCartPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.zeroCartPaymentPurchaseToGatewayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientMyAccount")
	@ResponseBody
	public ModelAndView clientMyAccount(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientMyAccountRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/clientAccountInfoUpdate")
	@ResponseBody
	public ModelAndView clientAccountInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientAccountInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientPasswordChange")
	@ResponseBody
	public ModelAndView clientPasswordChange(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientPasswordChangeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/clientPasswordInfoUpdate")
	@ResponseBody
	public ModelAndView clientPasswordInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return myRoomInfoSavingService.clientPasswordInfoUpdateInDB(req, sn);
	}
			
}
