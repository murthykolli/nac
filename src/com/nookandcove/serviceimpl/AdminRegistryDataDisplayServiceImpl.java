package com.nookandcove.serviceimpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.AdminRegistryConceptBoardsFurnitureSpecsSavingDAO;
import com.nookandcove.dao.AdminRegistryConceptBoardsSavingDAO;
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
import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;
import com.nookandcove.model.AdminRegistryConceptBoardsSaving;
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
import com.nookandcove.service.AdminRegistryDataDisplayService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class AdminRegistryDataDisplayServiceImpl implements AdminRegistryDataDisplayService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRegistryDataDisplayServiceImpl.class);	
    

	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
//	private String stockCheckProductId = "stockCheckProductId";
//	private String stockCheckProductPrice = "stockCheckProductPrice";
//	private String stockCheckProductOldPrice = "stockCheckProductOldPrice";
	private String availableStatus = "Available";
	private String backSoonStatus = "Back Soon";
	private String replaceStatus = "Replace";
	
	private String admnRegConBdIdsListInSn = "admnRegConBdIdsListInSn";
	private String admnRegConBdImagesListInSn = "admnRegConBdImagesListInSn";
	private String admnRegConBdCombinationListInSn = "admnRegConBdCombinationListInSn";
	private String admnRegConBdRoomNamesListInSn = "admnRegConBdRoomNamesListInSn";
	private String typeOfRoom = "typeOfRoom";
	private String typeOfRoomId = "typeOfRoomId";
	private String typeOfRoomInSn = "typeOfRoomInSn";
	private String typeOfRoomIdInSn = "typeOfRoomIdInSn";
	private String adminRegStockCheckAvailableConcepts = "adminRegStockCheckAvailableConcepts";
//	private String adminRegistryAllSCRed = "adminRegistryAllSCRed";
	
	private String roomFundDataForStoreCreditSn = "roomFundDataForStoreCreditSn";
	private String roomFundPriceForStoreCreditSn = "roomFundPriceForStoreCreditSn";
	private String typeOfCashFundName = "typeOfCashFundName";
	private String registryCashFundId = "registryCashFundId";
	private String adminCashFunds = "adminCashFunds";
	private String redirectStatus = "redirect:";
	private String transferNowStatus = "Transfer Now";
	private String transferCompleteStatus = "Transfer Completed";
	private String finiTouchesRefName = "Finishing Touches";
	private String consBoardsRefName = "Concept Boards";
	private String adminRegGiftRecPlaceOrderDataDisplay = "adminRegGiftRecPlaceOrderDataDisplay";
	private String bothCBAndFTRefName = "bothCBAndFTRefName";

	private String rgCBACStoreCreditTotalAmountInSn = "rgCBACStoreCreditTotalAmountInSn";	
	private String rgFTACStoreCreditTotalAmountInSn = "rgFTACStoreCreditTotalAmountInSn";
	private String rgCBContStoreCreditTotalAmountInSn = "rgCBContStoreCreditTotalAmountInSn";	
	private String rgFTContStoreCreditTotalAmountInSn = "rgFTContStoreCreditTotalAmountInSn";
	private String cashFundSmallImageUrl = "resources/images/cash_fund_images/small/";
	
	private String adminRegistryPendingCashFunds = "adminRegistryPendingCashFunds";
	private String adminRegistryClearedNotRequestedCashFunds = "adminRegistryClearedNotRequestedCashFunds";
	private String adminRegistryTransferRequestedCashFunds = "adminRegistryTransferRequestedCashFunds";
	private String adminRegistryTransferCompletedCashFunds = "adminRegistryTransferCompletedCashFunds";
	private String cashFundsStatus = "cashFundsStatus";
	private String adminNoCashFundsVal = "No Cash Funds";
	private String adminNoGiftReceived = "No Gift Received Data";
	private String giftReceivedStatus = "giftReceivedStatus";
	private String totalCashFundPrice = "totalCashFundPrice";
	private String guestCashFundStstus = "Guest Cash Fund";
	private String giftReceivedManagementId = "giftReceivedManagementId";
	
	private String adminRegistryGiftReceivedNoAction = "adminRegistryGiftReceivedNoAction";
	private String adminRegistryGiftReceivedShipNow = "adminRegistryGiftReceivedShipNow";	
	private String adminRegGiftReceivedOrderedDisplay = "adminRegGiftReceivedOrderedDisplay";
	private String adminRegistryGiftReceivedConvertedToCredit = "adminRegistryGiftReceivedConvertedToCredit";
	private String adminGiftsReceivedTrackingDisplay = "adminGiftsReceivedTrackingDisplay";
	private String adminRegGiftReceivedDeliveredDisplay = "adminRegGiftReceivedDeliveredDisplay";
	private String adminRegGiftReceivedBackOrderedDisplay = "adminRegGiftReceivedBackOrderedDisplay";
	private String adminRegGiftReceivedOutOfStockDisplay = "adminRegGiftReceivedOutOfStockDisplay";
	private String adminRoomFundsDataDisplay = "adminRoomFundsDataDisplay";

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
	private String adminCashFundsBankAccountsRed = "adminCashFundsBankAccountsRed";
	private String totalPendingFundsCount = "totalPendingFundsCount";
	private String totalClearedNotRequestedCount = "totalClearedNotRequestedCount";
	private String totalTransferRequestedCount = "totalTransferRequestedCount";
	private String totalTransferCompletedCount = "totalTransferCompletedCount";
	private String registryLiveStatusRed = "registryLiveStatusRed";
	private String registryArchiveStatusRed = "registryArchiveStatusRed";
	private String liveStatus = "Done";
	
	private String totalGRProductsCount = "totalGRProductsCount";
	private String totalGRProductAmount = "totalGRProductAmount";
	private String gusetIndConBoardsReff = "Guset Ind Con Boards";
	private String regIndConBoardsReff = "Regi Ind Con Boards";
	private String regContrConBoardsReff = "Regi Contr Con Boards";	
	private String gusetIndFinTouchesReff = "Guset Ind Fin Touches";
	private String regIndFinTouchesReff = "Regi Ind Fin Touches";
	private String regContrFinTouchesReff = "Regi Contr Fin Touches";
	
	private String cbIndividualProductName = "cbIndividualProductName";
	private String cbIndividualProductStore = "cbIndividualProductStore";
	private String cbIndividualProductHeading = "cbIndividualProductHeading";
	private String cbIndividualProductQuantity = "cbIndividualProductQuantity";
	private String cbIndividualProductPrice = "cbIndividualProductPrice";
	private String cbIndividualProductLink = "cbIndividualProductLink";
	private String cbBackOrderedText = "cbBackOrderedText";
	private String registrantFullName = "registrantFullName";
	private String registrantShippingAddress = "registrantShippingAddress";
	private String registrantApartment = "registrantApartment";
	private String registrantCity = "registrantCity";
	private String registrantState = "registrantState";
	private String registrantZip = "registrantZip";
	private String registrantPhoneNumber = "registrantPhoneNumber";
	private String registrantEmail = "registrantEmail";
	private String indNoActionStatusRef = "No Action";
	private String indOrderProcessingStatusRef = "Order Processing";
	private String indOrderedStatusRef = "Ordered";
	private String indTrackingStatusRef = "Tracking";
	private String indDeliveredStatusRef = "Delivered";
	private String indBOTillDateStatusRef = "Back Ordered Till";
	private String indOutOfStockStatusRef = "Converted to Store Credit Due to Out of Stock";
	private String individualCTSCRef = "Converted to Store Credit";
	
	private String giftRecNoActionCount = "giftRecNoActionCount";
	private String giftRecOrderProcessingCount = "giftRecOrderProcessingCount";
	private String giftRecOrderedCount = "giftRecOrderedCount";
	private String giftRecTrackingCount = "giftRecTrackingCount";
	private String giftRecDeliveredCount = "giftRecDeliveredCount";
	private String giftRecBackOrderedCount = "giftRecBackOrderedCount";
	private String giftRecOutOfStockCount = "giftRecOutOfStockCount";
	private String giftRecCTStoreCreditCount = "giftRecCTStoreCreditCount";
	private String groupGiftReffName = "Group Gift";
	private String registrantUserLoginInfoId = "registrantUserLoginInfoId";
	private String adminGiftReceivedBackOrderViewDetails = "adminGiftReceivedBackOrderViewDetails";
	private String backOrderDateDisplay = "backOrderDateDisplay";
	private String adminGiftReceivedBackOrdModifyDate = "adminGiftReceivedBackOrdModifyDate";
	private String adminGiftReceivedOutOfStockViewDetails = "adminGiftReceivedOutOfStockViewDetails";
	
	
	
	@Autowired
    private AdminRegistryConceptBoardsSavingDAO adminRegistryConceptBoardsSavingDAO;

	@Autowired
    private AdminRegistryConceptBoardsFurnitureSpecsSavingDAO adminRegistryConceptBoardsFurnitureSpecsSavingDAO;

	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;

	@Autowired
	private RegistrantShippingInfoSavingDAO registrantShippingInfoSavingDAO;

    @Autowired
    private GuestRoomFundPaymentInfoSavingDAO guestRoomFundPaymentInfoSavingDAO;

    @Autowired
    private RegistryRoomFundsPaymentInfoSavingDAO registryRoomFundsPaymentInfoSavingDAO;

	@Autowired
	private GuestUserPaymentInfoSavingDAO guestUserPaymentInfoSavingDAO;

    @Autowired
	private RegistryCashFundsInfoSavingDAO registryCashFundsInfoSavingDAO;

	@Autowired
	private RegistryCashFundsPaymentInfoSavingDAO registryCashFundsPaymentInfoSavingDAO;

	@Autowired
	private GuestRegistryCashFundsPaymentInfoSavingDAO guestRegistryCashFundsPaymentInfoSavingDAO;

	@Autowired
	private RegistrantCashFundBankAccountInfoSavingDAO registrantCashFundBankAccountInfoSavingDAO;

	@Autowired
    private RegistrantCustomGiftCardCodeSavingDAO registrantCustomGiftCardCodeSavingDAO;

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
    private RegistrantPaymentInfoSavingDAO registrantPaymentInfoSavingDAO;

	@Autowired
	private RegistrantFinishingTouchesIndividualProductsInfoSavingDAO registrantFinishingTouchesIndividualProductsInfoSavingDAO;

	@Autowired
	private RegistrantFinishingTouchesContributedProductsInfoSavingDAO registrantFinishingTouchesContributedProductsInfoSavingDAO;

	@Autowired
	private GuestFinishingTouchesIndividualPaymentSavingDAO guestFinishingTouchesIndividualPaymentSavingDAO;

	@Autowired
	private RegistrantFinishingTouchesIndividualPaymentSavingDAO registrantFinishingTouchesIndividualPaymentSavingDAO;

	@Autowired
	private RegistrantFinishingTouchesContributedPaymentSavingDAO registrantFinishingTouchesContributedPaymentSavingDAO;

	@Autowired
	private GuestFinishingTouchesContributedPaymentSavingDAO guestFinishingTouchesContributedPaymentSavingDAO;
    

    @Override
    @Transactional
    public ModelAndView registryLiveStatusRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List <RegistrantInformationSaving> registrantInformationList = registrantInformationSavingDAO.adminAllRegistrantsLiveStatusDataCheckInDB();
    	List <RegistrantInformationSaving> registrantArchiveList = registrantInformationSavingDAO.adminAllRegistrantsArchiveStatusDataCheckInDB();
        if (!registrantInformationList.isEmpty()) {
//        	int count = 0;
            List<RegistrantInformationSaving> regiInfoSavingList = new ArrayList<RegistrantInformationSaving>();            
            for (RegistrantInformationSaving regiInfoSavingLoop : registrantInformationList) {
            	RegistrantInformationSaving regiInfoSavingModel = new RegistrantInformationSaving();
            	regiInfoSavingModel.setCreatedDate(regiInfoSavingLoop.getCreatedDate());
            	String regFName = regiInfoSavingLoop.getRegFirstName();
            	String regLName = regiInfoSavingLoop.getRegLastName();
            	String regFullName = regFName + " " + regLName;            	
            	regiInfoSavingModel.setRegFirstName(regFullName);
            	String coRegFName = regiInfoSavingLoop.getCoRegFirstName();
            	String coRegLName = regiInfoSavingLoop.getCoRegLastName();
            	String coRegFullName = coRegFName + " " + coRegLName;            	
            	regiInfoSavingModel.setCoRegFirstName(coRegFullName);            	
            	regiInfoSavingModel.setRegUserName(regiInfoSavingLoop.getRegUserName());            	
            	regiInfoSavingModel.setEventType(regiInfoSavingLoop.getEventType());
            	regiInfoSavingModel.setEventDate(regiInfoSavingLoop.getEventDate());
            	String livesStatus = regiInfoSavingLoop.getStatus();
            	String Status = "";
            	if((liveStatus).equals(livesStatus)) {
            		Status = "Visible";
            	}
            	regiInfoSavingModel.setStatus(Status);
//            	count = count + 1;
//            	String totalCount = Integer.toString(count);
//            	regiInfoSavingModel.setState(totalCount);
            	regiInfoSavingModel.setRegistrantUserId(regiInfoSavingLoop.getRegistrantUserId());
            	regiInfoSavingModel.setRegSocialMedia(regiInfoSavingLoop.getRegSocialMedia());
            	regiInfoSavingList.add(regiInfoSavingModel);
            }
            mav = new ModelAndView(registryLiveStatusRed);
        	mav.addObject("adminRegistryLiveStatusSavingList", regiInfoSavingList);
            mav.addObject("adminRegistryLiveStatusListCount", registrantInformationList.size());
            mav.addObject("adminRegArchiveCount", registrantArchiveList.size());
        } else {
        	mav = new ModelAndView(registryLiveStatusRed);
        	mav.addObject("noLiveDataStatus", "No Live Data");
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryArchiveStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long registrantUserId = Long.parseLong(req.getParameter(registrantUserLoginInfoId));
    	RegistrantInformationSaving registrantInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	registrantInfoSavingModel.setRegArchiveStatus("Archive");
    	registrantInformationSavingDAO.merge(registrantInfoSavingModel);
    	mav = registryLiveStatusRedirection(req, sn);
    	return mav;    	
    }

    @Override
    @Transactional
    public ModelAndView registryArchiveStatusRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List <RegistrantInformationSaving> registrantInformationList = registrantInformationSavingDAO.adminAllRegistrantsArchiveStatusDataCheckInDB();
    	List <RegistrantInformationSaving> registranLiveList = registrantInformationSavingDAO.adminAllRegistrantsLiveStatusDataCheckInDB();
        if (!registrantInformationList.isEmpty()) {
//        	int count = 0;
            List<RegistrantInformationSaving> regiInfoSavingList = new ArrayList<RegistrantInformationSaving>();            
            for (RegistrantInformationSaving regiInfoSavingLoop : registrantInformationList) {
            	RegistrantInformationSaving regiInfoSavingModel = new RegistrantInformationSaving();
            	regiInfoSavingModel.setCreatedDate(regiInfoSavingLoop.getCreatedDate());
            	String regFName = regiInfoSavingLoop.getRegFirstName();
            	String regLName = regiInfoSavingLoop.getRegLastName();
            	String regFullName = regFName + " " + regLName;            	
            	regiInfoSavingModel.setRegFirstName(regFullName);
            	String coRegFName = regiInfoSavingLoop.getCoRegFirstName();
            	String coRegLName = regiInfoSavingLoop.getCoRegLastName();
            	String coRegFullName = coRegFName + " " + coRegLName;            	
            	regiInfoSavingModel.setCoRegFirstName(coRegFullName);            	
            	regiInfoSavingModel.setRegUserName(regiInfoSavingLoop.getRegUserName());            	
            	regiInfoSavingModel.setEventType(regiInfoSavingLoop.getEventType());
            	regiInfoSavingModel.setEventDate(regiInfoSavingLoop.getEventDate());
            	String livesStatus = regiInfoSavingLoop.getStatus();
            	String Status = "";
            	if((liveStatus).equals(livesStatus)) {
            		Status = "Visible";
            	}
            	regiInfoSavingModel.setStatus(Status);
//            	count = count + 1;
//            	String totalCount = Integer.toString(count);
            	regiInfoSavingModel.setRegistrantUserId(regiInfoSavingLoop.getRegistrantUserId());
            	regiInfoSavingModel.setRegSocialMedia(regiInfoSavingLoop.getRegSocialMedia());
//            	regiInfoSavingModel.setState(totalCount);
            	regiInfoSavingList.add(regiInfoSavingModel);
            }
            mav = new ModelAndView(registryArchiveStatusRed);
        	mav.addObject("adminRegistryArchiveStatusSavingList", regiInfoSavingList);
            mav.addObject("adminRegistryArchiveStatusListCount", registrantInformationList.size());
            mav.addObject("adminRegLiveCount", registranLiveList.size());
        } else {
        	mav = new ModelAndView(registryArchiveStatusRed);
        	mav.addObject("noLiveDataStatus", "No Live Data");
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryLiveStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long registrantUserId = Long.parseLong(req.getParameter(registrantUserLoginInfoId));
    	RegistrantInformationSaving registrantInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	registrantInfoSavingModel.setRegArchiveStatus(null);
    	registrantInformationSavingDAO.merge(registrantInfoSavingModel);
    	mav = registryArchiveStatusRedirection(req, sn);
    	return mav;    	
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryDataDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView("adminRegistryDataDisplay");    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryStockCheckRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegConBdImagesList = new ArrayList();
    	List admnRegConBdRoomNamesList = new ArrayList();
    	List admnRegConBdIdsList = new ArrayList();
    	List admnRegConBdCombinationList = new ArrayList();
    	String livingRoomRef = "Living Room";
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminCBStockCheckListTakeFromDBUsingRoomName(livingRoomRef);
    	if (!admnRegConBdRoomsList.isEmpty()) {    		
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			String admRegConBdCombiList = adminRegistryStockCheckProductsCombDataFromDB(req, sn, admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			if(null != admRegConBdCombiList) {
	    			admnRegConBdIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	    			admnRegConBdRoomNamesList.add(admnRegConBdSavingModel.getRoom());    			
		    		admnRegConBdCombinationList.add(admRegConBdCombiList);
		    		admnRegConBdImagesList.add(admnRegConBdSavingModel.getConceptBoardsImage());
    			}
     	   	}    		
    	}    	
    	mav = new ModelAndView(adminRegStockCheckAvailableConcepts);
    	sn.setAttribute(admnRegConBdIdsListInSn, admnRegConBdIdsList);
    	sn.setAttribute(admnRegConBdRoomNamesListInSn, admnRegConBdRoomNamesList);
    	sn.setAttribute(admnRegConBdImagesListInSn, admnRegConBdImagesList);
    	sn.setAttribute(admnRegConBdCombinationListInSn, admnRegConBdCombinationList);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(typeOfRoom, livingRoomRef);
    	mav.addObject(typeOfRoomId, "livingRoomId");
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryStockCheckSelectedRoom(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegConBdImagesList = new ArrayList();
    	List admnRegConBdRoomNamesList = new ArrayList();
    	List admnRegConBdIdsList = new ArrayList();
    	List admnRegConBdCombinationList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminCBStockCheckListTakeFromDBUsingRoomName(req.getParameter(typeOfRoom));
    	if (!admnRegConBdRoomsList.isEmpty()) {    		
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {    			
    			String admRegConBdCombiList = adminRegistryStockCheckProductsCombDataFromDB(req, sn, admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			if(null != admRegConBdCombiList) {
	    			admnRegConBdIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	    			admnRegConBdRoomNamesList.add(admnRegConBdSavingModel.getRoom());    			
		    		admnRegConBdCombinationList.add(admRegConBdCombiList);
		    		admnRegConBdImagesList.add(admnRegConBdSavingModel.getConceptBoardsImage());
    			}
     	   	}    		
    	}    	
    	mav = new ModelAndView(adminRegStockCheckAvailableConcepts);
    	sn.setAttribute(admnRegConBdIdsListInSn, admnRegConBdIdsList);
    	sn.setAttribute(admnRegConBdRoomNamesListInSn, admnRegConBdRoomNamesList);
    	sn.setAttribute(admnRegConBdImagesListInSn, admnRegConBdImagesList);
    	sn.setAttribute(admnRegConBdCombinationListInSn, admnRegConBdCombinationList);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(typeOfRoom, req.getParameter(typeOfRoom));
    	mav.addObject(typeOfRoomId, req.getParameter(typeOfRoomId));
    	return mav;
    }
//    
//    @Override
//    @Transactional
//    public ModelAndView adminRegistrySCProdPrice1UpdateInDB(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String stCheckProductPrice = req.getParameter(stockCheckProductPrice);
//    	String stCheckProductId = req.getParameter(stockCheckProductId);
//    	String stCheckProductOldPrice = req.getParameter(stockCheckProductOldPrice);
//    	long productsId = Long.parseLong(stCheckProductId);
//    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
//    	admRegConBdProductsModel.setProductPrice1(stCheckProductPrice);
//    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
//    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBContributedInfoList.isEmpty()) {
//        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
//        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }    	
//    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBIndividualInfoList.isEmpty()) {
//        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
//        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }
//    	sn.setAttribute(typeOfRoomIdInSn, req.getParameter(typeOfRoomId));
//    	sn.setAttribute(typeOfRoomInSn, req.getParameter(typeOfRoom));
//    	mav = new ModelAndView("redirect:" + adminRegistryAllSCRed);
//    	return mav;
//    }
//
//    @Override
//    @Transactional
//    public ModelAndView adminRegistrySCProdPrice2UpdateInDB(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String stCheckProductPrice = req.getParameter(stockCheckProductPrice);
//    	String stCheckProductId = req.getParameter(stockCheckProductId);
//    	String stCheckProductOldPrice = req.getParameter(stockCheckProductOldPrice);
//    	long productsId = Long.parseLong(stCheckProductId);
//    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
//    	admRegConBdProductsModel.setProductPrice2(stCheckProductPrice);
//    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
//    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBContributedInfoList.isEmpty()) {
//        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
//        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }    	
//    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBIndividualInfoList.isEmpty()) {
//        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
//        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }
//    	sn.setAttribute(typeOfRoomIdInSn, req.getParameter(typeOfRoomId));
//    	sn.setAttribute(typeOfRoomInSn, req.getParameter(typeOfRoom));
//    	mav = new ModelAndView("redirect:" + adminRegistryAllSCRed);
//    	return mav;
//    }
//
//    @Override
//    @Transactional
//    public ModelAndView adminRegistrySCProdPrice3UpdateInDB(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String stCheckProductPrice = req.getParameter(stockCheckProductPrice);
//    	String stCheckProductId = req.getParameter(stockCheckProductId);
//    	String stCheckProductOldPrice = req.getParameter(stockCheckProductOldPrice);
//    	long productsId = Long.parseLong(stCheckProductId);
//    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
//    	admRegConBdProductsModel.setProductPrice3(stCheckProductPrice);
//    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
//    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBContributedInfoList.isEmpty()) {
//        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
//        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }    	
//    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBIndividualInfoList.isEmpty()) {
//        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
//        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }
//    	sn.setAttribute(typeOfRoomIdInSn, req.getParameter(typeOfRoomId));
//    	sn.setAttribute(typeOfRoomInSn, req.getParameter(typeOfRoom));
//    	mav = new ModelAndView("redirect:" + adminRegistryAllSCRed);
//    	return mav;
//    }
//
//    @Override
//    @Transactional
//    public ModelAndView adminRegistrySCProdPrice4UpdateInDB(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String stCheckProductPrice = req.getParameter(stockCheckProductPrice);
//    	String stCheckProductId = req.getParameter(stockCheckProductId);
//    	String stCheckProductOldPrice = req.getParameter(stockCheckProductOldPrice);
//    	long productsId = Long.parseLong(stCheckProductId);
//    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
//    	admRegConBdProductsModel.setProductPrice4(stCheckProductPrice);
//    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
//    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBContributedInfoList.isEmpty()) {
//        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
//        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }    	
//    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBIndividualInfoList.isEmpty()) {
//        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
//        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }
//    	sn.setAttribute(typeOfRoomIdInSn, req.getParameter(typeOfRoomId));
//    	sn.setAttribute(typeOfRoomInSn, req.getParameter(typeOfRoom));
//    	mav = new ModelAndView("redirect:" + adminRegistryAllSCRed);
//    	return mav;
//    }
//
//    @Override
//    @Transactional
//    public ModelAndView adminRegistrySCProdPrice5UpdateInDB(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String stCheckProductPrice = req.getParameter(stockCheckProductPrice);
//    	String stCheckProductId = req.getParameter(stockCheckProductId);
//    	String stCheckProductOldPrice = req.getParameter(stockCheckProductOldPrice);
//    	long productsId = Long.parseLong(stCheckProductId);
//    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
//    	admRegConBdProductsModel.setProductPrice5(stCheckProductPrice);
//    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
//    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBContributedInfoList.isEmpty()) {
//        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
//        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }    	
//    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stCheckProductOldPrice);
//    	if (!regCBIndividualInfoList.isEmpty()) {
//        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
//        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stCheckProductOldPrice);
//				regDesigenConceptBoardModel.setProductPrice(stCheckProductPrice);
//				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
//        	}
//        }
//    	sn.setAttribute(typeOfRoomIdInSn, req.getParameter(typeOfRoomId));
//    	sn.setAttribute(typeOfRoomInSn, req.getParameter(typeOfRoom));
//    	mav = new ModelAndView("redirect:" + adminRegistryAllSCRed);
//    	return mav;
//    }

    @Override
    @Transactional
    public ModelAndView adminRegistryAllSCRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegConBdImagesList = new ArrayList();
    	List admnRegConBdRoomNamesList = new ArrayList();
    	List admnRegConBdIdsList = new ArrayList();
    	List admnRegConBdCombinationList = new ArrayList();
    	String typeOfRooms = (String) sn.getAttribute(typeOfRoomInSn);
    	String typeOfRoomsId = (String) sn.getAttribute(typeOfRoomIdInSn);
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminCBStockCheckListTakeFromDBUsingRoomName(typeOfRooms);
    	if (!admnRegConBdRoomsList.isEmpty()) {    		
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {    			
    			String admRegConBdCombiList = adminRegistryStockCheckProductsCombDataFromDB(req, sn, admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			if(null != admRegConBdCombiList) {
	    			admnRegConBdIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	    			admnRegConBdRoomNamesList.add(admnRegConBdSavingModel.getRoom());    			
		    		admnRegConBdCombinationList.add(admRegConBdCombiList);
		    		admnRegConBdImagesList.add(admnRegConBdSavingModel.getConceptBoardsImage());
    			}
     	   	}    		
    	}    	
    	mav = new ModelAndView(adminRegStockCheckAvailableConcepts);
    	sn.setAttribute(admnRegConBdIdsListInSn, admnRegConBdIdsList);
    	sn.setAttribute(admnRegConBdRoomNamesListInSn, admnRegConBdRoomNamesList);
    	sn.setAttribute(admnRegConBdImagesListInSn, admnRegConBdImagesList);
    	sn.setAttribute(admnRegConBdCombinationListInSn, admnRegConBdCombinationList);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(typeOfRoom, typeOfRooms);
    	mav.addObject(typeOfRoomId, typeOfRoomsId);
    	return mav;
    }

//    @Override
//    @Transactional
//    public ModelAndView adminRegistrySCStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	String stCheckStatusName = req.getParameter("stockCheckStatusName");
//    	String stCheckProductId = req.getParameter(stockCheckProductId);    	
//    	long productsId = Long.parseLong(stCheckProductId);
//    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
//    	admRegConBdProductsModel.setAdminStockCheckStatus(stCheckStatusName);
//    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);
//    	sn.setAttribute(typeOfRoomIdInSn, req.getParameter(typeOfRoomId));
//    	sn.setAttribute(typeOfRoomInSn, req.getParameter(typeOfRoom));
//    	mav = new ModelAndView("redirect:" + adminRegistryAllSCRed);
//    	return mav;
//    }

    @Override
    @Transactional
    public JSONArray jSonStockCheckItemStatusUpdateInDB(String scItemCombValue, HttpSession sn, HttpServletRequest req) {
    	String[] scItemCombValueSt = scItemCombValue.split("__");    	
    	long productsId = Long.parseLong(scItemCombValueSt[0]);
    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
    	admRegConBdProductsModel.setAdminStockCheckStatus(scItemCombValueSt[1]);
    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
    	JSONArray stAvailJson = new JSONArray();
        return stAvailJson;
    }

    @Override
    @Transactional
    public JSONArray jSonStockCheckPrice1UpdateInDB(String stPrice1UpdateCombValue, HttpSession sn, HttpServletRequest req) {
    	String[] stPrice1UpdateCombValueSt = stPrice1UpdateCombValue.split("__");    	
    	long productsId = Long.parseLong(stPrice1UpdateCombValueSt[2]);
    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
    	admRegConBdProductsModel.setProductPrice1(stPrice1UpdateCombValueSt[0]);
    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stPrice1UpdateCombValueSt[1]);
    	if (!regCBContributedInfoList.isEmpty()) {
        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stPrice1UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice1UpdateCombValueSt[0]);
				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }    	
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stPrice1UpdateCombValueSt[1]);
    	if (!regCBIndividualInfoList.isEmpty()) {
        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stPrice1UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice1UpdateCombValueSt[0]);
				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }    	   	
    	JSONArray stAvailJson = new JSONArray();
        return stAvailJson;
    }

    @Override
    @Transactional
    public JSONArray jSonStockCheckPrice2UpdateInDB(String stPrice2UpdateCombValue, HttpSession sn, HttpServletRequest req) {
    	String[] stPrice2UpdateCombValueSt = stPrice2UpdateCombValue.split("__");    	
    	long productsId = Long.parseLong(stPrice2UpdateCombValueSt[2]);
    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
    	admRegConBdProductsModel.setProductPrice2(stPrice2UpdateCombValueSt[0]);
    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stPrice2UpdateCombValueSt[1]);
    	if (!regCBContributedInfoList.isEmpty()) {
        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stPrice2UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice2UpdateCombValueSt[0]);
				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }    	
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stPrice2UpdateCombValueSt[1]);
    	if (!regCBIndividualInfoList.isEmpty()) {
        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stPrice2UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice2UpdateCombValueSt[0]);
				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }	   	
    	JSONArray stAvailJson = new JSONArray();
        return stAvailJson;
    }

    @Override
    @Transactional
    public JSONArray jSonStockCheckPrice3UpdateInDB(String stPrice3UpdateCombValue, HttpSession sn, HttpServletRequest req) {
    	String[] stPrice3UpdateCombValueSt = stPrice3UpdateCombValue.split("__");    	
    	long productsId = Long.parseLong(stPrice3UpdateCombValueSt[2]);
    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
    	admRegConBdProductsModel.setProductPrice3(stPrice3UpdateCombValueSt[0]);
    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stPrice3UpdateCombValueSt[1]);
    	if (!regCBContributedInfoList.isEmpty()) {
        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stPrice3UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice3UpdateCombValueSt[0]);
				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }    	
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stPrice3UpdateCombValueSt[1]);
    	if (!regCBIndividualInfoList.isEmpty()) {
        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stPrice3UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice3UpdateCombValueSt[0]);
				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }	   	
    	JSONArray stAvailJson = new JSONArray();
        return stAvailJson;
    }

    @Override
    @Transactional
    public JSONArray jSonStockCheckPrice4UpdateInDB(String stPrice4UpdateCombValue, HttpSession sn, HttpServletRequest req) {
    	String[] stPrice4UpdateCombValueSt = stPrice4UpdateCombValue.split("__");    	
    	long productsId = Long.parseLong(stPrice4UpdateCombValueSt[2]);
    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
    	admRegConBdProductsModel.setProductPrice4(stPrice4UpdateCombValueSt[0]);
    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stPrice4UpdateCombValueSt[1]);
    	if (!regCBContributedInfoList.isEmpty()) {
        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stPrice4UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice4UpdateCombValueSt[0]);
				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }    	
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stPrice4UpdateCombValueSt[1]);
    	if (!regCBIndividualInfoList.isEmpty()) {
        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stPrice4UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice4UpdateCombValueSt[0]);
				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }	   	
    	JSONArray stAvailJson = new JSONArray();
        return stAvailJson;
    }

    @Override
    @Transactional
    public JSONArray jSonStockCheckPrice5UpdateInDB(String stPrice5UpdateCombValue, HttpSession sn, HttpServletRequest req) {
    	String[] stPrice5UpdateCombValueSt = stPrice5UpdateCombValue.split("__");    	
    	long productsId = Long.parseLong(stPrice5UpdateCombValueSt[2]);
    	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBdProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(productsId);
    	admRegConBdProductsModel.setProductPrice5(stPrice5UpdateCombValueSt[0]);
    	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegConBdProductsModel);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesListFromInDB(productsId, stPrice5UpdateCombValueSt[1]);
    	if (!regCBContributedInfoList.isEmpty()) {
        	for(int i=0; i<regCBContributedInfoList.size(); i++) {
        		RegistrantConceptBoardsContributedProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsContributedProductsInfoSavingDAO.adminCBContributedPricesUpdatedInDB(productsId, stPrice5UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice5UpdateCombValueSt[0]);
				registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }    	
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesListFromInDB(productsId, stPrice5UpdateCombValueSt[1]);
    	if (!regCBIndividualInfoList.isEmpty()) {
        	for(int i=0; i<regCBIndividualInfoList.size(); i++) {
        		RegistrantConceptBoardsIndividualProductsInfoSaving regDesigenConceptBoardModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.adminCBIndividualPricesUpdatedInDB(productsId, stPrice5UpdateCombValueSt[1]);
				regDesigenConceptBoardModel.setProductPrice(stPrice5UpdateCombValueSt[0]);
				registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regDesigenConceptBoardModel);
        	}
        }	   	
    	JSONArray stAvailJson = new JSONArray();
        return stAvailJson;
    }
    
//    public ModelAndView adminRegistryAllSCRedirection1(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	List admnRegConBdImagesList = new ArrayList();
//    	List admnRegConBdRoomNamesList = new ArrayList();
//    	List admnRegConBdIdsList = new ArrayList();
//    	List admnRegConBdCombinationList = new ArrayList();
//    	String typeOfRooms = (String) sn.getAttribute(typeOfRoomInSn);
//    	String typeOfRoomsId = (String) sn.getAttribute(typeOfRoomIdInSn);
//    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminCBStockCheckListTakeFromDBUsingRoomName(typeOfRooms);
//    	if (!admnRegConBdRoomsList.isEmpty()) {    		
//    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {    			
//    			String admRegConBdCombiList = adminRegistryStockCheckProductsCombDataFromDB(req, sn, admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
//    			if(null != admRegConBdCombiList) {
//	    			admnRegConBdIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
//	    			admnRegConBdRoomNamesList.add(admnRegConBdSavingModel.getRoom());    			
//		    		admnRegConBdCombinationList.add(admRegConBdCombiList);
//		    		admnRegConBdImagesList.add(admnRegConBdSavingModel.getConceptBoardsImage());
//    			}
//     	   	}    		
//    	}    	
//    	mav = new ModelAndView();
//    	sn.setAttribute(admnRegConBdIdsListInSn, admnRegConBdIdsList);
//    	sn.setAttribute(admnRegConBdRoomNamesListInSn, admnRegConBdRoomNamesList);
//    	sn.setAttribute(admnRegConBdImagesListInSn, admnRegConBdImagesList);
//    	sn.setAttribute(admnRegConBdCombinationListInSn, admnRegConBdCombinationList);
//    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
//    	mav.addObject(typeOfRoom, typeOfRooms);
//    	mav.addObject(typeOfRoomId, typeOfRoomsId);
//    	return mav;
//    }
        
    public int adminRegistryStockCheckAllConceptsCount(HttpServletRequest req, HttpSession sn) {
    	int adminAllConcepts = 0;    	
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> allConceptsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.allStockCheckConceptsTotalCount();    	
    	adminAllConcepts = allConceptsProductsList.size();
    	return adminAllConcepts;
    }
    
    public int adminRegistryStockCheckAvailableConceptsCount(HttpServletRequest req, HttpSession sn) {
    	int adminAvailableConcepts = 0;    	
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> availableProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.allThreeStockCheckConceptsTotalCount(availableStatus);    	
    	adminAvailableConcepts = availableProductsList.size();
    	return adminAvailableConcepts;
    }
    
    public int adminRegistryStockCheckBackSoonConceptsCount(HttpServletRequest req, HttpSession sn) {
    	int adminBackSoonConcepts = 0;    	
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> backSoonProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.allThreeStockCheckConceptsTotalCount(backSoonStatus);    	
    	adminBackSoonConcepts = backSoonProductsList.size();
    	return adminBackSoonConcepts;
    }
    
    public int adminRegistryStockCheckReplaceConceptsCount(HttpServletRequest req, HttpSession sn) {
    	int adminReplaceConcepts = 0;    	
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> replaceProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.allThreeStockCheckConceptsTotalCount(replaceStatus);
    	adminReplaceConcepts = replaceProductsList.size();
    	return adminReplaceConcepts;
    }
     
    public String adminRegistryStockCheckProductsCombDataFromDB(HttpServletRequest req, HttpSession sn, long admnRegConBdId) {
    	String admnRegConBdCombinationList = null;
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> conBdFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecCount(admnRegConBdId); 	
    	if (!conBdFurSpecsProductsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsFurnitureSpecsSaving admnRegConBdProdSavingModel : conBdFurSpecsProductsList) {
    			String admnRegProductPrice1 = adminRegistryStockCheckProductPrice1Comb(req, sn, admnRegConBdProdSavingModel.getProductPrice1());
    			String admnRegProductPrice2 = adminRegistryStockCheckProductPrice2Comb(req, sn, admnRegConBdProdSavingModel.getProductPrice2());
    			String admnRegProductPrice3 = adminRegistryStockCheckProductPrice3Comb(req, sn, admnRegConBdProdSavingModel.getProductPrice3());
    			String admnRegProductPrice4 = adminRegistryStockCheckProductPrice4Comb(req, sn, admnRegConBdProdSavingModel.getProductPrice4());
    			String admnRegProductPrice5 = adminRegistryStockCheckProductPrice5Comb(req, sn, admnRegConBdProdSavingModel.getProductPrice5());
    			String allCombinationsList = admnRegConBdProdSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "___" + admnRegConBdProdSavingModel.getStoreUrl() + "___" + admnRegConBdProdSavingModel.getAdminStockCheckStatus() + "___" + admnRegProductPrice1 + "___" + admnRegProductPrice2 + "___" + admnRegProductPrice3 + "___" + admnRegProductPrice4 + "___" + admnRegProductPrice5;
    			admnRegConBdCombinationList = admnRegConBdCombinationList + "_&&_" + allCombinationsList;
    		}
    		admnRegConBdCombinationList = admnRegConBdCombinationList.replaceFirst("null_&&_", "");
    	}
    	return admnRegConBdCombinationList;
    }
    
    public String adminRegistryStockCheckProductPrice1Comb(HttpServletRequest req, HttpSession sn, String price1) {
    	String admnRegProductPrice1 = "0";   	
    	if(!("").equals(price1) && price1 != null) {
    		admnRegProductPrice1 = price1;
    	}
    	return admnRegProductPrice1;
    }

    public String adminRegistryStockCheckProductPrice2Comb(HttpServletRequest req, HttpSession sn, String price2) {
    	String admnRegProductPrice2 = "0";
    	if(!("").equals(price2) && price2 != null) {
    		admnRegProductPrice2 = price2;
    	}
    	return admnRegProductPrice2;
    }

    public String adminRegistryStockCheckProductPrice3Comb(HttpServletRequest req, HttpSession sn, String price3) {
    	String admnRegProductPrice3 = "0";
    	if(!("").equals(price3) && price3 != null) {
    		admnRegProductPrice3 = price3;
    	}
    	return admnRegProductPrice3;
    }

    public String adminRegistryStockCheckProductPrice4Comb(HttpServletRequest req, HttpSession sn, String price4) {
    	String admnRegProductPrice4 = "0";	
    	if(!("").equals(price4) && price4 != null) {
    		admnRegProductPrice4 = price4;
    	}
    	return admnRegProductPrice4;
    }

    public String adminRegistryStockCheckProductPrice5Comb(HttpServletRequest req, HttpSession sn, String price5) {
    	String admnRegProductPrice5 = "0";
    	if(!("").equals(price5) && price5 != null) {
    		admnRegProductPrice5 = price5;
    	}
    	return admnRegProductPrice5;
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

    public double allRegistryAndGuestGiftAmountTotal(HttpServletRequest req, HttpSession sn) {
    	double allTotalGiftAmount = 0;
    	int roomFundPriceForStoreCredit = 0;
    	if(null != sn.getAttribute(roomFundPriceForStoreCreditSn)) {
    		roomFundPriceForStoreCredit = (int) sn.getAttribute(roomFundPriceForStoreCreditSn);
    	}    	
    	double rgCBACStoreCreditTotalAmount = 0;
    	if(null != sn.getAttribute(rgCBACStoreCreditTotalAmountInSn)) {
    		rgCBACStoreCreditTotalAmount = (double) sn.getAttribute(rgCBACStoreCreditTotalAmountInSn);
    	}    	
    	double rgFTACStoreCreditTotalAmount = 0;
    	if(null != sn.getAttribute(rgFTACStoreCreditTotalAmountInSn)) {
    		rgFTACStoreCreditTotalAmount = (double) sn.getAttribute(rgFTACStoreCreditTotalAmountInSn);
    	}    	
    	double rgCBContStoreCreditTotalAmount = 0;
    	if(null != sn.getAttribute(rgCBContStoreCreditTotalAmountInSn)) {
    		rgCBContStoreCreditTotalAmount = (double) sn.getAttribute(rgCBContStoreCreditTotalAmountInSn);
    	}    	
    	double rgFTContStoreCreditTotalAmount = 0;
    	if(null != sn.getAttribute(rgFTContStoreCreditTotalAmountInSn)) {
    		rgFTContStoreCreditTotalAmount = (double) sn.getAttribute(rgFTContStoreCreditTotalAmountInSn);
    	}
    	allTotalGiftAmount = roomFundPriceForStoreCredit + rgCBACStoreCreditTotalAmount + rgFTACStoreCreditTotalAmount + rgCBContStoreCreditTotalAmount + rgFTContStoreCreditTotalAmount;
        return allTotalGiftAmount;
    }

    @Override
    @Transactional
    public ModelAndView registrantRoomFundsForStoreCreditDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	ModelAndView mav;
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
    	mav = registrantAndGuestStoreCreditDataDisplay(req, sn, storeCredRoomFundsPaymentInfoList);
 	   	mav = new ModelAndView();
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantAndGuestStoreCreditDataDisplay(HttpServletRequest req, HttpSession sn, String storeCredRoomFunds) {
    	ModelAndView mav;
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
    		sn.setAttribute(roomFundPriceForStoreCreditSn, totalRoomFundsAmount);
    	}
 	   	mav = new ModelAndView();
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryCashFundsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestCashFundsPaymentInfoList = null;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestPendingCashFundsInfoCheckInDB();
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		for (GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentSavingModel : guestCashFundPaymentRowList) {
    	    	long guestCashFundId = guestCashFundPaymentSavingModel.getGuestRegistryCashFundsPaymentInfoSavingId();
    	    	String cashFundPrice = guestCashFundPaymentSavingModel.getContributedCashFundPrice();
    	    	String registrantCashFundName = guestCashFundPaymentSavingModel.getCashFundName();    	    	
    	    	Timestamp guscrDate = guestCashFundPaymentSavingModel.getCreatedDate();
    	    	Date date1 = new Date();
    	    	date1.setTime(guscrDate.getTime());
    	    	String createdDate1 = new SimpleDateFormat("MM/dd/yyyy").format(date1);
    	    	long admnGuestRegistrantUserId = guestCashFundPaymentSavingModel.getRegistrantUserId();
    	    	long guestPaymentSavingId = guestCashFundPaymentSavingModel.getGuestUserPaymentInfoSavingId();
    	    	String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestPaymentSavingId);
    	    	long cashFundSavingId = guestCashFundPaymentSavingModel.getRegistryCashFundsInfoSavingId();
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnGuestRegistrantUserId);
    	    	String registrantGuestCashFundImage = registrantCashFundImageTakeFromDB(req, sn, admnGuestRegistrantUserId, cashFundSavingId);
    	    	String guestCashFundsSpaceList = registrantGuestCashFundImage + ",_," + registrantCashFundName + ",_," + cashFundPrice + ",_," + guestFullName + ",_," + createdDate1 + ",_," + guestCashFundId + ",_," + registrantFullName;
    	    	guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList + "__" + guestCashFundsSpaceList;
        	}
    		guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList.replaceFirst("null__", "");
    	}    	
    	sn.setAttribute("adminGuestPendingCashFundsPaymentInfo", guestCashFundsPaymentInfoList);
    	int totPendingFundsCount = adminRegistryFundsPendingCount(req, sn);
    	int totClearedNotRequestedCount = adminRegistryClearedNotRequestedCount(req, sn);
    	int totTransferRequestedCount = adminRegistryTransferRequestedCount(req, sn);
    	int totTransferCompletedCount = adminRegistryTransferCompletedCount(req, sn);
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		mav = new ModelAndView(adminRegistryPendingCashFunds);
    		mav.addObject(cashFundsStatus, adminNoCashFundsVal);    		    		
    	} else {
    		mav = new ModelAndView(adminRegistryPendingCashFunds);    		    		   		
    	}
    	mav.addObject(totalPendingFundsCount, totPendingFundsCount);
		mav.addObject(totalClearedNotRequestedCount, totClearedNotRequestedCount);
		mav.addObject(totalTransferRequestedCount, totTransferRequestedCount);
		mav.addObject(totalTransferCompletedCount, totTransferCompletedCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    public String registrantCashFundImageTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId, long cashFundSavingId) {
    	String registrantCashFundImage = null;
    	RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.cashFundsMyAccountDataTakeFromDB(registrantUserId, cashFundSavingId);
    	if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
    		byte[] regUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
    		String custmCashFundImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
    		registrantCashFundImage = "data:image/jpg;base64," + custmCashFundImg;
    	} else {
    		registrantCashFundImage = cashFundSmallImageUrl + "10_custom_fund_img.png";
    	}
    	return registrantCashFundImage;
    }

    public String guestUserFullNameForAdminTakeFromDB(HttpServletRequest req, HttpSession sn, long guestPaymentSavingId) {
    	String guestFullName = null;
    	List<GuestUserPaymentInfoSaving> guestUserInfoSavingList = guestUserPaymentInfoSavingDAO.guestUserFirstNameCheckingInDB(guestPaymentSavingId);
    	if (!guestUserInfoSavingList.isEmpty()) {
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestPaymentSavingId);
    		guestFullName = guestUserInfoSavingModel.getGuestUserFullName();
    	}
    	return guestFullName;
    }
    
    public String registryUserFullNameForAdminTakeFromDB(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String registryFullName = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	registryFullName = regInfoSavingModel.getRegFirstName() + " " + regInfoSavingModel.getRegLastName();
    	return registryFullName;
    }

    @Override
    @Transactional
    public ModelAndView adminPendingCashFundsRequestSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long registryCashFundSavingId = Long.parseLong(req.getParameter(registryCashFundId));
    	Timestamp currentDate = currentDate();
    	if((guestCashFundStstus).equals(req.getParameter(typeOfCashFundName))) {    		
    		GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentModel = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestCashFundColumnUpdateInDataBase(registryCashFundSavingId);
    		guestCashFundPaymentModel.setCashFundStatus(transferNowStatus);
    		guestCashFundPaymentModel.setRefferanceDate(currentDate);
    		guestRegistryCashFundsPaymentInfoSavingDAO.merge(guestCashFundPaymentModel);
    		String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestCashFundPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminCashFundsClearedEmailSendToRegistrant(req, sn, guestFullName, guestCashFundPaymentModel.getContributedCashFundPrice(), guestCashFundPaymentModel.getRegistrantUserId());
    		
    	} else {
    		RegistryCashFundsPaymentInfoSaving regCashFundPaymentModel = registryCashFundsPaymentInfoSavingDAO.adminRegistryCashFundColumnUpdateInDataBase(registryCashFundSavingId);
    		regCashFundPaymentModel.setCashFundStatus(transferNowStatus);
    		regCashFundPaymentModel.setRefferanceDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.merge(regCashFundPaymentModel);
    	}
    	mav = new ModelAndView(redirectStatus + adminCashFunds);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

	public String adminCashFundsClearedEmailSendToRegistrant(HttpServletRequest req, HttpSession sn, String guestFullName, String cashFundPrice, long registrantUserId) {
	  	String shopCartPaymentReff = null;
	  	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	String regUserEmail = regInfoSavingModel.getRegUserName();
    	String fCapName = regInfoSavingModel.getRegFirstName();
	  	String[] emailList = {regUserEmail};
        String subject = "Funds Are Available For Transfer";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "                
                + "<p style='margin-top: 35px; font: 1.05em/1.5em sans-serif;'>Your gift of $" + cashFundPrice + "</b> from " + guestFullName + " has cleared and is now available for transfer into your account. You can login to your registry at any time to initiate the transfer under the 'Cash Funds' tab under 'My Account'.</p>"                
                + "<p style='margin-top: 35px; margin-bottom: 20px; font: 1.05em/1.25em sans-serif;'>Login to your account here: <a href='https://www.nookandcove.com/registryLogin'>My Registry</a></p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin cash funds cleared email send to registrant failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

    @Override
    @Transactional
    public ModelAndView adminCashFundClearedNotRequestedRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestCashFundsPaymentInfoList = null;
    	double totalCashFundsPrice = 0;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestClearedNotRequestedCashFundsInfoCheckInDB();
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		for (GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentSavingModel : guestCashFundPaymentRowList) {
    	    	long guestCashFundId = guestCashFundPaymentSavingModel.getGuestRegistryCashFundsPaymentInfoSavingId();
    	    	String cashFundPrice = guestCashFundPaymentSavingModel.getContributedCashFundPrice();
    	    	double guestCashFundsPrice = Double.parseDouble(cashFundPrice);
    	    	totalCashFundsPrice = totalCashFundsPrice + guestCashFundsPrice;
    	    	String registrantCashFundName = guestCashFundPaymentSavingModel.getCashFundName();    	    	
    	    	Timestamp guscrDate = guestCashFundPaymentSavingModel.getCreatedDate();
    	    	Date date1 = new Date();
    	    	date1.setTime(guscrDate.getTime());
    	    	String createdDate1 = new SimpleDateFormat("MM/dd/yyyy").format(date1);
    	    	long admnGuestRegistrantUserId = guestCashFundPaymentSavingModel.getRegistrantUserId();
    	    	long guestPaymentSavingId = guestCashFundPaymentSavingModel.getGuestUserPaymentInfoSavingId();
    	    	String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestPaymentSavingId);
    	    	long cashFundSavingId = guestCashFundPaymentSavingModel.getRegistryCashFundsInfoSavingId();
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnGuestRegistrantUserId);
    	    	String registrantGuestCashFundImage = registrantCashFundImageTakeFromDB(req, sn, admnGuestRegistrantUserId, cashFundSavingId);
    	    	String guestCashFundsSpaceList = registrantGuestCashFundImage + ",_," + registrantCashFundName + ",_," + cashFundPrice + ",_," + guestFullName + ",_," + createdDate1 + ",_," + guestCashFundId + ",_," + registrantFullName;
    	    	guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList + "__" + guestCashFundsSpaceList;
        	}
    		guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList.replaceFirst("null__", "");
    	}    	
    	sn.setAttribute("adminGuestClearedNotRequestedCashFundsPaymentInfo", guestCashFundsPaymentInfoList);

    	int totPendingFundsCount = adminRegistryFundsPendingCount(req, sn);
    	int totClearedNotRequestedCount = adminRegistryClearedNotRequestedCount(req, sn);
    	int totTransferRequestedCount = adminRegistryTransferRequestedCount(req, sn);
    	int totTransferCompletedCount = adminRegistryTransferCompletedCount(req, sn);
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		String totalCashFundsPriceSt = String.format("%.2f", totalCashFundsPrice);
    		mav = new ModelAndView(adminRegistryClearedNotRequestedCashFunds);
    		mav.addObject(cashFundsStatus, adminNoCashFundsVal);
    		mav.addObject(totalCashFundPrice, totalCashFundsPriceSt);    		
    	} else {
    		mav = new ModelAndView(adminRegistryClearedNotRequestedCashFunds);    		    		   		
    	}
    	mav.addObject(totalPendingFundsCount, totPendingFundsCount);
		mav.addObject(totalClearedNotRequestedCount, totClearedNotRequestedCount);
		mav.addObject(totalTransferRequestedCount, totTransferRequestedCount);
		mav.addObject(totalTransferCompletedCount, totTransferCompletedCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryTransferRequestedCashFunds(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestCashFundsPaymentInfoList = null;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestTransferRequestedCashFundsInfoCheckInDB();
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		for (GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentSavingModel : guestCashFundPaymentRowList) {
    	    	long guestCashFundId = guestCashFundPaymentSavingModel.getGuestRegistryCashFundsPaymentInfoSavingId();
    	    	String cashFundPrice = guestCashFundPaymentSavingModel.getContributedCashFundPrice();
    	    	String registrantCashFundName = guestCashFundPaymentSavingModel.getCashFundName();    	    	
    	    	Timestamp guscrDate = guestCashFundPaymentSavingModel.getCreatedDate();
    	    	Date date1 = new Date();
    	    	date1.setTime(guscrDate.getTime());
    	    	String createdDate1 = new SimpleDateFormat("MM/dd/yyyy").format(date1);
    	    	long admnGuestRegistrantUserId = guestCashFundPaymentSavingModel.getRegistrantUserId();
    	    	long guestPaymentSavingId = guestCashFundPaymentSavingModel.getGuestUserPaymentInfoSavingId();
    	    	String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestPaymentSavingId);
    	    	long cashFundSavingId = guestCashFundPaymentSavingModel.getRegistryCashFundsInfoSavingId();
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnGuestRegistrantUserId);
    	    	String registrantGuestCashFundImage = registrantCashFundImageTakeFromDB(req, sn, admnGuestRegistrantUserId, cashFundSavingId);
    	    	String guestCashFundsSpaceList = registrantGuestCashFundImage + ",_," + registrantCashFundName + ",_," + cashFundPrice + ",_," + guestFullName + ",_," + createdDate1 + ",_," + guestCashFundId + ",_," + registrantFullName;
    	    	guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList + "__" + guestCashFundsSpaceList;
        	}
    		guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList.replaceFirst("null__", "");
    	}    	
    	sn.setAttribute("adminGuestTransferRequestedCashFunds", guestCashFundsPaymentInfoList);

    	int totPendingFundsCount = adminRegistryFundsPendingCount(req, sn);
    	int totClearedNotRequestedCount = adminRegistryClearedNotRequestedCount(req, sn);
    	int totTransferRequestedCount = adminRegistryTransferRequestedCount(req, sn);
    	int totTransferCompletedCount = adminRegistryTransferCompletedCount(req, sn);
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		mav = new ModelAndView(adminRegistryTransferRequestedCashFunds);
    		mav.addObject(cashFundsStatus, adminNoCashFundsVal);    		
    	} else {
    		mav = new ModelAndView(adminRegistryTransferRequestedCashFunds);    		    		   		
    	}
    	mav.addObject(totalPendingFundsCount, totPendingFundsCount);
		mav.addObject(totalClearedNotRequestedCount, totClearedNotRequestedCount);
		mav.addObject(totalTransferRequestedCount, totTransferRequestedCount);
		mav.addObject(totalTransferCompletedCount, totTransferCompletedCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminTransferCompleteCashFundsRedirect(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long registryCashFundSavingId = Long.parseLong(req.getParameter(registryCashFundId));
    	if((guestCashFundStstus).equals(req.getParameter(typeOfCashFundName))) {    		
    		GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentModel = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestCashFundColumnUpdateInDataBase(registryCashFundSavingId);
    		long registrantUserId = guestCashFundPaymentModel.getRegistrantUserId();
    		mav = regiCashFundsBankAccountsRedirection(req, sn, registrantUserId, registryCashFundSavingId, req.getParameter(typeOfCashFundName));
    	} else {
    		RegistryCashFundsPaymentInfoSaving regCashFundPaymentModel = registryCashFundsPaymentInfoSavingDAO.adminRegistryCashFundColumnUpdateInDataBase(registryCashFundSavingId);
    		long registrantUserId = regCashFundPaymentModel.getRegistrantUserId();
    		mav = regiCashFundsBankAccountsRedirection(req, sn, registrantUserId, registryCashFundSavingId, req.getParameter(typeOfCashFundName));
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView regiCashFundsBankAccountsRedirection(HttpServletRequest req, HttpSession sn, long registrantUserId, long registryCashFundSavingId, String typeOfCashFund) {
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
    	List<RegistrantCashFundBankAccountInfoSaving> regCFBankAccountsList = registrantCashFundBankAccountInfoSavingDAO.selectedCashFundBackAccountRowIdVerification(registrantUserId);
    	if (!regCFBankAccountsList.isEmpty()) {
    		RegistrantCashFundBankAccountInfoSaving regCFBankAccountsSavingModel = registrantCashFundBankAccountInfoSavingDAO.updatedCashFundBackAccountRowInDataBasa(registrantUserId);
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
    	mav = new ModelAndView(adminCashFundsBankAccountsRed);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(registryCashFundId, registryCashFundSavingId);
    	mav.addObject(typeOfCashFundName, typeOfCashFund);
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
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView cashFundTransferCompletedStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long registryCashFundSavingId = Long.parseLong(req.getParameter(registryCashFundId));
    	Timestamp currentDate = currentDate();
    	if((guestCashFundStstus).equals(req.getParameter(typeOfCashFundName))) {    		
    		GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentModel = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestCashFundColumnUpdateInDataBase(registryCashFundSavingId);
    		guestCashFundPaymentModel.setCashFundStatus(transferCompleteStatus);
    		guestCashFundPaymentModel.setTransferCompletedDate(currentDate);
    		guestCashFundPaymentModel.setRefferanceDate(currentDate);
    		guestRegistryCashFundsPaymentInfoSavingDAO.merge(guestCashFundPaymentModel);
    		String guestFullName = guestUserFullNameTakeFromDB(req, sn, guestCashFundPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminCashFundsTransferCompleteEmailSendToRegistrant(req, sn, guestFullName, guestCashFundPaymentModel.getContributedCashFundPrice(), guestCashFundPaymentModel.getRegistrantUserId());
    	} else {
    		RegistryCashFundsPaymentInfoSaving regCashFundPaymentModel = registryCashFundsPaymentInfoSavingDAO.adminRegistryCashFundColumnUpdateInDataBase(registryCashFundSavingId);
    		regCashFundPaymentModel.setCashFundStatus(transferCompleteStatus);
    		regCashFundPaymentModel.setTransferCompletedDate(currentDate);
    		regCashFundPaymentModel.setRefferanceDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.merge(regCashFundPaymentModel);
    	}
    	mav = new ModelAndView(redirectStatus + "adminCashFundTransferComplete");
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

	public String adminCashFundsTransferCompleteEmailSendToRegistrant(HttpServletRequest req, HttpSession sn, String guestFullName, String cashFundPrice, long registrantUserId) {
	  	String shopCartPaymentReff = null;
	  	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	String regUserEmail = regInfoSavingModel.getRegUserName();
    	String fCapName = regInfoSavingModel.getRegFirstName();
	  	String[] emailList = {regUserEmail};
        String subject = "Your Transfer Is Complete";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "                
                + "<p style='margin-top: 35px; font: 1.05em/1.5em sans-serif;'>We have received your request to transfer $" + cashFundPrice + "</b> from " + guestFullName + " into your account. We have completed the transaction of funds on our end.</p>"                
                + "<p style='margin-top: 35px; margin-bottom: 20px; font: 1.05em/1.25em sans-serif;'>Please allow 3-5 business days for transfers to process and to receive your funds.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin cash funds transfer complete email send to registrant failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

    @Override
    @Transactional
    public ModelAndView adminRegistryTransferCompletedCashFunds(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String guestCashFundsPaymentInfoList = null;
    	double totalCashFundsPrice = 0;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestTransferCompletedCashFundsInfoCheckInDB();
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		for (GuestRegistryCashFundsPaymentInfoSaving guestCashFundPaymentSavingModel : guestCashFundPaymentRowList) {
    	    	long guestCashFundId = guestCashFundPaymentSavingModel.getGuestRegistryCashFundsPaymentInfoSavingId();
    	    	String cashFundPrice = guestCashFundPaymentSavingModel.getContributedCashFundPrice();
    	    	double guestCashFundsPrice = Double.parseDouble(cashFundPrice);
    	    	totalCashFundsPrice = totalCashFundsPrice + guestCashFundsPrice;
    	    	String registrantCashFundName = guestCashFundPaymentSavingModel.getCashFundName();    	    	
    	    	Timestamp guscrDate = guestCashFundPaymentSavingModel.getTransferCompletedDate();
    	    	Date date1 = new Date();
    	    	date1.setTime(guscrDate.getTime());
    	    	String createdDate1 = new SimpleDateFormat("MM/dd/yyyy").format(date1);
    	    	long admnGuestRegistrantUserId = guestCashFundPaymentSavingModel.getRegistrantUserId();
    	    	long guestPaymentSavingId = guestCashFundPaymentSavingModel.getGuestUserPaymentInfoSavingId();
    	    	String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestPaymentSavingId);
    	    	long cashFundSavingId = guestCashFundPaymentSavingModel.getRegistryCashFundsInfoSavingId();
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnGuestRegistrantUserId);
    	    	String registrantGuestCashFundImage = registrantCashFundImageTakeFromDB(req, sn, admnGuestRegistrantUserId, cashFundSavingId);
    	    	String guestCashFundsSpaceList = registrantGuestCashFundImage + ",_," + registrantCashFundName + ",_," + cashFundPrice + ",_," + guestFullName + ",_," + createdDate1 + ",_," + guestCashFundId + ",_," + registrantFullName;
    	    	guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList + "__" + guestCashFundsSpaceList;
        	}
    		guestCashFundsPaymentInfoList = guestCashFundsPaymentInfoList.replaceFirst("null__", "");
    	}    	
    	sn.setAttribute("adminGuestTransferCompletedCashFund", guestCashFundsPaymentInfoList);

    	int totPendingFundsCount = adminRegistryFundsPendingCount(req, sn);
    	int totClearedNotRequestedCount = adminRegistryClearedNotRequestedCount(req, sn);
    	int totTransferRequestedCount = adminRegistryTransferRequestedCount(req, sn);
    	int totTransferCompletedCount = adminRegistryTransferCompletedCount(req, sn);
    	if (!guestCashFundPaymentRowList.isEmpty()) {
    		String totalCashFundsPriceSt = String.format("%.2f", totalCashFundsPrice);
    		mav = new ModelAndView(adminRegistryTransferCompletedCashFunds);
    		mav.addObject(cashFundsStatus, adminNoCashFundsVal);
    		mav.addObject(totalCashFundPrice, totalCashFundsPriceSt);
    	} else {
    		mav = new ModelAndView(adminRegistryTransferCompletedCashFunds);    		    		   		
    	}
    	mav.addObject(totalPendingFundsCount, totPendingFundsCount);
		mav.addObject(totalClearedNotRequestedCount, totClearedNotRequestedCount);
		mav.addObject(totalTransferRequestedCount, totTransferRequestedCount);
		mav.addObject(totalTransferCompletedCount, totTransferCompletedCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
    
    public int adminRegistryFundsPendingCount(HttpServletRequest req, HttpSession sn) {
    	int totalPendingFundsCount = 0;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestPendingCashFundsInfoCheckInDB();
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.adminRegistrantPendingCashFundsInfoCheckInDB();
    	int guestPFCount = guestCashFundPaymentRowList.size();
    	int regiPFCount = regCashFundAddCartRowList.size();
    	totalPendingFundsCount = guestPFCount + regiPFCount;
    	return totalPendingFundsCount;
    }

    public int adminRegistryClearedNotRequestedCount(HttpServletRequest req, HttpSession sn) {
    	int totalClearedNotRequestedCount = 0;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestClearedNotRequestedCashFundsInfoCheckInDB();
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.adminRegistrantClearedNotRequestedCashFundsInfoCheckInDB();
    	int guestCNRCount = guestCashFundPaymentRowList.size();
    	int regiCNRCount = regCashFundAddCartRowList.size();
    	totalClearedNotRequestedCount = guestCNRCount + regiCNRCount;
    	return totalClearedNotRequestedCount;
    }

    public int adminRegistryTransferRequestedCount(HttpServletRequest req, HttpSession sn) {
    	int totalTransferRequestedCount = 0;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestTransferRequestedCashFundsInfoCheckInDB();
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.adminRegistrantTransferRequestedCashFundsInfoCheckInDB();
    	int guestTRCount = guestCashFundPaymentRowList.size();
    	int regiTRCount = regCashFundAddCartRowList.size();
    	totalTransferRequestedCount = guestTRCount + regiTRCount;
    	return totalTransferRequestedCount;
    }

    public int adminRegistryTransferCompletedCount(HttpServletRequest req, HttpSession sn) {
    	int totalTransferCompletedCount = 0;
    	List<GuestRegistryCashFundsPaymentInfoSaving> guestCashFundPaymentRowList = guestRegistryCashFundsPaymentInfoSavingDAO.adminGuestTransferCompletedCashFundsInfoCheckInDB();
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.adminRegistrantTransferCompletedCashFundsInfoCheckInDB();
    	int guestTCCount = guestCashFundPaymentRowList.size();
    	int regiTCCount = regCashFundAddCartRowList.size();
    	totalTransferCompletedCount = guestTCCount + regiTCCount;
    	return totalTransferCompletedCount;
    }
        
    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedNoActionData(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	int guestCount = 0;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();    	
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indNoActionStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indNoActionStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indNoActionStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indNoActionStatusRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indNoActionStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indNoActionStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indNoActionStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indNoActionStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
       	int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
		int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
		int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
		int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
		int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
		int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
		int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);    		
    		mav = new ModelAndView(adminRegistryGiftReceivedNoAction);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedNoActionSavingList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);    		
    	} else {
    		mav = new ModelAndView(adminRegistryGiftReceivedNoAction);    		    		   		
    	} 
    	mav.addObject(giftRecNoActionCount, totalProductCount);
		mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
		mav.addObject(giftRecOrderedCount, grOrderedCount);
		mav.addObject(giftRecTrackingCount, grTrackingCount);
		mav.addObject(giftRecDeliveredCount, grDeliveredCount);
		mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
		mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
		mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
    
    public double guestAdminCBIndividualGiftReceivedDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList, int count) {
    	double cbIndividualProductPrice = 0;    	    	
    	if (!guestCBIndividualSavingList.isEmpty()) {
    		for (GuestConceptBoardsIndividualPaymentSaving guestCBIndividualSavingLoop : guestCBIndividualSavingList) {
    			RegistrantConceptBoardsIndividualProductsInfoSaving guestCBIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    	    	long admnGuestRegistrantUserId = guestCBIndividualSavingLoop.getRegistrantUserId();
    	    	int guestGivenQuantity = guestCBIndividualSavingLoop.getGiftedQuantity();
    	    	RegistrantConceptBoardsIndividualProductsInfoSaving guestCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(admnGuestRegistrantUserId, guestCBIndividualSavingLoop.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
        		double regProductPriceStDb = Double.parseDouble(guestCBIndividualProductSavingModel.getProductPrice());
        		double totalGuestCBIndividualPrice = regProductPriceStDb * guestGivenQuantity;
    	    	String guestCBIndividualAmount = "$" + String.format("%.2f", totalGuestCBIndividualPrice);    	    	
    	    	long guestPaymentSavingId = guestCBIndividualSavingLoop.getGuestUserPaymentInfoSavingId();
    	    	String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestPaymentSavingId);
    	    	String regiFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnGuestRegistrantUserId);    	    	
    	    	cbIndividualProductPrice = cbIndividualProductPrice + totalGuestCBIndividualPrice;
    	    	guestCBIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(guestCBIndividualSavingLoop.getGuestConceptBoardsIndividualPaymentSavingId());
    	    	guestCBIndividualProductInfoSavingModel.setProductPrice(guestCBIndividualAmount);
    	    	guestCBIndividualProductInfoSavingModel.setProductName(guestCBIndividualProductSavingModel.getProductName());
    	    	guestCBIndividualProductInfoSavingModel.setIndividualStatus(guestCBIndividualSavingLoop.getIndividualStatus());
    	    	guestCBIndividualProductInfoSavingModel.setProductHeading(guestFullName);
    	    	guestCBIndividualProductInfoSavingModel.setProductDescription(regiFullName);
    	    	guestCBIndividualProductInfoSavingModel.setCreatedDate(guestCBIndividualSavingLoop.getRefferanceDate());
    	    	guestCBIndividualProductInfoSavingModel.setStatus(gusetIndConBoardsReff);
    	    	guestCBIndividualProductInfoSavingModel.setStoreName(consBoardsRefName);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + guestCBIndividualSavingLoop.getTrackingLink() + "> Track</a>";
    	    	guestCBIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	guestCBIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(guestCBIndividualProductInfoSavingModel);
        	}
    	}    	
    	return cbIndividualProductPrice;
    }

    public double registryAdminCBIndividualGiftReceivedDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList, int count) {
    	double cbIndividualProductPrice = 0;
    	if (!regCBIndividualSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualSavingLoop : regCBIndividualSavingList) { 
    			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    			long admnRegistrantUserId = regCBIndividualSavingLoop.getRegistrantUserId();
    	    	int guestGivenQuantity = regCBIndividualSavingLoop.getGiftedQuantity();
    	    	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(admnRegistrantUserId, regCBIndividualSavingLoop.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
        		double regProductPriceStDb = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());
        		double totalGuestCBIndividualPrice = regProductPriceStDb * guestGivenQuantity;   	    	
    	    	String regCBIndividualAmount = "$" + String.format("%.2f", totalGuestCBIndividualPrice);
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnRegistrantUserId);
    	    	cbIndividualProductPrice = cbIndividualProductPrice + totalGuestCBIndividualPrice;    	    	
    	    	regCBIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(regCBIndividualSavingLoop.getRegistrantConceptBoardsIndividualPaymentSavingId());
    	    	regCBIndividualProductInfoSavingModel.setProductPrice(regCBIndividualAmount);
    	    	regCBIndividualProductInfoSavingModel.setProductName(regCBIndividualProductSavingModel.getProductName());
    	    	regCBIndividualProductInfoSavingModel.setIndividualStatus(regCBIndividualSavingLoop.getIndividualStatus());
    	    	regCBIndividualProductInfoSavingModel.setProductHeading(registrantFullName);
    	    	regCBIndividualProductInfoSavingModel.setProductDescription(registrantFullName);
    	    	regCBIndividualProductInfoSavingModel.setCreatedDate(regCBIndividualSavingLoop.getRefferanceDate());
    	    	regCBIndividualProductInfoSavingModel.setStatus(regIndConBoardsReff);
    	    	regCBIndividualProductInfoSavingModel.setStoreName(consBoardsRefName);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regCBIndividualSavingLoop.getTrackingLink() + "> Track</a>";
    	    	regCBIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	regCBIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(regCBIndividualProductInfoSavingModel);
        	}
    	}
    	return cbIndividualProductPrice;
    }

    public double guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList, int count) {
    	double cbCBContributedProductPrice = 0;
    	if (!regCBContributedSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingLoop : regCBContributedSavingList) { 
    			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    			long admnRegistrantUserId = regCBContributedSavingLoop.getRegistrantUserId();
    			double contributedPrice = Double.parseDouble(regCBContributedSavingLoop.getContributedPrice());
    			double remainingTotalPrice = Double.parseDouble(regCBContributedSavingLoop.getRemainingTotalPrice());
    			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
    			cbCBContributedProductPrice = cbCBContributedProductPrice + totalGiftedPrice;
    			String totalCBContributedAmount = "$" + String.format("%.2f", totalGiftedPrice);
    			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedProductSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB(admnRegistrantUserId, regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());        		
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnRegistrantUserId);
    	    	regCBIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    	    	regCBIndividualProductInfoSavingModel.setProductPrice(totalCBContributedAmount);
    	    	regCBIndividualProductInfoSavingModel.setProductName(regCBContributedProductSavingModel.getProductName());
    	    	regCBIndividualProductInfoSavingModel.setIndividualStatus(regCBContributedProductSavingModel.getContributedStatus());
    	    	regCBIndividualProductInfoSavingModel.setProductHeading(groupGiftReffName);
    	    	regCBIndividualProductInfoSavingModel.setProductDescription(registrantFullName);
    	    	regCBIndividualProductInfoSavingModel.setCreatedDate(regCBContributedSavingLoop.getUpdatedDate());
    	    	regCBIndividualProductInfoSavingModel.setStatus(regContrConBoardsReff);
    	    	regCBIndividualProductInfoSavingModel.setStoreName(consBoardsRefName);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regCBContributedProductSavingModel.getTrackingLink() + "> Track</a>";
    	    	regCBIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	regCBIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(regCBIndividualProductInfoSavingModel);
        	}
    	}
    	return cbCBContributedProductPrice;
    }
    
    public double guestAdminFTIndividualGiftReceivedDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList, int count) {
    	double ftIndividualProductPrice = 0;    	    	
    	if (!guestFTIndividualSavingList.isEmpty()) {
    		for (GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualSavingLoop : guestFTIndividualSavingList) {
    			RegistrantConceptBoardsIndividualProductsInfoSaving guestFTIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    	    	long admnGuestRegistrantUserId = guestFTIndividualSavingLoop.getRegistrantUserId();
    	    	int guestGivenQuantity = guestFTIndividualSavingLoop.getGiftedQuantity();
    	    	RegistrantFinishingTouchesIndividualProductsInfoSaving guestFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(admnGuestRegistrantUserId, guestFTIndividualSavingLoop.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
        		double regProductPriceStDb = Double.parseDouble(guestFTIndividualProductSavingModel.getProductPrice());
        		double totalGuestFTIndividualPrice = regProductPriceStDb * guestGivenQuantity;
    	    	String guestFTIndividualAmount = "$" + String.format("%.2f", totalGuestFTIndividualPrice);    	    	
    	    	long guestPaymentSavingId = guestFTIndividualSavingLoop.getGuestUserPaymentInfoSavingId();
    	    	String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestPaymentSavingId);
    	    	String regiFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnGuestRegistrantUserId);    	    	
    	    	ftIndividualProductPrice = ftIndividualProductPrice + totalGuestFTIndividualPrice;
    	    	guestFTIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(guestFTIndividualSavingLoop.getGuestFinishingTouchesIndividualPaymentSavingId());
    	    	guestFTIndividualProductInfoSavingModel.setProductPrice(guestFTIndividualAmount);
    	    	guestFTIndividualProductInfoSavingModel.setProductName(guestFTIndividualProductSavingModel.getProductName());
    	    	guestFTIndividualProductInfoSavingModel.setIndividualStatus(guestFTIndividualSavingLoop.getIndividualStatus());
    	    	guestFTIndividualProductInfoSavingModel.setProductHeading(guestFullName);
    	    	guestFTIndividualProductInfoSavingModel.setProductDescription(regiFullName);
    	    	guestFTIndividualProductInfoSavingModel.setCreatedDate(guestFTIndividualSavingLoop.getRefferanceDate());
    	    	guestFTIndividualProductInfoSavingModel.setStatus(gusetIndFinTouchesReff);
    	    	guestFTIndividualProductInfoSavingModel.setStoreName(finiTouchesRefName);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + guestFTIndividualSavingLoop.getTrackingLink() + "> Track</a>";
    	    	guestFTIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	guestFTIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(guestFTIndividualProductInfoSavingModel);
        	}
    	}    	
    	return ftIndividualProductPrice;
    }

    public double registryAdminFTIndividualGiftReceivedDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList, int count) {
    	double ftIndividualProductPrice = 0;
    	if (!regFTIndividualSavingList.isEmpty()) {
    		for (RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualSavingLoop : regFTIndividualSavingList) { 
    			RegistrantConceptBoardsIndividualProductsInfoSaving regFTIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    			long admnRegistrantUserId = regFTIndividualSavingLoop.getRegistrantUserId();
    	    	int guestGivenQuantity = regFTIndividualSavingLoop.getGiftedQuantity();
    	    	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(admnRegistrantUserId, regFTIndividualSavingLoop.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
        		double regProductPriceStDb = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());
        		double totalGuestFTIndividualPrice = regProductPriceStDb * guestGivenQuantity;   	    	
    	    	String regFTIndividualAmount = "$" + String.format("%.2f", totalGuestFTIndividualPrice);
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnRegistrantUserId);
    	    	ftIndividualProductPrice = ftIndividualProductPrice + totalGuestFTIndividualPrice;    	    	
    	    	regFTIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(regFTIndividualSavingLoop.getRegistrantFinishingTouchesIndividualPaymentSavingId());
    	    	regFTIndividualProductInfoSavingModel.setProductPrice(regFTIndividualAmount);
    	    	regFTIndividualProductInfoSavingModel.setProductName(regFTIndividualProductSavingModel.getProductName());
    	    	regFTIndividualProductInfoSavingModel.setIndividualStatus(regFTIndividualSavingLoop.getIndividualStatus());
    	    	regFTIndividualProductInfoSavingModel.setProductHeading(registrantFullName);
    	    	regFTIndividualProductInfoSavingModel.setProductDescription(registrantFullName);
    	    	regFTIndividualProductInfoSavingModel.setCreatedDate(regFTIndividualSavingLoop.getRefferanceDate());
    	    	regFTIndividualProductInfoSavingModel.setStatus(regIndFinTouchesReff);
    	    	regFTIndividualProductInfoSavingModel.setStoreName(finiTouchesRefName);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regFTIndividualSavingLoop.getTrackingLink() + "> Track</a>";
    	    	regFTIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	regFTIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(regFTIndividualProductInfoSavingModel);
        	}
    	}
    	return ftIndividualProductPrice;
    }

    public double guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList, int count) {
    	double ftFTContributedProductPrice = 0;
    	if (!regFTContributedSavingList.isEmpty()) {
    		for (RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingLoop : regFTContributedSavingList) { 
    			RegistrantConceptBoardsIndividualProductsInfoSaving regFTIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    			long admnRegistrantUserId = regFTContributedSavingLoop.getRegistrantUserId();
    			double contributedPrice = Double.parseDouble(regFTContributedSavingLoop.getContributedPrice());
    			double remainingTotalPrice = Double.parseDouble(regFTContributedSavingLoop.getRemainingTotalPrice());
    			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
    			ftFTContributedProductPrice = ftFTContributedProductPrice + totalGiftedPrice;
    			String totalFTContributedAmount = "$" + String.format("%.2f", totalGiftedPrice);
    			RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedProductSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB(admnRegistrantUserId, regFTContributedSavingLoop.getRegistrantFinishingTouchesContributedProductsInfoSavingId());        		
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnRegistrantUserId);
    	    	regFTIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(regFTContributedSavingLoop.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    	    	regFTIndividualProductInfoSavingModel.setProductPrice(totalFTContributedAmount);
    	    	regFTIndividualProductInfoSavingModel.setProductName(regFTContributedProductSavingModel.getProductName());
    	    	regFTIndividualProductInfoSavingModel.setIndividualStatus(regFTContributedProductSavingModel.getContributedStatus());
    	    	regFTIndividualProductInfoSavingModel.setProductHeading(groupGiftReffName);
    	    	regFTIndividualProductInfoSavingModel.setProductDescription(registrantFullName);
    	    	regFTIndividualProductInfoSavingModel.setCreatedDate(regFTContributedSavingLoop.getUpdatedDate());
    	    	regFTIndividualProductInfoSavingModel.setStatus(regContrFinTouchesReff);
    	    	regFTIndividualProductInfoSavingModel.setStoreName(finiTouchesRefName);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regFTContributedProductSavingModel.getTrackingLink() + "> Track</a>";
    	    	regFTIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	regFTIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(regFTIndividualProductInfoSavingModel);
        	}
    	}
    	return ftFTContributedProductPrice;
    }
    
    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedConvertedToCreditData(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	int guestCount = 0;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();    	
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);    	
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(individualCTSCRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, individualCTSCRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, individualCTSCRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());
    	double regCBContGiftRecivedPrice = guestAndRegCBContributedGRConToCreditDataDisplay(req, sn, cbIndividualPaymentSavingList, individualCTSCRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(individualCTSCRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, individualCTSCRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, individualCTSCRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, individualCTSCRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
    	int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
    	int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
    	int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
    	int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
    	int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
    	int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);
    		mav = new ModelAndView(adminRegistryGiftReceivedConvertedToCredit);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedStoreCreditSavingList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);
    	} else {
    		mav = new ModelAndView(adminRegistryGiftReceivedConvertedToCredit);    		    		   		
    	} 
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
    	mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
    	mav.addObject(giftRecOrderedCount, grOrderedCount);
    	mav.addObject(giftRecTrackingCount, grTrackingCount);
    	mav.addObject(giftRecDeliveredCount, grDeliveredCount);
    	mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
    	mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
    	mav.addObject(giftRecCTStoreCreditCount, totalProductCount);
    	return mav;
    }

    public double guestAndRegCBContributedGRConToCreditDataDisplay(HttpServletRequest req, HttpSession sn, List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList, String individualStatusRef, List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList, int count) {
    	double cbContributedProductPrice = 0;
    	if (!regCBContributedSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingLoop : regCBContributedSavingList) { 
    			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductInfoSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
    			long admnRegistrantUserId = regCBContributedSavingLoop.getRegistrantUserId();    			
    			double totalGiftedPrice = guestAndRegCBContributedGRConToCreditTotalPrice(req, sn, admnRegistrantUserId, regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			cbContributedProductPrice = cbContributedProductPrice + totalGiftedPrice;
    			String totalCBContributedAmount = "$" + String.format("%.2f", totalGiftedPrice);
    			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedProductSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB(admnRegistrantUserId, regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());        		
    	    	String registrantFullName = registryUserFullNameForAdminTakeFromDB(req, sn, admnRegistrantUserId);
    	    	regCBIndividualProductInfoSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(regCBContributedSavingLoop.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    	    	regCBIndividualProductInfoSavingModel.setProductPrice(totalCBContributedAmount);
    	    	regCBIndividualProductInfoSavingModel.setProductName(regCBContributedProductSavingModel.getProductName());
    	    	regCBIndividualProductInfoSavingModel.setIndividualStatus(regCBContributedProductSavingModel.getContributedStatus());
    	    	regCBIndividualProductInfoSavingModel.setProductHeading(groupGiftReffName);
    	    	regCBIndividualProductInfoSavingModel.setProductDescription(registrantFullName);
    	    	regCBIndividualProductInfoSavingModel.setCreatedDate(regCBContributedSavingLoop.getUpdatedDate());
    	    	regCBIndividualProductInfoSavingModel.setStatus(regContrConBoardsReff);
    	    	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + regCBContributedProductSavingModel.getTrackingLink() + "> Track</a>";
    	    	regCBIndividualProductInfoSavingModel.setTrackingLink(trackLinkUrl);
    	    	count = count + 1;
    	    	regCBIndividualProductInfoSavingModel.setQuantity(count);
    	    	cbIndividualPaymentSavingList.add(regCBIndividualProductInfoSavingModel);
        	}
    	}
    	return cbContributedProductPrice;
    }

    public double guestAndRegCBContributedGRConToCreditTotalPrice(HttpServletRequest req, HttpSession sn, long admnRegistrantUserId, long regCBContProductsInfoSavingId) {
    	double cbContributedProdPrice = 0;    	
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBContributedGRConToCreditDataList(admnRegistrantUserId, regCBContProductsInfoSavingId, individualCTSCRef);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			double regContributedPrice = Double.parseDouble(regCBContributedPaymentModel.getContributedPrice());
    			cbContributedProdPrice = cbContributedProdPrice + regContributedPrice;
    		}
    	}    	
    	List<GuestConceptBoardsContributedPaymentSaving> gusCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBContributedGRConToCreditDataList(admnRegistrantUserId, regCBContProductsInfoSavingId, individualCTSCRef);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : gusCBContributedPaymentList) {
    			double gusContributedPrice = Double.parseDouble(guestCBContributedSavingModel.getContributedPrice());
    			cbContributedProdPrice = cbContributedProdPrice + gusContributedPrice;
    		}
    	}    	
    	return cbContributedProdPrice;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedShipNowData(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();    	
    	int guestCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indOrderProcessingStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderProcessingStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderProcessingStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderProcessingStatusRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indOrderProcessingStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderProcessingStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderProcessingStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderProcessingStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
		int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
		int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
		int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
		int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
		int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
		int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);    		
    		mav = new ModelAndView(adminRegistryGiftReceivedShipNow);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedShopNowDataList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);    		
    	} else {
    		mav = new ModelAndView(adminRegistryGiftReceivedShipNow);    		    		   		
    	}
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
		mav.addObject(giftRecOrderProcessingCount, totalProductCount);
		mav.addObject(giftRecOrderedCount, grOrderedCount);
		mav.addObject(giftRecTrackingCount, grTrackingCount);
		mav.addObject(giftRecDeliveredCount, grDeliveredCount);
		mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
		mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
		mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView giftReceivedShipNowSelectedOrderRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(giftReceivedManagementList[2])) {
    		mav = grConBoardsShipNowSelectedOrderInfo(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    		mav.addObject(bothCBAndFTRefName, giftReceivedManagementList[2]);
    	} else if((finiTouchesRefName).equals(giftReceivedManagementList[2])) {
    		mav = grFinTouchesShipNowSelectedOrderInfo(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    		mav.addObject(bothCBAndFTRefName, giftReceivedManagementList[2]);
    	} else {
    		mav = adminGiftsReceivedShipNowData(req, sn);
    	}
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView grConBoardsShipNowSelectedOrderInfo(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef) {
    	ModelAndView mav;    	
    	String cbIndividualProductsName = null;
    	String cbIndividualProductsStore = null;
    	String cbIndividualProductsHeading = null;
    	String cbIndividualProductsQuantity = null;
    	String cbIndividualProductsPrice = null;
    	String cbIndividualProductsLink = null;
    	String registrantsFullName = null;
    	String registrantsShippingAddress = null;
    	String registrantsApartment = null;
    	String registrantsCity = null;
    	String registrantsState = null;
    	String registrantsZip = null;
    	String registrantsPhoneNumber = null;
    	String registrantsEmail = null;    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regCBIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regCBIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(guestCBIndividualPaymentSavingModel.getGiftedQuantity());
    		cbIndividualProductsPrice = "$" + regCBIndividualProductSavingModel.getProductPrice();
    		cbIndividualProductsLink = regCBIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();    		
    	} else if((regIndConBoardsReff).equals(typeOfConBoardRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regCBIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBIndividualPaymentSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regCBIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regCBIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(regCBIndividualPaymentSavingModel.getGiftedQuantity());
    		cbIndividualProductsPrice = "$" + regCBIndividualProductSavingModel.getProductPrice();
    		cbIndividualProductsLink = regCBIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	} else {    		
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);    		
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regCBContributedSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBContributedSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regCBContributedSavingModel.getProductName();
    		cbIndividualProductsStore = regCBContributedSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBContributedSavingModel.getProductHeading();
    		double contributedPrice = Double.parseDouble(regCBContributedSavingModel.getContributedPrice());
			double remainingTotalPrice = Double.parseDouble(regCBContributedSavingModel.getRemainingTotalPrice());
			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
    		cbIndividualProductsQuantity = null;
    		cbIndividualProductsPrice = "$" + String.format("%,.2f", totalGiftedPrice);
    		cbIndividualProductsLink = regCBContributedSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	}
    	mav = new ModelAndView(adminRegGiftRecPlaceOrderDataDisplay);
    	mav.addObject(cbIndividualProductName, cbIndividualProductsName);
    	mav.addObject(cbIndividualProductStore, cbIndividualProductsStore);
        mav.addObject(cbIndividualProductHeading, cbIndividualProductsHeading);
    	mav.addObject(cbIndividualProductQuantity, cbIndividualProductsQuantity);
    	mav.addObject(cbIndividualProductPrice, cbIndividualProductsPrice);
        mav.addObject(cbIndividualProductLink, cbIndividualProductsLink);        
        mav.addObject(registrantFullName, registrantsFullName);
        mav.addObject(registrantShippingAddress, registrantsShippingAddress);
        mav.addObject(registrantApartment, registrantsApartment);
        mav.addObject(registrantCity, registrantsCity);
        mav.addObject(registrantState, registrantsState);
        mav.addObject(registrantZip, registrantsZip);
        mav.addObject(registrantPhoneNumber, registrantsPhoneNumber);
        mav.addObject(registrantEmail, registrantsEmail);        
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView grFinTouchesShipNowSelectedOrderInfo(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;    	
    	String cbIndividualProductsName = null;
    	String cbIndividualProductsStore = null;
    	String cbIndividualProductsHeading = null;
    	String cbIndividualProductsQuantity = null;
    	String cbIndividualProductsPrice = null;
    	String cbIndividualProductsLink = null;
    	String registrantsFullName = null;
    	String registrantsShippingAddress = null;
    	String registrantsApartment = null;
    	String registrantsCity = null;
    	String registrantsState = null;
    	String registrantsZip = null;
    	String registrantsPhoneNumber = null;
    	String registrantsEmail = null;    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regFTIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regFTIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regFTIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(guestFTIndividualPaymentSavingModel.getGiftedQuantity());
    		cbIndividualProductsPrice = "$" + regFTIndividualProductSavingModel.getProductPrice();
    		cbIndividualProductsLink = regFTIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();    		
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regFTIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTIndividualPaymentSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regFTIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regFTIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regFTIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(regFTIndividualPaymentSavingModel.getGiftedQuantity());
    		cbIndividualProductsPrice = "$" + regFTIndividualProductSavingModel.getProductPrice();
    		cbIndividualProductsLink = regFTIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	} else {    		
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);    		
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regFTContributedSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTContributedSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regFTContributedSavingModel.getProductName();
    		cbIndividualProductsStore = regFTContributedSavingModel.getStoreName();
    		cbIndividualProductsHeading = regFTContributedSavingModel.getProductHeading();
    		double contributedPrice = Double.parseDouble(regFTContributedSavingModel.getContributedPrice());
			double remainingTotalPrice = Double.parseDouble(regFTContributedSavingModel.getRemainingTotalPrice());
			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
    		cbIndividualProductsQuantity = null;
    		cbIndividualProductsPrice = "$" + String.format("%,.2f", totalGiftedPrice);
    		cbIndividualProductsLink = regFTContributedSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	}
    	mav = new ModelAndView(adminRegGiftRecPlaceOrderDataDisplay);
    	mav.addObject(cbIndividualProductName, cbIndividualProductsName);
    	mav.addObject(cbIndividualProductStore, cbIndividualProductsStore);
        mav.addObject(cbIndividualProductHeading, cbIndividualProductsHeading);
    	mav.addObject(cbIndividualProductQuantity, cbIndividualProductsQuantity);
    	mav.addObject(cbIndividualProductPrice, cbIndividualProductsPrice);
        mav.addObject(cbIndividualProductLink, cbIndividualProductsLink);        
        mav.addObject(registrantFullName, registrantsFullName);
        mav.addObject(registrantShippingAddress, registrantsShippingAddress);
        mav.addObject(registrantApartment, registrantsApartment);
        mav.addObject(registrantCity, registrantsCity);
        mav.addObject(registrantState, registrantsState);
        mav.addObject(registrantZip, registrantsZip);
        mav.addObject(registrantPhoneNumber, registrantsPhoneNumber);
        mav.addObject(registrantEmail, registrantsEmail);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGROrderPlaceStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);    	
    	if((consBoardsRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGROrderPlaceConBoardsStatusUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGROrderPlaceFinTouchesStatusUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedShipNowData(req, sn);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGROrderPlaceConBoardsStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef) {
    	ModelAndView mav;    	  	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		guestCBIndividualPaymentSavingModel.setIndividualStatus(indOrderedStatusRef);
    		guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);    		   		
    	} else if((regIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(indOrderedStatusRef);
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);    		
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setContributedStatus(indOrderedStatusRef);
    		regCBContributedSavingModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
    		registryCBGRContributedPaymentColumnsUpdate(req, sn, indOrderedStatusRef, cbIndividualPaymentSavingId, currentDate);
    		guestCBGRContributedPaymentColumnsUpdate(req, sn, indOrderedStatusRef, cbIndividualPaymentSavingId, currentDate);
    	}
    	mav = adminGiftsReceivedOrderedDataDisplay(req, sn);    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGROrderPlaceFinTouchesStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;    	  	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		guestFTIndividualPaymentSavingModel.setIndividualStatus(indOrderedStatusRef);
    		guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);    		   		
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(indOrderedStatusRef);
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);    		
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTContributedSavingModel.setContributedStatus(indOrderedStatusRef);
    		regFTContributedSavingModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
    		registryFTGRContributedPaymentColumnsUpdate(req, sn, indOrderedStatusRef, ftIndividualPaymentSavingId, currentDate);
    		guestFTGRContributedPaymentColumnsUpdate(req, sn, indOrderedStatusRef, ftIndividualPaymentSavingId, currentDate);
    	}
    	mav = adminGiftsReceivedOrderedDataDisplay(req, sn);    	
        return mav;
    }
    
    public String registryCBGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String regCBContributedSavingValue = null;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBGiftReceivedContributedPaymentInfoList(cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			regCBContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regCBContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantConceptBoardsContributedPaymentSavingDAO.merge(regCBContributedPaymentModel);
    		}
    	}
    	return regCBContributedSavingValue;
    }

    public String guestCBGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String guestCBContributedSavingValue = null;
    	List<GuestConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentInfoList(cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : regCBContributedPaymentList) {
    			guestCBContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestCBContributedSavingModel.setRefferanceDate(currentDate);
    			guestConceptBoardsContributedPaymentSavingDAO.merge(guestCBContributedSavingModel);
    		}
    	}
    	return guestCBContributedSavingValue;
    }

    public String registryFTGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String regFTContributedSavingValue = null;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTGiftReceivedContributedPaymentInfoList(ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel : regFTContributedPaymentList) {
    			regFTContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regFTContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantFinishingTouchesContributedPaymentSavingDAO.merge(regFTContributedPaymentModel);
    		}
    	}
    	return regFTContributedSavingValue;
    }

    public String guestFTGRContributedPaymentColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String guestFTContributedSavingValue = null;
    	List<GuestFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentInfoList(ftContributedProductSavingId);
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
    public ModelAndView adminGiftsReceivedOrderedDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();
    	int guestCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indOrderedStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderedStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderedStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderedStatusRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indOrderedStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderedStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderedStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOrderedStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
      	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
		int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
		int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
		int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
		int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
		int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
		int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);    		
    		mav = new ModelAndView(adminRegGiftReceivedOrderedDisplay);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedOrderedDataList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);    		
    	} else {
    		mav = new ModelAndView(adminRegGiftReceivedOrderedDisplay);    		    		   		
    	}
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
		mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
		mav.addObject(giftRecOrderedCount, totalProductCount);
		mav.addObject(giftRecTrackingCount, grTrackingCount);
		mav.addObject(giftRecDeliveredCount, grDeliveredCount);
		mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
		mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
		mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftReceivedTrackingDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView("adminGiftReceivedTrackingDataDisplay");    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftReceivedTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	String admnGRTrackingLinkURL = req.getParameter("adminGRTrackingLinkURL");
    	String adminTrackingLinkURL = admnGRTrackingLinkURL.replaceAll("[\n\r]", " ");
    	if((consBoardsRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRConBoardsTrackingLinkUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1], adminTrackingLinkURL);
    	} else if((finiTouchesRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRFinTouchesTrackingLinkUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1], adminTrackingLinkURL);
    	} else {
    		mav = adminGiftsReceivedOrderedDataDisplay(req, sn);
    	}    	    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef, String adminTrackingLinkURL) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);    		
    		guestCBIndividualPaymentSavingModel.setTrackingLink(adminTrackingLinkURL);
    		guestCBIndividualPaymentSavingModel.setIndividualStatus(indTrackingStatusRef);
    		guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId(), guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
			GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestCBIndividualPaymentSavingModel.getGuestUserPaymentInfoSavingId());
			adminGiftReceivedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), regCBIndividualUpdateModel.getProductName(), regCBIndividualUpdateModel.getProductHeading(), regCBIndividualUpdateModel.getQuantity(), regCBIndividualUpdateModel.getProductPrice(), adminTrackingLinkURL);			
    	} else if((regIndConBoardsReff).equals(typeOfConBoardRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(indTrackingStatusRef);
    		regCBIndividualPaymentSavingModel.setTrackingLink(adminTrackingLinkURL);
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);    		
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(regCBIndividualPaymentSavingModel.getRegistrantUserId(), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBIndividualPaymentSavingModel.getRegistrantUserId());
			RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regCBIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			adminGiftReceivedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), regCBIndividualUpdateModel.getProductName(), regCBIndividualUpdateModel.getProductHeading(), regCBIndividualUpdateModel.getQuantity(), regCBIndividualUpdateModel.getProductPrice(), adminTrackingLinkURL);
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setContributedStatus(indTrackingStatusRef);
    		regCBContributedSavingModel.setTrackingLink(adminTrackingLinkURL);
    		regCBContributedSavingModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
    		registryCBGRContributedPaymentTrackColumnsUpdate(req, sn, indTrackingStatusRef, adminTrackingLinkURL, cbIndividualPaymentSavingId, currentDate);
    		guestCBGRContributedPaymentTrackColumnsUpdate(req, sn, indTrackingStatusRef, adminTrackingLinkURL, cbIndividualPaymentSavingId, currentDate);
    		adminGiftReceivedConBoardsEmailSendingDataHold(req, sn, regCBContributedSavingModel.getRegistrantUserId(), cbIndividualPaymentSavingId, regCBContributedSavingModel.getProductName(), regCBContributedSavingModel.getProductHeading(), adminTrackingLinkURL);    		
    	}    	
    	mav = adminGiftsReceivedTrackingDataDisplay(req, sn);    	
        return mav;
    }
    	
    public String adminGiftReceivedConBoardsEmailSendingDataHold(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualPaymentSavingId, String productName, String productSize, String adminTrackingLinkURL) {
    	String adminCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBGiftReceivedContributedPaymentInfoList(cbIndividualPaymentSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusTakeFromDB(registrantUserId, cbIndividualPaymentSavingId);
    		RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regCBContributedPaymentModel.getRegistrantPaymentInfoSavingId());
    		adminGiftReceivedContributedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), productName, productSize, adminTrackingLinkURL);
    	}
    	List<GuestConceptBoardsContributedPaymentSaving> guestCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentInfoList(cbIndividualPaymentSavingId);
    	if (!guestCBContributedPaymentList.isEmpty()) {
    		GuestConceptBoardsContributedPaymentSaving guestCBContributedPaymentModel = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestCBContributedPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminGiftReceivedContributedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), productName, productSize, adminTrackingLinkURL);
    	}
		return adminCartPaymentReff;
	}

    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef, String adminTrackingLinkURL) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);    		
    		guestFTIndividualPaymentSavingModel.setTrackingLink(adminTrackingLinkURL);
    		guestFTIndividualPaymentSavingModel.setIndividualStatus(indTrackingStatusRef);
    		guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId(), guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
			GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestFTIndividualPaymentSavingModel.getGuestUserPaymentInfoSavingId());
			adminGiftReceivedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), regFTIndividualUpdateModel.getProductName(), regFTIndividualUpdateModel.getProductHeading(), regFTIndividualUpdateModel.getQuantity(), regFTIndividualUpdateModel.getProductPrice(), adminTrackingLinkURL);			
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(indTrackingStatusRef);
    		regFTIndividualPaymentSavingModel.setTrackingLink(adminTrackingLinkURL);
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);    		
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(regFTIndividualPaymentSavingModel.getRegistrantUserId(), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTIndividualPaymentSavingModel.getRegistrantUserId());
			RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regFTIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			adminGiftReceivedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), regFTIndividualUpdateModel.getProductName(), regFTIndividualUpdateModel.getProductHeading(), regFTIndividualUpdateModel.getQuantity(), regFTIndividualUpdateModel.getProductPrice(), adminTrackingLinkURL);
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTContributedSavingModel.setContributedStatus(indTrackingStatusRef);
    		regFTContributedSavingModel.setTrackingLink(adminTrackingLinkURL);
    		regFTContributedSavingModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
    		registryFTGRContributedPaymentTrackColumnsUpdate(req, sn, indTrackingStatusRef, adminTrackingLinkURL, ftIndividualPaymentSavingId, currentDate);
    		guestFTGRContributedPaymentTrackColumnsUpdate(req, sn, indTrackingStatusRef, adminTrackingLinkURL, ftIndividualPaymentSavingId, currentDate);
    		adminGiftReceivedFinTouchesEmailSendingDataHold(req, sn, regFTContributedSavingModel.getRegistrantUserId(), ftIndividualPaymentSavingId, regFTContributedSavingModel.getProductName(), regFTContributedSavingModel.getProductHeading(), adminTrackingLinkURL);    		
    	}    	
    	mav = adminGiftsReceivedTrackingDataDisplay(req, sn);    	
        return mav;
    }
    	
    public String adminGiftReceivedFinTouchesEmailSendingDataHold(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualPaymentSavingId, String productName, String productSize, String adminTrackingLinkURL) {
    	String adminCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTGiftReceivedContributedPaymentInfoList(ftIndividualPaymentSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusTakeFromDB(registrantUserId, ftIndividualPaymentSavingId);
    		RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regFTContributedPaymentModel.getRegistrantPaymentInfoSavingId());
    		adminGiftReceivedContributedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), productName, productSize, adminTrackingLinkURL);
    	}
    	List<GuestFinishingTouchesContributedPaymentSaving> guestFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentInfoList(ftIndividualPaymentSavingId);
    	if (!guestFTContributedPaymentList.isEmpty()) {
    		GuestFinishingTouchesContributedPaymentSaving guestFTContributedPaymentModel = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestFTContributedPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminGiftReceivedContributedTrackingLinkSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), productName, productSize, adminTrackingLinkURL);
    	}
		return adminCartPaymentReff;
	}

	public String adminGiftReceivedTrackingLinkSendToRegistrant(HttpServletRequest req, HttpSession sn, String regUserEmail, String userFullName, long orderNumber, String productName, String productSize, Integer quantity, String productPrice, String trackingLink) {
	  	String shopCartPaymentReff = null;
	  	String[] emailList = {regUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
	  	String subject = "Here’s Your Tracking Link!";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>Hip Hip Hooray!</p>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Your gift is on its way!</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Here is your <font  style='font: bold 1.05em/1em sans-serif;'>TRACKING LINK: </font><font style='font: 1.1em/1.25em sans-serif;'><a href=" + trackingLink + "> click here </a></font></p>"                
                + "<p style='margin-top: 40px; font: bold 1.05em/1em sans-serif;'>Order Number: " + orderNumber + "</p>"                
                + "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productName + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productSize + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'>Quantity: " + quantity + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productPrice + "</p>"
	        	+ "<div style='margin-top: 10px; border-top: 1px solid black; width: 300px;'></div>"								
				+ "<p style='margin-top: 30px; margin-bottom: 35px; font: italic 1.05em/1.5em sans-serif;'>Please note that it may take 24-48 hours for your tracking info to be up to date.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin gift received tracking link send to registrant failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

	public String adminGiftReceivedContributedTrackingLinkSendToRegistrant(HttpServletRequest req, HttpSession sn, String regUserEmail, String userFullName, long orderNumber, String productName, String productSize, String trackingLink) {
	  	String shopCartPaymentReff = null;
	  	String[] emailList = {regUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
	  	String subject = "Here’s Your Tracking Link!";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>Hip Hip Hooray!</p>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Your gift is on its way!</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Here is your <font  style='font: bold 1.05em/1em sans-serif;'>TRACKING LINK: </font><font style='font: 1.1em/1.25em sans-serif;'><a href=" + trackingLink + "> click here </a></font></p>"                
                + "<p style='margin-top: 40px; font: bold 1.05em/1em sans-serif;'>Order Number: " + orderNumber + "</p>"                
                + "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productName + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productSize + "</p>"	        	
	        	+ "<div style='margin-top: 10px; border-top: 1px solid black; width: 300px;'></div>"								
				+ "<p style='margin-top: 30px; margin-bottom: 35px; font: italic 1.05em/1.5em sans-serif;'>Please note that it may take 24-48 hours for your tracking info to be up to date.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin gift received contributed tracking link send to registrant failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

    public String registryFTGRContributedPaymentTrackColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedTrackReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String regFTContributedSavingValue = null;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTGiftReceivedContributedPaymentInfoList(ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel : regFTContributedPaymentList) {
    			regFTContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regFTContributedPaymentModel.setTrackingLink(contributedTrackReff);
    			regFTContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantFinishingTouchesContributedPaymentSavingDAO.merge(regFTContributedPaymentModel);
    		}
    	}
    	return regFTContributedSavingValue;
    }
    public String guestFTGRContributedPaymentTrackColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedTrackReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String guestFTContributedSavingValue = null;
    	List<GuestFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentInfoList(ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (GuestFinishingTouchesContributedPaymentSaving guestFTContributedSavingModel : regFTContributedPaymentList) {
    			guestFTContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestFTContributedSavingModel.setTrackingLink(contributedTrackReff);
    			guestFTContributedSavingModel.setRefferanceDate(currentDate);
    			guestFinishingTouchesContributedPaymentSavingDAO.merge(guestFTContributedSavingModel);
    		}
    	}
    	return guestFTContributedSavingValue;
    }

    public String registryCBGRContributedPaymentTrackColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedTrackReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String regCBContributedSavingValue = null;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBGiftReceivedContributedPaymentInfoList(cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			regCBContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regCBContributedPaymentModel.setTrackingLink(contributedTrackReff);
    			regCBContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantConceptBoardsContributedPaymentSavingDAO.merge(regCBContributedPaymentModel);
    		}
    	}
    	return regCBContributedSavingValue;
    }

    public String guestCBGRContributedPaymentTrackColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedTrackReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String guestCBContributedSavingValue = null;
    	List<GuestConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentInfoList(cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : regCBContributedPaymentList) {
    			guestCBContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestCBContributedSavingModel.setTrackingLink(contributedTrackReff);
    			guestCBContributedSavingModel.setRefferanceDate(currentDate);
    			guestConceptBoardsContributedPaymentSavingDAO.merge(guestCBContributedSavingModel);
    		}
    	}
    	return guestCBContributedSavingValue;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedTrackingDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();
    	int guestCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indTrackingStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indTrackingStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indTrackingStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indTrackingStatusRef, regCBContributedSavingList, regContCount);
   
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indTrackingStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indTrackingStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indTrackingStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indTrackingStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
      	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
		int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
		int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
		int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
		int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
		int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
		int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);    		
    		mav = new ModelAndView(adminGiftsReceivedTrackingDisplay);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedTrackingDataList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);    		
    	} else {
    		mav = new ModelAndView(adminGiftsReceivedTrackingDisplay);    		    		   		
    	}
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
		mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
		mav.addObject(giftRecOrderedCount, grOrderedCount);
		mav.addObject(giftRecTrackingCount, totalProductCount);
		mav.addObject(giftRecDeliveredCount, grDeliveredCount);
		mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
		mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
		mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftReceivedOrderedDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRConBoardsOrderedDataUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRFinTouchesOrderedDataUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedTrackingDataDisplay(req, sn);
    	}
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsOrderedDataUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		guestCBIndividualPaymentSavingModel.setIndividualStatus(indDeliveredStatusRef);
    		guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);    		
    	} else if((regIndConBoardsReff).equals(typeOfConBoardRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(indDeliveredStatusRef);
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setContributedStatus(indDeliveredStatusRef);
    		regCBContributedSavingModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
    		registryCBGRContributedPaymentColumnsUpdate(req, sn, indDeliveredStatusRef, cbIndividualPaymentSavingId, currentDate);
    		guestCBGRContributedPaymentColumnsUpdate(req, sn, indDeliveredStatusRef, cbIndividualPaymentSavingId, currentDate);
    	}
    	mav = adminGiftsReceivedDeliveredDataDisplay(req, sn);    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesOrderedDataUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		guestFTIndividualPaymentSavingModel.setIndividualStatus(indDeliveredStatusRef);
    		guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);    		
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(indDeliveredStatusRef);
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTContributedSavingModel.setContributedStatus(indDeliveredStatusRef);
    		regFTContributedSavingModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
    		registryFTGRContributedPaymentColumnsUpdate(req, sn, indDeliveredStatusRef, ftIndividualPaymentSavingId, currentDate);
    		guestFTGRContributedPaymentColumnsUpdate(req, sn, indDeliveredStatusRef, ftIndividualPaymentSavingId, currentDate);
    	}
    	mav = adminGiftsReceivedDeliveredDataDisplay(req, sn);    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedDeliveredDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();    	
    	int guestCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indDeliveredStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indDeliveredStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indDeliveredStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indDeliveredStatusRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indDeliveredStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indDeliveredStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indDeliveredStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indDeliveredStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
      	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
		int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
		int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
		int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
		int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
		int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
		int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);    		
    		mav = new ModelAndView(adminRegGiftReceivedDeliveredDisplay);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedDeliveredDataList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);    		
    	} else {
    		mav = new ModelAndView(adminRegGiftReceivedDeliveredDisplay);    		    		   		
    	}
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
		mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
		mav.addObject(giftRecOrderedCount, grOrderedCount);
		mav.addObject(giftRecTrackingCount, grTrackingCount);
		mav.addObject(giftRecDeliveredCount, totalProductCount);
		mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
		mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
		mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRBackOrderedDateDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView("adminGRBackOrderedDateDisplay");    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(bothCBAndFTRefName, req.getParameter(bothCBAndFTRefName));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	String admnGRBackOrderedDate = req.getParameter("adminGRBackOrderedDate");
    	if((consBoardsRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGRConBoardsBackOrderedDateUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1], admnGRBackOrderedDate);
    	} else if((finiTouchesRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGRFinTouchesBackOrderedDateUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1], admnGRBackOrderedDate);
    	} else {
    		mav = adminGiftsReceivedShipNowData(req, sn);
    	}    	   	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(bothCBAndFTRefName, req.getParameter(bothCBAndFTRefName));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef, String admnGRBackOrderedDate) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);    		
    		guestCBIndividualPaymentSavingModel.setStatus(admnGRBackOrderedDate);
    		guestCBIndividualPaymentSavingModel.setIndividualStatus(indBOTillDateStatusRef);
    		guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);    		
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId(), guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
			GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestCBIndividualPaymentSavingModel.getGuestUserPaymentInfoSavingId());
			adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), regCBIndividualUpdateModel.getProductName(), admnGRBackOrderedDate);			
    	} else if((regIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setStatus(admnGRBackOrderedDate);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(indBOTillDateStatusRef);    		
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);    		
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(regCBIndividualPaymentSavingModel.getRegistrantUserId(), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBIndividualPaymentSavingModel.getRegistrantUserId());
			RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regCBIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), regCBIndividualUpdateModel.getProductName(), admnGRBackOrderedDate);			
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setContributedStatus(indBOTillDateStatusRef);
    		regCBContributedSavingModel.setUpdatedDate(currentDate);
    		regCBContributedSavingModel.setStatus(admnGRBackOrderedDate);
    		registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
    		registryCBGRContributedPaymentDateColumnsUpdate(req, sn, indBOTillDateStatusRef, admnGRBackOrderedDate, cbIndividualPaymentSavingId, currentDate);
    		guestCBGRContributedPaymentDateColumnsUpdate(req, sn, indBOTillDateStatusRef, admnGRBackOrderedDate, cbIndividualPaymentSavingId, currentDate);
    		adminGiftReceivedConBoardsEmailSendingBODateHold(req, sn, regCBContributedSavingModel.getRegistrantUserId(), cbIndividualPaymentSavingId, regCBContributedSavingModel.getProductName(), admnGRBackOrderedDate);
    	}
    	mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef, String admnGRBackOrderedDate) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);    		
    		guestFTIndividualPaymentSavingModel.setStatus(admnGRBackOrderedDate);
    		guestFTIndividualPaymentSavingModel.setIndividualStatus(indBOTillDateStatusRef);
    		guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);    		
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId(), guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
			GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestFTIndividualPaymentSavingModel.getGuestUserPaymentInfoSavingId());
			adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), regFTIndividualUpdateModel.getProductName(), admnGRBackOrderedDate);			
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTIndividualPaymentSavingModel.setStatus(admnGRBackOrderedDate);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(indBOTillDateStatusRef);    		
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);    		
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(regFTIndividualPaymentSavingModel.getRegistrantUserId(), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTIndividualPaymentSavingModel.getRegistrantUserId());
			RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regFTIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), regFTIndividualUpdateModel.getProductName(), admnGRBackOrderedDate);			
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTContributedSavingModel.setContributedStatus(indBOTillDateStatusRef);
    		regFTContributedSavingModel.setUpdatedDate(currentDate);
    		regFTContributedSavingModel.setStatus(admnGRBackOrderedDate);
    		registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
    		registryFTGRContributedPaymentDateColumnsUpdate(req, sn, indBOTillDateStatusRef, admnGRBackOrderedDate, ftIndividualPaymentSavingId, currentDate);
    		guestFTGRContributedPaymentDateColumnsUpdate(req, sn, indBOTillDateStatusRef, admnGRBackOrderedDate, ftIndividualPaymentSavingId, currentDate);
    		adminGiftReceivedFinTouchesEmailSendingBODateHold(req, sn, regFTContributedSavingModel.getRegistrantUserId(), ftIndividualPaymentSavingId, regFTContributedSavingModel.getProductName(), admnGRBackOrderedDate);
    	}
    	mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
	
    public String adminGiftReceivedConBoardsEmailSendingBODateHold(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualPaymentSavingId, String productName, String admnGRBackOrderedDate) {
    	String adminCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBGiftReceivedContributedPaymentInfoList(cbIndividualPaymentSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusTakeFromDB(registrantUserId, cbIndividualPaymentSavingId);
    		RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regCBContributedPaymentModel.getRegistrantPaymentInfoSavingId());
    		adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), productName, admnGRBackOrderedDate);
    	}
    	List<GuestConceptBoardsContributedPaymentSaving> guestCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentInfoList(cbIndividualPaymentSavingId);
    	if (!guestCBContributedPaymentList.isEmpty()) {
    		GuestConceptBoardsContributedPaymentSaving guestCBContributedPaymentModel = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestCBContributedPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), productName, admnGRBackOrderedDate);
    	}
		return adminCartPaymentReff;
	}

    public String adminGiftReceivedFinTouchesEmailSendingBODateHold(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualPaymentSavingId, String productName, String admnGRBackOrderedDate) {
    	String adminCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTGiftReceivedContributedPaymentInfoList(ftIndividualPaymentSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusTakeFromDB(registrantUserId, ftIndividualPaymentSavingId);
    		RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regFTContributedPaymentModel.getRegistrantPaymentInfoSavingId());
    		adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), productName, admnGRBackOrderedDate);
    	}
    	List<GuestFinishingTouchesContributedPaymentSaving> guestFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentInfoList(ftIndividualPaymentSavingId);
    	if (!guestFTContributedPaymentList.isEmpty()) {
    		GuestFinishingTouchesContributedPaymentSaving guestFTContributedPaymentModel = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestFTContributedPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminGiftReceivedBackOrderedDateEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), productName, admnGRBackOrderedDate);
    	}
		return adminCartPaymentReff;
	}

	public String adminGiftReceivedBackOrderedDateEmailSendToRegistrant(HttpServletRequest req, HttpSession sn, String shopUserEmail, String userFullName, long orderNumber, String productName, String backOrderedDate) {
	  	String shopCartPaymentReff = null;
	  	String[] emailList = {shopUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
	  	String subject = "A Product Is On Back Order";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We have been notified by the vendor that the <b>" + productName + "</b> from Order Number: <b>" + orderNumber + "</b> is currently back-ordered till <b>" + backOrderedDate + "</b>.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We apologize for any inconvenience this delay has caused. If you wish to keep your order as is, the status under 'Gift Tracker' for the product will be updated once it becomes available again and you will be able to request purchasing at that time.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>You also have the option to convert the gift total to Nook+Cove store credit that can be used towards anything on the site. Please note that for any back-ordered or out-of-stock products, our designers are always on the hunt for great replacements and are constantly updating our design boards! We recommend you check back to your favorite design boards for updates and product replacements.</p>"
                + "<p style='margin-top: 30px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>We appreciate and thank you for your patience on this matter.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin gift received back ordered date email send to registrant failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

    public String registryCBGRContributedPaymentDateColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedDateReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String regCBContributedSavingValue = null;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBGiftReceivedContributedPaymentInfoList(cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel : regCBContributedPaymentList) {
    			regCBContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regCBContributedPaymentModel.setStatus(contributedDateReff);
    			regCBContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantConceptBoardsContributedPaymentSavingDAO.merge(regCBContributedPaymentModel);
    		}
    	}
    	return regCBContributedSavingValue;
    }

    public String guestCBGRContributedPaymentDateColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedDateReff, long cbContributedProductSavingId, Timestamp currentDate) {
    	String guestCBContributedSavingValue = null;
    	List<GuestConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentInfoList(cbContributedProductSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {		
    		for (GuestConceptBoardsContributedPaymentSaving guestCBContributedSavingModel : regCBContributedPaymentList) {
    			guestCBContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestCBContributedSavingModel.setStatus(contributedDateReff);
    			guestCBContributedSavingModel.setRefferanceDate(currentDate);
    			guestConceptBoardsContributedPaymentSavingDAO.merge(guestCBContributedSavingModel);
    		}
    	}
    	return guestCBContributedSavingValue;
    }

    public String registryFTGRContributedPaymentDateColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedDateReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String regFTContributedSavingValue = null;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTGiftReceivedContributedPaymentInfoList(ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel : regFTContributedPaymentList) {
    			regFTContributedPaymentModel.setContributedStatus(contributedStatusReff);
    			regFTContributedPaymentModel.setStatus(contributedDateReff);
    			regFTContributedPaymentModel.setRefferanceDate(currentDate);
    			registrantFinishingTouchesContributedPaymentSavingDAO.merge(regFTContributedPaymentModel);
    		}
    	}
    	return regFTContributedSavingValue;
    }

    public String guestFTGRContributedPaymentDateColumnsUpdate(HttpServletRequest req, HttpSession sn, String contributedStatusReff, String contributedDateReff, long ftContributedProductSavingId, Timestamp currentDate) {
    	String guestFTContributedSavingValue = null;
    	List<GuestFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentInfoList(ftContributedProductSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {		
    		for (GuestFinishingTouchesContributedPaymentSaving guestFTContributedSavingModel : regFTContributedPaymentList) {
    			guestFTContributedSavingModel.setContributedStatus(contributedStatusReff);
    			guestFTContributedSavingModel.setStatus(contributedDateReff);
    			guestFTContributedSavingModel.setRefferanceDate(currentDate);
    			guestFinishingTouchesContributedPaymentSavingDAO.merge(guestFTContributedSavingModel);
    		}
    	}
    	return guestFTContributedSavingValue;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedBackOrderedDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();    	
    	int guestCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indBOTillDateStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indBOTillDateStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indBOTillDateStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indBOTillDateStatusRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indBOTillDateStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indBOTillDateStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indBOTillDateStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indBOTillDateStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
      	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
		int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
		int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
		int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
		int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
		int grOutOfStockCount = adminGiftsReceivedOutOfStockCount(req, sn);
		int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);    		
    		mav = new ModelAndView(adminRegGiftReceivedBackOrderedDisplay);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedBackOrderedDataList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);    		
    	} else {
    		mav = new ModelAndView(adminRegGiftReceivedBackOrderedDisplay);    		    		   		
    	}
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
		mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
		mav.addObject(giftRecOrderedCount, grOrderedCount);
		mav.addObject(giftRecTrackingCount, grTrackingCount);
		mav.addObject(giftRecDeliveredCount, grDeliveredCount);
		mav.addObject(giftRecBackOrderedCount, totalProductCount);
		mav.addObject(giftRecOutOfStockCount, grOutOfStockCount);
		mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftReceivedBackOrderViewDetails(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRConBoardsBackOrderViewDetails(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRFinTouchesBackOrderViewDetails(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);
    	}
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(bothCBAndFTRefName, giftReceivedManagementList[2]);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsBackOrderViewDetails(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef) {
    	ModelAndView mav;    	
    	String cbIndividualProductsName = null;
    	String cbIndividualProductsStore = null;
    	String cbIndividualProductsHeading = null;
    	String cbIndividualProductsQuantity = null;
    	String cbIndividualProductsPrice = null;
    	String cbIndividualProductsLink = null;
    	String backOrderedText = null;
    	if((gusetIndConBoardsReff).equals(typeOfConBoardRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		cbIndividualProductsName = regCBIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regCBIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(guestCBIndividualPaymentSavingModel.getGiftedQuantity());
    		cbIndividualProductsPrice = regCBIndividualProductSavingModel.getProductPrice();
    		cbIndividualProductsLink = regCBIndividualProductSavingModel.getStoreUrl();
    		backOrderedText = guestCBIndividualPaymentSavingModel.getBackOrderedText();
    	} else if((regIndConBoardsReff).equals(typeOfConBoardRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		cbIndividualProductsName = regCBIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regCBIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(regCBIndividualPaymentSavingModel.getGiftedQuantity());
    		cbIndividualProductsPrice = regCBIndividualProductSavingModel.getProductPrice();
    		cbIndividualProductsLink = regCBIndividualProductSavingModel.getStoreUrl();
    		backOrderedText = regCBIndividualPaymentSavingModel.getBackOrderedText();
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		cbIndividualProductsName = regCBContributedSavingModel.getProductName();
    		cbIndividualProductsStore = regCBContributedSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBContributedSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = null;
    		double contributedPrice = Double.parseDouble(regCBContributedSavingModel.getContributedPrice());
    		cbIndividualProductsPrice = "$" + String.format("%,.2f", contributedPrice);
    		cbIndividualProductsLink = regCBContributedSavingModel.getStoreUrl();
    		backOrderedText = regCBContributedSavingModel.getBackOrderedText();
    	}
    	mav = new ModelAndView(adminGiftReceivedBackOrderViewDetails);
    	mav.addObject(cbIndividualProductName, cbIndividualProductsName);
    	mav.addObject(cbIndividualProductStore, cbIndividualProductsStore);
        mav.addObject(cbIndividualProductHeading, cbIndividualProductsHeading);
    	mav.addObject(cbIndividualProductQuantity, cbIndividualProductsQuantity);
    	mav.addObject(cbIndividualProductPrice, cbIndividualProductsPrice);
        mav.addObject(cbIndividualProductLink, cbIndividualProductsLink);
        mav.addObject(cbBackOrderedText, backOrderedText);
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesBackOrderViewDetails(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;    	
    	String ftIndividualProductsName = null;
    	String ftIndividualProductsStore = null;
    	String ftIndividualProductsHeading = null;
    	String ftIndividualProductsQuantity = null;
    	String ftIndividualProductsPrice = null;
    	String ftIndividualProductsLink = null;
    	String backOrderedText = null;
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		ftIndividualProductsName = regFTIndividualProductSavingModel.getProductName();
    		ftIndividualProductsStore = regFTIndividualProductSavingModel.getStoreName();
    		ftIndividualProductsHeading = regFTIndividualProductSavingModel.getProductHeading();
    		ftIndividualProductsQuantity = String.valueOf(guestFTIndividualPaymentSavingModel.getGiftedQuantity());
    		ftIndividualProductsPrice = regFTIndividualProductSavingModel.getProductPrice();
    		ftIndividualProductsLink = regFTIndividualProductSavingModel.getStoreUrl();
    		backOrderedText = guestFTIndividualPaymentSavingModel.getBackOrderedText();
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		ftIndividualProductsName = regFTIndividualProductSavingModel.getProductName();
    		ftIndividualProductsStore = regFTIndividualProductSavingModel.getStoreName();
    		ftIndividualProductsHeading = regFTIndividualProductSavingModel.getProductHeading();
    		ftIndividualProductsQuantity = String.valueOf(regFTIndividualPaymentSavingModel.getGiftedQuantity());
    		ftIndividualProductsPrice = regFTIndividualProductSavingModel.getProductPrice();
    		ftIndividualProductsLink = regFTIndividualProductSavingModel.getStoreUrl();
    		backOrderedText = regFTIndividualPaymentSavingModel.getBackOrderedText();
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		ftIndividualProductsName = regFTContributedSavingModel.getProductName();
    		ftIndividualProductsStore = regFTContributedSavingModel.getStoreName();
    		ftIndividualProductsHeading = regFTContributedSavingModel.getProductHeading();
    		ftIndividualProductsQuantity = null;
    		double contributedPrice = Double.parseDouble(regFTContributedSavingModel.getContributedPrice());
    		ftIndividualProductsPrice = "$" + String.format("%,.2f", contributedPrice);
    		ftIndividualProductsLink = regFTContributedSavingModel.getStoreUrl();
    		backOrderedText = regFTContributedSavingModel.getBackOrderedText();
    	}
    	mav = new ModelAndView(adminGiftReceivedBackOrderViewDetails);
    	mav.addObject(cbIndividualProductName, ftIndividualProductsName);
    	mav.addObject(cbIndividualProductStore, ftIndividualProductsStore);
        mav.addObject(cbIndividualProductHeading, ftIndividualProductsHeading);
    	mav.addObject(cbIndividualProductQuantity, ftIndividualProductsQuantity);
    	mav.addObject(cbIndividualProductPrice, ftIndividualProductsPrice);
        mav.addObject(cbIndividualProductLink, ftIndividualProductsLink);
        mav.addObject(cbBackOrderedText, backOrderedText);
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRConBoardsBackInStockStatusUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRFinTouchesBackInStockStatusUpdateInDB(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);
    	}    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);    		
    		guestCBIndividualPaymentSavingModel.setStatus(null);
    		guestCBIndividualPaymentSavingModel.setIndividualStatus(indNoActionStatusRef);
    		guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);   		
    	} else if((regIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setStatus(null);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(indNoActionStatusRef);    		
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setContributedStatus(indNoActionStatusRef);
    		regCBContributedSavingModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
    		registryCBGRContributedPaymentDateColumnsUpdate(req, sn, indNoActionStatusRef, null, cbIndividualPaymentSavingId, currentDate);
    		guestCBGRContributedPaymentDateColumnsUpdate(req, sn, indNoActionStatusRef, null, cbIndividualPaymentSavingId, currentDate);
    	}
    	mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);    		
    		guestFTIndividualPaymentSavingModel.setStatus(null);
    		guestFTIndividualPaymentSavingModel.setIndividualStatus(indNoActionStatusRef);
    		guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);   		
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTIndividualPaymentSavingModel.setStatus(null);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(indNoActionStatusRef);    		
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTContributedSavingModel.setContributedStatus(indNoActionStatusRef);
    		regFTContributedSavingModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
    		registryFTGRContributedPaymentDateColumnsUpdate(req, sn, indNoActionStatusRef, null, ftIndividualPaymentSavingId, currentDate);
    		guestFTGRContributedPaymentDateColumnsUpdate(req, sn, indNoActionStatusRef, null, ftIndividualPaymentSavingId, currentDate);
    	}
    	mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGiftsReceivedConBoardsOutOfStockStatusUpdate(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGiftsReceivedFinTouchesOutOfStockStatusUpdate(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedShipNowData(req, sn);
    	}  	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(bothCBAndFTRefName, req.getParameter(bothCBAndFTRefName));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedConBoardsOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		guestCBIndividualPaymentSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		guestCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);
    		int regGivenQuantity = guestCBIndividualPaymentSavingModel.getGiftedQuantity();
			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId(), guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			regCBIndividualProductSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
//			double guestIndividualAmountDb = guestCustomGiftCardPriceUsingCode(req, sn, guestCBIndividualPaymentSavingModel.getRegistrantUserId(), totalRegProductPrice);
			registrantCustomGiftCardGenerationForRegistrant(req, sn, guestCBIndividualPaymentSavingModel.getRegistrantUserId(), totalWithTaxValue);			
			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId(), guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
			GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestCBIndividualPaymentSavingModel.getGuestUserPaymentInfoSavingId());
			adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), regCBIndividualUpdateModel.getProductName());			
    	} else if((regIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		regCBIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);
    		int regGivenQuantity = regCBIndividualPaymentSavingModel.getGiftedQuantity();
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(regCBIndividualPaymentSavingModel.getRegistrantUserId(), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		regCBIndividualProductSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
//			double individualAmountDb = registryCustomGiftCardPriceUsingCode(req, sn, regCBIndividualPaymentSavingModel.getRegistrantUserId(), totalRegProductPrice, regCBIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, regCBIndividualPaymentSavingModel.getRegistrantUserId(), totalWithTaxValue);			
			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB(regCBIndividualPaymentSavingModel.getRegistrantUserId(), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBIndividualPaymentSavingModel.getRegistrantUserId());
			RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regCBIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), regCBIndividualUpdateModel.getProductName());			
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setContributedStatus(indOutOfStockStatusRef);
			regCBContributedSavingModel.setUpdatedDate(currentDate);
			registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
			double myAccountContributedPrice = myAccountCotributedPriceCaliculation(req, sn, regCBContributedSavingModel.getRegistrantUserId(), cbIndividualPaymentSavingId);
    		registryCBGRContributedPaymentColumnsUpdate(req, sn, indOutOfStockStatusRef, cbIndividualPaymentSavingId, currentDate);
    		guestCBGRContributedPaymentColumnsUpdate(req, sn, indOutOfStockStatusRef, cbIndividualPaymentSavingId, currentDate);
//    		double contributedPrice = Double.parseDouble(regCBContributedSavingModel.getContributedPrice());
//			double remainingTotalPrice = Double.parseDouble(regCBContributedSavingModel.getRemainingTotalPrice());
//			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
//			RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusTakeFromDB(regCBContributedSavingModel.getRegistrantUserId(), cbIndividualPaymentSavingId);
//			double contributedAmountDb = registryCustomGiftCardPriceUsingCode(req, sn, regCBContributedSavingModel.getRegistrantUserId(), totalGiftedPrice, regCBContributedPaymentModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, regCBContributedSavingModel.getRegistrantUserId(), myAccountContributedPrice);
			adminGiftReceivedOutOfStockEmailSendingDataHold(req, sn, regCBContributedSavingModel.getRegistrantUserId(), cbIndividualPaymentSavingId, regCBContributedSavingModel.getProductName());
    	}
    	mav = adminGiftsReceivedOutOfStockDataDisplay(req, sn);    	
        return mav;
    }

    public String adminGiftReceivedOutOfStockEmailSendingDataHold(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualPaymentSavingId, String productName) {
    	String adminCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBGiftReceivedContributedPaymentInfoList(cbIndividualPaymentSavingId);
    	if (!regCBContributedPaymentList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusTakeFromDB(registrantUserId, cbIndividualPaymentSavingId);
    		RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regCBContributedPaymentModel.getRegistrantPaymentInfoSavingId());
    		adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), productName);
    	}
    	List<GuestConceptBoardsContributedPaymentSaving> guestCBContributedPaymentList = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentInfoList(cbIndividualPaymentSavingId);
    	if (!guestCBContributedPaymentList.isEmpty()) {
    		GuestConceptBoardsContributedPaymentSaving guestCBContributedPaymentModel = guestConceptBoardsContributedPaymentSavingDAO.guestCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestCBContributedPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), productName);
    	}
		return adminCartPaymentReff;
	}

    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedFinTouchesOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		guestFTIndividualPaymentSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		guestFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		guestFinishingTouchesIndividualPaymentSavingDAO.merge(guestFTIndividualPaymentSavingModel);
    		int regGivenQuantity = guestFTIndividualPaymentSavingModel.getGiftedQuantity();
			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId(), guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			regFTIndividualProductSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
//			double guestIndividualAmountDb = guestCustomGiftCardPriceUsingCode(req, sn, guestFTIndividualPaymentSavingModel.getRegistrantUserId(), totalRegProductPrice);
			registrantCustomGiftCardGenerationForRegistrant(req, sn, guestFTIndividualPaymentSavingModel.getRegistrantUserId(), totalWithTaxValue);			
			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId(), guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
			GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestFTIndividualPaymentSavingModel.getGuestUserPaymentInfoSavingId());
			adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), regFTIndividualUpdateModel.getProductName());			
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTIndividualPaymentSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		regFTIndividualPaymentSavingModel.setRefferanceDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualPaymentSavingModel);
    		int regGivenQuantity = regFTIndividualPaymentSavingModel.getGiftedQuantity();
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(regFTIndividualPaymentSavingModel.getRegistrantUserId(), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		regFTIndividualProductSavingModel.setIndividualStatus(indOutOfStockStatusRef);
    		registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualProductSavingModel);
    		double regProductPriceStDb = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());			
			double totalRegProductPrice = regProductPriceStDb * regGivenQuantity;
			double totalWithTaxValue = totalRegProductPrice + (totalRegProductPrice/100)*18;
//			double individualAmountDb = registryCustomGiftCardPriceUsingCode(req, sn, regFTIndividualPaymentSavingModel.getRegistrantUserId(), totalRegProductPrice, regFTIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, regFTIndividualPaymentSavingModel.getRegistrantUserId(), totalWithTaxValue);			
			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB(regFTIndividualPaymentSavingModel.getRegistrantUserId(), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
			RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTIndividualPaymentSavingModel.getRegistrantUserId());
			RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regFTIndividualPaymentSavingModel.getRegistrantPaymentInfoSavingId());
			adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), regFTIndividualUpdateModel.getProductName());			
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		regFTContributedSavingModel.setContributedStatus(indOutOfStockStatusRef);
			regFTContributedSavingModel.setUpdatedDate(currentDate);
			registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedSavingModel);
			double myAccountContributedPrice = myAccountCotributedPriceCaliculation(req, sn, regFTContributedSavingModel.getRegistrantUserId(), ftIndividualPaymentSavingId);
    		registryFTGRContributedPaymentColumnsUpdate(req, sn, indOutOfStockStatusRef, ftIndividualPaymentSavingId, currentDate);
    		guestFTGRContributedPaymentColumnsUpdate(req, sn, indOutOfStockStatusRef, ftIndividualPaymentSavingId, currentDate);
//    		double contributedPrice = Double.parseDouble(regFTContributedSavingModel.getContributedPrice());
//			double remainingTotalPrice = Double.parseDouble(regFTContributedSavingModel.getRemainingTotalPrice());
//			double totalGiftedPrice = contributedPrice - remainingTotalPrice;
//			RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusTakeFromDB(regFTContributedSavingModel.getRegistrantUserId(), ftIndividualPaymentSavingId);
//			double contributedAmountDb = registryCustomGiftCardPriceUsingCode(req, sn, regFTContributedSavingModel.getRegistrantUserId(), totalGiftedPrice, regFTContributedPaymentModel.getRegistrantPaymentInfoSavingId());
			registrantCustomGiftCardGenerationForRegistrant(req, sn, regFTContributedSavingModel.getRegistrantUserId(), myAccountContributedPrice);
			adminGiftReceivedFinTouchesOutOfStockEmailSendingDataHold(req, sn, regFTContributedSavingModel.getRegistrantUserId(), ftIndividualPaymentSavingId, regFTContributedSavingModel.getProductName());
    	}
    	mav = adminGiftsReceivedOutOfStockDataDisplay(req, sn);    	
        return mav;
    }

    public String adminGiftReceivedFinTouchesOutOfStockEmailSendingDataHold(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualPaymentSavingId, String productName) {
    	String adminCartPaymentReff = null;
    	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(registrantUserId);
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTGiftReceivedContributedPaymentInfoList(ftIndividualPaymentSavingId);
    	if (!regFTContributedPaymentList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusTakeFromDB(registrantUserId, ftIndividualPaymentSavingId);
    		RegistrantPaymentInfoSaving regiUserInfoSavingModel = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regFTContributedPaymentModel.getRegistrantPaymentInfoSavingId());
    		adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), regiUserInfoSavingModel.getTransactionNumber(), productName);
    	}
    	List<GuestFinishingTouchesContributedPaymentSaving> guestFTContributedPaymentList = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentInfoList(ftIndividualPaymentSavingId);
    	if (!guestFTContributedPaymentList.isEmpty()) {
    		GuestFinishingTouchesContributedPaymentSaving guestFTContributedPaymentModel = guestFinishingTouchesContributedPaymentSavingDAO.guestFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		GuestUserPaymentInfoSaving guestUserInfoSavingModel = guestUserPaymentInfoSavingDAO.guestUserFirstNameInfoTakingFromDB(guestFTContributedPaymentModel.getGuestUserPaymentInfoSavingId());
    		adminGiftReceivedOutOfStockEmailSendToRegistrant(req, sn, regInfoSavingModel.getRegUserName(), regInfoSavingModel.getRegFirstName(), guestUserInfoSavingModel.getTransactionNumber(), productName);
    	}
		return adminCartPaymentReff;
	}

	public String adminGiftReceivedOutOfStockEmailSendToRegistrant(HttpServletRequest req, HttpSession sn, String shopUserEmail, String userFullName, long orderNumber, String productName) {
	  	String shopCartPaymentReff = null;
	  	String[] emailList = {shopUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
	  	String subject = "A Product Is Out Of Stock";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We have been notified by the vendor that the <b>" + productName + "</b> from Order Number: <b>" + orderNumber + "</b> is out-of-stock.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>Since this product is out-of-stock, the total value of the gift is converted into Nook+Cove store credit. You can access your store credit totals and unique store credit code under the 'Store Credit' tab under 'My Account'.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>The store credit never expires and can be used towards any physical product on the site. Please note that for any out-of-stock products, our designers are always on the hunt for great replacements and are constantly updating our design boards! We recommend you check back to your favorite design boards for updates and product replacements.</p>"
                + "<p style='margin-top: 30px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>We appreciate and thank you for your patience and understanding on this matter.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin gift received back ordered date email send to registrant failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
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
        return myAccountContributedPrice;
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
    
    @Override
    @Transactional
    public ModelAndView adminGiftsReceivedOutOfStockDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> cbIndividualPaymentSavingList = new ArrayList<RegistrantConceptBoardsIndividualProductsInfoSaving>();    	
    	int guestCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indOutOfStockStatusRef);
    	int regContCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size();
    	double guestCBIndGiftRecivedPrice = guestAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOutOfStockStatusRef, guestCBIndividualSavingList, guestCount);
    	double regCBIndGiftRecivedPrice = registryAdminCBIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOutOfStockStatusRef, regCBIndividualSavingList, guestCBIndividualSavingList.size());    	
    	double regCBContGiftRecivedPrice = guestAndRegistryAdminCBContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOutOfStockStatusRef, regCBContributedSavingList, regContCount);
    	
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indOutOfStockStatusRef);
      	int guestFTIndCount = regContCount + regCBContributedSavingList.size();
    	int regFTIndCount = guestFTIndCount + guestFTIndividualSavingList.size();
    	int regGusFTContCount = regFTIndCount + regFTIndividualSavingList.size();
    	double guestFTIndGiftRecivedPrice = guestAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOutOfStockStatusRef, guestFTIndividualSavingList, guestFTIndCount);
    	double regFTIndGiftRecivedPrice = registryAdminFTIndividualGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOutOfStockStatusRef, regFTIndividualSavingList, regFTIndCount);
    	double regFTContGiftRecivedPrice = guestAndRegistryAdminFTContributedGiftReceivedDataDisplay(req, sn, cbIndividualPaymentSavingList, indOutOfStockStatusRef, regFTContributedSavingList, regGusFTContCount);
    	
    	double cbIndividualProductPrice = guestCBIndGiftRecivedPrice + regCBIndGiftRecivedPrice + regCBContGiftRecivedPrice + guestFTIndGiftRecivedPrice + regFTIndGiftRecivedPrice + regFTContGiftRecivedPrice;
      	int totalProductCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
      	int grNoActionCount = adminGiftsReceivedNoActionCount(req, sn);
    	int grOrderProcessingCount = adminGiftsReceivedOrderProcessingCount(req, sn);
    	int grOrderedCount = adminGiftsReceivedOrderedCount(req, sn);
    	int grTrackingCount = adminGiftsReceivedTrackingCount(req, sn);
    	int grDeliveredCount = adminGiftsReceivedDeliveredCount(req, sn);
    	int grBackOrderedCount = adminGiftsReceivedBackOrderedCount(req, sn);
    	int grCTStoreCreditCount = adminGiftsReceivedCTStoreCreditCount(req, sn);
    	if (totalProductCount > 0) {
    		String cbIndiProductTotalAmount = String.format("%,.2f", cbIndividualProductPrice);
    		mav = new ModelAndView(adminRegGiftReceivedOutOfStockDisplay);
    		mav.addObject(giftReceivedStatus, adminNoGiftReceived);
    		mav.addObject("totalCBGiftReceivedOutOfStockDataList", cbIndividualPaymentSavingList);
            mav.addObject(totalGRProductsCount, totalProductCount);
    		mav.addObject(totalGRProductAmount, cbIndiProductTotalAmount);
    	} else {
    		mav = new ModelAndView(adminRegGiftReceivedOutOfStockDisplay);    		    		   		
    	}
    	mav.addObject(giftRecNoActionCount, grNoActionCount);
    	mav.addObject(giftRecOrderProcessingCount, grOrderProcessingCount);
    	mav.addObject(giftRecOrderedCount, grOrderedCount);
    	mav.addObject(giftRecTrackingCount, grTrackingCount);
    	mav.addObject(giftRecDeliveredCount, grDeliveredCount);
    	mav.addObject(giftRecBackOrderedCount, grBackOrderedCount);
    	mav.addObject(giftRecOutOfStockCount, totalProductCount);
    	mav.addObject(giftRecCTStoreCreditCount, grCTStoreCreditCount);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftReceivedOutOfStockViewDetails(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRConBoardsOutOfStockViewDetails(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(giftReceivedManagementList[2])) {
    		mav = adminGRFinTouchesOutOfStockViewDetails(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedOutOfStockDataDisplay(req, sn);
    	}
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(bothCBAndFTRefName, giftReceivedManagementList[2]);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsOutOfStockViewDetails(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef) {
    	ModelAndView mav;
    	String cbIndividualProductsName = null;
    	String cbIndividualProductsStore = null;
    	String cbIndividualProductsHeading = null;
    	String cbIndividualProductsQuantity = null;
    	String cbIndividualProductsPrice = null;
    	String cbIndividualProductsLink = null;
    	String registrantsFullName = null;
    	String registrantsShippingAddress = null;
    	String registrantsApartment = null;
    	String registrantsCity = null;
    	String registrantsState = null;
    	String registrantsZip = null;
    	String registrantsPhoneNumber = null;
    	String registrantsEmail = null;    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(guestCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestCBIndividualPaymentSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regCBIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regCBIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(guestCBIndividualPaymentSavingModel.getGiftedQuantity());
    		double productPrice = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());
    		cbIndividualProductsPrice = "$" + String.format("%,.2f", productPrice);
    		cbIndividualProductsLink = regCBIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();    		
    	} else if((regIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataForAdminGiftReceived(regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regCBIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBIndividualPaymentSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regCBIndividualProductSavingModel.getProductName();
    		cbIndividualProductsStore = regCBIndividualProductSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBIndividualProductSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = String.valueOf(regCBIndividualPaymentSavingModel.getGiftedQuantity());
    		double productPrice = Double.parseDouble(regCBIndividualProductSavingModel.getProductPrice());
    		cbIndividualProductsPrice = "$" + String.format("%,.2f", productPrice);
    		cbIndividualProductsLink = regCBIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regCBContributedSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regCBContributedSavingModel.getRegistrantUserId());
            cbIndividualProductsName = regCBContributedSavingModel.getProductName();
    		cbIndividualProductsStore = regCBContributedSavingModel.getStoreName();
    		cbIndividualProductsHeading = regCBContributedSavingModel.getProductHeading();
    		cbIndividualProductsQuantity = null;
    		double contributedPrice = Double.parseDouble(regCBContributedSavingModel.getContributedPrice());
    		cbIndividualProductsPrice = "$" + String.format("%,.2f", contributedPrice);
    		cbIndividualProductsLink = regCBContributedSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	}
    	mav = new ModelAndView(adminGiftReceivedOutOfStockViewDetails);
    	mav.addObject(cbIndividualProductName, cbIndividualProductsName);
    	mav.addObject(cbIndividualProductStore, cbIndividualProductsStore);
        mav.addObject(cbIndividualProductHeading, cbIndividualProductsHeading);
    	mav.addObject(cbIndividualProductQuantity, cbIndividualProductsQuantity);
    	mav.addObject(cbIndividualProductPrice, cbIndividualProductsPrice);
        mav.addObject(cbIndividualProductLink, cbIndividualProductsLink);        
        mav.addObject(registrantFullName, registrantsFullName);
        mav.addObject(registrantShippingAddress, registrantsShippingAddress);
        mav.addObject(registrantApartment, registrantsApartment);
        mav.addObject(registrantCity, registrantsCity);
        mav.addObject(registrantState, registrantsState);
        mav.addObject(registrantZip, registrantsZip);
        mav.addObject(registrantPhoneNumber, registrantsPhoneNumber);
        mav.addObject(registrantEmail, registrantsEmail);
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesOutOfStockViewDetails(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;
    	String ftIndividualProductsName = null;
    	String ftIndividualProductsStore = null;
    	String ftIndividualProductsHeading = null;
    	String ftIndividualProductsQuantity = null;
    	String ftIndividualProductsPrice = null;
    	String ftIndividualProductsLink = null;
    	String registrantsFullName = null;
    	String registrantsShippingAddress = null;
    	String registrantsApartment = null;
    	String registrantsCity = null;
    	String registrantsState = null;
    	String registrantsZip = null;
    	String registrantsPhoneNumber = null;
    	String registrantsEmail = null;    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(guestFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestFTIndividualPaymentSavingModel.getRegistrantUserId());
            ftIndividualProductsName = regFTIndividualProductSavingModel.getProductName();
    		ftIndividualProductsStore = regFTIndividualProductSavingModel.getStoreName();
    		ftIndividualProductsHeading = regFTIndividualProductSavingModel.getProductHeading();
    		ftIndividualProductsQuantity = String.valueOf(guestFTIndividualPaymentSavingModel.getGiftedQuantity());
    		double productPrice = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());
    		ftIndividualProductsPrice = "$" + String.format("%,.2f", productPrice);
    		ftIndividualProductsLink = regFTIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();    		
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataForAdminGiftReceived(regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regFTIndividualPaymentSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTIndividualPaymentSavingModel.getRegistrantUserId());
            ftIndividualProductsName = regFTIndividualProductSavingModel.getProductName();
    		ftIndividualProductsStore = regFTIndividualProductSavingModel.getStoreName();
    		ftIndividualProductsHeading = regFTIndividualProductSavingModel.getProductHeading();
    		ftIndividualProductsQuantity = String.valueOf(regFTIndividualPaymentSavingModel.getGiftedQuantity());
    		double productPrice = Double.parseDouble(regFTIndividualProductSavingModel.getProductPrice());
    		ftIndividualProductsPrice = "$" + String.format("%,.2f", productPrice);
    		ftIndividualProductsLink = regFTIndividualProductSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		RegistrantShippingInfoSaving regiShippingInfoSavingModel = registrantShippingInfoSavingDAO.updatedShippingAddressRowInDataBasa(regFTContributedSavingModel.getRegistrantUserId());
    		RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regFTContributedSavingModel.getRegistrantUserId());
            ftIndividualProductsName = regFTContributedSavingModel.getProductName();
    		ftIndividualProductsStore = regFTContributedSavingModel.getStoreName();
    		ftIndividualProductsHeading = regFTContributedSavingModel.getProductHeading();
    		ftIndividualProductsQuantity = null;
    		double contributedPrice = Double.parseDouble(regFTContributedSavingModel.getContributedPrice());
    		ftIndividualProductsPrice = "$" + String.format("%,.2f", contributedPrice);
    		ftIndividualProductsLink = regFTContributedSavingModel.getStoreUrl();    		
    		registrantsFullName = regiShippingInfoSavingModel.getRegistrantFullNname();
    		registrantsShippingAddress = regiShippingInfoSavingModel.getShippingAddress();
    		registrantsApartment = regiShippingInfoSavingModel.getApartment();
    		registrantsCity = regiShippingInfoSavingModel.getCity();
    		registrantsState = regiShippingInfoSavingModel.getState();
    		registrantsZip = regiShippingInfoSavingModel.getZip();
    		registrantsPhoneNumber = regiShippingInfoSavingModel.getPhoneNumber();
    		registrantsEmail = regInfoSavingModel.getRegUserName();
    	}
    	mav = new ModelAndView(adminGiftReceivedOutOfStockViewDetails);
    	mav.addObject(cbIndividualProductName, ftIndividualProductsName);
    	mav.addObject(cbIndividualProductStore, ftIndividualProductsStore);
        mav.addObject(cbIndividualProductHeading, ftIndividualProductsHeading);
    	mav.addObject(cbIndividualProductQuantity, ftIndividualProductsQuantity);
    	mav.addObject(cbIndividualProductPrice, ftIndividualProductsPrice);
        mav.addObject(cbIndividualProductLink, ftIndividualProductsLink);        
        mav.addObject(registrantFullName, registrantsFullName);
        mav.addObject(registrantShippingAddress, registrantsShippingAddress);
        mav.addObject(registrantApartment, registrantsApartment);
        mav.addObject(registrantCity, registrantsCity);
        mav.addObject(registrantState, registrantsState);
        mav.addObject(registrantZip, registrantsZip);
        mav.addObject(registrantPhoneNumber, registrantsPhoneNumber);
        mav.addObject(registrantEmail, registrantsEmail);
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    public int adminGiftsReceivedNoActionCount(HttpServletRequest req, HttpSession sn) {
    	int grNoActionCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indNoActionStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indNoActionStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indNoActionStatusRef);
    	grNoActionCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grNoActionCount;
    }

    public int adminGiftsReceivedOrderProcessingCount(HttpServletRequest req, HttpSession sn) {
    	int grOrderProcessingCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indOrderProcessingStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderProcessingStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indOrderProcessingStatusRef);
    	grOrderProcessingCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grOrderProcessingCount;
    }

    public int adminGiftsReceivedOrderedCount(HttpServletRequest req, HttpSession sn) {
    	int grOrderedCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indOrderedStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indOrderedStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indOrderedStatusRef);
    	grOrderedCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grOrderedCount;
    }

    public int adminGiftsReceivedTrackingCount(HttpServletRequest req, HttpSession sn) {
    	int grTrackingCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indTrackingStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indTrackingStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indTrackingStatusRef);
    	grTrackingCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grTrackingCount;
    }

    public int adminGiftsReceivedDeliveredCount(HttpServletRequest req, HttpSession sn) {
    	int grDeliveredCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indDeliveredStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indDeliveredStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indDeliveredStatusRef);
    	grDeliveredCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grDeliveredCount;
    }

    public int adminGiftsReceivedBackOrderedCount(HttpServletRequest req, HttpSession sn) {
    	int grBackOrderedCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indBOTillDateStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indBOTillDateStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indBOTillDateStatusRef);
    	grBackOrderedCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grBackOrderedCount;
    }

    public int adminGiftsReceivedOutOfStockCount(HttpServletRequest req, HttpSession sn) {
    	int grOutOfStockCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(indOutOfStockStatusRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(indOutOfStockStatusRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(indOutOfStockStatusRef);
    	grOutOfStockCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grOutOfStockCount;
    }

    public int adminGiftsReceivedCTStoreCreditCount(HttpServletRequest req, HttpSession sn) {
    	int grCTStoreCreditCount = 0;
    	List<GuestConceptBoardsIndividualPaymentSaving> guestCBIndividualSavingList = guestConceptBoardsIndividualPaymentSavingDAO.guestAdminCBIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryAdminCBIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedSavingList = registrantConceptBoardsContributedProductsInfoSavingDAO.guestRegAdminCBContributedGiftReceivedData(individualCTSCRef);
    	List<GuestFinishingTouchesIndividualPaymentSaving> guestFTIndividualSavingList = guestFinishingTouchesIndividualPaymentSavingDAO.guestAdminFTIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryAdminFTIndividualGiftReceivedDataTakeFromDB(individualCTSCRef);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedSavingList = registrantFinishingTouchesContributedProductsInfoSavingDAO.guestRegAdminFTContributedGiftReceivedData(individualCTSCRef);
    	grCTStoreCreditCount = guestCBIndividualSavingList.size() + regCBIndividualSavingList.size() + regCBContributedSavingList.size() + guestFTIndividualSavingList.size() + regFTIndividualSavingList.size() + regFTContributedSavingList.size();
    	return grCTStoreCreditCount;
    }

    @Override
    @Transactional
    public ModelAndView adminGRBackOrderModifyDateDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	if((consBoardsRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGRConBoardsBackOrderModifyDateDisplay(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else if((finiTouchesRefName).equals(req.getParameter(bothCBAndFTRefName))) {
    		mav = adminGRFinTouchesBackOrderModifyDateDisplay(req, sn, cbIndividualPaymentSavingId, giftReceivedManagementList[1]);
    	} else {
    		mav = adminGiftsReceivedBackOrderedDataDisplay(req, sn);
    	}   	  	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(bothCBAndFTRefName, req.getParameter(bothCBAndFTRefName));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRConBoardsBackOrderModifyDateDisplay(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef) {
    	ModelAndView mav;
    	String backOrderDate = null;    	
    	if((gusetIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		backOrderDate = guestCBIndividualPaymentSavingModel.getStatus();
    	} else if((regIndConBoardsReff).equals(typeOfConBoardsRef)) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		backOrderDate = regCBIndividualPaymentSavingModel.getStatus();
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		backOrderDate = regCBContributedSavingModel.getStatus();
    	}
    	mav = new ModelAndView(adminGiftReceivedBackOrdModifyDate);    	
        mav.addObject(backOrderDateDisplay, backOrderDate);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRFinTouchesBackOrderModifyDateDisplay(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef) {
    	ModelAndView mav;
    	String backOrderDate = null;    	
    	if((gusetIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		GuestFinishingTouchesIndividualPaymentSaving guestFTIndividualPaymentSavingModel = guestFinishingTouchesIndividualPaymentSavingDAO.guestFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		backOrderDate = guestFTIndividualPaymentSavingModel.getStatus();
    	} else if((regIndFinTouchesReff).equals(typeOfFinTouchesRef)) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTGiftReceivedIndividualPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		backOrderDate = regFTIndividualPaymentSavingModel.getStatus();
    	} else {
    		RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFTGiftReceivedContributedPaymentDataTakeFromDB(ftIndividualPaymentSavingId);
    		backOrderDate = regFTContributedSavingModel.getStatus();
    	}
    	mav = new ModelAndView(adminGiftReceivedBackOrdModifyDate);    	
        mav.addObject(backOrderDateDisplay, backOrderDate);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGRBackOrderTextUpdateDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftReceivedManagementSt = req.getParameter(giftReceivedManagementId);
    	String[] giftReceivedManagementList = giftReceivedManagementSt.split(", ");
    	long cbIndividualPaymentSavingId = Long.parseLong(giftReceivedManagementList[0]);
    	String admnBackOrderedText = req.getParameter("backOrderedText");
    	String admnBackOrderedTextSt = admnBackOrderedText.replaceAll("[\n\r]", " ");
    	if((gusetIndConBoardsReff).equals(giftReceivedManagementList[1])) {
    		GuestConceptBoardsIndividualPaymentSaving guestCBIndividualPaymentSavingModel = guestConceptBoardsIndividualPaymentSavingDAO.guestCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);    		
    		guestCBIndividualPaymentSavingModel.setBackOrderedText(admnBackOrderedTextSt);
    		guestConceptBoardsIndividualPaymentSavingDAO.merge(guestCBIndividualPaymentSavingModel);   		
    	} else if((regIndConBoardsReff).equals(giftReceivedManagementList[1])) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBGiftReceivedIndividualPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBIndividualPaymentSavingModel.setBackOrderedText(admnBackOrderedTextSt);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualPaymentSavingModel);
    	} else {
    		RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryCBGiftReceivedContributedPaymentDataTakeFromDB(cbIndividualPaymentSavingId);
    		regCBContributedSavingModel.setBackOrderedText(admnBackOrderedTextSt);
    		registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedSavingModel);
    	}
    	mav = adminGiftReceivedBackOrderViewDetails(req, sn);    	
        mav.addObject(giftReceivedManagementId, req.getParameter(giftReceivedManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRoomFundsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GuestRoomFundPaymentInfoSaving> roomFundsPaymentSavingList = new ArrayList<GuestRoomFundPaymentInfoSaving>();    	
    	int count = 0;
    	double totalRoomFundAmount = 0;
    	List<GuestRoomFundPaymentInfoSaving> guestPaymentRowList = guestRoomFundPaymentInfoSavingDAO.adminGuestOnlyCashFundsPaymentRowCheckingInDB();
    	if (!guestPaymentRowList.isEmpty()) { 
    		for (GuestRoomFundPaymentInfoSaving guestUserPaymentSavingModel : guestPaymentRowList) {
    			String guestSeleSpaceInfo = guestUserPaymentSavingModel.getGuestRoomCombValues();
    			String[] guestPaymentInfoSt = guestSeleSpaceInfo.split("__");
    			for(int p=0; p<guestPaymentInfoSt.length; p++) {
    				GuestRoomFundPaymentInfoSaving roomFundsPaymentSavingModel = new GuestRoomFundPaymentInfoSaving();
    				String[] guestOnlyRoomFundValue = guestPaymentInfoSt[p].split(",_,");    				
    				String guestFullName = guestUserFullNameForAdminTakeFromDB(req, sn, guestUserPaymentSavingModel.getGuestUserPaymentInfoSavingId());
        	    	String regiFullName = registryUserFullNameForAdminTakeFromDB(req, sn, guestUserPaymentSavingModel.getRegistrantUserId());
        	    	roomFundsPaymentSavingModel.setGuestEmail(guestOnlyRoomFundValue[1]);
        	    	roomFundsPaymentSavingModel.setRoomFundsPrice(guestOnlyRoomFundValue[2]);
        	    	roomFundsPaymentSavingModel.setCheckoutPaymentStatus(regiFullName);
        	    	roomFundsPaymentSavingModel.setStatus(guestFullName);
        	    	roomFundsPaymentSavingModel.setCreatedDate(guestUserPaymentSavingModel.getCreatedDate());
        	    	count = count + 1;
        	    	roomFundsPaymentSavingModel.setTotalAmount(String.valueOf(count));
        	    	double roomFundPrice = Double.parseDouble(guestOnlyRoomFundValue[2]);
        	    	totalRoomFundAmount = totalRoomFundAmount + roomFundPrice;
        	    	roomFundsPaymentSavingList.add(roomFundsPaymentSavingModel);
    			} 
        	}
		}    	
    	List<RegistryRoomFundsPaymentInfoSaving> regRoomAndCashFundInfoList = registryRoomFundsPaymentInfoSavingDAO.adminRegistrantCashFundsPackageRowOnlyCheckingInDB();
    	if (!regRoomAndCashFundInfoList.isEmpty()) {        	
    		for (RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundSavingModel : regRoomAndCashFundInfoList) {
    			String registrantSeleSpaceInfo = regRoomAndCashFundSavingModel.getSelectedRoomFundsInfo();
    			String[] registrantPaymentInfoSt = registrantSeleSpaceInfo.split("__");
    			for(int q=0; q<registrantPaymentInfoSt.length; q++) {
    				GuestRoomFundPaymentInfoSaving roomFundsPaymentSavingModel = new GuestRoomFundPaymentInfoSaving();
    				String[] regOnlyRoomFundValue = registrantPaymentInfoSt[q].split(",_,");    				
    				String regiFullName = registryUserFullNameForAdminTakeFromDB(req, sn, regRoomAndCashFundSavingModel.getRegistrantUserId());
    				roomFundsPaymentSavingModel.setGuestEmail(regOnlyRoomFundValue[1]);
        	    	roomFundsPaymentSavingModel.setRoomFundsPrice(regOnlyRoomFundValue[2]);
        	    	roomFundsPaymentSavingModel.setCheckoutPaymentStatus(regiFullName);
        	    	roomFundsPaymentSavingModel.setStatus(regiFullName);
        	    	roomFundsPaymentSavingModel.setCreatedDate(regRoomAndCashFundSavingModel.getCreatedDate());
        	    	count = count + 1;
        	    	roomFundsPaymentSavingModel.setTotalAmount(String.valueOf(count));
        	    	double roomFundsPrice = Double.parseDouble(regOnlyRoomFundValue[2]);
        	    	totalRoomFundAmount = totalRoomFundAmount + roomFundsPrice;
        	    	roomFundsPaymentSavingList.add(roomFundsPaymentSavingModel);
    			}    			
        	}
		} 
        int totalRoomFundsCount = guestPaymentRowList.size() + regRoomAndCashFundInfoList.size();
        if (totalRoomFundsCount > 0) {
    		String adminTotalRoomFundAmount = String.format("%,.2f", totalRoomFundAmount);    		
    		mav = new ModelAndView(adminRoomFundsDataDisplay);
    		mav.addObject("roomFundsStatusRef", "Room Funds Data");
    		mav.addObject("totalRoomFundsDataSavingList", roomFundsPaymentSavingList);
            mav.addObject("totalRoomFundsCount", count);
    		mav.addObject("totalRoomFundsAmount", adminTotalRoomFundAmount);    		
    	} else {
    		mav = new ModelAndView(adminRoomFundsDataDisplay);    		    		   		
    	}    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    
	@Override
	@Transactional
	public Timestamp currentDate() {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
