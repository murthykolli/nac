package com.nookandcove.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.AddClientProductsToCartSavingDAO;
import com.nookandcove.dao.AdminAssignClientInfoToDesignerSavingDAO;
import com.nookandcove.dao.AdminDesignerMessageInfoSavingDAO;
import com.nookandcove.dao.ClientDesignerMessageInfoSavingDAO;
import com.nookandcove.dao.ClientInfoSavingDAO;
import com.nookandcove.dao.ClientPackageAndRenderingPaymentInfoSavingDAO;
import com.nookandcove.dao.ClientUploadedInspireImagesSavingDAO;
import com.nookandcove.dao.ClientUploadedSpaceImagesSavingDAO;
import com.nookandcove.dao.DesignerInfoSavingDAO;
import com.nookandcove.dao.FurnitureSpecsProductsAccPackSavingDAO;
import com.nookandcove.dao.FurnitureSpecsProductsFullRoomPackSavingDAO;
import com.nookandcove.dao.GiftInfoSavingDAO;
import com.nookandcove.dao.GuestRoomFundPaymentInfoSavingDAO;
import com.nookandcove.dao.PromoCodeInfoSavingDAO;
import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.dao.RegistrantPaymentInfoSavingDAO;
import com.nookandcove.dao.RegistryRoomFundsPaymentInfoSavingDAO;
import com.nookandcove.dao.ShoppingCartPaymentInfoSavingDAO;
import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.daoimpl.GiftInfoSavingDAOImpl;
import com.nookandcove.model.GiftInfoSaving;
import com.nookandcove.model.GuestRoomFundPaymentInfoSaving;
import com.nookandcove.model.PromoCodeInfoSaving;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.RegistrantPaymentInfoSaving;
import com.nookandcove.model.RegistryRoomFundsPaymentInfoSaving;
import com.nookandcove.model.ShoppingCartPaymentInfoSaving;
import com.nookandcove.model.AddClientProductsToCartSaving;
import com.nookandcove.model.AdminAssignClientInfoToDesignerSaving;
import com.nookandcove.model.AdminDesignerMessageInfoSaving;
import com.nookandcove.model.ClientDesignerMessageInfoSaving;
import com.nookandcove.model.ClientInfoSaving;
import com.nookandcove.model.ClientPackageAndRenderingPaymentInfoSaving;
import com.nookandcove.model.ClientUploadedInspireImagesSaving;
import com.nookandcove.model.ClientUploadedSpaceImagesSaving;
import com.nookandcove.model.DesignerInfoSaving;
import com.nookandcove.model.FurnitureSpecsProductsAccPackSaving;
import com.nookandcove.model.FurnitureSpecsProductsFullRoomPackSaving;
import com.nookandcove.model.UserInformation;
import com.nookandcove.service.AdminInfoSavingService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class AdminInfoSavingServiceImpl implements AdminInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminInfoSavingServiceImpl.class);
	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
	private String userIdInSn = "userIdInSn";
	private String mainAdminId = "mainAdminId";	
	private String newGiftCardsManagement = "newGiftCardsManagement";
	private String sentGiftCardsManagement = "sentGiftCardsManagement";
	private String adminClientRedirection = "adminClientRedirection";
	private String purchasesInfoRedirection = "purchasesInfoRedirection";
	private String purchasesViewOrderInfo = "purchasesViewOrderInfo";
	private String purchasesViewClientInfo = "purchasesViewClientInfo";
	private String clientDirectoryRedirection = "clientDirectoryRedirection";
	private String newDesignerClientsRedirection = "newDesignerClientsRedirection";
	private String designerDirectoryRedirection = "designerDirectoryRedirection";
	private String inactiveDesignersRedirection = "inactiveDesignersRedirection";
	private String inactiveDesignersProfileRed = "inactiveDesignersProfileRed";
	private String accountsInfoRedirection = "accountsInfoRedirection";	
	private String adminGiftCardDailyReport = "adminGiftCardDailyReport";
	private String adminGiftCardWeeklyReport = "adminGiftCardWeeklyReport";
	private String adminGiftCardMonthlyReport = "adminGiftCardMonthlyReport";
	private String adminGiftCardQuarterlyReport = "adminGiftCardQuarterlyReport";
	private String adminGiftCardYearlyReport = "adminGiftCardYearlyReport";		
	private String adminPackageDailyReport = "adminPackageDailyReport";
	private String adminPackageWeeklyReport = "adminPackageWeeklyReport";
	private String adminPackageMonthlyReport = "adminPackageMonthlyReport";
	private String adminPackageQuarterlyReport = "adminPackageQuarterlyReport";
	private String adminPackageYearlyReport = "adminPackageYearlyReport";
	private String adminRenderingDailyReport = "adminRenderingDailyReport";
	private String adminRenderingWeeklyReport = "adminRenderingWeeklyReport";
	private String adminRenderingMonthlyReport = "adminRenderingMonthlyReport";
	private String adminRenderingQuarterlyReport = "adminRenderingQuarterlyReport";
	private String adminRenderingYearlyReport = "adminRenderingYearlyReport";
	private String adminShoppingCartDailyReport = "adminShoppingCartDailyReport";
	private String adminShoppingCartWeeklyReport = "adminShoppingCartWeeklyReport";
	private String adminShoppingCartMonthlyReport = "adminShoppingCartMonthlyReport";
	private String adminShoppingCartQuarterlyReport = "adminShoppingCartQuarterlyReport";
	private String adminShoppingCartYearlyReport = "adminShoppingCartYearlyReport";	
	private String addNewDesignerRedirection = "addNewDesignerRedirection";
	private String promocodeRedirection = "promocodeRedirection";
	private String promocodeManagement = "promocodeManagement";
	private String promoCodeIdInSn = "promoCodeIdInSn";	
	private String clientInfoSavingIdInSn = "clientInfoSavingIdInSn";
	private String clientLoginIdInSn = "clientLoginIdInSn";
	private String designerInfoSavingIdInSn = "designerInfoSavingIdInSn";
	private String giftCardInfoSavingIdInSn = "giftCardInfoSavingIdInSn";
	private String giftCardsCount = "giftCardsCount";
	private String allGiftCardsCount = "allGiftCardsCount";
	private String packgePaymentCount = "packgePaymentCount";
	private String renderingPaymentCount = "renderingPaymentCount";
	private String giftCardsCountInSn = "giftCardsCountInSn";
	private String clientInfoSavingId = "clientInfoSavingId";
	private String designerInfoSavingId = "designerInfoSavingId";	
	private String adminClientAndDesignerMess = "adminClientAndDesignerMess";
	private String reDirAdminAndDesignerMes = "reDirAdminAndDesignerMes";
	private String promoCode = "promoCode";
	private String discount = "discount";
	private String promoNote = "promoNote";
	private String viewClientInfoDisplay = "viewClientInfoDisplay";	
	private String desnPersonalBio = "desnPersonalBio";
	private String desnLocation = "desnLocation";
	private String desnCredential = "desnCredential";
	private String firstName = "firstName";
	private String lastName = "lastName";
	private String userName = "userName";
	private String phoneNumber = "phoneNumber";
	private String createPassword = "createPassword";	
	private String uploadPhForDes = "uploadPhForDes";
	private String uploadPhForDesCount = "uploadPhForDesCount";
	private String insUploadPhoto = "insUploadPhoto";
	private String insUploadPhotoCount = "insUploadPhotoCount";
	private String typeOfSpaceVal = "typeOfSpaceVal";
	private String typeOfStyleVal = "typeOfStyleVal";
	private String budgetVal = "budgetVal";
	private String designPackageVal = "designPackageVal";
	private String aboutSpaceDimnVal = "aboutSpaceDimnVal";
	private String typeOfColor = "typeOfColor";	
	private String likeOfColor = "likeOfColor";
	private String disLikeOfColor = "disLikeOfColor";
	private String otherItem = "otherItem";
	private String alreadyHaveItem = "alreadyHaveItem";
	private String artAppValue = "artAppValue";
	private String moreAboutSpace = "moreAboutSpace";
	private String shareInspiration = "shareInspiration";
	private String allItemsVal = "allItemsVal";
	private String designerProfileImage = "designerProfileImage";
	private String designerFullName = "designerFullName";
	private String designerUserInSn = "designerUserInSn";
	private String editDesignerProfileInfo = "editDesignerProfileInfo";
	private String newClientsCountInSn = "newClientsCountInSn";
	private String newClientsCount = "newClientsCount";
	private String purchasesItemsCountInSn = "purchasesItemsCountInSn";
	private String purchasesItemsCount = "purchasesItemsCount";	
	private String concept1UploadedImage = "concept1UploadedImage";
	private String concept2UploadedImage = "concept2UploadedImage";
	private String concept3UploadedImage = "concept3UploadedImage";
	private String likeImagesValues = "likeImagesValues";
	private String desnUploadedProducts1Count = "desnUploadedProducts1Count";
	private String desnUploadedProducts2Count = "desnUploadedProducts2Count";
	private String desnUploadedProducts3Count = "desnUploadedProducts3Count";
	private String desnUploadedProducts4Count = "desnUploadedProducts4Count";
	private String desnUploadedProducts5Count = "desnUploadedProducts5Count";
	private String designConceptsStatus = "designConceptsStatus";
	private String designRenderingStatus = "designRenderingStatus";	
	private String designSecRenderingStatus = "designSecRenderingStatus";
	private String uploadedSecRend1Image = "uploadedSecRend1Image";
	private String uploadedSecRend2Image = "uploadedSecRend2Image";	
	private String uploadedRmrend1Image = "uploadedRmrend1Image";
	private String uploadedRmrend2Image = "uploadedRmrend2Image";
	private String uploadedRevrend1Image = "uploadedRevrend1Image";
	private String uploadedRevrend2Image = "uploadedRevrend2Image";
	private String designRevRenderingStatus = "designRevRenderingStatus";	
	private String adminAppConceptStatus = "adminAppConceptStatus";
	private String adminAppRenderingsStatus = "adminAppRenderingsStatus";
	private String adminAppRevRenderingsStatus = "adminAppRevRenderingsStatus";
	private String adminAppSecRenderingsStatus = "adminAppSecRenderingsStatus";	
	private String viewProductImagesList = "viewProductImagesList";
	private String viewProductNamesList = "viewProductNamesList";
	private String viewProductQuantityList = "viewProductQuantityList";
	private String viewProductPriceList = "viewProductPriceList";
	private String viewProductDescriptionList = "viewProductDescriptionList";
	private String viewProductsIdList = "viewProductsIdList";
	private String desnSubmitConceptStatus = "desnSubmitConceptStatus";
	private String desnSubmitRenderingsStatus = "desnSubmitRenderingsStatus";
	private String adminMailSendReffInSn = "adminMailSendReffInSn";
	private String shopCartPaymentRefInSn = "shopCartPaymentRefInSn";	
	private String clientFullName = "clientFullName";
	private String shipAddress1 = "shipAddress1";
	private String shipAddress2 = "shipAddress2";
	private String shipCity = "shipCity";
	private String shipState = "shipState";
	private String shipZip = "shipZip";
	private String billAddress1 = "billAddress1";
	private String billAddress2 = "billAddress2";
	private String billCity = "billCity";
	private String billState = "billState";
	private String billZip = "billZip";
	private String cardType = "cardType";
	private String payCardNumber = "payCardNumber";
	private String payCvvNumber = "payCvvNumber";
	private String expDate = "expDate";
	private String secRenPaymentStatus = "secRenPaymentStatus";
	private String totalProdPriceInDB = "totalProdPriceInDB";
	private String viewAssemblyRequiredStatusList = "viewAssemblyRequiredStatusList";	
	private String newGiftCardsManagementForAccounts = "newGiftCardsManagementForAccounts";
	private String sentGiftCardsManagementForAccounts = "sentGiftCardsManagementForAccounts";
	private String viewGiftCardInfoForAccounts = "viewGiftCardInfoForAccounts";
	private String purchasesInfoRedForAccounts = "purchasesInfoRedForAccounts";
	private String packagePaymentForAccounts = "packagePaymentForAccounts";
	private String secRenderingPaymentForAccounts = "secRenderingPaymentForAccounts";
	private String adminMBNewImgDsp = "adminMBNewImgDsp";
	private String createSubAdminRedirection = "createSubAdminRedirection";
	private String adminChangePasswordRedirection = "adminChangePasswordRedirection";
	private String subAdminsListDisplay = "subAdminsListDisplay";
	private String createNewSubAdminRedirection = "createNewSubAdminRedirection";	
	private String fullRoomCount = "fullRoomCount";
	private String accPackageCount = "accPackageCount";
	private String totalGiftCards = "totalGiftCards";
	private String totalGiftAmount = "totalGiftAmount";
	private String usedGiftCardCount = "usedGiftCardCount";
	private String weekDaysCount = "weekDaysCount";
	private String weekEndsCount = "weekEndsCount";
	private String orderStatusCount = "orderStatusCount";
	private String deliveryStatusCount = "deliveryStatusCount";
	private String giftCardAmount = "giftCardAmount";
	private String adminGiftCardID = "adminGiftCardID";
		
	@Autowired
    private ClientInfoSavingDAO clientInfoSavingDAO;
	
	@Autowired
    private UserInformationDAO userInformationDAO;
	
	@Autowired
    private GiftInfoSavingDAOImpl giftInfoSavingDAOImpl;
	
	@Autowired
    private DesignerInfoSavingDAO designerInfoSavingDAO;
	
	@Autowired
    private AdminAssignClientInfoToDesignerSavingDAO adminAssignClientInfoToDesignerSavingDAO;

    @Autowired
    private ClientUploadedSpaceImagesSavingDAO clientUploadedSpaceImagesSavingDAO;
    
    @Autowired
    private ClientUploadedInspireImagesSavingDAO clientUploadedInspireImagesSavingDAO;
    
    @Autowired
    private ClientDesignerMessageInfoSavingDAO clientDesignerMessageInfoSavingDAO;

    @Autowired
    private AdminDesignerMessageInfoSavingDAO adminDesignerMessageInfoSavingDAO;

    @Autowired
    private PromoCodeInfoSavingDAO promoCodeInfoSavingDAO;    

    @Autowired
    private FurnitureSpecsProductsAccPackSavingDAO furnitureSpecsProductsAccPackSavingDAO;

    @Autowired
    private FurnitureSpecsProductsFullRoomPackSavingDAO furnitureSpecsProductsFullRoomPackSavingDAO;

    @Autowired
    private AddClientProductsToCartSavingDAO addClientProductsToCartSavingDAO;

    @Autowired
    private ShoppingCartPaymentInfoSavingDAO shoppingCartPaymentInfoSavingDAO;

    @Autowired
    private ClientPackageAndRenderingPaymentInfoSavingDAO clientPackageAndRenderingPaymentInfoSavingDAO;

	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;

    @Autowired
    private GuestRoomFundPaymentInfoSavingDAO guestRoomFundPaymentInfoSaving;

    @Autowired
    private RegistrantPaymentInfoSavingDAO registrantPaymentInfoSavingDAO;

	@Autowired
    private GiftInfoSavingDAO giftInfoSavingDAO;

    @Autowired
    private RegistryRoomFundsPaymentInfoSavingDAO registryRoomFundsPaymentInfoSavingDAO;
	
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
    public ModelAndView designProcessAndRegistryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView("designProcessAndRegistryRed");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
	
    @Override
    @Transactional
    public ModelAndView adminNewClientsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List<DesignerInfoSaving> designerIdsList = designerInfoSavingDAO.displayDesignerNameAndDateInNewClientsUsingStatus();    	
    	if (!designerIdsList.isEmpty()) {
    		List<DesignerInfoSaving> admnDesigSavingList = new ArrayList<DesignerInfoSaving>();    	
    		for (DesignerInfoSaving desnInfoLoop : designerIdsList) {
    		String desnName	= desnInfoLoop.getDesignerFullName();
    		Timestamp dateTimest = desnInfoLoop.getDesWaitingForClientDate();    		
    		String DateInStr = null;
    		if(null != dateTimest) {
    			DateInStr = new SimpleDateFormat("MM/dd/yy").format(dateTimest);
    		}    		
    		String selBoxVal = desnName + " - " + DateInStr;
    		desnInfoLoop.setDesignerFullName(selBoxVal);
    		admnDesigSavingList.add(desnInfoLoop);    		
    		}    		
    	}
    	List<ClientInfoSaving> selectedAdminRowIdList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<ClientInfoSaving> admnClientsSavingList = new ArrayList<ClientInfoSaving>();
            for (ClientInfoSaving myRoomInfoLoop : selectedAdminRowIdList) {
            	ClientInfoSaving myRoomInfoSavingModel = new ClientInfoSaving();
            	myRoomInfoSavingModel.setCreatedDate(myRoomInfoLoop.getCreatedDate());
            	String customerName = customerNameFromDB(myRoomInfoLoop.getUserId());
            	myRoomInfoSavingModel.setTypeOfStyle(customerName);
            	String typeOfSpace = myRoomInfoLoop.getTypeOfSpace();
            	typeOfSpace = typeOfSpace.replace("_", " ");
            	myRoomInfoSavingModel.setTypeOfSpace(typeOfSpace);                
                String desnPack = myRoomInfoLoop.getDesignPackage();
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}            	
            	myRoomInfoSavingModel.setDesignPackage(designPackage);
            	myRoomInfoSavingModel.setClientAskedDesignerName(myRoomInfoLoop.getClientAskedDesignerName());
            	myRoomInfoSavingModel.setClientInfoSavingId(myRoomInfoLoop.getClientInfoSavingId());
            	admnClientsSavingList.add(myRoomInfoSavingModel);
            }            
            mav = new ModelAndView(adminClientRedirection);
            mav.addObject("admNewClientsSavingList", admnClientsSavingList);
            mav.addObject("admnClientsCount", selectedAdminRowIdList.size());
            mav.addObject("desnFullName", designerIdsList);
        } else{
        	mav = amnDesignerDirectoryRedirection(req, sn);
        }
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        sn.setAttribute(newClientsCountInSn, selectedAdminRowIdList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(newClientsCount, selectedAdminRowIdList.size());        
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(adminMailSendReffInSn, null);            	
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView newClientsInfoSharingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView();    	
    	long clientInfoId = Long.parseLong(req.getParameter(clientInfoSavingId));
    	mav = newClientsDirectoryInfoUpdateInDB(req, sn, clientInfoId);    	    	    	
    	List<ClientInfoSaving> selectedAdminRowIdList = clientInfoSavingDAO.adminAssignClientInfoToDesignerUsingIdStatus();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<ClientInfoSaving> admnClientsSavingList = new ArrayList<ClientInfoSaving>();
            for (ClientInfoSaving myRoomInfoLoop : selectedAdminRowIdList) {
            	ClientInfoSaving myRoomInfoSavingModel = new ClientInfoSaving();
            	myRoomInfoSavingModel.setCreatedDate(myRoomInfoLoop.getCreatedDate());
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(myRoomInfoLoop.getUserId());            	
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName;            	
            	myRoomInfoSavingModel.setTypeOfStyle(fullName);            	        
            	String typeOfSpace = myRoomInfoLoop.getTypeOfSpace();
                typeOfSpace = typeOfSpace.replace("_", " ");
            	myRoomInfoSavingModel.setTypeOfSpace(typeOfSpace);                
                String desnPack = myRoomInfoLoop.getDesignPackage();
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}            	
            	myRoomInfoSavingModel.setDesignPackage(designPackage);
            	myRoomInfoSavingModel.setClientInfoSavingId(myRoomInfoLoop.getClientInfoSavingId());
            	long designerInfoId = myRoomInfoLoop.getDesignerInfoSavingId();
            	String designerFullName = null;
            	if(designerInfoId > 0){
            		DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoId);
            		designerFullName = designerInfoSaving.getDesignerFullName();
            		String adminMailSendReff = (String) sn.getAttribute(adminMailSendReffInSn);
            		if(!("Admin One Time Message Sent").equals(adminMailSendReff)) {
            			mav = adminAssignedNewClientMailSentToDesigner(req, sn, designerInfoId);
            		}            		
            	}            	
            	myRoomInfoSavingModel.setOtherItems(designerFullName);
            	admnClientsSavingList.add(myRoomInfoSavingModel);
            }            
            mav = new ModelAndView(clientDirectoryRedirection);
            mav.addObject("clientDirectorySavingList", admnClientsSavingList);
            mav.addObject("clientDirectoryListCount", selectedAdminRowIdList.size());
        } else{
        	mav = new ModelAndView(clientDirectoryRedirection);            
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView newClientsDirectoryInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long clientInfoId) {
    	ModelAndView mav;    	
    	List clientDirRowIdList = clientInfoSavingDAO.clientDirectoryRowChecking(clientInfoId);
        if (!clientDirRowIdList.isEmpty()) {
        	Timestamp currentDate = currentDate();
        	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
        	long desInfoSavingId = Long.parseLong(req.getParameter(designerInfoSavingId));
        	clientInfoSaving.setDesignerInfoSavingId(desInfoSavingId);
        	clientInfoSaving.setDesignerAssignedDate(currentDate);
        	clientInfoSavingDAO.merge(clientInfoSaving);        	
        	AdminAssignClientInfoToDesignerSaving aaciModel = new AdminAssignClientInfoToDesignerSaving();
        	aaciModel.setClientInfoSavingId(clientInfoId);
        	aaciModel.setDesignerInfoSavingId(desInfoSavingId);
        	aaciModel.setCreatedDate(currentDate);
        	adminAssignClientInfoToDesignerSavingDAO.save(aaciModel);        	
        	DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(desInfoSavingId);
        	designerInfoSaving.setDesWaitingForClientStatus(null);
        	designerInfoSaving.setDesWaitingForClientDate(null);
        	designerInfoSavingDAO.merge(designerInfoSaving);
        }
        mav = new ModelAndView();
        return mav;
    }

    @Override
    @Transactional    
    public ModelAndView adminAssignedNewClientMailSentToDesigner(HttpServletRequest req, HttpSession sn, long designerInfoId) {
    	ModelAndView mav;
        DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoId);
 	   	long designerUserId = designerInfoSaving.getDesignerId();
	 	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);        		
        String toAdd = userInformation.getUserName();
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "You have been assigned a new client!";            
        String type = "text/html";           
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";              
        String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                    + "<p style='padding-top: 5px;'>You have been assigned a new client. Make sure you reach out to them within 1 business day. Have fun designing!</p>"
                    + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                    + "<p style='padding-top: 5px;'>-Admin</p> <br/>"
                    + "</div>"
                    + "</body> ";            
        try {
        	userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
        	sn.setAttribute(adminMailSendReffInSn, "Admin One Time Message Sent");
        } catch (Exception ex) {
        	LOGGER.error("admin Assigned New Client Mail Sent To Designer failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView amnClientDirectoryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	        
    	List<ClientInfoSaving> selectedAdminRowIdList = clientInfoSavingDAO.adminAssignClientInfoToDesignerUsingIdStatus();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<ClientInfoSaving> admnClientsSavingList = new ArrayList<ClientInfoSaving>();
            for (ClientInfoSaving myRoomInfoLoop : selectedAdminRowIdList) {
            	ClientInfoSaving myRoomInfoSavingModel = new ClientInfoSaving();
            	myRoomInfoSavingModel.setCreatedDate(myRoomInfoLoop.getCreatedDate());
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(myRoomInfoLoop.getUserId());            	
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName;            	
            	myRoomInfoSavingModel.setTypeOfStyle(fullName);            	        
            	String typeOfSpace = myRoomInfoLoop.getTypeOfSpace();
                typeOfSpace = typeOfSpace.replace("_", " ");
            	myRoomInfoSavingModel.setTypeOfSpace(typeOfSpace);                
                String desnPack = myRoomInfoLoop.getDesignPackage();
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}            	
            	myRoomInfoSavingModel.setDesignPackage(designPackage);
            	myRoomInfoSavingModel.setClientInfoSavingId(myRoomInfoLoop.getClientInfoSavingId());
            	long designerInfoId = myRoomInfoLoop.getDesignerInfoSavingId();
            	String designerFullName = null;
            	if(designerInfoId > 0){
            		DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoId);
            		designerFullName = designerInfoSaving.getDesignerFullName();            		
            	}            	
            	myRoomInfoSavingModel.setOtherItems(designerFullName);
            	admnClientsSavingList.add(myRoomInfoSavingModel);
            }            
            mav = new ModelAndView(clientDirectoryRedirection);
            mav.addObject("clientDirectorySavingList", admnClientsSavingList);
            mav.addObject("clientDirectoryListCount", selectedAdminRowIdList.size());
        } else{
        	mav = amnDesignerDirectoryRedirection(req, sn);
        }
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView amnAssignedNewDesignerForClientsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	int count = 0;
    	List<DesignerInfoSaving> designerIdsList = designerInfoSavingDAO.displayDesignerNameAndDateInNewClientsUsingStatus();    	
    	if (!designerIdsList.isEmpty()) {
    		List<DesignerInfoSaving> admnDesigSavingList = new ArrayList<DesignerInfoSaving>();    	
    		for (DesignerInfoSaving desnInfoLoop : designerIdsList) {
    		String desnName	= desnInfoLoop.getDesignerFullName();
    		Timestamp dateTimest = desnInfoLoop.getDesWaitingForClientDate();    		
    		String DateInStr = null;
    		if(null != dateTimest) {
    			DateInStr = new SimpleDateFormat("MM/dd/yy").format(dateTimest);
    		}    		
    		String selBoxVal = desnName + " - " + DateInStr;
    		desnInfoLoop.setDesignerFullName(selBoxVal);
    		admnDesigSavingList.add(desnInfoLoop);    		
    		}    		
    	}
    	List<ClientInfoSaving> selectedAdminRowIdList = clientInfoSavingDAO.adminAssignClientInfoToDesignerUsingIdStatus();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<ClientInfoSaving> admnClientsSavingList = new ArrayList<ClientInfoSaving>();            
            for (ClientInfoSaving myRoomInfoLoop : selectedAdminRowIdList) {
            	ClientInfoSaving myRoomInfoSavingModel = new ClientInfoSaving();
            	myRoomInfoSavingModel.setCreatedDate(myRoomInfoLoop.getCreatedDate());
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(myRoomInfoLoop.getUserId());            	
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName;            	
            	myRoomInfoSavingModel.setTypeOfStyle(fullName);            	        
            	String typeOfSpace = myRoomInfoLoop.getTypeOfSpace();
                typeOfSpace = typeOfSpace.replace("_", " ");
            	myRoomInfoSavingModel.setTypeOfSpace(typeOfSpace);                
                String desnPack = myRoomInfoLoop.getDesignPackage();
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}            	
            	myRoomInfoSavingModel.setDesignPackage(designPackage);
            	myRoomInfoSavingModel.setClientInfoSavingId(myRoomInfoLoop.getClientInfoSavingId());
            	myRoomInfoSavingModel.setStatus(myRoomInfoLoop.getAdminAssiNewDesigner());
            	long designerInfoId = myRoomInfoLoop.getDesignerInfoSavingId();
            	String designerFullName = null;
            	if(("ASSIGNED").equals(myRoomInfoLoop.getAdminAssiNewDesigner())) {
            		count = count + 1;
            	}
            	if(designerInfoId > 0){
            		DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoId);
            		designerFullName = designerInfoSaving.getDesignerFullName();            		
            	}            	
            	myRoomInfoSavingModel.setOtherItems(designerFullName);
            	admnClientsSavingList.add(myRoomInfoSavingModel);
            }            
            mav = new ModelAndView(newDesignerClientsRedirection);
            mav.addObject("assNewDsnForclientsSavingList", admnClientsSavingList);
            mav.addObject("assNewDsnForclientsListCount", selectedAdminRowIdList.size());
            mav.addObject("desnFullName", designerIdsList);
        } else{
        	mav = amnDesignerDirectoryRedirection(req, sn);
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject("assiClientsCount", count);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminAssignedNewDesignerInfoSavingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoId = Long.parseLong(req.getParameter(clientInfoSavingId));
    	List clientDirRowIdList = clientInfoSavingDAO.clientDirectoryRowChecking(clientInfoId);    	
        if (!clientDirRowIdList.isEmpty()) {
        	Timestamp currentDate = currentDate();
        	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
        	long desInfoSavingId = Long.parseLong(req.getParameter(designerInfoSavingId));        	
        	clientInfoSaving.setDesignerInfoSavingId(desInfoSavingId);
        	clientInfoSaving.setDesignerAssignedDate(currentDate);
        	clientInfoSaving.setAdminAssiNewDesigner("ASSIGNED");
        	clientInfoSavingDAO.merge(clientInfoSaving);        	               
            String desnPack = clientInfoSaving.getDesignPackage();
            if(("Accessories Package").equals(desnPack)) {
        		furnitureSpecsProductsAccPackSavingDAO.updateAdminAccAssignedNewDesignerInfoInDB(clientInfoId, desInfoSavingId);
        	} else {
        		furnitureSpecsProductsFullRoomPackSavingDAO.updateAdminFullRmAssignedNewDesignerInfoInDB(clientInfoId, desInfoSavingId);
        	}        	
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.adminAssignedNewDesignerInfoUpdateInClient(clientInfoId);
        	adminAssignClInfoSaving.setDesignerInfoSavingId(desInfoSavingId);
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminAssignedNewClientMailSentToDesigner(req, sn, desInfoSavingId);
        	mav = adminAssignedNewDesignerForClientEmailSending(req, sn, clientInfoId);
        }    	       
    	mav = amnAssignedNewDesignerForClientsRedirection(req, sn);  	
    	return mav;
    }

    @Override
    @Transactional    
    public ModelAndView adminAssignedNewDesignerForClientEmailSending(HttpServletRequest req, HttpSession sn, long clientInfoId) {
    	ModelAndView mav;
    	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
    	long clientUserId = clientInfoSaving.getUserId();
   	 	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(clientUserId);        		
        String toAdd = userInformation.getUserName();
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "You have been assigned a new designer!";            
        String type = "text/html";           
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";              
        String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                    + "<p style='padding-top: 5px;'>You have been assigned a new designer.</p>"
                    + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                    + "<p style='padding-top: 5px;'>-Admin</p> <br/>"
                    + "</div>"
                    + "</body> ";            
        try {
        	userEmail.sendEmail(toAdd, subject, body, type, fromAdd);           	
        } catch (Exception ex) {
           	LOGGER.error("admin Assigned New Designer Mail Sent To Client failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView amnViewClientInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	String clientInfoDisplay = req.getParameter("clientInfoDisplay");
	    long clientInfoSavingIdLong = Long.parseLong(clientInfoDisplay);
	    ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoSavingIdLong);
	    long desInfoSavingIdLong = clientInfoSaving.getDesignerInfoSavingId();	    
    	String typeOfSpace = clientInfoSaving.getTypeOfSpace();
        typeOfSpace = typeOfSpace.replace("_", " ");
        String typeOfStyle = clientInfoSaving.getTypeOfStyle();
        String budget = clientInfoSaving.getBudget();
        String designPackage = clientInfoSaving.getDesignPackage();
        String aboutSpaceDimn = clientInfoSaving.getSpaceDimension();
        String typeOfColor1 = clientInfoSaving.getTypeOfColor();
        String likeOfColor1 = clientInfoSaving.getLikeColor();
        String disLikeOfColor1 = clientInfoSaving.getDislikeColor();        
        String typeOfItem = clientInfoSaving.getTypeOfItemsList();        
        String itemValueStr = null;
        if(null != typeOfItem) {
        	String[] typeOfItemList = typeOfItem.split(", ");
        	for(int i = 0; i < typeOfItemList.length; i++) {
        		if(!("undefined").equals(typeOfItemList[i]) && null != typeOfItemList[i]) {
        			itemValueStr = itemValueStr + ", " + typeOfItemList[i];
        		}
        	}
        	itemValueStr = itemValueStr.replaceFirst("null, ", "");
        }                
        String otherItem1 = clientInfoSaving.getOtherItems();
        String alreadyHaveItem1 = clientInfoSaving.getAlreadyHaveItems();
        String artValue = clientInfoSaving.getTypeOfArtAppeals();
        if(null != artValue) {
        	artValue = artValue.replace("_", " ");
        }        
        String moreAboutSpace1 = clientInfoSaving.getMoreAboutSpace();
        String shareInspiration1 = clientInfoSaving.getShareYourInspire();        
        DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(desInfoSavingIdLong);        	
        byte[] desProfileImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();
        String desProfileImage = javax.xml.bind.DatatypeConverter.printBase64Binary(desProfileImageFromDB);        
        List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.adminSideClientUploadedSpaceImagesRowIdVerification(clientInfoSavingIdLong);
        List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.adminSideClientUploadedInspireImagesRowIdVerification(clientInfoSavingIdLong);
        String clUpDBImagesList = "";
        String clInsUpDBImagesList = "";        
        if(!clientUploadedSpaceImagesList.isEmpty()){
        	for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {        		
        		byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
        		String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
        		clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;        		
        	}
        	clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
        }                
        if(!clientUploadedInsImagesList.isEmpty()){
        	for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {       		
        		
        		byte[] uploadedInsImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
        		String buffDBInsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedInsImageFromDB);
        		clInsUpDBImagesList = clInsUpDBImagesList + "_,_" +buffDBInsImage;        		
        	}
        	clInsUpDBImagesList = clInsUpDBImagesList.replaceFirst("_,_", "");
        }
        mav = new ModelAndView(viewClientInfoDisplay);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	mav.addObject(uploadPhForDes, clUpDBImagesList);
    	mav.addObject(uploadPhForDesCount, clientUploadedSpaceImagesList.size());
    	mav.addObject(insUploadPhoto, clInsUpDBImagesList);
    	mav.addObject(insUploadPhotoCount, clientUploadedInsImagesList.size());    	
    	mav.addObject(typeOfSpaceVal, typeOfSpace);
    	mav.addObject(typeOfStyleVal, typeOfStyle);
    	mav.addObject(budgetVal, budget);
    	mav.addObject(designPackageVal, designPackage);
    	mav.addObject(aboutSpaceDimnVal, aboutSpaceDimn);
    	mav.addObject(typeOfColor, typeOfColor1);
    	mav.addObject(likeOfColor, likeOfColor1);
    	mav.addObject(disLikeOfColor, disLikeOfColor1);
    	mav.addObject(otherItem, otherItem1);
    	mav.addObject(alreadyHaveItem, alreadyHaveItem1);
    	mav.addObject(artAppValue, artValue);    	
    	mav.addObject(moreAboutSpace, moreAboutSpace1);
    	mav.addObject(shareInspiration, shareInspiration1);    	
    	mav.addObject(allItemsVal, itemValueStr);    	
    	mav.addObject(designerProfileImage, desProfileImage);
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
    	return mav;
    }    

    @Override
    @Transactional
    public ModelAndView newGiftCardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GiftInfoSaving> selectedAdminRowIdList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<GiftInfoSaving> admnGiftCardSavingList = new ArrayList<GiftInfoSaving>();
            for (GiftInfoSaving giftInfoLoop : selectedAdminRowIdList) {
            	GiftInfoSaving giftInfoSavingModel = new GiftInfoSaving();
            	giftInfoSavingModel.setCreatedDate(giftInfoLoop.getCreatedDate());            	
            	giftInfoSavingModel.setYourName(giftInfoLoop.getYourName());
            	String totalPrice = giftInfoLoop.getTotalPrice();
            	giftInfoSavingModel.setPackagePrice(totalPrice);            	
            	giftInfoSavingModel.setGiftCardCouponCode(giftInfoLoop.getGiftCardCouponCode());
            	giftInfoSavingModel.setGiftCardInfoSavingId(giftInfoLoop.getGiftCardInfoSavingId());            	
            	giftInfoSavingModel.setStatus(giftInfoLoop.getStatus());
            	giftInfoSavingModel.setCouponCodeUsedStatus(giftInfoLoop.getRemainingGiftPrice());
            	admnGiftCardSavingList.add(giftInfoSavingModel);
            }            
            mav = new ModelAndView(newGiftCardsManagement);
            mav.addObject("giftCardInfoSavingList", admnGiftCardSavingList);
            mav.addObject("giftCardInfoListCount", selectedAdminRowIdList.size());                       
        } else{
        	mav = new ModelAndView(newGiftCardsManagement);            
        }
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView sentGiftCardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GiftInfoSaving> selectedAdminRowIdList = giftInfoSavingDAOImpl.sentGiftCardsDataTakeFromDB();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<GiftInfoSaving> admnGiftCardSavingList = new ArrayList<GiftInfoSaving>();
            for (GiftInfoSaving giftInfoLoop : selectedAdminRowIdList) {
            	GiftInfoSaving giftInfoSavingModel = new GiftInfoSaving();
            	giftInfoSavingModel.setCreatedDate(giftInfoLoop.getCreatedDate());            	
            	giftInfoSavingModel.setYourName(giftInfoLoop.getYourName());
            	String totalPrice = giftInfoLoop.getTotalPrice();
            	giftInfoSavingModel.setPackagePrice(totalPrice);            	
            	giftInfoSavingModel.setGiftCardCouponCode(giftInfoLoop.getGiftCardCouponCode());
            	giftInfoSavingModel.setGiftCardInfoSavingId(giftInfoLoop.getGiftCardInfoSavingId());            	
            	giftInfoSavingModel.setStatus(giftInfoLoop.getStatus());
            	giftInfoSavingModel.setCouponCodeUsedStatus(giftInfoLoop.getRemainingGiftPrice());
            	admnGiftCardSavingList.add(giftInfoSavingModel);
            }            
            mav = new ModelAndView(sentGiftCardsManagement);
            mav.addObject("giftCardInfoSavingList", admnGiftCardSavingList);
            mav.addObject("giftCardInfoListCount", selectedAdminRowIdList.size());                       
        } else{
        	mav = new ModelAndView(sentGiftCardsManagement);            
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView giftCardInfoSharingRe(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String typeOfGiftCard = req.getParameter("giftCardType");
    	String giftCardInfoID = req.getParameter("giftCardId");    	
    	long giftCardID = Long.parseLong(giftCardInfoID);
    	if(("Delete Giftcard").equals(typeOfGiftCard)) {
    		GiftInfoSaving giftInfoRowDelete = giftInfoSavingDAOImpl.viewGiftCardInfoDataDisplay(giftCardID);
    		giftInfoSavingDAOImpl.delete(giftInfoRowDelete);    		
    		mav = newGiftCardsRedirection(req, sn);
    	} else {
    		sn.setAttribute(giftCardInfoSavingIdInSn, giftCardInfoID);
    		mav = viewGiftCardInfoToJSP(req, sn, giftCardID);
    	}    	    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView viewGiftCardInfoToJSP(HttpServletRequest req, HttpSession sn, long giftCardID) {
    	ModelAndView mav;    	
    	GiftInfoSaving giftInfoSaving = giftInfoSavingDAOImpl.viewGiftCardInfoDataDisplay(giftCardID);    	
     	String typeOfPackage = giftInfoSaving.getTypeOfPackage();
     	String packagePrice = giftInfoSaving.getPackagePrice();     	
     	String merchandiseCredit = giftInfoSaving.getMerchandiseCredit();
     	String typeOfGiftcard = giftInfoSaving.getTypeOfGiftcard();
     	String typeOfDeliveryMethod = giftInfoSaving.getTypeOfDeliveryMethod();
     	String giftRecipientName = giftInfoSaving.getGiftRecipientName();
     	String giftRecipientAddress = giftInfoSaving.getGiftRecipientAddress();
     	String giftRecipientCity = giftInfoSaving.getGiftRecipientCity();
     	String giftRecipientState = giftInfoSaving.getGiftRecipientState();
     	String recZipCode = giftInfoSaving.getGiftRecipientZipCode();     	
     	String recEmailarName = giftInfoSaving.getRecEmailarName();
     	String recEmailarAddress = giftInfoSaving.getRecEmailarAddress();
     	String yourName = giftInfoSaving.getYourName();
     	String yourEmail = giftInfoSaving.getYourEmail();
     	String giftMessage = giftInfoSaving.getGiftMessage();
     	String deliveryDate = giftInfoSaving.getDeliveryDate();     	
    	mav = new ModelAndView("viewGiftCardInfoRedirection");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	mav.addObject("typeOfPackage",typeOfPackage);
    	mav.addObject("packagePrice",packagePrice);
    	mav.addObject("merchandiseCredit",merchandiseCredit);
    	mav.addObject("typeOfGiftcard",typeOfGiftcard);
    	mav.addObject("typeOfDeliveryMethod",typeOfDeliveryMethod);
    	mav.addObject("giftRecipientName",giftRecipientName);
    	mav.addObject("giftRecipientAddress",giftRecipientAddress);
    	mav.addObject("giftRecipientCity",giftRecipientCity);
    	mav.addObject("giftRecipientState",giftRecipientState);
    	mav.addObject("recZipCode",recZipCode);
    	mav.addObject("recEmailarName",recEmailarName);
    	mav.addObject("recEmailarAddress",recEmailarAddress);
    	mav.addObject("yourName",yourName);
    	mav.addObject("yourEmail",yourEmail);
    	mav.addObject("giftMessage",giftMessage);
    	mav.addObject("recptZipCode",recZipCode);
    	mav.addObject("deliveryDate",deliveryDate);    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView amnPurchasesInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	 
    	List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
    	if (!shopCartPaymentSavingList.isEmpty()) {        	
            List<ShoppingCartPaymentInfoSaving> admnPurchasesSavingList = new ArrayList<ShoppingCartPaymentInfoSaving>();
            for (ShoppingCartPaymentInfoSaving purchaseInfoLoop : shopCartPaymentSavingList) {
            	ShoppingCartPaymentInfoSaving purchaseInfoSavingModel = new ShoppingCartPaymentInfoSaving();
            	purchaseInfoSavingModel.setCreatedDate(purchaseInfoLoop.getCreatedDate());            	
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(purchaseInfoLoop.getUserId());
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName;
            	purchaseInfoSavingModel.setShipFullName(fullName);
            	purchaseInfoSavingModel.setBillAddress1(purchaseInfoLoop.getOrderedStatus());
            	purchaseInfoSavingModel.setBillAddress2(purchaseInfoLoop.getDeliveredStatus());
            	String reviwOrdStatus = purchaseInfoLoop.getReviewOrderStatus();
            	String orderStatus = null;
            	if(("Place My Order").equals(reviwOrdStatus)) {
            		orderStatus = "YES";
            	} else {
            		orderStatus = "NO";
            	}
            	purchaseInfoSavingModel.setReviewOrderStatus(orderStatus);
            	purchaseInfoSavingModel.setShoppingCartPaymentInfoSavingId(purchaseInfoLoop.getShoppingCartPaymentInfoSavingId());
            	admnPurchasesSavingList.add(purchaseInfoSavingModel);
            }            
            mav = new ModelAndView(purchasesInfoRedirection);
            mav.addObject("purchasesInfoSavingList", admnPurchasesSavingList);
            mav.addObject("purchasesInfoListCount", shopCartPaymentSavingList.size());            
        } else{
        	mav = new ModelAndView(purchasesInfoRedirection);            
        }
    	String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
    	List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminPurchasedArchiveInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	 
    	List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasedArchiveInfoDisplay();
    	if (!shopCartPaymentSavingList.isEmpty()) {        	
            List<ShoppingCartPaymentInfoSaving> admnPurchasesSavingList = new ArrayList<ShoppingCartPaymentInfoSaving>();
            for (ShoppingCartPaymentInfoSaving purchaseInfoLoop : shopCartPaymentSavingList) {
            	ShoppingCartPaymentInfoSaving purchaseInfoSavingModel = new ShoppingCartPaymentInfoSaving();
            	purchaseInfoSavingModel.setCreatedDate(purchaseInfoLoop.getCreatedDate());            	
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(purchaseInfoLoop.getUserId());
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName;
            	purchaseInfoSavingModel.setShipFullName(fullName);
            	purchaseInfoSavingModel.setBillAddress1(purchaseInfoLoop.getOrderedStatus());
            	purchaseInfoSavingModel.setBillAddress2(purchaseInfoLoop.getDeliveredStatus());
            	String reviwOrdStatus = purchaseInfoLoop.getReviewOrderStatus();
            	String orderStatus = null;
            	if(("Place My Order").equals(reviwOrdStatus)) {
            		orderStatus = "YES";
            	} else {
            		orderStatus = "NO";
            	}
            	purchaseInfoSavingModel.setReviewOrderStatus(orderStatus);
            	purchaseInfoSavingModel.setShoppingCartPaymentInfoSavingId(purchaseInfoLoop.getShoppingCartPaymentInfoSavingId());
            	admnPurchasesSavingList.add(purchaseInfoSavingModel);
            }            
            mav = new ModelAndView("clientPurchasedArchiveInfo");
            mav.addObject("archiveInfoSavingList", admnPurchasesSavingList);
            mav.addObject("archiveInfoListCount", shopCartPaymentSavingList.size());            
        } else{
        	mav = amnPurchasesInfoRedirection(req, sn);        
        }
    	String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
    	List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentCountList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentCountList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentCountList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        return mav;
    }
     
    @Override
    @Transactional
    public ModelAndView purchasesViewInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String purchasesInfoReff = req.getParameter("purchasesInfoReffName");
    	String shopCartPayRef = req.getParameter("shopCartPaymentRef");
    	long shopCartPaymentRef = Long.valueOf(shopCartPayRef);
    	if(("View Order Info").equals(purchasesInfoReff)) {
    		mav = purchasesViewOrderInfoDisplay(req, sn, shopCartPaymentRef);
    	} else if(("Client Archive").equals(purchasesInfoReff)) {
    		mav = adminPurchasedArchiveData(req, sn, shopCartPaymentRef);
    	} else {
    		mav = purchasesViewClientInfoDisplay(req, sn, shopCartPaymentRef);
    	}    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView purchasesViewOrderInfoDisplay(HttpServletRequest req, HttpSession sn, long shopCartPaymentRef) {
    	ModelAndView mav;
    	ShoppingCartPaymentInfoSaving shopCartPaymentSavingModel = shoppingCartPaymentInfoSavingDAO.purchaseClientShippingDataTakeFromDB(shopCartPaymentRef);
    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(shopCartPaymentSavingModel.getUserId());
    	long userId = userInformation.getUserId();
    	String fName = userInformation.getFirstName();
    	String lName = userInformation.getLastName();
    	String fullName = fName + " " + lName;    	
    	String scOrderStatus = shopCartPaymentSavingModel.getOrderedStatus();
		String scDeliveryStatus = shopCartPaymentSavingModel.getDeliveredStatus();		
		String noOrderedStatus = null;
		String noDeliveryStatus = null;    	
    	List<AddClientProductsToCartSaving> addClientProdToCartSavingList = addClientProductsToCartSavingDAO.AdminOrderStatusValueCheckingInDB(userId, shopCartPaymentRef);
    	if(!addClientProdToCartSavingList.isEmpty()){
    		List<AddClientProductsToCartSaving> addClProductsToCartSavingJSPList = new ArrayList<AddClientProductsToCartSaving>();
        	for (AddClientProductsToCartSaving addClientProdToCartSavingLoop : addClientProdToCartSavingList) {
        		AddClientProductsToCartSaving addClientProdToCartSavingModel = new AddClientProductsToCartSaving();     		
        		addClientProdToCartSavingModel.setProductName(addClientProdToCartSavingLoop.getProductName());
        		addClientProdToCartSavingModel.setProductCount(addClientProdToCartSavingLoop.getProductCount());
        		addClientProdToCartSavingModel.setStoreName(addClientProdToCartSavingLoop.getStoreName());
        		addClientProdToCartSavingModel.setStoreURL(addClientProdToCartSavingLoop.getStoreURL());
        		addClientProdToCartSavingModel.setProductPrice(addClientProdToCartSavingLoop.getProductTotalPrice());
        		addClientProdToCartSavingModel.setOrderedStatus(addClientProdToCartSavingLoop.getOrderedStatus());
        		addClientProdToCartSavingModel.setDeliveredStatus(addClientProdToCartSavingLoop.getDeliveredStatus());
        		addClientProdToCartSavingModel.setAddClientProductsToCartSavingId(addClientProdToCartSavingLoop.getAddClientProductsToCartSavingId());
        		addClProductsToCartSavingJSPList.add(addClientProdToCartSavingModel);        		
        		if(("NO").equals(addClientProdToCartSavingLoop.getOrderedStatus())) {
        			noOrderedStatus = "ENTER";
        		}
        		if(("NO").equals(addClientProdToCartSavingLoop.getDeliveredStatus())) {
        			noDeliveryStatus = "ENTER";
        		}
        	}
        	if(("NO").equals(scOrderStatus) && null == noOrderedStatus) {
    			shopCartPaymentSavingModel.setOrderedStatus("YES");
    			shoppingCartPaymentInfoSavingDAO.merge(shopCartPaymentSavingModel);
    		}
    		if(("NO").equals(scDeliveryStatus) && null == noDeliveryStatus) {
    			shopCartPaymentSavingModel.setDeliveredStatus("YES");
    			shoppingCartPaymentInfoSavingDAO.merge(shopCartPaymentSavingModel);
    		}
        	sn.setAttribute(shopCartPaymentRefInSn, shopCartPaymentRef);        	
        	mav = new ModelAndView(purchasesViewOrderInfo);
        	mav.addObject(clientFullName, fullName);
        	mav.addObject("purchasesFurSpecsProductsList", addClProductsToCartSavingJSPList);
            mav.addObject("purchasesFurSpecsProductsCount", addClProductsToCartSavingJSPList.size());
        } else {
        	mav = amnPurchasesInfoRedirection(req, sn);
        }    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminPurchasedArchiveData(HttpServletRequest req, HttpSession sn, long shopCartPaymentRef) {
    	ModelAndView mav;
    	ShoppingCartPaymentInfoSaving shopCartPayArchiveModel = shoppingCartPaymentInfoSavingDAO.purchaseClientShippingDataTakeFromDB(shopCartPaymentRef);
    	shopCartPayArchiveModel.setStatus("Archive");
    	shoppingCartPaymentInfoSavingDAO.merge(shopCartPayArchiveModel);
    	mav = amnPurchasesInfoRedirection(req, sn);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView purchasesViewClientInfoDisplay(HttpServletRequest req, HttpSession sn, long shopCartPaymentRef) {
    	ModelAndView mav;
    	ShoppingCartPaymentInfoSaving shopCartPaymentSavingModel = shoppingCartPaymentInfoSavingDAO.purchaseClientShippingDataTakeFromDB(shopCartPaymentRef);
    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(shopCartPaymentSavingModel.getUserId());
    	String fName = userInformation.getFirstName();
    	String lName = userInformation.getLastName();
    	String clEmailId = userInformation.getUserName();
    	String fullName = fName + " " + lName;
    	mav = new ModelAndView(purchasesViewClientInfo);    	
    	mav.addObject(clientFullName, fullName);
    	mav.addObject(userName, clEmailId);
    	mav.addObject(phoneNumber, shopCartPaymentSavingModel.getShipPhNumber());
    	mav.addObject(shipAddress1, shopCartPaymentSavingModel.getShipAddress1());
    	mav.addObject(shipAddress2, shopCartPaymentSavingModel.getShipAddress2());
    	mav.addObject(shipCity, shopCartPaymentSavingModel.getShipCity());
    	mav.addObject(shipState, shopCartPaymentSavingModel.getShipState());
    	mav.addObject(shipZip, shopCartPaymentSavingModel.getShipZip());
    	mav.addObject(billAddress1, shopCartPaymentSavingModel.getBillAddress1());
    	mav.addObject(billAddress2, shopCartPaymentSavingModel.getBillAddress2());
    	mav.addObject(billCity, shopCartPaymentSavingModel.getBillCity());
    	mav.addObject(billState, shopCartPaymentSavingModel.getBillState());
    	mav.addObject(billZip, shopCartPaymentSavingModel.getBillZip());
    	mav.addObject(cardType, shopCartPaymentSavingModel.getAccountType());
    	mav.addObject(payCardNumber, shopCartPaymentSavingModel.getPayCardNumber());
    	mav.addObject(payCvvNumber, shopCartPaymentSavingModel.getPayCvvNumber());
    	mav.addObject(expDate, shopCartPaymentSavingModel.getPayExpDate());    	    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView orderInfoMarkAsDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String productRefName = req.getParameter("productReffName");
    	String markAsOrderDelRef = req.getParameter("markAsOrderOrDelRef");    	
    	if(("Back To Product").equals(markAsOrderDelRef)) {
    		mav = amnPurchasesInfoRedirection(req, sn);
    	} else if(("Mark As Order").equals(markAsOrderDelRef)) {
    		long productInfoIdRef = Long.valueOf(productRefName);
    		mav = markAsOrderUpdateRedirection(req, sn, productInfoIdRef);
    	} else {
    		long productInfoIdRef = Long.valueOf(productRefName);
    		mav = markAsDeliveryUpdateRedirection(req, sn, productInfoIdRef);    				
    	}    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminArchiveDataUpdateInDatabase(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String purchasesInfoReff = req.getParameter("archiveInfoReffName");
    	String shopCartPayRef = req.getParameter("shopingCartPaymentRef");
    	long shopCartPaymentRef = Long.valueOf(shopCartPayRef);
    	if(("Archive Client Delete").equals(purchasesInfoReff)) {
    		ShoppingCartPaymentInfoSaving shopCartPayArchiveModel = shoppingCartPaymentInfoSavingDAO.archivePurchaseClientShippingData(shopCartPaymentRef);
        	shoppingCartPaymentInfoSavingDAO.delete(shopCartPayArchiveModel);
        	mav = adminPurchasedArchiveInfoDisplay(req, sn);
    	} else {
    		ShoppingCartPaymentInfoSaving shopCartPayArchiveModel = shoppingCartPaymentInfoSavingDAO.archivePurchaseClientShippingData(shopCartPaymentRef);
        	shopCartPayArchiveModel.setStatus(null);
        	shoppingCartPaymentInfoSavingDAO.merge(shopCartPayArchiveModel);
        	mav = adminPurchasedArchiveInfoDisplay(req, sn);
    	}    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView markAsOrderUpdateRedirection(HttpServletRequest req, HttpSession sn, long productInfoIdRef) {
    	ModelAndView mav;    	
    	AddClientProductsToCartSaving addClientProdToCartSavingModel = addClientProductsToCartSavingDAO.updatedSelectedProductsFromCartDB(productInfoIdRef);
    	addClientProdToCartSavingModel.setOrderedStatus("YES");
    	addClientProductsToCartSavingDAO.merge(addClientProdToCartSavingModel);		
    	long shopCartPaymentRef = (Long) sn.getAttribute(shopCartPaymentRefInSn);
    	mav = purchasesViewOrderInfoDisplay(req, sn, shopCartPaymentRef);    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView markAsDeliveryUpdateRedirection(HttpServletRequest req, HttpSession sn, long productInfoIdRef) {
    	ModelAndView mav;
    	AddClientProductsToCartSaving addClientProdToCartSavingModel = addClientProductsToCartSavingDAO.updatedSelectedProductsFromCartDB(productInfoIdRef);
    	addClientProdToCartSavingModel.setDeliveredStatus("YES");
    	addClientProductsToCartSavingDAO.merge(addClientProdToCartSavingModel);    	
    	long shopCartPaymentRef = (Long) sn.getAttribute(shopCartPaymentRefInSn);
    	mav = purchasesViewOrderInfoDisplay(req, sn, shopCartPaymentRef);    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView addNewDesignerRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(addNewDesignerRedirection);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView newDesignerDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	String desUserName = req.getParameter("userName");               
        List regDataVal = userInformationDAO.findByUserName(desUserName);
        ModelAndView mav;
        if (!regDataVal.isEmpty()) {
            mav = new ModelAndView(addNewDesignerRedirection);
            mav.addObject("regErrorPage", " E-mail already exists!");
        } else {
            String encrypPassword = mD5Encrypt(req.getParameter("createPassword"));
            String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
            String passwordSalt = mD5Encrypt(encrypPassword + salt);
            Timestamp currentDate = currentDate();
            UserInformation uiModel = new UserInformation();
            uiModel.setFirstName(req.getParameter("firstName"));
            uiModel.setLastName(req.getParameter("lastName"));
            uiModel.setUserName(desUserName);
            uiModel.setPhoneNumber(req.getParameter("phoneNumber"));
            uiModel.setPassword(encrypPassword);
            uiModel.setPasswordSalt(passwordSalt);            
            uiModel.setTypeOfUser("D");            
            String desnPersonalBio1 = req.getParameter(desnPersonalBio);
            desnPersonalBio1 = desnPersonalBio1.replaceAll("[\n\r]", " ");
            String desnLocation1 = req.getParameter(desnLocation);
            desnLocation1 = desnLocation1.replaceAll("[\n\r]", " ");
            String desnCredential1 = req.getParameter(desnCredential);
            desnCredential1 = desnCredential1.replaceAll("[\n\r]", " ");
            uiModel.setDesnPersonalBio(desnPersonalBio1);
            uiModel.setDesnLocation(desnLocation1);
            uiModel.setDesnCredential(desnCredential1);
            uiModel.setCreatedDate(currentDate);
            userInformationDAO.save(uiModel);
            long userId = uiModel.getUserId();            
            DesignerInfoSaving disModel = new DesignerInfoSaving();
            disModel.setDesignerId(userId);
            disModel.setCreatedDate(currentDate);
            designerInfoSavingDAO.save(disModel);
            disModel.getDesignerInfoSavingId();            
            mav = amnDesignerDirectoryRedirection(req, sn);
            mav.addObject(flName, sn.getAttribute(firstNamesInSn));
            mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
            mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
            mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
            mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        }
        return mav;
    }
     
     @Override
     @Transactional
     public ModelAndView adminSideClientAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	 ModelAndView mav;
    	 String clientAndDesnMesList = "";
    	 String desFirstName = null;
    	 String clFirstName = null;       
    	 if(null != sn.getAttribute(clientInfoSavingIdInSn) && null != sn.getAttribute(designerInfoSavingIdInSn)) {
    		 long clientInfoId = Long.parseLong((String) sn.getAttribute(clientInfoSavingIdInSn));
    		 long designInfoId = Long.parseLong((String) sn.getAttribute(designerInfoSavingIdInSn));    	    
    		 DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);
    		 long desnUserId = designerInfoSaving.getDesignerId();    	    
    		 ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.userIdTakeFromTableUsingClId(clientInfoId);
    		 long clUserId = clientInfoSaving.getUserId();    	    
    		 UserInformation userInfoSaving = userInformationDAO.updatedRowIdVerification(desnUserId);
    		 UserInformation userInfoModel = userInformationDAO.updatedRowIdVerification(clUserId);
    		 desFirstName = userInfoSaving.getFirstName();
    		 clFirstName = userInfoModel.getFirstName();    	    
    		 List<ClientDesignerMessageInfoSaving> clAndDesnMesInfoList = clientDesignerMessageInfoSavingDAO.clientAndDesignerMessageInfoRowVerificationInDB(clientInfoId, designInfoId);
    		 if (!clAndDesnMesInfoList.isEmpty()) {
    			 for (ClientDesignerMessageInfoSaving clAndDesnMesInfoModel : clAndDesnMesInfoList) {         		        		
    				 String clAndDesMesVal = clAndDesnMesInfoModel.getMessageInfo();
    				 clientAndDesnMesList = clientAndDesnMesList + "_,_" + clAndDesMesVal;
    			 }
    			 clientAndDesnMesList = clientAndDesnMesList.replaceFirst("_,_", "");
    		 }         	
    	 }        
    	 mav = new ModelAndView(adminClientAndDesignerMess);
    	 mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	 mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	 mav.addObject("clientAndDesMessList", clientAndDesnMesList);       
    	 mav.addObject("designerFirstName", desFirstName);
    	 mav.addObject("clientFirstName", clFirstName);
    	 return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView amnDesignerDirectoryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<UserInformation> designerInfoList = userInformationDAO.designerInfoDisplayInAdmin();
    	List<UserInformation> inacDesignerInfoList = userInformationDAO.inactiveDesignerInfoDisplayInAdmin();
    	if (!designerInfoList.isEmpty()) {        	
            List<UserInformation> userInfoSavingList = new ArrayList<UserInformation>();
            for (UserInformation userInfoLoop : designerInfoList) {
            	UserInformation userInfoSavingModel = new UserInformation();            	
            	DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification(userInfoLoop.getUserId());            	
            	String fName = userInfoLoop.getFirstName();
            	String lName = userInfoLoop.getLastName();
            	String fullName = fName + " " + lName;            	
            	userInfoSavingModel.setFirstName(fullName);
            	String newUploadStatus = designerNewUploadStatusFromDB(designerInfoSaving.getDesignerInfoSavingId());
            	userInfoSavingModel.setAdminType(newUploadStatus);            	
            	String admAllClToDsnStatus = adminAllocatedClientToDesignerStatusFromDB(designerInfoSaving.getDesignerInfoSavingId());
            	userInfoSavingModel.setDesnLocation(admAllClToDsnStatus);            	           	
            	userInfoSavingModel.setUserId(designerInfoSaving.getDesignerInfoSavingId());            	
            	int desMesCount = designerMessagesCountInAdminSideTakeFromDB(designerInfoSaving.getDesignerInfoSavingId());
            	String desMessagesCount = "";
            	if(desMesCount > 0) {
            		desMessagesCount = "NEW";
            	}
            	userInfoSavingModel.setPassword(desMessagesCount);
            	userInfoSavingModel.setCreatedDate(userInfoLoop.getCreatedDate());
            	userInfoSavingList.add(userInfoSavingModel);
            }
            mav = new ModelAndView(designerDirectoryRedirection);
            mav.addObject("designerDirectorySavingList", userInfoSavingList);
            mav.addObject("designerDirectoryListCount", designerInfoList.size());
            mav.addObject("inactiveDesnCount", inacDesignerInfoList.size());
        } else{
        	mav = new ModelAndView(designerDirectoryRedirection);            
        }
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView admInactiveDesignersRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<UserInformation> designerInfoList = userInformationDAO.inactiveDesignerInfoDisplayInAdmin();
        if (!designerInfoList.isEmpty()) {        	
            List<UserInformation> userInfoSavingList = new ArrayList<UserInformation>();
            for (UserInformation userInfoLoop : designerInfoList) {
            	UserInformation userInfoSavingModel = new UserInformation();            	
            	DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification(userInfoLoop.getUserId());            	
            	String fName = userInfoLoop.getFirstName();
            	String lName = userInfoLoop.getLastName();
            	String fullName = fName + " " + lName;            	
            	userInfoSavingModel.setFirstName(fullName);            	          	
            	userInfoSavingModel.setUserId(designerInfoSaving.getDesignerInfoSavingId());
            	userInfoSavingModel.setCreatedDate(userInfoLoop.getCreatedDate());
            	userInfoSavingModel.setUpdatedDate(userInfoLoop.getUpdatedDate());
            	userInfoSavingList.add(userInfoSavingModel);
            }
            mav = new ModelAndView(inactiveDesignersRedirection);
            mav.addObject("inactiveDesignersSavingList", userInfoSavingList);
            mav.addObject("inactiveDesignersListCount", designerInfoList.size());                       
        } else{
        	mav = amnDesignerDirectoryRedirection(req, sn);          
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        return mav;
    } 

    @Override
    @Transactional
    public String amnDesignerDirectoryNewStatusDsp(HttpServletRequest req, HttpSession sn) {
    	String admnNewImgSt = null;
    	int desMesCount = 0;
    	String newUploadStatus =  null;
    	List<DesignerInfoSaving> designerInfoList = designerInfoSavingDAO.displayDesignerNameInNewClientsUsingStatus();
        if (!designerInfoList.isEmpty()) {        	
            for (DesignerInfoSaving designerInfoSaving : designerInfoList) {
            	newUploadStatus = designerNewUploadStatusFromDB(designerInfoSaving.getDesignerInfoSavingId());            	            	
            	desMesCount = designerMessagesCountInAdminSideTakeFromDB(designerInfoSaving.getDesignerInfoSavingId());
            	if(desMesCount > 0 || newUploadStatus != null) {
                	admnNewImgSt = "NEW";
                	break;
            	}
            }                           
        }
        return admnNewImgSt;
    }
    
	@Override
	@Transactional
	public String designerNewUploadStatusFromDB(long designInfoId) {
		String newUploadStatus = null;
		List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.checkDesignerUpdatedStatusInDB(designInfoId);
    	if(!adminAssignClInfoList.isEmpty()){
    		newUploadStatus = "YES";
    	} else {
    		newUploadStatus = null;
    	}
		return newUploadStatus;
	}

	@Override
	@Transactional
	public String adminAllocatedClientToDesignerStatusFromDB(long designInfoId) {
		String admAllClToDsnStatus = null;
		List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.checkClientsInfoUsingDesignerIdInDB(designInfoId);
    	if(!adminAssignClInfoList.isEmpty()){
    		admAllClToDsnStatus = "HAVE A CLIENT";
    	} else {
    		admAllClToDsnStatus = null;
    	}
		return admAllClToDsnStatus;
	}

	@Override
	@Transactional
	public int designerMessagesCountInAdminSideTakeFromDB(long designInfoId) {
		int desnMessagesCoun = 0;
		if(designInfoId > 0) {
			List adminAndDesnMesCountList = adminDesignerMessageInfoSavingDAO.designerMessageCounttoAdminSideInDB(designInfoId);
			desnMessagesCoun = adminAndDesnMesCountList.size();			
		}
		return desnMessagesCoun;
	}
    
    @Override
    @Transactional
    public ModelAndView designerDirectoryForClientsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String designersClientType = req.getParameter("designerClientType");
    	long designersInfoSavingId = Long.parseLong(req.getParameter(designerInfoSavingId));
    	sn.setAttribute(designerInfoSavingIdInSn, req.getParameter(designerInfoSavingId));    	
    	if(("View Designer Client").equals(designersClientType)) {
    		mav = viewDesignerDirectoryForClientsInAdmin(req, sn, designersInfoSavingId);
    	} else if(("Designer Client Message").equals(designersClientType)) {
    		mav = new ModelAndView("redirect:" + reDirAdminAndDesignerMes);
    	} else if(("Edit Designer Profile").equals(designersClientType)) {
    		mav = editDesignerProfileInDB(req, sn, designersInfoSavingId);
    	} else if(("Inactive Designer").equals(designersClientType)) {
    		mav = inactiveDesignerStatusInDB(req, sn, designersInfoSavingId);
    	} else {
    		mav = amnDesignerDirectoryRedirection(req, sn);
    	}    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }    

    @Override
    @Transactional
    public ModelAndView adminMessageSendToDesignerRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
	    Timestamp currentDate = currentDate();	
	    String timeString  = timeGettingFromCurrentDate();
	    timeString = timeString.replaceAll(" ", "");   
	    String todayDate = todayDateGettingFromCurrentDate();
	    String oneTimeRefDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate) + "_A";
	    List<AdminDesignerMessageInfoSaving> adminAndDesnMsgInfoList = adminDesignerMessageInfoSavingDAO.oneTimeDateFormationCheckingInDB(oneTimeRefDate);	    
	    String totalDate = todayDate + " " + timeString;	    
	    String adminsMessage = req.getParameter("adminMessage");
	    adminsMessage = adminsMessage.replaceAll("[\n\r]", " ");
	    String adminMsgData = totalDate + ",_," + adminsMessage;	    
	    String designerInfoId = (String) sn.getAttribute(designerInfoSavingIdInSn);
    	long designInfoId = Long.parseLong(designerInfoId);
    	if (adminAndDesnMsgInfoList.isEmpty()) {
	    	mav = adminOneTimeMessageMailSentToDesigner(req, sn, designInfoId);
	    }	    	           		
    	AdminDesignerMessageInfoSaving adminDesMessageSavingModel = new AdminDesignerMessageInfoSaving();
    	adminDesMessageSavingModel.setDesignerInfoSavingId(designInfoId);
    	adminDesMessageSavingModel.setMessageInfo(adminMsgData);
    	adminDesMessageSavingModel.setStatus("ADDESNEW");
	 	adminDesMessageSavingModel.setCreatedDate(currentDate);
	 	adminDesMessageSavingModel.setOneTimeRefDate(oneTimeRefDate);
	 	adminDesignerMessageInfoSavingDAO.save(adminDesMessageSavingModel);	 		
        mav = new ModelAndView("redirect:" + reDirAdminAndDesignerMes);         	
	    return mav;
    } 

    @Override
    @Transactional    
    public ModelAndView adminOneTimeMessageMailSentToDesigner(HttpServletRequest req, HttpSession sn, long designerInfoId) {
    	ModelAndView mav;
        DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoId);
    	long designerUserId = designerInfoSaving.getDesignerId();
   	 	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);        		
        String toAdd = userInformation.getUserName();
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "You have a new message from the admin.";            
        String type = "text/html";           
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";              
        String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                    + "<p style='padding-top: 5px;'>You have a new message from the admin. Log in to your account to read your messages.</p>"
                    + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                    + "<p style='padding-top: 5px;'>-Admin</p> <br/>"
                    + "</div>"
                    + "</body> ";            
        try {
        	userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
        } catch (Exception ex) {
        	LOGGER.error("Admin One Time Message Mail Sent To Designer failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
	    String designerInfoId = (String) sn.getAttribute(designerInfoSavingIdInSn);
    	long designInfoId = Long.parseLong(designerInfoId);    	
    	adminDesignerMessageInfoSavingDAO.designerMessagesStatusUpdateInAdminSide(designInfoId);
    	DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);
    	String desFullName = desnInfoSaving.getDesignerFullName();    	
	 		String adminAndDesnMesList = "";
	 		List<AdminDesignerMessageInfoSaving> adminAndDesnMesInfoList = adminDesignerMessageInfoSavingDAO.adminAndDesignerMessageInfoRowVerificationInDB(designInfoId);
         	if (!adminAndDesnMesInfoList.isEmpty()) {
         		for (AdminDesignerMessageInfoSaving adminAndDesnMesInfoModel : adminAndDesnMesInfoList) {         		        		
        		String adminAndDesMesVal = adminAndDesnMesInfoModel.getMessageInfo();
        		adminAndDesnMesList = adminAndDesnMesList + "_,_" + adminAndDesMesVal;
        		}
         		adminAndDesnMesList = adminAndDesnMesList.replaceFirst("_,_", "");
         	}         	
         	mav = new ModelAndView("viewDesignerAdminMessageInfo");
	 		mav.addObject("adminAndDesMessList", adminAndDesnMesList);
	 		mav.addObject(designerFullName, desFullName);
	 		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	 		mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
	 		mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
	 		mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
	 		mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
	 	
	    return mav;
    }

    @Override
    @Transactional
    public ModelAndView editDesignerProfileInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId) {
    	ModelAndView mav;    	
        DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designersInfoSavingId);
        long userId = desnInfoSaving.getDesignerId();        	
        sn.setAttribute(designerUserInSn, userId);        	
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
        String firstName1 = userInformation.getFirstName();
        String lastName1 = userInformation.getLastName();
        String userName1 = userInformation.getUserName();            
        String phNumber1 = userInformation.getPhoneNumber();
        String personalBio = userInformation.getDesnPersonalBio();
        String location = userInformation.getDesnLocation();
        String credentioals = userInformation.getDesnCredential();            	
        mav = new ModelAndView(editDesignerProfileInfo);            
        mav.addObject(firstName, firstName1);
        mav.addObject(lastName, lastName1);
        mav.addObject(userName, userName1);
        mav.addObject(phoneNumber, phNumber1);
        mav.addObject(desnPersonalBio, personalBio);
        mav.addObject(desnLocation, location);
        mav.addObject(desnCredential, credentioals);            
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView inactiveDesignerStatusInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
        DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designersInfoSavingId);
        long userId = desnInfoSaving.getDesignerId();        	
        sn.setAttribute(designerUserInSn, userId);        	
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
        userInformation.setTypeOfUser("I");
        userInformation.setUpdatedDate(currentDate);
        userInformationDAO.merge(userInformation);
        mav = amnDesignerDirectoryRedirection(req, sn);  	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView editDesignerDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	long userId = (Long) sn.getAttribute(designerUserInSn);
    	UserInformation userInfoModel = userInformationDAO.updatedRowIdVerification(userId);    	
    	int count = 0;
    	String oldUserName = userInfoModel.getUserName();
    	if(!(oldUserName).equals(req.getParameter(userName))) {
    		List regDataVal = userInformationDAO.findByUserName(req.getParameter(userName));
    		count = regDataVal.size();
    	}    	        
        if (count > 0) {
        	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
            String firstName1 = userInformation.getFirstName();
            String lastName1 = userInformation.getLastName();
            String userName1 = userInformation.getUserName();            
            String phNumber1 = userInformation.getPhoneNumber();
            String personalBio = userInformation.getDesnPersonalBio();
            String location = userInformation.getDesnLocation();
            String credentioals = userInformation.getDesnCredential();            	
            mav = new ModelAndView(editDesignerProfileInfo);            
            mav.addObject(firstName, firstName1);
            mav.addObject(lastName, lastName1);
            mav.addObject(userName, userName1);
            mav.addObject(phoneNumber, phNumber1);
            mav.addObject(desnPersonalBio, personalBio);
            mav.addObject(desnLocation, location);
            mav.addObject(desnCredential, credentioals);
            mav.addObject("regErrorPage", " E-mail already exists!");
        } else {        	
            UserInformation userInformationModel = userInformationDAO.updatedRowIdVerification(userId);
            userInformationModel.setFirstName(req.getParameter(firstName));
            userInformationModel.setLastName(req.getParameter(lastName));
            userInformationModel.setUserName(req.getParameter(userName));            
            userInformationModel.setPhoneNumber(req.getParameter(phoneNumber));
            userInformationModel.setDesnPersonalBio(req.getParameter(desnPersonalBio));
            userInformationModel.setDesnLocation(req.getParameter(desnLocation));
            userInformationModel.setDesnCredential(req.getParameter(desnCredential));
            userInformationDAO.merge(userInformationModel);            
            String fName = userInformationModel.getFirstName();
            String lName = userInformationModel.getLastName();
            String fullName = fName + " " + lName;            
            DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification(userId);
            desnInfoSaving.setDesignerFullName(fullName);
            designerInfoSavingDAO.merge(desnInfoSaving);            	
            mav = amnDesignerDirectoryRedirection(req, sn);
            mav.addObject("dataChanged", "Changed Info");
        }            
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }    

    @Override
    @Transactional
    public ModelAndView desnChangePasswordInDbTable(HttpServletRequest req, HttpSession sn) {
     	long userId = (Long) sn.getAttribute(designerUserInSn);
    	UserInformation userInfoSavingModel = userInformationDAO.updatedRowIdVerification(userId);    	
    	String userName2 = userInfoSavingModel.getUserName();     	 
        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String encrypCurPassword = mD5Encrypt(currentPassword);
        String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
        String encrypNewPassword = mD5Encrypt(newPassword);
        String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);        
        UserInformation userData = userInformationDAO.findByUserInfoFromDB(userName2);
        String oldPassSalt = userData.getPasswordSalt();        
        ModelAndView mav;
        if (currentPasswordSalt.equals(oldPassSalt)) {        	
        	UserInformation userInfoModel = userInformationDAO.findByUserInfoFromDB(userName2);        	
        	userInfoModel.setPassword(encrypNewPassword);
        	userInfoModel.setPasswordSalt(newPasswordSalt);        	
            userInformationDAO.merge(userInfoModel);
            mav = amnDesignerDirectoryRedirection(req, sn);           
            mav.addObject("passMessage", "Password");
        } else {
        	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
            String firstName1 = userInformation.getFirstName();
            String lastName1 = userInformation.getLastName();
            String userName1 = userInformation.getUserName();            
            String phNumber1 = userInformation.getPhoneNumber();
            String personalBio = userInformation.getDesnPersonalBio();
            String location = userInformation.getDesnLocation();
            String credentioals = userInformation.getDesnCredential();            
        	mav = new ModelAndView(editDesignerProfileInfo);
        	mav.addObject(firstName, firstName1);
            mav.addObject(lastName, lastName1);
            mav.addObject(userName, userName1);
            mav.addObject(phoneNumber, phNumber1);
            mav.addObject(desnPersonalBio, personalBio);
            mav.addObject(desnLocation, location);
            mav.addObject(desnCredential, credentioals);
            mav.addObject("changePasswordError", " Invalid Current Password");            
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView inactiveDesignersDirectoryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String inactiveDesignersRef = req.getParameter("inactiveDesignerRef");
    	long designersInfoSavingId = Long.parseLong(req.getParameter(designerInfoSavingId));
    	sn.setAttribute(designerInfoSavingIdInSn, req.getParameter(designerInfoSavingId));    	
    	if(("Inactive Designer Profile").equals(inactiveDesignersRef)) {
    		mav = inactiveDesignersProfileInDB(req, sn, designersInfoSavingId);
    	} else if(("Active Designer").equals(inactiveDesignersRef)) {
    		mav = activeDesignerStatusUpdateInDB(req, sn, designersInfoSavingId);
    	} else {
    		mav = amnDesignerDirectoryRedirection(req, sn);
    	}    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView activeDesignerStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
        DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designersInfoSavingId);
        long userId = desnInfoSaving.getDesignerId();        	
        sn.setAttribute(designerUserInSn, userId);        	
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
        userInformation.setTypeOfUser("D");
        userInformation.setUpdatedDate(currentDate);
        userInformationDAO.merge(userInformation);
        mav = admInactiveDesignersRedirection(req, sn);  	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView inactiveDesignersProfileInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId) {
    	ModelAndView mav;    	
    	DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designersInfoSavingId);
    	long userId = desnInfoSaving.getDesignerId();    	
    	sn.setAttribute(designerUserInSn, userId);    	
    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
    	String firstName1 = userInformation.getFirstName();
    	String lastName1 = userInformation.getLastName();
    	String userName1 = userInformation.getUserName();    	
    	String phNumber1 = userInformation.getPhoneNumber();
    	String personalBio = userInformation.getDesnPersonalBio();
    	String location = userInformation.getDesnLocation();
    	String credentioals = userInformation.getDesnCredential();        	
    	mav = new ModelAndView(inactiveDesignersProfileRed);    	
    	mav.addObject(firstName, firstName1);
    	mav.addObject(lastName, lastName1);
    	mav.addObject(userName, userName1);
    	mav.addObject(phoneNumber, phNumber1);
    	mav.addObject(desnPersonalBio, personalBio);
    	mav.addObject(desnLocation, location);
    	mav.addObject(desnCredential, credentioals);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView viewDesignerDirectoryForClientsInAdmin(HttpServletRequest req, HttpSession sn, long designersInfoSavingId) {
    	ModelAndView mav;    	
    	List<ClientInfoSaving> viewDesClsInfoList = clientInfoSavingDAO.checkDesignerDirectoryForClientsUsingDesignerID(designersInfoSavingId);
        if (!viewDesClsInfoList.isEmpty()) {        	
        	DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designersInfoSavingId);        	
        	String desnFullName = desnInfoSaving.getDesignerFullName();
            List<ClientInfoSaving> viewDesClsInfoSavingList = new ArrayList<ClientInfoSaving>();
            for (ClientInfoSaving viewDesClsInfoLoop : viewDesClsInfoList) {
            	ClientInfoSaving viewClsInfoSavingModel = new ClientInfoSaving();            	
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(viewDesClsInfoLoop.getUserId());
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName; 
            	viewClsInfoSavingModel.setTypeOfStyle(fullName);            	
            	viewClsInfoSavingModel.setDesignerAssignedDate(viewDesClsInfoLoop.getDesignerAssignedDate());            	
            	String typeOfSpace = viewDesClsInfoLoop.getTypeOfSpace();
                typeOfSpace = typeOfSpace.replace("_", " ");
                viewClsInfoSavingModel.setTypeOfSpace(typeOfSpace);                
                String desnPack = viewDesClsInfoLoop.getDesignPackage();
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}            	
            	viewClsInfoSavingModel.setDesignPackage(designPackage);            	
            	String uploadStatus = null;
            	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(viewDesClsInfoLoop.getClientInfoSavingId(), designersInfoSavingId);
        		if(!adminAssignClInfoList.isEmpty()){    		
            		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(viewDesClsInfoLoop.getClientInfoSavingId(), designersInfoSavingId);
            		uploadStatus = adminAssignClInfoSaving.getDesignerUploads();
        		}
        		viewClsInfoSavingModel.setStatus(uploadStatus);
        		viewClsInfoSavingModel.setClientInfoSavingId(viewDesClsInfoLoop.getClientInfoSavingId());
        		viewClsInfoSavingModel.setDesignerInfoSavingId(viewDesClsInfoLoop.getDesignerInfoSavingId());
        		viewClsInfoSavingModel.setUserId(viewDesClsInfoLoop.getUserId());
        		viewClsInfoSavingModel.setRoomStatus(viewDesClsInfoLoop.getRoomStatus());
            	viewDesClsInfoSavingList.add(viewClsInfoSavingModel);
            }
            mav = new ModelAndView("designerDirectoryForClientsRe");
            mav.addObject("designerDirectoryForClientsSavingList", viewDesClsInfoSavingList);
            mav.addObject("designerDirectoryForClientsListCount", viewDesClsInfoList.size());
            mav.addObject(designerFullName, desnFullName);                       
        } else{
        	mav = amnDesignerDirectoryRedirection(req, sn);
        	mav.addObject("desnClientAlStatus", "No");
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerDirectoryQuestionairreBackMove(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String clientInfoSavingId = (String) sn.getAttribute(clientInfoSavingIdInSn);
    	long clientInfoSavingIdLong = Long.parseLong(clientInfoSavingId);    	
    	ClientInfoSaving clInfoSavingModel = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoSavingIdLong);
	    long desInfoSavingIdLong = clInfoSavingModel.getDesignerInfoSavingId();    	
    	mav = viewDesignerDirectoryForClientsInAdmin(req, sn, desInfoSavingIdLong);    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerDirectoryClientInfoDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String designerClientType = req.getParameter("designerForClientType");    	
    	String designerAndClientIdList = req.getParameter("designerAndClientIds");
    	long clientInfoSavingId = 0;
    	long designerInfoSavingId = 0;
    	if(null != designerAndClientIdList) {
    	String[] designerAndClientIdString = designerAndClientIdList.split(", ");
    	clientInfoSavingId = Long.parseLong(designerAndClientIdString[0]);
    	designerInfoSavingId = Long.parseLong(designerAndClientIdString[1]);
    	sn.setAttribute(clientInfoSavingIdInSn, designerAndClientIdString[0]);
		sn.setAttribute(designerInfoSavingIdInSn, designerAndClientIdString[1]);
		sn.setAttribute(clientLoginIdInSn, designerAndClientIdString[2]);
    	}    	
    	if(("Go Back").equals(designerClientType)) {
    		mav = amnDesignerDirectoryRedirection(req, sn);
    	} else if(("View Uploads").equals(designerClientType)) {
    		mav = viewUploadconceptsAnd3DRenderingRedirection(req, sn, clientInfoSavingId, designerInfoSavingId);
    	} else if(("View Message").equals(designerClientType)) {
    		mav = adminSideClientAndDesignerMessageInfoRedirection(req, sn);
    	} else if(("Questionairre").equals(designerClientType)) {
    		mav = clientRoomsInformationInAdmin(req, sn);
    	} else {
    		mav = viewDesignerDirectoryForClientsInAdmin(req, sn, designerInfoSavingId);
    	}    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView viewUploadconceptsAnd3DRenderingRedirection(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
    	ModelAndView mav;
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);     	      
        String designPackage = myRoomInfoSaving.getDesignPackage();
        if (("Accessories Package").equals(designPackage)) {
        	mav = accPackageViewUploadConceptsAndFinalConcepts(req, sn, clientInfoId, designInfoId);
        } else if (("Full Room Design Package").equals(designPackage)) {
        	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoId, designInfoId);
        } else {
        	mav = amnDesignerDirectoryRedirection(req, sn);
        }    	    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView accPackageViewUploadConceptsAndFinalConcepts(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
    	ModelAndView mav;
    	sn.setAttribute(clientInfoSavingIdInSn, clientInfoId);
    	sn.setAttribute(designerInfoSavingIdInSn, designInfoId);    	
    	DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);        	
    	String desnFullName = desnInfoSaving.getDesignerFullName();    	
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
     	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(createDate.getTime());
        String formatedDate = sdf.format(date);        
        String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();
        typeOfSpace = typeOfSpace.replace("_", " ");        
        String designPackage = myRoomInfoSaving.getDesignPackage();        
        long userId = myRoomInfoSaving.getUserId();
        String customerName = customerNameFromDB(userId);
        String uploadedConcept1Image = "";
        String uploadedConcept2Image = "";
        String uploaded3DRenderingImage = "";
        String likeImagesValue = "";
        String adminAppConceptStatus1 = "";
        String adminAppRenderingsStatus1 = "";        
        String desnSubmitConceptStatus1 = "";
        String desnSubmitRenderingsStatus1 = "";                
        List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoId, designInfoId);
        List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoId, designInfoId);
        List adminAssignRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInDB(clientInfoId, designInfoId);                
    	if(!adminAssignCon1InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoId, designInfoId);    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignCon1InfoSaving.getConcept1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);
    	}        
    	if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedConcept2ImageFromDB = adminAssignCon2InfoSaving.getConcept2ImageUpload();
    		uploadedConcept2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);
    		adminAppConceptStatus1 = adminAssignCon2InfoSaving.getAdminApprovedForConcept();
    		desnSubmitConceptStatus1 = adminAssignCon2InfoSaving.getDesignerSubmitConceptsStatus();
    	}        
    	if(!adminAssignRendInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRendInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInDB(clientInfoId, designInfoId);
    		byte[] uploaded3DrendImageFromDB = adminAssignRendInfoSaving.getRendering1ImageUpload();
    		uploaded3DRenderingImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);
    		adminAppRenderingsStatus1 = adminAssignRendInfoSaving.getAdminApprovedForRendering();
    		desnSubmitRenderingsStatus1 = adminAssignRendInfoSaving.getDesignerSubmitRenderingStatus();
    	}    	
    	likeImagesValue = concept3DRenderingLikeImagesDisplay(req, sn, clientInfoId, designInfoId);    	
    	List desnUploadedProductsList1 = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoId, designInfoId);
    	List desnUploadedProductsList2 = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoId, designInfoId);
    	List desnUploadedProductsList3 = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designInfoId);         
    	mav = new ModelAndView("viewUploadAccPackConceptsAndFinalCon");    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	    	
    	mav.addObject("createdDate", formatedDate);
    	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
    	mav.addObject(designPackageVal, designPackage);
    	mav.addObject("clientFullName", customerName);
    	mav.addObject(designerFullName, desnFullName);    	
    	mav.addObject(concept1UploadedImage, uploadedConcept1Image);
     	mav.addObject(concept2UploadedImage, uploadedConcept2Image);
     	mav.addObject(concept3UploadedImage, uploaded3DRenderingImage);     	
     	mav.addObject(adminAppConceptStatus, adminAppConceptStatus1);
        mav.addObject(adminAppRenderingsStatus, adminAppRenderingsStatus1);
        mav.addObject(desnSubmitConceptStatus, desnSubmitConceptStatus1);
        mav.addObject(desnSubmitRenderingsStatus, desnSubmitRenderingsStatus1);     	
     	mav.addObject(desnUploadedProducts1Count, desnUploadedProductsList1.size());
     	mav.addObject(desnUploadedProducts2Count, desnUploadedProductsList2.size());
     	mav.addObject(desnUploadedProducts3Count, desnUploadedProductsList3.size());
     	mav.addObject(likeImagesValues, likeImagesValue);    	
    	return mav;
    }

    @Override
    @Transactional
    public String concept3DRenderingLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
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
    public ModelAndView fullRoomViewUploadConceptsAndRenderings(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
    	ModelAndView mav;
    	sn.setAttribute(clientInfoSavingIdInSn, clientInfoId);
    	sn.setAttribute(designerInfoSavingIdInSn, designInfoId);    	
    	DesignerInfoSaving desnInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designInfoId);        	
    	String desnFullName = desnInfoSaving.getDesignerFullName();    	
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
     	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(createDate.getTime());
        String formatedDate = sdf.format(date);        
        String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();
        typeOfSpace = typeOfSpace.replace("_", " ");       
        String designPackage = myRoomInfoSaving.getDesignPackage();        
        long userId = myRoomInfoSaving.getUserId();
        String customerName = customerNameFromDB(userId);
        String clUpDBImagesList = clientUploadedInspireImageTakeFromDB(clientInfoId, designInfoId, userId);            
        String uploadedConcept1Img = "";
        String uploadedConcept2Img = "";
        String uploadedRmrend1Img = "";
        String uploadedRmrend2Img = "";
        String uploadedRevrend1Img = "";
        String uploadedRevrend2Img = "";
        String uploadedSecRend1Img = "";
        String uploadedSecRend2Img = "";
        String likeImagesValue = "";
        String designConceptStatus = "";
        String designRenderingsStatus = "";
        String designRevRenderingsStatus = "";
        String designSecRenderingsStatus = "";        
        String adminAppConceptStatus1 = "";
        String adminAppRenderingsStatus1 = "";
        String adminAppRevRenderingsStatus1 = "";
        String adminAppSecRenderingsStatus1 = "";
        String secRenPayStatus = null;
        List designerConcept1VerList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoId, designInfoId);
        List designerConcept2VerList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoId, designInfoId);
        List designerRoomRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoId, designInfoId);
        List designerRoomRendering2VerList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering2VerificationInDB(clientInfoId, designInfoId);
        List designerRevisedRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInDB(clientInfoId, designInfoId);
        List designerRevisedRendering2VerList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2VerificationInDB(clientInfoId, designInfoId);        
        List designerSecondRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInDB(clientInfoId, designInfoId);
        List designerSecondRendering2VerList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2VerificationInDB(clientInfoId, designInfoId);                
    	if(!designerConcept1VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoId, designInfoId);    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignCon1InfoSaving.getConcept1ImageUpload();    		
    		uploadedConcept1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}        
    	if(!designerConcept2VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedConcept2ImageFromDB = adminAssignCon2InfoSaving.getConcept2ImageUpload();
    		uploadedConcept2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);
    		designConceptStatus = adminAssignCon2InfoSaving.getDesignerSubmitConceptsStatus();
    		adminAppConceptStatus1 = adminAssignCon2InfoSaving.getAdminApprovedForConcept();
    		secRenPayStatus = adminAssignCon2InfoSaving.getSecondRenderingPaymentStatus();
    	}        
    	if(!designerRoomRendering1VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRend1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedRmrend1ImageFromDB = adminAssignRend1InfoSaving.getRendering1ImageUpload();
    		uploadedRmrend1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRmrend1ImageFromDB);
    		designRenderingsStatus = adminAssignRend1InfoSaving.getDesignerSubmitRenderingStatus();
    		adminAppRenderingsStatus1 = adminAssignRend1InfoSaving.getAdminApprovedForRendering();
    	}     
    	if(!designerRoomRendering2VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRend2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering2UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedRmrend2ImageFromDB = adminAssignRend2InfoSaving.getRendering2ImageUpload();
    		uploadedRmrend2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRmrend2ImageFromDB);
    	}     
    	if(!designerRevisedRendering1VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRevRen1dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedRevrend1ImageFromDB = adminAssignRevRen1dInfoSaving.getRevisedRendering1ImageUpload();
    		uploadedRevrend1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRevrend1ImageFromDB);
    		designRevRenderingsStatus = adminAssignRevRen1dInfoSaving.getDesignerSubmitRevisedRenderingStatus();
    		adminAppRevRenderingsStatus1 = adminAssignRevRen1dInfoSaving.getAdminApprovedForRevisedRendering();
    	}     
    	if(!designerRevisedRendering2VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRevRen2dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedRevrend2ImageFromDB = adminAssignRevRen2dInfoSaving.getRevisedRendering2ImageUpload();
    		uploadedRevrend2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRevrend2ImageFromDB);
    	}    	
    	if(!designerSecondRendering1VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRevRen1dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedSecRevrend1ImageFromDB = adminAssignRevRen1dInfoSaving.getSecondRendering1ImageUpload();
    		uploadedSecRend1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedSecRevrend1ImageFromDB);
    		designSecRenderingsStatus = adminAssignRevRen1dInfoSaving.getDesignerSubmitSecondRenderingStatus();
    		adminAppSecRenderingsStatus1 = adminAssignRevRen1dInfoSaving.getAdminApprovedForSecondRendering();
    	}     
    	if(!designerSecondRendering2VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRevRen2dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2UpdationInDB(clientInfoId, designInfoId);
    		byte[] uploadedSecRevrend2ImageFromDB = adminAssignRevRen2dInfoSaving.getSecondRendering2ImageUpload();
    		uploadedSecRend2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedSecRevrend2ImageFromDB);
    	}    	
    	likeImagesValue = conceptRevisedRenderingLikeImagesDisplay(req, sn, clientInfoId, designInfoId);    	
    	List desnUploadedProductsList1 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoId, designInfoId);
    	List desnUploadedProductsList2 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoId, designInfoId);
    	List desnUploadedProductsList3 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
    	List desnUploadedProductsList4 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designInfoId);
    	List desnUploadedProductsList5 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designInfoId);                
    	mav = new ModelAndView("viewUploadFullRoomConceptsAndRenderings");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	mav.addObject("createdDate", formatedDate);
    	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
    	mav.addObject(designPackageVal, designPackage);
    	mav.addObject("clientFullName", customerName);
    	mav.addObject(designerFullName, desnFullName);    	
    	mav.addObject(concept1UploadedImage, uploadedConcept1Img);
    	mav.addObject(concept2UploadedImage, uploadedConcept2Img);
    	mav.addObject(uploadedRmrend1Image, uploadedRmrend1Img);
    	mav.addObject(uploadedRmrend2Image, uploadedRmrend2Img);
    	mav.addObject(uploadedRevrend1Image, uploadedRevrend1Img);
    	mav.addObject(uploadedRevrend2Image, uploadedRevrend2Img);
    	mav.addObject(uploadedSecRend1Image, uploadedSecRend1Img);
    	mav.addObject(uploadedSecRend2Image, uploadedSecRend2Img);     	
    	mav.addObject(designConceptsStatus, designConceptStatus);
    	mav.addObject(designRenderingStatus, designRenderingsStatus);
    	mav.addObject(designRevRenderingStatus, designRevRenderingsStatus);
    	mav.addObject(designSecRenderingStatus, designSecRenderingsStatus);     
    	mav.addObject(adminAppConceptStatus, adminAppConceptStatus1);
    	mav.addObject(adminAppRenderingsStatus, adminAppRenderingsStatus1);
    	mav.addObject(adminAppRevRenderingsStatus, adminAppRevRenderingsStatus1);
    	mav.addObject(adminAppSecRenderingsStatus, adminAppSecRenderingsStatus1);     
    	mav.addObject(desnUploadedProducts1Count, desnUploadedProductsList1.size());
    	mav.addObject(desnUploadedProducts2Count, desnUploadedProductsList2.size());
    	mav.addObject(desnUploadedProducts3Count, desnUploadedProductsList3.size());
    	mav.addObject(desnUploadedProducts4Count, desnUploadedProductsList4.size());
    	mav.addObject(desnUploadedProducts5Count, desnUploadedProductsList5.size());
    	mav.addObject(likeImagesValues, likeImagesValue);
    	mav.addObject(secRenPaymentStatus, secRenPayStatus);
    	mav.addObject("clientUpDBImagesList", clUpDBImagesList);
    	return mav;
    }

    public String clientUploadedInspireImageTakeFromDB(long clientInfoId, long designInfoId, long userId) {
    	String clUpDBImagesList = "";
 		List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification(userId, clientInfoId); 			
 		if(!clientUploadedInsImagesList.isEmpty()){
	       	for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {        		
	       		byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
	       		String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
	       		clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
	       	}
        clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
 		}  	
    	return clUpDBImagesList;
    }
    
    @Override
    @Transactional
    public ModelAndView designerFileUploadStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
    	ModelAndView mav;    	                
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);
		if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
    		adminAssignClInfoSaving.setDesignerUploads(null);
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
		}    	
    	mav = new ModelAndView();    	
    	return mav;
    }

    @Override
    @Transactional
    public String conceptRevisedRenderingLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId) {
   	 	String likeImagesValue = "";     	
     	List con3DRendLikeImgsList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);    	
     	if(!con3DRendLikeImgsList.isEmpty()){    		
   		AdminAssignClientInfoToDesignerSaving con3DRendLikeImgsValue = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);
   		String concept1LikeStatus = con3DRendLikeImgsValue.getConcept1LikeStatus();
   		String concept2LikeStatus = con3DRendLikeImgsValue.getConcept2LikeStatus();
   		String rendLikeStatus = con3DRendLikeImgsValue.getRenderingLikeStatus();
   		String revRendLikeStatus = con3DRendLikeImgsValue.getRevisedRenderingLikeStatus();
   		String secRendLikeStatus = con3DRendLikeImgsValue.getSecondRenderingLikeStatus();   		
   		String likeImage1Value = "";
   		String likeImage2Value = "";
   		String likeImage3Value = "";
   		String likeImage4Value = "";
   		String likeImage5Value = "";   		
   		if(null != concept1LikeStatus && !("").equals(concept1LikeStatus)) {
   			String[] con1LikeStatus = concept1LikeStatus.split(" ");
   			likeImage1Value = con1LikeStatus[0];
   		}   		
   		if(null != concept2LikeStatus && !("").equals(concept2LikeStatus)) {
   			String[] con2LikeStatus = concept2LikeStatus.split(" ");
   			likeImage2Value = con2LikeStatus[0];
   		}   		
   		if(null != rendLikeStatus && !("").equals(rendLikeStatus)) {
   			String[] renderLikeStatus = rendLikeStatus.split(" ");
   			likeImage3Value = renderLikeStatus[0];
   		}
   		if(null != revRendLikeStatus && !("").equals(revRendLikeStatus)) {
   			String[] reviRendLikeStatus = revRendLikeStatus.split(" ");
   			likeImage4Value = reviRendLikeStatus[0];
   		}
   		if(null != secRendLikeStatus && !("").equals(secRendLikeStatus)) {
   			String[] secdRendLikeStatus = secRendLikeStatus.split(" ");
   			likeImage5Value = secdRendLikeStatus[0];
   		}   		
   		likeImagesValue = likeImage1Value + "_" + likeImage2Value + "_" + likeImage3Value + "_" + likeImage4Value + "_" + likeImage5Value;    		
     	}
    	return likeImagesValue;
    }
     
    @Override
    @Transactional
    public ModelAndView adminApprovedConceptsAndRenderingsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	
		mav = viewDesignerDirectoryForClientsInAdmin(req, sn, designersInfoSavingId);    	    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminApprovedForAccConcepts1Redirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = accPackageViewUploadConceptsAndFinalConcepts(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminApprovedForAccConcepts2Redirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	 
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoSavingId, designersInfoSavingId);
        	adminAssignClInfoSaving.setAdminApprovedForConcept("Approved for Concepts");
        	adminAssignClInfoSaving.setConceptStatus("Approved for Concepts");
        	adminAssignClInfoSaving.setNewUploads("YES");
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminApprovedAllDesignsMailSentToDesigner(req, sn, designersInfoSavingId);
        }
        mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = accPackageViewUploadConceptsAndFinalConcepts(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminApprovedForFinalConceptsRedRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	 
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);
        	adminAssignClInfoSaving.setAdminApprovedForRendering("Approved for Renderings");
        	adminAssignClInfoSaving.setRenderingStatus("Approved for Renderings");
        	adminAssignClInfoSaving.setClientRequestedForRendering(null);
        	adminAssignClInfoSaving.setNewUploads("YES");
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminApprovedAllDesignsMailSentToDesigner(req, sn, designersInfoSavingId);
        }
        mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = accPackageViewUploadConceptsAndFinalConcepts(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }    

    @Override
    @Transactional
    public ModelAndView adminApprovedForConcepts1Redirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminApprovedForConcepts2Redirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	 
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoSavingId, designersInfoSavingId);
        	adminAssignClInfoSaving.setAdminApprovedForConcept("Approved for Concepts");
        	adminAssignClInfoSaving.setConceptStatus("Approved for Concepts");
        	adminAssignClInfoSaving.setNewUploads("YES");
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminApprovedAllDesignsMailSentToDesigner(req, sn, designersInfoSavingId);
        }
        mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminApprovedForRenderingsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	 
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);
        	adminAssignClInfoSaving.setAdminApprovedForRendering("Approved for Renderings");
        	adminAssignClInfoSaving.setRenderingStatus("Approved for Renderings");
        	adminAssignClInfoSaving.setClientRequestedForRendering(null);
        	adminAssignClInfoSaving.setNewUploads("YES");
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminApprovedAllDesignsMailSentToDesigner(req, sn, designersInfoSavingId);
        }
        mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminApprovedForRevisedRenderingsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	 
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);
        	adminAssignClInfoSaving.setAdminApprovedForRevisedRendering("Approved for Revised Renderings");
        	adminAssignClInfoSaving.setRevisedRenderingStatus("Approved for Revised Renderings");
        	adminAssignClInfoSaving.setNewUploads("YES");
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminApprovedAllDesignsMailSentToDesigner(req, sn, designersInfoSavingId);
        }
        mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminApprovedFor2ndRenderingsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	 
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
        	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);
        	adminAssignClInfoSaving.setAdminApprovedForSecondRendering("Approved for Second Renderings");
        	adminAssignClInfoSaving.setSecondRenderingStatus("Approved for Second Renderings");
        	adminAssignClInfoSaving.setNewUploads("YES");
        	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        	mav = adminApprovedAllDesignsMailSentToDesigner(req, sn, designersInfoSavingId);
        }
        mav = designerFileUploadStatusUpdateInDB(req, sn, clientInfoSavingId, designersInfoSavingId);
    	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoSavingId, designersInfoSavingId);   	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional    
    public ModelAndView adminApprovedAllDesignsMailSentToDesigner(HttpServletRequest req, HttpSession sn, long designerInfoId) {
    	ModelAndView mav;
        DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoId);
     	long designerUserId = designerInfoSaving.getDesignerId();
    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerUserId);        		
        String toAdd = userInformation.getUserName();
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "Your designs have been approved";            
        String type = "text/html";           
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";              
        String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                    + "<p style='padding-top: 5px;'>Your designs have been approved! This means your client can now see them. Make sure you send them a message as soon as possible about their designs. Log in to your account to send them a message now:</p>"
                    + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
                    + "<p style='padding-top: 5px;'>-Admin</p> <br/>"
                    + "</div>"
                    + "</body> ";            
        try {
        	userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
        } catch (Exception ex) {
        	LOGGER.error("Admin Approved All Designs Mail Sent To Designer failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
     }

    @Override
    @Transactional
    public ModelAndView clientRoomsInformationInAdmin(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String clientInfoSavingId = (String) sn.getAttribute(clientInfoSavingIdInSn);
    	long clientInfoSavingIdLong = Long.parseLong(clientInfoSavingId);    	
    	ClientInfoSaving clInfoSavingModel = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoSavingIdLong);
	    long desInfoSavingIdLong = clInfoSavingModel.getDesignerInfoSavingId();
	    ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForAdminSide(clientInfoSavingIdLong, desInfoSavingIdLong);
    	String typeOfSpace = clientInfoSaving.getTypeOfSpace();
        typeOfSpace = typeOfSpace.replace("_", " ");
        String typeOfStyle = clientInfoSaving.getTypeOfStyle();
        String budget = clientInfoSaving.getBudget();
        String designPackage = clientInfoSaving.getDesignPackage();
        String aboutSpaceDimn = clientInfoSaving.getSpaceDimension();
        String typeOfColor1 = clientInfoSaving.getTypeOfColor();
        String likeOfColor1 = clientInfoSaving.getLikeColor();
        String disLikeOfColor1 = clientInfoSaving.getDislikeColor();        
        String typeOfItem = clientInfoSaving.getTypeOfItemsList();
        String clAskedDenName = clientInfoSaving.getClientAskedDesignerName();
        String clHearAbtUs = clientInfoSaving.getClHearAboutUs();        
        String itemValueStr = clientRoomsItemsValuesGetting(typeOfItem);
        String otherItem1 = clientInfoSaving.getOtherItems();
        String alreadyHaveItem1 = clientInfoSaving.getAlreadyHaveItems();
        String artValue = clientInfoSaving.getTypeOfArtAppeals();
        if(null != artValue) {
        	artValue = artValue.replace("_", " ");
        }
        String moreAboutSpace1 = clientInfoSaving.getMoreAboutSpace();
        String shareInspiration1 = clientInfoSaving.getShareYourInspire();        
        DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(desInfoSavingIdLong);
        String desProfileImage = null;
        if(null != designerInfoSaving.getDesignerProfileImageBlob()) {
        	byte[] desProfileImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();
            desProfileImage = javax.xml.bind.DatatypeConverter.printBase64Binary(desProfileImageFromDB);
        } 
        List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.clientUploadedSpaceImagesRowIdVerification(clientInfoSavingIdLong, desInfoSavingIdLong);
        List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.clientUploadedInspireImagesRowIdVerification(clientInfoSavingIdLong, desInfoSavingIdLong);                
        String clUpDBImagesList = "";
        String clInsUpDBImagesList = "";
        if(!clientUploadedSpaceImagesList.isEmpty()){
        	for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {        		
        		byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
        		String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
        		clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;        		
        	}
        	clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
        }                
        if(!clientUploadedInsImagesList.isEmpty()){
        	for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {        		
        		byte[] uploadedInsImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
        		String buffDBInsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedInsImageFromDB);
        		clInsUpDBImagesList = clInsUpDBImagesList + "_,_" +buffDBInsImage;        		
        	}
        	clInsUpDBImagesList = clInsUpDBImagesList.replaceFirst("_,_", "");
        }          
    	mav = new ModelAndView("clientRoomInformation");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	mav.addObject(uploadPhForDes, clUpDBImagesList);
    	mav.addObject(uploadPhForDesCount, clientUploadedSpaceImagesList.size());
    	mav.addObject(insUploadPhoto, clInsUpDBImagesList);
    	mav.addObject(insUploadPhotoCount, clientUploadedInsImagesList.size());    	
    	mav.addObject(typeOfSpaceVal, typeOfSpace);
    	mav.addObject(typeOfStyleVal, typeOfStyle);
    	mav.addObject(budgetVal, budget);
    	mav.addObject(designPackageVal, designPackage);
    	mav.addObject(aboutSpaceDimnVal, aboutSpaceDimn);
    	mav.addObject(typeOfColor, typeOfColor1);
    	mav.addObject(likeOfColor, likeOfColor1);
    	mav.addObject(disLikeOfColor, disLikeOfColor1);
    	mav.addObject(otherItem, otherItem1);
    	mav.addObject(alreadyHaveItem, alreadyHaveItem1);
    	mav.addObject(artAppValue, artValue);    	
    	mav.addObject(moreAboutSpace, moreAboutSpace1);
    	mav.addObject(shareInspiration, shareInspiration1);    	
    	mav.addObject(allItemsVal, itemValueStr);    	
    	mav.addObject(designerProfileImage, desProfileImage);
    	mav.addObject("clAskedDesignerName", clAskedDenName);
    	mav.addObject("clHearAboutUs", clHearAbtUs);
    	return mav;
    }
    
    public String clientRoomsItemsValuesGetting(String typeOfItem) {
    	String itemValueStr = null;
        if(null != typeOfItem) {
        	String[] typeOfItemList = typeOfItem.split(", ");
        	for(int i = 0; i < typeOfItemList.length; i++) {
        		if(!("undefined").equals(typeOfItemList[i]) && null != typeOfItemList[i]) {
        			itemValueStr = itemValueStr + ", " + typeOfItemList[i];
        		}
        	}
        	itemValueStr = itemValueStr.replaceFirst("null, ", "");
        } 
    	return itemValueStr;
    }
    
    @Override
    @Transactional
    public ModelAndView desClientDirBackMoveRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String designerInfoId = (String) sn.getAttribute(designerInfoSavingIdInSn);    	
    	long designersInfoSavingId = Long.parseLong(designerInfoId);    	    	
    	mav = viewDesignerDirectoryForClientsInAdmin(req, sn, designersInfoSavingId);    		
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView giftCouponSendToUserRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String giftCardInfoSavingId = (String) sn.getAttribute(giftCardInfoSavingIdInSn);    	    	
    	long giftCardInfoID = Long.parseLong(giftCardInfoSavingId);    	
    	List selectedGiftCardRowIdList = giftInfoSavingDAOImpl.selectedGiftCardInfoDataChecking(giftCardInfoID);    	
    	String recEmail = null;
    	String couponCode = null;
    	String recFullName = null;
    	if(!selectedGiftCardRowIdList.isEmpty()){    		
    		GiftInfoSaving giftCardInfoSaving = giftInfoSavingDAOImpl.viewGiftCardInfoDataDisplay(giftCardInfoID);
    		giftCardInfoSaving.setStatus("SENT");
    		giftInfoSavingDAOImpl.merge(giftCardInfoSaving);
    		recEmail = giftCardInfoSaving.getRecEmailarAddress();
    		couponCode = giftCardInfoSaving.getGiftCardCouponCode();
    		recFullName = giftCardInfoSaving.getYourName();
    	}    	
    	if(null != recEmail) {
    		String aTo = recEmail;
            String aSubject = "Nook Cove Coupon Code.";
            String gcCouponCode = couponCode;
            String type = "text/html";
            EmailSending userEmail = new EmailSending();
            String fromAdd = "info@nookandcove.com";            
            String body = "<body> <div style='margin-left: 68px;margin-top:10px;background: #f1f1f1;width: 650px;box-shadow: 3px 3px 0px #7e7e7e;height:auto;'> "
                    + "<div style='background: #666666;height: 35px;width:651px;margin-top:-3px;position:absolute;'>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font style='margin-top: 10px; text-align: justify; color: white;font-size:20px;font-family:Georgia;position:absolute;'><b> NookCove <font color='yellow'>-</font> Gift Card Coupon Code</b></font> "
                    + "</div> "
                    + "<div style='margin-top: 5px; width: 600px; height: auto;font: 1.0em/1.26em sans-serif;text-align: justify;'> <br/><br/>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>Hello &nbsp;<font style=' color: #00a9f1;'>" + recFullName + ",</font></b> <br/><br/><br/> "
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Gift Card Coupon Code &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <b>" + gcCouponCode + "</b> <br/><br/><br/> "                    
                    + "</div><br/><br/></div>"
                    + "</body> ";            
            try {
                userEmail.sendEmail(aTo, aSubject, body, type, fromAdd);
            } catch (Exception ex) {
            	LOGGER.error("Coupon Code sending failed " + ex);
            }
    	}    	
    	mav = newGiftCardsRedirection(req, sn);    		
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView amnAccountsInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.findAll();
        List<ClientPackageAndRenderingPaymentInfoSaving> packgePaymentCountList = clientPackageAndRenderingPaymentInfoSavingDAO.clientPackagePaymentCountInAdmin();
        List<ClientPackageAndRenderingPaymentInfoSaving> renderingPaymentCountList = clientPackageAndRenderingPaymentInfoSavingDAO.client2ndRenderingPaymentCountInAdmin();
        List<UserInformation> subAdminsInfoList = userInformationDAO.subAdminListDisplayInAdmin();
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
    	mav = new ModelAndView(accountsInfoRedirection);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));        
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        mav.addObject(allGiftCardsCount, giftCardRowsList.size());
        mav.addObject(packgePaymentCount, packgePaymentCountList.size());
        mav.addObject(renderingPaymentCount, renderingPaymentCountList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        mav.addObject("subAdminsCount", subAdminsInfoList.size());
        return mav;
    }
      
    @Override
    @Transactional
    public ModelAndView adminAllConceptsProductBackMove(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;     
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	   	
    	mav = fullRoomViewUploadConceptsAndRenderings(req, sn, clientInfoSavingId, designersInfoSavingId);
    	return mav;
    }
 
    @Override
    @Transactional
    public ModelAndView adminAccConceptsProductBackMove(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;	 
    	long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	   	
    	mav = accPackageViewUploadConceptsAndFinalConcepts(req, sn, clientInfoSavingId, designersInfoSavingId);
    	return mav;
    }
 
    @Override
    @Transactional
    public ModelAndView desnUploadedAccConcept1ViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;               
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);        
   	   	String uploadedConcept1Image = "";   	   	
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}      
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0;
        List<FurnitureSpecsProductsAccPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}    	        
       mav = new ModelAndView("designerUploadedAccConcept1ViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept1UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView cdesnUploadedAccConcept2ViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;        
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);        
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept2ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0;
        List<FurnitureSpecsProductsAccPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}    	        
       mav = new ModelAndView("designerUploadedAccConcept2ViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept2UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView desnUploadedFinalConceptsViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);        
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0;
        List<FurnitureSpecsProductsAccPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsAccPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}       
       mav = new ModelAndView("designerUploadedFinalConceptsViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept2UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }    

    @Override
    @Transactional
    public ModelAndView desnUploadedConcept1ViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;               
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);        
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0;
        List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}      
       mav = new ModelAndView("designerUploadedConcept1ViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept1UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView cdesnUploadedConcept2ViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;        
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getConcept2ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0; 
        List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}      
       mav = new ModelAndView("designerUploadedConcept2ViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept1UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView desnUploadedRoomRenderingViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	   ModelAndView mav;
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRendering1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0; 
        List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}       
    	mav = new ModelAndView("designerUploadedRoomRenderingViewProducts");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
    	mav.addObject(concept1UploadedImage, uploadedConcept1Image);
    	mav.addObject(viewProductImagesList, productImagesList);        
    	mav.addObject(viewProductNamesList, productNamesList);
    	mav.addObject(viewProductQuantityList, productQuantityList);
    	mav.addObject(viewProductPriceList, productPriceList);
    	mav.addObject(viewProductDescriptionList, productDescriptionList);
    	mav.addObject(viewProductsIdList, productsIdList);
    	mav.addObject(totalProdPriceInDB, totalProdPrice);
    	mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView desnUploadedRevisedRenderingViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getRevisedRendering1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0;
        List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   	}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}      
       mav = new ModelAndView("designerUploadedRevRenderingViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept1UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }

    @Override
    @Transactional
    public ModelAndView desnUploaded2ndRenderingViewProductsRe(HttpServletRequest req, HttpSession sn) {
   	    ModelAndView mav;
        long clientInfoSavingId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designersInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);        
   	   	String uploadedConcept1Image = "";
   	   	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInDB(clientInfoSavingId, designersInfoSavingId);            
        if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInDB(clientInfoSavingId, designersInfoSavingId);    		    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignClInfoSaving.getSecondRendering1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);    		
    	}   	   	       
        String productImagesList = "";
        String productNamesList = "";
        String productQuantityList = "";
        String productPriceList = "";
        String productDescriptionList = "";
        String productsIdList = "";
        String assemblyRequiredStatusList = "";
        String totalProdPrice = "";
 	   	String totalProductPrice = "";
 	   	double totlProductPrice = 0.0; 
        List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecs1ProductsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoSavingId, designersInfoSavingId);
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
        		long productId = furnSpecs1ProductsModel.getFurnitureSpecsProductsFullRoomPackSavingId();
        		productsIdList = productsIdList + "_,_" + productId;
        		String assemReqStatus = furnSpecs1ProductsModel.getAssemblyRequiredStatus();
 			   	assemblyRequiredStatusList = assemblyRequiredStatusList + "_,_" + assemReqStatus; 			   	
 			   	int ProdQuantity = furnSpecs1ProductsModel.getProductQuantity();    			
 			   	String prodPrice = furnSpecs1ProductsModel.getProductPrice();
 			   	prodPrice = prodPrice.replace(",","");
 			   	prodPrice = prodPrice.replace("$","");
 			   	double prodtPrice = Double.parseDouble(prodPrice);
 			   	double totProductsPrice = prodtPrice * ProdQuantity;
 			   	totlProductPrice = totlProductPrice + totProductsPrice;
		   		}
    		productImagesList = productImagesList.replaceFirst("_,_", "");
        	productNamesList = productNamesList.replaceFirst("_,_", "");
        	productQuantityList = productQuantityList.replaceFirst("_,_", "");
        	productPriceList = productPriceList.replaceFirst("_,_", "");
        	productDescriptionList = productDescriptionList.replaceFirst("_,_", "");
        	productsIdList = productsIdList.replaceFirst("_,_", "");
        	assemblyRequiredStatusList = assemblyRequiredStatusList.replaceFirst("_,_", "");            
    		totalProductPrice = String.format("%.2f", totlProductPrice);
         	totalProdPrice = "$" + totalProductPrice;
    	}       
       mav = new ModelAndView("designerUploaded2ndRenderingViewProducts");
       mav.addObject(flName, sn.getAttribute(firstNamesInSn));
       mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
       mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
       mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
       mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));       
       mav.addObject(concept1UploadedImage, uploadedConcept1Image);
       mav.addObject(viewProductImagesList, productImagesList);        
       mav.addObject(viewProductNamesList, productNamesList);
       mav.addObject(viewProductQuantityList, productQuantityList);
       mav.addObject(viewProductPriceList, productPriceList);
       mav.addObject(viewProductDescriptionList, productDescriptionList);
       mav.addObject(viewProductsIdList, productsIdList);
       mav.addObject(totalProdPriceInDB, totalProdPrice);
       mav.addObject(viewAssemblyRequiredStatusList, assemblyRequiredStatusList);
       return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView promoCodeDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List<PromoCodeInfoSaving> selectedPromoCodeList = promoCodeInfoSavingDAO.selectedPromocodeVerification();
        if (!selectedPromoCodeList.isEmpty()) {
        	mav = new ModelAndView("redirect:" + "reDirPromoCodeDisp");
        } else {
        	mav = new ModelAndView(promocodeRedirection);
        }
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
    	List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());
    	sn.setAttribute(promoCodeIdInSn, null);
    	mav.addObject(adminMBNewImgDsp, admnNewImgSt);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView newPromoCodeDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(promocodeRedirection);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView promoCodeDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	PromoCodeInfoSaving promoCodeModel = new PromoCodeInfoSaving();    	
    	promoCodeModel.setPromoCode(req.getParameter(promoCode));
    	promoCodeModel.setDiscount(req.getParameter(discount));
    	promoCodeModel.setPromoNote(req.getParameter(promoNote));
    	promoCodeModel.setCreatedDate(currentDate);
    	promoCodeInfoSavingDAO.save(promoCodeModel);    	
    	mav = new ModelAndView("redirect:" + "reDirPromoCodeDisp");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView promoCodeManagementDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<PromoCodeInfoSaving> selectedPromoCodeList = promoCodeInfoSavingDAO.selectedPromocodeVerification();
        if (!selectedPromoCodeList.isEmpty()) {        	
            List<PromoCodeInfoSaving> promoCodeSavingList = new ArrayList<PromoCodeInfoSaving>();
            for (PromoCodeInfoSaving promoCodeInfoLoop : selectedPromoCodeList) {
            	PromoCodeInfoSaving promoCodeModel = new PromoCodeInfoSaving();
            	promoCodeModel.setPromoCodeInfoSavingId(promoCodeInfoLoop.getPromoCodeInfoSavingId());
            	promoCodeModel.setCreatedDate(promoCodeInfoLoop.getCreatedDate());
            	promoCodeModel.setPromoCode(promoCodeInfoLoop.getPromoCode());
            	promoCodeModel.setDiscount(promoCodeInfoLoop.getDiscount());
            	promoCodeModel.setPromoNote(promoCodeInfoLoop.getPromoNote());
            	promoCodeSavingList.add(promoCodeModel);
            }            
            mav = new ModelAndView(promocodeManagement);
            mav.addObject("promoCodeDataSavingList", promoCodeSavingList);
            mav.addObject("promoCodeCount", promoCodeSavingList.size());            
        } else{
        	mav = promoCodeDisplayRedirection(req, sn);
        }
        String admnNewImgSt = amnDesignerDirectoryNewStatusDsp(req, sn);
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        mav.addObject(adminMBNewImgDsp, admnNewImgSt);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView promoCodeManagementModification(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String newProCode = req.getParameter("promoCodeRefType");
    	if(null != newProCode && ("New PromoCode").equals(newProCode)) {
    		mav = new ModelAndView("redirect:" + "newPromoCodeDisplay");
    	} else {
    	long promoCodeId = Long.parseLong(req.getParameter("promoCodeId"));
    	List<PromoCodeInfoSaving> promoCodeDataList = promoCodeInfoSavingDAO.promocodeDataListFromDB(promoCodeId);
	        if (!promoCodeDataList.isEmpty()) {
	        	PromoCodeInfoSaving promoCodeModel = promoCodeInfoSavingDAO.promocodeSelectedDataListFromDB(promoCodeId);
	        	promoCodeInfoSavingDAO.delete(promoCodeModel);
	        }
        	mav = new ModelAndView("redirect:" + "reDirPromoCodeDisp");
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView newGiftCardsForAccRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GiftInfoSaving> selectedAdminRowIdList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<GiftInfoSaving> admnGiftCardSavingList = new ArrayList<GiftInfoSaving>();
            for (GiftInfoSaving giftInfoLoop : selectedAdminRowIdList) {
            	GiftInfoSaving giftInfoSavingModel = new GiftInfoSaving();
            	giftInfoSavingModel.setCreatedDate(giftInfoLoop.getCreatedDate());            	
            	giftInfoSavingModel.setYourName(giftInfoLoop.getYourName());
            	String totalPrice = giftInfoLoop.getTotalPrice();
            	giftInfoSavingModel.setPackagePrice(totalPrice);            	
            	giftInfoSavingModel.setGiftCardCouponCode(giftInfoLoop.getGiftCardCouponCode());
            	giftInfoSavingModel.setGiftCardInfoSavingId(giftInfoLoop.getGiftCardInfoSavingId());            	
            	giftInfoSavingModel.setStatus(giftInfoLoop.getStatus());
            	giftInfoSavingModel.setCouponCodeUsedStatus(giftInfoLoop.getRemainingGiftPrice());
            	admnGiftCardSavingList.add(giftInfoSavingModel);
            }            
            mav = new ModelAndView(newGiftCardsManagementForAccounts);
            mav.addObject("giftCardInfoSavingList", admnGiftCardSavingList);
            mav.addObject("giftCardInfoListCount", selectedAdminRowIdList.size());                       
        } else{
        	mav = new ModelAndView(newGiftCardsManagementForAccounts);            
        }
        List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView sentGiftCardsForAccRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GiftInfoSaving> selectedAdminRowIdList = giftInfoSavingDAOImpl.sentGiftCardsDataTakeFromDB();
        if (!selectedAdminRowIdList.isEmpty()) {        	
            List<GiftInfoSaving> admnGiftCardSavingList = new ArrayList<GiftInfoSaving>();
            for (GiftInfoSaving giftInfoLoop : selectedAdminRowIdList) {
            	GiftInfoSaving giftInfoSavingModel = new GiftInfoSaving();
            	giftInfoSavingModel.setCreatedDate(giftInfoLoop.getCreatedDate());            	
            	giftInfoSavingModel.setYourName(giftInfoLoop.getYourName());
            	String totalPrice = giftInfoLoop.getTotalPrice();
            	giftInfoSavingModel.setPackagePrice(totalPrice);            	
            	giftInfoSavingModel.setGiftCardCouponCode(giftInfoLoop.getGiftCardCouponCode());
            	giftInfoSavingModel.setGiftCardInfoSavingId(giftInfoLoop.getGiftCardInfoSavingId());            	
            	giftInfoSavingModel.setStatus(giftInfoLoop.getStatus());
            	giftInfoSavingModel.setCouponCodeUsedStatus(giftInfoLoop.getRemainingGiftPrice());
            	admnGiftCardSavingList.add(giftInfoSavingModel);
            }            
            mav = new ModelAndView(sentGiftCardsManagementForAccounts);
            mav.addObject("giftCardInfoSavingList", admnGiftCardSavingList);
            mav.addObject("giftCardInfoListCount", selectedAdminRowIdList.size());                       
        } else{
        	mav = new ModelAndView(sentGiftCardsManagementForAccounts);            
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView viewGiftCardInfoForAccRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	String giftCardInfoID = req.getParameter("giftCardId");    	
    	sn.setAttribute(giftCardInfoSavingIdInSn, giftCardInfoID);
    	long giftCardID = Long.parseLong(giftCardInfoID);    	
    	GiftInfoSaving giftInfoSaving = giftInfoSavingDAOImpl.viewGiftCardInfoDataDisplay(giftCardID);    	
     	String typeOfPackage = giftInfoSaving.getTypeOfPackage();
     	String packagePrice = giftInfoSaving.getPackagePrice();     	
     	String merchandiseCredit = giftInfoSaving.getMerchandiseCredit();
     	String typeOfGiftcard = giftInfoSaving.getTypeOfGiftcard();
     	String typeOfDeliveryMethod = giftInfoSaving.getTypeOfDeliveryMethod();
     	String giftRecipientName = giftInfoSaving.getGiftRecipientName();
     	String giftRecipientAddress = giftInfoSaving.getGiftRecipientAddress();
     	String giftRecipientCity = giftInfoSaving.getGiftRecipientCity();
     	String giftRecipientState = giftInfoSaving.getGiftRecipientState();
     	String recZipCode = giftInfoSaving.getGiftRecipientZipCode();     	
     	String recEmailarName = giftInfoSaving.getRecEmailarName();
     	String recEmailarAddress = giftInfoSaving.getRecEmailarAddress();
     	String yourName = giftInfoSaving.getYourName();
     	String yourEmail = giftInfoSaving.getYourEmail();
     	String giftMessage = giftInfoSaving.getGiftMessage();
     	String deliveryDate = giftInfoSaving.getDeliveryDate();     	
    	mav = new ModelAndView(viewGiftCardInfoForAccounts);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	mav.addObject("typeOfPackage",typeOfPackage);
    	mav.addObject("packagePrice",packagePrice);
    	mav.addObject("merchandiseCredit",merchandiseCredit);
    	mav.addObject("typeOfGiftcard",typeOfGiftcard);
    	mav.addObject("typeOfDeliveryMethod",typeOfDeliveryMethod);
    	mav.addObject("giftRecipientName",giftRecipientName);
    	mav.addObject("giftRecipientAddress",giftRecipientAddress);
    	mav.addObject("giftRecipientCity",giftRecipientCity);
    	mav.addObject("giftRecipientState",giftRecipientState);
    	mav.addObject("recZipCode",recZipCode);
    	mav.addObject("recEmailarName",recEmailarName);
    	mav.addObject("recEmailarAddress",recEmailarAddress);
    	mav.addObject("yourName",yourName);
    	mav.addObject("yourEmail",yourEmail);
    	mav.addObject("giftMessage",giftMessage);
    	mav.addObject("recptZipCode",recZipCode);
    	mav.addObject("deliveryDate",deliveryDate);    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminPackagePaymentForAccRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<Object> packgePaymentSavingList = (List<Object>) clientPackageAndRenderingPaymentInfoSavingDAO.clientPackagePaymentRowVerUsingJoins();
    	List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
    	if (!packgePaymentSavingList.isEmpty()) {
    		List<ClientInfoSaving> admnPurchasesSavingList = new ArrayList<ClientInfoSaving>();    		
            Iterator packgePaymentSavingIterator = packgePaymentSavingList.iterator();
            while (packgePaymentSavingIterator.hasNext()) {
            	Object[] packgePaymentSavingObj = (Object[]) packgePaymentSavingIterator.next();
                ClientInfoSaving clientInfoSavingModel = new ClientInfoSaving();
                String createdDate = String.valueOf(packgePaymentSavingObj[0]);                
                String typeOfSpace = String.valueOf(packgePaymentSavingObj[1]);
                String desnPack = String.valueOf(packgePaymentSavingObj[2]);
                String fName = String.valueOf(packgePaymentSavingObj[3]);
            	String lName = String.valueOf(packgePaymentSavingObj[4]);
            	String dsnInfoId = String.valueOf(packgePaymentSavingObj[5]);            	            	
                typeOfSpace = typeOfSpace.replace("_", " ");
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}
            	String fullName = fName + " " + lName;
            	long desnInfoId = Long.parseLong(dsnInfoId);
            	String dsignStatus = null;
            	if(desnInfoId > 0) {
            		dsignStatus = "ASSIGNED";
            	}            	
            	Timestamp startDate = Timestamp.valueOf(createdDate);
            	clientInfoSavingModel.setCreatedDate(startDate);
            	clientInfoSavingModel.setTypeOfSpace(typeOfSpace);
            	clientInfoSavingModel.setDesignPackage(designPackage);
            	clientInfoSavingModel.setLikeColor(fullName);
            	clientInfoSavingModel.setDislikeColor(dsignStatus);
            	admnPurchasesSavingList.add(clientInfoSavingModel);
            }    		           
            mav = new ModelAndView(packagePaymentForAccounts);
            mav.addObject("packagePaymentSavingList", admnPurchasesSavingList);
            mav.addObject("packagePaymentListCount", packgePaymentSavingList.size());            
        } else{
        	mav = new ModelAndView(packagePaymentForAccounts);            
        }
    	List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminSecRenderingPaymentForAccRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<Object> packgePaymentSavingList = (List<Object>) clientPackageAndRenderingPaymentInfoSavingDAO.client2ndRenderingPaymentRowVerUsingJoins();
    	List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
    	if (!packgePaymentSavingList.isEmpty()) {
    		List<ClientInfoSaving> admnPurchasesSavingList = new ArrayList<ClientInfoSaving>();    		
            Iterator packgePaymentSavingIterator = packgePaymentSavingList.iterator();
            while (packgePaymentSavingIterator.hasNext()) {
            	Object[] packgePaymentSavingObj = (Object[]) packgePaymentSavingIterator.next();
                ClientInfoSaving clientInfoSavingModel = new ClientInfoSaving();
                String createdDate = String.valueOf(packgePaymentSavingObj[0]);                
                String typeOfSpace = String.valueOf(packgePaymentSavingObj[1]);
                String desnPack = String.valueOf(packgePaymentSavingObj[2]);
                String fName = String.valueOf(packgePaymentSavingObj[3]);
            	String lName = String.valueOf(packgePaymentSavingObj[4]);
            	String dsnFullName = String.valueOf(packgePaymentSavingObj[5]);            	            	
                typeOfSpace = typeOfSpace.replace("_", " ");
            	String designPackage = null;
            	if(("Accessories Package").equals(desnPack)) {
            		designPackage = "ACCESSORIES";
            	} else {
            		designPackage = "FULL DESIGN";
            	}
            	String fullName = fName + " " + lName;            	            	
            	Timestamp startDate = Timestamp.valueOf(createdDate);
            	clientInfoSavingModel.setCreatedDate(startDate);
            	clientInfoSavingModel.setTypeOfSpace(typeOfSpace);
            	clientInfoSavingModel.setDesignPackage(designPackage);
            	clientInfoSavingModel.setLikeColor(fullName);
            	clientInfoSavingModel.setDislikeColor(dsnFullName);
            	admnPurchasesSavingList.add(clientInfoSavingModel);
            }    		           
            mav = new ModelAndView(secRenderingPaymentForAccounts);
            mav.addObject("secnRendrPaymentSavingList", admnPurchasesSavingList);
            mav.addObject("secnRendrPaymentListCount", packgePaymentSavingList.size());            
        } else{
        	mav = new ModelAndView(secRenderingPaymentForAccounts);            
        }
    	List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminPurchasesInfoForAccRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	 
    	List<ShoppingCartPaymentInfoSaving> shopCartPaymentSavingList = shoppingCartPaymentInfoSavingDAO.adminPurchasesInfoRowVerification();
    	if (!shopCartPaymentSavingList.isEmpty()) {        	
            List<ShoppingCartPaymentInfoSaving> admnPurchasesSavingList = new ArrayList<ShoppingCartPaymentInfoSaving>();
            for (ShoppingCartPaymentInfoSaving purchaseInfoLoop : shopCartPaymentSavingList) {
            	ShoppingCartPaymentInfoSaving purchaseInfoSavingModel = new ShoppingCartPaymentInfoSaving();
            	purchaseInfoSavingModel.setCreatedDate(purchaseInfoLoop.getCreatedDate());            	
            	UserInformation userInformation = userInformationDAO.updatedRowIdVerification(purchaseInfoLoop.getUserId());
            	String fName = userInformation.getFirstName();
            	String lName = userInformation.getLastName();
            	String fullName = fName + " " + lName;
            	purchaseInfoSavingModel.setShipFullName(fullName);
            	purchaseInfoSavingModel.setBillAddress1(purchaseInfoLoop.getOrderedStatus());
            	purchaseInfoSavingModel.setBillAddress2(purchaseInfoLoop.getDeliveredStatus());
            	String reviwOrdStatus = purchaseInfoLoop.getReviewOrderStatus();
            	String orderStatus = null;
            	if(("Place My Order").equals(reviwOrdStatus)) {
            		orderStatus = "YES";
            	} else {
            		orderStatus = "NO";
            	}
            	purchaseInfoSavingModel.setReviewOrderStatus(orderStatus);
            	purchaseInfoSavingModel.setShoppingCartPaymentInfoSavingId(purchaseInfoLoop.getShoppingCartPaymentInfoSavingId());
            	admnPurchasesSavingList.add(purchaseInfoSavingModel);
            }            
            mav = new ModelAndView(purchasesInfoRedForAccounts);
            mav.addObject("purchasesInfoSavingList", admnPurchasesSavingList);
            mav.addObject("purchasesInfoListCount", shopCartPaymentSavingList.size());            
        } else{
        	mav = new ModelAndView(purchasesInfoRedForAccounts);            
        }
    	List<GiftInfoSaving> giftCardRowsList = giftInfoSavingDAOImpl.newGiftCardsDataTakeFromDB();        
        sn.setAttribute(giftCardsCountInSn, giftCardRowsList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        List<ClientInfoSaving> newClientCountList = clientInfoSavingDAO.clientInfoDisplyInAdminNewCleintsUsingStatus();
        mav.addObject(newClientsCount, newClientCountList.size());
        mav.addObject(purchasesItemsCount, shopCartPaymentSavingList.size());
        sn.setAttribute(purchasesItemsCountInSn, shopCartPaymentSavingList.size());
        sn.setAttribute(newClientsCountInSn, newClientCountList.size());    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminChangePasswordRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(adminChangePasswordRedirection);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminChangePasswordSavingInDBTable(HttpServletRequest req, HttpSession sn) {
     	long userId = (Long) sn.getAttribute(userIdInSn);
     	UserInformation userInfoSavingModel = userInformationDAO.updatedRowIdVerification(userId);    	
    	String userName2 = userInfoSavingModel.getUserName();     	 
        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String encrypCurPassword = mD5Encrypt(currentPassword);
        String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
        String encrypNewPassword = mD5Encrypt(newPassword);
        String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);        
        UserInformation userData = userInformationDAO.findByUserInfoFromDB(userName2);
        String oldPassSalt = userData.getPasswordSalt();        
        ModelAndView mav;
        if (currentPasswordSalt.equals(oldPassSalt)) {        	
        	UserInformation userInfoModel = userInformationDAO.findByUserInfoFromDB(userName2);        	
        	userInfoModel.setPassword(encrypNewPassword);
        	userInfoModel.setPasswordSalt(newPasswordSalt);        	
            userInformationDAO.merge(userInfoModel);
            mav = amnAccountsInfoRedirection(req, sn);           
            mav.addObject("adminPassMessage", "Admin Password");
        } else {        	
        	mav = new ModelAndView(adminChangePasswordRedirection);        	
            mav.addObject("changePasswordError", " Invalid Current Password");            
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView createSubAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<UserInformation> subAdminsInfoList = userInformationDAO.subAdminListDisplayInAdmin();
    	if (!subAdminsInfoList.isEmpty()) {
    		mav = subAdminsListDisplayRed(req, sn);
    	} else {
    		mav = new ModelAndView(createSubAdminRedirection);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView createSubAdminDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	String fName = req.getParameter(firstName);
    	String lName = req.getParameter(lastName);
        String uName = req.getParameter(userName);
        String uPassword = req.getParameter(createPassword);        
        List regDataVal = userInformationDAO.findByUserName(uName);
        ModelAndView mav;
        if (!regDataVal.isEmpty()) {
            mav = new ModelAndView(createSubAdminRedirection);
            mav.addObject("regErrorPage", " E-mail already exists!");
        } else {
            String encrypPassword = mD5Encrypt(uPassword);
            String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
            String passwordSalt = mD5Encrypt(encrypPassword + salt);
            Timestamp currentDate = currentDate();
            UserInformation uiModel = new UserInformation();
            uiModel.setFirstName(fName);
            uiModel.setLastName(lName);
            uiModel.setUserName(uName);
            uiModel.setPassword(encrypPassword);
            uiModel.setPasswordSalt(passwordSalt);            
            uiModel.setTypeOfUser("S");
            uiModel.setCreatedDate(currentDate);
            userInformationDAO.save(uiModel);            
            mav = subAdminsListDisplayRed(req, sn);
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView subAdminsListDisplayRed(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<UserInformation> subAdminsInfoList = userInformationDAO.subAdminListDisplayInAdmin();
    	if (!subAdminsInfoList.isEmpty()) {        	
            List<UserInformation> userInfoSavingList = new ArrayList<UserInformation>();
            for (UserInformation userInfoLoop : subAdminsInfoList) {
            	UserInformation userInfoSavingModel = new UserInformation();            	
            	String fName = userInfoLoop.getFirstName();
            	String lName = userInfoLoop.getLastName();
            	String fullName = fName + " " + lName;            	
            	userInfoSavingModel.setFirstName(fullName);
            	userInfoSavingModel.setUserName(userInfoLoop.getUserName());            	          	
            	userInfoSavingModel.setUserId(userInfoLoop.getUserId());
            	userInfoSavingModel.setCreatedDate(userInfoLoop.getCreatedDate());
            	userInfoSavingModel.setUpdatedDate(userInfoLoop.getUpdatedDate());
            	userInfoSavingList.add(userInfoSavingModel);
            }
            mav = new ModelAndView(subAdminsListDisplay);
            mav.addObject("subAdminDisplayList", userInfoSavingList);
            mav.addObject("subAdminDisplayListCount", subAdminsInfoList.size());                       
        } else{
        	mav = createSubAdminRedirection(req, sn);
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView subAdminDeleteFromDBTable(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String subAdminDeleteReff = req.getParameter("subAdminDeleteRef");    	
    	if(("Sub Admin Back").equals(subAdminDeleteReff)) {
    		mav = amnAccountsInfoRedirection(req, sn);
    	} else if(("New Sub Admin").equals(subAdminDeleteReff)) {
    		mav = createNewSubAdminRedirection(req, sn);
    	} else if(("Delete Sub Admin").equals(subAdminDeleteReff)) {
    		long subAdminId = Long.parseLong(req.getParameter("subAdminDisplayId"));
    		UserInformation subAdminModel = userInformationDAO.deleteSubAdminFromDB(subAdminId);
    		userInformationDAO.delete(subAdminModel);
    		mav = subAdminsListDisplayRed(req, sn);
    	} else {
    		mav = createSubAdminRedirection(req, sn);
    	}    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
        mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
        mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
        mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView createNewSubAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(createNewSubAdminRedirection);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

	@Override
	@Transactional
	public ModelAndView allGiftCardsDailyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    String totGiftAmt = null;	    
	    List<GiftInfoSaving> giftCardDailyReportsList = giftInfoSavingDAOImpl.allGiftCardInfoDailyReports(todayDate);
	    if (!giftCardDailyReportsList.isEmpty()) {
	    	double giftPriceInDB = 0.0;
            for (GiftInfoSaving giftCardInfoLoop : giftCardDailyReportsList) {
            	String typeOfPackage = giftCardInfoLoop.getTypeOfPackage();
            	String gfPrice = giftCardInfoLoop.getRemainingGiftPrice();
            	double gfPriceInDB = Double.parseDouble(gfPrice);
            	giftPriceInDB = giftPriceInDB + gfPriceInDB; 
            	String usedGiftSt = giftCardInfoLoop.getUsedGiftStatus();            	            	
            	if(("USED").equals(usedGiftSt)) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            }
            totGiftAmt = String.format("%.2f", giftPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminGiftCardDailyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, giftCardDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totGiftAmt);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allGiftCardsWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -7);
	    String weeklyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totGiftAmt = null;	    
	    List<GiftInfoSaving> giftCardDailyReportsList = giftInfoSavingDAOImpl.allGiftCardInfoTotalReports(todayDate, weeklyDate);
	    if (!giftCardDailyReportsList.isEmpty()) {	    	
	    	double giftPriceInDB = 0.0;
            for (GiftInfoSaving giftCardInfoLoop : giftCardDailyReportsList) {
            	String typeOfPackage = giftCardInfoLoop.getTypeOfPackage();
            	String gfPrice = giftCardInfoLoop.getRemainingGiftPrice();
            	double gfPriceInDB = Double.parseDouble(gfPrice);
            	giftPriceInDB = giftPriceInDB + gfPriceInDB; 
            	String usedGiftSt = giftCardInfoLoop.getUsedGiftStatus();
            	String reffDate = giftCardInfoLoop.getCreatedDateInSt();            	            	
            	if(("USED").equals(usedGiftSt)) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totGiftAmt = String.format("%.2f", giftPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminGiftCardWeeklyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, giftCardDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totGiftAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allGiftCardsMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -30);
	    String monthlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totGiftAmt = null;	    
	    List<GiftInfoSaving> giftCardDailyReportsList = giftInfoSavingDAOImpl.allGiftCardInfoTotalReports(todayDate, monthlyDate);
	    if (!giftCardDailyReportsList.isEmpty()) {	    	
	    	double giftPriceInDB = 0.0;
            for (GiftInfoSaving giftCardInfoLoop : giftCardDailyReportsList) {
            	String typeOfPackage = giftCardInfoLoop.getTypeOfPackage();
            	String gfPrice = giftCardInfoLoop.getRemainingGiftPrice();
            	double gfPriceInDB = Double.parseDouble(gfPrice);
            	giftPriceInDB = giftPriceInDB + gfPriceInDB; 
            	String usedGiftSt = giftCardInfoLoop.getUsedGiftStatus();
            	String reffDate = giftCardInfoLoop.getCreatedDateInSt();            	            	
            	if(("USED").equals(usedGiftSt)) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totGiftAmt = String.format("%.2f", giftPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminGiftCardMonthlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, giftCardDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totGiftAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allGiftCardsQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -90);
	    String quarterlyDate = formatter.format(cal.getTime());	    	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totGiftAmt = null;	    
	    List<GiftInfoSaving> giftCardDailyReportsList = giftInfoSavingDAOImpl.allGiftCardInfoTotalReports(todayDate, quarterlyDate);
	    if (!giftCardDailyReportsList.isEmpty()) {	    	
	    	double giftPriceInDB = 0.0;
            for (GiftInfoSaving giftCardInfoLoop : giftCardDailyReportsList) {
            	String typeOfPackage = giftCardInfoLoop.getTypeOfPackage();
            	String gfPrice = giftCardInfoLoop.getRemainingGiftPrice();
            	double gfPriceInDB = Double.parseDouble(gfPrice);
            	giftPriceInDB = giftPriceInDB + gfPriceInDB; 
            	String usedGiftSt = giftCardInfoLoop.getUsedGiftStatus();
            	String reffDate = giftCardInfoLoop.getCreatedDateInSt();            	            	
            	if(("USED").equals(usedGiftSt)) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totGiftAmt = String.format("%.2f", giftPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminGiftCardQuarterlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, giftCardDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totGiftAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allGiftCardsYearlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -365);
	    String yearlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totGiftAmt = null;	    
	    List<GiftInfoSaving> giftCardDailyReportsList = giftInfoSavingDAOImpl.allGiftCardInfoTotalReports(todayDate, yearlyDate);
	    if (!giftCardDailyReportsList.isEmpty()) {	    	
	    	double giftPriceInDB = 0.0;
            for (GiftInfoSaving giftCardInfoLoop : giftCardDailyReportsList) {
            	String typeOfPackage = giftCardInfoLoop.getTypeOfPackage();
            	String gfPrice = giftCardInfoLoop.getRemainingGiftPrice();
            	double gfPriceInDB = Double.parseDouble(gfPrice);
            	giftPriceInDB = giftPriceInDB + gfPriceInDB; 
            	String usedGiftSt = giftCardInfoLoop.getUsedGiftStatus();
            	String reffDate = giftCardInfoLoop.getCreatedDateInSt();            	            	
            	if(("USED").equals(usedGiftSt)) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totGiftAmt = String.format("%.2f", giftPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminGiftCardYearlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, giftCardDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totGiftAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }
	
	@Override
	@Transactional
	public ModelAndView allPackageDailyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allPackageInfoDailyReports(todayDate);
	    if (!packageDailyReportsList.isEmpty()) {
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB;             	            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminPackageDailyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allPackageWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -7);
	    String weeklyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allPackageInfoTotalReports(todayDate, weeklyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminPackageWeeklyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allPackageMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -30);
	    String monthlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allPackageInfoTotalReports(todayDate, monthlyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminPackageMonthlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allPackageQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -90);
	    String quarterlyDate = formatter.format(cal.getTime());	    	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allPackageInfoTotalReports(todayDate, quarterlyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminPackageQuarterlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allPackageYearlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -365);
	    String yearlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allPackageInfoTotalReports(todayDate, yearlyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminPackageYearlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allRenderingDailyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    String totPackageAmt = null;
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allRenderingInfoDailyReports(todayDate);
	    if (!packageDailyReportsList.isEmpty()) {
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);            
	    }	    
	    mav = new ModelAndView(adminRenderingDailyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));		
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allRenderingWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -7);
	    String weeklyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allRenderingInfoTotalReports(todayDate, weeklyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminRenderingWeeklyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allRenderingMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -30);
	    String monthlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allRenderingInfoTotalReports(todayDate, monthlyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminRenderingMonthlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allRenderingQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -90);
	    String quarterlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allRenderingInfoTotalReports(todayDate, quarterlyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminRenderingQuarterlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allRenderingYearlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -365);
	    String yearlyDate = formatter.format(cal.getTime());	    
	    int fullRmCount = 0;
	    int accPackCount = 0;
	    int usedGiftCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    String totPackageAmt = null;	    
	    List<ClientPackageAndRenderingPaymentInfoSaving> packageDailyReportsList = clientPackageAndRenderingPaymentInfoSavingDAO.allRenderingInfoTotalReports(todayDate, yearlyDate);
	    if (!packageDailyReportsList.isEmpty()) {	    	
	    	double packPriceInDB = 0.0;
            for (ClientPackageAndRenderingPaymentInfoSaving packageInfoLoop : packageDailyReportsList) {
            	long clientInfoId = packageInfoLoop.getClientInfoSavingId();
            	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
            	String typeOfPackage = clientInfoSaving.getDesignPackage();
            	long designerInfoId = clientInfoSaving.getDesignerInfoSavingId();
            	String packagePrice = packageInfoLoop.getTotalPaybleAmount();
            	double packagePriceInDB = Double.parseDouble(packagePrice);
            	packPriceInDB = packPriceInDB + packagePriceInDB; 
            	String reffDate = packageInfoLoop.getCreatedDateInSt();            	            	
            	if(designerInfoId > 0) {
            		usedGiftCount = usedGiftCount + 1;
            	}
            	if(("Full Room Design Package").equals(typeOfPackage)) {
            		fullRmCount = fullRmCount + 1;
            	} else {
            		accPackCount = accPackCount + 1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }
            totPackageAmt = String.format("%.2f", packPriceInDB);
	    }	    
	    mav = new ModelAndView(adminRenderingYearlyReport);
	    mav.addObject(fullRoomCount, fullRmCount);
	    mav.addObject(accPackageCount, accPackCount);
	    mav.addObject(usedGiftCardCount, usedGiftCount);
	    mav.addObject(totalGiftCards, packageDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPackageAmt);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allShoppingCartDailyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());	    
	    String totPableAmount = null;
	    int placeOrdCount = 0;
	    int notPlaceOrdCount = 0;
	    int orderStCount = 0;
	    int delvStCount = 0;
	    List<ShoppingCartPaymentInfoSaving> shopCartDailyReportsList = shoppingCartPaymentInfoSavingDAO.allShoppingCartInfoDailyReports(todayDate);
	    if (!shopCartDailyReportsList.isEmpty()) {
	    	double totalPaybleAmtInDB = 0.0;
            for (ShoppingCartPaymentInfoSaving shCartInfoLoop : shopCartDailyReportsList) {
            	String totPaybleAmt = shCartInfoLoop.getTotalPaybleAmount();
            	double totPaybleAmtInDB = Double.parseDouble(totPaybleAmt);
            	totalPaybleAmtInDB = totalPaybleAmtInDB + totPaybleAmtInDB;
            	String placeOrderCount = shCartInfoLoop.getReviewOrderStatus();
            	String ordStatusCount = shCartInfoLoop.getOrderedStatus();
            	String delStatusCount = shCartInfoLoop.getDeliveredStatus();
            	if(("YES").equals(ordStatusCount)) {
            		orderStCount = orderStCount + 1;
            	}
            	if(("YES").equals(delStatusCount)) {
            		delvStCount = delvStCount + 1;
            	}            	
            	if(("Place My Order").equals(placeOrderCount)) {
            		placeOrdCount = placeOrdCount + 1;
            	} else {
            		notPlaceOrdCount = notPlaceOrdCount +1;
            	}            	
            }
            totPableAmount = String.format("%.2f", totalPaybleAmtInDB);            
	    }	    
	    mav = new ModelAndView(adminShoppingCartDailyReport);
	    mav.addObject(fullRoomCount, placeOrdCount);
	    mav.addObject(accPackageCount, notPlaceOrdCount);
	    mav.addObject(orderStatusCount, orderStCount);
	    mav.addObject(deliveryStatusCount, delvStCount);
	    mav.addObject(totalGiftCards, shopCartDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPableAmount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));		
	    return mav;
    }
	 
	@Override
	@Transactional
	public ModelAndView allShoppingCartWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -7);
	    String weeklyDate = formatter.format(cal.getTime());	    
	    String totPableAmount = null;
	    int placeOrdCount = 0;
	    int notPlaceOrdCount = 0;
	    int orderStCount = 0;
	    int delvStCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    List<ShoppingCartPaymentInfoSaving> shopCartDailyReportsList = shoppingCartPaymentInfoSavingDAO.allShoppingCartInfoTotalReports(todayDate, weeklyDate);
	    if (!shopCartDailyReportsList.isEmpty()) {
	    	double totalPaybleAmtInDB = 0.0;
            for (ShoppingCartPaymentInfoSaving shCartInfoLoop : shopCartDailyReportsList) {
            	String totPaybleAmt = shCartInfoLoop.getTotalPaybleAmount();
            	double totPaybleAmtInDB = Double.parseDouble(totPaybleAmt);
            	totalPaybleAmtInDB = totalPaybleAmtInDB + totPaybleAmtInDB;
            	String placeOrderCount = shCartInfoLoop.getReviewOrderStatus();
            	String ordStatusCount = shCartInfoLoop.getOrderedStatus();
            	String delStatusCount = shCartInfoLoop.getDeliveredStatus();
            	String reffDate = shCartInfoLoop.getCreatedDateInSt();            	
            	if(("YES").equals(ordStatusCount)) {
            		orderStCount = orderStCount + 1;
            	}
            	if(("YES").equals(delStatusCount)) {
            		delvStCount = delvStCount + 1;
            	}            	
            	if(("Place My Order").equals(placeOrderCount)) {
            		placeOrdCount = placeOrdCount + 1;
            	} else {
            		notPlaceOrdCount = notPlaceOrdCount +1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }            
            totPableAmount = String.format("%.2f", totalPaybleAmtInDB);            
	    }	    
	    mav = new ModelAndView(adminShoppingCartWeeklyReport);
	    mav.addObject(fullRoomCount, placeOrdCount);
	    mav.addObject(accPackageCount, notPlaceOrdCount);
	    mav.addObject(orderStatusCount, orderStCount);
	    mav.addObject(deliveryStatusCount, delvStCount);
	    mav.addObject(totalGiftCards, shopCartDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPableAmount);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allShoppingCartMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -30);
	    String monthlyDate = formatter.format(cal.getTime());	    
	    String totPableAmount = null;
	    int placeOrdCount = 0;
	    int notPlaceOrdCount = 0;
	    int orderStCount = 0;
	    int delvStCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    List<ShoppingCartPaymentInfoSaving> shopCartDailyReportsList = shoppingCartPaymentInfoSavingDAO.allShoppingCartInfoTotalReports(todayDate, monthlyDate);
	    if (!shopCartDailyReportsList.isEmpty()) {
	    	double totalPaybleAmtInDB = 0.0;
            for (ShoppingCartPaymentInfoSaving shCartInfoLoop : shopCartDailyReportsList) {
            	String totPaybleAmt = shCartInfoLoop.getTotalPaybleAmount();
            	double totPaybleAmtInDB = Double.parseDouble(totPaybleAmt);
            	totalPaybleAmtInDB = totalPaybleAmtInDB + totPaybleAmtInDB;
            	String placeOrderCount = shCartInfoLoop.getReviewOrderStatus();
            	String ordStatusCount = shCartInfoLoop.getOrderedStatus();
            	String delStatusCount = shCartInfoLoop.getDeliveredStatus();
            	String reffDate = shCartInfoLoop.getCreatedDateInSt();            	
            	if(("YES").equals(ordStatusCount)) {
            		orderStCount = orderStCount + 1;
            	}
            	if(("YES").equals(delStatusCount)) {
            		delvStCount = delvStCount + 1;
            	}            	
            	if(("Place My Order").equals(placeOrderCount)) {
            		placeOrdCount = placeOrdCount + 1;
            	} else {
            		notPlaceOrdCount = notPlaceOrdCount +1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }            
            totPableAmount = String.format("%.2f", totalPaybleAmtInDB);            
	    }	    
	    mav = new ModelAndView(adminShoppingCartMonthlyReport);
	    mav.addObject(fullRoomCount, placeOrdCount);
	    mav.addObject(accPackageCount, notPlaceOrdCount);
	    mav.addObject(orderStatusCount, orderStCount);
	    mav.addObject(deliveryStatusCount, delvStCount);
	    mav.addObject(totalGiftCards, shopCartDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPableAmount);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allShoppingCartQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -90);
	    String quarterlyDate = formatter.format(cal.getTime());	    	    
	    String totPableAmount = null;
	    int placeOrdCount = 0;
	    int notPlaceOrdCount = 0;
	    int orderStCount = 0;
	    int delvStCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    List<ShoppingCartPaymentInfoSaving> shopCartDailyReportsList = shoppingCartPaymentInfoSavingDAO.allShoppingCartInfoTotalReports(todayDate, quarterlyDate);
	    if (!shopCartDailyReportsList.isEmpty()) {
	    	double totalPaybleAmtInDB = 0.0;
            for (ShoppingCartPaymentInfoSaving shCartInfoLoop : shopCartDailyReportsList) {
            	String totPaybleAmt = shCartInfoLoop.getTotalPaybleAmount();
            	double totPaybleAmtInDB = Double.parseDouble(totPaybleAmt);
            	totalPaybleAmtInDB = totalPaybleAmtInDB + totPaybleAmtInDB;
            	String placeOrderCount = shCartInfoLoop.getReviewOrderStatus();
            	String ordStatusCount = shCartInfoLoop.getOrderedStatus();
            	String delStatusCount = shCartInfoLoop.getDeliveredStatus();
            	String reffDate = shCartInfoLoop.getCreatedDateInSt();            	
            	if(("YES").equals(ordStatusCount)) {
            		orderStCount = orderStCount + 1;
            	}
            	if(("YES").equals(delStatusCount)) {
            		delvStCount = delvStCount + 1;
            	}            	
            	if(("Place My Order").equals(placeOrderCount)) {
            		placeOrdCount = placeOrdCount + 1;
            	} else {
            		notPlaceOrdCount = notPlaceOrdCount +1;
            	}            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }            
            totPableAmount = String.format("%.2f", totalPaybleAmtInDB);            
	    }	    
	    mav = new ModelAndView(adminShoppingCartQuarterlyReport);
	    mav.addObject(fullRoomCount, placeOrdCount);
	    mav.addObject(accPackageCount, notPlaceOrdCount);
	    mav.addObject(orderStatusCount, orderStCount);
	    mav.addObject(deliveryStatusCount, delvStCount);
	    mav.addObject(totalGiftCards, shopCartDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPableAmount);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
	    
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView allShoppingCartYearlyReportsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String todayDate = formatter.format(new Date());
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -365);
	    String yearlyDate = formatter.format(cal.getTime());	    
	    String totPableAmount = null;
	    int placeOrdCount = 0;
	    int notPlaceOrdCount = 0;
	    int orderStCount = 0;
	    int delvStCount = 0;
	    int weekDayCount = 0;
	    int weekEndCount = 0;
	    List<ShoppingCartPaymentInfoSaving> shopCartDailyReportsList = shoppingCartPaymentInfoSavingDAO.allShoppingCartInfoTotalReports(todayDate, yearlyDate);
	    if (!shopCartDailyReportsList.isEmpty()) {
	    	double totalPaybleAmtInDB = 0.0;
            for (ShoppingCartPaymentInfoSaving shCartInfoLoop : shopCartDailyReportsList) {
            	String totPaybleAmt = shCartInfoLoop.getTotalPaybleAmount();
            	double totPaybleAmtInDB = Double.parseDouble(totPaybleAmt);
            	totalPaybleAmtInDB = totalPaybleAmtInDB + totPaybleAmtInDB;
            	String placeOrderCount = shCartInfoLoop.getReviewOrderStatus();
            	String ordStatusCount = shCartInfoLoop.getOrderedStatus();
            	String delStatusCount = shCartInfoLoop.getDeliveredStatus();
            	String reffDate = shCartInfoLoop.getCreatedDateInSt();            	
            	if(("YES").equals(ordStatusCount)) {
            		orderStCount = orderStCount + 1;
            	}
            	if(("YES").equals(delStatusCount)) {
            		delvStCount = delvStCount + 1;
            	}
            	
            	if(("Place My Order").equals(placeOrderCount)) {
            		placeOrdCount = placeOrdCount + 1;
            	} else {
            		notPlaceOrdCount = notPlaceOrdCount +1;
            	}
            	
            	String dayOfWeek = null;
    	    	Date refDayName;
    			try {
    				refDayName = formatter.parse(reffDate);
    				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(refDayName);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			if(("Saturday").equalsIgnoreCase(dayOfWeek) || ("Sunday").equalsIgnoreCase(dayOfWeek)) {
    				weekEndCount = weekEndCount + 1;
    			} else {
    				weekDayCount = weekDayCount + 1;
    			}
            }            
            totPableAmount = String.format("%.2f", totalPaybleAmtInDB);            
	    }	    
	    mav = new ModelAndView(adminShoppingCartYearlyReport);
	    mav.addObject(fullRoomCount, placeOrdCount);
	    mav.addObject(accPackageCount, notPlaceOrdCount);
	    mav.addObject(orderStatusCount, orderStCount);
	    mav.addObject(deliveryStatusCount, delvStCount);
	    mav.addObject(totalGiftCards, shopCartDailyReportsList.size());
	    mav.addObject(totalGiftAmount, totPableAmount);
	    mav.addObject(weekDaysCount, weekDayCount);
	    mav.addObject(weekEndsCount, weekEndCount);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));	    
	    return mav;
    }
	
    @Override
    @Transactional
    public ModelAndView adminDesignAndRegistryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<UserInformation> packageLIRowIdList = userInformationDAO.packageLoginInfoDisplayInAdminSide();
    	List<RegistrantInformationSaving> registryLIRowIdList = registrantInformationSavingDAO.adminRegistryLoginInfoListTakeFromDB();
    	List<RegistrantPaymentInfoSaving> regiPaymentInfoList = registrantPaymentInfoSavingDAO.adminRegistryUserPaymentDataTakeFromDB();
    	List<GuestRoomFundPaymentInfoSaving> guestPaymentInfoList = guestRoomFundPaymentInfoSaving.adminGuestUserPaymentDataTakeFromDB();
    	mav = new ModelAndView("adminDesignAndRegistryRed");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	mav.addObject("designLoginCount", packageLIRowIdList.size());
    	mav.addObject("registryLoginCount", registryLIRowIdList.size());
    	mav.addObject("registryPaymentCount", regiPaymentInfoList.size());
    	mav.addObject("guestPaymentCount", guestPaymentInfoList.size());
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminPRHomeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<UserInformation> packageLIRowIdList = userInformationDAO.packageLoginInfoDisplayInAdminSide();
        if (!packageLIRowIdList.isEmpty()) {
        	int count = 0;
            List<UserInformation> packageLISavingList = new ArrayList<UserInformation>();            
            for (UserInformation packageLIInfoLoop : packageLIRowIdList) {
            	UserInformation packageLISavingModel = new UserInformation();
            	packageLISavingModel.setCreatedDate(packageLIInfoLoop.getCreatedDate());
            	String fName = packageLIInfoLoop.getFirstName();
            	String lName = packageLIInfoLoop.getLastName();
            	String fullName = fName + " " + lName;            	
            	packageLISavingModel.setFirstName(fullName);            	        
            	packageLISavingModel.setUserName(packageLIInfoLoop.getUserName());
            	packageLISavingModel.setUserId(packageLIInfoLoop.getUserId());
            	count = count + 1;
            	String totalCount = Integer.toString(count);
            	packageLISavingModel.setLastName(totalCount);
            	packageLISavingList.add(packageLISavingModel);
            }
            mav = new ModelAndView("adminPackageRedirection");
        	mav.addObject("adminPackageSavingList", packageLISavingList);
            mav.addObject("adminPackageListCount", packageLIRowIdList.size());
        } else {
        	mav = amnDesignerDirectoryRedirection(req, sn);
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantInformationSaving> registryLIRowIdList = registrantInformationSavingDAO.adminRegistryLoginInfoListTakeFromDB();
    	if (!registryLIRowIdList.isEmpty()) {
        	int count = 0;
            List<RegistrantInformationSaving> registryLISavingList = new ArrayList<RegistrantInformationSaving>();            
            for (RegistrantInformationSaving registryLIInfoLoop : registryLIRowIdList) {
            	RegistrantInformationSaving registryLISavingModel = new RegistrantInformationSaving();
            	registryLISavingModel.setCreatedDate(registryLIInfoLoop.getCreatedDate());
            	String fName = registryLIInfoLoop.getRegFirstName();
            	String lName = registryLIInfoLoop.getRegLastName();
            	String fullName = fName + " " + lName;            	
            	registryLISavingModel.setRegFirstName(fullName);            	        
            	registryLISavingModel.setRegUserName(registryLIInfoLoop.getRegUserName());
            	registryLISavingModel.setRegistrantUserId(registryLIInfoLoop.getRegistrantUserId());
            	count = count + 1;
            	String totalCount = Integer.toString(count);
            	registryLISavingModel.setRegAddress(totalCount);
            	registryLISavingList.add(registryLISavingModel);
            }
            mav = new ModelAndView("adminRegistryRedirection");
        	mav.addObject("adminRegistrySavingList", registryLISavingList);
            mav.addObject("adminRegistryListCount", registryLIRowIdList.size());
        } else {
        	mav = adminPRHomeRedirection(req, sn);
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryUserPaymentRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<RegistrantPaymentInfoSaving> regiPaymentInfoList = registrantPaymentInfoSavingDAO.adminRegistryUserPaymentDataTakeFromDB();
    	if (!regiPaymentInfoList.isEmpty()) {
        	int count = 0;
            List<RegistrantPaymentInfoSaving> regiPaymentSavingList = new ArrayList<RegistrantPaymentInfoSaving>();            
            for (RegistrantPaymentInfoSaving regiPaymentInfoLoop : regiPaymentInfoList) {
            	RegistrantPaymentInfoSaving regiPaymentSavingModel = new RegistrantPaymentInfoSaving();
            	regiPaymentSavingModel.setCreatedDate(regiPaymentInfoLoop.getCreatedDate());
            	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(regiPaymentInfoLoop.getRegistrantUserId());
                String regiFirstName = regInfoSavingModel.getRegFirstName();
                String coRegiFirstName = regInfoSavingModel.getRegLastName();                
            	String fullName = regiFirstName + " " + coRegiFirstName;            	
            	regiPaymentSavingModel.setBillAddress1(fullName);
            	regiPaymentSavingModel.setBillAddress2(regInfoSavingModel.getRegUserName());            	
            	regiPaymentSavingModel.setNameOnCard(regiPaymentInfoLoop.getNameOnCard());
            	String totAmount = "$ " + regiPaymentInfoLoop.getTotalPableAmount();
            	regiPaymentSavingModel.setTotalPableAmount(totAmount);                
            	count = count + 1;
            	String totalCount = Integer.toString(count);
            	regiPaymentSavingModel.setStatus(totalCount);
            	regiPaymentSavingModel.setRegistrantPaymentInfoSavingId(regiPaymentInfoLoop.getRegistrantPaymentInfoSavingId());
            	regiPaymentSavingList.add(regiPaymentSavingModel);
            }
            mav = new ModelAndView("adminRegistryUserPaymentRed");
        	mav.addObject("adminRegistryUserPaymentSavingList", regiPaymentSavingList);
            mav.addObject("adminRegistryUserPaymentListCount", regiPaymentInfoList.size());
        } else {
        	mav = adminPRHomeRedirection(req, sn);
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewRegistryUserPaymentRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regiUserPayment = (String) req.getParameter("regPaymentUserIdRef");
    	long regiUserPaymentId = Long.valueOf(regiUserPayment);
    	RegistrantPaymentInfoSaving regiPaymentInfoData = registrantPaymentInfoSavingDAO.adminRegistrantPaymentInfoTakingFromDB(regiUserPaymentId);    	
    	String payCardNumber = regiPaymentInfoData.getPayCardNumber();
    	String accountType = regiPaymentInfoData.getAccountType();
    	String payExpDate = regiPaymentInfoData.getPayExpDate();
    	String nameOnCard = regiPaymentInfoData.getNameOnCard();
    	String billFullName = regiPaymentInfoData.getBillFullName();
    	String billAddress1 = regiPaymentInfoData.getBillAddress1();
    	String billAddress2 = regiPaymentInfoData.getBillAddress2();
    	String billCity = regiPaymentInfoData.getBillCity();
    	String billState = regiPaymentInfoData.getBillState();
    	String billZip = regiPaymentInfoData.getBillZip();
    	String billCountry = regiPaymentInfoData.getBillCountry();
    	String billPhNumber = regiPaymentInfoData.getBillPhNumber();
    	String totalAmount = regiPaymentInfoData.getTotalPableAmount();    	    	
    	String checkoutPaymentStatus = regiPaymentInfoData.getCheckoutPaymentStatus();	
    	long transactionNumber = regiPaymentInfoData.getTransactionNumber();
    	String authorizationCode = regiPaymentInfoData.getAuthorizationCode();
    	String createdDateInSt = regiPaymentInfoData.getCreatedDateInSt();
    	String registrantMessage = regiPaymentInfoData.getRegistrantMessage();   	
    	String regiAddress = billAddress1 + " " + billAddress2;
    	String regiStAddress = billCity + ", " + billState + " " + billZip;
//    	long registrantUserId = regiPaymentInfoData.getRegistrantUserId();
    	RegistryRoomFundsPaymentInfoSaving regCashFundSavingModel = registryRoomFundsPaymentInfoSavingDAO.adminRegistryRoomAndCashFundInfoTakingFromDB(regiUserPaymentId);        
    	String registrantSelSpaceInfo = regCashFundSavingModel.getSelectedRoomFundsInfo();
    	mav = new ModelAndView("adminRegistryUserViewPayment");
    	mav.addObject("regBillFullName", billFullName);
    	mav.addObject("regPayAddress", regiAddress);
    	mav.addObject("regStAddress", regiStAddress);
    	mav.addObject("regCountry", billCountry);
    	mav.addObject("regBillPhNumber", billPhNumber);
    	mav.addObject("regNameOnCard", nameOnCard);
    	mav.addObject("regAccountType", accountType);
    	mav.addObject("regPayCardNumber", payCardNumber);
    	mav.addObject("regPayExpDate", payExpDate);    	
    	mav.addObject("regTotalAmount", totalAmount);    	
    	sn.setAttribute("regSelSpaceAllInfoInSn", registrantSelSpaceInfo);
    	mav.addObject("regCheckoutPaymentSt", checkoutPaymentStatus);
    	mav.addObject("regTransactionNo", transactionNumber);
    	mav.addObject("regAuthorizeCode", authorizationCode);
    	mav.addObject("regCreatedDateInSt", createdDateInSt);
    	mav.addObject("regMessage", registrantMessage);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGuestUserPaymentRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GuestRoomFundPaymentInfoSaving> guestPaymentInfoList = guestRoomFundPaymentInfoSaving.adminGuestUserPaymentDataTakeFromDB();
    	if (!guestPaymentInfoList.isEmpty()) {
        	int count = 0;
            List<GuestRoomFundPaymentInfoSaving> guestPaymentSavingList = new ArrayList<GuestRoomFundPaymentInfoSaving>();            
            for (GuestRoomFundPaymentInfoSaving guestPaymentInfoLoop : guestPaymentInfoList) {
            	GuestRoomFundPaymentInfoSaving guestPaymentSavingModel = new GuestRoomFundPaymentInfoSaving();
            	guestPaymentSavingModel.setCreatedDate(guestPaymentInfoLoop.getCreatedDate());
            	RegistrantInformationSaving regInfoSavingModel = registrantInformationSavingDAO.registryDataTakeFromDB(guestPaymentInfoLoop.getRegistrantUserId());
                String regiFirstName = regInfoSavingModel.getRegFirstName();
                String coRegiFirstName = regInfoSavingModel.getRegLastName();                
            	String fullName = regiFirstName + " " + coRegiFirstName;            	
            	guestPaymentSavingModel.setGuestRoomCombValues(fullName);
            	guestPaymentSavingModel.setGuestEmail(guestPaymentInfoLoop.getGuestEmail());
//            	guestPaymentSavingModel.setNameOnCard(guestPaymentInfoLoop.getNameOnCard());
            	String totAmount = "$ " + guestPaymentInfoLoop.getTotalAmount();
            	guestPaymentSavingModel.setTotalAmount(totAmount);
            	guestPaymentSavingModel.setGuestUserPaymentInfoSavingId(guestPaymentInfoLoop.getGuestUserPaymentInfoSavingId());
            	count = count + 1;
            	String totalCount = Integer.toString(count);
            	guestPaymentSavingModel.setStatus(totalCount);
            	guestPaymentSavingList.add(guestPaymentSavingModel);
            }
            mav = new ModelAndView("adminGuestUserPaymentRed");
        	mav.addObject("adminGuestUserPaymentSavingList", guestPaymentSavingList);
            mav.addObject("adminGuestUserPaymentListCount", guestPaymentInfoList.size());
        } else {
        	mav = adminPRHomeRedirection(req, sn);
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewGuestUserPaymentRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView("adminGuestUserViewPayment");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView deleteNewClientDataInAdmin(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	long clientInfoId = Long.parseLong(req.getParameter("param"));
    	List<ClientInfoSaving> clientDirRowIdList = clientInfoSavingDAO.clientDirectoryRowChecking(clientInfoId);
    	List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.adminSideClientUploadedInspireImagesRowIdVerification(clientInfoId);
    	List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.adminSideClientUploadedSpaceImagesRowIdVerification(clientInfoId);
    	if (!clientUploadedInsImagesList.isEmpty()) {
 		   for (ClientUploadedInspireImagesSaving clientUploadedInsImgModel : clientUploadedInsImagesList) {         		        		
 			  clientUploadedInspireImagesSavingDAO.delete(clientUploadedInsImgModel);
 		   } 		   
 	   	}
        if (!clientUploadedSpaceImagesList.isEmpty()) {
  		   for (ClientUploadedSpaceImagesSaving clientUploadedSpaceImgModel : clientUploadedSpaceImagesList) {         		        		
  			 clientUploadedSpaceImagesSavingDAO.delete(clientUploadedSpaceImgModel);
  		   } 		   
  	   	}
        if (!clientDirRowIdList.isEmpty()) {
        	ClientInfoSaving clientInfoDeleteRow = clientInfoSavingDAO.userIdTakeFromTableUsingClId(clientInfoId);        	
        	clientInfoSavingDAO.delete(clientInfoDeleteRow);
        }
    	mav = adminNewClientsRedirection(req, sn);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView createGiftCardsForAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView("createGiftCardsForAdmin");    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftCardDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	Timestamp currentDate = currentDate();
    	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    	GiftInfoSaving gisModel = new GiftInfoSaving();
    	gisModel.setPackagePrice("0");
    	gisModel.setMerchandiseCredit("0");
    	gisModel.setYourName("Admin");
    	gisModel.setYourEmail("admin@nookandcove.com");    	  	
    	String alphaNumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String t = "";
        for (int i = 0; i < 8; i++) {
        t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }    	
    	gisModel.setGiftCardCouponCode(t);
    	gisModel.setStatus("NEW");
    	gisModel.setCouponCodeUsedStatus("NO");
    	gisModel.setTotalPrice(req.getParameter(giftCardAmount));
    	gisModel.setPromoAmount("0");
    	gisModel.setRemainingGiftPrice(req.getParameter(giftCardAmount));
    	gisModel.setUsedGiftStatus("NO USED");
    	gisModel.setPayCardNumber("0");    	
    	gisModel.setTransactionNumber(0);
    	gisModel.setPaymentStatus(null);
    	gisModel.setCreatedDate(currentDate);
    	gisModel.setCreatedDateInSt(todayDate);
        giftInfoSavingDAO.save(gisModel);    	
    	mav = adminManageGiftCardInfoDisplay(req, sn);    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminManageGiftCardInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<GiftInfoSaving> selectedAdminRowIdList = giftInfoSavingDAOImpl.adminCreatedGiftCardsDataTakeFromDB();
    	if (!selectedAdminRowIdList.isEmpty()) {       	
            List<GiftInfoSaving> admnGiftCardSavingList = new ArrayList<GiftInfoSaving>();
            for (GiftInfoSaving giftInfoLoop : selectedAdminRowIdList) {
            	GiftInfoSaving giftInfoSavingModel = new GiftInfoSaving();
            	giftInfoSavingModel.setCreatedDate(giftInfoLoop.getCreatedDate());            	
            	giftInfoSavingModel.setYourName(giftInfoLoop.getYourName());
            	String totalPrice = giftInfoLoop.getTotalPrice();
            	giftInfoSavingModel.setPackagePrice(totalPrice);            	
            	giftInfoSavingModel.setGiftCardCouponCode(giftInfoLoop.getGiftCardCouponCode());
            	giftInfoSavingModel.setGiftCardInfoSavingId(giftInfoLoop.getGiftCardInfoSavingId());            	
            	giftInfoSavingModel.setStatus(giftInfoLoop.getStatus());
            	giftInfoSavingModel.setTypeOfDeliveryMethod(giftInfoLoop.getTypeOfDeliveryMethod());
            	giftInfoSavingModel.setCouponCodeUsedStatus(giftInfoLoop.getRemainingGiftPrice());
            	admnGiftCardSavingList.add(giftInfoSavingModel);
            }            
            mav = new ModelAndView("manageGiftCardsForAdmin");
            mav.addObject("manageGiftCardsSavingList", admnGiftCardSavingList);
            mav.addObject("manageGiftCardsListCount", selectedAdminRowIdList.size());                       
        } else{
        	mav = createGiftCardsForAdminRedirection(req, sn);            
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminGiftCardSendRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String typeOfGiftCard = req.getParameter("adminGiftCardType");
    	String giftCardInfoID = req.getParameter("adminGiftCardId");    	
    	long giftCardID = Long.parseLong(giftCardInfoID);
    	if(("Delete Gift Card").equals(typeOfGiftCard)) {
    		GiftInfoSaving giftInfoRowDelete = giftInfoSavingDAOImpl.viewGiftCardInfoDataDisplay(giftCardID);
    		giftInfoSavingDAOImpl.delete(giftInfoRowDelete);    		
    		mav = adminManageGiftCardInfoDisplay(req, sn);
    	} else {
    		mav = selectedAdminGiftCardSendDataCreation(req, sn, giftCardID);
    	}    	    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedAdminGiftCardSendDataCreation(HttpServletRequest req, HttpSession sn, long giftCardID) {
    	ModelAndView mav;
    	mav = new ModelAndView("createSendGiftCardForClient");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));
    	mav.addObject(adminGiftCardID, giftCardID);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminSendGiftCardDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long giftCardID = Long.parseLong(req.getParameter(adminGiftCardID));
    	GiftInfoSaving giftInfoSaving = giftInfoSavingDAOImpl.viewGiftCardInfoDataDisplay(giftCardID);    	
     	giftInfoSaving.setTypeOfDeliveryMethod(req.getParameter("typeOfDelivery"));
     	giftInfoSaving.setGiftRecipientName(req.getParameter("giftRecipientName"));
     	giftInfoSaving.setGiftRecipientAddress(req.getParameter("giftRecipientAddress"));
     	giftInfoSaving.setGiftRecipientCity(req.getParameter("giftRecipientCity"));
     	giftInfoSaving.setGiftRecipientState(req.getParameter("giftRecipientState"));
     	giftInfoSaving.setGiftRecipientZipCode(req.getParameter("giftRecipientZipCode"));     	
     	giftInfoSaving.setRecEmailarName(req.getParameter("recEmailarName"));
     	giftInfoSaving.setRecEmailarAddress(req.getParameter("recEmailarAddress"));
     	giftInfoSavingDAOImpl.merge(giftInfoSaving);
     	mav = adminManageGiftCardInfoDisplay(req, sn);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(mainAdminId, sn.getAttribute(userIdInSn));
    	mav.addObject(giftCardsCount, sn.getAttribute(giftCardsCountInSn));
    	mav.addObject(newClientsCount, sn.getAttribute(newClientsCountInSn));
    	mav.addObject(purchasesItemsCount, sn.getAttribute(purchasesItemsCountInSn));    	   	
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
 	public String designerNameTakeFromDB(long designerId) {
 		String designerName = null;
 		if(designerId > 0) {
	 		UserInformation userInformation = userInformationDAO.updatedRowIdVerification(designerId);
	 		String fName = userInformation.getFirstName();
	 		String lName = userInformation.getLastName();
	 		String fCapName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
	        String lCapName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
	        designerName = fCapName +" "+lCapName;
 		}
 		return designerName;
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

	public static String getCurrentTimeStamp() {
	    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
	}

}
