package com.nookandcove.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.nookandcove.dao.RegistrantCashFundBankAccountInfoSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsContributedPaymentSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsContributedProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsIndividualPaymentSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsIndividualProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantCustomGiftCardCodeSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesContributedPaymentSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesContributedProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesIndividualPaymentSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesIndividualProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.dao.RegistrantPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistrantShippingInfoSavingDAO;
import com.nookandcove.dao.RegistryCashFundsInfoSavingDAO;
import com.nookandcove.dao.RegistryCashFundsPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistryRoomFundsPaymentInfoSavingDAO;
import com.nookandcove.model.GuestConceptBoardsContributedPaymentSaving;
import com.nookandcove.model.GuestConceptBoardsIndividualPaymentSaving;
import com.nookandcove.model.GuestFinishingTouchesContributedPaymentSaving;
import com.nookandcove.model.GuestFinishingTouchesIndividualPaymentSaving;
import com.nookandcove.model.GuestRegistryCashFundsPaymentInfoSaving;
import com.nookandcove.model.GuestRoomFundPaymentInfoSaving;
import com.nookandcove.model.GuestUserPaymentInfoSaving;
import com.nookandcove.model.RegistrantCashFundBankAccountInfoSaving;
import com.nookandcove.model.RegistrantConceptBoardsContributedPaymentSaving;
import com.nookandcove.model.RegistrantConceptBoardsContributedProductsInfoSaving;
import com.nookandcove.model.RegistrantConceptBoardsIndividualPaymentSaving;
import com.nookandcove.model.RegistrantConceptBoardsIndividualProductsInfoSaving;
import com.nookandcove.model.RegistrantCustomGiftCardCodeSaving;
import com.nookandcove.model.RegistrantFinishingTouchesContributedPaymentSaving;
import com.nookandcove.model.RegistrantFinishingTouchesContributedProductsInfoSaving;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualPaymentSaving;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualProductsInfoSaving;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.RegistrantPaymentInfoSaving;
import com.nookandcove.model.RegistrantShippingInfoSaving;
import com.nookandcove.model.RegistryCashFundsInfoSaving;
import com.nookandcove.model.RegistryCashFundsPaymentInfoSaving;
import com.nookandcove.model.RegistryRoomFundsPaymentInfoSaving;
import com.nookandcove.service.RegistrantMyAccountService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class RegistrantMyAccountServiceImpl implements RegistrantMyAccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantMyAccountServiceImpl.class);
	private String regErrorPage = "regErrorPage";
	private String registrantUserIdInSn = "registrantUserIdInSn";
	private String registryContactInfoRed = "registryContactInfoRed";
	private String registryPasswordChangeRed = "registryPasswordChangeRed";
	private String registryEventInfoChangeRed = "registryEventInfoChangeRed";
	private String registryURLInfoChangeRed = "registryURLInfoChangeRed";
	private String registryPrivacyInfoChangeRed = "registryPrivacyInfoChangeRed";
	private String registrantShippingInfoDisplayRed = "registrantShippingInfoDisplayRed";
	private String registrantMyOrderDisplayRed = "registrantMyOrderDisplayRed";
	private String registrantGiftsReceivedDisplayRed = "registrantGiftsReceivedDisplayRed";
	private String registrantRoomFundsDisplayRed = "registrantRoomFundsDisplayRed";
	private String registrantCashFundsDisplayRed = "registrantCashFundsDisplayRed";
	private String registrantCashFundsBankAccountsRed = "registrantCashFundsBankAccountsRed";
	private String registrantStoreCreditDisplayRed = "registrantStoreCreditDisplayRed";
	private String regSuccSave = "regSuccSave";
	private String currentPassword = "currentPassword";
	private String newPassword = "newPassword";
	private String eventType = "eventType";
	private String regUserName = "regUserName";
	private String regFirstName = "regFirstName";
	private String regLastName = "regLastName";
	private String coRegFirstName = "coRegFirstName";
	private String coRegLastName = "coRegLastName";
	private String regAddress = "regAddress";
	private String eventMonth = "eventMonth";
	private String eventDay = "eventDay";
	private String eventYear = "eventYear";
	private String regiStatusInSn = "regiStatusInSn";
	private String regiCartCountInSn = "regiCartCountInSn";
	private String regTotalCartItems = "regTotalCartItems";
	private String maCartRegiSpaceInfoSn = "maCartRegiSpaceInfoSn";
	private String registryCashFundsPaymentInfoInSn = "registryCashFundsPaymentInfoInSn";
	private String registrantRoomFundsPaymentInfoSn = "registrantRoomFundsPaymentInfoSn";
	private String guestRoomFundsPaymentInfoSn = "guestRoomFundsPaymentInfoSn";
	private String registrantCashFundsPaymentInfoSn = "registrantCashFundsPaymentInfoSn";
	private String guestCashFundsPaymentInfoSn = "guestCashFundsPaymentInfoSn";
	private String regFirstNamesInSn = "regFirstNamesInSn";
	private String regFirstNames = "regFirstNames";
	private String regStatus = "regStatus";	
	private String regShippingAddress = "regShippingAddress";
	private String regShippingApartment = "regShippingApartment";
	private String regShippingCity = "regShippingCity";
	private String regShippingState = "regShippingState";
	private String regShippingZipCode = "regShippingZipCode";
	private String regShippingPhoneNumber = "regShippingPhoneNumber";
	private String regOrderReff = "Have Order";
	private String regiMAOrderReff = "regiMAOrderReff";
	private String roomFundDataForStoreCreditSn = "roomFundDataForStoreCreditSn";
	private String storeCreditRoomFundsPriceInSn = "storeCreditRoomFundsPriceInSn";
	private String roomFundPriceForStoreCredit = "roomFundPriceForStoreCredit";
	private String registrantGiftCardCode = "registrantGiftCardCode";
	private String totalCreditAmount = "totalCreditAmount";
	
	private String regConceptBoardPaymentIdsList = "regConceptBoardPaymentIdsList";
	private String regConceptBoardPaymentImageList = "regConceptBoardPaymentImageList";
	private String regConceptBoardPaymentNameList = "regConceptBoardPaymentNameList";
	private String regConceptBoardPaymentAmountList = "regConceptBoardPaymentAmountList";
	private String regConceptBoardPaymentStartDateList = "regConceptBoardPaymentStartDateList";
	private String regGRTrackingLinksList = "regGRTrackingLinksList";
	private String regGRBOTillDatesList = "regGRBOTillDatesList";
	private String registrantNameList = "registrantNameList";
	private String regConBoardAddCartValueInSn = "regConBoardAddCartValueInSn";
	private String guestConceptBoardPaymentIdsList = "guestConceptBoardPaymentIdsList";
	private String guestConceptBoardPaymentImageList = "guestConceptBoardPaymentImageList";
	private String guestConceptBoardPaymentNameList = "guestConceptBoardPaymentNameList";
	private String guestConceptBoardPaymentAmountList = "guestConceptBoardPaymentAmountList";
	private String guestConceptBoardPaymentStartDateList = "guestConceptBoardPaymentStartDateList";
	private String guestCBNameList = "guestCBNameList";
	private String guestGRTrackingLinksList = "guestGRTrackingLinksList";
	private String guestGRBOTillDatesList = "guestGRBOTillDatesList";
	private String guestConBoardAddCartValueInSn = "guestConBoardAddCartValueInSn";
	private String regConceptBoardContributePaymentIdsList = "regConceptBoardContributePaymentIdsList";
	private String regConceptBoardContributePaymentImageList = "regConceptBoardContributePaymentImageList";
	private String regConceptBoardContributePaymentNameList = "regConceptBoardContributePaymentNameList";
	private String regConceptBoardContributeTotalPriceList = "regConceptBoardContributeTotalPriceList";
	private String regConceptBoardTotalContributedDataList = "regConceptBoardTotalContributedDataList";
	private String registryAndGuestCBGiftReceivedStatusList = "registryAndGuestCBGiftReceivedStatusList";
	private String regContGRTrackingLinksList = "regContGRTrackingLinksList";
	private String regContGRBOTillDatesList = "regContGRBOTillDatesList";
	private String regConBoardContributeValueInSn = "regConBoardContributeValueInSn";
	private String guestConceptBoardContributePaymentIdsList = "guestConceptBoardContributePaymentIdsList";
	private String guestConBoardContributeValueInSn = "guestConBoardContributeValueInSn";
	private String registrantCBGiftReceivedStatusList = "registrantCBGiftReceivedStatusList";
	private String guestCBGiftReceivedStatusList = "guestCBGiftReceivedStatusList";
	private String redirectStatus = "redirect:";
	private String regiCashFundsDsp = "regiCashFundsDsp";
	private String conToStoreCreditStatus = "Converted to Store Credit";
	private String regConToStoreCreditRef = "regConToStoreCreditRef";
	private String orderProcessingStatus = "Order Processing";
	
	private String regFinishingTouchesPaymentIdsList = "regFinishingTouchesPaymentIdsList";
	private String regFinishingTouchesPaymentImageList = "regFinishingTouchesPaymentImageList";
	private String regFinishingTouchesPaymentNameList = "regFinishingTouchesPaymentNameList";
	private String regFinishingTouchesPaymentAmountList = "regFinishingTouchesPaymentAmountList";
	private String regFinishingTouchesPaymentStartDateList = "regFinishingTouchesPaymentStartDateList";
	private String ftRegistrantNameList = "ftRegistrantNameList";
	private String registrantFTGiftReceivedStatusList = "registrantFTGiftReceivedStatusList";
	private String regFTGRTrackingLinksList = "regFTGRTrackingLinksList";
	private String regFTGRBOTillDatesList = "regFTGRBOTillDatesList";
	private String guestFinishingTouchesPaymentIdsList = "guestFinishingTouchesPaymentIdsList";
	private String guestFinishingTouchesPaymentImageList = "guestFinishingTouchesPaymentImageList";
	private String guestFinishingTouchesPaymentNameList = "guestFinishingTouchesPaymentNameList";
	private String guestFinishingTouchesPaymentAmountList = "guestFinishingTouchesPaymentAmountList";
	private String guestFinishingTouchesPaymentStartDateList = "guestFinishingTouchesPaymentStartDateList";
	private String guestFTNameList = "guestFTNameList";
	private String guestFTGiftReceivedStatusList = "guestFTGiftReceivedStatusList";
	private String guestFTGRTrackingLinksList = "guestFTGRTrackingLinksList";
	private String guestFTGRBOTillDatesList = "guestFTGRBOTillDatesList";
	private String regFinishingTouchesContributePaymentIdsList = "regFinishingTouchesContributePaymentIdsList";
	private String regFinishingTouchesContributePaymentImageList = "regFinishingTouchesContributePaymentImageList";
	private String regFinishingTouchesContributePaymentNameList = "regFinishingTouchesContributePaymentNameList";
	private String regFinishingTouchesContributeTotalPriceList = "regFinishingTouchesContributeTotalPriceList";
	private String regFinishingTouchesTotalContributedDataList = "regFinishingTouchesTotalContributedDataList";
	private String registryAndGuestFTGiftReceivedStatusList = "registryAndGuestFTGiftReceivedStatusList";
	private String regFTContGRTrackingLinksList = "regFTContGRTrackingLinksList";
	private String regFTContGRBOTillDatesList = "regFTContGRBOTillDatesList";
	private String regFinTouchesAddCartValueInSn = "regFinTouchesAddCartValueInSn";
	private String guestFinTouchesAddCartValueInSn = "guestFinTouchesAddCartValueInSn";
	private String regFinTouchesContributeValueInSn = "regFinTouchesContributeValueInSn";
	
	private String rgConceptBoardACStoreCreditIdsList = "rgConceptBoardACStoreCreditIdsList";
	private String rgConceptBoardACStoreCreditImageList = "rgConceptBoardACStoreCreditImageList";
	private String rgConceptBoardACStoreCreditNameList = "rgConceptBoardACStoreCreditNameList";
	private String rgConceptBoardACStoreCreditAmountList = "rgConceptBoardACStoreCreditAmountList";
	private String storeCreditCBIndividualPriceInSn = "storeCreditCBIndividualPriceInSn";	
	private String rgConceptBoardContStoreCreditIdsList = "rgConceptBoardContStoreCreditIdsList";
	private String rgConceptBoardContStoreCreditImageList = "rgConceptBoardContStoreCreditImageList";
	private String rgConceptBoardContStoreCreditNameList = "rgConceptBoardContStoreCreditNameList";
	private String rgConceptBoardContStoreCreditAmountList = "rgConceptBoardContStoreCreditAmountList";
	private String storeCreditCBContributedPriceInSn = "storeCreditCBContributedPriceInSn";
	private String storeCreditFTContributedPriceInSn = "storeCreditFTContributedPriceInSn";
	private String storeCreditFTIndividualPriceInSn = "storeCreditFTIndividualPriceInSn";
	private String cashFundSmallImageUrl = "resources/images/cash_fund_images/small/";
	
	private String cashFundRoutingNumber = "cashFundRoutingNumber";
	private String cashFundAccountNumber = "cashFundAccountNumber";
	private String cashFundFirstName = "cashFundFirstName";
	private String cashFundLastName = "cashFundLastName";
	private String cashFundStreetAddress = "cashFundStreetAddress";
	private String cashFundAptOrUnit = "cashFundAptOrUnit";
	private String cashFundCity = "cashFundCity";
	private String cashFundState = "cashFundState";
	private String cashFundZipCode = "cashFundZipCode";
	private String cashFundPhoneNumber = "cashFundPhoneNumber";
	private String registryCFPaymentInfoSavingId = "registryCFPaymentInfoSavingId";
	private String guestCFPaymentInfoSavingId = "guestCFPaymentInfoSavingId";
	private String transferReqStatus = "Transfer Requested";
	private String haveDataReff = "Have Data";
	private String regiGiftsReceivedDsp = "regiGiftsReceivedDsp";
	
	private String regCBContributedProductIdsList = "regCBContributedProductIdsList";
	private String regCBContributedProductImageList = "regCBContributedProductImageList";
	private String regCBContributedProductNameList = "regCBContributedProductNameList";
	private String regCBContributedProductAmountList = "regCBContributedProductAmountList";
	private String regCBContributedProductQuantityList = "regCBContributedProductQuantityList";
	private String regCBContributedProductStartDateList = "regCBContributedProductStartDateList";
	private String regCBContributedProductOrderNoList = "regCBContributedProductOrderNoList";
	private String regCBIndividualProductIdsList = "regCBIndividualProductIdsList";
	private String regCBIndividualProductImageList = "regCBIndividualProductImageList";
	private String regCBIndividualProductNameList = "regCBIndividualProductNameList";
	private String regCBIndividualProductAmountList = "regCBIndividualProductAmountList";
	private String regCBIndividualProductQuantityList = "regCBIndividualProductQuantityList";
	private String regCBIndividualProductStartDateList = "regCBIndividualProductStartDateList";
	private String regCBIndividualProductOrderNoList = "regCBIndividualProductOrderNoList";

	private String regFTContributedProductIdsList = "regFTContributedProductIdsList";
	private String regFTContributedProductImageList = "regFTContributedProductImageList";
	private String regFTContributedProductNameList = "regFTContributedProductNameList";
	private String regFTContributedProductAmountList = "regFTContributedProductAmountList";
	private String regFTContributedProductQuantityList = "regFTContributedProductQuantityList";
	private String regFTContributedProductStartDateList = "regFTContributedProductStartDateList";
	private String regFTContributedProductOrderNoList = "regFTContributedProductOrderNoList";
	private String regFTIndividualProductIdsList = "regFTIndividualProductIdsList";
	private String regFTIndividualProductImageList = "regFTIndividualProductImageList";
	private String regFTIndividualProductNameList = "regFTIndividualProductNameList";
	private String regFTIndividualProductAmountList = "regFTIndividualProductAmountList";
	private String regFTIndividualProductQuantityList = "regFTIndividualProductQuantityList";
	private String regFTIndividualProductStartDateList = "regFTIndividualProductStartDateList";
	private String regFTIndividualProductOrderNoList = "regFTIndividualProductOrderNoList";
	
	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;
	
    @Autowired
    private GuestRoomFundPaymentInfoSavingDAO guestRoomFundPaymentInfoSavingDAO;

    @Autowired
    private RegistrantPaymentInfoSavingDAO registrantPaymentInfoSavingDAO;

    @Autowired
    private RegistryRoomFundsPaymentInfoSavingDAO registryRoomFundsPaymentInfoSavingDAO;

	@Autowired
	private GuestUserPaymentInfoSavingDAO guestUserPaymentInfoSavingDAO;

	@Autowired
	private RegistrantShippingInfoSavingDAO registrantShippingInfoSavingDAO;

	@Autowired
    private RegistrantCustomGiftCardCodeSavingDAO registrantCustomGiftCardCodeSavingDAO;

	@Autowired
	private RegistryCashFundsInfoSavingDAO registryCashFundsInfoSavingDAO;

	@Autowired
	private RegistryCashFundsPaymentInfoSavingDAO registryCashFundsPaymentInfoSavingDAO;

	@Autowired
	private GuestRegistryCashFundsPaymentInfoSavingDAO guestRegistryCashFundsPaymentInfoSavingDAO;

	@Autowired
	private RegistrantCashFundBankAccountInfoSavingDAO registrantCashFundBankAccountInfoSavingDAO;
	
	@Autowired
	private RegistrantConceptBoardsContributedProductsInfoSavingDAO registrantConceptBoardsContributedProductsInfoSavingDAO;

	@Autowired
	private RegistrantConceptBoardsIndividualProductsInfoSavingDAO registrantConceptBoardsIndividualProductsInfoSavingDAO;

	@Autowired
	private RegistrantConceptBoardsContributedPaymentSavingDAO registrantConceptBoardsContributedPaymentSavingDAO;

	@Autowired
	private RegistrantConceptBoardsIndividualPaymentSavingDAO registrantConceptBoardsIndividualPaymentSavingDAO;

	@Autowired
	private GuestConceptBoardsContributedPaymentSavingDAO guestConceptBoardsContributedPaymentSavingDAO;

	@Autowired
	private GuestConceptBoardsIndividualPaymentSavingDAO guestConceptBoardsIndividualPaymentSavingDAO;
	
	@Autowired
	private RegistrantFinishingTouchesIndividualPaymentSavingDAO registrantFinishingTouchesIndividualPaymentSavingDAO;
	
	@Autowired
	private RegistrantFinishingTouchesContributedPaymentSavingDAO registrantFinishingTouchesContributedPaymentSavingDAO;

	@Autowired
	private RegistrantFinishingTouchesContributedProductsInfoSavingDAO registrantFinishingTouchesContributedProductsInfoSavingDAO;

	@Autowired
	private RegistrantFinishingTouchesIndividualProductsInfoSavingDAO registrantFinishingTouchesIndividualProductsInfoSavingDAO;

	@Autowired
	private GuestFinishingTouchesIndividualPaymentSavingDAO guestFinishingTouchesIndividualPaymentSavingDAO;

	@Autowired
	private GuestFinishingTouchesContributedPaymentSavingDAO guestFinishingTouchesContributedPaymentSavingDAO;
	
	
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
    public ModelAndView registryMyAccountRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        String regiFirstName = regInfoSavingModel.getRegFirstName();
        String coRegiFirstName = regInfoSavingModel.getCoRegFirstName();
        String regiLastName = regInfoSavingModel.getRegLastName();
        String coRegiLastName = regInfoSavingModel.getCoRegLastName();
        String regEmail = regInfoSavingModel.getRegUserName();
        registrantGiftsReceivedSessionPutNull(req, sn);
    	mav = new ModelAndView(registryContactInfoRed);
    	mav.addObject(regFirstName, regiFirstName);
        mav.addObject(coRegFirstName, coRegiFirstName);
        mav.addObject(regLastName, regiLastName);
        mav.addObject(coRegLastName, coRegiLastName);
        mav.addObject(regUserName, regEmail);
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        sn.setAttribute(maCartRegiSpaceInfoSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantAccountInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List regDataVal = registrantInformationSavingDAO.findByUserName(req.getParameter(regUserName));
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
        String regEmail = regInfoSavingModel.getRegUserName();        
        regInfoSavingModel.setRegFirstName(req.getParameter(regFirstName));
        regInfoSavingModel.setCoRegFirstName(req.getParameter(coRegFirstName));
        regInfoSavingModel.setRegLastName(req.getParameter(regLastName));
        regInfoSavingModel.setCoRegLastName(req.getParameter(coRegLastName));	        
        registrantInformationSavingDAO.merge(regInfoSavingModel);        
        if (!regDataVal.isEmpty() && ("null" != req.getParameter(regUserName) && !(regEmail).equals(req.getParameter(regUserName)))) {
        	mav = registryMyAccountRedirection(req, sn);
            mav.addObject(regErrorPage, "This e-mail already exists!");
        } else {        
        	regInfoSavingModel.setRegUserName(req.getParameter(regUserName));
        	registrantInformationSavingDAO.merge(regInfoSavingModel);
//        	String lastSingleName = String.valueOf(req.getParameter(regLastName).charAt(0)).toUpperCase();
            String fCapName = req.getParameter(regFirstName).substring(0, 1).toUpperCase() + req.getParameter(regFirstName).substring(1);            
//            String fullName = fCapName +" "+lastSingleName;
            sn.setAttribute(regFirstNamesInSn, fCapName);
            sn.setAttribute("regiFirstNameInSn", req.getParameter(regFirstName));
        	sn.setAttribute("coRegiFirstNameInSn", req.getParameter(coRegFirstName));
        	mav = registryMyAccountRedirection(req, sn);
        	mav.addObject(regSuccSave, "Account Data Saved");
        }
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryPasswordChangeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));        
        String regEmail = regInfoSavingModel.getRegUserName();        
    	mav = new ModelAndView(registryPasswordChangeRed);
    	mav.addObject(regUserName, regEmail);
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantPasswordInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long regUserId = (Long) sn.getAttribute(registrantUserIdInSn);    	
        String currentPass = req.getParameter(currentPassword);
        String newPass = req.getParameter(newPassword);
        String encrypCurPassword = mD5Encrypt(currentPass);
        String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
        String encrypNewPassword = mD5Encrypt(newPass);
        String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);
        Timestamp currentDate = currentDate();
        RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regUserId);
        String oldPassSalt = regInfoSavingModel.getPasswordSalt();
        if (currentPasswordSalt.equals(oldPassSalt) && regUserId > 0) {
        	regInfoSavingModel.setPassword(encrypNewPassword);
        	regInfoSavingModel.setPasswordSalt(newPasswordSalt);
        	regInfoSavingModel.setLastPasswordChangedDate(currentDate);
            registrantInformationSavingDAO.merge(regInfoSavingModel);
            req.setAttribute(regSuccSave, "Password Saved");
        } else {
            req.setAttribute("changePasswordError", "Invalid Current Password");
        }
        mav = registryPasswordChangeRedirection(req, sn);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView registryEventInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String eventsDate = regInfoSavingModel.getEventDate();
 	   	String eventsType = regInfoSavingModel.getEventType();	   	
    	mav = new ModelAndView(registryEventInfoChangeRed);
    	mav.addObject(eventType, eventsType);
        mav.addObject(eventDay, eventsDate);
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantEventInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String eventDate = req.getParameter(eventMonth) + "/" + req.getParameter(eventDay) + "/" + req.getParameter(eventYear);
    	regInfoSavingModel.setEventType(req.getParameter(eventType));
    	regInfoSavingModel.setEventDate(eventDate);
//    	regInfoSavingModel.setEventState(req.getParameter(eventState));
        registrantInformationSavingDAO.merge(regInfoSavingModel);
        int monthInt = Integer.parseInt(req.getParameter(eventMonth));
        String month = new DateFormatSymbols().getMonths()[monthInt-1];
        String eventDateList = month + " " + req.getParameter(eventDay) + ", " + req.getParameter(eventYear);
        sn.setAttribute("eventDateInSn", eventDateList);
        mav = registryEventInfoRedirection(req, sn);
        mav.addObject(regSuccSave, "Event Info Saved");
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryURLInfoChangeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String regiAddress = regInfoSavingModel.getRegAddress();
    	String regiStatus = regInfoSavingModel.getStatus();
 	   	mav = new ModelAndView(registryURLInfoChangeRed);
    	mav.addObject(regAddress, regiAddress);
    	mav.addObject(regStatus, regiStatus);
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantURLInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regiAddress = req.getParameter(regAddress).toLowerCase();
    	List regAddressVal = registrantInformationSavingDAO.registryAddressDataTakeFromDB(regiAddress);
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String regiStatus = regInfoSavingModel.getStatus();
    	String regEDBAddress = regInfoSavingModel.getRegAddress();
    	if (!regAddressVal.isEmpty() && ("null" != regiAddress && !(regEDBAddress).equals(regiAddress))) {
        	mav = registryURLInfoChangeRedirection(req, sn);
            mav.addObject(regErrorPage, " This URL is already taken. Please try again.");
        } else {        
        	regInfoSavingModel.setRegAddress(regiAddress);
        	registrantInformationSavingDAO.merge(regInfoSavingModel);
        	mav = registryURLInfoChangeRedirection(req, sn);
        	mav.addObject(regSuccSave, "URL Info Saved");
        }
    	mav.addObject(regStatus, regiStatus);
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryPrivacyInfoChangeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String regiStatus = regInfoSavingModel.getStatus();
    	String regiAddress = regInfoSavingModel.getRegAddress();
 	   	mav = new ModelAndView(registryPrivacyInfoChangeRed);
    	mav.addObject(regStatus, regiStatus);
    	mav.addObject(regAddress, regiAddress);
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regGiveVisibleToGuestRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	String doneStatus = "Done";
    	regInfoSavingModel.setStatus(doneStatus);
    	registrantInformationSavingDAO.merge(regInfoSavingModel);
    	sn.setAttribute(regiStatusInSn, doneStatus);
        mav = registryPrivacyInfoChangeRedirection(req, sn);
        mav.addObject(regSuccSave, "Visible To Guest");
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regGiveNotVisibleToGuestRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
    	regInfoSavingModel.setStatus(null);
    	registrantInformationSavingDAO.merge(regInfoSavingModel);
    	sn.setAttribute(regiStatusInSn, null);
        mav = registryPrivacyInfoChangeRedirection(req, sn);
        //mav.addObject(regSuccSave, "Not Visible To Guest");
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView registrantShippingInfoDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantShippingInfoSaving> regiShippingInfoSavingList = registrantShippingInfoSavingDAO.selectedShippingAddressRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regiShippingInfoSavingList.isEmpty()) {
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa((Long) sn.getAttribute(registrantUserIdInSn));
    		mav = new ModelAndView(registrantShippingInfoDisplayRed);
    		mav.addObject(regShippingAddress, regiShippingInfoSavingModel.getShippingAddress());
    		mav.addObject(regShippingApartment, regiShippingInfoSavingModel.getApartment());
    		mav.addObject(regShippingCity, regiShippingInfoSavingModel.getCity());
    		mav.addObject(regShippingState, regiShippingInfoSavingModel.getState());
    		mav.addObject(regShippingZipCode, regiShippingInfoSavingModel.getZip());
    		mav.addObject(regShippingPhoneNumber, regiShippingInfoSavingModel.getPhoneNumber());
    	} else {
    		mav = new ModelAndView(registrantShippingInfoDisplayRed);
    	} 	   	
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantShippingInfoSavingInDataBaseTable(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regiFullName = registryUserFullNameTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	String checkBoxStatus = "on";
    	List<RegistrantShippingInfoSaving> regiShippingInfoSavingList = registrantShippingInfoSavingDAO.selectedShippingAddressRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	Timestamp currentDate = currentDate();
    	if (!regiShippingInfoSavingList.isEmpty()) {
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa((Long) sn.getAttribute(registrantUserIdInSn));
    		regiShippingInfoSavingModel.setRegistrantFullNname(regiFullName);
    		regiShippingInfoSavingModel.setShippingAddress(req.getParameter(regShippingAddress));
    		regiShippingInfoSavingModel.setApartment(req.getParameter(regShippingApartment));
    		regiShippingInfoSavingModel.setCity(req.getParameter(regShippingCity));
    		regiShippingInfoSavingModel.setState(req.getParameter(regShippingState));
    		regiShippingInfoSavingModel.setZip(req.getParameter(regShippingZipCode));
    		regiShippingInfoSavingModel.setPhoneNumber(req.getParameter(regShippingPhoneNumber));
    		regiShippingInfoSavingModel.setShippingStatus(checkBoxStatus);
    		regiShippingInfoSavingModel.setUpdatedDate(currentDate);
    		registrantShippingInfoSavingDAO.merge(regiShippingInfoSavingModel);
    	} else {
    		RegistrantShippingInfoSaving regShippingInfoSavingModel = new RegistrantShippingInfoSaving();
    		regShippingInfoSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regShippingInfoSavingModel.setRegistrantFullNname(regiFullName);
    		regShippingInfoSavingModel.setShippingAddress(req.getParameter(regShippingAddress));
    		regShippingInfoSavingModel.setApartment(req.getParameter(regShippingApartment));
    		regShippingInfoSavingModel.setCity(req.getParameter(regShippingCity));
    		regShippingInfoSavingModel.setState(req.getParameter(regShippingState));
    		regShippingInfoSavingModel.setZip(req.getParameter(regShippingZipCode));
    		regShippingInfoSavingModel.setPhoneNumber(req.getParameter(regShippingPhoneNumber));
    		regShippingInfoSavingModel.setShippingStatus(checkBoxStatus);
    		regShippingInfoSavingModel.setCreatedDate(currentDate);
    		registrantShippingInfoSavingDAO.save(regShippingInfoSavingModel);
    	}    	
 	   	mav = registrantShippingInfoDisplayRedirection(req, sn);
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantMyOrderDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regMyOrderRef = null;
    	String maCartRegSpaceInfoComList = registrantRoomFundsDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	String registrantCashFundsPaymentInfList = registrantMACashFundsDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	String regCBContributedPaymentData = registrantCBContributedPaymentDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	String regCBIndividualPaymentData = registrantCBIndividualPaymentDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn)); 
    	String regFTContributedPaymentData = registrantFTContributedPaymentDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	String regFTIndividualPaymentData = registrantFTIndividualPaymentDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	if((null != maCartRegSpaceInfoComList) || (null != registrantCashFundsPaymentInfList) || (null != regCBContributedPaymentData) || (null != regCBIndividualPaymentData) || (null != regFTContributedPaymentData) || (null != regFTIndividualPaymentData)) {
    		regMyOrderRef = regOrderReff;
    	}  	
 	   	mav = new ModelAndView(registrantMyOrderDisplayRed);
 	   	mav.addObject(regSuccSave, regMyOrderRef);	
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    public String registrantRoomFundsDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String maCartRegSpaceInfoComList = null;    	
    	List<RegistryRoomFundsPaymentInfoSaving> regCashFundInfoList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundsPackageRowCheckingInDB(registrantUserId);
    	String maCartRegSpaceInfoList = null;
    	if (!regCashFundInfoList.isEmpty()) {
    		for (RegistryRoomFundsPaymentInfoSaving regCashFundSavingModel : regCashFundInfoList) {
    			maCartRegSpaceInfoList = regCashFundSavingModel.getSelectedRoomFundsInfo();
    			long regPaymentInfoSavingId = regCashFundSavingModel.getRegistrantPaymentInfoSavingId();
    			long orderNo = 0;
    			if(regPaymentInfoSavingId > 0) {
    				RegistrantPaymentInfoSaving regPaymentInfoModel = registrantPaymentInfoSavingDAO.registryTransactionNumberTakeFromDB(registrantUserId, regPaymentInfoSavingId);
    				orderNo = regPaymentInfoModel.getTransactionNumber();
    			}    	    	  	    	
    	    	Timestamp tsDate = regCashFundSavingModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(tsDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	maCartRegSpaceInfoList = maCartRegSpaceInfoList.replaceFirst("null__", "");
    	    	String maCartTotRegSpaceInfoList = maCartRegSpaceInfoList + "_&_" + createdDate + "_&_" + orderNo;
    	    	maCartRegSpaceInfoComList = maCartRegSpaceInfoComList + "_&&_" + maCartTotRegSpaceInfoList;
        	}
    		maCartRegSpaceInfoComList = maCartRegSpaceInfoComList.replaceFirst("null_&&_", "");
    		sn.setAttribute(maCartRegiSpaceInfoSn, maCartRegSpaceInfoComList);	    	
    	} 
 	   	return maCartRegSpaceInfoComList;
    }

    public String registrantMACashFundsDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String registrantCashFundsPaymentInfList = null;    	
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsMyAccountsDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCashFundAddCartRowList.isEmpty()) {
    		for (RegistryCashFundsPaymentInfoSaving regCashFundSavingModel : regCashFundAddCartRowList) {
    			String regCashFundPrice = regCashFundSavingModel.getContributedCashFundPrice();
    	    	String registrantCashsFundName = regCashFundSavingModel.getCashFundName();
    	    	Timestamp regCrDate = regCashFundSavingModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(regCrDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	long regPaymentInfoSavingId = regCashFundSavingModel.getRegistrantPaymentInfoSavingId();
    			long orderNo = 0;
    			if(regPaymentInfoSavingId > 0) {
    				RegistrantPaymentInfoSaving regPaymentInfoModel = registrantPaymentInfoSavingDAO.registryTransactionNumberTakeFromDB(registrantUserId, regPaymentInfoSavingId);
    				orderNo = regPaymentInfoModel.getTransactionNumber();
    			}
    	    	String registrantCashFundImage = registrantCashFundImageTakeFromDB(req, sn, registrantUserId, regCashFundSavingModel.getRegistryCashFundsInfoSavingId());
    	    	String registrantCashFundsList = registrantCashFundImage + ",_," + registrantCashsFundName + ",_," + regCashFundPrice + ",_," + createdDate + ",_," + orderNo;
    	    	registrantCashFundsPaymentInfList = registrantCashFundsPaymentInfList + "__" + registrantCashFundsList;   	    	    	    	
        	}
    		registrantCashFundsPaymentInfList = registrantCashFundsPaymentInfList.replaceFirst("null__", "");
    		sn.setAttribute(registryCashFundsPaymentInfoInSn, registrantCashFundsPaymentInfList);
    	}    	
 	   	return registrantCashFundsPaymentInfList;
    }

    public String registrantCBContributedPaymentDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regCBContributedPaymentData = null;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedSavingList = registrantConceptBoardsContributedPaymentSavingDAO.regConceptBoardsContributedMyAccountDataDisplay(registrantUserId);
    	List regiCBContributedProductIdsList = new ArrayList();
    	List regiCBContributedProductImageList = new ArrayList();
    	List regiCBContributedProductNameList = new ArrayList();
    	List regiCBContributedProductAmountList = new ArrayList();
    	List regiCBContributedProductQuantityList = new ArrayList();
    	List regiCBContributedProductStartDateList = new ArrayList();
    	List regiCBContributedProductOrderNoList = new ArrayList();
    	if (!regCBContributedSavingList.isEmpty()) {        	
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedSavingModel : regCBContributedSavingList) {
    			regiCBContributedProductIdsList.add(regCBContributedSavingModel.getRegistrantConceptBoardsContributedPaymentSavingId());
    			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());    			
    			regiCBContributedProductImageList.add(regCBContributedUpdateModel.getProductUploadedImage());
    			regiCBContributedProductNameList.add(regCBContributedUpdateModel.getProductName());
    			regiCBContributedProductAmountList.add(regCBContributedSavingModel.getContributedPrice());
    			regiCBContributedProductQuantityList.add(regCBContributedUpdateModel.getQuantity());
    			Timestamp tsDate = regCBContributedUpdateModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(tsDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	regiCBContributedProductStartDateList.add(createdDate);    			
    			long regPaymentInfoSavingId = regCBContributedSavingModel.getRegistrantPaymentInfoSavingId();
    			long orderNo = 0;
    			if(regPaymentInfoSavingId > 0) {
    				RegistrantPaymentInfoSaving regPaymentInfoModel = registrantPaymentInfoSavingDAO.registryTransactionNumberTakeFromDB(registrantUserId, regPaymentInfoSavingId);
    				orderNo = regPaymentInfoModel.getTransactionNumber();
    			}
    			regiCBContributedProductOrderNoList.add(orderNo);
    			sn.setAttribute(regCBContributedProductIdsList, regiCBContributedProductIdsList);
    			sn.setAttribute(regCBContributedProductImageList, regiCBContributedProductImageList);
    			sn.setAttribute(regCBContributedProductNameList, regiCBContributedProductNameList);
    			sn.setAttribute(regCBContributedProductAmountList, regiCBContributedProductAmountList);
    			sn.setAttribute(regCBContributedProductQuantityList, regiCBContributedProductQuantityList);
    			sn.setAttribute(regCBContributedProductStartDateList, regiCBContributedProductStartDateList);
    			sn.setAttribute(regCBContributedProductOrderNoList, regiCBContributedProductOrderNoList);    			
    		}
    		regCBContributedPaymentData = haveDataReff;
        } 
 	   	return regCBContributedPaymentData;
    }

    public String registrantCBIndividualPaymentDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regCBIndividualPaymentData = null;
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.regConceptBoardsIndividualMyAccountDataDisplay(registrantUserId);
    	List regiCBIndividualProductIdsList = new ArrayList();
    	List regiCBIndividualProductImageList = new ArrayList();
    	List regiCBIndividualProductNameList = new ArrayList();
    	List regiCBIndividualProductAmountList = new ArrayList();
    	List regiCBIndividualProductStartDateList = new ArrayList();
    	List regiCBIndividualProductOrderNoList = new ArrayList();
    	if (!regCBIndividualSavingList.isEmpty()) {        	
    		for (RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualSavingModel : regCBIndividualSavingList) {
    			regiCBIndividualProductIdsList.add(regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualPaymentSavingId());
    			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());    			
    			regiCBIndividualProductImageList.add(regCBIndividualUpdateModel.getProductUploadedImage());
    			regiCBIndividualProductNameList.add(regCBIndividualUpdateModel.getProductName());
    			double totalProdPriceDb = Double.parseDouble(regCBIndividualUpdateModel.getProductPrice());
    			int giftedQuantity = regCBIndividualSavingModel.getGiftedQuantity();
    			double totalGiftedPrice = totalProdPriceDb * giftedQuantity;
    			double totalGuestIndWithTaxAmount = totalGiftedPrice + (totalGiftedPrice/100)*18;
            	String totalRegProductAmountSt = String.format("%,.2f", totalGuestIndWithTaxAmount);
    			regiCBIndividualProductAmountList.add(totalRegProductAmountSt);
    			Timestamp tsDate = regCBIndividualUpdateModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(tsDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	regiCBIndividualProductStartDateList.add(createdDate);    			
    			long regPaymentInfoSavingId = regCBIndividualSavingModel.getRegistrantPaymentInfoSavingId();
    			long orderNo = 0;
    			if(regPaymentInfoSavingId > 0) {
    				RegistrantPaymentInfoSaving regPaymentInfoModel = registrantPaymentInfoSavingDAO.registryTransactionNumberTakeFromDB(registrantUserId, regPaymentInfoSavingId);
    				orderNo = regPaymentInfoModel.getTransactionNumber();
    			}
    			regiCBIndividualProductOrderNoList.add(orderNo);
    			sn.setAttribute(regCBIndividualProductIdsList, regiCBIndividualProductIdsList);
    			sn.setAttribute(regCBIndividualProductImageList, regiCBIndividualProductImageList);
    			sn.setAttribute(regCBIndividualProductNameList, regiCBIndividualProductNameList);
    			sn.setAttribute(regCBIndividualProductAmountList, regiCBIndividualProductAmountList);
    			sn.setAttribute(regCBIndividualProductStartDateList, regiCBIndividualProductStartDateList);
    			sn.setAttribute(regCBIndividualProductOrderNoList, regiCBIndividualProductOrderNoList);    			
    		}
    		regCBIndividualPaymentData = haveDataReff;
        }
 	   	return regCBIndividualPaymentData;
    }

    public String registrantFTContributedPaymentDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regFTContributedPaymentData = null;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedSavingList = registrantFinishingTouchesContributedPaymentSavingDAO.regFinishingTouchesContributedMyAccountDataDisplay(registrantUserId);
    	List regiFTContributedProductIdsList = new ArrayList();
    	List regiFTContributedProductImageList = new ArrayList();
    	List regiFTContributedProductNameList = new ArrayList();
    	List regiFTContributedProductAmountList = new ArrayList();
    	List regiFTContributedProductQuantityList = new ArrayList();
    	List regiFTContributedProductStartDateList = new ArrayList();
    	List regiFTContributedProductOrderNoList = new ArrayList();
    	if (!regFTContributedSavingList.isEmpty()) {        	
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedSavingModel : regFTContributedSavingList) {
    			regiFTContributedProductIdsList.add(regFTContributedSavingModel.getRegistrantFinishingTouchesContributedPaymentSavingId());
    			RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());    			
    			regiFTContributedProductImageList.add(regFTContributedUpdateModel.getProductUploadedImage());
    			regiFTContributedProductNameList.add(regFTContributedUpdateModel.getProductName());
    			regiFTContributedProductAmountList.add(regFTContributedSavingModel.getContributedPrice());
    			regiFTContributedProductQuantityList.add(regFTContributedUpdateModel.getQuantity());
    			Timestamp tsDate = regFTContributedUpdateModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(tsDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	regiFTContributedProductStartDateList.add(createdDate);    			
    			long regPaymentInfoSavingId = regFTContributedSavingModel.getRegistrantPaymentInfoSavingId();
    			long orderNo = 0;
    			if(regPaymentInfoSavingId > 0) {
    				RegistrantPaymentInfoSaving regPaymentInfoModel = registrantPaymentInfoSavingDAO.registryTransactionNumberTakeFromDB(registrantUserId, regPaymentInfoSavingId);
    				orderNo = regPaymentInfoModel.getTransactionNumber();
    			}
    			regiFTContributedProductOrderNoList.add(orderNo);
    			sn.setAttribute(regFTContributedProductIdsList, regiFTContributedProductIdsList);
    			sn.setAttribute(regFTContributedProductImageList, regiFTContributedProductImageList);
    			sn.setAttribute(regFTContributedProductNameList, regiFTContributedProductNameList);
    			sn.setAttribute(regFTContributedProductAmountList, regiFTContributedProductAmountList);
    			sn.setAttribute(regFTContributedProductQuantityList, regiFTContributedProductQuantityList);
    			sn.setAttribute(regFTContributedProductStartDateList, regiFTContributedProductStartDateList);
    			sn.setAttribute(regFTContributedProductOrderNoList, regiFTContributedProductOrderNoList);    			
    		}
    		regFTContributedPaymentData = haveDataReff;
        } 
 	   	return regFTContributedPaymentData;
    }

    public String registrantFTIndividualPaymentDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String regFTIndividualPaymentData = null;
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.regFinishingTouchesIndividualMyAccountDataDisplay(registrantUserId);
    	List regiFTIndividualProductIdsList = new ArrayList();
    	List regiFTIndividualProductImageList = new ArrayList();
    	List regiFTIndividualProductNameList = new ArrayList();
    	List regiFTIndividualProductAmountList = new ArrayList();
    	List regiFTIndividualProductStartDateList = new ArrayList();
    	List regiFTIndividualProductOrderNoList = new ArrayList();
    	if (!regFTIndividualSavingList.isEmpty()) {        	
    		for (RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualSavingModel : regFTIndividualSavingList) {
    			regiFTIndividualProductIdsList.add(regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualPaymentSavingId());
    			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());    			
    			regiFTIndividualProductImageList.add(regFTIndividualUpdateModel.getProductUploadedImage());
    			regiFTIndividualProductNameList.add(regFTIndividualUpdateModel.getProductName());
    			double totalProdPriceDb = Double.parseDouble(regFTIndividualUpdateModel.getProductPrice());
    			int giftedQuantity = regFTIndividualSavingModel.getGiftedQuantity();
    			double totalGiftedPrice = totalProdPriceDb * giftedQuantity;
    			double totalGuestIndWithTaxAmount = totalGiftedPrice + (totalGiftedPrice/100)*18;
            	String totalRegProductAmountSt = String.format("%,.2f", totalGuestIndWithTaxAmount);
    			regiFTIndividualProductAmountList.add(totalRegProductAmountSt);
    			Timestamp tsDate = regFTIndividualUpdateModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(tsDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	regiFTIndividualProductStartDateList.add(createdDate);    			
    			long regPaymentInfoSavingId = regFTIndividualSavingModel.getRegistrantPaymentInfoSavingId();
    			long orderNo = 0;
    			if(regPaymentInfoSavingId > 0) {
    				RegistrantPaymentInfoSaving regPaymentInfoModel = registrantPaymentInfoSavingDAO.registryTransactionNumberTakeFromDB(registrantUserId, regPaymentInfoSavingId);
    				orderNo = regPaymentInfoModel.getTransactionNumber();
    			}
    			regiFTIndividualProductOrderNoList.add(orderNo);
    			sn.setAttribute(regFTIndividualProductIdsList, regiFTIndividualProductIdsList);
    			sn.setAttribute(regFTIndividualProductImageList, regiFTIndividualProductImageList);
    			sn.setAttribute(regFTIndividualProductNameList, regiFTIndividualProductNameList);
    			sn.setAttribute(regFTIndividualProductAmountList, regiFTIndividualProductAmountList);
    			sn.setAttribute(regFTIndividualProductStartDateList, regiFTIndividualProductStartDateList);
    			sn.setAttribute(regFTIndividualProductOrderNoList, regiFTIndividualProductOrderNoList);    			
    		}
    		regFTIndividualPaymentData = haveDataReff;
        }
 	   	return regFTIndividualPaymentData;
    }

    @Override
    @Transactional
    public ModelAndView conceptBoardsGiftsReceivedDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regMyOrderRef = null;    	
    	registrantCBIndividualGiftReceivedDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	guestCBIndividualGiftReceivedDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registrantCBContributedGiftReceivedDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registrantFTIndividualGiftReceivedDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	guestFTIndividualGiftReceivedDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registrantFTContributedGiftReceivedDataTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = new ModelAndView(registrantGiftsReceivedDisplayRed);
 	   	mav.addObject(regSuccSave, regMyOrderRef);	
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    public String registrantCBIndividualGiftReceivedDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
	  	String regCBIndividualGiftReceived = null;
	  	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.regConceptBoardsIndividualMyAccountDataDisplay(registrantUserId);
	  	List conceptBoardPaymentIdsList = new ArrayList();
	  	List conceptBoardProImageList = new ArrayList();
	  	List conceptBoardProNameList = new ArrayList();
	  	List conceptBoardProAmountList = new ArrayList();
	  	List conceptBoardProStartDateList = new ArrayList();
	  	List conceptBoardGiftRecStatusList = new ArrayList();
	  	List registrantNamesList = new ArrayList();
	  	List regiGRTrackingLinksList = new ArrayList();
	  	List regiGRBOTillDatesList = new ArrayList();
	  	if (!regCBIndividualSavingList.isEmpty()) {        	
	  		for (RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualSavingModel : regCBIndividualSavingList) {
	  			conceptBoardPaymentIdsList.add(regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualPaymentSavingId());
	  			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(registrantUserId, regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
	  			conceptBoardProImageList.add(regCBIndividualUpdateModel.getProductUploadedImage());
	  			conceptBoardProNameList.add(regCBIndividualUpdateModel.getProductName());	  			
	  			double totalProdPriceDb = Double.parseDouble(regCBIndividualUpdateModel.getProductPrice());
    			int giftedQuantity = regCBIndividualSavingModel.getGiftedQuantity();
    			double totalGiftedPrice = totalProdPriceDb * giftedQuantity;
    			double totalGuestIndWithTaxAmount = totalGiftedPrice + (totalGiftedPrice/100)*18;
            	String totalRegProductAmountSt = String.format("%,.2f", totalGuestIndWithTaxAmount);
            	conceptBoardProAmountList.add(totalRegProductAmountSt);
	  			Timestamp tsDate = regCBIndividualSavingModel.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  	    	conceptBoardProStartDateList.add(createdDate);    			
	  	    	String regiFullName = registryUserFullNameTakeFromDB(req, sn, registrantUserId);
	  	        registrantNamesList.add(regiFullName);
	  	        conceptBoardGiftRecStatusList.add(regCBIndividualSavingModel.getIndividualStatus());
	  	        String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regCBIndividualSavingModel.getTrackingLink() + "> Track</a>";
	  	        regiGRTrackingLinksList.add(trackLinkUrl);
	  	        regiGRBOTillDatesList.add(regCBIndividualSavingModel.getStatus());
	  			sn.setAttribute(regConceptBoardPaymentIdsList, conceptBoardPaymentIdsList);
	  			sn.setAttribute(regConceptBoardPaymentImageList, conceptBoardProImageList);
	  			sn.setAttribute(regConceptBoardPaymentNameList, conceptBoardProNameList);
	  			sn.setAttribute(regConceptBoardPaymentAmountList, conceptBoardProAmountList);
	  			sn.setAttribute(regConceptBoardPaymentStartDateList, conceptBoardProStartDateList);
	  			sn.setAttribute(registrantNameList, registrantNamesList);
	  			sn.setAttribute(registrantCBGiftReceivedStatusList, conceptBoardGiftRecStatusList);
	  			sn.setAttribute(regGRTrackingLinksList, regiGRTrackingLinksList);
	  			sn.setAttribute(regGRBOTillDatesList, regiGRBOTillDatesList);
	  		}
	  		sn.setAttribute(regConBoardAddCartValueInSn, "Have RCB Add Cart Data");
	    } 
		return regCBIndividualGiftReceived;
    }
  
    public String guestCBIndividualGiftReceivedDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String guestCBIndividualGiftReceived = null;
	  	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.regConceptBoardsIndividualMyAccountDataDisplay(registrantUserId);
	  	List guestConBoardPaymentIdsList = new ArrayList();
	  	List guestConBoardProImageList = new ArrayList();
	  	List guestConBoardProNameList = new ArrayList();
	  	List guestConBoardProAmountList = new ArrayList();
	  	List guestConBoardProStartDateList = new ArrayList();
	  	List guestConBoardGiftRecStatusList = new ArrayList();
	  	List registrantNamesList = new ArrayList();
	  	List gustGRTrackingLinksList = new ArrayList();
	  	List gustGRBOTillDatesList = new ArrayList();
	  	if (!guestCBIndividualSavingList.isEmpty()) {        	
	  		for (GuestConceptBoardsIndividualPaymentSaving guestCBIndividualSavingModel : guestCBIndividualSavingList) {
	  			guestConBoardPaymentIdsList.add(guestCBIndividualSavingModel.getGuestConceptBoardsIndividualPaymentSavingId());
	  			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(registrantUserId, guestCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
	  			guestConBoardProImageList.add(regCBIndividualUpdateModel.getProductUploadedImage());
	  			guestConBoardProNameList.add(regCBIndividualUpdateModel.getProductName());	  			
	  			double totalProdPriceDb = Double.parseDouble(regCBIndividualUpdateModel.getProductPrice());
    			int giftedQuantity = guestCBIndividualSavingModel.getGiftedQuantity();
    			double totalGiftedPrice = totalProdPriceDb * giftedQuantity;
    			double totalGuestIndWithTaxAmount = totalGiftedPrice + (totalGiftedPrice/100)*18;
            	String totalRegProductAmountSt = String.format("%,.2f", totalGuestIndWithTaxAmount);
            	guestConBoardProAmountList.add(totalRegProductAmountSt);
	  			Timestamp tsDate = guestCBIndividualSavingModel.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  	    	guestConBoardProStartDateList.add(createdDate);    			
	  	    	String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestCBIndividualSavingModel.getGuestUserPaymentInfoSavingId());
	  	        registrantNamesList.add(guestFullName);
	  	        guestConBoardGiftRecStatusList.add(guestCBIndividualSavingModel.getIndividualStatus());
	  	        String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + guestCBIndividualSavingModel.getTrackingLink() + "> Track</a>";
	  	        gustGRTrackingLinksList.add(trackLinkUrl);
	  	        gustGRBOTillDatesList.add(guestCBIndividualSavingModel.getStatus());
	  			sn.setAttribute(guestConceptBoardPaymentIdsList, guestConBoardPaymentIdsList);
	  			sn.setAttribute(guestConceptBoardPaymentImageList, guestConBoardProImageList);
	  			sn.setAttribute(guestConceptBoardPaymentNameList, guestConBoardProNameList);
	  			sn.setAttribute(guestConceptBoardPaymentAmountList, guestConBoardProAmountList);
	  			sn.setAttribute(guestConceptBoardPaymentStartDateList, guestConBoardProStartDateList);
	  			sn.setAttribute(guestCBNameList, registrantNamesList);
	  			sn.setAttribute(guestCBGiftReceivedStatusList, guestConBoardGiftRecStatusList);
	  			sn.setAttribute(guestGRTrackingLinksList, gustGRTrackingLinksList);
	  			sn.setAttribute(guestGRBOTillDatesList, gustGRBOTillDatesList);
	  		}
	  		sn.setAttribute(guestConBoardAddCartValueInSn, "Have GCB Add Cart Data");
	    } 
		return guestCBIndividualGiftReceived;
    }
    
    public String registrantCBContributedGiftReceivedDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
	  	String cbContributedData = null;
	  	List conceptBoardPaymentIdsList = new ArrayList();
	  	List conceptBoardProImageList = new ArrayList();	  	
	  	List conceptBoardProNameList = new ArrayList();
	  	List conceptBoardTotalPriceList = new ArrayList();
	  	List regTotalContributedDataList = new ArrayList();
	  	List regAndGuetCBGiftReceivedStatusList = new ArrayList();
	  	List regiContGRTrackingLinksList = new ArrayList();
	  	List regiContGRBOTillDatesList = new ArrayList();
	  	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedMyAccountsDataDisplay(registrantUserId);
	  	if (!regCBContributedSavingList.isEmpty()) {
	  		for (RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingLoop : regCBContributedSavingList) {
	  			conceptBoardPaymentIdsList.add(regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());
	  			conceptBoardProImageList.add(regCBContributedSavingLoop.getProductUploadedImage());
	  			conceptBoardProNameList.add(regCBContributedSavingLoop.getProductName());
	  			double totalContributedPriceDb = Double.parseDouble(regCBContributedSavingLoop.getContributedPrice());
	  			String totalContributedPrice = String.format("%.2f", totalContributedPriceDb);
	  			conceptBoardTotalPriceList.add(totalContributedPrice);
	  			String regCBContributedValue = giftReceivedCBContributedValuesList(req, sn, registrantUserId, regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());
	  			regTotalContributedDataList.add(regCBContributedValue);
	  			regAndGuetCBGiftReceivedStatusList.add(regCBContributedSavingLoop.getContributedStatus());
	  			String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regCBContributedSavingLoop.getTrackingLink() + "> Track</a>";
	  			regiContGRTrackingLinksList.add(trackLinkUrl);
	  			regiContGRBOTillDatesList.add(regCBContributedSavingLoop.getStatus());
	  		}
	  		sn.setAttribute(regConBoardContributeValueInSn, "Have RCB Contribute Data");
	  	}
	  	sn.setAttribute(regConceptBoardContributePaymentIdsList, conceptBoardPaymentIdsList);
		sn.setAttribute(regConceptBoardContributePaymentImageList, conceptBoardProImageList);
		sn.setAttribute(regConceptBoardContributePaymentNameList, conceptBoardProNameList);
		sn.setAttribute(regConceptBoardContributeTotalPriceList, conceptBoardTotalPriceList);
		sn.setAttribute(regConceptBoardTotalContributedDataList, regTotalContributedDataList);
		sn.setAttribute(registryAndGuestCBGiftReceivedStatusList, regAndGuetCBGiftReceivedStatusList);
		sn.setAttribute(regContGRTrackingLinksList, regiContGRTrackingLinksList);
		sn.setAttribute(regContGRBOTillDatesList, regiContGRBOTillDatesList);
		return cbContributedData;
    }
    
    public String giftReceivedCBContributedValuesList(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductsId) {
	  	String cbContributedData = null;
	  	List<GuestConceptBoardsContributedPaymentSaving> guestCBContributedSavingList = guestConceptBoardsContributedPaymentSavingDAO.guestGiftReceivedCBContributeAmountCheckingInDB(registrantUserId, cbContributedProductsId);
	  	if (!guestCBContributedSavingList.isEmpty()) {
	  		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingLoop : guestCBContributedSavingList) {
	  			String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestCBContributedSavingLoop.getGuestUserPaymentInfoSavingId());
	  			double cbPriceDb = Double.parseDouble(guestCBContributedSavingLoop.getContributedPrice());
	  			String cbPriceSt = String.format("%.2f", cbPriceDb);
	  			Timestamp tsDate = guestCBContributedSavingLoop.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  			String guestCombValue = guestFullName + "_,_" + createdDate + "_,_" + cbPriceSt + "_,_" + guestCBContributedSavingLoop.getContributedStatus();
	  			cbContributedData = cbContributedData + "__" +guestCombValue;
	  		}
	  		cbContributedData = cbContributedData.replaceFirst("null__", "");
	  	}
	  	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedSavingList = registrantConceptBoardsContributedPaymentSavingDAO.registrantGiftReceivedCBContributeAmountCheckingInDB(registrantUserId, cbContributedProductsId);
	  	if (!regCBContributedSavingList.isEmpty()) {
	  		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedSavingLoop : regCBContributedSavingList) {
	  			String regiFullName = registryUserFullNameTakeFromDB(req, sn, registrantUserId);
	  			double cbPriceDb = Double.parseDouble(regCBContributedSavingLoop.getContributedPrice());
	  			String cbPriceSt = String.format("%.2f", cbPriceDb);
	  			Timestamp tsDate = regCBContributedSavingLoop.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  			String guestCombValue = regiFullName + "_,_" + createdDate + "_,_" + cbPriceSt + "_,_" + regCBContributedSavingLoop.getContributedStatus();
	  			cbContributedData = cbContributedData + "__" +guestCombValue;
	  		}
	  		cbContributedData = cbContributedData.replaceFirst("null__", "");
	  	}
		return cbContributedData;
    }

    public String registrantFTIndividualGiftReceivedDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
	  	String regFTIndividualGiftReceived = null;
	  	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.regFinishingTouchesIndividualMyAccountDataDisplay(registrantUserId);
	  	List finTouchesPaymentIdsList = new ArrayList();
	  	List finTouchesProImageList = new ArrayList();
	  	List finTouchesProNameList = new ArrayList();
	  	List finTouchesProAmountList = new ArrayList();
	  	List finTouchesProStartDateList = new ArrayList();
	  	List finTouchesGiftRecStatusList = new ArrayList();
	  	List registrantNamesList = new ArrayList();
	  	List regiGRTrackingLinksList = new ArrayList();
	  	List regiGRBOTillDatesList = new ArrayList();
	  	if (!regFTIndividualSavingList.isEmpty()) {        	
	  		for (RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualSavingModel : regFTIndividualSavingList) {
	  			finTouchesPaymentIdsList.add(regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualPaymentSavingId());
	  			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(registrantUserId, regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
	  			finTouchesProImageList.add(regFTIndividualUpdateModel.getProductUploadedImage());
	  			finTouchesProNameList.add(regFTIndividualUpdateModel.getProductName());	  			
	  			double totalProdPriceDb = Double.parseDouble(regFTIndividualUpdateModel.getProductPrice());
    			int giftedQuantity = regFTIndividualSavingModel.getGiftedQuantity();
    			double totalGiftedPrice = totalProdPriceDb * giftedQuantity;
    			double totalGuestIndWithTaxAmount = totalGiftedPrice + (totalGiftedPrice/100)*18;
            	String totalRegProductAmountSt = String.format("%,.2f", totalGuestIndWithTaxAmount);
            	finTouchesProAmountList.add(totalRegProductAmountSt);
	  			Timestamp tsDate = regFTIndividualSavingModel.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  	    	finTouchesProStartDateList.add(createdDate);    			
	  	    	String regiFullName = registryUserFullNameTakeFromDB(req, sn, registrantUserId);
	  	    	registrantNamesList.add(regiFullName);
	  	        finTouchesGiftRecStatusList.add(regFTIndividualSavingModel.getIndividualStatus());
	  	        String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regFTIndividualSavingModel.getTrackingLink() + "> Track</a>";
	  	        regiGRTrackingLinksList.add(trackLinkUrl);
	  	        regiGRBOTillDatesList.add(regFTIndividualSavingModel.getStatus());
	  			sn.setAttribute(regFinishingTouchesPaymentIdsList, finTouchesPaymentIdsList);
	  			sn.setAttribute(regFinishingTouchesPaymentImageList, finTouchesProImageList);
	  			sn.setAttribute(regFinishingTouchesPaymentNameList, finTouchesProNameList);
	  			sn.setAttribute(regFinishingTouchesPaymentAmountList, finTouchesProAmountList);
	  			sn.setAttribute(regFinishingTouchesPaymentStartDateList, finTouchesProStartDateList);
	  			sn.setAttribute(ftRegistrantNameList, registrantNamesList);
	  			sn.setAttribute(registrantFTGiftReceivedStatusList, finTouchesGiftRecStatusList);
	  			sn.setAttribute(regFTGRTrackingLinksList, regiGRTrackingLinksList);
	  			sn.setAttribute(regFTGRBOTillDatesList, regiGRBOTillDatesList);
	  		}
	  		sn.setAttribute(regFinTouchesAddCartValueInSn, "Have RFT Add Cart Data");
	    } 
		return regFTIndividualGiftReceived;
    }
  
    public String guestFTIndividualGiftReceivedDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String guestFTIndividualGiftReceived = null;
	  	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.regFinishingTouchesIndividualMyAccountDataDisplay(registrantUserId);
	  	List guestConBoardPaymentIdsList = new ArrayList();
	  	List guestConBoardProImageList = new ArrayList();
	  	List guestConBoardProNameList = new ArrayList();
	  	List guestConBoardProAmountList = new ArrayList();
	  	List guestConBoardProStartDateList = new ArrayList();
	  	List guestConBoardGiftRecStatusList = new ArrayList();
	  	List registrantNamesList = new ArrayList();
	  	List gustGRTrackingLinksList = new ArrayList();
	  	List gustGRBOTillDatesList = new ArrayList();
	  	if (!guestFTIndividualSavingList.isEmpty()) {        	
	  		for (GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualSavingModel : guestFTIndividualSavingList) {
	  			guestConBoardPaymentIdsList.add(guestFTIndividualSavingModel.getGuestFinishingTouchesIndividualPaymentSavingId());
	  			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(registrantUserId, guestFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
	  			guestConBoardProImageList.add(regFTIndividualUpdateModel.getProductUploadedImage());
	  			guestConBoardProNameList.add(regFTIndividualUpdateModel.getProductName());	  			
	  			double totalProdPriceDb = Double.parseDouble(regFTIndividualUpdateModel.getProductPrice());
    			int giftedQuantity = guestFTIndividualSavingModel.getGiftedQuantity();
    			double totalGiftedPrice = totalProdPriceDb * giftedQuantity;
    			double totalGuestIndWithTaxAmount = totalGiftedPrice + (totalGiftedPrice/100)*18;
            	String totalRegProductAmountSt = String.format("%,.2f", totalGuestIndWithTaxAmount);
            	guestConBoardProAmountList.add(totalRegProductAmountSt);
	  			Timestamp tsDate = guestFTIndividualSavingModel.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  	    	guestConBoardProStartDateList.add(createdDate);    			
	  	    	String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestFTIndividualSavingModel.getGuestUserPaymentInfoSavingId());
	  	        registrantNamesList.add(guestFullName);
	  	        guestConBoardGiftRecStatusList.add(guestFTIndividualSavingModel.getIndividualStatus());
	  	        String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + guestFTIndividualSavingModel.getTrackingLink() + "> Track</a>";
	  	        gustGRTrackingLinksList.add(trackLinkUrl);
	  	        gustGRBOTillDatesList.add(guestFTIndividualSavingModel.getStatus());
	  			sn.setAttribute(guestFinishingTouchesPaymentIdsList, guestConBoardPaymentIdsList);
	  			sn.setAttribute(guestFinishingTouchesPaymentImageList, guestConBoardProImageList);
	  			sn.setAttribute(guestFinishingTouchesPaymentNameList, guestConBoardProNameList);
	  			sn.setAttribute(guestFinishingTouchesPaymentAmountList, guestConBoardProAmountList);
	  			sn.setAttribute(guestFinishingTouchesPaymentStartDateList, guestConBoardProStartDateList);
	  			sn.setAttribute(guestFTNameList, registrantNamesList);
	  			sn.setAttribute(guestFTGiftReceivedStatusList, guestConBoardGiftRecStatusList);
	  			sn.setAttribute(guestFTGRTrackingLinksList, gustGRTrackingLinksList);
	  			sn.setAttribute(guestFTGRBOTillDatesList, gustGRBOTillDatesList);
	  		}
	  		sn.setAttribute(guestFinTouchesAddCartValueInSn, "Have GFT Add Cart Data");
	    } 
		return guestFTIndividualGiftReceived;
    }
    
    public String registrantFTContributedGiftReceivedDataTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
	  	String cbContributedData = null;
	  	List finTouchesPaymentIdsList = new ArrayList();
	  	List finTouchesProImageList = new ArrayList();	  	
	  	List finTouchesProNameList = new ArrayList();
	  	List finTouchesTotalPriceList = new ArrayList();
	  	List regTotalContributedDataList = new ArrayList();
	  	List regAndGuetFTGiftReceivedStatusList = new ArrayList();
	  	List regiContGRTrackingLinksList = new ArrayList();
	  	List regiContGRBOTillDatesList = new ArrayList();
	  	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedMyAccountsDataDisplay(registrantUserId);
	  	if (!regFTContributedSavingList.isEmpty()) {
	  		for (RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingLoop : regFTContributedSavingList) {
	  			finTouchesPaymentIdsList.add(regFTContributedSavingLoop.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
	  			finTouchesProImageList.add(regFTContributedSavingLoop.getProductUploadedImage());
	  			finTouchesProNameList.add(regFTContributedSavingLoop.getProductName());
	  			double totalContributedPriceDb = Double.parseDouble(regFTContributedSavingLoop.getContributedPrice());
	  			String totalContributedPrice = String.format("%.2f", totalContributedPriceDb);
	  			finTouchesTotalPriceList.add(totalContributedPrice);
	  			String regFTContributedValue = giftReceivedFTContributedValuesList(req, sn, registrantUserId, regFTContributedSavingLoop.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
	  			regTotalContributedDataList.add(regFTContributedValue);
	  			regAndGuetFTGiftReceivedStatusList.add(regFTContributedSavingLoop.getContributedStatus());
	  			String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regFTContributedSavingLoop.getTrackingLink() + "> Track</a>";
	  			regiContGRTrackingLinksList.add(trackLinkUrl);
	  			regiContGRBOTillDatesList.add(regFTContributedSavingLoop.getStatus());
	  		}
	  		sn.setAttribute(regFinTouchesContributeValueInSn, "Have RFT Contribute Data");
	  	}
	  	sn.setAttribute(regFinishingTouchesContributePaymentIdsList, finTouchesPaymentIdsList);
		sn.setAttribute(regFinishingTouchesContributePaymentImageList, finTouchesProImageList);
		sn.setAttribute(regFinishingTouchesContributePaymentNameList, finTouchesProNameList);
		sn.setAttribute(regFinishingTouchesContributeTotalPriceList, finTouchesTotalPriceList);
		sn.setAttribute(regFinishingTouchesTotalContributedDataList, regTotalContributedDataList);
		sn.setAttribute(registryAndGuestFTGiftReceivedStatusList, regAndGuetFTGiftReceivedStatusList);
		sn.setAttribute(regFTContGRTrackingLinksList, regiContGRTrackingLinksList);
		sn.setAttribute(regFTContGRBOTillDatesList, regiContGRBOTillDatesList);
		return cbContributedData;
    }
    
    public String giftReceivedFTContributedValuesList(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductsId) {
	  	String cbContributedData = null;
	  	List<GuestFinishingTouchesContributedPaymentSaving> guestFTContributedSavingList = guestFinishingTouchesContributedPaymentSavingDAO.guestGiftReceivedFTContributeAmountCheckingInDB(registrantUserId, cbContributedProductsId);
	  	if (!guestFTContributedSavingList.isEmpty()) {
	  		for (GuestFinishingTouchesContributedPaymentSaving guestFTContributedSavingLoop : guestFTContributedSavingList) {
	  			String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestFTContributedSavingLoop.getGuestUserPaymentInfoSavingId());
	  			double cbPriceDb = Double.parseDouble(guestFTContributedSavingLoop.getContributedPrice());
	  			String cbPriceSt = String.format("%.2f", cbPriceDb);
	  			Timestamp tsDate = guestFTContributedSavingLoop.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  			String guestCombValue = guestFullName + "_,_" + createdDate + "_,_" + cbPriceSt + "_,_" + guestFTContributedSavingLoop.getContributedStatus();
	  			cbContributedData = cbContributedData + "__" +guestCombValue;
	  		}
	  		cbContributedData = cbContributedData.replaceFirst("null__", "");
	  	}
	  	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedSavingList = registrantFinishingTouchesContributedPaymentSavingDAO.registrantGiftReceivedFTContributeAmountCheckingInDB(registrantUserId, cbContributedProductsId);
	  	if (!regFTContributedSavingList.isEmpty()) {
	  		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedSavingLoop : regFTContributedSavingList) {
	  			String regiFullName = registryUserFullNameTakeFromDB(req, sn, registrantUserId);
	  			double cbPriceDb = Double.parseDouble(regFTContributedSavingLoop.getContributedPrice());
	  			String cbPriceSt = String.format("%.2f", cbPriceDb);
	  			Timestamp tsDate = regFTContributedSavingLoop.getCreatedDate();
	  	    	Date date = new Date();
	  	    	date.setTime(tsDate.getTime());
	  	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
	  			String guestCombValue = regiFullName + "_,_" + createdDate + "_,_" + cbPriceSt + "_,_" + regFTContributedSavingLoop.getContributedStatus();
	  			cbContributedData = cbContributedData + "__" +guestCombValue;
	  		}
	  		cbContributedData = cbContributedData.replaceFirst("null__", "");
	  	}
		return cbContributedData;
    }
     
    public String registrantCustomGiftCardGenerationForRegistrant(HttpServletRequest req, HttpSession sn, long registrantUserId, double allTotalGiftAmount) {
    	String regCustomGiftCard = null;
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
    		regCustomGiftCardCodeModel.setTotalCredit(allTotalGiftAmount);
    		regCustomGiftCardCodeModel.setRemainingCredit(allTotalGiftAmount);
    		regCustomGiftCardCodeModel.setUsedCredit(usedCredit);
    		regCustomGiftCardCodeModel.setCreatedDate(currentDate);
    		registrantCustomGiftCardCodeSavingDAO.save(regCustomGiftCardCodeModel);
    	} else {
    		RegistrantCustomGiftCardCodeSaving regCustomGiftCardCodeSavingModel = registrantCustomGiftCardCodeSavingDAO.updatedGiftCardCodeRowInDataBasa(registrantUserId);
    		double totalCredit = regCustomGiftCardCodeSavingModel.getTotalCredit();
    		double remCredit = regCustomGiftCardCodeSavingModel.getRemainingCredit();
    		double allTotCredit = totalCredit + allTotalGiftAmount;
    		double allTotRemCredit = remCredit + allTotalGiftAmount;
    		regCustomGiftCardCodeSavingModel.setTotalCredit(allTotCredit);
    		regCustomGiftCardCodeSavingModel.setRemainingCredit(allTotRemCredit);
    		regCustomGiftCardCodeSavingModel.setUpdatedDate(currentDate);
    		registrantCustomGiftCardCodeSavingDAO.merge(regCustomGiftCardCodeSavingModel);
    	}
 	   	return regCustomGiftCard;
    }
    
    public String registrantGiftsReceivedSessionPutNull(HttpServletRequest req, HttpSession sn) {
    	String nullValuesReff = null;
    	sn.setAttribute(regConceptBoardPaymentIdsList, null);
		sn.setAttribute(regConBoardAddCartValueInSn, null);		
		sn.setAttribute(guestConceptBoardPaymentIdsList, null);
		sn.setAttribute(guestConBoardAddCartValueInSn, null);				
		sn.setAttribute(regConceptBoardContributePaymentIdsList, null);
		sn.setAttribute(regConceptBoardTotalContributedDataList, null);
		sn.setAttribute(regConBoardContributeValueInSn, null);
		sn.setAttribute(regFinishingTouchesPaymentIdsList, null);
		sn.setAttribute(regFinTouchesAddCartValueInSn, null);		
		sn.setAttribute(guestFinishingTouchesPaymentIdsList, null);
		sn.setAttribute(guestFinTouchesAddCartValueInSn, null);				
		sn.setAttribute(regFinishingTouchesContributePaymentIdsList, null);
		sn.setAttribute(regFinishingTouchesTotalContributedDataList, null);
		sn.setAttribute(regFinTouchesContributeValueInSn, null);
		sn.setAttribute(regGRTrackingLinksList, null);
		sn.setAttribute(regGRBOTillDatesList, null);
		sn.setAttribute(guestGRTrackingLinksList, null);
		sn.setAttribute(guestGRBOTillDatesList, null);
		sn.setAttribute(regContGRTrackingLinksList, null);
		sn.setAttribute(regContGRBOTillDatesList, null);
		sn.setAttribute(guestConceptBoardContributePaymentIdsList, null);
		sn.setAttribute(guestConBoardContributeValueInSn, null);		
		sn.setAttribute(roomFundDataForStoreCreditSn, null);
		sn.setAttribute(storeCreditRoomFundsPriceInSn, null);
		sn.setAttribute(guestCashFundsPaymentInfoSn, null);
    	sn.setAttribute(registrantCashFundsPaymentInfoSn, null);
    	sn.setAttribute(registrantRoomFundsPaymentInfoSn, null);
    	sn.setAttribute(guestRoomFundsPaymentInfoSn, null);    	
    	sn.setAttribute(rgConceptBoardACStoreCreditIdsList, null);
    	sn.setAttribute(storeCreditCBIndividualPriceInSn, null);
    	sn.setAttribute(storeCreditFTContributedPriceInSn, null);
    	sn.setAttribute(storeCreditFTIndividualPriceInSn, null);
    	sn.setAttribute(rgConceptBoardContStoreCreditIdsList, null);
    	sn.setAttribute(storeCreditCBContributedPriceInSn, null);    	
    	sn.setAttribute(regCBContributedProductIdsList, null);
    	sn.setAttribute(regCBContributedProductImageList, null);
    	sn.setAttribute(regCBContributedProductNameList, null);
    	sn.setAttribute(regCBContributedProductAmountList, null);
    	sn.setAttribute(regCBContributedProductQuantityList, null);
    	sn.setAttribute(regCBContributedProductStartDateList, null);
    	sn.setAttribute(regCBContributedProductOrderNoList, null);
    	sn.setAttribute(regCBIndividualProductIdsList, null);
    	sn.setAttribute(regCBIndividualProductImageList, null);
    	sn.setAttribute(regCBIndividualProductNameList, null);
    	sn.setAttribute(regCBIndividualProductAmountList, null);
    	sn.setAttribute(regCBIndividualProductQuantityList, null);
    	sn.setAttribute(regCBIndividualProductStartDateList, null);
    	sn.setAttribute(regCBIndividualProductOrderNoList, null);
    	sn.setAttribute(regFTContributedProductIdsList, null);
    	sn.setAttribute(regFTContributedProductImageList, null);
    	sn.setAttribute(regFTContributedProductNameList, null);
    	sn.setAttribute(regFTContributedProductAmountList, null);
    	sn.setAttribute(regFTContributedProductQuantityList, null);
    	sn.setAttribute(regFTContributedProductStartDateList, null);
    	sn.setAttribute(regFTContributedProductOrderNoList, null);
    	sn.setAttribute(regFTIndividualProductIdsList, null);
    	sn.setAttribute(regFTIndividualProductImageList, null);
    	sn.setAttribute(regFTIndividualProductNameList, null);
    	sn.setAttribute(regFTIndividualProductAmountList, null);
    	sn.setAttribute(regFTIndividualProductQuantityList, null);
    	sn.setAttribute(regFTIndividualProductStartDateList, null);
    	sn.setAttribute(regFTIndividualProductOrderNoList, null);
    	sn.setAttribute(maCartRegiSpaceInfoSn, null);
    	sn.setAttribute(registryCashFundsPaymentInfoInSn, null);
    	return nullValuesReff;
    }
    
    @Override
    @Transactional
    public ModelAndView registrantRoomFundsDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regRoomFundsReff = null;
    	String guestRoomFundsInfoList = null;
    	String guestRoomFundsPaymentInfoSnList = null;    	
    	List<GuestRoomFundPaymentInfoSaving> regPaymentInfoList = guestRoomFundPaymentInfoSavingDAO.guestOnlyRoomsPaymentRowCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regPaymentInfoList.isEmpty()) {
    		for (GuestRoomFundPaymentInfoSaving regPaymentSavingModel : regPaymentInfoList) {
    			guestRoomFundsInfoList = regPaymentSavingModel.getGuestRoomCombValues();
    			long guestUserPaymentId = regPaymentSavingModel.getGuestUserPaymentInfoSavingId(); 
    			String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestUserPaymentId);
    	    	Timestamp tsDate = regPaymentSavingModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(tsDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	String guestRoomFundPaymentInfoList = guestRoomFundsInfoList + "_&_" + guestFullName + "_&_" + createdDate;
    	    	guestRoomFundsPaymentInfoSnList = guestRoomFundsPaymentInfoSnList + "_&&_" + guestRoomFundPaymentInfoList;
        	}
    		guestRoomFundsPaymentInfoSnList = guestRoomFundsPaymentInfoSnList.replaceFirst("null_&&_", "");    		
    	}
    	sn.setAttribute(guestRoomFundsPaymentInfoSn, guestRoomFundsPaymentInfoSnList);
    	String registrantRoomFundsPaymentList = null;
    	String registrantRoomFundsInfoList = null;
    	List<RegistryRoomFundsPaymentInfoSaving> regiRoomFundsInfoList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundsPackageRowCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn));    	
    	if (!regiRoomFundsInfoList.isEmpty()) {
    		for (RegistryRoomFundsPaymentInfoSaving regiRoomFundsSavingModel : regiRoomFundsInfoList) {
    			registrantRoomFundsInfoList = regiRoomFundsSavingModel.getSelectedRoomFundsInfo();
    			String regiFullName = registryUserFullNameTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	        
    	    	Timestamp startDate = regiRoomFundsSavingModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(startDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	registrantRoomFundsInfoList = registrantRoomFundsInfoList.replaceFirst("null__", "");  	    	    	    	
    	    	String regiRoomFundsPaymentInfoList = registrantRoomFundsInfoList + "_&_" + regiFullName + "_&_" + createdDate;
    	    	registrantRoomFundsPaymentList = registrantRoomFundsPaymentList + "_&&_" + regiRoomFundsPaymentInfoList;
        	}
    		registrantRoomFundsPaymentList = registrantRoomFundsPaymentList.replaceFirst("null_&&_", "");    		
    	}
    	if ((!regPaymentInfoList.isEmpty()) || (!regiRoomFundsInfoList.isEmpty())) {
    		regRoomFundsReff = regOrderReff;    		
    	}    	
    	sn.setAttribute(registrantRoomFundsPaymentInfoSn, registrantRoomFundsPaymentList);
 	   	mav = new ModelAndView(registrantRoomFundsDisplayRed);
 	   	mav.addObject(regiMAOrderReff, regRoomFundsReff);
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantCashFundsDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestCashFundsPaymentInfoList = null;
    	String regRoomFundsReff = null;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.guestCashFundsMyAccountDataCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		for (GuestRegistryCashFundsPaymentInfoSaving regPaymentSavingModel : guestCashFundPaymentRowList) {
    			long guestUserPaymentId = regPaymentSavingModel.getGuestUserPaymentInfoSavingId(); 
    			String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestUserPaymentId);
    	    	String cashFundPrice = regPaymentSavingModel.getContributedCashFundPrice();
    	    	String registrantCashFundName = regPaymentSavingModel.getCashFundName();
    	    	Timestamp guscrDate = regPaymentSavingModel.getCreatedDate();
    	    	Date date1 = new Date();
    	    	date1.setTime(guscrDate.getTime());
    	    	String createdDate1 = new SimpleDateFormat("MM/dd/yyyy").format(date1);
    	    	String fundsGusStstus = regPaymentSavingModel.getCashFundStatus();
    	    	long cashFundSavingId = regPaymentSavingModel.getRegistryCashFundsInfoSavingId();
    	    	long guestCFPaymentInfoSavingId = regPaymentSavingModel.getGuestRegistryCashFundsPaymentInfoSavingId();
    	    	String registrantGuestCashFundImage = registrantCashFundImageTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cashFundSavingId);
    	    	String guestCashFundsSpaceList = registrantGuestCashFundImage + ",_," + registrantCashFundName + ",_," + cashFundPrice + ",_," + guestFullName + ",_," + createdDate1 + ",_," + fundsGusStstus + ",_," + guestCFPaymentInfoSavingId;
    	    	guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList + "__" + guestCashFundsSpaceList;
        	}
    		guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList.replaceFirst("null__", "");
    	}
    	sn.setAttribute(guestCashFundsPaymentInfoSn, guestCashFundsPaymentInfoList);
    	String registrantCashFundsPaymentInfList = null;    	
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsMyAccountsDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCashFundAddCartRowList.isEmpty()) {
    		for (RegistryCashFundsPaymentInfoSaving regCashFundSavingModel : regCashFundAddCartRowList) {
    			String regiFullName = registryUserFullNameTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	    	String regCashFundPrice = regCashFundSavingModel.getContributedCashFundPrice();
    	    	String registrantCashsFundName = regCashFundSavingModel.getCashFundName();
    	    	Timestamp regCrDate = regCashFundSavingModel.getCreatedDate();
    	    	Date date2 = new Date();
    	    	date2.setTime(regCrDate.getTime());
    	    	String createdDate2 = new SimpleDateFormat("MM/dd/yyyy").format(date2);
    	    	String fundsRegStstus = regCashFundSavingModel.getCashFundStatus();
    	    	long regiCFPaymentInfoSavingId = regCashFundSavingModel.getRegistryCashFundsPaymentInfoSavingId();
    	    	long cashFundSavingId = regCashFundSavingModel.getRegistryCashFundsInfoSavingId();
    	    	String registrantCashFundImage = registrantCashFundImageTakeFromDB(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cashFundSavingId);
    	    	String registrantCashFundsList = registrantCashFundImage + ",_," + registrantCashsFundName + ",_," + regCashFundPrice + ",_," + regiFullName + ",_," + createdDate2 + ",_," + fundsRegStstus + ",_," + regiCFPaymentInfoSavingId;
    	    	registrantCashFundsPaymentInfList = registrantCashFundsPaymentInfList + "__" + registrantCashFundsList;   	    	    	    	
        	}
    		registrantCashFundsPaymentInfList = registrantCashFundsPaymentInfList.replaceFirst("null__", "");
    	}
    	if ((!guestCashFundPaymentRowList.isEmpty()) || (!regCashFundAddCartRowList.isEmpty())) {
    		regRoomFundsReff = regOrderReff;    		
    	}
    	sn.setAttribute(registrantCashFundsPaymentInfoSn, registrantCashFundsPaymentInfList);
    	mav = new ModelAndView(registrantCashFundsDisplayRed);
    	mav.addObject(regiMAOrderReff, regRoomFundsReff);
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }
    
    public String registryUserFullNameTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String registryFullName = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	registryFullName = regInfoSavingModel.getRegFirstName() + " " + regInfoSavingModel.getRegLastName();
    	return registryFullName;
    }

    public String guestUserFullNameTakeFromDB(HttpServletRequest req, HttpSession sn, long guestUserPaymentId) {
    	String guestFullName = null;
    	List<GuestUserPaymentInfoSaving> guestUserInfoSavingList = guestUserPaymentInfoSavingDAO.guestUserFirstNameCheckingInDB(guestUserPaymentId);
    	if (!guestUserInfoSavingList.isEmpty()) {
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestUserPaymentId);
    		guestFullName = guestUserInfoSavingModel.getGuestUserFullName();
    	}
    	return guestFullName;
    }

    public String registrantCashFundImageTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId, long cashFundSavingId) {
    	String registrantCashFundImage = null;
    	RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.cashFundsMyAccountDataTakeFromDB(registrantUserId, cashFundSavingId);
    	if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
    		byte[] regUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
    		String custmCashFundImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
    		registrantCashFundImage = "data:image/jpg;base64," + custmCashFundImg;
    	} else {
    		registrantCashFundImage = cashFundSmallImageUrl + registryCashFundsInfoModel.getCashFundImageUrl();
    	}
    	return registrantCashFundImage;
    }

    @Override
    @Transactional
    public ModelAndView registrantStoreCreditDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regRoomFundsReff = null;
    	registryAndGuestStoreCreditRoomFundsInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryAndGuestStoreCreditCBContributeInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	registryAndGuestStoreCreditCBIndividualInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryAndGuestStoreCreditFTContributeInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	registryAndGuestStoreCreditFTIndividualInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allTotalGiftAmount = allRegistryAndGuestGiftAmountTotal(req, sn);
    	String allTotalGiftAmountStr = String.format("%,.2f", allTotalGiftAmount);    	
    	String giftCardCode = null;
    	String remainingAmountStr = null;
    	String totalGiftAmountStr = null;
    	String regGiftCardUseDataList = null;
    	List<RegistrantCustomGiftCardCodeSaving> regCustomGiftCardSavingList = registrantCustomGiftCardCodeSavingDAO.selectedGiftCardCodeRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	if(allTotalGiftAmount > 0 && (!regCustomGiftCardSavingList.isEmpty())) {
    		regRoomFundsReff = regOrderReff;
    		RegistrantCustomGiftCardCodeSaving regCustomGiftCardSavingModel = registrantCustomGiftCardCodeSavingDAO.updatedGiftCardCodeRowInDataBasa((Long) sn.getAttribute(registrantUserIdInSn));
	    	giftCardCode = regCustomGiftCardSavingModel.getGiftCardCode();
	    	double remainingAmount = regCustomGiftCardSavingModel.getRemainingCredit();
	    	remainingAmountStr = String.format("%,.2f", remainingAmount);
	    	double totalAmount = regCustomGiftCardSavingModel.getTotalCredit();
	    	totalGiftAmountStr = String.format("%,.2f", totalAmount);
	    	regGiftCardUseDataList = registrantPaymentForGiftCardUseDataDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), regCustomGiftCardSavingModel.getGiftCardCode());
    	}
 	   	mav = new ModelAndView(registrantStoreCreditDisplayRed); 	   	
 	   	mav.addObject(registrantGiftCardCode, giftCardCode);
 	   	mav.addObject(totalCreditAmount, remainingAmountStr);
 	   	mav.addObject("totalGiftedAmount", totalGiftAmountStr);
 	   	mav.addObject("allTotalGiftAmount", allTotalGiftAmountStr);
 	   	sn.setAttribute("regCustomGiftCardUsedData", regGiftCardUseDataList);
 	   	mav.addObject(regiMAOrderReff, regRoomFundsReff);
 	   	mav.addObject(roomFundPriceForStoreCredit, sn.getAttribute(storeCreditRoomFundsPriceInSn));
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }
    
    public String registrantPaymentForGiftCardUseDataDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId, String giftCardCode) {
    	String regGiftCardUseDataList = null;
    	List<RegistrantPaymentInfoSaving> regPaymentInfoGCList = registrantPaymentInfoSavingDAO.registrantMyAccountStoredCreditGiftedPrice(registrantUserId, giftCardCode);
    	if (!regPaymentInfoGCList.isEmpty()) {
    		for (RegistrantPaymentInfoSaving regPaymentSavingModel : regPaymentInfoGCList) {
    			Timestamp startDate = regPaymentSavingModel.getCreatedDate();
    	    	Date date = new Date();
    	    	date.setTime(startDate.getTime());
    	    	String createdDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    	    	double giftCardPriceDb = Double.parseDouble(regPaymentSavingModel.getGiftCardPrice());
    			String regGiftCardPrice = String.format("%,.2f", giftCardPriceDb);
    			String giftCardCombinationVal = createdDate + "_,_" + regGiftCardPrice;
    			regGiftCardUseDataList = regGiftCardUseDataList + "__" + giftCardCombinationVal;
        	}
    		regGiftCardUseDataList = regGiftCardUseDataList.replaceFirst("null__", ""); 		
    	}
        return regGiftCardUseDataList;
    }
    
    public double allRegistryAndGuestGiftAmountTotal(HttpServletRequest req, HttpSession sn) {
    	double allTotalGiftAmount = 0;
    	int roomFundPriceForStoreCredit = 0;
    	if(null != sn.getAttribute(storeCreditRoomFundsPriceInSn)) {
    		roomFundPriceForStoreCredit = (int) sn.getAttribute(storeCreditRoomFundsPriceInSn);
    	}
    	double storeCreditCBContributedPrice = 0;
    	if(null != sn.getAttribute(storeCreditCBContributedPriceInSn)) {
    		storeCreditCBContributedPrice = (double) sn.getAttribute(storeCreditCBContributedPriceInSn);
    	} 
    	double storeCreditCBIndividualPrice = 0;
    	if(null != sn.getAttribute(storeCreditCBIndividualPriceInSn)) {
    		storeCreditCBIndividualPrice = (double) sn.getAttribute(storeCreditCBIndividualPriceInSn);
    	}
    	double storeCreditFTContributedPrice = 0;
    	if(null != sn.getAttribute(storeCreditFTContributedPriceInSn)) {
    		storeCreditFTContributedPrice = (double) sn.getAttribute(storeCreditFTContributedPriceInSn);
    	}
    	double storeCreditFTIndividualPrice = 0;
    	if(null != sn.getAttribute(storeCreditFTIndividualPriceInSn)) {
    		storeCreditFTIndividualPrice = (double) sn.getAttribute(storeCreditFTIndividualPriceInSn);
    	}
    	allTotalGiftAmount = roomFundPriceForStoreCredit + storeCreditCBContributedPrice + storeCreditCBIndividualPrice + storeCreditFTContributedPrice + storeCreditFTIndividualPrice;
        return allTotalGiftAmount;
    }
    
    public String registryAndGuestStoreCreditRoomFundsInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String storeCreditRoomFunds = null;
    	String storeCredRoomFundsPaymentInfoList = null;    	
    	List<GuestRoomFundPaymentInfoSaving> regPaymentInfoList = guestRoomFundPaymentInfoSavingDAO.guestOnlyRoomsPaymentRowCheckingInDB(registrantUserId);
    	if (!regPaymentInfoList.isEmpty()) {
    		for (GuestRoomFundPaymentInfoSaving regPaymentSavingModel : regPaymentInfoList) {
    			String guestRoomFundsInfoList = regPaymentSavingModel.getGuestRoomCombValues();
    			storeCredRoomFundsPaymentInfoList = storeCredRoomFundsPaymentInfoList + "__" + guestRoomFundsInfoList;
        	}
    		storeCredRoomFundsPaymentInfoList = storeCredRoomFundsPaymentInfoList.replaceFirst("null__", ""); 		
    	}    	
    	List<RegistryRoomFundsPaymentInfoSaving> regiRoomFundsInfoList = registryRoomFundsPaymentInfoSavingDAO.regRoomAndCashFundsPackageRowCheckingInDB(registrantUserId);    	
    	if (!regiRoomFundsInfoList.isEmpty()) {
    		for (RegistryRoomFundsPaymentInfoSaving regiRoomFundsSavingModel : regiRoomFundsInfoList) {
    			String registrantRoomFundsInfoList = regiRoomFundsSavingModel.getSelectedRoomFundsInfo();
    			storeCredRoomFundsPaymentInfoList = storeCredRoomFundsPaymentInfoList + "__" + registrantRoomFundsInfoList;
        	}
    		storeCredRoomFundsPaymentInfoList = storeCredRoomFundsPaymentInfoList.replaceFirst("null__", "");    		
    	}
    	registryAndGuestStoreCreditRoomFundsDataDisplay(req, sn, storeCredRoomFundsPaymentInfoList);
 	   	return storeCreditRoomFunds;
    }

    public String registryAndGuestStoreCreditRoomFundsDataDisplay(HttpServletRequest req, HttpSession sn, String storeCredRoomFunds) {
    	String storeCreditRoomFundsRef = null;
    	String totalRoomFundsDataList = null;
    	if(null != storeCredRoomFunds) {
    		String[] storeCredRoomFundsSt = storeCredRoomFunds.split("__");
    		int totalRoomFundsAmount = 0;    		
    		int roomFundsAmount1 = 0;
    		int roomFundsAmount2 = 0;
    		int roomFundsAmount3 = 0;
    		int roomFundsAmount4 = 0;
    		int roomFundsAmount5 = 0;
    		int roomFundsAmount6 = 0;
    		int roomFundsAmount7 = 0;
    		int roomFundsAmount8 = 0;
    		int roomFundsAmount9 = 0;
    		int roomFundsAmount10 = 0;    		
    		String roomFundsDataList1 = null;
    		String roomFundsDataList2 = null;
    		String roomFundsDataList3 = null;
    		String roomFundsDataList4 = null;
    		String roomFundsDataList5 = null;
    		String roomFundsDataList6 = null;
    		String roomFundsDataList7 = null;
    		String roomFundsDataList8 = null;
    		String roomFundsDataList9 = null;
    		String roomFundsDataList10 = null;
    		for(int i=0; i<storeCredRoomFundsSt.length; i++) {
    			String[] roomFundNameList = storeCredRoomFundsSt[i].split(",_,");
    			String roomFundNameValue = roomFundNameList[1];
    			String roomFundPriceValue = roomFundNameList[2];
    			int roomFundsAmount = 0;
    			if(null != roomFundPriceValue) {
    				roomFundsAmount = Integer.parseInt(roomFundPriceValue);
    			}    			    			
    			if(("LIVING ROOM FUND").equals(roomFundNameValue)) {
    				roomFundsAmount1 = roomFundsAmount1 + roomFundsAmount;
    				roomFundsDataList1 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount1;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("DINING ROOM FUND").equals(roomFundNameValue)) {
    				roomFundsAmount2 = roomFundsAmount2 + roomFundsAmount;
    				roomFundsDataList2 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount2;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("BEDROOM FUND").equals(roomFundNameValue)) {
    				roomFundsAmount3 = roomFundsAmount3 + roomFundsAmount;
    				roomFundsDataList3 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount3;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("HOME OFFICE FUND").equals(roomFundNameValue)) {
    				roomFundsAmount4 = roomFundsAmount4 + roomFundsAmount;
    				roomFundsDataList4 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount4; 
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("ENTRYWAY FUND").equals(roomFundNameValue)) {
    				roomFundsAmount5 = roomFundsAmount5 + roomFundsAmount;
    				roomFundsDataList5 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount5;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("NURSERY FUND").equals(roomFundNameValue)) {
    				roomFundsAmount6 = roomFundsAmount6 + roomFundsAmount;
    				roomFundsDataList6 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount6;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("KIDS BEDROOM FUND").equals(roomFundNameValue)) {
    				roomFundsAmount7 = roomFundsAmount7 + roomFundsAmount;
    				roomFundsDataList7 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount7;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("PLAY AREA FUND").equals(roomFundNameValue)) {
    				roomFundsAmount8 = roomFundsAmount8 + roomFundsAmount;
    				roomFundsDataList8 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount8;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("OUTDOOR SPACE FUND").equals(roomFundNameValue)) {
    				roomFundsAmount9 = roomFundsAmount9 + roomFundsAmount;
    				roomFundsDataList9 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount9;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			} else if(("CUSTOM DESIGN FUND").equals(roomFundNameValue)) {
    				roomFundsAmount10 = roomFundsAmount10 + roomFundsAmount;
    				roomFundsDataList10 = roomFundNameList[0] + ",_," + roomFundNameValue + ",_," + roomFundsAmount10;
    				totalRoomFundsAmount = totalRoomFundsAmount + roomFundsAmount;
    			}
    		}
    		totalRoomFundsDataList = roomFundsDataList1 + "__" + roomFundsDataList2 + "__" + roomFundsDataList3 + "__" + roomFundsDataList4 + "__" + roomFundsDataList5 + "__" + roomFundsDataList6 + "__" + roomFundsDataList7 + "__" + roomFundsDataList8 + "__" + roomFundsDataList9 + "__" + roomFundsDataList10;
    		totalRoomFundsDataList = totalRoomFundsDataList.replace("__null", "");
    		totalRoomFundsDataList = totalRoomFundsDataList.replace("null__", "");
    		sn.setAttribute(roomFundDataForStoreCreditSn, totalRoomFundsDataList);
    		sn.setAttribute(storeCreditRoomFundsPriceInSn, totalRoomFundsAmount);
    	}
 	   	return storeCreditRoomFundsRef;
    }

//  Guest And Registry Concept Boards Store Credit Display Coding

    public String registryAndGuestStoreCreditCBContributeInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String cbContributeInfoDisplay = null;
		List conceptBoardPaymentIdsList = new ArrayList();
		List conceptBoardProImageList = new ArrayList();
		List conceptBoardProNameList = new ArrayList();
		List conceptBoardProAmountList = new ArrayList();
		double totalRegGuestAddCartPrice = 0;
		List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedDataList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryMyAccountCBContributedDataDisplay(registrantUserId);
		if (!regCBContributedDataList.isEmpty()) {
			for (RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel : regCBContributedDataList) {
				conceptBoardPaymentIdsList.add(regCBContributedUpdateModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());				
				conceptBoardProImageList.add(regCBContributedUpdateModel.getProductUploadedImage());
				conceptBoardProNameList.add(regCBContributedUpdateModel.getProductName());
				double regGuestTotalAddCartPrice = registryAndGuestStoreCreditCBContributeProductsTotalPrice(req, sn, registrantUserId, regCBContributedUpdateModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
				totalRegGuestAddCartPrice = totalRegGuestAddCartPrice + regGuestTotalAddCartPrice;
				String regGuestTotalAddCartPriceSt = String.format("%,.2f", regGuestTotalAddCartPrice);
				conceptBoardProAmountList.add(regGuestTotalAddCartPriceSt);    			
			}    		
		}
		sn.setAttribute(rgConceptBoardContStoreCreditIdsList, conceptBoardPaymentIdsList);
		sn.setAttribute(rgConceptBoardContStoreCreditImageList, conceptBoardProImageList);
		sn.setAttribute(rgConceptBoardContStoreCreditNameList, conceptBoardProNameList);
		sn.setAttribute(rgConceptBoardContStoreCreditAmountList, conceptBoardProAmountList);
		sn.setAttribute(storeCreditCBContributedPriceInSn, totalRegGuestAddCartPrice);
		return cbContributeInfoDisplay;
	}
    
    public double registryAndGuestStoreCreditCBContributeProductsTotalPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long regSelectedProdsId) {
	  	double regGuestTotalAddCartPrice = 0;    	
	  	List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registrantStoreCreditCBContributeAmountCheckingInDB(registrantUserId, regSelectedProdsId);
	  	if (!regDesigenConceptBoardsList.isEmpty()) {    		
	  		for (RegistrantConceptBoardsContributedPaymentSaving regConceptBoardsSavingModel : regDesigenConceptBoardsList) {
	  			String regProductPriceSt = regConceptBoardsSavingModel.getContributedPrice();
	  			double regProductPriceStDb = 0;
	  			if(null != regProductPriceSt) {
	  				regProductPriceStDb = Double.parseDouble(regProductPriceSt);
	  			}
	  			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + regProductPriceStDb;
	  		}    		
	  	}    	
	  	List<GuestConceptBoardsContributedPaymentSaving> guestDesigenConceptBoardsList = guestConceptBoardsContributedPaymentSavingDAO.guestStoreCreditCBContributeAmountCheckingInDB(registrantUserId, regSelectedProdsId);
	  	if (!guestDesigenConceptBoardsList.isEmpty()) {    		
	  		for (GuestConceptBoardsContributedPaymentSaving guestConceptBoardsSavingModel : guestDesigenConceptBoardsList) {
	  			String guestProductPriceSt = guestConceptBoardsSavingModel.getContributedPrice();
	  			double guestProductPriceDb = 0;
	  			if(null != guestProductPriceSt) {
	  				guestProductPriceDb = Double.parseDouble(guestProductPriceSt);
	  			}
	  			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + guestProductPriceDb;    			
	  		}    		
	      }
	  	return regGuestTotalAddCartPrice;
    }

    public String registryAndGuestStoreCreditCBIndividualInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String cbIndividualInfoDisplay = null;    	
    	List conceptBoardPaymentIdsList = new ArrayList();
    	List conceptBoardProImageList = new ArrayList();
    	List conceptBoardProNameList = new ArrayList();
    	List conceptBoardProAmountList = new ArrayList();
    	double totalRegGuestAddCartPrice = 0;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualDataList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryMyAccountCBIndividualDataDisplay(registrantUserId);
    	if (!regCBIndividualDataList.isEmpty()) {
    		for (RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel : regCBIndividualDataList) {
    			conceptBoardPaymentIdsList.add(regCBIndividualUpdateModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			conceptBoardProImageList.add(regCBIndividualUpdateModel.getProductUploadedImage());
    			conceptBoardProNameList.add(regCBIndividualUpdateModel.getProductName());
    			double regGuestTotalAddCartPrice = registryAndGuestStoreCreditCBIndividualProductsTotalPrice(req, sn, registrantUserId, regCBIndividualUpdateModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId(), regCBIndividualUpdateModel.getProductPrice());
    			totalRegGuestAddCartPrice = totalRegGuestAddCartPrice + regGuestTotalAddCartPrice;
    			String regGuestTotalAddCartPriceSt = String.format("%,.2f", regGuestTotalAddCartPrice);
    			conceptBoardProAmountList.add(regGuestTotalAddCartPriceSt);    			
    		}    		
    	}
    	sn.setAttribute(rgConceptBoardACStoreCreditIdsList, conceptBoardPaymentIdsList);
		sn.setAttribute(rgConceptBoardACStoreCreditImageList, conceptBoardProImageList);
		sn.setAttribute(rgConceptBoardACStoreCreditNameList, conceptBoardProNameList);
		sn.setAttribute(rgConceptBoardACStoreCreditAmountList, conceptBoardProAmountList);
		sn.setAttribute(storeCreditCBIndividualPriceInSn, totalRegGuestAddCartPrice);
		return cbIndividualInfoDisplay;
    }
    
    public double registryAndGuestStoreCreditCBIndividualProductsTotalPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long regSelectedProdsId, String productPrice) {
    	double regGuestTotalAddCartPrice = 0;    	
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registrantStoreCreditCBIndividualAmountCheckingInDB(registrantUserId, regSelectedProdsId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {    		
    		for (RegistrantConceptBoardsIndividualPaymentSaving regConceptBoardsSavingModel : regDesigenConceptBoardsList) {
    			int regGivenQuantity = regConceptBoardsSavingModel.getGiftedQuantity();
    			double regProductPriceStDb = 0;
    			if(null != productPrice) {
    				regProductPriceStDb = Double.parseDouble(productPrice);
    			}
    			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
    			double regTotalPriceWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
    			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + regTotalPriceWithTaxValue;
    		}    		
    	}    	
    	List<GuestConceptBoardsIndividualPaymentSaving> guestDesigenConceptBoardsList = guestConceptBoardsIndividualPaymentSavingDAO.guestStoreCreditCBIndividualAmountCheckingInDB(registrantUserId, regSelectedProdsId);
    	if (!guestDesigenConceptBoardsList.isEmpty()) {    		
    		for (GuestConceptBoardsIndividualPaymentSaving guestConceptBoardsSavingModel : guestDesigenConceptBoardsList) {
    			int guestGivenQuantity = guestConceptBoardsSavingModel.getGiftedQuantity();
    			double guestProductPriceDb = 0;
    			if(null != productPrice) {
    				guestProductPriceDb = Double.parseDouble(productPrice);
    			}
    			double totalGuestProductPrice = guestProductPriceDb * guestGivenQuantity;
    			double guestTotalPriceWithTaxValue = totalGuestProductPrice + (totalGuestProductPrice/100)*18;
    			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + guestTotalPriceWithTaxValue;    			
    		}    		
        }    	
        return regGuestTotalAddCartPrice;
    }

//  Guest And Registry Finishing Touches Store Credit Display Coding

    public String registryAndGuestStoreCreditFTContributeInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String ftContributeInfoDisplay = null;
		List finishingTouchesPaymentIdsList = new ArrayList();
		List finishingTouchesProImageList = new ArrayList();
		List finishingTouchesProNameList = new ArrayList();
		List finishingTouchesProAmountList = new ArrayList();
		double totalRegGuestAddCartPrice = 0;
		List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedDataList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryMyAccountFTContributedDataDisplay(registrantUserId);
		if (!regFTContributedDataList.isEmpty()) {
			for (RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel : regFTContributedDataList) {
				finishingTouchesPaymentIdsList.add(regFTContributedUpdateModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());				
				finishingTouchesProImageList.add(regFTContributedUpdateModel.getProductUploadedImage());
				finishingTouchesProNameList.add(regFTContributedUpdateModel.getProductName());
				double regGuestTotalAddCartPrice = registryAndGuestStoreCreditFTContributeProductsTotalPrice(req, sn, registrantUserId, regFTContributedUpdateModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
				totalRegGuestAddCartPrice = totalRegGuestAddCartPrice + regGuestTotalAddCartPrice;
				String regGuestTotalAddCartPriceSt = String.format("%,.2f", regGuestTotalAddCartPrice);
				finishingTouchesProAmountList.add(regGuestTotalAddCartPriceSt);    			
			}    		
		}
		sn.setAttribute(rgConceptBoardContStoreCreditIdsList, finishingTouchesPaymentIdsList);
		sn.setAttribute(rgConceptBoardContStoreCreditImageList, finishingTouchesProImageList);
		sn.setAttribute(rgConceptBoardContStoreCreditNameList, finishingTouchesProNameList);
		sn.setAttribute(rgConceptBoardContStoreCreditAmountList, finishingTouchesProAmountList);
		sn.setAttribute(storeCreditFTContributedPriceInSn, totalRegGuestAddCartPrice);
		return ftContributeInfoDisplay;
	}
    
    public double registryAndGuestStoreCreditFTContributeProductsTotalPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long regSelectedProdsId) {
	  	double regGuestTotalAddCartPrice = 0;    	
	  	List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registrantStoreCreditFTContributeAmountCheckingInDB(registrantUserId, regSelectedProdsId);
	  	if (!regDesigenFinishingTouchesList.isEmpty()) {    		
	  		for (RegistrantFinishingTouchesContributedPaymentSaving regFinishingTouchesSavingModel : regDesigenFinishingTouchesList) {
	  			String regProductPriceSt = regFinishingTouchesSavingModel.getContributedPrice();
	  			double regProductPriceStDb = 0;
	  			if(null != regProductPriceSt) {
	  				regProductPriceStDb = Double.parseDouble(regProductPriceSt);
	  			}
	  			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + regProductPriceStDb;
	  		}    		
	  	}    	
	  	List<GuestFinishingTouchesContributedPaymentSaving> guestDesigenFinishingTouchesList = guestFinishingTouchesContributedPaymentSavingDAO.guestStoreCreditFTContributeAmountCheckingInDB(registrantUserId, regSelectedProdsId);
	  	if (!guestDesigenFinishingTouchesList.isEmpty()) {    		
	  		for (GuestFinishingTouchesContributedPaymentSaving guestFinishingTouchesSavingModel : guestDesigenFinishingTouchesList) {
	  			String guestProductPriceSt = guestFinishingTouchesSavingModel.getContributedPrice();
	  			double guestProductPriceDb = 0;
	  			if(null != guestProductPriceSt) {
	  				guestProductPriceDb = Double.parseDouble(guestProductPriceSt);
	  			}
	  			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + guestProductPriceDb;    			
	  		}    		
	      }
	  	return regGuestTotalAddCartPrice;
    }

    public String registryAndGuestStoreCreditFTIndividualInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String ftIndividualInfoDisplay = null;    	
    	List finishingTouchesPaymentIdsList = new ArrayList();
    	List finishingTouchesProImageList = new ArrayList();
    	List finishingTouchesProNameList = new ArrayList();
    	List finishingTouchesProAmountList = new ArrayList();
    	double totalRegGuestAddCartPrice = 0;
    	List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualDataList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryMyAccountFTIndividualDataDisplay(registrantUserId);
    	if (!regFTIndividualDataList.isEmpty()) {
    		for (RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel : regFTIndividualDataList) {
    			finishingTouchesPaymentIdsList.add(regFTIndividualUpdateModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			finishingTouchesProImageList.add(regFTIndividualUpdateModel.getProductUploadedImage());
    			finishingTouchesProNameList.add(regFTIndividualUpdateModel.getProductName());
    			double regGuestTotalAddCartPrice = registryAndGuestStoreCreditFTIndividualProductsTotalPrice(req, sn, registrantUserId, regFTIndividualUpdateModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId(), regFTIndividualUpdateModel.getProductPrice());
    			totalRegGuestAddCartPrice = totalRegGuestAddCartPrice + regGuestTotalAddCartPrice;
    			String regGuestTotalAddCartPriceSt = String.format("%,.2f", regGuestTotalAddCartPrice);
    			finishingTouchesProAmountList.add(regGuestTotalAddCartPriceSt);    			
    		}    		
    	}
    	sn.setAttribute(rgConceptBoardACStoreCreditIdsList, finishingTouchesPaymentIdsList);
		sn.setAttribute(rgConceptBoardACStoreCreditImageList, finishingTouchesProImageList);
		sn.setAttribute(rgConceptBoardACStoreCreditNameList, finishingTouchesProNameList);
		sn.setAttribute(rgConceptBoardACStoreCreditAmountList, finishingTouchesProAmountList);
		sn.setAttribute(storeCreditFTIndividualPriceInSn, totalRegGuestAddCartPrice);
		return ftIndividualInfoDisplay;
    }
    
    public double registryAndGuestStoreCreditFTIndividualProductsTotalPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long regSelectedProdsId, String productPrice) {
    	double regGuestTotalAddCartPrice = 0;    	
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registrantStoreCreditFTIndividualAmountCheckingInDB(registrantUserId, regSelectedProdsId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {    		
    		for (RegistrantFinishingTouchesIndividualPaymentSaving regFinishingTouchesSavingModel : regDesigenFinishingTouchesList) {
    			int regGivenQuantity = regFinishingTouchesSavingModel.getGiftedQuantity();
    			double regProductPriceStDb = 0;
    			if(null != productPrice) {
    				regProductPriceStDb = Double.parseDouble(productPrice);
    			}
    			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
    			double regTotalPriceWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
    			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + regTotalPriceWithTaxValue;
    		}    		
    	}    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestDesigenFinishingTouchesList = guestFinishingTouchesIndividualPaymentSavingDAO.guestStoreCreditFTIndividualAmountCheckingInDB(registrantUserId, regSelectedProdsId);
    	if (!guestDesigenFinishingTouchesList.isEmpty()) {    		
    		for (GuestFinishingTouchesIndividualPaymentSaving guestFinishingTouchesSavingModel : guestDesigenFinishingTouchesList) {
    			int guestGivenQuantity = guestFinishingTouchesSavingModel.getGiftedQuantity();
    			double guestProductPriceDb = 0;
    			if(null != productPrice) {
    				guestProductPriceDb = Double.parseDouble(productPrice);
    			}
    			double totalGuestProductPrice = guestProductPriceDb * guestGivenQuantity;
    			double guestTotalPriceWithTaxValue = totalGuestProductPrice + (totalGuestProductPrice/100)*18;
    			regGuestTotalAddCartPrice = regGuestTotalAddCartPrice + guestTotalPriceWithTaxValue;    			
    		}    		
        }    	
        return regGuestTotalAddCartPrice;
    }
    
    @Override
    @Transactional
    public ModelAndView regiCashFundsBankAccountsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String cashFundRoutingNumber1 = null;
    	String cashFundAccountNumber1 = null;
    	String cashFundFirstName1 = null;
    	String cashFundLastName1 = null;
    	String cashFundStreetAddress1 = null;
    	String cashFundAptOrUnit1 = null;
    	String cashFundCity1 = null;
    	String cashFundState1 = null;
    	String cashFundZipCode1 = null;
    	String cashFundPhoneNumber1 = null;
    	List<RegistrantCashFundBankAccountInfoSaving> regCFBankAccountsList = registrantCashFundBankAccountInfoSavingDAO.selectedCashFundBackAccountRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCFBankAccountsList.isEmpty()) {
    		RegistrantCashFundBankAccountInfoSaving regCFBankAccountsSavingModel = registrantCashFundBankAccountInfoSavingDAO.updatedCashFundBackAccountRowInDataBasa((Long) sn.getAttribute(registrantUserIdInSn));
    		cashFundRoutingNumber1 = regCFBankAccountsSavingModel.getCashFundRoutingNumber();
    		cashFundAccountNumber1 = regCFBankAccountsSavingModel.getCashFundAccountNumber();
    		cashFundFirstName1 = regCFBankAccountsSavingModel.getCashFundFirstName();
    		cashFundLastName1 = regCFBankAccountsSavingModel.getCashFundLastName();
    		cashFundStreetAddress1 = regCFBankAccountsSavingModel.getCashFundStreetAddress();
    		cashFundAptOrUnit1 = regCFBankAccountsSavingModel.getCashFundAptOrUnit();
    		cashFundCity1 = regCFBankAccountsSavingModel.getCashFundCity();
    		cashFundState1 = regCFBankAccountsSavingModel.getCashFundState();
    		cashFundZipCode1 = regCFBankAccountsSavingModel.getCashFundZipCode();
    		cashFundPhoneNumber1 = regCFBankAccountsSavingModel.getCashFundPhoneNumber();    		
    	}
    	mav = new ModelAndView(registrantCashFundsBankAccountsRed);
    	mav.addObject(cashFundRoutingNumber, cashFundRoutingNumber1);
    	mav.addObject(cashFundAccountNumber, cashFundAccountNumber1);
    	mav.addObject(cashFundFirstName, cashFundFirstName1);
    	mav.addObject(cashFundLastName, cashFundLastName1);
    	mav.addObject(cashFundStreetAddress, cashFundStreetAddress1);
    	mav.addObject(cashFundAptOrUnit, cashFundAptOrUnit1);
    	mav.addObject(cashFundCity, cashFundCity1);
    	mav.addObject(cashFundState, cashFundState1);
    	mav.addObject(cashFundZipCode, cashFundZipCode1);
    	mav.addObject(cashFundPhoneNumber, cashFundPhoneNumber1);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView cashFundBankAccountInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	List<RegistrantCashFundBankAccountInfoSaving> regCFBankAccountsList = registrantCashFundBankAccountInfoSavingDAO.selectedCashFundBackAccountRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCFBankAccountsList.isEmpty()) {
    		RegistrantCashFundBankAccountInfoSaving regCFBankAccountsSavingModel = registrantCashFundBankAccountInfoSavingDAO.updatedCashFundBackAccountRowInDataBasa((Long) sn.getAttribute(registrantUserIdInSn));
    		regCFBankAccountsSavingModel.setCashFundRoutingNumber(req.getParameter(cashFundRoutingNumber));
    		regCFBankAccountsSavingModel.setCashFundAccountNumber(req.getParameter(cashFundAccountNumber));
    		regCFBankAccountsSavingModel.setCashFundFirstName(req.getParameter(cashFundFirstName));
    		regCFBankAccountsSavingModel.setCashFundLastName(req.getParameter(cashFundLastName));
    		regCFBankAccountsSavingModel.setCashFundStreetAddress(req.getParameter(cashFundStreetAddress));
    		regCFBankAccountsSavingModel.setCashFundAptOrUnit(req.getParameter(cashFundAptOrUnit));
    		regCFBankAccountsSavingModel.setCashFundCity(req.getParameter(cashFundCity));
    		regCFBankAccountsSavingModel.setCashFundState(req.getParameter(cashFundState));
    		regCFBankAccountsSavingModel.setCashFundZipCode(req.getParameter(cashFundZipCode));
    		regCFBankAccountsSavingModel.setCashFundPhoneNumber(req.getParameter(cashFundPhoneNumber));
    		regCFBankAccountsSavingModel.setUpdatedDate(currentDate);
    		registrantCashFundBankAccountInfoSavingDAO.merge(regCFBankAccountsSavingModel);
    	} else {
    		RegistrantCashFundBankAccountInfoSaving regCashFundBankAccountSaving = new RegistrantCashFundBankAccountInfoSaving();
    		regCashFundBankAccountSaving.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regCashFundBankAccountSaving.setCashFundRoutingNumber(req.getParameter(cashFundRoutingNumber));
    		regCashFundBankAccountSaving.setCashFundAccountNumber(req.getParameter(cashFundAccountNumber));
    		regCashFundBankAccountSaving.setCashFundFirstName(req.getParameter(cashFundFirstName));
    		regCashFundBankAccountSaving.setCashFundLastName(req.getParameter(cashFundLastName));
    		regCashFundBankAccountSaving.setCashFundStreetAddress(req.getParameter(cashFundStreetAddress));
    		regCashFundBankAccountSaving.setCashFundAptOrUnit(req.getParameter(cashFundAptOrUnit));
    		regCashFundBankAccountSaving.setCashFundCity(req.getParameter(cashFundCity));
    		regCashFundBankAccountSaving.setCashFundState(req.getParameter(cashFundState));
    		regCashFundBankAccountSaving.setCashFundZipCode(req.getParameter(cashFundZipCode));
    		regCashFundBankAccountSaving.setCashFundPhoneNumber(req.getParameter(cashFundPhoneNumber));
    		regCashFundBankAccountSaving.setCreatedDate(currentDate);
    		registrantCashFundBankAccountInfoSavingDAO.save(regCashFundBankAccountSaving);
    	}
    	mav = new ModelAndView(redirectStatus + regiCashFundsDsp);	   	
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestTransferRequestUpdateInDataBase(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantCashFundBankAccountInfoSaving> regCFBankAccountsList = registrantCashFundBankAccountInfoSavingDAO.selectedCashFundBackAccountRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCFBankAccountsList.isEmpty()) {
    		Timestamp currentDate = currentDate();
    		long cashFundsPaymentSavingId = Long.parseLong(req.getParameter(guestCFPaymentInfoSavingId));
    		GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentModel = guestRegistryCashFundsPaymentInfoSavingDAO.guestMyAccountInfoUpdateInDB((Long) sn.getAttribute(registrantUserIdInSn), cashFundsPaymentSavingId);
    		guestCashFundPaymentModel.setCashFundStatus(transferReqStatus);
    		guestCashFundPaymentModel.setRefferanceDate(currentDate);
    		guestRegistryCashFundsPaymentInfoSavingDAO.merge(guestCashFundPaymentModel);
    		mav = new ModelAndView(redirectStatus + regiCashFundsDsp);
    	} else {
    		mav = regiCashFundsBankAccountsRedirection(req, sn);
    	}
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryTransferRequestUpdateInDataBase(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantCashFundBankAccountInfoSaving> regCFBankAccountsList = registrantCashFundBankAccountInfoSavingDAO.selectedCashFundBackAccountRowIdVerification((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCFBankAccountsList.isEmpty()) {
    		Timestamp currentDate = currentDate();
    		long cashFundsPaymentSavingId = Long.parseLong(req.getParameter(registryCFPaymentInfoSavingId));
    		RegistryCashFundsPaymentInfoSaving regCashFundPaymentModel = registryCashFundsPaymentInfoSavingDAO.registryMyAccountInfoUpdateInDB((Long) sn.getAttribute(registrantUserIdInSn), cashFundsPaymentSavingId);
    		regCashFundPaymentModel.setCashFundStatus(transferReqStatus);
    		regCashFundPaymentModel.setRefferanceDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.merge(regCashFundPaymentModel);
    		mav = new ModelAndView(redirectStatus + regiCashFundsDsp);
    	} else {
    		mav = regiCashFundsBankAccountsRedirection(req, sn);
    	}
 	   	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryCBIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regConToStoreCreditReff = req.getParameter(regConToStoreCreditRef);
    	long regConBoardsPaymentId = Long.parseLong(regConToStoreCreditReff);
    	Timestamp currentDate = currentDate();
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualPaymentSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regConBoardsPaymentId);
    	if (!regCBIndividualPaymentSavingList.isEmpty()) { 
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regConBoardsPaymentId);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(conToStoreCreditStatus);
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);    		
    		int regGivenQuantity = regCBIndividualPaymentSavingModel.getGiftedQuantity();
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		regCBIndividualProductSavingModel.setIndividualStatus(conToStoreCreditStatus);
    		registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
//			double individualAmountDb = registryIndividualCustomGiftCardPriceUsingCode(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalWithTaxValue, regCBIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalWithTaxValue);
    	}    	
 	   	mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestCBIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestConToStoreCreditRef = req.getParameter(regConToStoreCreditRef);
		long cbIndividualPaymentSavingId = Long.parseLong(guestConToStoreCreditRef);
		Timestamp currentDate = currentDate();
		List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualPaymentSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestCBMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualPaymentSavingId);
		if (!guestCBIndividualPaymentSavingList.isEmpty()) { 
			GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualPaymentSavingId);
			guestCBIndividualPaymentSavingModel.setIndividualStatus(conToStoreCreditStatus);
			guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
			guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);
			int regGivenQuantity = guestCBIndividualPaymentSavingModel.getGiftedQuantity();
			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			regCBIndividualProductSavingModel.setIndividualStatus(conToStoreCreditStatus);
			registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalWithTaxValue);
		}    	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestMACBIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestCBIndividualShopNow = req.getParameter("guestCBIndividualShopNowRef");
		long cbIndividualPaymentSavingId = Long.parseLong(guestCBIndividualShopNow);
		Timestamp currentDate = currentDate();
		List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualPaymentSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestCBMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualPaymentSavingId);
		if (!guestCBIndividualPaymentSavingList.isEmpty()) { 
			GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualPaymentSavingId);
			guestCBIndividualPaymentSavingModel.setIndividualStatus(orderProcessingStatus);
			guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
			guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);
			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
			registrantShipNowEmailSending(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regCBIndividualUpdateModel.getProductName(), regCBIndividualUpdateModel.getProductHeading());
		}   	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

	public String registrantShipNowEmailSending(HttpServletRequest req, HttpSession sn, String regUserEmail, String userFullName, String productName, String productSize) {
	  	String shopCartPaymentReff = null;
	  	String[] emailList = {regUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
	  	String subject = "Your Order Is Being Processed";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='margin-top: 0px; font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>You have requested for the following gifts to be shipped to the shipping address on file.</p>"                
				                
                + "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productName + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productSize + "</p>"
	        	+ "<div style='margin-top: 10px; border-top: 1px solid black; width: 300px;'></div>"								
				
				+ "<p style='margin-top: 30px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>We are processing these orders and will send out tracking details once they have shipped. Thank you!</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Registrant ship now email sending failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}    

    @Override
    @Transactional
    public ModelAndView registryMACBIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String registryCBIndividualShopNow = req.getParameter("registryCBIndividualShopNowRef");
    	long regConBoardsPaymentId = Long.parseLong(registryCBIndividualShopNow);
    	Timestamp currentDate = currentDate();
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualPaymentSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regConBoardsPaymentId);
    	if (!regCBIndividualPaymentSavingList.isEmpty()) { 
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regConBoardsPaymentId);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(orderProcessingStatus);
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel); 
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
			registrantShipNowEmailSending(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regCBIndividualUpdateModel.getProductName(), regCBIndividualUpdateModel.getProductHeading());
    	}    	
 	   	mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryMACBContributedConToStoreCredit(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestConToStoreCreditRef = req.getParameter(regConToStoreCreditRef);
		long cbContributedPaymentSavingId = Long.parseLong(guestConToStoreCreditRef);
		Timestamp currentDate = currentDate();
		List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.regConceptBoardsContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
		if (!regCBContributedSavingList.isEmpty()) { 
			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
			regCBContributedSavingModel.setContributedStatus(conToStoreCreditStatus);
			regCBContributedSavingModel.setUpdatedDate(currentDate);
			registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
			double myAccountContributedPrice = myAccountCotributedPriceCaliculation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
			registryMACBGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, cbContributedPaymentSavingId, currentDate);
			guestMACBGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, cbContributedPaymentSavingId, currentDate);			
//			double contributedPrice = Double.parseDouble(regCBContributedSavingModel.getContributedPrice());
//			double remainingTotalPrice = Double.parseDouble(regCBContributedSavingModel.getRemainingTotalPrice());
//			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
//			RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
//			double contributedAmountDb = registryCustomGiftCardPriceUsingCode(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalGiftedPrice, regCBContributedPaymentModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), myAccountContributedPrice);
		}    	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    public double myAccountCotributedPriceCaliculation(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductSavingId) {
    	double myAccountContributedPrice = 0;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryMyAccountCBPaymentContributedPriceFromDB(registrantUserId, cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {    		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			if(null != regCBContributedPaymentModel.getContributedPrice()) {
    				double regContributedPriceDb = Double.parseDouble(regCBContributedPaymentModel.getContributedPrice());
    				myAccountContributedPrice = myAccountContributedPrice + regContributedPriceDb;
    			}
    		}
    	}
    	List<GuestConceptBoardsContributedPaymentSaving> guestCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestMyAccountCBPaymentContributedPriceFromDB(registrantUserId, cbContributedProductSavingId);
    	if (!guestCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : guestCBContributedPaymentList) {
    			if(null != guestCBContributedSavingModel.getContributedPrice()) {
    				double guestContributedPriceDb = Double.parseDouble(guestCBContributedSavingModel.getContributedPrice());
    				myAccountContributedPrice = myAccountContributedPrice + guestContributedPriceDb;
    			}
    		}
    	}
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryMyAccountFTPaymentContributedPriceFromDB(registrantUserId, cbContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {    		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel : regFTContributedPaymentList) {
    			if(null != regFTContributedPaymentModel.getContributedPrice()) {
    				double regContributedPriceDb = Double.parseDouble(regFTContributedPaymentModel.getContributedPrice());
    				myAccountContributedPrice = myAccountContributedPrice + regContributedPriceDb;
    			}
    		}
    	}
    	List<GuestFinishingTouchesContributedPaymentSaving> guestFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestMyAccountFTPaymentContributedPriceFromDB(registrantUserId, cbContributedProductSavingId);
    	if (!guestFTContributedPaymentList.isEmpty()) {		
    		for (GuestFinishingTouchesContributedPaymentSaving guestFTContributedSavingModel : guestFTContributedPaymentList) {
    			if(null != guestFTContributedSavingModel.getContributedPrice()) {
    				double guestContributedPriceDb = Double.parseDouble(guestFTContributedSavingModel.getContributedPrice());
    				myAccountContributedPrice = myAccountContributedPrice + guestContributedPriceDb;
    			}
    		}
    	}
        return myAccountContributedPrice;
    }

    @Override
    @Transactional
    public ModelAndView regMACBContributedConToStoreCreditInBOTD(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestConToStoreCreditRef = req.getParameter(regConToStoreCreditRef);
		long cbContributedPaymentSavingId = Long.parseLong(guestConToStoreCreditRef);
		Timestamp currentDate = currentDate();
		List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.regConceptBoardsContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
		if (!regCBContributedSavingList.isEmpty()) { 
			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
			regCBContributedSavingModel.setContributedStatus(conToStoreCreditStatus);
			regCBContributedSavingModel.setUpdatedDate(currentDate);
			registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
			double myAccountContributedPrice = myAccountCotributedPriceCaliculation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
			registryMACBGRContributedPaymentInBOTDColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, cbContributedPaymentSavingId, currentDate);
			guestMACBGRContributedPaymentInBOTDColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, cbContributedPaymentSavingId, currentDate);
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), myAccountContributedPrice);
		}    	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryMACBContributedShopNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String regCBContributedShopNow = req.getParameter("regCBContributedShopNowRef");
		long cbContributedPaymentSavingId = Long.parseLong(regCBContributedShopNow);
		Timestamp currentDate = currentDate();
		List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.regConceptBoardsContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
		if (!regCBContributedSavingList.isEmpty()) { 
			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), cbContributedPaymentSavingId);
			regCBContributedSavingModel.setContributedStatus(orderProcessingStatus);
			regCBContributedSavingModel.setUpdatedDate(currentDate);
			registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
			registryMACBGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), orderProcessingStatus, cbContributedPaymentSavingId, currentDate);
			guestMACBGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), orderProcessingStatus, cbContributedPaymentSavingId, currentDate);
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
			registrantShipNowEmailSending(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regCBContributedSavingModel.getProductName(), regCBContributedSavingModel.getProductHeading());
		}
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    public String registryMACBGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String regCBContributedSavingValue = null;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryMyAccountCBPaymentContributedPriceFromDB(registrantUserIdInSn, cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			regCBContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regCBContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantConceptBoardsContributedPaymentSavingDAO.merge(regCBContributedPaymentModel);
    		}
    	}
    	return regCBContributedSavingValue;
    }

    public String guestMACBGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String guestCBContributedSavingValue = null;
    	List<GuestConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestMyAccountCBPaymentContributedPriceFromDB(registrantUserIdInSn, cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : regCBContributedPaymentList) {
    			guestCBContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestCBContributedSavingModel.setRefferanceDate(currentDate);
    			guestConceptBoardsContributedPaymentSavingDAO.merge(guestCBContributedSavingModel);
    		}
    	}
    	return guestCBContributedSavingValue;
    }

    public String registryMACBGRContributedPaymentInBOTDColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String regCBContributedSavingValue = null;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryMyAccountCBPaymentContributedInBOTDPriceFromDB(registrantUserIdInSn, cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			regCBContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regCBContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantConceptBoardsContributedPaymentSavingDAO.merge(regCBContributedPaymentModel);
    		}
    	}
    	return regCBContributedSavingValue;
    }

    public String guestMACBGRContributedPaymentInBOTDColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String guestCBContributedSavingValue = null;
    	List<GuestConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestMyAccountCBPaymentContributedInBOTDPriceFromDB(registrantUserIdInSn, cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : regCBContributedPaymentList) {
    			guestCBContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestCBContributedSavingModel.setRefferanceDate(currentDate);
    			guestConceptBoardsContributedPaymentSavingDAO.merge(guestCBContributedSavingModel);
    		}
    	}
    	return guestCBContributedSavingValue;
    }

    @Override
    @Transactional
    public ModelAndView guestMAFTIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestFTIndividualShopNow = req.getParameter("guestFTIndividualShopNowRef");
		long ftIndividualPaymentSavingId = Long.parseLong(guestFTIndividualShopNow);
		Timestamp currentDate = currentDate();
		List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualPaymentSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualPaymentSavingId);
		if (!guestFTIndividualPaymentSavingList.isEmpty()) { 
			GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualPaymentSavingId);
			guestFTIndividualPaymentSavingModel.setIndividualStatus(orderProcessingStatus);
			guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
			guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);
			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
			registrantShipNowEmailSending(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regFTIndividualUpdateModel.getProductName(), regFTIndividualUpdateModel.getProductHeading());
		}   	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    @Override
    @Transactional
    public ModelAndView guestFTIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestConToStoreCreditRef = req.getParameter(regConToStoreCreditRef);
		long ftIndividualPaymentSavingId = Long.parseLong(guestConToStoreCreditRef);
		Timestamp currentDate = currentDate();
		List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualPaymentSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualPaymentSavingId);
		if (!guestFTIndividualPaymentSavingList.isEmpty()) { 
			GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualPaymentSavingId);
			guestFTIndividualPaymentSavingModel.setIndividualStatus(conToStoreCreditStatus);
			guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
			guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);
			int regGivenQuantity = guestFTIndividualPaymentSavingModel.getGiftedQuantity();
			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			regFTIndividualProductSavingModel.setIndividualStatus(conToStoreCreditStatus);
			registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalWithTaxValue);
		}    	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryMAFTIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String registryFTIndividualShopNow = req.getParameter("registryFTIndividualShopNowRef");
    	long regFinTouchesPaymentId = Long.parseLong(registryFTIndividualShopNow);
    	Timestamp currentDate = currentDate();
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualPaymentSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFinTouchesPaymentId);
    	if (!regFTIndividualPaymentSavingList.isEmpty()) { 
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFinTouchesPaymentId);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(orderProcessingStatus);
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel); 
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
			registrantShipNowEmailSending(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regFTIndividualUpdateModel.getProductName(), regFTIndividualUpdateModel.getProductHeading());
    	}    	
 	   	mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryFTIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regConToStoreCreditReff = req.getParameter(regConToStoreCreditRef);
    	long regFinTouchesPaymentId = Long.parseLong(regConToStoreCreditReff);
    	Timestamp currentDate = currentDate();
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualPaymentSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTMyAccountIndividualPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFinTouchesPaymentId);
    	if (!regFTIndividualPaymentSavingList.isEmpty()) { 
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTMyAccountIndividualPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFinTouchesPaymentId);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(conToStoreCreditStatus);
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);    		
    		int regGivenQuantity = regFTIndividualPaymentSavingModel.getGiftedQuantity();
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		regFTIndividualProductSavingModel.setIndividualStatus(conToStoreCreditStatus);
    		registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
//			double individualAmountDb = registryIndividualCustomGiftCardPriceUsingCode(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalWithTaxValue, regFTIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalWithTaxValue);
    	}    	
 	   	mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryMAFTContributedConToStoreCredit(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestConToStoreCreditRef = req.getParameter(regConToStoreCreditRef);
		long ftContributedPaymentSavingId = Long.parseLong(guestConToStoreCreditRef);
		Timestamp currentDate = currentDate();
		List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.regFinishingTouchesContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
		if (!regFTContributedSavingList.isEmpty()) { 
			RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
			regFTContributedSavingModel.setContributedStatus(conToStoreCreditStatus);
			regFTContributedSavingModel.setUpdatedDate(currentDate);
			registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
			double myAccountContributedPrice = myAccountCotributedPriceCaliculation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
			registryMAFTGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, ftContributedPaymentSavingId, currentDate);
			guestMAFTGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, ftContributedPaymentSavingId, currentDate);			
//			double contributedPrice = Double.parseDouble(regFTContributedSavingModel.getContributedPrice());
//			double remainingTotalPrice = Double.parseDouble(regFTContributedSavingModel.getRemainingTotalPrice());
//			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
//			RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
//			double contributedAmountDb = registryCustomGiftCardPriceUsingCode(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), totalGiftedPrice, regFTContributedPaymentModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), myAccountContributedPrice);
		}    	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    public String registryMAFTGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String regFTContributedSavingValue = null;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryMyAccountFTPaymentContributedPriceFromDB(registrantUserIdInSn, ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel : regFTContributedPaymentList) {
    			regFTContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regFTContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantFinishingTouchesContributedPaymentSavingDAO.merge(regFTContributedPaymentModel);
    		}
    	}
    	return regFTContributedSavingValue;
    }

    public String guestMAFTGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String guestFTContributedSavingValue = null;
    	List<GuestFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestMyAccountFTPaymentContributedPriceFromDB(registrantUserIdInSn, ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (GuestFinishingTouchesContributedPaymentSaving guestFTContributedSavingModel : regFTContributedPaymentList) {
    			guestFTContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestFTContributedSavingModel.setRefferanceDate(currentDate);
    			guestFinishingTouchesContributedPaymentSavingDAO.merge(guestFTContributedSavingModel);
    		}
    	}
    	return guestFTContributedSavingValue;
    }

    @Override
    @Transactional
    public ModelAndView regMAFTContributedConToStoreCreditInBOTD(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String guestConToStoreCreditRef = req.getParameter(regConToStoreCreditRef);
		long ftContributedPaymentSavingId = Long.parseLong(guestConToStoreCreditRef);
		Timestamp currentDate = currentDate();
		List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.regFinishingTouchesContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
		if (!regFTContributedSavingList.isEmpty()) { 
			RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
			regFTContributedSavingModel.setContributedStatus(conToStoreCreditStatus);
			regFTContributedSavingModel.setUpdatedDate(currentDate);
			registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
			double myAccountContributedPrice = myAccountCotributedPriceCaliculation(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
			registryMAFTGRContributedPaymentInBOTDColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, ftContributedPaymentSavingId, currentDate);
			guestMAFTGRContributedPaymentInBOTDColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), conToStoreCreditStatus, ftContributedPaymentSavingId, currentDate);
			registrantCustomGiftCardGenerationForRegistrant(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), myAccountContributedPrice);
		}    	
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

    public String registryMAFTGRContributedPaymentInBOTDColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String regFTContributedSavingValue = null;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryMyAccountFTPaymentContributedInBOTDPriceFromDB(registrantUserIdInSn, ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel : regFTContributedPaymentList) {
    			regFTContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regFTContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantFinishingTouchesContributedPaymentSavingDAO.merge(regFTContributedPaymentModel);
    		}
    	}
    	return regFTContributedSavingValue;
    }

    public String guestMAFTGRContributedPaymentInBOTDColumnsUpdate(HttpServletRequest req, HttpSession sn, long registrantUserIdInSn, String contributedStatusReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String guestFTContributedSavingValue = null;
    	List<GuestFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestMyAccountFTPaymentContributedInBOTDPriceFromDB(registrantUserIdInSn, ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (GuestFinishingTouchesContributedPaymentSaving guestFTContributedSavingModel : regFTContributedPaymentList) {
    			guestFTContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestFTContributedSavingModel.setRefferanceDate(currentDate);
    			guestFinishingTouchesContributedPaymentSavingDAO.merge(guestFTContributedSavingModel);
    		}
    	}
    	return guestFTContributedSavingValue;
    }

    @Override
    @Transactional
    public ModelAndView registryMAFTContributedShopNowRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		String regFTContributedShopNow = req.getParameter("regFTContributedShopNowRef");
		long ftContributedPaymentSavingId = Long.parseLong(regFTContributedShopNow);
		Timestamp currentDate = currentDate();
		List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.regFinishingTouchesContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
		if (!regFTContributedSavingList.isEmpty()) { 
			RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), ftContributedPaymentSavingId);
			regFTContributedSavingModel.setContributedStatus(orderProcessingStatus);
			regFTContributedSavingModel.setUpdatedDate(currentDate);
			registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
			registryMAFTGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), orderProcessingStatus, ftContributedPaymentSavingId, currentDate);
			guestMAFTGRContributedPaymentColumnsUpdate(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), orderProcessingStatus, ftContributedPaymentSavingId, currentDate);
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn));
			registrantShipNowEmailSending(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regFTContributedSavingModel.getProductName(), regFTContributedSavingModel.getProductHeading());
		}
		mav = new ModelAndView(redirectStatus + regiGiftsReceivedDsp);
		return mav;
    }

	@Override
	@Transactional
	public Timestamp currentDate() {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
