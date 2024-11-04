package com.nookandcove.serviceimpl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

import com.nookandcove.dao.DesignerInfoSavingDAO;
import com.nookandcove.dao.FurnitureSpecsProductsAccPackSavingDAO;
import com.nookandcove.dao.FurnitureSpecsProductsFullRoomPackSavingDAO;
import com.nookandcove.dao.AdminAssignClientInfoToDesignerSavingDAO;
import com.nookandcove.dao.AdminDesignerMessageInfoSavingDAO;
import com.nookandcove.dao.ClientDesignerMessageInfoSavingDAO;
import com.nookandcove.dao.ClientInfoSavingDAO;
import com.nookandcove.dao.ClientUploadedInspireImagesSavingDAO;
import com.nookandcove.dao.ClientUploadedSpaceImagesSavingDAO;
import com.nookandcove.dao.DesignerEditableCalendarInfoSavingDAO;
import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.model.DesignerInfoSaving;
import com.nookandcove.model.FurnitureSpecsProductsAccPackSaving;
import com.nookandcove.model.FurnitureSpecsProductsFullRoomPackSaving;
import com.nookandcove.model.AdminAssignClientInfoToDesignerSaving;
import com.nookandcove.model.AdminDesignerMessageInfoSaving;
import com.nookandcove.model.ClientDesignerMessageInfoSaving;
import com.nookandcove.model.ClientInfoSaving;
import com.nookandcove.model.ClientUploadedInspireImagesSaving;
import com.nookandcove.model.ClientUploadedSpaceImagesSaving;
import com.nookandcove.model.DesignerEditableCalendarInfoSaving;
import com.nookandcove.model.UserInformation;
import com.nookandcove.service.DesignerInfoSavingService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class DesignerInfoSavingServiceImpl implements DesignerInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignerInfoSavingServiceImpl.class);	
	
	private String firstNamesInSn = "firstNameInSn";
	private String userNameInSn = "userNameInSn";
	private String flName = "flName";
	private String userIdInSn = "userIdInSn";
	private String factsaboutdesigner = "factsaboutdesigner";
	private String uploadedImgInSN = "uploadedImgInSN";
	private String uploadedDesImg = "uploadedDesImg";
	private String factsAboutDesn = "factsAboutDesn";
	private String clCreatedDateInSN = "clCreatedDateInSN";
	private String clRoomValInSN = "clRoomValInSN";
	private String clDesnPackValInSN = "clDesnPackValInSN";	
	private String createdDate = "createdDate";
	private String typeOfSpaceVal = "typeOfSpaceVal";	
	private String desnPhoneNumber = "desnPhoneNumber";	
	private String desnerUserName = "desnerUserName";
	private String desnFullName = "desnFullName";	
	private String clientInfoSavingIdInSn = "clientInfoSavingIdInSn";
	private String designerInfoSavingIdInSn = "designerInfoSavingIdInSn";
	private String clientCheckList = "clientCheckList";
	private String clientFullName = "clientFullName";
	private String desWaitingForClientReq = "desWaitingForClientReq";
	private String desWaitingForClientReqInSn = "desWaitingForClientReqInSn";
	private String productName = "productName";
	private String productPrice = "productPrice";
	private String storeName = "storeName";
	private String storeURL = "storeURL";
	private String skuName = "skuName";
	private String productImage = "productImage";
	private String reDirfurnSpecsCon1FullRmPack = "reDirfurnSpecsCon1FullRmPack";
	private String reDirfurnSpecsCon2FullRmPack = "reDirfurnSpecsCon2FullRmPack";
	private String reDirfurnSpecsFullRmPackRoomRendering = "reDirfurnSpecsFullRmPackRoomRendering";
	private String reDirfurnSpecsFullRmPack2ndRendering = "reDirfurnSpecsFullRmPack2ndRendering";
	private String reDirfurnSpecsFullRmPackRevisedRendering = "reDirfurnSpecsFullRmPackRevisedRendering";
	private String reDirfurnSpecsCon1AccPack = "reDirfurnSpecsCon1AccPack";
	private String reDirfurnSpecsCon2AccPack = "reDirfurnSpecsCon2AccPack";
	private String reDirfurnSpecsAccPackFinalConcept = "reDirfurnSpecsAccPackFinalConcept";
	private String viewClientMessageInfo = "viewClientMessageInfo";
	private String reDirDesignerAndClientMes = "reDirDesignerAndClientMes";
	private String reDirDesignerAndAdminMes = "reDirDesignerAndAdminMes";
	private String adminMessageCountInSN = "adminMessageCountInSN";
	private String adminMessageCount = "adminMessageCount";	
	private String accStyleManagement = "accStyleManagement";
	private String accBudgetManagement = "accBudgetManagement";
	private String accDimensionsManagement = "accDimensionsManagement";
	private String accColorManagement = "accColorManagement";
	private String accFurnitureManagement = "accFurnitureManagement";
	private String accArtManagement = "accArtManagement";
	private String accMyRoomManagement = "accMyRoomManagement";
	private String accInspirationManagement = "accInspirationManagement";
	private String fullStyleManagement = "fullStyleManagement";
	private String fullBudgetManagement = "fullBudgetManagement";
	private String fullDimensionsManagement = "fullDimensionsManagement";
	private String fullColorManagement = "fullColorManagement";
	private String fullFurnitureManagement = "fullFurnitureManagement";
	private String fullArtManagement = "fullArtManagement";
	private String fullMyRoomManagement = "fullMyRoomManagement";
	private String fullInspirationManagement = "fullInspirationManagement";	
	private String typeOfStyleVal = "typeOfStyleVal";	
	private String allocateBudget = "allocateBudget";
	private String spaceDimension = "spaceDimension";
	private String typeOfColor = "typeOfColor";
	private String likeColor = "likeColor";
	private String dislikeColor = "dislikeColor";
	private String typeOfItem = "typeOfItem";
	private String otherItem = "otherItem";
	private String alreadyHaveItem = "alreadyHaveItem";
	private String typeOfArt = "typeOfArt";
	private String moreAboutSpace = "moreAboutSpace";
	private String uploadedImgInDB = "uploadedImgInDB";
	private String shareInspiration = "shareInspiration";
	private String shUploadedImgInDB = "shUploadedImgInDB";
	private String uploadAccPackConceptsAndRenderings = "uploadAccPackConceptsAndRenderings";
	private String uploadFullRoomPackConceptsAndRenderings = "uploadFullRoomPackConceptsAndRenderings";	
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
	private String designRevRenderingStatus = "designRevRenderingStatus";
	private String designSecRenderingStatus = "designSecRenderingStatus";
	private String uploadedSecRend1Image = "uploadedSecRend1Image";
	private String uploadedSecRend2Image = "uploadedSecRend2Image";
	private String adminConceptsStatus = "adminConceptsStatus";
	private String adminRenderingStatus = "adminRenderingStatus";	
	private String adminRevRenderingStatus = "adminRevRenderingStatus";
	private String adminSecRenderingStatus = "adminSecRenderingStatus";	
	private String uploadedRmrend1Image = "uploadedRmrend1Image";
	private String uploadedRmrend2Image = "uploadedRmrend2Image";
	private String uploadedRevrend1Image = "uploadedRevrend1Image";
	private String uploadedRevrend2Image = "uploadedRevrend2Image";		
	private String conceptApproved = "conceptApproved";
	private String renderingRequest = "renderingRequest";
	private String renderingApproved = "renderingApproved";
	private String secRendPurchage = "secRendPurchage";
	private String secRendApproved = "secRendApproved";
	private String revisionRequest = "revisionRequest";
	private String revisedRendApproved = "revisedRendApproved";
	private String desnPersonalBio = "desnPersonalBio";
	private String desnCredentials = "desnCredentials";
	private String desnLocation = "desnLocation";
	private String desigerNotes = "desigerNotes";
	private String secRenPaymentStatus = "secRenPaymentStatus";	
	private String furnitureSpecsConcepts1FRProductsUpload = "furnitureSpecsConcepts1FRProductsUpload";
	private String furnitureSpecsConcepts1FRProductsDisplay = "furnitureSpecsConcepts1FRProductsDisplay";
	private String furnitureSpecsConcepts1FRProductsEdit = "furnitureSpecsConcepts1FRProductsEdit";
	private String furnitureSpecsConcepts2FRProductsUpload = "furnitureSpecsConcepts2FRProductsUpload";
	private String furnitureSpecsConcepts2FRProductsDisplay = "furnitureSpecsConcepts2FRProductsDisplay";
	private String furnitureSpecsConcepts2FRProductsEdit = "furnitureSpecsConcepts2FRProductsEdit";
	private String furnitureSpecsRoomRenderingFRProductsUpload = "furnitureSpecsRoomRenderingFRProductsUpload";
	private String furnitureSpecsRoomRenderingFRProductsDisplay = "furnitureSpecsRoomRenderingFRProductsDisplay";
	private String furnitureSpecsRoomRenderingFRProductsEdit = "furnitureSpecsRoomRenderingFRProductsEdit";
	private String furnitureSpecs2ndRenderingFRProductsUpload = "furnitureSpecs2ndRenderingFRProductsUpload";
	private String furnitureSpecs2ndRenderingFRProductsDisplay = "furnitureSpecs2ndRenderingFRProductsDisplay";
	private String furnitureSpecs2ndRenderingFRProductsEdit = "furnitureSpecs2ndRenderingFRProductsEdit";
	private String furnitureSpecsRevisedRenderingFRProductsUpload = "furnitureSpecsRevisedRenderingFRProductsUpload";
	private String furnitureSpecsRevisedRenderingFRProductsDisplay = "furnitureSpecsRevisedRenderingFRProductsDisplay";
	private String furnitureSpecsRevisedRenderingFRProductsEdit = "furnitureSpecsRevisedRenderingFRProductsEdit";
	private String furnitureSpecsConcepts1AccPackProductsUpload = "furnitureSpecsConcepts1AccPackProductsUpload";
	private String furnitureSpecsConcepts1AccPackProductsDisplay = "furnitureSpecsConcepts1AccPackProductsDisplay";
	private String furnitureSpecsConcepts1AccPackProductsEdit = "furnitureSpecsConcepts1AccPackProductsEdit";
	private String furnitureSpecsConcepts2AccPackProductsUpload = "furnitureSpecsConcepts2AccPackProductsUpload";
	private String furnitureSpecsConcepts2AccPackProductsDisplay = "furnitureSpecsConcepts2AccPackProductsDisplay";
	private String furnitureSpecsConcepts2AccPackProductsEdit = "furnitureSpecsConcepts2AccPackProductsEdit";
	private String furnitureSpecsFinalConceptAccPackProductsUpload = "furnitureSpecsFinalConceptAccPackProductsUpload";
	private String furnitureSpecsFinalConceptAccPackProductsDisplay = "furnitureSpecsFinalConceptAccPackProductsDisplay";
	private String furnitureSpecsFinalConceptAccPackProductsEdit = "furnitureSpecsFinalConceptAccPackProductsEdit";
	private String furn_Spec_Saving_Id_List = "furn_Spec_Saving_Id_List";
	private String furn_Spec_Product_Name_List = "furn_Spec_Product_Name_List";
	private String productsQuantity = "productsQuantity";
	private String productDescription = "productDescription";
	private String assemblyRequiredStatus = "assemblyRequiredStatus";
	private String prodTotalCount = "prodTotalCount";
	private String clientBudget = "clientBudget";
	private String totalProductsPrice = "totalProductsPrice";
	private String productsIdInSn = "productsIdInSn";
	private String clientMessageRefType = "clientMessageRefType";
	private String desnEditableCalendarForClients = "desnEditableCalendarForClients";
	private String desnEditableCalendarDataDisplay = "desnEditableCalendarDataDisplay";
	private String clientName = "clientName";
	private String clientInfoText = "clientInfoText";
	private String clientMonth = "clientMonth";
	private String clientDay = "clientDay";
	private String clientYear = "clientYear";
	
	private String uploadImgPath = "/var/www/html/data/nookandcoveimages/";
		
	@Autowired
    private DesignerInfoSavingDAO designerInfoSavingDAO;
	
	@Autowired
    private ClientInfoSavingDAO clientInfoSavingDAO;
	
	@Autowired
    private UserInformationDAO userInformationDAO;

    @Autowired
    private ClientUploadedSpaceImagesSavingDAO clientUploadedSpaceImagesSavingDAO;
    
    @Autowired
    private ClientUploadedInspireImagesSavingDAO clientUploadedInspireImagesSavingDAO;
    
    @Autowired
    private AdminAssignClientInfoToDesignerSavingDAO adminAssignClientInfoToDesignerSavingDAO;

    @Autowired
    private ClientDesignerMessageInfoSavingDAO clientDesignerMessageInfoSavingDAO;

    @Autowired
    private AdminDesignerMessageInfoSavingDAO adminDesignerMessageInfoSavingDAO;

    @Autowired
    private FurnitureSpecsProductsAccPackSavingDAO furnitureSpecsProductsAccPackSavingDAO;

    @Autowired
    private FurnitureSpecsProductsFullRoomPackSavingDAO furnitureSpecsProductsFullRoomPackSavingDAO;

    @Autowired
    private DesignerEditableCalendarInfoSavingDAO designerEditableCalendarInfoSavingDAO;
    
    @Override
    @Transactional
    public ModelAndView designerClientsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	long designerSavingId = 0;
    	String reqNewClientStatus = null;
    	List selectedDesnRowIdList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));    	
    	if(!selectedDesnRowIdList.isEmpty()){    		
    		DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
    		designerSavingId = designerInfoSaving.getDesignerInfoSavingId();
    		reqNewClientStatus = designerInfoSaving.getDesWaitingForClientStatus();
    		sn.setAttribute(designerInfoSavingIdInSn, designerSavingId);
    	}    	
    	List adminMessageCountList = adminDesignerMessageInfoSavingDAO.adminMessageCounttoDesignerSideInDB(designerSavingId);    	
    	List<ClientInfoSaving> selectedClientRowIdList = clientInfoSavingDAO.displayOnlyDesignersClientsData(designerSavingId);    	
    	if (!selectedClientRowIdList.isEmpty()) { 
    		List<ClientInfoSaving> desnClientsSavingList = new ArrayList<ClientInfoSaving>();
            for (ClientInfoSaving myRoomInfoLoop : selectedClientRowIdList) {
            	ClientInfoSaving myRoomInfoSavingModel = new ClientInfoSaving();
            	myRoomInfoSavingModel.setCreatedDate(myRoomInfoLoop.getCreatedDate());
            	long clientId = myRoomInfoLoop.getUserId();            	
            	long clientInfoId = myRoomInfoLoop.getClientInfoSavingId();            	
            	int clMesCount = clientMessagesCountInDesnSideTakeFromDB(clientInfoId, designerSavingId);
            	String clMessagesCount = "";            	
            	if(clMesCount > 0) {
            		clMessagesCount = "NEW";
            	}            	
            	String clientNewAlertReq = clientNewAlertRequestRedirection(clientInfoId, designerSavingId);            	            	
            	String customerName = customerNameFromDB(clientId);
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
            	myRoomInfoSavingModel.setTypeOfItemsList(clMessagesCount);
            	myRoomInfoSavingModel.setDesignPackage(designPackage);
            	myRoomInfoSavingModel.setMoreAboutSpace(clientNewAlertReq);
            	myRoomInfoSavingModel.setRoomStatus(myRoomInfoLoop.getRoomStatus());
            	myRoomInfoSavingModel.setClientInfoSavingId(myRoomInfoLoop.getClientInfoSavingId());
            	myRoomInfoSavingModel.setDesignerInfoSavingId(myRoomInfoLoop.getDesignerInfoSavingId());
            	desnClientsSavingList.add(myRoomInfoSavingModel);
            }            
            mav = new ModelAndView("designerClientsRedirection");
            mav.addObject("designerClientsSavingList", desnClientsSavingList);
            mav.addObject("desnClientsCount", selectedClientRowIdList.size());
            mav.addObject("reqNewClientsStatus", reqNewClientStatus);            
        } else{
        	mav = deisgnerFirstTimeClientRequestRedirection(req, sn);           
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        sn.setAttribute(adminMessageCountInSN, adminMessageCountList.size());
        mav.addObject(adminMessageCount, adminMessageCountList.size());
        sn.setAttribute(designerInfoSavingIdInSn, designerSavingId);           	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerClientsArchiveRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	long designerSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List<ClientInfoSaving> selectedClientRowIdList = clientInfoSavingDAO.displayClientArchiveDataUsingDesignerID(designerSavingId);    	
    	if (!selectedClientRowIdList.isEmpty()) { 
    		List<ClientInfoSaving> desnClientsSavingList = new ArrayList<ClientInfoSaving>();
            for (ClientInfoSaving myRoomInfoLoop : selectedClientRowIdList) {
            	ClientInfoSaving myRoomInfoSavingModel = new ClientInfoSaving();
            	myRoomInfoSavingModel.setCreatedDate(myRoomInfoLoop.getCreatedDate());
            	long clientUserId = myRoomInfoLoop.getUserId();            	
            	String customerName = customerNameFromDB(clientUserId);
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
            	myRoomInfoSavingModel.setRoomStatus(myRoomInfoLoop.getRoomStatus());
            	myRoomInfoSavingModel.setClientInfoSavingId(myRoomInfoLoop.getClientInfoSavingId());
            	myRoomInfoSavingModel.setDesignerInfoSavingId(myRoomInfoLoop.getDesignerInfoSavingId());
            	desnClientsSavingList.add(myRoomInfoSavingModel);
            }            
            mav = new ModelAndView("designerClientsArchiveRed");
            mav.addObject("designerClArchiveSavingList", desnClientsSavingList);
            mav.addObject("designerClArchiveSavingCount", selectedClientRowIdList.size());
        } else {
        	mav = designerClientsRedirection(req, sn);
        }
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));                  	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerClArchiveDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String clentInfoIdList = req.getParameter("desArchiveCliens");   	
    	String[] clentInfoIdString = clentInfoIdList.split(", ");
    	long clientInfoId = Long.parseLong(clentInfoIdString[0]);
    	long designerInfoId = Long.parseLong(clentInfoIdString[1]);    	
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
    	myRoomInfoSaving.setRoomStatus(null);
    	clientInfoSavingDAO.merge(myRoomInfoSaving);
    	mav = designerClientsArchiveRedirection(req, sn);
    	return mav;
    }

	@Override
	@Transactional
	public ModelAndView deisgnerFirstTimeClientRequestRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String clientRequest = null;
		List designerInfoSavingList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
		if (!designerInfoSavingList.isEmpty()) {
			DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
			clientRequest = designerInfoSaving.getDesWaitingForClientStatus();
		}
		UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
    	String firstName = userInformation.getFirstName();    	
		mav = new ModelAndView("deisgnerFirstTimeClientRequest");
		mav.addObject("dsnFirstName", firstName);
		mav.addObject("clientFirstRequest", clientRequest);
		return mav;
    }

	@Override
	@Transactional
	public ModelAndView newClientRequestToAdminRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;				
		List designerInfoSavingList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
		if (!designerInfoSavingList.isEmpty()) {
			Timestamp currentDate = currentDate(); 
			DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
			designerInfoSaving.setDesWaitingForClientStatus("Request For Client");
			designerInfoSaving.setDesWaitingForClientDate(currentDate);
			designerInfoSavingDAO.merge(designerInfoSaving);
			mav = designerClientsRedirection(req, sn);
		} else {
			mav = designerClientsRedirection(req, sn);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
    }

	@Override
	@Transactional
	public ModelAndView newClientRequestCancelFromAdminRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;				
		List designerInfoSavingList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
		if (!designerInfoSavingList.isEmpty()) {
			DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
			designerInfoSaving.setDesWaitingForClientStatus(null);
			designerInfoSaving.setDesWaitingForClientDate(null);
			designerInfoSavingDAO.merge(designerInfoSaving);
			mav = designerClientsRedirection(req, sn);
		} else {
			mav = designerClientsRedirection(req, sn);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
    }

	@Override
	@Transactional
	public String clientNewAlertRequestRedirection(long clientInfoId, long designerInfoId) {
		String clientNewAlertReq = null;								
		List adminAssignClInfoSavingList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designerInfoId);
		if(!adminAssignClInfoSavingList.isEmpty()){
			AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
			clientNewAlertReq = adminAssignClInfoSaving.getNewUploads();			
		}		
		return clientNewAlertReq;
	}

    @Override
    @Transactional
    public ModelAndView designerUpdateAccPackCheckListInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav; 
      	String clientCheckValue = "";        
        if(null != req.getParameterValues(clientCheckList)) {
        	String[] checkBoxVal = req.getParameterValues(clientCheckList);
        	for (int q = 0; q < checkBoxVal.length; q++) {
        		clientCheckValue = clientCheckValue + "," + checkBoxVal[q];
        	}
        	clientCheckValue = clientCheckValue.replaceFirst(",", "");
        }
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);
      	if(!adminAssignClInfoList.isEmpty()){    		
      		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
      		adminAssignClInfoSaving.setDesignPackCheckListInfo(clientCheckValue);
      		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
      	}      	
  		mav = designerSideAccessoriesPackageRedirection(req, sn);   	
      	return mav;
    }
    
	@Override
    @Transactional
    public ModelAndView designerSideAccessoriesPackageRedirection(HttpServletRequest req, HttpSession sn) {
	    ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(createDate.getTime());
        String formatedDate = sdf.format(date);
        String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();
        typeOfSpace = typeOfSpace.replace("_", " ");        
        String typeOfStyle = myRoomInfoSaving.getTypeOfStyle();
        long userId = myRoomInfoSaving.getUserId();
        String clientName = customerNameFromDB(userId);
        AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
        adminAssignClInfoSaving.setNewUploads(null);
        adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
        String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
        String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
        String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
        String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
        mav = new ModelAndView(accStyleManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn)); 	
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);
      	mav.addObject(typeOfStyleVal, typeOfStyle);
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);      	
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
	}
    
    @Override
    @Transactional
    public ModelAndView accBudgetManagementRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(createDate.getTime());
        String formatedDate = sdf.format(date);        
        String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
        typeOfSpace = typeOfSpace.replace("_", " ");        
        String selBudget = myRoomInfoSaving.getBudget();
        long userId = myRoomInfoSaving.getUserId();
        String clientName = customerNameFromDB(userId);
        AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
        String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
        String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
        String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
        String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
        mav = new ModelAndView(accBudgetManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
      	mav.addObject(allocateBudget, selBudget);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accDimensionsManagementRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String spDimension = myRoomInfoSaving.getSpaceDimension();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
    	String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();    	        
      	mav = new ModelAndView(accDimensionsManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(spaceDimension, spDimension);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accColorManagementRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String tyOfColor = myRoomInfoSaving.getTypeOfColor();
    	String lkColor = myRoomInfoSaving.getLikeColor();
    	String disLkColor = myRoomInfoSaving.getDislikeColor();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
    	String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();    	        
      	mav = new ModelAndView(accColorManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(typeOfColor, tyOfColor);
      	mav.addObject(likeColor, lkColor);
      	mav.addObject(dislikeColor, disLkColor);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accFurnitureManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String typeOfItems = myRoomInfoSaving.getTypeOfItemsList();
    	String otherItems = myRoomInfoSaving.getOtherItems();
    	String alreadyHaveItems = myRoomInfoSaving.getAlreadyHaveItems();    	
    	List<String> mytyOfItemsList = new ArrayList<String>();
    	if(null != typeOfItems) {      	
    		typeOfItems = typeOfItems.replaceAll(", undefined", "");
      		typeOfItems = typeOfItems.replaceAll("undefined, ", "");
      		typeOfItems = typeOfItems.replaceAll("undefined", "");      		
      		if(!("").equals(typeOfItems)) {    	  			
      			mytyOfItemsList = new ArrayList<String>(Arrays.asList(typeOfItems.split(",")));
      		} else {    	  			
      			mytyOfItemsList = null;
      		}    			
    	}    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
    	String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();    	        
      	mav = new ModelAndView(accFurnitureManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(typeOfItem, typeOfItems);
      	mav.addObject(otherItem, otherItems);
      	mav.addObject(alreadyHaveItem, alreadyHaveItems);
      	sn.setAttribute("fur_item_Names_List", mytyOfItemsList);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accArtManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String typeOfApp = myRoomInfoSaving.getTypeOfArtAppeals();
  		if(null != typeOfApp){
  			typeOfApp = typeOfApp.replace("_", " ");
  		}    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
    	String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();    	        
      	mav = new ModelAndView(accArtManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(typeOfArt, typeOfApp);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accMyRoomManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String clUpDBImagesList = "";
    	List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.adminSideClientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(clientInfoSavingIdInSn));    	
    	if(!clientUploadedSpaceImagesList.isEmpty()){
    		for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {    			
    			byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
    			String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    			clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;
    		}
    		clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
    	}   	
    	String moreAbtSpace = myRoomInfoSaving.getMoreAboutSpace();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
    	String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();    	        
      	mav = new ModelAndView(accMyRoomManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(moreAboutSpace, moreAbtSpace);
      	mav.addObject(uploadedImgInDB, clUpDBImagesList);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accInspirationManagementRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String clUpDBImagesList = "";
  		List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.adminSideClientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(clientInfoSavingIdInSn));    	
  		if(!clientUploadedInsImagesList.isEmpty()){
    		for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {    			
    			byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
    			String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    			clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
    		}
    		clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
    	}    	
    	String shareYourInsp = myRoomInfoSaving.getShareYourInspire();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String finalConceptReq1 = adminAssignClInfoSaving.getClientRequestedForConcept();
    	String finalConceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();    	        
      	mav = new ModelAndView(accInspirationManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(shareInspiration, shareYourInsp);
      	mav.addObject(shUploadedImgInDB, clUpDBImagesList);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, finalConceptReq1);
      	mav.addObject(renderingApproved, finalConceptApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerUpdateFullPackCheckListInDB(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav; 
    	String clientCheckValue = "";        
    	if(null != req.getParameterValues(clientCheckList)) {
    		String[] checkBoxVal = req.getParameterValues(clientCheckList);
    		for (int q = 0; q < checkBoxVal.length; q++) {
    			clientCheckValue = clientCheckValue + "," + checkBoxVal[q];
    		}
    	    clientCheckValue = clientCheckValue.replaceFirst(",", "");
    	}
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
   	  		adminAssignClInfoSaving.setDesignPackCheckListInfo(clientCheckValue);
   	  		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = designerSideFullRoomDesignPackageRedirection(req, sn);    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerSideFullRoomDesignPackageRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);    	
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String typeOfStyle = myRoomInfoSaving.getTypeOfStyle();
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	adminAssignClInfoSaving.setNewUploads(null);
    	adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);    	
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();    	
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();
      	mav = new ModelAndView(fullStyleManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);
      	mav.addObject(typeOfStyleVal, typeOfStyle);
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);      	
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullBudgetManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String selBudget = myRoomInfoSaving.getBudget();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	    	      
      	mav = new ModelAndView(fullBudgetManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(allocateBudget, selBudget);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullDimensionsManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String spDimension = myRoomInfoSaving.getSpaceDimension();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	        
      	mav = new ModelAndView(fullDimensionsManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(spaceDimension, spDimension);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullColorManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");
    	String tyOfColor = myRoomInfoSaving.getTypeOfColor();
    	String lkColor = myRoomInfoSaving.getLikeColor();
    	String disLkColor = myRoomInfoSaving.getDislikeColor();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	        
      	mav = new ModelAndView(fullColorManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(typeOfColor, tyOfColor);
      	mav.addObject(likeColor, lkColor);
      	mav.addObject(dislikeColor, disLkColor);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullFurnitureManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String typeOfItems = myRoomInfoSaving.getTypeOfItemsList();
    	String otherItems = myRoomInfoSaving.getOtherItems();
    	String alreadyHaveItems = myRoomInfoSaving.getAlreadyHaveItems();    	
    	List<String> mytyOfItemsList = new ArrayList<String>();
    	if(null != typeOfItems) {      	
    		typeOfItems = typeOfItems.replaceAll(", undefined", "");
      		typeOfItems = typeOfItems.replaceAll("undefined, ", "");
      		typeOfItems = typeOfItems.replaceAll("undefined", "");      		
      		if(!("").equals(typeOfItems)) {    	  			
      			mytyOfItemsList = new ArrayList<String>(Arrays.asList(typeOfItems.split(",")));
      		} else {    	  			
      			mytyOfItemsList = null;
      		}    			
    	}    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	        
      	mav = new ModelAndView(fullFurnitureManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(typeOfItem, typeOfItems);
      	mav.addObject(otherItem, otherItems);
      	mav.addObject(alreadyHaveItem, alreadyHaveItems);
      	sn.setAttribute("fur_item_Names_List", mytyOfItemsList);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullArtManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String typeOfApp = myRoomInfoSaving.getTypeOfArtAppeals();
  		if(null != typeOfApp){
  			typeOfApp = typeOfApp.replace("_", " ");
  		}    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	        
      	mav = new ModelAndView(fullArtManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(typeOfArt, typeOfApp);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullMyRoomManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");
    	String clUpDBImagesList = "";
    	List<ClientUploadedSpaceImagesSaving> clientUploadedSpaceImagesList = clientUploadedSpaceImagesSavingDAO.adminSideClientUploadedSpaceImagesRowIdVerification((Long) sn.getAttribute(clientInfoSavingIdInSn));    	
    	if(!clientUploadedSpaceImagesList.isEmpty()){
    		for (ClientUploadedSpaceImagesSaving clientUploadedSIModel : clientUploadedSpaceImagesList) {    			
    			byte[] uploadedImageFromDB = clientUploadedSIModel.getUploadSpaceImagesBlogForDesigner();
    			String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    			clUpDBImagesList = clUpDBImagesList + "_,_" + buffDBImage;
    		}
    		clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
    	}   	
    	String moreAbtSpace = myRoomInfoSaving.getMoreAboutSpace();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	        
      	mav = new ModelAndView(fullMyRoomManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(moreAboutSpace, moreAbtSpace);
      	mav.addObject(uploadedImgInDB, clUpDBImagesList);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList);
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullInspirationManagementRedirection(HttpServletRequest req, HttpSession sn) {
      	ModelAndView mav;      	
      	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
       	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date(createDate.getTime());
    	String formatedDate = sdf.format(date);        
    	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
    	typeOfSpace = typeOfSpace.replace("_", " ");    	
    	String clUpDBImagesList = "";
  		List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.adminSideClientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(clientInfoSavingIdInSn));    	
  		if(!clientUploadedInsImagesList.isEmpty()){
    		for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {    			
    			byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
    			String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    			clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
    		}
    		clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
    	}   	
    	String shareYourInsp = myRoomInfoSaving.getShareYourInspire();    	
    	long userId = myRoomInfoSaving.getUserId();
    	String clientName = customerNameFromDB(userId);    	
    	AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designerInfoId);
    	String clCheckList = adminAssignClInfoSaving.getDesignPackCheckListInfo();
    	String conceptApproved1 = adminAssignClInfoSaving.getAdminApprovedForConcept();
    	String renderingRequest1 = adminAssignClInfoSaving.getClientRequestedForRendering();
    	String renderingApproved1 = adminAssignClInfoSaving.getAdminApprovedForRendering();
    	String secRendPurchage1 = adminAssignClInfoSaving.getClientPurchasedForSecondRendering();
    	String secRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForSecondRendering();
    	String revisionRequest1 = adminAssignClInfoSaving.getClientRequestedForRevisedRendering();
    	String revisedRendApproved1 = adminAssignClInfoSaving.getAdminApprovedForRevisedRendering();    	        
      	mav = new ModelAndView(fullInspirationManagement);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));      	
      	mav.addObject(shareInspiration, shareYourInsp);
      	mav.addObject(shUploadedImgInDB, clUpDBImagesList);
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
      	mav.addObject(clientCheckList, clCheckList); 
      	mav.addObject(conceptApproved, conceptApproved1);
      	mav.addObject(renderingRequest, renderingRequest1);
      	mav.addObject(renderingApproved, renderingApproved1);
      	mav.addObject(secRendPurchage, secRendPurchage1);
      	mav.addObject(secRendApproved, secRendApproved1);
      	mav.addObject(revisionRequest, revisionRequest1);
      	mav.addObject(revisedRendApproved, revisedRendApproved1);
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }

    @Override
    @Transactional
    public ModelAndView desnUploadAccPackConceptsAndRenderingsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    	
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
     	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(createDate.getTime());
        String formatedDate = sdf.format(date);        
        String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
        typeOfSpace = typeOfSpace.replace("_", " ");        
        String clUpDBImagesList = "";
		List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.adminSideClientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(clientInfoSavingIdInSn));		
		if(!clientUploadedInsImagesList.isEmpty()){
        	for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {        		
        		byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
        		String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
        		clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
        	}    	  
            clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
        }        
        long userId = myRoomInfoSaving.getUserId();
        String clientName = customerNameFromDB(userId);    	      
        String uploadedConcept1Image = "";
        String uploadedConcept2Image = "";
        String uploaded3DRenderingImage = "";
        String likeImagesValue = "";
        String designConceptStatus = "";
        String designRenderingsStatus = "";
        String adminConceptStatus = "";
        String adminRenderingsStatus = "";        
        List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoId, designerInfoId);
        List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoId, designerInfoId);
        List adminAssignRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInDB(clientInfoId, designerInfoId);    	      
    	if(!adminAssignCon1InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoId, designerInfoId);    		
    		byte[] uploadedConcept1ImageFromDB = adminAssignCon1InfoSaving.getConcept1ImageUpload();    		
    		uploadedConcept1Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);
    	}        
    	if(!adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoId, designerInfoId);
    		byte[] uploadedConcept2ImageFromDB = adminAssignCon2InfoSaving.getConcept2ImageUpload();
    		uploadedConcept2Image = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);
    		designConceptStatus = adminAssignCon2InfoSaving.getDesignerSubmitConceptsStatus();
    		adminConceptStatus = adminAssignCon2InfoSaving.getAdminApprovedForConcept();
    	}        
    	if(!adminAssignRendInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRendInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInDB(clientInfoId, designerInfoId);
    		byte[] uploaded3DrendImageFromDB = adminAssignRendInfoSaving.getRendering1ImageUpload();
    		uploaded3DRenderingImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploaded3DrendImageFromDB);
    		designRenderingsStatus = adminAssignRendInfoSaving.getDesignerSubmitRenderingStatus();
    		adminRenderingsStatus = adminAssignRendInfoSaving.getAdminApprovedForRendering();
    	}    	
    	likeImagesValue = concept3DRenderingLikeImagesDisplay(req, sn, clientInfoId, designerInfoId);    	
    	List desnUploadedProductsList1 = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoId, designerInfoId);
    	List desnUploadedProductsList2 = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoId, designerInfoId);
    	List desnUploadedProductsList3 = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designerInfoId);    	      
    	mav = new ModelAndView(uploadAccPackConceptsAndRenderings);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
    	List adminMessageCountList = adminDesignerMessageInfoSavingDAO.adminMessageCounttoDesignerSideInDB(designerInfoId);
       	sn.setAttribute(adminMessageCountInSN, adminMessageCountList.size());       	
    	mav.addObject(createdDate, formatedDate);    	
    	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
    	mav.addObject(clientFullName, clientName);
    	mav.addObject(concept1UploadedImage, uploadedConcept1Image);
     	mav.addObject(concept2UploadedImage, uploadedConcept2Image);
     	mav.addObject(concept3UploadedImage, uploaded3DRenderingImage);
     	mav.addObject(designConceptsStatus, designConceptStatus);
     	mav.addObject(designRenderingStatus, designRenderingsStatus);
     	mav.addObject(adminConceptsStatus, adminConceptStatus);
     	mav.addObject(adminRenderingStatus, adminRenderingsStatus);     	
     	mav.addObject(desnUploadedProducts1Count, desnUploadedProductsList1.size());
     	mav.addObject(desnUploadedProducts2Count, desnUploadedProductsList2.size());
     	mav.addObject(desnUploadedProducts3Count, desnUploadedProductsList3.size());
     	mav.addObject(likeImagesValues, likeImagesValue);    	
    	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
    	return mav;
    }   
    
    @Override
    @Transactional
    public ModelAndView accDesignerUploadConcept1ImageInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setConcept1ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirimageUploadInDB");    	       
    	return mav;
   }
   
    @Override
    @Transactional
    public ModelAndView accDesignerUploadConcept2ImageInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
 	   	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setConcept2ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}   	
    	mav = new ModelAndView("redirect:" + "reDirimageUploadInDB");    	     
    	return mav;
    }
   
    @Override
    @Transactional
    public ModelAndView accDesignerUploadFinalConceptImageInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
 	   	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setRendering1ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}   	
    	mav = new ModelAndView("redirect:" + "reDirimageUploadInDB");    	    
    	return mav;
    }  

    @Override
    @Transactional
    public ModelAndView designerSubmitAccPackConceptsToAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;	 	
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	 	
    	List adminAssignCon1InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoId, designerInfoId);
    	List adminAssignCon2InfoList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoId, designerInfoId);    	     
    	if(!adminAssignCon1InfoList.isEmpty() && !adminAssignCon2InfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignCon1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoId, designerInfoId);
    		adminAssignCon1InfoSaving.setDesignerSubmitConceptsStatus("Submitted Concepts");
    		adminAssignCon1InfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignCon1InfoSaving);
    	}    
    	mav = desnAccPackApprovedMailSentToAdmin(req, sn);
    	mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerSubmitAccPackFinalConceptsToAdminRedirection(HttpServletRequest req, HttpSession sn) {
	 	ModelAndView mav;	 	
	 	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	 	
	 	List adminAssignRendInfoList = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingVerificationInDB(clientInfoId, designerInfoId);        
    	if(!adminAssignRendInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRendInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designer3DRenderingUpdationInDB(clientInfoId, designerInfoId);
    		adminAssignRendInfoSaving.setDesignerSubmitRenderingStatus("Submitted Rendering");
    		adminAssignRendInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignRendInfoSaving);
    	} 
    	mav = desnAccPackApprovedMailSentToAdmin(req, sn);
    	mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
	 	return mav;
    }
	 
    @Override
    @Transactional    
    public ModelAndView desnAccPackApprovedMailSentToAdmin(HttpServletRequest req, HttpSession sn) {
	    ModelAndView mav;
		long adminUserId = 1;
	    UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        		
	    String toAdd = userInformation.getUserName();
	    String firstName = userInformation.getFirstName();
	    String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		String subject = "You have new uploads that need to be approved.";    	  
		String type = "text/html";    	 
		EmailSending userEmail = new EmailSending();
		String fromAdd = "info@nookandcove.com";    	    
		String body = "<body>" 
	    	      	+ "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
	    	      	+ "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
	    	      	+ "<p style='margin-top: 8px;'>You have new uploads from a designer. Designs need to be thoroughly checked and approved.</p>"
	    	      	+ "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
	    	      	+ "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
	    	      	+ "</div>"
	    	      	+ "</body> ";    	  
		try {
			userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
		} catch (Exception ex) {
			LOGGER.error("desn Accessories Pack Approved Mail Sent To Admin failed " + ex);
		}       
		mav = new ModelAndView();
		return mav;
    }   
 
    @Override
    @Transactional
    public ModelAndView desnUploadFullRoomConceptsAndRenderingsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;   	
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
   	   	Timestamp createDate = myRoomInfoSaving.getCreatedDate();
   	   	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
   	   	Date date = new Date(createDate.getTime());
   	   	String formatedDate = sdf.format(date);        
      	String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();        
      	typeOfSpace = typeOfSpace.replace("_", " ");       
      	String clUpDBImagesList = "";
      	List<ClientUploadedInspireImagesSaving> clientUploadedInsImagesList = clientUploadedInspireImagesSavingDAO.adminSideClientUploadedInspireImagesRowIdVerification((Long) sn.getAttribute(clientInfoSavingIdInSn));
      	if(!clientUploadedInsImagesList.isEmpty()){
      		for (ClientUploadedInspireImagesSaving clientUploadedIIModel : clientUploadedInsImagesList) {       		
      			byte[] uploadedImageFromDB = clientUploadedIIModel.getUploadInspiredImagesBlogForDesigner();
      			String buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
      			clUpDBImagesList = clUpDBImagesList + "_,_" +buffDBImage;
      		}    	  
          	clUpDBImagesList = clUpDBImagesList.replaceFirst("_,_", "");
      	}       
      	long userId = myRoomInfoSaving.getUserId();
      	String clientName = customerNameFromDB(userId);    	     
      	String uploadedConcept2Img = "";
      	String uploadedRmrend1Img = "";      	
      	String uploadedRevrend1Img = "";      	
      	String uploadedSecRend1Img = "";
      	String likeImagesValue = "";
      	String designConceptStatus = "";
      	String designRenderingsStatus = "";
      	String designRevRenderingsStatus = "";
      	String designSecRenderingsStatus = "";
      	String adminConceptStatus = "";
      	String adminRenderingsStatus = "";
      	String adminRevRenderingsStatus = "";
      	String adminSecRenderingsStatus = "";
      	String secRenPayStatus = null;
      	List designerConcept2VerList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoId, designerInfoId);
      	List designerRoomRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoId, designerInfoId);      	
      	List designerRevisedRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInDB(clientInfoId, designerInfoId);
      	List designerSecondRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInDB(clientInfoId, designerInfoId);
      	String uploadedConcept1Img = fullRoomUploadConcept1ImagesTakefromInDB(req, sn, clientInfoId, designerInfoId);       
      	if(!designerConcept2VerList.isEmpty()){    		
      		AdminAssignClientInfoToDesignerSaving adminAssignCon2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept2UpdationInDB(clientInfoId, designerInfoId);
      		byte[] uploadedConcept2ImageFromDB = adminAssignCon2InfoSaving.getConcept2ImageUpload();
      		uploadedConcept2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept2ImageFromDB);
      		designConceptStatus = adminAssignCon2InfoSaving.getDesignerSubmitConceptsStatus();
      		adminConceptStatus = adminAssignCon2InfoSaving.getAdminApprovedForConcept();
      		secRenPayStatus = adminAssignCon2InfoSaving.getSecondRenderingPaymentStatus();
      	}       
      	if(!designerRoomRendering1VerList.isEmpty()){    		
      		AdminAssignClientInfoToDesignerSaving adminAssignRend1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoId, designerInfoId);
      		byte[] uploadedRmrend1ImageFromDB = adminAssignRend1InfoSaving.getRendering1ImageUpload();
      		uploadedRmrend1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRmrend1ImageFromDB);
      		designRenderingsStatus = adminAssignRend1InfoSaving.getDesignerSubmitRenderingStatus();
      		adminRenderingsStatus = adminAssignRend1InfoSaving.getAdminApprovedForRendering();
      	}
      	String uploadedRmrend2Img = fullRoomUploadRoomRend2ImagesTakefromInDB(req, sn, clientInfoId, designerInfoId);    
      	if(!designerRevisedRendering1VerList.isEmpty()){    		
      		AdminAssignClientInfoToDesignerSaving adminAssignRevRen1dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInDB(clientInfoId, designerInfoId);
      		byte[] uploadedRevrend1ImageFromDB = adminAssignRevRen1dInfoSaving.getRevisedRendering1ImageUpload();
      		uploadedRevrend1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRevrend1ImageFromDB);
      		designRevRenderingsStatus = adminAssignRevRen1dInfoSaving.getDesignerSubmitRevisedRenderingStatus();
      		adminRevRenderingsStatus = adminAssignRevRen1dInfoSaving.getAdminApprovedForRevisedRendering();   		
      	}    
      	String uploadedRevrend2Img = fullRoomUploadRevRend2ImagesTakefromInDB(req, sn, clientInfoId, designerInfoId);
      	if(!designerSecondRendering1VerList.isEmpty()){    		
      		AdminAssignClientInfoToDesignerSaving adminAssignRevRen1dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInDB(clientInfoId, designerInfoId);
      		byte[] uploadedSecRevrend1ImageFromDB = adminAssignRevRen1dInfoSaving.getSecondRendering1ImageUpload();
      		uploadedSecRend1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedSecRevrend1ImageFromDB);
      		designSecRenderingsStatus = adminAssignRevRen1dInfoSaving.getDesignerSubmitSecondRenderingStatus();
      		adminSecRenderingsStatus = adminAssignRevRen1dInfoSaving.getAdminApprovedForSecondRendering();
      	}    
      	String uploadedSecRend2Img = fullRoomUploadSecRend2ImagesTakefromInDB(req, sn, clientInfoId, designerInfoId);   	
      	List adminMessageCountList = adminDesignerMessageInfoSavingDAO.adminMessageCounttoDesignerSideInDB(designerInfoId);
      	sn.setAttribute(adminMessageCountInSN, adminMessageCountList.size());
      	likeImagesValue = conceptRevisedRenderingLikeImagesDisplay(req, sn, clientInfoId, designerInfoId);   	
      	List desnUploadedProductsList1 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoId, designerInfoId);
      	List desnUploadedProductsList2 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoId, designerInfoId);
      	List desnUploadedProductsList3 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
      	List desnUploadedProductsList4 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
      	List desnUploadedProductsList5 = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);    	
      	mav = new ModelAndView(uploadFullRoomPackConceptsAndRenderings);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));   	
      	mav.addObject(createdDate, formatedDate);    	
      	mav.addObject(typeOfSpaceVal, typeOfSpace);    	
      	mav.addObject(clientFullName, clientName);
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
      	mav.addObject(adminConceptsStatus, adminConceptStatus);
      	mav.addObject(adminRenderingStatus, adminRenderingsStatus);
      	mav.addObject(adminRevRenderingStatus, adminRevRenderingsStatus);
      	mav.addObject(adminSecRenderingStatus, adminSecRenderingsStatus);    	
      	mav.addObject(desnUploadedProducts1Count, desnUploadedProductsList1.size());
      	mav.addObject(desnUploadedProducts2Count, desnUploadedProductsList2.size());
      	mav.addObject(desnUploadedProducts3Count, desnUploadedProductsList3.size());
      	mav.addObject(desnUploadedProducts4Count, desnUploadedProductsList4.size());
      	mav.addObject(desnUploadedProducts5Count, desnUploadedProductsList5.size());
      	mav.addObject(likeImagesValues, likeImagesValue);    	
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	mav.addObject(secRenPaymentStatus, secRenPayStatus);
      	return mav;
    }

    @Override
    @Transactional
    public String fullRoomUploadConcept1ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId) {
    	String uploadedConcept1Img = "";
    	List designerConcept1VerList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoId, designerInfoId);
    	if(!designerConcept1VerList.isEmpty()){    		
      		AdminAssignClientInfoToDesignerSaving adminAssignCon1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoId, designerInfoId);    		
      		byte[] uploadedConcept1ImageFromDB = adminAssignCon1InfoSaving.getConcept1ImageUpload();    		
      		uploadedConcept1Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedConcept1ImageFromDB);
      	}
    	return uploadedConcept1Img;
    }    

    @Override
    @Transactional
    public String fullRoomUploadRoomRend2ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId) {
    	String uploadedRmrend2Img = "";
    	List designerRoomRendering2VerList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering2VerificationInDB(clientInfoId, designerInfoId);
    	if(!designerRoomRendering2VerList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignRend2InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering2UpdationInDB(clientInfoId, designerInfoId);
    	   	byte[] uploadedRmrend2ImageFromDB = adminAssignRend2InfoSaving.getRendering2ImageUpload();
    	   	uploadedRmrend2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRmrend2ImageFromDB);
    	}
       	return uploadedRmrend2Img;
    }

    @Override
    @Transactional
    public String fullRoomUploadRevRend2ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId) {
    	String uploadedRevrend2Img = "";
    	List designerRevisedRendering2VerList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2VerificationInDB(clientInfoId, designerInfoId);
    	if(!designerRevisedRendering2VerList.isEmpty()){    		
       		AdminAssignClientInfoToDesignerSaving adminAssignRevRen2dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering2UpdationInDB(clientInfoId, designerInfoId);
       		byte[] uploadedRevrend2ImageFromDB = adminAssignRevRen2dInfoSaving.getRevisedRendering2ImageUpload();
       		uploadedRevrend2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedRevrend2ImageFromDB);
       	}
       	return uploadedRevrend2Img;
    }

    @Override
    @Transactional
    public String fullRoomUploadSecRend2ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId) {
    	String uploadedSecRend2Img = "";
    	List designerSecondRendering2VerList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2VerificationInDB(clientInfoId, designerInfoId);
    	if(!designerSecondRendering2VerList.isEmpty()){    		
       		AdminAssignClientInfoToDesignerSaving adminAssignRevRen2dInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering2UpdationInDB(clientInfoId, designerInfoId);
       		byte[] uploadedSecRevrend2ImageFromDB = adminAssignRevRen2dInfoSaving.getSecondRendering2ImageUpload();
       		uploadedSecRend2Img = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedSecRevrend2ImageFromDB);
       	}
       	return uploadedSecRend2Img;
    }
    
    @Override
    @Transactional
    public ModelAndView fullRoomUploadConcept1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setConcept1ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadConcept2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	   	ModelAndView mav;   	
	   	String fileName = fileDesnUpload.getOriginalFilename();
	   	String filepath = uploadImgPath + fileName;
	   	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
	   	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	   	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
	   	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
	   	if(!adminAssignClInfoList.isEmpty()){    		
	   		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
	   		adminAssignClInfoSaving.setConcept2ImageUpload(bFile);
	   		adminAssignClInfoSaving.setDesignerUploads("YES");
	   		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   	}
	   	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadSecRendConcept1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	   	ModelAndView mav;   	
	   	String fileName = fileDesnUpload.getOriginalFilename();
	   	String filepath = uploadImgPath + fileName;
	   	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
	   	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	   	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
	   	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
	   	if(!adminAssignClInfoList.isEmpty()){    		
	   		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
	   		adminAssignClInfoSaving.setSecondRendering1ImageUpload(bFile);
	   		adminAssignClInfoSaving.setDesignerUploads("YES");
	   		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
	   	}
	   	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadSecRendConcept2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setSecondRendering2ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadRendering1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setRendering1ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadRendering2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setRendering2ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadRevRendering1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setRevisedRendering1ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomUploadRevRendering2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;   	
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);   	
    	List adminAssignClInfoList = adminAssignClientInfoToDesignerSavingDAO.clientCheckListVerificationInDB(clientInfoId, designInfoId);       
    	if(!adminAssignClInfoList.isEmpty()){    		
    		AdminAssignClientInfoToDesignerSaving adminAssignClInfoSaving = adminAssignClientInfoToDesignerSavingDAO.clientCheckListUpdationInDB(clientInfoId, designInfoId);    		
    		adminAssignClInfoSaving.setRevisedRendering2ImageUpload(bFile);
    		adminAssignClInfoSaving.setDesignerUploads("YES");
    		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignClInfoSaving);
    	}
    	mav = new ModelAndView("redirect:" + "reDirFullRoomImageUploadInDB");    	       
    	return mav;
    }
 
    @Override
    @Transactional
    public ModelAndView designerSubmitFullRoomConceptsToAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;	 	
	 	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	 	
	 	List designerConcept1VerList = adminAssignClientInfoToDesignerSavingDAO.designerConcept1VerificationInDB(clientInfoId, designerInfoId);
	 	List designerConcept2VerList = adminAssignClientInfoToDesignerSavingDAO.designerConcept2VerificationInDB(clientInfoId, designerInfoId);	       
	 	if(!designerConcept1VerList.isEmpty() && !designerConcept2VerList.isEmpty()){    		
	 		AdminAssignClientInfoToDesignerSaving adminAssignCon1InfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerConcept1UpdationInDB(clientInfoId, designerInfoId);    		
	 		adminAssignCon1InfoSaving.setDesignerSubmitConceptsStatus("Submitted Concepts");
	 		adminAssignCon1InfoSaving.setDesignerUploads("YES");
	 		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignCon1InfoSaving);
	 	}	        
	 	mav = desnFullRoomPackApprovedMailSentToAdmin(req, sn);	       
	 	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	 	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerSubmitFullRoomRenderingsToAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;	 	
	 	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	 	
	 	List designerRoomRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1VerificationInDB(clientInfoId, designerInfoId);	       	    	
	 	if(!designerRoomRendering1VerList.isEmpty()){    		
	 		AdminAssignClientInfoToDesignerSaving adminAssignRendInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRoomRendering1UpdationInDB(clientInfoId, designerInfoId);
	 		adminAssignRendInfoSaving.setDesignerSubmitRenderingStatus("Submitted Rendering");
	 		adminAssignRendInfoSaving.setDesignerUploads("YES");
	 		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignRendInfoSaving);
	 	}	       
	 	mav = desnFullRoomPackApprovedMailSentToAdmin(req, sn);	       
	 	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	 	return mav;
    }	

    @Override
    @Transactional
    public ModelAndView designerSubmitFullRoomRevisedRenderingsToAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;	 	
	 	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	 	
	 	List designerRevisedRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1VerificationInDB(clientInfoId, designerInfoId);	      
	 	if(!designerRevisedRendering1VerList.isEmpty()){    		
	 		AdminAssignClientInfoToDesignerSaving adminAssignRevRendInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerRevisedRendering1UpdationInDB(clientInfoId, designerInfoId);
	 		adminAssignRevRendInfoSaving.setDesignerSubmitRevisedRenderingStatus("Submitted Revised Rendering");
	 		adminAssignRevRendInfoSaving.setDesignerUploads("YES");
	 		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignRevRendInfoSaving);
	 	}
	 	mav = desnFullRoomPackApprovedMailSentToAdmin(req, sn);	       
	 	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	 	return mav;
    }
	 
    @Override
    @Transactional
    public ModelAndView designerSubmitFullRoom2ndRenderingsToAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;	 	
	 	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	 	
	 	List designerSecRendering1VerList = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1VerificationInDB(clientInfoId, designerInfoId);    	
	 	if(!designerSecRendering1VerList.isEmpty()){    		
	 		AdminAssignClientInfoToDesignerSaving adminAssignSecRendInfoSaving = adminAssignClientInfoToDesignerSavingDAO.designerSecondRendering1UpdationInDB(clientInfoId, designerInfoId);
	 		adminAssignSecRendInfoSaving.setDesignerSubmitSecondRenderingStatus("Submitted Second Rendering");
	 		adminAssignSecRendInfoSaving.setDesignerUploads("YES");
	 		adminAssignClientInfoToDesignerSavingDAO.merge(adminAssignSecRendInfoSaving);
	 	}	      	
	 	mav = desnFullRoomPackApprovedMailSentToAdmin(req, sn);	       
	 	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	 	return mav;
    }

    @Override
    @Transactional    
    public ModelAndView desnFullRoomPackApprovedMailSentToAdmin(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("desnFullRoomPackApprovedMailSentToAdmin...Service");
	    ModelAndView mav;
		long adminUserId = 1;
	    UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        		
	    String toAdd = userInformation.getUserName();
	    String firstName = userInformation.getFirstName();
	    String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		String subject = "You have new uploads that need to be approved.";    	  
		String type = "text/html";    	 
		EmailSending userEmail = new EmailSending();
		String fromAdd = "info@nookandcove.com";    	    
		String body = "<body>" 
	    	      	+ "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
	    	      	+ "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
	    	      	+ "<p style='margin-top: 8px;'>You have new uploads from a designer. Designs need to be thoroughly checked and approved.</p>"
	    	      	+ "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
	    	      	+ "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
	    	      	+ "</div>"
	    	      	+ "</body> ";    	  
		try {
			userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
		} catch (Exception ex) {
			LOGGER.error("desn Full Room Pack Approved Mail Sent To Admin failed " + ex);
		}       
		mav = new ModelAndView();
		return mav;
    } 
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1AccPackProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon1AccPackRetrieveFromDB(req, sn);    	
		} else {
			mav = new ModelAndView(furnitureSpecsConcepts1AccPackProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsCon1AccPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav; 	
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0; 	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
 		for (FurnitureSpecsProductsAccPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
 			furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsAccPackSavingId());
 			furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
 			int count = 1;
 			prodCount = prodCount + count; 			
 			int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    			
 			String prodPrice = furnSpecCon1SavingModel.getProductPrice();
 			prodPrice = prodPrice.replace(",","");
 			prodPrice = prodPrice.replace("$","");
 			double productPrice = Double.parseDouble(prodPrice);
 			double totProductsPrice = productPrice * ProdQuantity;
 			totlProductPrice = totlProductPrice + totProductsPrice;    			
 		} 		
 		totalProductPrice = String.format("%.2f", totlProductPrice);
 		totalProductPrice = "$" + totalProductPrice; 		
 		ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
 		clBudget = clientInfoSaving.getBudget();
 		if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {					
 			clBudget = "$" + clBudget;
 		} else {					
 			clBudget = "";
 		}			
 		mav = new ModelAndView(furnitureSpecsConcepts1AccPackProductsDisplay);
 		sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
 		sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
 		mav.addObject(prodTotalCount, prodCount);
 		mav.addObject(clientBudget, clBudget);
 		mav.addObject(totalProductsPrice, totalProductPrice); 	   
		} else{
     	mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
  
	@Override
	@Transactional
	public ModelAndView furnitureSpecsAccPackDisplayBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
     	mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
        return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1AccPackProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsAccPackSaving furnitureSpecsProAccPackSaving = new FurnitureSpecsProductsAccPackSaving();
     	furnitureSpecsProAccPackSaving.setClientInfoSavingId(clientInfoId);
     	furnitureSpecsProAccPackSaving.setDesignerInfoSavingId(designerInfoId);
     	furnitureSpecsProAccPackSaving.setConceptsRenderingsRefferance("Concept1 Furniture Specs");
     	furnitureSpecsProAccPackSaving.setProductImage(bFile);
     	furnitureSpecsProAccPackSaving.setProductName(req.getParameter(productName));
     	furnitureSpecsProAccPackSaving.setProductPrice(req.getParameter(productPrice));
     	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
     	furnitureSpecsProAccPackSaving.setProductQuantity(quantity);
     	furnitureSpecsProAccPackSaving.setStoreName(req.getParameter(storeName));
     	furnitureSpecsProAccPackSaving.setStoreURL(req.getParameter(storeURL));
     	furnitureSpecsProAccPackSaving.setSkuName(req.getParameter(skuName));
     	furnitureSpecsProAccPackSaving.setProductDescription(req.getParameter(productDescription));
     	furnitureSpecsProAccPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
     	furnitureSpecsProAccPackSaving.setCreatedDate(currentDate);
     	furnitureSpecsProductsAccPackSavingDAO.save(furnitureSpecsProAccPackSaving);        	
     	mav = new ModelAndView("redirect:" + reDirfurnSpecsCon1AccPack);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
        return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsCon1AccPackAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon1AccPackRetrieveFromDB(req, sn);
		} else {
			mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);    	
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1AccPackAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsConcepts1AccPackProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
        return mav;
	}
 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1AccPackDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsAccPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowDeleteFromDB(productId);
			furnitureSpecsProductsAccPackSavingDAO.delete(furnSpecsCon1RowsModel); 		
			mav = reDirfurnSpecsCon1AccPackRetrieveFromDB(req, sn);
		} else {
			mav = new ModelAndView(furnitureSpecsConcepts1AccPackProductsUpload);
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1AccPackEditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsAccPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowDeleteFromDB(productId);
			String prodName = furnSpecsCon1RowsModel.getProductName();
			String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
			int qunty = furnSpecsCon1RowsModel.getProductQuantity();
			String strName = furnSpecsCon1RowsModel.getStoreName();
			String strUrl = furnSpecsCon1RowsModel.getStoreURL();
			byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
			String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
			String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();
			mav = new ModelAndView(furnitureSpecsConcepts1AccPackProductsEdit);
			mav.addObject(productName, prodName);
			mav.addObject(productPrice, prodPrice);
			mav.addObject(productsQuantity, qunty);
			mav.addObject(storeName, strName);
			mav.addObject(storeURL, strUrl);
			mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
			mav.addObject(productDescription, prodDesc);
			mav.addObject(assemblyRequiredStatus, assReqStatus);
			sn.setAttribute(productsIdInSn, productId); 		
		} else {
			mav = reDirfurnSpecsCon1AccPackRetrieveFromDB(req, sn);
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1AccPackEditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName; 	   	
		byte[] bFile = new byte[20971520];
		if(!("").equals(fileName)) {    	
			File conFile = new File(filepath);
			conFile.mkdir(); 	    
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
		}    	  	
     	FurnitureSpecsProductsAccPackSaving furnitureSpecsProAccPackSaving = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept1AccPackRowDeleteFromDB(productId);
     	if(!("").equals(fileName)) {
     		furnitureSpecsProAccPackSaving.setProductImage(bFile);
     	}
     	furnitureSpecsProAccPackSaving.setProductName(req.getParameter(productName));
     	furnitureSpecsProAccPackSaving.setProductPrice(req.getParameter(productPrice));
     	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
     	furnitureSpecsProAccPackSaving.setProductQuantity(quantity);
     	furnitureSpecsProAccPackSaving.setStoreName(req.getParameter(storeName));
     	furnitureSpecsProAccPackSaving.setStoreURL(req.getParameter(storeURL));
     	furnitureSpecsProAccPackSaving.setSkuName(req.getParameter(skuName));
     	furnitureSpecsProAccPackSaving.setProductDescription(req.getParameter(productDescription));
     	furnitureSpecsProAccPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
     	furnitureSpecsProAccPackSaving.setUpdatedDate(currentDate);
     	furnitureSpecsProductsAccPackSavingDAO.merge(furnitureSpecsProAccPackSaving);        	
     	mav = new ModelAndView("redirect:" + reDirfurnSpecsCon1AccPack);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
        return mav;
	}	

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2AccPackProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoId, designerInfoId);		
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon2AccPackRetrieveFromDB(req, sn);    	
		} else {
			mav = new ModelAndView(furnitureSpecsConcepts2AccPackProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsCon2AccPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0; 	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
 		for (FurnitureSpecsProductsAccPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
 			furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsAccPackSavingId());
 			furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
 			int count = 1;
 			prodCount = prodCount + count; 			
 			int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    			
 			String prodPrice = furnSpecCon1SavingModel.getProductPrice();
 			prodPrice = prodPrice.replace(",","");
 			prodPrice = prodPrice.replace("$","");
 			double productPrice = Double.parseDouble(prodPrice);
 			double totProductsPrice = productPrice * ProdQuantity;
 			totlProductPrice = totlProductPrice + totProductsPrice;    			
        } 		
 		totalProductPrice = String.format("%.2f", totlProductPrice);
 		totalProductPrice = "$" + totalProductPrice; 		
 		ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
 		clBudget = clientInfoSaving.getBudget();
 		if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {					
 			clBudget = "$" + clBudget;
 		} else {					
 			clBudget = "";
 		}			
 		mav = new ModelAndView(furnitureSpecsConcepts2AccPackProductsDisplay);
 		sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
 		sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
 		mav.addObject(prodTotalCount, prodCount);
 		mav.addObject(clientBudget, clBudget);
 		mav.addObject(totalProductsPrice, totalProductPrice);
		} else{
			mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
 	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2AccPackProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsAccPackSaving furnitureSpecsProAccPackSaving = new FurnitureSpecsProductsAccPackSaving();
     	furnitureSpecsProAccPackSaving.setClientInfoSavingId(clientInfoId);
     	furnitureSpecsProAccPackSaving.setDesignerInfoSavingId(designerInfoId);
     	furnitureSpecsProAccPackSaving.setConceptsRenderingsRefferance("Concept2 Furniture Specs");
     	furnitureSpecsProAccPackSaving.setProductImage(bFile);
     	furnitureSpecsProAccPackSaving.setProductName(req.getParameter(productName));
     	furnitureSpecsProAccPackSaving.setProductPrice(req.getParameter(productPrice));
     	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
     	furnitureSpecsProAccPackSaving.setProductQuantity(quantity);
     	furnitureSpecsProAccPackSaving.setStoreName(req.getParameter(storeName));
     	furnitureSpecsProAccPackSaving.setStoreURL(req.getParameter(storeURL));
     	furnitureSpecsProAccPackSaving.setSkuName(req.getParameter(skuName));
     	furnitureSpecsProAccPackSaving.setProductDescription(req.getParameter(productDescription));
     	furnitureSpecsProAccPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
     	furnitureSpecsProAccPackSaving.setCreatedDate(currentDate);
     	furnitureSpecsProductsAccPackSavingDAO.save(furnitureSpecsProAccPackSaving);        	
     	mav = new ModelAndView("redirect:" + reDirfurnSpecsCon2AccPack);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
        return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsCon2AccPackAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon2AccPackRetrieveFromDB(req, sn);
		} else {
			mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);    	 
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2AccPackAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsConcepts2AccPackProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));		
		return mav;
	}
 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2AccPackDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsAccPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowDeleteFromDB(productId);
			furnitureSpecsProductsAccPackSavingDAO.delete(furnSpecsCon1RowsModel); 		
			mav = reDirfurnSpecsCon2AccPackRetrieveFromDB(req, sn);
		} else {
			mav = new ModelAndView(furnitureSpecsConcepts2AccPackProductsUpload);
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2AccPackEditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsAccPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowDeleteFromDB(productId);
			String prodName = furnSpecsCon1RowsModel.getProductName();
			String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
			int qunty = furnSpecsCon1RowsModel.getProductQuantity();
			String strName = furnSpecsCon1RowsModel.getStoreName();
			String strUrl = furnSpecsCon1RowsModel.getStoreURL();
			byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
			String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
			String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();     	
			mav = new ModelAndView(furnitureSpecsConcepts2AccPackProductsEdit);
			mav.addObject(productName, prodName);
			mav.addObject(productPrice, prodPrice);
			mav.addObject(productsQuantity, qunty);
			mav.addObject(storeName, strName);
			mav.addObject(storeURL, strUrl);
			mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
			mav.addObject(productDescription, prodDesc);
			mav.addObject(assemblyRequiredStatus, assReqStatus);
			sn.setAttribute(productsIdInSn, productId); 		
		} else {
			mav = reDirfurnSpecsCon2AccPackRetrieveFromDB(req, sn);
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2AccPackEditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;	
		byte[] bFile = new byte[20971520];
		if(!("").equals(fileName)) {    	
			File conFile = new File(filepath);
			conFile.mkdir(); 	    
			fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
		}    	  	
     	FurnitureSpecsProductsAccPackSaving furnitureSpecsProAccPackSaving = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsConcept2AccPackRowDeleteFromDB(productId);
     	if(!("").equals(fileName)) {
     		furnitureSpecsProAccPackSaving.setProductImage(bFile);
     	}
     	furnitureSpecsProAccPackSaving.setProductName(req.getParameter(productName));
     	furnitureSpecsProAccPackSaving.setProductPrice(req.getParameter(productPrice));
     	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
     	furnitureSpecsProAccPackSaving.setProductQuantity(quantity);
     	furnitureSpecsProAccPackSaving.setStoreName(req.getParameter(storeName));
     	furnitureSpecsProAccPackSaving.setStoreURL(req.getParameter(storeURL));
     	furnitureSpecsProAccPackSaving.setSkuName(req.getParameter(skuName));
     	furnitureSpecsProAccPackSaving.setProductDescription(req.getParameter(productDescription));
     	furnitureSpecsProAccPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
     	furnitureSpecsProAccPackSaving.setUpdatedDate(currentDate);
     	furnitureSpecsProductsAccPackSavingDAO.merge(furnitureSpecsProAccPackSaving);        	
     	mav = new ModelAndView("redirect:" + reDirfurnSpecsCon2AccPack);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
        return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designerInfoId);		
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(req, sn);    	
		} else {
			mav = new ModelAndView(furnitureSpecsFinalConceptAccPackProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0; 	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			for (FurnitureSpecsProductsAccPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
				furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsAccPackSavingId());
				furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
	 			int count = 1;
	 			prodCount = prodCount + count; 			
	 			int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    			
	 			String prodPrice = furnSpecCon1SavingModel.getProductPrice();
	 			prodPrice = prodPrice.replace(",","");
	 			prodPrice = prodPrice.replace("$","");
	 			double productPrice = Double.parseDouble(prodPrice);
	 			double totProductsPrice = productPrice * ProdQuantity;
	 			totlProductPrice = totlProductPrice + totProductsPrice;    			
			} 		
			totalProductPrice = String.format("%.2f", totlProductPrice);
	     	totalProductPrice = "$" + totalProductPrice; 		
	     	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
			clBudget = clientInfoSaving.getBudget();
			if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {					
				clBudget = "$" + clBudget;
			} else {					
				clBudget = "";
			}			
			mav = new ModelAndView(furnitureSpecsFinalConceptAccPackProductsDisplay);
			sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
			sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
			mav.addObject(prodTotalCount, prodCount);
			mav.addObject(clientBudget, clBudget);
			mav.addObject(totalProductsPrice, totalProductPrice); 	   
		} else{
			mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
 	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptAccPackProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsAccPackSaving furnitureSpecsProAccPackSaving = new FurnitureSpecsProductsAccPackSaving();
     	furnitureSpecsProAccPackSaving.setClientInfoSavingId(clientInfoId);
     	furnitureSpecsProAccPackSaving.setDesignerInfoSavingId(designerInfoId);
     	furnitureSpecsProAccPackSaving.setConceptsRenderingsRefferance("Final Concept Furniture Specs");
     	furnitureSpecsProAccPackSaving.setProductImage(bFile);
     	furnitureSpecsProAccPackSaving.setProductName(req.getParameter(productName));
     	furnitureSpecsProAccPackSaving.setProductPrice(req.getParameter(productPrice));
     	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
     	furnitureSpecsProAccPackSaving.setProductQuantity(quantity);
     	furnitureSpecsProAccPackSaving.setStoreName(req.getParameter(storeName));
     	furnitureSpecsProAccPackSaving.setStoreURL(req.getParameter(storeURL));
     	furnitureSpecsProAccPackSaving.setSkuName(req.getParameter(skuName));
     	furnitureSpecsProAccPackSaving.setProductDescription(req.getParameter(productDescription));
     	furnitureSpecsProAccPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
     	furnitureSpecsProAccPackSaving.setCreatedDate(currentDate);
     	furnitureSpecsProductsAccPackSavingDAO.save(furnitureSpecsProAccPackSaving);        	
     	mav = new ModelAndView("redirect:" + reDirfurnSpecsAccPackFinalConcept);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
        return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptAccPackAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(req, sn);
		} else {
			mav = desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);    	 
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}
		 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptAccPackAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsFinalConceptAccPackProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));		
		return mav;
	}
 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptAccPackDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsAccPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowDeleteFromDB(productId);
			String conRendReff = furnSpecsCon1RowsModel.getConceptsRenderingsRefferance();
			if(("Concept1 Furniture Specs").equals(conRendReff)) {
				furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackProdRowDeleteFromDB(productId);
			} else if(("Concept2 Furniture Specs").equals(conRendReff)) {
				furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackProdRowDeleteFromDB(productId);
			} else {
				furnitureSpecsProductsAccPackSavingDAO.delete(furnSpecsCon1RowsModel);
			}
			mav = reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(req, sn);
		} else {
			mav = new ModelAndView(furnitureSpecsFinalConceptAccPackProductsUpload);
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptAccPackEditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsAccPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsAccPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowDeleteFromDB(productId);
			String prodName = furnSpecsCon1RowsModel.getProductName();
			String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
			int qunty = furnSpecsCon1RowsModel.getProductQuantity();
			String strName = furnSpecsCon1RowsModel.getStoreName();
			String strUrl = furnSpecsCon1RowsModel.getStoreURL();
			byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
			String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
			String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();     	
			mav = new ModelAndView(furnitureSpecsFinalConceptAccPackProductsEdit);
			mav.addObject(productName, prodName);
			mav.addObject(productPrice, prodPrice);
			mav.addObject(productsQuantity, qunty);
			mav.addObject(storeName, strName);
			mav.addObject(storeURL, strUrl);
			mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
			mav.addObject(productDescription, prodDesc);
			mav.addObject(assemblyRequiredStatus, assReqStatus);
			sn.setAttribute(productsIdInSn, productId); 		
		} else {
			mav = reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(req, sn);
		}		 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 		
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsFinalConceptAccPackEditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		byte[] bFile = new byte[20971520];
		if(!("").equals(fileName)) {    	
			File conFile = new File(filepath);
			conFile.mkdir(); 	    
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
		}    	  	
     	FurnitureSpecsProductsAccPackSaving furnitureSpecsProAccPackSaving = furnitureSpecsProductsAccPackSavingDAO.furnitureSpecsFinalConceptAccPackRowDeleteFromDB(productId);
     	if(!("").equals(fileName)) {
     		furnitureSpecsProAccPackSaving.setProductImage(bFile);
     	}
     	furnitureSpecsProAccPackSaving.setProductName(req.getParameter(productName));
     	furnitureSpecsProAccPackSaving.setProductPrice(req.getParameter(productPrice));
     	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
     	furnitureSpecsProAccPackSaving.setProductQuantity(quantity);
     	furnitureSpecsProAccPackSaving.setStoreName(req.getParameter(storeName));
     	furnitureSpecsProAccPackSaving.setStoreURL(req.getParameter(storeURL));
     	furnitureSpecsProAccPackSaving.setSkuName(req.getParameter(skuName));
     	furnitureSpecsProAccPackSaving.setProductDescription(req.getParameter(productDescription));
     	furnitureSpecsProAccPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
     	furnitureSpecsProAccPackSaving.setUpdatedDate(currentDate);
     	furnitureSpecsProductsAccPackSavingDAO.merge(furnitureSpecsProAccPackSaving);        	
     	mav = new ModelAndView("redirect:" + reDirfurnSpecsAccPackFinalConcept);
     	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
        return mav;
	} 
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1ProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoId, designerInfoId);
	    if (!furnSpecsCon1RowsList.isEmpty()) {
	    	mav = reDirfurnSpecsCon1FullRmPackRetrieveFromDB(req, sn);    	
	    } else {
	    	mav = new ModelAndView(furnitureSpecsConcepts1FRProductsUpload);
	    }
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	    mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
	    return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsCon1FullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0;	    	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			for (FurnitureSpecsProductsFullRoomPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
				furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsFullRoomPackSavingId());
	    		furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
	    		int count = 1;
	    		prodCount = prodCount + count;	    		
	    		int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    		
	    		String prodPrice = furnSpecCon1SavingModel.getProductPrice();
	    		prodPrice = prodPrice.replace(",","");
	     		prodPrice = prodPrice.replace("$","");
	    		double productPrice = Double.parseDouble(prodPrice);
	    		double totProductsPrice = productPrice * ProdQuantity;
	    		totlProductPrice = totlProductPrice + totProductsPrice;    		
			}	    	
			totalProductPrice = String.format("%.2f", totlProductPrice);
	     	totalProductPrice = "$" + totalProductPrice;	    	
	    	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
	    	clBudget = clientInfoSaving.getBudget();		
	    	if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {			
	    		clBudget = "$" + clBudget;
	    	} else {			
	    		clBudget = "";
	    	}		
	    	mav = new ModelAndView(furnitureSpecsConcepts1FRProductsDisplay);
	    	sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	    	sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	    	mav.addObject(prodTotalCount, prodCount);
	    	mav.addObject(clientBudget, clBudget);
	    	mav.addObject(totalProductsPrice, totalProductPrice);	    	   
	        } else{
	        	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	        }    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	    	
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsFRDisplayBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	 	
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1FRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = new FurnitureSpecsProductsFullRoomPackSaving();
		furnitureSpecsProFullRmPackSaving.setClientInfoSavingId(clientInfoId);
		furnitureSpecsProFullRmPackSaving.setDesignerInfoSavingId(designerInfoId);
		furnitureSpecsProFullRmPackSaving.setConceptsRenderingsRefferance("Concept1 Furniture Specs");
		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setCreatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.save(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsCon1FullRmPack);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsCon1FRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon1FullRmPackRetrieveFromDB(req, sn);
		} else {
			mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);    	 
	    }	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1FRAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsConcepts1FRProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1FRDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowDeleteFromDB(productId);
	    	furnitureSpecsProductsFullRoomPackSavingDAO.delete(furnSpecsCon1RowsModel);	    	
	    	mav = reDirfurnSpecsCon1FullRmPackRetrieveFromDB(req, sn);
		} else {
			mav = new ModelAndView(furnitureSpecsConcepts1FRProductsUpload);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1FREditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowDeleteFromDB(productId);
	    	String prodName = furnSpecsCon1RowsModel.getProductName();
	    	String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
	    	int qunty = furnSpecsCon1RowsModel.getProductQuantity();
	    	String strName = furnSpecsCon1RowsModel.getStoreName();
	    	String strUrl = furnSpecsCon1RowsModel.getStoreURL();
	    	byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
	    	String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
	    	String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();	        	
	    	mav = new ModelAndView(furnitureSpecsConcepts1FRProductsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productPrice, prodPrice);
	    	mav.addObject(productsQuantity, qunty);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(storeURL, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
	    	mav.addObject(productDescription, prodDesc);
	    	mav.addObject(assemblyRequiredStatus, assReqStatus);
	    	sn.setAttribute(productsIdInSn, productId);	    	
		} else {
	    	mav = reDirfurnSpecsCon1FullRmPackRetrieveFromDB(req, sn);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts1FREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;	    	  	
		byte[] bFile = new byte[20971520];
		if(!("").equals(fileName)) {    	
			File conFile = new File(filepath);
	        conFile.mkdir();	        
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
		}
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept1FRRowDeleteFromDB(productId);
		if(!("").equals(fileName)) {
			furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		}
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setUpdatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.merge(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsCon1FullRmPack);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}	

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2ProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoId, designerInfoId);		
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon2FullRmPackRetrieveFromDB(req, sn);    	
		} else {
	    	mav = new ModelAndView(furnitureSpecsConcepts2FRProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsCon2FullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0;	    	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			for (FurnitureSpecsProductsFullRoomPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
				furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsFullRoomPackSavingId());
	    		furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
	    		int count = 1;
	    		prodCount = prodCount + count;	    		
	    		int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    		
	    		String prodPrice = furnSpecCon1SavingModel.getProductPrice();
	    		prodPrice = prodPrice.replace(",","");
	     		prodPrice = prodPrice.replace("$","");
	    		double productPrice = Double.parseDouble(prodPrice);
	    		double totProductsPrice = productPrice * ProdQuantity;
	    		totlProductPrice = totlProductPrice + totProductsPrice;    		
			}	    	
	    	totalProductPrice = String.format("%.2f", totlProductPrice);
	     	totalProductPrice = "$" + totalProductPrice;	    	
	    	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
	    	clBudget = clientInfoSaving.getBudget();
	    	if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {			
	    		clBudget = "$" + clBudget;
	    	} else {			
	    		clBudget = "";
	    	}		
	    	mav = new ModelAndView(furnitureSpecsConcepts2FRProductsDisplay);
	    	sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	    	sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	    	mav.addObject(prodTotalCount, prodCount);
	    	mav.addObject(clientBudget, clBudget);
	    	mav.addObject(totalProductsPrice, totalProductPrice);	    	   
		} else{
			mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	    	
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2FRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = new FurnitureSpecsProductsFullRoomPackSaving();
		furnitureSpecsProFullRmPackSaving.setClientInfoSavingId(clientInfoId);
		furnitureSpecsProFullRmPackSaving.setDesignerInfoSavingId(designerInfoId);
		furnitureSpecsProFullRmPackSaving.setConceptsRenderingsRefferance("Concept2 Furniture Specs");
		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setCreatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.save(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsCon2FullRmPack);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsCon2FRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsCon2FullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);    	 
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2FRAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsConcepts2FRProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2FRDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowDeleteFromDB(productId);
	    	furnitureSpecsProductsFullRoomPackSavingDAO.delete(furnSpecsCon1RowsModel);	    	
	    	mav = reDirfurnSpecsCon2FullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = new ModelAndView(furnitureSpecsConcepts2FRProductsUpload);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2FREditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowDeleteFromDB(productId);
	    	String prodName = furnSpecsCon1RowsModel.getProductName();
	    	String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
	    	int qunty = furnSpecsCon1RowsModel.getProductQuantity();
	    	String strName = furnSpecsCon1RowsModel.getStoreName();
	    	String strUrl = furnSpecsCon1RowsModel.getStoreURL();
	    	byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
	    	String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
	    	String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();	        	
	    	mav = new ModelAndView(furnitureSpecsConcepts2FRProductsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productPrice, prodPrice);
	    	mav.addObject(productsQuantity, qunty);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(storeURL, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
	    	mav.addObject(productDescription, prodDesc);
	    	mav.addObject(assemblyRequiredStatus, assReqStatus);
	    	sn.setAttribute(productsIdInSn, productId);	    	
		} else {
	    	mav = reDirfurnSpecsCon2FullRmPackRetrieveFromDB(req, sn);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsConcepts2FREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);	
		Timestamp currentDate = currentDate();
	   	String fileName = fileDesnUpload.getOriginalFilename();
	   	String filepath = uploadImgPath + fileName;	    	  	
	   	byte[] bFile = new byte[20971520];
	   	if(!("").equals(fileName)) {    	
	   		File conFile = new File(filepath);
	        conFile.mkdir();	        
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
	   	}
	   	FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsConcept2FRRowDeleteFromDB(productId);
	   	if(!("").equals(fileName)) {
	   		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
	   	}
	   	furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
	   	furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
	   	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
	   	furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
	   	furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
	   	furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
	   	furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
	   	furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
	   	furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
	   	furnitureSpecsProFullRmPackSaving.setUpdatedDate(currentDate);
	   	furnitureSpecsProductsFullRoomPackSavingDAO.merge(furnitureSpecsProFullRmPackSaving);        	
	   	mav = new ModelAndView("redirect:" + reDirfurnSpecsCon2FullRmPack);
	   	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
	   	return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);		
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(req, sn);    	
		} else {
			mav = new ModelAndView(furnitureSpecsRoomRenderingFRProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0;	    	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			for (FurnitureSpecsProductsFullRoomPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
				furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsFullRoomPackSavingId());
	    		furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
	    		int count = 1;
	    		prodCount = prodCount + count;	    		
	    		int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    		
	    		String prodPrice = furnSpecCon1SavingModel.getProductPrice();
	    		prodPrice = prodPrice.replace(",","");
	     		prodPrice = prodPrice.replace("$","");
	    		double productPrice = Double.parseDouble(prodPrice);
	    		double totProductsPrice = productPrice * ProdQuantity;
	    		totlProductPrice = totlProductPrice + totProductsPrice;    		
			}
			totalProductPrice = String.format("%.2f", totlProductPrice);
	     	totalProductPrice = "$" + totalProductPrice;	    	
	    	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
	    	clBudget = clientInfoSaving.getBudget();
	    	if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {			
	    		clBudget = "$" + clBudget;
	    	} else {			
	    		clBudget = "";
	    	}		
	    	mav = new ModelAndView(furnitureSpecsRoomRenderingFRProductsDisplay);
	    	sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	    	sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	    	mav.addObject(prodTotalCount, prodCount);
	    	mav.addObject(clientBudget, clBudget);
	    	mav.addObject(totalProductsPrice, totalProductPrice);	    	   
	        } else{
	        	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	        }    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	    	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingFRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = new FurnitureSpecsProductsFullRoomPackSaving();
		furnitureSpecsProFullRmPackSaving.setClientInfoSavingId(clientInfoId);
		furnitureSpecsProFullRmPackSaving.setDesignerInfoSavingId(designerInfoId);
		furnitureSpecsProFullRmPackSaving.setConceptsRenderingsRefferance("Room Rendering Furniture Specs");
		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setCreatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.save(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsFullRmPackRoomRendering);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}
 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);    	 
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingFRAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsRoomRenderingFRProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingFRDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowDeleteFromDB(productId);
	    	String conRendReff = furnSpecsCon1RowsModel.getConceptsRenderingsRefferance();
	    	if(("Concept1 Furniture Specs").equals(conRendReff)) {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRProdRowDeleteFromDB(productId);
	    	} else if(("Concept2 Furniture Specs").equals(conRendReff)) {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRProdRowDeleteFromDB(productId);
	    	} else {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.delete(furnSpecsCon1RowsModel);
	    	}	    	
	    	mav = reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = new ModelAndView(furnitureSpecsRoomRenderingFRProductsUpload);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingFREditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowVerUsingIdInDB(productId);
	   	if (!furnSpecsCon1RowsList.isEmpty()) {
	    	FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowDeleteFromDB(productId);
	    	String prodName = furnSpecsCon1RowsModel.getProductName();
	    	String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
	    	int qunty = furnSpecsCon1RowsModel.getProductQuantity();
	    	String strName = furnSpecsCon1RowsModel.getStoreName();
	    	String strUrl = furnSpecsCon1RowsModel.getStoreURL();
	    	byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
	       	String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
	       	String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();	        	
	    	mav = new ModelAndView(furnitureSpecsRoomRenderingFRProductsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productPrice, prodPrice);
	    	mav.addObject(productsQuantity, qunty);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(storeURL, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
	    	mav.addObject(productDescription, prodDesc);
	    	mav.addObject(assemblyRequiredStatus, assReqStatus);
	    	sn.setAttribute(productsIdInSn, productId);	    	
	   	} else {
	    	mav = reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(req, sn);
	   	}	 
	   	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRoomRenderingFREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);	
		Timestamp currentDate = currentDate();
	   	String fileName = fileDesnUpload.getOriginalFilename();
	   	String filepath = uploadImgPath + fileName;	    	 	
	   	byte[] bFile = new byte[20971520];
	   	if(!("").equals(fileName)) {    	
	    	File conFile = new File(filepath);
	        conFile.mkdir();	        
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
	   	}
	   	FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRoomRenderingFRRowDeleteFromDB(productId);
	   	if(!("").equals(fileName)) {
	   		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
	   	}
	   	furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
	   	furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
	   	int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
	   	furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
	   	furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
	   	furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
	   	furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
	   	furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
	   	furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
	   	furnitureSpecsProFullRmPackSaving.setUpdatedDate(currentDate);
	   	furnitureSpecsProductsFullRoomPackSavingDAO.merge(furnitureSpecsProFullRmPackSaving);        	
	   	mav = new ModelAndView("redirect:" + reDirfurnSpecsFullRmPackRoomRendering);
	   	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	   	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);		
		if (!furnSpecsCon1RowsList.isEmpty()) {
	    	mav = reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(req, sn);    	
		} else {
			mav = new ModelAndView(furnitureSpecs2ndRenderingFRProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0;	    	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			for (FurnitureSpecsProductsFullRoomPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
				furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsFullRoomPackSavingId());
	    		furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
	    		int count = 1;
	    		prodCount = prodCount + count;	    		
	    		int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    		
	    		String prodPrice = furnSpecCon1SavingModel.getProductPrice();
	    		prodPrice = prodPrice.replace(",","");
	     		prodPrice = prodPrice.replace("$","");
	    		double productPrice = Double.parseDouble(prodPrice);
	    		double totProductsPrice = productPrice * ProdQuantity;
	    		totlProductPrice = totlProductPrice + totProductsPrice;    		
			}
	    	totalProductPrice = String.format("%.2f", totlProductPrice);
	     	totalProductPrice = "$" + totalProductPrice;
	     	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
	     	clBudget = clientInfoSaving.getBudget();
	     	if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {			
	     		clBudget = "$" + clBudget;
	     	} else {			
	     		clBudget = "";
	     	}		
	     	mav = new ModelAndView(furnitureSpecs2ndRenderingFRProductsDisplay);
	     	sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	     	sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	     	mav.addObject(prodTotalCount, prodCount);
	     	mav.addObject(clientBudget, clBudget);
	     	mav.addObject(totalProductsPrice, totalProductPrice);	    	   
		} else{
			mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	    	
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingFRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = new FurnitureSpecsProductsFullRoomPackSaving();
		furnitureSpecsProFullRmPackSaving.setClientInfoSavingId(clientInfoId);
		furnitureSpecsProFullRmPackSaving.setDesignerInfoSavingId(designerInfoId);
		furnitureSpecsProFullRmPackSaving.setConceptsRenderingsRefferance("2nd Rendering Furniture Specs");
		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setCreatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.save(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsFullRmPack2ndRendering);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);    	 
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingFRAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecs2ndRenderingFRProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingFRDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowDeleteFromDB(productId);
	    	String conRendReff = furnSpecsCon1RowsModel.getConceptsRenderingsRefferance();
	    	if(("Concept1 Furniture Specs").equals(conRendReff)) {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRProdRowDeleteFromDB(productId);
	    	} else if(("Concept2 Furniture Specs").equals(conRendReff)) {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRProdRowDeleteFromDB(productId);
	    	} else {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.delete(furnSpecsCon1RowsModel);
	    	}	    	
	    	mav = reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = new ModelAndView(furnitureSpecs2ndRenderingFRProductsUpload);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingFREditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowDeleteFromDB(productId);
	    	String prodName = furnSpecsCon1RowsModel.getProductName();
	    	String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
	    	int qunty = furnSpecsCon1RowsModel.getProductQuantity();
	    	String strName = furnSpecsCon1RowsModel.getStoreName();
	    	String strUrl = furnSpecsCon1RowsModel.getStoreURL();
	    	byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
	    	String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
	    	String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();	        	
	    	mav = new ModelAndView(furnitureSpecs2ndRenderingFRProductsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productPrice, prodPrice);
	    	mav.addObject(productsQuantity, qunty);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(storeURL, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
	    	mav.addObject(productDescription, prodDesc);
	    	mav.addObject(assemblyRequiredStatus, assReqStatus);
	    	sn.setAttribute(productsIdInSn, productId);	    	
		} else {
	    	mav = reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(req, sn);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecs2ndRenderingFREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);	
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;	    	
		byte[] bFile = new byte[20971520];
		if(!("").equals(fileName)) {    	
			File conFile = new File(filepath);
	        conFile.mkdir();	        
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
		}
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecs2ndRenderingFRRowDeleteFromDB(productId);
		if(!("").equals(fileName)) {
			furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		}
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setUpdatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.merge(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsFullRmPack2ndRendering);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingProductsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);		
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(req, sn);    	
		} else {
			mav = new ModelAndView(furnitureSpecsRevisedRenderingFRProductsUpload);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}	 

	@Override
	@Transactional
	public ModelAndView reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0;	    	
		String clBudget = "";
		String totalProductPrice = "";
		double totlProductPrice = 0.0;
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			for (FurnitureSpecsProductsFullRoomPackSaving furnSpecCon1SavingModel : furnSpecsCon1RowsList) {
	    		furnSpecSavingIdList.add(furnSpecCon1SavingModel.getFurnitureSpecsProductsFullRoomPackSavingId());
	    		furnSpecProductNameList.add(furnSpecCon1SavingModel.getProductName());
	    		int count = 1;
	    		prodCount = prodCount + count;	    		
	    		int ProdQuantity = furnSpecCon1SavingModel.getProductQuantity();    		
	    		String prodPrice = furnSpecCon1SavingModel.getProductPrice();
	    		prodPrice = prodPrice.replace(",","");
	     		prodPrice = prodPrice.replace("$","");
	    		double productPrice = Double.parseDouble(prodPrice);
	    		double totProductsPrice = productPrice * ProdQuantity;
	    		totlProductPrice = totlProductPrice + totProductsPrice;    		
			}	    	
	    	totalProductPrice = String.format("%.2f", totlProductPrice);
	     	totalProductPrice = "$" + totalProductPrice;
	     	ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.clientDirectoryValuesUpdationByAdmin(clientInfoId);
	     	clBudget = clientInfoSaving.getBudget();
	     	if(!("").equals(clBudget) && null != clBudget && !("NOT SURE YET").equals(clBudget)) {			
	     		clBudget = "$" + clBudget;
	     	} else {			
	     		clBudget = "";
	     	}		
	     	mav = new ModelAndView(furnitureSpecsRevisedRenderingFRProductsDisplay);
	     	sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	     	sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	     	mav.addObject(prodTotalCount, prodCount);
	     	mav.addObject(clientBudget, clBudget);
	     	mav.addObject(totalProductsPrice, totalProductPrice);	    	   
		} else{
			mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
		return mav;
	}
	 
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingFRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = new FurnitureSpecsProductsFullRoomPackSaving();
		furnitureSpecsProFullRmPackSaving.setClientInfoSavingId(clientInfoId);
		furnitureSpecsProFullRmPackSaving.setDesignerInfoSavingId(designerInfoId);
		furnitureSpecsProFullRmPackSaving.setConceptsRenderingsRefferance("Revised Rendering Furniture Specs");
		furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setCreatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.save(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsFullRmPackRevisedRendering);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
		long designerInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerificationInDB(clientInfoId, designerInfoId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			mav = reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(req, sn);
		} else {
	    	mav = desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);    	 
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingFRAddNewRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(furnitureSpecsRevisedRenderingFRProductsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingFRDeleteInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
	    	FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowDeleteFromDB(productId);
	    	String conRendReff = furnSpecsCon1RowsModel.getConceptsRenderingsRefferance();
	    	if(("Concept1 Furniture Specs").equals(conRendReff)) {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRProdRowDeleteFromDB(productId);
	    	} else if(("Concept2 Furniture Specs").equals(conRendReff)) {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRProdRowDeleteFromDB(productId);
	    	} else {
	    		furnitureSpecsProductsFullRoomPackSavingDAO.delete(furnSpecsCon1RowsModel);
	    	}	    	
	    	mav = reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(req, sn);
		} else {
			mav = new ModelAndView(furnitureSpecsRevisedRenderingFRProductsUpload);
	    }	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingFREditInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter(storeURL);
		long productId = Long.parseLong(produtId);		
		List<FurnitureSpecsProductsFullRoomPackSaving> furnSpecsCon1RowsList = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowVerUsingIdInDB(productId);
		if (!furnSpecsCon1RowsList.isEmpty()) {
			FurnitureSpecsProductsFullRoomPackSaving furnSpecsCon1RowsModel = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowDeleteFromDB(productId);
	    	String prodName = furnSpecsCon1RowsModel.getProductName();
	    	String prodPrice = furnSpecsCon1RowsModel.getProductPrice();
	    	int qunty = furnSpecsCon1RowsModel.getProductQuantity();
	    	String strName = furnSpecsCon1RowsModel.getStoreName();
	    	String strUrl = furnSpecsCon1RowsModel.getStoreURL();
	    	byte[] productImgFromDB = furnSpecsCon1RowsModel.getProductImage();
			String productsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB);
			String skuNames = furnSpecsCon1RowsModel.getSkuName();
	    	String prodDesc = furnSpecsCon1RowsModel.getProductDescription();
	    	String assReqStatus = furnSpecsCon1RowsModel.getAssemblyRequiredStatus();
	    	mav = new ModelAndView(furnitureSpecsRevisedRenderingFRProductsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productPrice, prodPrice);
	    	mav.addObject(productsQuantity, qunty);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(storeURL, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productImage, productsImage);
	    	mav.addObject(productDescription, prodDesc);
	    	mav.addObject(assemblyRequiredStatus, assReqStatus);
	    	sn.setAttribute(productsIdInSn, productId);
		} else {
	    	mav = reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(req, sn);
		}	 
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN)); 	
		return mav;
	}
	  
	@Override
	@Transactional
	public ModelAndView furnitureSpecsRevisedRenderingFREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;
		long productId = (Long)sn.getAttribute(productsIdInSn);
		Timestamp currentDate = currentDate();
		String fileName = fileDesnUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		byte[] bFile = new byte[20971520];
		if(!("").equals(fileName)) {    	
	    	File conFile = new File(filepath);
	        conFile.mkdir();	        
	        fileDesnUpload.transferTo(conFile);        
	        bFile = new byte[(int) conFile.length()];    	      
	        try {
	        	FileInputStream fileInputStream = new FileInputStream(conFile);
	        	fileInputStream.read(bFile);
	        	fileInputStream.close();
	        } 
	        catch (Exception e) {
	        	LOGGER.error("Blog Exception: "+e);
	        }
		}
		FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsProFullRmPackSaving = furnitureSpecsProductsFullRoomPackSavingDAO.furnitureSpecsRevisedRenderingFRRowDeleteFromDB(productId);
		if(!("").equals(fileName)) {
			furnitureSpecsProFullRmPackSaving.setProductImage(bFile);
		}
		furnitureSpecsProFullRmPackSaving.setProductName(req.getParameter(productName));
		furnitureSpecsProFullRmPackSaving.setProductPrice(req.getParameter(productPrice));
		int quantity = Integer.parseInt(req.getParameter(productsQuantity));        	
		furnitureSpecsProFullRmPackSaving.setProductQuantity(quantity);
		furnitureSpecsProFullRmPackSaving.setStoreName(req.getParameter(storeName));
		furnitureSpecsProFullRmPackSaving.setStoreURL(req.getParameter(storeURL));
		furnitureSpecsProFullRmPackSaving.setSkuName(req.getParameter(skuName));
		furnitureSpecsProFullRmPackSaving.setProductDescription(req.getParameter(productDescription));
		furnitureSpecsProFullRmPackSaving.setAssemblyRequiredStatus(req.getParameter(assemblyRequiredStatus));
		furnitureSpecsProFullRmPackSaving.setUpdatedDate(currentDate);
		furnitureSpecsProductsFullRoomPackSavingDAO.merge(furnitureSpecsProFullRmPackSaving);        	
		mav = new ModelAndView("redirect:" + reDirfurnSpecsFullRmPackRevisedRendering);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));       
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
    public ModelAndView designerAccountRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List selectedDesnRowIdList = designerInfoSavingDAO.selectedDesnRowIdVerificationUsingStatus((Long) sn.getAttribute(userIdInSn));    	
        String buffDBImage = null;
        String desnrPerBio = null;
        String desnrCreden = null;
        String desnrLocation = null;        
        String clientReqStatus = "";
    	if(!selectedDesnRowIdList.isEmpty()){    	
    		DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));    	
    		byte[] uploadedImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();    	
    		if(null != uploadedImageFromDB) {
    			buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
    		}
    		clientReqStatus = designerInfoSaving.getDesWaitingForClientStatus();    	
    	}    	
    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
    	String firstName = userInformation.getFirstName();
    	String lastName = userInformation.getLastName();
    	String desPhoneNo = userInformation.getPhoneNumber();
    	String userName = userInformation.getUserName();
    	String fullName = firstName + " " + lastName;    	
    	desnrPerBio = userInformation.getDesnPersonalBio();
    	desnrCreden = userInformation.getDesnCredential();
    	desnrLocation = userInformation.getDesnLocation();    	
    	DesignerInfoSaving designerInfoModel = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
    	designerInfoModel.setDesignerFullName(fullName);
    	designerInfoSavingDAO.merge(designerInfoModel);    	
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
    	List adminMessageCountList = adminDesignerMessageInfoSavingDAO.adminMessageCounttoDesignerSideInDB(designInfoId);    	
    	mav = new ModelAndView("designerDetailsVerification");
    	sn.setAttribute(adminMessageCountInSN, adminMessageCountList.size());
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(desnFullName, fullName);
    	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));    	
    	mav.addObject(uploadedDesImg, buffDBImage);    	
    	mav.addObject(desnPhoneNumber, desPhoneNo);
    	mav.addObject(desnerUserName, userName);
    	mav.addObject(desWaitingForClientReq, clientReqStatus);
    	mav.addObject(desnPersonalBio, desnrPerBio);
    	mav.addObject(desnCredentials, desnrCreden);
    	mav.addObject(desnLocation, desnrLocation);    	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView uploadDesInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List selectedDesnRowIdList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));        
        String buffDBImage = null;
        String desnMessage = null;
        String desPhoneNo = null;
        String clientReqStatus = "";
    	if(!selectedDesnRowIdList.isEmpty()){    	
    		DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
	    	designerInfoSaving.setQuirkyFactsAboutDesigner(req.getParameter(factsaboutdesigner));
	    	designerInfoSaving.setStatus("Done");
	    	String designerFullName = customerNameFromDB((Long) sn.getAttribute(userIdInSn));
	    	designerInfoSaving.setDesignerFullName(designerFullName);
	    	designerInfoSavingDAO.merge(designerInfoSaving);
	    	clientReqStatus = designerInfoSaving.getDesWaitingForClientStatus();    	
	    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));    	  
	    	userInformation.setPhoneNumber(req.getParameter("phoneNumber"));
	    	userInformationDAO.merge(userInformation);    	
	    	byte[] uploadedImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();
	    	buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
	    	desnMessage = designerInfoSaving.getQuirkyFactsAboutDesigner();
	    	desPhoneNo = designerPhoneNumberFromDB((Long) sn.getAttribute(userIdInSn));
    	}    	
    	mav = new ModelAndView("designerDetailsVerification");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(desnerUserName, (String) sn.getAttribute(userNameInSn));
    	mav.addObject(uploadedDesImg, buffDBImage);
    	mav.addObject(factsAboutDesn, desnMessage);
    	mav.addObject(desnPhoneNumber, desPhoneNo);
    	mav.addObject(desWaitingForClientReq, clientReqStatus);
    	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
    	return mav;
    }
	
    @Override
    @Transactional
    public ModelAndView uploadDesignerProfileInDBTables(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;
    	String fileName = fileDesnUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
 	   	conFile.mkdir();        
 	   	fileDesnUpload.transferTo(conFile);
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
        List selectedDesnRowIdList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));        
        String buffDBImage = null;
        String clientReqStatus = "";        
    	if(!selectedDesnRowIdList.isEmpty()){    	
	    	DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
	    	designerInfoSaving.setDesignerProfileImageBlob(bFile);
	    	designerInfoSaving.setStatus("Done");
	    	designerInfoSaving.setUpdatedDate(currentDate);
	    	designerInfoSavingDAO.merge(designerInfoSaving);
	    	byte[] uploadedImageFromDB = designerInfoSaving.getDesignerProfileImageBlob();
	    	buffDBImage = javax.xml.bind.DatatypeConverter.printBase64Binary(uploadedImageFromDB);
	    	clientReqStatus = designerInfoSaving.getDesWaitingForClientStatus();    	
    	}    	
    	mav = new ModelAndView("redirect:" + "reDirDesignerImageInDB");    	  	
        sn.setAttribute(uploadedImgInSN, buffDBImage);
        sn.setAttribute(desWaitingForClientReqInSn, clientReqStatus);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView reLoadDesignerUploadImagesInDBTables(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
    	String firstName = userInformation.getFirstName();
    	String lastName = userInformation.getLastName();
    	String desPhoneNo = userInformation.getPhoneNumber();
    	String userName = userInformation.getUserName();
    	String fullName = firstName + " " + lastName;    	
    	String desnrPerBio = userInformation.getDesnPersonalBio();
    	String desnrCreden = userInformation.getDesnCredential();
    	String desnrLocation = userInformation.getDesnLocation();    	
    	mav = new ModelAndView("designerDetailsVerification");
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(desnerUserName, userName);
    	mav.addObject(uploadedDesImg, sn.getAttribute(uploadedImgInSN));
    	mav.addObject(desnPhoneNumber, desPhoneNo);
    	mav.addObject(desWaitingForClientReq, sn.getAttribute(desWaitingForClientReqInSn));
    	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
    	mav.addObject(desnFullName, fullName);
    	mav.addObject(desnPersonalBio, desnrPerBio);
    	mav.addObject(desnCredentials, desnrCreden);
    	mav.addObject(desnLocation, desnrLocation);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView messageForAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView("redirect:" + reDirDesignerAndAdminMes);
    	return mav;
    }    

    @Override
    @Transactional
    public ModelAndView designerMessageSendToAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    
	   	Timestamp currentDate = currentDate();	   
	   	String timeString  = timeGettingFromCurrentDate();
	   	timeString = timeString.replaceAll(" ", "");   
	   	String todayDate = todayDateGettingFromCurrentDate();	      
	   	String totalDate = todayDate + " " + timeString;
	   	String oneTimeRefDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate) + "_D";
	    List<AdminDesignerMessageInfoSaving> adminAndDesnMsgInfoList = adminDesignerMessageInfoSavingDAO.oneTimeDateFormationCheckingInDB(oneTimeRefDate);
	   	String desnMessage = req.getParameter("designerMessageForAdmin");
	   	desnMessage = desnMessage.replaceAll("[\n\r]", " ");
	   	String desnMsgData = totalDate + "__" + desnMessage;         
	   	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
	   	if (adminAndDesnMsgInfoList.isEmpty()) {
	    	mav = designerOneTimeSentMailToAdmin(req, sn);
	    }
    	AdminDesignerMessageInfoSaving adminDesMessageSavingModel = new AdminDesignerMessageInfoSaving();
    	adminDesMessageSavingModel.setDesignerInfoSavingId(designInfoId);
    	adminDesMessageSavingModel.setMessageInfo(desnMsgData);
    	adminDesMessageSavingModel.setStatus("DESADNEW");
	 	adminDesMessageSavingModel.setCreatedDate(currentDate);
	 	adminDesMessageSavingModel.setOneTimeRefDate(oneTimeRefDate);
	 	adminDesignerMessageInfoSavingDAO.save(adminDesMessageSavingModel);
	 	mav = new ModelAndView("redirect:" + reDirDesignerAndAdminMes);         	
        return mav;
    } 

    @Override
    @Transactional
    public ModelAndView designerOneTimeSentMailToAdmin(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
        long adminUserId = 1;
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        	
        String toAdd = userInformation.getUserName();
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "You have a new message from a designer.";    	  
        String type = "text/html";    	 
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";    	    
        String body = "<body>" 
    	    		+ "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
    	    		+ "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
    	    		+ "<p style='padding-top: 5px;'>You have a new message from a designer.</p>"
    	    		+ "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
    	    		+ "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
    	    		+ "</div>"
    	    		+ "</body> ";    	  
        try {
        	userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
        } catch (Exception ex) {
        	LOGGER.error("Designer One Time Sent Mail To Admin failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
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
    public ModelAndView adminAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
    	adminDesignerMessageInfoSavingDAO.adminMessagesStatusUpdateInDesignerSide(designInfoId);	   
	 	String desnAndAdminMesList = "";
	 	List<AdminDesignerMessageInfoSaving> adminAndDesnMesInfoList = adminDesignerMessageInfoSavingDAO.adminAndDesignerMessageInfoRowVerificationInDB(designInfoId);
	 	if (!adminAndDesnMesInfoList.isEmpty()) {
	 		for (AdminDesignerMessageInfoSaving adminAndDesnMesInfoModel : adminAndDesnMesInfoList) {      	
	 			String adminAndDesMesVal = adminAndDesnMesInfoModel.getMessageInfo();
	 			desnAndAdminMesList = desnAndAdminMesList + "_,_" + adminAndDesMesVal;
	 		}
         	desnAndAdminMesList = desnAndAdminMesList.replaceFirst("_,_", "");
	 	}         	
	 	List adminMessageCountList = adminDesignerMessageInfoSavingDAO.adminMessageCounttoDesignerSideInDB(designInfoId);
	 	mav = new ModelAndView("messageAdminRedirection");
	 	mav.addObject("desAndAdminMessList", desnAndAdminMesList);
	 	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	 	sn.setAttribute(adminMessageCountInSN, adminMessageCountList.size());	 		
	 	return mav;
    }
    
	@Override
	@Transactional
	public int clientMessagesCountInDesnSideTakeFromDB(long clientInfoId, long designerInfoId) {
		int clMessagesCoun = 0;
		if(clientInfoId > 0 && designerInfoId > 0) {			
			List clMessCountList = clientDesignerMessageInfoSavingDAO.clientMessageInfoCountInDesigner(clientInfoId, designerInfoId);
			clMessagesCoun = clMessCountList.size();			
		}
		return clMessagesCoun;
	}
    
    @Override
    @Transactional
    public ModelAndView viewClientMessageRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String clentInfoIdList = req.getParameter("desCliens");   	
    	if(("View Client").equals(req.getParameter(clientMessageRefType))) {	    		    	
    		String[] clentInfoIdString = clentInfoIdList.split(", ");
    		sn.setAttribute(clientInfoSavingIdInSn, clentInfoIdString[0]);
    		sn.setAttribute(designerInfoSavingIdInSn, clentInfoIdString[1]);
    		mav = viewClientInformationForDesigner(req, sn, clentInfoIdString[0], clentInfoIdString[1]);
    	} else if(("View Message").equals(req.getParameter(clientMessageRefType))) {
    		String[] clentInfoIdString = clentInfoIdList.split(", ");
    		sn.setAttribute(clientInfoSavingIdInSn, clentInfoIdString[0]);
    		sn.setAttribute(designerInfoSavingIdInSn, clentInfoIdString[1]);
    		mav = viewClientMessageInformation(req, sn, clentInfoIdString[0], clentInfoIdString[1]);
    	} else if(("Archive Clients").equals(req.getParameter(clientMessageRefType))) {
    		String[] clentInfoIdString = clentInfoIdList.split(", ");
    		sn.setAttribute(clientInfoSavingIdInSn, clentInfoIdString[0]);
    		sn.setAttribute(designerInfoSavingIdInSn, clentInfoIdString[1]);
    		mav = viewArchiveClientsInformation(req, sn, clentInfoIdString[0], clentInfoIdString[1]);
    	} else {
    		List designerInfoSavingList = designerInfoSavingDAO.selectedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
    		if (!designerInfoSavingList.isEmpty()) {
    			Timestamp currentDate = currentDate(); 
    			DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.updatedDesnRowIdVerification((Long) sn.getAttribute(userIdInSn));
    			designerInfoSaving.setDesWaitingForClientStatus("Request For Client");
    			designerInfoSaving.setDesWaitingForClientDate(currentDate);
    			designerInfoSavingDAO.merge(designerInfoSaving);
    			mav = designerClientsRedirection(req, sn);
    		} else {
    			mav = designerClientsRedirection(req, sn);
    		}
    	}    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView viewClientInformationForDesigner(HttpServletRequest req, HttpSession sn, String clentInfoId, String desInfoId) {
    	ModelAndView mav;
    	long clientInfoId = Long.parseLong(clentInfoId);
    	long designerInfoId = Long.parseLong(desInfoId);
    	sn.setAttribute(clientInfoSavingIdInSn, clientInfoId);
		sn.setAttribute(designerInfoSavingIdInSn, designerInfoId);
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);     	
        String designPackage = myRoomInfoSaving.getDesignPackage();
        if(("Accessories Package").equals(designPackage)) {
        	mav = designerSideAccessoriesPackageRedirection(req, sn);
        } else if(("Full Room Design Package").equals(designPackage)) {
        	mav = designerSideFullRoomDesignPackageRedirection(req, sn);
        } else {
        	mav = designerClientsRedirection(req, sn);
        }        
    	return mav;
    }
   
    @Override
    @Transactional
    public ModelAndView viewClientMessageInformation(HttpServletRequest req, HttpSession sn, String clientsInfoIdStr, String designersInfoIdStr) {
    	ModelAndView mav;
    	long clientInfoId = Long.parseLong(clientsInfoIdStr);
    	long designerInfoId = Long.parseLong(designersInfoIdStr);
    	sn.setAttribute(clientInfoSavingIdInSn, clientInfoId);
    	sn.setAttribute(designerInfoSavingIdInSn, designerInfoId);
    	mav = new ModelAndView("redirect:" + reDirDesignerAndClientMes);	 	
    	return mav;
    }
   
    @Override
    @Transactional
    public ModelAndView viewArchiveClientsInformation(HttpServletRequest req, HttpSession sn, String clientsInfoIdStr, String designersInfoIdStr) {
    	ModelAndView mav;
    	long clientInfoId = Long.parseLong(clientsInfoIdStr);
    	long designerInfoId = Long.parseLong(designersInfoIdStr);
    	sn.setAttribute(clientInfoSavingIdInSn, clientInfoId);
    	sn.setAttribute(designerInfoSavingIdInSn, designerInfoId);
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designerInfoId);
    	myRoomInfoSaving.setRoomStatus("Finished");
    	clientInfoSavingDAO.merge(myRoomInfoSaving);
    	mav = designerClientsRedirection(req, sn);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerMessageForClientRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView("redirect:" + reDirDesignerAndClientMes);	 	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerNotesDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
    	String designNotes = myRoomInfoSaving.getDesigerNotes();
    	mav = new ModelAndView("designerNotesDisplayRed");
    	mav.addObject(desigerNotes, designNotes);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerNotesDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
      	String desigersNotes = req.getParameter(desigerNotes);
      	desigersNotes = desigersNotes.replaceAll("[\n\r]", " ");
    	myRoomInfoSaving.setDesigerNotes(desigersNotes);
    	clientInfoSavingDAO.merge(myRoomInfoSaving);
    	mav = designerNotesDisplayRedirection(req, sn);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomDesignerNotesDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
    	String designNotes = myRoomInfoSaving.getDesigerNotes();
    	mav = new ModelAndView("fullRoomDesignerNotesDisplayRed");
    	mav.addObject(desigerNotes, designNotes);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView fullRoomDesignerNotesDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
      	String desigersNotes = req.getParameter(desigerNotes);
      	desigersNotes = desigersNotes.replaceAll("[\n\r]", " ");
    	myRoomInfoSaving.setDesigerNotes(desigersNotes);
    	clientInfoSavingDAO.merge(myRoomInfoSaving);
    	mav = fullRoomDesignerNotesDisplayRedirection(req, sn);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerMessageSendToClientRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    
	    Timestamp currentDate = currentDate();
	    String timeString  = timeGettingFromCurrentDate();
		timeString = timeString.replaceAll(" ", "");   
		String todayDate = todayDateGettingFromCurrentDate();	      
		String totalDate = todayDate + " " + timeString;
		String oneTimeRefDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate) + "_D";
		List<ClientDesignerMessageInfoSaving> clientAndDesnMsgInfoList = clientDesignerMessageInfoSavingDAO.oneTimeDateFormationCheckingInDB(oneTimeRefDate);
	    String designerMessage = req.getParameter("designersMessage");
	    designerMessage = designerMessage.replaceAll("[\n\r]", " ");
		String clMsgData = totalDate +"__" + designerMessage;	   
		long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);    		
	 	ClientDesignerMessageInfoSaving clDesMessageSavingModel = new ClientDesignerMessageInfoSaving();
	 	clDesMessageSavingModel.setClientInfoSavingId(clientInfoId);
	 	clDesMessageSavingModel.setDesignerInfoSavingId(designInfoId);
	 	clDesMessageSavingModel.setMessageInfo(clMsgData);
	 	clDesMessageSavingModel.setStatus("DESCLNEW");
	 	clDesMessageSavingModel.setCreatedDate(currentDate);
	 	clDesMessageSavingModel.setOneTimeRefDate(oneTimeRefDate);
	 	clientDesignerMessageInfoSavingDAO.save(clDesMessageSavingModel);
	 	if (clientAndDesnMsgInfoList.isEmpty()) {
	 		mav = designerOneTimeSentMailToClient(req, sn);
		}
        mav = new ModelAndView("redirect:" + reDirDesignerAndClientMes);         	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerOneTimeSentMailToClient(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
        long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
	 	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
	 	ClientInfoSaving clientInfoSavingModel = clientInfoSavingDAO.viewClientInfoDisplayForDesigner(clientInfoId, designInfoId);
	 	long userId = clientInfoSavingModel.getUserId();
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);        		
        String toAdd = userInformation.getUserName();
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "You have a new message from your designer.";    	  
        String type = "text/html";    	 
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";    	    
        String body = "<body>" 
        			+ "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
        			+ "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
        			+ "<p style='padding-top: 5px;'>You have a new message from your designer. Log in to your account to read your messages.</p>"
        			+ "<p style='padding-top: 5px;'><a href='https://nookandcove.com/login'>www.nookandcove.com/login</a></p>"
        			+ "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
        			+ "</div>"
        			+ "</body> ";    	  
        try {
        	userEmail.sendEmail(toAdd, subject, body, type, fromAdd);
        } catch (Exception ex) {
        	LOGGER.error("Designer Sent mail to client failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerAndClientMessageInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long clientInfoId = (Long)sn.getAttribute(clientInfoSavingIdInSn);
      	long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	String customerName = null;
      	if (clientInfoId > 0) {
      		ClientInfoSaving clientInfoSaving = clientInfoSavingDAO.userIdTakeFromTableUsingClId(clientInfoId);
      		long userId = clientInfoSaving.getUserId();
      		customerName = customerNameFromDB(userId);      		
      	}
      	String clientAndDesnMesList = "";
      	List<ClientDesignerMessageInfoSaving> clAndDesnMesInfoList = clientDesignerMessageInfoSavingDAO.clientAndDesignerMessageInfoRowVerificationInDB(clientInfoId, designInfoId);
      	if (!clAndDesnMesInfoList.isEmpty()) {         		
      		for (ClientDesignerMessageInfoSaving clAndDesnMesInfoModel : clAndDesnMesInfoList) {      		
      			String clAndDesMesVal = clAndDesnMesInfoModel.getMessageInfo();
        		clientAndDesnMesList = clientAndDesnMesList + "_,_" + clAndDesMesVal;
      		}
      		clientAndDesnMesList = clientAndDesnMesList.replaceFirst("_,_", "");        		        		
      		clientDesignerMessageInfoSavingDAO.clientMessagesStatusUpdateInDesignerSide(clientInfoId, designInfoId);
      	}         	
      	mav = new ModelAndView(viewClientMessageInfo);
      	mav.addObject("clientAndDesMessList", clientAndDesnMesList);
      	mav.addObject("clientName", customerName);
      	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
      	mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
      	return mav;
    }      
    
    @Override
    @Transactional
    public ModelAndView viewMsgInfoValuesMaintainInSn(HttpServletRequest req, HttpSession sn, String clentInfoId) {
    	long myRoomInfoId = Long.parseLong(clentInfoId);
    	ClientInfoSaving myRoomInfoSaving = clientInfoSavingDAO.viewClientInfoDataDisplay(myRoomInfoId);     	
        Timestamp createDate = myRoomInfoSaving.getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(createDate.getTime());
        String formatedDate = sdf.format(date);        
        String typeOfSpace = myRoomInfoSaving.getTypeOfSpace();
        typeOfSpace = typeOfSpace.replace("Room", " Room");        
        String designPackage = myRoomInfoSaving.getDesignPackage();
        designPackage = designPackage.replace(",", ", ");        
    	ModelAndView mav = new ModelAndView();    	  	
    	sn.setAttribute(clCreatedDateInSN, formatedDate);
    	sn.setAttribute(clRoomValInSN, typeOfSpace);
    	sn.setAttribute(clDesnPackValInSN, designPackage);
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
	public ModelAndView designerEditableCalendarForClients(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List<DesignerEditableCalendarInfoSaving> desnEditCalenderList = designerEditableCalendarInfoSavingDAO.checkEditableCalendarRowInDB(designerInfoSavingId);    	
    	if (!desnEditCalenderList.isEmpty()) {
    		mav = designerClientNotesDataDisplay(req, sn);
    	} else {
    		mav = designerEditableCalendarCreateForClients(req, sn);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView designerEditableCalendarCreateForClients(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long designInfoId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		List<ClientInfoSaving> selectedClientRowIdList = clientInfoSavingDAO.displayOnlyDesignersClientsData(designInfoId);    	
    	if (!selectedClientRowIdList.isEmpty()) {
    		Set<String> remDuplicateClientSet = new LinkedHashSet<String>();
    		List remDuplicateClients = new ArrayList();
            for (ClientInfoSaving myRoomInfoLoop : selectedClientRowIdList) {
            	long clientUserId = myRoomInfoLoop.getUserId();           	
            	remDuplicateClients.add(clientUserId);
            	remDuplicateClientSet = new LinkedHashSet<String>(remDuplicateClients);            	
            }
            List remDuplicateClientList = new ArrayList(remDuplicateClientSet);
            List clientNameList = new ArrayList();
            List clientIdList = new ArrayList();
            for (int i=0; i<remDuplicateClientList.size(); i++) {
            	long clUserId = (Long) remDuplicateClientList.get(i);
            	String customerName = customerNameFromDB(clUserId);
            	String combValue = customerName + "__" + clUserId;
            	clientNameList.add(customerName);
            	clientIdList.add(combValue);
            }
            mav = new ModelAndView(desnEditableCalendarForClients);
    		mav.addObject("clientNamesList", clientNameList);
    		mav.addObject("clientIdsList", clientIdList);
    	} else {
    		mav = designerClientsRedirection(req, sn);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminMessageCount, sn.getAttribute(adminMessageCountInSN));
		return mav;
	}

    @Override
    @Transactional
    public ModelAndView designerClientNotesDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	String clientName1 = req.getParameter(clientName);
      	String clientInfoText1 = req.getParameter(clientInfoText);
      	clientInfoText1 = clientInfoText1.replaceAll("[\n\r]", " ");
      	String clientMonth1 = req.getParameter(clientMonth);
      	String clientDay1 = req.getParameter(clientDay);
      	String clientYear1 = req.getParameter(clientYear);      	
      	String[] clientSplitName = clientName1.split("__");
      	long clientInfoSavingId = Long.parseLong(clientSplitName[1]);
      	long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	String date = clientMonth1 + "/" + clientDay1 + "/" + clientYear1;
      	int monthNumber = Integer.parseInt(clientMonth1);
      	String monthName = Month.of(monthNumber).name();
      	DesignerEditableCalendarInfoSaving desEditCalendarInfoSaving = new DesignerEditableCalendarInfoSaving();
      	desEditCalendarInfoSaving.setClientInfoSavingId(clientInfoSavingId);
      	desEditCalendarInfoSaving.setDesignerInfoSavingId(designerInfoSavingId);
      	desEditCalendarInfoSaving.setClientName(clientSplitName[0]);
      	desEditCalendarInfoSaving.setClientMonth(monthName);
      	desEditCalendarInfoSaving.setClientDay(clientDay1);
      	desEditCalendarInfoSaving.setClientYear(clientYear1);
      	desEditCalendarInfoSaving.setClientInfoText(clientInfoText1);
      	desEditCalendarInfoSaving.setDateInString(date);
      	desEditCalendarInfoSaving.setCreatedDate(currentDate);
      	designerEditableCalendarInfoSavingDAO.save(desEditCalendarInfoSaving);
      	mav = designerClientNotesDataDisplay(req, sn);      	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView designerClientNotesDataTakeFromDatabase(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
      	String clientMonth1 = req.getParameter(clientMonth);
      	String clientYear1 = req.getParameter(clientYear);
      	int monthNumber = Integer.parseInt(clientMonth1);
      	int yearNumber = Integer.parseInt(clientYear1);
      	String monthName = Month.of(monthNumber).name();
      	long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
      	YearMonth yearMonthObject = YearMonth.of(yearNumber, monthNumber);
      	int daysInMonth = yearMonthObject.lengthOfMonth();
      	List clientsDataList = new ArrayList();
      	List clientsDaysList = new ArrayList();
      	for(int i=1; i<(daysInMonth+1); i++) {
      		String clDay = Integer.toString(i);
      		List<DesignerEditableCalendarInfoSaving> desnEditCalenderList = designerEditableCalendarInfoSavingDAO.editableCalendarMonthDataTakeFromDB(designerInfoSavingId, monthName, clDay, clientYear1);
      		int count = desnEditCalenderList.size();
      		String date = monthName + "__" + clDay + "__" + clientYear1;
      		clientsDataList.add(count);
      		clientsDaysList.add(date);
      	}
      	mav = designerClientNotesDataDisplay(req, sn);      	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }


    @Override
    @Transactional
    public ModelAndView designerClientNotesDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
      	long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);      	
      	List<DesignerEditableCalendarInfoSaving> desnEditCalenderList = designerEditableCalendarInfoSavingDAO.checkEditableCalendarRowInDB(designerInfoSavingId);
      	if (!desnEditCalenderList.isEmpty()) {
      		mav = new ModelAndView(desnEditableCalendarDataDisplay);
    	} else {
    		mav = designerEditableCalendarCreateForClients(req, sn);
    	}      	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
  
	@Override
	@Transactional
	public String customerNameFromDB(long userId) {
		String customerName = null;
		if(userId > 0) {
			UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
			String fName = userInformation.getFirstName();			
			String fCapName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
			String lCapName = String.valueOf(userInformation.getLastName().charAt(0)).toUpperCase();		   
	        customerName = fCapName +" "+lCapName;
		}
		return customerName;
	}
	
	@Override
	@Transactional
	public String designerPhoneNumberFromDB(long userId) {
		String phoneNumber = null;
		if(userId > 0) {
			UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);
			phoneNumber = userInformation.getPhoneNumber();
		}
		return phoneNumber;
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
