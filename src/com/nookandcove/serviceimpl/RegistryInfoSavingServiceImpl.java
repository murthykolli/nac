package com.nookandcove.serviceimpl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.GuestRoomFundPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistrantCustomGiftCardCodeSavingDAO;
import com.nookandcove.dao.RegistryRoomFundsInfoSavingDAO;
import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.dao.RegistrantPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistrantShippingInfoSavingDAO;
import com.nookandcove.dao.RegistryCashFundsInfoSavingDAO;
//import com.nookandcove.dao.RegistryCashFundsPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistryRoomFundsPaymentInfoSavingDAO;
import com.nookandcove.model.GuestRoomFundPaymentInfoSaving;
import com.nookandcove.model.RegistrantCustomGiftCardCodeSaving;
import com.nookandcove.model.RegistryRoomFundsInfoSaving;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.RegistrantPaymentInfoSaving;
import com.nookandcove.model.RegistrantShippingInfoSaving;
import com.nookandcove.model.RegistryCashFundsInfoSaving;
//import com.nookandcove.model.RegistryCashFundsPaymentInfoSaving;
import com.nookandcove.model.RegistryRoomFundsPaymentInfoSaving;
import com.nookandcove.service.RegistryConceptBoardsService;
import com.nookandcove.service.RegistryFinishingTouchesService;
import com.nookandcove.service.RegistryInfoSavingService;
import com.nookandcove.service.RegistryPaymentGatewayService;
import com.nookandcove.service.UserInformationService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class RegistryInfoSavingServiceImpl implements RegistryInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryInfoSavingServiceImpl.class);
	
    private String regForgotPasswordRedirection = "regForgotPasswordRedirection";
	private String regSecurityPinRedirection = "regSecurityPinRedirection";
	private String seqUserIdInSn = "seqUserIdInSn";
	private String securityPinInSn = "securityPinInSn";
	private String regErrorPage = "regErrorPage";
	private String loginRedirectRef = "loginRedirectRef";	
	private String registrantUserIdInSn = "registrantUserIdInSn";
	private String createRegistryRedirection = "createRegistryRedirection";
	private String registryOverviewRedirection = "registryOverviewRedirection";
	private String designCuratedConceptsBoardsRed = "designCuratedConceptsBoardsRed";
	private String createdRoomAndCashFundsRedirection = "createdRoomAndCashFundsRedirection";
	private String createdCashFundRedirection = "createdCashFundRedirection";
	private String registryLoginRedirection = "registryLoginRedirection";
	private String registryHomeRedirection = "registryHomeRedirection";
	private String registryHomeALRedirection = "registryHomeALRedirection";
	private String regEditBackgroundImgForGuestRed = "regEditBackgroundImgForGuestRed";
	private String registrantAddCartInfoDisplay = "registrantAddCartInfoDisplay";
	private String registrantFundsCheckOutContactRed = "registrantFundsCheckOutContactRed";
	private String registrantReviewAndPlaceOrderRed = "registrantReviewAndPlaceOrderRed";
	private String registrantPaymentInfoRedi = "registrantPaymentInfoRedi";
	private String registrantGiftCardPaymentInfoRedi = "registrantGiftCardPaymentInfoRedi";
	private String registrantGiftCardZeroPaymentInfoRedi = "registrantGiftCardZeroPaymentInfoRedi";
	private String registrantPaymentSuccessRed = "registrantPaymentSuccessRed";
	private String aboutUsForGuestRedirection = "aboutUsForGuestRedirection";
	private String totalPayableAmountSt = "totalPayableAmountSt";
	private String totalFundsAmountInSn = "totalFundsAmountInSn";
	private String handlingFeesInSn = "handlingFeesInSn";
	private String shoppingCartStateTaxFeeInSn = "shoppingCartStateTaxFeeInSn";
	private String registryRoomFundsInfoDisplay = "registryRoomFundsInfoDisplay";
	private String regBackgroundUploadImageInSn = "regBackgroundUploadImageInSn";
	private String eventType = "eventType";
	private String eventDate = "eventDate";	
	private String regUserName = "regUserName";
	private String regFirstName = "regFirstName";
	private String regLastName = "regLastName";
	private String coRegFirstName = "coRegFirstName";
	private String coRegLastName = "coRegLastName";
	private String password = "password";
	private String regSocialMedia = "regSocialMedia";
	private String regVendorCouponId = "regVendorCouponId";
	private String regUploadedPhoto = "regUploadedPhoto";
	private String registrantMessage = "registrantMessage";
	private String userIdInSn = "userIdInSn";
	private String regAddress = "regAddress";
	private String nameOfTheRoomFund = "nameOfTheRoomFund";
	private String titleOfTheRoomFund = "titleOfTheRoomFund";
	private String imageOfTheRoomFund = "imageOfTheRoomFund";
	private String dateCheckOption = "dateCheckOption";
	private String eventMonth = "eventMonth";
	private String eventDay = "eventDay";
	private String eventYear = "eventYear";
	private String eventsTypeInSn = "eventsTypeInSn";
	private String regiUserNameInSn = "regiUserNameInSn";
	private String regiLastNameInSn = "regiLastNameInSn";
	private String coRegiLastNameInSn = "coRegiLastNameInSn";
	private String regBackReffVal = "regBackReffVal";	
	private String selSpaceCountAndAmount = "selSpaceCountAndAmount";
	private String cashFundName = "cashFundName";
	private String cashFundReqAmount = "cashFundReqAmount";
	private String registrySpaceName = "registrySpaceName";
	private String registrySpaceNameImg = "registrySpaceNameImg";
	private String registrySpaceColName = "registrySpaceColName";
	private String registrySpaceColCount = "registrySpaceColCount";
	private String regiFundAmoun = "regiFundAmoun";
	private String totalRegFundAmount = "totalRegFundAmount";
	private String regiCartCountInSn = "regiCartCountInSn";
	private String regTotalCartItems = "regTotalCartItems";
	private String regiReferance = "regiReferance";		
	private String guestEmailIdInSn = "guestEmailIdInSn";
	private String guestCountInSn = "guestCountInSn";
	private String addDesignPackIdInSn = "addDesignPackIdInSn";
	private String guestReferanceInSn = "guestReferanceInSn";
	private String regFirstNamesInSn = "regFirstNamesInSn";
	private String regFirstNames = "regFirstNames";
	private String guestBackgroungImage = "guestBackgroungImage";
	private String previewGuestRegistryRed = "previewGuestRegistryRed";	
	private String livingRoomFundSn = "livingRoomFundSn";
	private String diningRoomFundSn = "diningRoomFundSn";
	private String bedroomFundSn = "bedroomFundSn";
	private String homeOfficeFundSn = "homeOfficeFundSn";
	private String entrywayFundSn = "entrywayFundSn";
	private String nurseryFundSn = "nurseryFundSn";
	private String kidsBedroomFundSn = "kidsBedroomFundSn";
	private String playAreaFundSn = "playAreaFundSn";
	private String outdoorSpaceFundSn = "outdoorSpaceFundSn";
	private String otherDreamSpaceFundSn = "otherDreamSpaceFundSn";
	private String regStatus = "regStatus";	
	private String billNameOnCard = "billNameOnCard";
	private String billAddress1 = "billAddress1";
	private String billAddress2 = "billAddress2";
	private String billCity = "billCity";
	private String billState = "billState";
	private String billZip = "billZip";
	private String billCountry = "billCountry";
	private String guestEmail = "guestEmail";
	private String guestPhNumber = "guestPhNumber";	
	private String shipFullName = "shipFullName";
	private String shipAddress1 = "shipAddress1";
	private String shipAddress2 = "shipAddress2";
	private String shipCity = "shipCity";
	private String shipState = "shipState";
	private String shipZip = "shipZip";
	private String shipPhNumber = "shipPhNumber";
	private String checkBoxStatus = "checkBoxStatus";
	private String payCardNumber = "payCardNumber";
	private String payExpYear = "payExpYear";
	private String payExpMonth = "payExpMonth";
	private String payCvvNumber = "payCvvNumber";
	private String nameOnCard = "nameOnCard";
	private String paymentValStatus = "paymentValStatus";
	private String paymentReturnStatus = "paymentReturnStatus";
	private String regiPaymentInfoSavingId = "regiPaymentInfoSavingId";
	private String regiPaymentInfoSavingIdInSn = "regiPaymentInfoSavingIdInSn";
	private String redirectRegSpaceAllCartInfoDisplay = "redirectRegSpaceAllCartInfoDisplay";
	private String livingRoomFund = "LIVING ROOM FUND";
	private String diningRoomFund = "DINING ROOM FUND";
	private String bedRoomFund = "BEDROOM FUND";
	private String homeOfficeFund = "HOME OFFICE FUND";
	private String entryWayFund = "ENTRYWAY FUND";
	private String nurseryFund = "NURSERY FUND";
	private String kidsBedRoomFund = "KIDS BEDROOM FUND";
	private String playAreaFund = "PLAY AREA FUND";
	private String outdoorSpaceFund = "OUTDOOR SPACE FUND";
	private String dreamSpaceFund = "CUSTOM DESIGN FUND";
	private String registryOverview = "registryOverview";	
	private String uploadImgPath = "/var/www/html/data/nookandcoveimages/";
	private String shippingAmountStInSn = "shippingAmountStInSn";
	private String totalPayableAmountIncTaxInSn = "totalPayableAmountIncTaxInSn";
	private String giftCardStatus = "giftCardStatus";
	private String giftCardPrice = "giftCardPrice";
	private String totalPaybleAmount = "totalPaybleAmount";
	private String regGiftCardCouponCode = "regGiftCardCouponCode";
	private String tranApprovedStatus = "This transaction has been approved.";
	private String regiFirstNameInSn = "regiFirstNameInSn";
	private String regUploadedPhotoInSn = "regUploadedPhotoInSn";
	private String guestBackgroungImageInSn = "guestBackgroungImageInSn";	
	private String registrantMessageInSn = "registrantMessageInSn";
	private String eventDateInSn = "eventDateInSn";
	private String regiStatusInSn = "regiStatusInSn";	
	private String registryRoomFundsCountInSn = "registryRoomFundsCountInSn";
	private String registryCashFundsCountInSn = "registryCashFundsCountInSn";
	private String registryCustomFundsCountInSn = "registryCustomFundsCountInSn";
	private String regHaveStatus = "Have";
	private String errorPageStatus = "errorPage";
	private String passwordSaltFormat = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
	private String redirectStatus = "redirect:";
	private String registryLanding = "registryLanding";	
	private String regCashFundsIdListInSn = "regCashFundsIdListInSn";
	private String regCashFundsImageListInSn = "regCashFundsImageListInSn";
	private String regCashFundsNameListInSn = "regCashFundsNameListInSn";
	private String regCashFundsPriceListInSn = "regCashFundsPriceListInSn";
	private String regCashFundsContAmountListInSn = "regCashFundsContAmountListInSn";
	private String regCashFundsRemAmountListInSn = "regCashFundsRemAmountListInSn";
	private String regCashFundsMessagesListInSn = "regCashFundsMessagesListInSn";
	private String regCustomFundsIdListInSn = "regCustomFundsIdListInSn";
	private String regCustomFundsImageListInSn = "regCustomFundsImageListInSn";	
	private String regCustomFundsNameListInSn = "regCustomFundsNameListInSn";
	private String regCustomFundsPriceListInSn = "regCustomFundsPriceListInSn";
	private String regCustomFundsContAmountListInSn = "regCustomFundsContAmountListInSn";
	private String regCustomFundsRemAmountListInSn = "regCustomFundsRemAmountListInSn";
	private String regCustomFundsMessagesListInSn = "regCustomFundsMessagesListInSn";
	private String landingRef = "landingRef";
	private String landingRefValInSn = "landingRefValInSn";
	private String landingRefVal = "Landing";
	private String landingBackRefInSn = "landingBackRefInSn";
	private String landingCFBackRefInSn = "landingCFBackRefInSn";
	private String cashFundBigImageUrl = "resources/images/cash_fund_images/big/";
	private String regCBIndividualCountInSn = "regCBIndividualCountInSn";
	private String regCBContributedCartCountInSn = "regCBContributedCartCountInSn";
	private String regFTContributedCartCountInSn = "regFTContributedCartCountInSn";
	private String regFTIndividualCartCountInSn = "regFTIndividualCartCountInSn";
	private String shoppingCartTotalAmountInSn = "shoppingCartTotalAmountInSn";
	private String shoppingCartTotalAmountStInSn = "shoppingCartTotalAmountStInSn";
	private String shoppingCartSubTotalAmountInSn = "shoppingCartSubTotalAmountInSn";
	private String shoppingCartShippingFeeInSn = "shoppingCartShippingFeeInSn";
	private String totalConceptBoardsAmountInSn = "totalConceptBoardsAmountInSn";
	private String totalFinishingTouchesAmountInSn = "totalFinishingTouchesAmountInSn";
	private String jSonObject = "JSonObj";
	private String cbContributedAddCartPriceInSn = "cbContributedAddCartPriceInSn";
	private String cbIndividualAddCartPriceInSn = "cbIndividualAddCartPriceInSn";
	private String ftContributedAddCartPriceInSn = "ftContributedAddCartPriceInSn";
	private String ftIndividualAddCartPriceInSn = "ftIndividualAddCartPriceInSn";
	private String totalRGPaybleAmountInSn = "totalRGPaybleAmountInSn";
	private String totalPaybleAmountForEmailInSn = "totalPaybleAmountForEmailInSn";
	
	private String totalLivingRoomFundsAmount = "totalLivingRoomFundsAmount";
	private String totalDyningRoomFundsAmount = "totalDyningRoomFundsAmount";
	private String totalBedRoomFundsAmount = "totalBedRoomFundsAmount";
	private String totalHomeOfficeRoomFundsAmount = "totalHomeOfficeRoomFundsAmount";
	private String totalEntryWayRoomFundsAmount = "totalEntryWayRoomFundsAmount";
	private String totalNurseryRoomFundsAmount = "totalNurseryRoomFundsAmount";
	private String totalKidsBedRoomRoomFundsAmount = "totalKidsBedRoomRoomFundsAmount";
	private String totalPlayAreaRoomFundsAmount = "totalPlayAreaRoomFundsAmount";
	private String totalOutDoorSpaceRoomFundsAmount = "totalOutDoorSpaceRoomFundsAmount";
	private String totalOtherDreamSpaceRoomFundsAmount = "totalOtherDreamSpaceRoomFundsAmount";
	private String homeLearnMoreReff = "homeLearnMoreReff";
	private String paymentOrderNumber = "paymentOrderNumber";
	private String dateComingSoonStatus = "Date coming soon";
//	private String guestDisplayBGImagePath = "resources/images/registry/reg_guest_show_images/";
	private String guestDisplayBGImagePath = "outsideImages/backgroundImages/";
	private String guestDisplayBGImageExten = ".png";
	private String messageForGuestReff = "Welcome to our registry! We are so happy and excited to share our special day with you!";
	private String uploadProfileTextReff = "<br><br>Upload<br> profile<br> picture";

	private String transactionNumberInSn = "transactionNumberInSn";
	private String accountTypeInSn = "accountTypeInSn";
	private String authorizationCodeInSn = "authorizationCodeInSn";
	private String registrentInfoSaving = "registrentInfoSaving";
	private String defaultCouponPriceInSn = "defaultCouponPriceInSn";
	
	

	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;
	
    @Autowired
    private RegistryRoomFundsInfoSavingDAO registryRoomFundsInfoSavingDAO;

    @Autowired
    private GuestRoomFundPaymentInfoSavingDAO guestRoomFundPaymentInfoSavingDAO;
    
    @Autowired
    private RegistrantPaymentInfoSavingDAO registrantPaymentInfoSavingDAO;

    @Autowired
    private UserInformationService userInformationService;

	@Autowired
    private RegistryRoomFundsPaymentInfoSavingDAO registryRoomFundsPaymentInfoSavingDAO;

	@Autowired
    private RegistrantCustomGiftCardCodeSavingDAO registrantCustomGiftCardCodeSavingDAO;

	@Autowired
	private RegistrantShippingInfoSavingDAO registrantShippingInfoSavingDAO;
	
	@Autowired
	private RegistryCashFundsInfoSavingDAO registryCashFundsInfoSavingDAO;

//	@Autowired
//	private RegistryCashFundsPaymentInfoSavingDAO registryCashFundsPaymentInfoSavingDAO;

	@Autowired
	private RegistryConceptBoardsService registryConceptBoardsService;

	@Autowired
	private RegistryFinishingTouchesService registryFinishingTouchesService;

	@Autowired
    private RegistryPaymentGatewayService registryPaymentGatewayService;

		
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
    public ModelAndView registryHomeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(registrantUserIdInSn)) {
    		mav = new ModelAndView(registryHomeALRedirection);
    		mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	} else {
    		guestUserValuesGoingToNull(req, sn);
    		mav = new ModelAndView(registryHomeRedirection);
    	}
        sn.setAttribute(userIdInSn, null);
        sn.setAttribute(guestEmailIdInSn, null);
        sn.setAttribute(guestCountInSn, null);
        sn.setAttribute(addDesignPackIdInSn, null);
        sn.setAttribute(guestReferanceInSn, null);        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryHowItWorksALRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(registrantUserIdInSn)) {
    		mav = new ModelAndView("registryHowItWorksALRedirection");
    		mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	} else{
        	mav = new ModelAndView("registryHowItWorksBLRedirection");
        }    	
        return mav;
    }
        
    @Override
    @Transactional
    public ModelAndView registryBenefitsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(registrantUserIdInSn)) {
    		mav = new ModelAndView("registryBenefitsALRedirection");
    		mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	} else{
        	mav = new ModelAndView("registryBenefitsBLRedirection");
        } 
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView registryLMDesignServicesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(registrantUserIdInSn)) {
    		mav = new ModelAndView("lmDesignServiceALRedirection");
    		mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	} else{
        	mav = new ModelAndView("lmDesignServiceBLRedirection");
        } 
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView createRegistryRedirection(HttpServletRequest req, HttpSession sn) {
    	guestUserValuesGoingToNull(req, sn);
        ModelAndView mav = new ModelAndView(createRegistryRedirection);
        mav.addObject(homeLearnMoreReff, "E-mail already exists!");
        return mav;
    }

    public String guestUserValuesGoingToNull(HttpServletRequest req, HttpSession sn) {
    	String guestValuesNull = null;
    	sn.setAttribute(userIdInSn, null);        
        sn.setAttribute("cartCountInSn", null);
        sn.setAttribute(regiCartCountInSn, null);
        sn.setAttribute(regCBContributedCartCountInSn, null);
        sn.setAttribute(regCBIndividualCountInSn, null);
        sn.setAttribute(regCBContributedCartCountInSn, null);
        sn.setAttribute(regFTContributedCartCountInSn, null);
        sn.setAttribute(regFTIndividualCartCountInSn, null);
        sn.setAttribute(shoppingCartTotalAmountStInSn, null);
        sn.setAttribute(totalFundsAmountInSn, null);
        sn.setAttribute("guestRegistrantUserIdInSn", null);
        sn.setAttribute(regiFirstNameInSn, null);
        sn.setAttribute(regUploadedPhotoInSn, null);
        sn.setAttribute(guestBackgroungImageInSn, null);
        sn.setAttribute(registrantMessageInSn, null);
        sn.setAttribute(eventDateInSn, null);
        sn.setAttribute(livingRoomFundSn, null);
        sn.setAttribute(diningRoomFundSn, null);
        sn.setAttribute(bedroomFundSn, null);
        sn.setAttribute(homeOfficeFundSn, null);
        sn.setAttribute(entrywayFundSn, null);
        sn.setAttribute(nurseryFundSn, null);
        sn.setAttribute(kidsBedroomFundSn, null);
        sn.setAttribute(playAreaFundSn, null);
        sn.setAttribute(outdoorSpaceFundSn, null);
        sn.setAttribute(otherDreamSpaceFundSn, null);
        sn.setAttribute(cashFundName, null);
        sn.setAttribute(cashFundReqAmount, null);
        sn.setAttribute(regCashFundsIdListInSn, null);
        sn.setAttribute(regCashFundsImageListInSn, null);
        sn.setAttribute(regCashFundsNameListInSn, null);
        sn.setAttribute(regCashFundsPriceListInSn, null);
        sn.setAttribute(regCashFundsContAmountListInSn, null);
        sn.setAttribute(regCashFundsRemAmountListInSn, null);
        sn.setAttribute(regCashFundsMessagesListInSn, null);
        sn.setAttribute(regCustomFundsIdListInSn, null);
        sn.setAttribute(regCustomFundsImageListInSn, null);
        sn.setAttribute(regCustomFundsNameListInSn, null);
        sn.setAttribute(regCustomFundsPriceListInSn, null);
        sn.setAttribute(regCustomFundsContAmountListInSn, null);
        sn.setAttribute(regCustomFundsRemAmountListInSn, null);
        sn.setAttribute(regCustomFundsMessagesListInSn, null);        
        sn.setAttribute("totalCashFundsAmount", null);
        sn.setAttribute("regiAddressGuestSn", null);
        sn.setAttribute(shoppingCartTotalAmountInSn, null);
    	sn.setAttribute(shoppingCartTotalAmountStInSn, null);
    	sn.setAttribute(shoppingCartSubTotalAmountInSn, null);
    	sn.setAttribute(shoppingCartShippingFeeInSn, null);
    	sn.setAttribute(totalConceptBoardsAmountInSn, null);
    	sn.setAttribute(totalFinishingTouchesAmountInSn, null);
    	sn.setAttribute(eventsTypeInSn, null);
	    sn.setAttribute(regiUserNameInSn, null);
	    sn.setAttribute(regiLastNameInSn, null);
	    sn.setAttribute(coRegiLastNameInSn, null);	    
	    sn.setAttribute("guestCBContributedProductSavingIdListInSn", null);
	    sn.setAttribute("guestCBContributedProductImageListInSn", null);
	    sn.setAttribute("guestCBContributedProductNameListInSn", null);
	    sn.setAttribute("guestCBContributedProductPriceListInSn", null);
	    sn.setAttribute("guestCBContributedProductQuantityListInSn", null);
	    sn.setAttribute("guestCBContributedRemainingAmountListInSn", null);
	    sn.setAttribute("guestCBContributedAmountListInSn", null);
	    sn.setAttribute("guestCBIndividualProductSavingIdListInSn", null);
	    sn.setAttribute("guestCBIndividualProductImageListInSn", null);
	    sn.setAttribute("guestCBIndividualProductNameListInSn", null);
	    sn.setAttribute("guestCBIndividualProductPriceListInSn", null);
	    sn.setAttribute("guestCBIndividualProductQuantityListInSn", null);
	    sn.setAttribute("guestCBIndividualRemainingQuantityListInSn", null);
	    sn.setAttribute("guestCBIndividualGivenQuantityListInSn", null);	   
	    sn.setAttribute("cbContributedProductSavingIdListInSn", null);
	    sn.setAttribute("cbContributedProductImageListInSn", null);
	    sn.setAttribute("cbContributedProductNameListInSn", null);
	    sn.setAttribute("cbContributedProductPriceListInSn", null);
	    sn.setAttribute("cbContributedProductQuantityListInSn", null);
	    sn.setAttribute("cbContributedRemainingAmountListInSn", null);
	    sn.setAttribute("cbContributedAmountListInSn", null);
	    sn.setAttribute("cbContributedPaymentStatusListInSn", null);
	    sn.setAttribute("cbIndividualProductSavingIdListInSn", null);
	    sn.setAttribute("cbIndividualProductImageListInSn", null);
	    sn.setAttribute("cbIndividualProductNameListInSn", null);
	    sn.setAttribute("cbIndividualProductPriceListInSn", null);
	    sn.setAttribute("cbIndividualProductQuantityListInSn", null);
	    sn.setAttribute("cbIndividualRemainingQuantityListInSn", null);
	    sn.setAttribute("cbIndividualGivenQuantityListInSn", null);
	    sn.setAttribute("cbIndividualPaymentStatusListInSn", null);	    
	    sn.setAttribute(totalLivingRoomFundsAmount, null);
	    sn.setAttribute(totalDyningRoomFundsAmount, null);
	    sn.setAttribute(totalBedRoomFundsAmount, null);
	    sn.setAttribute(totalHomeOfficeRoomFundsAmount, null);
	    sn.setAttribute(totalEntryWayRoomFundsAmount, null);
	    sn.setAttribute(totalNurseryRoomFundsAmount, null);
	    sn.setAttribute(totalKidsBedRoomRoomFundsAmount, null);
	    sn.setAttribute(totalPlayAreaRoomFundsAmount, null);
	    sn.setAttribute(totalOutDoorSpaceRoomFundsAmount, null);
	    sn.setAttribute(totalOtherDreamSpaceRoomFundsAmount, null);
	    return guestValuesNull;
    }

    @Override
    @Transactional
    public ModelAndView registryDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	List regDataVal = registrantInformationSavingDAO.findByUserName(req.getParameter(regUserName));
        List regAddressVal = registrantInformationSavingDAO.registryAddressValuesCheckingInDB(req.getParameter(regAddress));
        ModelAndView mav;
        if (!regDataVal.isEmpty()) {
            mav = new ModelAndView(createRegistryRedirection);
            mav.addObject(regErrorPage, "This e-mail already exists!");            
            mav.addObject(eventType, req.getParameter(eventType));
            mav.addObject(eventMonth, req.getParameter(eventMonth));
            mav.addObject(eventDay, req.getParameter(eventDay));
            mav.addObject(eventYear, req.getParameter(eventYear));
            mav.addObject(regUserName, req.getParameter(regUserName));
            mav.addObject(regFirstName, req.getParameter(regFirstName));
            mav.addObject(regLastName, req.getParameter(regLastName));
            mav.addObject(coRegFirstName, req.getParameter(coRegFirstName));
            mav.addObject(coRegLastName, req.getParameter(coRegLastName));
            mav.addObject(regAddress, req.getParameter(regAddress));
            mav.addObject(dateCheckOption, req.getParameter(dateCheckOption));
            mav.addObject(regSocialMedia, req.getParameter(regSocialMedia));
            mav.addObject(regVendorCouponId, req.getParameter(regVendorCouponId));
        } else if (!regAddressVal.isEmpty()) {
        	mav = new ModelAndView(createRegistryRedirection);
        	mav.addObject("regAddrErrorPage", "Please create your custom url!");
            mav.addObject(eventType, req.getParameter(eventType));
            mav.addObject(eventMonth, req.getParameter(eventMonth));
            mav.addObject(eventDay, req.getParameter(eventDay));
            mav.addObject(eventYear, req.getParameter(eventYear));
            mav.addObject(regUserName, req.getParameter(regUserName));
            mav.addObject(regFirstName, req.getParameter(regFirstName));
            mav.addObject(regLastName, req.getParameter(regLastName));
            mav.addObject(coRegFirstName, req.getParameter(coRegFirstName));
            mav.addObject(coRegLastName, req.getParameter(coRegLastName));
            mav.addObject(regAddress, req.getParameter(regAddress));
            mav.addObject(password, req.getParameter(password));
            mav.addObject(dateCheckOption, req.getParameter(dateCheckOption));
            mav.addObject(regSocialMedia, req.getParameter(regSocialMedia));
            mav.addObject(regVendorCouponId, req.getParameter(regVendorCouponId));
        } else {        	
        	String encrypPassword = mD5Encrypt(req.getParameter(password));
            String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
            Timestamp currentDate = currentDate();
            RegistrantInformationSaving risModel = new RegistrantInformationSaving();            
            risModel.setEventType(req.getParameter(eventType));
            String regEventDate = null;
            if((null != req.getParameter(eventMonth)) && ("" != req.getParameter(eventMonth))) {
        		regEventDate = req.getParameter(eventMonth) + "/" + req.getParameter(eventDay) + "/" + req.getParameter(eventYear);
        		risModel.setEventDate(regEventDate);
        	} else {
        		risModel.setDateCheckOption(req.getParameter(dateCheckOption));
        	}
            risModel.setRegUserName(req.getParameter(regUserName));
            String regFirstCapName = req.getParameter(regFirstName).substring(0, 1).toUpperCase() + req.getParameter(regFirstName).substring(1);
            risModel.setRegFirstName(regFirstCapName);
            risModel.setRegLastName(req.getParameter(regLastName));
            String coRegFirstCapName = null;
            if(null != req.getParameter(coRegFirstName) && "" != req.getParameter(coRegFirstName)) {
            	coRegFirstCapName = req.getParameter(coRegFirstName).substring(0, 1).toUpperCase() + req.getParameter(coRegFirstName).substring(1);
            }
            risModel.setCoRegFirstName(coRegFirstCapName);
            risModel.setCoRegLastName(req.getParameter(coRegLastName));
            risModel.setRegAddress(req.getParameter(regAddress));            
            risModel.setPassword(encrypPassword);
            risModel.setPasswordSalt(passwordSalt);            
            risModel.setTypeOfUser("R");
            risModel.setRegSocialMedia(req.getParameter(regSocialMedia));
            risModel.setRegVendorCouponId(req.getParameter(regVendorCouponId));
            String doneStatus = "Done";
            risModel.setStatus(doneStatus);
            risModel.setCreatedDate(currentDate);
            registrantInformationSavingDAO.save(risModel);
            sn.setAttribute(regFirstNamesInSn, regFirstCapName);            
            long registrantUserId = risModel.getRegistrantUserId();
            sn.setAttribute(registrantUserIdInSn, registrantUserId);
            createdRegistrantDataTakeFromDB(risModel, req, sn);
//            mav = registryOverviewRedirection(req, sn);
            registrantAccountCreationEmailSending(req, sn, req.getParameter(regUserName));
            mav = new ModelAndView(redirectStatus + registrentInfoSaving);                       
        }
        return mav;
    }
    
    public String createdRegistrantDataTakeFromDB(RegistrantInformationSaving risModel, HttpServletRequest req, HttpSession sn) {
    	String registrantInfoRef = null;
    	int monthInt = 0;
        String month = null;
        String eventDateList = null;
        if(null != risModel.getEventDate()) {
        	String[] eventDateSt = risModel.getEventDate().split("/");
        	monthInt = Integer.parseInt(eventDateSt[0]);        
        	month = new DateFormatSymbols().getMonths()[monthInt-1];
        	eventDateList = month + " " + eventDateSt[1] + ", " + eventDateSt[2];
        } else {
        	eventDateList = dateComingSoonStatus;
        }            
        String registryCombiName = risModel.getRegFirstName();
        if(null != risModel.getCoRegFirstName()) {
        	registryCombiName = risModel.getRegFirstName() + " & " + risModel.getCoRegFirstName();
        }        
    	String guestBackGroundImage = guestDisplayBGImagePath + "reg_guest_show_image2" + guestDisplayBGImageExten;
        if(null != risModel.getGuestBackgroundImg()) {
        	guestBackGroundImage = guestDisplayBGImagePath + risModel.getGuestBackgroundImg() + guestDisplayBGImageExten;
        }
        String messageForGuest = messageForGuestReff;
        if(null != risModel.getRegMessage()) {
        	messageForGuest = risModel.getRegMessage();
        }
        String buffDBImage = null;        
        if(null != risModel.getRegPhotoUpload()) {
        	byte[] regUploadedImg = risModel.getRegPhotoUpload();
        	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        	buffDBImage = "<img src='data:image/jpg;base64,"+ bufferDBImage + "' class='regi_circle_uploaded_image'>";
        } else {
        	buffDBImage = uploadProfileTextReff;
        }
        sn.setAttribute(regiFirstNameInSn, registryCombiName);
    	sn.setAttribute(guestBackgroungImageInSn, guestBackGroundImage);
    	sn.setAttribute(registrantMessageInSn, messageForGuest);
    	sn.setAttribute(eventDateInSn, eventDateList);
    	sn.setAttribute(regiStatusInSn, risModel.getStatus());
    	sn.setAttribute(regUploadedPhotoInSn, buffDBImage);
    	return registrantInfoRef;
    }

	public String registrantAccountCreationEmailSending(HttpServletRequest req, HttpSession sn, String regUserEmail) {
	  	String regCreateAccountReff = null;
	  	String[] emailList = {regUserEmail};
        String fCapName = (String) sn.getAttribute(regiFirstNameInSn);
	  	String subject = "Welcome to Nook+Cove, " + fCapName + "!";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>Thank you for registering with Nook+Cove!</p>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Congratulations!!! We are extremely excited that you've chosen us to be a part of your celebration!</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>At Nook+Cove we pride ourselves in providing a registry experience unlike any other! Our design pros have created beautifully curated designs to help you add furniture and decor to your registry. Your guests will be thrilled that they get to take part in gifting meaningful and beautiful gifts for your home!</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Now that you've taken the steps to create your registry, click below to log in to your registry and add gifts!</p>"
				+ "<p style='margin-top: 25px; font: 1.05em/1.25em sans-serif;'><a href='https://www.nookandcove.com/registryLogin'>GO TO MY REGISTRY</a></p>"								
				+ "<p style='margin-top: 25px; margin-bottom: 15px; font: 1.05em/1.5em sans-serif;'>We look forward to registry fun filled days with you!</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Registrant account creation email sending failed " + ex);
	  	}       
	  	return regCreateAccountReff;
	}

    @Override
    @Transactional
    public ModelAndView registrantHomeLandingPageRedirection(HttpServletRequest req, HttpSession sn, String regiUserName, String uPassword) {
    	String encrypPassword = mD5Encrypt(uPassword);
        String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
        List<RegistrantInformationSaving> userDataList = registrantInformationSavingDAO.findByUserInfoProperty(regiUserName, passwordSalt);
        ModelAndView mav;
        if (!userDataList.isEmpty()) {
        	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.regiUserInfoDataTakeFromDB(regiUserName, passwordSalt);
            long registrantUserId = regInfoSavingModel.getRegistrantUserId();
            sn.setAttribute(registrantUserIdInSn, registrantUserId);
            mav = new ModelAndView(redirectStatus + registryLanding);            
        } else {        	
            mav = userInformationService.loginRedirection(req, sn);
            mav.addObject(errorPageStatus, "Invalid ID or Password.");
        }        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView twoLoginPagesForRegRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(("My Design Process").equals(req.getParameter(loginRedirectRef))) {
        	mav = userInformationService.userDetailsVerificationForRegFromDB(req, sn, req.getParameter(regUserName), req.getParameter(password));
        } else if(("My Registry").equals(req.getParameter(loginRedirectRef))) {
        	mav = registryLoginVerificationFromDB(req, sn, req.getParameter(regUserName), req.getParameter(password));
        } else {
        	mav = registryLoginRedirection(req, sn);
        }
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryLoginVerificationFromDB(HttpServletRequest req, HttpSession sn, String regiUserName, String uPassword) {
    	String encrypPassword = mD5Encrypt(uPassword);
        String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
        List<RegistrantInformationSaving> userDataList = registrantInformationSavingDAO.findByUserInfoProperty(regiUserName, passwordSalt);
        ModelAndView mav;
        if (!userDataList.isEmpty()) {
        	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.regiUserInfoDataTakeFromDB(regiUserName, passwordSalt);
            long registrantUserId = regInfoSavingModel.getRegistrantUserId();
            sn.setAttribute(registrantUserIdInSn, registrantUserId);
            mav = new ModelAndView(redirectStatus + registryLanding);            
        } else {
            mav = new ModelAndView(registryLoginRedirection);
            mav.addObject(errorPageStatus, "Invalid ID or Password.");
        }        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryLandingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	registrantInformationTakeFromDB(req, sn); 
        registryRoomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	int registryTotalCount = registryTotalConcAndFundsCombCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryConceptBoardsService.registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryConceptBoardsService.registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesService.registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesService.registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	guestAndRegistryBothAllPricesListSeparation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	sn.setAttribute(regiCartCountInSn, registryTotalCount);
    	mav = new ModelAndView(registryOverviewRedirection);
    	mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));        
        mav.addObject(regStatus, sn.getAttribute(regiStatusInSn));
        mav.addObject(regTotalCartItems, registryTotalCount);    	
    	mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
    	return mav;
    }

    public String registrantInformationTakeFromDB(HttpServletRequest req, HttpSession sn) {
    	String registrantInfoRef = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        int monthInt = 0;
        String month = null;
        String eventDateList = null;
        if(null != regInfoSavingModel.getEventDate()) {
        	String[] eventDateSt = regInfoSavingModel.getEventDate().split("/");
        	monthInt = Integer.parseInt(eventDateSt[0]);        
        	month = new DateFormatSymbols().getMonths()[monthInt-1];
        	eventDateList = month + " " + eventDateSt[1] + ", " + eventDateSt[2];
        } else {
        	eventDateList = dateComingSoonStatus;
        }
        String buffDBImage = null;        
        if(null != regInfoSavingModel.getRegPhotoUpload()) {
        	byte[] regUploadedImg = regInfoSavingModel.getRegPhotoUpload();
        	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        	buffDBImage = "<img src='data:image/jpg;base64,"+ bufferDBImage + "' class='regi_circle_uploaded_image'>";
        } else {
        	buffDBImage = uploadProfileTextReff;
        }
        String fCapName = regInfoSavingModel.getRegFirstName().substring(0, 1).toUpperCase() + regInfoSavingModel.getRegFirstName().substring(1);
        String registryCombiName = regInfoSavingModel.getRegFirstName();
        if(null != regInfoSavingModel.getCoRegFirstName()) {
        	registryCombiName = regInfoSavingModel.getRegFirstName() + " & " + regInfoSavingModel.getCoRegFirstName();
        }        
        String guestBackGroundImage = registrantBackgroundImageTakeFromDB(req, sn, regInfoSavingModel.getGuestBackgroundImg(), regInfoSavingModel.getRegBackgroundUploadImage());
        String messageForGuest = messageForGuestReff;
        if(null != regInfoSavingModel.getRegMessage()) {
        	messageForGuest = regInfoSavingModel.getRegMessage();
        }        
        sn.setAttribute(regFirstNamesInSn, fCapName);
        sn.setAttribute(regiFirstNameInSn, registryCombiName);
    	sn.setAttribute(regUploadedPhotoInSn, buffDBImage);
    	sn.setAttribute(guestBackgroungImageInSn, guestBackGroundImage);
    	sn.setAttribute(registrantMessageInSn, messageForGuest);
    	sn.setAttribute(eventDateInSn, eventDateList);
    	sn.setAttribute(regiStatusInSn, regInfoSavingModel.getStatus());    	
    	return registrantInfoRef;
    }

    public String registrantBackgroundImageTakeFromDB(HttpServletRequest req, HttpSession sn, String guestBackgroundImage, byte[] regBackgroundUploadImage) {
    	String guestBackGroundImage = null;
    	if(null != guestBackgroundImage && null == regBackgroundUploadImage) {
        	guestBackGroundImage = guestDisplayBGImagePath + guestBackgroundImage + guestDisplayBGImageExten;
        } else if(null == guestBackgroundImage && null != regBackgroundUploadImage) {
        	byte[] regUploadedImg = regBackgroundUploadImage;
        	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        	guestBackGroundImage = "data:image/jpg;base64,"+ bufferDBImage;
        	sn.setAttribute(regBackgroundUploadImageInSn, guestBackGroundImage);
        } else {
        	guestBackGroundImage = guestDisplayBGImagePath + "reg_guest_show_image2" + guestDisplayBGImageExten;
        }
    	return guestBackGroundImage;
    }
    
    @Override
    @Transactional
    public ModelAndView registrentLandingDisplayRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(registrantUserIdInSn)) {       
	        registryRoomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	        registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	        registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	int registryTotalCount = registryTotalConcAndFundsCombCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	registryConceptBoardsService.registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	registryConceptBoardsService.registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	registryFinishingTouchesService.registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	registryFinishingTouchesService.registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	guestAndRegistryBothAllPricesListSeparation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	sn.setAttribute(regiCartCountInSn, registryTotalCount);
	    	mav = new ModelAndView(registryOverviewRedirection);        
	        mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
	        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
	        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
	        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
	        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
	        mav.addObject(regStatus, sn.getAttribute(regiStatusInSn));
	        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
	    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        } else {
        	mav = createRegistryRedirection(req, sn);
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryOverviewRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        registryRoomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	int registryTotalCount = registryTotalConcAndFundsCombCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryConceptBoardsService.registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryConceptBoardsService.registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesService.registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesService.registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	guestAndRegistryBothAllPricesListSeparation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	sn.setAttribute(regiCartCountInSn, registryTotalCount);
    	mav = new ModelAndView(registryOverviewRedirection);        
        mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
        mav.addObject(regStatus, sn.getAttribute(regiStatusInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }
    
    public String registryRoomFundInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String registryRoomFundInfoRef = null;        
	    String livingRoomFund = null;
	    String diningRoomFund = null;
	    String bedroomFund = null;
	    String homeOfficeFund = null;
	    String entrywayFund = null;
	    String nurseryFund = null;
	    String kidsBedroomFund = null;
	    String playAreaFund = null;
	    String outdoorSpaceFund = null;
	    String otherDreamSpaceFund = null;
	    List<RegistryRoomFundsInfoSaving> regInfoForGuestList = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowCheckingInDB(registrantUserId);
    	if (!regInfoForGuestList.isEmpty()) {
    		RegistryRoomFundsInfoSaving regInfoForGuestModel = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowValueFromDB(registrantUserId);    	
    		livingRoomFund = regInfoForGuestModel.getLivingRoom();
	    	diningRoomFund = regInfoForGuestModel.getDiningRoom();
	    	bedroomFund = regInfoForGuestModel.getBedroom();
	    	homeOfficeFund = regInfoForGuestModel.getHomeOffice();
	    	entrywayFund = regInfoForGuestModel.getEntryway();
	    	nurseryFund = regInfoForGuestModel.getNursery();
	    	kidsBedroomFund = regInfoForGuestModel.getKidsBedroom();
	    	playAreaFund = regInfoForGuestModel.getPlayArea();
	    	outdoorSpaceFund = regInfoForGuestModel.getOutdoorSpace();
	    	otherDreamSpaceFund = regInfoForGuestModel.getOtherDreamSpace();
    	}        
        sn.setAttribute(livingRoomFundSn, livingRoomFund);
    	sn.setAttribute(diningRoomFundSn, diningRoomFund);
    	sn.setAttribute(bedroomFundSn, bedroomFund);    	
    	sn.setAttribute(homeOfficeFundSn, homeOfficeFund);
    	sn.setAttribute(entrywayFundSn, entrywayFund);
    	sn.setAttribute(nurseryFundSn, nurseryFund);
    	sn.setAttribute(kidsBedroomFundSn, kidsBedroomFund);
    	sn.setAttribute(playAreaFundSn, playAreaFund);
    	sn.setAttribute(outdoorSpaceFundSn, outdoorSpaceFund);
    	sn.setAttribute(otherDreamSpaceFundSn, otherDreamSpaceFund);    	
    	return registryRoomFundInfoRef;
    }

    public String registryCashFundInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String cashFundInfo = null;       
        List regCashFundsIdList = new ArrayList();
        List regCashFundsImageList = new ArrayList();
        List regCashFundsNameList = new ArrayList();
		List regCashFundsPriceList = new ArrayList();
		List regCashFundsContAmountList = new ArrayList();
		List regCashFundsRemAmountList = new ArrayList();
		List regCashFundsMessagesList = new ArrayList();
		List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCashFundsDataCheckInDB(registrantUserId);
        if (!registryCashFundsInfoList.isEmpty()) {
    		for (RegistryCashFundsInfoSaving registryCashFundsInfoModel : registryCashFundsInfoList) {
    			regCashFundsIdList.add(registryCashFundsInfoModel.getRegistryCashFundsInfoSavingId());
	            regCashFundsImageList.add(registryCashFundsInfoModel.getCashFundImageUrl());
	            regCashFundsNameList.add(registryCashFundsInfoModel.getCashFundName());
	            regCashFundsPriceList.add(registryCashFundsInfoModel.getCashFundReqAmount());
	            regCashFundsContAmountList.add(registryCashFundsInfoModel.getTotalContributedAmount());
	            regCashFundsRemAmountList.add(registryCashFundsInfoModel.getRemainingAmount());
	            regCashFundsMessagesList.add(registryCashFundsInfoModel.getCashFundMessage());
	    	}
    	}    	   	
        sn.setAttribute(regCashFundsIdListInSn, regCashFundsIdList);    	
    	sn.setAttribute(regCashFundsImageListInSn, regCashFundsImageList);
    	sn.setAttribute(regCashFundsNameListInSn, regCashFundsNameList);
    	sn.setAttribute(regCashFundsPriceListInSn, regCashFundsPriceList);
    	sn.setAttribute(regCashFundsContAmountListInSn, regCashFundsContAmountList);
    	sn.setAttribute(regCashFundsRemAmountListInSn, regCashFundsRemAmountList);
    	sn.setAttribute(regCashFundsMessagesListInSn, regCashFundsMessagesList);
        return cashFundInfo;
    }

    public String registryCustomFundInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String cashFundInfo = null;       
        List regCustomFundsIdList = new ArrayList();
        List regCustomFundsImageList = new ArrayList();
        List regCustomFundsNameList = new ArrayList();
		List regCustomFundsPriceList = new ArrayList();
		List regCustomFundsContAmountList = new ArrayList();
		List regCustomFundsRemAmountList = new ArrayList();
		List regCustomFundsMessagesList = new ArrayList();
		List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCustomFundsDataTakeFromDB(registrantUserId);
        if (!registryCashFundsInfoList.isEmpty()) {
    		for (RegistryCashFundsInfoSaving registryCashFundsInfoModel : registryCashFundsInfoList) {
	    		regCustomFundsIdList.add(registryCashFundsInfoModel.getRegistryCashFundsInfoSavingId());
	    		String cashFundDBImage = null;
	    		if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
	            	byte[] regCFUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
	            	String cashFundUplImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regCFUploadedImg);
	            	cashFundDBImage = "data:image/jpg;base64," + cashFundUplImg;
	            } else {
	            	cashFundDBImage = cashFundBigImageUrl + registryCashFundsInfoModel.getCashFundImageUrl();
	            }
	    		regCustomFundsImageList.add(cashFundDBImage);
	            regCustomFundsNameList.add(registryCashFundsInfoModel.getCashFundName());
	            regCustomFundsPriceList.add(registryCashFundsInfoModel.getCashFundReqAmount());
	            regCustomFundsContAmountList.add(registryCashFundsInfoModel.getTotalContributedAmount());
	            regCustomFundsRemAmountList.add(registryCashFundsInfoModel.getRemainingAmount());
	            regCustomFundsMessagesList.add(registryCashFundsInfoModel.getCashFundMessage());	            
	    	}
    	}    	   	
    	sn.setAttribute(regCustomFundsIdListInSn, regCustomFundsIdList);    	
    	sn.setAttribute(regCustomFundsImageListInSn, regCustomFundsImageList);
    	sn.setAttribute(regCustomFundsNameListInSn, regCustomFundsNameList);
    	sn.setAttribute(regCustomFundsPriceListInSn, regCustomFundsPriceList);
    	sn.setAttribute(regCustomFundsContAmountListInSn, regCustomFundsContAmountList);
    	sn.setAttribute(regCustomFundsRemAmountListInSn, regCustomFundsRemAmountList);
    	sn.setAttribute(regCustomFundsMessagesListInSn, regCustomFundsMessagesList);
        return cashFundInfo;
    }
    
    public String guestAndRegistryBothAllPricesListSeparation(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String guestAndRegistryBoth = null;
    	String bothGuestAndRegistrantPrice = null;        
        List<GuestRoomFundPaymentInfoSaving> guestPaymentRowList = guestRoomFundPaymentInfoSavingDAO.guestRoomAndCashFundsPackageInfoRowCheckingInDB(registrantUserId);
        if (!guestPaymentRowList.isEmpty()) {        	
    		for (GuestRoomFundPaymentInfoSaving guestUserPaymentSavingModel : guestPaymentRowList) {
    			String guestSeleSpaceInfo = guestUserPaymentSavingModel.getGuestRoomCombValues();
    			String[] guestPaymentInfoSt = guestSeleSpaceInfo.split("__");
    			for(int i=0; i<guestPaymentInfoSt.length; i++) {
    				String[] guestOnlyRoomFundValue = guestPaymentInfoSt[i].split(",_,");    				
    				String guestPriceListSt = guestOnlyRoomFundValue[1] + ",_," + guestOnlyRoomFundValue[4] + ",_," + guestOnlyRoomFundValue[2];
    				bothGuestAndRegistrantPrice = bothGuestAndRegistrantPrice + "__" + guestPriceListSt;    		        
    			}    			
        	}
    		bothGuestAndRegistrantPrice = bothGuestAndRegistrantPrice.replaceFirst("null__", "");
		}
        sn.setAttribute(totalLivingRoomFundsAmount, separateLivingRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalDyningRoomFundsAmount, separateDyningRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalBedRoomFundsAmount, separateBedRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalHomeOfficeRoomFundsAmount, separateHomeOfficeRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalEntryWayRoomFundsAmount, separateEntryWayRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalNurseryRoomFundsAmount, separateNurseryRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalKidsBedRoomRoomFundsAmount, separateKidsBedRoomRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalPlayAreaRoomFundsAmount, separatePlayAreaRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalOutDoorSpaceRoomFundsAmount, separateOutDoorSpaceRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute(totalOtherDreamSpaceRoomFundsAmount, separateOtherDreamSpaceRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
		return guestAndRegistryBoth;
    }

    public String separateLivingRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalLivingRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((livingRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((livingRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((livingRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((livingRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((livingRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
		totalLivingRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalLivingRoomFundAmount;
    }

    public String separateDyningRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalDyningRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((diningRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((diningRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((diningRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((diningRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((diningRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalDyningRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalDyningRoomFundAmount;
    }

    public String separateBedRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalBedRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((bedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((bedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((bedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((bedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((bedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalBedRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalBedRoomFundAmount;
    }

    public String separateHomeOfficeRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalHomeOfficeRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((homeOfficeFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((homeOfficeFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((homeOfficeFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((homeOfficeFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((homeOfficeFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalHomeOfficeRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalHomeOfficeRoomFundAmount;
    }

    public String separateEntryWayRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalEntryWayRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((entryWayFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((entryWayFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((entryWayFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((entryWayFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((entryWayFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalEntryWayRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalEntryWayRoomFundAmount;
    }

    public String separateNurseryRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalNurseryRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((nurseryFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((nurseryFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((nurseryFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((nurseryFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((nurseryFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalNurseryRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalNurseryRoomFundAmount;
    }

    public String separateKidsBedRoomRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalKidsBedRoomRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((kidsBedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((kidsBedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((kidsBedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((kidsBedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((kidsBedRoomFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalKidsBedRoomRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalKidsBedRoomRoomFundAmount;
    }

    public String separatePlayAreaRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalPlayAreaRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((playAreaFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((playAreaFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((playAreaFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((playAreaFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((playAreaFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalPlayAreaRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalPlayAreaRoomFundAmount;
    }

    public String separateOutDoorSpaceRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalOutDoorSpaceRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((outdoorSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((outdoorSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((outdoorSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((outdoorSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((outdoorSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalOutDoorSpaceRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalOutDoorSpaceRoomFundAmount;
    }

    public String separateOtherDreamSpaceRoomFundsGiftedAmoutList(String bothGuestAndRegistrantPrice) {
    	String totalOtherDreamSpaceRoomFundAmount = null;
        double totalRoomAmount1 = 0;
        double totalRoomAmount2 = 0;
        double totalRoomAmount3 = 0;
        double totalRoomAmount4 = 0;
        double totalRoomAmount5 = 0;
        if (null != bothGuestAndRegistrantPrice) {
    		String[] bothGuestAndRegistrantPaymentInfoSt = bothGuestAndRegistrantPrice.split("__");
    		for(int i=0; i<bothGuestAndRegistrantPaymentInfoSt.length; i++) {
    			String[] onlyRoomFundValue = bothGuestAndRegistrantPaymentInfoSt[i].split(",_,");    				
    			int roomCountInt = Integer.parseInt(onlyRoomFundValue[1]);
    			double roomAmountInt = Double.parseDouble(onlyRoomFundValue[2]);
    		    if((dreamSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 1) {
    		       	totalRoomAmount1 = totalRoomAmount1 + roomAmountInt;
    		    } else if((dreamSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 2) {
    		       	totalRoomAmount2 = totalRoomAmount2 + roomAmountInt;
    		    } else if((dreamSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 3) {
    		       	totalRoomAmount3 = totalRoomAmount3 + roomAmountInt;
    		    } else if((dreamSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 4) {
    		       	totalRoomAmount4 = totalRoomAmount4 + roomAmountInt;
    		    } else if((dreamSpaceFund).equals(onlyRoomFundValue[0]) && roomCountInt == 5) {
    		       	totalRoomAmount5 = totalRoomAmount5 + roomAmountInt;
    		    }
    		}
		}
        totalOtherDreamSpaceRoomFundAmount = totalRoomAmount1 + "__" + totalRoomAmount2 + "__" + totalRoomAmount3 + "__" + totalRoomAmount4 + "__" + totalRoomAmount5;
        return totalOtherDreamSpaceRoomFundAmount;
    }

    @Override
    @Transactional
    public ModelAndView registrantBackgroundImageUploadInDB(MultipartFile regPhotoUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;
    	String fileName = regPhotoUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	regPhotoUpload.transferTo(conFile);
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
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        regInfoSavingModel.setRegBackgroundUploadImage(bFile);
        regInfoSavingModel.setGuestBackgroundImg(null);
        regInfoSavingModel.setUpdatedDate(currentDate);
        registrantInformationSavingDAO.merge(regInfoSavingModel);
        String buffDBImage = null;
        if(null != regInfoSavingModel.getRegBackgroundUploadImage()) {
        	byte[] regUploadedImg = regInfoSavingModel.getRegBackgroundUploadImage();
        	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        	buffDBImage = "data:image/jpg;base64,"+ bufferDBImage;
        } 
        sn.setAttribute(regBackgroundUploadImageInSn, buffDBImage);
        sn.setAttribute(guestBackgroungImageInSn, buffDBImage);
        mav = registryOverviewRedirection(req, sn);    	
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView createdRoomFundsInfoRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;        
        mav = new ModelAndView(createdRoomAndCashFundsRedirection);
        mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
        mav.addObject(regStatus, sn.getAttribute(regiStatusInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject("selRoomCashFund", "Selected Room Cash Fund");
    	sn.setAttribute(landingRefValInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView createCashFundsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	sn.setAttribute(landingBackRefInSn, null);
    	sn.setAttribute(landingCFBackRefInSn, null);
        mav = new ModelAndView(createdCashFundRedirection);
        mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
        mav.addObject(regStatus, sn.getAttribute(regiStatusInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));        
    	mav.addObject("selRoomCashFund", "Selected Room Cash Fund");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView uploadRegistrantProfileInDB(MultipartFile regPhotoUpload, String uploadImgReferance, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;
    	String fileName = regPhotoUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	regPhotoUpload.transferTo(conFile);
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
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        regInfoSavingModel.setRegPhotoUpload(bFile);
        regInfoSavingModel.setUpdatedDate(currentDate);
        registrantInformationSavingDAO.merge(regInfoSavingModel);
        String buffDBImage = null;        
        if(null != regInfoSavingModel.getRegPhotoUpload()) {
        	byte[] regUploadedImg = regInfoSavingModel.getRegPhotoUpload();
        	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        	buffDBImage = "<img src='data:image/jpg;base64,"+ bufferDBImage + "' class='regi_circle_uploaded_image'>";
        } else {
        	buffDBImage = uploadProfileTextReff;
        } 
        sn.setAttribute(regUploadedPhotoInSn, buffDBImage);
        mav = new ModelAndView(redirectStatus + "registryUploadImageRedirect");
    	mav.addObject("uploadImageReferance", uploadImgReferance);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryUploadImageRedirectToJSP(String uploadImgReferance, HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(("landingImageUpload").equals(uploadImgReferance)) {
        	mav = registryOverviewRedirection(req, sn);
        } else if(("roomFundImageUpload").equals(uploadImgReferance)) {
        	mav = createdRoomFundsInfoRedirection(req, sn);
        } else if(("conceptBoardsImageUpload").equals(uploadImgReferance)) {
        	mav = designConceptsBoardsForLandingDataMaintain(req, sn);
        }else if(("cashFundImageUpload").equals(uploadImgReferance)) {
        	mav = createCashFundsRedirection(req, sn);
        } else {
        	mav = registryOverviewRedirection(req, sn);
        }
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView saveRegiMessageDataInDB(String regMesReferance, HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;        
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        String messageToGuest = req.getParameter("messageToGuests");
        messageToGuest = messageToGuest.replaceAll("[\n\r]", " ");
        regInfoSavingModel.setRegMessage(messageToGuest);
        registrantInformationSavingDAO.merge(regInfoSavingModel);
        sn.setAttribute(registrantMessageInSn, messageToGuest);
        if(("messageLanding").equals(regMesReferance)) {
        	mav = registryOverviewRedirection(req, sn);
        } else if(("messageRoomfund").equals(regMesReferance)) {
        	mav = createdRoomFundsInfoRedirection(req, sn);
        } else if(("messageConceptBoards").equals(regMesReferance)) {
        	mav = designConceptsBoardsForLandingDataMaintain(req, sn);
        } else if(("messageCashfund").equals(regMesReferance)) {
        	mav = createCashFundsRedirection(req, sn);
        } else {
        	mav = registryOverviewRedirection(req, sn);
        }
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView designConceptsBoardsForLandingDataMaintain(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;                
        mav = new ModelAndView(designCuratedConceptsBoardsRed);        
        mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
        mav.addObject(regStatus, sn.getAttribute(regiStatusInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        mav.addObject("desnCurConBoards", "Design Curated Con Boards");    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regEditBackgroundImageForGuest(String regReferance, HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        String guestBackGroundImage = registrantBackgroundImageTakeFromDB(req, sn, regInfoSavingModel.getGuestBackgroundImg(), regInfoSavingModel.getRegBackgroundUploadImage());        
        sn.setAttribute(guestBackgroungImageInSn, guestBackGroundImage);	  	
        mav = new ModelAndView(regEditBackgroundImgForGuestRed);
    	mav.addObject(guestBackgroungImage, guestBackGroundImage);
    	mav.addObject(regiReferance, regReferance);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }    
    
    @Override
    @Transactional
    public ModelAndView regEditBackgroundImageSaveInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        String bgImagesName = req.getParameter("bgImageName");
        regInfoSavingModel.setGuestBackgroundImg(bgImagesName);
        regInfoSavingModel.setRegBackgroundUploadImage(null);
        registrantInformationSavingDAO.merge(regInfoSavingModel);
        String regReferance = req.getParameter(regiReferance);
        String guestBackGroundImage = guestDisplayBGImagePath + regInfoSavingModel.getGuestBackgroundImg() + guestDisplayBGImageExten;
        sn.setAttribute(guestBackgroungImageInSn, guestBackGroundImage);
        sn.setAttribute(regBackgroundUploadImageInSn, null);
        if(("landingEditBackground").equals(regReferance)) {
        	mav = registryOverviewRedirection(req, sn);
        } else if(("roomFundEditBackground").equals(regReferance)) {
        	mav = createdRoomFundsInfoRedirection(req, sn);
        } else if(("conceptBoardsEditBackground").equals(regReferance)) {
        	mav = designConceptsBoardsForLandingDataMaintain(req, sn);
        }else if(("cashFundEditBackground").equals(regReferance)) {
        	mav = createCashFundsRedirection(req, sn);
        } else {
        	mav = registryOverviewRedirection(req, sn);
        }        
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView previewGuestRegistryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView(previewGuestRegistryRed);
    	mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regSpaceBackMoveRedirection(HttpServletRequest req, HttpSession sn) {
 	   	ModelAndView mav;
 	   	if((landingRefVal).equals(sn.getAttribute(landingRefValInSn))) {
   		mav = registryOverviewRedirection(req, sn);
	   	} else {
	   		mav = createdRoomFundsInfoRedirection(req, sn);
	   	}
 	   	mav.addObject(regBackReffVal, "Reg Back Move");
 	   	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryRoomFundsInfoDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String roomFundsInfoValue = null;
    	List<RegistryRoomFundsInfoSaving> regInfoForGuestList = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regInfoForGuestList.isEmpty()) {
    		roomFundsInfoValue = registryRoomFundsInfoDisplayDataFromDB(req, sn);
    	} else {
    		registryRoomFoundsInfoCreateInDatabase(req, sn, req.getParameter(nameOfTheRoomFund), req.getParameter(selSpaceCountAndAmount));
    	}
    	sn.setAttribute(landingRefValInSn, req.getParameter(landingRef));
    	mav = new ModelAndView(registryRoomFundsInfoDisplay);    	
    	mav.addObject(selSpaceCountAndAmount, roomFundsInfoValue);
    	mav.addObject(nameOfTheRoomFund, req.getParameter(nameOfTheRoomFund));
    	mav.addObject(titleOfTheRoomFund, req.getParameter(nameOfTheRoomFund).replace(" FUND", ""));
    	mav.addObject(imageOfTheRoomFund, req.getParameter(imageOfTheRoomFund));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }

    public String registryRoomFundsInfoDisplayDataFromDB(HttpServletRequest req, HttpSession sn) {
    	String roomFundsInfoValue = null;
    	RegistryRoomFundsInfoSaving regInfoForGuestSavingModel = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowValueFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if((livingRoomFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getLivingRoom();			
    	} else if((diningRoomFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getDiningRoom();
    	} else if((bedRoomFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getBedroom();
    	} else if((homeOfficeFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getHomeOffice();
    	} else if((entryWayFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getEntryway();
    	} else if((nurseryFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getNursery();
    	} else if((kidsBedRoomFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getKidsBedroom();
    	} else if((playAreaFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getPlayArea();
    	} else if((outdoorSpaceFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getOutdoorSpace();
    	} else if((dreamSpaceFund).equals(req.getParameter(nameOfTheRoomFund))) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getOtherDreamSpace();
    	}
    	return roomFundsInfoValue;
    }

    @Override
    @Transactional
    public ModelAndView registryRoomFoundInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistryRoomFundsInfoSaving> regInfoForGuestList = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regInfoForGuestList.isEmpty()) {
    		registryRoomFoundsInfoUpdateInDatabase(req, sn, req.getParameter(nameOfTheRoomFund), req.getParameter(selSpaceCountAndAmount));
    	} else {
    		registryRoomFoundsInfoCreateInDatabase(req, sn, req.getParameter(nameOfTheRoomFund), req.getParameter(selSpaceCountAndAmount));
    	}
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	return mav;
    }

    public String registryRoomFoundsInfoUpdateInDatabase(HttpServletRequest req, HttpSession sn, String nameOfTheRoomFund, String selSpaceCountAndAmount) {
    	String roomFundUpdatedData = null;
    	Timestamp currentDate = currentDate();
    	RegistryRoomFundsInfoSaving regInfoForGuestModel = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowValueFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if((livingRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setLivingRoom(selSpaceCountAndAmount);
    		sn.setAttribute(livingRoomFundSn, selSpaceCountAndAmount);
    	} else if((diningRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setDiningRoom(selSpaceCountAndAmount);
    		sn.setAttribute(diningRoomFundSn, selSpaceCountAndAmount);
    	} else if((bedRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setBedroom(selSpaceCountAndAmount);
    		sn.setAttribute(bedroomFundSn, selSpaceCountAndAmount);
    	} else if((homeOfficeFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setHomeOffice(selSpaceCountAndAmount);
    		sn.setAttribute(homeOfficeFundSn, selSpaceCountAndAmount);
    	} else if((entryWayFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setEntryway(selSpaceCountAndAmount);
    		sn.setAttribute(entrywayFundSn, selSpaceCountAndAmount);
    	} else if((nurseryFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setNursery(selSpaceCountAndAmount);
    		sn.setAttribute(nurseryFundSn, selSpaceCountAndAmount);
    	} else if((kidsBedRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setKidsBedroom(selSpaceCountAndAmount);
    		sn.setAttribute(kidsBedroomFundSn, selSpaceCountAndAmount);
    	} else if((playAreaFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setPlayArea(selSpaceCountAndAmount);
    		sn.setAttribute(playAreaFundSn, selSpaceCountAndAmount);
    	} else if((outdoorSpaceFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setOutdoorSpace(selSpaceCountAndAmount);
    		sn.setAttribute(outdoorSpaceFundSn, selSpaceCountAndAmount);
    	} else if((dreamSpaceFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setOtherDreamSpace(selSpaceCountAndAmount);
    		sn.setAttribute(otherDreamSpaceFundSn, selSpaceCountAndAmount);
    	}
    	regInfoForGuestModel.setUpdatedDate(currentDate);
		registryRoomFundsInfoSavingDAO.merge(regInfoForGuestModel);
    	return roomFundUpdatedData;
    }

    public String registryRoomFoundsInfoCreateInDatabase(HttpServletRequest req, HttpSession sn, String nameOfTheRoomFund, String selSpaceCountAndAmount) {
    	String roomFundCreateData = null;
    	Timestamp currentDate = currentDate();
    	RegistryRoomFundsInfoSaving regInfoForGuestModel = new RegistryRoomFundsInfoSaving();
    	if((livingRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setLivingRoom(selSpaceCountAndAmount);
    		sn.setAttribute(livingRoomFundSn, selSpaceCountAndAmount);
    	} else if((diningRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setDiningRoom(selSpaceCountAndAmount);
    		sn.setAttribute(diningRoomFundSn, selSpaceCountAndAmount);
    	} else if((bedRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setBedroom(selSpaceCountAndAmount);
    		sn.setAttribute(bedroomFundSn, selSpaceCountAndAmount);
    	} else if((homeOfficeFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setHomeOffice(selSpaceCountAndAmount);
    		sn.setAttribute(homeOfficeFundSn, selSpaceCountAndAmount);
    	} else if((entryWayFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setEntryway(selSpaceCountAndAmount);
    		sn.setAttribute(entrywayFundSn, selSpaceCountAndAmount);
    	} else if((nurseryFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setNursery(selSpaceCountAndAmount);
    		sn.setAttribute(nurseryFundSn, selSpaceCountAndAmount);
    	} else if((kidsBedRoomFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setKidsBedroom(selSpaceCountAndAmount);
    		sn.setAttribute(kidsBedroomFundSn, selSpaceCountAndAmount);
    	} else if((playAreaFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setPlayArea(selSpaceCountAndAmount);
    		sn.setAttribute(playAreaFundSn, selSpaceCountAndAmount);
    	} else if((outdoorSpaceFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setOutdoorSpace(selSpaceCountAndAmount);
    		sn.setAttribute(outdoorSpaceFundSn, selSpaceCountAndAmount);
    	} else if((dreamSpaceFund).equals(nameOfTheRoomFund)) {
    		regInfoForGuestModel.setOtherDreamSpace(selSpaceCountAndAmount);
    		sn.setAttribute(otherDreamSpaceFundSn, selSpaceCountAndAmount);
    	}
    	regInfoForGuestModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    	regInfoForGuestModel.setCreatedDate(currentDate);
		registryRoomFundsInfoSavingDAO.save(regInfoForGuestModel);
    	return roomFundCreateData;
    }

    @Override
    @Transactional
    public ModelAndView registryRoomFundsLandingInfoEditInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String roomFundsInfoValue = null;
    	String[] totalRoomFundCombValue = req.getParameter(landingRef).split("__");
    	String namesOfTheRoomFund = totalRoomFundCombValue[1];
    	String titlesOfTheRoomFund = totalRoomFundCombValue[1].replace(" FUND", "");
    	String imagesOfTheRoomFund = totalRoomFundCombValue[2];
    	RegistryRoomFundsInfoSaving regInfoForGuestSavingModel = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowValueFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if((livingRoomFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getLivingRoom();			
    	} else if((diningRoomFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getDiningRoom();
    	} else if((bedRoomFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getBedroom();
    	} else if((homeOfficeFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getHomeOffice();
    	} else if((entryWayFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getEntryway();
    	} else if((nurseryFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getNursery();
    	} else if((kidsBedRoomFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getKidsBedroom();
    	} else if((playAreaFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getPlayArea();
    	} else if((outdoorSpaceFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getOutdoorSpace();
    	} else if((dreamSpaceFund).equals(namesOfTheRoomFund)) {
    		roomFundsInfoValue = regInfoForGuestSavingModel.getOtherDreamSpace();
    	}    	
    	sn.setAttribute(landingRefValInSn, req.getParameter(landingRef));
    	mav = new ModelAndView(registryRoomFundsInfoDisplay);    	
    	mav.addObject(selSpaceCountAndAmount, roomFundsInfoValue);
    	mav.addObject(nameOfTheRoomFund, namesOfTheRoomFund);
    	mav.addObject(titleOfTheRoomFund, titlesOfTheRoomFund);
    	mav.addObject(imageOfTheRoomFund, imagesOfTheRoomFund);
    	sn.setAttribute(landingRefValInSn, totalRoomFundCombValue[0]);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView roomFundAndLandingPageRedirections(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = registryOverviewRedirection(req, sn);
    	return mav;
    }

    @Override
    @Transactional
    public JSONArray jSonRegistryMakeVisibleAccessInDB(String liveStatusRef, HttpServletRequest req, HttpSession sn) {
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if(("Live Status On").equals(liveStatusRef)) {
    		regInfoSavingModel.setStatus("Done");
        	registrantInformationSavingDAO.merge(regInfoSavingModel);
    	} else {
    		regInfoSavingModel.setStatus(null);
        	registrantInformationSavingDAO.merge(regInfoSavingModel);
    	}
    	sn.setAttribute(regiStatusInSn, regInfoSavingModel.getStatus());
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regInfoSavingModel.getStatus());
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }

    @Override
    @Transactional
    public ModelAndView registryLoginRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav = new ModelAndView(registryLoginRedirection);
        guestUserValuesGoingToNull(req, sn);
        return mav;
    }
 
    @Override
    @Transactional
    public ModelAndView regLogOutRedirection(HttpServletRequest req, HttpSession sn) {
    	guestUserValuesGoingToNull(req, sn);
    	ModelAndView mav = new ModelAndView(registryLoginRedirection);
    	mav.addObject("logOutMessage", "You have been successfully logged out.");
        sn.setAttribute(registrantUserIdInSn, null);
        sn.setAttribute(userIdInSn, null);
        sn.setAttribute(regFirstNamesInSn, null);
        sn.setAttribute(userIdInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryForgotPasswordRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(regForgotPasswordRedirection);            
    	return mav;
    }
    
    @Override
    @Transactional    
    public ModelAndView regForgotPasswordSentToMail(HttpServletRequest req, HttpSession sn) {
    	EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";
        List regDataVal = registrantInformationSavingDAO.findByUserName(req.getParameter(regUserName));        
        ModelAndView mav;
        if (!regDataVal.isEmpty()) {
        	RegistrantInformationSaving regInfoData = registrantInformationSavingDAO.findByUserInfoFromDB(req.getParameter(regUserName));            
            long userId = regInfoData.getRegistrantUserId();
            String firstName = regInfoData.getRegFirstName();
            String lastName = regInfoData.getRegLastName();            
            String lastSingleName = String.valueOf(lastName.charAt(0)).toUpperCase();
            String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            String fullName = fCapName +" "+lastSingleName;            
            String alphaNumerics = "ab1cde2fgh3ijk4mnp5qrs6tuv7wxy8zAB9CDEFGHIJKLMNPQRST0UVWXYZ";
            String t = "";
            for (int i = 0; i < 8; i++) {
                t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
            }
            String securityPin = t;
            Timestamp currentDate = currentDate();            
            RegistrantInformationSaving regInformation = registrantInformationSavingDAO.registryDataTakeFromDB(userId);            
            regInformation.setSecurityPin(securityPin);           
            regInformation.setEmailSentDate(currentDate);
            registrantInformationSavingDAO.merge(regInformation);            
            String aTo = req.getParameter(regUserName);
            String aSubject = "Nook + Cove Reset Password";
            String spin = securityPin;
            String type = "text/html";
            String body = "<body>" 
                        + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                        + "<p style='padding-top: 5px;'>Hello &nbsp;" + fullName + ", </p> <br/>"
                        + "<p style='padding-top: 5px;'>Please use the Security Pin below to create a new password.</p>"
                        + "<p style='padding-top: 5px;'>SECURITY PIN: <b>" + spin + "</b></p> <br/><br/>"
                        + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                        + "</div>"
                        + "</body> "; 
            try {
                userEmail.sendEmail(aTo, aSubject, body, type, fromAdd);
            } catch (Exception ex) {
            	LOGGER.error("forgetPasswordWithEmailChecking " + ex);
            }
            mav = new ModelAndView(regSecurityPinRedirection);            
            sn.setAttribute(seqUserIdInSn, userId);
            sn.setAttribute(securityPinInSn, securityPin);            
            mav.addObject("secPinMessage", " A Security Pin has been sent to your e-mail");
        } else {
            mav = new ModelAndView(regForgotPasswordRedirection);
            mav.addObject("forPassErrorPage", " E-mail ID not found!");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regForgotPassSecPinCheVerification(HttpServletRequest req, HttpSession sn) {
    	String snSecPin = (String) sn.getAttribute(securityPinInSn);
        long snUserId = (Long) sn.getAttribute(seqUserIdInSn);
        String secPin = req.getParameter("securityPin");
        String newPassword = req.getParameter("newPassword");
        ModelAndView mav;
        if (snSecPin.equals(secPin)) {        	
            String encrypPassword = mD5Encrypt(newPassword);
            String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
            Timestamp currentDate = currentDate();
            RegistrantInformationSaving regInformation = registrantInformationSavingDAO.registryDataTakeFromDB(snUserId);
            regInformation.setPassword(encrypPassword);
            regInformation.setPasswordSalt(passwordSalt);
            regInformation.setLastPasswordChangedDate(currentDate);
            registrantInformationSavingDAO.merge(regInformation);
            mav = new ModelAndView(registryLoginRedirection);
        } else {
        	mav = new ModelAndView(regSecurityPinRedirection);
            mav.addObject("forPassSeqPinErrorPage", " Please enter correct Security Pin!");
        }
        return mav;
    }
    
    @Override
    @Transactional
    public JSONArray jSonRoomFundContributedLandingInfoDeleteFromDB(String totalRoomFundInfo, HttpServletRequest req, HttpSession sn) {
    	jSonRoomFundContributedLandingInfoRedirection(req, sn, totalRoomFundInfo);
    	int regTotalCartCount = registryShoppingCartTotalCount(req, sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }

    public String jSonRoomFundContributedLandingInfoRedirection(HttpServletRequest req, HttpSession sn, String totalRoomFundInfo) {
    	String remainingRoomFundsInfoRef = null;    	
    	String[] totalRoomFundInfoValue = totalRoomFundInfo.split("___");
    	String roomFundsName = totalRoomFundInfoValue[0];
    	String roomFundColumnCount = totalRoomFundInfoValue[1];
    	RegistryRoomFundsInfoSaving regInfoForGuestSavingModel = registryRoomFundsInfoSavingDAO.selectedRegAddGiftRowValueFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String remainingRoomFundsInfo = null;
    	if((livingRoomFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getLivingRoom(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setLivingRoom(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(livingRoomFundSn, regInfoForGuestSavingModel.getLivingRoom());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), livingRoomFund, roomFundColumnCount);
    	} else if((diningRoomFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getDiningRoom(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setDiningRoom(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(diningRoomFundSn, regInfoForGuestSavingModel.getDiningRoom());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), diningRoomFund, roomFundColumnCount);
    	} else if((bedRoomFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getBedroom(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setBedroom(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(bedroomFundSn, regInfoForGuestSavingModel.getBedroom());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), bedRoomFund, roomFundColumnCount);
    	} else if((homeOfficeFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getHomeOffice(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setHomeOffice(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(homeOfficeFundSn, regInfoForGuestSavingModel.getHomeOffice());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), homeOfficeFund, roomFundColumnCount);
    	} else if((entryWayFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getEntryway(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setEntryway(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(entrywayFundSn, regInfoForGuestSavingModel.getEntryway());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), entryWayFund, roomFundColumnCount);
    	} else if((nurseryFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getNursery(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setNursery(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(nurseryFundSn, regInfoForGuestSavingModel.getNursery());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), nurseryFund, roomFundColumnCount);
    	} else if((kidsBedRoomFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getKidsBedroom(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setKidsBedroom(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(kidsBedroomFundSn, regInfoForGuestSavingModel.getKidsBedroom());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), kidsBedRoomFund, roomFundColumnCount);
    	} else if((playAreaFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getPlayArea(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setPlayArea(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(playAreaFundSn, regInfoForGuestSavingModel.getPlayArea());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), playAreaFund, roomFundColumnCount);
    	} else if((outdoorSpaceFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getOutdoorSpace(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setOutdoorSpace(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(outdoorSpaceFundSn, regInfoForGuestSavingModel.getOutdoorSpace());		
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), outdoorSpaceFund, roomFundColumnCount);
    	} else if((dreamSpaceFund).equals(roomFundsName)) {
    		remainingRoomFundsInfo = registryRoomFundSelectedInfoDeleteFromDB(req, sn, regInfoForGuestSavingModel.getOtherDreamSpace(), roomFundColumnCount);
    		regInfoForGuestSavingModel.setOtherDreamSpace(remainingRoomFundsInfo);
			registryRoomFundsInfoSavingDAO.merge(regInfoForGuestSavingModel);
			sn.setAttribute(otherDreamSpaceFundSn, regInfoForGuestSavingModel.getOtherDreamSpace());	
			registryAllRoomsCartInfoDeleteFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), dreamSpaceFund, roomFundColumnCount);
    	}
    	return remainingRoomFundsInfoRef;
    }

    public String registryRoomFundSelectedInfoDeleteFromDB(HttpServletRequest req, HttpSession sn, String dbRoomFundColumnInfo, String roomFundColCount) {
    	String remainingRoomFundsInfo = null;
    	String[] dbRoomFundColumnInfoSt = dbRoomFundColumnInfo.split("__");
    	for(int i=0; i < dbRoomFundColumnInfoSt.length; i++) {
    		String[] dbRoomFundSeparateColumns = dbRoomFundColumnInfoSt[i].split("_,_");
    		if(!(roomFundColCount).equals(dbRoomFundSeparateColumns[0])) { 
    			remainingRoomFundsInfo = remainingRoomFundsInfo + "__" + dbRoomFundColumnInfoSt[i];
    		}
    	}
    	if(null != remainingRoomFundsInfo) {
    		remainingRoomFundsInfo = remainingRoomFundsInfo.replaceFirst("null__", "");
    	}
    	return remainingRoomFundsInfo;
    }

    public String registryAllRoomsCartInfoDeleteFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId, String regRoomFundName, String regRoomFundCount) {
    	String regAllRoomsCartInfo = null;
    	List<RegistryRoomFundsPaymentInfoSaving> regRoomCashSavingList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundPSNRowCheckingInDB(registrantUserId);
    	if (!regRoomCashSavingList.isEmpty()) {    		
    		RegistryRoomFundsPaymentInfoSaving regRoomCashSavingModel = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundRowDataTakingFromDB(registrantUserId);
    		String dbRoomInfodsp = regRoomCashSavingModel.getSelectedRoomFundsInfo();
        	int dbCartNo = regRoomCashSavingModel.getPaymentCartNo();
        	String dbTotalSpaceAmount = regRoomCashSavingModel.getContributedRoomFundAmount();
        	String dbAllTotalAmount = regRoomCashSavingModel.getTotalAmount();
        	String roomFundInfoAndPrice = registrySelectedRoomsInfoAndPrice(dbRoomInfodsp, regRoomFundName, regRoomFundCount);
        	if(null != roomFundInfoAndPrice) {
	        	String[] regiRoomFundInfoDivide = roomFundInfoAndPrice.split("&&");
	        	String totalRoomFundInfo = regiRoomFundInfoDivide[0];
	        	String roomFundPrice = regiRoomFundInfoDivide[1];
	        	double dbTotalSpaceAmountInDb = 0;
	        	if(null != dbTotalSpaceAmount) {
	        		dbTotalSpaceAmountInDb = Double.parseDouble(dbTotalSpaceAmount);
	        	}
	        	double dbAllTotalAmountInDb = 0;
	        	if(null != dbAllTotalAmount) {
	        		dbAllTotalAmountInDb = Double.parseDouble(dbAllTotalAmount);
	        	}
	        	double givenSpaceAmountDb = 0;
	        	if(null != roomFundPrice) {
	        		givenSpaceAmountDb = Double.parseDouble(roomFundPrice);
	        	}        	
	        	String regiRemainingSpaceInfo = null;
	        	String[] dbRoomSpaceSeparation = dbRoomInfodsp.split("__");
	        	for(int i = 0; i < dbRoomSpaceSeparation.length; i++) {
	        		if(!totalRoomFundInfo.equals(dbRoomSpaceSeparation[i])) {
	        			regiRemainingSpaceInfo = regiRemainingSpaceInfo + "__" + dbRoomSpaceSeparation[i];
	        		} 
	        	}
	        	if(dbRoomSpaceSeparation.length > 1) {
	        		regiRemainingSpaceInfo = regiRemainingSpaceInfo.replaceFirst("null__", "");
	        	}
	        	int remaingCatNo = dbCartNo - 1;
	        	double remTotalSpaceAmount = dbTotalSpaceAmountInDb - givenSpaceAmountDb;
	        	String remTotSpaceAmount = String.format("%.2f", remTotalSpaceAmount);
	        	double remAllTotalAmountInDb = dbAllTotalAmountInDb - givenSpaceAmountDb;
	        	String remAllTotalAmount = String.format("%.2f", remAllTotalAmountInDb);    	
	        	if(remaingCatNo > 0) {
	        		regRoomCashSavingModel.setSelectedRoomFundsInfo(regiRemainingSpaceInfo);
	        		regRoomCashSavingModel.setPaymentCartNo(remaingCatNo);
	        		regRoomCashSavingModel.setContributedRoomFundAmount(remTotSpaceAmount);
	        		regRoomCashSavingModel.setTotalAmount(remAllTotalAmount);
	        		registryRoomFundsPaymentInfoSavingDAO.merge(regRoomCashSavingModel);
	        	} else {
	        		registryRoomFundsPaymentInfoSavingDAO.delete(regRoomCashSavingModel);
	        	}
	        	sn.setAttribute(registryRoomFundsCountInSn, remaingCatNo);
        	}
    	}
    	return regAllRoomsCartInfo;
    }
    
    public String registrySelectedRoomsInfoAndPrice(String dnRegRoomFundInfo, String regRoomFundName, String regRoomFundCount) {
    	String roomInfoAndPrice = null;
    	String[] regRoomFundInfoSt = dnRegRoomFundInfo.split("__");    	
    	for(int i=0; i<regRoomFundInfoSt.length; i++) {
    		String[] regRoomFundInfoDivide = regRoomFundInfoSt[i].split(",_,");
    		String dbRoomFundName = regRoomFundInfoDivide[1];
    		String dbRoomFundCount = regRoomFundInfoDivide[4];
    		if((regRoomFundName).equals(dbRoomFundName) && (regRoomFundCount).equals(dbRoomFundCount)) {
    			String roomFundPrice = regRoomFundInfoDivide[2];
    			String totalRoomFundInfo = regRoomFundInfoSt[i];
    			roomInfoAndPrice = totalRoomFundInfo + "&&" + roomFundPrice;
    			break;
    		}
    	}    	
    	return roomInfoAndPrice;
    }
    
    @Override
    @Transactional
    public ModelAndView registrySpaceSelContributeCartInfoDeleteFromDB(long registrantUserId, HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List regRoomAndCashFundSavingList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundPSNRowCheckingInDB(registrantUserId);
    	if (!regRoomAndCashFundSavingList.isEmpty()) {
	    	RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundSavingModel = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundRowDataTakingFromDB(registrantUserId);    	
			String cartRegiUserInfoList = regRoomAndCashFundSavingModel.getSelectedRoomFundsInfo();			
			int cartCount = 0;
	    	double totalRegPrice = 0;    	
	    	String regUserCartTotalInfoList = null;
	    	if(null != cartRegiUserInfoList) {
	    		String singCartRowValueList[] = cartRegiUserInfoList.split("__");
		    	for(int i=0; i<singCartRowValueList.length; i++) {    			
		    		String singCartColumnValue[] = singCartRowValueList[i].split(",_,");
		    		String guSpaceColumnName = singCartColumnValue[3];
		    		String guSpaceColumnCount = singCartColumnValue[4];
		    		String guSpaceAmount = singCartColumnValue[2];
		    		double guSpaceAmountInDb = 0;
		    		if(null != guSpaceAmount) {
		    			guSpaceAmountInDb = Double.parseDouble(guSpaceAmount);
		    		}
		    		if(req.getParameter(registrySpaceColName).equals(guSpaceColumnName) && req.getParameter(registrySpaceColCount).equals(guSpaceColumnCount)) {		    			
		    		} else {
		    			regUserCartTotalInfoList = regUserCartTotalInfoList + "__" + singCartRowValueList[i];
		    			totalRegPrice = totalRegPrice + guSpaceAmountInDb;
		    			cartCount = cartCount + 1;
		    		}	    		
		    	}
		    	double roomAndCashFundPrice = totalRegPrice;		    	
		    	String totalRegPriceStr = String.format("%.2f", totalRegPrice);
		    	String roomAndCashFundPriceStr = String.format("%.2f", roomAndCashFundPrice);
		    	if(null != regUserCartTotalInfoList) {
		    		regUserCartTotalInfoList = regUserCartTotalInfoList.replaceFirst("null__", "");
		    	}
		    	regRoomAndCashFundSavingModel.setSelectedRoomFundsInfo(regUserCartTotalInfoList);
		    	regRoomAndCashFundSavingModel.setPaymentCartNo(cartCount);
		    	regRoomAndCashFundSavingModel.setTotalAmount(roomAndCashFundPriceStr);
		    	regRoomAndCashFundSavingModel.setContributedRoomFundAmount(totalRegPriceStr);
		    	regRoomAndCashFundSavingModel.setSpaceHandlingFee(null);
		    	registryRoomFundsPaymentInfoSavingDAO.merge(regRoomAndCashFundSavingModel);
	    	}
    	}    	
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }
    
    public int registryTotalConcAndFundsCombCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int regTotalFundsCombCount = 0;
    	int regCBContributedCount = registryConceptBoardsService.registryTotalConceptBoardsContributedCartCount(req, sn, registrantUserId);
    	int regCBIndividualCount = registryConceptBoardsService.registryTotalConceptBoardsIndividualCartCount(req, sn, registrantUserId);
    	int regFTContributedCount = registryFinishingTouchesService.registryTotalFinishingTouchesContributedCartCount(req, sn, registrantUserId);
    	int regFTIndividualCount = registryFinishingTouchesService.registryTotalFinishingTouchesIndividualCartCount(req, sn, registrantUserId);
    	regTotalFundsCombCount = regCBContributedCount + regCBIndividualCount + regFTContributedCount + regFTIndividualCount;
        return regTotalFundsCombCount;
    }
    
    public int registryShoppingCartTotalCount(HttpServletRequest req, HttpSession sn) {
    	int regTotalFundsCombCount = 0;
    	int regCBContributedCount = 0;
    	int regCBIndividualCount = 0;
    	int regFTContributedCount = 0;
    	int regFTIndividualCount = 0;
    	if(null != sn.getAttribute(regCBContributedCartCountInSn)) {
    		regCBContributedCount = (int) sn.getAttribute(regCBContributedCartCountInSn);
    	}
    	if(null != sn.getAttribute(regCBIndividualCountInSn)) {
    		regCBIndividualCount = (int) sn.getAttribute(regCBIndividualCountInSn);
    	}
    	if(null != sn.getAttribute(regFTContributedCartCountInSn)) {
    		regFTContributedCount = (int) sn.getAttribute(regFTContributedCartCountInSn);
    	} 
    	if(null != sn.getAttribute(regFTIndividualCartCountInSn)) {
    		regFTIndividualCount = (int) sn.getAttribute(regFTIndividualCartCountInSn);
    	} 
    	regTotalFundsCombCount = regCBContributedCount + regCBIndividualCount + regFTContributedCount + regFTIndividualCount;   	
    	return regTotalFundsCombCount;
    }
     
    @Override
    @Transactional
    public ModelAndView registrySpaceInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List regRoomAndCashFundInfoList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundPSNRowCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regRoomAndCashFundInfoList.isEmpty()) {    		
    		registrySpaceInfoModidfication((Long) sn.getAttribute(registrantUserIdInSn), req, sn);    		
    	} else {
    		String cartRegUserInfoList = req.getParameter(registrySpaceNameImg) + ",_," + req.getParameter(registrySpaceName) + ",_," + req.getParameter(regiFundAmoun) + ",_," + req.getParameter(registrySpaceColName) + ",_," + req.getParameter(registrySpaceColCount);
    		RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundSavingModel = new RegistryRoomFundsPaymentInfoSaving();
    		regRoomAndCashFundSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regRoomAndCashFundSavingModel.setSelectedRoomFundsInfo(cartRegUserInfoList);    		
    		regRoomAndCashFundSavingModel.setPaymentCartNo(1);
    		regRoomAndCashFundSavingModel.setTotalAmount(req.getParameter(regiFundAmoun));
    		regRoomAndCashFundSavingModel.setContributedRoomFundAmount(req.getParameter(regiFundAmoun));
    		registryRoomFundsPaymentInfoSavingDAO.save(regRoomAndCashFundSavingModel);
    	}
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }

    public String registrySpaceInfoModidfication(long registrantUserId, HttpServletRequest req, HttpSession sn) {
    	String regSpaceInfoRef = null;    	
    	RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundSavingModel = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundRowDataTakingFromDB(registrantUserId);
		String cartRegiUserInfoList = regRoomAndCashFundSavingModel.getSelectedRoomFundsInfo();		
		String status = null;
    	int cartCount = 0;
    	double totalRegPrice = 0;
    	String regUserCartTotalInfoList = null;
    	if(null != cartRegiUserInfoList) {
	    	String singCartRowValueList[] = cartRegiUserInfoList.split("__");    		
	    	for(int i=0; i<singCartRowValueList.length; i++) {    			
	    		String singCartColumnValue[] = singCartRowValueList[i].split(",_,");
	    		String guSpaceColumnName = singCartColumnValue[3];
	    		String guSpaceColumnCount = singCartColumnValue[4];
	    		if(req.getParameter(registrySpaceColName).equals(guSpaceColumnName) && req.getParameter(registrySpaceColCount).equals(guSpaceColumnCount)) {
	    			regUserCartTotalInfoList = regUserCartTotalInfoList + "__" + req.getParameter(registrySpaceNameImg) + ",_," + req.getParameter(registrySpaceName) + ",_," + req.getParameter(regiFundAmoun) + ",_," + req.getParameter(registrySpaceColName) + ",_," + req.getParameter(registrySpaceColCount);
	    			totalRegPrice = totalRegPrice + Double.parseDouble(req.getParameter(regiFundAmoun));
	    			status = regHaveStatus;
	    			cartCount = cartCount + 1;
	    		} else {
	    			regUserCartTotalInfoList = regUserCartTotalInfoList + "__" + singCartRowValueList[i];
	    			totalRegPrice = totalRegPrice + Double.parseDouble(singCartColumnValue[2]);
	    			cartCount = cartCount + 1;
	    		}    			
	    	}
	    	if((null == status)) {
	    		regUserCartTotalInfoList =  regUserCartTotalInfoList + "__" + req.getParameter(registrySpaceNameImg) + ",_," + req.getParameter(registrySpaceName) + ",_," + req.getParameter(regiFundAmoun) + ",_," + req.getParameter(registrySpaceColName) + ",_," + req.getParameter(registrySpaceColCount);
	    		totalRegPrice = totalRegPrice + Double.parseDouble(req.getParameter(regiFundAmoun));
				cartCount = cartCount + 1;
			}
	    	double roomAndCashFundPrice = totalRegPrice;
	    	String totalRegPriceStr = String.format("%.2f", totalRegPrice);
	    	String roomAndCashFundPriceStr = String.format("%.2f", roomAndCashFundPrice);
	    	regUserCartTotalInfoList = regUserCartTotalInfoList.replaceFirst("null__", "");    	
	    	regRoomAndCashFundSavingModel.setSelectedRoomFundsInfo(regUserCartTotalInfoList);
	    	regRoomAndCashFundSavingModel.setPaymentCartNo(cartCount);
	    	regRoomAndCashFundSavingModel.setTotalAmount(roomAndCashFundPriceStr);
	    	regRoomAndCashFundSavingModel.setContributedRoomFundAmount(totalRegPriceStr);
	    	registryRoomFundsPaymentInfoSavingDAO.merge(regRoomAndCashFundSavingModel);
    	} else {
    		String cartRegUserInfoList = req.getParameter(registrySpaceNameImg) + ",_," + req.getParameter(registrySpaceName) + ",_," + req.getParameter(regiFundAmoun) + ",_," + req.getParameter(registrySpaceColName) + ",_," + req.getParameter(registrySpaceColCount);
    		int totalCartCount = regRoomAndCashFundSavingModel.getPaymentCartNo();
    		double totalRegiAmountInt = Double.parseDouble(req.getParameter(regiFundAmoun));
    		String totalRegPriceStr = String.format("%.2f", totalRegiAmountInt);
    		int totalCartCountInt = totalCartCount + 1;
    		regRoomAndCashFundSavingModel.setSelectedRoomFundsInfo(cartRegUserInfoList);    		
    		regRoomAndCashFundSavingModel.setPaymentCartNo(totalCartCountInt);
    		regRoomAndCashFundSavingModel.setTotalAmount(totalRegPriceStr);
    		regRoomAndCashFundSavingModel.setContributedRoomFundAmount(req.getParameter(regiFundAmoun));
    		registryRoomFundsPaymentInfoSavingDAO.merge(regRoomAndCashFundSavingModel);
    	}    	
    	return regSpaceInfoRef;
    }

    @Override
    @Transactional
    public ModelAndView registrantTotalShoppingCartDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	registryConceptBoardsService.registrantCBContributedAddToCartInfoDisplay(req, sn);
    	registryConceptBoardsService.registrantCBIndividualAddToCartInfoDisplay(req, sn);
    	registryFinishingTouchesService.registrantFTContributedAddToCartInfoDisplay(req, sn);
    	registryFinishingTouchesService.registrantFTIndividualAddToCartInfoDisplay(req, sn);
    	double allConceptsAndFundsTotalPrice = registryAllConceptsAndFundsTotalPrice(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	int bothDesConAndFundsCount = registryShoppingCartTotalCount(req, sn);	    
	    if(bothDesConAndFundsCount > 0) {
		    mav = new ModelAndView(registrantAddCartInfoDisplay);
		    mav.addObject(totalRegFundAmount, allConceptsAndFundsTotalPrice);    	
		    sn.setAttribute(regiCartCountInSn, bothDesConAndFundsCount);
		    mav.addObject(regTotalCartItems, bothDesConAndFundsCount);		    
		    mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
	    } else {
	    	sn.setAttribute(regiCartCountInSn, bothDesConAndFundsCount);
	    	mav = new ModelAndView(redirectStatus + registryOverview);
	    }
    	return mav;
    }

    public double registryAllConceptsAndFundsTotalPrice(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	double allConceptsAndFundsTotalPrice = 0;
		double regCBContributedTotalPrice = registryConceptBoardsService.registrantCBContributedAddCartTotalPrice(req, sn);
		double regCBIndividualTotalPrice = registryConceptBoardsService.registrantCBIndividualAddCartTotalPrice(req, sn);
		double regFTContributedTotalPrice = registryFinishingTouchesService.registrantFTContributedAddCartTotalPrice(req, sn);
		double regFTIndividualTotalPrice = registryFinishingTouchesService.registrantFTIndividualAddCartTotalPrice(req, sn);
		double allShoppingCartTotalAmountDb = regCBContributedTotalPrice + regCBIndividualTotalPrice + regFTContributedTotalPrice + regFTIndividualTotalPrice;
	    String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmountDb);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
        return allConceptsAndFundsTotalPrice;
    }
    
//    @Override
//    @Transactional
//    public ModelAndView regCashFundContributeEditInfoRedirection(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String cashFundsName = null;
//	    String cashFundDBImage = null;
//    	List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCashFundsDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn));
//    	if (!registryCashFundsInfoList.isEmpty()) {
//    		RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));    		        
//            if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
//            	byte[] regCFUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
//            	cashFundDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regCFUploadedImg);
//            } 
//        	cashFundsName = registryCashFundsInfoModel.getCashFundName();
//    	}    	        
//    	mav = new ModelAndView(regCashFundContributeInfoDisplay);
//    	mav.addObject(regCashFundValue, req.getParameter(regCashFundValue));
//    	mav.addObject(cashFundUploadImg, cashFundDBImage);
//    	mav.addObject(cashFundName, cashFundsName);
//    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
//    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
//        return mav;
//    }

    @Override
    @Transactional
    public ModelAndView registrantFundsCheckOutContactRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	registrantBillingAddressFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registrantShippingInfoDisplayRedirection(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryShoppingCartTotalPriceWithTaxs(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));   	
    	mav = new ModelAndView(registrantFundsCheckOutContactRed);
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));    	
    	mav.addObject(billNameOnCard, req.getAttribute(billNameOnCard));
    	mav.addObject(billAddress1, req.getAttribute(billAddress1));
    	mav.addObject(billAddress2, req.getAttribute(billAddress2));
    	mav.addObject(billCity, req.getAttribute(billCity));
    	mav.addObject(billState, req.getAttribute(billState));
    	mav.addObject(billZip, req.getAttribute(billZip));
    	mav.addObject(billCountry, req.getAttribute(billCountry));
    	mav.addObject(guestPhNumber, req.getAttribute(guestPhNumber));
    	mav.addObject(shipFullName, req.getAttribute(shipFullName));
    	mav.addObject(shipAddress1, req.getAttribute(shipAddress1));
    	mav.addObject(shipAddress2, req.getAttribute(shipAddress2));
    	mav.addObject(shipCity, req.getAttribute(shipCity));
    	mav.addObject(shipState, req.getAttribute(shipState));
    	mav.addObject(shipZip, req.getAttribute(shipZip));
    	mav.addObject(shipPhNumber, req.getAttribute(shipPhNumber));
    	mav.addObject(checkBoxStatus, req.getAttribute(checkBoxStatus));
    	return mav;
    }

    public double registryShoppingCartTotalPriceWithTaxs(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	double regShoppingCartTotalPrice = 0;
		double regCBContributedTotalPrice = registryConceptBoardsService.registrantCBContributedAddCartTotalPrice(req, sn);
		double regCBIndividualTotalPrice = registryConceptBoardsService.registrantCBIndividualAddCartTotalPrice(req, sn);
		double regFTContributedTotalPrice = registryFinishingTouchesService.registrantFTContributedAddCartTotalPrice(req, sn);
		double regFTIndividualTotalPrice = registryFinishingTouchesService.registrantFTIndividualAddCartTotalPrice(req, sn);
		double cbIndividualShippingFee = conceptBoardIndividualShippingFee(req, sn);
		double cbIndividualStateTaxFee = conceptBoardIndividualStateTaxFee(req, sn);
		double ftIndividualShippingFee = finishingTouchesIndividualShippingFee(req, sn);
		double ftIndividualStateTaxFee = finishingTouchesIndividualStateTaxFee(req, sn);
		double totalConceptBoardsAmount = regCBContributedTotalPrice + regCBIndividualTotalPrice;
		double totalFinishingTouchesAmount = regFTContributedTotalPrice + regFTIndividualTotalPrice;
		double totalCBAndFTAmount = totalConceptBoardsAmount + totalFinishingTouchesAmount;		
		double totalIndividualShippingFee = cbIndividualShippingFee + ftIndividualShippingFee;		
		regShoppingCartTotalPrice = totalCBAndFTAmount + cbIndividualShippingFee + cbIndividualStateTaxFee + ftIndividualShippingFee + ftIndividualStateTaxFee;
		double regShoppingCartWCCTotalPrice = defaultCouponCodeFee(req, sn, totalCBAndFTAmount, regShoppingCartTotalPrice);
		String regShoppingCartTotalPriceSt = String.format("%,.2f", regShoppingCartWCCTotalPrice);
		String shoppingCartSubTotalAmountSt = String.format("%,.2f", totalCBAndFTAmount);
		String totalIndividualShippingFeeSt = String.format("%,.2f", totalIndividualShippingFee);
		String regShoppingCartTotalPriceInSt = String.format("%.2f", regShoppingCartWCCTotalPrice);
		String totalConceptBoardsAmountSt = String.format("%.2f", totalConceptBoardsAmount);
		String totalFinishingTouchesAmountSt = String.format("%.2f", totalFinishingTouchesAmount);
		totalIndividualStateTaxFee(req, sn);
    	sn.setAttribute(shoppingCartTotalAmountInSn, regShoppingCartTotalPriceSt);
    	sn.setAttribute(shoppingCartTotalAmountStInSn, regShoppingCartTotalPriceInSt);
    	sn.setAttribute(shoppingCartSubTotalAmountInSn, shoppingCartSubTotalAmountSt);
    	sn.setAttribute(shoppingCartShippingFeeInSn, totalIndividualShippingFeeSt);
    	sn.setAttribute(totalConceptBoardsAmountInSn, totalConceptBoardsAmountSt);
    	sn.setAttribute(totalFinishingTouchesAmountInSn, totalFinishingTouchesAmountSt);
    	return regShoppingCartTotalPrice;    	
    }

    public double defaultCouponCodeFee(HttpServletRequest req, HttpSession sn, double dsnAndFinTouTotaldbAmount, double regShoppingCartTotalPrice) {
    	double defaultCouponPrice = 0;
    	if(regShoppingCartTotalPrice > 0) {
    		double defaultCouponPriceDb = (dsnAndFinTouTotaldbAmount/100)*5;
    		String defaultCouponPriceSt = String.format("%,.2f", defaultCouponPriceDb);
    		sn.setAttribute(defaultCouponPriceInSn, defaultCouponPriceSt);
    		defaultCouponPrice = regShoppingCartTotalPrice - defaultCouponPriceDb;
    	}
    	return defaultCouponPrice;
    }

    public double conceptBoardIndividualShippingFee(HttpServletRequest req, HttpSession sn) {
    	double cbIndividualShippingFee = 0;
//    	double regCBIndividualTotalPrice = registryConceptBoardsService.registrantCBIndividualAddCartTotalPrice(req, sn);
//    	if(regCBIndividualTotalPrice > 0) {
//    		cbIndividualShippingFee = (regCBIndividualTotalPrice/100)*10;
//    	}
    	return cbIndividualShippingFee;
    }

    public double conceptBoardIndividualStateTaxFee(HttpServletRequest req, HttpSession sn) {
    	double cbIndividualStateTaxFee = 0;
//    	double regCBIndividualTotalPrice = registryConceptBoardsService.registrantCBIndividualAddCartTotalPrice(req, sn);    	
//    	if(regCBIndividualTotalPrice > 0) {
//    		cbIndividualStateTaxFee = (regCBIndividualTotalPrice/100)*8;
//    	}
    	return cbIndividualStateTaxFee;
    }

    public double finishingTouchesIndividualShippingFee(HttpServletRequest req, HttpSession sn) {
    	double ftIndividualShippingFee = 0;
//    	double regFTIndividualTotalPrice = registryFinishingTouchesService.registrantFTIndividualAddCartTotalPrice(req, sn);
//    	if(regFTIndividualTotalPrice > 0) {
//    		ftIndividualShippingFee = (regFTIndividualTotalPrice/100)*10;
//    	}
    	return ftIndividualShippingFee;
    }

    public double finishingTouchesIndividualStateTaxFee(HttpServletRequest req, HttpSession sn) {
    	double ftIndividualStateTaxFee = 0;
//    	double regFTIndividualTotalPrice = registryFinishingTouchesService.registrantFTIndividualAddCartTotalPrice(req, sn);    	
//    	if(regFTIndividualTotalPrice > 0) {
//    		ftIndividualStateTaxFee = (regFTIndividualTotalPrice/100)*8;
//    	}
    	return ftIndividualStateTaxFee;
    }

    public double totalIndividualStateTaxFee(HttpServletRequest req, HttpSession sn) {
    	double totalIndividualStateTaxFee = 0;
    	String cbIndividualStateTaxFeeSt = "0.00";
    	double regCBIndividualTotalPrice = conceptBoardIndividualStateTaxFee(req, sn);
    	double regFTIndividualTotalPrice = finishingTouchesIndividualStateTaxFee(req, sn);
    	double regTotalIndividualTotalPrice = regCBIndividualTotalPrice + regFTIndividualTotalPrice;
    	if(regTotalIndividualTotalPrice > 0) {
    		cbIndividualStateTaxFeeSt = String.format("%.2f", regTotalIndividualTotalPrice);
    	}
    	sn.setAttribute(shoppingCartStateTaxFeeInSn, cbIndividualStateTaxFeeSt);
    	return totalIndividualStateTaxFee;
    }
        
    public String registrantBillingAddressFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regBillAddrRef = null;
    	String billNameOnCard1 = null;
    	String billAddress11 = null;
    	String billAddress21 = null;
    	String billCity1 = null;
    	String billState1 = null;
    	String billZip1 = null;
    	String billCountry1 = null;
    	String guestPhNumber1 = null;
    	List regPaymentInfoList = registrantPaymentInfoSavingDAO.registrantUserPaymentRowCheckingInDB(registrantUserId);
    	if (!regPaymentInfoList.isEmpty()) {   		
    		RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);    	
    		billNameOnCard1 = regPaymentInfoSavingModel.getBillFullName();
    		billAddress11 = regPaymentInfoSavingModel.getBillAddress1();
    		billAddress21 = regPaymentInfoSavingModel.getBillAddress2();
    		billCity1 = regPaymentInfoSavingModel.getBillCity();
    		billState1 = regPaymentInfoSavingModel.getBillState();
    		billZip1 = regPaymentInfoSavingModel.getBillZip();
    		billCountry1 = regPaymentInfoSavingModel.getBillCountry();
    		guestPhNumber1 = regPaymentInfoSavingModel.getBillPhNumber();    		
    	}
    	req.setAttribute(billNameOnCard, billNameOnCard1);
    	req.setAttribute(billAddress1, billAddress11);
    	req.setAttribute(billAddress2, billAddress21);
    	req.setAttribute(billCity, billCity1);
    	req.setAttribute(billState, billState1);
    	req.setAttribute(billZip, billZip1);
    	req.setAttribute(billCountry, billCountry1);
    	req.setAttribute(guestPhNumber, guestPhNumber1);    	
    	return regBillAddrRef;
    }

    public String registrantShippingInfoDisplayRedirection(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regShipAddrRef = null;
    	String shipFullName1 = null;
    	String shipAddress01 = null;
    	String shipAddress02 = null;
    	String shipCity1 = null;
    	String shipState1 = null;
    	String shipZip1 = null;
    	String shipPhNumber1 = null;
    	String checkBoxStatus1 = null;
    	List<RegistrantShippingInfoSaving> regiShippingInfoSavingList = registrantShippingInfoSavingDAO.selectedShippingAddressRowIdVerification(registrantUserId);
    	if (!regiShippingInfoSavingList.isEmpty()) {
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(registrantUserId);
    		shipFullName1 = regiShippingInfoSavingModel.getRegistrantFullNname();
    		shipAddress01 = regiShippingInfoSavingModel.getShippingAddress();
    		shipAddress02 = regiShippingInfoSavingModel.getApartment();
    		shipCity1 = regiShippingInfoSavingModel.getCity();
    		shipState1 = regiShippingInfoSavingModel.getState();
    		shipZip1 = regiShippingInfoSavingModel.getZip();
    		shipPhNumber1 = regiShippingInfoSavingModel.getPhoneNumber();
    		checkBoxStatus1 = regiShippingInfoSavingModel.getShippingStatus();
    	} 
    	req.setAttribute(shipFullName, shipFullName1);
    	req.setAttribute(shipAddress1, shipAddress01);
    	req.setAttribute(shipAddress2, shipAddress02);
    	req.setAttribute(shipCity, shipCity1);
    	req.setAttribute(shipState, shipState1);
    	req.setAttribute(shipZip, shipZip1);
    	req.setAttribute(shipPhNumber, shipPhNumber1);
    	req.setAttribute(checkBoxStatus, checkBoxStatus1);
    	return regShipAddrRef;
    }

    @Override
    @Transactional
    public ModelAndView registrantBillingAndShippingInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();    	
    	registrantBillingInfoSavingInDBTable(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(billNameOnCard), req.getParameter(billAddress1), req.getParameter(billAddress2), req.getParameter(billCity), req.getParameter(billState), req.getParameter(billZip), req.getParameter(billCountry), req.getParameter(guestPhNumber), currentDate);
    	registrantShippingInfoSavingInDBTable(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(shipFullName), req.getParameter(shipAddress1), req.getParameter(shipAddress2), req.getParameter(shipCity), req.getParameter(shipState), req.getParameter(shipZip), req.getParameter(shipPhNumber), currentDate);
    	allPaymentsUpdatesInRegistryPaymentTable(req, sn);
    	mav = new ModelAndView(registrantReviewAndPlaceOrderRed);
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(billNameOnCard, req.getParameter(billNameOnCard));
    	mav.addObject(billAddress1, req.getParameter(billAddress1));
    	mav.addObject(billAddress2, req.getParameter(billAddress2));
    	mav.addObject(billCity, req.getParameter(billCity));
    	mav.addObject(billState, req.getParameter(billState));
    	mav.addObject(billZip, req.getParameter(billZip));
    	mav.addObject(billCountry, req.getParameter(billCountry));
    	mav.addObject(guestEmail, req.getParameter(guestEmail));
    	mav.addObject(guestPhNumber, req.getParameter(guestPhNumber));    	
    	mav.addObject(shipFullName, req.getParameter(shipFullName));
    	mav.addObject(shipAddress1, req.getParameter(shipAddress1));
    	mav.addObject(shipAddress2, req.getParameter(shipAddress2));
    	mav.addObject(shipCity, req.getParameter(shipCity));
    	mav.addObject(shipState, req.getParameter(shipState));
    	mav.addObject(shipZip, req.getParameter(shipZip));
    	mav.addObject(shipPhNumber, req.getParameter(shipPhNumber));
    	return mav;
    }

    public String registrantBillingInfoSavingInDBTable(HttpServletRequest req, HttpSession sn, long registrantUserId, String billNameOnCard, String billAddress1, String billAddress2, String billCity, String billState, String billZip, String billCountry, String guestPhNumber, Timestamp currentDate) {
    	String regBillingInfoSaving = null;
    	List<RegistrantPaymentInfoSaving> regPaymentInfoList = registrantPaymentInfoSavingDAO.registrantUserPaymentRowCheckingInDB(registrantUserId);
    	if (!regPaymentInfoList.isEmpty()) {
    		RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);       	
	    	regPaymentInfoSavingModel.setBillFullName(billNameOnCard);
	    	regPaymentInfoSavingModel.setBillAddress1(billAddress1);
	    	regPaymentInfoSavingModel.setBillAddress2(billAddress2);
	    	regPaymentInfoSavingModel.setBillCity(billCity);
	    	regPaymentInfoSavingModel.setBillState(billState);
	    	regPaymentInfoSavingModel.setBillZip(billZip);
	    	regPaymentInfoSavingModel.setBillCountry(billCountry);
	    	regPaymentInfoSavingModel.setBillPhNumber(guestPhNumber);
	    	regPaymentInfoSavingModel.setUpdatedDate(currentDate);
	    	registrantPaymentInfoSavingDAO.merge(regPaymentInfoSavingModel);
    	} else {
    		RegistrantPaymentInfoSaving regPaymentInfoSavingModel = new RegistrantPaymentInfoSaving();
    		regPaymentInfoSavingModel.setRegistrantUserId(registrantUserId);
        	regPaymentInfoSavingModel.setBillFullName(billNameOnCard);
        	regPaymentInfoSavingModel.setBillAddress1(billAddress1);
        	regPaymentInfoSavingModel.setBillAddress2(billAddress2);
        	regPaymentInfoSavingModel.setBillCity(billCity);
        	regPaymentInfoSavingModel.setBillState(billState);
        	regPaymentInfoSavingModel.setBillZip(billZip);
        	regPaymentInfoSavingModel.setBillCountry(billCountry);
        	regPaymentInfoSavingModel.setBillPhNumber(guestPhNumber);
        	regPaymentInfoSavingModel.setCreatedDate(currentDate);
        	registrantPaymentInfoSavingDAO.save(regPaymentInfoSavingModel);
    	}    	
 	   	return regBillingInfoSaving;
    }

    public String registrantShippingInfoSavingInDBTable(HttpServletRequest req, HttpSession sn, long registrantUserId, String shipFullName, String shipAddress1, String shipAddress2, String shipCity, String shipState, String shipZip, String shipPhNumber, Timestamp currentDate) {
    	String regShippingInfoSaving = null;
    	String checkBoxStatus = "on";
    	List<RegistrantShippingInfoSaving> regiShippingInfoSavingList = registrantShippingInfoSavingDAO.selectedShippingAddressRowIdVerification(registrantUserId);
    	if (!regiShippingInfoSavingList.isEmpty()) {
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(registrantUserId);    		
    		regiShippingInfoSavingModel.setRegistrantFullNname(shipFullName);
    		regiShippingInfoSavingModel.setShippingAddress(shipAddress1);
    		regiShippingInfoSavingModel.setApartment(shipAddress2);
    		regiShippingInfoSavingModel.setCity(shipCity);
    		regiShippingInfoSavingModel.setState(shipState);
    		regiShippingInfoSavingModel.setZip(shipZip);
    		regiShippingInfoSavingModel.setPhoneNumber(shipPhNumber);
    		regiShippingInfoSavingModel.setShippingStatus(checkBoxStatus);
    		regiShippingInfoSavingModel.setUpdatedDate(currentDate);
    		registrantShippingInfoSavingDAO.merge(regiShippingInfoSavingModel);
    	} else {
    		RegistrantShippingInfoSaving regShippingInfoSavingModel = new RegistrantShippingInfoSaving();
    		regShippingInfoSavingModel.setRegistrantUserId(registrantUserId);
    		regShippingInfoSavingModel.setRegistrantFullNname(shipFullName);
    		regShippingInfoSavingModel.setShippingAddress(shipAddress1);
    		regShippingInfoSavingModel.setApartment(shipAddress2);
    		regShippingInfoSavingModel.setCity(shipCity);
    		regShippingInfoSavingModel.setState(shipState);
    		regShippingInfoSavingModel.setZip(shipZip);
    		regShippingInfoSavingModel.setPhoneNumber(shipPhNumber);
    		regShippingInfoSavingModel.setShippingStatus(checkBoxStatus);
    		regShippingInfoSavingModel.setCreatedDate(currentDate);
    		registrantShippingInfoSavingDAO.save(regShippingInfoSavingModel);
    	}    	
 	   	return regShippingInfoSaving;
    }
    
    public String allPaymentsUpdatesInRegistryPaymentTable(HttpServletRequest req, HttpSession sn) {
    	String allPaymentsUpdatesRef = null;
    	RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	regPaymentInfoSavingModel.setDefaultCouponPrice((String) sn.getAttribute(defaultCouponPriceInSn));
    	regPaymentInfoSavingModel.setTaxFee((String) sn.getAttribute(shoppingCartStateTaxFeeInSn));
    	regPaymentInfoSavingModel.setShippingFee((String) sn.getAttribute(shoppingCartShippingFeeInSn));
    	regPaymentInfoSavingModel.setConceptBoardsPrice((String) sn.getAttribute(totalConceptBoardsAmountInSn));
    	regPaymentInfoSavingModel.setFinishingTouchesPrice((String) sn.getAttribute(totalFinishingTouchesAmountInSn));
		registrantPaymentInfoSavingDAO.merge(regPaymentInfoSavingModel);
//		registrantRoomFundsInfoUpdateInDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
//    	registrantCashFundsInfoUpdateInDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	return allPaymentsUpdatesRef;
    }

//    public String registrantRoomFundsInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
//    	String roomFundsPrice = null;
//    	RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);
//    	List regiRoomAndCashFundInfoList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundPSNRowCheckingInDB(registrantUserId);
//    	if (!regiRoomAndCashFundInfoList.isEmpty()) {    		
//    		RegistryRoomFundsPaymentInfoSaving regiRoomAndCashFundSavingModel = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundRowDataTakingFromDB(registrantUserId);    		
//    		regPaymentInfoSavingModel.setRoomFundsPrice(regiRoomAndCashFundSavingModel.getTotalAmount());
//    		registrantPaymentInfoSavingDAO.merge(regPaymentInfoSavingModel);
//    	}
//    	return roomFundsPrice;
//    }

//    public String registrantCashFundsInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
//    	String cashFundsPrice = null;
//    	RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);
//    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsPaymentInfoCheckInDB(registrantUserId);
//    	if (!regCashFundAddCartRowList.isEmpty()) {
//    		double cashFundsContPriceDb = 0;
//    		for (RegistryCashFundsPaymentInfoSaving regCashFundsPaymentInfoModel : regCashFundAddCartRowList) {
//    			double cashFundsContPrice = Double.parseDouble(regCashFundsPaymentInfoModel.getContributedCashFundPrice());
//    			cashFundsContPriceDb = cashFundsContPriceDb + cashFundsContPrice;
//    		}
//    		String contCashFundPrice = String.format("%.2f", cashFundsContPriceDb);
//    		regPaymentInfoSavingModel.setCashFundsPrice(contCashFundPrice);
//    		registrantPaymentInfoSavingDAO.merge(regPaymentInfoSavingModel);
//    	}
//    	return cashFundsPrice;
//    }

    @Override
    @Transactional
    public ModelAndView registrantPaymentInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView(registrantPaymentInfoRedi);
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }

	@Override
    @Transactional
    public ModelAndView registrantCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String nameOnCard1 = req.getParameter(nameOnCard);   	  	  	
        long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
    	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear) ;
    	Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
    	String amount = (String) sn.getAttribute(shoppingCartTotalAmountStInSn);
    	RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String fullName = regPaymentInfoSavingModel.getBillFullName();    	
    	String cityName = regPaymentInfoSavingModel.getBillCity();
    	String stateName = regPaymentInfoSavingModel.getBillState();
    	String zipCode = regPaymentInfoSavingModel.getBillZip();    	
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String emailAddress = regInfoSavingModel.getRegUserName();
    	String fullAddress = regPaymentInfoSavingModel.getBillAddress1() + " " + regPaymentInfoSavingModel.getBillAddress2();      
        String paymentReturnTypeReff = registryPaymentGatewayService.totalPaymentInfoSendToAuthorizeNetGateway(req, sn, amount, cardNumber, expirationDate, cardCode, fullName, emailAddress, fullAddress, cityName, stateName, zipCode);
        long transactionNumber = (Long) sn.getAttribute(transactionNumberInSn);
        String accountType = (String) sn.getAttribute(accountTypeInSn);
        String authorizationCode = (String) sn.getAttribute(authorizationCodeInSn);               
    	if((tranApprovedStatus).equals(paymentReturnTypeReff)) {
    		Timestamp currentDate = currentDate();
    		registrantCartPaymentEmailSendingToTheUser(req, sn, emailAddress);
    		registrantUserAllPaymentsInfoUpdatedInDBTable(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cardNumber, accountType, expirationDate, cardCode, paymentReturnTypeReff, nameOnCard1, authorizationCode, transactionNumber, amount, currentDate);
    		mav = new ModelAndView(registrantPaymentSuccessRed);
    		mav.addObject(paymentOrderNumber, transactionNumber);
    		sn.setAttribute(totalPaybleAmountForEmailInSn, amount);
    	} else {
    		mav = new ModelAndView(registrantPaymentInfoRedi);    	
    		mav.addObject(totalFundsAmountInSn, sn.getAttribute(totalFundsAmountInSn));    		
    		sn.setAttribute(totalPayableAmountSt, amount);    		
		    mav.addObject(payCardNumber, req.getParameter(payCardNumber));
		    mav.addObject(payExpMonth, req.getParameter(payExpMonth));
		    mav.addObject(payExpYear, req.getParameter(payExpYear));
		    mav.addObject(nameOnCard, req.getParameter(nameOnCard));
		    mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
		    mav.addObject(paymentValStatus, "Payment Fail");
		    mav.addObject(paymentReturnStatus, paymentReturnTypeReff);
		    mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	}    	
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        return mav;
    }
	
    public String registrantUserAllPaymentsInfoUpdatedInDBTable(HttpServletRequest req, HttpSession sn, long registrantUserId, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate) {
    	String regAllPaymentsReff = null;
    	registrantUserPaymentsInfoUpdated(req, sn, registrantUserId, cardNumber, accountType, expirationDate, cardCode, returnType, nameOnCard1, authorizationCode, transactionNumber, amount, currentDate);
		registryConceptBoardsService.registrantConceptBoardsPaymentInfoUpdateInDB(sn, req, registrantUserId, returnType, (Long) sn.getAttribute(regiPaymentInfoSavingIdInSn));
		registryFinishingTouchesService.registrantFinishingTouchesPaymentInfoUpdateInDB(sn, req, registrantUserId, returnType, (Long) sn.getAttribute(regiPaymentInfoSavingIdInSn));
    	registryAllTablesDataUploadAfterPayment(req, sn, registrantUserId);
    	registrantPaymentValuesGoingToNull(req, sn);
    	return regAllPaymentsReff;
    }

    public String registrantUserPaymentsInfoUpdated(HttpServletRequest req, HttpSession sn, long registrantUserId, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate) {
    	String regPaymentsInfoReff = null;
		RegistrantPaymentInfoSaving regiPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);
		String accCardNumber = Long.toString(cardNumber);
		regiPaymentInfoSavingModel.setPayCardNumber(accCardNumber);
		regiPaymentInfoSavingModel.setAccountType(accountType);
		regiPaymentInfoSavingModel.setPayExpDate(expirationDate);
		String cvvNum = Integer.toString(cardCode);
		regiPaymentInfoSavingModel.setPayCvvNumber(cvvNum);
		regiPaymentInfoSavingModel.setCheckoutPaymentStatus(returnType);
		regiPaymentInfoSavingModel.setNameOnCard(nameOnCard1);
		regiPaymentInfoSavingModel.setAuthorizationCode(authorizationCode);
		regiPaymentInfoSavingModel.setTransactionNumber(transactionNumber);
		regiPaymentInfoSavingModel.setTotalPableAmount(amount);        	
		regiPaymentInfoSavingModel.setUpdatedDate(currentDate);		
		String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		regiPaymentInfoSavingModel.setCreatedDateInSt(todayDate);        	
		registrantPaymentInfoSavingDAO.merge(regiPaymentInfoSavingModel);
		sn.setAttribute(regiPaymentInfoSavingIdInSn, regiPaymentInfoSavingModel.getRegistrantPaymentInfoSavingId());
		sn.setAttribute(shoppingCartSubTotalAmountInSn, null);	    
	    return regPaymentsInfoReff;
    }
    
    public String registrantPaymentValuesGoingToNull(HttpServletRequest req, HttpSession sn) {
    	String paymentValuesGoingToNull = null;
    	sn.setAttribute(defaultCouponPriceInSn, null);
    	sn.setAttribute(shoppingCartStateTaxFeeInSn, null);
    	sn.setAttribute(shoppingCartShippingFeeInSn, null);
    	sn.setAttribute(shoppingCartTotalAmountInSn, null);
    	sn.setAttribute(regiCartCountInSn, null);
    	sn.setAttribute(regTotalCartItems, null);
    	sn.setAttribute(shoppingCartTotalAmountStInSn, null);
    	sn.setAttribute(registryRoomFundsCountInSn, null);
    	sn.setAttribute(registryCashFundsCountInSn, null);
    	sn.setAttribute(registryCustomFundsCountInSn, null);
    	sn.setAttribute(regCBContributedCartCountInSn, null);
    	sn.setAttribute(regFTContributedCartCountInSn, null);
        sn.setAttribute(regFTIndividualCartCountInSn, null);
    	sn.setAttribute(regCBIndividualCountInSn, null);
    	sn.setAttribute(transactionNumberInSn, null);
        sn.setAttribute(accountTypeInSn, null);
        sn.setAttribute(authorizationCodeInSn, null);
    	return paymentValuesGoingToNull;    	
    }

    public String registrantCartPaymentEmailSendingToTheUser(HttpServletRequest req, HttpSession sn, String regUserEmail) {
    	String regCartPaymentReff = null;
	  	String[] emailList = {regUserEmail};
        String fCapName = (String) sn.getAttribute(regiFirstNameInSn);
	  	String subject = "Thank You For Your Order!";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>A Gift From You To You!</p>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Isn't it fun to give yourself a little something every once in a while!!</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Make sure you log in to your registry account to view your purchase details under the 'My Account' and 'My Orders' tabs.</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.25em sans-serif;'>Login to your account here: <a href='https://www.nookandcove.com/registryLogin'>My Registry</a></p>"				
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>You will be able to select when your product ships as well as view and track all details from your account.</p>"								
				+ "<p style='margin-top: 25px; margin-bottom: 15px; font: 1.05em/1.5em sans-serif;'>If you have any questions regarding this order, please email us at hello@nookandcove.com and we will get back to you as soon as possible.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin shop tracking link mail failed " + ex);
	  	}       
	  	return regCartPaymentReff;
	}   
        
    public String registryAllTablesDataUploadAfterPayment(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regAllTablesDataUploadReff = null;
    	registryConceptBoardsService.registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryConceptBoardsService.registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesService.registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesService.registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	return regAllTablesDataUploadReff;
    }
    
    @Override
    @Transactional
    public ModelAndView registrantSessionTimeOutRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(registryLoginRedirection);
    	mav.addObject("logOutMessage", "Your session has expired. Please sign in again.");
        sn.setAttribute(registrantUserIdInSn, null);
        sn.setAttribute(userIdInSn, null);
        sn.setAttribute(regFirstNamesInSn, null);
        sn.setAttribute(userIdInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView aboutUsForGuestRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(aboutUsForGuestRedirection);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryTermsRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(registrantUserIdInSn)) {
    		mav = new ModelAndView("registryTermsRedAL");
    		mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	} else{
        	mav = new ModelAndView("registryTermsRedBL");
        } 
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryPrivacyPolicyRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(registrantUserIdInSn)) {
    		mav = new ModelAndView("registryPrivacyPolicyRedAL");
    		mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	} else{
        	mav = new ModelAndView("registryPrivacyPolicyRedBL");
        } 
        return mav;
    }

    public double registrantShoppingCartTotalAmountDisplay(HttpSession sn, HttpServletRequest req) {
    	double regShoppingCartTotalAmount = 0;
    	double cbContributedAddCartPrice = 0;
    	if(null != sn.getAttribute(cbContributedAddCartPriceInSn)) {
    		cbContributedAddCartPrice = (Double) sn.getAttribute(cbContributedAddCartPriceInSn);
    	}
    	double cbIndividualAddCartPrice = 0;
    	if(null != sn.getAttribute(cbIndividualAddCartPriceInSn)) {
    		cbIndividualAddCartPrice = (Double) sn.getAttribute(cbIndividualAddCartPriceInSn);
    	}
    	double ftContributedAddCartPrice = 0;
    	if(null != sn.getAttribute(ftContributedAddCartPriceInSn)) {
    		ftContributedAddCartPrice = (Double) sn.getAttribute(ftContributedAddCartPriceInSn);
    	}
    	double ftIndividualAddCartPrice = 0;
    	if(null != sn.getAttribute(ftIndividualAddCartPriceInSn)) {
    		ftIndividualAddCartPrice = (Double) sn.getAttribute(ftIndividualAddCartPriceInSn);
    	}
    	regShoppingCartTotalAmount = cbContributedAddCartPrice + cbIndividualAddCartPrice + ftContributedAddCartPrice + ftIndividualAddCartPrice;
    	return regShoppingCartTotalAmount;
    }

    @Override
    @Transactional
    public ModelAndView regFullRoomPaymentInfoDeleteFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	double fullRoomPrice = 185;
    	long registPaymentInfoSavingId = Long.parseLong(req.getParameter(regiPaymentInfoSavingId));
    	String regFullRoomDesignCount = req.getParameter("regiFullRoomDesignCount");
    	int regFullRoomDesnCount = Integer.parseInt(regFullRoomDesignCount);
    	RegistryRoomFundsPaymentInfoSaving regRoomCashSavingModel = registryRoomFundsPaymentInfoSavingDAO.registryRoomAndCashFundDeleteFromCartInDB((Long) sn.getAttribute(registrantUserIdInSn), registPaymentInfoSavingId);
    	int dbCartNo = regRoomCashSavingModel.getPaymentCartNo();
    	String dbAllTotalAmount = regRoomCashSavingModel.getTotalAmount();    	
    	double dbAllTotalAmountInDb = 0;
    	if(null != dbAllTotalAmount) {
    		dbAllTotalAmountInDb = Double.parseDouble(dbAllTotalAmount);
    	}
    	double dbFullRoomTotalAmount = fullRoomPrice * regFullRoomDesnCount;    	
    	int remaingCatNo = dbCartNo - regFullRoomDesnCount;
    	double remAllTotalAmountInDb = dbAllTotalAmountInDb - dbFullRoomTotalAmount;
    	String remAllTotalAmount = String.format("%.2f", remAllTotalAmountInDb);    	
    	if(remaingCatNo > 0) {
    		regRoomCashSavingModel.setPaymentCartNo(remaingCatNo);
    		regRoomCashSavingModel.setTotalAmount(remAllTotalAmount);
    		registryRoomFundsPaymentInfoSavingDAO.merge(regRoomCashSavingModel);
    	} else {
    		registryRoomFundsPaymentInfoSavingDAO.delete(regRoomCashSavingModel);
    	}
    	mav = new ModelAndView(redirectStatus + redirectRegSpaceAllCartInfoDisplay);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regAccDsnPaymentInfoDeleteFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	double accDesignPrice = 85;
    	long registPaymentInfoSavingId = Long.parseLong(req.getParameter(regiPaymentInfoSavingId));
    	String regAccDesignCount = req.getParameter("regiAccDesignCount");
    	int regiAccDesignCount = Integer.parseInt(regAccDesignCount);
    	RegistryRoomFundsPaymentInfoSaving regRoomCashSavingModel = registryRoomFundsPaymentInfoSavingDAO.registryRoomAndCashFundDeleteFromCartInDB((Long) sn.getAttribute(registrantUserIdInSn), registPaymentInfoSavingId);
    	int dbCartNo = regRoomCashSavingModel.getPaymentCartNo();
    	String dbAllTotalAmount = regRoomCashSavingModel.getTotalAmount();    	
    	double dbAllTotalAmountInDb = 0;
    	if(null != dbAllTotalAmount) {
    		dbAllTotalAmountInDb = Double.parseDouble(dbAllTotalAmount);
    	}
    	double dbAccDesignTotalAmount = accDesignPrice * regiAccDesignCount;    	
    	int remaingCatNo = dbCartNo - regiAccDesignCount;
    	double remAllTotalAmountInDb = dbAllTotalAmountInDb - dbAccDesignTotalAmount;
    	String remAllTotalAmount = String.format("%.2f", remAllTotalAmountInDb);    	
    	if(remaingCatNo > 0) {
    		regRoomCashSavingModel.setPaymentCartNo(remaingCatNo);
    		regRoomCashSavingModel.setTotalAmount(remAllTotalAmount);
    		registryRoomFundsPaymentInfoSavingDAO.merge(regRoomCashSavingModel);
    	} else {
    		registryRoomFundsPaymentInfoSavingDAO.delete(regRoomCashSavingModel);
    	}
    	mav = new ModelAndView(redirectStatus + redirectRegSpaceAllCartInfoDisplay);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regCashFundPaymentInfoDeleteFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long registPaymentInfoSavingId = Long.parseLong(req.getParameter(regiPaymentInfoSavingId));
    	String regCashFundValue = req.getParameter("regiCashFundValue");
    	double regCashFundAmountInDb = 0;
    	if(null != regCashFundValue) {
    		regCashFundAmountInDb = Double.parseDouble(regCashFundValue);
    	}
    	RegistryRoomFundsPaymentInfoSaving regRoomCashSavingModel = registryRoomFundsPaymentInfoSavingDAO.registryRoomAndCashFundDeleteFromCartInDB((Long) sn.getAttribute(registrantUserIdInSn), registPaymentInfoSavingId);
    	int dbCartNo = regRoomCashSavingModel.getPaymentCartNo();
    	String dbAllTotalAmount = regRoomCashSavingModel.getTotalAmount();
    	String dbTotalSpaceAmount = regRoomCashSavingModel.getContributedRoomFundAmount();
    	double dbTotalSpaceAmountInDb = 0;
    	if(null != dbTotalSpaceAmount) {
    		dbTotalSpaceAmountInDb = Double.parseDouble(dbTotalSpaceAmount);
    	}
    	double dbAllTotalAmountInDb = 0;
    	if(null != dbAllTotalAmount) {
    		dbAllTotalAmountInDb = Double.parseDouble(dbAllTotalAmount);
    	}
    	double remTotalSpaceAmount = dbTotalSpaceAmountInDb - regCashFundAmountInDb;
    	String remTotSpaceAmount = String.format("%.2f", remTotalSpaceAmount);
    	int remaingCatNo = dbCartNo - 1;
    	double remAllTotalAmountInDb = dbAllTotalAmountInDb - regCashFundAmountInDb;
    	String remAllTotalAmount = String.format("%.2f", remAllTotalAmountInDb);    	
    	if(remaingCatNo > 0) {
    		regRoomCashSavingModel.setPaymentCartNo(remaingCatNo);
    		regRoomCashSavingModel.setTotalAmount(remAllTotalAmount);
    		regRoomCashSavingModel.setContributedRoomFundAmount(remTotSpaceAmount);
    		registryRoomFundsPaymentInfoSavingDAO.merge(regRoomCashSavingModel);
    	} else {
    		registryRoomFundsPaymentInfoSavingDAO.delete(regRoomCashSavingModel);
    	}
    	mav = new ModelAndView(redirectStatus + redirectRegSpaceAllCartInfoDisplay);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantGiftCardPaymentInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav; 	   	
    	String giftAmount = null;
 	    String gcCuponCode = null; 	    
 	    String bothAmountsTotal = null;
 	    String giftCdStatus = "Wrong Code";
 	    List<RegistrantCustomGiftCardCodeSaving> regCustomGiftCardCodeList =  registrantCustomGiftCardCodeSavingDAO.registrantGiftCardCodeValuesChecking((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(regGiftCardCouponCode));
	   	if (!regCustomGiftCardCodeList.isEmpty()) {
	   		RegistrantCustomGiftCardCodeSaving regCustomGiftCardCodeSavingModel =  registrantCustomGiftCardCodeSavingDAO.registrantGiftCardCodeValuesTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(regGiftCardCouponCode));
	   		double regGiftAmount = regCustomGiftCardCodeSavingModel.getRemainingCredit();
	   		gcCuponCode = regCustomGiftCardCodeSavingModel.getGiftCardCode();   		
	   		double totalSnPriceDb = Double.parseDouble((String) sn.getAttribute(shoppingCartTotalAmountStInSn));
	   		double totalBothAmountsDb = totalSnPriceDb - regGiftAmount;
	   		if(regGiftAmount < 1) {
		    	mav = new ModelAndView(registrantPaymentInfoRedi);
		    	mav.addObject(giftCardStatus, giftCdStatus);
	   		} else {
		   		if(totalBothAmountsDb > 0) {
			   		bothAmountsTotal = String.format("%.2f", totalBothAmountsDb);
			   		giftAmount = String.format("%.2f", regGiftAmount);
			   		sn.setAttribute(totalRGPaybleAmountInSn, bothAmountsTotal);
			   		mav = new ModelAndView(registrantGiftCardPaymentInfoRedi);	   			
			   	} else {
			   		double zeroAmount = 0;
		   			bothAmountsTotal = String.format("%.2f", zeroAmount);
		   			giftAmount = String.format("%.2f", totalSnPriceDb);
		   			mav = new ModelAndView(registrantGiftCardZeroPaymentInfoRedi);
			   	}
	   		}	   		
	   		mav.addObject(giftCardPrice, giftAmount);
	   		String allShoppingCartTotalAmountSt = String.format("%,.2f", totalSnPriceDb);
	    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
	   		mav.addObject(shoppingCartTotalAmountStInSn, sn.getAttribute(shoppingCartTotalAmountStInSn));
	        mav.addObject(totalPaybleAmount, bothAmountsTotal);        
	        mav.addObject(regGiftCardCouponCode, gcCuponCode);
	   	} else {
	   		mav = new ModelAndView(registrantPaymentInfoRedi);
	    	mav.addObject(giftCardStatus, giftCdStatus);
	    }	   		    
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(payCardNumber, req.getParameter(payCardNumber));
        mav.addObject(payExpMonth, req.getParameter(payExpMonth));
        mav.addObject(payExpYear, req.getParameter(payExpYear));
        mav.addObject(nameOnCard, req.getParameter(nameOnCard));
        mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
        return mav;
    }

	@Override
    @Transactional
    public ModelAndView registrantGiftCardZeroPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	registrantCartPaymentEmailSendingToTheUser(req, sn, regInfoSavingModel.getRegUserName());
    	registrantUserAllZeroPaymentsInfoUpdatedInDBTable(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(giftCardPrice), req.getParameter(regGiftCardCouponCode), tranApprovedStatus, req.getParameter(totalPaybleAmount), currentDate);
        registrantGiftCardPaymentUpdateInDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(giftCardPrice), req.getParameter(regGiftCardCouponCode));
        registryAllTablesDataUploadAfterPayment(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        mav = new ModelAndView(registrantPaymentSuccessRed);
        mav.addObject(paymentOrderNumber, null);        
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        return mav;
    }

    public String registrantGiftCardPaymentUpdateInDB(HttpServletRequest req, HttpSession sn, long registrantUserId, String giftCardPrice, String giftCardCouponCode) {
    	String regiUserAllZeroPayments = null;
 	    RegistrantCustomGiftCardCodeSaving regCustomGiftCardCodeSavingModel =  registrantCustomGiftCardCodeSavingDAO.registrantGiftCardCodeValuesTakeFromDB(registrantUserId, giftCardCouponCode);
	   	double regUsedCredit = regCustomGiftCardCodeSavingModel.getUsedCredit();
	   	double regRemainingCredit = regCustomGiftCardCodeSavingModel.getRemainingCredit();
	   	double giftCardPriceDb = Double.parseDouble(giftCardPrice);
	   	double totalUsedCredit = regUsedCredit + giftCardPriceDb;
	   	double totalRemainingCredit = regRemainingCredit - giftCardPriceDb;
	   	regCustomGiftCardCodeSavingModel.setUsedCredit(totalUsedCredit);
	   	regCustomGiftCardCodeSavingModel.setRemainingCredit(totalRemainingCredit);
	   	registrantCustomGiftCardCodeSavingDAO.merge(regCustomGiftCardCodeSavingModel);
	    return regiUserAllZeroPayments;
    }

    public String registrantUserAllZeroPaymentsInfoUpdatedInDBTable(HttpServletRequest req, HttpSession sn, long registrantUserId, String giftCardPrice, String regGiftCardCouponCode, String returnType, String totalPaybleAmount, Timestamp currentDate) {
    	String regUserAllZeroPayments = null;
    	RegistrantPaymentInfoSaving regiPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);
		registryConceptBoardsService.registrantConceptBoardsPaymentInfoUpdateInDB(sn, req, registrantUserId, returnType, regiPaymentInfoSavingModel.getRegistrantPaymentInfoSavingId());
		registryFinishingTouchesService.registrantFinishingTouchesPaymentInfoUpdateInDB(sn, req, registrantUserId, returnType, regiPaymentInfoSavingModel.getRegistrantPaymentInfoSavingId());
    	String totPayableAmount = (String) sn.getAttribute(shoppingCartTotalAmountStInSn);
		regiPaymentInfoSavingModel.setCheckoutPaymentStatus(returnType);		
		regiPaymentInfoSavingModel.setTotalPableAmount(totPayableAmount);        	
		regiPaymentInfoSavingModel.setUpdatedDate(currentDate);
		regiPaymentInfoSavingModel.setShippingFee((String) sn.getAttribute(shippingAmountStInSn));
		regiPaymentInfoSavingModel.setTaxFee((String) sn.getAttribute(shoppingCartStateTaxFeeInSn));
		String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		regiPaymentInfoSavingModel.setCreatedDateInSt(todayDate);
		regiPaymentInfoSavingModel.setGiftCardPrice(giftCardPrice);
		regiPaymentInfoSavingModel.setGiftCardCode(regGiftCardCouponCode);
		registrantPaymentInfoSavingDAO.merge(regiPaymentInfoSavingModel);        	
		sn.setAttribute(totalFundsAmountInSn, null);
	    sn.setAttribute(handlingFeesInSn, null);	    
	    sn.setAttribute(totalPayableAmountSt, null);
	     sn.setAttribute(totalPayableAmountIncTaxInSn, null);
	    sn.setAttribute(shippingAmountStInSn, null);	     
	    sn.setAttribute(shoppingCartSubTotalAmountInSn, null);
	    sn.setAttribute(shoppingCartStateTaxFeeInSn, null);
	    sn.setAttribute(shoppingCartShippingFeeInSn, null);
	    sn.setAttribute(shoppingCartTotalAmountInSn, null);
	    sn.setAttribute(regiCartCountInSn, null);
    	sn.setAttribute(regTotalCartItems, null);
	    sn.setAttribute(shoppingCartTotalAmountStInSn, null);	    
	    sn.setAttribute(registryRoomFundsCountInSn, null);
	    sn.setAttribute(registryCashFundsCountInSn, null);
	    sn.setAttribute(registryCustomFundsCountInSn, null);
	    sn.setAttribute(regCBContributedCartCountInSn, null);
	    sn.setAttribute(regCBIndividualCountInSn, null);
	    sn.setAttribute(regFTContributedCartCountInSn, null);
        sn.setAttribute(regFTIndividualCartCountInSn, null);	    
	    return regUserAllZeroPayments;
    }

	@Override
    @Transactional
    public ModelAndView registrantGiftCardPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
        long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
    	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear) ;
    	Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
    	String amount = (String) sn.getAttribute(shoppingCartTotalAmountStInSn);
    	RegistrantPaymentInfoSaving regPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String fullName = regPaymentInfoSavingModel.getBillFullName();    	
    	String cityName = regPaymentInfoSavingModel.getBillCity();
    	String stateName = regPaymentInfoSavingModel.getBillState();
    	String zipCode = regPaymentInfoSavingModel.getBillZip();    	
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String emailAddress = regInfoSavingModel.getRegUserName();
    	String fullAddress = regPaymentInfoSavingModel.getBillAddress1() + " " + regPaymentInfoSavingModel.getBillAddress2();      
        String paymentReturnTypeReff = registryPaymentGatewayService.totalPaymentInfoSendToAuthorizeNetGateway(req, sn, amount, cardNumber, expirationDate, cardCode, fullName, emailAddress, fullAddress, cityName, stateName, zipCode);
        long transactionNumber = (Long) sn.getAttribute(transactionNumberInSn);
        String accountType = (String) sn.getAttribute(accountTypeInSn);
        String authorizationCode = (String) sn.getAttribute(authorizationCodeInSn);                
    	if((tranApprovedStatus).equals(paymentReturnTypeReff)) {
    		Timestamp currentDate = currentDate();
    		registrantCartPaymentEmailSendingToTheUser(req, sn, emailAddress);
    		registrantGiftCardAllPaymentsInfoUpdatedInDBTable(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cardNumber, accountType, expirationDate, cardCode, paymentReturnTypeReff, req.getParameter(nameOnCard), authorizationCode, transactionNumber, (String) sn.getAttribute(totalRGPaybleAmountInSn), currentDate, req.getParameter(giftCardPrice), req.getParameter(regGiftCardCouponCode));
    		registrantGiftCardPaymentUpdateInDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(giftCardPrice), req.getParameter(regGiftCardCouponCode));
    		registryAllTablesDataUploadAfterPayment(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    		mav = new ModelAndView(registrantPaymentSuccessRed);
    		mav.addObject(paymentOrderNumber, transactionNumber);
    		sn.setAttribute(totalPaybleAmountForEmailInSn, sn.getAttribute(totalRGPaybleAmountInSn));
    	} else {
    		mav = new ModelAndView(registrantGiftCardPaymentInfoRedi);    	
    		mav.addObject(totalFundsAmountInSn, sn.getAttribute(totalFundsAmountInSn));    		
    		mav.addObject(shoppingCartTotalAmountInSn, sn.getAttribute(shoppingCartTotalAmountInSn));
    		mav.addObject(totalPaybleAmount, sn.getAttribute(totalRGPaybleAmountInSn));
    		mav.addObject(giftCardPrice, req.getParameter(giftCardPrice));
    		mav.addObject(regGiftCardCouponCode, req.getParameter(regGiftCardCouponCode));
		    mav.addObject(payCardNumber, req.getParameter(payCardNumber));
		    mav.addObject(payExpMonth, req.getParameter(payExpMonth));
		    mav.addObject(payExpYear, req.getParameter(payExpYear));
		    mav.addObject(nameOnCard, req.getParameter(nameOnCard));
		    mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
		    mav.addObject(paymentValStatus, "Payment Fail");
		    mav.addObject(paymentReturnStatus, paymentReturnTypeReff);
		    mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	}    	
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        return mav;
    }

    public String registrantGiftCardAllPaymentsInfoUpdatedInDBTable(HttpServletRequest req, HttpSession sn, long registrantUserId, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate, String giftCardPrice, String regGiftCardCouponCode) {
    	String regGCAllPaymentRef = null;
    	registrantGiftCardAllPaymentsInfoUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cardNumber, accountType, expirationDate, cardCode, returnType, req.getParameter(nameOnCard), authorizationCode, transactionNumber, (String) sn.getAttribute(shoppingCartTotalAmountInSn), currentDate, giftCardPrice, regGiftCardCouponCode);
		registryConceptBoardsService.registrantConceptBoardsPaymentInfoUpdateInDB(sn, req, registrantUserId, returnType, (Long) sn.getAttribute(regiPaymentInfoSavingIdInSn));
		registryFinishingTouchesService.registrantFinishingTouchesPaymentInfoUpdateInDB(sn, req, registrantUserId, returnType, (Long) sn.getAttribute(regiPaymentInfoSavingIdInSn));
		registrantPaymentValuesGoingToNull(req, sn);
		return regGCAllPaymentRef;
    }

    public String registrantGiftCardAllPaymentsInfoUpdate(HttpServletRequest req, HttpSession sn, long registrantUserId, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate, String giftCardPrice, String regGiftCardCouponCode) {
    	String regGCAllPaymentUpRef = null;
		RegistrantPaymentInfoSaving regiPaymentInfoSavingModel = registrantPaymentInfoSavingDAO.registrantUserPaymentRowDataTakingFromDB(registrantUserId);
		String accCardNumber = Long.toString(cardNumber);
		regiPaymentInfoSavingModel.setPayCardNumber(accCardNumber);
		regiPaymentInfoSavingModel.setAccountType(accountType);
		regiPaymentInfoSavingModel.setPayExpDate(expirationDate);
		String cvvNum = Integer.toString(cardCode);
		regiPaymentInfoSavingModel.setPayCvvNumber(cvvNum);
		regiPaymentInfoSavingModel.setCheckoutPaymentStatus(returnType);
		regiPaymentInfoSavingModel.setNameOnCard(nameOnCard1);
		regiPaymentInfoSavingModel.setAuthorizationCode(authorizationCode);
		regiPaymentInfoSavingModel.setTransactionNumber(transactionNumber);
		regiPaymentInfoSavingModel.setTotalPableAmount(amount);        	
		regiPaymentInfoSavingModel.setUpdatedDate(currentDate);
		regiPaymentInfoSavingModel.setShippingFee((String) sn.getAttribute(shoppingCartShippingFeeInSn));
		regiPaymentInfoSavingModel.setTaxFee((String) sn.getAttribute(shoppingCartStateTaxFeeInSn));
		String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		regiPaymentInfoSavingModel.setCreatedDateInSt(todayDate);
		regiPaymentInfoSavingModel.setGiftCardPrice(giftCardPrice);
		regiPaymentInfoSavingModel.setGiftCardCode(regGiftCardCouponCode);
		registrantPaymentInfoSavingDAO.merge(regiPaymentInfoSavingModel);
		sn.setAttribute(regiPaymentInfoSavingIdInSn, regiPaymentInfoSavingModel.getRegistrantPaymentInfoSavingId());		
	    return regGCAllPaymentUpRef;
    }

	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
