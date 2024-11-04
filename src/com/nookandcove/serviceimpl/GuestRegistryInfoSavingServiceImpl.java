package com.nookandcove.serviceimpl;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.GuestConceptBoardsContributedPaymentSavingDAO;
import com.nookandcove.dao.GuestConceptBoardsIndividualPaymentSavingDAO;
import com.nookandcove.dao.GuestFinishingTouchesContributedPaymentSavingDAO;
import com.nookandcove.dao.GuestFinishingTouchesIndividualPaymentSavingDAO;
import com.nookandcove.dao.GuestRegistryCashFundsPaymentInfoSavingDAO;
import com.nookandcove.dao.GuestRoomFundPaymentInfoSavingDAO;
import com.nookandcove.dao.GuestUserPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsContributedPaymentSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsContributedProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsIndividualPaymentSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsIndividualProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantCustomGiftCardCodeSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesContributedPaymentSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesContributedProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesIndividualPaymentSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesIndividualProductsInfoSavingDAO;
import com.nookandcove.dao.RegistryRoomFundsInfoSavingDAO;
import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.dao.RegistryCashFundsInfoSavingDAO;
import com.nookandcove.model.GuestConceptBoardsContributedPaymentSaving;
import com.nookandcove.model.GuestConceptBoardsIndividualPaymentSaving;
import com.nookandcove.model.GuestFinishingTouchesContributedPaymentSaving;
import com.nookandcove.model.GuestFinishingTouchesIndividualPaymentSaving;
import com.nookandcove.model.GuestRegistryCashFundsPaymentInfoSaving;
import com.nookandcove.model.GuestRoomFundPaymentInfoSaving;
import com.nookandcove.model.GuestUserPaymentInfoSaving;
import com.nookandcove.model.RegistrantConceptBoardsContributedPaymentSaving;
import com.nookandcove.model.RegistrantConceptBoardsContributedProductsInfoSaving;
import com.nookandcove.model.RegistrantConceptBoardsIndividualPaymentSaving;
import com.nookandcove.model.RegistrantConceptBoardsIndividualProductsInfoSaving;
import com.nookandcove.model.RegistrantCustomGiftCardCodeSaving;
import com.nookandcove.model.RegistrantFinishingTouchesContributedPaymentSaving;
import com.nookandcove.model.RegistrantFinishingTouchesContributedProductsInfoSaving;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualPaymentSaving;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualProductsInfoSaving;
import com.nookandcove.model.RegistryRoomFundsInfoSaving;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.RegistryCashFundsInfoSaving;
import com.nookandcove.service.GuestRegistryInfoSavingService;
import com.nookandcove.service.RegistryPaymentGatewayService;
import com.taxjar.Taxjar;
import com.taxjar.exception.TaxjarException;
import com.taxjar.model.rates.RateResponse;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class GuestRegistryInfoSavingServiceImpl implements GuestRegistryInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GuestRegistryInfoSavingServiceImpl.class);
	
    private String regiAddressGuestSn = "regiAddressGuestSn";
	private String guestRoomFundsCartInfoInSn = "guestRoomFundsCartInfoInSn";
	private String guestRegistrantUserIdInSn = "guestRegistrantUserIdInSn";
	private String findRegistryRedirection = "findRegistryRedirection";
	private String spaceContributeInfoDisplay = "spaceContributeInfoDisplay";
	private String regGuestAddCartInfoDisplay = "regGuestAddCartInfoDisplay";
	private String guestFundsCheckOutNowRed = "guestFundsCheckOutNowRed";
	private String guestReviewAndPlaceOrderRed = "guestReviewAndPlaceOrderRed";
	private String guestRegistryPaymentInfoRed = "guestRegistryPaymentInfoRed";
	private String guestPaymentSuccessRed = "guestPaymentSuccessRed";	
	private String guestSpaceNameImg = "guestSpaceNameImg";
	private String guestSpaceName = "guestSpaceName";
	private String guSpaceColName = "guSpaceColName";
	private String guSpaceColCount = "guSpaceColCount";
	private String guestFundAmount = "guestFundAmount";
	private String roomFundNeedPrice = "roomFundNeedPrice";
	private String guStillNeedAmount = "guStillNeedAmount";	
	private String cashFundValueInSn = "cashFundValueInSn";
	private String onlySpaceTotalAmountInSn = "onlySpaceTotalAmountInSn";	
	private String cartCountInSn = "cartCountInSn";
	private String totalCartItems = "totalCartItems";
	private String totalGuFundAmount = "totalGuFundAmount";
	private String guestShoppingCartTotalAmountInSn = "guestShoppingCartTotalAmountInSn";
	private String totalPayableAmountInSn = "totalPayableAmountInSn";
	private String totalPayableAmountSt = "totalPayableAmountSt";
	private String totalFundsAmountInSn = "totalFundsAmountInSn";
	private String totalHandlingFeesInSn = "totalHandlingFeesInSn";
	private String eventType = "eventType";
	private String eventDate = "eventDate";	
	private String eventsTypeInSn = "eventsTypeInSn";
	private String regiUserNameInSn = "regiUserNameInSn";
	private String regiLastNameInSn = "regiLastNameInSn";
	private String coRegiLastNameInSn = "coRegiLastNameInSn";	
	private String regUserName = "regUserName";
	private String regFirstName = "regFirstName";
	private String regLastName = "regLastName";
	private String coRegFirstName = "coRegFirstName";
	private String coRegLastName = "coRegLastName";
	private String regUploadedPhoto = "regUploadedPhoto";
	private String registrantMessage = "registrantMessage";
	private String guestBackgroungImage = "guestBackgroungImage";
	private String searchNoRecordsForGuestRed = "searchNoRecordsForGuestRed";
	private String searchRegistryInfoForGuestRed = "searchRegistryInfoForGuestRed";	
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
	private String billNameOnCard = "billNameOnCard";
	private String billAddress1 = "billAddress1";
	private String billAddress2 = "billAddress2";
	private String billCity = "billCity";
	private String billState = "billState";
	private String billZip = "billZip";
	private String billCountry = "billCountry";
	private String guestEmail = "guestEmail";
	private String guestPhNumber = "guestPhNumber";
	private String guestUserFullName = "guestUserFullName";
	private String treasuredGiftMess = "treasuredGiftMess";	
	private String payCardNumber = "payCardNumber";
	private String payExpYear = "payExpYear";
	private String payExpMonth = "payExpMonth";
	private String payCvvNumber = "payCvvNumber";
	private String nameOnCard = "nameOnCard";
	private String paymentValStatus = "paymentValStatus";
	private String paymentReturnStatus = "paymentReturnStatus";	
	private String productQuantity = "productQuantity";	
	private String totalGuestBillingInfoInSn = "totalGuestBillingInfoInSn";
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
	private String guestRegistryMyAccount = "guestRegistryMyAccount";
	private String guestCBIndividualCartValueInSn = "guestCBIndividualCartValueInSn";
	private String guestCBContributedCartValueInSn = "guestCBContributedCartValueInSn";
	private String guestCBIndividualCartCountInSn = "guestCBIndividualCartCountInSn";
	private String guestCBContributedCartCountInSn = "guestCBContributedCartCountInSn";
	private String guestFTContributedCartCountInSn = "guestFTContributedCartCountInSn";
	private String guestFinishingTouchesContProductId = "guestFinishingTouchesContProductId";
	private String guestFTContributedCartValueInSn = "guestFTContributedCartValueInSn";
	private String guestFTContributedPriceInSn = "guestFTContributedPriceInSn";
	private String guestFTCotributedNeedPrice = "guestFTCotributedNeedPrice";
	private String roomsCartCountInSn = "roomsCartCountInSn";
	private String cashFundCartCountInSn = "cashFundCartCountInSn";
	private String totalRoomFundPriceInSn = "totalRoomFundPriceInSn";	
	private String guestCBIndividualPriceInSn = "guestCBIndividualPriceInSn";	
	private String guestConceptBoardContProductId = "guestConceptBoardContProductId";	
	private String guestCBContributedPriceInSn = "guestCBContributedPriceInSn";
	private String guestUserPaymentInfoSavingIdInSn = "guestUserPaymentInfoSavingIdInSn";	
	private String bothCBandFTAddCartPriceInSn = "bothCBandFTAddCartPriceInSn";
	private String shippingAmount = "shippingAmount";
	private String stateTaxAmount = "stateTaxAmount";
	private String totalPayableAmountDbInSn = "totalPayableAmountDbInSn";
	private String stateTaxAmountStInSn = "stateTaxAmountStInSn";
	private String shippingAmountStInSn = "shippingAmountStInSn";
	private String totalPayableAmountIncTaxInSn = "totalPayableAmountIncTaxInSn";
	private String roomFundTotalPriceInSn = "roomFundTotalPriceInSn";
	private String totalRoomFundPaybleAmountInSn = "totalRoomFundPaybleAmountInSn";	
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
	private String cashFundBigImageUrl = "resources/images/cash_fund_images/big/";
	private String cashFundSmallImageUrl = "resources/images/cash_fund_images/small/";
	
	private String regiFirstNameInSn = "regiFirstNameInSn";
	private String coRegiFirstNameInSn = "coRegiFirstNameInSn";
	private String regUploadedPhotoInSn = "regUploadedPhotoInSn";
	private String guestBackgroungImageInSn = "guestBackgroungImageInSn";
	private String registrantMessageInSn = "registrantMessageInSn";
	private String eventDateInSn = "eventDateInSn";
	private String registryCashFundsId = "registryCashFundsId";
	private String guestCashFundContributeInfoDisplay = "guestCashFundContributeInfoDisplay";
	private String guestCustomFundContributeInfoDisplay = "guestCustomFundContributeInfoDisplay";
	private String registryCashFundsImage = "registryCashFundsImage";
	private String guestCashFundsNeedAmount = "guestCashFundsNeedAmount";
	private String jSonObject = "JSonObj";
	private String guestCashFundTotalValueInSn = "guestCashFundTotalValueInSn";
	private String guestCustomFundTotalValueInSn = "guestCustomFundTotalValueInSn";
	private String totalGuestFundAmountInSn = "totalGuestFundAmountInSn";	
	private String cashFundsMessage = "cashFundsMessage";
	private String registryCashFundsMessage = "registryCashFundsMessage";
	private String registryCashFundsName = "registryCashFundsName";
	private String cashFundNewName = "cashFundNewName";
	private String registryCashFundContId = "registryCashFundContId";
	private String registryCashFundsNeedAmount = "registryCashFundsNeedAmount";
	private String contributeAmount = "contributeAmount";
	private String cashFundsName = "cashFundsName";
	private String redirectStatus = "redirect:";
	private String cashCustomFundHandlingFeeInSn = "cashCustomFundHandlingFeeInSn";
	private String cashCustomFundTotalAmountInSn = "cashCustomFundTotalAmountInSn";
	private String roomFundHandlingFeeInSn = "roomFundHandlingFeeInSn";	
	private String guestCashFundCartCountInSn = "guestCashFundCartCountInSn";
	private String guestCustomFundCartCountInSn = "guestCustomFundCartCountInSn";
	private String guestCashFundContValueInSn = "guestCashFundContValueInSn";
	private String guestCustomFundContValueInSn = "guestCustomFundContValueInSn";
	private String noActionStatsRef = "No Action";
	
	private String guestCBContributedProductSavingIdListInSn = "guestCBContributedProductSavingIdListInSn";
	private String guestCBContributedProductImageListInSn = "guestCBContributedProductImageListInSn";
	private String guestCBContributedProductNameListInSn = "guestCBContributedProductNameListInSn";
	private String guestCBContributedProductPriceListInSn = "guestCBContributedProductPriceListInSn";
	private String guestCBContributedProductQuantityListInSn = "guestCBContributedProductQuantityListInSn";
	private String guestCBContributedRemainingAmountListInSn = "guestCBContributedRemainingAmountListInSn";
	private String guestCBContributedAmountListInSn = "guestCBContributedAmountListInSn";
	
	private String guestCBIndividualProductSavingIdListInSn = "guestCBIndividualProductSavingIdListInSn";
	private String guestCBIndividualProductImageListInSn = "guestCBIndividualProductImageListInSn";
	private String guestCBIndividualProductNameListInSn = "guestCBIndividualProductNameListInSn";
	private String guestCBIndividualProductPriceListInSn = "guestCBIndividualProductPriceListInSn";
	private String guestCBIndividualProductQuantityListInSn = "guestCBIndividualProductQuantityListInSn";
	private String guestCBIndividualRemainingQuantityListInSn = "guestCBIndividualRemainingQuantityListInSn";
	private String guestCBIndividualGivenQuantityListInSn = "guestCBIndividualGivenQuantityListInSn";
	
	private String guestFTContributedProductSavingIdListInSn = "guestFTContributedProductSavingIdListInSn";
	private String guestFTContributedProductImageListInSn = "guestFTContributedProductImageListInSn";
	private String guestFTContributedProductNameListInSn = "guestFTContributedProductNameListInSn";
	private String guestFTContributedProductPriceListInSn = "guestFTContributedProductPriceListInSn";
	private String guestFTContributedProductQuantityListInSn = "guestFTContributedProductQuantityListInSn";
	private String guestFTContributedRemainingAmountListInSn = "guestFTContributedRemainingAmountListInSn";
	private String guestFTContributedAmountListInSn = "guestFTContributedAmountListInSn";
	
	private String guestFTIndividualProductSavingIdListInSn = "guestFTIndividualProductSavingIdListInSn";
	private String guestFTIndividualProductImageListInSn = "guestFTIndividualProductImageListInSn";
	private String guestFTIndividualProductNameListInSn = "guestFTIndividualProductNameListInSn";
	private String guestFTIndividualProductPriceListInSn = "guestFTIndividualProductPriceListInSn";
	private String guestFTIndividualProductQuantityListInSn = "guestFTIndividualProductQuantityListInSn";
	private String guestFTIndividualRemainingQuantityListInSn = "guestFTIndividualRemainingQuantityListInSn";
	private String guestFTIndividualGivenQuantityListInSn = "guestFTIndividualGivenQuantityListInSn";
	
	private String guestCBCotributedProductSavingId = "guestCBCotributedProductSavingId";
	private String guestCBCotributedRemainingPrice = "guestCBCotributedRemainingPrice";
	private String guestCBCotributedProductImage = "guestCBCotributedProductImage";
	private String guestCBCotributedNeedPrice = "guestCBCotributedNeedPrice";
	private String guestCBCotributedProductName = "guestCBCotributedProductName";
	private String guestCBCotributedPrice = "guestCBCotributedPrice";
	private String guestCBIndividualProductSavingId = "guestCBIndividualProductSavingId";
	private String guestCBIndividualProductPrice = "guestCBIndividualProductPrice";
	private String guestCBIndividualProductName = "guestCBIndividualProductName";
	private String guestCBIndividualProductImage = "guestCBIndividualProductImage";
	private String guestCBIndividualNeedQuantity = "guestCBIndividualNeedQuantity";
	private String paymentOrderNumber = "paymentOrderNumber";	
	private String guestRoomFundsPaymentInfoInSn = "guestRoomFundsPaymentInfoInSn";
	private String guestCashFundsPaymentInfoInSn = "guestCashFundsPaymentInfoInSn";
	private String guestCustomFundsPaymentInfoInSn = "guestCustomFundsPaymentInfoInSn";
	private String guestCBContributedPaymentInfoInSn = "guestCBContributedPaymentInfoInSn";
	private String guestCBIndividualPaymentInfoInSn = "guestCBIndividualPaymentInfoInSn";
	private String guestFTCotributedProductSavingId = "guestFTCotributedProductSavingId";
	private String guestFTCotributedRemainingPrice = "guestFTCotributedRemainingPrice";
	private String guestFTCotributedProductImage = "guestFTCotributedProductImage";
	private String guestFTCotributedProductName = "guestFTCotributedProductName";
	private String guestFTCotributedPrice = "guestFTCotributedPrice";
	
	private String dateComingSoonStatus = "Date coming soon";
//	private String guestDisplayBGImagePath = "resources/images/registry/reg_guest_show_images/";
	private String guestDisplayBGImagePath = "outsideImages/backgroundImages/";
	private String guestDisplayBGImageExten = ".png";
	private String messageForGuestReff = "Welcome to our registry! We are so happy and excited to share our special day with you!";
	private String uploadProfileTextReff = "<br><br>Upload<br> profile<br> picture";
	private String registryUserFullNameInSn = "registryUserFullNameInSn";
	private String totalPaybleAmountForEmailInSn = "totalPaybleAmountForEmailInSn";

	private String transactionNumberInSn = "transactionNumberInSn";
	private String accountTypeInSn = "accountTypeInSn";
	private String authorizationCodeInSn = "authorizationCodeInSn";
	
	private String guestFTIndividualProductSavingId = "guestFTIndividualProductSavingId";
	private String guestFTIndividualProductPrice = "guestFTIndividualProductPrice";
	private String guestFTIndividualProductName = "guestFTIndividualProductName";
	private String guestFTIndividualProductImage = "guestFTIndividualProductImage";
	private String guestFTIndividualNeedQuantity = "guestFTIndividualNeedQuantity";
	private String guestFTIndividualCartCountInSn = "guestFTIndividualCartCountInSn";
	private String guestFTIndividualCartValueInSn = "guestFTIndividualCartValueInSn";
	private String guestFTIndividualPriceInSn = "guestFTIndividualPriceInSn";
	private String defaultCouponPriceInSn = "defaultCouponPriceInSn";
	private String defaultCouponStPriceInSn = "defaultCouponStPriceInSn";
	
	
	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;
	
    @Autowired
    private RegistryRoomFundsInfoSavingDAO registrantInfoForGuestSavingDAO;

    @Autowired
    private GuestRoomFundPaymentInfoSavingDAO guestRoomFundPaymentInfoSavingDAO;

    @Autowired
    private GuestConceptBoardsContributedPaymentSavingDAO guestConceptBoardsContributedPaymentSavingDAO;

	@Autowired
    private GuestConceptBoardsIndividualPaymentSavingDAO guestConceptBoardsIndividualPaymentSavingDAO;

	@Autowired
    private GuestUserPaymentInfoSavingDAO guestUserPaymentInfoSavingDAO;

	@Autowired
    private RegistrantCustomGiftCardCodeSavingDAO registrantCustomGiftCardCodeSavingDAO;

	@Autowired
	private RegistryCashFundsInfoSavingDAO registryCashFundsInfoSavingDAO;

	@Autowired
	private GuestRegistryCashFundsPaymentInfoSavingDAO guestRegistryCashFundsPaymentInfoSavingDAO;	

	@Autowired
	private RegistrantConceptBoardsContributedProductsInfoSavingDAO registrantConceptBoardsContributedProductsInfoSavingDAO;

	@Autowired
	private RegistrantConceptBoardsIndividualProductsInfoSavingDAO registrantConceptBoardsIndividualProductsInfoSavingDAO;

	@Autowired
	private RegistrantConceptBoardsContributedPaymentSavingDAO registrantConceptBoardsContributedPaymentSavingDAO;

	@Autowired
	private RegistrantConceptBoardsIndividualPaymentSavingDAO registrantConceptBoardsIndividualPaymentSavingDAO;

	@Autowired
    private RegistryPaymentGatewayService registryPaymentGatewayService;

	@Autowired
    private RegistrantFinishingTouchesContributedProductsInfoSavingDAO registrantFinishingTouchesContributedProductsInfoSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesIndividualProductsInfoSavingDAO registrantFinishingTouchesIndividualProductsInfoSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesContributedPaymentSavingDAO registrantFinishingTouchesContributedPaymentSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesIndividualPaymentSavingDAO registrantFinishingTouchesIndividualPaymentSavingDAO;

	@Autowired
    private GuestFinishingTouchesIndividualPaymentSavingDAO guestFinishingTouchesIndividualPaymentSavingDAO;

	@Autowired
    private GuestFinishingTouchesContributedPaymentSavingDAO guestFinishingTouchesContributedPaymentSavingDAO;
	
	
    @Override
    @Transactional
    public ModelAndView findRegistryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantInformationSaving> regiSearchNamesList = registrantInformationSavingDAO.registryNamesListTakeFromDB();
    	if (!regiSearchNamesList.isEmpty()) {                       
    		List regUserIdsList = new ArrayList();
            List regUserImagesList = new ArrayList();
            List regUserNamesList = new ArrayList();
            List regUserDatesList = new ArrayList();
            List regUserURLsList = new ArrayList();            
            for (RegistrantInformationSaving regiSearchNamesModel : regiSearchNamesList) {
            	regUserIdsList.add(regiSearchNamesModel.getRegistrantUserId());
            	String regUserImageInDB = null;
            	if(null != regiSearchNamesModel.getRegPhotoUpload()) {
            		byte[] uploadedImageFromDB = regiSearchNamesModel.getRegPhotoUpload();
         	   		regUserImageInDB = "data:image/jpg;base64," + javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
            	} else {
            		regUserImageInDB = "resources/images/default_profile_img.png";
            	}
         	   	regUserImagesList.add(regUserImageInDB);
         	   	String fullName = null;
         	   if(null != regiSearchNamesModel.getCoRegFirstName() && (!("").equals(regiSearchNamesModel.getCoRegFirstName()))) {
         	   		String regFirstName = regiSearchNamesModel.getRegFirstName().substring(0, 1).toUpperCase() + regiSearchNamesModel.getRegFirstName().substring(1);
         	   		String coRegFirstName = regiSearchNamesModel.getCoRegFirstName().substring(0, 1).toUpperCase() + regiSearchNamesModel.getCoRegFirstName().substring(1);
         	   		fullName = regFirstName + " & " + coRegFirstName;
         	   	} else {
         	   		String regFirstName = regiSearchNamesModel.getRegFirstName().substring(0, 1).toUpperCase() + regiSearchNamesModel.getRegFirstName().substring(1);
     	   			String regLastName = regiSearchNamesModel.getRegLastName().substring(0, 1).toUpperCase() + regiSearchNamesModel.getRegLastName().substring(1);
         	   		fullName = regFirstName + " " + regLastName;
         	   	}
         	   	sn.setAttribute(registryUserFullNameInSn, fullName);
         	   	regUserNamesList.add(fullName);
         	   	String eventsDate = regiSearchNamesModel.getEventDate();         	   	
         	   	if(null != eventsDate) {
	               	String[] eventDateSt = eventsDate.split("/");
	               	int monthInt = Integer.parseInt(eventDateSt[0]);        
	               	String month = new DateFormatSymbols().getMonths()[monthInt-1];
	               	String eventDateList = month + " " + eventDateSt[1] + ", " + eventDateSt[2];
	               	regUserDatesList.add(eventDateList);
         	   	} else {
         	   	regUserDatesList.add("Date coming soon");
         	   	}         	   
         	   	regUserURLsList.add(regiSearchNamesModel.getRegAddress());
            }
            mav = guestUserNullValuesDisplayRedirection(req, sn);
            mav = new ModelAndView(findRegistryRedirection);
        	sn.setAttribute("reg_User_Ids_List", regUserIdsList);
            sn.setAttribute("reg_User_Images_List", regUserImagesList);
            sn.setAttribute("reg_User_Names_List", regUserNamesList);
            sn.setAttribute("reg_User_Dates_List", regUserDatesList);
            sn.setAttribute("reg_User_URLs_List", regUserURLsList);            
    	} else {
    		mav = new ModelAndView(findRegistryRedirection);
    	}
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestUserNullValuesDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView();        	   	
        sn.setAttribute(guestShoppingCartTotalAmountInSn, null);
        sn.setAttribute(guestRoomFundsCartInfoInSn, null);
        sn.setAttribute(cashFundValueInSn, null);
        sn.setAttribute(onlySpaceTotalAmountInSn, null);
        sn.setAttribute(cartCountInSn, null);
        sn.setAttribute(totalPayableAmountInSn, null);
        sn.setAttribute(totalFundsAmountInSn, null);
        sn.setAttribute(totalHandlingFeesInSn, null);
        sn.setAttribute(totalGuestBillingInfoInSn, null);
        sn.setAttribute(guestCBIndividualCartValueInSn, null);
        sn.setAttribute(guestCBIndividualCartCountInSn, null);
        sn.setAttribute(guestFTIndividualCartCountInSn, null);
        sn.setAttribute(guestFTIndividualCartValueInSn, null);
        sn.setAttribute(guestFTContributedCartValueInSn, null);
        sn.setAttribute(roomsCartCountInSn, null);
        sn.setAttribute(cashFundCartCountInSn, null);        
		sn.setAttribute(guestCBIndividualPriceInSn, null);		
 		sn.setAttribute(totalRoomFundPriceInSn, null); 		
 		sn.setAttribute(guestCBContributedPriceInSn, null);
 		sn.setAttribute(guestFTContributedPriceInSn, null);
        sn.setAttribute(guestFTIndividualPriceInSn, null);
 		sn.setAttribute(guestCBContributedCartCountInSn, null);
 		sn.setAttribute(guestFTContributedCartCountInSn, null);
 		sn.setAttribute(guestCBContributedCartValueInSn, null);
 		sn.setAttribute(guestUserPaymentInfoSavingIdInSn, null);
 		sn.setAttribute(totalPayableAmountIncTaxInSn, null);
	    sn.setAttribute(shippingAmountStInSn, null);
	    sn.setAttribute(stateTaxAmountStInSn, null);
	    sn.setAttribute(bothCBandFTAddCartPriceInSn, null);
	    sn.setAttribute(roomFundTotalPriceInSn, null);
	    sn.setAttribute(totalRoomFundPaybleAmountInSn, null);
	    sn.setAttribute(totalHandlingFeesInSn, null);
	    sn.setAttribute(regiFirstNameInSn, null);
	    sn.setAttribute(coRegiFirstNameInSn, null);
	    sn.setAttribute(regUploadedPhotoInSn, null);
	    sn.setAttribute(guestBackgroungImageInSn, null);
	    sn.setAttribute(registrantMessageInSn, null);
	    sn.setAttribute(eventDateInSn, null);
	    sn.setAttribute(guestCustomFundContValueInSn, null);
	    sn.setAttribute(guestCashFundContValueInSn, null);
	    sn.setAttribute(guestCashFundTotalValueInSn, null);
	    sn.setAttribute(guestCustomFundTotalValueInSn, null);
	    sn.setAttribute(totalGuestFundAmountInSn, null);	    
	    sn.setAttribute(guestCashFundCartCountInSn, null);
	    sn.setAttribute(guestCustomFundCartCountInSn, null);
	    sn.setAttribute(eventsTypeInSn, null);
	    sn.setAttribute(regiUserNameInSn, null);
	    sn.setAttribute(regiLastNameInSn, null);
	    sn.setAttribute(coRegiLastNameInSn, null);
	    return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView guestSelectByGiftInfo(String guestAddress, HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView("redirect:/reDirGuestSelectedGiftInfo", "regAddress", guestAddress);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView reDirGuestSelectedGiftInfoFromDB(String regiAddress, HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantInformationSaving> selectedTwoNameValuesList = registrantInformationSavingDAO.searchRegistryInfoInDBForGuest(regiAddress);
    	if(!selectedTwoNameValuesList.isEmpty()){
    		guestRegistrantInformationTakeFromDB(req, sn, regiAddress);
    		long registrantUserId = (Long) sn.getAttribute(guestRegistrantUserIdInSn);
     	   	registryRoomFundInfoDisplay(req, sn, registrantUserId);
     	   	registryCashFundInfoDisplay(req, sn, registrantUserId);
     	   	registryCustomFundInfoDisplay(req, sn, registrantUserId);
     	   	registryConceptBoardsContributedProductsDisplay(req, sn, registrantUserId);
     	   	registryConceptBoardsIndividualProductsDisplay(req, sn, registrantUserId);
     	   	registryFinishingTouchesContributedProductsDisplay(req, sn, registrantUserId);
     	   	registryFinishingTouchesIndividualProductsDisplay(req, sn, registrantUserId);
     	   	guestAndRegistryBothAllPricesListSeparation(req, sn, registrantUserId);    	   	
     	   	mav = new ModelAndView(searchRegistryInfoForGuestRed);        	
        	mav.addObject(eventType, sn.getAttribute(eventsTypeInSn));
            mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
            mav.addObject(regUserName, sn.getAttribute(regiUserNameInSn));
            mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
            mav.addObject(regLastName, sn.getAttribute(regiLastNameInSn));
            mav.addObject(coRegFirstName, sn.getAttribute(coRegiFirstNameInSn));
            mav.addObject(coRegLastName, sn.getAttribute(coRegiLastNameInSn));
            mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
            mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));            
        	sn.setAttribute(regiAddressGuestSn, regiAddress);
        	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
        	mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
    	} else {
    		mav = new ModelAndView(searchNoRecordsForGuestRed);
    	}
    	return mav;
    }
    
    public String guestRegistrantInformationTakeFromDB(HttpServletRequest req, HttpSession sn, String regiAddress) {
    	String guestRegistrantInfoRef = null;
    	RegistrantInformationSaving searchRegInfoModel = registrantInformationSavingDAO.searchRegistryInfoTakeFromDBForGuest(regiAddress);
		String regiUserName = searchRegInfoModel.getRegUserName();    		
		String regiPhotoImage = null;        
	    if(null != searchRegInfoModel.getRegPhotoUpload()) {
	    	byte[] regiUploadedImg = searchRegInfoModel.getRegPhotoUpload();
	    	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regiUploadedImg);
	    	regiPhotoImage = "<img src='data:image/jpg;base64,"+ bufferDBImage + "' class='regi_circle_uploaded_image'>";
	    } else {
	    	regiPhotoImage = uploadProfileTextReff;
        }   			
//	    String regiFirstName = searchRegInfoModel.getRegFirstName().substring(0,1).toUpperCase() + searchRegInfoModel.getRegFirstName().substring(1).toLowerCase();
//	    String regiLastName = searchRegInfoModel.getRegLastName().substring(0,1).toUpperCase() + searchRegInfoModel.getRegLastName().substring(1).toLowerCase();
//	    String coRegiFirstName = searchRegInfoModel.getCoRegFirstName();
//	    String coRegiLastName = searchRegInfoModel.getCoRegLastName();
	    long registrantUserId = searchRegInfoModel.getRegistrantUserId();
	    sn.setAttribute(guestRegistrantUserIdInSn, registrantUserId);
//	    if(null != coRegiFirstName && null != coRegiLastName) {
//	    	coRegiFirstName = coRegiFirstName.substring(0,1).toUpperCase() + coRegiFirstName.substring(1).toLowerCase();
//	    	coRegiLastName = coRegiLastName.substring(0,1).toUpperCase() + coRegiLastName.substring(1).toLowerCase();
//	    }
//	    String regMessage = searchRegInfoModel.getRegMessage();
	    String eventDateList = null;
	    if(null != searchRegInfoModel.getEventDate()) {
	    	String[] eventDateSt = searchRegInfoModel.getEventDate().split("/");
	    	int monthInt = Integer.parseInt(eventDateSt[0]);        
	    	String month = new DateFormatSymbols().getMonths()[monthInt-1];
	    	eventDateList = month + " " + eventDateSt[1] + ", " + eventDateSt[2];
	    } else {
        	eventDateList = dateComingSoonStatus;
        }
	    String registryCombiName = searchRegInfoModel.getRegFirstName();
        if(null != searchRegInfoModel.getCoRegFirstName()) {
        	registryCombiName = searchRegInfoModel.getRegFirstName() + " & " + searchRegInfoModel.getCoRegFirstName();
        }
        String guestBackGroundImage = registrantBackgroundImageTakeFromDB(req, sn, searchRegInfoModel.getGuestBackgroundImg(), searchRegInfoModel.getRegBackgroundUploadImage());        
        String messageForGuest = messageForGuestReff;
        if(null != searchRegInfoModel.getRegMessage()) {
        	messageForGuest = searchRegInfoModel.getRegMessage();
        } 
 	   	String eventsType = searchRegInfoModel.getEventType();
// 	   	String guestBackgroungImg = searchRegInfoModel.getGuestBackgroundImg(); 	   	
 	   	sn.setAttribute(regiFirstNameInSn, registryCombiName);
//	   	sn.setAttribute(coRegiFirstNameInSn, coRegiFirstName);
	   	sn.setAttribute(regUploadedPhotoInSn, regiPhotoImage);
	   	sn.setAttribute(guestBackgroungImageInSn, guestBackGroundImage);
	   	sn.setAttribute(registrantMessageInSn, messageForGuest);
	   	sn.setAttribute(eventDateInSn, eventDateList);	   	
	   	sn.setAttribute(eventsTypeInSn, eventsType);
	   	sn.setAttribute(regiUserNameInSn, regiUserName);
//	   	sn.setAttribute(regiLastNameInSn, regiLastName);
//	   	sn.setAttribute(coRegiLastNameInSn, coRegiLastName);
    	return guestRegistrantInfoRef;
    }

    public String registrantBackgroundImageTakeFromDB(HttpServletRequest req, HttpSession sn, String guestBackgroundImage, byte[] regBackgroundUploadImage) {
    	String guestBackGroundImage = null;
        if(null != guestBackgroundImage && null == regBackgroundUploadImage) {
        	guestBackGroundImage = guestDisplayBGImagePath + guestBackgroundImage + guestDisplayBGImageExten;
        } else if(null == guestBackgroundImage && null != regBackgroundUploadImage) {
        	byte[] regUploadedImg = regBackgroundUploadImage;
        	String bufferDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        	guestBackGroundImage = "data:image/jpg;base64,"+ bufferDBImage;
        } else {
        	guestBackGroundImage = guestDisplayBGImagePath + "reg_guest_show_image2" + guestDisplayBGImageExten;
        }
    	return guestBackGroundImage;
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
        List<RegistryRoomFundsInfoSaving> regInfoForGuestList = registrantInfoForGuestSavingDAO.selectedRegAddGiftRowCheckingInDB(registrantUserId);
    	if (!regInfoForGuestList.isEmpty()) {
    		RegistryRoomFundsInfoSaving regInfoForGuestModel = registrantInfoForGuestSavingDAO.selectedRegAddGiftRowValueFromDB(registrantUserId);    	
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

//  Concept Boards Contributed Products Display
    public String registryConceptBoardsContributedProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regConBoardsContributedRef = null;
        List guestCBContributedProductSavingIdList = new ArrayList();
        List guestCBContributedProductImageList = new ArrayList();
		List guestCBContributedProductNameList = new ArrayList();
		List guestCBContributedProductPriceList = new ArrayList();
		List guestCBContributedProductQuantityList = new ArrayList();
		List guestCBContributedRemainingAmountList = new ArrayList();
		List guestCBContributedAmountList = new ArrayList();	
		List<RegistrantConceptBoardsContributedProductsInfoSaving> guestCBContributedTotalInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedTotalDataTakeFromDB(registrantUserId);
		if (!guestCBContributedTotalInfoList.isEmpty()) {
    		for (RegistrantConceptBoardsContributedProductsInfoSaving guestCBContributedSavingModel : guestCBContributedTotalInfoList) {
    			guestCBContributedProductSavingIdList.add(guestCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			guestCBContributedProductImageList.add(guestCBContributedSavingModel.getProductUploadedImage());    			
    			guestCBContributedProductNameList.add(guestCBContributedSavingModel.getProductName());
    			double totalWithTaxValue = 0;
    			if(null != guestCBContributedSavingModel.getProductPrice()) {
    				double totalRegConProductPrice = Double.parseDouble(guestCBContributedSavingModel.getProductPrice());
    				totalWithTaxValue = totalRegConProductPrice + (totalRegConProductPrice/100)*20;
    			}
    			guestCBContributedProductPriceList.add(totalWithTaxValue);
    			guestCBContributedProductQuantityList.add(guestCBContributedSavingModel.getQuantity()); 
    			guestCBContributedRemainingAmountList.add(guestCBContributedSavingModel.getRemainingTotalPrice());
    			String regguestCBContributedPrice = guestConceptBoardsContributedPrice(req, sn, registrantUserId, guestCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			guestCBContributedAmountList.add(regguestCBContributedPrice);
        	}
    		sn.setAttribute(guestCBContributedProductSavingIdListInSn, guestCBContributedProductSavingIdList);
	 		sn.setAttribute(guestCBContributedProductImageListInSn, guestCBContributedProductImageList);
	 		sn.setAttribute(guestCBContributedProductNameListInSn, guestCBContributedProductNameList);
	 		sn.setAttribute(guestCBContributedProductPriceListInSn, guestCBContributedProductPriceList);
	 		sn.setAttribute(guestCBContributedProductQuantityListInSn, guestCBContributedProductQuantityList);
	 		sn.setAttribute(guestCBContributedRemainingAmountListInSn, guestCBContributedRemainingAmountList);
	 		sn.setAttribute(guestCBContributedAmountListInSn, guestCBContributedAmountList);
    	} else {
    		sn.setAttribute(guestCBContributedProductSavingIdListInSn, null);
	 		sn.setAttribute(guestCBContributedProductImageListInSn, null);
	 		sn.setAttribute(guestCBContributedProductNameListInSn, null);
	 		sn.setAttribute(guestCBContributedProductPriceListInSn, null);
	 		sn.setAttribute(guestCBContributedProductQuantityListInSn, null);
	 		sn.setAttribute(guestCBContributedRemainingAmountListInSn, null);
	 		sn.setAttribute(guestCBContributedAmountListInSn, null);
    	}
        return regConBoardsContributedRef;
    }

    public String guestConceptBoardsContributedPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductSavingId) {
        String regCBContributedPrice = null;
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceCheckInDB(registrantUserId, cbContributedProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceTakeFromDB(registrantUserId, cbContributedProductSavingId);
    		regCBContributedPrice = regDesigenConceptBoardsModel.getContributedPrice();
    	}
        return regCBContributedPrice;
    }
    
//  Concept Boards Individual Products Display
    public String registryConceptBoardsIndividualProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regConBoardsIndividualRef = null;
        List guestCBIndividualProductSavingIdList = new ArrayList();
        List guestCBIndividualProductImageList = new ArrayList();
		List guestCBIndividualProductNameList = new ArrayList();
		List guestCBIndividualProductPriceList = new ArrayList();
		List guestCBIndividualProductQuantityList = new ArrayList();
		List guestCBIndividualRemainingQuantityList = new ArrayList();
		List guestCBIndividualGivenQuantityList = new ArrayList();
		List<RegistrantConceptBoardsIndividualProductsInfoSaving> regguestCBIndividualTotalInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualTotalDataTakeFromDB(registrantUserId);
		if (!regguestCBIndividualTotalInfoList.isEmpty()) {
    		for (RegistrantConceptBoardsIndividualProductsInfoSaving regguestCBIndividualSavingModel : regguestCBIndividualTotalInfoList) {
    			guestCBIndividualProductSavingIdList.add(regguestCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			guestCBIndividualProductImageList.add(regguestCBIndividualSavingModel.getProductUploadedImage());    			
    			guestCBIndividualProductNameList.add(regguestCBIndividualSavingModel.getProductName());
    			guestCBIndividualProductPriceList.add(regguestCBIndividualSavingModel.getProductPrice());
    			guestCBIndividualProductQuantityList.add(regguestCBIndividualSavingModel.getQuantity()); 
    			guestCBIndividualRemainingQuantityList.add(regguestCBIndividualSavingModel.getRemainingQuantity());
    			int regguestCBIndividualGivenQuantity = guestConceptBoardsIndividualPrice(req, sn, registrantUserId, regguestCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			guestCBIndividualGivenQuantityList.add(regguestCBIndividualGivenQuantity);
        	}
    		sn.setAttribute(guestCBIndividualProductSavingIdListInSn, guestCBIndividualProductSavingIdList);
	 		sn.setAttribute(guestCBIndividualProductImageListInSn, guestCBIndividualProductImageList);
	 		sn.setAttribute(guestCBIndividualProductNameListInSn, guestCBIndividualProductNameList);
	 		sn.setAttribute(guestCBIndividualProductPriceListInSn, guestCBIndividualProductPriceList);
	 		sn.setAttribute(guestCBIndividualProductQuantityListInSn, guestCBIndividualProductQuantityList);
	 		sn.setAttribute(guestCBIndividualRemainingQuantityListInSn, guestCBIndividualRemainingQuantityList);
	 		sn.setAttribute(guestCBIndividualGivenQuantityListInSn, guestCBIndividualGivenQuantityList);
    	} else {
    		sn.setAttribute(guestCBIndividualProductSavingIdListInSn, null);
	 		sn.setAttribute(guestCBIndividualProductImageListInSn, null);
	 		sn.setAttribute(guestCBIndividualProductNameListInSn, null);
	 		sn.setAttribute(guestCBIndividualProductPriceListInSn, null);
	 		sn.setAttribute(guestCBIndividualProductQuantityListInSn, null);
	 		sn.setAttribute(guestCBIndividualRemainingQuantityListInSn, null);
	 		sn.setAttribute(guestCBIndividualGivenQuantityListInSn, null);
    	}
        return regConBoardsIndividualRef;
    }

    public Integer guestConceptBoardsIndividualPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualProductSavingId) {
        int regCBIndividualGivenQuantity = 0;
        List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceCheckInDB(registrantUserId, cbIndividualProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceTakeFromDB(registrantUserId, cbIndividualProductSavingId);
    		regCBIndividualGivenQuantity = regDesigenConceptBoardsModel.getGiftedQuantity();
    	}
        return regCBIndividualGivenQuantity;
    }

//  Finishing Touches Contributed Products Display
    public String registryFinishingTouchesContributedProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regConBoardsContributedRef = null;
        List guestFTContributedProductSavingIdList = new ArrayList();
        List guestFTContributedProductImageList = new ArrayList();
		List guestFTContributedProductNameList = new ArrayList();
		List guestFTContributedProductPriceList = new ArrayList();
		List guestFTContributedProductQuantityList = new ArrayList();
		List guestFTContributedRemainingAmountList = new ArrayList();
		List guestFTContributedAmountList = new ArrayList();	
		List<RegistrantFinishingTouchesContributedProductsInfoSaving> guestFTContributedTotalInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedTotalDataTakeFromDB(registrantUserId);
		if (!guestFTContributedTotalInfoList.isEmpty()) {
    		for (RegistrantFinishingTouchesContributedProductsInfoSaving guestFTContributedSavingModel : guestFTContributedTotalInfoList) {
    			guestFTContributedProductSavingIdList.add(guestFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			guestFTContributedProductImageList.add(guestFTContributedSavingModel.getProductUploadedImage());    			
    			guestFTContributedProductNameList.add(guestFTContributedSavingModel.getProductName());
    			double totalWithTaxValue = 0;
    			if(null != guestFTContributedSavingModel.getProductPrice()) {
    				double totalRegConProductPrice = Double.parseDouble(guestFTContributedSavingModel.getProductPrice());
    				totalWithTaxValue = totalRegConProductPrice + (totalRegConProductPrice/100)*20;
    			}
    			guestFTContributedProductPriceList.add(totalWithTaxValue);
    			guestFTContributedProductQuantityList.add(guestFTContributedSavingModel.getQuantity()); 
    			guestFTContributedRemainingAmountList.add(guestFTContributedSavingModel.getRemainingTotalPrice());
    			String regguestFTContributedPrice = guestFinishingTouchesContributedPrice(req, sn, registrantUserId, guestFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			guestFTContributedAmountList.add(regguestFTContributedPrice);
        	}
    		sn.setAttribute(guestFTContributedProductSavingIdListInSn, guestFTContributedProductSavingIdList);
	 		sn.setAttribute(guestFTContributedProductImageListInSn, guestFTContributedProductImageList);
	 		sn.setAttribute(guestFTContributedProductNameListInSn, guestFTContributedProductNameList);
	 		sn.setAttribute(guestFTContributedProductPriceListInSn, guestFTContributedProductPriceList);
	 		sn.setAttribute(guestFTContributedProductQuantityListInSn, guestFTContributedProductQuantityList);
	 		sn.setAttribute(guestFTContributedRemainingAmountListInSn, guestFTContributedRemainingAmountList);
	 		sn.setAttribute(guestFTContributedAmountListInSn, guestFTContributedAmountList);
    	} else {
    		sn.setAttribute(guestFTContributedProductSavingIdListInSn, null);
	 		sn.setAttribute(guestFTContributedProductImageListInSn, null);
	 		sn.setAttribute(guestFTContributedProductNameListInSn, null);
	 		sn.setAttribute(guestFTContributedProductPriceListInSn, null);
	 		sn.setAttribute(guestFTContributedProductQuantityListInSn, null);
	 		sn.setAttribute(guestFTContributedRemainingAmountListInSn, null);
	 		sn.setAttribute(guestFTContributedAmountListInSn, null);
    	}
        return regConBoardsContributedRef;
    }

    public String guestFinishingTouchesContributedPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftContributedProductSavingId) {
        String regFTContributedPrice = null;
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceCheckInDB(registrantUserId, ftContributedProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceTakeFromDB(registrantUserId, ftContributedProductSavingId);
    		regFTContributedPrice = regDesigenFinishingTouchesModel.getContributedPrice();
    	}
        return regFTContributedPrice;
    }
    
//  Finishing Touches Individual Products Display
    public String registryFinishingTouchesIndividualProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regConBoardsIndividualRef = null;
        List guestFTIndividualProductSavingIdList = new ArrayList();
        List guestFTIndividualProductImageList = new ArrayList();
		List guestFTIndividualProductNameList = new ArrayList();
		List guestFTIndividualProductPriceList = new ArrayList();
		List guestFTIndividualProductQuantityList = new ArrayList();
		List guestFTIndividualRemainingQuantityList = new ArrayList();
		List guestFTIndividualGivenQuantityList = new ArrayList();
		List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regguestFTIndividualTotalInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualTotalDataTakeFromDB(registrantUserId);
		if (!regguestFTIndividualTotalInfoList.isEmpty()) {
    		for (RegistrantFinishingTouchesIndividualProductsInfoSaving regguestFTIndividualSavingModel : regguestFTIndividualTotalInfoList) {
    			guestFTIndividualProductSavingIdList.add(regguestFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			guestFTIndividualProductImageList.add(regguestFTIndividualSavingModel.getProductUploadedImage());    			
    			guestFTIndividualProductNameList.add(regguestFTIndividualSavingModel.getProductName());
    			guestFTIndividualProductPriceList.add(regguestFTIndividualSavingModel.getProductPrice());
    			guestFTIndividualProductQuantityList.add(regguestFTIndividualSavingModel.getQuantity()); 
    			guestFTIndividualRemainingQuantityList.add(regguestFTIndividualSavingModel.getRemainingQuantity());
    			int regguestFTIndividualGivenQuantity = guestFinishingTouchesIndividualPrice(req, sn, registrantUserId, regguestFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			guestFTIndividualGivenQuantityList.add(regguestFTIndividualGivenQuantity);
        	}
    		sn.setAttribute(guestFTIndividualProductSavingIdListInSn, guestFTIndividualProductSavingIdList);
	 		sn.setAttribute(guestFTIndividualProductImageListInSn, guestFTIndividualProductImageList);
	 		sn.setAttribute(guestFTIndividualProductNameListInSn, guestFTIndividualProductNameList);
	 		sn.setAttribute(guestFTIndividualProductPriceListInSn, guestFTIndividualProductPriceList);
	 		sn.setAttribute(guestFTIndividualProductQuantityListInSn, guestFTIndividualProductQuantityList);
	 		sn.setAttribute(guestFTIndividualRemainingQuantityListInSn, guestFTIndividualRemainingQuantityList);
	 		sn.setAttribute(guestFTIndividualGivenQuantityListInSn, guestFTIndividualGivenQuantityList);
    	} else {
    		sn.setAttribute(guestFTIndividualProductSavingIdListInSn, null);
	 		sn.setAttribute(guestFTIndividualProductImageListInSn, null);
	 		sn.setAttribute(guestFTIndividualProductNameListInSn, null);
	 		sn.setAttribute(guestFTIndividualProductPriceListInSn, null);
	 		sn.setAttribute(guestFTIndividualProductQuantityListInSn, null);
	 		sn.setAttribute(guestFTIndividualRemainingQuantityListInSn, null);
	 		sn.setAttribute(guestFTIndividualGivenQuantityListInSn, null);
    	}
        return regConBoardsIndividualRef;
    }

    public Integer guestFinishingTouchesIndividualPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualProductSavingId) {
        int regFTIndividualGivenQuantity = 0;
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceCheckInDB(registrantUserId, ftIndividualProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceTakeFromDB(registrantUserId, ftIndividualProductSavingId);
    		regFTIndividualGivenQuantity = regDesigenFinishingTouchesModel.getGiftedQuantity();
    	}
        return regFTIndividualGivenQuantity;
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
//        List<RegistryRoomFundsPaymentInfoSaving> regRoomAndCashFundInfoList = roomFundsPaymentInfoSavingDAO.regRoomAndCashFundsPackageInfoRowCheckingInDB(registrantUserId);
//        if (!regRoomAndCashFundInfoList.isEmpty()) {        	
//    		for (RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundSavingModel : regRoomAndCashFundInfoList) {
//    			String registrantSeleSpaceInfo = regRoomAndCashFundSavingModel.getSelectedRoomFundsInfo();
//    			String[] registrantPaymentInfoSt = registrantSeleSpaceInfo.split("__");
//    			for(int i=0; i<registrantPaymentInfoSt.length; i++) {
//    				String[] regOnlyRoomFundValue = registrantPaymentInfoSt[i].split(",_,");    				
//    				String registrantPriceListSt = regOnlyRoomFundValue[1] + ",_," + regOnlyRoomFundValue[4] + ",_," + regOnlyRoomFundValue[2];
//    				bothGuestAndRegistrantPrice = bothGuestAndRegistrantPrice + "__" + registrantPriceListSt;    		        
//    			}    			
//        	}
//    		bothGuestAndRegistrantPrice = bothGuestAndRegistrantPrice.replaceFirst("null__", "");
//		}
        sn.setAttribute("totalLivingRoomFundsAmount", separateLivingRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalDyningRoomFundsAmount", separateDyningRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalBedRoomFundsAmount", separateBedRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalHomeOfficeRoomFundsAmount", separateHomeOfficeRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalEntryWayRoomFundsAmount", separateEntryWayRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalNurseryRoomFundsAmount", separateNurseryRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalKidsBedRoomRoomFundsAmount", separateKidsBedRoomRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalPlayAreaRoomFundsAmount", separatePlayAreaRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalOutDoorSpaceRoomFundsAmount", separateOutDoorSpaceRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
        sn.setAttribute("totalOtherDreamSpaceRoomFundsAmount", separateOtherDreamSpaceRoomFundsGiftedAmoutList(bothGuestAndRegistrantPrice));
//        String totalCashFundAmount = separateCashFundsGiftedAmoutList(req, sn, registrantUserId);
//		sn.setAttribute("totalCashFundsAmount", totalCashFundAmount);
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

//    public String separateCashFundsGiftedAmoutList(HttpServletRequest req, HttpSession sn, long registrantUserId) {
//    	String bothCashFundPriceTotal = null;
//    	double bothCashFundPriceTotalInt = 0;    	
//        List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.guestCashFundsPackageRowCheckingInDB(registrantUserId);
//        if (!guestCashFundPaymentRowList.isEmpty()) {
//    		for (GuestRegistryCashFundsPaymentInfoSaving guestUserPaymentSavingModel : guestCashFundPaymentRowList) {
//    			String cashFundPriceSt = guestUserPaymentSavingModel.getContributedCashFundPrice();
//    			if(null != cashFundPriceSt) {
//	    			double onlyCashFundPriceDb = Double.parseDouble(cashFundPriceSt);
//	    			bothCashFundPriceTotalInt = bothCashFundPriceTotalInt + onlyCashFundPriceDb;
//    			}
//        	}    		
//		}
//        List<RegistryCashFundsPaymentInfoSaving> regCashFundPaymentRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsPackageRowCheckingInDB(registrantUserId);
//        if (!regCashFundPaymentRowList.isEmpty()) {
//        	for (RegistryCashFundsPaymentInfoSaving regRoomAndCashFundSavingModel : regCashFundPaymentRowList) {
//    			String registrantCashFundPrice = regRoomAndCashFundSavingModel.getContributedCashFundPrice();
//    			if(null != registrantCashFundPrice) {
//    				double registrantCashFundPriceInt = Double.parseDouble(registrantCashFundPrice);
//	    			bothCashFundPriceTotalInt = bothCashFundPriceTotalInt + registrantCashFundPriceInt;
//    			}
//        	}    		
//		}
//        if(bothCashFundPriceTotalInt > 0) {
//        	bothCashFundPriceTotal = String.format("%.2f", bothCashFundPriceTotalInt);
//        }
//        return bothCashFundPriceTotal;
//    }

    @Override
    @Transactional
    public ModelAndView guestSelectedMyAccountInfoFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regiAddress = (String) sn.getAttribute(regiAddressGuestSn);
    	mav = new ModelAndView(searchRegistryInfoForGuestRed);
    	mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(coRegFirstName, sn.getAttribute(coRegiFirstNameInSn));
        mav.addObject(regUploadedPhoto, sn.getAttribute(regUploadedPhotoInSn));
        mav.addObject(registrantMessage, sn.getAttribute(registrantMessageInSn));
        mav.addObject(eventDate, sn.getAttribute(eventDateInSn));
        mav.addObject(guestBackgroungImage, sn.getAttribute(guestBackgroungImageInSn));                        
        sn.setAttribute(regiAddressGuestSn, regiAddress);
        mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView spaceContributeInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView(spaceContributeInfoDisplay);
    	mav.addObject(guestSpaceName, req.getParameter(guestSpaceName));
    	mav.addObject(guestSpaceNameImg, req.getParameter(guestSpaceNameImg));
    	mav.addObject(guSpaceColName, req.getParameter(guSpaceColName));
    	mav.addObject(guSpaceColCount, req.getParameter(guSpaceColCount));
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	String regStillNeedAmt = req.getParameter(guStillNeedAmount);
    	double regStillNeedAmtDb = 0;
    	if(null != regStillNeedAmt) {
    		regStillNeedAmtDb = Double.parseDouble(regStillNeedAmt);
    	}
    	String regStillNeedAmount = String.format("%.2f", regStillNeedAmtDb);
    	mav.addObject(guStillNeedAmount, regStillNeedAmount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestCashFundContributeInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String imageCFPath = cashFundSmallImageUrl + req.getParameter(registryCashFundsImage);    	
    	mav = new ModelAndView(guestCashFundContributeInfoDisplay);
    	mav.addObject(cashFundNewName, req.getParameter(registryCashFundsName));
    	mav.addObject(registryCashFundsImage, imageCFPath);
    	mav.addObject("regCashFundsNeedAmount", req.getParameter(registryCashFundsNeedAmount));
    	mav.addObject(cashFundsMessage, req.getParameter(registryCashFundsMessage));
    	mav.addObject(registryCashFundContId, req.getParameter(registryCashFundsId));
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestCustomFundContributeInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String selectedImageVal = null;
    	String imageDspVal = cashFundBigImageUrl + "10_custom_fund_img.png";
    	if((imageDspVal).equals(req.getParameter(registryCashFundsImage))) {
    		selectedImageVal = cashFundSmallImageUrl + "10_custom_fund_img.png";
    	} else {
    		selectedImageVal = req.getParameter(registryCashFundsImage);
    	}
    	mav = new ModelAndView(guestCustomFundContributeInfoDisplay);
    	mav.addObject(cashFundNewName, req.getParameter(registryCashFundsName));
    	mav.addObject(registryCashFundsImage, selectedImageVal);
    	mav.addObject("regCashFundsNeedAmount", req.getParameter(registryCashFundsNeedAmount));
    	mav.addObject(cashFundsMessage, req.getParameter(registryCashFundsMessage));
    	mav.addObject(registryCashFundContId, req.getParameter(registryCashFundsId));
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestCashFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	    	
    	String guestCashFundContrSnValue = null;
    	int totalCashFundCartCount = 0;
    	String guestCashFundContrCombVal = req.getParameter(registryCashFundsId) + "_,_" + req.getParameter(registryCashFundsImage) + "_,_" + req.getParameter(cashFundsName) + "_,_" + req.getParameter(contributeAmount) + "_,_" + req.getParameter(guestCashFundsNeedAmount);
    	if(null != sn.getAttribute(guestCashFundContValueInSn)) {
    		guestCashFundContrSnValue = guestCashFundAmountUpdateToCart(sn, (String) sn.getAttribute(guestCashFundContValueInSn), req.getParameter(registryCashFundsId), req.getParameter(contributeAmount), req.getParameter(registryCashFundsImage), req.getParameter(cashFundsName), req.getParameter(guestCashFundsNeedAmount));
    		totalCashFundCartCount = (int) sn.getAttribute(guestCashFundCartCountInSn);    		
        } else {
        	guestCashFundContrSnValue = guestCashFundContrCombVal;
        	totalCashFundCartCount = 1;
        	double guestCashFundValuDb = Double.parseDouble(req.getParameter(contributeAmount));
        	sn.setAttribute(guestCashFundTotalValueInSn, guestCashFundValuDb);
        }
    	sn.setAttribute(guestCashFundContValueInSn, guestCashFundContrSnValue);
    	sn.setAttribute(guestCashFundCartCountInSn, totalCashFundCartCount);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	mav = new ModelAndView(redirectStatus + guestRegistryMyAccount);
    	return mav;
    }

    public String guestCashFundAmountUpdateToCart(HttpSession sn, String guestCashFundContSnValue, String registryCashFundsId, String contributeAmount, String cashFundImage, String cashFundName, String guCashFundsNeedAmount) {
    	String guestCashFundsContSnValue = null;
    	String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
    	int totalCashFundCartCount = 0;
    	String prodIdCheckStatus = null;
    	double guestCashFundTotalValDb = 0;
    	for(int i=0; i<guestCashFundContrSnValue.length; i++) {
    		String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");    		
    		if(registryCashFundsId.equals(guestCashFundsListSt[0])) {
    			String totalGuestCashFundComb = registryCashFundsId + "_,_" + guestCashFundsListSt[1] + "_,_" + guestCashFundsListSt[2] + "_,_" + contributeAmount + "_,_" + guestCashFundsListSt[4];
				prodIdCheckStatus = "Done";
				guestCashFundsContSnValue = guestCashFundsContSnValue + "__" + totalGuestCashFundComb;				
				totalCashFundCartCount = totalCashFundCartCount + 1;
				double guestCashFundValDb = Double.parseDouble(contributeAmount);
				guestCashFundTotalValDb = guestCashFundTotalValDb + guestCashFundValDb;
    		} else {
    			guestCashFundsContSnValue = guestCashFundsContSnValue + "__" + guestCashFundContrSnValue[i];
    			totalCashFundCartCount = totalCashFundCartCount + 1;
    			double guestCashFundValueDb = Double.parseDouble(guestCashFundsListSt[3]);
    			guestCashFundTotalValDb = guestCashFundTotalValDb + guestCashFundValueDb;
    		}
    		guestCashFundsContSnValue = guestCashFundsContSnValue.replaceFirst("null__", "");
    	}
    	if(prodIdCheckStatus == null) {
    		String guestCashFundsInputVal = registryCashFundsId + "_,_" + cashFundImage + "_,_" + cashFundName + "_,_" + contributeAmount + "_,_" + guCashFundsNeedAmount;
    		guestCashFundsContSnValue = guestCashFundsContSnValue + "__" + guestCashFundsInputVal;
    		totalCashFundCartCount = totalCashFundCartCount + 1;
    		double guestCashFundValuDb = Double.parseDouble(contributeAmount);
			guestCashFundTotalValDb = guestCashFundTotalValDb + guestCashFundValuDb;
    	}
    	sn.setAttribute(guestCashFundCartCountInSn, totalCashFundCartCount);
    	sn.setAttribute(guestCashFundTotalValueInSn, guestCashFundTotalValDb);
    	sn.setAttribute(guestCashFundContValueInSn, guestCashFundsContSnValue);
    	return guestCashFundsContSnValue;
    }
    
    @Override
    @Transactional
    public ModelAndView guestCustomFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	    	
    	String guestCustomFundContrSnValue = null;
    	int totalCashFundCartCount = 0;
    	String guestCustomFundContrCombVal = req.getParameter(registryCashFundsId) + "_,_" + req.getParameter(registryCashFundsImage) + "_,_" + req.getParameter(cashFundsName) + "_,_" + req.getParameter(contributeAmount) + "_,_" + req.getParameter(guestCashFundsNeedAmount);
    	if(null != sn.getAttribute(guestCustomFundContValueInSn)) {
    		guestCustomFundContrSnValue = guestCustomFundAmountUpdateToCart(sn, (String) sn.getAttribute(guestCustomFundContValueInSn), req.getParameter(registryCashFundsId), req.getParameter(contributeAmount), req.getParameter(registryCashFundsImage), req.getParameter(cashFundsName), req.getParameter(guestCashFundsNeedAmount));
    		totalCashFundCartCount = (int) sn.getAttribute(guestCustomFundCartCountInSn);    		
        } else {
        	guestCustomFundContrSnValue = guestCustomFundContrCombVal;
        	totalCashFundCartCount = 1;
        	double guestCustomFundValuDb = Double.parseDouble(req.getParameter(contributeAmount));
        	sn.setAttribute(guestCustomFundTotalValueInSn, guestCustomFundValuDb);
        }
    	sn.setAttribute(guestCustomFundContValueInSn, guestCustomFundContrSnValue);
    	sn.setAttribute(guestCustomFundCartCountInSn, totalCashFundCartCount);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);    	
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	mav = new ModelAndView(redirectStatus + guestRegistryMyAccount);
    	return mav;
    }

    public String guestCustomFundAmountUpdateToCart(HttpSession sn, String guestCustomFundContSnValue, String registryCustomFundsId, String contributeAmount, String customFundImage, String customFundName, String customFundNeedPrice) {
    	String guestCustomFundsContSnValue = null;
    	String[] guestCustomFundContrSnValue = guestCustomFundContSnValue.split("__");
    	int totalCustomFundCartCount = 0;
    	String prodIdCheckStatus = null;
    	double guestCustomFundTotalValDb = 0;
    	for(int i=0; i<guestCustomFundContrSnValue.length; i++) {
    		String[] guestCustomFundsListSt = guestCustomFundContrSnValue[i].split("_,_");    		
    		if(registryCustomFundsId.equals(guestCustomFundsListSt[0])) {    			
				String totalGuestCustomFundComb = registryCustomFundsId + "_,_" + guestCustomFundsListSt[1] + "_,_" + guestCustomFundsListSt[2] + "_,_" + contributeAmount + "_,_" + guestCustomFundsListSt[4];
				prodIdCheckStatus = "Done";
				guestCustomFundsContSnValue = guestCustomFundsContSnValue + "__" + totalGuestCustomFundComb;
				totalCustomFundCartCount = totalCustomFundCartCount + 1;
				double guestCustomFundValDb = Double.parseDouble(contributeAmount);
				guestCustomFundTotalValDb = guestCustomFundTotalValDb + guestCustomFundValDb;
    		} else {
    			guestCustomFundsContSnValue = guestCustomFundsContSnValue + "__" + guestCustomFundContrSnValue[i];
    			totalCustomFundCartCount = totalCustomFundCartCount + 1;
    			double guestCustomFundValueDb = Double.parseDouble(guestCustomFundsListSt[3]);
    			guestCustomFundTotalValDb = guestCustomFundTotalValDb + guestCustomFundValueDb;
    		}
    		guestCustomFundsContSnValue = guestCustomFundsContSnValue.replaceFirst("null__", "");
    	}
    	if(prodIdCheckStatus == null) {
    		String guestCustomFundsInputVal = registryCustomFundsId + "_,_" + customFundImage + "_,_" + customFundName + "_,_" + contributeAmount + "_,_" + customFundNeedPrice;
    		guestCustomFundsContSnValue = guestCustomFundsContSnValue + "__" + guestCustomFundsInputVal;
    		totalCustomFundCartCount = totalCustomFundCartCount + 1;
    		double guestCustomFundValuDb = Double.parseDouble(contributeAmount);
			guestCustomFundTotalValDb = guestCustomFundTotalValDb + guestCustomFundValuDb;
    	}
    	sn.setAttribute(guestCustomFundTotalValueInSn, guestCustomFundTotalValDb);
    	sn.setAttribute(guestCustomFundCartCountInSn, totalCustomFundCartCount);
    	sn.setAttribute(guestCustomFundContValueInSn, guestCustomFundsContSnValue);
    	return guestCustomFundsContSnValue;
    }

//    @Override
//    @Transactional
//    public ModelAndView cashFundContributeEditInfoRedirection(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	long registrantUserId = (Long) sn.getAttribute(guestRegistrantUserIdInSn);
//    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
//    	String cashFundDBImage = null;        
//        if(null != regInfoSavingModel.getCashFundUploadImg()) {
//        	byte[] regCFUploadedImg = regInfoSavingModel.getCashFundUploadImg();
//        	cashFundDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(regCFUploadedImg);
//        }                
//    	mav = new ModelAndView(cashFundContributeInfoDisplay);
//    	mav.addObject(cashFundValueInSn, req.getParameter(cashFundValueInSn));
//    	mav.addObject(cashFundUploadImg, cashFundDBImage);
//    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
//        return mav;
//    }

    @Override
    @Transactional
    public ModelAndView guestConceptBoardContributedInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView("guestConceptBoardsContributeInfoDisplay");
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	mav.addObject(guestCBCotributedProductSavingId, req.getParameter(guestCBCotributedProductSavingId));    	
    	mav.addObject(guestCBCotributedRemainingPrice, req.getParameter(guestCBCotributedRemainingPrice));    	
    	mav.addObject(guestCBCotributedProductImage, req.getParameter(guestCBCotributedProductImage));
    	mav.addObject(guestCBCotributedProductName, req.getParameter(guestCBCotributedProductName));
    	mav.addObject(guestCBCotributedPrice, req.getParameter(guestCBCotributedPrice));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestFinishingTouchesContributedInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView("guestFinishingTouchesContributeInfoDisplay");
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	mav.addObject(guestFTCotributedProductSavingId, req.getParameter(guestFTCotributedProductSavingId));    	
    	mav.addObject(guestFTCotributedRemainingPrice, req.getParameter(guestFTCotributedRemainingPrice));    	
    	mav.addObject(guestFTCotributedProductImage, req.getParameter(guestFTCotributedProductImage));
    	mav.addObject(guestFTCotributedProductName, req.getParameter(guestFTCotributedProductName));
    	mav.addObject(guestFTCotributedPrice, req.getParameter(guestFTCotributedPrice));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView regSpacePriceInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String cartGuestUserRegInfoList = null;
    	String cartGuestUserRegInfoSnList = (String) sn.getAttribute(guestRoomFundsCartInfoInSn);
    	int totalRegPrice = 0;
    	String status = null;
    	int cartCount = 0;
    	if(null != cartGuestUserRegInfoSnList) {
    		String singCartRowValueList[] = cartGuestUserRegInfoSnList.split("__");    		
    		for(int i=0; i<singCartRowValueList.length; i++) {    			
    			String singCartColumnValue[] = singCartRowValueList[i].split(",_,");
    			String guSpaceColumnName = singCartColumnValue[3];
    			String guSpaceColumnCount = singCartColumnValue[4];    			
    			if(req.getParameter(guSpaceColName).equals(guSpaceColumnName) && req.getParameter(guSpaceColCount).equals(guSpaceColumnCount)) {    				
    				cartGuestUserRegInfoList = cartGuestUserRegInfoList + "__" + req.getParameter(guestSpaceNameImg) + ",_," + req.getParameter(guestSpaceName) + ",_," + req.getParameter(guestFundAmount) + ",_," + req.getParameter(guSpaceColName) + ",_," + req.getParameter(guSpaceColCount) + ",_," + req.getParameter(roomFundNeedPrice);
    				totalRegPrice = totalRegPrice + Integer.parseInt(req.getParameter(guestFundAmount));
    				status = "Have";
    				cartCount = cartCount + 1;
    			} else {
    				cartGuestUserRegInfoList = cartGuestUserRegInfoList + "__" + singCartRowValueList[i];
    				totalRegPrice = totalRegPrice + Integer.parseInt(singCartColumnValue[2]);
    				cartCount = cartCount + 1;
    			}    			
    		}
    		if((null == status)) {
				cartGuestUserRegInfoList =  cartGuestUserRegInfoList + "__" + req.getParameter(guestSpaceNameImg) + ",_," + req.getParameter(guestSpaceName) + ",_," + req.getParameter(guestFundAmount) + ",_," + req.getParameter(guSpaceColName) + ",_," + req.getParameter(guSpaceColCount) + ",_," + req.getParameter(roomFundNeedPrice);
				totalRegPrice = totalRegPrice + Integer.parseInt(req.getParameter(guestFundAmount));
				cartCount = cartCount + 1;
			}
    	} else {
    		cartGuestUserRegInfoList = req.getParameter(guestSpaceNameImg) + ",_," + req.getParameter(guestSpaceName) + ",_," + req.getParameter(guestFundAmount) + ",_," + req.getParameter(guSpaceColName) + ",_," + req.getParameter(guSpaceColCount) + ",_," + req.getParameter(roomFundNeedPrice);
    		totalRegPrice = Integer.parseInt(req.getParameter(guestFundAmount));
    		cartCount = cartCount + 1;
    	}
    	cartGuestUserRegInfoList = cartGuestUserRegInfoList.replaceFirst("null__", "");
    	sn.setAttribute(roomsCartCountInSn, cartCount);
    	sn.setAttribute(totalRoomFundPriceInSn, totalRegPrice);
    	sn.setAttribute(guestRoomFundsCartInfoInSn, cartGuestUserRegInfoList);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);    	
    	sn.setAttribute(totalGuFundAmount, allShoppingCartTotalAmount);    	
    	sn.setAttribute(cartCountInSn, allCartCountTotal);
    	sn.setAttribute(onlySpaceTotalAmountInSn, totalRegPrice);
    	mav = new ModelAndView(redirectStatus + guestRegistryMyAccount);
    	return mav;
    }

    public int allCartCountTotalDisplay(HttpSession sn) {
    	int allCartCountTotal = 0;
    	int totalRoomCartCount = 0;    	
    	if(null != sn.getAttribute(roomsCartCountInSn)) {
    		totalRoomCartCount = (int) sn.getAttribute(roomsCartCountInSn);
        }
    	int registryCashFundCount = 0;    	
    	if(null != sn.getAttribute(guestCashFundCartCountInSn)) {
    		registryCashFundCount = (int) sn.getAttribute(guestCashFundCartCountInSn);
    	}
    	int registryCustomFundCount = 0;
    	if(null != sn.getAttribute(guestCustomFundCartCountInSn)) {
    		registryCustomFundCount = (int) sn.getAttribute(guestCustomFundCartCountInSn);
    	}    	
    	int guestCBCartCount = 0;
    	if(null != sn.getAttribute(guestCBIndividualCartCountInSn)) {
        	guestCBCartCount = (int) sn.getAttribute(guestCBIndividualCartCountInSn);
        }
    	int guestCBContCartCount = 0;
    	if(null != sn.getAttribute(guestCBContributedCartCountInSn)) {
    		guestCBContCartCount = (int) sn.getAttribute(guestCBContributedCartCountInSn);
        }
    	int guestFTCartCount = 0;
    	if(null != sn.getAttribute(guestFTIndividualCartCountInSn)) {
    		guestFTCartCount = (int) sn.getAttribute(guestFTIndividualCartCountInSn);
        }
    	int guestFTContCartCount = 0;
    	if(null != sn.getAttribute(guestFTContributedCartCountInSn)) {
    		guestFTContCartCount = (int) sn.getAttribute(guestFTContributedCartCountInSn);
        } 
        allCartCountTotal = totalRoomCartCount + registryCashFundCount + registryCustomFundCount + guestCBCartCount + guestCBContCartCount + guestFTCartCount + guestFTContCartCount;
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	return allCartCountTotal;
    }

    public double allShoppingCartTotalAmountDisplay(HttpSession sn) {
    	double allShoppingCartTotalAmount = 0;
    	int totalRoomFundPrice = 0;
    	double guestCashFundTotalValue = 0;
    	double guestCustomFundTotalValue = 0;
    	double guestConceptBoardsPrice = 0;
    	double guestConceptBoardsContPrice = 0;
    	double guestFinishingTouchesIndPrice = 0;
    	double guestFinishingTouchesContPrice = 0;
    	if(null != sn.getAttribute(totalRoomFundPriceInSn)) {
    		totalRoomFundPrice = (Integer) sn.getAttribute(totalRoomFundPriceInSn);
    	}
    	if(null != sn.getAttribute(guestCashFundTotalValueInSn)) {
    		guestCashFundTotalValue = (double) sn.getAttribute(guestCashFundTotalValueInSn);
    	}
    	if(null != sn.getAttribute(guestCustomFundTotalValueInSn)) {
    		guestCustomFundTotalValue = (double) sn.getAttribute(guestCustomFundTotalValueInSn);
    	}
    	if(null != sn.getAttribute(guestCBContributedPriceInSn)) {
    		guestConceptBoardsContPrice = (double) sn.getAttribute(guestCBContributedPriceInSn);
        }
    	if(null != sn.getAttribute(guestCBIndividualPriceInSn)) {
    		guestConceptBoardsPrice = (double) sn.getAttribute(guestCBIndividualPriceInSn);
        }
    	if(null != sn.getAttribute(guestFTContributedPriceInSn)) {
    		guestFinishingTouchesIndPrice = (double) sn.getAttribute(guestFTContributedPriceInSn);
        }
    	if(null != sn.getAttribute(guestFTIndividualPriceInSn)) {
    		guestFinishingTouchesContPrice = (double) sn.getAttribute(guestFTIndividualPriceInSn);
        }
    	double totalCBAndFTAmount = guestConceptBoardsPrice + guestConceptBoardsContPrice + guestFinishingTouchesIndPrice + guestFinishingTouchesContPrice;
        allShoppingCartTotalAmount = totalRoomFundPrice + guestCashFundTotalValue + guestCustomFundTotalValue + totalCBAndFTAmount;
        defaultCouponCodeFee(sn, totalCBAndFTAmount);
        sn.setAttribute(guestShoppingCartTotalAmountInSn, allShoppingCartTotalAmount);
    	return allShoppingCartTotalAmount;
    }

    public double defaultCouponCodeFee(HttpSession sn, double totalCBAndFTAmount) {
    	double defaultCouponPrice = 0;
    	if(totalCBAndFTAmount > 0) {
    		defaultCouponPrice = (totalCBAndFTAmount/100)*5;
    		String defaultCouponPriceSt = String.format("%,.2f", defaultCouponPrice);
    		sn.setAttribute(defaultCouponStPriceInSn, defaultCouponPriceSt);
    	}
    	sn.setAttribute(defaultCouponPriceInSn, defaultCouponPrice);
    	return defaultCouponPrice;
    }

    @Override
    @Transactional
    public ModelAndView regGuestMyShoppingCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
    	if(allCartCountTotal > 0) {
        	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
        	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
        	mav = new ModelAndView(regGuestAddCartInfoDisplay);        	
        	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);
	    	mav.addObject(totalCartItems, allCartCountTotal);
	    	sn.setAttribute(cartCountInSn, allCartCountTotal);
	    	sn.setAttribute(guestShoppingCartTotalAmountInSn, allShoppingCartTotalAmount);
    	} else {
    		mav = guestSelectedMyAccountInfoFromDB(req, sn);
    	}
    	return mav;
    }
    
    public double guestStateTaxPriceValue(HttpServletRequest req, HttpSession sn) {
	    double guestTotalStateTaxAmount = 0;
		String stateTaxFeeSt = "0.00";
//		if(null != sn.getAttribute(guestCBIndividualPriceInSn)) {
//			double bothCBandFTAddCartPrice = (double) sn.getAttribute(guestCBIndividualPriceInSn);
//			double guestCBIndividualStateTaxPriceDb = (bothCBandFTAddCartPrice/100)*8; 
//			guestTotalStateTaxAmount = guestTotalStateTaxAmount + guestCBIndividualStateTaxPriceDb;			
//		}
//		if(null != sn.getAttribute(guestFTIndividualPriceInSn)) {
//    		double guestFTIndividualStateTaxPrice = (double) sn.getAttribute(guestFTIndividualPriceInSn);
//    		double guestFTIndividualStateTaxPriceDb = (guestFTIndividualStateTaxPrice/100)*8;
//    		guestTotalStateTaxAmount = guestTotalStateTaxAmount + guestFTIndividualStateTaxPriceDb;    		
//    	}
		if(guestTotalStateTaxAmount > 0) {
			stateTaxFeeSt = String.format("%.2f", guestTotalStateTaxAmount);
		}
		sn.setAttribute(stateTaxAmountStInSn, stateTaxFeeSt);
		sn.setAttribute(totalPayableAmountIncTaxInSn, guestTotalStateTaxAmount);
		return guestTotalStateTaxAmount;
    }

    @Override
    @Transactional
    public ModelAndView guestFundsCheckOutNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	double guestTotalCartAmount = guestTotalSelectedCartPrice(req, sn);
    	String totalCartAmount = String.format("%.2f", guestTotalCartAmount);
    	double guestTotalShippingAmount = guestTotalShippingPrice(req, sn);
    	String totalShippingAmount = "0.00";
    	if(guestTotalShippingAmount > 0) {
    		totalShippingAmount = String.format("%.2f", guestTotalShippingAmount);
    	}    	
    	String stateTaxFee = "0.00";
    	double stateTaxFeeDb = guestStateTaxPriceValue(req, sn);
    	if(stateTaxFeeDb > 0) {
    		stateTaxFee = (String) sn.getAttribute(stateTaxAmountStInSn);
    	}    	
    	double guestRoomFundHandling = guestRoomFundsHandlingFee(req, sn);
    	double defaultCouponPrice = guestDefaultCouponPrice(req, sn);
    	double guestCashCustomFundHandling = guestCashAndCustomFundsHandlingFee(req, sn);
    	double totalPaybleAmountInDb = guestTotalCartAmount + guestRoomFundHandling + guestTotalShippingAmount + stateTaxFeeDb + guestCashCustomFundHandling - defaultCouponPrice;
    	String totalPaybleAmount = String.format("%.2f", totalPaybleAmountInDb);
    	double totalPaybleAmountdb = guestTotalCartAmount + guestRoomFundHandling + guestTotalShippingAmount + guestCashCustomFundHandling;
    	double totalHandlingFee = guestRoomFundHandling + guestCashCustomFundHandling;
    	String totalHandlingFeeSt = String.format("%.2f", totalHandlingFee);
    	String totalGuestBillingInfo = (String) sn.getAttribute(totalGuestBillingInfoInSn);
    	String totalGuestBillingInfoSt1 = null;
    	String totalGuestBillingInfoSt2 = null;
    	String totalGuestBillingInfoSt3 = null;
    	String totalGuestBillingInfoSt4 = null;    	
    	String totalGuestBillingInfoSt5 = null;
    	String totalGuestBillingInfoSt6 = null;
    	String totalGuestBillingInfoSt7 = null;
    	String totalGuestBillingInfoSt8 = null;
    	String totalGuestBillingInfoSt9 = null;
    	String totalGuestBillingInfoSt10 = null;
    	String totalGuestBillingInfoSt11 = null;
    	if(null != totalGuestBillingInfo) {
    		String totalGuestBillingInfoSt[] = totalGuestBillingInfo.split("__");
    		totalGuestBillingInfoSt1 = totalGuestBillingInfoSt[0];
    		totalGuestBillingInfoSt2 = totalGuestBillingInfoSt[1];
    		totalGuestBillingInfoSt3 = totalGuestBillingInfoSt[2];
    		totalGuestBillingInfoSt4 = totalGuestBillingInfoSt[3];
    		totalGuestBillingInfoSt5 = totalGuestBillingInfoSt[4];
    		totalGuestBillingInfoSt6 = totalGuestBillingInfoSt[5];
    		totalGuestBillingInfoSt7 = totalGuestBillingInfoSt[6];
    		totalGuestBillingInfoSt8 = totalGuestBillingInfoSt[7];
    		totalGuestBillingInfoSt9 = totalGuestBillingInfoSt[8];
    		totalGuestBillingInfoSt10 = totalGuestBillingInfoSt[9];
    		if(totalGuestBillingInfoSt.length > 10) { 
    			totalGuestBillingInfoSt11 = totalGuestBillingInfoSt[10];
    		}
    	}
    	mav = new ModelAndView(guestFundsCheckOutNowRed);
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));   	
    	sn.setAttribute(totalPayableAmountInSn, totalPaybleAmount);    	
        sn.setAttribute(totalHandlingFeesInSn, totalHandlingFeeSt);
        mav.addObject(totalFundsAmountInSn, totalCartAmount);
    	sn.setAttribute(totalPayableAmountDbInSn, totalPaybleAmountdb);
    	mav.addObject(billNameOnCard, totalGuestBillingInfoSt1);
    	mav.addObject(billAddress1, totalGuestBillingInfoSt2);
    	mav.addObject(billAddress2, totalGuestBillingInfoSt3);
    	mav.addObject(billCity, totalGuestBillingInfoSt4);
    	mav.addObject(billState, totalGuestBillingInfoSt5);
    	mav.addObject(billZip, totalGuestBillingInfoSt6);
    	mav.addObject(billCountry, totalGuestBillingInfoSt7);
    	mav.addObject(guestEmail, totalGuestBillingInfoSt8);
    	mav.addObject(guestPhNumber, totalGuestBillingInfoSt9);
    	mav.addObject(guestUserFullName, totalGuestBillingInfoSt10);
    	mav.addObject(treasuredGiftMess, totalGuestBillingInfoSt11);
    	mav.addObject(shippingAmount, totalShippingAmount);
    	mav.addObject(stateTaxAmount, stateTaxFee);
    	return mav;
    }

    public double guestDefaultCouponPrice(HttpServletRequest req, HttpSession sn) {
    	double defaultCouponPrice = 0;
    	if(null != sn.getAttribute(defaultCouponPriceInSn)) {
    		defaultCouponPrice = (double) sn.getAttribute(defaultCouponPriceInSn);
    	}
    	return defaultCouponPrice;
    }

    public double guestTotalSelectedCartPrice(HttpServletRequest req, HttpSession sn) {
    	double guestTotalCartAmount = 0;
    	if(null != sn.getAttribute(guestShoppingCartTotalAmountInSn)) {
    		guestTotalCartAmount = (double) sn.getAttribute(guestShoppingCartTotalAmountInSn);
    	}
    	String totalCartAmount = String.format("%.2f", guestTotalCartAmount);
    	sn.setAttribute(totalFundsAmountInSn, totalCartAmount);
    	return guestTotalCartAmount;
    }

    public double guestTotalShippingPrice(HttpServletRequest req, HttpSession sn) {
    	double guestTotalShippingAmount = 0;
    	String shippingAmountSt = "0.00";
//    	if(null != sn.getAttribute(guestCBIndividualPriceInSn)) {
//    		double guestCBIndividualShipPrice = (double) sn.getAttribute(guestCBIndividualPriceInSn);
//    		double guestCBIndividualShipPriceDb = (guestCBIndividualShipPrice/100)*10;
//    		guestTotalShippingAmount = guestTotalShippingAmount + guestCBIndividualShipPriceDb;
//    	}
//    	if(null != sn.getAttribute(guestFTIndividualPriceInSn)) {
//    		double guestFTIndividualShipPrice = (double) sn.getAttribute(guestFTIndividualPriceInSn);
//    		double guestFTIndividualShipPriceDb = (guestFTIndividualShipPrice/100)*10;
//    		guestTotalShippingAmount = guestTotalShippingAmount + guestFTIndividualShipPriceDb;
//    		
//    	}
    	if(guestTotalShippingAmount > 0) {
    		shippingAmountSt = String.format("%.2f", guestTotalShippingAmount);
    	}    	
    	sn.setAttribute(shippingAmountStInSn, shippingAmountSt);   	
    	return guestTotalShippingAmount;
    }

    public double guestRoomFundsHandlingFee(HttpServletRequest req, HttpSession sn) {
    	double guestRoomFundHandling = 0;
    	double guestRoomFundTotalValue = 0.0;
    	String guestToatalRoomFundPaybleAmountSt = null;
    	String guestRoomFundTotalValueSt = null;
    	String guestRoomFundHandlingSt = null;
    	if(null != sn.getAttribute(onlySpaceTotalAmountInSn)) {
    		int guestRoomFundTotValue = (int) sn.getAttribute(onlySpaceTotalAmountInSn);
    		guestRoomFundTotalValue = Double.valueOf(guestRoomFundTotValue);
//    		guestRoomFundHandling = (guestRoomFundTotalValue/100)*2.5;
    		guestRoomFundTotalValueSt = String.format("%.2f", guestRoomFundTotalValue);
    		guestRoomFundHandlingSt = String.format("%.2f", guestRoomFundHandling);
    		double guestTolRoomFundPaybleAmount = guestRoomFundTotalValue + guestRoomFundHandling;
    		guestToatalRoomFundPaybleAmountSt = String.format("%.2f", guestTolRoomFundPaybleAmount);
    	}
    	sn.setAttribute(roomFundHandlingFeeInSn, guestRoomFundHandlingSt);
    	sn.setAttribute(roomFundTotalPriceInSn, guestRoomFundTotalValueSt);
    	sn.setAttribute(totalRoomFundPaybleAmountInSn, guestToatalRoomFundPaybleAmountSt);
    	return guestRoomFundHandling;
    }

    public double guestCashAndCustomFundsHandlingFee(HttpServletRequest req, HttpSession sn) {
    	double guestCashCustomFundHandling = 0;
    	double guestCashFundTotalValue = 0;
    	double guestCustomFundTotalValue = 0;
    	String guestCashCustomFundHandlingSt = null;
    	String guestTotalCashCustomFundPriceSt = null;
    	if(null != sn.getAttribute(guestCashFundTotalValueInSn)) {
    		guestCashFundTotalValue = (double) sn.getAttribute(guestCashFundTotalValueInSn);
    	}
    	if(null != sn.getAttribute(guestCustomFundTotalValueInSn)) {
    		guestCustomFundTotalValue = (double) sn.getAttribute(guestCustomFundTotalValueInSn);
    	}
    	double guestTotalCashCustomFundPrice = guestCashFundTotalValue + guestCustomFundTotalValue;
    	if(guestTotalCashCustomFundPrice > 0) {
    		guestCashCustomFundHandling = (guestTotalCashCustomFundPrice/100)*2.5;
    		guestCashCustomFundHandlingSt = String.format("%.2f", guestCashCustomFundHandling);
    		guestTotalCashCustomFundPriceSt = String.format("%.2f", guestTotalCashCustomFundPrice);
    	}
    	sn.setAttribute(cashCustomFundHandlingFeeInSn, guestCashCustomFundHandlingSt);
    	sn.setAttribute(cashCustomFundTotalAmountInSn, guestTotalCashCustomFundPriceSt);
    	return guestCashCustomFundHandling;
    }

    @Override
    @Transactional
    public ModelAndView regGuestBillingInfoSavingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftMessage = req.getParameter(treasuredGiftMess);    	
    	String totalGuestBillingInfo = null;
    	if(!("").equals(giftMessage) && null != giftMessage) {
    		String guestGiftMessage = giftMessage.replaceAll("[\n\r]", " ");
    		totalGuestBillingInfo = req.getParameter(billNameOnCard) + "__" + req.getParameter(billAddress1) + "__" + req.getParameter(billAddress2) + "__" + req.getParameter(billCity) + "__" + req.getParameter(billState) + "__" + req.getParameter(billZip) + "__" + req.getParameter(billCountry) + "__" + req.getParameter(guestEmail) + "__" + req.getParameter(guestPhNumber) + "__" + req.getParameter(guestUserFullName) + "__" + guestGiftMessage;
    	} else {
    		totalGuestBillingInfo = req.getParameter(billNameOnCard) + "__" + req.getParameter(billAddress1) + "__" + req.getParameter(billAddress2) + "__" + req.getParameter(billCity) + "__" + req.getParameter(billState) + "__" + req.getParameter(billZip) + "__" + req.getParameter(billCountry) + "__" + req.getParameter(guestEmail) + "__" + req.getParameter(guestPhNumber) + "__" + req.getParameter(guestUserFullName);
    	}
//    	float totalTaxPecent = stateTacCaleculation(req.getParameter(billZip), req.getParameter(billCity), req.getParameter(billState));
    	
    	String stateTaxFeeSt = "0.00";
    	double stateTaxFee = guestStateTaxPriceValue(req, sn);
    	if(stateTaxFee > 0) {
    		double totalPayableAmountDb = (double) sn.getAttribute(totalPayableAmountDbInSn);
    		double defaultCouponPrice = guestDefaultCouponPrice(req, sn);
    		double totalPayableAmount = totalPayableAmountDb + stateTaxFee - defaultCouponPrice;
    		String totalPayableAmountSt = String.format("%.2f", totalPayableAmount);
    		sn.setAttribute(totalPayableAmountInSn, totalPayableAmountSt);
    		stateTaxFeeSt = String.format("%.2f", stateTaxFee);
    	}    	
    	sn.setAttribute(stateTaxAmountStInSn, stateTaxFeeSt);
    	sn.setAttribute(totalPayableAmountIncTaxInSn, stateTaxFee);
    	mav = new ModelAndView(guestReviewAndPlaceOrderRed);
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	mav.addObject(billNameOnCard, req.getParameter(billNameOnCard));
    	mav.addObject(billAddress1, req.getParameter(billAddress1));
    	mav.addObject(billAddress2, req.getParameter(billAddress2));
    	mav.addObject(billCity, req.getParameter(billCity));
    	mav.addObject(billState, req.getParameter(billState));
    	mav.addObject(billZip, req.getParameter(billZip));
    	mav.addObject(billCountry, req.getParameter(billCountry));
    	mav.addObject(guestEmail, req.getParameter(guestEmail));
    	mav.addObject(guestPhNumber, req.getParameter(guestPhNumber));
    	mav.addObject(guestUserFullName, req.getParameter(guestUserFullName));
    	mav.addObject(treasuredGiftMess, giftMessage);
    	sn.setAttribute(totalGuestBillingInfoInSn, totalGuestBillingInfo);
    	mav.addObject(totalPayableAmountInSn, sn.getAttribute(totalPayableAmountInSn));
    	mav.addObject(totalFundsAmountInSn, sn.getAttribute(totalFundsAmountInSn));
    	mav.addObject(totalHandlingFeesInSn, sn.getAttribute(totalHandlingFeesInSn));
    	mav.addObject(shippingAmount, sn.getAttribute(shippingAmountStInSn));
    	mav.addObject(stateTaxAmount, stateTaxFeeSt);
    	return mav;
    }

    public float stateTacCaleculation(String zipCode, String cityName, String stateName) {
    	float totalTaxPecent = 0;
    	Taxjar client = new Taxjar("593fe642f9069f0c1c02464b104f9347");
    	try {    		
            RateResponse res = client.ratesForLocation(zipCode);
            float staterate = res.rate.getStateRate();
            float city = res.rate.getCityRate();
            float country = res.rate.getCountryRate();
            float distRate = res.rate.getCombinedDistrictRate();
            totalTaxPecent = staterate + city + distRate + country;
        } catch (TaxjarException e) {
            e.printStackTrace();
        }
    	return totalTaxPecent;
    }

    @Override
    @Transactional
    public ModelAndView regGuestPaymentInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView(guestRegistryPaymentInfoRed);    	
    	mav.addObject(totalGuestBillingInfoInSn,  sn.getAttribute(totalGuestBillingInfoInSn));
    	sn.setAttribute(totalPayableAmountSt, sn.getAttribute(totalPayableAmountInSn));    	
    	sn.setAttribute(guestRoomFundsPaymentInfoInSn, null);
    	sn.setAttribute(guestCashFundsPaymentInfoInSn, null);
    	sn.setAttribute(guestCustomFundsPaymentInfoInSn, null);
    	sn.setAttribute(guestCBContributedPaymentInfoInSn, null);
    	sn.setAttribute(guestCBIndividualPaymentInfoInSn, null);    	
    	mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));    	
    	return mav;
    }

	@Override
    @Transactional
    public ModelAndView guestCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
        String nameOnCard1 = req.getParameter(nameOnCard);
        long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
    	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear);
    	Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
    	String amount = (String) sn.getAttribute(totalPayableAmountInSn);    	
    	String totalGuestBillingInfo = (String) sn.getAttribute(totalGuestBillingInfoInSn);
    	String totalGuestBillingInfoSt[] = totalGuestBillingInfo.split("__");
    	String fullName = totalGuestBillingInfoSt[0];    	
    	String cityName = totalGuestBillingInfoSt[3];
    	String stateName = totalGuestBillingInfoSt[4];
    	String zipCode = totalGuestBillingInfoSt[5];    	
    	String emailAddress = totalGuestBillingInfoSt[7];
    	String totalGuestBillingInfoSt11 = null;
    	if(totalGuestBillingInfoSt.length > 10) { 
    		totalGuestBillingInfoSt11 = totalGuestBillingInfoSt[10];
    	} 
    	String fullAddress = totalGuestBillingInfoSt[1] + " " + totalGuestBillingInfoSt[2];    	     
        String paymentReturnTypeReff = registryPaymentGatewayService.totalPaymentInfoSendToAuthorizeNetGateway(req, sn, amount, cardNumber, expirationDate, cardCode, fullName, emailAddress, fullAddress, cityName, stateName, zipCode);
        long transactionNumber = (Long) sn.getAttribute(transactionNumberInSn);
        String accountType = (String) sn.getAttribute(accountTypeInSn);
        String authorizationCode = (String) sn.getAttribute(authorizationCodeInSn);        
        Timestamp currentDate = currentDate();
    	if(("This transaction has been approved.").equals(paymentReturnTypeReff)) {
    		sn.setAttribute(guestRoomFundsPaymentInfoInSn, sn.getAttribute(guestRoomFundsCartInfoInSn));
    		sn.setAttribute(guestCashFundsPaymentInfoInSn, sn.getAttribute(guestCashFundContValueInSn));
    		sn.setAttribute(guestCustomFundsPaymentInfoInSn, sn.getAttribute(guestCustomFundContValueInSn));
    		sn.setAttribute(guestCBContributedPaymentInfoInSn, sn.getAttribute(guestCBContributedCartValueInSn));
    		sn.setAttribute(guestCBIndividualPaymentInfoInSn, sn.getAttribute(guestCBIndividualCartValueInSn));
    		allGuestUserPaymentInformationUpdateInDB(req, sn, cardNumber, accountType, expirationDate, cardCode, paymentReturnTypeReff, nameOnCard1, totalGuestBillingInfoSt[0], totalGuestBillingInfoSt[1], totalGuestBillingInfoSt[2], totalGuestBillingInfoSt[3], totalGuestBillingInfoSt[4], totalGuestBillingInfoSt[5], totalGuestBillingInfoSt[6], totalGuestBillingInfoSt[7], totalGuestBillingInfoSt[8], totalGuestBillingInfoSt[9], totalGuestBillingInfoSt11, authorizationCode, transactionNumber, amount, currentDate);
    		mav = new ModelAndView(guestPaymentSuccessRed);
    		mav.addObject(paymentOrderNumber, transactionNumber);
    		sn.setAttribute(totalPaybleAmountForEmailInSn, amount);
    	} else {
    		mav = new ModelAndView(guestRegistryPaymentInfoRed);    	
        	mav.addObject(totalGuestBillingInfoInSn,  sn.getAttribute(totalGuestBillingInfoInSn));
        	sn.setAttribute(totalPayableAmountSt, amount);            	 	
		    mav.addObject(payCardNumber, req.getParameter(payCardNumber));
		    mav.addObject(payExpMonth, req.getParameter(payExpMonth));
		    mav.addObject(payExpYear, req.getParameter(payExpYear));
		    mav.addObject(nameOnCard, req.getParameter(nameOnCard));
		    mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
		    mav.addObject(paymentValStatus, "Payment Fail");
		    mav.addObject(paymentReturnStatus, paymentReturnTypeReff);
		    mav.addObject(totalCartItems, sn.getAttribute(cartCountInSn));
    	}
        return mav;
    }
	
//	Room And Cash Fund Payment Info Saving	
	public String allGuestUserPaymentInformationUpdateInDB(HttpServletRequest req, HttpSession sn, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String totalGuestBillingInfoSt1, String totalGuestBillingInfoSt2, String totalGuestBillingInfoSt3, String totalGuestBillingInfoSt4, String totalGuestBillingInfoSt5, String totalGuestBillingInfoSt6, String totalGuestBillingInfoSt7, String totalGuestBillingInfoSt8, String totalGuestBillingInfoSt9, String totalGuestBillingInfoSt10, String totalGuestBillingInfoSt11, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate) {
		String allGuestUserPymentReffVal = null;
        guestUserPaymentInformationSaving(req, sn, cardNumber, accountType, expirationDate, cardCode, returnType, nameOnCard1, totalGuestBillingInfoSt1, totalGuestBillingInfoSt2, totalGuestBillingInfoSt3, totalGuestBillingInfoSt4, totalGuestBillingInfoSt5, totalGuestBillingInfoSt6, totalGuestBillingInfoSt7, totalGuestBillingInfoSt8, totalGuestBillingInfoSt9, totalGuestBillingInfoSt10, totalGuestBillingInfoSt11, authorizationCode, transactionNumber, amount, currentDate);
        guestRoomFundPaymentInfoSaving(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestRegistryCashFundInfoSaveInDBMainTable(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestRegistryCustomFundInfoSaveInDBMainTable(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestCBContributedPaymentInfoSavingInDataBase(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestCBIndividualPaymentInfoSavingInDataBase(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestFTContributedPaymentInfoSavingInDataBase(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestFTIndividualPaymentInfoSavingInDataBase(req, sn, returnType, totalGuestBillingInfoSt8, amount, currentDate);
		guestAndRegistryBothAllPricesListSeparation(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
		guestUserPutNullValuesAfterPayment(req, sn);
        return allGuestUserPymentReffVal;
    }

//	Room And Cash Fund Payment Info Saving	
    public String guestUserPaymentInformationSaving(HttpServletRequest req, HttpSession sn, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String totalGuestBillingInfoSt1, String totalGuestBillingInfoSt2, String totalGuestBillingInfoSt3, String totalGuestBillingInfoSt4, String totalGuestBillingInfoSt5, String totalGuestBillingInfoSt6, String totalGuestBillingInfoSt7, String totalGuestBillingInfoSt8, String totalGuestBillingInfoSt9, String totalGuestBillingInfoSt10, String totalGuestBillingInfoSt11, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate) {
        String pymentReffVal = null;
        GuestUserPaymentInfoSaving guestPaymentSavingModel = new GuestUserPaymentInfoSaving();
        guestPaymentSavingModel.setRegistrantUserId((Long) sn.getAttribute(guestRegistrantUserIdInSn));
    	String accCardNumber = Long.toString(cardNumber);
    	guestPaymentSavingModel.setPayCardNumber(accCardNumber);
    	guestPaymentSavingModel.setAccountType(accountType);
    	guestPaymentSavingModel.setPayExpDate(expirationDate);
    	String cvvNum = Integer.toString(cardCode);
    	guestPaymentSavingModel.setPayCvvNumber(cvvNum);
    	guestPaymentSavingModel.setCheckoutPaymentStatus(returnType);
    	guestPaymentSavingModel.setNameOnCard(nameOnCard1);        	
    	guestPaymentSavingModel.setBillFullName(totalGuestBillingInfoSt1);
    	guestPaymentSavingModel.setBillAddress1(totalGuestBillingInfoSt2);
    	guestPaymentSavingModel.setBillAddress2(totalGuestBillingInfoSt3);
    	guestPaymentSavingModel.setBillCity(totalGuestBillingInfoSt4);
    	guestPaymentSavingModel.setBillState(totalGuestBillingInfoSt5);
    	guestPaymentSavingModel.setBillZip(totalGuestBillingInfoSt6);
    	guestPaymentSavingModel.setBillCountry(totalGuestBillingInfoSt7);
    	guestPaymentSavingModel.setGuestEmail(totalGuestBillingInfoSt8);
    	guestPaymentSavingModel.setBillPhNumber(totalGuestBillingInfoSt9);
    	guestPaymentSavingModel.setGuestUserFullName(totalGuestBillingInfoSt10);
    	guestPaymentSavingModel.setGuestMessage(totalGuestBillingInfoSt11);
    	guestPaymentSavingModel.setAuthorizationCode(authorizationCode);
    	guestPaymentSavingModel.setTransactionNumber(transactionNumber);
    	guestPaymentSavingModel.setTotalAmount(amount);        	
    	guestPaymentSavingModel.setCreatedDate(currentDate);
    	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    	guestPaymentSavingModel.setCreatedDateInSt(todayDate);
    	String totalConceptBoardAmount = totalConceptBoardPaymentAmount(req, sn);
    	guestPaymentSavingModel.setConceptBoardsPrice(totalConceptBoardAmount);
    	String totalFinishingTouchesAmount = totaltFinishingTouchesPaymentAmount(req, sn);
    	guestPaymentSavingModel.setFinishingTouchesPrice(totalFinishingTouchesAmount);
    	guestPaymentSavingModel.setShippingFee((String) sn.getAttribute(shippingAmountStInSn));
    	guestPaymentSavingModel.setTaxFee((String) sn.getAttribute(stateTaxAmountStInSn));
    	guestPaymentSavingModel.setRoomFundsPrice((String) sn.getAttribute(roomFundTotalPriceInSn));
    	guestPaymentSavingModel.setCashFundsPrice((String) sn.getAttribute(cashCustomFundTotalAmountInSn));
    	guestPaymentSavingModel.setTotalHandlingFee((String) sn.getAttribute(totalHandlingFeesInSn));
    	if(null != sn.getAttribute(defaultCouponPriceInSn)) {
    		String defaultCouponPriceSt = String.format("%.2f", sn.getAttribute(defaultCouponPriceInSn));
    		guestPaymentSavingModel.setDefaultCouponPrice(defaultCouponPriceSt);
    	}
    	guestUserPaymentInfoSavingDAO.save(guestPaymentSavingModel);
    	long guestUserPaymentInfoSavingId = guestPaymentSavingModel.getGuestUserPaymentInfoSavingId();
    	sn.setAttribute(guestUserPaymentInfoSavingIdInSn, guestUserPaymentInfoSavingId);
    	guestCartPaymentEmailSendingToGuest(req, sn, totalGuestBillingInfoSt8, totalGuestBillingInfoSt10, transactionNumber, (String) sn.getAttribute(shippingAmountStInSn), (String) sn.getAttribute(stateTaxAmountStInSn), amount, (String) sn.getAttribute(totalHandlingFeesInSn));
    	guestCartPaymentEmailSendingToRegistrant(req, sn, totalGuestBillingInfoSt10, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        return pymentReffVal;
    }
    
    public String totalConceptBoardPaymentAmount(HttpServletRequest req, HttpSession sn) {
    	String totalConceptBoardAmount = null;
    	double guestCBContributedPriceDb = 0;
    	double guestCBIndividualPriceDb = 0;
	    if(null != sn.getAttribute(guestCBContributedPriceInSn)) {
	    	guestCBContributedPriceDb = (double) sn.getAttribute(guestCBContributedPriceInSn);
	    }
		if(null != sn.getAttribute(guestCBIndividualPriceInSn)) {
			guestCBIndividualPriceDb = (double) sn.getAttribute(guestCBIndividualPriceInSn);
	    }
		double conceptBoardsTotalAmountDb = guestCBContributedPriceDb + guestCBIndividualPriceDb;
		totalConceptBoardAmount = String.format("%.2f", conceptBoardsTotalAmountDb);
		return totalConceptBoardAmount;
    }

    public String totaltFinishingTouchesPaymentAmount(HttpServletRequest req, HttpSession sn) {
    	String totaltFinishingTouchesAmount = null;
    	double guestFTContributedPriceDb = 0;
    	double guestFTIndividualPriceDb = 0;
	    if(null != sn.getAttribute(guestFTContributedPriceInSn)) {
	    	guestFTContributedPriceDb = (double) sn.getAttribute(guestFTContributedPriceInSn);
	    }
		if(null != sn.getAttribute(guestFTIndividualPriceInSn)) {
			guestFTIndividualPriceDb = (double) sn.getAttribute(guestFTIndividualPriceInSn);
	    }
		double conceptBoardsTotalAmountDb = guestFTContributedPriceDb + guestFTIndividualPriceDb;
		totaltFinishingTouchesAmount = String.format("%.2f", conceptBoardsTotalAmountDb);
		return totaltFinishingTouchesAmount;
    }
	
//	Room And Cash Fund Payment Info Saving	
    public String guestRoomFundPaymentInfoSaving(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
    	String roomFundPymentReffVal = null;
    	if(null != sn.getAttribute(guestRoomFundsCartInfoInSn)) {
    		GuestRoomFundPaymentInfoSaving guestPaySavingModel = new GuestRoomFundPaymentInfoSaving();    	
        	guestPaySavingModel.setRegistrantUserId((Long) sn.getAttribute(guestRegistrantUserIdInSn));
	    	guestPaySavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
	    	int totalRoomFundPrice = 0;
	    	if(null != sn.getAttribute(totalRoomFundPriceInSn)) {
	    		totalRoomFundPrice = (Integer) sn.getAttribute(totalRoomFundPriceInSn);	    		
	    	}    	
	    	guestPaySavingModel.setCheckoutPaymentStatus(returnType);    	
	    	guestPaySavingModel.setGuestEmail(totalGuestBillingInfoSt8);    	
	    	guestPaySavingModel.setTotalAmount((String) sn.getAttribute(totalRoomFundPaybleAmountInSn));        	
	    	guestPaySavingModel.setCreatedDate(currentDate);	    	
	    	guestPaySavingModel.setGuestRoomCombValues((String) sn.getAttribute(guestRoomFundsCartInfoInSn));
	    	guestPaySavingModel.setRoomFundsPrice((String) sn.getAttribute(roomFundTotalPriceInSn));
	    	guestPaySavingModel.setSpaceHandlingFee((String) sn.getAttribute(roomFundHandlingFeeInSn));	    	
	    	guestRoomFundPaymentInfoSavingDAO.save(guestPaySavingModel);
	    	double roomCashFundPriceDb = 0;
    		if(totalRoomFundPrice > 0) {
    			roomCashFundPriceDb = Double.valueOf(totalRoomFundPrice);
    		}
    		guestCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn), roomCashFundPriceDb);
    		registryRoomFundInfoDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
    	}        
        return roomFundPymentReffVal;
    }
   
    public String guestCustomGiftCardGenerationForRegistrant(HttpServletRequest req, HttpSession sn, long registrantUserId, double roomTotGiftAmount) {
    	String roomFundCustomGCGReffVal = null;
    	Timestamp currentDate = currentDate();    	
    	List<RegistrantCustomGiftCardCodeSaving> regCustomGiftCardCodeList =  registrantCustomGiftCardCodeSavingDAO.selectedGiftCardCodeRowIdVerification(registrantUserId);
    	if (regCustomGiftCardCodeList.isEmpty()) {    		
    		String alphaNumerics = "AB1C9DE8FG7H6IJ5KL4MNP3QRST0UVWX2YZ";
            String codeGen= "";
            for (int i = 0; i < 8; i++) {
            	codeGen += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
            }
            String giftCardCode = codeGen;
            double usedCredit = 0;
    		RegistrantCustomGiftCardCodeSaving regCustomGiftCardCodeModel = new RegistrantCustomGiftCardCodeSaving();
    		regCustomGiftCardCodeModel.setRegistrantUserId(registrantUserId);
    		regCustomGiftCardCodeModel.setGiftCardCode(giftCardCode);
    		regCustomGiftCardCodeModel.setTotalCredit(roomTotGiftAmount);
    		regCustomGiftCardCodeModel.setRemainingCredit(roomTotGiftAmount);
    		regCustomGiftCardCodeModel.setUsedCredit(usedCredit);
    		regCustomGiftCardCodeModel.setCreatedDate(currentDate);
    		registrantCustomGiftCardCodeSavingDAO.save(regCustomGiftCardCodeModel);
    	} else {
    		RegistrantCustomGiftCardCodeSaving regCustomGiftCardCodeSavingModel = registrantCustomGiftCardCodeSavingDAO.updatedGiftCardCodeRowInDataBasa(registrantUserId);
    		double totalCredit = regCustomGiftCardCodeSavingModel.getTotalCredit();
    		double remCredit = regCustomGiftCardCodeSavingModel.getRemainingCredit();
    		double allTotCredit = totalCredit + roomTotGiftAmount;
    		double allTotRemCredit = remCredit + roomTotGiftAmount;
    		regCustomGiftCardCodeSavingModel.setTotalCredit(allTotCredit);
    		regCustomGiftCardCodeSavingModel.setRemainingCredit(allTotRemCredit);
    		regCustomGiftCardCodeSavingModel.setUpdatedDate(currentDate);
    		registrantCustomGiftCardCodeSavingDAO.merge(regCustomGiftCardCodeSavingModel);
    	} 	   	
 	   	return roomFundCustomGCGReffVal;
    }
    
    public String guestRegistryCashFundInfoSaveInDBMainTable(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
    	String cashFundPymentReffVal = null;
    	String guestCashFundContSnValue = (String) sn.getAttribute(guestCashFundContValueInSn);
    	if(null != guestCashFundContSnValue) {
    		String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
    		for(int i=0; i<guestCashFundContrSnValue.length; i++) {
    			String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");
    			long regCashFundsInfoSavingId = Long.parseLong(guestCashFundsListSt[0]);
		    	long registrantUserId = (Long) sn.getAttribute(guestRegistrantUserIdInSn);		    	
		    	GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaySavingModel = new GuestRegistryCashFundsPaymentInfoSaving();
		    	guestCashFundPaySavingModel.setRegistrantUserId(registrantUserId);
		    	guestCashFundPaySavingModel.setRegistryCashFundsInfoSavingId(regCashFundsInfoSavingId);
		    	guestCashFundPaySavingModel.setCashFundName(guestCashFundsListSt[2]);
		    	guestCashFundPaySavingModel.setContributedCashFundPrice(guestCashFundsListSt[3]);
		    	guestCashFundPaySavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
		    	guestCashFundPaySavingModel.setCheckoutPaymentStatus(returnType);    	
		    	guestCashFundPaySavingModel.setGuestEmail(totalGuestBillingInfoSt8);
		    	guestCashFundPaySavingModel.setCashFundStatus("Funds Pending");
		    	double cashFundsContributedAmount = Double.parseDouble(guestCashFundsListSt[3]);
		    	double guestCashCustomFundHandling = (cashFundsContributedAmount/100)*2.5;
	    		String guestCashCustomFundHandlingSt = String.format("%.2f", guestCashCustomFundHandling);
	    		guestCashFundPaySavingModel.setCashFundHandlingFee(guestCashCustomFundHandlingSt);
		    	guestCashFundPaySavingModel.setCreatedDate(currentDate);
		    	guestCashFundPaySavingModel.setRefferanceDate(currentDate);
		    	guestRegistryCashFundsPaymentInfoSavingDAO.save(guestCashFundPaySavingModel);		    	    	
				RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsValuesUpdateInDB(registrantUserId, regCashFundsInfoSavingId);
				double cashFundOrgReqAmount = 0;
				if(null != registryCashFundsInfoModel.getCashFundReqAmount()) {
					cashFundOrgReqAmount = Double.parseDouble(registryCashFundsInfoModel.getCashFundReqAmount());
				}
				double cashFundOrgContrAmount = 0;
				if(null != registryCashFundsInfoModel.getTotalContributedAmount()) {
					cashFundOrgContrAmount = Double.parseDouble(registryCashFundsInfoModel.getTotalContributedAmount());
				}
				double cashFundTotalCont = cashFundOrgContrAmount + cashFundsContributedAmount;
				double cashFundRemainAmount = cashFundOrgReqAmount - cashFundTotalCont;
				String cashFundTotalContribute = String.format("%.2f", cashFundTotalCont);
				String cashFundRemainingAmount = String.format("%.2f", cashFundRemainAmount);
				registryCashFundsInfoModel.setTotalContributedAmount(cashFundTotalContribute);
				registryCashFundsInfoModel.setRemainingAmount(cashFundRemainingAmount);
				registryCashFundsInfoSavingDAO.merge(registryCashFundsInfoModel);				
    		}
    		registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
    	}
    	return cashFundPymentReffVal;
    }

    public String guestRegistryCustomFundInfoSaveInDBMainTable(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
    	String cashFundPymentReffVal = null;
    	String guestCashFundContSnValue = (String) sn.getAttribute(guestCustomFundContValueInSn);
    	if(null != guestCashFundContSnValue) {
    		String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
    		for(int i=0; i<guestCashFundContrSnValue.length; i++) {
    			String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");
    			long regCashFundsInfoSavingId = Long.parseLong(guestCashFundsListSt[0]);
		    	long registrantUserId = (Long) sn.getAttribute(guestRegistrantUserIdInSn);		    	
		    	GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaySavingModel = new GuestRegistryCashFundsPaymentInfoSaving();
		    	guestCashFundPaySavingModel.setRegistrantUserId(registrantUserId);
		    	guestCashFundPaySavingModel.setRegistryCashFundsInfoSavingId(regCashFundsInfoSavingId);
		    	guestCashFundPaySavingModel.setCashFundName(guestCashFundsListSt[2]);
		    	guestCashFundPaySavingModel.setContributedCashFundPrice(guestCashFundsListSt[3]);
		    	guestCashFundPaySavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
		    	guestCashFundPaySavingModel.setCheckoutPaymentStatus(returnType);    	
		    	guestCashFundPaySavingModel.setGuestEmail(totalGuestBillingInfoSt8);
		    	guestCashFundPaySavingModel.setCashFundStatus("Funds Pending");
		    	double cashFundsContributedAmount = Double.parseDouble(guestCashFundsListSt[3]);
		    	double guestCashCustomFundHandling = (cashFundsContributedAmount/100)*2.5;
	    		String guestCashCustomFundHandlingSt = String.format("%.2f", guestCashCustomFundHandling);
		    	guestCashFundPaySavingModel.setCashFundHandlingFee(guestCashCustomFundHandlingSt);
		    	guestCashFundPaySavingModel.setCreatedDate(currentDate);
		    	guestCashFundPaySavingModel.setRefferanceDate(currentDate);
		    	guestRegistryCashFundsPaymentInfoSavingDAO.save(guestCashFundPaySavingModel);		    	    	
				RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsValuesUpdateInDB(registrantUserId, regCashFundsInfoSavingId);
				double cashFundOrgReqAmount = 0;
				if(null != registryCashFundsInfoModel.getCashFundReqAmount()) {
					cashFundOrgReqAmount = Double.parseDouble(registryCashFundsInfoModel.getCashFundReqAmount());
				}
				double cashFundOrgContrAmount = 0;
				if(null != registryCashFundsInfoModel.getTotalContributedAmount()) {
					cashFundOrgContrAmount = Double.parseDouble(registryCashFundsInfoModel.getTotalContributedAmount());
				}
				double cashFundTotalCont = cashFundOrgContrAmount + cashFundsContributedAmount;
				double cashFundRemainAmount = cashFundOrgReqAmount - cashFundTotalCont;
				String cashFundTotalContribute = String.format("%.2f", cashFundTotalCont);
				String cashFundRemainingAmount = String.format("%.2f", cashFundRemainAmount);
				registryCashFundsInfoModel.setTotalContributedAmount(cashFundTotalContribute);
				registryCashFundsInfoModel.setRemainingAmount(cashFundRemainingAmount);
				registryCashFundsInfoSavingDAO.merge(registryCashFundsInfoModel);				
    		}
    		registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
    	}
    	return cashFundPymentReffVal;
    }

//	Design Curated Concept Boards Contribute Fund Payment Info Saving	
	public String guestCBContributedPaymentInfoSavingInDataBase(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
		String dsnConBoardsContReffVal = null;
        String guestConceptBoardContSnValue = (String) sn.getAttribute(guestCBContributedCartValueInSn);
        if(null != guestConceptBoardContSnValue) {
        	String[] guestConceptBoardContValueInSt = guestConceptBoardContSnValue.split("__");
        	for(int i=0; i<guestConceptBoardContValueInSt.length; i++) {
        		String[] guestConceptBoardContProdIdSt = guestConceptBoardContValueInSt[i].split("_,_");
        		long regConBoardProductSavingId = Long.parseLong(guestConceptBoardContProdIdSt[0]);        		
        		GuestConceptBoardsContributedPaymentSaving guestCBContributedPaymentSavingModel = new GuestConceptBoardsContributedPaymentSaving();
        		guestCBContributedPaymentSavingModel.setRegistrantConceptBoardsContributedProductsInfoSavingId(regConBoardProductSavingId);
        		guestCBContributedPaymentSavingModel.setRegistrantUserId((Long) sn.getAttribute(guestRegistrantUserIdInSn));
        		guestCBContributedPaymentSavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
        		guestCBContributedPaymentSavingModel.setCheckoutPaymentStatus(returnType);
        		guestCBContributedPaymentSavingModel.setContributedPrice(guestConceptBoardContProdIdSt[1]);
        		guestCBContributedPaymentSavingModel.setCreatedDate(currentDate);
        		guestCBContributedPaymentSavingModel.setContributedStatus(noActionStatsRef);
        		guestCBContributedPaymentSavingModel.setRefferanceDate(currentDate);
        		guestConceptBoardsContributedPaymentSavingDAO.save(guestCBContributedPaymentSavingModel);            	
        		regCBContributedProductsInfoUpdateInTable(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn), regConBoardProductSavingId, guestConceptBoardContProdIdSt[1]);            	
        	}
        	registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        	registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        }
        return dsnConBoardsContReffVal;
    }

    public String regCBContributedProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductsInfoSavingId, String ContributedPrice) {
    	String cbContributedPriceValue = null;
    	Timestamp currentDate = currentDate();
    	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedProductsInfoModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB(registrantUserId, cbContributedProductsInfoSavingId);
    	double cbContributedRemaingPriceDb = 0;
    	if(null != regCBContributedProductsInfoModel.getRemainingTotalPrice()) {
    		cbContributedRemaingPriceDb = Double.parseDouble(regCBContributedProductsInfoModel.getRemainingTotalPrice());
    	}
    	double regCBContributedAmountDb = Double.parseDouble(ContributedPrice);
    	double totalRemaingPriceDb = cbContributedRemaingPriceDb - regCBContributedAmountDb;
    	String totalRemaingPriceSt = String.format("%.2f", totalRemaingPriceDb);
    	regCBContributedProductsInfoModel.setRemainingTotalPrice(totalRemaingPriceSt);
    	regCBContributedProductsInfoModel.setUpdatedDate(currentDate);
    	String noActionStatusSt = regCBContributedProductsInfoModel.getContributedStatus();    	
    	if(null == noActionStatusSt) {
			regCBContributedProductsInfoModel.setContributedStatus(noActionStatsRef);
		}    	
    	registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedProductsInfoModel);
        return cbContributedPriceValue;
    }

//	Design Curated Concept Boards Fund Payment Info Saving	
    public String guestCBIndividualPaymentInfoSavingInDataBase(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
		String dsnConceptBoardsReffVal = null;
        String guestConceptBoardsSnValue = (String) sn.getAttribute(guestCBIndividualCartValueInSn);
        if(null != guestConceptBoardsSnValue) {
        	String[] guestConceptBoardsValueInSt = guestConceptBoardsSnValue.split("__");
        	for(int i=0; i<guestConceptBoardsValueInSt.length; i++) {
        		String[] guestConceptBoardProdIdSt = guestConceptBoardsValueInSt[i].split("_,_");    		
        		long cbIndividualProductsInfoSavingId = Long.parseLong(guestConceptBoardProdIdSt[0]);        		
        		int guestQuantityInt = Integer.parseInt(guestConceptBoardProdIdSt[1]);
        		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = new GuestConceptBoardsIndividualPaymentSaving();
        		guestCBIndividualPaymentSavingModel.setRegistrantConceptBoardsIndividualProductsInfoSavingId(cbIndividualProductsInfoSavingId);
        		guestCBIndividualPaymentSavingModel.setRegistrantUserId((Long) sn.getAttribute(guestRegistrantUserIdInSn)); 
        		guestCBIndividualPaymentSavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
        		guestCBIndividualPaymentSavingModel.setCheckoutPaymentStatus(returnType);
        		guestCBIndividualPaymentSavingModel.setGiftedQuantity(guestQuantityInt);
            	guestCBIndividualPaymentSavingModel.setCreatedDate(currentDate); 
            	guestCBIndividualPaymentSavingModel.setIndividualStatus(noActionStatsRef);
            	guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
            	guestConceptBoardsIndividualPaymentSavingDAO.save(guestCBIndividualPaymentSavingModel);            	
            	regCBIndividualProductsInfoUpdateInTable(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn), cbIndividualProductsInfoSavingId, guestQuantityInt);
        	}
        	registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        	registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        }
        return dsnConceptBoardsReffVal;
    }

    public String regCBIndividualProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualProductsInfoSavingId, int guestQuantityInt) {
    	String cbIndividualQuantity = null;
    	Timestamp currentDate = currentDate();    	
    	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductsInfoModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(registrantUserId, cbIndividualProductsInfoSavingId);
    	int cbIndividualRemainingQuantity = regCBIndividualProductsInfoModel.getRemainingQuantity();
    	int totalIndividualRemainingQuantity = cbIndividualRemainingQuantity - guestQuantityInt;
    	regCBIndividualProductsInfoModel.setRemainingQuantity(totalIndividualRemainingQuantity);
    	regCBIndividualProductsInfoModel.setUpdatedDate(currentDate);
    	registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualProductsInfoModel);        	
    	return cbIndividualQuantity;
    }

//	Design Curated Finishing Touches Contribute Fund Payment Info Saving	
	public String guestFTContributedPaymentInfoSavingInDataBase(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
		String dsnFinTouchesContReffVal = null;
        String guestFinishingTouchesContSnValue = (String) sn.getAttribute(guestFTContributedCartValueInSn);
        if(null != guestFinishingTouchesContSnValue) {
        	String[] guestFinishingTouchesContValueInSt = guestFinishingTouchesContSnValue.split("__");
        	for(int i=0; i<guestFinishingTouchesContValueInSt.length; i++) {
        		String[] guestFinishingTouchesContProdIdSt = guestFinishingTouchesContValueInSt[i].split("_,_");
        		long regFinTouchesProductSavingId = Long.parseLong(guestFinishingTouchesContProdIdSt[0]);        		
        		GuestFinishingTouchesContributedPaymentSaving guestFTContributedPaymentSavingModel = new GuestFinishingTouchesContributedPaymentSaving();
        		guestFTContributedPaymentSavingModel.setRegistrantFinishingTouchesContributedProductsInfoSavingId(regFinTouchesProductSavingId);
        		guestFTContributedPaymentSavingModel.setRegistrantUserId((Long) sn.getAttribute(guestRegistrantUserIdInSn));
        		guestFTContributedPaymentSavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
        		guestFTContributedPaymentSavingModel.setCheckoutPaymentStatus(returnType);
        		guestFTContributedPaymentSavingModel.setContributedPrice(guestFinishingTouchesContProdIdSt[1]);
        		guestFTContributedPaymentSavingModel.setCreatedDate(currentDate);
        		guestFTContributedPaymentSavingModel.setContributedStatus(noActionStatsRef);
        		guestFTContributedPaymentSavingModel.setRefferanceDate(currentDate);
        		guestFinishingTouchesContributedPaymentSavingDAO.save(guestFTContributedPaymentSavingModel);            	
        		regFTContributedProductsInfoUpdateInTable(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn), regFinTouchesProductSavingId, guestFinishingTouchesContProdIdSt[1]);            	
        	}
        	registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        	registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        }
        return dsnFinTouchesContReffVal;
    }

    public String regFTContributedProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftContributedProductsInfoSavingId, String ContributedPrice) {
    	String ftContributedPriceValue = null;
    	Timestamp currentDate = currentDate();
    	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedProductsInfoModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB(registrantUserId, ftContributedProductsInfoSavingId);
    	double ftContributedRemaingPriceDb = 0;
    	if(null != regFTContributedProductsInfoModel.getRemainingTotalPrice()) {
    		ftContributedRemaingPriceDb = Double.parseDouble(regFTContributedProductsInfoModel.getRemainingTotalPrice());
    	}
    	double regFTContributedAmountDb = Double.parseDouble(ContributedPrice);
    	double totalRemaingPriceDb = ftContributedRemaingPriceDb - regFTContributedAmountDb;
    	String totalRemaingPriceSt = String.format("%.2f", totalRemaingPriceDb);
    	regFTContributedProductsInfoModel.setRemainingTotalPrice(totalRemaingPriceSt);
    	regFTContributedProductsInfoModel.setUpdatedDate(currentDate);
    	String noActionStatusSt = regFTContributedProductsInfoModel.getContributedStatus();    	
    	if(null == noActionStatusSt) {
			regFTContributedProductsInfoModel.setContributedStatus(noActionStatsRef);
		}    	
    	registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedProductsInfoModel);
        return ftContributedPriceValue;
    }

//	Design Curated Finishing Touches Fund Payment Info Saving	
    public String guestFTIndividualPaymentInfoSavingInDataBase(HttpServletRequest req, HttpSession sn, String returnType, String totalGuestBillingInfoSt8, String amount, Timestamp currentDate) {
		String dsnFinishingTouchesReffVal = null;
        String guestFinishingTouchesSnValue = (String) sn.getAttribute(guestFTIndividualCartValueInSn);
        if(null != guestFinishingTouchesSnValue) {
        	String[] guestFinishingTouchesValueInSt = guestFinishingTouchesSnValue.split("__");
        	for(int i=0; i<guestFinishingTouchesValueInSt.length; i++) {
        		String[] guestFinishingTouchesProdIdSt = guestFinishingTouchesValueInSt[i].split("_,_");    		
        		long ftIndividualProductsInfoSavingId = Long.parseLong(guestFinishingTouchesProdIdSt[0]);        		
        		int guestQuantityInt = Integer.parseInt(guestFinishingTouchesProdIdSt[1]);
        		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = new GuestFinishingTouchesIndividualPaymentSaving();
        		guestFTIndividualPaymentSavingModel.setRegistrantFinishingTouchesIndividualProductsInfoSavingId(ftIndividualProductsInfoSavingId);
        		guestFTIndividualPaymentSavingModel.setRegistrantUserId((Long) sn.getAttribute(guestRegistrantUserIdInSn)); 
        		guestFTIndividualPaymentSavingModel.setGuestUserPaymentInfoSavingId((Long) sn.getAttribute(guestUserPaymentInfoSavingIdInSn));
        		guestFTIndividualPaymentSavingModel.setCheckoutPaymentStatus(returnType);
        		guestFTIndividualPaymentSavingModel.setGiftedQuantity(guestQuantityInt);
            	guestFTIndividualPaymentSavingModel.setCreatedDate(currentDate); 
            	guestFTIndividualPaymentSavingModel.setIndividualStatus(noActionStatsRef);
            	guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
            	guestFinishingTouchesIndividualPaymentSavingDAO.save(guestFTIndividualPaymentSavingModel);            	
            	regFTIndividualProductsInfoUpdateInTable(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn), ftIndividualProductsInfoSavingId, guestQuantityInt);
        	}
        	registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        	registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(guestRegistrantUserIdInSn));
        }
        return dsnFinishingTouchesReffVal;
    }

    public String regFTIndividualProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualProductsInfoSavingId, int guestQuantityInt) {
    	String ftIndividualQuantity = null;
    	Timestamp currentDate = currentDate();    	
    	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductsInfoModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(registrantUserId, ftIndividualProductsInfoSavingId);
    	int ftIndividualRemainingQuantity = regFTIndividualProductsInfoModel.getRemainingQuantity();
    	int totalIndividualRemainingQuantity = ftIndividualRemainingQuantity - guestQuantityInt;
    	regFTIndividualProductsInfoModel.setRemainingQuantity(totalIndividualRemainingQuantity);
    	regFTIndividualProductsInfoModel.setUpdatedDate(currentDate);
    	registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualProductsInfoModel);        	
    	return ftIndividualQuantity;
    }

    public String guestCartPaymentEmailSendingToGuest(HttpServletRequest req, HttpSession sn, String guestUserEmail, String guestFullName, long transactionNumber, String guestTotalShippingAmount, String guestTotalTaxAmount, String guestTotalPayableAmount, String guestTotalHandlingFee) {
    	String shopCartPaymentReff = null;
    	String[] emailList = {guestUserEmail};
        String fCapName = guestFullName.substring(0, 1).toUpperCase() + guestFullName.substring(1);
        String registryUserFullName = (String) sn.getAttribute(registryUserFullNameInSn);
    	String subject = "Your Gift For " + registryUserFullName;           
    	String type = "text/html";           
    	EmailSending userEmail = new EmailSending();
    	String fromAdd = "info@nookandcove.com";              
    	String body1 = "<body>"    				
                    + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                    + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>Thank you for your purchase!</p>"
                    + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                    + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Thank you for your purchase from Nook+Cove! We are sure your gift is going to make " + registryUserFullName + " smile!</p>"                    
                    + "<p style='margin-top: 40px; font: bold 1.05em/1em sans-serif;'>Order Number: " + transactionNumber + "</p>"
                    + "</div>"
                    + "</body> ";    	
    	String body2 = "";
        String cartGuestUserRegInfoSnList = (String) sn.getAttribute(guestRoomFundsCartInfoInSn);
        if(null != cartGuestUserRegInfoSnList) {
        	String singCartRowValueList[] = cartGuestUserRegInfoSnList.split("__");    		
        	for(int i=0; i<singCartRowValueList.length; i++) {    			
        		String singCartColumnValue[] = singCartRowValueList[i].split(",_,");        			      		
		        String bodyRoomFundLoop = "<body>"
		        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
		        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + singCartColumnValue[1] + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + singCartColumnValue[2] + "</p>"
		        		+ "</div>"
		        		+ "</body> ";
		        body2 = body2 + bodyRoomFundLoop;
        	}
		}
        String guestCashFundContSnValue = (String) sn.getAttribute(guestCashFundContValueInSn);
        if(null != guestCashFundContSnValue) {
        	String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
        	for(int i=0; i<guestCashFundContrSnValue.length; i++) {
           		String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");      		
                String bodyCashFundLoop = "<body>"
                		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
                		+ "<p style='font: 1.05em/1em sans-serif;'> " + guestCashFundsListSt[2] + "</p>"
                		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestCashFundsListSt[3] + "</p>"
                		+ "</div>"
                		+ "</body> ";
                body2 = body2 + bodyCashFundLoop;
           	}
        }
        String guestCustomFundContSnValue = (String) sn.getAttribute(guestCustomFundContValueInSn);
        if(null != guestCustomFundContSnValue) {
        	String[] guestCustomFundContrSnValue = guestCustomFundContSnValue.split("__");
        	for(int i=0; i<guestCustomFundContrSnValue.length; i++) {
        		String[] guestCustomFundsListSt = guestCustomFundContrSnValue[i].split("_,_");
		        String bodyCustomFundLoop = "<body>"
		        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
		        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + guestCustomFundsListSt[2] + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestCustomFundsListSt[3] + "</p>"
		        		+ "</div>"
		        		+ "</body> ";
		        body2 = body2 + bodyCustomFundLoop;
        	}
		}		
		String guestConceptBoardContSnValue = (String) sn.getAttribute(guestCBContributedCartValueInSn);
		if(null != guestConceptBoardContSnValue) {
        	String[] guestConceptBoardContValueInSt = guestConceptBoardContSnValue.split("__");
        	for(int i=0; i<guestConceptBoardContValueInSt.length; i++) {
        		String[] guestConceptBoardContProdIdSt = guestConceptBoardContValueInSt[i].split("_,_");
        		long regConBoardProductSavingId = Long.parseLong(guestConceptBoardContProdIdSt[0]);
        		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedProductsInfoModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(regConBoardProductSavingId);
	        String bodyContLoop = "<body>"
	        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
	        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'> " + regCBContributedProductsInfoModel.getProductName() + "</p>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'> " + regCBContributedProductsInfoModel.getProductHeading() + "</p>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestConceptBoardContProdIdSt[1] + "</p>"
	        		+ "</div>"
	        		+ "</body> ";
	        body2 = body2 + bodyContLoop;
        	}
		}
        String guestConceptBoardsSnValue = (String) sn.getAttribute(guestCBIndividualCartValueInSn);
        if(null != guestConceptBoardsSnValue) {
           	String[] guestConceptBoardsValueInSt = guestConceptBoardsSnValue.split("__");
            for(int i=0; i<guestConceptBoardsValueInSt.length; i++) {
            	String[] guestConceptBoardProdIdSt = guestConceptBoardsValueInSt[i].split("_,_");    		
            	long cbIndividualProductsInfoSavingId = Long.parseLong(guestConceptBoardProdIdSt[0]);
            	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductsInfoModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(cbIndividualProductsInfoSavingId);
    	        String bodyIndLoop = "<body>"
    	        	+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
    	        	+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + regCBIndividualProductsInfoModel.getProductName() + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + regCBIndividualProductsInfoModel.getProductHeading() + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'>Quantity: " + guestConceptBoardProdIdSt[1] + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'>$" + regCBIndividualProductsInfoModel.getProductPrice() + "</p>"
    	        	+ "</div>"
    	        	+ "</body> ";
    	        body2 = body2 + bodyIndLoop;
            }
    	}
        String guestFinishingTouchesContSnValue = (String) sn.getAttribute(guestFTContributedCartValueInSn);
		if(null != guestFinishingTouchesContSnValue) {
        	String[] guestFinishingTouchesContValueInSt = guestFinishingTouchesContSnValue.split("__");
        	for(int i=0; i<guestFinishingTouchesContValueInSt.length; i++) {
        		String[] guestFinishingTouchesContProdIdSt = guestFinishingTouchesContValueInSt[i].split("_,_");
        		long regFinTouchesProductSavingId = Long.parseLong(guestFinishingTouchesContProdIdSt[0]);
        		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedProductsInfoModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(regFinTouchesProductSavingId);
	        String bodyContLoop = "<body>"
	        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
	        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'> " + regFTContributedProductsInfoModel.getProductName() + "</p>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'> " + regFTContributedProductsInfoModel.getProductHeading() + "</p>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestFinishingTouchesContProdIdSt[1] + "</p>"
	        		+ "</div>"
	        		+ "</body> ";
	        body2 = body2 + bodyContLoop;
        	}
		}
        String guestFinishingTouchesSnValue = (String) sn.getAttribute(guestFTIndividualCartValueInSn);
        if(null != guestFinishingTouchesSnValue) {
           	String[] guestFinishingTouchesValueInSt = guestFinishingTouchesSnValue.split("__");
            for(int i=0; i<guestFinishingTouchesValueInSt.length; i++) {
            	String[] guestFinishingTouchesProdIdSt = guestFinishingTouchesValueInSt[i].split("_,_");    		
            	long ftIndividualProductsInfoSavingId = Long.parseLong(guestFinishingTouchesProdIdSt[0]);
            	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductsInfoModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(ftIndividualProductsInfoSavingId);
    	        String bodyIndLoop = "<body>"
    	        	+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
    	        	+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + regFTIndividualProductsInfoModel.getProductName() + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + regFTIndividualProductsInfoModel.getProductHeading() + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'>Quantity: " + guestFinishingTouchesProdIdSt[1] + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'>$" + regFTIndividualProductsInfoModel.getProductPrice() + "</p>"
    	        	+ "</div>"
    	        	+ "</body> ";
    	        body2 = body2 + bodyIndLoop;
            }
    	}
		String body3 = "<body>"
					+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
					+ "<div style='margin-top: 10px; border-top: 1px solid black; width: 300px;'></div>"
					+ "<p style='margin-top: 15px; font: 1.05em/1em sans-serif;'>Shipping: $" + guestTotalShippingAmount + "</p>"
					+ "<p style='font: 1.05em/1em sans-serif;'>Tax: $" + guestTotalTaxAmount + "</p>"
					+ "<p style='font: 1.05em/1em sans-serif;'>Handling: $" + guestTotalHandlingFee + "</p>"
					+ "<p style='margin-top: 10px; font: bold 1.05em/1.25em sans-serif;'>Total: $" + guestTotalPayableAmount + "</p>"					
					+ "<p style='margin-top: 40px; font: 1.05em/1.5em sans-serif;'>The recipient(s) have received notification of your gift and all further correspondence regarding the gift will be sent to them.</p>"
					+ "<p style='margin-top: 20px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>Remember, you don't have to create a registry with us to shop our products and designs! Visit us again soon to treat yourself with something beautiful!</p>"
					+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
					+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
                    + "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                    + "</div>"
                    + "</body> ";
		String body =  body1 + body2 + body3;
    	try {
    		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
    	} catch (Exception ex) {
    		LOGGER.error("Guest cart payment email sending to guest failed " + ex);
    	}       
    	return shopCartPaymentReff;
    }

    public String guestCartPaymentEmailSendingToRegistrant(HttpServletRequest req, HttpSession sn, String guestFullName, long registrantUserId) {
    	String shopCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	String regUserEmail = regInfoSavingModel.getRegUserName();
    	String fCapName = regInfoSavingModel.getRegFirstName();
    	String[] emailList = {regUserEmail};        
    	String subject = "A Gift From " + guestFullName + "!";           
    	String type = "text/html";           
    	EmailSending userEmail = new EmailSending();
    	String fromAdd = "info@nookandcove.com";              
    	String body1 = "<body>"    				
                    + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                    + "<p style='margin-top: 0px; font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                    + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>" + guestFullName + " has purchased a gift for you from your registry!</p>"                    
                    + "</div>"
                    + "</body> ";    	
    	String body2 = "";
        String cartGuestUserRegInfoSnList = (String) sn.getAttribute(guestRoomFundsCartInfoInSn);
        if(null != cartGuestUserRegInfoSnList) {
        	String singCartRowValueList[] = cartGuestUserRegInfoSnList.split("__");    		
        	for(int i=0; i<singCartRowValueList.length; i++) {    			
        		String singCartColumnValue[] = singCartRowValueList[i].split(",_,");        			      		
		        String bodyRoomFundLoop = "<body>"
		        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
		        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + singCartColumnValue[1] + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + singCartColumnValue[2] + "</p>"
		        		+ "</div>"
		        		+ "</body> ";
		        body2 = body2 + bodyRoomFundLoop;
        	}
		}
        String guestCashFundContSnValue = (String) sn.getAttribute(guestCashFundContValueInSn);
        if(null != guestCashFundContSnValue) {
        	String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
        	for(int i=0; i<guestCashFundContrSnValue.length; i++) {
           		String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");      		
                String bodyCashFundLoop = "<body>"
                		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
                		+ "<p style='font: 1.05em/1em sans-serif;'> " + guestCashFundsListSt[2] + "</p>"
                		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestCashFundsListSt[3] + "</p>"
                		+ "</div>"
                		+ "</body> ";
                body2 = body2 + bodyCashFundLoop;
           	}
        }
        String guestCustomFundContSnValue = (String) sn.getAttribute(guestCustomFundContValueInSn);
        if(null != guestCustomFundContSnValue) {
        	String[] guestCustomFundContrSnValue = guestCustomFundContSnValue.split("__");
        	for(int i=0; i<guestCustomFundContrSnValue.length; i++) {
        		String[] guestCustomFundsListSt = guestCustomFundContrSnValue[i].split("_,_");
		        String bodyCustomFundLoop = "<body>"
		        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
		        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + guestCustomFundsListSt[2] + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestCustomFundsListSt[3] + "</p>"
		        		+ "</div>"
		        		+ "</body> ";
		        body2 = body2 + bodyCustomFundLoop;
        	}
		}		
		String guestConceptBoardContSnValue = (String) sn.getAttribute(guestCBContributedCartValueInSn);
		if(null != guestConceptBoardContSnValue) {
        	String[] guestConceptBoardContValueInSt = guestConceptBoardContSnValue.split("__");
        	for(int i=0; i<guestConceptBoardContValueInSt.length; i++) {
        		String[] guestConceptBoardContProdIdSt = guestConceptBoardContValueInSt[i].split("_,_");
        		long regConBoardProductSavingId = Long.parseLong(guestConceptBoardContProdIdSt[0]);
        		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedProductsInfoModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(regConBoardProductSavingId);
	        String bodyContLoop = "<body>"
	        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
	        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'> " + regCBContributedProductsInfoModel.getProductName() + "</p>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestConceptBoardContProdIdSt[1] + "</p>"
	        		+ "</div>"
	        		+ "</body> ";
	        body2 = body2 + bodyContLoop;
        	}
		}
        String guestConceptBoardsSnValue = (String) sn.getAttribute(guestCBIndividualCartValueInSn);
        if(null != guestConceptBoardsSnValue) {
           	String[] guestConceptBoardsValueInSt = guestConceptBoardsSnValue.split("__");
            for(int i=0; i<guestConceptBoardsValueInSt.length; i++) {
            	String[] guestConceptBoardProdIdSt = guestConceptBoardsValueInSt[i].split("_,_");    		
            	long cbIndividualProductsInfoSavingId = Long.parseLong(guestConceptBoardProdIdSt[0]);
            	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductsInfoModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(cbIndividualProductsInfoSavingId);
    	        String bodyIndLoop = "<body>"
    	        	+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
    	        	+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + regCBIndividualProductsInfoModel.getProductName() + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'>$" + regCBIndividualProductsInfoModel.getProductPrice() + "</p>"
    	        	+ "</div>"
    	        	+ "</body> ";
    	        body2 = body2 + bodyIndLoop;
            }
    	}
        String guestFinishingTouchesContSnValue = (String) sn.getAttribute(guestFTContributedCartValueInSn);
		if(null != guestFinishingTouchesContSnValue) {
        	String[] guestFinishingTouchesContValueInSt = guestFinishingTouchesContSnValue.split("__");
        	for(int i=0; i<guestFinishingTouchesContValueInSt.length; i++) {
        		String[] guestFinishingTouchesContProdIdSt = guestFinishingTouchesContValueInSt[i].split("_,_");
        		long regFinTouchesProductSavingId = Long.parseLong(guestFinishingTouchesContProdIdSt[0]);
        		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedProductsInfoModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(regFinTouchesProductSavingId);
	        String bodyContLoop = "<body>"
	        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
	        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'> " + regFTContributedProductsInfoModel.getProductName() + "</p>"
	        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + guestFinishingTouchesContProdIdSt[1] + "</p>"
	        		+ "</div>"
	        		+ "</body> ";
	        body2 = body2 + bodyContLoop;
        	}
		}
        String guestFinishingTouchesSnValue = (String) sn.getAttribute(guestFTIndividualCartValueInSn);
        if(null != guestFinishingTouchesSnValue) {
           	String[] guestFinishingTouchesValueInSt = guestFinishingTouchesSnValue.split("__");
            for(int i=0; i<guestFinishingTouchesValueInSt.length; i++) {
            	String[] guestFinishingTouchesProdIdSt = guestFinishingTouchesValueInSt[i].split("_,_");    		
            	long ftIndividualProductsInfoSavingId = Long.parseLong(guestFinishingTouchesProdIdSt[0]);
            	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductsInfoModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(ftIndividualProductsInfoSavingId);
    	        String bodyIndLoop = "<body>"
    	        	+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
    	        	+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + regFTIndividualProductsInfoModel.getProductName() + "</p>"
    	        	+ "<p style='font: 1.05em/1em sans-serif;'>$" + regFTIndividualProductsInfoModel.getProductPrice() + "</p>"
    	        	+ "</div>"
    	        	+ "</body> ";
    	        body2 = body2 + bodyIndLoop;
            }
    	}
		String body3 = "<body>"
					+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
					+ "<div style='margin-top: 10px; border-top: 1px solid black; width: 300px;'></div>"										
					+ "<p style='margin-top: 40px; font: 1.05em/1.5em sans-serif;'>Make sure you log in to your registry to view gift details under the 'My Account' and 'Gift Tracker' tabs.</p>"
					+ "<p style='margin-top: 25px; font: 1.05em/1.25em sans-serif;'>Log in to your account here: <a href='https://www.nookandcove.com/registryLogin'>My Registry</a></p>"					
					+ "<p style='margin-top: 20px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>For furniture and decor gifts, you will be able to select when a gift ships and track its details from your account. You can also track contributions towards a group gift, Room Funds and Cash Funds from your account.</p>"
					+ "<p style='margin-top: 20px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>If you have any questions regarding this gift, please reply to this email and we will get back to you as soon as possible.</p>"					
					+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
					+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
                    + "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                    + "</div>"
                    + "</body> ";
		String body =  body1 + body2 + body3;
    	try {
    		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
    	} catch (Exception ex) {
    		LOGGER.error("Guest cart payment email sending to registrant failed " + ex);
    	}       
    	return shopCartPaymentReff;
    }

    public String guestUserPutNullValuesAfterPayment(HttpServletRequest req, HttpSession sn) {
    	String allNullValuesReff = null;
    	sn.setAttribute(guestRoomFundsCartInfoInSn, null);
    	sn.setAttribute(guestCashFundContValueInSn, null);
    	sn.setAttribute(guestCustomFundContValueInSn, null);
    	sn.setAttribute(guestCBContributedCartValueInSn, null);
    	sn.setAttribute(guestCBIndividualCartValueInSn, null);
    	sn.setAttribute(guestFTIndividualCartValueInSn, null);
        sn.setAttribute(guestFTContributedCartValueInSn, null);
    	sn.setAttribute(totalRoomFundPriceInSn, null);
    	sn.setAttribute(guestCashFundTotalValueInSn, null);
    	sn.setAttribute(guestCustomFundTotalValueInSn, null);
    	sn.setAttribute(guestCBContributedPriceInSn, null);
    	sn.setAttribute(guestCBIndividualPriceInSn, null);
    	sn.setAttribute(guestFTContributedPriceInSn, null);
        sn.setAttribute(guestFTIndividualPriceInSn, null);
    	sn.setAttribute(cartCountInSn, null);
    	sn.setAttribute(roomsCartCountInSn, null);
    	sn.setAttribute(guestCashFundCartCountInSn, null);
    	sn.setAttribute(guestCustomFundCartCountInSn, null);
    	sn.setAttribute(guestCBContributedCartCountInSn, null);
    	sn.setAttribute(guestFTContributedCartCountInSn, null);
    	sn.setAttribute(guestCBIndividualCartCountInSn, null);
    	sn.setAttribute(guestFTIndividualCartCountInSn, null);
    	sn.setAttribute(guestShoppingCartTotalAmountInSn, null);
    	sn.setAttribute(cashFundValueInSn, null);
    	sn.setAttribute(onlySpaceTotalAmountInSn, null);                
    	sn.setAttribute(totalPayableAmountInSn, null);
    	sn.setAttribute(totalFundsAmountInSn, null);
    	sn.setAttribute(totalHandlingFeesInSn, null);
    	sn.setAttribute(totalGuestBillingInfoInSn, null);         		
    	sn.setAttribute(guestUserPaymentInfoSavingIdInSn, null);
    	sn.setAttribute(totalPayableAmountIncTaxInSn, null);
    	sn.setAttribute(shippingAmountStInSn, null);
    	sn.setAttribute(stateTaxAmountStInSn, null);
    	sn.setAttribute(bothCBandFTAddCartPriceInSn, null);
    	sn.setAttribute(roomFundTotalPriceInSn, null);
    	sn.setAttribute(totalRoomFundPaybleAmountInSn, null);	    	    
    	sn.setAttribute(roomFundHandlingFeeInSn, null);
    	sn.setAttribute(cashCustomFundTotalAmountInSn, null);
    	sn.setAttribute(transactionNumberInSn, null);
        sn.setAttribute(accountTypeInSn, null);
        sn.setAttribute(authorizationCodeInSn, null);
	    return allNullValuesReff;
    }

//Guest coding start
	
    @Override
    @Transactional
    public ModelAndView guestConceptBoardIndividualInfoDisplay(HttpServletRequest req, HttpSession sn) {  
    	ModelAndView mav;               
        String guestConceptBoardsSnValue = null;
        int guestCBCartCount = 0;
        String guestConceptBoardsCombVal = req.getParameter(guestCBIndividualProductSavingId) + "_,_" + req.getParameter(productQuantity) + "_,_" + req.getParameter(guestCBIndividualProductPrice) + "_,_" + req.getParameter(guestCBIndividualProductName) + "_,_" + req.getParameter(guestCBIndividualProductImage) + "_,_" + req.getParameter(guestCBIndividualNeedQuantity);
        if(null != sn.getAttribute(guestCBIndividualCartValueInSn)) {
        	guestConceptBoardsSnValue = guestCBIndividualProductDataAndQuantityUpdate(sn, (String) sn.getAttribute(guestCBIndividualCartValueInSn), req.getParameter(guestCBIndividualProductSavingId), req.getParameter(productQuantity), req.getParameter(guestCBIndividualProductPrice), req.getParameter(guestCBIndividualProductName), req.getParameter(guestCBIndividualProductImage), req.getParameter(guestCBIndividualNeedQuantity));
        	guestCBCartCount = (int) sn.getAttribute(guestCBIndividualCartCountInSn);
        } else {
        	guestConceptBoardsSnValue = guestConceptBoardsCombVal;
        	guestCBCartCount = Integer.parseInt(req.getParameter(productQuantity));
        	double guestCBIndividualPriceDb = Double.parseDouble(req.getParameter(guestCBIndividualProductPrice));
        	double guestCBIndividualPrice = guestCBIndividualPriceDb * guestCBCartCount;
        	sn.setAttribute(guestCBIndividualPriceInSn, guestCBIndividualPrice);
        }
        sn.setAttribute(guestCBIndividualCartCountInSn, guestCBCartCount);
        sn.setAttribute(guestCBIndividualCartValueInSn, guestConceptBoardsSnValue);        
        int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);        
        mav = guestSelectedMyAccountInfoFromDB(req, sn);
        mav.addObject(totalCartItems, allCartCountTotal);
        mav.addObject("guestAddCartReff", "Add To Cart");
        return mav;
  }
    
    public String guestCBIndividualProductDataAndQuantityUpdate(HttpSession sn, String sessionCBProdValue, String conBorProdId, String quantity, String productPrice, String productName, String productImage, String needQuantity) {
    	String guestConceptBoardsSnValue = null;
    	String prodIdCheckStatus = null;
    	double guestCBIndividualPriceDB = 0;
    	String[] guestConceptBoardsValueInSt = sessionCBProdValue.split("__");
    	int guestCBCartCount = 0;
    	for(int i=0; i<guestConceptBoardsValueInSt.length; i++) {
    		String[] guestConceptBoardProdIdSt = guestConceptBoardsValueInSt[i].split("_,_");    		
    		if(conBorProdId.equals(guestConceptBoardProdIdSt[0])) {
    			int guestQuantityInt = Integer.parseInt(quantity);
				String totalProdQuantity = Integer.toString(guestQuantityInt);
				String totalGuestProdComb = conBorProdId + "_,_" + totalProdQuantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage + "_,_" + needQuantity;
				prodIdCheckStatus = "Done";
				guestConceptBoardsSnValue = guestConceptBoardsSnValue + "__" + totalGuestProdComb;
				guestCBCartCount = guestCBCartCount + guestQuantityInt;
				double guestCBIndividualPriceDb = Double.parseDouble(productPrice);
	        	double guestCBIndividualPrice = guestCBIndividualPriceDb * guestQuantityInt;
	        	guestCBIndividualPriceDB = guestCBIndividualPriceDB + guestCBIndividualPrice;
    		} else {
    			guestConceptBoardsSnValue = guestConceptBoardsSnValue + "__" + guestConceptBoardsValueInSt[i];
    			int gusSelQuantityCount1 = Integer.parseInt(guestConceptBoardProdIdSt[1]);
    			guestCBCartCount = guestCBCartCount + gusSelQuantityCount1;
    			double guestCBIndividualPriceDb = Double.parseDouble(guestConceptBoardProdIdSt[2]);
	        	double guestCBIndividualPrice = guestCBIndividualPriceDb * gusSelQuantityCount1;
	        	guestCBIndividualPriceDB = guestCBIndividualPriceDB + guestCBIndividualPrice;
    		}
    		guestConceptBoardsSnValue = guestConceptBoardsSnValue.replaceFirst("null__", "");    		
    	}
    	if(prodIdCheckStatus == null) {
    		String guestConceptBoardsInputVal = conBorProdId + "_,_" + quantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage + "_,_" + needQuantity;
    		guestConceptBoardsSnValue = guestConceptBoardsSnValue + "__" + guestConceptBoardsInputVal;
    		int gusSelQuantityCount = Integer.parseInt(quantity);
    		guestCBCartCount = guestCBCartCount + gusSelQuantityCount;
    		double guestCBIndividualPriceDb = Double.parseDouble(productPrice);
        	double guestCBIndividualPrice = guestCBIndividualPriceDb * gusSelQuantityCount;
        	guestCBIndividualPriceDB = guestCBIndividualPriceDB + guestCBIndividualPrice;
    	}
    	sn.setAttribute(guestCBIndividualPriceInSn, guestCBIndividualPriceDB);
    	sn.setAttribute(guestCBIndividualCartCountInSn, guestCBCartCount);
    	return guestConceptBoardsSnValue;
    }

    @Override
    @Transactional
    public ModelAndView guestFinishingTouchesIndividualInfoDisplay(HttpServletRequest req, HttpSession sn) {   
    	ModelAndView mav;               
        String guestFinishingTouchessSnValue = null;
        int guestFTCartCount = 0;
        String guestFinishingTouchesCombVal = req.getParameter(guestFTIndividualProductSavingId) + "_,_" + req.getParameter(productQuantity) + "_,_" + req.getParameter(guestFTIndividualProductPrice) + "_,_" + req.getParameter(guestFTIndividualProductName) + "_,_" + req.getParameter(guestFTIndividualProductImage) + "_,_" + req.getParameter(guestFTIndividualNeedQuantity);
        if(null != sn.getAttribute(guestFTIndividualCartValueInSn)) {
        	guestFinishingTouchessSnValue = guestFTIndividualProductDataAndQuantityUpdate(sn, (String) sn.getAttribute(guestFTIndividualCartValueInSn), req.getParameter(guestFTIndividualProductSavingId), req.getParameter(productQuantity), req.getParameter(guestFTIndividualProductPrice), req.getParameter(guestFTIndividualProductName), req.getParameter(guestFTIndividualProductImage), req.getParameter(guestFTIndividualNeedQuantity));
        	guestFTCartCount = (int) sn.getAttribute(guestFTIndividualCartCountInSn);
        } else {
        	guestFinishingTouchessSnValue = guestFinishingTouchesCombVal;
        	guestFTCartCount = Integer.parseInt(req.getParameter(productQuantity));
        	double guestFTIndividualPriceDb = Double.parseDouble(req.getParameter(guestFTIndividualProductPrice));
        	double guestFTIndividualPrice = guestFTIndividualPriceDb * guestFTCartCount;
        	sn.setAttribute(guestFTIndividualPriceInSn, guestFTIndividualPrice);
        }
        sn.setAttribute(guestFTIndividualCartCountInSn, guestFTCartCount);
        sn.setAttribute(guestFTIndividualCartValueInSn, guestFinishingTouchessSnValue);        
        int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);        
        mav = guestSelectedMyAccountInfoFromDB(req, sn);
        mav.addObject(totalCartItems, allCartCountTotal);
        mav.addObject("guestAddCartReff", "Add To Cart");
        return mav;
  }
    
    public String guestFTIndividualProductDataAndQuantityUpdate(HttpSession sn, String sessionFTProdValue, String conBorProdId, String quantity, String productPrice, String productName, String productImage, String needQuantity) {
    	String guestFinishingTouchessSnValue = null;
    	String prodIdCheckStatus = null;
    	double guestFTIndividualPriceDB = 0;
    	String[] guestFinishingTouchessValueInSt = sessionFTProdValue.split("__");
    	int guestFTCartCount = 0;
    	for(int i=0; i<guestFinishingTouchessValueInSt.length; i++) {
    		String[] guestFinishingTouchesProdIdSt = guestFinishingTouchessValueInSt[i].split("_,_");    		
    		if(conBorProdId.equals(guestFinishingTouchesProdIdSt[0])) {
    			int guestQuantityInt = Integer.parseInt(quantity);
				String totalProdQuantity = Integer.toString(guestQuantityInt);
				String totalGuestProdComb = conBorProdId + "_,_" + totalProdQuantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage + "_,_" + needQuantity;
				prodIdCheckStatus = "Done";
				guestFinishingTouchessSnValue = guestFinishingTouchessSnValue + "__" + totalGuestProdComb;
				guestFTCartCount = guestFTCartCount + guestQuantityInt;
				double guestFTIndividualPriceDb = Double.parseDouble(productPrice);
	        	double guestFTIndividualPrice = guestFTIndividualPriceDb * guestQuantityInt;
	        	guestFTIndividualPriceDB = guestFTIndividualPriceDB + guestFTIndividualPrice;
    		} else {
    			guestFinishingTouchessSnValue = guestFinishingTouchessSnValue + "__" + guestFinishingTouchessValueInSt[i];
    			int gusSelQuantityCount1 = Integer.parseInt(guestFinishingTouchesProdIdSt[1]);
    			guestFTCartCount = guestFTCartCount + gusSelQuantityCount1;
    			double guestFTIndividualPriceDb = Double.parseDouble(guestFinishingTouchesProdIdSt[2]);
	        	double guestFTIndividualPrice = guestFTIndividualPriceDb * gusSelQuantityCount1;
	        	guestFTIndividualPriceDB = guestFTIndividualPriceDB + guestFTIndividualPrice;
    		}
    		guestFinishingTouchessSnValue = guestFinishingTouchessSnValue.replaceFirst("null__", "");    		
    	}
    	if(prodIdCheckStatus == null) {
    		String guestFinishingTouchesInputVal = conBorProdId + "_,_" + quantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage + "_,_" + needQuantity;
    		guestFinishingTouchessSnValue = guestFinishingTouchessSnValue + "__" + guestFinishingTouchesInputVal;
    		int gusSelQuantityCount = Integer.parseInt(quantity);
    		guestFTCartCount = guestFTCartCount + gusSelQuantityCount;
    		double guestFTIndividualPriceDb = Double.parseDouble(productPrice);
        	double guestFTIndividualPrice = guestFTIndividualPriceDb * gusSelQuantityCount;
        	guestFTIndividualPriceDB = guestFTIndividualPriceDB + guestFTIndividualPrice;
    	}
    	sn.setAttribute(guestFTIndividualPriceInSn, guestFTIndividualPriceDB);
    	sn.setAttribute(guestFTIndividualCartCountInSn, guestFTCartCount);
    	return guestFinishingTouchessSnValue;
    }

    @Override
    @Transactional
    public ModelAndView guestConBoardContributedDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestConBoardContSnValue = null;
        int guestCBConCartCount = 0;
    	String guestConceptBoardContCombVal = req.getParameter(guestConceptBoardContProductId) + "_,_" + req.getParameter(guestFundAmount) + "_,_" + req.getParameter(guestCBCotributedProductName) + "_,_" + req.getParameter(guestCBCotributedProductImage) + "_,_" + req.getParameter(guestCBCotributedNeedPrice);    	
    	if(null != sn.getAttribute(guestCBContributedCartValueInSn)) {
    		guestConBoardContSnValue = guestConBoardContProductPriceAdding(sn, (String) sn.getAttribute(guestCBContributedCartValueInSn), req.getParameter("guestConceptBoardContProductId"), req.getParameter(guestFundAmount), req.getParameter(guestCBCotributedProductName), req.getParameter(guestCBCotributedProductImage), req.getParameter(guestCBCotributedNeedPrice));
    		guestCBConCartCount = (int) sn.getAttribute(guestCBContributedCartCountInSn);    		
        } else {
        	guestConBoardContSnValue = guestConceptBoardContCombVal;
        	guestCBConCartCount = 1;
        	double guestCBContributedPrice = Double.parseDouble(req.getParameter(guestFundAmount));
        	sn.setAttribute(guestCBContributedPriceInSn, guestCBContributedPrice);
        }
    	sn.setAttribute(guestCBContributedCartValueInSn, guestConBoardContSnValue);
        sn.setAttribute(guestCBContributedCartCountInSn, guestCBConCartCount);        
        int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);        
        mav = new ModelAndView(redirectStatus + guestRegistryMyAccount);
        mav.addObject(totalCartItems, allCartCountTotal);
        return mav;
    }
    
    public String guestConBoardContProductPriceAdding(HttpSession sn, String sessionCBContProdValue, String conBorContProdId, String contributeAmount, String cbCotributedProductName, String cbCotributedProductImageSt, String cbCotributedNeedPriceSt) {
    	String guestConceptBoardContSnValue = null;
    	String prodIdCheckStatus = null;
    	String[] guestConceptBoardsValueInSt = sessionCBContProdValue.split("__");
    	double guestCBContributedPriceDB = 0;
    	int guestCBCartCount = 0;    	
    	for(int i=0; i<guestConceptBoardsValueInSt.length; i++) {
    		String[] guestConceptBoardProdIdSt = guestConceptBoardsValueInSt[i].split("_,_");    		
    		if(conBorContProdId.equals(guestConceptBoardProdIdSt[0])) {    			
				String totalGuestProdComb = conBorContProdId + "_,_" + contributeAmount + "_,_" + cbCotributedProductName + "_,_" + cbCotributedProductImageSt + "_,_" + cbCotributedNeedPriceSt;
				prodIdCheckStatus = "Done";
				guestConceptBoardContSnValue = guestConceptBoardContSnValue + "__" + totalGuestProdComb;
				guestCBContributedPriceDB = guestCBContributedPriceDB + Double.parseDouble(contributeAmount);
				guestCBCartCount = guestCBCartCount + 1;
    		} else {
    			guestConceptBoardContSnValue = guestConceptBoardContSnValue + "__" + guestConceptBoardsValueInSt[i];
    			guestCBContributedPriceDB = guestCBContributedPriceDB + Double.parseDouble(guestConceptBoardProdIdSt[1]);
    			guestCBCartCount = guestCBCartCount + 1;
    		}
    		guestConceptBoardContSnValue = guestConceptBoardContSnValue.replaceFirst("null__", "");    		
    	}
    	if(prodIdCheckStatus == null) {
    		String guestConceptBoardsInputVal = conBorContProdId + "_,_" + contributeAmount + "_,_" + cbCotributedProductName + "_,_" + cbCotributedProductImageSt + "_,_" + cbCotributedNeedPriceSt;
    		guestConceptBoardContSnValue = guestConceptBoardContSnValue + "__" + guestConceptBoardsInputVal;
    		guestCBContributedPriceDB = guestCBContributedPriceDB + Double.parseDouble(contributeAmount);
    		guestCBCartCount = guestCBCartCount + 1;
    	}
    	sn.setAttribute(guestCBContributedPriceInSn, guestCBContributedPriceDB);
    	sn.setAttribute(guestCBContributedCartCountInSn, guestCBCartCount);
    	return guestConceptBoardContSnValue;
    }

    @Override
    @Transactional
    public ModelAndView guestFinTouchesContributedDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestFinTouchesContSnValue = null;
        int guestFTConCartCount = 0;
    	String guestFinishingTouchesContCombVal = req.getParameter(guestFinishingTouchesContProductId) + "_,_" + req.getParameter(guestFundAmount) + "_,_" + req.getParameter(guestFTCotributedProductName) + "_,_" + req.getParameter(guestFTCotributedProductImage) + "_,_" + req.getParameter(guestFTCotributedNeedPrice);    	
    	if(null != sn.getAttribute(guestFTContributedCartValueInSn)) {
    		guestFinTouchesContSnValue = guestFinTouchesContProductPriceAdding(sn, (String) sn.getAttribute(guestFTContributedCartValueInSn), req.getParameter("guestFinishingTouchesContProductId"), req.getParameter(guestFundAmount), req.getParameter(guestFTCotributedProductName), req.getParameter(guestFTCotributedProductImage), req.getParameter(guestFTCotributedNeedPrice));
    		guestFTConCartCount = (int) sn.getAttribute(guestFTContributedCartCountInSn);    		
        } else {
        	guestFinTouchesContSnValue = guestFinishingTouchesContCombVal;
        	guestFTConCartCount = 1;
        	double guestFTContributedPrice = Double.parseDouble(req.getParameter(guestFundAmount));
        	sn.setAttribute(guestFTContributedPriceInSn, guestFTContributedPrice);
        }
    	sn.setAttribute(guestFTContributedCartValueInSn, guestFinTouchesContSnValue);
        sn.setAttribute(guestFTContributedCartCountInSn, guestFTConCartCount);        
        int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);        
        mav = new ModelAndView(redirectStatus + guestRegistryMyAccount);
        mav.addObject(totalCartItems, allCartCountTotal);
        return mav;
    }
    
    public String guestFinTouchesContProductPriceAdding(HttpSession sn, String sessionFTContProdValue, String conBorContProdId, String contributeAmount, String ftCotributedProductName, String ftCotributedProductImageSt, String ftCotributedNeedPriceSt) {
    	String guestFinishingTouchesContSnValue = null;
    	String prodIdCheckStatus = null;
    	String[] guestFinishingTouchesValueInSt = sessionFTContProdValue.split("__");
    	double guestFTContributedPriceDB = 0;
    	int guestFTCartCount = 0;    	
    	for(int i=0; i<guestFinishingTouchesValueInSt.length; i++) {
    		String[] guestFinishingTouchesProdIdSt = guestFinishingTouchesValueInSt[i].split("_,_");    		
    		if(conBorContProdId.equals(guestFinishingTouchesProdIdSt[0])) {    			
				String totalGuestProdComb = conBorContProdId + "_,_" + contributeAmount + "_,_" + ftCotributedProductName + "_,_" + ftCotributedProductImageSt + "_,_" + ftCotributedNeedPriceSt;
				prodIdCheckStatus = "Done";
				guestFinishingTouchesContSnValue = guestFinishingTouchesContSnValue + "__" + totalGuestProdComb;
				guestFTContributedPriceDB = guestFTContributedPriceDB + Double.parseDouble(contributeAmount);
				guestFTCartCount = guestFTCartCount + 1;
    		} else {
    			guestFinishingTouchesContSnValue = guestFinishingTouchesContSnValue + "__" + guestFinishingTouchesValueInSt[i];
    			guestFTContributedPriceDB = guestFTContributedPriceDB + Double.parseDouble(guestFinishingTouchesProdIdSt[1]);
    			guestFTCartCount = guestFTCartCount + 1;
    		}
    		guestFinishingTouchesContSnValue = guestFinishingTouchesContSnValue.replaceFirst("null__", "");    		
    	}
    	if(prodIdCheckStatus == null) {
    		String guestFinishingTouchesInputVal = conBorContProdId + "_,_" + contributeAmount + "_,_" + ftCotributedProductName + "_,_" + ftCotributedProductImageSt + "_,_" + ftCotributedNeedPriceSt;
    		guestFinishingTouchesContSnValue = guestFinishingTouchesContSnValue + "__" + guestFinishingTouchesInputVal;
    		guestFTContributedPriceDB = guestFTContributedPriceDB + Double.parseDouble(contributeAmount);
    		guestFTCartCount = guestFTCartCount + 1;
    	}
    	sn.setAttribute(guestFTContributedPriceInSn, guestFTContributedPriceDB);
    	sn.setAttribute(guestFTContributedCartCountInSn, guestFTCartCount);
    	return guestFinishingTouchesContSnValue;
    }

    @Override
    @Transactional
    public JSONArray jSonCashFundContributeValueUpdateInDB(String cashFundName, HttpSession sn) {
    	String[] totalCashFundInfoList = cashFundName.split("__");
    	guestCashFundAmountJSonUpdateToCart(sn, (String) sn.getAttribute(guestCashFundContValueInSn), totalCashFundInfoList[0], totalCashFundInfoList[1]);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalCashFundInfoList[1]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String guestCashFundAmountJSonUpdateToCart(HttpSession sn, String guestCashFundContSnValue, String registryCashFundsId, String cartNewAmount) {
    	String guestCashFundsContSnValue = null;
    	String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
    	int totalCashFundCartCount = 0;
    	double guestCashFundTotalValDb = 0;
    	for(int i=0; i<guestCashFundContrSnValue.length; i++) {
    		String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");    		
    		if(registryCashFundsId.equals(guestCashFundsListSt[0])) {    			
				String totalGuestCashFundComb = registryCashFundsId + "_,_" + guestCashFundsListSt[1] + "_,_" + guestCashFundsListSt[2] + "_,_" + cartNewAmount + "_,_" + guestCashFundsListSt[4];
				guestCashFundsContSnValue = guestCashFundsContSnValue + "__" + totalGuestCashFundComb;
				totalCashFundCartCount = totalCashFundCartCount + 1;
				double guestCashFundValDb = Double.parseDouble(cartNewAmount);
				guestCashFundTotalValDb = guestCashFundTotalValDb + guestCashFundValDb;
    		} else {
    			guestCashFundsContSnValue = guestCashFundsContSnValue + "__" + guestCashFundContrSnValue[i];
    			totalCashFundCartCount = totalCashFundCartCount + 1;
    			double guestCashFundValueDb = Double.parseDouble(guestCashFundsListSt[3]);
    			guestCashFundTotalValDb = guestCashFundTotalValDb + guestCashFundValueDb;
    		}
    		guestCashFundsContSnValue = guestCashFundsContSnValue.replaceFirst("null__", "");    		
    	}    	
    	sn.setAttribute(guestCashFundTotalValueInSn, guestCashFundTotalValDb);
    	sn.setAttribute(guestCashFundCartCountInSn, totalCashFundCartCount);
    	sn.setAttribute(guestCashFundContValueInSn, guestCashFundsContSnValue);
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(guestShoppingCartTotalAmountInSn, allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);
    	return guestCashFundsContSnValue;
    }

    @Override
    @Transactional
    public JSONArray jSonCustomFundContributeValueUpdateInDB(String cashFundName, HttpSession sn) {
    	String[] totalCashFundInfoList = cashFundName.split("__");
    	guestCustomFundAmountJSonUpdateToCart(sn, (String) sn.getAttribute(guestCustomFundContValueInSn), totalCashFundInfoList[0], totalCashFundInfoList[1]);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalCashFundInfoList[1]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String guestCustomFundAmountJSonUpdateToCart(HttpSession sn, String guestCustomFundContSnValue, String registryCustomFundsId, String cartNewAmount) {
    	String guestCustomFundsContSnValue = null;
    	String[] guestCustomFundContrSnValue = guestCustomFundContSnValue.split("__");
    	int totalCustomFundCartCount = 0;
    	double guestCustomFundTotalValDb = 0;
    	for(int i=0; i<guestCustomFundContrSnValue.length; i++) {
    		String[] guestCustomFundsListSt = guestCustomFundContrSnValue[i].split("_,_");    		
    		if(registryCustomFundsId.equals(guestCustomFundsListSt[0])) {    			
				String totalGuestCustomFundComb = registryCustomFundsId + "_,_" + guestCustomFundsListSt[1] + "_,_" + guestCustomFundsListSt[2] + "_,_" + cartNewAmount + "_,_" + guestCustomFundsListSt[4];
				guestCustomFundsContSnValue = guestCustomFundsContSnValue + "__" + totalGuestCustomFundComb;
				totalCustomFundCartCount = totalCustomFundCartCount + 1;
				double guestCustomFundValDb = Double.parseDouble(cartNewAmount);
				guestCustomFundTotalValDb = guestCustomFundTotalValDb + guestCustomFundValDb;
    		} else {
    			guestCustomFundsContSnValue = guestCustomFundsContSnValue + "__" + guestCustomFundContrSnValue[i];
    			totalCustomFundCartCount = totalCustomFundCartCount + 1;
    			double guestCustomFundValueDb = Double.parseDouble(guestCustomFundsListSt[3]);
    			guestCustomFundTotalValDb = guestCustomFundTotalValDb + guestCustomFundValueDb;
    		}
    		guestCustomFundsContSnValue = guestCustomFundsContSnValue.replaceFirst("null__", "");    		
    	}    	
    	sn.setAttribute(guestCustomFundTotalValueInSn, guestCustomFundTotalValDb);
    	sn.setAttribute(guestCustomFundCartCountInSn, totalCustomFundCartCount);
    	sn.setAttribute(guestCustomFundContValueInSn, guestCustomFundsContSnValue);
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(guestShoppingCartTotalAmountInSn, allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);
    	return guestCustomFundsContSnValue;
    }

    @Override
    @Transactional
    public JSONArray jSonCashFundContributeInfoDeleteInDB(String cashFundsId, HttpSession sn) {
    	guestCashFundAmountJSonInfoDeleteFromCart(sn, (String) sn.getAttribute(guestCashFundContValueInSn), cashFundsId);
    	int guestCartCount = guestCashFundCartCount(sn);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, guestCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String guestCashFundAmountJSonInfoDeleteFromCart(HttpSession sn, String guestCashFundContSnValue, String registryCashFundsId) {
    	String guestCashFundsContSnValue = null;
    	String[] guestCashFundContrSnValue = guestCashFundContSnValue.split("__");
    	int totalCashFundCartCount = 0;
    	double guestCashFundTotalValDb = 0;
    	for(int i=0; i<guestCashFundContrSnValue.length; i++) {
    		String[] guestCashFundsListSt = guestCashFundContrSnValue[i].split("_,_");    		
    		if(registryCashFundsId.equals(guestCashFundsListSt[0])) {
    		} else {
    			guestCashFundsContSnValue = guestCashFundsContSnValue + "__" + guestCashFundContrSnValue[i];
    			totalCashFundCartCount = totalCashFundCartCount + 1;
    			double guestCashFundValueDb = Double.parseDouble(guestCashFundsListSt[3]);
    			guestCashFundTotalValDb = guestCashFundTotalValDb + guestCashFundValueDb;
    		}
    	}
    	if(null != guestCashFundsContSnValue) {
    		guestCashFundsContSnValue = guestCashFundsContSnValue.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestCashFundTotalValueInSn, guestCashFundTotalValDb);
    	sn.setAttribute(guestCashFundCartCountInSn, totalCashFundCartCount);
    	sn.setAttribute(guestCashFundContValueInSn, guestCashFundsContSnValue);
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(guestShoppingCartTotalAmountInSn, allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);
    	return guestCashFundsContSnValue;
    }
    
    public int guestCashFundCartCount(HttpSession sn) {
    	int guestCartCount = 0;    	
    	guestCartCount = allCartCountTotalDisplay(sn);
    	sn.setAttribute(cartCountInSn, guestCartCount);
    	return guestCartCount;
    }

    @Override
    @Transactional
    public JSONArray jSonCustomFundContributeInfoDeleteInDB(String customFundName, HttpSession sn) {
    	guestCustomFundAmountJSonInfoDeleteFromCart(sn, (String) sn.getAttribute(guestCustomFundContValueInSn), customFundName);
    	int guestCartCount = guestCashFundCartCount(sn);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, guestCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }
    
    public String guestCustomFundAmountJSonInfoDeleteFromCart(HttpSession sn, String guestCustomFundContSnValue, String registryCustomFundsId) {
    	String guestCustomFundsContSnValue = null;
    	String[] guestCustomFundContrSnValue = guestCustomFundContSnValue.split("__");
    	int totalCustomFundCartCount = 0;
    	double guestCustomFundTotalValDb = 0;
    	for(int i=0; i<guestCustomFundContrSnValue.length; i++) {
    		String[] guestCustomFundsListSt = guestCustomFundContrSnValue[i].split("_,_");    		
    		if(registryCustomFundsId.equals(guestCustomFundsListSt[0])) {			
    		} else {
    			guestCustomFundsContSnValue = guestCustomFundsContSnValue + "__" + guestCustomFundContrSnValue[i];
    			totalCustomFundCartCount = totalCustomFundCartCount + 1;
    			double guestCustomFundValueDb = Double.parseDouble(guestCustomFundsListSt[3]);
    			guestCustomFundTotalValDb = guestCustomFundTotalValDb + guestCustomFundValueDb;
    		}    		    		
    	}
    	if(null != guestCustomFundsContSnValue) {
    		guestCustomFundsContSnValue = guestCustomFundsContSnValue.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestCustomFundTotalValueInSn, guestCustomFundTotalValDb);
    	sn.setAttribute(guestCustomFundCartCountInSn, totalCustomFundCartCount);
    	sn.setAttribute(guestCustomFundContValueInSn, guestCustomFundsContSnValue);
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(guestShoppingCartTotalAmountInSn, allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);
    	return guestCustomFundsContSnValue;
    }

    @Override
    @Transactional
    public JSONArray jSonRoomFundContributeValueUpdateInDB(String roomFundsName, HttpSession sn) {
    	String[] totalRoomFundInfoList = roomFundsName.split("___");
    	guestRoomFundAmountJSonUpdateToCart(sn, totalRoomFundInfoList[0], totalRoomFundInfoList[1], totalRoomFundInfoList[2], totalRoomFundInfoList[3], totalRoomFundInfoList[4], totalRoomFundInfoList[5], totalRoomFundInfoList[6]);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalRoomFundInfoList[2]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }
    
    public String guestRoomFundAmountJSonUpdateToCart(HttpSession sn, String roomFundImage, String roomFundName, String roomFundColumnName, String roomFundColumnCount, String oldRoomFundPrice, String newRoomFundPrice, String roomFundsNeedPrice) { 
    	String guestRoomFundsContSnValue = null;
    	String selectedRoomtotalInfo = roomFundImage + ",_," + roomFundName + ",_," + oldRoomFundPrice + ",_," + roomFundColumnName + ",_," + roomFundColumnCount + ",_," + roomFundsNeedPrice;
    	String withoutPriceRoomtotalInfo = roomFundImage + ",_," + roomFundName + "_,_" + roomFundColumnName + ",_," + roomFundColumnCount + ",_," + roomFundsNeedPrice;
    	String[] withoutPriceRoomtotalInfoStr = withoutPriceRoomtotalInfo.split("_,_");
    	String withoutPriceRoomtotalValue = withoutPriceRoomtotalInfoStr[0] + ",_," + newRoomFundPrice + ",_," + withoutPriceRoomtotalInfoStr[1];
    	int oldRoomFundPriceDb = 0;
    	if(null != oldRoomFundPrice) {
    		oldRoomFundPriceDb = Integer.parseInt(oldRoomFundPrice);
    	}    	
    	int newRoomFundPriceInt = 0;
    	if(null != newRoomFundPrice) {
    		newRoomFundPriceInt = Integer.parseInt(newRoomFundPrice);
    	}
    	String guestCartRoomInfoList = null;
    	String guestRoomFundsCartInfoList = (String) sn.getAttribute(guestRoomFundsCartInfoInSn);
    	String[] guestRoomFundsCartInfoSt = guestRoomFundsCartInfoList.split("__");
    	for(int i = 0; i < guestRoomFundsCartInfoSt.length; i++) {
    		if(!selectedRoomtotalInfo.equals(guestRoomFundsCartInfoSt[i])) {
    			guestCartRoomInfoList = guestCartRoomInfoList + "__" + guestRoomFundsCartInfoSt[i];
    		} else {
    			guestCartRoomInfoList = guestCartRoomInfoList + "__" + withoutPriceRoomtotalValue;
    		}
    	}
    	if(guestRoomFundsCartInfoSt.length > 0) {
    		guestCartRoomInfoList = guestCartRoomInfoList.replaceFirst("null__", "");
    	}    	
    	int totalRoomFundPrice = (int) sn.getAttribute(totalRoomFundPriceInSn);
    	int remRoomAmount = (totalRoomFundPrice - oldRoomFundPriceDb) + newRoomFundPriceInt; 
    	sn.setAttribute(totalRoomFundPriceInSn, remRoomAmount);
    	sn.setAttribute(guestRoomFundsCartInfoInSn, guestCartRoomInfoList);
    	return guestRoomFundsContSnValue;
    }

    @Override
    @Transactional
    public JSONArray jSonRoomFundContributeInfoDeleteInDB(String roomFundsName, HttpSession sn) {
    	String[] totalRoomFundInfoList = roomFundsName.split("___");
    	guestRoomFundAmountJSonDeleteFromCart(sn, totalRoomFundInfoList[0], totalRoomFundInfoList[1]);
    	int guestCartCount = guestCashFundCartCount(sn);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, guestCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String guestRoomFundAmountJSonDeleteFromCart(HttpSession sn, String selectedRoomTotalInfo, String oldRoomFundPrice) { 
    	String guestRoomFundContDelValue = null;
    	int oldRoomFundPriceDb = 0;
    	if(null != oldRoomFundPrice) {
    		oldRoomFundPriceDb = Integer.parseInt(oldRoomFundPrice);
    	}
    	String guestCartRoomInfoList = null;
    	String guestRoomFundsCartInfoList = (String) sn.getAttribute(guestRoomFundsCartInfoInSn);
    	String[] guestRoomFundsCartInfoSt = guestRoomFundsCartInfoList.split("__");
    	for(int i = 0; i < guestRoomFundsCartInfoSt.length; i++) {
    		if(!selectedRoomTotalInfo.equals(guestRoomFundsCartInfoSt[i])) {
    			guestCartRoomInfoList = guestCartRoomInfoList + "__" + guestRoomFundsCartInfoSt[i];
    		} 
    	}
    	if(guestRoomFundsCartInfoSt.length > 1) {
    		guestCartRoomInfoList = guestCartRoomInfoList.replaceFirst("null__", "");
    	}
    	int roomsCartCount = (int) sn.getAttribute(roomsCartCountInSn);
    	int remCartCount = roomsCartCount - 1;    	
    	int totalRoomFundPrice = (int) sn.getAttribute(totalRoomFundPriceInSn);
    	int remRoomAmount = totalRoomFundPrice - oldRoomFundPriceDb;    	
    	sn.setAttribute(roomsCartCountInSn, remCartCount);
    	sn.setAttribute(totalRoomFundPriceInSn, remRoomAmount);
    	sn.setAttribute(guestRoomFundsCartInfoInSn, guestCartRoomInfoList);
    	return guestRoomFundContDelValue;
    }
    
    @Override
    @Transactional
    public JSONArray jSonAddCartGuestCBContributedValueUpdateInDB(String cbContributedInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] cbContributedInfoValueSt = cbContributedInfoValue.split("__");
    	registrantCBContributedAddCartJSonValueUpdateInDB(sn, req, cbContributedInfoValueSt[0], cbContributedInfoValueSt[1], cbContributedInfoValueSt[2]);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }
    
    public String registrantCBContributedAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String cbContributedPaymentSavingId, String regNewContributedPriceValue, String regOldContributedPriceValue) {
    	String cbContributedAddCartValue = null;        
    	String guestConceptBoardContSnValue = (String) sn.getAttribute(guestCBContributedCartValueInSn);    	
    	String[] guestConceptBoardContValueInSt = guestConceptBoardContSnValue.split("__");
    	String guestConceptBoardContValuesList = null;
    	for(int i = 0; i < guestConceptBoardContValueInSt.length; i++) {
    		String[] checkSnValuesString = guestConceptBoardContValueInSt[i].split("_,_");    		
    		if((cbContributedPaymentSavingId).equals(checkSnValuesString[0])) {
    			String newCBContributedValuesList = checkSnValuesString[0] + "_,_" + regNewContributedPriceValue + "_,_" + checkSnValuesString[2] + "_,_" + checkSnValuesString[3] + "_,_" + checkSnValuesString[4];
    			guestConceptBoardContValuesList = guestConceptBoardContValuesList + "__" + newCBContributedValuesList;
    		} else {
    			guestConceptBoardContValuesList = guestConceptBoardContValuesList + "__" + guestConceptBoardContValueInSt[i];    			
    		}
    	}
    	if(guestConceptBoardContValueInSt.length > 0) {
    		guestConceptBoardContValuesList = guestConceptBoardContValuesList.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestCBContributedCartValueInSn, guestConceptBoardContValuesList);
    	double guestConceptBoardsContPriceSn = (double) sn.getAttribute(guestCBContributedPriceInSn);
    	double oldContributedPrice = Double.parseDouble(regOldContributedPriceValue);
    	double newContributedPrice = Double.parseDouble(regNewContributedPriceValue);
    	double guestConceptBoardsContPrice = (guestConceptBoardsContPriceSn - oldContributedPrice) + newContributedPrice;
    	sn.setAttribute(guestCBContributedPriceInSn, guestConceptBoardsContPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);        
    	return cbContributedAddCartValue;
    }
    
    @Override
    @Transactional
    public JSONArray jSonAddCartGuestCBIndividualValueUpdateInDB(String cbIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] cbIndividualInfoValueSt = cbIndividualInfoValue.split("__");
    	registrantCBIndividualAddCartJSonValueUpdateInDB(sn, req, cbIndividualInfoValueSt[0], cbIndividualInfoValueSt[1], cbIndividualInfoValueSt[2], cbIndividualInfoValueSt[3]);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBIndividualAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String cbIndividualPaymentSavingId, String guestNewIndividualQuantity, String guestOldIndividualQuantity, String guestOldIndividualPrice) {
    	String cbIndividualAddCartValue = null;
        int newIndividualQuantity = Integer.parseInt(guestNewIndividualQuantity);
        int oldIndividualQuantity = Integer.parseInt(guestOldIndividualQuantity);
        double guestOldIndividualPriceDb = Double.parseDouble(guestOldIndividualPrice);        
        String guestConceptBoardsSnValue = (String) sn.getAttribute(guestCBIndividualCartValueInSn);
        String[] guestConceptBoardsValueInSt = guestConceptBoardsSnValue.split("__");
    	String guestConceptBoardsValuesList = null;
    	for(int i = 0; i < guestConceptBoardsValueInSt.length; i++) {
    		String[] checkSnValuesString = guestConceptBoardsValueInSt[i].split("_,_");
    		if((cbIndividualPaymentSavingId).equals(checkSnValuesString[0])) {
    			String newCBContributedValuesList = checkSnValuesString[0] + "_,_" + guestNewIndividualQuantity + "_,_" + checkSnValuesString[2] + "_,_" + checkSnValuesString[3] + "_,_" + checkSnValuesString[4] + "_,_" + checkSnValuesString[5];
    			guestConceptBoardsValuesList = guestConceptBoardsValuesList + "__" + newCBContributedValuesList;
    		} else {
    			guestConceptBoardsValuesList = guestConceptBoardsValuesList + "__" + guestConceptBoardsValueInSt[i];
    		}
    	}
    	if(guestConceptBoardsValueInSt.length > 0) {
    		guestConceptBoardsValuesList = guestConceptBoardsValuesList.replaceFirst("null__", "");
    	}
    	int totalSnCBCartCount = (int) sn.getAttribute(guestCBIndividualCartCountInSn);
    	int guestCBCartCount = (totalSnCBCartCount - oldIndividualQuantity) + newIndividualQuantity;
    	sn.setAttribute(guestCBIndividualCartCountInSn, guestCBCartCount);    	
    	sn.setAttribute(guestCBIndividualCartValueInSn, guestConceptBoardsValuesList);    	
    	double guestConceptBoardsIndvPriceSn = (double) sn.getAttribute(guestCBIndividualPriceInSn);
    	double guestOldIndividualAmountDb = guestOldIndividualPriceDb * oldIndividualQuantity;
    	double guestNewIndividualAmountDb = guestOldIndividualPriceDb * newIndividualQuantity;    	
    	double guestConceptBoardsIndvPrice = (guestConceptBoardsIndvPriceSn - guestOldIndividualAmountDb) + guestNewIndividualAmountDb;
    	sn.setAttribute(guestCBIndividualPriceInSn, guestConceptBoardsIndvPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);        
    	return cbIndividualAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonGuestCBContributedInfoDeleteFromDB(String regiCBContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantCBContributedAddCartJSonValueDeleteFromInDB(sn, req, regiCBContributedPaymentSavingId);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBContributedAddCartJSonValueDeleteFromInDB(HttpSession sn, HttpServletRequest req, String cbContributedPaymentSavingId) {
    	String cbContributedAddCartValue = null;        
    	String guestConceptBoardContSnValue = (String) sn.getAttribute(guestCBContributedCartValueInSn);    	
    	String[] guestConceptBoardContValueInSt = guestConceptBoardContSnValue.split("__");
    	String guestConceptBoardContValuesList = null;
    	double contributedSnPriceDb = 0;
    	int contributedCount = 0;
    	for(int i = 0; i < guestConceptBoardContValueInSt.length; i++) {
    		String[] checkSnValuesString = guestConceptBoardContValueInSt[i].split("_,_");
    		if((cbContributedPaymentSavingId).equals(checkSnValuesString[0])) {
    			contributedSnPriceDb = Double.parseDouble(checkSnValuesString[1]);
    			contributedCount = 1;
    		} else {
    			guestConceptBoardContValuesList = guestConceptBoardContValuesList + "__" + guestConceptBoardContValueInSt[i];    			
    		}
    	}
    	if(null != guestConceptBoardContValuesList) {
    		guestConceptBoardContValuesList = guestConceptBoardContValuesList.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestCBContributedCartValueInSn, guestConceptBoardContValuesList);
    	double guestConceptBoardsContPriceSn = (double) sn.getAttribute(guestCBContributedPriceInSn);
    	double guestConceptBoardsContPrice = guestConceptBoardsContPriceSn - contributedSnPriceDb;
    	sn.setAttribute(guestCBContributedPriceInSn, guestConceptBoardsContPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);    	
    	int totalSnCBCartCount = (int) sn.getAttribute(guestCBContributedCartCountInSn);
    	int guestCBCartCount = totalSnCBCartCount - contributedCount;
    	sn.setAttribute(guestCBContributedCartCountInSn, guestCBCartCount); 
    	return cbContributedAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonGuestCBIndividualInfoDeleteFromDB(String regiCBIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantCBIndividualAddCartJSonValueDeleteFromDB(sn, req, regiCBIndividualPaymentSavingId);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBIndividualAddCartJSonValueDeleteFromDB(HttpSession sn, HttpServletRequest req, String cbIndividualPaymentSavingId) {
    	String cbIndividualAddCartValue = null;               
        String guestConceptBoardsSnValue = (String) sn.getAttribute(guestCBIndividualCartValueInSn);
        String[] guestConceptBoardsValueInSt = guestConceptBoardsSnValue.split("__");
    	String guestConceptBoardsValuesList = null;
    	int snQuantity = 0;
    	double individualSnPriceDb = 0;
    	for(int i = 0; i < guestConceptBoardsValueInSt.length; i++) {
    		String[] checkSnValuesString = guestConceptBoardsValueInSt[i].split("_,_");
    		if((cbIndividualPaymentSavingId).equals(checkSnValuesString[0])) {
    			snQuantity = Integer.parseInt(checkSnValuesString[1]);
    			double contributedSnPriceDb = Double.parseDouble(checkSnValuesString[2]);
    			individualSnPriceDb = contributedSnPriceDb * snQuantity;
    		} else {
    			guestConceptBoardsValuesList = guestConceptBoardsValuesList + "__" + guestConceptBoardsValueInSt[i];
    		}
    	}
    	if(null != guestConceptBoardsValuesList) {
    		guestConceptBoardsValuesList = guestConceptBoardsValuesList.replaceFirst("null__", "");
    	}
    	int totalSnCBCartCount = (int) sn.getAttribute(guestCBIndividualCartCountInSn);
    	int guestCBCartCount = totalSnCBCartCount - snQuantity;
    	sn.setAttribute(guestCBIndividualCartCountInSn, guestCBCartCount);
    	sn.setAttribute(guestCBIndividualCartValueInSn, guestConceptBoardsValuesList);    	
    	double guestConceptBoardsIndvPriceSn = (double) sn.getAttribute(guestCBIndividualPriceInSn);    		
    	double guestConceptBoardsIndvPrice = guestConceptBoardsIndvPriceSn - individualSnPriceDb;
    	sn.setAttribute(guestCBIndividualPriceInSn, guestConceptBoardsIndvPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);        
    	return cbIndividualAddCartValue;
    }
    
    @Override
    @Transactional
    public JSONArray jSonAddCartGuestFTContributedValueUpdateInDB(String ftContributedInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] ftContributedInfoValueSt = ftContributedInfoValue.split("__");
    	registrantFTContributedAddCartJSonValueUpdateInDB(sn, req, ftContributedInfoValueSt[0], ftContributedInfoValueSt[1], ftContributedInfoValueSt[2]);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }
    
    public String registrantFTContributedAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String ftContributedPaymentSavingId, String regNewContributedPriceValue, String regOldContributedPriceValue) {
    	String ftContributedAddCartValue = null;        
    	String guestFinishingTouchesContSnValue = (String) sn.getAttribute(guestFTContributedCartValueInSn);    	
    	String[] guestFinishingTouchesContValueInSt = guestFinishingTouchesContSnValue.split("__");
    	String guestFinishingTouchesContValuesList = null;
    	for(int i = 0; i < guestFinishingTouchesContValueInSt.length; i++) {
    		String[] checkSnValuesString = guestFinishingTouchesContValueInSt[i].split("_,_");    		
    		if((ftContributedPaymentSavingId).equals(checkSnValuesString[0])) {
    			String newFTContributedValuesList = checkSnValuesString[0] + "_,_" + regNewContributedPriceValue + "_,_" + checkSnValuesString[2] + "_,_" + checkSnValuesString[3] + "_,_" + checkSnValuesString[4];
    			guestFinishingTouchesContValuesList = guestFinishingTouchesContValuesList + "__" + newFTContributedValuesList;
    		} else {
    			guestFinishingTouchesContValuesList = guestFinishingTouchesContValuesList + "__" + guestFinishingTouchesContValueInSt[i];    			
    		}
    	}
    	if(guestFinishingTouchesContValueInSt.length > 0) {
    		guestFinishingTouchesContValuesList = guestFinishingTouchesContValuesList.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestFTContributedCartValueInSn, guestFinishingTouchesContValuesList);
    	double totalFinishingTouchesContPriceSn = (double) sn.getAttribute(guestFTContributedPriceInSn);
    	double oldContributedPrice = Double.parseDouble(regOldContributedPriceValue);
    	double newContributedPrice = Double.parseDouble(regNewContributedPriceValue);
    	double totalFinishingTouchesContPrice = (totalFinishingTouchesContPriceSn - oldContributedPrice) + newContributedPrice;
    	sn.setAttribute(guestFTContributedPriceInSn, totalFinishingTouchesContPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);        
    	return ftContributedAddCartValue;
    }
    
    @Override
    @Transactional
    public JSONArray jSonAddCartGuestFTIndividualValueUpdateInDB(String ftIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] ftIndividualInfoValueSt = ftIndividualInfoValue.split("__");
    	registrantFTIndividualAddCartJSonValueUpdateInDB(sn, req, ftIndividualInfoValueSt[0], ftIndividualInfoValueSt[1], ftIndividualInfoValueSt[2], ftIndividualInfoValueSt[3]);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTIndividualAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String ftIndividualPaymentSavingId, String guestNewIndividualQuantity, String guestOldIndividualQuantity, String guestOldIndividualPrice) {
    	String ftIndividualAddCartValue = null;
        int newIndividualQuantity = Integer.parseInt(guestNewIndividualQuantity);
        int oldIndividualQuantity = Integer.parseInt(guestOldIndividualQuantity);
        double guestOldIndividualPriceDb = Double.parseDouble(guestOldIndividualPrice);        
        String guestFinishingTouchesSnValue = (String) sn.getAttribute(guestFTIndividualCartValueInSn);
        String[] guestFinishingTouchesValueInSt = guestFinishingTouchesSnValue.split("__");
    	String guestFinishingTouchesValuesList = null;
    	for(int i = 0; i < guestFinishingTouchesValueInSt.length; i++) {
    		String[] checkSnValuesString = guestFinishingTouchesValueInSt[i].split("_,_");
    		if((ftIndividualPaymentSavingId).equals(checkSnValuesString[0])) {
    			String newFTContributedValuesList = checkSnValuesString[0] + "_,_" + guestNewIndividualQuantity + "_,_" + checkSnValuesString[2] + "_,_" + checkSnValuesString[3] + "_,_" + checkSnValuesString[4] + "_,_" + checkSnValuesString[5];
    			guestFinishingTouchesValuesList = guestFinishingTouchesValuesList + "__" + newFTContributedValuesList;
    		} else {
    			guestFinishingTouchesValuesList = guestFinishingTouchesValuesList + "__" + guestFinishingTouchesValueInSt[i];
    		}
    	}
    	if(guestFinishingTouchesValueInSt.length > 0) {
    		guestFinishingTouchesValuesList = guestFinishingTouchesValuesList.replaceFirst("null__", "");
    	}
    	int totalSnFTCartCount = (int) sn.getAttribute(guestFTIndividualCartCountInSn);
    	int guestFTCartCount = (totalSnFTCartCount - oldIndividualQuantity) + newIndividualQuantity;
    	sn.setAttribute(guestFTIndividualCartCountInSn, guestFTCartCount);    	
    	sn.setAttribute(guestFTIndividualCartValueInSn, guestFinishingTouchesValuesList);    	
    	double totalFinishingTouchesIndvPriceSn = (double) sn.getAttribute(guestFTIndividualPriceInSn);
    	double guestOldIndividualAmountDb = guestOldIndividualPriceDb * oldIndividualQuantity;
    	double guestNewIndividualAmountDb = guestOldIndividualPriceDb * newIndividualQuantity;    	
    	double totalFinishingTouchesIndvPrice = (totalFinishingTouchesIndvPriceSn - guestOldIndividualAmountDb) + guestNewIndividualAmountDb;
    	sn.setAttribute(guestFTIndividualPriceInSn, totalFinishingTouchesIndvPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);        
    	return ftIndividualAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonGuestFTContributedInfoDeleteFromDB(String regiFTContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantFTContributedAddCartJSonValueDeleteFromInDB(sn, req, regiFTContributedPaymentSavingId);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTContributedAddCartJSonValueDeleteFromInDB(HttpSession sn, HttpServletRequest req, String ftContributedPaymentSavingId) {
    	String ftContributedAddCartValue = null;        
    	String guestFinishingTouchesContSnValue = (String) sn.getAttribute(guestFTContributedCartValueInSn);    	
    	String[] guestFinishingTouchesContValueInSt = guestFinishingTouchesContSnValue.split("__");
    	String guestFinishingTouchesContValuesList = null;
    	double contributedSnPriceDb = 0;
    	int contributedCount = 0;
    	for(int i = 0; i < guestFinishingTouchesContValueInSt.length; i++) {
    		String[] checkSnValuesString = guestFinishingTouchesContValueInSt[i].split("_,_");
    		if((ftContributedPaymentSavingId).equals(checkSnValuesString[0])) {
    			contributedSnPriceDb = Double.parseDouble(checkSnValuesString[1]);
    			contributedCount = 1;
    		} else {
    			guestFinishingTouchesContValuesList = guestFinishingTouchesContValuesList + "__" + guestFinishingTouchesContValueInSt[i];    			
    		}
    	}
    	if(null != guestFinishingTouchesContValuesList) {
    		guestFinishingTouchesContValuesList = guestFinishingTouchesContValuesList.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestFTContributedCartValueInSn, guestFinishingTouchesContValuesList);
    	double totalFinishingTouchesContPriceSn = (double) sn.getAttribute(guestFTContributedPriceInSn);
    	double totalFinishingTouchesContPrice = totalFinishingTouchesContPriceSn - contributedSnPriceDb;
    	sn.setAttribute(guestFTContributedPriceInSn, totalFinishingTouchesContPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);    	
    	int totalSnFTCartCount = (int) sn.getAttribute(guestFTContributedCartCountInSn);
    	int guestFTCartCount = totalSnFTCartCount - contributedCount;
    	sn.setAttribute(guestFTContributedCartCountInSn, guestFTCartCount); 
    	return ftContributedAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonGuestFTIndividualInfoDeleteFromDB(String regiFTIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantFTIndividualAddCartJSonValueDeleteFromDB(sn, req, regiFTIndividualPaymentSavingId);
    	int allCartCountTotal = allCartCountTotalDisplay(sn);
        sn.setAttribute(cartCountInSn, allCartCountTotal);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, allCartCountTotal);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTIndividualAddCartJSonValueDeleteFromDB(HttpSession sn, HttpServletRequest req, String ftIndividualPaymentSavingId) {
    	String ftIndividualAddCartValue = null;               
        String guestFinishingTouchesSnValue = (String) sn.getAttribute(guestFTIndividualCartValueInSn);
        String[] guestFinishingTouchesValueInSt = guestFinishingTouchesSnValue.split("__");
    	String guestFinishingTouchesValuesList = null;
    	int snQuantity = 0;
    	double individualSnPriceDb = 0;
    	for(int i = 0; i < guestFinishingTouchesValueInSt.length; i++) {
    		String[] checkSnValuesString = guestFinishingTouchesValueInSt[i].split("_,_");
    		if((ftIndividualPaymentSavingId).equals(checkSnValuesString[0])) {
    			snQuantity = Integer.parseInt(checkSnValuesString[1]);
    			double contributedSnPriceDb = Double.parseDouble(checkSnValuesString[2]);
    			individualSnPriceDb = contributedSnPriceDb * snQuantity;
    		} else {
    			guestFinishingTouchesValuesList = guestFinishingTouchesValuesList + "__" + guestFinishingTouchesValueInSt[i];
    		}
    	}
    	if(null != guestFinishingTouchesValuesList) {
    		guestFinishingTouchesValuesList = guestFinishingTouchesValuesList.replaceFirst("null__", "");
    	}
    	int totalSnFTCartCount = (int) sn.getAttribute(guestFTIndividualCartCountInSn);
    	int guestFTCartCount = totalSnFTCartCount - snQuantity;
    	sn.setAttribute(guestFTIndividualCartCountInSn, guestFTCartCount);
    	sn.setAttribute(guestFTIndividualCartValueInSn, guestFinishingTouchesValuesList);    	
    	double totalFinishingTouchesIndvPriceSn = (double) sn.getAttribute(guestFTIndividualPriceInSn);    		
    	double totalFinishingTouchesIndvPrice = totalFinishingTouchesIndvPriceSn - individualSnPriceDb;
    	sn.setAttribute(guestFTIndividualPriceInSn, totalFinishingTouchesIndvPrice);    	
    	double allShoppingCartTotalAmount = allShoppingCartTotalAmountDisplay(sn);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(totalGuestFundAmountInSn, allShoppingCartTotalAmountSt);        
    	return ftIndividualAddCartValue;
    }
    
    

	
	

	@Override
	@Transactional
	public Timestamp currentDate() {
//		Timestamp currentDate = Timestamp.from(ZonedDateTime.now().toInstant());
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
