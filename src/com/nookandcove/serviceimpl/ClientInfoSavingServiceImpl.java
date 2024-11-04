package com.nookandcove.serviceimpl;

import java.util.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.AddClientProductsToCartSavingDAO;
import com.nookandcove.dao.AdminAssignClientInfoToDesignerSavingDAO;
import com.nookandcove.dao.ClientDesignerMessageInfoSavingDAO;
import com.nookandcove.dao.ClientInfoSavingDAO;
import com.nookandcove.dao.ClientPackageAndRenderingPaymentInfoSavingDAO;
import com.nookandcove.dao.ClientUploadedInspireImagesSavingDAO;
import com.nookandcove.dao.ClientUploadedSpaceImagesSavingDAO;
import com.nookandcove.dao.DesignerInfoSavingDAO;
import com.nookandcove.dao.FurnitureSpecsProductsAccPackSavingDAO;
import com.nookandcove.dao.FurnitureSpecsProductsFullRoomPackSavingDAO;
import com.nookandcove.dao.GiftInfoSavingDAO;
import com.nookandcove.dao.ItemsListForSpaceInfoDAO;
import com.nookandcove.dao.PromoCodeInfoSavingDAO;
import com.nookandcove.dao.ShoppingCartPaymentInfoSavingDAO;
import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.model.AddClientProductsToCartSaving;
import com.nookandcove.model.AdminAssignClientInfoToDesignerSaving;
import com.nookandcove.model.ClientDesignerMessageInfoSaving;
import com.nookandcove.model.ClientInfoSaving;
import com.nookandcove.model.ClientPackageAndRenderingPaymentInfoSaving;
import com.nookandcove.model.ClientUploadedInspireImagesSaving;
import com.nookandcove.model.ClientUploadedSpaceImagesSaving;
import com.nookandcove.model.DesignerInfoSaving;
import com.nookandcove.model.FurnitureSpecsProductsAccPackSaving;
import com.nookandcove.model.FurnitureSpecsProductsFullRoomPackSaving;
import com.nookandcove.model.GiftInfoSaving;
import com.nookandcove.model.ItemsListForSpaceInfo;
import com.nookandcove.model.PromoCodeInfoSaving;
import com.nookandcove.model.ShoppingCartPaymentInfoSaving;
import com.nookandcove.model.UserInformation;
import com.nookandcove.service.ClientInfoSavingService;
import com.nookandcove.service.PaymentGatewayService;
import com.nookandcove.service.UserInformationService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class ClientInfoSavingServiceImpl implements ClientInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientInfoSavingServiceImpl.class);
	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
	private String userIdInSn = "userIdInSn";	
	private String typeOfSpaceInSn = "typeOfSpaceInSn";
	private String typeOfStyleInSn = "typeOfStyleInSn";
	private String packagePriceInSn = "packagePriceInSn";
	private String designPackageInSn = "designPackageInSn";		
	private String typeOfRoomDisplayAL = "typeOfRoomDisplayAL";
	private String typeOfRoomDisplayBL = "typeOfRoomDisplayBL";
	private String selectedBySpaceBL = "selectedBySpaceBL";
	private String selectedBySpaceAL = "selectedBySpaceAL";
	private String selectedByStyleBL = "selectedByStyleBL";
	private String selectedByStyleAL = "selectedByStyleAL";
	private String allocateForBudgetAL = "allocateForBudgetAL";
	private String quesPaymentRedirection = "quesPaymentRedirection";
	private String zeroQuesPaymentRedirection = "zeroQuesPaymentRedirection";
	private String quesPaymentSuccessRedirection = "quesPaymentSuccessRedirection";
	private String dimensionsRedirection = "dimensionsRedirection";
	private String feelAboutColorRedirection = "feelAboutColorRedirection";
	private String needItemsForSpaceRed = "needItemsForSpaceRed";
	private String typeOfArtAppealsRed = "typeOfArtAppealsRed";
	private String moreAboutSpaceUploadImages = "moreAboutSpaceUploadImages";
	private String shareInspirationUploadImages = "shareInspirationUploadImages";	
	private String doneWithQuestionnaireRed = "doneWithQuestionnaireRed";
	private String justAboutFinishedQuestionnaireRed = "justAboutFinishedQuestionnaireRed";	
	private String typeOfSpace = "typeOfSpace";
	private String selectedSpace = "selectedSpace";
	private String typeOfStyle = "typeOfStyle";
	private String selectedStyle = "selectedStyle";
	private String budget = "budget";
	private String allocateBudget = "allocateBudget";
	private String typeOfPackage = "typeOfPackage";
	private String packagePrice = "packagePrice";
	private String packagePriceFm = "packagePriceFm";
	private String typeOfColor = "typeOfColor";
	private String likeColor = "likeColor";
	private String dislikeColor = "dislikeColor";
	private String typeOfItem = "typeOfItem";
	private String otherItem = "otherItem";
	private String alreadyHaveItem = "alreadyHaveItem";
	private String wallArtRef = "wallArtRef";
	private String typeOfArt = "typeOfArt";
	private String moreAboutSpace = "moreAboutSpace";
	private String shareInspiration = "shareInspiration";
	private String clAskedDesignerName = "clAskedDesignerName";
	private String clHearAboutUs = "clHearAboutUs";
	private String spaceDimension = "spaceDimension";
	private String uploadedImgInDB = "uploadedImgInDB";
	private String shUploadedImgInDB = "shUploadedImgInDB";	
	private String spaceDimensionInSN = "spaceDimensionInSN";
	private String typeOfFriendlyInSN = "typeOfFriendlyInSN";
	private String uploadedImgInDBInSN = "uploadedImgInDBInSN";
	private String shUploadedImgInDBInSN = "shUploadedImgInDBInSN";
	private String clientInfoSavingIdInSn = "clientInfoSavingIdInSn";
	private String clientUploadImgId = "clientUploadImgId";
	private String clUploadedImgsCount = "clUploadedImgsCount";
	private String concept1UploadedImage = "concept1UploadedImage";
	private String concept2UploadedImage = "concept2UploadedImage";
	private String messageMyDesigner = "messageMyDesigner";
	private String reDirClientAndDesignerMes = "reDirClientAndDesignerMes";	
	private String desnMessageCountInSN = "desnMessageCountInSN";
	private String desnMessageCount = "desnMessageCount";	
	private String totalCartItemsCountInSN = "totalCartItemsCountInSN";
	private String totalCartItemsCount = "totalCartItemsCount";
	private String typeOfSpaceVal = "typeOfSpaceVal";
	private String typeOfStyleVal = "typeOfStyleVal";
	private String desMessage = "desMessage";
	private String wallArtRefInSN = "wallArtRefInSN";
	private String dimension = "dimension";
	private String itemWallArtInSN = "itemWallArtInSN";
	private String itemWallArtValue = "itemWallArtValue";	
	private String desnUpPhotoInSn = "desnUpPhotoInSn";
	private String designerProfileImage = "designerProfileImage";
	private String roomsInformationModification = "roomsInformationModification";
	private String selectedRoomInSn = "selectedRoomInSn";	
	private String roomModification = "roomModification";
	private String styleModification = "styleModification";
	private String budgetModification = "budgetModification";
	private String dimensionsModification = "dimensionsModification";
	private String colorModification = "colorModification";
	private String furnitureModification = "furnitureModification";
	private String artModification = "artModification";
	private String myRoomModification = "myRoomModification";
	private String inspirationModification = "inspirationModification";
	private String roomManagement = "roomManagement";
	private String styleManagement = "styleManagement";
	private String budgetManagement = "budgetManagement";
	private String dimensionsManagement = "dimensionsManagement";
	private String colorManagement = "colorManagement";
	private String furnitureManagement = "furnitureManagement";
	private String artManagement = "artManagement";
	private String myRoomManagement = "myRoomManagement";
	private String inspirationManagement = "inspirationManagement";	
	private String myShoppingCartDisplay = "myShoppingCartDisplay";
	private String shippingInfoDisplay = "shippingInfoDisplay";
	private String billingInfoDisplay = "billingInfoDisplay";
	private String reviewAndPlaceOrder = "reviewAndPlaceOrder";
	private String changeShippingInfo = "changeShippingInfo";
	private String changeBillingInfo = "changeBillingInfo";
	private String alreadyHaveAccInSn = "alreadyHaveAccInSn";
	private String typeOfDesignPackInSN = "typeOfDesignPackInSN";
	private String typeOfDesignPack = "typeOfDesignPack";	
	private String accDesnPackConceptsTextRed = "accDesnPackConceptsTextRed";
	private String accDesnPackConceptsRed = "accDesnPackConceptsRed";
	private String reverseConceptsRed = "reverseConceptsRed";
	private String accDesnPackFinalConceptsTextRed = "accDesnPackFinalConceptsTextRed";
	private String accDesnPackFinalConceptsRed = "accDesnPackFinalConceptsRed";
	private String designerInfoSavingIdInSn = "designerInfoSavingIdInSn";
	private String accDesnPackShopTheLookTextRed = "accDesnPackShopTheLookTextRed";
	private String concept1ViewShopProducts = "concept1ViewShopProducts";
	private String concept2ViewShopProducts = "concept2ViewShopProducts";
	private String finalConceptViewShopProducts = "finalConceptViewShopProducts";
	private String finalViewShopProducts = "finalViewShopProducts";
	private String popUpRefName = "popUpRefName";
	private String noOfProduct = "noOfProduct";
	private String popUpRefNameInSn = "popUpRefNameInSn";
	private String noOfProductInSn = "noOfProductInSn";	
	private String viewProductImagesList = "viewProductImagesList";
	private String viewProductNamesList = "viewProductNamesList";
	private String viewProductQuantityList = "viewProductQuantityList";
	private String viewProductPriceList = "viewProductPriceList";
	private String viewProductDescriptionList = "viewProductDescriptionList";
	private String viewAssemblyRequiredStatusList = "viewAssemblyRequiredStatusList";
	private String viewProductsIdList = "viewProductsIdList";
	private String totalProductsAmountInSn = "totalProductsAmountInSn";
	private String totalProductsAmount = "totalProductsAmount";	
	private String shipFullName = "shipFullName";
	private String shipAddress1 = "shipAddress1";
	private String shipAddress2 = "shipAddress2";
	private String shipCity = "shipCity";
	private String shipState = "shipState";
	private String shipZip = "shipZip";
	private String shipCountry = "shipCountry";
	private String shipPhNumber = "shipPhNumber";	
	private String payCardNumber = "payCardNumber";
	private String payExpMonth = "payExpMonth";
	private String payExpYear = "payExpYear";
	private String payCvvNumber = "payCvvNumber";
	private String nameOnCard = "nameOnCard";
	private String typeOfCard = "typeOfCard";
	private String billFullName = "billFullName";
	private String billAddress1 = "billAddress1";
	private String billAddress2 = "billAddress2";
	private String billCity = "billCity";
	private String billState = "billState";
	private String billZip = "billZip";
	private String billCountry = "billCountry";
	private String billPhNumber = "billPhNumber";
	private String promoCodePrice = "promoCodePrice";
	private String giftCardPrice = "giftCardPrice";
	private String giftCardStatus = "giftCardStatus";
	private String promoStatus = "promoStatus";
	private String payPromoCode = "payPromoCode";
	private String payGiftCard = "payGiftCard";
	private String remGiftCardPrice = "remGiftCardPrice";
	private String totalPaybleAmount = "totalPaybleAmount";
	private String fullRoomDesnPackConceptsTextRed = "fullRoomDesnPackConceptsTextRed";
	private String fullRoomPackConceptsRed = "fullRoomPackConceptsRed";
	private String fullRoomRenderingPleaseRed = "fullRoomRenderingPleaseRed";
	private String fullRoomSecRenderingTextRed = "fullRoomSecRenderingTextRed";
	private String fullRoomSecRenderingPaymentRed = "fullRoomSecRenderingPaymentRed";
	private String zeroFullRoomSecRenderingPaymentRed = "zeroFullRoomSecRenderingPaymentRed";
	private String fullRoomSecRenderingPaymentSuccessRed = "fullRoomSecRenderingPaymentSuccessRed";
	private String fullRoomDesPackRenderingTextRed = "fullRoomDesPackRenderingTextRed";
	private String fullRoomDesPackSingleRenderingInfoRed = "fullRoomDesPackSingleRenderingInfoRed";
	private String fullRoomDesPackDoubleRenderingInfoRed = "fullRoomDesPackDoubleRenderingInfoRed";
	private String fullRoomDesPackSingleRenderingInfoDisplayRed = "fullRoomDesPackSingleRenderingInfoDisplayRed";
	private String fullRoomDesPackDoubleRenderingInfoDisplayRed = "fullRoomDesPackDoubleRenderingInfoDisplayRed";
	private String fullRoomDesPackSingleRenderingReqRevisionRed = "fullRoomDesPackSingleRenderingReqRevisionRed";
	private String fullRoomDesPackDoubleRenderingReqRevisionRed = "fullRoomDesPackDoubleRenderingReqRevisionRed";
	private String fullRoomSingle2ndRenderingViewShopProducts = "fullRoomSingle2ndRenderingViewShopProducts";
	private String fullRoomDouble2ndRenderingViewShopProducts = "fullRoomDouble2ndRenderingViewShopProducts";	
	private String fullRoomConcept1ViewShopProducts = "fullRoomConcept1ViewShopProducts";
	private String fullRoomConcept2ViewShopProducts = "fullRoomConcept2ViewShopProducts";
	private String fullRoomRenderingViewProducts = "fullRoomRenderingViewProducts";
	private String fullRoomDoubleRenderingViewShopProducts = "fullRoomDoubleRenderingViewShopProducts";
	private String fullRoomDoubleRevisedRenderingViewShopProducts = "fullRoomDoubleRevisedRenderingViewShopProducts";
	private String fullRoomSingleRevisedRenderingViewShopProducts = "fullRoomSingleRevisedRenderingViewShopProducts";
	private String fullRoomConceptViewShopProducts = "fullRoomConceptViewShopProducts";
	private String fullRoomRenderingViewShopProducts = "fullRoomRenderingViewShopProducts";
	private String fullRoomReviseRenderingViewShopProducts = "fullRoomReviseRenderingViewShopProducts";
	private String fullRoom2ndRenderingViewShopProducts = "fullRoom2ndRenderingViewShopProducts";
	private String fullRmDesnPackShopTheLookTextRed = "fullRmDesnPackShopTheLookTextRed";	
	private String fullRmDesnSingleSecondRenderingConcepts = "fullRmDesnSingleSecondRenderingConcepts";	
	private String fullRmDesnDoubleSecondRenderingConcepts = "fullRmDesnDoubleSecondRenderingConcepts";
	private String conceptStatus = "conceptStatus";
	private String renderingStatus = "renderingStatus";
	private String secondRenderingStatus = "secondRenderingStatus";
	private String revisedRenderingStatus = "revisedRenderingStatus";
	private String conceptStatusInSn = "conceptStatusInSn";
	private String renderingStatusInSn = "renderingStatusInSn";
	private String secondRenderingStatusInSn = "secondRenderingStatusInSn";
	private String revisedRenderingStatusInSn = "revisedRenderingStatusInSn";
	private String totalProdPriceInDB = "totalProdPriceInDB";
	private String likeImagesValues = "likeImagesValues";	
	private String desnProfileBioInSn = "desnProfileBioInSn";
	private String desnLocationInSn = "desnLocationInSn";
	private String desnProfileBio = "desnProfileBio";
	private String desnLocation = "desnLocation";
	private String desnFullNameInSn = "desnFullNameInSn";
	private String desnFullName = "desnFullName";
	private String checkBoxStatus = "checkBoxStatus";
	private String reviewOrderStatus = "reviewOrderStatus";
	private String finishedReviewPlaceOrder = "finishedReviewPlaceOrder";
	private String totalCheckoutAmountInSn = "totalCheckoutAmountInSn";
	private String cartPaymentInfoForYesDisplay = "cartPaymentInfoForYesDisplay";
	private String zeroCartPaymentInfoForYesDisplay = "zeroCartPaymentInfoForYesDisplay";
	private String cartPaymentInfoForNoDisplay = "cartPaymentInfoForNoDisplay";	
	private String apiLoginId = "apiLoginId";
	private String transactionKey = "transactionKey";
	private String amount = "amount";
	private String paymentReturnStatus = "paymentReturnStatus";
	private String paymentValStatus = "paymentValStatus";
	private String returnTypeInSn = "returnTypeInSn";
	private String paymentInfoSavingIdInSn = "paymentInfoSavingIdInSn";
	private String giftCuponCode = "giftCuponCode";
	private String secRenderPrice = "secRenderPrice";
	private String secRenderingAmount = "secRenderingAmount";
	private String catGCAmountInSn = "catGCAmountInSn";
	private String desnUserIdRef = "desnUserIdRef";
	private String clientContactInfoEdit = "clientContactInfoEdit";
	private String clientFirstName = "clientFirstName";
	private String clientLastName = "clientLastName";
	private String clientUserEmail = "clientUserEmail";
	private String clientPasswordEdit = "clientPasswordEdit";
	private String clientErrorPage = "clientErrorPage";
	private String clientSuccPage = "clientSuccPage";	
	private String uploadImgPath = "/var/www/html/data/nookandcoveimages/";
		    
    @Autowired
    private ClientInfoSavingDAO clientInfoSavingDAO;
    
    @Autowired
    private DesignerInfoSavingDAO designerInfoSavingDAO;
    
    @Autowired
    private UserInformationService userInformationService;
    
    @Autowired
    private UserInformationDAO userInformationDAO;
    
    @Autowired
    private ClientUploadedSpaceImagesSavingDAO clientUploadedSpaceImagesSavingDAO;
    
    @Autowired
    private ClientUploadedInspireImagesSavingDAO clientUploadedInspireImagesSavingDAO;
    
    @Autowired
    private AdminAssignClientInfoToDesignerSavingDAO adminAssignClientInfoToDesignerSavingDAO;
    
    @Autowired
    private FurnitureSpecsProductsAccPackSavingDAO furnitureSpecsProductsAccPackSavingDAO;

    @Autowired
    private FurnitureSpecsProductsFullRoomPackSavingDAO furnitureSpecsProductsFullRoomPackSavingDAO;
    
    @Autowired
    private ClientDesignerMessageInfoSavingDAO clientDesignerMessageInfoSavingDAO;
    
    @Autowired
    private AddClientProductsToCartSavingDAO addClientProductsToCartSavingDAO;

    @Autowired
    private ItemsListForSpaceInfoDAO itemsListForSpaceInfoDAO;

    @Autowired
    private ShoppingCartPaymentInfoSavingDAO shoppingCartPaymentInfoSavingDAO;

    @Autowired
    private GiftInfoSavingDAO giftInfoSavingDAO;

    @Autowired
    private PromoCodeInfoSavingDAO promoCodeInfoSavingDAO;

    @Autowired
    private PaymentGatewayService paymentGatewayService;    

    @Autowired
    private ClientPackageAndRenderingPaymentInfoSavingDAO clientPackageAndRenderingPaymentInfoSavingDAO;
    
    @Override
    @Transactional
    public ModelAndView startTheBusiness(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {        	
        	mav = new ModelAndView(typeOfRoomDisplayAL);
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        	sn.setAttribute(typeOfSpaceInSn, null);
            sn.setAttribute(typeOfStyleInSn, null);
            sn.setAttribute(alreadyHaveAccInSn, null);            
        	sn.setAttribute(packagePriceInSn, null);
        	sn.setAttribute(designPackageInSn, null);
        	sn.setAttribute(clientInfoSavingIdInSn, null);
        } else{        	
        	mav = new ModelAndView(typeOfRoomDisplayBL);
        }
        sn.setAttribute(alreadyHaveAccInSn, null);
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView signUpRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {        	
        	mav = new ModelAndView(typeOfRoomDisplayAL);
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        	sn.setAttribute(spaceDimensionInSN, null);
        	sn.setAttribute(typeOfFriendlyInSN, null);
        	sn.setAttribute(uploadedImgInDBInSN, null);
        	sn.setAttribute(shUploadedImgInDBInSN, null);
        	sn.setAttribute(wallArtRefInSN, null);
        } else{        	
        	mav = new ModelAndView(typeOfRoomDisplayBL);
        }
        mav.addObject("signUpStatus", "SignUp Page");
        sn.setAttribute(alreadyHaveAccInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedSpace(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {       	           
        	mav = new ModelAndView(selectedBySpaceAL);
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));        	
        } else{
        	mav = new ModelAndView(selectedBySpaceBL);
        }        
        mav.addObject(selectedSpace, req.getParameter(typeOfSpace));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selStyleBackMove(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	if(null != sn.getAttribute(userIdInSn)) {
	    	mav = new ModelAndView(typeOfRoomDisplayAL);
	    	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	} else{    		
    		mav = new ModelAndView(typeOfRoomDisplayBL);    		    		
    	}    	
    	mav.addObject(selectedSpace, req.getParameter(typeOfSpace));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedStyle(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;         
        if(null != sn.getAttribute(userIdInSn)) {
        	mav = new ModelAndView(selectedByStyleAL);
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
        	mav = new ModelAndView(selectedByStyleBL);
        }        
    	mav.addObject(selectedSpace, req.getParameter(typeOfSpace));
    	mav.addObject(selectedStyle, req.getParameter(typeOfStyle));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designPackBackMove(HttpServletRequest req, HttpSession sn) {
     	ModelAndView mav;     	
     	if(null != sn.getAttribute(userIdInSn)) {
     		mav = new ModelAndView(selectedBySpaceAL);
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{        	
        	mav = new ModelAndView(selectedBySpaceBL);
        }     	
     	mav.addObject(selectedSpace, req.getParameter(typeOfSpace));
    	mav.addObject(selectedStyle, req.getParameter(typeOfStyle));
     	return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedDesignPackage(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	sn.setAttribute(typeOfSpaceInSn, req.getParameter(typeOfSpace));
    	sn.setAttribute(typeOfStyleInSn, req.getParameter(typeOfStyle));
    	sn.setAttribute(packagePriceInSn, req.getParameter(packagePrice));
    	sn.setAttribute(designPackageInSn, req.getParameter(typeOfPackage));    	
        if(null != sn.getAttribute(userIdInSn)) {        	
        	mav = new ModelAndView(quesPaymentRedirection);            
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        	mav.addObject(packagePrice, sn.getAttribute(packagePriceInSn));
        	String packPriceFormate = String.format("%.2f", Double.parseDouble((String) sn.getAttribute(packagePriceInSn)));
            mav.addObject(packagePriceFm, packPriceFormate);
        	sn.setAttribute(totalCheckoutAmountInSn, sn.getAttribute(packagePriceInSn));
        } else{        	
        	mav = userInformationService.registrationRedirection(req, sn);        	
        }
        sn.setAttribute(returnTypeInSn, null);
        sn.setAttribute(paymentInfoSavingIdInSn, null);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView paymentInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;        
    	if(null != sn.getAttribute(userIdInSn)) {
    		List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingRoomName((Long) sn.getAttribute(userIdInSn), (String) sn.getAttribute(typeOfSpaceInSn));
        	Timestamp currentDate = currentDate();
        	if(selectedRowIdList.isEmpty()){         		
        		ClientInfoSaving mriModel = new ClientInfoSaving();
                mriModel.setUserId((Long) sn.getAttribute(userIdInSn));
    	        mriModel.setTypeOfSpace((String) sn.getAttribute(typeOfSpaceInSn));
    	        mriModel.setTypeOfStyle((String) sn.getAttribute(typeOfStyleInSn));
    	        mriModel.setPackagePrice((String) sn.getAttribute(packagePriceInSn));
    	        mriModel.setDesignPackage((String) sn.getAttribute(designPackageInSn));    	        
    	        mriModel.setCreatedDate(currentDate);
    	        clientInfoSavingDAO.save(mriModel);
    	        long clientInfoSavingId = mriModel.getClientInfoSavingId();    	        
    	        sn.setAttribute(clientInfoSavingIdInSn, clientInfoSavingId);    	        
        	} else {        		
        		ClientInfoSaving clientInfoSavingModel = clientInfoSavingDAO.rowIdUpdationUsingRoomName((Long) sn.getAttribute(userIdInSn), (String) sn.getAttribute(typeOfSpaceInSn));
        		clientInfoSavingModel.setTypeOfSpace((String) sn.getAttribute(typeOfSpaceInSn));
        		clientInfoSavingModel.setTypeOfStyle((String) sn.getAttribute(typeOfStyleInSn));
        		clientInfoSavingModel.setPackagePrice((String) sn.getAttribute(packagePriceInSn));
        		clientInfoSavingModel.setDesignPackage((String) sn.getAttribute(designPackageInSn));        		
        		clientInfoSavingModel.setUpdatedDate(currentDate);
        		clientInfoSavingDAO.merge(clientInfoSavingModel);
        		long clientInfoSavingId1 = clientInfoSavingModel.getClientInfoSavingId();
        		sn.setAttribute(clientInfoSavingIdInSn, clientInfoSavingId1);
        	}
        	double remGiftAmount = 0;
        	if("" != req.getParameter(remGiftCardPrice)) {
        		remGiftAmount = Double.parseDouble(req.getParameter(remGiftCardPrice));
        	}
        	long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
        	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear) ;
            Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
            String apiLoginId1 = req.getParameter(apiLoginId);
            String transactionKey1 = req.getParameter(transactionKey);
            String totalPableAmt = req.getParameter(amount);
	        	mav = paymentGatewayService.packagePaymentGatewayRedirectionDisplay(req, sn, cardNumber, expirationDate, cardCode, apiLoginId1, transactionKey1, totalPableAmt, req.getParameter(nameOnCard), (String) sn.getAttribute(packagePriceInSn), req.getParameter(giftCardPrice), req.getParameter(promoCodePrice));
	        	String returnVal = (String) sn.getAttribute(returnTypeInSn);	        	
	        	if(("This transaction has been approved.").equals(returnVal)) {
	        		ClientInfoSaving clientInfoSavingModel = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	        		clientInfoSavingModel.setPaymentStatus(returnVal);
	        		clientInfoSavingModel.setPaymentInfoSavingId((Long) sn.getAttribute(paymentInfoSavingIdInSn));
	        		clientInfoSavingModel.setStatus("Done");
	        		clientInfoSavingDAO.merge(clientInfoSavingModel);
		        	List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(req.getParameter(giftCuponCode));
		            if(!giftInfoSavingList.isEmpty()){
		            	GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(req.getParameter(giftCuponCode));
		            	if(0 == remGiftAmount) {
		            		giftInfoSavingModel.setUsedGiftStatus("USED");
		            	}
		            	mav = giftCardPurchasedEmailSendToClient(req, sn);
		            	giftInfoSavingModel.setRemainingGiftPrice(req.getParameter(remGiftCardPrice));
		            	giftInfoSavingDAO.merge(giftInfoSavingModel);
		            }		           
		            mav = questionnerFullAndAccPackageEmailForClient(req, sn);
		            mav = questionnerFullAndAccPackageEmailForAdmin(req, sn);
		        	mav = new ModelAndView(quesPaymentSuccessRedirection);
		        	sn.setAttribute(returnTypeInSn, null);
		        	sn.setAttribute(paymentInfoSavingIdInSn, null);
	        	} else {
	        		sn.setAttribute(totalCheckoutAmountInSn, sn.getAttribute(packagePriceInSn));
	        		mav = new ModelAndView(quesPaymentRedirection);            
	            	mav.addObject(packagePrice, sn.getAttribute(packagePriceInSn));
	            	mav.addObject(paymentValStatus, "Payment Fail");
	            	mav.addObject(paymentReturnStatus, returnVal);
	            	String packPriceFormate = String.format("%.2f", Double.parseDouble((String) sn.getAttribute(packagePriceInSn)));
	            	mav.addObject(giftCardPrice, req.getParameter(giftCardPrice));
	                mav.addObject(remGiftCardPrice, req.getParameter(remGiftCardPrice));
	                mav.addObject(totalPaybleAmount, req.getParameter(amount));
	                mav.addObject(packagePriceFm, packPriceFormate);
	                mav.addObject(giftCuponCode, req.getParameter(giftCuponCode));
	                mav.addObject(promoCodePrice, req.getParameter(promoCodePrice));        
	                mav.addObject(payCardNumber, req.getParameter(payCardNumber));
	                mav.addObject(payExpMonth, req.getParameter(payExpMonth));
	                mav.addObject(payExpYear, req.getParameter(payExpYear));
	                mav.addObject(nameOnCard, req.getParameter(nameOnCard));
	                mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
	                sn.setAttribute(totalCheckoutAmountInSn, req.getParameter(amount));
	        	}
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
        	mav = startTheBusiness(req, sn);
        }    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView zeroPaymentInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;        
    	if(null != sn.getAttribute(userIdInSn)) {
    		List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingRoomName((Long) sn.getAttribute(userIdInSn), (String) sn.getAttribute(typeOfSpaceInSn));
        	Timestamp currentDate = currentDate();
        	if(selectedRowIdList.isEmpty()){         		
        		ClientInfoSaving mriModel = new ClientInfoSaving();
                mriModel.setUserId((Long) sn.getAttribute(userIdInSn));
    	        mriModel.setTypeOfSpace((String) sn.getAttribute(typeOfSpaceInSn));
    	        mriModel.setTypeOfStyle((String) sn.getAttribute(typeOfStyleInSn));
    	        mriModel.setPackagePrice((String) sn.getAttribute(packagePriceInSn));
    	        mriModel.setDesignPackage((String) sn.getAttribute(designPackageInSn));    	        
    	        mriModel.setCreatedDate(currentDate);
    	        clientInfoSavingDAO.save(mriModel);
    	        long clientInfoSavingId = mriModel.getClientInfoSavingId();    	        
    	        sn.setAttribute(clientInfoSavingIdInSn, clientInfoSavingId);    	        
        	} else {        		
        		ClientInfoSaving clientInfoSavingModel = clientInfoSavingDAO.rowIdUpdationUsingRoomName((Long) sn.getAttribute(userIdInSn), (String) sn.getAttribute(typeOfSpaceInSn));
        		clientInfoSavingModel.setTypeOfSpace((String) sn.getAttribute(typeOfSpaceInSn));
        		clientInfoSavingModel.setTypeOfStyle((String) sn.getAttribute(typeOfStyleInSn));
        		clientInfoSavingModel.setPackagePrice((String) sn.getAttribute(packagePriceInSn));
        		clientInfoSavingModel.setDesignPackage((String) sn.getAttribute(designPackageInSn));        		
        		clientInfoSavingModel.setUpdatedDate(currentDate);
        		clientInfoSavingDAO.merge(clientInfoSavingModel);
        		long clientInfoSavingId1 = clientInfoSavingModel.getClientInfoSavingId();
        		sn.setAttribute(clientInfoSavingIdInSn, clientInfoSavingId1);
        	}
        	double remGiftAmount = 0;
        	if("" != req.getParameter(remGiftCardPrice)) {
        		remGiftAmount = Double.parseDouble(req.getParameter(remGiftCardPrice));
        	}        	
            String totalPableAmt = req.getParameter(amount);            
            mav = zeroPackageCheckoutPaymentDisplay(req, sn, totalPableAmt, (String) sn.getAttribute(packagePriceInSn), req.getParameter(giftCardPrice), req.getParameter(promoCodePrice), req.getParameter(giftCuponCode), req.getParameter(remGiftCardPrice), remGiftAmount);
         	mav = new ModelAndView(quesPaymentSuccessRedirection);            
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
        	mav = startTheBusiness(req, sn);
        }    	
    	return mav;
    }

    @Override 
    @Transactional
    public ModelAndView zeroPackageCheckoutPaymentDisplay(HttpServletRequest req, HttpSession sn, String amount, String totalAmount, String giftAmount, String promoCodePrice, String giftCuponCode, String remGiftCardPrice, double remGiftAmount) {
    	ModelAndView mav;
 	   	List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(giftCuponCode);
 	   	String accountType = null;
 	   	String authorizationCode = null;
 	   	long transactionNumber = 0; 	   	
 	   	String cardNumber = null;
 	   	String expirationDate = null;
 	   	String nameOnCard = null; 	   
 	   	if(!giftInfoSavingList.isEmpty()){
 	   		GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(giftCuponCode);
 	   		if(0 == remGiftAmount) {
 	   			giftInfoSavingModel.setUsedGiftStatus("USED");
 	   		}
 	   		giftInfoSavingModel.setRemainingGiftPrice(remGiftCardPrice);
 	   		giftInfoSavingDAO.merge(giftInfoSavingModel);
 	   		mav = giftCardPurchasedEmailSendToClient(req, sn);
 	   	}     
 	   	mav = questionnerFullAndAccPackageEmailForClient(req, sn);
 	   	mav = questionnerFullAndAccPackageEmailForAdmin(req, sn);      
 	   	Timestamp currentDate = currentDate(); 
 	   	ClientPackageAndRenderingPaymentInfoSaving clPackAndSecRendModel = new ClientPackageAndRenderingPaymentInfoSaving();
 	   	clPackAndSecRendModel.setUserId((Long) sn.getAttribute(userIdInSn));
 	   	clPackAndSecRendModel.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
 	   	clPackAndSecRendModel.setPayCardNumber(cardNumber);
 	   	clPackAndSecRendModel.setAccountType(accountType);
 	   	clPackAndSecRendModel.setPayExpDate(expirationDate);
 	   	clPackAndSecRendModel.setPayCvvNumber("****");
 	   	clPackAndSecRendModel.setPaymentStatus("This transaction has been approved.");
 	   	clPackAndSecRendModel.setNameOnCard(nameOnCard);
 	   	clPackAndSecRendModel.setEstimatedAmount(totalAmount);
 	   	clPackAndSecRendModel.setGiftAmount(giftAmount);
 	   	clPackAndSecRendModel.setPromoAmount(promoCodePrice);
 	   	clPackAndSecRendModel.setAuthorizationCode(authorizationCode);
 	   	clPackAndSecRendModel.setTransactionNumber(transactionNumber);
 	   	clPackAndSecRendModel.setTypeOfPayment("Package Payment");
 	   	clPackAndSecRendModel.setTotalPaybleAmount(amount);
 	   	clPackAndSecRendModel.setCreatedDate(currentDate);
 	   	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
 	   	clPackAndSecRendModel.setCreatedDateInSt(todayDate);
 	   	clientPackageAndRenderingPaymentInfoSavingDAO.save(clPackAndSecRendModel);
 	   	long paymentInfoSavingId = clPackAndSecRendModel.getClientPackageAndRenderingPaymentInfoSavingId();
 	   	ClientInfoSaving clientInfoSavingModel = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
 	   	clientInfoSavingModel.setPaymentStatus("This transaction has been approved.");
 	   	clientInfoSavingModel.setPaymentInfoSavingId(paymentInfoSavingId);
 	   	clientInfoSavingModel.setStatus("Done");
 	   	clientInfoSavingDAO.merge(clientInfoSavingModel);  
 	   	mav = new ModelAndView();      
 	  	return mav;
    }

    @Override
    @Transactional
    public ModelAndView paymentInfoSuccessRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;        
    	if(null != sn.getAttribute(userIdInSn)) {    		
    		mav = new ModelAndView(allocateForBudgetAL);
		    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
        	mav = startTheBusiness(req, sn);
        }    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView giftCardPayInPackgeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav; 	   	
 	   	String giftCdPrice = null;
 	   	String giftCdStatus = null; 	   	
 	   	double giftCardPriceInDB = 0;
	   	double promoPriceInDB = 0;
	   	double packagePriceInDB = 0;
	   	double totalPableAmount = 0;
	   	double remGiftPrice = 0;
	   	double giftAmountInDB = 0;
 	    String totPableAmt = null;
 	    String remGiftAmt = null;
 	    String giftAmount = null;
 	    String gcCuponCode = null; 	     	   	
 	    String disCountPrice = req.getParameter(promoCodePrice);
 	    String packPrice = (String) sn.getAttribute(packagePriceInSn); 	    
 	    if ("" != disCountPrice) {
 	    	promoPriceInDB = Double.parseDouble(disCountPrice);
 	    }
 	    if (null != packPrice) {
 	    	packagePriceInDB = Double.parseDouble(packPrice);
 	    }
 	    double promoPackPrice = packagePriceInDB - promoPriceInDB;
 	    String packPriceFormate = String.format("%.2f", packagePriceInDB); 	   
 	   	List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(req.getParameter(payGiftCard));
        if(!giftInfoSavingList.isEmpty()){
        	GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(req.getParameter(payGiftCard));
        	giftCdPrice = giftInfoSavingModel.getRemainingGiftPrice();
        	gcCuponCode = req.getParameter(payGiftCard);        	
            if (null != giftCdPrice) {
            	giftCardPriceInDB = Double.parseDouble(giftCdPrice);
            }                                    
            if(giftCardPriceInDB >= promoPackPrice) {            	
            	remGiftPrice = giftCardPriceInDB - promoPackPrice;
            	totalPableAmount = 0;
            	giftAmountInDB = promoPackPrice;
            } else if(promoPackPrice > giftCardPriceInDB) {
            	totalPableAmount = promoPackPrice - giftCardPriceInDB;
            	giftAmountInDB = giftCardPriceInDB;
            	remGiftPrice = 0;
            }            
            totPableAmt = String.format("%.2f", totalPableAmount);
            remGiftAmt = String.format("%.2f", remGiftPrice);
            giftAmount = String.format("%.2f", giftAmountInDB);
        } else {
        	giftCdStatus = "Wrong Code";
     	   	totPableAmt = String.format("%.2f", promoPackPrice);
        }
        if(("0.00").equals(totPableAmt)) {
 	    	mav = new ModelAndView(zeroQuesPaymentRedirection);
 	    } else {
 	    	mav = new ModelAndView(quesPaymentRedirection);
 	    }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        sn.setAttribute(totalCheckoutAmountInSn, totPableAmt);
        mav.addObject(giftCardStatus, giftCdStatus);
        mav.addObject(giftCardPrice, giftAmount);
        mav.addObject(remGiftCardPrice, remGiftAmt);
        mav.addObject(totalPaybleAmount, totPableAmt);
        mav.addObject(packagePrice, packPrice);
        mav.addObject(packagePriceFm, packPriceFormate);
        mav.addObject(giftCuponCode, gcCuponCode);
        mav.addObject(promoCodePrice, disCountPrice);        
        mav.addObject(payCardNumber, req.getParameter(payCardNumber));
        mav.addObject(payExpMonth, req.getParameter(payExpMonth));
        mav.addObject(payExpYear, req.getParameter(payExpYear));
        mav.addObject(nameOnCard, req.getParameter(nameOnCard));
        mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView promoCodePayInPackgeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav; 	   
 	    String disCountPrice = null;
 	    String disCount = null;
 	    String promoStatus1 = null;
 	    double packagePriceInDB = 0;
 	    double giftCardPriceInDB = 0; 	    
	   	double totalPableAmount = 0;
	   	double remGiftPrice = 0;
	   	double giftAmountInDB = 0;
	    String totPableAmt = null;
	    String remGiftAmt = null;
	    String giftAmount = null;
	    String giftCdPrice = null;
 	   	String packPrice = (String) sn.getAttribute(packagePriceInSn);
 	    if (null != packPrice) {
 	      	packagePriceInDB = Double.parseDouble(packPrice);
 	 	}
 	    List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(req.getParameter(giftCuponCode));
 	    if(!giftInfoSavingList.isEmpty()){
	       	GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(req.getParameter(giftCuponCode));
	       	giftCdPrice = giftInfoSavingModel.getRemainingGiftPrice();	       	
	       	if (null != giftCdPrice) {
	       		giftCardPriceInDB = Double.parseDouble(giftCdPrice);
	       	}           
 	    } 	   
 	    String packPriceFormate = String.format("%.2f", packagePriceInDB);
 	    List<PromoCodeInfoSaving> promoCodeInfoSavingList = promoCodeInfoSavingDAO.selectedPromoCodeChecking(req.getParameter(payPromoCode));
 	    if(!promoCodeInfoSavingList.isEmpty()){
 	    	PromoCodeInfoSaving promoCodeInfoSavingModel = promoCodeInfoSavingDAO.selectedPromoCodeUpdateInDB(req.getParameter(payPromoCode));
 	    	disCount = promoCodeInfoSavingModel.getDiscount(); 	    	   
	 	    if (null != disCount) {         		
	 	    	int disCountAmount = Integer.parseInt(disCount); 	    	
	 	    	double withDisCountAmount = packagePriceInDB*((double)disCountAmount)*0.01;
	 	    	double promoPackPrice = packagePriceInDB - withDisCountAmount;
	 	    	disCountPrice = String.format("%.2f", withDisCountAmount);		    	
	 	    	if(giftCardPriceInDB > promoPackPrice) {            	
	 	    		remGiftPrice = giftCardPriceInDB - promoPackPrice;
	 	           	totalPableAmount = 0;
	 	           	giftAmountInDB = promoPackPrice;
	 	    	} else if(promoPackPrice > giftCardPriceInDB) {
	 	           	totalPableAmount = promoPackPrice - giftCardPriceInDB;
	 	           	giftAmountInDB = giftCardPriceInDB;
	 	           	remGiftPrice = 0;
	 	    	}
	 	    	totPableAmt = String.format("%.2f", totalPableAmount);
	            remGiftAmt = String.format("%.2f", remGiftPrice);
	            giftAmount = String.format("%.2f", giftAmountInDB);
	 	    } 
 	    } else {
 	    	promoStatus1 = "Wrong Code";
 	    	if(giftCardPriceInDB > packagePriceInDB) {            	
 	           	remGiftPrice = giftCardPriceInDB - packagePriceInDB;
 	           	totalPableAmount = 0;
 	           	giftAmountInDB = packagePriceInDB;
 	    	} else if(packagePriceInDB > giftCardPriceInDB) {
 	           	totalPableAmount = packagePriceInDB - giftCardPriceInDB;
 	           	giftAmountInDB = giftCardPriceInDB;
 	           	remGiftPrice = 0;
 	    	}
 	    	totPableAmt = String.format("%.2f", totalPableAmount);
            remGiftAmt = String.format("%.2f", remGiftPrice);
            giftAmount = String.format("%.2f", giftAmountInDB);
 	    }
 	    if(("0.00").equals(totPableAmt)) {
 	    	mav = new ModelAndView(zeroQuesPaymentRedirection);
 	    } else {
 	    	mav = new ModelAndView(quesPaymentRedirection);
 	    }
 	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
 	    mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN)); 	    
 	    mav.addObject(promoStatus, promoStatus1); 	    
 	    sn.setAttribute(totalCheckoutAmountInSn, totPableAmt);
 	    mav.addObject(promoCodePrice, disCountPrice);
 	    mav.addObject(totalPaybleAmount, totPableAmt); 	    
 	    mav.addObject(packagePrice, packPrice);
 	    mav.addObject(packagePriceFm, packPriceFormate); 	    
 	    mav.addObject(giftCardPrice, giftAmount);
 	    mav.addObject(remGiftCardPrice, remGiftAmt);
 	    mav.addObject(giftCuponCode, req.getParameter(giftCuponCode));
 	    mav.addObject(payCardNumber, req.getParameter(payCardNumber));
 	    mav.addObject(payExpMonth, req.getParameter(payExpMonth));
 	    mav.addObject(payExpYear, req.getParameter(payExpYear));
 	    mav.addObject(nameOnCard, req.getParameter(nameOnCard));
 	    mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
 	    return mav;
    }

    @Override
    @Transactional
    public ModelAndView questionnerFullAndAccPackageEmailForClient(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
     	UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));        		
     	String toAdd = userInformation.getUserName();
     	String firstName = userInformation.getFirstName();
     	String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
     	String subject = "Get Ready For Some Designing Fun!";            
     	String type = "text/html";           
     	EmailSending userEmail = new EmailSending();
     	String fromAdd = "info@nookandcove.com";              
     	String body = "<body>" 
                     + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                     + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                     + "<p style='padding-top: 5px;'>Thanks for purchasing a design package at NOOK + COVE! You will be assigned a designer shortly and they will get in touch with you via our messaging feature which you can access by logging into your account.</p>"
                     + "<p style='padding-top: 5px;'>We hope you enjoy the design process and we look forward to making your design dreams come true!</p>"
                     + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                     + "</div>"
                     + "</body> ";            
     	try {
     		userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
     	} catch (Exception ex) {
     		LOGGER.error("questionner Full And Acc Package Email For Client failed " + ex);
     	}       
     	mav = new ModelAndView();
     	return mav;
    }

    @Override
    @Transactional
    public ModelAndView questionnerFullAndAccPackageEmailForAdmin(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long adminUserId = 1;
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        		
        String userID1 = userInformation.getUserName();
        String userID2 = "brennan.rachman@madwire.com";
        String userID3 = "marketing360+m24951@bcc.mad360.net";
        String[] emailList = {userID1, userID2, userID3};
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    	String subject = "A new design package has been purchased.";            
    	String type = "text/html";           
    	EmailSending userEmail = new EmailSending();
    	String fromAdd = "info@nookandcove.com";              
    	String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                    + "<p style='margin-top: 8px;'>A new design package has been purchased. Need to assign a designer to the client.</p>"
                    + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                    + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                    + "</div>"
                    + "</body> ";            
    	try {
    		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
    	} catch (Exception ex) {
    		LOGGER.error("questionner Full And Acc Package Email For Admin failed " + ex);
    	}       
    	mav = new ModelAndView();
    	return mav;
   }
  
   @Override
   @Transactional
   public ModelAndView allocateBudget(HttpServletRequest req, HttpSession sn) {
	   	ModelAndView mav;	       
	   	String dimentionVal = null;
	   	if(null != sn.getAttribute(userIdInSn)) {
	    	Timestamp currentDate = currentDate();        	
	        List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	        if(!selectedRowIdList.isEmpty()){
	        	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
		       	clientInfoSaving.setBudget(req.getParameter(budget));        
		       	clientInfoSaving.setUpdatedDate(currentDate);
	            clientInfoSavingDAO.merge(clientInfoSaving);
	            dimentionVal = clientInfoSaving.getSpaceDimension();
	        }	    
	    mav = new ModelAndView(dimensionsRedirection);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	    mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	    mav.addObject(spaceDimension, dimentionVal);
	    } else{
	       	mav = userInformationService.loginRedirection(req, sn);
	    }	    
	   	mav.addObject(allocateBudget, req.getParameter(budget));
	   	return mav;
   }

   @Override
   @Transactional
   public ModelAndView dimensionBackMove(HttpServletRequest req, HttpSession sn) {
     	ModelAndView mav;     	
     	if(null != sn.getAttribute(userIdInSn)) {
     		ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
         	String allcBudget = clientInfoSaving.getBudget();          	
        	mav = new ModelAndView(allocateForBudgetAL);
        	mav.addObject(allocateBudget, allcBudget);         	
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
       	 	mav = userInformationService.logOutRedirection(req, sn);
        }
     	return mav;
   }

   @Override
   @Transactional
   public ModelAndView roomDimensions(HttpServletRequest req, HttpSession sn) {
	   	ModelAndView mav;
	    Timestamp currentDate = currentDate();
	    ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   	clientInfoSaving.setSpaceDimension(req.getParameter(dimension));
	   	clientInfoSaving.setUpdatedDate(currentDate);
	    clientInfoSavingDAO.merge(clientInfoSaving);
	    String typeOfCol = clientInfoSaving.getTypeOfColor();
	    String likeCol = clientInfoSaving.getLikeColor();
	    String dislikeCol = clientInfoSaving.getDislikeColor();	               
	   	mav = new ModelAndView(feelAboutColorRedirection);    	
	   	mav.addObject(typeOfColor, typeOfCol);
	   	mav.addObject(likeColor, likeCol);
	   	mav.addObject(dislikeColor, dislikeCol);
	   	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));	   	
	   	return mav;
   }

   @Override
   @Transactional
   public ModelAndView typeOfColorBackMove(HttpServletRequest req, HttpSession sn) {
     	ModelAndView mav;
     	if(null != sn.getAttribute(userIdInSn)) {
     		ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
         	String spaceDim = clientInfoSaving.getSpaceDimension();
         	mav = new ModelAndView(dimensionsRedirection);
        	mav.addObject(spaceDimension, spaceDim);         	
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
       	 	mav = userInformationService.logOutRedirection(req, sn);
        }
     	return mav;
   }

   @Override
   @Transactional
   public ModelAndView feelAboutColorRedirection(HttpServletRequest req, HttpSession sn) {
	   	ModelAndView mav;
	    Timestamp currentDate = currentDate();
	   	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   	clientInfoSaving.setTypeOfColor(req.getParameter(typeOfColor));
	   	clientInfoSaving.setLikeColor(req.getParameter(likeColor));
	   	clientInfoSaving.setDislikeColor(req.getParameter(dislikeColor));
	   	clientInfoSaving.setUpdatedDate(currentDate);
	    clientInfoSavingDAO.merge(clientInfoSaving);
	    String typeOfItems = clientInfoSaving.getTypeOfItemsList();
	    String otherItems = clientInfoSaving.getOtherItems();
	    String alreadyHaveItems = clientInfoSaving.getAlreadyHaveItems();
	    clientInfoSaving.setTypeOfItemsList(req.getParameter(typeOfItem));
	   	clientInfoSaving.setOtherItems(req.getParameter(otherItem));
	   	clientInfoSaving.getAlreadyHaveItems();
	    selectedItemsDisplayInJSP(req, sn, clientInfoSaving.getTypeOfSpace());
	   	mav = new ModelAndView(needItemsForSpaceRed);
	   	mav.addObject(typeOfItem, typeOfItems);
	   	mav.addObject(otherItem, otherItems);
	   	mav.addObject(alreadyHaveItem, alreadyHaveItems);    	
	   	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   	return mav;
   }

   @Override
   @Transactional
   public ModelAndView selectedItemsDisplayInJSP(HttpServletRequest req, HttpSession sn, String refSpaceName) {
       List itemNamesList = new ArrayList();
       List<ItemsListForSpaceInfo> selectedItemsList = itemsListForSpaceInfoDAO.selectedItemsTakeFromDB(refSpaceName);        
       for (ItemsListForSpaceInfo selectedItemsModel : selectedItemsList) {
       	itemNamesList.add(selectedItemsModel.getNameOfItem());       	        	            	   
       }        
       sn.setAttribute("item_Names_List", itemNamesList);
       ModelAndView mav = new ModelAndView();  
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView needSpaceItemsBackMove(HttpServletRequest req, HttpSession sn) {
     	ModelAndView mav;
     	if(null != sn.getAttribute(userIdInSn)) {
     		ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
     		String typeOfCol = clientInfoSaving.getTypeOfColor();
     		String likeCol = clientInfoSaving.getLikeColor();
     		String dislikeCol = clientInfoSaving.getDislikeColor();                    
	       	mav = new ModelAndView(feelAboutColorRedirection);    	
	       	mav.addObject(typeOfColor, typeOfCol);
	       	mav.addObject(likeColor, likeCol);
	       	mav.addObject(dislikeColor, dislikeCol);        	         	
        	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else{
       	 	mav = userInformationService.logOutRedirection(req, sn);
        }
     	return mav;
   }

   @Override
   @Transactional
   public ModelAndView needSpaceItemsDataSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   Timestamp currentDate = currentDate();
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   clientInfoSaving.setTypeOfItemsList(req.getParameter(typeOfItem));
	   String otherItemVal = req.getParameter(otherItem);
	   String alreadyHaveItemVal = req.getParameter(alreadyHaveItem);
	   otherItemVal = otherItemVal.replaceAll("[\n\r]", " ");
	   alreadyHaveItemVal = alreadyHaveItemVal.replaceAll("[\n\r]", " ");
	   clientInfoSaving.setOtherItems(otherItemVal);
	   clientInfoSaving.setAlreadyHaveItems(alreadyHaveItemVal);
	   clientInfoSaving.setUpdatedDate(currentDate);
	   clientInfoSavingDAO.merge(clientInfoSaving);
	   String wallArtReff = clientInfoSaving.getTypeOfArtAppeals();
	   if(("WALL ART").equalsIgnoreCase(req.getParameter(wallArtRef))) {
		   mav = new ModelAndView(typeOfArtAppealsRed);
	       mav.addObject(typeOfArt, wallArtReff);
	       sn.setAttribute(wallArtRefInSN, req.getParameter(wallArtRef));
	   } else {
		   mav = new ModelAndView("redirect:" + "reDirMoreAboutSpaceUpImgs");
	       sn.setAttribute(wallArtRefInSN, null);
	       clientInfoSaving.setTypeOfArtAppeals(null);
	       clientInfoSavingDAO.merge(clientInfoSaving);
	   }    	
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView typeOfArtBackMove(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   if(null != sn.getAttribute(userIdInSn)) {
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
    	   String typeOfItems = clientInfoSaving.getTypeOfItemsList();
           String otherItems = clientInfoSaving.getOtherItems();
           String alreadyHaveItems = clientInfoSaving.getAlreadyHaveItems();                    
	       mav = new ModelAndView(needItemsForSpaceRed);    	
	       mav.addObject(typeOfItem, typeOfItems);
	       mav.addObject(otherItem, otherItems);
	       mav.addObject(alreadyHaveItem, alreadyHaveItems);        	         	
           mav.addObject(flName, sn.getAttribute(firstNamesInSn));
           mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       } else{
    	   mav = userInformationService.logOutRedirection(req, sn);
       }
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView typeOfArtDataSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   Timestamp currentDate = currentDate();
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   clientInfoSaving.setTypeOfArtAppeals(req.getParameter(typeOfArt));    	
	   clientInfoSaving.setUpdatedDate(currentDate);
	   clientInfoSavingDAO.merge(clientInfoSaving);
	   mav = new ModelAndView("redirect:" + "reDirMoreAboutSpaceUpImgs");
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView moreAboutSpaceUploadImagesInDB(MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	   ModelAndView mav;        
	   String fileName = fileUpload.getOriginalFilename();
	   String filepath = uploadImgPath + fileName;
	   File conFile = new File(filepath);
	   conFile.mkdir();        
	   fileUpload.transferTo(conFile);
	   byte[] bFile = new byte[(int) conFile.length()];
	   try {
		   BufferedImage bufferedImage = ImageIO.read(conFile);
		   BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		   newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
		   ByteArrayOutputStream baos = new ByteArrayOutputStream();      
		   ImageIO.write(newBufferedImage, "jpg", baos);      
		   baos.flush();
		   bFile = baos.toByteArray();
		   baos.close();
	   } catch (Exception e) {
		   LOGGER.error("Blog Exception: "+e);
	   }
	   Timestamp currentDate = currentDate();
	   ClientUploadedSpaceImagesSaving cusis = new ClientUploadedSpaceImagesSaving();
	   cusis.setUserId((Long) sn.getAttribute(userIdInSn));
	   cusis.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
	   cusis.setUploadSpaceImagesBlogForDesigner(bFile);
	   cusis.setUploadSpaceImagesPathForDesigner(fileName);
	   cusis.setCreatedDate(currentDate);
	   clientUploadedSpaceImagesSavingDAO.save(cusis);
	   mav = new ModelAndView("redirect:" + "reDirMoreAboutSpaceUpImgs");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView reDirMoreAboutSpaceUpImgsInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.clientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String clientUploadImgIdsList = "";
	   String clUpDBImagesList = "";
	   if(!clientUploadedSpaceImagesList.isEmpty()){
		   for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {
			   long clientUpImgId = clientUploadedSIModel.getClientUploadedSpaceImagesSavingId();
			   byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
			   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
			   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
		   }
		   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
		   clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
	   }	   
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String moreAbtSpace = clientInfoSaving.getMoreAboutSpace();
	   mav = new ModelAndView(moreAboutSpaceUploadImages);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));		
	   mav.addObject(uploadedImgInDB, clUpDBImagesList);
	   mav.addObject(clientUploadImgId, clientUploadImgIdsList);
	   mav.addObject(clUploadedImgsCount, clientUploadedSpaceImagesList.size());
	   mav.addObject(moreAboutSpace, moreAbtSpace);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView aboutSpaceImgBackMove(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   if(null != sn.getAttribute(userIdInSn)) {
		   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
		   String wallArtReff = clientInfoSaving.getTypeOfArtAppeals();
		   String typeOfItems = clientInfoSaving.getTypeOfItemsList();
           String otherItems = clientInfoSaving.getOtherItems();
           String alreadyHaveItems = clientInfoSaving.getAlreadyHaveItems();
           if(("WALL ART").equalsIgnoreCase((String) sn.getAttribute(wallArtRefInSN))) {
        	   mav = new ModelAndView(typeOfArtAppealsRed);
        	   mav.addObject(typeOfArt, wallArtReff);           	
           } else {            	                    
        	   mav = new ModelAndView(needItemsForSpaceRed);    	
        	   mav.addObject(typeOfItem, typeOfItems);
        	   mav.addObject(otherItem, otherItems);
        	   mav.addObject(alreadyHaveItem, alreadyHaveItems); 
           }   	
           mav.addObject(flName, sn.getAttribute(firstNamesInSn));
           mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       } else{
    	   mav = userInformationService.logOutRedirection(req, sn);
       }
     	return mav;
   }

   @Override
   @Transactional
   public JSONArray deleteImageFromDBUsingJSON(String deletedImage, HttpSession sn) {
	   long deletedImageId = Long.parseLong(deletedImage);
       if(deletedImageId > 0) {
    	   ClientUploadedSpaceImagesSaving clUploadedSpaceDelImgsList = clientUploadedSpaceImagesSavingDAO.deleteUploadedImagesSelectedRowInDB((Long) sn.getAttribute(userIdInSn), deletedImageId);
    	   clientUploadedSpaceImagesSavingDAO.delete(clUploadedSpaceDelImgsList);
       }
       List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.clientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       String clUpDBImagesList = "";
       String clientUploadImgIdsList = "";                   
       if(!clientUploadedSpaceImagesList.isEmpty()){        	 
    	   for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {         		
    		   long clientUpImgId = clientUploadedSIModel.getClientUploadedSpaceImagesSavingId();
    		   byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
    		   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;
    		   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
    	   }
    	   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
           clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
       }
       JSONArray forms = new JSONArray();
       JSONObject jsonObj = new JSONObject();
       jsonObj.put("JSonSpObj1", clUpDBImagesList);
       jsonObj.put("JSonSpObj2", clientUploadImgIdsList);
       forms.add(jsonObj);
       return forms;
   }

   @Override
   @Transactional
   public ModelAndView aboutSpaceDataSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       Timestamp currentDate = currentDate();
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       clientInfoSaving.setMoreAboutSpace(req.getParameter(moreAboutSpace));   	
       clientInfoSaving.setUpdatedDate(currentDate);
       clientInfoSavingDAO.merge(clientInfoSaving);
       mav = new ModelAndView("redirect:" + "reDirShareInspirationUpImgs");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
   	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));   	
   	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirShareInspirationUpImgsInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;		
	   List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       String clientUploadImgIdsList = "";
       String clUpDBImagesList = "";
       if(!clientUploadedInsImagesList.isEmpty()){
    	   for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {       		
	       		long clientUpImgId = clientUploadedIIModel.getClientUploadedInspireImagesSavingId();
	       		byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
	       		String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
	       		clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
	       		clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
    	   }
    	   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
           clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
       }
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String shareYourInsp = clientInfoSaving.getShareYourInspire();
	   mav = new ModelAndView(shareInspirationUploadImages);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));		
	   mav.addObject(shUploadedImgInDB, clUpDBImagesList);
	   mav.addObject(clientUploadImgId, clientUploadImgIdsList);
	   mav.addObject(clUploadedImgsCount, clientUploadedInsImagesList.size());
	   mav.addObject(shareInspiration, shareYourInsp);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView shareInspImgBackMove(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   if(null != sn.getAttribute(userIdInSn)) {
		   clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
		   mav = new ModelAndView("redirect:" + "reDirMoreAboutSpaceUpImgs");
		   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   } else{
		   mav = userInformationService.logOutRedirection(req, sn);
	   }
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView shareInspirationUpImgInDB(MultipartFile shareInspImgUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	   ModelAndView mav;
	   String fileName = shareInspImgUpload.getOriginalFilename();
	   String filepath = uploadImgPath + fileName;
	   File conFile = new File(filepath);
	   conFile.mkdir();        
	   shareInspImgUpload.transferTo(conFile);
	   byte[] bFile = new byte[(int) conFile.length()];
	   try {
		   BufferedImage bufferedImage = ImageIO.read(conFile);
		   BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		   newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
		   ByteArrayOutputStream baos = new ByteArrayOutputStream();      
		   ImageIO.write(newBufferedImage, "jpg", baos);      
		   baos.flush();
		   bFile = baos.toByteArray();
		   baos.close();
	   } catch (Exception e) {
		   LOGGER.error("Blog Exception: "+e);
	   }
	   Timestamp currentDate = currentDate();
       ClientUploadedInspireImagesSaving cuiis = new ClientUploadedInspireImagesSaving();
       cuiis.setUserId((Long) sn.getAttribute(userIdInSn));        
       cuiis.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
       cuiis.setUploadInspiredImagesBlogForDesigner(bFile);
       cuiis.setUploadInspiredImagesPathForDesigner(fileName);
       cuiis.setCreatedDate(currentDate);
       clientUploadedInspireImagesSavingDAO.save(cuiis);
       mav = new ModelAndView("redirect:" + "reDirShareInspirationUpImgs");
       return mav;
   }
   
   @Override
   @Transactional
   public JSONArray shareInspDeleteImageFromDBUsingJSON(String deletedImage, HttpSession sn) {
	   long deletedImageId = Long.parseLong(deletedImage);
	   if(deletedImageId > 0) {
		   ClientUploadedInspireImagesSaving clUploadedInspDelImgsList = clientUploadedInspireImagesSavingDAO.deleteUploadedImagesSelectedRowInDB((Long) sn.getAttribute(userIdInSn), deletedImageId);
		   clientUploadedInspireImagesSavingDAO.delete(clUploadedInspDelImgsList);
	   }
	   List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String clUpDBImagesList = "";
	   String clientUploadImgIdsList = "";
	   if(!clientUploadedInsImagesList.isEmpty()){        	 
		   for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {
			   long clientUpImgId = clientUploadedIIModel.getClientUploadedInspireImagesSavingId();
			   byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();          		
			   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;
			   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
		   }
		   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
	       clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
	   }                                     
       JSONArray forms = new JSONArray();
       JSONObject jsonObj = new JSONObject();
       jsonObj.put("JSonInspObj1", clUpDBImagesList);
       jsonObj.put("JSonInspObj2", clientUploadImgIdsList); 
       forms.add(jsonObj);
       return forms;
   }

   @Override
   @Transactional
   public ModelAndView shareInspirationDataSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       Timestamp currentDate = currentDate();      
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       clientInfoSaving.setShareYourInspire(req.getParameter(shareInspiration));
       clientInfoSaving.setUpdatedDate(currentDate);
       clientInfoSavingDAO.merge(clientInfoSaving);
       mav = new ModelAndView(justAboutFinishedQuestionnaireRed);          	
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));    	
       return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView justAboutFinishedQuestionnaireSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       Timestamp currentDate = currentDate();
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       clientInfoSaving.setClientAskedDesignerName(req.getParameter(clAskedDesignerName));
       clientInfoSaving.setClHearAboutUs(req.getParameter(clHearAboutUs));
       clientInfoSaving.setUpdatedDate(currentDate);
       clientInfoSavingDAO.merge(clientInfoSaving);
       mav = new ModelAndView(doneWithQuestionnaireRed);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));   	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView myDashBoardRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       Timestamp currentDate = currentDate();
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       clientInfoSaving.setStatus("Done");
       clientInfoSaving.setUpdatedDate(currentDate);
       clientInfoSavingDAO.merge(clientInfoSaving);
       mav = clientsInformationDisplayRedirection(req, sn);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));   	
       return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView clientsInformationDisplayRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   List<ClientInfoSaving> selectedClientInfoRowIdList = clientInfoSavingDAO.clientManagementRowCheckingInDB((Long) sn.getAttribute(userIdInSn));
	   List clientInfoIdsList = new ArrayList();
	   List typeOfSpaceList = new ArrayList();
       List startDatesList = new ArrayList();
       List newImagesStatusList = new ArrayList();       
       if (!selectedClientInfoRowIdList.isEmpty()) {
    	   for (ClientInfoSaving clientInfoSavingModel : selectedClientInfoRowIdList) {
    		   clientInfoIdsList.add(clientInfoSavingModel.getClientInfoSavingId());
    		   String selectedRoom = null;
    		   String typeofRoom = clientInfoSavingModel.getTypeOfSpace();
    		   if((!("LIVING_ROOM").equals(typeofRoom)) && (!("DINING_ROOM").equals(typeofRoom)) && (!("BEDROOM").equals(typeofRoom)) && (!("HOME_OFFICE").equals(typeofRoom)) && (!("REC_ROOM").equals(typeofRoom)) && (!("NURSERY").equals(typeofRoom)) && (!("KIDS_BEDROOM").equals(typeofRoom)) && (!("PLAYROOM").equals(typeofRoom)) && (!("OUTDOOR_SPACE").equals(typeofRoom))) {
    			   selectedRoom = "<font class='other_space_img_display_cl'>" + typeofRoom + "</font>";
    		   } else {
    			   String srcReff = "resources/images/space_images/" + typeofRoom + ".png";
    			   selectedRoom = "<img src=" + srcReff + ">";
    		   }
           typeOfSpaceList.add(selectedRoom);
           String strDate = new SimpleDateFormat("MM/dd/yyyy").format(clientInfoSavingModel.getCreatedDate());
           startDatesList.add(strDate);
           String newImgStatus = newImagesDisplayInManagement(req, sn, clientInfoSavingModel.getClientInfoSavingId());
           newImagesStatusList.add(newImgStatus);
           }           
       sn.setAttribute("client_Info_Ids_List", clientInfoIdsList);
       sn.setAttribute("type_Of_Space_List", typeOfSpaceList);
       sn.setAttribute("start_Dates_List", startDatesList);
       sn.setAttribute("new_Image_Status_List", newImagesStatusList);     	          
       mav = new ModelAndView("clientManagementDisplay");
       int totCartItemsCount = totalAddCartItemsCountFromDB(sn);            
       sn.setAttribute(totalCartItemsCountInSN, totCartItemsCount);
       mav.addObject(totalCartItemsCount, totCartItemsCount);       	
       } else{
    	   mav = startTheBusiness(req, sn);            
       }       
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));     
       return mav;
   }

   @Override
   @Transactional
   public String newImagesDisplayInManagement(HttpServletRequest req, HttpSession sn, long clientInfoId) {
	   String newImgStatus = "";
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();
       int desnMessagesCoun = 0;
       String conceptStatus1 = null;
       String renderingStatus1 = null;
       String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;
       if(designInfoId > 0) {
    	   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
    	   desnMessagesCoun = desnMessCountList.size();
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
    	   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
    	   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
    	   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
    	   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();
    	   if(desnMessagesCoun > 0 || ("Approved for Concepts").equals(conceptStatus1) || ("Approved for Renderings").equals(renderingStatus1) || ("Approved for Revised Renderings").equals(secondRenderingStatus1) || ("Approved for Second Renderings").equals(revisedRenderingStatus1)) {
    		   newImgStatus = "showImageClass";
    	   }
    	   sn.setAttribute(conceptStatusInSn, conceptStatus1);
    	   sn.setAttribute(renderingStatusInSn, renderingStatus1);
    	   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
    	   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);        	
       }
       return newImgStatus;
   }
   
   @Override
   @Transactional
   public ModelAndView clientInfoDisplaySavingRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   String clientDisNameList = req.getParameter("clientsDisplayName");   	
	   if("Modify Client".equals(req.getParameter("clientDisplayRefType"))) {
		   long clentInfoId = Long.parseLong(clientDisNameList);
		   sn.setAttribute(clientInfoSavingIdInSn, clentInfoId);
		   mav = modifyClientsInformation(req, sn, clentInfoId);    		
	   } else {
		   sn.setAttribute(clientInfoSavingIdInSn, null);
		   mav = addNewClient(req, sn);		   
	   }    	
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView modifyClientsInformation(HttpServletRequest req, HttpSession sn, long clientInfoId) {
	   ModelAndView mav;	   	
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);	   	    	
	   String typeOfSpace = clientInfoSaving.getTypeOfSpace();
	   String designPack = clientInfoSaving.getDesignPackage();
	   sn.setAttribute(typeOfDesignPackInSN, designPack);
	   if(null != typeOfSpace) {
		   typeOfSpace = typeOfSpace.replace("_", " ");
	   }
	   sn.setAttribute(selectedRoomInSn, typeOfSpace);	       
	   String typeOfItems = clientInfoSaving.getTypeOfItemsList();
	   String wallArtVal = null;
	   if(null != typeOfItems) {
		   wallArtVal = itemsWallArtValueSearch(req, sn, typeOfItems);
	   }        
	   sn.setAttribute(itemWallArtInSN, wallArtVal);	             
	   long designerInfoSavingId = clientInfoSaving.getDesignerInfoSavingId(); 	       
	   String desProfileImage = "";
	   int desnMessagesCoun = 0;	       
	   String conceptStatus1 = null;
	   String renderingStatus1 = null;
	   String secondRenderingStatus1 = null;
	   String revisedRenderingStatus1 = null;
	   long desnUserId = 0;
	   if(designerInfoSavingId > 0) {
		   DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
	       byte[] desProfileImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();
	       desProfileImage = javax.xml.bind.DatatypeConverter.printBase64Binary(desProfileImageFromDB);
	       desnUserId = designerInfoSaving.getDesignerId();	       	
	       mav = designerProfileInfoDisplayRed(req, sn, desnUserId);	       	
	       List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designerInfoSavingId);
	       desnMessagesCoun = desnMessCountList.size();	       	
	       AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoSavingId);
	       conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
	       renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
	       secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
	       revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();	       	
	       sn.setAttribute(conceptStatusInSn, conceptStatus1);
	       sn.setAttribute(renderingStatusInSn, renderingStatus1);
	       sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
	       sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
	   }	       
	   mav = new ModelAndView(roomsInformationModification);	       
	   mav.addObject(typeOfSpaceVal, typeOfSpace);
	   mav.addObject(typeOfDesignPack, designPack);
	   sn.setAttribute(desnUpPhotoInSn, desProfileImage);	   	
	   mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
	   mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
	   mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
	   mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
	   mav.addObject(designerProfileImage, desProfileImage);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
	   mav.addObject(desnMessageCount, desnMessagesCoun);	       
	   mav.addObject(conceptStatus, conceptStatus1);
	   mav.addObject(renderingStatus, renderingStatus1);
	   mav.addObject(secondRenderingStatus, secondRenderingStatus1);
	   mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView designerProfileInfoDisplayRed(HttpServletRequest req, HttpSession sn, long designerUserId) {
	   ModelAndView mav;
	   UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);
	   String desnProfileBio = userInformation.getDesnPersonalBio();
	   String desnLocation = userInformation.getDesnLocation();
	   sn.setAttribute(desnProfileBioInSn, desnProfileBio);
	   sn.setAttribute(desnLocationInSn, desnLocation);
	   String lastSingleName = String.valueOf(userInformation.getLastName().charAt(0)).toUpperCase();
	   String desnrFullName = userInformation.getFirstName() + " " + lastSingleName;
	   sn.setAttribute(desnFullNameInSn, desnrFullName);
	   mav = new ModelAndView();
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView addNewClient(HttpServletRequest req, HttpSession sn) {
       ModelAndView mav;       
       if(null != sn.getAttribute(userIdInSn)) {        	
    	   mav = new ModelAndView(typeOfRoomDisplayAL);
    	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       } else{
    	   mav = new ModelAndView(typeOfRoomDisplayBL);
       }                        
       return mav;
   }   
   
   @Override
   @Transactional
   public ModelAndView styleModificationBackMove(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        
       String selStyle = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   selStyle = clientInfoSaving.getTypeOfStyle();                
       }   		
       mav = new ModelAndView(roomsInformationModification);       	
       mav.addObject(typeOfStyleVal, selStyle);
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView roomManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       String selSpace = null;
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	        	        	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
    	   if(null != req.getParameter(typeOfSpace)) {
    		   String typeofRoom = req.getParameter(typeOfSpace);
    		   if((!("LIVING_ROOM").equals(typeofRoom)) && (!("DINING_ROOM").equals(typeofRoom)) && (!("BEDROOM").equals(typeofRoom)) && (!("HOME_OFFICE").equals(typeofRoom)) && (!("REC_ROOM").equals(typeofRoom)) && (!("NURSERY").equals(typeofRoom)) && (!("KIDS_BEDROOM").equals(typeofRoom)) && (!("PLAYROOM").equals(typeofRoom)) && (!("OUTDOOR_SPACE").equals(typeofRoom))) {
    			   clientInfoSaving.setTypeOfItemsList(null);
    			   sn.setAttribute(itemWallArtInSN, null);
    		   }
    		   Timestamp currentDate = currentDate();
    		   clientInfoSaving.setTypeOfSpace(typeofRoom);        
    		   clientInfoSaving.setUpdatedDate(currentDate);                	
    		   clientInfoSavingDAO.merge(clientInfoSaving);
    	   }
    	   selSpace = clientInfoSaving.getTypeOfSpace();                
       }
       if(null != selSpace) {
    	   selSpace = selSpace.replace("_", " ");
       }
       sn.setAttribute(selectedRoomInSn, selSpace);   		            
       mav = new ModelAndView(roomManagement);       	
       mav.addObject(typeOfSpaceVal, selSpace);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));              
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView roomModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       	
       String selspace = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   selspace = clientInfoSaving.getTypeOfSpace();                
       }           
       mav = new ModelAndView(roomModification);       	
       mav.addObject(selectedSpace, selspace);        	  	
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   } 

   @Override
   @Transactional
   public ModelAndView styleManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       String selStyle = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
    	   if(null != req.getParameter(typeOfStyle)) {
    		   Timestamp currentDate = currentDate();
    		   clientInfoSaving.setTypeOfStyle(req.getParameter(typeOfStyle));        
    		   clientInfoSaving.setUpdatedDate(currentDate);
    		   clientInfoSavingDAO.merge(clientInfoSaving);
    	   }
    	   selStyle = clientInfoSaving.getTypeOfStyle();                
       }
       if(null != selStyle) {
    	   selStyle = selStyle.replace("_", " ");
       }
       mav = new ModelAndView(styleManagement);        	
       mav.addObject(typeOfStyleVal, selStyle);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView styleModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        	
       String selStyle = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
   			selStyle = clientInfoSaving.getTypeOfStyle();                
       }           
       mav = new ModelAndView(styleModification);       	
       mav.addObject(selectedStyle, selStyle);        	       	
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView budgetManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       String selBudget = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
    	   if(null != req.getParameter(budget)) {
    		   Timestamp currentDate = currentDate();
    		   clientInfoSaving.setBudget(req.getParameter(budget));        
    		   clientInfoSaving.setUpdatedDate(currentDate);
    		   clientInfoSavingDAO.merge(clientInfoSaving);
    	   }
    	   selBudget = clientInfoSaving.getBudget();                
       }   		          
       mav = new ModelAndView(budgetManagement);        	
       mav.addObject(allocateBudget, selBudget);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn)); 
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView budgetModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       	
       String selBudget = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   selBudget = clientInfoSaving.getBudget();                
       }           
       mav = new ModelAndView(budgetModification);       	
       mav.addObject(allocateBudget, selBudget);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView dimensionsManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       String spDimension = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
    	   if(null != req.getParameter(dimension)) {
    		   Timestamp currentDate = currentDate();
    		   clientInfoSaving.setSpaceDimension(req.getParameter(dimension));     
    		   clientInfoSaving.setUpdatedDate(currentDate);
    		   clientInfoSavingDAO.merge(clientInfoSaving);
    	   }
    	   spDimension = clientInfoSaving.getSpaceDimension();                
       }   		           
       mav = new ModelAndView(dimensionsManagement);        	
       mav.addObject(spaceDimension, spDimension);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView dimensionsModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       	
       String spDimension = null;        	
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   spDimension = clientInfoSaving.getSpaceDimension();                
       }           
       mav = new ModelAndView(dimensionsModification);       	
       mav.addObject(spaceDimension, spDimension);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView colorManagement(HttpServletRequest req, HttpSession sn) {	
	   ModelAndView mav;       
	   String tyOfColor = null;
	   String lkColor = null;
	   String disLkColor = null;
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
    	   if(null != req.getParameter(typeOfColor) || null != req.getParameter(likeColor) || null != req.getParameter(dislikeColor)) {
    		   Timestamp currentDate = currentDate();
    		   clientInfoSaving.setTypeOfColor(req.getParameter(typeOfColor));
    		   clientInfoSaving.setLikeColor(req.getParameter(likeColor));
    		   clientInfoSaving.setDislikeColor(req.getParameter(dislikeColor));
    		   clientInfoSaving.setUpdatedDate(currentDate);
    		   clientInfoSavingDAO.merge(clientInfoSaving);
    	   }
    	   tyOfColor = clientInfoSaving.getTypeOfColor();
    	   lkColor = clientInfoSaving.getLikeColor();
    	   disLkColor = clientInfoSaving.getDislikeColor();
       }   		           
       mav = new ModelAndView(colorManagement);        	
       mav.addObject(typeOfColor, tyOfColor);
       mav.addObject(likeColor, lkColor);
       mav.addObject(dislikeColor, disLkColor);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView colorModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       	
       String tyOfColor = null;
       String lkColor = null;
       String disLkColor = null;
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   tyOfColor = clientInfoSaving.getTypeOfColor();
    	   lkColor = clientInfoSaving.getLikeColor();
    	   disLkColor = clientInfoSaving.getDislikeColor();
       }           
       mav = new ModelAndView(colorModification);       	
       mav.addObject(typeOfColor, tyOfColor);
       mav.addObject(likeColor, lkColor);
       mav.addObject(dislikeColor, disLkColor);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView furnitureManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   String typeOfItems = null;
	   String otherItems = null;
	   String alreadyHaveItems = null;
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       String otherItemVal = req.getParameter(otherItem);
       if(null != otherItemVal) {
    	   otherItemVal = otherItemVal.replaceAll("[\n\r]", " ");
       }
       String alreadyHaveItemVal = req.getParameter(alreadyHaveItem);
       if(null != alreadyHaveItemVal) {
    	   alreadyHaveItemVal = alreadyHaveItemVal.replaceAll("[\n\r]", " ");
       }       	
       List<String> mytyOfItemsList = new ArrayList<String>();
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));   			
    	   if(null != req.getParameter(typeOfItem) || null != otherItemVal || null != alreadyHaveItemVal) {
    		   Timestamp currentDate = currentDate();
    		   clientInfoSaving.setTypeOfItemsList(req.getParameter(typeOfItem));
    		   clientInfoSaving.setOtherItems(otherItemVal);
    		   clientInfoSaving.setAlreadyHaveItems(alreadyHaveItemVal);
    		   clientInfoSaving.setUpdatedDate(currentDate);
    		   clientInfoSavingDAO.merge(clientInfoSaving);
    	   }
    	   typeOfItems = clientInfoSaving.getTypeOfItemsList();
           otherItems = clientInfoSaving.getOtherItems();
           alreadyHaveItems = clientInfoSaving.getAlreadyHaveItems();               
           String wallArtVal = null;                
           if(null != typeOfItems) {
        	   wallArtVal = itemsWallArtValueSearch(req, sn, typeOfItems);
        	   if(null == wallArtVal) {
        		   clientInfoSaving.setTypeOfArtAppeals(null);
        		   clientInfoSavingDAO.merge(clientInfoSaving);
        		   sn.setAttribute(itemWallArtInSN, null);
        	   } else {
        		   sn.setAttribute(itemWallArtInSN, wallArtVal);
        	   }               	
        	   typeOfItems = typeOfItems.replaceAll(", undefined", "");
        	   typeOfItems = typeOfItems.replaceAll("undefined, ", "");
        	   typeOfItems = typeOfItems.replaceAll("undefined", "");           		
        	   if(!("").equals(typeOfItems)) {            			
        		   mytyOfItemsList = new ArrayList<String>(Arrays.asList(typeOfItems.split(",")));
        	   } else {            			
        		   mytyOfItemsList = null;
        	   }
           }
       }   		   		           
       mav = new ModelAndView(furnitureManagement);    		
       mav.addObject(typeOfItem, typeOfItems);
       mav.addObject(otherItem, otherItems);
       mav.addObject(alreadyHaveItem, alreadyHaveItems);
       sn.setAttribute("fur_item_Names_List", mytyOfItemsList);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }
   
   @Override
   @Transactional
   public String itemsWallArtValueSearch(HttpServletRequest req, HttpSession sn, String typeOfItems) {
	   String wallArtValue = null;
	   typeOfItems = typeOfItems.replaceAll(", undefined", "");
	   typeOfItems = typeOfItems.replaceAll("undefined, ", "");		
	   String[] listOfItems = typeOfItems.split(", ");
	   for (int i = 0; i < listOfItems.length; i++) {			
		   if(("WALL ART").equalsIgnoreCase(listOfItems[i])) {
			   wallArtValue = listOfItems[i];
		   }
	   }
	   return wallArtValue;    	
   }

   @Override
   @Transactional
   public ModelAndView furnitureModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       String typeOfItems = null;
       String otherItems = null;
       String alreadyHaveItems = null;
       String typeOfSpace = null;
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   typeOfItems = clientInfoSaving.getTypeOfItemsList();
    	   otherItems = clientInfoSaving.getOtherItems();
    	   alreadyHaveItems = clientInfoSaving.getAlreadyHaveItems();
    	   typeOfSpace = clientInfoSaving.getTypeOfSpace();
       }
       selectedItemsDisplayInJSP(req, sn, typeOfSpace);           
       mav = new ModelAndView(furnitureModification);       
       mav.addObject(typeOfItem, typeOfItems);
       mav.addObject(otherItem, otherItems);
       mav.addObject(alreadyHaveItem, alreadyHaveItems);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView artManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   String typeOfApp = null;
	   List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
	   if(!selectedRowIdList.isEmpty()){
		   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
		   if(null != req.getParameter(typeOfArt)) {
			   Timestamp currentDate = currentDate();
			   clientInfoSaving.setTypeOfArtAppeals(req.getParameter(typeOfArt));    				
			   clientInfoSaving.setUpdatedDate(currentDate);
			   clientInfoSavingDAO.merge(clientInfoSaving);
		   }
		   typeOfApp = clientInfoSaving.getTypeOfArtAppeals();
		   if(null != typeOfApp){
			   typeOfApp = typeOfApp.replace("_", " ");
		   }
	   }   		           
	   mav = new ModelAndView(artManagement);        	
       mav.addObject(typeOfArt, typeOfApp);        	
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView artModificationRed(HttpServletRequest req, HttpSession sn) {
       ModelAndView mav;
       String typeOfApp = null;
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   typeOfApp = clientInfoSaving.getTypeOfArtAppeals();
       }           
       mav = new ModelAndView(artModification);       	
       mav.addObject(typeOfArt, typeOfApp);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView myRoomManagement(HttpServletRequest req, HttpSession sn) {
       ModelAndView mav;
       String moreAbtSpace = null;
       String clUpDBImagesList = "";
       List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.clientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       
       if(!clientUploadedSpaceImagesList.isEmpty()){
    	   for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {       		
    		   byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
    		   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;
    	   }
    	   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", ""); 
       }             
	   List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
	   if(!selectedRowIdList.isEmpty()){
		   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
		   String moreAbotSpace = req.getParameter(moreAboutSpace);
		   if(null != moreAbotSpace) {
			   moreAbotSpace = moreAbotSpace.replaceAll("[\n\r]", " ");
			   Timestamp currentDate = currentDate();
			   clientInfoSaving.setMoreAboutSpace(moreAbotSpace);    				
			   clientInfoSaving.setUpdatedDate(currentDate);
			   clientInfoSavingDAO.merge(clientInfoSaving);
		   }
		   moreAbtSpace = clientInfoSaving.getMoreAboutSpace();
	   }   		          
	   mav = new ModelAndView(myRoomManagement);        	
       mav.addObject(moreAboutSpace, moreAbtSpace);
       mav.addObject(uploadedImgInDB, clUpDBImagesList);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));       	
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView myRoomModificationRed(HttpServletRequest req, HttpSession sn) {
       ModelAndView mav;
       String moreAbtSpace = null;
       String clUpDBImagesList = "";
	   String clientUploadImgIdsList = "";
	   List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.clientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));	       
	   if(!clientUploadedSpaceImagesList.isEmpty()){
		   for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) { 		
			   long clientUpImgId = clientUploadedSIModel.getClientUploadedSpaceImagesSavingId();
			   byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
			   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;
			   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
		   }
		   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
		   clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
	   }        
       List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       	
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   moreAbtSpace = clientInfoSaving.getMoreAboutSpace();
       }           
       mav = new ModelAndView(myRoomModification);       	
       mav.addObject(moreAboutSpace, moreAbtSpace);
       mav.addObject(uploadedImgInDB, clUpDBImagesList);
       mav.addObject(clientUploadImgId, clientUploadImgIdsList);
       mav.addObject(clUploadedImgsCount, clientUploadedSpaceImagesList.size());
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       	
       return mav;
   }   

   @Override
   @Transactional
   public ModelAndView modClMoreAboutSpaceUploadImagesInDB(MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	   ModelAndView mav;        
       String fileName = fileUpload.getOriginalFilename();       
       String filepath = uploadImgPath + fileName;
       File conFile = new File(filepath);
	   conFile.mkdir();        
	   fileUpload.transferTo(conFile);
	   byte[] bFile = new byte[(int) conFile.length()];
	   try {
		   BufferedImage bufferedImage = ImageIO.read(conFile);
		   BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		   newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
		   ByteArrayOutputStream baos = new ByteArrayOutputStream();      
		   ImageIO.write(newBufferedImage, "jpg", baos);      
		   baos.flush();
		   bFile = baos.toByteArray();
		   baos.close();
	   } catch (Exception e) {
		   LOGGER.error("Blog Exception: "+e);
	   }
	   Timestamp currentDate = currentDate();
       ClientUploadedSpaceImagesSaving cusis = new ClientUploadedSpaceImagesSaving();
       cusis.setUserId((Long) sn.getAttribute(userIdInSn));
       cusis.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
       cusis.setUploadSpaceImagesBlogForDesigner(bFile);
       cusis.setUploadSpaceImagesPathForDesigner(fileName);
       cusis.setCreatedDate(currentDate);
       clientUploadedSpaceImagesSavingDAO.save(cusis);      
       mav = new ModelAndView("redirect:" + "reDirModClMoreAboutSpaceUpImgs");
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirModClMoreAboutSpaceUpImgsInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;		
	   List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.clientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String clientUploadImgIdsList = "";
	   String clUpDBImagesList = "";	               
	   if(!clientUploadedSpaceImagesList.isEmpty()){
		   for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {
			   long clientUpImgId = clientUploadedSIModel.getClientUploadedSpaceImagesSavingId();
			   byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
			   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
			   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
		   }
		   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
		   clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");	
	   }      
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String moreAbtSpace = clientInfoSaving.getMoreAboutSpace();	      
	   mav = new ModelAndView(myRoomModification);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));		
	   mav.addObject(uploadedImgInDB, clUpDBImagesList);
	   mav.addObject(clientUploadImgId, clientUploadImgIdsList);
	   mav.addObject(clUploadedImgsCount, clientUploadedSpaceImagesList.size());
	   mav.addObject(moreAboutSpace, moreAbtSpace);
	   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
	   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
       return mav;
   }
	
   @Override
   @Transactional
   public ModelAndView inspirationManagement(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        
       String shareYourInsp = null;
       String clUpDBImagesList = "";
       List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));       
       if(!clientUploadedInsImagesList.isEmpty()){
    	   for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {
    		   byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
    		   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
    	   }
    	   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
       }      
	   List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       if(!selectedRowIdList.isEmpty()){
		   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
		   String shareYourInspration = req.getParameter(shareInspiration);
		   if(null != shareYourInspration) {    				
			   Timestamp currentDate = currentDate();
			   clientInfoSaving.setShareYourInspire(shareYourInspration);    				
			   clientInfoSaving.setUpdatedDate(currentDate);
			   clientInfoSavingDAO.merge(clientInfoSaving);
		   }
		   shareYourInsp = clientInfoSaving.getShareYourInspire();
	   }   		          
	   mav = new ModelAndView(inspirationManagement);        	
       mav.addObject(shareInspiration, shareYourInsp);
       mav.addObject(shUploadedImgInDB, clUpDBImagesList);
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(typeOfDesignPack, sn.getAttribute(typeOfDesignPackInSN));
       mav.addObject(designerProfileImage, sn.getAttribute(desnUpPhotoInSn));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
       mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
       mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
       mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
       mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView inspirationModificationRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        	
       String shareYourInsp = null;
       List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       String clientUploadImgIdsList = "";
       String clUpDBImagesList = "";
       if(!clientUploadedInsImagesList.isEmpty()){
    	   for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {
    		   long clientUpImgId = clientUploadedIIModel.getClientUploadedInspireImagesSavingId();
    		   byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
    		   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
    		   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
    	   }
    	   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
           clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
       }       
	   List selectedRowIdList = clientInfoSavingDAO.rowIdSelectionUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       if(!selectedRowIdList.isEmpty()){
    	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));                
    	   shareYourInsp = clientInfoSaving.getShareYourInspire();
       }
       mav = new ModelAndView(inspirationModification);
       mav.addObject(shUploadedImgInDB, clUpDBImagesList);
       mav.addObject(clientUploadImgId, clientUploadImgIdsList);
       mav.addObject(clUploadedImgsCount, clientUploadedInsImagesList.size());
       mav.addObject(shareInspiration, shareYourInsp);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView modClShareInspirationUpImgInDB(MultipartFile shareInspImgUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	   ModelAndView mav;
	   String fileName = shareInspImgUpload.getOriginalFilename();
	   String filepath = uploadImgPath + fileName;
	   File conFile = new File(filepath);
	   conFile.mkdir();        
	   shareInspImgUpload.transferTo(conFile);
	   byte[] bFile = new byte[(int) conFile.length()];
	   try {
		   BufferedImage bufferedImage = ImageIO.read(conFile);
		   BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		   newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
		   ByteArrayOutputStream baos = new ByteArrayOutputStream();      
		   ImageIO.write(newBufferedImage, "jpg", baos);      
		   baos.flush();
		   bFile = baos.toByteArray();
		   baos.close();
	   } catch (Exception e) {
		   LOGGER.error("Blog Exception: "+e);
	   }
	   Timestamp currentDate = currentDate();
       ClientUploadedInspireImagesSaving cuiis = new ClientUploadedInspireImagesSaving();
       cuiis.setUserId((Long) sn.getAttribute(userIdInSn));        
       cuiis.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
       cuiis.setUploadInspiredImagesBlogForDesigner(bFile);
       cuiis.setUploadInspiredImagesPathForDesigner(fileName);
       cuiis.setCreatedDate(currentDate);
       clientUploadedInspireImagesSavingDAO.save(cuiis);       
       mav = new ModelAndView("redirect:" + "reDirModClShareInspirationUpImgs");
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirModClShareInspirationUpImgsInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;		
	   List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       String clientUploadImgIdsList = "";
       String clUpDBImagesList = "";               
       if(!clientUploadedInsImagesList.isEmpty()){
    	   for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {
    		   long clientUpImgId = clientUploadedIIModel.getClientUploadedInspireImagesSavingId();
    		   byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
    		   String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
    		   clientUploadImgIdsList = clientUploadImgIdsList + "_,_" + clientUpImgId;
    	   }
    	   clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
           clientUploadImgIdsList = clientUploadImgIdsList.replaceFirst("_,_", "");
       }      
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   String shareYourInsp = clientInfoSaving.getShareYourInspire();       
	   mav = new ModelAndView(inspirationModification);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));		
	   mav.addObject(shUploadedImgInDB, clUpDBImagesList);
	   mav.addObject(clientUploadImgId, clientUploadImgIdsList);
	   mav.addObject(clUploadedImgsCount, clientUploadedInsImagesList.size());
	   mav.addObject(shareInspiration, shareYourInsp);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView myRoomInformationRedirection(HttpServletRequest req, HttpSession sn) {
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       String typeOfSpace = clientInfoSaving.getTypeOfSpace();
	   String designPack = clientInfoSaving.getDesignPackage();
	   sn.setAttribute(typeOfDesignPackInSN, designPack);
	   if(null != typeOfSpace) {
		   typeOfSpace = typeOfSpace.replace("_", " ");
	   }
       sn.setAttribute(selectedRoomInSn, typeOfSpace);        
       String typeOfItems = clientInfoSaving.getTypeOfItemsList();        
       String wallArtVal = null;
       if(null != typeOfItems) {
    	   wallArtVal = itemsWallArtValueSearch(req, sn, typeOfItems);
       }        
       sn.setAttribute(itemWallArtInSN, wallArtVal);              
       long designerInfoSavingId = clientInfoSaving.getDesignerInfoSavingId(); 
       String desnMessage = "";
       String desProfileImage = "";
       int desnMessagesCoun = 0;
       String conceptStatus1 = null;
       String renderingStatus1 = null;
       String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;
       if(designerInfoSavingId > 0) {
    	   DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
    	   desnMessage = designerInfoSaving.getQuirkyFactsAboutDesigner();
    	   byte[] desProfileImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();
    	   desProfileImage = javax.xml.bind.DatatypeConverter.printBase64Binary(desProfileImageFromDB);        	
    	   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), designerInfoSavingId);
    	   desnMessagesCoun = desnMessCountList.size();
    	   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);       	
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB((Long) sn.getAttribute(clientInfoSavingIdInSn), designerInfoSavingId);       	
    	   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
    	   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
    	   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
    	   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();       	
    	   sn.setAttribute(conceptStatusInSn, conceptStatus1);
    	   sn.setAttribute(renderingStatusInSn, renderingStatus1);
    	   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
    	   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
       }              
       ModelAndView mav = new ModelAndView(roomsInformationModification);        
       mav.addObject(typeOfSpaceVal, typeOfSpace);
       mav.addObject(typeOfDesignPack, designPack);
       sn.setAttribute(desnUpPhotoInSn, desProfileImage);     	
       mav.addObject(desnMessageCount, desnMessagesCoun);    	
       mav.addObject(itemWallArtValue, sn.getAttribute(itemWallArtInSN));
       mav.addObject(desMessage, desnMessage);
       mav.addObject(designerProfileImage, desProfileImage);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnProfileBio, sn.getAttribute(desnProfileBioInSn));
       mav.addObject(desnLocation, sn.getAttribute(desnLocationInSn));
       mav.addObject(desnFullName, sn.getAttribute(desnFullNameInSn));
       mav.addObject(conceptStatus, conceptStatus1);
       mav.addObject(renderingStatus, renderingStatus1);
       mav.addObject(secondRenderingStatus, secondRenderingStatus1);
       mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
       return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView accConceptsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);	
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();        
	   String uploadedConcept1Image = "";
	   String uploadedConcept2Image = "";
	   String revisedCon = null;	 
	   String likeImagesValue = "";
	   int desnMessagesCoun = 0;
	   String conceptStatus1 = null;
	   String renderingStatus1 = null;
	   String secondRenderingStatus1 = null;
	   String revisedRenderingStatus1 = null;
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);              
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
			   uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);
			   revisedCon = adminAssignClInfoSaving.getClientRequestedForConcept();
		   }  	
		   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon2InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getConcept2ImageUpload();
			   uploadedConcept2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   }     
		   likeImagesValue = conceptsLikeImagesDisplay(req, sn, clientInfoId, designInfoId);
		   if(!("").equals(uploadedConcept1Image) && !("").equals(uploadedConcept2Image)) {		    	
			   if(("Request for Final Concepts").equals(revisedCon)) {
				   mav = new ModelAndView(reverseConceptsRed);
			   } else {
				   mav = new ModelAndView(accDesnPackConceptsRed);
			   }
		   } else {
			   mav = new ModelAndView(accDesnPackConceptsTextRed);
		   } 		    	
		   mav.addObject(concept1UploadedImage, uploadedConcept1Image);
		   mav.addObject("concept2UploadedImage", uploadedConcept2Image);         	
		   mav.addObject(likeImagesValues, likeImagesValue);         	
		   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);  	
		   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
		   desnMessagesCoun = desnMessCountList.size();
		   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
		   mav.addObject(desnMessageCount, desnMessagesCoun);
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   adminAssignClInfoSavingModel.setConceptStatus(null);
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSavingModel);
		   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
		   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
		   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
		   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus(); 	
		   sn.setAttribute(conceptStatusInSn, conceptStatus1);
		   sn.setAttribute(renderingStatusInSn, renderingStatus1);
		   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
		   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
	   } else {
		   mav = new ModelAndView(accDesnPackConceptsTextRed);
	   }  
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(conceptStatus, conceptStatus1);
	   mav.addObject(renderingStatus, renderingStatus1);
	   mav.addObject(secondRenderingStatus, secondRenderingStatus1);
	   mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
	   return mav;
   }
  
   @Override
   @Transactional
   public JSONArray conceptsLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   String[] likeStatusSt = likeStatus.split("_");  
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);
		   if("Con1".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept1LikeStatus(likeStatusSt[1]);
		   } else if("Con2".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept2LikeStatus(likeStatusSt[1]);
		   } else {
			   adminAssignClInfoSaving.setRenderingLikeStatus(likeStatusSt[1]);
		   }
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
   
   @Override
   @Transactional
   public ModelAndView revisedConceptsRequestRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), (Long) sn.getAttribute(designerInfoSavingIdInSn));       	
       adminAssignClInfoSaving.setClientRequestedForConcept("Request for Final Concepts");
       adminAssignClInfoSaving.setNewUploads("YES");
       adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
       mav = clientRequestForConAndRendSentMailToDesigner(req, sn, (Long) sn.getAttribute(designerInfoSavingIdInSn));
       mav = accConceptsRedirection(req, sn);
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientRequestForConAndRendSentMailToDesigner(HttpServletRequest req, HttpSession sn, long designInfoId) {
	   ModelAndView mav;
       DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);
 	   long designerUserId = designerInfoSaving.getDesignerId();
 	   UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);        		
       String userID1 = userInformation.getUserName();
       String userID2 = "brennan.rachman@madwire.com";
       String userID3 = "marketing360+m24951@bcc.mad360.net";
       String[] emailList = {userID1, userID2, userID3};
       String firstName = userInformation.getFirstName();
       String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
       String subject = "You have a new request from a client.";            
       String type = "text/html";           
       EmailSending userEmail = new EmailSending();
       String fromAdd = "info@nookandcove.com";              
       String body = "<body>" 
                   + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                   + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                   + "<p style='padding-top: 5px;'>You have a new request from a client. Log in to your account to see what has been requested.</p>"
                   + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                   + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                   + "</div>"
                   + "</body> ";            
       try {
    	   userEmail.sendEmail(emailList, subject, body, type, fromAdd);        	
       } catch (Exception ex) {
    	   LOGGER.error("Client Request For Concepts And Renderings Sent Mail To Designer failed " + ex);
       }       
       mav = new ModelAndView();
       return mav;
   }
   
   @Override
   @Transactional
   public String conceptsLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   String likeImagesValue = "";      	
	   List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);   	
	   if(!con3DRendLikeImgsList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   String concept1LikeStatus = con3DRendLikeImgsValue.getConcept1LikeStatus();
		   String concept2LikeStatus = con3DRendLikeImgsValue.getConcept2LikeStatus();
		   String threeDRendLikeStatus = con3DRendLikeImgsValue.getRenderingLikeStatus();  		
		   String likeImage1Value = "";
		   String likeImage2Value = "";
		   String likeImage3Value = "";  		
		   if(null != concept1LikeStatus && !("").equals(concept1LikeStatus)) {
			   String[] con1LikeStatus = concept1LikeStatus.split(" ");
			   likeImage1Value = con1LikeStatus[0];
		   }  		
		   if(null != concept2LikeStatus && !("").equals(concept2LikeStatus)) {
			   String[] con2LikeStatus = concept2LikeStatus.split(" ");
			   likeImage2Value = con2LikeStatus[0];
		   }  		
		   if(null != threeDRendLikeStatus && !("").equals(threeDRendLikeStatus)) {
			   String[] thDRendLikeStatus = threeDRendLikeStatus.split(" ");
			   likeImage3Value = thDRendLikeStatus[0];
		   }    		
		   likeImagesValue = likeImage1Value + "_" + likeImage2Value + "_" + likeImage3Value;    		
	   }
	   return likeImagesValue;
   }
   
   @Override
   @Transactional
   public ModelAndView concept1ViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();       
	   String uploadedConcept1Image = "";         
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
			   uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
		   }
	   }               
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";      
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsAccPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoId, designInfoId);
	   if (!furnSpecs1ProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsAccPackSaving furnSpecs1ProductsModel : furnSpecs1ProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
	   		}	
	   		totalProductPrice = String.format("%.2f", totlProductPrice);
	   		totalProdPrice = "$" + totalProductPrice;
	   		productImagesList = productImagesList.replaceFirst("_,_", "");
	 	    productNamesList = productNamesList.replaceFirst("_,_", "");
	 	    productQuantityList = productQuantityList.replaceFirst("_,_", "");
	 	    productPriceList = productPriceList.replaceFirst("_,_", "");
	 	    productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
	 	    assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
	 	    productsIdList = productsIdList.replaceFirst("_,_", "");
	   }  	
	   mav = new ModelAndView(concept1ViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);       
	   mav.addObject(concept1UploadedImage, uploadedConcept1Image);
	   mav.addObject(viewProductImagesList, productImagesList);        
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView concept2ViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();       
	   String uploadedConcept2Image = "";         
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getConcept2ImageUpload();    		
			   uploadedConcept2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
	   		}
	   }	               
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsAccPackSaving> furnSpecs2ProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoId, designInfoId);
	   if (!furnSpecs2ProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsAccPackSaving furnSpecs1ProductsModel : furnSpecs2ProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
	   		}
	   		totalProductPrice = String.format("%.2f", totlProductPrice);
	 		totalProdPrice = "$" + totalProductPrice;
	 		productImagesList = productImagesList.replaceFirst("_,_", "");
	 	    productNamesList = productNamesList.replaceFirst("_,_", "");
	 	    productQuantityList = productQuantityList.replaceFirst("_,_", "");
	 	    productPriceList = productPriceList.replaceFirst("_,_", "");
	 	    productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
	 	    assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
	 	    productsIdList = productsIdList.replaceFirst("_,_", "");
	   }   	
	   mav = new ModelAndView(concept2ViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);	       
	   mav.addObject(concept2UploadedImage, uploadedConcept2Image);
	   mav.addObject(viewProductImagesList, productImagesList);
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView reDirConcept1ProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirConcept1ProductAddToCart");
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView concept1ProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;   
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);	   
	   String reffType = "Accessories Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
	   productSavingID = Long.parseLong(prodSavingIDString);
	   productCount = Integer.parseInt(numOfProduct);
	   }	   
	   List furnSpecs1ProductsList = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);	   
	   if(!furnSpecs1ProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }   		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);	   	
			   double totalProductPrice = productsPrice * prodCount;	   	
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsAccPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsAccPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
   			}
   		}   	
   		int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
   		sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
   		sn.setAttribute(popUpRefNameInSn, null);
 	    sn.setAttribute(noOfProductInSn, null);   		
   		mav = concept1ViewShopProductsRedirection(req, sn);
   		return mav;
   }
   
   @Override
   @Transactional
   public int totalAddCartItemsCountFromDB(HttpSession sn) {
	   int totalItemsCount = 0;   	
	   List totalAddCartItemsList = addClientProductsToCartSavingDAO.totalAddCartItemsListDisplay((Long) sn.getAttribute(userIdInSn));
	   if(!totalAddCartItemsList.isEmpty()){      		
		   String totalAddCartItemsString = totalAddCartItemsList.toString();
		   totalAddCartItemsString = totalAddCartItemsString.replace("[", "");
		   totalAddCartItemsString = totalAddCartItemsString.replace("]", "");          
		   String[] totalCartItemsCount = totalAddCartItemsString.split(", ");            
		   for (int i = 0; i < totalCartItemsCount.length; i++) {
			   int totCartItemsCountInt = Integer.parseInt(totalCartItemsCount[i]);
			   totalItemsCount = totalItemsCount + totCartItemsCountInt;
		   }
	   }
	   return totalItemsCount;
   }

   @Override
   @Transactional
   public ModelAndView reDirConcept2ProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirConcept2ProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView concept2ProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;   
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Accessories Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
	   productSavingID = Long.parseLong(prodSavingIDString);
	   productCount = Integer.parseInt(numOfProduct);
	   }   	
	   List furnSpecs1ProductsList = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);   	
	   if(!furnSpecs1ProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }   		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsAccPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);   		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsAccPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
   			}
   		}   	
   		int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
   		sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
   		sn.setAttribute(popUpRefNameInSn, null);
 	    sn.setAttribute(noOfProductInSn, null);   	
   		mav = concept2ViewShopProductsRedirection(req, sn);
   		return mav;
   }

   @Override
   @Transactional
   public ModelAndView accFinalConceptsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);          	
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                   
	   String uploaded3DRenderingImage = "";          
	   String likeImagesValue = "";
	   int desnMessagesCoun = 0;
	   String conceptStatus1 = null;
	   String renderingStatus1 = null;
	   String secondRenderingStatus1 = null;
	   String revisedRenderingStatus1 = null;
	   if(designInfoId > 0) {   	
		   List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInClientSide(clientInfoId, designInfoId);        
  	     	if(!adminAssign3DRendInfoList.isEmpty()){    		
  	     		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInClientSide(clientInfoId, designInfoId);  		
  	      		byte[] uploaded3DrendImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();
  	      		uploaded3DRenderingImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);
  	     	}  	     	
  	     	likeImagesValue = fullRoomDsnRoomRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);    	    	
  	     	if(!("").equals(uploaded3DRenderingImage)) {
  	     		mav = new ModelAndView(accDesnPackFinalConceptsRed);
  	     	} else {
  	     		mav = new ModelAndView(accDesnPackFinalConceptsTextRed);
    	    }    	    	    	
  	     	mav.addObject("concept3UploadedImage", uploaded3DRenderingImage);           	       	
           	mav.addObject(likeImagesValues, likeImagesValue);
           	sn.setAttribute(designerInfoSavingIdInSn, designInfoId);             	
           	List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
          	desnMessagesCoun = desnMessCountList.size();
          	sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
          	mav.addObject(desnMessageCount, desnMessagesCoun);
          	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);        	
          	adminAssignClInfoSavingModel.setRenderingStatus(null);
          	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSavingModel);          	
          	conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
          	renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
          	secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
          	revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();          	
          	sn.setAttribute(conceptStatusInSn, conceptStatus1);
          	sn.setAttribute(renderingStatusInSn, renderingStatus1);
          	sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
          	sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
	   } else {
		   mav = new ModelAndView(accDesnPackFinalConceptsTextRed);
	   }             
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(conceptStatus, conceptStatus1);
	   mav.addObject(renderingStatus, renderingStatus1);
	   mav.addObject(secondRenderingStatus, secondRenderingStatus1);
	   mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
	   return mav;
   }

   @Override
   @Transactional
   public JSONArray finalConceptsLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInClientSide(clientInfoId, designInfoId); 
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInClientSide(clientInfoId, designInfoId);
		   adminAssignClInfoSaving.setRenderingLikeStatus(likeStatus);
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }

   @Override
   @Transactional
   public String fullRoomDsnRoomRendLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   String likeImagesValue = "";      	
	   List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       	
	   if(!con3DRendLikeImgsList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   String revRendLikeStatus = con3DRendLikeImgsValue.getRenderingLikeStatus();      		
		   if(null != revRendLikeStatus && !("").equals(revRendLikeStatus)) {
			   likeImagesValue = revRendLikeStatus;
		   }
	   }      		
	   return likeImagesValue;
   }

   @Override
   @Transactional
   public ModelAndView finalConceptViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();       
	   String uploadedFinalConceptImage = "";         
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   }
	   }	               
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsAccPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsAccPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;	  		
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }   
	   mav = new ModelAndView(finalConceptViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);	       
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);	   
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFinalConceptProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFinalConceptProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView finalConceptProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;   
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Accessories Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
	   productSavingID = Long.parseLong(prodSavingIDString);
	   productCount = Integer.parseInt(numOfProduct);
	   }   	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);   	
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }   		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsAccPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);   		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsAccPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
   			}
	   }   	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);   	
	   mav = finalConceptViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView accShopRedirRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();	    
	   int desnMessagesCoun = 0;
	   String conceptStatus1 = null;
	   String renderingStatus1 = null;
	   String secondRenderingStatus1 = null;
	   String revisedRenderingStatus1 = null;
	   if(designInfoId > 0) { 
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);
		   if(!adminAssignCon1InfoList.isEmpty()){       
			   mav = shopViewShopProductsRedirection(req, sn);
		   } else {
			   mav = new ModelAndView(accDesnPackShopTheLookTextRed);
		   }	   		
		   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
		   desnMessagesCoun = desnMessCountList.size();
		   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
		   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
		   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
		   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();       	
		   sn.setAttribute(conceptStatusInSn, conceptStatus1);
		   sn.setAttribute(renderingStatusInSn, renderingStatus1);
		   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
		   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
	   	} else {
	   		mav = new ModelAndView(accDesnPackShopTheLookTextRed);
	   	}      	  	               
       	mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       	mav.addObject(desnMessageCount, desnMessagesCoun);
       	mav.addObject(conceptStatus, conceptStatus1);
       	mav.addObject(renderingStatus, renderingStatus1);
       	mav.addObject(secondRenderingStatus, secondRenderingStatus1);
       	mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
       	return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirShopFinalProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirShopFinalProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView shopProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;   
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Accessories Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
	   productSavingID = Long.parseLong(prodSavingIDString);
	   productCount = Integer.parseInt(numOfProduct);
	   }   	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);   	
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }   		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsAccPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsAccPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);   		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsAccPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }   	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	    sn.setAttribute(noOfProductInSn, null);   	
	   mav = shopViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView shopViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();       
	   String uploadedFinalConceptImage = "";         
	   if(designInfoId > 0) {     	
		   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInClientSide(clientInfoId, designInfoId);
		   List adminAssignFinalConInfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInClientSide(clientInfoId, designInfoId);		   
		   if(!adminAssignCon2InfoList.isEmpty() && !adminAssignFinalConInfoList.isEmpty()){			   
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   } else {			   
			   AdminAssignClientInfoToDesignerSaving adminAssignCon2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignCon2InfoSaving.getConcept1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);
		   }
	   }	               
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsAccPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsAccPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }   	
	   mav = new ModelAndView(finalViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);	       
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);        
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView messageMyDesigners(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   mav = new ModelAndView("redirect:" + reDirClientAndDesignerMes);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientMessageSendToDesignerRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   Timestamp currentDate = currentDate();
	   String timeString  = timeGettingFromCurrentDate();
	   timeString = timeString.replaceAll(" ", "");   
	   String todayDate = todayDateGettingFromCurrentDate();	      
	   String totalDate = todayDate + " " + timeString;
	   String oneTimeRefDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate) + "_C";
	   List<ClientDesignerMessageInfoSaving> clientAndDesnMsgInfoList = clientDesignerMessageInfoSavingDAO.oneTimeDateFormationCheckingInDB(oneTimeRefDate);
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();      
	   String typeOfSpace = clientInfoSaving.getTypeOfSpace();
	   String designPack = clientInfoSaving.getDesignPackage();
	   if(null != typeOfSpace) {
		   typeOfSpace = typeOfSpace.replace("_", " ");
	   }
	   String clientsMessage = req.getParameter("clientMessage"); 
	   clientsMessage = clientsMessage.replaceAll("[\n\r]", " ");
	   String clMsgData = totalDate +",_," + clientsMessage;               
	   if(designInfoId > 0) {
		   if (clientAndDesnMsgInfoList.isEmpty()) {
			   mav = clientOneTimeSentMailToDesigner(req, sn, designInfoId);
		   }
		   ClientDesignerMessageInfoSaving clDesMessageSavingModel = new ClientDesignerMessageInfoSaving();
		   clDesMessageSavingModel.setClientInfoSavingId(clientInfoId);
		   clDesMessageSavingModel.setDesignerInfoSavingId(designInfoId);
		   clDesMessageSavingModel.setMessageInfo(clMsgData);
		   clDesMessageSavingModel.setStatus("CLDESNEW");
		   clDesMessageSavingModel.setCreatedDate(currentDate);
		   clDesMessageSavingModel.setOneTimeRefDate(oneTimeRefDate);
		   clientDesignerMessageInfoSavingDAO.save(clDesMessageSavingModel);
		   List<ClientInfoSaving> archiveRowsList = clientInfoSavingDAO.designerArchiveClientRowCheck(clientInfoId, designInfoId);
		   if(!archiveRowsList.isEmpty()){
			   ClientInfoSaving dsnArchiveRowUpdate = clientInfoSavingDAO.designerArchiveClientsStatusCheck(clientInfoId, designInfoId);
			   dsnArchiveRowUpdate.setRoomStatus(null);
			   clientInfoSavingDAO.merge(dsnArchiveRowUpdate);
		   }
		   mav = new ModelAndView("redirect:" + reDirClientAndDesignerMes);
	   } else{
		   mav = new ModelAndView(messageMyDesigner);
		   mav.addObject("noDesignerStatus", "No Designer");
	   }
	   mav.addObject(typeOfSpaceVal, typeOfSpace);
	   mav.addObject(typeOfDesignPack, designPack);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientOneTimeSentMailToDesigner(HttpServletRequest req, HttpSession sn, long designInfoId) {
	   ModelAndView mav;
       DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);
 	   long designerUserId = designerInfoSaving.getDesignerId();
 	   UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);        		
       String toAdd = userInformation.getUserName();
       String firstName = userInformation.getFirstName();
       String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
       String subject = "You have a new message from a client.";            
       String type = "text/html";           
       EmailSending userEmail = new EmailSending();
       String fromAdd = "info@nookandcove.com";              
       String body = "<body>" 
                   + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                   + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                   + "<p style='padding-top: 5px;'>You have a new message from a client. Log in to your account to read your messages.</p>"
                   + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                   + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                   + "</div>"
                   + "</body> ";            
       try {
    	   userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
       } catch (Exception ex) {
    	   LOGGER.error("Client One Time Sent Mail To Designer failed " + ex);
       }       
       mav = new ModelAndView();
       return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView clientAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	   	
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();
       String typeOfSpace = clientInfoSaving.getTypeOfSpace();
       String designPack = clientInfoSaving.getDesignPackage();
       if(null != typeOfSpace) {
    	   typeOfSpace = typeOfSpace.replace("_", " ");
       }      
       String clientAndDesnMesList = "";
       int desnMessagesCoun = 0;
       String dsnFullName = null;
  	   String conceptStatus1 = null;
       String renderingStatus1 = null;
       String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;
       if(designInfoId > 0) {   	  
    	   DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);
    	   long designerUserId = designerInfoSaving.getDesignerId();
    	   
    	   UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);    	   
    	   String lastSingleName = String.valueOf(userInformation.getLastName().charAt(0)).toUpperCase();
    	   dsnFullName = userInformation.getFirstName() + " " + lastSingleName;    	       
    	   List<ClientDesignerMessageInfoSaving> clAndDesnMesInfoList = clientDesignerMessageInfoSavingDAO.clientAndDesignerMessageInfoRowVerificationInDB(clientInfoId, designInfoId);   		
    	   if (!clAndDesnMesInfoList.isEmpty()) {
    		   for (ClientDesignerMessageInfoSaving clAndDesnMesInfoModel : clAndDesnMesInfoList) {         		        		
    			   String clAndDesMesVal = clAndDesnMesInfoModel.getMessageInfo();
    			   clientAndDesnMesList = clientAndDesnMesList + "_,_" + clAndDesMesVal;
    		   }
    		   clientAndDesnMesList = clientAndDesnMesList.replaceFirst("_,_", "");
    	   }
    	   clientDesignerMessageInfoSavingDAO.designerMessagesStatusUpdateInClientSide(clientInfoId, designInfoId);
    	   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
    	   desnMessagesCoun = desnMessCountList.size();
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
    	   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
    	   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
    	   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
    	   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();       	
    	   sn.setAttribute(conceptStatusInSn, conceptStatus1);
    	   sn.setAttribute(renderingStatusInSn, renderingStatus1);
    	   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
    	   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
       }               
       mav = new ModelAndView(messageMyDesigner);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject("clientAndDesMessList", clientAndDesnMesList);
       mav.addObject("designerFullName", dsnFullName);
       sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
       mav.addObject(typeOfSpaceVal, typeOfSpace);
       mav.addObject(typeOfDesignPack, designPack);
       mav.addObject(conceptStatus, conceptStatus1);
       mav.addObject(renderingStatus, renderingStatus1);
       mav.addObject(secondRenderingStatus, secondRenderingStatus1);
       mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
       return mav;
   }
	
   @Override
   @Transactional
   public ModelAndView fullRmConceptsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);     	
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();              
       String uploadedConcept1Image = "";
       String uploadedConcept2Image = "";
       String roomRenderingReq = null;
       String secRenderingReq = null;
       String secRenPayStatus = null;       
       String likeImagesValue = "";
       int desnMessagesCoun = 0;
       String conceptStatus1 = null;
       String renderingStatus1 = null;
       String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;        
       if(designInfoId > 0) {     	
    	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);              
    	   if(!adminAssignCon1InfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
    		   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
    		   uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);
    		   roomRenderingReq = adminAssignClInfoSaving.getClientRequestedForRendering();
    		   secRenderingReq = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    		   secRenPayStatus = adminAssignClInfoSaving.getSecondRenderingPaymentStatus();
    	   }	     	
    	   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInClientSide(clientInfoId, designInfoId);                
    	   if(!adminAssignCon2InfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInClientSide(clientInfoId, designInfoId);    		
    		   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getConcept2ImageUpload();
    		   uploadedConcept2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
    	   }	        
    	   likeImagesValue = fullRoomConceptsLikeImagesDisplay(req, sn, clientInfoId, designInfoId);	    	    	
    	   if(!("").equals(uploadedConcept1Image) && !("").equals(uploadedConcept2Image)) {		    	
    		   mav = fullRmRenderingChecking(req, sn, roomRenderingReq, secRenPayStatus, secRenderingReq);
    	   } else {
    		   mav = new ModelAndView(fullRoomDesnPackConceptsTextRed);
    	   }	    		    	
    	   mav.addObject(concept1UploadedImage, uploadedConcept1Image);
    	   mav.addObject("concept2UploadedImage", uploadedConcept2Image);         	
    	   mav.addObject(likeImagesValues, likeImagesValue);
    	   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
    	   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);        	
    	   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
    	   desnMessagesCoun = desnMessCountList.size();
    	   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
    	   adminAssignClInfoSavingModel.setConceptStatus(null);
    	   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSavingModel);       	
    	   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
    	   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
    	   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
    	   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();       	
    	   sn.setAttribute(conceptStatusInSn, conceptStatus1);
    	   sn.setAttribute(renderingStatusInSn, renderingStatus1);
    	   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
    	   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);        	
       } else {
    	   mav = new ModelAndView(fullRoomDesnPackConceptsTextRed);
       }        
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, desnMessagesCoun);
       mav.addObject(conceptStatus, conceptStatus1);
       mav.addObject(renderingStatus, renderingStatus1);
       mav.addObject(secondRenderingStatus, secondRenderingStatus1);
       mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmRenderingChecking(HttpServletRequest req, HttpSession sn, String roomRenderingReq, String secRenPayStatus, String secRenderingReq) {
	   ModelAndView mav;         
       if(("Request for Rendering").equals(roomRenderingReq) && null == secRenPayStatus) {
    	   mav = new ModelAndView(fullRoomRenderingPleaseRed);
       } else if(("Second Rendering").equals(secRenderingReq) && null == secRenPayStatus) {
    	   mav = fullRmSecRenderingRedirection(req, sn);
       } else if(("Second Rendering").equals(secRenderingReq) && null != secRenPayStatus) {
    	   mav = new ModelAndView(fullRoomRenderingPleaseRed);
       } else {
    	   mav = new ModelAndView(fullRoomPackConceptsRed);
       }   	   
       return mav;
   }

   @Override
   @Transactional
   public String fullRoomConceptsLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   String likeImagesValue = "";      	
	   List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);   	
	   if(!con3DRendLikeImgsList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   String concept1LikeStatus = con3DRendLikeImgsValue.getConcept1LikeStatus();
		   String concept2LikeStatus = con3DRendLikeImgsValue.getConcept2LikeStatus();
		   String threeDRendLikeStatus = con3DRendLikeImgsValue.getRenderingLikeStatus();  		
		   String likeImage1Value = "";
		   String likeImage2Value = "";
		   String likeImage3Value = "";  		
		   if(null != concept1LikeStatus && !("").equals(concept1LikeStatus)) {
			   String[] con1LikeStatus = concept1LikeStatus.split(" ");
			   likeImage1Value = con1LikeStatus[0];
		   }  		
		   if(null != concept2LikeStatus && !("").equals(concept2LikeStatus)) {
			   String[] con2LikeStatus = concept2LikeStatus.split(" ");
			   likeImage2Value = con2LikeStatus[0];
		   }  		
		   if(null != threeDRendLikeStatus && !("").equals(threeDRendLikeStatus)) {
			   String[] thDRendLikeStatus = threeDRendLikeStatus.split(" ");
			   likeImage3Value = thDRendLikeStatus[0];
		   }    		
		   likeImagesValue = likeImage1Value + "_" + likeImage2Value + "_" + likeImage3Value;    		
	   }
	   return likeImagesValue;
   }

   @Override
   @Transactional
   public JSONArray fullRoomConceptsLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   String[] likeStatusSt = likeStatus.split("_");  
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);
		   if("Con1".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept1LikeStatus(likeStatusSt[1]);
		   } else if("Con2".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept2LikeStatus(likeStatusSt[1]);
		   } else {
			   adminAssignClInfoSaving.setRenderingLikeStatus(likeStatusSt[1]);
		   }
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }

   @Override
   @Transactional
   public ModelAndView renderingConsRequestRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;           
	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), (Long) sn.getAttribute(designerInfoSavingIdInSn));       	
	   adminAssignClInfoSaving.setClientRequestedForRendering("Request for Rendering");
	   adminAssignClInfoSaving.setNewUploads("YES");
	   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   mav = clientRequestForConAndRendSentMailToDesigner(req, sn, (Long) sn.getAttribute(designerInfoSavingIdInSn));
	   mav = fullRmConceptsRedirection(req, sn);
	   return mav;
   }
    
   @Override
   @Transactional
   public ModelAndView secRenderingConsRequestRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;           
	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), (Long) sn.getAttribute(designerInfoSavingIdInSn));
	   adminAssignClInfoSaving.setNewUploads("YES");
	   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   mav = secRenderingConsPaymentRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();         
	   int desnMessagesCoun = 0;
	   String conceptStatus1 = null;
	   String renderingStatus1 = null;
	   String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;
       if(designInfoId > 0) {      	  
    	   List revisedRendering1RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);
    	   List revisedRendering2RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2VerificationInClientSide(clientInfoId, designInfoId);       	          	  
    	   if(!revisedRendering1RedCheckList.isEmpty() && !revisedRendering2RedCheckList.isEmpty()){
    		   mav = fullRmDoubleRevisedRenderingRedirection(req, sn);
    	   } else if(!revisedRendering1RedCheckList.isEmpty() && revisedRendering2RedCheckList.isEmpty()){
    		   mav = fullRmSingleRevisedRenderingRedirection(req, sn);
    	   } else {    	      		
    		   mav = fullRmDesnRoomRenderingRedOnly(req, sn, clientInfoId, designInfoId);
    	   }   	      	
    	   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
    	   desnMessagesCoun = desnMessCountList.size();
    	   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
    	   adminAssignClInfoSavingModel.setRenderingStatus(null);
           adminAssignClInfoSavingModel.setRevisedRenderingStatus(null);
           adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSavingModel);           	
           conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
           renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
           secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
           revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();           	
           sn.setAttribute(conceptStatusInSn, conceptStatus1);
           sn.setAttribute(renderingStatusInSn, renderingStatus1);
           sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
           sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);   	      	
       	} else {
       		mav = new ModelAndView(fullRoomDesPackRenderingTextRed);
       	}          
        mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        mav.addObject(desnMessageCount, desnMessagesCoun);
        mav.addObject(conceptStatus, conceptStatus1);
        mav.addObject(renderingStatus, renderingStatus1);
        mav.addObject(secondRenderingStatus, secondRenderingStatus1);
        mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
        return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmDoubleRevisedRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav; 
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);          	
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                   
       String uploadedRender1Image = "";
       String uploadedRender2Image = "";
       String likeImagesValue = "";           
       if(designInfoId > 0) {     	
    	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);              
    	   if(!adminAssignCon1InfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
    		   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRevisedRendering1ImageUpload();    		
    		   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);       	     	
    	   }      	     	
    	   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2VerificationInClientSide(clientInfoId, designInfoId);                
    	   if(!adminAssignCon2InfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
    		   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRevisedRendering2ImageUpload();
    		   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
      	 	}
    	   likeImagesValue = fullRoomDsnRevisedRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);      	 
    	   mav = new ModelAndView(fullRoomDesPackDoubleRenderingReqRevisionRed);      	    		    	
      	   mav.addObject(concept1UploadedImage, uploadedRender1Image);
           mav.addObject(concept2UploadedImage, uploadedRender2Image);         	
           mav.addObject(likeImagesValues, likeImagesValue);
           mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
           mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
           mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
           mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
           mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
           sn.setAttribute(designerInfoSavingIdInSn, designInfoId);
       } else {
    	   mav = new ModelAndView(fullRoomDesPackRenderingTextRed);
       }           
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override
   @Transactional
   public String fullRoomDsnRevisedRendLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   String likeImagesValue = "";      	
	   List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);   	
	   if(!con3DRendLikeImgsList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   String revRendLikeStatus = con3DRendLikeImgsValue.getRevisedRenderingLikeStatus();  		
		   if(null != revRendLikeStatus && !("").equals(revRendLikeStatus)) {
			   likeImagesValue = revRendLikeStatus;
		   }
	   }  		
	   return likeImagesValue;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSingleRevisedRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);           	
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();               
       String uploadedRendering1Img = "";     
       String likeImagesValue = "";              
       if(designInfoId > 0) {   	
    	   List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);        
    	   if(!adminAssign3DRendInfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInClientSide(clientInfoId, designInfoId);  		
    		   byte[] uploaded3DrendImageFromDB = adminAssignClInfoSaving.getRevisedRendering1ImageUpload();
    		   uploadedRendering1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);         	    
    	   }   
    	   likeImagesValue = fullRoomDsnRevisedRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);        	
    	   mav = new ModelAndView(fullRoomDesPackSingleRenderingReqRevisionRed);        	
    	   mav.addObject("uploadedRendering1Image", uploadedRendering1Img);       	       	
           mav.addObject(likeImagesValues, likeImagesValue);
           mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
           mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
           mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
           mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
           mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
           sn.setAttribute(designerInfoSavingIdInSn, designInfoId);
       } else {
    	   mav = new ModelAndView(fullRoomDesPackRenderingTextRed);
       }               
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDesnRoomRenderingRedOnly(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;       
       List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);
       String clReqForRevRendStatus = null;
       if(!adminAssign3DRendInfoList.isEmpty()){    		
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);  		
    	   clReqForRevRendStatus = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();    	      		
       }	      	
       if(("Request for Revised Rendering").equals(clReqForRevRendStatus)){   	      		
    	   mav = fullRmDesnRoomRenderingInfoDisplayRedOnly(req, sn, clientInfoId, designInfoId);
       } else {
    	   mav = fullRmDesnRoomRenderingInfoRedOnly(req, sn, clientInfoId, designInfoId);
       }
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDesnRoomRenderingInfoDisplayRedOnly(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;       
       List rendering1RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);
       List rendering2RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerRendering2VerificationInClientSide(clientInfoId, designInfoId);
 	   if(!rendering1RedCheckList.isEmpty() && !rendering2RedCheckList.isEmpty()){    	      		
    	   mav = fullRmDoubleRenderingInfoDisplayRedirection(req, sn, clientInfoId, designInfoId);
       } else if(!rendering1RedCheckList.isEmpty() && rendering2RedCheckList.isEmpty()){
    	   mav = fullRmSingleRenderingInfoDisplayRedirection(req, sn, clientInfoId, designInfoId);
       } else {
    	   mav = new ModelAndView(fullRoomDesPackRenderingTextRed);
       }
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDoubleRenderingInfoDisplayRedirection(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;        
	   String uploadedRender1Image = "";
	   String uploadedRender2Image = "";
	   String likeImagesValue = "";              	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);              
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
		   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
		   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);   	     			
	   }     	     	
	   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering2VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon2InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
		   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering2ImageUpload();
		   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
	   }
	   likeImagesValue = fullRoomDsnRoomRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);     	    	
	   mav = new ModelAndView(fullRoomDesPackDoubleRenderingInfoDisplayRed);   	 		    	
	   mav.addObject(concept1UploadedImage, uploadedRender1Image);
	   mav.addObject(concept2UploadedImage, uploadedRender2Image);         	
	   mav.addObject(likeImagesValues, likeImagesValue);
	   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
	   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
	   mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
	   mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
	   mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
	   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);            
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSingleRenderingInfoDisplayRedirection(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;
	   String uploadedRendering1Img = "";     
	   String likeImagesValue = "";               	
	   List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);        
	   if(!adminAssign3DRendInfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);  		
		   byte[] uploaded3DrendImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();
		   uploadedRendering1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);     	      		
	   }  	     	
	   likeImagesValue = fullRoomDsnRoomRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);       	      	
	   mav = new ModelAndView(fullRoomDesPackSingleRenderingInfoDisplayRed);      	    	       	    	    	
	   mav.addObject("uploadedRendering1Image", uploadedRendering1Img);       	       	
	   mav.addObject(likeImagesValues, likeImagesValue);
	   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
	   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
	   mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
	   mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
	   mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
	   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);              
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDesnRoomRenderingInfoRedOnly(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;       
       List rendering1RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);
       List rendering2RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerRendering2VerificationInClientSide(clientInfoId, designInfoId); 	 
       if(!rendering1RedCheckList.isEmpty() && !rendering2RedCheckList.isEmpty()){    	      		
    	   mav = fullRmDoubleRenderingRedirection(req, sn, clientInfoId, designInfoId);
       } else if(!rendering1RedCheckList.isEmpty() && rendering2RedCheckList.isEmpty()){
    	   mav = fullRmSingleRenderingRedirection(req, sn, clientInfoId, designInfoId);
       } else {
    	   mav = new ModelAndView(fullRoomDesPackRenderingTextRed);
       }
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDoubleRenderingRedirection(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;    
	   String uploadedRender1Image = "";
	   String uploadedRender2Image = "";
	   String likeImagesValue = "";               	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);              
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
		   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
		   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);   	     			
	   }     	     	
	   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering2VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon2InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
		   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering2ImageUpload();
		   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
	   }
	   likeImagesValue = fullRoomDsnRoomRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);     	    	
	   mav = new ModelAndView(fullRoomDesPackDoubleRenderingInfoRed);   	    		    	
	   mav.addObject(concept1UploadedImage, uploadedRender1Image);
	   mav.addObject(concept2UploadedImage, uploadedRender2Image);         	
	   mav.addObject(likeImagesValues, likeImagesValue);
	   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
	   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
	   mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
	   mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
	   mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
	   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);            
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSingleRenderingRedirection(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   ModelAndView mav;
	   String uploadedRendering1Img = "";     
	   String likeImagesValue = "";                  	
	   List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);        
	   if(!adminAssign3DRendInfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);  		
		   byte[] uploaded3DrendImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();
		   uploadedRendering1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);     	      		
	   }  	     	
	   likeImagesValue = fullRoomDsnRoomRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);           	      	
	   mav = new ModelAndView(fullRoomDesPackSingleRenderingInfoRed);          	    	       	    	    	
	   mav.addObject("uploadedRendering1Image", uploadedRendering1Img);       	       	
	   mav.addObject(likeImagesValues, likeImagesValue);
	   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
	   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
	   mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
	   mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
	   mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
	   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);                  
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDesnRenderingReqRevisionRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;      
	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), (Long) sn.getAttribute(designerInfoSavingIdInSn));       	
	   adminAssignClInfoSaving.setClientRequestedForRevisedRendering("Request for Revised Rendering");
	   adminAssignClInfoSaving.setNewUploads("YES");
	   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   mav = clientRequestForConAndRendSentMailToDesigner(req, sn, (Long) sn.getAttribute(designerInfoSavingIdInSn));
	   mav = fullRmRenderingRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmConcept1ViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();        
       String uploadedConcept1Image = "";    
       if(designInfoId > 0) {     	
    	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);      
    	   if(!adminAssignCon1InfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
    		   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
    		   uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	   }
       }      
       String productImagesList = "";
       String productNamesList = "";
       String productQuantityList = "";
       String productPriceList = "";
       String productDescriptionList = "";
       String assemblyRequiredStatusList = "";
       String productsIdList = "";       
       String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
       List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoId, designInfoId);
       if (!furnSpecs1ProductsList.isEmpty()) {
    	   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : furnSpecs1ProductsList) {
    		   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
    		   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   productImagesList = productImagesList + "_,_" + productImageInDB;        		
    		   String productName = furnSpecs1ProductsModel.getProductName();
    		   productNamesList = productNamesList + "_,_" + productName;
    		   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
    		   String productPrice = furnSpecs1ProductsModel.getProductPrice();
    		   productPriceList = productPriceList + "_,_" + productPrice;    		   
    		   String description = furnSpecs1ProductsModel.getProductDescription();
    		   productDescriptionList = productDescriptionList + "_,_" + description;
    		   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
    		   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
    		   productsIdList = productsIdList + "_,_" + productId;
    		   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
    		   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
    		   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
    		   double prodtPrice = Double.parseDouble(prodPrice);
    		   double totProductsPrice = prodtPrice * ProdQuantity;
    		   totlProductPrice = totlProductPrice + totProductsPrice;
    	   }
    	   totalProductPrice = String.format("%.2f", totlProductPrice);
    	   totalProdPrice = "$" + totalProductPrice;
    	   productImagesList = productImagesList.replaceFirst("_,_", "");
           productNamesList = productNamesList.replaceFirst("_,_", "");
           productQuantityList = productQuantityList.replaceFirst("_,_", "");
           productPriceList = productPriceList.replaceFirst("_,_", "");
           productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
           assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
           productsIdList = productsIdList.replaceFirst("_,_", "");
       }   	
       mav = new ModelAndView(fullRoomConcept1ViewShopProducts);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(totalProdPriceInDB, totalProdPrice);        
       mav.addObject(concept1UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       mav.addObject(viewProductsIdList, productsIdList);        
       return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmConcept2ViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();        
	   String uploadedConcept2Image = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);      
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getConcept2ImageUpload();    		
			   uploadedConcept2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
      	   	}
	   }      	     
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";      	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs2ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!furnSpecs2ProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : furnSpecs2ProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;      	  
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;      	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }     	   	
	   mav = new ModelAndView(fullRoomConcept2ViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);      	       
	   mav.addObject(concept2UploadedImage, uploadedConcept2Image);
	   mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       mav.addObject(viewProductsIdList, productsIdList);	       
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;  
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();	   
	   String uploadedFinalConceptImage = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);  
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
    	   	}
	   }    	 
	   String productImagesList = "";
       String productNamesList = "";
       String productQuantityList = "";
       String productPriceList = "";
       String productDescriptionList = "";
       String assemblyRequiredStatusList = "";
       String productsIdList = "";
       String totalProdPrice = "";
       String totalProductPrice = "";
       double totlProductPrice = 0.0;
       List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
       if (!finalFurnSpecsProductsList.isEmpty()) {
    	   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
    		   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
    		   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		   productImagesList = productImagesList + "_,_" + productImageInDB;    	  		
    		   String productName = furnSpecs1ProductsModel.getProductName();
    		   productNamesList = productNamesList + "_,_" + productName;
    		   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
    		   String productPrice = furnSpecs1ProductsModel.getProductPrice();
    		   productPriceList = productPriceList + "_,_" + productPrice;    	  		
    		   String description = furnSpecs1ProductsModel.getProductDescription();
    		   productDescriptionList = productDescriptionList + "_,_" + description; 
    		   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
    		   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
    		   productsIdList = productsIdList + "_,_" + productId;
    		   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
    		   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
    		   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
    		   double prodtPrice = Double.parseDouble(prodPrice);
    		   double totProductsPrice = prodtPrice * ProdQuantity;
    		   totlProductPrice = totlProductPrice + totProductsPrice;
    	   }
    	   totalProductPrice = String.format("%.2f", totlProductPrice);
    	   totalProdPrice = "$" + totalProductPrice;
    	   productImagesList = productImagesList.replaceFirst("_,_", "");
           productNamesList = productNamesList.replaceFirst("_,_", "");
           productQuantityList = productQuantityList.replaceFirst("_,_", "");
           productPriceList = productPriceList.replaceFirst("_,_", "");
           productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
           assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
           productsIdList = productsIdList.replaceFirst("_,_", "");
       }      
       mav = new ModelAndView(fullRoomRenderingViewProducts);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(totalProdPriceInDB, totalProdPrice);    	       
       mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       mav.addObject(viewProductsIdList, productsIdList);	       
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDoubleRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;     
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();     
	   String uploadedRender1Image = "";
	   String uploadedRender2Image = "";
	   if(designInfoId > 0) {        	    	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);              
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);           	     		
		   }          	     	
		   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering2VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon2InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering2ImageUpload();
			   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   }        	    	
	   } 
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";       	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;       	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;       	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }      	   	
	   mav = new ModelAndView(fullRoomDoubleRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);       	       
	   mav.addObject(concept1UploadedImage, uploadedRender1Image);
	   mav.addObject(concept2UploadedImage, uploadedRender2Image);
	   mav.addObject(viewProductImagesList, productImagesList);        
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSingle2ndRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;  
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();  
	   String uploadedFinalConceptImage = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);    
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);        	     		
		   }
	   }    
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;    	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;    	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }   	   	
	   mav = new ModelAndView(fullRoomSingle2ndRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);	   
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);        
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDouble2ndRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;      
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();      
	   String uploadedRender1Image = "";
	   String uploadedRender2Image = "";
	   if(designInfoId > 0) {        	    	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);              
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);        	     		
		   }        	     	
		   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon2InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering2ImageUpload();
			   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   }        	    	
	   }	   
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";        	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;        	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;        	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }       	   	
	   mav = new ModelAndView(fullRoomDouble2ndRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);        	       
	   mav.addObject(concept1UploadedImage, uploadedRender1Image);
	   mav.addObject(concept2UploadedImage, uploadedRender2Image);
	   mav.addObject(viewProductImagesList, productImagesList);        
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSingleRevisedRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;             
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();	   
	   String uploadedFinalConceptImage = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);              
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRevisedRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);       	     	
		   }
	   }               	 
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;               	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;			   
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }   
	   mav = new ModelAndView(fullRoomSingleRevisedRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(totalProdPriceInDB, totalProdPrice);               	       
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);        
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);	       
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmDoubleRevisedRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav; 
   	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
   	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
   	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId(); 
   	   String uploadedRender1Image = "";
   	   String uploadedRender2Image = "";
   	   if(designInfoId > 0) {     	
   		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);              
   		   if(!adminAssignCon1InfoList.isEmpty()){    		
   			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
   			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRevisedRendering1ImageUpload();    		
   			   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);       	     	
   		   }   		   
   		   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2VerificationInClientSide(clientInfoId, designInfoId);                
   		   if(!adminAssignCon2InfoList.isEmpty()){    		
   			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
   			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRevisedRendering2ImageUpload();
   			   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
   		   }          	          	    	
   	   }   	 
   	   String productImagesList = "";
   	   String productNamesList = "";
   	   String productQuantityList = "";
   	   String productPriceList = "";
   	   String productDescriptionList = "";
   	   String assemblyRequiredStatusList = "";
   	   String productsIdList = "";   	    
   	   String totalProdPrice = "";
   	   String totalProductPrice = "";
   	   double totlProductPrice = 0.0;
   	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
   	   if (!finalFurnSpecsProductsList.isEmpty()) {
   		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
   	   			byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
   	   			String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
   	   			productImagesList = productImagesList + "_,_" + productImageInDB;   	  		
   	   			String productName = furnSpecs1ProductsModel.getProductName();
   	   			productNamesList = productNamesList + "_,_" + productName;
   	   			String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
   	   			productQuantityList = productQuantityList + "_,_" + productQuantity;
   	   			String productPrice = furnSpecs1ProductsModel.getProductPrice();
   	   			productPriceList = productPriceList + "_,_" + productPrice;   	  		
   	   			String description = furnSpecs1ProductsModel.getProductDescription();
   	   			productDescriptionList = productDescriptionList + "_,_" + description;
   	   			String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			    assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
   	   			long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
   	   			productsIdList = productsIdList + "_,_" + productId;
   	   			int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
   	   			String prodPrice = furnSpecs1ProductsModel.getProductPrice();
	   	   		prodPrice = prodPrice.replace(",","");
	 		    prodPrice = prodPrice.replace("$","");
   	   			double prodtPrice = Double.parseDouble(prodPrice);
   	   			double totProductsPrice = prodtPrice * ProdQuantity;
   	   			totlProductPrice = totlProductPrice + totProductsPrice;
   		   }
   		   totalProductPrice = String.format("%.2f", totlProductPrice);
   		   totalProdPrice = "$" + totalProductPrice;
   		   productImagesList = productImagesList.replaceFirst("_,_", "");
    	   productNamesList = productNamesList.replaceFirst("_,_", "");
    	   productQuantityList = productQuantityList.replaceFirst("_,_", "");
    	   productPriceList = productPriceList.replaceFirst("_,_", "");
    	   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
    	   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
    	   productsIdList = productsIdList.replaceFirst("_,_", "");
   	   }  	   	
   	   mav = new ModelAndView(fullRoomDoubleRevisedRenderingViewShopProducts);
   	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
   	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
   	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
   	   mav.addObject(totalProdPriceInDB, totalProdPrice);   	       
   	   mav.addObject(concept1UploadedImage, uploadedRender1Image);
   	   mav.addObject(concept2UploadedImage, uploadedRender2Image);
   	   mav.addObject(viewProductImagesList, productImagesList);        
   	   mav.addObject(viewProductNamesList, productNamesList);
   	   mav.addObject(viewProductQuantityList, productQuantityList);
   	   mav.addObject(viewProductPriceList, productPriceList);
   	   mav.addObject(viewProductDescriptionList, productDescriptionList);
   	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
   	   mav.addObject(viewProductsIdList, productsIdList);	       
   	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRmConcept1ProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRmConcept1ProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmConcept1ProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	   
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
		   productSavingID = Long.parseLong(prodSavingIDString);
		   productCount = Integer.parseInt(numOfProduct);
	   }          	
	   List furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);          	
	   if(!furnSpecs1ProductsList.isEmpty()){		 
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }          		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);	   	
			   double totalProductPrice = productsPrice * prodCount;	   	
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);          		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());       	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }          	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);          	
	   mav = fullRmConcept1ViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRmConcept2ProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRmConcept2ProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmConcept2ProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;           
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
		   productSavingID = Long.parseLong(prodSavingIDString);
		   productCount = Integer.parseInt(numOfProduct);
	   }           	
	   List furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);           	
	   if(!furnSpecs1ProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }           		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);           		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());             	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }           	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);	   
	   mav = fullRmConcept2ViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRmRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRmRenderingProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmRenderingProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	   
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
		   productSavingID = Long.parseLong(prodSavingIDString);
		   productCount = Integer.parseInt(numOfProduct);
	   }            	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }            		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }            	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);            	
	   mav = fullRmRenderingViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRmRevisedDoubleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRmRevisedDoubleRenderingProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmRevisedDoubleRenderingProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
		   productSavingID = Long.parseLong(prodSavingIDString);
		   productCount = Integer.parseInt(numOfProduct);
	   }       	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);	   
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
       			AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
       			int prodCount = addClProToCartSaving.getProductCount();
       			if(productCount > 0) {
       				prodCount = prodCount + productCount; 
       			} else {
       				prodCount = prodCount + 1;
       			}       		
       			String prodTotPrice = addClProToCartSaving.getProductPrice();   		
       			prodTotPrice = prodTotPrice.replaceAll(",", "");
         	   	double productsPrice = Double.parseDouble(prodTotPrice);
         	   	double totalProductPrice = productsPrice * prodCount;
         	   	String totProductPrice = String.format("%.2f", totalProductPrice);     	
         	   	addClProToCartSaving.setProductTotalPrice(totProductPrice);
         	   	addClProToCartSaving.setProductCount(prodCount);
         	   	addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);       		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());         	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }       	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);       	
	   mav = fullRmDoubleRevisedRenderingViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRm2ndSingleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRm2ndSingleRenderingProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRm2ndSingleRenderingProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;    
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
	   productSavingID = Long.parseLong(prodSavingIDString);
	   productCount = Integer.parseInt(numOfProduct);
	   }    	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);    	
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }    		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());      	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }    	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);    	
	   mav = fullRmSingle2ndRenderingViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRm2ndDoubleRenderingProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRm2ndDoubleRenderingProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRm2ndDoubleRenderingProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;    
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
	   productSavingID = Long.parseLong(prodSavingIDString);
	   productCount = Integer.parseInt(numOfProduct);
	   }    	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);    	
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount;
			   } else {
				   prodCount = prodCount + 1;
			   }    		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);    		
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());      	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }    	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);    	
	   mav = fullRmDouble2ndRenderingViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmShopRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();	    
       int desnMessagesCoun = 0;
       String conceptStatus1 = null;
       String renderingStatus1 = null;
       String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;
       if(designInfoId > 0) { 
    	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);
    	   if(!adminAssignCon1InfoList.isEmpty()){       
    		   mav = fullRmShopViewShopProductsRedirection(req, sn);
    	   } else {
    		   mav = new ModelAndView(fullRmDesnPackShopTheLookTextRed);
    	   }	   		
    	   List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
    	   desnMessagesCoun = desnMessCountList.size();
    	   sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
    	   conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
    	   renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
    	   secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
    	   revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();       	
    	   sn.setAttribute(conceptStatusInSn, conceptStatus1);
    	   sn.setAttribute(renderingStatusInSn, renderingStatus1);
    	   sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
    	   sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);
       } else {
    	   mav = new ModelAndView(fullRmDesnPackShopTheLookTextRed);
       }     	  	
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(desnMessageCount, desnMessagesCoun);
       mav.addObject(conceptStatus, conceptStatus1);
       mav.addObject(renderingStatus, renderingStatus1);
       mav.addObject(secondRenderingStatus, secondRenderingStatus1);
       mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView reDirFullRmShopProductAddToCart(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   sn.setAttribute(popUpRefNameInSn, req.getParameter(popUpRefName));
	   sn.setAttribute(noOfProductInSn, req.getParameter(noOfProduct));
	   mav = new ModelAndView("redirect:" + "reDirFullRmShopProductAddToCart");
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmShopProductAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;      
	   Timestamp currentDate = currentDate();
	   String prodSavingIDString = (String) sn.getAttribute(popUpRefNameInSn);
	   String numOfProduct = (String) sn.getAttribute(noOfProductInSn);
	   String reffType = "Full Room Design Package";
	   long productSavingID = 0;
	   int productCount = 0;
	   if(null != prodSavingIDString && null != numOfProduct) {
		   productSavingID = Long.parseLong(prodSavingIDString);
		   productCount = Integer.parseInt(numOfProduct);
	   }      	
	   List furnSpecsFinalProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowVerificationInDB(productSavingID);
	   List cartProductList = addClientProductsToCartSavingDAO.selectedClientProductFromCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);      	
	   if(!furnSpecsFinalProductsList.isEmpty()){   	
		   if(!cartProductList.isEmpty()){
			   AddClientProductsToCartSaving addClProToCartSaving = addClientProductsToCartSavingDAO.updateClientProductToCart((Long) sn.getAttribute(userIdInSn), productSavingID, reffType);
			   int prodCount = addClProToCartSaving.getProductCount();
			   if(productCount > 0) {
				   prodCount = prodCount + productCount; 
			   } else {
				   prodCount = prodCount + 1;
			   }      		
			   String prodTotPrice = addClProToCartSaving.getProductPrice();   		
			   prodTotPrice = prodTotPrice.replaceAll(",", "");
			   double productsPrice = Double.parseDouble(prodTotPrice);
			   double totalProductPrice = productsPrice * prodCount;
			   String totProductPrice = String.format("%.2f", totalProductPrice);     	
			   addClProToCartSaving.setProductTotalPrice(totProductPrice);
			   addClProToCartSaving.setProductCount(prodCount);
			   addClientProductsToCartSavingDAO.merge(addClProToCartSaving);
		   } else {
			   FurnitureSpecsProductsFullRoomPackSaving clProduUploadedByDesSaving = furnitureSpecsProductsFullRoomPackSavingDAO.addProductToCartRowUpdateInDB(productSavingID);
			   AddClientProductsToCartSaving addClProdToCartSaving = new AddClientProductsToCartSaving();
			   addClProdToCartSaving.setUserId((Long) sn.getAttribute(userIdInSn));
			   addClProdToCartSaving.setClientInfoSavingId(clProduUploadedByDesSaving.getClientInfoSavingId());
			   addClProdToCartSaving.setDesignerInfoSavingId(clProduUploadedByDesSaving.getDesignerInfoSavingId());
			   addClProdToCartSaving.setClientProductsUploadedByDesignerSavingId(clProduUploadedByDesSaving.getFurnitureSpecsProductsFullRoomPackSavingId());
			   addClProdToCartSaving.setConceptsThreedRefferance(reffType);
			   addClProdToCartSaving.setProductName(clProduUploadedByDesSaving.getProductName());
			   addClProdToCartSaving.setProductPrice(clProduUploadedByDesSaving.getProductPrice());
			   addClProdToCartSaving.setStoreName(clProduUploadedByDesSaving.getStoreName());
			   addClProdToCartSaving.setStoreURL(clProduUploadedByDesSaving.getStoreURL());
			   addClProdToCartSaving.setSkuName(clProduUploadedByDesSaving.getSkuName());
			   addClProdToCartSaving.setProductCount(productCount);
			   addClProdToCartSaving.setLikeStatus(req.getParameter("favLineName"));
			   addClProdToCartSaving.setCreatedDate(currentDate);
			   addClProdToCartSaving.setProductImageUpload(clProduUploadedByDesSaving.getProductImage());   	   	
			   String prodPrice = clProduUploadedByDesSaving.getProductPrice();
			   prodPrice = prodPrice.replaceAll(",", "");
			   double productPrice = Double.parseDouble(prodPrice);
			   double totalProductsPrice = productPrice * productCount;
			   String totProductsPrice = String.format("%.2f", totalProductsPrice);     	
			   addClProdToCartSaving.setProductTotalPrice(totProductsPrice);
			   addClientProductsToCartSavingDAO.save(addClProdToCartSaving);     	
		   }
	   }      	
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   sn.setAttribute(popUpRefNameInSn, null);
	   sn.setAttribute(noOfProductInSn, null);      	
	   mav = fullRmShopViewShopProductsRedirection(req, sn);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmShopViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();     
	   if(designInfoId > 0) {     	
		   List adminAssignConceptsInfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);
		   List adminAssignRenderingsInfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);
		   List adminAssignRevRenderingsInfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);
		   List adminAssign2ndRenderingsInfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);		   
		   if(!adminAssignConceptsInfoList.isEmpty() && adminAssignRenderingsInfoList.isEmpty() && adminAssignRevRenderingsInfoList.isEmpty() && adminAssign2ndRenderingsInfoList.isEmpty()){    		
			   mav	= fullRoomConcepViewShopProductsRedirection(req, sn);     	   		
		   } else if(!adminAssignConceptsInfoList.isEmpty() && !adminAssignRenderingsInfoList.isEmpty() && adminAssignRevRenderingsInfoList.isEmpty() && adminAssign2ndRenderingsInfoList.isEmpty()){    		
			   mav	= fullRoomRenderingViewShopProductsRedirection(req, sn);     	   		
		   } else if(!adminAssignConceptsInfoList.isEmpty() && !adminAssignRenderingsInfoList.isEmpty() && !adminAssignRevRenderingsInfoList.isEmpty() && adminAssign2ndRenderingsInfoList.isEmpty()){    		
			   mav	= fullRoomReviseRenderingViewShopProductsRedirection(req, sn);     	   		
		   } else if(!adminAssignConceptsInfoList.isEmpty() && !adminAssignRenderingsInfoList.isEmpty() && !adminAssignRevRenderingsInfoList.isEmpty() && !adminAssign2ndRenderingsInfoList.isEmpty()){    		
			   mav	= fullRoom2ndRenderingViewShopProductsRedirection(req, sn);     	   		
		   } else if(!adminAssignConceptsInfoList.isEmpty() && adminAssignRenderingsInfoList.isEmpty() && adminAssignRevRenderingsInfoList.isEmpty() && !adminAssign2ndRenderingsInfoList.isEmpty()){    		
			   mav	= fullRoom2ndRenderingViewShopProductsRedirection(req, sn);     	   		
		   } else if(!adminAssignConceptsInfoList.isEmpty() && !adminAssignRenderingsInfoList.isEmpty() && adminAssignRevRenderingsInfoList.isEmpty() && !adminAssign2ndRenderingsInfoList.isEmpty()){    		
			   mav	= fullRoom2ndRenderingViewShopProductsRedirection(req, sn);     	   		
		   } else {
			   mav = new ModelAndView(fullRmDesnPackShopTheLookTextRed);
		   } 
	   } else {
		   mav = new ModelAndView(fullRmDesnPackShopTheLookTextRed);
	   }
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRoomConcepViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;          
   	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
   	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
   	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();          
   	   String uploadedFinalConceptImage = "";    
   	   if(designInfoId > 0) {     	
   		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInClientSide(clientInfoId, designInfoId);
   		   if(!adminAssignCon1InfoList.isEmpty()){    		
   			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide(clientInfoId, designInfoId);    		
   			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
   			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
   		   }
   	   }          	          
   	   String productImagesList = "";
   	   String productNamesList = "";
   	   String productQuantityList = "";
   	   String productPriceList = "";
   	   String productDescriptionList = "";
   	   String assemblyRequiredStatusList = "";
   	   String productsIdList = "";   	    
   	   String totalProdPrice = "";
   	   String totalProductPrice = "";
   	   double totlProductPrice = 0.0;
   	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
   	   if (!finalFurnSpecsProductsList.isEmpty()) {
   		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
   			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
   			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
   			   productImagesList = productImagesList + "_,_" + productImageInDB;   	  		
   			   String productName = furnSpecs1ProductsModel.getProductName();
   			   productNamesList = productNamesList + "_,_" + productName;
   			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
   			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
   			   productPriceList = productPriceList + "_,_" + productPrice;   	  		
   			   String description = furnSpecs1ProductsModel.getProductDescription();
   			   productDescriptionList = productDescriptionList + "_,_" + description;
   			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
   			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
   			   productsIdList = productsIdList + "_,_" + productId;
   			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
   			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
   			   prodPrice = prodPrice.replace(",","");
   			   prodPrice = prodPrice.replace("$","");
   			   double prodtPrice = Double.parseDouble(prodPrice);
   			   double totProductsPrice = prodtPrice * ProdQuantity;
   			   totlProductPrice = totlProductPrice + totProductsPrice;
   		   }
   		   totalProductPrice = String.format("%.2f", totlProductPrice);
   		   totalProdPrice = "$" + totalProductPrice;
   		   productImagesList = productImagesList.replaceFirst("_,_", "");
    	   productNamesList = productNamesList.replaceFirst("_,_", "");
    	   productQuantityList = productQuantityList.replaceFirst("_,_", "");
    	   productPriceList = productPriceList.replaceFirst("_,_", "");
    	   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
    	   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
    	   productsIdList = productsIdList.replaceFirst("_,_", "");
   	   }  	   	
   	   mav = new ModelAndView(fullRoomConceptViewShopProducts);
   	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
   	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
   	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));   	       
   	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
   	   mav.addObject(viewProductImagesList, productImagesList);        
   	   mav.addObject(viewProductNamesList, productNamesList);
   	   mav.addObject(viewProductQuantityList, productQuantityList);
   	   mav.addObject(viewProductPriceList, productPriceList);
   	   mav.addObject(viewProductDescriptionList, productDescriptionList);
   	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
   	   mav.addObject(viewProductsIdList, productsIdList);
   	   mav.addObject(totalProdPriceInDB, totalProdPrice);
   	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRoomRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;     
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();     
	   String uploadedFinalConceptImage = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   }
	   }     	   	
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";    	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;    	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;    	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }   	   	
	   mav = new ModelAndView(fullRoomRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));	   
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);     
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);
	   mav.addObject(totalProdPriceInDB, totalProdPrice);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRoomReviseRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;      
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();      
	   String uploadedFinalConceptImage = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getRevisedRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
     	   	}
	   }          	    
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";     	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;     	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;     	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }    	   	
	   mav = new ModelAndView(fullRoomReviseRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));     	    
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);     
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);
	   mav.addObject(totalProdPriceInDB, totalProdPrice);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRoom2ndRenderingViewShopProductsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;       
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();       
	   String uploadedFinalConceptImage = "";    
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getSecondRendering1ImageUpload();    		
			   uploadedFinalConceptImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
      	  	}
	   }     	   
	   String productImagesList = "";
	   String productNamesList = "";
	   String productQuantityList = "";
	   String productPriceList = "";
	   String productDescriptionList = "";
	   String assemblyRequiredStatusList = "";
	   String productsIdList = "";      	    
	   String totalProdPrice = "";
	   String totalProductPrice = "";
	   double totlProductPrice = 0.0;
	   List<FurnitureSpecsProductsFullRoomPackSaving> finalFurnSpecsProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
	   if (!finalFurnSpecsProductsList.isEmpty()) {
		   for (FurnitureSpecsProductsFullRoomPackSaving furnSpecs1ProductsModel : finalFurnSpecsProductsList) {
			   byte[] uploadedImageFromDB = furnSpecs1ProductsModel.getProductImage();
			   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
			   productImagesList = productImagesList + "_,_" + productImageInDB;      	  		
			   String productName = furnSpecs1ProductsModel.getProductName();
			   productNamesList = productNamesList + "_,_" + productName;
			   String productQuantity = String.valueOf(furnSpecs1ProductsModel.getProductQuantity());
			   productQuantityList = productQuantityList + "_,_" + productQuantity;
			   String productPrice = furnSpecs1ProductsModel.getProductPrice();
			   productPriceList = productPriceList + "_,_" + productPrice;      	  		
			   String description = furnSpecs1ProductsModel.getProductDescription();
			   productDescriptionList = productDescriptionList + "_,_" + description;
			   String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
			   assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus;
			   long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
			   productsIdList = productsIdList + "_,_" + productId;
			   int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
			   String prodPrice = furnSpecs1ProductsModel.getProductPrice();
			   prodPrice = prodPrice.replace(",","");
    		   prodPrice = prodPrice.replace("$","");
			   double prodtPrice = Double.parseDouble(prodPrice);
			   double totProductsPrice = prodtPrice * ProdQuantity;
			   totlProductPrice = totlProductPrice + totProductsPrice;
		   }
		   totalProductPrice = String.format("%.2f", totlProductPrice);
		   totalProdPrice = "$" + totalProductPrice;
		   productImagesList = productImagesList.replaceFirst("_,_", "");
		   productNamesList = productNamesList.replaceFirst("_,_", "");
		   productQuantityList = productQuantityList.replaceFirst("_,_", "");
		   productPriceList = productPriceList.replaceFirst("_,_", "");
		   productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
		   assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");
		   productsIdList = productsIdList.replaceFirst("_,_", "");
	   }      	   	
	   mav = new ModelAndView(fullRoom2ndRenderingViewShopProducts);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));      	    
	   mav.addObject(concept2UploadedImage, uploadedFinalConceptImage);
	   mav.addObject(viewProductImagesList, productImagesList);     
	   mav.addObject(viewProductNamesList, productNamesList);
	   mav.addObject(viewProductQuantityList, productQuantityList);
	   mav.addObject(viewProductPriceList, productPriceList);
	   mav.addObject(viewProductDescriptionList, productDescriptionList);
	   mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
	   mav.addObject(viewProductsIdList, productsIdList);
	   mav.addObject(totalProdPriceInDB, totalProdPrice);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSecRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;     
       long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);      	
       ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
       long designInfoId = clientInfoSaving.getDesignerInfoSavingId();          
       String uploaded3DRenderingImage = "";     
       String likeImagesValue = "";
       String secRenderingReq = null;
       String secRenPayStatus = null;
       int desnMessagesCoun = 0;
       String conceptStatus1 = null;
       String renderingStatus1 = null;
       String secondRenderingStatus1 = null;
       String revisedRenderingStatus1 = null;
       if(designInfoId > 0) {   	
    	   List adminAssign2ndRendPayList = adminAssignClientInfoToDesignerSavingDAO.secondRenderingPaymentCheckingForClientSide(clientInfoId, designInfoId);    	   
    	   List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInClientSide(clientInfoId, designInfoId);
    	   if(!adminAssign2ndRendPayList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.secondRenderingPaymentForClientSide(clientInfoId, designInfoId);    		
    		   secRenderingReq = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    		   secRenPayStatus = adminAssignClInfoSaving.getSecondRenderingPaymentStatus();    		
    	   }    	   
    	   if(!adminAssign3DRendInfoList.isEmpty()){    		
    		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInClientSide(clientInfoId, designInfoId);  		
    		   byte[] uploaded3DrendImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();
    		   uploaded3DRenderingImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);    		   
    		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);    	      		
   	     	}    	   
     	  	likeImagesValue = fullRoomDsn2ndRendLikeImagesDisplay(req, sn, clientInfoId, designInfoId);     	    	 
     	  	if(("Second Rendering").equals(secRenderingReq) && null == secRenPayStatus) {
     	  		mav = secRenderingConsPaymentRedirection(req, sn);
     	  	} else if(("Second Rendering").equals(secRenderingReq) && null != secRenPayStatus) {     	  		
     	  		mav = fullRmSecRenderingConceptsRedirection(req, sn);
     	  	} else {
   	    		mav = new ModelAndView(fullRoomSecRenderingTextRed);
   	    	}     	    	    	
     	    mav.addObject("concept3UploadedImage", uploaded3DRenderingImage);       	       	
          	mav.addObject(likeImagesValues, likeImagesValue);
          	mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
          	sn.setAttribute(designerInfoSavingIdInSn, designInfoId);          	
          	List desnMessCountList = clientDesignerMessageInfoSavingDAO.designerMessageInfoCountInClientSide(clientInfoId, designInfoId);
          	desnMessagesCoun = desnMessCountList.size();
          	sn.setAttribute(desnMessageCountInSN, desnMessagesCoun);
          	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSavingModel = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);       	
          	adminAssignClInfoSavingModel.setSecondRenderingStatus(null);
          	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSavingModel);       	
          	conceptStatus1 = adminAssignClInfoSavingModel.getConceptStatus();
          	renderingStatus1 = adminAssignClInfoSavingModel.getRenderingStatus();
          	secondRenderingStatus1 = adminAssignClInfoSavingModel.getSecondRenderingStatus();
          	revisedRenderingStatus1 = adminAssignClInfoSavingModel.getRevisedRenderingStatus();       	
          	sn.setAttribute(conceptStatusInSn, conceptStatus1);
          	sn.setAttribute(renderingStatusInSn, renderingStatus1);
          	sn.setAttribute(secondRenderingStatusInSn, secondRenderingStatus1);
          	sn.setAttribute(revisedRenderingStatusInSn, revisedRenderingStatus1);          	
       } else {
    	   mav = new ModelAndView(fullRoomSecRenderingTextRed);
    	   mav.addObject(desnUserIdRef, "No Designer Yet");
       }          
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(conceptStatus, conceptStatus1);
       mav.addObject(renderingStatus, renderingStatus1);
       mav.addObject(secondRenderingStatus, secondRenderingStatus1);
       mav.addObject(revisedRenderingStatus, revisedRenderingStatus1);
       return mav;
   }

   @Override
   @Transactional
   public String fullRoomDsn2ndRendLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   String likeImagesValue = "";      	
	   List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);        	
	   if(!con3DRendLikeImgsList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   String revRendLikeStatus = con3DRendLikeImgsValue.getSecondRenderingLikeStatus();       		
		   	if(null != revRendLikeStatus && !("").equals(revRendLikeStatus)) {
		   		likeImagesValue = revRendLikeStatus;
		   	}
	   }    		
	   return likeImagesValue;
   }

   @Override
   @Transactional
   public ModelAndView secRenderingConsPaymentRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	   
	   String paybleAmount = null;	    
	   String secRendAmount = req.getParameter(secRenderPrice);
	   if(null != secRendAmount) {
		   double paybleAmtDb = Double.parseDouble(secRendAmount);		   
		   paybleAmount = String.format("%.2f", paybleAmtDb);
	   }
	   mav = new ModelAndView(fullRoomSecRenderingPaymentRed);	   
	   mav.addObject(totalPaybleAmount, paybleAmount);
	   mav.addObject(secRenderingAmount, paybleAmount);
	   sn.setAttribute(totalCheckoutAmountInSn, paybleAmount);
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSecRenderingConceptsRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;          
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);             	
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();               
	   if(designInfoId > 0) {        	   
		   List secRendering1RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);
		   List secRendering2RedCheckList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2VerificationInClientSide(clientInfoId, designInfoId);		   
		   if(!secRendering1RedCheckList.isEmpty() && !secRendering2RedCheckList.isEmpty()){     	      		
			   mav = fullRmDoubleSecondRenderingRedirection(req, sn);
		   } else if(!secRendering1RedCheckList.isEmpty() && secRendering2RedCheckList.isEmpty()){     	      		
			   mav = fullRmSingleSecondRenderingRedirection(req, sn);
		   } else {
			   mav = new ModelAndView(fullRoomSecRenderingPaymentSuccessRed);
		   }		   
	   } else {
		   mav = new ModelAndView(fullRoomSecRenderingTextRed);
	   }	   
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView fullRmDoubleSecondRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;        
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);    	
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();             
	   String uploadedRender1Image = "";
	   String uploadedRender2Image = "";
	   String likeImagesValue = "";      
	   if(designInfoId > 0) {     	
		   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);              
		   if(!adminAssignCon1InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getSecondRendering1ImageUpload();    		
			   uploadedRender1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);        	     		
		   }	     	
		   List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2VerificationInClientSide(clientInfoId, designInfoId);                
		   if(!adminAssignCon2InfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2UpdationInClientSide(clientInfoId, designInfoId);    		
			   byte[] uploadedConcept2ImageFromDB = adminAssignClInfoSaving.getSecondRendering2ImageUpload();
			   uploadedRender2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);    		
		   }	        
		   likeImagesValue = fullRoomSecRendConceptsLikeImagesDisplay(req, sn, clientInfoId, designInfoId);	    	
		   mav = new ModelAndView(fullRmDesnDoubleSecondRenderingConcepts);	    	
		   mav.addObject(concept1UploadedImage, uploadedRender1Image);
		   mav.addObject(concept2UploadedImage, uploadedRender2Image);         	
		   mav.addObject(likeImagesValues, likeImagesValue);
		   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
		   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
		   mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
		   mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
		   mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
		   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);
	   } else {
		   mav = new ModelAndView(fullRoomSecRenderingTextRed);
	   }       
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }
   
   @Override
   @Transactional
   public String fullRoomSecRendConceptsLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
	   String likeImagesValue = "";      	
	   List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);   	
	   if(!con3DRendLikeImgsList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
		   String concept1LikeStatus = con3DRendLikeImgsValue.getConcept1LikeStatus();
		   String concept2LikeStatus = con3DRendLikeImgsValue.getConcept2LikeStatus();
		   String threeDRendLikeStatus = con3DRendLikeImgsValue.getSecondRenderingLikeStatus();  		    		
		   String likeImage1Value = "";
		   String likeImage2Value = "";
		   String likeImage3Value = "";  		
		   if(null != concept1LikeStatus && !("").equals(concept1LikeStatus)) {
			   String[] con1LikeStatus = concept1LikeStatus.split(" ");
			   likeImage1Value = con1LikeStatus[0];
		   }  		
		   if(null != concept2LikeStatus && !("").equals(concept2LikeStatus)) {
			   String[] con2LikeStatus = concept2LikeStatus.split(" ");
			   likeImage2Value = con2LikeStatus[0];
		   }  		
		   if(null != threeDRendLikeStatus && !("").equals(threeDRendLikeStatus)) {
			   String[] thDRendLikeStatus = threeDRendLikeStatus.split(" ");
			   likeImage3Value = thDRendLikeStatus[0];
		   }    		
		   likeImagesValue = likeImage1Value + "_" + likeImage2Value + "_" + likeImage3Value;    		
	   }
	   return likeImagesValue;
   }

   @Override
   @Transactional
   public ModelAndView fullRmSingleSecondRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;     
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);          	
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), clientInfoId);
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();	   
	   String uploadedRendering1Img = "";     
	   String likeImagesValue = "";              
	   if(designInfoId > 0) {   	
		   List adminAssign3DRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);        
		   if(!adminAssign3DRendInfoList.isEmpty()){    		
			   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);  		
			   byte[] uploaded3DrendImageFromDB = adminAssignClInfoSaving.getSecondRendering1ImageUpload();
			   uploadedRendering1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);          	      		
		   }  	     	
		   likeImagesValue = fullRoomSecRendConceptsLikeImagesDisplay(req, sn, clientInfoId, designInfoId);         	    
		   mav = new ModelAndView(fullRmDesnSingleSecondRenderingConcepts);      	    		       	    	    	
		   mav.addObject("uploadedRendering1Image", uploadedRendering1Img);       	       	
		   mav.addObject(likeImagesValues, likeImagesValue);
		   mav.addObject(desnMessageCount, sn.getAttribute(desnMessageCountInSN));
		   mav.addObject(conceptStatus, sn.getAttribute(conceptStatusInSn));
		   mav.addObject(renderingStatus, sn.getAttribute(renderingStatusInSn));
		   mav.addObject(secondRenderingStatus, sn.getAttribute(secondRenderingStatusInSn));
		   mav.addObject(revisedRenderingStatus, sn.getAttribute(revisedRenderingStatusInSn));
		   sn.setAttribute(designerInfoSavingIdInSn, designInfoId);
	   } else {
		   mav = new ModelAndView(fullRoomSecRenderingTextRed);
	   }              
	   mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView secondRenderingPaymentInfoSavingInDb(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       String secRendAmount = req.getParameter(secRenderingAmount);
       double remGiftAmount = 0;
       if("" != req.getParameter(remGiftCardPrice)) {
    	   remGiftAmount = Double.parseDouble(req.getParameter(remGiftCardPrice));
       }
       long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
       String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear);
       Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
       String apiLoginId1 = req.getParameter(apiLoginId);
       String transactionKey1 = req.getParameter(transactionKey);
       String totalPableAmt = req.getParameter(amount);
	       mav = paymentGatewayService.secRenderingPaymentGatewayRedirectionDisplay(req, sn, cardNumber, expirationDate, cardCode, apiLoginId1, transactionKey1, totalPableAmt, req.getParameter(nameOnCard), secRendAmount, req.getParameter(giftCardPrice));
	       String returnVal = (String) sn.getAttribute(returnTypeInSn);       
	       if(("This transaction has been approved.").equals(returnVal)) { 	   
	    	   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.secondRenderingPaymentForClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), (Long) sn.getAttribute(designerInfoSavingIdInSn));       	
	           adminAssignClInfoSaving.setClientPurchasedForSecondRendering("Second Rendering");
	           adminAssignClInfoSaving.setNewUploads("YES");
	           adminAssignClInfoSaving.setSecondRenderingPaymentStatus(returnVal);
	           adminAssignClInfoSaving.setPaymentInfoSavingId((Long) sn.getAttribute(paymentInfoSavingIdInSn));
	           adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);       	
	    	   List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(req.getParameter(giftCuponCode));
	           if(!giftInfoSavingList.isEmpty()){
	        	   GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(req.getParameter(giftCuponCode));
	        	   if(0 == remGiftAmount) {
	        		   giftInfoSavingModel.setUsedGiftStatus("USED");
	        	   }
	        	   giftInfoSavingModel.setRemainingGiftPrice(req.getParameter(remGiftCardPrice));
	        	   giftInfoSavingDAO.merge(giftInfoSavingModel);
	        	   mav = giftCardPurchasedEmailSendToClient(req, sn);
	           }           
	           mav = clientRequestForConAndRendSentMailToDesigner(req, sn, (Long) sn.getAttribute(designerInfoSavingIdInSn));
	           mav = new ModelAndView(fullRoomSecRenderingPaymentSuccessRed);
	           sn.setAttribute(returnTypeInSn, null);
	       	   sn.setAttribute(paymentInfoSavingIdInSn, null);           
	       } else {
	    	   sn.setAttribute(totalCheckoutAmountInSn, sn.getAttribute(packagePriceInSn));
	    	   mav = new ModelAndView(fullRoomSecRenderingPaymentRed);            
	    	   mav.addObject(packagePrice, sn.getAttribute(packagePriceInSn));
	    	   mav.addObject(paymentValStatus, "Payment Fail");
	    	   mav.addObject(paymentReturnStatus, returnVal);    	   
	    	   mav.addObject(giftCuponCode, req.getParameter(giftCuponCode));    	   
	    	   mav.addObject(giftCardPrice, req.getParameter(giftCardPrice));
	           mav.addObject(remGiftCardPrice, req.getParameter(remGiftCardPrice));
	           mav.addObject(totalPaybleAmount, req.getParameter(amount));
	           mav.addObject(secRenderingAmount, secRendAmount);           
	           mav.addObject(payCardNumber, req.getParameter(payCardNumber));
	           mav.addObject(payExpMonth, req.getParameter(payExpMonth));
	           mav.addObject(payExpYear, req.getParameter(payExpYear));
	           mav.addObject(nameOnCard, req.getParameter(nameOnCard));
	           mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
	           sn.setAttribute(totalCheckoutAmountInSn, req.getParameter(amount));
	       }
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView zeroSecondRenderingPaymentInfoSavingInDb(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       String secRendAmount = req.getParameter(secRenderingAmount);
       double remGiftAmount = 0;
       if("" != req.getParameter(remGiftCardPrice)) {
    	   remGiftAmount = Double.parseDouble(req.getParameter(remGiftCardPrice));
       }       
       String totalPableAmt = req.getParameter(amount);
       mav = zeroSecRenderingCheckoutPaymentDisplay(req, sn, totalPableAmt, secRendAmount, req.getParameter(giftCardPrice), req.getParameter(giftCuponCode), req.getParameter(remGiftCardPrice), remGiftAmount);
       mav = new ModelAndView(fullRoomSecRenderingPaymentSuccessRed);       
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override 
   @Transactional
   public ModelAndView zeroSecRenderingCheckoutPaymentDisplay(HttpServletRequest req, HttpSession sn, String amount, String totalAmount, String giftAmount, String giftCuponCode, String remGiftCardPrice, double remGiftAmount) {
	   ModelAndView mav;
       List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(giftCuponCode);
       String accountType = null;
       String authorizationCode = null;
       long transactionNumber = 0; 	   	
       String cardNumber = null;
       String expirationDate = null;
       String nameOnCard = null;
       if(!giftInfoSavingList.isEmpty()){
    	   GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(giftCuponCode);
    	   if(0 == remGiftAmount) {
    		   giftInfoSavingModel.setUsedGiftStatus("USED");
    	   }
       	   giftInfoSavingModel.setRemainingGiftPrice(remGiftCardPrice);
       	   giftInfoSavingDAO.merge(giftInfoSavingModel);
       	   mav = giftCardPurchasedEmailSendToClient(req, sn);       	   
       }     
       mav = clientRequestForConAndRendSentMailToDesigner(req, sn, (Long) sn.getAttribute(designerInfoSavingIdInSn));      
       Timestamp currentDate = currentDate(); 
	   ClientPackageAndRenderingPaymentInfoSaving clPackAndSecRendModel = new ClientPackageAndRenderingPaymentInfoSaving();
	   clPackAndSecRendModel.setUserId((Long) sn.getAttribute(userIdInSn));
	   clPackAndSecRendModel.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
	   clPackAndSecRendModel.setPayCardNumber(cardNumber);
	   clPackAndSecRendModel.setAccountType(accountType);
	   clPackAndSecRendModel.setPayExpDate(expirationDate);
	   clPackAndSecRendModel.setPayCvvNumber("****");
	   clPackAndSecRendModel.setPaymentStatus("This transaction has been approved.");
	   clPackAndSecRendModel.setNameOnCard(nameOnCard);
	   clPackAndSecRendModel.setEstimatedAmount(totalAmount);
	   clPackAndSecRendModel.setGiftAmount(giftAmount);
	   clPackAndSecRendModel.setAuthorizationCode(authorizationCode);
	   clPackAndSecRendModel.setTransactionNumber(transactionNumber);
	   clPackAndSecRendModel.setTypeOfPayment("Rendering Payment");
	   clPackAndSecRendModel.setTotalPaybleAmount(amount);
	   clPackAndSecRendModel.setCreatedDate(currentDate);
	   String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	   clPackAndSecRendModel.setCreatedDateInSt(todayDate);
	   clientPackageAndRenderingPaymentInfoSavingDAO.save(clPackAndSecRendModel);
       long paymentInfoSavingId = clPackAndSecRendModel.getClientPackageAndRenderingPaymentInfoSavingId();
       AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInClientSide((Long) sn.getAttribute(clientInfoSavingIdInSn), (Long) sn.getAttribute(designerInfoSavingIdInSn));       	
       adminAssignClInfoSaving.setClientPurchasedForSecondRendering("Second Rendering");
       adminAssignClInfoSaving.setNewUploads("YES");
       adminAssignClInfoSaving.setSecondRenderingPaymentStatus("This transaction has been approved.");
       adminAssignClInfoSaving.setPaymentInfoSavingId(paymentInfoSavingId);
       adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving); 
       mav = new ModelAndView();      
       return mav;
   } 
   
   @Override
   @Transactional
   public ModelAndView giftCardInfoChecInRenderingRedirection(HttpServletRequest req, HttpSession sn) {
	   LOGGER.debug("giftCardInfoChecInRenderingRedirection...Service");        
	   ModelAndView mav;             	
	   String giftCdPrice = null;
	   double secRendAmountDB = 0;
	   double giftCardPriceInDB = 0;
	   double remGiftPrice = 0;
	   double totalPableAmount = 0;
	   double giftAmountInDB = 0;
	   String totPableAmt = null;
	   String remGiftAmt = null;
	   String giftAmount = null;
	   String giftCdStatus = null;	   	   
	   String secRendAmount = req.getParameter(secRenderingAmount);
	   if(null != secRendAmount) {
		   secRendAmountDB = Double.parseDouble(secRendAmount);		   
	   }	   
	   List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(req.getParameter(payGiftCard));
	   if(!giftInfoSavingList.isEmpty()){
	       GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(req.getParameter(payGiftCard));
	       giftCdPrice = giftInfoSavingModel.getRemainingGiftPrice();	       
	       if (null != giftCdPrice) {
	    	   giftCardPriceInDB = Double.parseDouble(giftCdPrice);
	       }                                    
	       if(giftCardPriceInDB >= secRendAmountDB) {            	
	    	   remGiftPrice = giftCardPriceInDB - secRendAmountDB;
	           totalPableAmount = 0;
	           giftAmountInDB = secRendAmountDB;
	       } else if(secRendAmountDB > giftCardPriceInDB) {
	    	   totalPableAmount = secRendAmountDB - giftCardPriceInDB;
	           giftAmountInDB = giftCardPriceInDB;
	           remGiftPrice = 0;
	       }            
	       totPableAmt = String.format("%.2f", totalPableAmount);
	       remGiftAmt = String.format("%.2f", remGiftPrice);
	       giftAmount = String.format("%.2f", giftAmountInDB);
       } else {
    	   giftCdStatus = "Wrong Code";
    	   totPableAmt = String.format("%.2f", secRendAmountDB);
       }
	   if(("0.00").equals(totPableAmt)) {
	    	mav = new ModelAndView(zeroFullRoomSecRenderingPaymentRed);
	    } else {
	    	mav = new ModelAndView(fullRoomSecRenderingPaymentRed);
	   }            	
       mav.addObject(payCardNumber, req.getParameter(payCardNumber));
       mav.addObject(payExpMonth, req.getParameter(payExpMonth));
       mav.addObject(payExpYear, req.getParameter(payExpYear));
       mav.addObject(nameOnCard, req.getParameter(nameOnCard));
       mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
       mav.addObject(typeOfSpaceVal, sn.getAttribute(selectedRoomInSn));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       sn.setAttribute(totalCheckoutAmountInSn, totPableAmt);
       mav.addObject(giftCuponCode, req.getParameter(payGiftCard));              
       mav.addObject(giftCardStatus, giftCdStatus);
       mav.addObject(giftCardPrice, giftAmount);
       mav.addObject(remGiftCardPrice, remGiftAmt);
       mav.addObject(totalPaybleAmount, totPableAmt);
       mav.addObject(secRenderingAmount, secRendAmount);
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView giftCardPurchasedEmailSendToClient(HttpServletRequest req, HttpSession sn) {
     	ModelAndView mav;
       	UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));        		
       	String toAdd = userInformation.getUserName();
       	String firstName = userInformation.getFirstName();
       	String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
       	String subject = "Thank you for your purchase!";            
       	String type = "text/html";           
       	EmailSending userEmail = new EmailSending();
       	String fromAdd = "info@nookandcove.com";              
       	String body = "<body>" 
                       + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                       + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                       + "<p style='padding-top: 5px;'>Thank you for purchasing a Nook + Cove Gift Card! Your Gift Card will be sent out per your instructions.</p>"
                       + "<p style='padding-top: 5px;'>We look forward to giving your Gift Card Recipient a fun and fabulous design experience!</p>"
                       + "<p style='padding-top: 5px;'>Sincerely,</p> <br/>"
                       + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                       + "</div>"
                       + "</body> ";            
       	try {
       		userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
       	} catch (Exception ex) {
       		LOGGER.error("Gift Card Purchased Email For Client " + ex);
       	}       
       	mav = new ModelAndView();
       	return mav;
   }

   @Override
   @Transactional
   public ModelAndView paymentShoppingCartInfoDisplay(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));      
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shCartPaySavingModel.setGiftCouponCodes(null);
		   shCartPaySavingModel.setCartGiftAmount(null);       
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);
	   }	   
       List<AddClientProductsToCartSaving> selectedPaymentCartItemsList = addClientProductsToCartSavingDAO.selectedPaymentCartItemsListTakeFromDB((Long) sn.getAttribute(userIdInSn));       
       if (!selectedPaymentCartItemsList.isEmpty()) {        	               
    	   List productSavingIdsList = new ArrayList();
           List productImagesList = new ArrayList();
           List productNamesList = new ArrayList();
           List productPriceList = new ArrayList();
           List productCountList = new ArrayList();
           List productTotalPriceList = new ArrayList();           
           double totalAmount = 0.0;
           for (AddClientProductsToCartSaving addClientProductsToCartSaving : selectedPaymentCartItemsList) {
        	   productSavingIdsList.add(addClientProductsToCartSaving.getAddClientProductsToCartSavingId());
        	   byte[] uploadedImageFromDB = addClientProductsToCartSaving.getProductImageUpload();
        	   String productImageInDB = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
        	   productImagesList.add(productImageInDB);
        	   productNamesList.add(addClientProductsToCartSaving.getProductName());
        	   productPriceList.add(addClientProductsToCartSaving.getProductPrice());
        	   productCountList.add(addClientProductsToCartSaving.getProductCount());
        	   productTotalPriceList.add(addClientProductsToCartSaving.getProductTotalPrice());          	
        	   String totalPrice = addClientProductsToCartSaving.getProductTotalPrice();
        	   double prodTotalPrice = Double.parseDouble(totalPrice);            	 
        	   totalAmount = totalAmount + prodTotalPrice;          	  
           }
           String totFormattedAmount = String.format("%.2f", totalAmount);           
           int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
           sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);           
           sn.setAttribute("product_Saving_Ids_List", productSavingIdsList);
           sn.setAttribute("product_Images_List", productImagesList);
           sn.setAttribute("product_Name_List", productNamesList);
           sn.setAttribute("product_Price_List", productPriceList);
           sn.setAttribute("product_Count_List", productCountList);
           sn.setAttribute("product_TotalPrice_List", productTotalPriceList);                     
           mav = new ModelAndView(myShoppingCartDisplay);
           mav.addObject(totalProductsAmount, totFormattedAmount);
           sn.setAttribute(totalProductsAmountInSn, totFormattedAmount);           
       } else{        	 
    	   mav = clientsInformationDisplayRedirection(req, sn);            
       }       
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));       
       return mav;
   }

   @Override
   @Transactional
   public JSONArray addSelectedProductsToCart(long productSavingId, int productCount, HttpSession sn) {
	   AddClientProductsToCartSaving cartProductsList = addClientProductsToCartSavingDAO.deletedSelectedProductsFromCartDB(productSavingId);
	   cartProductsList.setProductCount(productCount);		   
	   String prodPrice = cartProductsList.getProductPrice();
	   prodPrice = prodPrice.replaceAll(",", "");
	   double productPrice = Double.parseDouble(prodPrice);  	 
	   double totalProductsPrice = productPrice * productCount;
	   String totProductsPrice = String.format("%.2f", totalProductsPrice);			
	   cartProductsList.setProductTotalPrice(totProductsPrice);
	   addClientProductsToCartSavingDAO.merge(cartProductsList);		        
	   JSONArray forms = new JSONArray();          
	   return forms;
   }

   @Override
   @Transactional
   public JSONArray deleteSelectedProductFromCart(long productSavingId, HttpSession sn) {
	   AddClientProductsToCartSaving cartProductsList = addClientProductsToCartSavingDAO.deletedSelectedProductsFromCartDB(productSavingId);
	   addClientProductsToCartSavingDAO.delete(cartProductsList);   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
   
   @Override
   @Transactional
   public JSONArray singleSecRendLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   String[] likeStatusSt = likeStatus.split("_");  
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);
		   if("Con1".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept1LikeStatus(likeStatusSt[1]);
		   } else if("Con2".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept2LikeStatus(likeStatusSt[1]);
		   } else {
			   adminAssignClInfoSaving.setSecondRenderingLikeStatus(likeStatusSt[1]);
		   }
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
  
   @Override
   @Transactional
   public JSONArray doubleSecRendLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInClientSide(clientInfoId, designInfoId);
		   adminAssignClInfoSaving.setSecondRenderingLikeStatus(likeStatus);		
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
 
   @Override
   @Transactional
   public JSONArray doubleRenderingLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   String[] likeStatusSt = likeStatus.split("_");  
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering2VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering2UpdationInClientSide(clientInfoId, designInfoId);
		   if("Con1".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept1LikeStatus(likeStatusSt[1]);
		   } else if("Con2".equals(likeStatusSt[0])) {
			   adminAssignClInfoSaving.setConcept2LikeStatus(likeStatusSt[1]);
		   } else {
			   adminAssignClInfoSaving.setRenderingLikeStatus(likeStatusSt[1]);
		   }
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }  
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
   
   @Override
   @Transactional
   public JSONArray doubleRevisedRenderingLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInClientSide(clientInfoId, designInfoId);
		   adminAssignClInfoSaving.setRevisedRenderingLikeStatus(likeStatus);		
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }   
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
   
   @Override
   @Transactional
   public JSONArray doubleRoomRenderingLikeUpdateInDB(String likeStatus, HttpSession sn) {
	   long clientInfoId = (Long) sn.getAttribute(clientInfoSavingIdInSn);
	   ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.rowIdUpdationUsingClientInfoID((Long) sn.getAttribute(userIdInSn), (Long) sn.getAttribute(clientInfoSavingIdInSn));
	   long designInfoId = clientInfoSaving.getDesignerInfoSavingId();                	
	   List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRendering1VerificationInClientSide(clientInfoId, designInfoId);                
	   if(!adminAssignCon1InfoList.isEmpty()){    		
		   AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRendering1UpdationInClientSide(clientInfoId, designInfoId);
		   adminAssignClInfoSaving.setRenderingLikeStatus(likeStatus);		
		   adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   }
	   JSONArray forms = new JSONArray();          
	   return forms;
   }
   
   @Override
   @Transactional
   public ModelAndView changeShippingInfoDisplay(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   String shipFullName1 = null;
	   String shipAddress01 = null;
	   String shipAddress02 = null;
	   String shipCity1 = null;
	   String shipState1 = null;
	   String shipZip1 = null;
	   String shipCountry1 = null;
	   String shipPhNumber1 = null;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));      
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shipFullName1 = shCartPaySavingModel.getShipFullName();
		   shipAddress01 = shCartPaySavingModel.getShipAddress1();
		   shipAddress02 = shCartPaySavingModel.getShipAddress2();
		   shipCity1 = shCartPaySavingModel.getShipCity();
		   shipState1 = shCartPaySavingModel.getShipState();
		   shipZip1 = shCartPaySavingModel.getShipZip();
		   shipCountry1 = shCartPaySavingModel.getShipCountry();
		   shipPhNumber1 = shCartPaySavingModel.getShipPhNumber();        	 
	   }
	   mav = new ModelAndView(changeShippingInfo);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN)); 
	   mav.addObject(shipFullName, shipFullName1);
	   mav.addObject(shipAddress1, shipAddress01);
	   mav.addObject(shipAddress2, shipAddress02);
	   mav.addObject(shipCity, shipCity1);
	   mav.addObject(shipState, shipState1);
	   mav.addObject(shipZip, shipZip1);
	   mav.addObject(shipCountry, shipCountry1);
	   mav.addObject(shipPhNumber, shipPhNumber1);
	   return mav;
   }       
   
   @Override
   @Transactional
   public ModelAndView changeBillingInfoDisplay(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;            
	   String billFullName1 = null;
	   String billAddress01 = null;
	   String billAddress02 = null;
	   String billCity1 = null;
	   String billState1 = null;
	   String billZip1 = null;
	   String billCountry1 = null;
	   String billPhNumber1 = null;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
       if(!shopCartPayInfoSavingList.isEmpty()){        	 
    	   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
    	   billFullName1 = shCartPaySavingModel.getBillFullName();
    	   billAddress01 = shCartPaySavingModel.getBillAddress1();
    	   billAddress02 = shCartPaySavingModel.getBillAddress2();
    	   billCity1 = shCartPaySavingModel.getBillCity();
    	   billState1 = shCartPaySavingModel.getBillState();
    	   billZip1 = shCartPaySavingModel.getBillZip();
    	   billCountry1 = shCartPaySavingModel.getBillCountry();
    	   billPhNumber1 = shCartPaySavingModel.getBillPhNumber();        	 
       }
       mav = new ModelAndView(changeBillingInfo);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN)); 
       mav.addObject(billFullName, billFullName1);
       mav.addObject(billAddress1, billAddress01);
       mav.addObject(billAddress2, billAddress02);
       mav.addObject(billCity, billCity1);
       mav.addObject(billState, billState1);
       mav.addObject(billZip, billZip1);
       mav.addObject(billCountry, billCountry1);
       mav.addObject(billPhNumber, billPhNumber1);
       return mav;
   }         
   
   @Override
   @Transactional
   public ModelAndView changeShippingInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	  
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   Timestamp currentDate = currentDate();
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shCartPaySavingModel.setShipFullName(req.getParameter(shipFullName));
		   shCartPaySavingModel.setShipAddress1(req.getParameter(shipAddress1));
		   shCartPaySavingModel.setShipAddress2(req.getParameter(shipAddress2));
		   shCartPaySavingModel.setShipCity(req.getParameter(shipCity));
		   shCartPaySavingModel.setShipState(req.getParameter(shipState));
		   shCartPaySavingModel.setShipZip(req.getParameter(shipZip));
		   shCartPaySavingModel.setShipCountry(req.getParameter(shipCountry));
		   shCartPaySavingModel.setShipPhNumber(req.getParameter(shipPhNumber));	   	
		   shCartPaySavingModel.setUpdatedDate(currentDate);
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);	
	   }
	   mav = reviewAndPlaceOrderDisplay(req, sn); 		
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView changeBillingInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   Timestamp currentDate = currentDate();
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shCartPaySavingModel.setBillFullName(req.getParameter(billFullName));
		   shCartPaySavingModel.setBillAddress1(req.getParameter(billAddress1));
		   shCartPaySavingModel.setBillAddress2(req.getParameter(billAddress2));
		   shCartPaySavingModel.setBillCity(req.getParameter(billCity));
		   shCartPaySavingModel.setBillState(req.getParameter(billState));
		   shCartPaySavingModel.setBillZip(req.getParameter(billZip));
		   shCartPaySavingModel.setBillCountry(req.getParameter(billCountry));
		   shCartPaySavingModel.setBillPhNumber(req.getParameter(billPhNumber));
		   shCartPaySavingModel.setUpdatedDate(currentDate);
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);	
	   }
	   mav = reviewAndPlaceOrderDisplay(req, sn);	 		
	   return mav;	
   }

   @Override
   @Transactional
   public ModelAndView shippingInformationDisplay(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   String shipFullName1 = null;
	   String shipAddress01 = null;
	   String shipAddress02 = null;
	   String shipCity1 = null;
	   String shipState1 = null;
	   String shipZip1 = null;
	   String shipCountry1 = null;
	   String shipPhNumber1 = null;
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));        	 
		   shipFullName1 = shCartPaySavingModel.getShipFullName();
		   shipAddress01 = shCartPaySavingModel.getShipAddress1();
		   shipAddress02 = shCartPaySavingModel.getShipAddress2();
		   shipCity1 = shCartPaySavingModel.getShipCity();
		   shipState1 = shCartPaySavingModel.getShipState();
		   shipZip1 = shCartPaySavingModel.getShipZip();
		   shipCountry1 = shCartPaySavingModel.getShipCountry();
		   shipPhNumber1 = shCartPaySavingModel.getShipPhNumber();         	 
	   }
	   mav = new ModelAndView(shippingInfoDisplay);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
	   mav.addObject(shipFullName, shipFullName1);
	   mav.addObject(shipAddress1, shipAddress01);
	   mav.addObject(shipAddress2, shipAddress02);
	   mav.addObject(shipCity, shipCity1);
	   mav.addObject(shipState, shipState1);
	   mav.addObject(shipZip, shipZip1);
	   mav.addObject(shipCountry, shipCountry1);
	   mav.addObject(shipPhNumber, shipPhNumber1);          	
	   return mav;
   }     
   
   @Override
   @Transactional
   public ModelAndView billingInformationDisplay(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   mav = shippingAddressSavingOrUpdateInDB(req, sn, req.getParameter(shipFullName), req.getParameter(shipAddress1), req.getParameter(shipAddress2), req.getParameter(shipCity), req.getParameter(shipState), req.getParameter(shipZip), req.getParameter(shipCountry), req.getParameter(shipPhNumber));	   	   
	   String billFullName1 = null;
	   String billAddress01 = null;
	   String billAddress02 = null;
	   String billCity1 = null;
	   String billState1 = null;
	   String billZip1 = null;
	   String billCountry1 = null;
	   String billPhNumber1 = null;
	   String shipFullName1 = null;
	   String shipAddress01 = null;
	   String shipAddress02 = null;
	   String shipCity1 = null;
	   String shipState1 = null;
	   String shipZip1 = null;
	   String shipCountry1 = null;
	   String shipPhNumber1 = null;
	   String ckBoxStatus = null;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   if(!shopCartPayInfoSavingList.isEmpty()){
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));		   
		   billFullName1 = shCartPaySavingModel.getBillFullName();
		   billAddress01 = shCartPaySavingModel.getBillAddress1();
		   billAddress02 = shCartPaySavingModel.getBillAddress2();
		   billCity1 = shCartPaySavingModel.getBillCity();
		   billState1 = shCartPaySavingModel.getBillState();
		   billZip1 = shCartPaySavingModel.getBillZip();
		   billCountry1 = shCartPaySavingModel.getBillCountry();
		   billPhNumber1 = shCartPaySavingModel.getBillPhNumber();
		   shipFullName1 = shCartPaySavingModel.getShipFullName();
		   shipAddress01 = shCartPaySavingModel.getShipAddress1();
		   shipAddress02 = shCartPaySavingModel.getShipAddress2();
		   shipCity1 = shCartPaySavingModel.getShipCity();
		   shipState1 = shCartPaySavingModel.getShipState();
		   shipZip1 = shCartPaySavingModel.getShipZip();
		   shipCountry1 = shCartPaySavingModel.getShipCountry();
		   shipPhNumber1 = shCartPaySavingModel.getShipPhNumber();
		   ckBoxStatus = shCartPaySavingModel.getCheckboxStatus();
	   } 
	   mav = new ModelAndView(billingInfoDisplay);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
	   mav.addObject(billFullName, billFullName1);
	   mav.addObject(billAddress1, billAddress01);
	   mav.addObject(billAddress2, billAddress02);
	   mav.addObject(billCity, billCity1);
	   mav.addObject(billState, billState1);
	   mav.addObject(billZip, billZip1);
	   mav.addObject(billCountry, billCountry1);
	   mav.addObject(billPhNumber, billPhNumber1);
	   mav.addObject(shipFullName, shipFullName1);
	   mav.addObject(shipAddress1, shipAddress01);
	   mav.addObject(shipAddress2, shipAddress02);
	   mav.addObject(shipCity, shipCity1);
	   mav.addObject(shipState, shipState1);
	   mav.addObject(shipZip, shipZip1);
	   mav.addObject(shipCountry, shipCountry1);
	   mav.addObject(shipPhNumber, shipPhNumber1);
	   mav.addObject(checkBoxStatus, ckBoxStatus);
	   return mav;
   }
   
   @Override
   @Transactional
   public ModelAndView shippingAddressSavingOrUpdateInDB(HttpServletRequest req, HttpSession sn, String shipFullName, String shipAddress1, String shipAddress2, String shipCity, String shipState, String shipZip, String shipCountry, String shipPhNumber) {
	   ModelAndView mav;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   Timestamp currentDate = currentDate();	   
	   if(!shopCartPayInfoSavingList.isEmpty()){
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shCartPaySavingModel.setShipFullName(shipFullName);
		   shCartPaySavingModel.setShipAddress1(shipAddress1);
		   shCartPaySavingModel.setShipAddress2(shipAddress2);
		   shCartPaySavingModel.setShipCity(shipCity);
		   shCartPaySavingModel.setShipState(shipState);
		   shCartPaySavingModel.setShipZip(shipZip);
		   shCartPaySavingModel.setShipCountry(shipCountry);
		   shCartPaySavingModel.setShipPhNumber(shipPhNumber);
		   shCartPaySavingModel.setEstimatedAmount((String) sn.getAttribute(totalProductsAmountInSn));
		   shCartPaySavingModel.setUpdatedDate(currentDate);
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);		   
	   } else {       	 
		   ShoppingCartPaymentInfoSaving shCartPayModel = new ShoppingCartPaymentInfoSaving();
		   shCartPayModel.setUserId((Long) sn.getAttribute(userIdInSn));
		   shCartPayModel.setShipFullName(shipFullName);
		   shCartPayModel.setShipAddress1(shipAddress1);
		   shCartPayModel.setShipAddress2(shipAddress2);
		   shCartPayModel.setShipCity(shipCity);
		   shCartPayModel.setShipState(shipState);
		   shCartPayModel.setShipZip(shipZip);
		   shCartPayModel.setShipCountry(shipCountry);
		   shCartPayModel.setShipPhNumber(shipPhNumber);
		   shCartPayModel.setEstimatedAmount((String) sn.getAttribute(totalProductsAmountInSn));
		   shCartPayModel.setCreatedDate(currentDate);
		   shoppingCartPaymentInfoSavingDAO.save(shCartPayModel);		   
	   }
	   mav = new ModelAndView();	   
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView paymentReviewBackMoveRed(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));	   
	   String billFullName1 = null;
	   String billAddress01 = null;
	   String billAddress02 = null;
	   String billCity1 = null;
	   String billState1 = null;
	   String billZip1 = null;
	   String billCountry1 = null;
	   String billPhNumber1 = null;
	   String shipFullName1 = null;
	   String shipAddress01 = null;
	   String shipAddress02 = null;
	   String shipCity1 = null;
	   String shipState1 = null;
	   String shipZip1 = null;
	   String shipCountry1 = null;
	   String shipPhNumber1 = null;
	   String ckBoxStatus = null;
	   if(!shopCartPayInfoSavingList.isEmpty()){
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));		   
		   billFullName1 = shCartPaySavingModel.getBillFullName();
		   billAddress01 = shCartPaySavingModel.getBillAddress1();
		   billAddress02 = shCartPaySavingModel.getBillAddress2();
		   billCity1 = shCartPaySavingModel.getBillCity();
		   billState1 = shCartPaySavingModel.getBillState();
		   billZip1 = shCartPaySavingModel.getBillZip();
		   billCountry1 = shCartPaySavingModel.getBillCountry();
		   billPhNumber1 = shCartPaySavingModel.getBillPhNumber();
		   shipFullName1 = shCartPaySavingModel.getShipFullName();
		   shipAddress01 = shCartPaySavingModel.getShipAddress1();
		   shipAddress02 = shCartPaySavingModel.getShipAddress2();
		   shipCity1 = shCartPaySavingModel.getShipCity();
		   shipState1 = shCartPaySavingModel.getShipState();
		   shipZip1 = shCartPaySavingModel.getShipZip();
		   shipCountry1 = shCartPaySavingModel.getShipCountry();
		   shipPhNumber1 = shCartPaySavingModel.getShipPhNumber();
		   ckBoxStatus = shCartPaySavingModel.getCheckboxStatus();
	   } 
	   mav = new ModelAndView(billingInfoDisplay);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
	   mav.addObject(billFullName, billFullName1);
	   mav.addObject(billAddress1, billAddress01);
	   mav.addObject(billAddress2, billAddress02);
	   mav.addObject(billCity, billCity1);
	   mav.addObject(billState, billState1);
	   mav.addObject(billZip, billZip1);
	   mav.addObject(billCountry, billCountry1);
	   mav.addObject(billPhNumber, billPhNumber1);
	   mav.addObject(shipFullName, shipFullName1);
	   mav.addObject(shipAddress1, shipAddress01);
	   mav.addObject(shipAddress2, shipAddress02);
	   mav.addObject(shipCity, shipCity1);
	   mav.addObject(shipState, shipState1);
	   mav.addObject(shipZip, shipZip1);
	   mav.addObject(shipCountry, shipCountry1);
	   mav.addObject(shipPhNumber, shipPhNumber1);
	   mav.addObject(checkBoxStatus, ckBoxStatus);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView billingInformationDataSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   Timestamp currentDate = currentDate();
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));		   
		   shCartPaySavingModel.setBillFullName(req.getParameter(billFullName));
		   shCartPaySavingModel.setBillAddress1(req.getParameter(billAddress1));
		   shCartPaySavingModel.setBillAddress2(req.getParameter(billAddress2));
		   shCartPaySavingModel.setBillCity(req.getParameter(billCity));
		   shCartPaySavingModel.setBillState(req.getParameter(billState));
		   shCartPaySavingModel.setBillZip(req.getParameter(billZip));
		   shCartPaySavingModel.setBillCountry(req.getParameter(billCountry));
		   shCartPaySavingModel.setBillPhNumber(req.getParameter(billPhNumber));
		   shCartPaySavingModel.setCheckboxStatus(req.getParameter("checkbox"));
		   shCartPaySavingModel.setUpdatedDate(currentDate);
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);
	   }
	   mav = reviewAndPlaceOrderDisplay(req, sn);        
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reviewAndPlaceOrderDisplay(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;            
	   String shipFullName1 = null;
	   String shipAddress01 = null;
	   String shipAddress02 = null;
	   String shipCity1 = null;
	   String shipState1 = null;
	   String shipZip1 = null;
	   String shipCountry1 = null;
	   String shipPhNumber1 = null;
	   String billFullName1 = null;
	   String billAddress01 = null;
	   String billAddress02 = null;
	   String billCity1 = null;
	   String billState1 = null;
	   String billZip1 = null;
	   String billCountry1 = null;
	   String billPhNumber1 = null;
	   String reviewOrderStatus1 = null;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shipFullName1 = shCartPaySavingModel.getShipFullName();
		   shipAddress01 = shCartPaySavingModel.getShipAddress1();
		   shipAddress02 = shCartPaySavingModel.getShipAddress2();
		   shipCity1 = shCartPaySavingModel.getShipCity();
		   shipState1 = shCartPaySavingModel.getShipState();
		   shipZip1 = shCartPaySavingModel.getShipZip();
		   shipCountry1 = shCartPaySavingModel.getShipCountry();
		   shipPhNumber1 = shCartPaySavingModel.getShipPhNumber();
		   billFullName1 = shCartPaySavingModel.getBillFullName();
		   billAddress01 = shCartPaySavingModel.getBillAddress1();
		   billAddress02 = shCartPaySavingModel.getBillAddress2();
		   billCity1 = shCartPaySavingModel.getBillCity();
		   billState1 = shCartPaySavingModel.getBillState();
		   billZip1 = shCartPaySavingModel.getBillZip();
		   billCountry1 = shCartPaySavingModel.getBillCountry();
		   billPhNumber1 = shCartPaySavingModel.getBillPhNumber();
		   reviewOrderStatus1 = shCartPaySavingModel.getReviewOrderStatus();
	   }
	   mav = new ModelAndView(reviewAndPlaceOrder);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
	   mav.addObject(shipFullName, shipFullName1);
	   mav.addObject(shipAddress1, shipAddress01);
	   mav.addObject(shipAddress2, shipAddress02);
	   mav.addObject(shipCity, shipCity1);
	   mav.addObject(shipState, shipState1);
	   mav.addObject(shipZip, shipZip1);
	   mav.addObject(shipCountry, shipCountry1);
	   mav.addObject(shipPhNumber, shipPhNumber1); 
	   mav.addObject(billFullName, billFullName1);
	   mav.addObject(billAddress1, billAddress01);
	   mav.addObject(billAddress2, billAddress02);
	   mav.addObject(billCity, billCity1);
	   mav.addObject(billState, billState1);
	   mav.addObject(billZip, billZip1);
	   mav.addObject(billCountry, billCountry1);
	   mav.addObject(billPhNumber, billPhNumber1);
	   mav.addObject(reviewOrderStatus, reviewOrderStatus1);
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView reviewPlaceOrderDataSavingInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   List<ShoppingCartPaymentInfoSaving> shopCartPayInfoSavingList = shoppingCartPaymentInfoSavingDAO.selectedShoppingCartRowVerification((Long) sn.getAttribute(userIdInSn));
	   Timestamp currentDate = currentDate();
	   if(!shopCartPayInfoSavingList.isEmpty()){        	 
		   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		   shCartPaySavingModel.setReviewOrderStatus(req.getParameter(reviewOrderStatus));		   
		   shCartPaySavingModel.setUpdatedDate(currentDate);
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);
	   }
	   if(("Do Not Place My Order").equals(req.getParameter(reviewOrderStatus))) {
		   mav = new ModelAndView(cartPaymentInfoForNoDisplay);
	   } else {
		   mav = new ModelAndView(cartPaymentInfoForYesDisplay);
	   }	   
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView cartPaymentGiftCardInfoRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   String giftCdPrice = null;
	   double totProductsAmoutDB = 0;
	   double giftCardPriceInDB = 0;
	   double totalPableAmount = 0;
	   double giftAmountInDB = 0;
	   double cartGiftPriceDB = 0;
	   double cartGftDBPriceDB = 0;
	   String totPableAmt = null;
	   String giftAmount = null;
	   String giftCdStatus = null;
	   String usedGCCodeSt = null;	   	   
	   String totProductsAmout = (String) sn.getAttribute(totalProductsAmountInSn);
	   if(null != totProductsAmout) {
		   totProductsAmoutDB = Double.parseDouble(totProductsAmout);		   
	   }	   
	   ShoppingCartPaymentInfoSaving shCartPayModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
       String gcCopons = shCartPayModel.getGiftCouponCodes();
       String cartGftDBPrice = shCartPayModel.getCartGiftAmount();
       usedGCCodeSt = giftCardCouponCodesCheckingInDB(gcCopons, req.getParameter(payGiftCard));
       cartGftDBPriceDB = giftCardCouponPriceCheckingInDB(gcCopons, cartGftDBPrice);
             
	   List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(req.getParameter(payGiftCard));
	   if(totProductsAmoutDB > cartGftDBPriceDB && !giftInfoSavingList.isEmpty() && null == usedGCCodeSt){
		   GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(req.getParameter(payGiftCard));
	       giftCdPrice = giftInfoSavingModel.getRemainingGiftPrice();	       
	       if (null != giftCdPrice) {
	    	   giftCardPriceInDB = Double.parseDouble(giftCdPrice);
	       }	       
	       double remGftAmt = totProductsAmoutDB - cartGftDBPriceDB;
	       if(giftCardPriceInDB >= remGftAmt) {            	
	    	   totalPableAmount = 0;
	           giftAmountInDB = remGftAmt + cartGftDBPriceDB;
	       } else if(remGftAmt > giftCardPriceInDB) {
	    	   totalPableAmount = remGftAmt - giftCardPriceInDB;
	           giftAmountInDB = giftCardPriceInDB + cartGftDBPriceDB;	           	           
	       }	       
	       ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
           String giftCopons = shCartPaySavingModel.getGiftCouponCodes();
           String cartGfPrice = shCartPaySavingModel.getCartGiftAmount();
           String totGiftCopons = giftCopons + "_,_" + req.getParameter(payGiftCard);
           totGiftCopons = totGiftCopons.replaceFirst("null_,_", "");
           shCartPaySavingModel.setGiftCouponCodes(totGiftCopons);
           if(null != cartGfPrice) {
    		   cartGiftPriceDB = Double.parseDouble(cartGfPrice);		   
    	   }
           double totalGfAmount = cartGiftPriceDB + giftCardPriceInDB;
           String totalGiftAmount = String.format("%.2f", totalGfAmount);
           shCartPaySavingModel.setCartGiftAmount(totalGiftAmount);
		   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);		   
	       totPableAmt = String.format("%.2f", totalPableAmount);
	       giftAmount = String.format("%.2f", giftAmountInDB);
       } else {
    	   double elseGiftAmountDB = 0;
    	   giftCdStatus = "Wrong Code";
    	   totPableAmt = String.format("%.2f", totProductsAmoutDB);
    	   if(null != cartGftDBPrice) {
    		   if(cartGftDBPriceDB >= totProductsAmoutDB) {            	
    	    	   totalPableAmount = 0;
    	    	   elseGiftAmountDB = totProductsAmoutDB;    	           
    	       } else if(totProductsAmoutDB > cartGftDBPriceDB) {
    	    	   totalPableAmount = totProductsAmoutDB - cartGftDBPriceDB;
    	    	   elseGiftAmountDB = cartGftDBPriceDB;	           	           
    	       }    		   
    		   totPableAmt = String.format("%.2f", totalPableAmount);
    	       giftAmount = String.format("%.2f", elseGiftAmountDB);
    	   }    	   
       }
	   if(("0.00").equals(totPableAmt)) {
		   mav = new ModelAndView(zeroCartPaymentInfoForYesDisplay);
	   } else {
		   mav = new ModelAndView(cartPaymentInfoForYesDisplay);
	   }
       mav.addObject(payCardNumber, req.getParameter(payCardNumber));
       mav.addObject(payExpMonth, req.getParameter(payExpMonth));
       mav.addObject(payExpYear, req.getParameter(payExpYear));
       mav.addObject(nameOnCard, req.getParameter(nameOnCard));
       mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       sn.setAttribute(totalCheckoutAmountInSn, totPableAmt);              
       mav.addObject(giftCardStatus, giftCdStatus);
       mav.addObject(giftCardPrice, giftAmount);
       mav.addObject(totalPaybleAmount, totPableAmt);
       mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientMyAccountRedirection(HttpServletRequest req, HttpSession sn) {
   	ModelAndView mav;
   	UserInformation userInformationModel = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
   		String clFirstName = userInformationModel.getFirstName();
   		String clLastName = userInformationModel.getLastName();
   		String clientEmail = userInformationModel.getUserName();        
   		mav = new ModelAndView(clientContactInfoEdit);   	
       mav.addObject(clientFirstName, clFirstName);
       mav.addObject(clientLastName, clLastName);
       mav.addObject(clientUserEmail, clientEmail);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN)); 
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientAccountInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
   	ModelAndView mav;
   	List clientEmailList = userInformationDAO.findByUserName(req.getParameter(clientUserEmail));
   	UserInformation userInformationModel = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
   		String clientEmail = userInformationModel.getUserName();        
   		userInformationModel.setFirstName(req.getParameter(clientFirstName));
   		userInformationModel.setLastName(req.getParameter(clientLastName));       	        
       	userInformationDAO.merge(userInformationModel);
       	String lastSingleName = String.valueOf(req.getParameter(clientLastName).charAt(0)).toUpperCase();
       	String fCapName = req.getParameter(clientFirstName).substring(0, 1).toUpperCase() + req.getParameter(clientFirstName).substring(1);
       	String fullName = fCapName +" "+lastSingleName;            
       	sn.setAttribute(firstNamesInSn, fullName);
       	if (!clientEmailList.isEmpty() && ("null" != req.getParameter(clientUserEmail) && !(clientEmail).equals(req.getParameter(clientUserEmail)))) {
       		mav = clientMyAccountRedirection(req, sn);
       		mav.addObject(clientErrorPage, " E-mail already exists!");
       } else {        
    	   	userInformationModel.setUserName(req.getParameter(clientUserEmail));
       		userInformationDAO.merge(userInformationModel);
       		mav = clientMyAccountRedirection(req, sn);
       		mav.addObject(clientSuccPage, "Account Data Saved");
       }
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientPasswordChangeRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   UserInformation userInformationModel = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));        
	   String clientEmail = userInformationModel.getUserName();        
	   mav = new ModelAndView(clientPasswordEdit);
	   mav.addObject(clientUserEmail, clientEmail);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   public String mD5Encrypt(String password) {
	   String forPassword = password;
       try {        	
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(password.getBytes());
           byte byteData[] = md.digest();
           StringBuilder sb = new StringBuilder();
           for (int i = 0; i < byteData.length; i++) {
               sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
           }
           forPassword = sb.toString();
       } catch (NoSuchAlgorithmException exception) {
       	LOGGER.error("mD5Encrypt " + exception);
       }
       return forPassword;
   }

   @Override
   @Transactional
   public ModelAndView clientPasswordInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
	   long clUserId = (Long) sn.getAttribute(userIdInSn);    	
       String currentPass = req.getParameter("currentPassword");
       String newPass = req.getParameter("newPassword");
       String encrypCurPassword = mD5Encrypt(currentPass);
       String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
       String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
       String encrypNewPassword = mD5Encrypt(newPass);
       String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
       String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);
       Timestamp currentDate = currentDate();
       UserInformation userInformationModel = userInformationDAO.updatedRowIdVerification(clUserId);
       String oldPassSalt = userInformationModel.getPasswordSalt();
       if (currentPasswordSalt.equals(oldPassSalt) && clUserId > 0) {
    	   userInformationModel.setPassword(encrypNewPassword);
    	   userInformationModel.setPasswordSalt(newPasswordSalt);
    	   userInformationModel.setLastPasswordChangedDate(currentDate);
    	   userInformationDAO.merge(userInformationModel);
           req.setAttribute(clientSuccPage, "Password Saved");
       } else {
           req.setAttribute(clientErrorPage, "Invalid Current Password");
       }
       mav = clientPasswordChangeRedirection(req, sn);
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       return mav;
   }

   @Override
   @Transactional
   public String giftCardCouponCodesCheckingInDB(String gcCopons, String payGiftCard) {
	   String usedGCCodeSt = null;	   
	   if(null != gcCopons && gcCopons.length() > 8) {
    	   String[] gcCoponsSt = gcCopons.split("_,_");
    	   for(int i=0; i<gcCoponsSt.length; i++) {    		   
    		   if(gcCoponsSt[i].equals(payGiftCard)) {
    			   usedGCCodeSt = "Already Used";
        	   }  
    	   }
       } else if(null != gcCopons && gcCopons.length() == 8) {
    	   if(gcCopons.equals(payGiftCard)) {
    		   usedGCCodeSt = "Already Used";
    	   }
       }
	   return usedGCCodeSt;
   }

   @Override
   @Transactional
   public double giftCardCouponPriceCheckingInDB(String gcCopons, String cartGftDBPrice) {
	   double cartGftDBPriceDB = 0;	   
	   if(null != gcCopons && gcCopons.length() > 8) {
    	   cartGftDBPriceDB = Double.parseDouble(cartGftDBPrice);    	   
       } else if(null != gcCopons && gcCopons.length() == 8) {
    	   cartGftDBPriceDB = Double.parseDouble(cartGftDBPrice);    	   
       }
	   return cartGftDBPriceDB;
   }
   
   @Override
   @Transactional
   public ModelAndView cartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	   
	   double cartGiftPriceDB = 0;
	   double totProductsAmoutDB = 0;
	   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
       String giftCopons = shCartPaySavingModel.getGiftCouponCodes();
       String cartGfPrice = shCartPaySavingModel.getCartGiftAmount();
       String estAmount = shCartPaySavingModel.getEstimatedAmount();
       String revOrderStatus = shCartPaySavingModel.getReviewOrderStatus();
       if(null != cartGfPrice) {
		   cartGiftPriceDB = Double.parseDouble(cartGfPrice);		   
	   }
       if(null != estAmount) {
		   totProductsAmoutDB = Double.parseDouble(estAmount);		   
	   }
       double pableAmountDB = 0;
       if(cartGiftPriceDB > totProductsAmoutDB) {
    	   pableAmountDB = 0;
       } else {
    	   pableAmountDB = totProductsAmoutDB - cartGiftPriceDB;
       }       
       String totalPableAmt = String.format("%.2f", pableAmountDB);
       long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
	   String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear) ;
       Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
       String apiLoginId1 = req.getParameter(apiLoginId);
       String transactionKey1 = req.getParameter(transactionKey);
       long paymentInfoSavingId = shCartPaySavingModel.getShoppingCartPaymentInfoSavingId();
    	   if(("Do Not Place My Order").equals(revOrderStatus)) {    		   
    		   mav = catCheckoutPaymentNoValueSelectionDisplay(req, sn, giftCopons, paymentInfoSavingId, cardNumber, expirationDate, cardCode, apiLoginId1, transactionKey1, totalPableAmt, req.getParameter(nameOnCard), req.getParameter(typeOfCard));   		   
    	   } else {
    		   mav = paymentGatewayService.catCheckoutPaymentGatewayRedirectionDisplay(req, sn, cardNumber, expirationDate, cardCode, apiLoginId1, transactionKey1, totalPableAmt, req.getParameter(nameOnCard));
    	       String returnVal = (String) sn.getAttribute(returnTypeInSn);   	
    	       if(("This transaction has been approved.").equals(returnVal)) {
    	    	   if(null != giftCopons) {
    	    		   mav = cartGiftCardAmountUpdatesInDB(req, sn, giftCopons);
    	    		   mav = giftCardPurchasedEmailSendToClient(req, sn);
    	    	   }    	    	   
    	    	   addClientProductsToCartSavingDAO.updateAllPaimentCartItemsInDB((Long) sn.getAttribute(userIdInSn), paymentInfoSavingId, returnVal);
    	    	   mav = clientShoppingCartSentMailToAdmin(req, sn);    	   
    		       mav = new ModelAndView(finishedReviewPlaceOrder);       	
    		       sn.setAttribute(returnTypeInSn, null);
    		       sn.setAttribute(paymentInfoSavingIdInSn, null);	       	
    		       int totCartItemsCount = totalAddCartItemsCountFromDB(sn);            
    		       sn.setAttribute(totalCartItemsCountInSN, totCartItemsCount);
    		       sn.setAttribute(totalProductsAmountInSn, null);
    		   } else {
    			   mav = new ModelAndView(cartPaymentInfoForYesDisplay);  	
    		       mav.addObject(payCardNumber, req.getParameter(payCardNumber));
    		       mav.addObject(payExpMonth, req.getParameter(payExpMonth));
    		       mav.addObject(payExpYear, req.getParameter(payExpYear));
    		       mav.addObject(nameOnCard, req.getParameter(nameOnCard));
    		       mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
    		       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		       mav.addObject(paymentValStatus, "Payment Fail");
    		       mav.addObject(paymentReturnStatus, returnVal);	       
    		       sn.setAttribute(totalCheckoutAmountInSn, totalPableAmt);              
    		       mav.addObject(giftCardPrice, cartGfPrice);
    		       mav.addObject(totalPaybleAmount, totalPableAmt);	       
    		   }
    	   }           
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView zeroCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;	   
	   double cartGiftPriceDB = 0;
	   double totProductsAmoutDB = 0;
	   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
       String giftCopons = shCartPaySavingModel.getGiftCouponCodes();
       String cartGfPrice = shCartPaySavingModel.getCartGiftAmount();
       String estAmount = shCartPaySavingModel.getEstimatedAmount();
       if(null != cartGfPrice) {
		   cartGiftPriceDB = Double.parseDouble(cartGfPrice);		   
	   }
       if(null != estAmount) {
		   totProductsAmoutDB = Double.parseDouble(estAmount);		   
	   }
       double pableAmountDB = 0;
       if(cartGiftPriceDB > totProductsAmoutDB) {
    	   pableAmountDB = 0;
       } else {
    	   pableAmountDB = totProductsAmoutDB - cartGiftPriceDB;
       }       
       String totalPableAmt = String.format("%.2f", pableAmountDB);       
       long paymentInfoSavingId = shCartPaySavingModel.getShoppingCartPaymentInfoSavingId();
       mav = zeroCatCheckoutPaymentDisplay(req, sn, giftCopons, paymentInfoSavingId, totalPableAmt);
	   mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
       mav.addObject(totalProductsAmount, sn.getAttribute(totalProductsAmountInSn));
	   return mav;
   }
   
   @Override 
   @Transactional
   public ModelAndView zeroCatCheckoutPaymentDisplay(HttpServletRequest req, HttpSession sn, String giftCopons, long paymentInfoSavingId, String amount) {
	   ModelAndView mav;
	   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
	   String returnVal = "This transaction has been approved.";
	   if(null != giftCopons) {
		   mav = cartGiftCardAmountUpdatesInDB(req, sn, giftCopons);
		   mav = giftCardPurchasedEmailSendToClient(req, sn);
	   }
	   addClientProductsToCartSavingDAO.updateAllPaimentCartItemsInDB((Long) sn.getAttribute(userIdInSn), paymentInfoSavingId, returnVal);
	   Timestamp currentDate = currentDate();	   	   	
       String cardNumber = null;
       String authorizationCode = null;
       String expirationDate = null;
       String nameOnCard = null;
	   shCartPaySavingModel.setPayCardNumber(cardNumber);
	   String giftCdAmount = shCartPaySavingModel.getCartGiftAmount();
	   shCartPaySavingModel.setPayExpDate(expirationDate);
	   shCartPaySavingModel.setPayCvvNumber("***");
	   shCartPaySavingModel.setCheckoutPaymentStatus(returnVal);
	   shCartPaySavingModel.setNameOnCard(nameOnCard);
	   shCartPaySavingModel.setGiftAmount(giftCdAmount);
	   shCartPaySavingModel.setAuthorizationCode(authorizationCode);
	   shCartPaySavingModel.setTotalPaybleAmount(amount);
	   shCartPaySavingModel.setGiftCouponCodes(null);
	   shCartPaySavingModel.setCartGiftAmount(null);
	   shCartPaySavingModel.setOrderedStatus("NO");
	   shCartPaySavingModel.setDeliveredStatus("NO");
	   shCartPaySavingModel.setUpdatedDate(currentDate);
	   String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	   shCartPaySavingModel.setCreatedDateInSt(todayDate);
	   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);
	   int totalCartItemsCount = totalAddCartItemsCountFromDB(sn);
	   sn.setAttribute(totalCartItemsCountInSN, totalCartItemsCount);
	   mav = new ModelAndView(finishedReviewPlaceOrder);	   
	   return mav;
   }

   @Override
   @Transactional
   public ModelAndView catCheckoutPaymentNoValueSelectionDisplay(HttpServletRequest req, HttpSession sn, String giftCopons, long paymentInfoSavingId, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard, String typeOfCard) {
	   ModelAndView mav;
	   ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
	   String returnVal = "This transaction is pending.";	   
	   addClientProductsToCartSavingDAO.updateAllPaimentCartItemsInDB((Long) sn.getAttribute(userIdInSn), paymentInfoSavingId, returnVal);
	   Timestamp currentDate = currentDate();   	
	   String accCardNumber = Long.toString(cardNumber);
	   shCartPaySavingModel.setPayCardNumber(accCardNumber);	   
	   shCartPaySavingModel.setPayExpDate(expirationDate);
	   shCartPaySavingModel.setAccountType(typeOfCard);
	   String cvvNum = Integer.toString(cardCode);
	   shCartPaySavingModel.setPayCvvNumber(cvvNum);
	   shCartPaySavingModel.setCheckoutPaymentStatus(returnVal);
	   shCartPaySavingModel.setNameOnCard(nameOnCard);	   
	   shCartPaySavingModel.setAuthorizationCode(giftCopons);
	   shCartPaySavingModel.setTotalPaybleAmount(amount);
	   shCartPaySavingModel.setGiftCouponCodes(null);
	   shCartPaySavingModel.setCartGiftAmount(null);
	   shCartPaySavingModel.setOrderedStatus("NO");
	   shCartPaySavingModel.setDeliveredStatus("NO");
	   shCartPaySavingModel.setUpdatedDate(currentDate);
	   shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);
	   mav = doNotPlaceShoppingCartSentMailToAdmin(req, sn);
	   int totCartItemsCount = totalAddCartItemsCountFromDB(sn);            
       sn.setAttribute(totalCartItemsCountInSN, totCartItemsCount);
       sn.setAttribute(totalProductsAmountInSn, null);
	   mav = new ModelAndView(finishedReviewPlaceOrder);
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView doNotPlaceShoppingCartSentMailToAdmin(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       long adminUserId = 1;
       UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        		
       String toAdd = userInformation.getUserName();
       String firstName = userInformation.getFirstName();
       String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
       String subject = "Client transaction cannot be completed because client selected NO radio button.";            
       String type = "text/html";           
       EmailSending userEmail = new EmailSending();
       UserInformation userInfoModel = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));        		
 	   String fromAdd = userInfoModel.getUserName();
       String body = "<body>" 
                   + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                   + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                   + "<p style='padding-top: 5px;'>CLIENT SELECTED ... </p>"
                   + "<p style='padding-top: 5px;'>DO NOT PLACE MY ORDER UNTIL I APPROVE TAXES & SHIPPING FEES ON MY ORDER </p>"
                   + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                   + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                   + "</div>"
                   + "</body> ";            
       try {
    	   userEmail.sendEmail(toAdd, subject, body, type, fromAdd);         	
       } catch (Exception ex) {
    	   LOGGER.error("Client Shopping Cart Sent Mail To Admin failed " + ex);
       }       
       mav = new ModelAndView();
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView clientShoppingCartSentMailToAdmin(HttpServletRequest req, HttpSession sn) {
	   ModelAndView mav;
       long adminUserId = 1;
       UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        		
       String userID1 = userInformation.getUserName();
       String userID2 = "brennan.rachman@madwire.com";
       String userID3 = "marketing360+m24951@bcc.mad360.net";
       String[] emailList = {userID1, userID2, userID3};
       String firstName = userInformation.getFirstName();
       String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
       String subject = "Shopping Cart purchases have been made.";            
       String type = "text/html";           
       EmailSending userEmail = new EmailSending();
       UserInformation userInfoModel = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));        		
 	   String fromAdd = userInfoModel.getUserName();
       String body = "<body>" 
                   + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                   + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                   + "<p style='padding-top: 5px;'>Purchases have been made via shopping cart. Orders need to be placed with vendors.</p>"
                   + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                   + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                   + "</div>"
                   + "</body> ";            
       try {
    	   userEmail.sendEmail(emailList, subject, body, type, fromAdd);         	
       } catch (Exception ex) {
    	   LOGGER.error("Client Shopping Cart Sent Mail To Admin failed " + ex);
       }       
       mav = new ModelAndView();
       return mav;
   }
  	
   @Override
   @Transactional
   public ModelAndView cartGiftCardAmountUpdatesInDB(HttpServletRequest req, HttpSession sn, String giftCopons) {
	   ModelAndView mav;	    
	   sn.setAttribute(catGCAmountInSn, sn.getAttribute(totalProductsAmountInSn));
       if(null != giftCopons && giftCopons.length() > 8) {
    	   String[] gcCoponsSt = giftCopons.split("_,_");
    	   for(int i=0; i<gcCoponsSt.length; i++) { 
    		   mav = cartMultipleGiftCardsUpdateInDB(req, sn, gcCoponsSt[i]);    		     
    	   }
       } else if(null != giftCopons && giftCopons.length() == 8) {
    	   mav = cartMultipleGiftCardsUpdateInDB(req, sn, giftCopons);
       }             
       mav = new ModelAndView();       
       return mav;
   }

   @Override
   @Transactional
   public ModelAndView cartMultipleGiftCardsUpdateInDB(HttpServletRequest req, HttpSession sn, String giftCouponCOde) {
	   ModelAndView mav;             	
	   String giftCdPrice = null;
	   double giftCardPriceInDB = 0;
	   double totalPableAmount = 0;	   
	   double totProductsAmoutDB = 0;
	   String totProductsAmout = (String) sn.getAttribute(catGCAmountInSn);
	   if(null != totProductsAmout) {
		   totProductsAmoutDB = Double.parseDouble(totProductsAmout);		   
	   }
	   List<GiftInfoSaving> giftInfoSavingList = giftInfoSavingDAO.giftCardVerificationInDB(giftCouponCOde);
	   if(!giftInfoSavingList.isEmpty()){
	       GiftInfoSaving giftInfoSavingModel = giftInfoSavingDAO.giftCardUsedStatusUpdateInDB(giftCouponCOde);	       
	       giftCdPrice = giftInfoSavingModel.getRemainingGiftPrice();	       
	       if (null != giftCdPrice) {
	    	   giftCardPriceInDB = Double.parseDouble(giftCdPrice);
	       }
	       if(giftCardPriceInDB > totProductsAmoutDB) {
	    	   double remGiftPrice = giftCardPriceInDB - totProductsAmoutDB;
	    	   String remGiftAmt = String.format("%.2f", remGiftPrice);
	    	   giftInfoSavingModel.setRemainingGiftPrice(remGiftAmt);
	    	   giftInfoSavingDAO.merge(giftInfoSavingModel);	           
	       } else if(totProductsAmoutDB > giftCardPriceInDB) {
	    	   giftInfoSavingModel.setUsedGiftStatus("USED");
	    	   giftInfoSavingModel.setRemainingGiftPrice(null);
	    	   giftInfoSavingDAO.merge(giftInfoSavingModel);
	    	   totalPableAmount = totProductsAmoutDB - giftCardPriceInDB;
	    	   String remGiftCardAmt = String.format("%.2f", totalPableAmount);
	    	   sn.setAttribute(catGCAmountInSn, remGiftCardAmt);
	       } else {
	    	   giftInfoSavingModel.setUsedGiftStatus("USED");
	    	   giftInfoSavingModel.setRemainingGiftPrice(null);
	    	   giftInfoSavingDAO.merge(giftInfoSavingModel);
	    	   totalPableAmount = totProductsAmoutDB - giftCardPriceInDB;
	    	   String remGiftCardAmt = String.format("%.2f", totalPableAmount);
	    	   sn.setAttribute(catGCAmountInSn, remGiftCardAmt);
	       }
       }        
       mav = new ModelAndView();       
       return mav;
   }
   
   @Override
   @Transactional
   public String customerNameFromDB(long userId) {
	   String customerName = null;
	   if(userId > 0) {
		   UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
		   String fName = userInformation.getFirstName();
		   String lName = userInformation.getLastName();
		   String fCapName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
		   String lCapName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
		   customerName = fCapName +" "+lCapName;
	   }
	   return customerName;
   }        

   @Override
   @Transactional
   public String todayDateGettingFromCurrentDate() {
	   Timestamp currentDate = currentDate();
	   String todayDate = null;
	   Format formatter = new SimpleDateFormat("MMM");   
	   String month = formatter.format(currentDate);
	   Format formatterDate = new SimpleDateFormat("dd");   
	   String date = formatterDate.format(currentDate);
	   todayDate = month + ", " + date;		
	   return todayDate;
   } 

   @Override
   @Transactional
   public String timeGettingFromCurrentDate() {
	   Timestamp currentDate = currentDate();
	   SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
	   String timeString  = dateFormat.format(currentDate);
	   return timeString;
   }

	@Override
	@Transactional
	public Timestamp currentDate() {
//		Date date= new Date();
//		long time = date.getTime();
//		Timestamp currentDate = new Timestamp(time);		 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}