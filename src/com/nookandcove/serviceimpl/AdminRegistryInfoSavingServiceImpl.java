package com.nookandcove.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.IOException;
import java.sql.Timestamp;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.AdminRegistryConceptBoardsFurnitureSpecsSavingDAO;
import com.nookandcove.dao.AdminRegistryConceptBoardsSavingDAO;
import com.nookandcove.dao.AdminRegistryFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.dao.DesignerInfoSavingDAO;
import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;
import com.nookandcove.model.AdminRegistryConceptBoardsSaving;
import com.nookandcove.model.AdminRegistryFinishingTouchesProductsInfoSaving;
import com.nookandcove.model.DesignerInfoSaving;
import com.nookandcove.service.AdminRegistryInfoSavingService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class AdminRegistryInfoSavingServiceImpl implements AdminRegistryInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRegistryInfoSavingServiceImpl.class);
	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
	private String adminRegistryAddNewBoardsRed = "adminRegistryAddNewBoardsRed";
	private String adminRegistryAddNewRoomRedirect = "adminRegistryAddNewRoomRedirect";
	private String adminRegistryModifyRoomRedirect = "adminRegistryModifyRoomRedirect";
	private String conceptBoardsImage = "conceptBoardsImage";
	private String adminRegistryRoom = "adminRegistryRoom";
	private String adminRegistryRoomInSn = "adminRegistryRoomInSn";
	private String adminRegistryStyle = "adminRegistryStyle";
	private String adminRegistryDesigner = "adminRegistryDesigner";
	private String adminRegistryPrice = "adminRegistryPrice";
	private String conceptBoardsSavingIdInSn = "conceptBoardsSavingIdInSn";
	private String adminRegConceptBoardsManagementDisplay = "adminRegConceptBoardsManagementDisplay";
	private String adminConFurnitureSpectsDisplay = "adminConFurnitureSpectsDisplay";
	private String adminConFurnitureSpectsUpload = "adminConFurnitureSpectsUpload";
	private String adminConFurnitureSpectsEdit = "adminConFurnitureSpectsEdit";
	private String adminConFSProductsIdInSn = "adminConFSProductsIdInSn";
	private String adminConFurSpectsDataDisplayRed = "adminConFurSpectsDataDisplayRed";	
	private String productCategory = "productCategory";
	private String productName = "productName";
	private String productSize1 = "productSize1";
	private String productSize2 = "productSize2";
	private String productSize3 = "productSize3";
	private String productSize4 = "productSize4";
	private String productSize5 = "productSize5";
//	private String productDescription2 = "productDescription2";
//	private String productDescription3 = "productDescription3";
//	private String productDescription4 = "productDescription4";
//	private String productDescription5 = "productDescription5";
	private String productDescription1 = "productDescription1";
	private String productPrice1 = "productPrice1";
	private String productPrice2 = "productPrice2";
	private String productPrice3 = "productPrice3";
	private String productPrice4 = "productPrice4";
	private String productPrice5 = "productPrice5";
	private String storeName = "storeName";
	private String brandName = "brandName";
	private String storeUrl = "storeUrl";
	private String skuName = "skuName";
	private String mostPopularCB = "mostPopularCB";
	private String productUploadedImage1 = "productUploadedImage1";
	private String productUploadedImage2 = "productUploadedImage2";
	private String productUploadedImage3 = "productUploadedImage3";
	private String productUploadedImage4 = "productUploadedImage4";	
	private String furn_Spec_Saving_Id_List = "furn_Spec_Saving_Id_List";
	private String furn_Spec_Product_Name_List = "furn_Spec_Product_Name_List";
	private String prodTotalCount = "prodTotalCount";
	private String furn_Spec_Approval_Status_List = "furn_Spec_Approval_Status_List";
	private String admnRegConBdRoomIdsListInSn = "admnRegConBdRoomIdsListInSn";
	private String admnRegConBdRoomImagesListInSn = "admnRegConBdRoomImagesListInSn";
	private String admnRegTotalResultCount = "admnRegTotalResultCount";
	private String adminRegistryConceptBoardsRed = "adminRegistryConceptBoardsRed";
	private String adminRegistryFinishingTouchesHome = "adminRegistryFinishingTouchesHome";
	private String adminRegistryFinishingTouchesDisplay = "adminRegistryFinishingTouchesDisplay";
	private String adminRegistryFinishingTouchesUpload = "adminRegistryFinishingTouchesUpload";
	private String adminRegistryFinishingTouchesEdit = "adminRegistryFinishingTouchesEdit";
	private String redirectAdminFinishingTouchesDisplay = "redirectAdminFinishingTouchesDisplay";
	private String finishingTouchesIdList = "finishingTouchesIdList";
	private String finishingTouchesProductNameList = "finishingTouchesProductNameList";
	private String adminRegFinishingTouchesSavingIdInSn = "adminRegFinishingTouchesSavingIdInSn";
	private String finishingTouchesApprovedStatusList = "finishingTouchesApprovedStatusList";
	private String productUploadImage1 = "productUploadImage1";
	private String productUploadImage2 = "productUploadImage2";
	private String productUploadImage3 = "productUploadImage3";
	private String productUploadImage4 = "productUploadImage4";
	private String finishingTouchesRBName = "finishingTouchesRBName";
	private String finishingTouchesCBName = "finishingTouchesCBName";
	private String adminFTCBValuesList = "adminFTCBValuesList";
	private String finishingTouchesImageIdInSn = "finishingTouchesImageIdInSn";
	private String adminReff = "Admin";
	private String approvedReff = "Approved";
	private String uploadImgPath = "/var/www/html/data/nookandcoveimages/";
	
	private String adminDesignerRegistryConceptBoardsRed = "adminDesignerRegistryConceptBoardsRed";
	private String adminDesignerRegConBdRoomIdsListInSn = "adminDesignerRegConBdRoomIdsListInSn";
	private String adminDesignerRegConBdRoomImagesListInSn = "adminDesignerRegConBdRoomImagesListInSn";
	private String adminDesignerRegTotalResultCount = "adminDesignerRegTotalResultCount";
	private String adminDesignerRegistryRoomInSn = "adminDesignerRegistryRoomInSn";
	private String designerRegistryRoom = "designerRegistryRoom";
	private String designerRegistryStyle = "designerRegistryStyle";
	private String designerRegistryPrice = "designerRegistryPrice";
	private String designerFullName = "designerFullName";
	private String designerFTCBValuesList = "designerFTCBValuesList";
	private String adminDesignerRegistryFinishingTouchesHome = "adminDesignerRegistryFinishingTouchesHome";
	private String adminDesignerRegistryModifyRoomRedirect = "adminDesignerRegistryModifyRoomRedirect";
	private String adminDesignerRegConceptBoardsManagementDisplay = "adminDesignerRegConceptBoardsManagementDisplay";
	private String redirectAdminDesignerFinishingTouchesDisplay = "redirectAdminDesignerFinishingTouchesDisplay";
	private String adminDesignerRegistryFinishingTouchesDisplay = "adminDesignerRegistryFinishingTouchesDisplay";
	private String adminDesignerRegistryFinishingTouchesEdit = "adminDesignerRegistryFinishingTouchesEdit";
	private String adminDesignerConFurSpectsDataDisplayRed = "adminDesignerConFurSpectsDataDisplayRed";
	private String adminDesignerConFurnitureSpectsDisplay = "adminDesignerConFurnitureSpectsDisplay";
	private String adminDesignerConFurnitureSpectsEdit = "adminDesignerConFurnitureSpectsEdit";
	private String adminDesignerConFurnitureSpectsUpload = "adminDesignerConFurnitureSpectsUpload";
	private String adminApprovalStatus = "adminApprovalStatus";
	private String adminProductsAddedData = "adminProductsAddedData";
	private String adminDoneStatus = "Done";
	private String availableStatus = "Available";
	private String designerNamesList = "designerNamesList";
	
	@Autowired
    private DesignerInfoSavingDAO designerInfoSavingDAO;

	@Autowired
    private AdminRegistryConceptBoardsSavingDAO adminRegistryConceptBoardsSavingDAO;

	@Autowired
    private AdminRegistryConceptBoardsFurnitureSpecsSavingDAO adminRegistryConceptBoardsFurnitureSpecsSavingDAO;

	@Autowired
    private AdminRegistryFinishingTouchesProductsInfoSavingDAO adminRegistryFinishingTouchesProductsInfoSavingDAO;
		
    @Override
    @Transactional
    public ModelAndView adminRegistryConceptBoardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsLivingRoomListTakeFromDB();  	
    	if (!admnRegConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			String conBoardsImage = null;
    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegConBdRoomImagesList.add(conBoardsImage);
     	   }
    	}
    	mav = new ModelAndView(adminRegistryConceptBoardsRed);
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegConBdRoomsList.size());
        mav.addObject(adminRegistryRoom, "Living Room");
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
    	sn.setAttribute(adminRegistryRoomInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedRoomAndStyleRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();
    	String rommName = req.getParameter(adminRegistryRoom);    	
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsAllRoomListTakeFromDB(rommName);  	
    	if (!admnRegConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			String conBoardsImage = null;
    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegConBdRoomImagesList.add(conBoardsImage);
     	   }
    	}
    	mav = new ModelAndView(adminRegistryConceptBoardsRed);
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegConBdRoomsList.size());
        mav.addObject(adminRegistryRoom, rommName);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedStyleAndRoomRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String rommName = req.getParameter(adminRegistryRoom);
    	String priceValue = req.getParameter(adminRegistryPrice);
    	String admnRegCheckValue = "";
    	if(null != req.getParameterValues(adminRegistryStyle)) {
        	String[] checkBoxVal = req.getParameterValues(adminRegistryStyle);
        	for (int i = 0; i < checkBoxVal.length; i++) {
        		admnRegCheckValue = admnRegCheckValue + "," + checkBoxVal[i];
        	}
        	admnRegCheckValue = admnRegCheckValue.replaceFirst(",", "");        	
        }
        if((!("").equals(admnRegCheckValue)) && (!("").equals(priceValue))) {
        	String priceValue1 = priceValue.replace(",", "', '");
        	mav = selectedRoomStyleAndPriceCombDataTakeFromDB(req, sn, rommName, admnRegCheckValue, priceValue1);
    	} else if((!("").equals(admnRegCheckValue)) && (("").equals(priceValue))) {
    		mav = selectedRoomAndStyleDataTakeFromDB(req, sn, rommName, admnRegCheckValue);
    	} else if((("").equals(admnRegCheckValue)) && (!("").equals(priceValue))) {
    		String priceValue1 = priceValue.replace(",", "', '");
    		mav = selectedRoomAndPriceDataTakeFromDB(req, sn, rommName, priceValue1);
    	} else {
    		mav = selectedRoomDataOnlyTakeFromDB(req, sn, rommName);
    	}    	
    	mav = new ModelAndView(adminRegistryConceptBoardsRed);
    	mav.addObject(adminRegistryRoom, rommName);
        mav.addObject(adminRegistryStyle, admnRegCheckValue);
        mav.addObject(adminRegistryPrice, priceValue);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String rommName = req.getParameter(adminRegistryRoom);
    	String styleValue = req.getParameter(adminRegistryStyle);
    	String admnRegCheckValue = "";
    	String priceValue = "";
        if(null != req.getParameterValues(adminRegistryPrice)) {
        	String[] checkBoxVal = req.getParameterValues(adminRegistryPrice);
        	for (int i = 0; i < checkBoxVal.length; i++) {
        		admnRegCheckValue = admnRegCheckValue + "," + checkBoxVal[i];
        	}
        	admnRegCheckValue = admnRegCheckValue.replaceFirst(",", "");
        	priceValue = admnRegCheckValue.replace(",", "', '");
        }
        if((!("").equals(admnRegCheckValue)) && (!("").equals(styleValue))) {
        	mav = selectedRoomStyleAndPriceCombDataTakeFromDB(req, sn, rommName, styleValue, priceValue);
    	} else if((!("").equals(admnRegCheckValue)) && (("").equals(styleValue))) {
    		mav = selectedRoomAndPriceDataTakeFromDB(req, sn, rommName, priceValue);
    	} else if((("").equals(admnRegCheckValue)) && (!("").equals(styleValue))) {
    		mav = selectedRoomAndStyleDataTakeFromDB(req, sn, rommName, styleValue);
    	} else {
    		mav = selectedRoomDataOnlyTakeFromDB(req, sn, rommName);
    	}   	
    	mav = new ModelAndView(adminRegistryConceptBoardsRed);
    	mav.addObject(adminRegistryRoom, rommName);
        mav.addObject(adminRegistryStyle, styleValue);
        mav.addObject(adminRegistryPrice, admnRegCheckValue);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedRoomDataOnlyTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsAllRoomListTakeFromDB(rommName);  	
    	if (!admnRegConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			String conBoardsImage = null;
    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegConBdRoomImagesList.add(conBoardsImage);
     	   }
    	}
    	mav = new ModelAndView();
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegConBdRoomsList.size());
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedRoomAndStyleDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsAllRoomAndStyleListTakeFromDB(rommName);
    	int totalConceptCount = 0;
    	if (!admnRegConBdRoomStyleList.isEmpty()) {    		
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomStyleList) {    			
    			String stylesNameDBList = admnRegConBdSavingModel.getStyle();
    			String styleRowChecking = styleNameCheckInDbUsingAdminSelectedStyleList(stylesNameDBList, styleNames);    			
    			if(("Have").equals(styleRowChecking)) {
	    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	    			String conBoardsImage = null;
	    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
	    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
	    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	        		}
	    			admnRegConBdRoomImagesList.add(conBoardsImage);
	    			totalConceptCount = totalConceptCount + 1;
    			}
     	   }
    	}
    	mav = new ModelAndView();
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, totalConceptCount);
        return mav;
    }
    
    public String styleNameCheckInDbUsingAdminSelectedStyleList(String stylesNameDbList, String stylesNameAdmList) {
    	String styleRowChecking = null;
    	String[] stylesNameDbSt = stylesNameDbList.split(",");
    	String[] stylesNameAdmSt = stylesNameAdmList.split(",");				
		for(int i=0; i<stylesNameAdmSt.length; i++) {
			for(int j=0; j<stylesNameDbSt.length; j++) {
				if(stylesNameAdmSt[i].equals(stylesNameDbSt[j])) {
					styleRowChecking = "Have";
					break;
				}
			}
		}
		return styleRowChecking;
    }

    @Override
    @Transactional
    public ModelAndView selectedRoomAndPriceDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String price) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsAllRoomsAndPriceListTakeFromDB(rommName, price);  	
    	if (!admnRegConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			String conBoardsImage = null;
    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegConBdRoomImagesList.add(conBoardsImage);
     	   }
    	}
    	mav = new ModelAndView();
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegConBdRoomsList.size());
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedRoomStyleAndPriceCombDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames, String priceValue) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(rommName, priceValue);
    	int totalConceptCount = 0;
    	if (!admnRegConBdRoomStyleList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomStyleList) {
    			String stylesNameDBList = admnRegConBdSavingModel.getStyle();
    			String styleRowChecking = styleNameCheckInDbUsingAdminSelectedStyleList(stylesNameDBList, styleNames);    			
    			if(("Have").equals(styleRowChecking)) {
	    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	    			String conBoardsImage = null;
	    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
	    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
	    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	        		}
	    			admnRegConBdRoomImagesList.add(conBoardsImage);
	    			totalConceptCount = totalConceptCount + 1;
    			}
     	   }
    	}
    	mav = new ModelAndView();
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, totalConceptCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView unCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String rommName = req.getParameter(adminRegistryRoom);
    	mav = selectedRoomDataOnlyTakeFromDB(req, sn, rommName);
    	mav = new ModelAndView(adminRegistryConceptBoardsRed);
    	mav.addObject(adminRegistryRoom, rommName);
        mav.addObject(adminRegistryStyle, null);
        mav.addObject(adminRegistryPrice, null);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView selectedRoomAndStyleImageUploadInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;   	
    	
 	   	String conceptImagesName1 = req.getParameter("conceptImagesName");
 	   	if (null != conceptImagesName1) {
 	   		long conceptBoardsSavingId = Long.parseLong(conceptImagesName1);
 	   		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
 	   	}
 	   	String rommName = req.getParameter(adminRegistryRoom);
	   	sn.setAttribute(adminRegistryRoomInSn, rommName);	   	
	   	mav = adminRegistryModifyRoomRedirection(req, sn);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedRoomAndStyleImageUpdateRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegConBdRoomIdsList = new ArrayList();
    	List admnRegConBdRoomImagesList = new ArrayList();
    	String rommName = (String) sn.getAttribute(adminRegistryRoomInSn);    	
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsAllRoomListTakeFromDB(rommName);  	
    	if (!admnRegConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			String conBoardsImage = null;
    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegConBdRoomImagesList.add(conBoardsImage);
     	   }
    	}
    	mav = new ModelAndView(adminRegistryConceptBoardsRed);
    	sn.setAttribute(admnRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
        sn.setAttribute(admnRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegConBdRoomsList.size());
        mav.addObject(adminRegistryRoom, rommName);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(adminRegistryRoomInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegConceptBoardsManagement(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsManagementList();
    	if(!admnRegConBdManList.isEmpty()){
    		mav = adminRegConceptBoardsManagementDataDisplay(req, sn);
    	} else {
    		mav = adminRegAddNewBoardsRedirection(req, sn);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegConceptBoardsManagementDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsManagementList();
    	if(!admnRegConBdManList.isEmpty()){       	
            List<AdminRegistryConceptBoardsSaving> admnRegConBdSavingList = new ArrayList<AdminRegistryConceptBoardsSaving>();
            for (AdminRegistryConceptBoardsSaving admnRegConBdInfoLoop : admnRegConBdManList) {
            	AdminRegistryConceptBoardsSaving admnRegConBdSavingModel = new AdminRegistryConceptBoardsSaving();            	           	
            	admnRegConBdSavingModel.setAdminRegistryConceptBoardsSavingId(admnRegConBdInfoLoop.getAdminRegistryConceptBoardsSavingId());
            	admnRegConBdSavingModel.setRoom(admnRegConBdInfoLoop.getRoom());
            	admnRegConBdSavingModel.setStyle(admnRegConBdInfoLoop.getStyle());
            	admnRegConBdSavingModel.setDesignerName(admnRegConBdInfoLoop.getDesignerName());
            	admnRegConBdSavingModel.setPrice(admnRegConBdInfoLoop.getPrice());
            	admnRegConBdSavingModel.setFurnitureSpecsCount(admnRegConBdInfoLoop.getFurnitureSpecsCount());
            	admnRegConBdSavingModel.setCreatedDate(admnRegConBdInfoLoop.getCreatedDate());
            	admnRegConBdSavingModel.setUpdatedDate(admnRegConBdInfoLoop.getUpdatedDate());
            	admnRegConBdSavingModel.setMostPopularCB(admnRegConBdInfoLoop.getMostPopularCB());
            	admnRegConBdSavingList.add(admnRegConBdSavingModel);
            }
            mav = new ModelAndView(adminRegConceptBoardsManagementDisplay);
            mav.addObject("adminRegConceptBoardsManagementSavingList", admnRegConBdSavingList);
            mav.addObject("adminRegConceptBoardsManagementListCount", admnRegConBdManList.size());                       
        } else{
        	mav = adminRegAddNewBoardsRedirection(req, sn);
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        return mav;
    } 

    @Override
    @Transactional
    public ModelAndView adminRegAddNewBoardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<DesignerInfoSaving> desiNamesList = designerInfoSavingDAO.allDesignersInfoDisplayInRegAdmin();
    	String room = null;
    	String style = null;
    	String price = null;
    	String desnName = null;
    	String conBoardsImage = null;
    	String mostPopular = null;
    	int totalFurSpecsProductsCount = 0;
    	if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
    		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
    		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
    		room = admnRegConBdModel.getRoom();
    		style = admnRegConBdModel.getStyle();
    		price = admnRegConBdModel.getPrice();
    		mostPopular = admnRegConBdModel.getMostPopularCB();
    		long desnInfoId = admnRegConBdModel.getDesignerInfoSavingId();
    		desnName = String.valueOf(desnInfoId);
    		if(null != admnRegConBdModel.getConceptBoardsImage()) {
	    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
    		}
    		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
    		totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
    	} else {
    		List <AdminRegistryConceptBoardsSaving> admnRegConBdFSList = adminRegistryConceptBoardsSavingDAO.adminCBFurSpicStatusVerification();
    		if(!admnRegConBdFSList.isEmpty()){
    			AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.adminCBFurSpicStatusValueFromDB();
        		room = admnRegConBdModel.getRoom();
        		style = admnRegConBdModel.getStyle();
        		price = admnRegConBdModel.getPrice();
        		mostPopular = admnRegConBdModel.getMostPopularCB();
        		long desnInfoId = admnRegConBdModel.getDesignerInfoSavingId();
        		desnName = String.valueOf(desnInfoId);
        		if(null != admnRegConBdModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
        		long conceptBoardsSavingId = admnRegConBdModel.getAdminRegistryConceptBoardsSavingId();
    	    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
    	    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
    	    	totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
    		}
    	}    	    	
    	mav = new ModelAndView(adminRegistryAddNewBoardsRed);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(designerNamesList, desiNamesList);
    	mav.addObject(adminRegistryRoom, room);
    	mav.addObject(adminRegistryStyle, style);
    	mav.addObject(adminRegistryDesigner, desnName);
    	mav.addObject(adminRegistryPrice, price);
    	mav.addObject(mostPopularCB, mostPopular);
    	mav.addObject(conceptBoardsImage, conBoardsImage);
    	mav.addObject(prodTotalCount, totalFurSpecsProductsCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String adminRegistryStyleValue = "";        
        if(null != req.getParameterValues(adminRegistryStyle)) {
        	String[] checkBoxVal = req.getParameterValues(adminRegistryStyle);
        	for (int q = 0; q < checkBoxVal.length; q++) {
        		adminRegistryStyleValue = adminRegistryStyleValue + "," + checkBoxVal[q];
        	}
        	adminRegistryStyleValue = adminRegistryStyleValue.replaceFirst(",", "");
        }
        long adminUserId = 1;
    	if (null == sn.getAttribute(conceptBoardsSavingIdInSn)) {    		
	    	AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = new AdminRegistryConceptBoardsSaving();
	    	adminRegConBdSavingModel.setAdminDesignerCommonReferenceId(adminUserId);
    	    adminRegConBdSavingModel.setAdminDesignerCommonReferenceName(adminReff);
    	    adminRegConBdSavingModel.setAdminApprovalStatus(approvedReff);
	    	adminRegConBdSavingModel.setRoom(req.getParameter(adminRegistryRoom));
	    	adminRegConBdSavingModel.setStyle(adminRegistryStyleValue);
	    	long designerInfoSavingId = Long.parseLong(req.getParameter(adminRegistryDesigner));
//	    	DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
//	    	adminRegConBdSavingModel.setDesignerName(designerInfoSaving.getDesignerFullName());
	    	adminRegConBdSavingModel.setDesignerName(adminReff);
	    	adminRegConBdSavingModel.setPrice(req.getParameter(adminRegistryPrice));
	    	adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
	    	adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
	    	adminRegistryConceptBoardsSavingDAO.save(adminRegConBdSavingModel);
	    	long conceptBoardsSavingId = adminRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId();
	    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
    	} else {
    		AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
    	    adminRegConBdSavingModel.setRoom(req.getParameter(adminRegistryRoom));
    	    adminRegConBdSavingModel.setStyle(adminRegistryStyleValue);
    	    long designerInfoSavingId = Long.parseLong(req.getParameter(adminRegistryDesigner));
//    	    DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
//    	    adminRegConBdSavingModel.setDesignerName(designerInfoSaving.getDesignerFullName());
    	    adminRegConBdSavingModel.setPrice(req.getParameter(adminRegistryPrice));
    	    adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
    	    adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
    	    adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
    	}
    	mav = new ModelAndView("redirect:" + "adminRegAddNewBoards");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminConceptBoardsDataModificationInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String adminRegistryStyleValue = "";        
        if(null != req.getParameterValues(adminRegistryStyle)) {
        	String[] checkBoxVal = req.getParameterValues(adminRegistryStyle);
        	for (int q = 0; q < checkBoxVal.length; q++) {
        		adminRegistryStyleValue = adminRegistryStyleValue + "," + checkBoxVal[q];
        	}
        	adminRegistryStyleValue = adminRegistryStyleValue.replaceFirst(",", "");
        }
    	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
    	AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);    	
	    adminRegConBdSavingModel.setRoom(req.getParameter(adminRegistryRoom));
	    adminRegConBdSavingModel.setStyle(adminRegistryStyleValue);
	    long designerInfoSavingId = Long.parseLong(req.getParameter(adminRegistryDesigner));
//	    DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
//	    adminRegConBdSavingModel.setDesignerName(designerInfoSaving.getDesignerFullName());
	    adminRegConBdSavingModel.setDesignerName(adminReff);
	    adminRegConBdSavingModel.setPrice(req.getParameter(adminRegistryPrice));
	    adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
	    adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
	    adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);	    
    	mav = adminRegistryModifyRoomRedirection(req, sn);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegConceptBoardImageUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;        
    	String fileName = imageUpload.getOriginalFilename();    	
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
    	conFile.mkdir();        
    	imageUpload.transferTo(conFile);
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
 	   	if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
 	   		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
 	   		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
 	   	   	admnRegConBdModel.setConceptBoardsImage(bFile);
 		   	admnRegConBdModel.setUpdatedDate(currentDate);
 		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
 	   	} 	   
 	   	mav = new ModelAndView("redirect:" + "adminRegAddNewBoards");
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRedConceptSpcBoardModificationUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;        
    	String fileName = imageUpload.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
    	conFile.mkdir();        
    	imageUpload.transferTo(conFile);
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
 	   	if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
 	   		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
 	   		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
 	   	   	admnRegConBdModel.setConceptBoardsImage(bFile);
 		   	admnRegConBdModel.setUpdatedDate(currentDate);
 		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
 	   	} 	   
 	   mav = adminRegistryModifyRoomRedirection(req, sn);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegConceptBoardsManagementRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	String admConBoardManagement = req.getParameter("admConBoardManagementId");
    	String typeOfRoomSel = req.getParameter("typeOfRoomSelection");
    	if(("Modify Room").equals(typeOfRoomSel)) {
    		long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
    		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
    		mav = adminRegistryModifyRoomRedirection(req, sn);
    	} else if(("Delete Room").equals(typeOfRoomSel)) {
    		long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
    		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
    		mav = adminRegistryDeleteRoomRedirection(req, sn, conceptBoardsSavingId);
    	} else {
    		sn.setAttribute(conceptBoardsSavingIdInSn, null);
    		mav = adminRegistryAddNewRoomRedirect(req, sn);
    	}    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminAddAnotherConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String adminRegistryStyleValue = "";        
        if(null != req.getParameterValues(adminRegistryStyle)) {
        	String[] checkBoxVal = req.getParameterValues(adminRegistryStyle);
        	for (int q = 0; q < checkBoxVal.length; q++) {
        		adminRegistryStyleValue = adminRegistryStyleValue + "," + checkBoxVal[q];
        	}
        	adminRegistryStyleValue = adminRegistryStyleValue.replaceFirst(",", "");
        }
        long adminUserId = 1;
    	if (null == sn.getAttribute(conceptBoardsSavingIdInSn)) {    		
	    	AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = new AdminRegistryConceptBoardsSaving();
	    	adminRegConBdSavingModel.setAdminDesignerCommonReferenceId(adminUserId);
    	    adminRegConBdSavingModel.setAdminDesignerCommonReferenceName(adminReff);
    	    adminRegConBdSavingModel.setAdminApprovalStatus(approvedReff);
	    	adminRegConBdSavingModel.setRoom(req.getParameter(adminRegistryRoom));
	    	adminRegConBdSavingModel.setStyle(adminRegistryStyleValue);
	    	long designerInfoSavingId = Long.parseLong(req.getParameter(adminRegistryDesigner));
//	    	DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
//	    	adminRegConBdSavingModel.setDesignerName(designerInfoSaving.getDesignerFullName());
	    	adminRegConBdSavingModel.setDesignerName(adminReff);
	    	adminRegConBdSavingModel.setPrice(req.getParameter(adminRegistryPrice));
	    	adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
	    	adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
	    	adminRegistryConceptBoardsSavingDAO.save(adminRegConBdSavingModel);
	    	long conceptBoardsSavingId = adminRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId();
	    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
    	} else {
    		AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));    		
    	    adminRegConBdSavingModel.setRoom(req.getParameter(adminRegistryRoom));
    	    adminRegConBdSavingModel.setStyle(adminRegistryStyleValue);
    	    long designerInfoSavingId = Long.parseLong(req.getParameter(adminRegistryDesigner));
//    	    DesignerInfoSaving designerInfoSaving = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
//    	    adminRegConBdSavingModel.setDesignerName(designerInfoSaving.getDesignerFullName());
    	    adminRegConBdSavingModel.setDesignerName(adminReff);
    	    adminRegConBdSavingModel.setPrice(req.getParameter(adminRegistryPrice));
    	    adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
    	    adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
    	    adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
    	}
    	mav = adminRegistryAddNewRoomRedirect(req, sn);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminAddAnotherConceptSpcBoardUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;        
    	String fileName = imageUpload.getOriginalFilename();
 	   	String filepath = uploadImgPath + fileName;
	   	File conFile = new File(filepath);
	   	conFile.mkdir();        
	   	imageUpload.transferTo(conFile);
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
 	   	if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
 	   		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
 	   		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
 	   	   	admnRegConBdModel.setConceptBoardsImage(bFile);
 		   	admnRegConBdModel.setUpdatedDate(currentDate);
 		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
 	   	} 	   
 	   mav = adminRegistryAddNewRoomRedirect(req, sn);
 	   	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryModifyRoomRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
    	List<DesignerInfoSaving> desiNamesList = designerInfoSavingDAO.allDesignersInfoDisplayInRegAdmin();
    	String room = null;
    	String style = null;
    	String desnName = null;
    	String price = null;
    	String conBoardsImage = null;
    	String mostPopular = null;
    	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
    	room = admnRegConBdModel.getRoom();
    	style = admnRegConBdModel.getStyle();
    	price = admnRegConBdModel.getPrice();
    	mostPopular = admnRegConBdModel.getMostPopularCB();
    	long desnInfoId = admnRegConBdModel.getDesignerInfoSavingId();
    	desnName = String.valueOf(desnInfoId);
    	if(null != admnRegConBdModel.getConceptBoardsImage()) {
	    	byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
	 	   	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
    	}
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);		
    	mav = new ModelAndView(adminRegistryModifyRoomRedirect);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(designerNamesList, desiNamesList);
    	mav.addObject(adminRegistryRoom, room);
    	mav.addObject(adminRegistryStyle, style);
    	mav.addObject(adminRegistryDesigner, desnName);
    	mav.addObject(adminRegistryPrice, price);
    	mav.addObject(mostPopularCB, mostPopular);
    	mav.addObject(conceptBoardsImage, conBoardsImage);
    	mav.addObject(prodTotalCount, totalFurSpecsProductsList.size());
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryDeleteRoomRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId) {
    	ModelAndView mav;
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
    	for (AdminRegistryConceptBoardsFurnitureSpecsSaving admnRegConBdInfoLoop : totalFurSpecsProductsList) {
    		AdminRegistryConceptBoardsFurnitureSpecsSaving removeFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.deleteConBoardsFurnitureSpecsProductsInDB(admnRegConBdInfoLoop.getAdminRegistryConceptBoardsSavingId());
        	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.delete(removeFurSpecsProductsList);
    	}    	
    	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
    	adminRegistryConceptBoardsSavingDAO.delete(admnRegConBdModel);    	
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.adminConceptBoardsManagementList();
    	if(!admnRegConBdManList.isEmpty()){
    		mav = adminRegConceptBoardsManagementDataDisplay(req, sn);
    	} else {
    		sn.setAttribute(conceptBoardsSavingIdInSn, null);
    		mav = adminRegAddNewBoardsRedirection(req, sn);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));   	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegistryAddNewRoomRedirect(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<DesignerInfoSaving> desiNamesList = designerInfoSavingDAO.allDesignersInfoDisplayInRegAdmin();
    	String room = null;
    	String style = null;
    	String desnName = null;
    	String conBoardsImage = null;
    	String price = null;
    	String mostPopular = null;
    	int totalFurSpecsProductsCount = 0;
    	if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
    		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
    		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
    		room = admnRegConBdModel.getRoom();
    		style = admnRegConBdModel.getStyle();
    		price = admnRegConBdModel.getPrice();
    		mostPopular = admnRegConBdModel.getMostPopularCB();
    		long desnInfoId = admnRegConBdModel.getDesignerInfoSavingId();
    		desnName = String.valueOf(desnInfoId);
    		if(null != admnRegConBdModel.getConceptBoardsImage()) {
	    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
    		}
    		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
	    	totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
    	} else {
    		List <AdminRegistryConceptBoardsSaving> admnRegConBdFSList = adminRegistryConceptBoardsSavingDAO.adminCBFurSpicStatusVerification();
    		if(!admnRegConBdFSList.isEmpty()){
    			AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.adminCBFurSpicStatusValueFromDB();
        		room = admnRegConBdModel.getRoom();
        		style = admnRegConBdModel.getStyle();
        		price = admnRegConBdModel.getPrice();
        		mostPopular = admnRegConBdModel.getMostPopularCB();
        		long desnInfoId = admnRegConBdModel.getDesignerInfoSavingId();
        		desnName = String.valueOf(desnInfoId);
        		if(null != admnRegConBdModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
        		long conceptBoardsSavingId = admnRegConBdModel.getAdminRegistryConceptBoardsSavingId();
    	    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
    	    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
    	    	totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
    		}
    	}
    	mav = new ModelAndView(adminRegistryAddNewRoomRedirect);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(designerNamesList, desiNamesList);
    	mav.addObject(adminRegistryRoom, room);
    	mav.addObject(adminRegistryStyle, style);
    	mav.addObject(adminRegistryDesigner, desnName);
    	mav.addObject(adminRegistryPrice, price);
    	mav.addObject(mostPopularCB, mostPopular);
    	mav.addObject(conceptBoardsImage, conBoardsImage);
    	mav.addObject(prodTotalCount, totalFurSpecsProductsCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminConFurnitureSpectsUploadRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
    	if(!totalFurSpecsProductsList.isEmpty()){
    		mav = new ModelAndView("redirect:" + adminConFurSpectsDataDisplayRed);
    	} else {
    		mav = new ModelAndView(adminConFurnitureSpectsUpload);
    	}    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        return mav;
    }    

	@Override
	@Transactional
	public ModelAndView adminConFurnitureSpectsDataDisplayFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0; 	
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
		if (!totalFurSpecsProductsList.isEmpty()) {
	 		for (AdminRegistryConceptBoardsFurnitureSpecsSaving furnSpecsProductsSavingModel : totalFurSpecsProductsList) {
	 			furnSpecSavingIdList.add(furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId());
	 			furnSpecProductNameList.add(furnSpecsProductsSavingModel.getProductName());
	 			int count = 1;
	 			prodCount = prodCount + count;
	 		}		
	 		mav = new ModelAndView(adminConFurnitureSpectsDisplay);
	 		sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	 		sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	 		mav.addObject(prodTotalCount, prodCount);
 		} else{
     	mav = adminConFurnitureSpectsUploadRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		sn.setAttribute(adminConFSProductsIdInSn, null);
		return mav;
	}

   	@Override
   	@Transactional
   	public ModelAndView adminConFurnitureSpecsUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
   		ModelAndView mav;   		
   		String fileName1 = productUploadedImage1.getOriginalFilename();
   		String fileName2 = productUploadedImage2.getOriginalFilename();
   		String fileName3 = productUploadedImage3.getOriginalFilename();
   		String fileName4 = productUploadedImage4.getOriginalFilename();   		
   		byte[] bFile1 = null;
   		byte[] bFile2 = null;
   		byte[] bFile3 = null;
   		byte[] bFile4 = null;   		
   		if((null != fileName1) && ("" != fileName1)) {
   			String filepath1 = uploadImgPath + fileName1;	
   	   		File conFile1 = new File(filepath1);
   	   		conFile1.mkdir();    
   	   		productUploadedImage1.transferTo(conFile1);        
   	   		bFile1 = new byte[(int) conFile1.length()];
   	   		try {
   	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
   	   			fileInputStream1.read(bFile1);
   	   			fileInputStream1.close();   	   			
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName2) && ("" != fileName2)) {
   			String filepath2 = uploadImgPath + fileName2;	
   	   		File conFile2 = new File(filepath2);
   	   		conFile2.mkdir();    
   	   		productUploadedImage2.transferTo(conFile2);        
   	   		bFile2 = new byte[(int) conFile2.length()];
   	   		try {
   	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
   	   			fileInputStream2.read(bFile2);
   	   			fileInputStream2.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName3) && ("" != fileName3)) {
   			String filepath3 = uploadImgPath + fileName3;	
   	   		File conFile3 = new File(filepath3);
   	   		conFile3.mkdir();    
   	   		productUploadedImage3.transferTo(conFile3);        
   	   		bFile3 = new byte[(int) conFile3.length()];
   	   		try {
   	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
   	   			fileInputStream3.read(bFile3);
   	   			fileInputStream3.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName4) && ("" != fileName4)) {
   			String filepath4 = uploadImgPath + fileName4;	
   	   		File conFile4 = new File(filepath4);
   	   		conFile4.mkdir();    
   	   		productUploadedImage4.transferTo(conFile4);        
   	   		bFile4 = new byte[(int) conFile4.length()];
   	   		try {
   	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
   	   			fileInputStream4.read(bFile4);
   	   			fileInputStream4.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}   		
   		Timestamp currentDate = currentDate();
   		long adminUserId = 1;
   		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = new AdminRegistryConceptBoardsFurnitureSpecsSaving();
   		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
   		admRegFurnitureSpecsSaving.setAdminRegistryConceptBoardsSavingId(conceptBoardsSavingId);
   		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceId(adminUserId);
   		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceName(adminReff);
	    admRegFurnitureSpecsSaving.setAdminApprovalStatus(approvedReff);
   		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
   		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
   		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
   		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
   		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
   		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));   		
   		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
//   		admRegFurnitureSpecsSaving.setProductDescription2(req.getParameter(productDescription2));
//   		admRegFurnitureSpecsSaving.setProductDescription3(req.getParameter(productDescription3));
//   		admRegFurnitureSpecsSaving.setProductDescription4(req.getParameter(productDescription4));
//   		admRegFurnitureSpecsSaving.setProductDescription5(req.getParameter(productDescription5));
   		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
   		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
   		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
   		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
   		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
   		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
   		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
   		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
   		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
   		admRegFurnitureSpecsSaving.setFurnitureSpecsStatus(adminDoneStatus);   		
   		admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
   		admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
   		admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
   		admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
   		admRegFurnitureSpecsSaving.setAdminStockCheckStatus(availableStatus);
   		admRegFurnitureSpecsSaving.setCreatedDate(currentDate);
   		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.save(admRegFurnitureSpecsSaving);
   		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB(conceptBoardsSavingId);
   		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsCountList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount(conceptBoardsSavingId);
   		admnRegConBdModel.setFurnitureSpecsStatus(adminDoneStatus);
   		admnRegConBdModel.setFurnitureSpecsCount(totalFurSpecsCountList.size());
   		adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
   		mav = new ModelAndView("redirect:" + adminConFurSpectsDataDisplayRed);
   		mav.addObject(flName, sn.getAttribute(firstNamesInSn));    
        return mav;
   	}

    @Override
    @Transactional
    public ModelAndView adminRedConFurnitureSpectsAddNewProductsRed(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView(adminConFurnitureSpectsUpload);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        return mav;
    }

	@Override
	@Transactional
	public ModelAndView adminRedConFurnitureSpectsEditProductsRed(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter("storeURL");
		long productId = Long.parseLong(produtId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> ediFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecEditProductsInDB(productId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving ediFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecEditProductsDataTakeFromDB(productId);		
	    	String prodName = ediFurSpecsProductsModel.getProductName();	    	
	    	String headName1 = ediFurSpecsProductsModel.getProductSize1();
	    	String headName2 = ediFurSpecsProductsModel.getProductSize2();
	    	String headName3 = ediFurSpecsProductsModel.getProductSize3();
	    	String headName4 = ediFurSpecsProductsModel.getProductSize4();
	    	String headName5 = ediFurSpecsProductsModel.getProductSize5();
	    	String prodDesc1 = ediFurSpecsProductsModel.getProductDescription1();
//	    	String prodDesc2 = ediFurSpecsProductsModel.getProductDescription2();
//	    	String prodDesc3 = ediFurSpecsProductsModel.getProductDescription3();
//	    	String prodDesc4 = ediFurSpecsProductsModel.getProductDescription4();
//	    	String prodDesc5 = ediFurSpecsProductsModel.getProductDescription5();
	    	String prodPrice1 = ediFurSpecsProductsModel.getProductPrice1();
	    	String prodPrice2 = ediFurSpecsProductsModel.getProductPrice2();
	    	String prodPrice3 = ediFurSpecsProductsModel.getProductPrice3();
	    	String prodPrice4 = ediFurSpecsProductsModel.getProductPrice4();
	    	String prodPrice5 = ediFurSpecsProductsModel.getProductPrice5();
	    	String strName = ediFurSpecsProductsModel.getStoreName();
	    	String brandsName = ediFurSpecsProductsModel.getBrandName();
	    	String strUrl = ediFurSpecsProductsModel.getStoreUrl();
	    	String skuNames = ediFurSpecsProductsModel.getSkuName();
	    	String productsImage1 = null;
	    	String productsImage2 = null;
	    	String productsImage3 = null;
	    	String productsImage4 = null;
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage1()) {
		    	byte[] productImgFromDB1 = ediFurSpecsProductsModel.getProductUploadedImage1();
				productsImage1 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB1);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage2()) {
				byte[] productImgFromDB2 = ediFurSpecsProductsModel.getProductUploadedImage2();
				productsImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB2);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage3()) {
				byte[] productImgFromDB3 = ediFurSpecsProductsModel.getProductUploadedImage3();
				productsImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB3);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage4()) {
				byte[] productImgFromDB4 = ediFurSpecsProductsModel.getProductUploadedImage4();
				productsImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB4);
	    	}
	    	mav = new ModelAndView(adminConFurnitureSpectsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productSize1, headName1);
	    	mav.addObject(productSize2, headName2);
	    	mav.addObject(productSize3, headName3);
	    	mav.addObject(productSize4, headName4);
	    	mav.addObject(productSize5, headName5);
	    	mav.addObject(productDescription1, prodDesc1);
//	    	mav.addObject(productDescription2, prodDesc2);
//	    	mav.addObject(productDescription3, prodDesc3);
//	    	mav.addObject(productDescription4, prodDesc4);
//	    	mav.addObject(productDescription5, prodDesc5);
	    	mav.addObject(productPrice1, prodPrice1);
	    	mav.addObject(productPrice2, prodPrice2);
	    	mav.addObject(productPrice3, prodPrice3);
	    	mav.addObject(productPrice4, prodPrice4);
	    	mav.addObject(productPrice5, prodPrice5);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(brandName, brandsName);
	    	mav.addObject(storeUrl, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productUploadedImage1, productsImage1);
			mav.addObject(productUploadedImage2, productsImage2);
			mav.addObject(productUploadedImage3, productsImage3);
			mav.addObject(productUploadedImage4, productsImage4);	    	
	    	sn.setAttribute(adminConFSProductsIdInSn, productId);	    	
		} else {
			mav = new ModelAndView("redirect:" + adminConFurSpectsDataDisplayRed);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

   	@Override
   	@Transactional
   	public ModelAndView adminConFurnitureSpecsModifiedDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
   		ModelAndView mav;   		   		
   		String fileName1 = productUploadedImage1.getOriginalFilename();
   		String fileName2 = productUploadedImage2.getOriginalFilename();
   		String fileName3 = productUploadedImage3.getOriginalFilename();
   		String fileName4 = productUploadedImage4.getOriginalFilename();   		
   		byte[] bFile1 = null;
   		byte[] bFile2 = null;
   		byte[] bFile3 = null;
   		byte[] bFile4 = null;   		
   		if((null != fileName1) && ("" != fileName1)) {
   			String filepath1 = uploadImgPath + fileName1;	
   	   		File conFile1 = new File(filepath1);
   	   		conFile1.mkdir();    
   	   		productUploadedImage1.transferTo(conFile1);        
   	   		bFile1 = new byte[(int) conFile1.length()];
   	   		try {
   	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
   	   			fileInputStream1.read(bFile1);
   	   			fileInputStream1.close();   	   			
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName2) && ("" != fileName2)) {
   			String filepath2 = uploadImgPath + fileName2;	
   	   		File conFile2 = new File(filepath2);
   	   		conFile2.mkdir();    
   	   		productUploadedImage2.transferTo(conFile2);        
   	   		bFile2 = new byte[(int) conFile2.length()];
   	   		try {
   	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
   	   			fileInputStream2.read(bFile2);
   	   			fileInputStream2.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName3) && ("" != fileName3)) {
   			String filepath3 = uploadImgPath + fileName3;	
   	   		File conFile3 = new File(filepath3);
   	   		conFile3.mkdir();    
   	   		productUploadedImage3.transferTo(conFile3);        
   	   		bFile3 = new byte[(int) conFile3.length()];
   	   		try {
   	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
   	   			fileInputStream3.read(bFile3);
   	   			fileInputStream3.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName4) && ("" != fileName4)) {
   			String filepath4 = uploadImgPath + fileName4;	
   	   		File conFile4 = new File(filepath4);
   	   		conFile4.mkdir();    
   	   		productUploadedImage4.transferTo(conFile4);        
   	   		bFile4 = new byte[(int) conFile4.length()];
   	   		try {
   	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
   	   			fileInputStream4.read(bFile4);
   	   			fileInputStream4.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		String editFileName1 = req.getParameter(productUploadImage1);
   		String editFileName2 = req.getParameter(productUploadImage2);
   		String editFileName3 = req.getParameter(productUploadImage3);
   		String editFileName4 = req.getParameter(productUploadImage4);   		
   		Timestamp currentDate = currentDate();
   		long adminConFSProductsId = (Long) sn.getAttribute(adminConFSProductsIdInSn);
   		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecEditProductsDataTakeFromDB(adminConFSProductsId);   		
   		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
   		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
   		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
   		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
   		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
   		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));
   		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
//   		admRegFurnitureSpecsSaving.setProductDescription2(req.getParameter(productDescription2));
//   		admRegFurnitureSpecsSaving.setProductDescription3(req.getParameter(productDescription3));
//   		admRegFurnitureSpecsSaving.setProductDescription4(req.getParameter(productDescription4));
//   		admRegFurnitureSpecsSaving.setProductDescription5(req.getParameter(productDescription5));
   		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
   		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
   		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
   		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
   		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
   		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
   		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
   		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
   		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
   		admRegFurnitureSpecsSaving.setFurnitureSpecsStatus(adminDoneStatus);   		
   		admRegFurnitureSpecsSaving.setUpdatedDate(currentDate);
   		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegFurnitureSpecsSaving);
   		mav = adminConFurnitureSpecsEditdDataUpdateInDB(req, sn, adminConFSProductsId, bFile1, bFile2, bFile3, bFile4, editFileName1, editFileName2, editFileName3, editFileName4);
   		long conceptBoardsSavingId = admRegFurnitureSpecsSaving.getAdminRegistryConceptBoardsSavingId();
   		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
   		mav = new ModelAndView("redirect:" + adminConFurSpectsDataDisplayRed);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));       
        return mav;
   	}

	@Override
	@Transactional
	public ModelAndView adminConFurnitureSpecsEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminConFSProductsId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4) {
		ModelAndView mav;		
		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecEditProductsDataTakeFromDB(adminConFSProductsId);
		if(null != bFile1) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
   		}
   		if(null != bFile2) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
   		}
   		if(null != bFile3) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
   		}
   		if(null != bFile4) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
   		}   		
   		if(("").equals(editFileName1)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage1(null);
	   	}
   		if(("").equals(editFileName2)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage2(null);
	   	}
   		if(("").equals(editFileName3)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage3(null);
	   	}
   		if(("").equals(editFileName4)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage4(null);
	   	}
   		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = new ModelAndView();
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminConFurnitureSpecsDataDeleteFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> delFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecEditProductsInDB(productId);
		if (!delFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving delFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecEditProductsDataTakeFromDB(productId);
			adminRegistryConceptBoardsFurnitureSpecsSavingDAO.delete(delFurSpecsProductsModel);
			sn.setAttribute(adminConFSProductsIdInSn, productId);			
		}
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> deleteFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.adminRegFurnitureSpecCount((Long) sn.getAttribute(conceptBoardsSavingIdInSn));		
		if(deleteFurSpecsProductsList.size() == 0) {
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
			adminRegConBdSavingModel.setFurnitureSpecsStatus(null);
			adminRegConBdSavingModel.setAdminApprovalStatus(null);			
			adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		} else {
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
			int furSpecsCount = adminRegConBdSavingModel.getFurnitureSpecsCount();
			int totalSpecsCount = furSpecsCount - 1;
			adminRegConBdSavingModel.setFurnitureSpecsCount(totalSpecsCount);
			adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		}
		mav = new ModelAndView("redirect:" + adminConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

    @Override
    @Transactional
    public ModelAndView adminRegistryFinishingTouchesUploadRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFinishingTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFurnitureSpecEditProductsInDB();
    	if(!totalFinishingTouchesProductsList.isEmpty()){
    		mav = new ModelAndView("redirect:" + redirectAdminFinishingTouchesDisplay);
    	} else {
    		mav = new ModelAndView(adminRegistryFinishingTouchesUpload);
    	}    	
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        return mav;
    }

   	@Override
   	@Transactional
   	public ModelAndView adminFinishingTouchesUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
   		ModelAndView mav;   		
   		String fileName1 = productUploadedImage1.getOriginalFilename();
   		String fileName2 = productUploadedImage2.getOriginalFilename();
   		String fileName3 = productUploadedImage3.getOriginalFilename();
   		String fileName4 = productUploadedImage4.getOriginalFilename();   		
   		byte[] bFile1 = null;
   		byte[] bFile2 = null;
   		byte[] bFile3 = null;
   		byte[] bFile4 = null;   		
   		if((null != fileName1) && ("" != fileName1)) {
   			String filepath1 = uploadImgPath + fileName1;	
   	   		File conFile1 = new File(filepath1);
   	   		conFile1.mkdir();    
   	   		productUploadedImage1.transferTo(conFile1);        
   	   		bFile1 = new byte[(int) conFile1.length()];
   	   		try {
   	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
   	   			fileInputStream1.read(bFile1);
   	   			fileInputStream1.close();   	   			
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName2) && ("" != fileName2)) {
   			String filepath2 = uploadImgPath + fileName2;	
   	   		File conFile2 = new File(filepath2);
   	   		conFile2.mkdir();    
   	   		productUploadedImage2.transferTo(conFile2);        
   	   		bFile2 = new byte[(int) conFile2.length()];
   	   		try {
   	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
   	   			fileInputStream2.read(bFile2);
   	   			fileInputStream2.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName3) && ("" != fileName3)) {
   			String filepath3 = uploadImgPath + fileName3;	
   	   		File conFile3 = new File(filepath3);
   	   		conFile3.mkdir();    
   	   		productUploadedImage3.transferTo(conFile3);        
   	   		bFile3 = new byte[(int) conFile3.length()];
   	   		try {
   	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
   	   			fileInputStream3.read(bFile3);
   	   			fileInputStream3.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName4) && ("" != fileName4)) {
   			String filepath4 = uploadImgPath + fileName4;	
   	   		File conFile4 = new File(filepath4);
   	   		conFile4.mkdir();    
   	   		productUploadedImage4.transferTo(conFile4);        
   	   		bFile4 = new byte[(int) conFile4.length()];
   	   		try {
   	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
   	   			fileInputStream4.read(bFile4);
   	   			fileInputStream4.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}   		
   		Timestamp currentDate = currentDate();
   		long adminUserId = 1;
   		AdminRegistryFinishingTouchesProductsInfoSaving admRegFurnitureSpecsSaving = new AdminRegistryFinishingTouchesProductsInfoSaving();
   		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceId(adminUserId);
   		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceName(adminReff);
   		admRegFurnitureSpecsSaving.setAdminApprovalStatus(approvedReff);
   		admRegFurnitureSpecsSaving.setProductCategory(req.getParameter(productCategory));
   		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
   		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
   		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
   		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
   		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
   		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));   		
   		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
//   		admRegFurnitureSpecsSaving.setProductDescription2(req.getParameter(productDescription2));
//   		admRegFurnitureSpecsSaving.setProductDescription3(req.getParameter(productDescription3));
//   		admRegFurnitureSpecsSaving.setProductDescription4(req.getParameter(productDescription4));
//   		admRegFurnitureSpecsSaving.setProductDescription5(req.getParameter(productDescription5));
   		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
   		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
   		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
   		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
   		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
   		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
   		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
   		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
   		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
   		admRegFurnitureSpecsSaving.setFinishingTouchesStatus(adminDoneStatus);
   		admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
   		admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
   		admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
   		admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
   		admRegFurnitureSpecsSaving.setAdminStockCheckStatus(availableStatus);
   		admRegFurnitureSpecsSaving.setCreatedDate(currentDate);
   		adminRegistryFinishingTouchesProductsInfoSavingDAO.save(admRegFurnitureSpecsSaving);   		
   		mav = new ModelAndView("redirect:" + redirectAdminFinishingTouchesDisplay);
   		mav.addObject(flName, sn.getAttribute(firstNamesInSn));     
        return mav;
   	}

    @Override
    @Transactional
    public ModelAndView adminRegFinishingTouchesCategoriesManagement(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesCategoriesProductsTakeFromDB();
    	if(!admnRegFinTouchesProductsList.isEmpty()){
    		mav = adminRegFinishingTouchesCategoriesManagementDataDisplay(req, sn);
    	} else {
    		mav = new ModelAndView(adminRegistryFinishingTouchesUpload);
    	}
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegFinishingTouchesCategoriesManagementDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesCategoriesProductsTakeFromDB();
    	if(!admnRegFinTouchesProductsList.isEmpty()){       	
            List<AdminRegistryFinishingTouchesProductsInfoSaving> admRegFinTouchesSavingList = new ArrayList<AdminRegistryFinishingTouchesProductsInfoSaving>();
            for (AdminRegistryFinishingTouchesProductsInfoSaving admRegFinTouchesInfoLoop : admnRegFinTouchesProductsList) {
            	AdminRegistryFinishingTouchesProductsInfoSaving admRegFinTouchesSavingModel = new AdminRegistryFinishingTouchesProductsInfoSaving();            	           	
            	admRegFinTouchesSavingModel.setAdminRegistryFinishingTouchesProductsInfoSavingId(admRegFinTouchesInfoLoop.getAdminRegistryFinishingTouchesProductsInfoSavingId());
            	admRegFinTouchesSavingModel.setProductCategory(admRegFinTouchesInfoLoop.getProductCategory());
            	admRegFinTouchesSavingModel.setProductName(admRegFinTouchesInfoLoop.getProductName());
            	admRegFinTouchesSavingModel.setProductPrice1(admRegFinTouchesInfoLoop.getProductPrice1());
            	admRegFinTouchesSavingModel.setStoreName(admRegFinTouchesInfoLoop.getStoreName());
            	admRegFinTouchesSavingModel.setBrandName(admRegFinTouchesInfoLoop.getBrandName());
            	admRegFinTouchesSavingModel.setCreatedDate(admRegFinTouchesInfoLoop.getCreatedDate());
            	admRegFinTouchesSavingModel.setUpdatedDate(admRegFinTouchesInfoLoop.getUpdatedDate());            	
            	admRegFinTouchesSavingList.add(admRegFinTouchesSavingModel);
            }
            mav = new ModelAndView(adminRegistryFinishingTouchesDisplay);
            mav.addObject("adminRegFinTouchesManagementSavingList", admRegFinTouchesSavingList);
            mav.addObject("adminRegFinTouchesManagementListCount", admnRegFinTouchesProductsList.size());                       
        } else{
        	mav = adminRegAddNewBoardsRedirection(req, sn);
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminRegFinishingTouchesManagementRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	String admFiniTouchesManagementId = req.getParameter("admFinTouchesManagementId");
    	String typeOfRoomSel = req.getParameter("typeOfProductSelection");
    	if(("Modify Room").equals(typeOfRoomSel)) {
    		long finiTouchesManagementId = Long.parseLong(admFiniTouchesManagementId);
    		mav = adminFinishingTouchesEditProductsRedirection(req, sn, finiTouchesManagementId);
    	} else if(("Delete Room").equals(typeOfRoomSel)) {
    		long finTouchesManagementId = Long.parseLong(admFiniTouchesManagementId);
    		mav = adminFinishingTouchesDataDeleteFromDB(req, sn, finTouchesManagementId);
    	} else {
    		mav = new ModelAndView(adminRegistryFinishingTouchesUpload);
    	}   	
        return mav;
    }

//	@Override
//	@Transactional
//	public ModelAndView redirectAdminFinishingTouchesDisplayRedirection(HttpServletRequest req, HttpSession sn) {
//		ModelAndView mav;
//		List finiTouchesIdList = new ArrayList();
//		List finiTouchesProductNameList = new ArrayList();
//		int prodCount = 0;
//		List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFinishingTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFurnitureSpecEditProductsInDB();
//		if (!totalFinishingTouchesProductsList.isEmpty()) {
//	 		for (AdminRegistryFinishingTouchesProductsInfoSaving finishingTouchesSavingModel : totalFinishingTouchesProductsList) {
//	 			finiTouchesIdList.add(finishingTouchesSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
//	 			finiTouchesProductNameList.add(finishingTouchesSavingModel.getProductName());
//	 			int count = 1;
//	 			prodCount = prodCount + count;
//	 		}		
//	 		mav = new ModelAndView(adminRegistryFinishingTouchesDisplay);
//	 		sn.setAttribute(finishingTouchesIdList, finiTouchesIdList);
//	 		sn.setAttribute(finishingTouchesProductNameList, finiTouchesProductNameList);
//	 		mav.addObject(prodTotalCount, prodCount);	 		
// 		} else{
//     	mav = adminRegistryFinishingTouchesUploadRedirection(req, sn);
//		}    	
//		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
//		sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, null);
//		return mav;
//	}

//    @Override
//    @Transactional
//    public ModelAndView adminFinishingTouchesAddNewProductsRedirection(HttpServletRequest req, HttpSession sn) {
//    	ModelAndView mav;
//    	mav = new ModelAndView(adminRegistryFinishingTouchesUpload);
//    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
//        return mav;
//    }

	@Override
	@Transactional
	public ModelAndView adminFinishingTouchesEditProductsRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId) {
		ModelAndView mav;
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
	    	String prodCategory = ediFurSpecsProductsModel.getProductCategory();
	    	String prodName = ediFurSpecsProductsModel.getProductName();
	    	String headName1 = ediFurSpecsProductsModel.getProductSize1();
	    	String headName2 = ediFurSpecsProductsModel.getProductSize2();
	    	String headName3 = ediFurSpecsProductsModel.getProductSize3();
	    	String headName4 = ediFurSpecsProductsModel.getProductSize4();
	    	String headName5 = ediFurSpecsProductsModel.getProductSize5();
	    	String prodDesc1 = ediFurSpecsProductsModel.getProductDescription1();
//	    	String prodDesc2 = ediFurSpecsProductsModel.getProductDescription2();
//	    	String prodDesc3 = ediFurSpecsProductsModel.getProductDescription3();
//	    	String prodDesc4 = ediFurSpecsProductsModel.getProductDescription4();
//	    	String prodDesc5 = ediFurSpecsProductsModel.getProductDescription5();
	    	String prodPrice1 = ediFurSpecsProductsModel.getProductPrice1();
	    	String prodPrice2 = ediFurSpecsProductsModel.getProductPrice2();
	    	String prodPrice3 = ediFurSpecsProductsModel.getProductPrice3();
	    	String prodPrice4 = ediFurSpecsProductsModel.getProductPrice4();
	    	String prodPrice5 = ediFurSpecsProductsModel.getProductPrice5();
	    	String strName = ediFurSpecsProductsModel.getStoreName();
	    	String brandsName = ediFurSpecsProductsModel.getBrandName();
	    	String strUrl = ediFurSpecsProductsModel.getStoreUrl();
	    	String skuNames = ediFurSpecsProductsModel.getSkuName();
	    	String productsImage1 = null;
	    	String productsImage2 = null;
	    	String productsImage3 = null;
	    	String productsImage4 = null;
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage1()) {
		    	byte[] productImgFromDB1 = ediFurSpecsProductsModel.getProductUploadedImage1();
				productsImage1 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB1);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage2()) {
				byte[] productImgFromDB2 = ediFurSpecsProductsModel.getProductUploadedImage2();
				productsImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB2);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage3()) {
				byte[] productImgFromDB3 = ediFurSpecsProductsModel.getProductUploadedImage3();
				productsImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB3);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage4()) {
				byte[] productImgFromDB4 = ediFurSpecsProductsModel.getProductUploadedImage4();
				productsImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB4);
	    	}
	    	mav = new ModelAndView(adminRegistryFinishingTouchesEdit);
	    	mav.addObject(productCategory, prodCategory);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productSize1, headName1);
	    	mav.addObject(productSize2, headName2);
	    	mav.addObject(productSize3, headName3);
	    	mav.addObject(productSize4, headName4);
	    	mav.addObject(productSize5, headName5);
	    	mav.addObject(productDescription1, prodDesc1);
//	    	mav.addObject(productDescription2, prodDesc2);
//	    	mav.addObject(productDescription3, prodDesc3);
//	    	mav.addObject(productDescription4, prodDesc4);
//	    	mav.addObject(productDescription5, prodDesc5);
	    	mav.addObject(productPrice1, prodPrice1);
	    	mav.addObject(productPrice2, prodPrice2);
	    	mav.addObject(productPrice3, prodPrice3);
	    	mav.addObject(productPrice4, prodPrice4);
	    	mav.addObject(productPrice5, prodPrice5);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(brandName, brandsName);
	    	mav.addObject(storeUrl, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productUploadedImage1, productsImage1);
			mav.addObject(productUploadedImage2, productsImage2);
			mav.addObject(productUploadedImage3, productsImage3);
			mav.addObject(productUploadedImage4, productsImage4);	    	
	    	sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);	    	
		} else {
			mav = new ModelAndView("redirect:" + redirectAdminFinishingTouchesDisplay);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

   	@Override
   	@Transactional
   	public ModelAndView adminFinishingTouchesModifiedDataUpdateInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
   		ModelAndView mav;
   		   		
   		String fileName1 = productUploadedImage1.getOriginalFilename();
   		String fileName2 = productUploadedImage2.getOriginalFilename();
   		String fileName3 = productUploadedImage3.getOriginalFilename();
   		String fileName4 = productUploadedImage4.getOriginalFilename();   		
   		byte[] bFile1 = null;
   		byte[] bFile2 = null;
   		byte[] bFile3 = null;
   		byte[] bFile4 = null;   		
   		if((null != fileName1) && ("" != fileName1)) {
   			String filepath1 = uploadImgPath + fileName1;	
   	   		File conFile1 = new File(filepath1);
   	   		conFile1.mkdir();    
   	   		productUploadedImage1.transferTo(conFile1);        
   	   		bFile1 = new byte[(int) conFile1.length()];
   	   		try {
   	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
   	   			fileInputStream1.read(bFile1);
   	   			fileInputStream1.close();   	   			
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName2) && ("" != fileName2)) {
   			String filepath2 = uploadImgPath + fileName2;	
   	   		File conFile2 = new File(filepath2);
   	   		conFile2.mkdir();    
   	   		productUploadedImage2.transferTo(conFile2);        
   	   		bFile2 = new byte[(int) conFile2.length()];
   	   		try {
   	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
   	   			fileInputStream2.read(bFile2);
   	   			fileInputStream2.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName3) && ("" != fileName3)) {
   			String filepath3 = uploadImgPath + fileName3;	
   	   		File conFile3 = new File(filepath3);
   	   		conFile3.mkdir();    
   	   		productUploadedImage3.transferTo(conFile3);        
   	   		bFile3 = new byte[(int) conFile3.length()];
   	   		try {
   	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
   	   			fileInputStream3.read(bFile3);
   	   			fileInputStream3.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		if((null != fileName4) && ("" != fileName4)) {
   			String filepath4 = uploadImgPath + fileName4;	
   	   		File conFile4 = new File(filepath4);
   	   		conFile4.mkdir();    
   	   		productUploadedImage4.transferTo(conFile4);        
   	   		bFile4 = new byte[(int) conFile4.length()];
   	   		try {
   	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
   	   			fileInputStream4.read(bFile4);
   	   			fileInputStream4.close();
   	   		} 
   	   		catch (Exception e) {
   	   			LOGGER.error("Blog Exception: "+e);
   	   		}
   		}
   		String editFileName1 = req.getParameter(productUploadImage1);
   		String editFileName2 = req.getParameter(productUploadImage2);
   		String editFileName3 = req.getParameter(productUploadImage3);
   		String editFileName4 = req.getParameter(productUploadImage4);   		
   		Timestamp currentDate = currentDate();
   		long adminRegFinishingTouchesSavingId = (Long) sn.getAttribute(adminRegFinishingTouchesSavingIdInSn);
   		AdminRegistryFinishingTouchesProductsInfoSaving admRegFurnitureSpecsSaving = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);
   		admRegFurnitureSpecsSaving.setProductCategory(req.getParameter(productCategory));
   		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
   		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
   		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
   		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
   		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
   		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));
   		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
//   		admRegFurnitureSpecsSaving.setProductDescription2(req.getParameter(productDescription2));
//   		admRegFurnitureSpecsSaving.setProductDescription3(req.getParameter(productDescription3));
//   		admRegFurnitureSpecsSaving.setProductDescription4(req.getParameter(productDescription4));
//   		admRegFurnitureSpecsSaving.setProductDescription5(req.getParameter(productDescription5));
   		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
   		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
   		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
   		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
   		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
   		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
   		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
   		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
   		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
   		admRegFurnitureSpecsSaving.setFinishingTouchesStatus(adminDoneStatus);   		
   		admRegFurnitureSpecsSaving.setUpdatedDate(currentDate);
   		adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(admRegFurnitureSpecsSaving);
   		mav = adminFinishingTouchesImagesEditdDataUpdateInDB(req, sn, adminRegFinishingTouchesSavingId, bFile1, bFile2, bFile3, bFile4, editFileName1, editFileName2, editFileName3, editFileName4);
   		mav = new ModelAndView("redirect:" + redirectAdminFinishingTouchesDisplay);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));       
        return mav;
   	}

	@Override
	@Transactional
	public ModelAndView adminFinishingTouchesImagesEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4) {
		ModelAndView mav;
		AdminRegistryFinishingTouchesProductsInfoSaving admRegFurnitureSpecsSaving = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);
		if(null != bFile1) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
   		}
   		if(null != bFile2) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
   		}
   		if(null != bFile3) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
   		}
   		if(null != bFile4) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
   		}   		
   		if(("").equals(editFileName1)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage1(null);
	   	}
   		if(("").equals(editFileName2)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage2(null);
	   	}
   		if(("").equals(editFileName3)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage3(null);
	   	}
   		if(("").equals(editFileName4)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage4(null);
	   	}
   		adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = new ModelAndView();
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminFinishingTouchesDataDeleteFromDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId) {
		ModelAndView mav;		
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
			adminRegistryFinishingTouchesProductsInfoSavingDAO.delete(ediFurSpecsProductsModel);
			sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);			
		}
		mav = new ModelAndView("redirect:" + redirectAdminFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

    @Override
    @Transactional
    public ModelAndView selectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegFinishingTouchesIdsList = new ArrayList();
    	List admnRegFinishingTouchesImagesList = new ArrayList();    	
    	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinishingTouchesList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFurnitureSpecEditProductsInDB();
    	if (!admnRegFinishingTouchesList.isEmpty()) {
    		for (AdminRegistryFinishingTouchesProductsInfoSaving admnRegFinishingTouchesModel : admnRegFinishingTouchesList) {
    			admnRegFinishingTouchesIdsList.add(admnRegFinishingTouchesModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
    			String admnRegFTImage = null;
    			if(null != admnRegFinishingTouchesModel.getProductUploadedImage1()) {
    	    		byte[] conBoardsImageFromDB = admnRegFinishingTouchesModel.getProductUploadedImage1();
    	    		admnRegFTImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegFinishingTouchesImagesList.add(admnRegFTImage);
     	   }
    	}
    	mav = new ModelAndView(adminRegistryFinishingTouchesHome);
    	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
        sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegFinishingTouchesList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(adminRegistryRoom, req.getParameter(adminRegistryRoom));
        mav.addObject(adminRegistryStyle, req.getParameter(adminRegistryStyle));
        mav.addObject(adminRegistryPrice, req.getParameter(adminRegistryPrice));
        mav.addObject(finishingTouchesRBName, req.getParameter(finishingTouchesRBName));
        mav.addObject(finishingTouchesCBName, req.getParameter(finishingTouchesCBName));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedCBFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
//    	String adminFTCBValues = "";    	
//        if(null != req.getParameterValues(adminFTCBValuesList)) {
//        	String[] checkBoxVal = req.getParameterValues(adminFTCBValuesList);
//        	for (int i = 0; i < checkBoxVal.length; i++) {
//        		adminFTCBValues = adminFTCBValues + "," + checkBoxVal[i];
//        	}
//        	adminFTCBValues = adminFTCBValues.replaceFirst(",", "");        	
//        }
//        if(!("").equals(adminFTCBValues)) {
//        	String adminFTCBFormatValue = adminFTCBValues.replace(",", "', '");
//        	mav = regiSelectedCheckBoxFinishingTouchesList(req, sn, adminFTCBFormatValue);
//    	} 
    	mav = regiSelectedCheckBoxFinishingTouchesList(req, sn, req.getParameter(adminFTCBValuesList));
    	mav = new ModelAndView(adminRegistryFinishingTouchesHome);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	mav.addObject(adminRegistryRoom, req.getParameter(adminRegistryRoom));
        mav.addObject(adminRegistryStyle, req.getParameter(adminRegistryStyle));
        mav.addObject(adminRegistryPrice, req.getParameter(adminRegistryPrice));
        mav.addObject(finishingTouchesRBName, req.getParameter(finishingTouchesRBName));
        mav.addObject(finishingTouchesCBName, req.getParameter(adminFTCBValuesList));
//        mav.addObject(finishingTouchesCBName, adminFTCBValues);
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView regiSelectedCheckBoxFinishingTouchesList(HttpServletRequest req, HttpSession sn, String prodCategory) {
    	ModelAndView mav;
    	List admnRegFinishingTouchesIdsList = new ArrayList();
    	List admnRegFinishingTouchesImagesList = new ArrayList();    	
    	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinishingTouchesList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminSelectedCheckBoxFinishingTouchesListFromDB(prodCategory);
    	if (!admnRegFinishingTouchesList.isEmpty()) {
    		for (AdminRegistryFinishingTouchesProductsInfoSaving admnRegFinishingTouchesModel : admnRegFinishingTouchesList) {
    			admnRegFinishingTouchesIdsList.add(admnRegFinishingTouchesModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
    			String admnRegFTImage = null;
    			if(null != admnRegFinishingTouchesModel.getProductUploadedImage1()) {
    	    		byte[] conBoardsImageFromDB = admnRegFinishingTouchesModel.getProductUploadedImage1();
    	    		admnRegFTImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegFinishingTouchesImagesList.add(admnRegFTImage);
     	   }
    	}
    	mav = new ModelAndView();
    	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
        sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegFinishingTouchesList.size());            	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView selectedFinishingTouchesImageEditInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
 	   	String finishingTouchesImage1 = req.getParameter("finishingTouchesImage");
 	   	if (null != finishingTouchesImage1) {
 	   		long finishingTouchesImageId = Long.parseLong(finishingTouchesImage1);
 	   		sn.setAttribute(finishingTouchesImageIdInSn, finishingTouchesImageId);
 	   		mav = selectedFinishingTouchesImageEditRedirection(req, sn, finishingTouchesImageId);
 	   	} else {	   		   	
 	   		mav = selectedFinishingTouchesRedirection(req, sn);
 	   	}
 	   	return mav;
    }

	@Override
	@Transactional
	public ModelAndView selectedFinishingTouchesImageEditRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId) {
		ModelAndView mav;		
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
	    	String prodCategory = ediFurSpecsProductsModel.getProductCategory();
	    	String prodName = ediFurSpecsProductsModel.getProductName();
	    	String headName1 = ediFurSpecsProductsModel.getProductSize1();
	    	String headName2 = ediFurSpecsProductsModel.getProductSize2();
	    	String headName3 = ediFurSpecsProductsModel.getProductSize3();
	    	String headName4 = ediFurSpecsProductsModel.getProductSize4();
	    	String headName5 = ediFurSpecsProductsModel.getProductSize5();
	    	String prodDesc1 = ediFurSpecsProductsModel.getProductDescription1();
//	    	String prodDesc2 = ediFurSpecsProductsModel.getProductDescription2();
//	    	String prodDesc3 = ediFurSpecsProductsModel.getProductDescription3();
//	    	String prodDesc4 = ediFurSpecsProductsModel.getProductDescription4();
//	    	String prodDesc5 = ediFurSpecsProductsModel.getProductDescription5();
	    	String prodPrice1 = ediFurSpecsProductsModel.getProductPrice1();
	    	String prodPrice2 = ediFurSpecsProductsModel.getProductPrice2();
	    	String prodPrice3 = ediFurSpecsProductsModel.getProductPrice3();
	    	String prodPrice4 = ediFurSpecsProductsModel.getProductPrice4();
	    	String prodPrice5 = ediFurSpecsProductsModel.getProductPrice5();
	    	String strName = ediFurSpecsProductsModel.getStoreName();
	    	String brandsName = ediFurSpecsProductsModel.getBrandName();
	    	String strUrl = ediFurSpecsProductsModel.getStoreUrl();
	    	String skuNames = ediFurSpecsProductsModel.getSkuName();
	    	String productsImage1 = null;
	    	String productsImage2 = null;
	    	String productsImage3 = null;
	    	String productsImage4 = null;
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage1()) {
		    	byte[] productImgFromDB1 = ediFurSpecsProductsModel.getProductUploadedImage1();
				productsImage1 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB1);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage2()) {
				byte[] productImgFromDB2 = ediFurSpecsProductsModel.getProductUploadedImage2();
				productsImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB2);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage3()) {
				byte[] productImgFromDB3 = ediFurSpecsProductsModel.getProductUploadedImage3();
				productsImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB3);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage4()) {
				byte[] productImgFromDB4 = ediFurSpecsProductsModel.getProductUploadedImage4();
				productsImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB4);
	    	}
	    	mav = new ModelAndView(adminRegistryFinishingTouchesEdit);
	    	mav.addObject(productCategory, prodCategory);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productSize1, headName1);
	    	mav.addObject(productSize2, headName2);
	    	mav.addObject(productSize3, headName3);
	    	mav.addObject(productSize4, headName4);
	    	mav.addObject(productSize5, headName5);
	    	mav.addObject(productDescription1, prodDesc1);
//	    	mav.addObject(productDescription2, prodDesc2);
//	    	mav.addObject(productDescription3, prodDesc3);
//	    	mav.addObject(productDescription4, prodDesc4);
//	    	mav.addObject(productDescription5, prodDesc5);
	    	mav.addObject(productPrice1, prodPrice1);
	    	mav.addObject(productPrice2, prodPrice2);
	    	mav.addObject(productPrice3, prodPrice3);
	    	mav.addObject(productPrice4, prodPrice4);
	    	mav.addObject(productPrice5, prodPrice5);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(brandName, brandsName);
	    	mav.addObject(storeUrl, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productUploadedImage1, productsImage1);
			mav.addObject(productUploadedImage2, productsImage2);
			mav.addObject(productUploadedImage3, productsImage3);
			mav.addObject(productUploadedImage4, productsImage4);	    	
	    	sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);	    	
		} else {
			mav = new ModelAndView("redirect:" + redirectAdminFinishingTouchesDisplay);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

    @Override
    @Transactional
    public ModelAndView backToFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List admnRegFinishingTouchesIdsList = new ArrayList();
    	List admnRegFinishingTouchesImagesList = new ArrayList();    	
    	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinishingTouchesList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFurnitureSpecEditProductsInDB();
    	if (!admnRegFinishingTouchesList.isEmpty()) {
    		for (AdminRegistryFinishingTouchesProductsInfoSaving admnRegFinishingTouchesModel : admnRegFinishingTouchesList) {
    			admnRegFinishingTouchesIdsList.add(admnRegFinishingTouchesModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
    			String admnRegFTImage = null;
    			if(null != admnRegFinishingTouchesModel.getProductUploadedImage1()) {
    	    		byte[] conBoardsImageFromDB = admnRegFinishingTouchesModel.getProductUploadedImage1();
    	    		admnRegFTImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			admnRegFinishingTouchesImagesList.add(admnRegFTImage);
     	   }
    	}
    	mav = new ModelAndView(adminRegistryFinishingTouchesHome);
    	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
        sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
        sn.setAttribute(admnRegTotalResultCount, admnRegFinishingTouchesList.size());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
        mav.addObject(finishingTouchesRBName, "Finishing Touches");
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
        return mav;
    }
    
    
//	Designer Side Registry Coding
    
    @Override
    @Transactional
    public ModelAndView adminDesignerRegistryConceptBoardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List desnRegConBdRoomIdsList = new ArrayList();
    	List desnRegConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsLivingRoomListTakeFromDB();  	
    	if (!admnRegConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
    			desnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			String conBoardsImage = null;
    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
        		}
    			desnRegConBdRoomImagesList.add(conBoardsImage);
     	   }
    	}
    	mav = new ModelAndView(adminDesignerRegistryConceptBoardsRed);
    	sn.setAttribute(adminDesignerRegConBdRoomIdsListInSn, desnRegConBdRoomIdsList);
        sn.setAttribute(adminDesignerRegConBdRoomImagesListInSn, desnRegConBdRoomImagesList);
        sn.setAttribute(adminDesignerRegTotalResultCount, admnRegConBdRoomsList.size());
        mav.addObject(designerRegistryRoom, "Living Room");
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
    	sn.setAttribute(adminDesignerRegistryRoomInSn, null);
        return mav;
    }
    
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedRoomAndStyleRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	String rommName = req.getParameter(designerRegistryRoom);    	
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsAllRoomListTakeFromDB(rommName);  	
	  	if (!admnRegConBdRoomsList.isEmpty()) {
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
	  			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	  			String conBoardsImage = null;
	  			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
	  	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
	  	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	  			admnRegConBdRoomImagesList.add(conBoardsImage);
	   	   }
	  	}
	  	mav = new ModelAndView(adminDesignerRegistryConceptBoardsRed);
	  	sn.setAttribute(adminDesignerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(adminDesignerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(adminDesignerRegTotalResultCount, admnRegConBdRoomsList.size());
	    mav.addObject(designerRegistryRoom, rommName);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	    return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedStyleAndRoomRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String rommName = req.getParameter(designerRegistryRoom);
	  	String priceValue = req.getParameter(designerRegistryPrice);
	  	String admnRegCheckValue = "";
	  	if(null != req.getParameterValues(designerRegistryStyle)) {
	      	String[] checkBoxVal = req.getParameterValues(designerRegistryStyle);
	      	for (int i = 0; i < checkBoxVal.length; i++) {
	      		admnRegCheckValue = admnRegCheckValue + "," + checkBoxVal[i];
	      	}
	      	admnRegCheckValue = admnRegCheckValue.replaceFirst(",", "");        	
	    }
	    if((!("").equals(admnRegCheckValue)) && (!("").equals(priceValue))) {
	    	String priceValue1 = priceValue.replace(",", "', '");
	      	mav = adminDesignerSelectedRoomStyleAndPriceCombDataTakeFromDB(req, sn, rommName, admnRegCheckValue, priceValue1);
	  	} else if((!("").equals(admnRegCheckValue)) && (("").equals(priceValue))) {
	  		mav = adminDesignerSelectedRoomAndStyleDataTakeFromDB(req, sn, rommName, admnRegCheckValue);
	  	} else if((("").equals(admnRegCheckValue)) && (!("").equals(priceValue))) {
	  		String priceValue1 = priceValue.replace(",", "', '");
	  		mav = adminDesignerSelectedRoomAndPriceDataTakeFromDB(req, sn, rommName, priceValue1);
	  	} else {
	  		mav = adminDesignerSelectedRoomDataOnlyTakeFromDB(req, sn, rommName);
	  	}    	
	  	mav = new ModelAndView(adminDesignerRegistryConceptBoardsRed);
	  	mav.addObject(designerRegistryRoom, rommName);
	  	mav.addObject(designerRegistryStyle, admnRegCheckValue);
	  	mav.addObject(designerRegistryPrice, priceValue);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedRoomStyleAndPriceCombDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames, String priceValue) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(rommName, priceValue);
	  	int totalConceptCount = 0;
	  	if (!admnRegConBdRoomStyleList.isEmpty()) {
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomStyleList) {
	  			String stylesNameDBList = admnRegConBdSavingModel.getStyle();
	  			String styleRowChecking = adminDesignerStyleNameCheckInDbUsingAdminSelectedStyleList(stylesNameDBList, styleNames);    			
	  			if(("Have").equals(styleRowChecking)) {
		    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
		    			String conBoardsImage = null;
		    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
		    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
		    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
		        		}
		    			admnRegConBdRoomImagesList.add(conBoardsImage);
		    			totalConceptCount = totalConceptCount + 1;
	  			}
	   	   }
	  	}
	  	mav = new ModelAndView();
	  	sn.setAttribute(adminDesignerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(adminDesignerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(adminDesignerRegTotalResultCount, totalConceptCount);
	    return mav;
	}
	
	public String adminDesignerStyleNameCheckInDbUsingAdminSelectedStyleList(String stylesNameDbList, String stylesNameAdmList) {
    	String styleRowChecking = null;
    	String[] stylesNameDbSt = stylesNameDbList.split(",");
    	String[] stylesNameAdmSt = stylesNameAdmList.split(",");				
		for(int i=0; i<stylesNameAdmSt.length; i++) {
			for(int j=0; j<stylesNameDbSt.length; j++) {
				if(stylesNameAdmSt[i].equals(stylesNameDbSt[j])) {
					styleRowChecking = "Have";
					break;
				}
			}
		}
		return styleRowChecking;
    }
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedRoomAndStyleDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();    	
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsAllRoomAndStyleListTakeFromDB(rommName);
	  	int totalConceptCount = 0;
	  	if (!admnRegConBdRoomStyleList.isEmpty()) {    		
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomStyleList) {    			
	  			String stylesNameDBList = admnRegConBdSavingModel.getStyle();
	  			String styleRowChecking = adminDesignerStyleNameCheckInDbUsingAdminSelectedStyleList(stylesNameDBList, styleNames);    			
	  			if(("Have").equals(styleRowChecking)) {
		    			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
		    			String conBoardsImage = null;
		    			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
		    	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
		    	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
		        		}
		    			admnRegConBdRoomImagesList.add(conBoardsImage);
		    			totalConceptCount = totalConceptCount + 1;
	  			}
	   	   }
	  	}
	  	mav = new ModelAndView();
	  	sn.setAttribute(adminDesignerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	  	sn.setAttribute(adminDesignerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	  	sn.setAttribute(adminDesignerRegTotalResultCount, totalConceptCount);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedRoomAndPriceDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String price) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsAllRoomsAndPriceListTakeFromDB(rommName, price);  	
	  	if (!admnRegConBdRoomsList.isEmpty()) {
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
	  			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	  			String conBoardsImage = null;
	  			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
	  	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
	  	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	  			admnRegConBdRoomImagesList.add(conBoardsImage);
	   	   }
	  	}
	  	mav = new ModelAndView();
	  	sn.setAttribute(adminDesignerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(adminDesignerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(adminDesignerRegTotalResultCount, admnRegConBdRoomsList.size());
	    return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedRoomDataOnlyTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsAllRoomListTakeFromDB(rommName);  	
	  	if (!admnRegConBdRoomsList.isEmpty()) {
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomsList) {
	  			admnRegConBdRoomIdsList.add(admnRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	  			String conBoardsImage = null;
	  			if(null != admnRegConBdSavingModel.getConceptBoardsImage()) {
	  	    		byte[] conBoardsImageFromDB = admnRegConBdSavingModel.getConceptBoardsImage();
	  	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	  			admnRegConBdRoomImagesList.add(conBoardsImage);
	   	   }
	  	}
	  	mav = new ModelAndView();
	  	sn.setAttribute(adminDesignerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(adminDesignerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(adminDesignerRegTotalResultCount, admnRegConBdRoomsList.size());
	    return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String rommName = req.getParameter(designerRegistryRoom);
	  	String styleValue = req.getParameter(designerRegistryStyle);
	  	String admnRegCheckValue = "";
	  	String priceValue = "";
	    if(null != req.getParameterValues(designerRegistryPrice)) {
	    	String[] checkBoxVal = req.getParameterValues(designerRegistryPrice);
	      	for (int i = 0; i < checkBoxVal.length; i++) {
	      		admnRegCheckValue = admnRegCheckValue + "," + checkBoxVal[i];
	      	}
	      	admnRegCheckValue = admnRegCheckValue.replaceFirst(",", "");
	      	priceValue = admnRegCheckValue.replace(",", "', '");
	    }
	    if((!("").equals(admnRegCheckValue)) && (!("").equals(styleValue))) {
	      	mav = adminDesignerSelectedRoomStyleAndPriceCombDataTakeFromDB(req, sn, rommName, styleValue, priceValue);
	  	} else if((!("").equals(admnRegCheckValue)) && (("").equals(styleValue))) {
	  		mav = adminDesignerSelectedRoomAndPriceDataTakeFromDB(req, sn, rommName, priceValue);
	  	} else if((("").equals(admnRegCheckValue)) && (!("").equals(styleValue))) {
	  		mav = adminDesignerSelectedRoomAndStyleDataTakeFromDB(req, sn, rommName, styleValue);
	  	} else {
	  		mav = adminDesignerSelectedRoomDataOnlyTakeFromDB(req, sn, rommName);
	  	}   	
	  	mav = new ModelAndView(adminDesignerRegistryConceptBoardsRed);
	  	mav.addObject(designerRegistryRoom, rommName);
	  	mav.addObject(designerRegistryStyle, styleValue);
	  	mav.addObject(designerRegistryPrice, admnRegCheckValue);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerUnCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String rommName = req.getParameter(designerRegistryRoom);
	  	mav = adminDesignerSelectedRoomDataOnlyTakeFromDB(req, sn, rommName);
	  	mav = new ModelAndView(adminDesignerRegistryConceptBoardsRed);
	  	mav.addObject(designerRegistryRoom, rommName);
	  	mav.addObject(designerRegistryStyle, null);
	  	mav.addObject(designerRegistryPrice, null);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedRoomAndStyleImageUploadInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
	   	String conceptImagesName1 = req.getParameter("conceptImagesName");
	   	if (null != conceptImagesName1) {
	   		long conceptBoardsSavingId = Long.parseLong(conceptImagesName1);
	   		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
	   	}
	   	String rommName = req.getParameter(designerRegistryRoom);
	   	sn.setAttribute(adminDesignerRegistryRoomInSn, rommName);	   	
	   	mav = adminDesignerRegistryModifyRoomRedirection(req, sn);
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRegistryModifyRoomRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
	  	String room = null;
	  	String style = null;
	  	String price = null;
	  	String mostPopular = null;
	  	String conBoardsImage = null;    	
	  	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB(conceptBoardsSavingId);
	  	room = admnRegConBdModel.getRoom();
	  	style = admnRegConBdModel.getStyle();
	  	price = admnRegConBdModel.getPrice();
	  	mostPopular = admnRegConBdModel.getMostPopularCB();
	  	long designerInfoSavingId = admnRegConBdModel.getDesignerInfoSavingId();
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
	  	if(null != admnRegConBdModel.getConceptBoardsImage()) {
		    	byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
		 	   	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	  	}
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);		
	  	mav = new ModelAndView(adminDesignerRegistryModifyRoomRedirect);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	mav.addObject(designerRegistryRoom, room);
	  	mav.addObject(designerRegistryStyle, style);
	  	mav.addObject(designerFullName, designersName);
	  	mav.addObject(designerRegistryPrice, price);
	  	mav.addObject(mostPopularCB, mostPopular);
	  	mav.addObject(conceptBoardsImage, conBoardsImage);
	  	mav.addObject(prodTotalCount, totalFurSpecsProductsList.size());
	  	return mav;
	}
	  
	@Override
	@Transactional
	public ModelAndView adminDesignerRegConceptBoardsManagement(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsManagementList();
	  	if(!admnRegConBdManList.isEmpty()){
	  		mav = adminDesignerRegConceptBoardsManagementDataDisplay(req, sn);
	  	} else {
	  		mav = adminDesignerRegistryConceptBoardsRedirection(req, sn);
	  	}
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerConceptBoardsDataModificationInDB(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String designerRegistryStyleValue = "";        
	    if(null != req.getParameterValues(designerRegistryStyle)) {
	     	String[] checkBoxVal = req.getParameterValues(designerRegistryStyle);
	      	for (int q = 0; q < checkBoxVal.length; q++) {
	      		designerRegistryStyleValue = designerRegistryStyleValue + "," + checkBoxVal[q];
	      	}
	      	designerRegistryStyleValue = designerRegistryStyleValue.replaceFirst(",", "");
	    }
	  	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
	  	AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB(conceptBoardsSavingId);    	
		adminRegConBdSavingModel.setRoom(req.getParameter(designerRegistryRoom));
		adminRegConBdSavingModel.setStyle(designerRegistryStyleValue);
		long designerInfoSavingId = adminRegConBdSavingModel.getDesignerInfoSavingId();
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
		adminRegConBdSavingModel.setDesignerName(designersName);
		adminRegConBdSavingModel.setPrice(req.getParameter(designerRegistryPrice));
		adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
		adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
		adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);	    
	  	mav = adminDesignerRegistryModifyRoomRedirection(req, sn);
	  	return mav;
	}
	
    @Override
    @Transactional
    public ModelAndView adminDesignerRegConceptBoardsManagementDataDisplay(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsManagementList();
		if(!admnRegConBdManList.isEmpty()){       	
	        List<AdminRegistryConceptBoardsSaving> admnRegConBdSavingList = new ArrayList<AdminRegistryConceptBoardsSaving>();
	        for (AdminRegistryConceptBoardsSaving admnRegConBdInfoLoop : admnRegConBdManList) {
	        	AdminRegistryConceptBoardsSaving admnRegConBdSavingModel = new AdminRegistryConceptBoardsSaving();            	           	
	        	admnRegConBdSavingModel.setAdminRegistryConceptBoardsSavingId(admnRegConBdInfoLoop.getAdminRegistryConceptBoardsSavingId());
	        	admnRegConBdSavingModel.setRoom(admnRegConBdInfoLoop.getRoom());
	        	admnRegConBdSavingModel.setStyle(admnRegConBdInfoLoop.getStyle());
	        	admnRegConBdSavingModel.setDesignerName(admnRegConBdInfoLoop.getDesignerName());
	        	admnRegConBdSavingModel.setPrice(admnRegConBdInfoLoop.getPrice());
	        	admnRegConBdSavingModel.setMostPopularCB(admnRegConBdInfoLoop.getMostPopularCB());
	        	admnRegConBdSavingModel.setFurnitureSpecsCount(admnRegConBdInfoLoop.getFurnitureSpecsCount());
	        	admnRegConBdSavingModel.setAdminApprovalStatus(admnRegConBdInfoLoop.getAdminApprovalStatus());
	        	admnRegConBdSavingModel.setCreatedDate(admnRegConBdInfoLoop.getCreatedDate());
	        	admnRegConBdSavingModel.setUpdatedDate(admnRegConBdInfoLoop.getUpdatedDate());
	        	admnRegConBdSavingList.add(admnRegConBdSavingModel);
	        }
	        mav = new ModelAndView(adminDesignerRegConceptBoardsManagementDisplay);
	        mav.addObject("designerRegConceptBoardsManagementSavingList", admnRegConBdSavingList);
	        mav.addObject("designerRegConceptBoardsManagementListCount", admnRegConBdManList.size());                       
	    } else{
	    	mav = adminDesignerRegistryConceptBoardsRedirection(req, sn);
	    }
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView adminDesignerRegConceptBoardsManagementRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;    	
		String admConBoardManagement = req.getParameter("admConBoardManagementId");
		String typeOfRoomSel = req.getParameter("typeOfRoomSelection");
		if(("Modified Room").equals(typeOfRoomSel)) {
			long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
			sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
			mav = adminDesignerRegistryModifyRoomRedirection(req, sn);
		} else if(("Deleted Room").equals(typeOfRoomSel)) {
			long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
			sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
			mav = adminDesignerRegistryDeleteRoomRedirection(req, sn, conceptBoardsSavingId);
		} else if(("Approved Status").equals(typeOfRoomSel)) {
			long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
			sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
			mav = adminDesignerRegistryApprovedStatusRedirection(req, sn, conceptBoardsSavingId);
		} else {
			sn.setAttribute(conceptBoardsSavingIdInSn, null);
			mav = adminDesignerRegistryConceptBoardsRedirection(req, sn);
		}    	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRegistryDeleteRoomRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId) {
	  	ModelAndView mav;
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
	  	for (AdminRegistryConceptBoardsFurnitureSpecsSaving admnRegConBdInfoLoop : totalFurSpecsProductsList) {
	  		AdminRegistryConceptBoardsFurnitureSpecsSaving removeFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerDeleteConBoardsFurnitureSpecsProductsInDB(admnRegConBdInfoLoop.getAdminRegistryConceptBoardsSavingId());
	      	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.delete(removeFurSpecsProductsList);
	  	}    	
	  	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB(conceptBoardsSavingId);
	  	adminRegistryConceptBoardsSavingDAO.delete(admnRegConBdModel);    	
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.designerConceptBoardsManagementList();
	  	if(!admnRegConBdManList.isEmpty()){
	  		mav = adminDesignerRegConceptBoardsManagementDataDisplay(req, sn);
	  	} else {
	  		sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  		mav = adminDesignerRegistryConceptBoardsRedirection(req, sn);
	  	}
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));   	
	  	return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminDesignerRegistryApprovedStatusRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId) {
	  	ModelAndView mav;
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
	  	for (AdminRegistryConceptBoardsFurnitureSpecsSaving admnRegConBdInfoLoop : totalFurSpecsProductsList) {
	  		admnRegConBdInfoLoop.setAdminApprovalStatus(approvedReff);
	      	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admnRegConBdInfoLoop);
	  	}    	
	  	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB(conceptBoardsSavingId);
	  	admnRegConBdModel.setAdminApprovalStatus(approvedReff);
	  	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);    	
	  	mav = adminDesignerRegConceptBoardsManagementDataDisplay(req, sn);	  	
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));   	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerConFurnitureSpecsDataDeleteFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(storeName);
		long productId = Long.parseLong(produtId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> delFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsInDB(productId);
		if (!delFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving delFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsDataTakeFromDB(productId);
			adminRegistryConceptBoardsFurnitureSpecsSavingDAO.delete(delFurSpecsProductsModel);
			sn.setAttribute(adminConFSProductsIdInSn, productId);
		}
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> deleteFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount((Long) sn.getAttribute(conceptBoardsSavingIdInSn));		
		if(deleteFurSpecsProductsList.size() == 0) {
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
			adminRegConBdSavingModel.setFurnitureSpecsStatus(null);
			adminRegConBdSavingModel.setAdminApprovalStatus(null);
			adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		} else {
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
			int furSpecsCount = adminRegConBdSavingModel.getFurnitureSpecsCount();
			int totalSpecsCount = furSpecsCount - 1;
			adminRegConBdSavingModel.setFurnitureSpecsCount(totalSpecsCount);
			adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		}
		mav = new ModelAndView("redirect:" + adminDesignerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerConFurnitureSpectsDataDisplayFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		List furnSpecApprStatusList = new ArrayList();
		int prodCount = 0;
		String admApprovalStatus = null;
		String admProductsAddedData = null;
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
		if (!totalFurSpecsProductsList.isEmpty()) {
	 		for (AdminRegistryConceptBoardsFurnitureSpecsSaving furnSpecsProductsSavingModel : totalFurSpecsProductsList) {
	 			furnSpecSavingIdList.add(furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId());
	 			furnSpecProductNameList.add(furnSpecsProductsSavingModel.getProductName());
	 			furnSpecApprStatusList.add(furnSpecsProductsSavingModel.getAdminApprovalStatus());
	 			admApprovalStatus = furnSpecsProductsSavingModel.getAdminApprovalStatus();
	 			int count = 1;
	 			prodCount = prodCount + count;
	 			admProductsAddedData = furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsSavingId() + "__" + furnSpecsProductsSavingModel.getAdminDesignerCommonReferenceId() + "__" + furnSpecsProductsSavingModel.getAdminDesignerCommonReferenceName() + "__" + furnSpecsProductsSavingModel.getAdminApprovalStatus(); 
	 		}		
	 		mav = new ModelAndView(adminDesignerConFurnitureSpectsDisplay);
	 		sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	 		sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	 		sn.setAttribute(furn_Spec_Approval_Status_List, furnSpecApprStatusList);
	 		mav.addObject(prodTotalCount, prodCount);
	 		mav.addObject(adminApprovalStatus, admApprovalStatus);
	 		mav.addObject(adminProductsAddedData, admProductsAddedData);
 		} else{
 			mav = adminDesignerRegistryConceptBoardsRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		sn.setAttribute(adminConFSProductsIdInSn, null);
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRedConFurnitureSpectsEditProductsRed(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter("storeURL");
		long productId = Long.parseLong(produtId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> ediFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsInDB(productId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving ediFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsDataTakeFromDB(productId);		
	    	String prodName = ediFurSpecsProductsModel.getProductName();	    	
	    	String headName1 = ediFurSpecsProductsModel.getProductSize1();
	    	String headName2 = ediFurSpecsProductsModel.getProductSize2();
	    	String headName3 = ediFurSpecsProductsModel.getProductSize3();
	    	String headName4 = ediFurSpecsProductsModel.getProductSize4();
	    	String headName5 = ediFurSpecsProductsModel.getProductSize5();
	    	String prodDesc1 = ediFurSpecsProductsModel.getProductDescription1();
	    	String prodPrice1 = ediFurSpecsProductsModel.getProductPrice1();
	    	String prodPrice2 = ediFurSpecsProductsModel.getProductPrice2();
	    	String prodPrice3 = ediFurSpecsProductsModel.getProductPrice3();
	    	String prodPrice4 = ediFurSpecsProductsModel.getProductPrice4();
	    	String prodPrice5 = ediFurSpecsProductsModel.getProductPrice5();
	    	String strName = ediFurSpecsProductsModel.getStoreName();
	    	String brandsName = ediFurSpecsProductsModel.getBrandName();
	    	String strUrl = ediFurSpecsProductsModel.getStoreUrl();
	    	String skuNames = ediFurSpecsProductsModel.getSkuName();
	    	String productsImage1 = null;
	    	String productsImage2 = null;
	    	String productsImage3 = null;
	    	String productsImage4 = null;
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage1()) {
		    	byte[] productImgFromDB1 = ediFurSpecsProductsModel.getProductUploadedImage1();
				productsImage1 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB1);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage2()) {
				byte[] productImgFromDB2 = ediFurSpecsProductsModel.getProductUploadedImage2();
				productsImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB2);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage3()) {
				byte[] productImgFromDB3 = ediFurSpecsProductsModel.getProductUploadedImage3();
				productsImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB3);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage4()) {
				byte[] productImgFromDB4 = ediFurSpecsProductsModel.getProductUploadedImage4();
				productsImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB4);
	    	}
	    	mav = new ModelAndView(adminDesignerConFurnitureSpectsEdit);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productSize1, headName1);
	    	mav.addObject(productSize2, headName2);
	    	mav.addObject(productSize3, headName3);
	    	mav.addObject(productSize4, headName4);
	    	mav.addObject(productSize5, headName5);
	    	mav.addObject(productDescription1, prodDesc1);
	    	mav.addObject(productPrice1, prodPrice1);
	    	mav.addObject(productPrice2, prodPrice2);
	    	mav.addObject(productPrice3, prodPrice3);
	    	mav.addObject(productPrice4, prodPrice4);
	    	mav.addObject(productPrice5, prodPrice5);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(brandName, brandsName);
	    	mav.addObject(storeUrl, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productUploadedImage1, productsImage1);
			mav.addObject(productUploadedImage2, productsImage2);
			mav.addObject(productUploadedImage3, productsImage3);
			mav.addObject(productUploadedImage4, productsImage4);	    	
	    	sn.setAttribute(adminConFSProductsIdInSn, productId);	    	
		} else {
			mav = new ModelAndView("redirect:" + adminDesignerConFurSpectsDataDisplayRed);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminDesignerRedConFurnitureSpectsAddNewProductsRed(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(adminDesignerConFurnitureSpectsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(adminProductsAddedData, req.getParameter(adminProductsAddedData));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminDesignerConFurnitureSpecsUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;   		
		String fileName1 = productUploadedImage1.getOriginalFilename();
		String fileName2 = productUploadedImage2.getOriginalFilename();
		String fileName3 = productUploadedImage3.getOriginalFilename();
		String fileName4 = productUploadedImage4.getOriginalFilename();   		
		byte[] bFile1 = null;
		byte[] bFile2 = null;
		byte[] bFile3 = null;
		byte[] bFile4 = null;   		
		if((null != fileName1) && ("" != fileName1)) {
			String filepath1 = uploadImgPath + fileName1;	
	   		File conFile1 = new File(filepath1);
	   		conFile1.mkdir();    
	   		productUploadedImage1.transferTo(conFile1);        
	   		bFile1 = new byte[(int) conFile1.length()];
	   		try {
	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
	   			fileInputStream1.read(bFile1);
	   			fileInputStream1.close();   	   			
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName2) && ("" != fileName2)) {
			String filepath2 = uploadImgPath + fileName2;	
	   		File conFile2 = new File(filepath2);
	   		conFile2.mkdir();    
	   		productUploadedImage2.transferTo(conFile2);        
	   		bFile2 = new byte[(int) conFile2.length()];
	   		try {
	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
	   			fileInputStream2.read(bFile2);
	   			fileInputStream2.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName3) && ("" != fileName3)) {
			String filepath3 = uploadImgPath + fileName3;	
	   		File conFile3 = new File(filepath3);
	   		conFile3.mkdir();    
	   		productUploadedImage3.transferTo(conFile3);        
	   		bFile3 = new byte[(int) conFile3.length()];
	   		try {
	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
	   			fileInputStream3.read(bFile3);
	   			fileInputStream3.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName4) && ("" != fileName4)) {
			String filepath4 = uploadImgPath + fileName4;	
	   		File conFile4 = new File(filepath4);
	   		conFile4.mkdir();    
	   		productUploadedImage4.transferTo(conFile4);        
	   		bFile4 = new byte[(int) conFile4.length()];
	   		try {
	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
	   			fileInputStream4.read(bFile4);
	   			fileInputStream4.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		String admProductsAddedData = req.getParameter(adminProductsAddedData);
		String[] admnProductsAddedData = admProductsAddedData.split("__");
		long conceptBoardsSavingId = Long.parseLong(admnProductsAddedData[0]);
		long designerInfoSavingId = Long.parseLong(admnProductsAddedData[1]);		
		Timestamp currentDate = currentDate();		
		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = new AdminRegistryConceptBoardsFurnitureSpecsSaving();		
		admRegFurnitureSpecsSaving.setAdminRegistryConceptBoardsSavingId(conceptBoardsSavingId);
		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceId(designerInfoSavingId);
		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceName(admnProductsAddedData[2]);
		admRegFurnitureSpecsSaving.setAdminApprovalStatus(admnProductsAddedData[3]);
		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));   		
		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
		admRegFurnitureSpecsSaving.setFurnitureSpecsStatus(adminDoneStatus);   		
		admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
		admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
		admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
		admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
		admRegFurnitureSpecsSaving.setCreatedDate(currentDate);
		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.save(admRegFurnitureSpecsSaving);
		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedAdminAndDesnRegConBoardsImageInDB(conceptBoardsSavingId, designerInfoSavingId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsCountList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
		admnRegConBdModel.setFurnitureSpecsStatus(adminDoneStatus);
		admnRegConBdModel.setFurnitureSpecsCount(totalFurSpecsCountList.size());
		admRegFurnitureSpecsSaving.setAdminStockCheckStatus(availableStatus);
		adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
		mav = new ModelAndView("redirect:" + adminDesignerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn)); 
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerConFurnitureSpectsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
	  	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
	  	if(!totalFurSpecsProductsList.isEmpty()){
	  		mav = new ModelAndView("redirect:" + adminDesignerConFurSpectsDataDisplayRed);
	  	} else {
	  		mav = adminDesignerRegistryConceptBoardsRedirection(req, sn);
	  	}    	
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	      return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRedConceptSpcBoardModificationUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
	  	ModelAndView mav;        
	  	String fileName = imageUpload.getOriginalFilename();
		String filepath = uploadImgPath + fileName;
		File conFile = new File(filepath);
	   	conFile.mkdir();        
	   	imageUpload.transferTo(conFile);
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
		if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
			long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
			AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB(conceptBoardsSavingId);
		   	admnRegConBdModel.setConceptBoardsImage(bFile);
		  	admnRegConBdModel.setUpdatedDate(currentDate);
		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
		} 	   
		mav = adminDesignerRegistryModifyRoomRedirection(req, sn);
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRedConFurnitureSpectsProdApprovalInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(brandName);
		long productId = Long.parseLong(produtId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> delFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsInDB(productId);
		if (!delFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving delFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsDataTakeFromDB(productId);
			delFurSpecsProductsModel.setAdminApprovalStatus(approvedReff);
			adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(delFurSpecsProductsModel);
			sn.setAttribute(adminConFSProductsIdInSn, productId);
		}		
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> approvalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecApprovalList((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
		if(approvalFurSpecsProductsList.size() == 0) {
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
			adminRegConBdSavingModel.setAdminApprovalStatus(approvedReff);
			adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		}
		mav = new ModelAndView("redirect:" + adminDesignerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
		
//	Finishing Touches Coding
		
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List admnRegFinishingTouchesIdsList = new ArrayList();
	  	List admnRegFinishingTouchesImagesList = new ArrayList();    	
	  	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinishingTouchesList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFTFurnitureSpecEditProductsInDB();
	  	if (!admnRegFinishingTouchesList.isEmpty()) {
	  		for (AdminRegistryFinishingTouchesProductsInfoSaving admnRegFinishingTouchesModel : admnRegFinishingTouchesList) {
	  			admnRegFinishingTouchesIdsList.add(admnRegFinishingTouchesModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
	  			String admnRegFTImage = null;
	  			if(null != admnRegFinishingTouchesModel.getProductUploadedImage1()) {
	  	    		byte[] conBoardsImageFromDB = admnRegFinishingTouchesModel.getProductUploadedImage1();
	  	    		admnRegFTImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	  			admnRegFinishingTouchesImagesList.add(admnRegFTImage);
	   	   }
	  	}
	  	mav = new ModelAndView(adminDesignerRegistryFinishingTouchesHome);
	  	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
	  	sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
	  	sn.setAttribute(adminDesignerRegTotalResultCount, admnRegFinishingTouchesList.size());
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	mav.addObject(designerRegistryRoom, req.getParameter(designerRegistryRoom));
	  	mav.addObject(designerRegistryStyle, req.getParameter(designerRegistryStyle));
	  	mav.addObject(designerRegistryPrice, req.getParameter(designerRegistryPrice));
	  	mav.addObject(finishingTouchesRBName, req.getParameter(finishingTouchesRBName));
	  	mav.addObject(finishingTouchesCBName, req.getParameter(finishingTouchesCBName));
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRegistryFinishingTouchesUploadRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFinishingTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFTFurnitureSpecEditProductsInDB();
	  	if(!totalFinishingTouchesProductsList.isEmpty()){
	  		mav = new ModelAndView("redirect:" + redirectAdminDesignerFinishingTouchesDisplay);
	  	} else {
	  		mav = backToAdminDesignerFinishingTouchesRedirection(req, sn);
	  	}    	
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView redirectAdminDesignerFinishingTouchesDisplayRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		List finiTouchesIdList = new ArrayList();
		List finiTouchesProductNameList = new ArrayList();
		List finiTouchesApprStatusList = new ArrayList();
		int prodCount = 0;
		List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFinishingTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFTFurnitureSpecEditProductsInDB();
		if (!totalFinishingTouchesProductsList.isEmpty()) {
	 		for (AdminRegistryFinishingTouchesProductsInfoSaving finishingTouchesSavingModel : totalFinishingTouchesProductsList) {
	 			finiTouchesIdList.add(finishingTouchesSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
	 			finiTouchesProductNameList.add(finishingTouchesSavingModel.getProductName());
	 			finiTouchesApprStatusList.add(finishingTouchesSavingModel.getAdminApprovalStatus());
	 			int count = 1;
	 			prodCount = prodCount + count;
	 		}		
	 		mav = new ModelAndView(adminDesignerRegistryFinishingTouchesDisplay);
	 		sn.setAttribute(finishingTouchesIdList, finiTouchesIdList);
	 		sn.setAttribute(finishingTouchesProductNameList, finiTouchesProductNameList);
	 		sn.setAttribute(finishingTouchesApprovedStatusList, finiTouchesApprStatusList);
	 		mav.addObject(prodTotalCount, prodCount);	 		
 		} else{
 			mav = backToAdminDesignerFinishingTouchesRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, null);
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedCBFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String adminFTCBValues = "";    	
	    if(null != req.getParameterValues(designerFTCBValuesList)) {
	    	String[] checkBoxVal = req.getParameterValues(designerFTCBValuesList);
	      	for (int i = 0; i < checkBoxVal.length; i++) {
	      		adminFTCBValues = adminFTCBValues + "," + checkBoxVal[i];
	      	}
	      	adminFTCBValues = adminFTCBValues.replaceFirst(",", "");        	
	    }
	    if(!("").equals(adminFTCBValues)) {
	      	String adminFTCBFormatValue = adminFTCBValues.replace(",", "', '");
	      	mav = adminDesignerRegSelectedCheckBoxFinishingTouchesList(req, sn, adminFTCBFormatValue);
	  	}    	
	  	mav = new ModelAndView(adminDesignerRegistryFinishingTouchesHome);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	mav.addObject(designerRegistryRoom, req.getParameter(designerRegistryRoom));
	  	mav.addObject(designerRegistryStyle, req.getParameter(designerRegistryStyle));
	  	mav.addObject(designerRegistryPrice, req.getParameter(designerRegistryPrice));
	  	mav.addObject(finishingTouchesRBName, req.getParameter(finishingTouchesRBName));
	  	mav.addObject(finishingTouchesCBName, adminFTCBValues);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerRegSelectedCheckBoxFinishingTouchesList(HttpServletRequest req, HttpSession sn, String prodCategory) {
	  	ModelAndView mav;
	  	List admnRegFinishingTouchesIdsList = new ArrayList();
	  	List admnRegFinishingTouchesImagesList = new ArrayList();    	
	  	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinishingTouchesList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerSelectedCheckBoxFinishingTouchesListFromDB(prodCategory);
	  	if (!admnRegFinishingTouchesList.isEmpty()) {
	  		for (AdminRegistryFinishingTouchesProductsInfoSaving admnRegFinishingTouchesModel : admnRegFinishingTouchesList) {
	  			admnRegFinishingTouchesIdsList.add(admnRegFinishingTouchesModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
	  			String admnRegFTImage = null;
	  			if(null != admnRegFinishingTouchesModel.getProductUploadedImage1()) {
	  	    		byte[] conBoardsImageFromDB = admnRegFinishingTouchesModel.getProductUploadedImage1();
	  	    		admnRegFTImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	  			admnRegFinishingTouchesImagesList.add(admnRegFTImage);
	   	   }
	  	}
	  	mav = new ModelAndView();
	  	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
	  	sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
	  	sn.setAttribute(adminDesignerRegTotalResultCount, admnRegFinishingTouchesList.size());            	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView backToAdminDesignerFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List admnRegFinishingTouchesIdsList = new ArrayList();
	  	List admnRegFinishingTouchesImagesList = new ArrayList();    	
	  	List<AdminRegistryFinishingTouchesProductsInfoSaving> admnRegFinishingTouchesList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFTFurnitureSpecEditProductsInDB();
	  	if (!admnRegFinishingTouchesList.isEmpty()) {
	  		for (AdminRegistryFinishingTouchesProductsInfoSaving admnRegFinishingTouchesModel : admnRegFinishingTouchesList) {
	  			admnRegFinishingTouchesIdsList.add(admnRegFinishingTouchesModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
	  			String admnRegFTImage = null;
	  			if(null != admnRegFinishingTouchesModel.getProductUploadedImage1()) {
	  	    		byte[] conBoardsImageFromDB = admnRegFinishingTouchesModel.getProductUploadedImage1();
	  	    		admnRegFTImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	  			admnRegFinishingTouchesImagesList.add(admnRegFTImage);
	   	   }
	  	}
	  	mav = new ModelAndView(adminDesignerRegistryFinishingTouchesHome);
	  	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
	  	sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
	  	sn.setAttribute(adminDesignerRegTotalResultCount, admnRegFinishingTouchesList.size());
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
	  	mav.addObject(finishingTouchesRBName, "Finishing Touches");
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedFinishingTouchesImageEditInDB(HttpServletRequest req, HttpSession sn) {
  	ModelAndView mav;
	   	String finishingTouchesImage1 = req.getParameter("finishingTouchesImage");
	   	if (null != finishingTouchesImage1) {
	   		long finishingTouchesImageId = Long.parseLong(finishingTouchesImage1);
	   		sn.setAttribute(finishingTouchesImageIdInSn, finishingTouchesImageId);
	   		mav = adminDesignerSelectedFinishingTouchesImageEditRedirection(req, sn, finishingTouchesImageId);
	   	} else {	   		   	
	   		mav = backToAdminDesignerFinishingTouchesRedirection(req, sn);
	   	}
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerSelectedFinishingTouchesImageEditRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId) {
		ModelAndView mav;		
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
	    	String prodCategory = ediFurSpecsProductsModel.getProductCategory();
	    	String prodName = ediFurSpecsProductsModel.getProductName();
	    	String headName1 = ediFurSpecsProductsModel.getProductSize1();
	    	String headName2 = ediFurSpecsProductsModel.getProductSize2();
	    	String headName3 = ediFurSpecsProductsModel.getProductSize3();
	    	String headName4 = ediFurSpecsProductsModel.getProductSize4();
	    	String headName5 = ediFurSpecsProductsModel.getProductSize5();
	    	String prodDesc1 = ediFurSpecsProductsModel.getProductDescription1();
	    	String prodPrice1 = ediFurSpecsProductsModel.getProductPrice1();
	    	String prodPrice2 = ediFurSpecsProductsModel.getProductPrice2();
	    	String prodPrice3 = ediFurSpecsProductsModel.getProductPrice3();
	    	String prodPrice4 = ediFurSpecsProductsModel.getProductPrice4();
	    	String prodPrice5 = ediFurSpecsProductsModel.getProductPrice5();
	    	String strName = ediFurSpecsProductsModel.getStoreName();
	    	String brandsName = ediFurSpecsProductsModel.getBrandName();
	    	String strUrl = ediFurSpecsProductsModel.getStoreUrl();
	    	String skuNames = ediFurSpecsProductsModel.getSkuName();
	    	String productsImage1 = null;
	    	String productsImage2 = null;
	    	String productsImage3 = null;
	    	String productsImage4 = null;
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage1()) {
		    	byte[] productImgFromDB1 = ediFurSpecsProductsModel.getProductUploadedImage1();
				productsImage1 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB1);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage2()) {
				byte[] productImgFromDB2 = ediFurSpecsProductsModel.getProductUploadedImage2();
				productsImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB2);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage3()) {
				byte[] productImgFromDB3 = ediFurSpecsProductsModel.getProductUploadedImage3();
				productsImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB3);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage4()) {
				byte[] productImgFromDB4 = ediFurSpecsProductsModel.getProductUploadedImage4();
				productsImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB4);
	    	}
	    	mav = new ModelAndView(adminDesignerRegistryFinishingTouchesEdit);
	    	mav.addObject(productCategory, prodCategory);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productSize1, headName1);
	    	mav.addObject(productSize2, headName2);
	    	mav.addObject(productSize3, headName3);
	    	mav.addObject(productSize4, headName4);
	    	mav.addObject(productSize5, headName5);
	    	mav.addObject(productDescription1, prodDesc1);
	    	mav.addObject(productPrice1, prodPrice1);
	    	mav.addObject(productPrice2, prodPrice2);
	    	mav.addObject(productPrice3, prodPrice3);
	    	mav.addObject(productPrice4, prodPrice4);
	    	mav.addObject(productPrice5, prodPrice5);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(brandName, brandsName);
	    	mav.addObject(storeUrl, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productUploadedImage1, productsImage1);
			mav.addObject(productUploadedImage2, productsImage2);
			mav.addObject(productUploadedImage3, productsImage3);
			mav.addObject(productUploadedImage4, productsImage4);	    	
	    	sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);	    	
		} else {
			mav = new ModelAndView("redirect:" + redirectAdminDesignerFinishingTouchesDisplay);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerConFurnitureSpecsModifiedDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;   		   		
		String fileName1 = productUploadedImage1.getOriginalFilename();
		String fileName2 = productUploadedImage2.getOriginalFilename();
		String fileName3 = productUploadedImage3.getOriginalFilename();
		String fileName4 = productUploadedImage4.getOriginalFilename();   		
		byte[] bFile1 = null;
		byte[] bFile2 = null;
		byte[] bFile3 = null;
		byte[] bFile4 = null;   		
		if((null != fileName1) && ("" != fileName1)) {
			String filepath1 = uploadImgPath + fileName1;	
	   		File conFile1 = new File(filepath1);
	   		conFile1.mkdir();    
	   		productUploadedImage1.transferTo(conFile1);        
	   		bFile1 = new byte[(int) conFile1.length()];
	   		try {
	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
	   			fileInputStream1.read(bFile1);
	   			fileInputStream1.close();   	   			
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName2) && ("" != fileName2)) {
			String filepath2 = uploadImgPath + fileName2;	
	   		File conFile2 = new File(filepath2);
	   		conFile2.mkdir();    
	   		productUploadedImage2.transferTo(conFile2);        
	   		bFile2 = new byte[(int) conFile2.length()];
	   		try {
	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
	   			fileInputStream2.read(bFile2);
	   			fileInputStream2.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName3) && ("" != fileName3)) {
			String filepath3 = uploadImgPath + fileName3;	
	   		File conFile3 = new File(filepath3);
	   		conFile3.mkdir();    
	   		productUploadedImage3.transferTo(conFile3);        
	   		bFile3 = new byte[(int) conFile3.length()];
	   		try {
	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
	   			fileInputStream3.read(bFile3);
	   			fileInputStream3.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName4) && ("" != fileName4)) {
			String filepath4 = uploadImgPath + fileName4;	
	   		File conFile4 = new File(filepath4);
	   		conFile4.mkdir();    
	   		productUploadedImage4.transferTo(conFile4);        
	   		bFile4 = new byte[(int) conFile4.length()];
	   		try {
	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
	   			fileInputStream4.read(bFile4);
	   			fileInputStream4.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		String editFileName1 = req.getParameter(productUploadImage1);
		String editFileName2 = req.getParameter(productUploadImage2);
		String editFileName3 = req.getParameter(productUploadImage3);
		String editFileName4 = req.getParameter(productUploadImage4);   		
		Timestamp currentDate = currentDate();
		long adminConFSProductsId = (Long) sn.getAttribute(adminConFSProductsIdInSn);
		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsDataTakeFromDB(adminConFSProductsId);   		
		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));
		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
		admRegFurnitureSpecsSaving.setFurnitureSpecsStatus(adminDoneStatus);   		
		admRegFurnitureSpecsSaving.setUpdatedDate(currentDate);
		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = adminDesignerConFurnitureSpecsEditdDataUpdateInDB(req, sn, adminConFSProductsId, bFile1, bFile2, bFile3, bFile4, editFileName1, editFileName2, editFileName3, editFileName4);
		long conceptBoardsSavingId = admRegFurnitureSpecsSaving.getAdminRegistryConceptBoardsSavingId();
		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
		mav = new ModelAndView("redirect:" + adminDesignerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));       
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerConFurnitureSpecsEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminConFSProductsId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4) {
		ModelAndView mav;		
		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegFurnitureSpecEditProductsDataTakeFromDB(adminConFSProductsId);
		if(null != bFile1) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
   		}
   		if(null != bFile2) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
   		}
   		if(null != bFile3) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
   		}
   		if(null != bFile4) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
   		}   		
   		if(("").equals(editFileName1)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage1(null);
	   	}
   		if(("").equals(editFileName2)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage2(null);
	   	}
   		if(("").equals(editFileName3)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage3(null);
	   	}
   		if(("").equals(editFileName4)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage4(null);
	   	}
   		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = new ModelAndView();
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminDesignerFinishingTouchesDataDeleteFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(storeName);
		long adminRegFinishingTouchesSavingId = Long.parseLong(produtId);
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
			adminRegistryFinishingTouchesProductsInfoSavingDAO.delete(ediFurSpecsProductsModel);
			sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);			
		}
		mav = new ModelAndView("redirect:" + redirectAdminDesignerFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerFinishingTouchesEditProductsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String produtId = req.getParameter("finishingTouchesSavingId");
		long adminRegFinishingTouchesSavingId = Long.parseLong(produtId);
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
	    	String prodCategory = ediFurSpecsProductsModel.getProductCategory();
	    	String prodName = ediFurSpecsProductsModel.getProductName();
	    	String headName1 = ediFurSpecsProductsModel.getProductSize1();
	    	String headName2 = ediFurSpecsProductsModel.getProductSize2();
	    	String headName3 = ediFurSpecsProductsModel.getProductSize3();
	    	String headName4 = ediFurSpecsProductsModel.getProductSize4();
	    	String headName5 = ediFurSpecsProductsModel.getProductSize5();
	    	String prodDesc1 = ediFurSpecsProductsModel.getProductDescription1();
	    	String prodPrice1 = ediFurSpecsProductsModel.getProductPrice1();
	    	String prodPrice2 = ediFurSpecsProductsModel.getProductPrice2();
	    	String prodPrice3 = ediFurSpecsProductsModel.getProductPrice3();
	    	String prodPrice4 = ediFurSpecsProductsModel.getProductPrice4();
	    	String prodPrice5 = ediFurSpecsProductsModel.getProductPrice5();
	    	String strName = ediFurSpecsProductsModel.getStoreName();
	    	String brandsName = ediFurSpecsProductsModel.getBrandName();
	    	String strUrl = ediFurSpecsProductsModel.getStoreUrl();
	    	String skuNames = ediFurSpecsProductsModel.getSkuName();
	    	String productsImage1 = null;
	    	String productsImage2 = null;
	    	String productsImage3 = null;
	    	String productsImage4 = null;
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage1()) {
		    	byte[] productImgFromDB1 = ediFurSpecsProductsModel.getProductUploadedImage1();
				productsImage1 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB1);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage2()) {
				byte[] productImgFromDB2 = ediFurSpecsProductsModel.getProductUploadedImage2();
				productsImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB2);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage3()) {
				byte[] productImgFromDB3 = ediFurSpecsProductsModel.getProductUploadedImage3();
				productsImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB3);
	    	}
	    	if(null != ediFurSpecsProductsModel.getProductUploadedImage4()) {
				byte[] productImgFromDB4 = ediFurSpecsProductsModel.getProductUploadedImage4();
				productsImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(productImgFromDB4);
	    	}
	    	mav = new ModelAndView(adminDesignerRegistryFinishingTouchesEdit);
	    	mav.addObject(productCategory, prodCategory);
	    	mav.addObject(productName, prodName);
	    	mav.addObject(productSize1, headName1);
	    	mav.addObject(productSize2, headName2);
	    	mav.addObject(productSize3, headName3);
	    	mav.addObject(productSize4, headName4);
	    	mav.addObject(productSize5, headName5);
	    	mav.addObject(productDescription1, prodDesc1);
	    	mav.addObject(productPrice1, prodPrice1);
	    	mav.addObject(productPrice2, prodPrice2);
	    	mav.addObject(productPrice3, prodPrice3);
	    	mav.addObject(productPrice4, prodPrice4);
	    	mav.addObject(productPrice5, prodPrice5);
	    	mav.addObject(storeName, strName);
	    	mav.addObject(brandName, brandsName);
	    	mav.addObject(storeUrl, strUrl);
	    	mav.addObject(skuName, skuNames);
			mav.addObject(productUploadedImage1, productsImage1);
			mav.addObject(productUploadedImage2, productsImage2);
			mav.addObject(productUploadedImage3, productsImage3);
			mav.addObject(productUploadedImage4, productsImage4);	    	
	    	sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);	    	
		} else {
			mav = new ModelAndView("redirect:" + redirectAdminDesignerFinishingTouchesDisplay);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerFinishingTouchesModifiedDataUpdateInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		ModelAndView mav;		   		
		String fileName1 = productUploadedImage1.getOriginalFilename();
		String fileName2 = productUploadedImage2.getOriginalFilename();
		String fileName3 = productUploadedImage3.getOriginalFilename();
		String fileName4 = productUploadedImage4.getOriginalFilename();   		
		byte[] bFile1 = null;
		byte[] bFile2 = null;
		byte[] bFile3 = null;
		byte[] bFile4 = null;   		
		if((null != fileName1) && ("" != fileName1)) {
			String filepath1 = uploadImgPath + fileName1;	
	   		File conFile1 = new File(filepath1);
	   		conFile1.mkdir();    
	   		productUploadedImage1.transferTo(conFile1);        
	   		bFile1 = new byte[(int) conFile1.length()];
	   		try {
	   			FileInputStream fileInputStream1 = new FileInputStream(conFile1);
	   			fileInputStream1.read(bFile1);
	   			fileInputStream1.close();   	   			
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName2) && ("" != fileName2)) {
			String filepath2 = uploadImgPath + fileName2;	
	   		File conFile2 = new File(filepath2);
	   		conFile2.mkdir();    
	   		productUploadedImage2.transferTo(conFile2);        
	   		bFile2 = new byte[(int) conFile2.length()];
	   		try {
	   			FileInputStream fileInputStream2 = new FileInputStream(conFile2);
	   			fileInputStream2.read(bFile2);
	   			fileInputStream2.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName3) && ("" != fileName3)) {
			String filepath3 = uploadImgPath + fileName3;	
	   		File conFile3 = new File(filepath3);
	   		conFile3.mkdir();    
	   		productUploadedImage3.transferTo(conFile3);        
	   		bFile3 = new byte[(int) conFile3.length()];
	   		try {
	   			FileInputStream fileInputStream3 = new FileInputStream(conFile3);
	   			fileInputStream3.read(bFile3);
	   			fileInputStream3.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		if((null != fileName4) && ("" != fileName4)) {
			String filepath4 = uploadImgPath + fileName4;	
	   		File conFile4 = new File(filepath4);
	   		conFile4.mkdir();    
	   		productUploadedImage4.transferTo(conFile4);        
	   		bFile4 = new byte[(int) conFile4.length()];
	   		try {
	   			FileInputStream fileInputStream4 = new FileInputStream(conFile4);
	   			fileInputStream4.read(bFile4);
	   			fileInputStream4.close();
	   		} 
	   		catch (Exception e) {
	   			LOGGER.error("Blog Exception: "+e);
	   		}
		}
		String editFileName1 = req.getParameter(productUploadImage1);
		String editFileName2 = req.getParameter(productUploadImage2);
		String editFileName3 = req.getParameter(productUploadImage3);
		String editFileName4 = req.getParameter(productUploadImage4);   		
		Timestamp currentDate = currentDate();
		long adminRegFinishingTouchesSavingId = (Long) sn.getAttribute(adminRegFinishingTouchesSavingIdInSn);
		AdminRegistryFinishingTouchesProductsInfoSaving admRegFurnitureSpecsSaving = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);
		admRegFurnitureSpecsSaving.setProductCategory(req.getParameter(productCategory));
		admRegFurnitureSpecsSaving.setProductName(req.getParameter(productName));
		admRegFurnitureSpecsSaving.setProductSize1(req.getParameter(productSize1));
		admRegFurnitureSpecsSaving.setProductSize2(req.getParameter(productSize2));
		admRegFurnitureSpecsSaving.setProductSize3(req.getParameter(productSize3));
		admRegFurnitureSpecsSaving.setProductSize4(req.getParameter(productSize4));
		admRegFurnitureSpecsSaving.setProductSize5(req.getParameter(productSize5));
		admRegFurnitureSpecsSaving.setProductDescription1(req.getParameter(productDescription1));
		admRegFurnitureSpecsSaving.setProductPrice1(req.getParameter(productPrice1));
		admRegFurnitureSpecsSaving.setProductPrice2(req.getParameter(productPrice2));
		admRegFurnitureSpecsSaving.setProductPrice3(req.getParameter(productPrice3));
		admRegFurnitureSpecsSaving.setProductPrice4(req.getParameter(productPrice4));
		admRegFurnitureSpecsSaving.setProductPrice5(req.getParameter(productPrice5));
		admRegFurnitureSpecsSaving.setStoreName(req.getParameter(storeName));
		admRegFurnitureSpecsSaving.setBrandName(req.getParameter(brandName));
		admRegFurnitureSpecsSaving.setStoreUrl(req.getParameter(storeUrl));
		admRegFurnitureSpecsSaving.setSkuName(req.getParameter(skuName));
		admRegFurnitureSpecsSaving.setFinishingTouchesStatus(adminDoneStatus);   		
		admRegFurnitureSpecsSaving.setUpdatedDate(currentDate);
		adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = adminDesignerFinishingTouchesImagesEditdDataUpdateInDB(req, sn, adminRegFinishingTouchesSavingId, bFile1, bFile2, bFile3, bFile4, editFileName1, editFileName2, editFileName3, editFileName4);
		mav = new ModelAndView("redirect:" + redirectAdminDesignerFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));       
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView adminDesignerFinishingTouchesImagesEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4) {
		ModelAndView mav;
		AdminRegistryFinishingTouchesProductsInfoSaving admRegFurnitureSpecsSaving = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);
		if(null != bFile1) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
   		}
   		if(null != bFile2) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
   		}
   		if(null != bFile3) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
   		}
   		if(null != bFile4) {
   			admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
   		}   		
   		if(("").equals(editFileName1)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage1(null);
	   	}
   		if(("").equals(editFileName2)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage2(null);
	   	}
   		if(("").equals(editFileName3)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage3(null);
	   	}
   		if(("").equals(editFileName4)) {
	   		admRegFurnitureSpecsSaving.setProductUploadedImage4(null);
	   	}
   		adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = new ModelAndView();
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView adminDesignerRedFinishingTouchesSpectsProdApprovalInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(brandName);
		long adminRegFinishingTouchesSavingId = Long.parseLong(produtId);
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);
			ediFurSpecsProductsModel.setAdminApprovalStatus(approvedReff);
			adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(ediFurSpecsProductsModel);			
		}		
		List<AdminRegistryFinishingTouchesProductsInfoSaving> approvalFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesApprovalStatusInDB(adminRegFinishingTouchesSavingId);
		if(approvalFurSpecsProductsList.size() == 0) {
			AdminRegistryFinishingTouchesProductsInfoSaving apprFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);
			apprFurSpecsProductsModel.setAdminApprovalStatus(approvedReff);
			adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(apprFurSpecsProductsModel);
		}
		mav = new ModelAndView("redirect:" + redirectAdminDesignerFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
//     
//    @Override
//    @Transactional
//    public ModelAndView adminStockCheckPriceUpdateInDB(HttpServletRequest req, HttpSession sn) throws IOException {
//    	ModelAndView mav;
//    	Document doc = Jsoup.connect("https://www.shadesoflight.com/products/brianna-9-light-chandelier-by-ellen-degeneres?color=Polished+Nickel").timeout(6000).get();
////    	Elements title = doc.select(".header-container .product-name");
//    	//Elements price = doc.select(".header-container .regPrice");
//    	Elements spans = doc.select("span");
//    	String spanList = spans.text();
//    	System.out.println("spanList ############### :"+spanList);
//    	spanList = spanList.replace(" $", ", ");
//    	String[] spanListVal = spanList.split(", ");
//    	String priceValueSt = null;
//    	for(int i=0; i<spanListVal.length; i++) {
//    		priceValueSt = spanListVal[1];
//    	}
//    	System.out.println("Priceeeeeeeeeeeeee :"+priceValueSt);
//    	//System.out.println("Valueeeeeeeeeee: "+price.text());    	
//    	mav = new ModelAndView("redirect:" + "registryLiveStatusRed");    	
//        return mav;
//    }
    
	@Override
	@Transactional
	public Timestamp currentDate() {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
