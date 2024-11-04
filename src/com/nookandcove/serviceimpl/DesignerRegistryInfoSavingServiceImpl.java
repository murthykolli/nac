package com.nookandcove.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;

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

import com.nookandcove.dao.AdminRegistryConceptBoardsFurnitureSpecsSavingDAO;
import com.nookandcove.dao.AdminRegistryConceptBoardsSavingDAO;
import com.nookandcove.dao.AdminRegistryFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.dao.DesignerInfoSavingDAO;
import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;
import com.nookandcove.model.AdminRegistryConceptBoardsSaving;
import com.nookandcove.model.AdminRegistryFinishingTouchesProductsInfoSaving;
import com.nookandcove.model.DesignerInfoSaving;
import com.nookandcove.service.DesignerRegistryInfoSavingService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class DesignerRegistryInfoSavingServiceImpl implements DesignerRegistryInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignerRegistryInfoSavingServiceImpl.class);
	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
	private String designerRegistryAddNewBoardsRed = "designerRegistryAddNewBoardsRed";
	private String designerRegistryAddNewRoomRedirect = "designerRegistryAddNewRoomRedirect";
	private String conceptBoardsImage = "conceptBoardsImage";
	private String designerRegistryRoom = "designerRegistryRoom";
	private String designerRegistryRoomInSn = "designerRegistryRoomInSn";
	private String designerRegistryStyle = "designerRegistryStyle";
	private String designerRegistryPrice = "designerRegistryPrice";
	private String conceptBoardsSavingIdInSn = "conceptBoardsSavingIdInSn";
	private String designerRegConceptBoardsManagementDisplay = "designerRegConceptBoardsManagementDisplay";
	private String designerRegistryModifyRoomRedirect = "designerRegistryModifyRoomRedirect";
	private String designerConFurnitureSpectsDisplay = "designerConFurnitureSpectsDisplay";
	private String designerConFurnitureSpectsUpload = "designerConFurnitureSpectsUpload";
	private String designerConFurnitureSpectsEdit = "designerConFurnitureSpectsEdit";
	private String adminConFSProductsIdInSn = "adminConFSProductsIdInSn";
	private String designerConFurSpectsDataDisplayRed = "designerConFurSpectsDataDisplayRed";	
	private String productCategory = "productCategory";
	private String productName = "productName";
	private String productSize1 = "productSize1";
	private String productSize2 = "productSize2";
	private String productSize3 = "productSize3";
	private String productSize4 = "productSize4";
	private String productSize5 = "productSize5";
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
	private String designerRegConBdRoomIdsListInSn = "designerRegConBdRoomIdsListInSn";
	private String designerRegConBdRoomImagesListInSn = "designerRegConBdRoomImagesListInSn";
	private String designerRegTotalResultCount = "designerRegTotalResultCount";
	private String designerRegistryConceptBoardsRed = "designerRegistryConceptBoardsRed";
	private String designerRegistryFinishingTouchesHome = "designerRegistryFinishingTouchesHome";
	private String designerRegistryFinishingTouchesDisplay = "designerRegistryFinishingTouchesDisplay";
	private String designerRegistryFinishingTouchesUpload = "designerRegistryFinishingTouchesUpload";
	private String designerRegistryFinishingTouchesEdit = "designerRegistryFinishingTouchesEdit";
	private String redirectDesignerFinishingTouchesDisplay = "redirectDesignerFinishingTouchesDisplay";
	private String finishingTouchesIdList = "finishingTouchesIdList";
	private String finishingTouchesProductNameList = "finishingTouchesProductNameList";
	private String adminRegFinishingTouchesSavingIdInSn = "adminRegFinishingTouchesSavingIdInSn";
	private String productUploadImage1 = "productUploadImage1";
	private String productUploadImage2 = "productUploadImage2";
	private String productUploadImage3 = "productUploadImage3";
	private String productUploadImage4 = "productUploadImage4";
	private String finishingTouchesRBName = "finishingTouchesRBName";
	private String finishingTouchesCBName = "finishingTouchesCBName";
	private String designerFTCBValuesList = "designerFTCBValuesList";
	private String finishingTouchesImageIdInSn = "finishingTouchesImageIdInSn";
	private String designerReff = "Designer";
	private String designerInfoSavingIdInSn = "designerInfoSavingIdInSn";
	private String designerRegAddNewBoards = "designerRegAddNewBoards";
	private String designerFullName = "designerFullName";
	private String desnDoneStatus = "Done";
	private String availableStatus = "Available";
	
	private String uploadImgPath = "/var/www/html/data/nookandcoveimages/";
	
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
    public ModelAndView designerRegistryConceptBoardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List desnRegConBdRoomIdsList = new ArrayList();
    	List desnRegConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsLivingRoomListTakeFromDB((Long)sn.getAttribute(designerInfoSavingIdInSn));  	
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
    	mav = new ModelAndView(designerRegistryConceptBoardsRed);
    	sn.setAttribute(designerRegConBdRoomIdsListInSn, desnRegConBdRoomIdsList);
        sn.setAttribute(designerRegConBdRoomImagesListInSn, desnRegConBdRoomImagesList);
        sn.setAttribute(designerRegTotalResultCount, admnRegConBdRoomsList.size());
        mav.addObject(designerRegistryRoom, "Living Room");
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	sn.setAttribute(conceptBoardsSavingIdInSn, null);
    	sn.setAttribute(designerRegistryRoomInSn, null);
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerRegConceptBoardsManagement(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsManagementList((Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	if(!admnRegConBdManList.isEmpty()){
	  		mav = designerRegConceptBoardsManagementDataDisplay(req, sn);
	  	} else {
	  		mav = designerRegAddNewBoardsRedirection(req, sn);
	  	}
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	return mav;
    }
  
    @Override
    @Transactional
    public ModelAndView designerRegConceptBoardsManagementDataDisplay(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsManagementList((Long)sn.getAttribute(designerInfoSavingIdInSn));
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
	        	admnRegConBdSavingModel.setCreatedDate(admnRegConBdInfoLoop.getCreatedDate());
	        	admnRegConBdSavingModel.setUpdatedDate(admnRegConBdInfoLoop.getUpdatedDate());
	        	admnRegConBdSavingList.add(admnRegConBdSavingModel);
	        }
	        mav = new ModelAndView(designerRegConceptBoardsManagementDisplay);
	        mav.addObject("designerRegConceptBoardsManagementSavingList", admnRegConBdSavingList);
	        mav.addObject("designerRegConceptBoardsManagementListCount", admnRegConBdManList.size());                       
	    } else{
	    	mav = designerRegAddNewBoardsRedirection(req, sn);
	    }
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	    return mav;
    }

	@Override
	@Transactional
	public ModelAndView designerRegAddNewBoardsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
		String room = null;
		String style = null;
		String price = null;
		String mostPopular = null;
		String conBoardsImage = null;
		int totalFurSpecsProductsCount = 0;
		if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
			long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
			AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
			room = admnRegConBdModel.getRoom();
			style = admnRegConBdModel.getStyle();
			price = admnRegConBdModel.getPrice();
			mostPopular = admnRegConBdModel.getMostPopularCB();
			if(null != admnRegConBdModel.getConceptBoardsImage()) {
	  		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
		       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
			}
			List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
			totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
		} else {
			List <AdminRegistryConceptBoardsSaving> admnRegConBdFSList = adminRegistryConceptBoardsSavingDAO.onlyDesignerRegCBFurSpicStatusVerification((Long)sn.getAttribute(designerInfoSavingIdInSn));
			if(!admnRegConBdFSList.isEmpty()){
				AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.onlyDesignerRegCBFurSpicStatusValueFromDB((Long)sn.getAttribute(designerInfoSavingIdInSn));
				room = admnRegConBdModel.getRoom();
				style = admnRegConBdModel.getStyle();
				price = admnRegConBdModel.getPrice();
				mostPopular = admnRegConBdModel.getMostPopularCB();
				if(null != admnRegConBdModel.getConceptBoardsImage()) {
		    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
		 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
				}
				long conceptBoardsSavingId = admnRegConBdModel.getAdminRegistryConceptBoardsSavingId();
		    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
		    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
		    	totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
			}
		}    	    	
		mav = new ModelAndView(designerRegistryAddNewBoardsRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		mav.addObject(designerFullName, designersName);
		mav.addObject(designerRegistryRoom, room);
		mav.addObject(designerRegistryStyle, style);
		mav.addObject(designerRegistryPrice, price);
		mav.addObject(mostPopularCB, mostPopular);
		mav.addObject(conceptBoardsImage, conBoardsImage);
		mav.addObject(prodTotalCount, totalFurSpecsProductsCount);
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView designerRegConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		String designerRegistryStyleValue = "";        
		if(null != req.getParameterValues(designerRegistryStyle)) {
			String[] checkBoxVal = req.getParameterValues(designerRegistryStyle);
			for (int q = 0; q < checkBoxVal.length; q++) {
				designerRegistryStyleValue = designerRegistryStyleValue + "," + checkBoxVal[q];
			}
			designerRegistryStyleValue = designerRegistryStyleValue.replaceFirst(",", "");
		}
		if (null == sn.getAttribute(conceptBoardsSavingIdInSn)) {    		
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = new AdminRegistryConceptBoardsSaving();
			adminRegConBdSavingModel.setAdminDesignerCommonReferenceId(designerInfoSavingId);
		    adminRegConBdSavingModel.setAdminDesignerCommonReferenceName(designerReff);
		  	adminRegConBdSavingModel.setRoom(req.getParameter(designerRegistryRoom));
		  	adminRegConBdSavingModel.setStyle(designerRegistryStyleValue);	  	
		  	adminRegConBdSavingModel.setDesignerName(req.getParameter(designerFullName));
		  	adminRegConBdSavingModel.setPrice(req.getParameter(designerRegistryPrice));
		  	adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
		  	adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
		  	adminRegistryConceptBoardsSavingDAO.save(adminRegConBdSavingModel);
		  	long conceptBoardsSavingId = adminRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId();
		  	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
		} else {
			AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));
		    adminRegConBdSavingModel.setRoom(req.getParameter(designerRegistryRoom));
		    adminRegConBdSavingModel.setStyle(designerRegistryStyleValue);	    
		    adminRegConBdSavingModel.setDesignerName(req.getParameter(designerFullName));
		    adminRegConBdSavingModel.setPrice(req.getParameter(designerRegistryPrice));
		    adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
		    adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
		    adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		}
		mav = new ModelAndView("redirect:" + designerRegAddNewBoards);
	  return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerRedConceptSpcBoardImageUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
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
	  		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	   	admnRegConBdModel.setConceptBoardsImage(bFile);
		   	admnRegConBdModel.setUpdatedDate(currentDate);
		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
	  	} 	   
	  	mav = new ModelAndView("redirect:" + designerRegAddNewBoards);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConFurnitureSpectsUploadRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
	  	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
	  	if(!totalFurSpecsProductsList.isEmpty()){
	  		mav = new ModelAndView("redirect:" + designerConFurSpectsDataDisplayRed);
	  	} else {
	  		mav = new ModelAndView(designerConFurnitureSpectsUpload);
	  	}    	
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	      return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConFurnitureSpecsUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
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
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		Timestamp currentDate = currentDate();		
		AdminRegistryConceptBoardsFurnitureSpecsSaving admRegFurnitureSpecsSaving = new AdminRegistryConceptBoardsFurnitureSpecsSaving();
		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
		admRegFurnitureSpecsSaving.setAdminRegistryConceptBoardsSavingId(conceptBoardsSavingId);
		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceId(designerInfoSavingId);
		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceName(designerReff);
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
		admRegFurnitureSpecsSaving.setFurnitureSpecsStatus(desnDoneStatus);   		
		admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
		admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
		admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
		admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
		admRegFurnitureSpecsSaving.setAdminStockCheckStatus(availableStatus);
		admRegFurnitureSpecsSaving.setCreatedDate(currentDate);
		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.save(admRegFurnitureSpecsSaving);
		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, designerInfoSavingId);
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsCountList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
		admnRegConBdModel.setFurnitureSpecsStatus(desnDoneStatus);
		admnRegConBdModel.setFurnitureSpecsCount(totalFurSpecsCountList.size());
		adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
		mav = new ModelAndView("redirect:" + designerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));    
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConFurnitureSpectsDataDisplayFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
		List furnSpecSavingIdList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		int prodCount = 0; 	
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
		if (!totalFurSpecsProductsList.isEmpty()) {
	 		for (AdminRegistryConceptBoardsFurnitureSpecsSaving furnSpecsProductsSavingModel : totalFurSpecsProductsList) {
	 			furnSpecSavingIdList.add(furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId());
	 			furnSpecProductNameList.add(furnSpecsProductsSavingModel.getProductName());
	 			int count = 1;
	 			prodCount = prodCount + count;
	 		}		
	 		mav = new ModelAndView(designerConFurnitureSpectsDisplay);
	 		sn.setAttribute(furn_Spec_Saving_Id_List, furnSpecSavingIdList);
	 		sn.setAttribute(furn_Spec_Product_Name_List, furnSpecProductNameList);
	 		mav.addObject(prodTotalCount, prodCount);
 		} else{
     	mav = designerConFurnitureSpectsUploadRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		sn.setAttribute(adminConFSProductsIdInSn, null);
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerRegConceptBoardsManagementRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;    	
		String admConBoardManagement = req.getParameter("admConBoardManagementId");
		String typeOfRoomSel = req.getParameter("typeOfRoomSelection");
		if(("Modify Room").equals(typeOfRoomSel)) {
			long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
			sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
			mav = designerRegistryModifyRoomRedirection(req, sn);
		} else if(("Delete Room").equals(typeOfRoomSel)) {
			long conceptBoardsSavingId = Long.parseLong(admConBoardManagement);
			sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
			mav = designerRegistryDeleteRoomRedirection(req, sn, conceptBoardsSavingId);
		} else {
			sn.setAttribute(conceptBoardsSavingIdInSn, null);
			mav = designerRegistryAddNewRoomRedirect(req, sn);
		}    	
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerRegistryModifyRoomRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
	  	String room = null;
	  	String style = null;
	  	String price = null;
	  	String conBoardsImage = null; 
	  	String mostPopular = null;
	  	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	room = admnRegConBdModel.getRoom();
	  	style = admnRegConBdModel.getStyle();
	  	price = admnRegConBdModel.getPrice();
	  	mostPopular = admnRegConBdModel.getMostPopularCB();
	  	long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
	  	if(null != admnRegConBdModel.getConceptBoardsImage()) {
		    	byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
		 	   	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	  	}
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);		
	  	mav = new ModelAndView(designerRegistryModifyRoomRedirect);
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
	public ModelAndView designerRegistryDeleteRoomRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId) {
	  	ModelAndView mav;
	  	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
	  	for (AdminRegistryConceptBoardsFurnitureSpecsSaving admnRegConBdInfoLoop : totalFurSpecsProductsList) {
	  		AdminRegistryConceptBoardsFurnitureSpecsSaving removeFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerDeleteConBoardsFurnitureSpecsProductsInDB(admnRegConBdInfoLoop.getAdminRegistryConceptBoardsSavingId());
	      	adminRegistryConceptBoardsFurnitureSpecsSavingDAO.delete(removeFurSpecsProductsList);
	  	}    	
	  	AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	adminRegistryConceptBoardsSavingDAO.delete(admnRegConBdModel);    	
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdManList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsManagementList((Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	if(!admnRegConBdManList.isEmpty()){
	  		mav = designerRegConceptBoardsManagementDataDisplay(req, sn);
	  	} else {
	  		sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  		mav = designerRegAddNewBoardsRedirection(req, sn);
	  	}
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));   	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerRegistryAddNewRoomRedirect(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String room = null;
	  	String style = null;
	  	String conBoardsImage = null;
	  	String price = null;
	  	String mostPopular = null;
	  	int totalFurSpecsProductsCount = 0;
	  	long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
	  	if (null != sn.getAttribute(conceptBoardsSavingIdInSn)) {
	  		long conceptBoardsSavingId = (Long) sn.getAttribute(conceptBoardsSavingIdInSn);
	  		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	  		room = admnRegConBdModel.getRoom();
	  		style = admnRegConBdModel.getStyle();
	  		price = admnRegConBdModel.getPrice();
	  		mostPopular = admnRegConBdModel.getMostPopularCB();
	  		if(null != admnRegConBdModel.getConceptBoardsImage()) {
		    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
		 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	  		}
	  		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
		    	totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
	  	} else {
	  		List <AdminRegistryConceptBoardsSaving> admnRegConBdFSList = adminRegistryConceptBoardsSavingDAO.onlyDesignerRegCBFurSpicStatusVerification((Long)sn.getAttribute(designerInfoSavingIdInSn));
	  		if(!admnRegConBdFSList.isEmpty()){
	  			AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.onlyDesignerRegCBFurSpicStatusValueFromDB((Long)sn.getAttribute(designerInfoSavingIdInSn));
	      		room = admnRegConBdModel.getRoom();
	      		style = admnRegConBdModel.getStyle();
	      		price = admnRegConBdModel.getPrice();
	      		mostPopular = admnRegConBdModel.getMostPopularCB();
	      		if(null != admnRegConBdModel.getConceptBoardsImage()) {
	  	    		byte[] conBoardsImageFromDB = admnRegConBdModel.getConceptBoardsImage();
	  	 	       	conBoardsImage = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB);
	      		}
	      		long conceptBoardsSavingId = admnRegConBdModel.getAdminRegistryConceptBoardsSavingId();
	  	    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
	  	    	List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.designerRegistryFurnitureSpecCount(conceptBoardsSavingId);
	  	    	totalFurSpecsProductsCount = totalFurSpecsProductsList.size();
	  		}
	  	}
	  	mav = new ModelAndView(designerRegistryAddNewRoomRedirect);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	mav.addObject(designerFullName, designersName);
	  	mav.addObject(designerRegistryRoom, room);
	  	mav.addObject(designerRegistryStyle, style);
	  	mav.addObject(designerRegistryPrice, price);
	  	mav.addObject(conceptBoardsImage, conBoardsImage);
	  	mav.addObject(prodTotalCount, totalFurSpecsProductsCount);
	  	mav.addObject(mostPopularCB, mostPopular);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerRedConceptSpcBoardModificationUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
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
			AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
		   	admnRegConBdModel.setConceptBoardsImage(bFile);
		  	admnRegConBdModel.setUpdatedDate(currentDate);
		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
		} 	   
		mav = designerRegistryModifyRoomRedirection(req, sn);
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerAddAnotherConceptSpcBoardUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
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
	   		AdminRegistryConceptBoardsSaving admnRegConBdModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	   	   	admnRegConBdModel.setConceptBoardsImage(bFile);
		   	admnRegConBdModel.setUpdatedDate(currentDate);
		   	adminRegistryConceptBoardsSavingDAO.merge(admnRegConBdModel);
	   	} 	   
	   	mav = designerRegistryAddNewRoomRedirect(req, sn);
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConceptBoardsDataModificationInDB(HttpServletRequest req, HttpSession sn) {
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
	  	AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedOnlyDesnRegConBoardsImageInDB(conceptBoardsSavingId, (Long)sn.getAttribute(designerInfoSavingIdInSn));    	
		adminRegConBdSavingModel.setRoom(req.getParameter(designerRegistryRoom));
		adminRegConBdSavingModel.setStyle(designerRegistryStyleValue);
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
		adminRegConBdSavingModel.setDesignerName(designersName);
		adminRegConBdSavingModel.setPrice(req.getParameter(designerRegistryPrice));
		adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
		adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
		adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);	    
	  	mav = designerRegistryModifyRoomRedirection(req, sn);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerAddAnotherConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String designerRegistryStyleValue = "";        
		if(null != req.getParameterValues(designerRegistryStyle)) {
      	String[] checkBoxVal = req.getParameterValues(designerRegistryStyle);
      	for (int q = 0; q < checkBoxVal.length; q++) {
      		designerRegistryStyleValue = designerRegistryStyleValue + "," + checkBoxVal[q];
      	}
      	designerRegistryStyleValue = designerRegistryStyleValue.replaceFirst(",", "");
		}
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		DesignerInfoSaving desiNamesModel = designerInfoSavingDAO.designerDataTakeFromDBUsingId(designerInfoSavingId);
		String designersName = desiNamesModel.getDesignerFullName();
  		if (null == sn.getAttribute(conceptBoardsSavingIdInSn)) {    		
	    	AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = new AdminRegistryConceptBoardsSaving();
	    	adminRegConBdSavingModel.setAdminDesignerCommonReferenceId(designerInfoSavingId);
	    	adminRegConBdSavingModel.setAdminDesignerCommonReferenceName(designerReff);
	    	adminRegConBdSavingModel.setRoom(req.getParameter(designerRegistryRoom));
	    	adminRegConBdSavingModel.setStyle(designerRegistryStyleValue);	    	
	    	adminRegConBdSavingModel.setDesignerName(designersName);
	    	adminRegConBdSavingModel.setPrice(req.getParameter(designerRegistryPrice));
	    	adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
	    	adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
	    	adminRegistryConceptBoardsSavingDAO.save(adminRegConBdSavingModel);
	    	long conceptBoardsSavingId = adminRegConBdSavingModel.getAdminRegistryConceptBoardsSavingId();
	    	sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
  		} else {
	  		AdminRegistryConceptBoardsSaving adminRegConBdSavingModel = adminRegistryConceptBoardsSavingDAO.updatedDesnRegConBoardsImageInDB((Long) sn.getAttribute(conceptBoardsSavingIdInSn));    		
	  	    adminRegConBdSavingModel.setRoom(req.getParameter(designerRegistryRoom));
	  	    adminRegConBdSavingModel.setStyle(designerRegistryStyleValue);  	    
	  	    adminRegConBdSavingModel.setDesignerName(designersName);
	  	    adminRegConBdSavingModel.setPrice(req.getParameter(designerRegistryPrice));
	  	    adminRegConBdSavingModel.setMostPopularCB(req.getParameter(mostPopularCB));
	  	    adminRegConBdSavingModel.setDesignerInfoSavingId(designerInfoSavingId);
	  	    adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
  		}
  		mav = designerRegistryAddNewRoomRedirect(req, sn);
  		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConFurnitureSpecsDataDeleteFromDB(HttpServletRequest req, HttpSession sn) {
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
			adminRegistryConceptBoardsSavingDAO.merge(adminRegConBdSavingModel);
		}
		mav = new ModelAndView("redirect:" + designerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerRedConFurnitureSpectsEditProductsRed(HttpServletRequest req, HttpSession sn) {
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
	    	mav = new ModelAndView(designerConFurnitureSpectsEdit);
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
			mav = new ModelAndView("redirect:" + designerConFurSpectsDataDisplayRed);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConFurnitureSpecsModifiedDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
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
		admRegFurnitureSpecsSaving.setFurnitureSpecsStatus(desnDoneStatus);   		
		admRegFurnitureSpecsSaving.setUpdatedDate(currentDate);
		adminRegistryConceptBoardsFurnitureSpecsSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = designerConFurnitureSpecsEditdDataUpdateInDB(req, sn, adminConFSProductsId, bFile1, bFile2, bFile3, bFile4, editFileName1, editFileName2, editFileName3, editFileName4);
		long conceptBoardsSavingId = admRegFurnitureSpecsSaving.getAdminRegistryConceptBoardsSavingId();
		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId);
		mav = new ModelAndView("redirect:" + designerConFurSpectsDataDisplayRed);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));       
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerConFurnitureSpecsEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminConFSProductsId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4) {
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
	public ModelAndView designerRedConFurnitureSpectsAddNewProductsRed(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(designerConFurnitureSpectsUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedRoomAndStyleImageUploadInDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
	   	String conceptImagesName1 = req.getParameter("conceptImagesName");
	   	if (null != conceptImagesName1) {
	   		long conceptBoardsSavingId = Long.parseLong(conceptImagesName1);
	   		sn.setAttribute(conceptBoardsSavingIdInSn, conceptBoardsSavingId); 
	   	}
	   	String rommName = req.getParameter(designerRegistryRoom);
	   	sn.setAttribute(designerRegistryRoomInSn, rommName);	   	
	   	mav = designerRegistryModifyRoomRedirection(req, sn);
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedRoomAndStyleRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	String rommName = req.getParameter(designerRegistryRoom);    	
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsAllRoomListTakeFromDB(rommName, (Long)sn.getAttribute(designerInfoSavingIdInSn));  	
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
	  	mav = new ModelAndView(designerRegistryConceptBoardsRed);
	  	sn.setAttribute(designerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(designerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(designerRegTotalResultCount, admnRegConBdRoomsList.size());
	    mav.addObject(designerRegistryRoom, rommName);
	    mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	    return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedStyleAndRoomRedirection(HttpServletRequest req, HttpSession sn) {
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
	      	mav = designerSelectedRoomStyleAndPriceCombDataTakeFromDB(req, sn, rommName, admnRegCheckValue, priceValue1);
	  	} else if((!("").equals(admnRegCheckValue)) && (("").equals(priceValue))) {
	  		mav = designerSelectedRoomAndStyleDataTakeFromDB(req, sn, rommName, admnRegCheckValue);
	  	} else if((("").equals(admnRegCheckValue)) && (!("").equals(priceValue))) {
	  		String priceValue1 = priceValue.replace(",", "', '");
	  		mav = designerSelectedRoomAndPriceDataTakeFromDB(req, sn, rommName, priceValue1);
	  	} else {
	  		mav = designerSelectedRoomDataOnlyTakeFromDB(req, sn, rommName);
	  	}    	
	  	mav = new ModelAndView(designerRegistryConceptBoardsRed);
	  	mav.addObject(designerRegistryRoom, rommName);
	  	mav.addObject(designerRegistryStyle, admnRegCheckValue);
	  	mav.addObject(designerRegistryPrice, priceValue);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  	return mav;
	}

	@Override
	@Transactional
	public ModelAndView designerSelectedRoomStyleAndPriceCombDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames, String priceValue) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(rommName, priceValue, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	int totalConceptCount = 0;
	  	if (!admnRegConBdRoomStyleList.isEmpty()) {
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomStyleList) {
	  			String stylesNameDBList = admnRegConBdSavingModel.getStyle();
	  			String styleRowChecking = designerStyleNameCheckInDbUsingAdminSelectedStyleList(stylesNameDBList, styleNames);    			
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
	  	sn.setAttribute(designerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(designerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(designerRegTotalResultCount, totalConceptCount);
	    return mav;
	}
	
	public String designerStyleNameCheckInDbUsingAdminSelectedStyleList(String stylesNameDbList, String stylesNameAdmList) {
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
	public ModelAndView designerSelectedRoomAndStyleDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();    	
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsAllRoomAndStyleListTakeFromDB(rommName, (Long)sn.getAttribute(designerInfoSavingIdInSn));
	  	int totalConceptCount = 0;
	  	if (!admnRegConBdRoomStyleList.isEmpty()) {    		
	  		for (AdminRegistryConceptBoardsSaving admnRegConBdSavingModel : admnRegConBdRoomStyleList) {    			
	  			String stylesNameDBList = admnRegConBdSavingModel.getStyle();
	  			String styleRowChecking = designerStyleNameCheckInDbUsingAdminSelectedStyleList(stylesNameDBList, styleNames);    			
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
	  	sn.setAttribute(designerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	  	sn.setAttribute(designerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	  	sn.setAttribute(designerRegTotalResultCount, totalConceptCount);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedRoomAndPriceDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String price) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsAllRoomsAndPriceListTakeFromDB(rommName, price, (Long)sn.getAttribute(designerInfoSavingIdInSn));  	
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
	  	sn.setAttribute(designerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(designerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(designerRegTotalResultCount, admnRegConBdRoomsList.size());
	    return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedRoomDataOnlyTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName) {
	  	ModelAndView mav;
	  	List admnRegConBdRoomIdsList = new ArrayList();
	  	List admnRegConBdRoomImagesList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsAllRoomListTakeFromDB(rommName, (Long)sn.getAttribute(designerInfoSavingIdInSn));  	
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
	  	sn.setAttribute(designerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
	    sn.setAttribute(designerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
	    sn.setAttribute(designerRegTotalResultCount, admnRegConBdRoomsList.size());
	    return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn) {
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
	      	mav = designerSelectedRoomStyleAndPriceCombDataTakeFromDB(req, sn, rommName, styleValue, priceValue);
	  	} else if((!("").equals(admnRegCheckValue)) && (("").equals(styleValue))) {
	  		mav = designerSelectedRoomAndPriceDataTakeFromDB(req, sn, rommName, priceValue);
	  	} else if((("").equals(admnRegCheckValue)) && (!("").equals(styleValue))) {
	  		mav = designerSelectedRoomAndStyleDataTakeFromDB(req, sn, rommName, styleValue);
	  	} else {
	  		mav = designerSelectedRoomDataOnlyTakeFromDB(req, sn, rommName);
	  	}   	
	  	mav = new ModelAndView(designerRegistryConceptBoardsRed);
	  	mav.addObject(designerRegistryRoom, rommName);
	  	mav.addObject(designerRegistryStyle, styleValue);
	  	mav.addObject(designerRegistryPrice, admnRegCheckValue);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerUnCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	String rommName = req.getParameter(designerRegistryRoom);
	  	mav = designerSelectedRoomDataOnlyTakeFromDB(req, sn, rommName);
	  	mav = new ModelAndView(designerRegistryConceptBoardsRed);
	  	mav.addObject(designerRegistryRoom, rommName);
	  	mav.addObject(designerRegistryStyle, null);
	  	mav.addObject(designerRegistryPrice, null);
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	sn.setAttribute(conceptBoardsSavingIdInSn, null);
	  	return mav;
	}

	
//	Finishing Touches Coding
		
	@Override
	@Transactional
	public ModelAndView designerSelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
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
	  	mav = new ModelAndView(designerRegistryFinishingTouchesHome);
	  	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
	  	sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
	  	sn.setAttribute(designerRegTotalResultCount, admnRegFinishingTouchesList.size());
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
	public ModelAndView designerRegistryFinishingTouchesUploadRedirection(HttpServletRequest req, HttpSession sn) {
	  	ModelAndView mav;
	  	List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFinishingTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFTFurnitureSpecEditProductsInDB();
	  	if(!totalFinishingTouchesProductsList.isEmpty()){
	  		mav = new ModelAndView("redirect:" + redirectDesignerFinishingTouchesDisplay);
	  	} else {
	  		mav = new ModelAndView(designerRegistryFinishingTouchesUpload);
	  	}    	
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerFinishingTouchesUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
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
		long designerInfoSavingId = (Long)sn.getAttribute(designerInfoSavingIdInSn);
		AdminRegistryFinishingTouchesProductsInfoSaving admRegFurnitureSpecsSaving = new AdminRegistryFinishingTouchesProductsInfoSaving();
		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceId(designerInfoSavingId);
		admRegFurnitureSpecsSaving.setAdminDesignerCommonReferenceName(designerReff);
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
		admRegFurnitureSpecsSaving.setFinishingTouchesStatus(desnDoneStatus);
		admRegFurnitureSpecsSaving.setProductUploadedImage1(bFile1);
		admRegFurnitureSpecsSaving.setProductUploadedImage2(bFile2);
		admRegFurnitureSpecsSaving.setProductUploadedImage3(bFile3);
		admRegFurnitureSpecsSaving.setProductUploadedImage4(bFile4);
		admRegFurnitureSpecsSaving.setAdminStockCheckStatus(availableStatus);
		admRegFurnitureSpecsSaving.setCreatedDate(currentDate);
		adminRegistryFinishingTouchesProductsInfoSavingDAO.save(admRegFurnitureSpecsSaving);   		
		mav = new ModelAndView("redirect:" + redirectDesignerFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));     
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView redirectDesignerFinishingTouchesDisplayRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		List finiTouchesIdList = new ArrayList();
		List finiTouchesProductNameList = new ArrayList();
		int prodCount = 0;
		List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFinishingTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFTFurnitureSpecEditProductsInDB();
		if (!totalFinishingTouchesProductsList.isEmpty()) {
	 		for (AdminRegistryFinishingTouchesProductsInfoSaving finishingTouchesSavingModel : totalFinishingTouchesProductsList) {
	 			finiTouchesIdList.add(finishingTouchesSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
	 			finiTouchesProductNameList.add(finishingTouchesSavingModel.getProductName());
	 			int count = 1;
	 			prodCount = prodCount + count;
	 		}		
	 		mav = new ModelAndView(designerRegistryFinishingTouchesDisplay);
	 		sn.setAttribute(finishingTouchesIdList, finiTouchesIdList);
	 		sn.setAttribute(finishingTouchesProductNameList, finiTouchesProductNameList);
	 		mav.addObject(prodTotalCount, prodCount);	 		
 		} else{
     	mav = designerRegistryFinishingTouchesUploadRedirection(req, sn);
		}    	
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, null);
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView backToDsnFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
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
	  	mav = new ModelAndView(designerRegistryFinishingTouchesHome);
	  	sn.setAttribute("admFinishingTouchesIdsList", admnRegFinishingTouchesIdsList);
	  	sn.setAttribute("admFinishingTouchesImagesList", admnRegFinishingTouchesImagesList);
	  	sn.setAttribute(designerRegTotalResultCount, admnRegFinishingTouchesList.size());
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
	  	mav.addObject(finishingTouchesRBName, "Finishing Touches");
	  	mav.addObject(flName, sn.getAttribute(firstNamesInSn));    	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerFinishingTouchesDataDeleteFromDB(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String produtId = req.getParameter(storeName);
		long adminRegFinishingTouchesSavingId = Long.parseLong(produtId);
		List<AdminRegistryFinishingTouchesProductsInfoSaving> ediFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsInDB(adminRegFinishingTouchesSavingId);
		if (!ediFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving ediFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.designerRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFinishingTouchesSavingId);		
			adminRegistryFinishingTouchesProductsInfoSavingDAO.delete(ediFurSpecsProductsModel);
			sn.setAttribute(adminRegFinishingTouchesSavingIdInSn, adminRegFinishingTouchesSavingId);			
		}
		mav = new ModelAndView("redirect:" + redirectDesignerFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerFinishingTouchesEditProductsRedirection(HttpServletRequest req, HttpSession sn) {
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
	    	mav = new ModelAndView(designerRegistryFinishingTouchesEdit);
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
			mav = new ModelAndView("redirect:" + redirectDesignerFinishingTouchesDisplay);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerFinishingTouchesAddNewProductsRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		mav = new ModelAndView(designerRegistryFinishingTouchesUpload);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerFinishingTouchesModifiedDataUpdateInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
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
		admRegFurnitureSpecsSaving.setFinishingTouchesStatus(desnDoneStatus);   		
		admRegFurnitureSpecsSaving.setUpdatedDate(currentDate);
		adminRegistryFinishingTouchesProductsInfoSavingDAO.merge(admRegFurnitureSpecsSaving);
		mav = designerFinishingTouchesImagesEditdDataUpdateInDB(req, sn, adminRegFinishingTouchesSavingId, bFile1, bFile2, bFile3, bFile4, editFileName1, editFileName2, editFileName3, editFileName4);
		mav = new ModelAndView("redirect:" + redirectDesignerFinishingTouchesDisplay);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));       
		return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerFinishingTouchesImagesEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4) {
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
	public ModelAndView designerSelectedCBFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
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
	      	mav = designerRegSelectedCheckBoxFinishingTouchesList(req, sn, adminFTCBFormatValue);
	  	}    	
	  	mav = new ModelAndView(designerRegistryFinishingTouchesHome);
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
	public ModelAndView designerRegSelectedCheckBoxFinishingTouchesList(HttpServletRequest req, HttpSession sn, String prodCategory) {
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
	  	sn.setAttribute(designerRegTotalResultCount, admnRegFinishingTouchesList.size());            	
	  	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedFinishingTouchesImageEditInDB(HttpServletRequest req, HttpSession sn) {
  	ModelAndView mav;
	   	String finishingTouchesImage1 = req.getParameter("finishingTouchesImage");
	   	if (null != finishingTouchesImage1) {
	   		long finishingTouchesImageId = Long.parseLong(finishingTouchesImage1);
	   		sn.setAttribute(finishingTouchesImageIdInSn, finishingTouchesImageId);
	   		mav = designerSelectedFinishingTouchesImageEditRedirection(req, sn, finishingTouchesImageId);
	   	} else {	   		   	
	   		mav = designerSelectedFinishingTouchesRedirection(req, sn);
	   	}
	   	return mav;
	}
	
	@Override
	@Transactional
	public ModelAndView designerSelectedFinishingTouchesImageEditRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId) {
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
	    	mav = new ModelAndView(designerRegistryFinishingTouchesEdit);
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
			mav = new ModelAndView("redirect:" + redirectDesignerFinishingTouchesDisplay);
		}
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
		return mav;
	}
	
  @Override
  @Transactional
  public ModelAndView designerSelectedRoomAndStyleImageUpdateRedirection(HttpServletRequest req, HttpSession sn) {
	  ModelAndView mav;
	  List admnRegConBdRoomIdsList = new ArrayList();
	  List admnRegConBdRoomImagesList = new ArrayList();
	  String rommName = (String) sn.getAttribute(designerRegistryRoomInSn);    	
	  List <AdminRegistryConceptBoardsSaving> admnRegConBdRoomsList = adminRegistryConceptBoardsSavingDAO.onlyDesignerConceptBoardsAllRoomListTakeFromDB(rommName, (Long)sn.getAttribute(designerInfoSavingIdInSn));  	
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
	  mav = new ModelAndView(designerRegistryConceptBoardsRed);
	  sn.setAttribute(designerRegConBdRoomIdsListInSn, admnRegConBdRoomIdsList);
      sn.setAttribute(designerRegConBdRoomImagesListInSn, admnRegConBdRoomImagesList);
      sn.setAttribute(designerRegTotalResultCount, admnRegConBdRoomsList.size());
      mav.addObject(designerRegistryRoom, rommName);
      mav.addObject(flName, sn.getAttribute(firstNamesInSn));
      sn.setAttribute(designerRegistryRoomInSn, null);
      return mav;
  }
	
    
	@Override
	@Transactional
	public Timestamp currentDate() {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
