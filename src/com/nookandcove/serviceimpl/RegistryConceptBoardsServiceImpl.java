package com.nookandcove.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.AdminRegistryConceptBoardsFurnitureSpecsSavingDAO;
import com.nookandcove.dao.AdminRegistryConceptBoardsSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsContributedPaymentSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsContributedProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsIndividualPaymentSavingDAO;
import com.nookandcove.dao.RegistrantConceptBoardsIndividualProductsInfoSavingDAO;
import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;
import com.nookandcove.model.AdminRegistryConceptBoardsSaving;
import com.nookandcove.model.RegistrantConceptBoardsContributedPaymentSaving;
import com.nookandcove.model.RegistrantConceptBoardsContributedProductsInfoSaving;
import com.nookandcove.model.RegistrantConceptBoardsIndividualPaymentSaving;
import com.nookandcove.model.RegistrantConceptBoardsIndividualProductsInfoSaving;
import com.nookandcove.service.RegistryConceptBoardsService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class RegistryConceptBoardsServiceImpl implements RegistryConceptBoardsService {

    private String registrantUserIdInSn = "registrantUserIdInSn";
	private String designCuratedConceptsBoardsRed = "designCuratedConceptsBoardsRed";
	private String eventDate = "eventDate";	
	private String regFirstName = "regFirstName";
	private String coRegFirstName = "coRegFirstName";
	private String regUploadedPhoto = "regUploadedPhoto";
	private String registrantMessage = "registrantMessage";
	private String regiCartCountInSn = "regiCartCountInSn";
	private String regTotalCartItems = "regTotalCartItems";
	private String regFirstNamesInSn = "regFirstNamesInSn";
	private String regFirstNames = "regFirstNames";
	private String guestBackgroungImage = "guestBackgroungImage";
	private String regStatus = "regStatus";	
//	private String regConBoardRoomIdsListInSn = "regConBoardRoomIdsListInSn";
//	private String regConBoardRoomImagesListInSn = "regConBoardRoomImagesListInSn";
	private String regTotalResultsCount = "regTotalResultsCount";
	private String registrySpaceRoom = "registrySpaceRoom";
	private String registryStyleName = "registryStyleName";
	private String registryPrice = "registryPrice";
	private String registryViewProducts = "registryViewProducts";
	private String conceptBoardsBigImage = "conceptBoardsBigImage";
//	private String regCuratedSelectedRoomRedirection = "regCuratedSelectedRoomRedirection";
	private String registrySelectedConceptBoards = "registrySelectedConceptBoards";
	private String regFurnSpecSavingIdList = "regFurnSpecSavingIdList";
	private String regFurnSpecProductImageList = "regFurnSpecProductImageList";
	private String regFurnSpecProductImage2List = "regFurnSpecProductImage2List";
	private String regFurnSpecProductImage3List = "regFurnSpecProductImage3List";
	private String regFurnSpecProductImage4List = "regFurnSpecProductImage4List";
	private String regFurnSpecProductNameList = "regFurnSpecProductNameList";
	private String regFurnSpecStoreNameList = "regFurnSpecStoreNameList";
	private String regFurnSpecProductPriceList = "regFurnSpecProductPriceList";
	private String regFurnSpecPopUpValuesList = "regFurnSpecPopUpValuesList";	
	private String registrySpaceRoomInSn = "registrySpaceRoomInSn";
	private String registryStyleNameInSn = "registryStyleNameInSn";
	private String registryPriceInSn = "registryPriceInSn";
	private String regViewProductsInSn = "regViewProductsInSn";
	private String regProductHeading = "regProductHeading";
	private String regProductPrice = "regProductPrice";
	private String registryDescription = "registryDescription";
	private String groupGiftRefferanceValue = "groupGiftRefferanceValue";
	private String productQuantity = "productQuantity";
	private String totalProdPopUpValuesList = "totalProdPopUpValuesList";
	private String productsPrice = "productsPrice";
	private String productsDescription = "productsDescription";
	private String productSize = "productSize";
	private String productsCount = "productsCount";
	private String hidePriceGuest = "hidePriceGuest";
//	private String viewRegDesignCuratedConceptBoards = "viewRegDesignCuratedConceptBoards";
	private String productInfoSavingInfo = "productInfoSavingInfo";	
	private String registryOverview = "registryOverview";	
	private String regCBCotributedProductSavingId = "regCBCotributedProductSavingId";
	private String regCBIndividualProductSavingId = "regCBIndividualProductSavingId";
	private String regConBoardPaymentStatus = "regConBoardPaymentStatus";
	private String regiFirstNameInSn = "regiFirstNameInSn";
	private String coRegiFirstNameInSn = "coRegiFirstNameInSn";
	private String regUploadedPhotoInSn = "regUploadedPhotoInSn";
	private String guestBackgroungImageInSn = "guestBackgroungImageInSn";
	private String registrantMessageInSn = "registrantMessageInSn";
	private String eventDateInSn = "eventDateInSn";
	private String regiStatusInSn = "regiStatusInSn";	
	private String registryRoomFundsCountInSn = "registryRoomFundsCountInSn";
	private String registryCashFundsCountInSn = "registryCashFundsCountInSn";
	private String registryCustomFundsCountInSn = "registryCustomFundsCountInSn";
	private String regCBIndividualCountInSn = "regCBIndividualCountInSn";
	private String regCBContributedCartCountInSn = "regCBContributedCartCountInSn";
	private String regFTContributedCartCountInSn = "regFTContributedCartCountInSn";
	private String regFTIndividualCartCountInSn = "regFTIndividualCartCountInSn";
//	private String regHaveStatus = "Have";
	private String redirectStatus = "redirect:";
	private String redirectRegistrySelectedConceptBoards = "redirectRegistrySelectedConceptBoards";	
	private String cbContributedProductSavingIdListInSn = "cbContributedProductSavingIdListInSn";
	private String cbContributedProductImageListInSn = "cbContributedProductImageListInSn";
	private String cbContributedProductNameListInSn = "cbContributedProductNameListInSn";
	private String cbContributedProductPriceListInSn = "cbContributedProductPriceListInSn";
	private String cbContributedProductQuantityListInSn = "cbContributedProductQuantityListInSn";
	private String cbContributedRemainingAmountListInSn = "cbContributedRemainingAmountListInSn";
	private String cbContributedAmountListInSn = "cbContributedAmountListInSn";
	private String cbContributedPaymentStatusListInSn = "cbContributedPaymentStatusListInSn";

	private String cbIndividualProductSavingIdListInSn = "cbIndividualProductSavingIdListInSn";
	private String cbIndividualProductImageListInSn = "cbIndividualProductImageListInSn";
	private String cbIndividualProductNameListInSn = "cbIndividualProductNameListInSn";
	private String cbIndividualProductPriceListInSn = "cbIndividualProductPriceListInSn";
	private String cbIndividualProductQuantityListInSn = "cbIndividualProductQuantityListInSn";
	private String cbIndividualRemainingQuantityListInSn = "cbIndividualRemainingQuantityListInSn";
	private String cbIndividualGivenQuantityListInSn = "cbIndividualGivenQuantityListInSn";
	private String cbIndividualPaymentStatusListInSn = "cbIndividualPaymentStatusListInSn";
	
	private String cbContributedPaymentSavingIdListInSn = "cbContributedPaymentSavingIdListInSn";
	private String cbContributedAddCartImageListInSn = "cbContributedAddCartImageListInSn";
	private String cbContributedAddCartNameListInSn = "cbContributedAddCartNameListInSn";
	private String cbContributedAddCartPriceListInSn = "cbContributedAddCartPriceListInSn";
	private String cbContributedNeedPriceListInSn = "cbContributedNeedPriceListInSn";
	
	private String cbIndividualPaymentSavingIdListInSn = "cbIndividualPaymentSavingIdListInSn";
	private String cbIndividualAddCartImageListInSn = "cbIndividualAddCartImageListInSn";
	private String cbIndividualAddCartNameListInSn = "cbIndividualAddCartNameListInSn";
	private String cbIndividualAddCartPriceListInSn = "cbIndividualAddCartPriceListInSn";
	private String cbIndividualAddCartQuantityListInSn = "cbIndividualAddCartQuantityListInSn";
	private String cbIndividualNeedQuantityListInSn = "cbIndividualNeedQuantityListInSn";
		
	private String groupGiftRefferanceVal = "Enable Group Gift";
	private String jSonObject = "JSonObj";
	private String regCBCotributedProductImage = "regCBCotributedProductImage";
	private String regCBCotributedProductName = "regCBCotributedProductName";
	private String regCBCotributedPrice = "regCBCotributedPrice";
	private String regCBCotributedRemainingPrice = "regCBCotributedRemainingPrice";
	private String shoppingCartTotalAmountInSn = "shoppingCartTotalAmountInSn";
	private String cbContributedAddCartPriceInSn = "cbContributedAddCartPriceInSn";
	private String cbIndividualAddCartPriceInSn = "cbIndividualAddCartPriceInSn";
	private String ftContributedAddCartPriceInSn = "ftContributedAddCartPriceInSn";
	private String ftIndividualAddCartPriceInSn = "ftIndividualAddCartPriceInSn";
	private String noActionStatus = "No Action";
	private String regConceptBoardsContributedProductEdit = "regConceptBoardsContributedProductEdit";
	private String allProductsTotalPrice = "allProductsTotalPrice";
	private String guestsWatchedCount = "guestsWatchedCount";
	private String totalCBProductsCountInSn = "totalCBProductsCountInSn";
	private String registryCBRoomCount = "registryCBRoomCount";
	private String registryCBRoomCountInSn = "registryCBRoomCountInSn";
	private String registryViewAllDesignsConcepts = "registryViewAllDesignsConcepts";
	
	private String registryConceptBoardsIdsListInSn = "registryConceptBoardsIdsListInSn";
	private String registryViewDesignsCBIdsListInSn = "registryViewDesignsCBIdsListInSn";
	private String registryViewDesignsCBImagesListInSn = "registryViewDesignsCBImagesListInSn";
	
	

	@Autowired
    private AdminRegistryConceptBoardsSavingDAO adminRegistryConceptBoardsSavingDAO;

	@Autowired
    private AdminRegistryConceptBoardsFurnitureSpecsSavingDAO adminRegistryConceptBoardsFurnitureSpecsSavingDAO;

	@Autowired
	private RegistrantConceptBoardsContributedProductsInfoSavingDAO registrantConceptBoardsContributedProductsInfoSavingDAO;

	@Autowired
	private RegistrantConceptBoardsIndividualProductsInfoSavingDAO registrantConceptBoardsIndividualProductsInfoSavingDAO;

	@Autowired
	private RegistrantConceptBoardsContributedPaymentSavingDAO registrantConceptBoardsContributedPaymentSavingDAO;

	@Autowired
	private RegistrantConceptBoardsIndividualPaymentSavingDAO registrantConceptBoardsIndividualPaymentSavingDAO;
	

    @Override
    @Transactional
    public ModelAndView designCuratedConceptsBoardsRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;                
        mav = new ModelAndView(designCuratedConceptsBoardsRed);        
        mav.addObject(regFirstName, sn.getAttribute(regiFirstNameInSn));
        mav.addObject(coRegFirstName, sn.getAttribute(coRegiFirstNameInSn));
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
    public ModelAndView registrySelectedConceptBoardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List registryConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(registrySpaceRoom));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			registryConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int regiCBRoomCount = Integer.parseInt(req.getParameter(registryCBRoomCount));
    	Long registryConceptBoardsId = (Long) registryConceptBoardsIdsList.get(regiCBRoomCount);    	
    	int allProductsTotalPriceDb = registrySelectedConceptBoardsProductsList(req, sn, registryConceptBoardsId);
    	int guestsWatchCountDb = Math.round(allProductsTotalPriceDb / 120);
    	sn.setAttribute(totalCBProductsCountInSn, registryConBdRoomsList.size());
    	mav = new ModelAndView(registrySelectedConceptBoards);
    	mav.addObject(regTotalResultsCount, registryConBdRoomsList.size());
        mav.addObject(registrySpaceRoom, req.getParameter(registrySpaceRoom));
        mav.addObject(allProductsTotalPrice, allProductsTotalPriceDb);
        mav.addObject(guestsWatchedCount, guestsWatchCountDb);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	sn.setAttribute(registryCBRoomCountInSn, regiCBRoomCount);
        return mav;
    }

    public int registrySelectedConceptBoardsProductsList(HttpServletRequest req, HttpSession sn, Long registryConceptBoardsId) {
    	int allProductsTotalPrice = 0;        
        byte[] conBoardsImageFromDB = null;
        List furnSpecSavingIdList = new ArrayList();
        List furnSpecProductImageList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		List furnSpecStoreNameList = new ArrayList();
		List furnSpecProductPriceList = new ArrayList();
		List furnSpecPopUpValuesList = new ArrayList();
		List furnSpecProductImage2List = new ArrayList();
		List furnSpecProductImage3List = new ArrayList();
		List furnSpecProductImage4List = new ArrayList();
        List <AdminRegistryConceptBoardsSaving> registryConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.registrantConceptBoardsSelRoomAndStyleListTakeFromDB(registryConceptBoardsId);
        if (!registryConBdRoomStyleList.isEmpty()) {
        	AdminRegistryConceptBoardsSaving registryConBdRoomModel = adminRegistryConceptBoardsSavingDAO.registrantConceptBoardsSelRoomDataTakeFromDB(registryConceptBoardsId);
        	conBoardsImageFromDB = registryConBdRoomModel.getConceptBoardsImage();
        }
        List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecCount(registryConceptBoardsId);
        double allProductsTotalPriceDb = 0;
        if (!totalFurSpecsProductsList.isEmpty()) {        	
	 		for (AdminRegistryConceptBoardsFurnitureSpecsSaving furnSpecsProductsSavingModel : totalFurSpecsProductsList) {
	 			furnSpecSavingIdList.add(furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId());
    			long conctBoardProductsId = furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId();
    			String conBoardContributedStatus = registrantAllConBoardContributedStatus(req, sn, conctBoardProductsId);
//    			int conBoardIndividualStatus = registrantAllConBoardIndividualStatus(req, sn, conctBoardProductsId);
    			String conBoardPaymentStatus = registrantAllConBoardProductPaymentStatus(req, sn, conctBoardProductsId);
    			String prodCombValues =  furnSpecsProductsSavingModel.getProductSize1() + "_,_" + furnSpecsProductsSavingModel.getProductPrice1() + "_,_" + furnSpecsProductsSavingModel.getProductSize2() + "_,_" + furnSpecsProductsSavingModel.getProductPrice2() + "_,_" + furnSpecsProductsSavingModel.getProductSize3() + "_,_" + furnSpecsProductsSavingModel.getProductPrice3() + "_,_" + furnSpecsProductsSavingModel.getProductSize4() + "_,_" + furnSpecsProductsSavingModel.getProductPrice4() + "_,_" + furnSpecsProductsSavingModel.getProductSize5() + "_,_" + furnSpecsProductsSavingModel.getProductPrice5() + "_,_" + furnSpecsProductsSavingModel.getProductDescription1();
    			String totalPopUpValuesList = furnSpecsProductsSavingModel.getProductName() + "_,_" + furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + furnSpecsProductsSavingModel.getStoreName(); 
    			furnSpecProductImageList.add(furnSpecsProductsSavingModel.getProductUploadedImage1());
	 			furnSpecProductNameList.add(furnSpecsProductsSavingModel.getProductName());
	 			furnSpecStoreNameList.add(furnSpecsProductsSavingModel.getStoreName());
	 			furnSpecProductPriceList.add(furnSpecsProductsSavingModel.getProductPrice1());
	 			furnSpecPopUpValuesList.add(totalPopUpValuesList);
	 			furnSpecProductImage2List.add(furnSpecsProductsSavingModel.getProductUploadedImage2());
	 			furnSpecProductImage3List.add(furnSpecsProductsSavingModel.getProductUploadedImage3());
	 			furnSpecProductImage4List.add(furnSpecsProductsSavingModel.getProductUploadedImage4());
	 			double singleProductPrice = registrantAllProductPriceTotal(req, sn, furnSpecsProductsSavingModel.getProductPrice1());
	 			allProductsTotalPriceDb = allProductsTotalPriceDb + singleProductPrice;
	 		}	 		
	 		sn.setAttribute(regFurnSpecSavingIdList, furnSpecSavingIdList);
	 		sn.setAttribute(regFurnSpecProductImageList, furnSpecProductImageList);
	 		sn.setAttribute(regFurnSpecProductNameList, furnSpecProductNameList);
	 		sn.setAttribute(regFurnSpecStoreNameList, furnSpecStoreNameList);
	 		sn.setAttribute(regFurnSpecProductPriceList, furnSpecProductPriceList);
	 		sn.setAttribute(regFurnSpecPopUpValuesList, furnSpecPopUpValuesList);
	 		sn.setAttribute(regFurnSpecProductImage2List, furnSpecProductImage2List);
	 		sn.setAttribute(regFurnSpecProductImage3List, furnSpecProductImage3List);
	 		sn.setAttribute(regFurnSpecProductImage4List, furnSpecProductImage4List);
 		}
        allProductsTotalPrice = (int) Math.round(allProductsTotalPriceDb);                
        sn.setAttribute(conceptBoardsBigImage, conBoardsImageFromDB);        
        return allProductsTotalPrice;
    }

    @Override
    @Transactional
    public ModelAndView registryPreviousCBProductsDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List registryConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(registrySpaceRoom));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			registryConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int regiCBRoomCount = Integer.parseInt(req.getParameter(registryCBRoomCount)) - 1;    	
    	Long registryConceptBoardsId = (Long) registryConceptBoardsIdsList.get(regiCBRoomCount);    	
    	int allProductsTotalPriceDb = registrySelectedConceptBoardsProductsList(req, sn, registryConceptBoardsId);
    	int guestsWatchCountDb = Math.round(allProductsTotalPriceDb / 120);
    	sn.setAttribute(totalCBProductsCountInSn, registryConBdRoomsList.size());
    	mav = new ModelAndView(registrySelectedConceptBoards);
    	sn.setAttribute(registryConceptBoardsIdsListInSn, registryConceptBoardsIdsList);        
        mav.addObject(regTotalResultsCount, registryConBdRoomsList.size());
        mav.addObject(registrySpaceRoom, req.getParameter(registrySpaceRoom));
        mav.addObject(allProductsTotalPrice, allProductsTotalPriceDb);
        mav.addObject(guestsWatchedCount, guestsWatchCountDb);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	sn.setAttribute(registryCBRoomCountInSn, regiCBRoomCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryNextCBProductsDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List registryConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(registrySpaceRoom));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			registryConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int regiCBRoomCount = Integer.parseInt(req.getParameter(registryCBRoomCount)) + 1;    	
    	Long registryConceptBoardsId = (Long) registryConceptBoardsIdsList.get(regiCBRoomCount);    	
    	int allProductsTotalPriceDb = registrySelectedConceptBoardsProductsList(req, sn, registryConceptBoardsId);
    	int guestsWatchCountDb = Math.round(allProductsTotalPriceDb / 120);
    	sn.setAttribute(totalCBProductsCountInSn, registryConBdRoomsList.size());
    	mav = new ModelAndView(registrySelectedConceptBoards);
    	sn.setAttribute(registryConceptBoardsIdsListInSn, registryConceptBoardsIdsList);        
        mav.addObject(regTotalResultsCount, registryConBdRoomsList.size());
        mav.addObject(registrySpaceRoom, req.getParameter(registrySpaceRoom));
        mav.addObject(allProductsTotalPrice, allProductsTotalPriceDb);
        mav.addObject(guestsWatchedCount, guestsWatchCountDb);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	sn.setAttribute(registryCBRoomCountInSn, regiCBRoomCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryViewAllDesignsConceptBoards(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List registryConBdRoomIdsList = new ArrayList();
    	List registryConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(registrySpaceRoom));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			registryConBdRoomIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			registryConBdRoomImagesList.add(registryConBdSavingModel.getConceptBoardsImage());
     	   }
    	}
    	mav = new ModelAndView(registryViewAllDesignsConcepts);
    	sn.setAttribute(registryViewDesignsCBIdsListInSn, registryConBdRoomIdsList);
        sn.setAttribute(registryViewDesignsCBImagesListInSn, registryConBdRoomImagesList);
        mav.addObject(regTotalResultsCount, registryConBdRoomsList.size());
        mav.addObject(registrySpaceRoom, req.getParameter(registrySpaceRoom));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView viewDesignSelectedConceptBoards(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List registryConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(registrySpaceRoom));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			registryConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int regiCBRoomCount = Integer.parseInt(req.getParameter(registryCBRoomCount));    	
    	Long registryConceptBoardsId = (Long) registryConceptBoardsIdsList.get(regiCBRoomCount);    	
    	int allProductsTotalPriceDb = registrySelectedConceptBoardsProductsList(req, sn, registryConceptBoardsId);
    	int guestsWatchCountDb = Math.round(allProductsTotalPriceDb / 120);
    	sn.setAttribute(totalCBProductsCountInSn, registryConBdRoomsList.size());
    	mav = new ModelAndView(registrySelectedConceptBoards);
    	sn.setAttribute(registryConceptBoardsIdsListInSn, registryConceptBoardsIdsList);        
        mav.addObject(regTotalResultsCount, registryConBdRoomsList.size());
        mav.addObject(registrySpaceRoom, req.getParameter(registrySpaceRoom));
        mav.addObject(allProductsTotalPrice, allProductsTotalPriceDb);
        mav.addObject(guestsWatchedCount, guestsWatchCountDb);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	sn.setAttribute(registryCBRoomCountInSn, regiCBRoomCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView redirectRegistrySelectedConceptBoardsData(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List registryConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB((String) sn.getAttribute(registrySpaceRoomInSn));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			registryConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int regiCBRoomCount = (int) sn.getAttribute(registryCBRoomCountInSn);
    	Long registryConceptBoardsId = (Long) registryConceptBoardsIdsList.get(regiCBRoomCount);    	
    	int allProductsTotalPriceDb = redirectRegistrySelectedConceptBoardsProductsList(req, sn, registryConceptBoardsId);
    	int guestsWatchCountDb = Math.round(allProductsTotalPriceDb / 120);
    	sn.setAttribute(totalCBProductsCountInSn, registryConBdRoomsList.size());
    	mav = new ModelAndView(registrySelectedConceptBoards);
    	mav.addObject(regTotalResultsCount, registryConBdRoomsList.size());
    	mav.addObject(registrySpaceRoom, (String) sn.getAttribute(registrySpaceRoomInSn));
        mav.addObject(allProductsTotalPrice, allProductsTotalPriceDb);
        mav.addObject(guestsWatchedCount, guestsWatchCountDb);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	sn.setAttribute(registryCBRoomCountInSn, regiCBRoomCount);
//    	mav.addObject("conceptBoardStatus", "CB Add TO Registry");
//      mav.addObject(registryStyleName, (String) sn.getAttribute(registryStyleNameInSn));
//      mav.addObject(registryPrice, (String) sn.getAttribute(registryPriceInSn));
        return mav;
    }
    
    public int redirectRegistrySelectedConceptBoardsProductsList(HttpServletRequest req, HttpSession sn, Long registryConceptBoardsId) {
    	int allProductsTotalPrice = 0;        
        byte[] conBoardsImageFromDB = null;
        List furnSpecSavingIdList = new ArrayList();
        List furnSpecProductImageList = new ArrayList();
		List furnSpecProductNameList = new ArrayList();
		List furnSpecStoreNameList = new ArrayList();
		List furnSpecProductPriceList = new ArrayList();
		List furnSpecPopUpValuesList = new ArrayList();
		List furnSpecProductImage2List = new ArrayList();
		List furnSpecProductImage3List = new ArrayList();
		List furnSpecProductImage4List = new ArrayList();
        List <AdminRegistryConceptBoardsSaving> registryConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.registrantConceptBoardsSelRoomAndStyleListTakeFromDB(registryConceptBoardsId);
        if (!registryConBdRoomStyleList.isEmpty()) {
        	AdminRegistryConceptBoardsSaving registryConBdRoomModel = adminRegistryConceptBoardsSavingDAO.registrantConceptBoardsSelRoomDataTakeFromDB(registryConceptBoardsId);
        	conBoardsImageFromDB = registryConBdRoomModel.getConceptBoardsImage();
        }
        List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecCount(registryConceptBoardsId);
        double allProductsTotalPriceDb = 0;
        if (!totalFurSpecsProductsList.isEmpty()) {        	
	 		for (AdminRegistryConceptBoardsFurnitureSpecsSaving furnSpecsProductsSavingModel : totalFurSpecsProductsList) {
	 			furnSpecSavingIdList.add(furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId());
    			long conctBoardProductsId = furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId();
    			String conBoardContributedStatus = registrantAllConBoardContributedStatus(req, sn, conctBoardProductsId);
//    			int conBoardIndividualStatus = registrantAllConBoardIndividualStatus(req, sn, conctBoardProductsId);
    			String conBoardPaymentStatus = registrantAllConBoardProductPaymentStatus(req, sn, conctBoardProductsId);
    			String prodCombValues =  furnSpecsProductsSavingModel.getProductSize1() + "_,_" + furnSpecsProductsSavingModel.getProductPrice1() + "_,_" + furnSpecsProductsSavingModel.getProductSize2() + "_,_" + furnSpecsProductsSavingModel.getProductPrice2() + "_,_" + furnSpecsProductsSavingModel.getProductSize3() + "_,_" + furnSpecsProductsSavingModel.getProductPrice3() + "_,_" + furnSpecsProductsSavingModel.getProductSize4() + "_,_" + furnSpecsProductsSavingModel.getProductPrice4() + "_,_" + furnSpecsProductsSavingModel.getProductSize5() + "_,_" + furnSpecsProductsSavingModel.getProductPrice5() + "_,_" + furnSpecsProductsSavingModel.getProductDescription1();
    			String totalPopUpValuesList = furnSpecsProductsSavingModel.getProductName() + "_,_" + furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + furnSpecsProductsSavingModel.getStoreName(); 
    			furnSpecProductImageList.add(furnSpecsProductsSavingModel.getProductUploadedImage1());
	 			furnSpecProductNameList.add(furnSpecsProductsSavingModel.getProductName());
	 			furnSpecStoreNameList.add(furnSpecsProductsSavingModel.getStoreName());
	 			furnSpecProductPriceList.add(furnSpecsProductsSavingModel.getProductPrice1());
	 			furnSpecPopUpValuesList.add(totalPopUpValuesList);
	 			furnSpecProductImage2List.add(furnSpecsProductsSavingModel.getProductUploadedImage2());
	 			furnSpecProductImage3List.add(furnSpecsProductsSavingModel.getProductUploadedImage3());
	 			furnSpecProductImage4List.add(furnSpecsProductsSavingModel.getProductUploadedImage4());
	 			double singleProductPrice = registrantAllProductPriceTotal(req, sn, furnSpecsProductsSavingModel.getProductPrice1());
	 			allProductsTotalPriceDb = allProductsTotalPriceDb + singleProductPrice;
	 		}	 		
	 		sn.setAttribute(regFurnSpecSavingIdList, furnSpecSavingIdList);
	 		sn.setAttribute(regFurnSpecProductImageList, furnSpecProductImageList);
	 		sn.setAttribute(regFurnSpecProductNameList, furnSpecProductNameList);
	 		sn.setAttribute(regFurnSpecStoreNameList, furnSpecStoreNameList);
	 		sn.setAttribute(regFurnSpecProductPriceList, furnSpecProductPriceList);
	 		sn.setAttribute(regFurnSpecPopUpValuesList, furnSpecPopUpValuesList);
	 		sn.setAttribute(regFurnSpecProductImage2List, furnSpecProductImage2List);
	 		sn.setAttribute(regFurnSpecProductImage3List, furnSpecProductImage3List);
	 		sn.setAttribute(regFurnSpecProductImage4List, furnSpecProductImage4List);
 		}
        registryTotalConceptBoardsIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
		registryTotalConceptBoardsContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
		int bothDesConAndFundsCount = registryTotalFundsCombCartCounts(sn);
		sn.setAttribute(regiCartCountInSn, bothDesConAndFundsCount);
        allProductsTotalPrice = (int) Math.round(allProductsTotalPriceDb);                
        sn.setAttribute(conceptBoardsBigImage, conBoardsImageFromDB);        
        return allProductsTotalPrice;
    }
     
    public double registrantAllProductPriceTotal(HttpServletRequest req, HttpSession sn, String singleProductPriceSt) {
    	double singleProductPrice = 0;
    	if(null != singleProductPriceSt) {
    		singleProductPriceSt = singleProductPriceSt.replace(",", ""); 
    		singleProductPrice = Double.parseDouble(singleProductPriceSt);
    	}    
    	return singleProductPrice;
    }

    public String registrantAllConBoardContributedStatus(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId) {
    	String conBoardContributedStatus = null;
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
    	if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	double contributedQuantityCount = registrantCBContributedQuantityCountFromDB(req, sn, regCBContributedUpdateModel.getContributedPrice(), regCBContributedUpdateModel.getRemainingTotalPrice(), regCBContributedUpdateModel.getQuantity());
        	conBoardContributedStatus = "Contributed" + "_,_" + regCBContributedUpdateModel.getQuantity() + "_,_" + contributedQuantityCount;
        } else if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualDeleteModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);        	
        	int giftedQuantity = regCBIndividualDeleteModel.getQuantity() - regCBIndividualDeleteModel.getRemainingQuantity();
        	conBoardContributedStatus = "Individual" + "_,_" + regCBIndividualDeleteModel.getQuantity() + "_,_" + giftedQuantity;
        } else {
        	conBoardContributedStatus = "No Payment" + "_,_" + 1 + "_,_" + 0;
        }
        return conBoardContributedStatus;
    }

    public String registrantAllConBoardProductPaymentStatus(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId) {
    	String conBoardPaymentStatus = null;
    	String conBoardContPaymentStatus = registrantCBProductContributedPaymentStatus(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
    	String conBoardIndPaymentStatus = registrantCBProductIndividualPaymentStatus(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
    	if(null != conBoardContPaymentStatus) {
    		conBoardPaymentStatus = conBoardContPaymentStatus;
    	} else if(null != conBoardIndPaymentStatus) {
    		conBoardPaymentStatus = conBoardIndPaymentStatus;
    	}    	
    	return conBoardPaymentStatus;
    }
    
    public String registrantCBProductContributedPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long adminRegCBFSpecsSavingId) {
    	String conBoardContPaymentStatus = null;
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataCheckInDB(registrantUserId, adminRegCBFSpecsSavingId);
    	long conBoardsProductSavingId = 0;
    	if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataTakeFromDB(registrantUserId, adminRegCBFSpecsSavingId);
        	conBoardsProductSavingId = regCBContributedUpdateModel.getRegistrantConceptBoardsContributedProductsInfoSavingId();
    	}
    	List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsPaymentDataCheckInDB(registrantUserId, conBoardsProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsPaymentDataTakeFromDB(registrantUserId, conBoardsProductSavingId);
    		conBoardContPaymentStatus = regDesigenConceptBoardsModel.getCheckoutPaymentStatus();
    	}    	
    	return conBoardContPaymentStatus;
    }
    
    public String registrantCBProductIndividualPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long adminRegCBFSpecsSavingId) {
    	String conBoardIndPaymentStatus = null;    	
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataCheckInDB(registrantUserId, adminRegCBFSpecsSavingId);
    	long conBoardsIndProductSavingId = 0;
    	if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualDeleteModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataTakeFromDB(registrantUserId, adminRegCBFSpecsSavingId);
        	conBoardsIndProductSavingId = regCBIndividualDeleteModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId();
        }
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptIndBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPaymentStatusCheck(registrantUserId, conBoardsIndProductSavingId);
    	if (!regDesigenConceptIndBoardsList.isEmpty()) {
    		RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptIndBoardsModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPaymentStatusValue(registrantUserId, conBoardsIndProductSavingId);
    		conBoardIndPaymentStatus = regDesigenConceptIndBoardsModel.getCheckoutPaymentStatus();
    	}
    	return conBoardIndPaymentStatus;
    }
    
    @Override
    @Transactional
    public int registryTotalConceptBoardsContributedCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int registryConceptBoardsContCount = 0;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedTotalCartCount(registrantUserId);
        registryConceptBoardsContCount = regDesigenConceptBoardsList.size();        		
        sn.setAttribute(regCBContributedCartCountInSn, registryConceptBoardsContCount);
        return registryConceptBoardsContCount;
    }

    public int registryTotalFundsCombCartCounts(HttpSession sn) {
    	int regTotalFundsCombCount = 0;
    	int registryRoomFundsCount = 0;
    	int registryCashFundCount = 0;
    	int registryCustomFundCount = 0;
    	int regCBContributedCount = 0;
    	int regCBIndividualCount = 0;
    	int regFTContributedCount = 0;
    	int regFTIndividualCount = 0;
    	if(null != sn.getAttribute(registryRoomFundsCountInSn)) {
    		registryRoomFundsCount = (int) sn.getAttribute(registryRoomFundsCountInSn);
    	}
    	if(null != sn.getAttribute(registryCashFundsCountInSn)) {
    		registryCashFundCount = (int) sn.getAttribute(registryCashFundsCountInSn);
    	}
    	if(null != sn.getAttribute(registryCustomFundsCountInSn)) {
    		registryCustomFundCount = (int) sn.getAttribute(registryCustomFundsCountInSn);
    	}
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
    	regTotalFundsCombCount = registryRoomFundsCount + registryCashFundCount + registryCustomFundCount + regCBContributedCount + regCBIndividualCount + regFTContributedCount + regFTIndividualCount;    	
    	return regTotalFundsCombCount;
    }
    
    @Override
    @Transactional
    public ModelAndView registrantConceptBoardInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        long adminRegCBFSpecsSavingId = Long.parseLong(req.getParameter(productInfoSavingInfo));
        int quantity = Integer.parseInt(req.getParameter(productQuantity));
        String regiProductHeading = req.getParameter(regProductHeading);
        String regiProductPrice = req.getParameter(regProductPrice);
        regiProductPrice= regiProductPrice.replace(",", "");
        String regiDescription = req.getParameter(registryDescription);
        String groupGiftRefferance = req.getParameter(groupGiftRefferanceValue);        
        Timestamp currentDate = currentDate();
        if((groupGiftRefferanceVal).equals(groupGiftRefferance)) {
        	mav = registrantConceptBoardContributedInfoSavingInDB(req, sn, adminRegCBFSpecsSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate);
        } else {
        	mav = registrantConceptBoardIndividualInfoSavingInDB(req, sn, adminRegCBFSpecsSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate);
        }
        sn.setAttribute(registrySpaceRoomInSn, req.getParameter(registrySpaceRoom));
        sn.setAttribute(registryStyleNameInSn, req.getParameter(registryStyleName));
        sn.setAttribute(registryPriceInSn, req.getParameter(registryPrice));
        sn.setAttribute(regViewProductsInSn, req.getParameter(registryViewProducts));              
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantConceptBoardContributedInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate) {
        ModelAndView mav;
        List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualDeleteModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.delete(regCBIndividualDeleteModel);        	
        }
        double regiProductPriceDb = Double.parseDouble(regiProductPrice);
        double shippingFee = (regiProductPriceDb/100)*10;
        double stateTaxFee = (regiProductPriceDb/100)*8;
        double totalTaxtFee = shippingFee + stateTaxFee;
        double contributedAmountDb = regiProductPriceDb + totalTaxtFee;
        double totalContributedAmountDb = contributedAmountDb * quantity;
		String totalContributedAmount = String.format("%.2f", totalContributedAmountDb);
		String allTaxsTotalPrice = String.format("%.2f", totalTaxtFee);
        List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	String conBoardContrRemAmount = conceptBoardContributedRemainingAmount(totalContributedAmountDb, regCBContributedUpdateModel.getContributedPrice(), regCBContributedUpdateModel.getRemainingTotalPrice());
        	regCBContributedUpdateModel.setContributedPrice(totalContributedAmount);
        	regCBContributedUpdateModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regCBContributedUpdateModel.setQuantity(quantity);
        	regCBContributedUpdateModel.setProductPrice(regiProductPrice);
        	regCBContributedUpdateModel.setProductDescription(regiDescription);
        	regCBContributedUpdateModel.setProductHeading(regiProductHeading);
        	regCBContributedUpdateModel.setUpdatedDate(currentDate);
        	regCBContributedUpdateModel.setRemainingTotalPrice(conBoardContrRemAmount);
        	registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedUpdateModel);
        } else {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = new RegistrantConceptBoardsContributedProductsInfoSaving();
        	regCBContributedSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regCBContributedSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(adminRegCBFSpecsSavingId);
        	regCBContributedSavingModel.setContributedPrice(totalContributedAmount);
        	regCBContributedSavingModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regCBContributedSavingModel.setQuantity(quantity);
        	regCBContributedSavingModel.setProductPrice(regiProductPrice);
        	regCBContributedSavingModel.setProductDescription(regiDescription);
        	regCBContributedSavingModel.setProductHeading(regiProductHeading);
        	regCBContributedSavingModel.setCreatedDate(currentDate);        	
        	regCBContributedSavingModel.setRemainingTotalPrice(totalContributedAmount);        	
        	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBordModel=  adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(adminRegCBFSpecsSavingId);
        	regCBContributedSavingModel.setProductName(admRegConBordModel.getProductName());
        	regCBContributedSavingModel.setProductUploadedImage(admRegConBordModel.getProductUploadedImage1());
        	regCBContributedSavingModel.setStoreName(admRegConBordModel.getStoreName());
        	regCBContributedSavingModel.setStoreUrl(admRegConBordModel.getStoreUrl());
        	registrantConceptBoardsContributedProductsInfoSavingDAO.save(regCBContributedSavingModel);
        }        
        registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        mav = new ModelAndView(redirectStatus + redirectRegistrySelectedConceptBoards);        
        return mav;
    }

    public String conceptBoardContributedRemainingAmount(double totalContributedAmount, String conBoardGiftedAmount, String remainingAmount) {
    	String conBoardContrRemAmount = null;
    	double conBoardContAmountDb = 0;
    	if(null != conBoardGiftedAmount) {
    		conBoardContAmountDb = Double.parseDouble(conBoardGiftedAmount);
    	}    	
    	double contributeRemAmountDb = totalContributedAmount - conBoardContAmountDb;
    	double remainingAmountDb = 0;
    	if(null != remainingAmount) {
    		remainingAmountDb = Double.parseDouble(remainingAmount);
    	}
    	double totalRemainingAmount = remainingAmountDb + contributeRemAmountDb;
    	conBoardContrRemAmount = String.format("%.2f", totalRemainingAmount);
    	return conBoardContrRemAmount;
    }

    @Override
    @Transactional
    public ModelAndView registrantConceptBoardIndividualInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate) {
        ModelAndView mav;
        List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	registrantConceptBoardsContributedProductsInfoSavingDAO.delete(regCBContributedUpdateModel);
        }        
        List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);        	
        	int dbQuantity = regCBIndividualUpdateModel.getQuantity();
        	int remQuantity = quantity - dbQuantity;
        	int conBoardGiftedQuantity = 0;
        	if(null != regCBIndividualUpdateModel.getRemainingQuantity()) {
        		conBoardGiftedQuantity = regCBIndividualUpdateModel.getRemainingQuantity();
        	}
        	int giftedRemQuantity = remQuantity + conBoardGiftedQuantity;
        	regCBIndividualUpdateModel.setQuantity(quantity);
        	regCBIndividualUpdateModel.setProductPrice(regiProductPrice);
        	regCBIndividualUpdateModel.setProductDescription(regiDescription);
        	regCBIndividualUpdateModel.setProductHeading(regiProductHeading);
        	regCBIndividualUpdateModel.setUpdatedDate(currentDate);
        	regCBIndividualUpdateModel.setRemainingQuantity(giftedRemQuantity);
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualUpdateModel);
        } else {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
        	regCBIndividualSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regCBIndividualSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(adminRegCBFSpecsSavingId);
        	regCBIndividualSavingModel.setQuantity(quantity);
        	regCBIndividualSavingModel.setProductPrice(regiProductPrice);
        	regCBIndividualSavingModel.setProductDescription(regiDescription);
        	regCBIndividualSavingModel.setProductHeading(regiProductHeading);
        	regCBIndividualSavingModel.setCreatedDate(currentDate);
        	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBordModel=  adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(adminRegCBFSpecsSavingId);
        	regCBIndividualSavingModel.setProductName(admRegConBordModel.getProductName());
        	regCBIndividualSavingModel.setProductUploadedImage(admRegConBordModel.getProductUploadedImage1());        	
    		regCBIndividualSavingModel.setRemainingQuantity(quantity);
    		regCBIndividualSavingModel.setStoreName(admRegConBordModel.getStoreName());
    		regCBIndividualSavingModel.setStoreUrl(admRegConBordModel.getStoreUrl());
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.save(regCBIndividualSavingModel);
        }        
        registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        mav = new ModelAndView(redirectStatus + redirectRegistrySelectedConceptBoards);        
        return mav;
    }

    @Override
    @Transactional
    public String registryConceptBoardsContributedProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regConBoardsContributedRef = null;
        List cbContributedProductSavingIdList = new ArrayList();
        List cbContributedProductImageList = new ArrayList();
		List cbContributedProductNameList = new ArrayList();
		List cbContributedProductPriceList = new ArrayList();
		List cbContributedProductQuantityList = new ArrayList();
		List cbContributedRemainingAmountList = new ArrayList();
		List cbContributedAmountList = new ArrayList();	
		List cbContributedPaymentStatusList = new ArrayList();
		List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedTotalInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedTotalDataTakeFromDB(registrantUserId);
		if (!regCBContributedTotalInfoList.isEmpty()) {
    		for (RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel : regCBContributedTotalInfoList) {
    			cbContributedProductSavingIdList.add(regCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			cbContributedProductImageList.add(regCBContributedSavingModel.getProductUploadedImage());    			
    			cbContributedProductNameList.add(regCBContributedSavingModel.getProductName());
    			double totalWithTaxValue = 0;
    			if(null != regCBContributedSavingModel.getProductPrice()) {
    				double totalRegConProductPrice = Double.parseDouble(regCBContributedSavingModel.getProductPrice());
    				totalWithTaxValue = totalRegConProductPrice + (totalRegConProductPrice/100)*18;
    			}
    			cbContributedProductPriceList.add(totalWithTaxValue);
    			cbContributedProductQuantityList.add(regCBContributedSavingModel.getQuantity()); 
    			cbContributedRemainingAmountList.add(regCBContributedSavingModel.getRemainingTotalPrice());
    			String regCBContributedPrice = registryConceptBoardsContributedPrice(req, sn, registrantUserId, regCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			cbContributedAmountList.add(regCBContributedPrice);
    			String regCBContributedPaymentStatus = registryConceptBoardsContributedPaymentStatus(req, sn, registrantUserId, regCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			cbContributedPaymentStatusList.add(regCBContributedPaymentStatus);
        	}
    		sn.setAttribute(cbContributedProductSavingIdListInSn, cbContributedProductSavingIdList);
	 		sn.setAttribute(cbContributedProductImageListInSn, cbContributedProductImageList);
	 		sn.setAttribute(cbContributedProductNameListInSn, cbContributedProductNameList);
	 		sn.setAttribute(cbContributedProductPriceListInSn, cbContributedProductPriceList);
	 		sn.setAttribute(cbContributedProductQuantityListInSn, cbContributedProductQuantityList);
	 		sn.setAttribute(cbContributedRemainingAmountListInSn, cbContributedRemainingAmountList);
	 		sn.setAttribute(cbContributedAmountListInSn, cbContributedAmountList);
	 		sn.setAttribute(cbContributedPaymentStatusListInSn, cbContributedPaymentStatusList);
    	} else {
    		sn.setAttribute(cbContributedProductSavingIdListInSn, null);
	 		sn.setAttribute(cbContributedProductImageListInSn, null);
	 		sn.setAttribute(cbContributedProductNameListInSn, null);
	 		sn.setAttribute(cbContributedProductPriceListInSn, null);
	 		sn.setAttribute(cbContributedProductQuantityListInSn, null);
	 		sn.setAttribute(cbContributedRemainingAmountListInSn, null);
	 		sn.setAttribute(cbContributedAmountListInSn, null);
	 		sn.setAttribute(cbContributedPaymentStatusListInSn, null);
    	}
        return regConBoardsContributedRef;
    }
    
    public String registryConceptBoardsContributedPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductSavingId) {
        String regCBContributedPrice = null;
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceCheckInDB(registrantUserId, cbContributedProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceTakeFromDB(registrantUserId, cbContributedProductSavingId);
    		regCBContributedPrice = regDesigenConceptBoardsModel.getContributedPrice();
    	}
        return regCBContributedPrice;
    }

    public String registryConceptBoardsContributedPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbContributedProductSavingId) {
        String regCBContributedPaymentStatus = null;
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusCheckInDB(registrantUserId, cbContributedProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPaymentStatusTakeFromDB(registrantUserId, cbContributedProductSavingId);
    		regCBContributedPaymentStatus = "Contibuted Payment";
    	}
        return regCBContributedPaymentStatus;
    }

    @Override
    @Transactional
    public String registryConceptBoardsIndividualProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regConBoardsIndividualRef = null;
        List cbIndividualProductSavingIdList = new ArrayList();
        List cbIndividualProductImageList = new ArrayList();
		List cbIndividualProductNameList = new ArrayList();
		List cbIndividualProductPriceList = new ArrayList();
		List cbIndividualProductQuantityList = new ArrayList();
		List cbIndividualRemainingQuantityList = new ArrayList();
		List cbIndividualGivenQuantityList = new ArrayList();
		List cbIndividualPaymentStatusList = new ArrayList();
		List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualTotalInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualTotalDataTakeFromDB(registrantUserId);
		if (!regCBIndividualTotalInfoList.isEmpty()) {
    		for (RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualSavingModel : regCBIndividualTotalInfoList) {
    			cbIndividualProductSavingIdList.add(regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			cbIndividualProductImageList.add(regCBIndividualSavingModel.getProductUploadedImage());    			
    			cbIndividualProductNameList.add(regCBIndividualSavingModel.getProductName());
    			cbIndividualProductPriceList.add(regCBIndividualSavingModel.getProductPrice());
    			cbIndividualProductQuantityList.add(regCBIndividualSavingModel.getQuantity()); 
    			cbIndividualRemainingQuantityList.add(regCBIndividualSavingModel.getRemainingQuantity());
    			int regCBIndividualGivenQuantity = registryConceptBoardsIndividualPrice(req, sn, registrantUserId, regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			cbIndividualGivenQuantityList.add(regCBIndividualGivenQuantity);
    			String regCBIndividualPaymentStatus = registryConceptBoardsIndividualPaymentStatus(req, sn, registrantUserId, regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			cbIndividualPaymentStatusList.add(regCBIndividualPaymentStatus);
        	}
    		sn.setAttribute(cbIndividualProductSavingIdListInSn, cbIndividualProductSavingIdList);
	 		sn.setAttribute(cbIndividualProductImageListInSn, cbIndividualProductImageList);
	 		sn.setAttribute(cbIndividualProductNameListInSn, cbIndividualProductNameList);
	 		sn.setAttribute(cbIndividualProductPriceListInSn, cbIndividualProductPriceList);
	 		sn.setAttribute(cbIndividualProductQuantityListInSn, cbIndividualProductQuantityList);
	 		sn.setAttribute(cbIndividualRemainingQuantityListInSn, cbIndividualRemainingQuantityList);
	 		sn.setAttribute(cbIndividualGivenQuantityListInSn, cbIndividualGivenQuantityList);
	 		sn.setAttribute(cbIndividualPaymentStatusListInSn, cbIndividualPaymentStatusList);
    	} else {
    		sn.setAttribute(cbIndividualProductSavingIdListInSn, null);
	 		sn.setAttribute(cbIndividualProductImageListInSn, null);
	 		sn.setAttribute(cbIndividualProductNameListInSn, null);
	 		sn.setAttribute(cbIndividualProductPriceListInSn, null);
	 		sn.setAttribute(cbIndividualProductQuantityListInSn, null);
	 		sn.setAttribute(cbIndividualRemainingQuantityListInSn, null);
	 		sn.setAttribute(cbIndividualGivenQuantityListInSn, null);
	 		sn.setAttribute(cbIndividualPaymentStatusListInSn, null);
    	}
        return regConBoardsIndividualRef;
    }

    public Integer registryConceptBoardsIndividualPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualProductSavingId) {
        int regCBIndividualGivenQuantity = 0;
        List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceCheckInDB(registrantUserId, cbIndividualProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceTakeFromDB(registrantUserId, cbIndividualProductSavingId);
    		regCBIndividualGivenQuantity = regDesigenConceptBoardsModel.getGiftedQuantity();
    	}
        return regCBIndividualGivenQuantity;
    }

    public String registryConceptBoardsIndividualPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long cbIndividualProductSavingId) {
    	String regCBIndividualPaymentStatus = null;
        List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPaymentStatusCheckInDB(registrantUserId, cbIndividualProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPaymentStatusTakeFromDB(registrantUserId, cbIndividualProductSavingId);
    		regCBIndividualPaymentStatus = "Individual Payment";
    	}
        return regCBIndividualPaymentStatus;
    }

    @Override
    @Transactional
    public int registryTotalConceptBoardsIndividualCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int registryConceptBoardsContCount = 0;    	
	    List<RegistrantConceptBoardsIndividualPaymentSaving> regConceptBoardsIndividualList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
	    if (!regConceptBoardsIndividualList.isEmpty()) {
	    	for (RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptBoardsModel : regConceptBoardsIndividualList) {
	    		registryConceptBoardsContCount = registryConceptBoardsContCount + regDesigenConceptBoardsModel.getGiftedQuantity();        		
	    	}	        
	    }
	    sn.setAttribute(regCBIndividualCountInSn, registryConceptBoardsContCount);
	    return registryConceptBoardsContCount;    	
    }

    @Override
    @Transactional
    public ModelAndView registrantCBContributedSelectedProductEditInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String totalPopUpValuesList = null;
    	long regiCBCotributedProductSavingId = Long.parseLong(req.getParameter(regCBCotributedProductSavingId));    	
        String prodPrice = null;
        String prodDescription = null;
        String productsSize = null;
        int prodCount = 0;
        String hidePriceGuests = null;
        RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
        long admRegConBoardProductId = regCBContributedUpdateModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId();
        String conBoardContributedStatus = registrantAllConBoardContributedStatus(req, sn, admRegConBoardProductId);
//		int conBoardIndividualStatus = registrantAllConBoardIndividualStatus(req, sn, admRegConBoardProductId);
		String conBoardPaymentStatus = registrantAllConBoardProductPaymentStatus(req, sn, admRegConBoardProductId);		
        List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsInDB(admRegConBoardProductId);
		if (!totalFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving totalFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(admRegConBoardProductId);
			String furSpecProdImage = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage1()) {
    	    	byte[] fsProdImageFromDB = totalFurSpecsProductsModel.getProductUploadedImage1();
    	    	furSpecProdImage = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB);
        	}
    		String productImage2 = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage2()) {
    	    	byte[] fsProdImageFromDB2 = totalFurSpecsProductsModel.getProductUploadedImage2();
    	    	productImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB2);
        	}
    		String productImage3 = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage3()) {
    	    	byte[] fsProdImageFromDB3 = totalFurSpecsProductsModel.getProductUploadedImage3();
    	    	productImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB3);
        	}
    		String productImage4 = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage4()) {
    	    	byte[] fsProdImageFromDB4 = totalFurSpecsProductsModel.getProductUploadedImage4();
    	    	productImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB4);
        	}
    		String prodCombValues =  totalFurSpecsProductsModel.getProductSize1() + "_,_" + totalFurSpecsProductsModel.getProductPrice1() + "_,_" + totalFurSpecsProductsModel.getProductSize2() + "_,_" + totalFurSpecsProductsModel.getProductPrice2() + "_,_" + totalFurSpecsProductsModel.getProductSize3() + "_,_" + totalFurSpecsProductsModel.getProductPrice3() + "_,_" + totalFurSpecsProductsModel.getProductSize4() + "_,_" + totalFurSpecsProductsModel.getProductPrice4() + "_,_" + totalFurSpecsProductsModel.getProductSize5() + "_,_" + totalFurSpecsProductsModel.getProductPrice5() + "_,_" + totalFurSpecsProductsModel.getProductDescription1();
    		
    		totalPopUpValuesList = regCBContributedUpdateModel.getProductName() + "_,_" + furSpecProdImage + "_,_" + productImage2 + "_,_" + productImage3 + "_,_" + productImage4 + "_,_" + totalFurSpecsProductsModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regCBContributedUpdateModel.getStoreName();   		
    		prodPrice = regCBContributedUpdateModel.getProductPrice();
    		prodDescription = regCBContributedUpdateModel.getProductDescription();
    		productsSize = regCBContributedUpdateModel.getProductHeading();
            prodCount = regCBContributedUpdateModel.getQuantity();            
	 	} else {	 		 
	 		String prodCombValues =  regCBContributedUpdateModel.getProductHeading() + "_,_" + regCBContributedUpdateModel.getProductPrice() + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + regCBContributedUpdateModel.getProductDescription();
	 		String furSpecProdcImage = null;
    		if(null != regCBContributedUpdateModel.getProductUploadedImage()) {
    	    	byte[] fsProdImageFromDB = regCBContributedUpdateModel.getProductUploadedImage();
    	    	furSpecProdcImage = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB);
        	}
    		totalPopUpValuesList = regCBContributedUpdateModel.getProductName() + "_,_" + furSpecProdcImage + "_,_" + null + "_,_" + null + "_,_" + null + "_,_" + regCBContributedUpdateModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regCBContributedUpdateModel.getStoreName(); 
    		prodPrice = regCBContributedUpdateModel.getProductPrice();
    		prodDescription = regCBContributedUpdateModel.getProductDescription();
    		productsSize = regCBContributedUpdateModel.getProductHeading();
            prodCount = regCBContributedUpdateModel.getQuantity();            
	 	}
		mav = new ModelAndView(regConceptBoardsContributedProductEdit);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(totalProdPopUpValuesList, totalPopUpValuesList);    	
    	mav.addObject(productsPrice, prodPrice);
    	mav.addObject(productsDescription, prodDescription);
    	mav.addObject(productSize, productsSize);
    	mav.addObject(productsCount, prodCount);    	
    	mav.addObject(hidePriceGuest, hidePriceGuests);
    	mav.addObject(regConBoardPaymentStatus, conBoardPaymentStatus);
    	return mav;
    }

    public double registrantCBContributedQuantityCountFromDB(HttpServletRequest req, HttpSession sn, String requestedTotalPrice, String remainingTotalPrice, int quantity) {
    	double contributedQuantityCount = 1;
    	double requestedTotalPriceDb = 0;
    	if(null != requestedTotalPrice) {
    		requestedTotalPriceDb = Double.parseDouble(requestedTotalPrice);
    	}
    	double remainingTotalPriceDb = 0;
    	if(null != remainingTotalPrice) {
    		remainingTotalPriceDb = Double.parseDouble(remainingTotalPrice);
    	}
    	double totalContributedPrice = requestedTotalPriceDb - remainingTotalPriceDb;
    	if(totalContributedPrice > 0) {
    		double productActuallyPrice = requestedTotalPriceDb / quantity;
    		contributedQuantityCount = totalContributedPrice / productActuallyPrice;
    	}
    	return contributedQuantityCount;
    }

    @Override
    @Transactional
    public ModelAndView registrantCBIndividualSelectedProductEditInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String totalPopUpValuesList = null;
    	long regiCBIndividualProductSavingId = Long.parseLong(req.getParameter(regCBIndividualProductSavingId));
    	String prodPrice = null;
        String prodDescription = null;
        String productsSize = null;
        int prodCount = 0;
        String hidePriceGuests = null;
        RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBIndividualProductSavingId);
        long admRegConBoardProductId = regCBIndividualUpdateModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId();
        String conBoardContributedStatus = registrantAllConBoardContributedStatus(req, sn, admRegConBoardProductId);
//		int conBoardIndividualStatus = registrantAllConBoardIndividualStatus(req, sn, admRegConBoardProductId);
		String conBoardPaymentStatus = registrantAllConBoardProductPaymentStatus(req, sn, admRegConBoardProductId);		
        List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsInDB(admRegConBoardProductId);
        if (!totalFurSpecsProductsList.isEmpty()) {
			AdminRegistryConceptBoardsFurnitureSpecsSaving totalFurSpecsProductsModel = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(admRegConBoardProductId);
			String furSpecProdImage = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage1()) {
    	    	byte[] fsProdImageFromDB = totalFurSpecsProductsModel.getProductUploadedImage1();
    	    	furSpecProdImage = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB);
        	}
    		String productImage2 = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage2()) {
    	    	byte[] fsProdImageFromDB2 = totalFurSpecsProductsModel.getProductUploadedImage2();
    	    	productImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB2);
        	}
    		String productImage3 = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage3()) {
    	    	byte[] fsProdImageFromDB3 = totalFurSpecsProductsModel.getProductUploadedImage3();
    	    	productImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB3);
        	}
    		String productImage4 = null;
    		if(null != totalFurSpecsProductsModel.getProductUploadedImage4()) {
    	    	byte[] fsProdImageFromDB4 = totalFurSpecsProductsModel.getProductUploadedImage4();
    	    	productImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB4);
        	}
    		String prodCombValues =  totalFurSpecsProductsModel.getProductSize1() + "_,_" + totalFurSpecsProductsModel.getProductPrice1() + "_,_" + totalFurSpecsProductsModel.getProductSize2() + "_,_" + totalFurSpecsProductsModel.getProductPrice2() + "_,_" + totalFurSpecsProductsModel.getProductSize3() + "_,_" + totalFurSpecsProductsModel.getProductPrice3() + "_,_" + totalFurSpecsProductsModel.getProductSize4() + "_,_" + totalFurSpecsProductsModel.getProductPrice4() + "_,_" + totalFurSpecsProductsModel.getProductSize5() + "_,_" + totalFurSpecsProductsModel.getProductPrice5() + "_,_" + totalFurSpecsProductsModel.getProductDescription1();
    		
    		totalPopUpValuesList = regCBIndividualUpdateModel.getProductName() + "_,_" + furSpecProdImage + "_,_" + productImage2 + "_,_" + productImage3 + "_,_" + productImage4 + "_,_" + totalFurSpecsProductsModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regCBIndividualUpdateModel.getStoreName();  		
    		prodPrice = regCBIndividualUpdateModel.getProductPrice();
    		prodDescription = regCBIndividualUpdateModel.getProductDescription();
    		productsSize = regCBIndividualUpdateModel.getProductHeading();
            prodCount = regCBIndividualUpdateModel.getQuantity();            
	 	} else {	 		 
	 		String prodCombValues =  regCBIndividualUpdateModel.getProductHeading() + "_,_" + regCBIndividualUpdateModel.getProductPrice() + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + regCBIndividualUpdateModel.getProductDescription();
	 		String furSpecProdcImage = null;
    		if(null != regCBIndividualUpdateModel.getProductUploadedImage()) {
    	    	byte[] fsProdImageFromDB = regCBIndividualUpdateModel.getProductUploadedImage();
    	    	furSpecProdcImage = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB);
        	}
    		totalPopUpValuesList = regCBIndividualUpdateModel.getProductName() + "_,_" + furSpecProdcImage + "_,_" + null + "_,_" + null + "_,_" + null + "_,_" + regCBIndividualUpdateModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regCBIndividualUpdateModel.getStoreName();
    		prodPrice = regCBIndividualUpdateModel.getProductPrice();
    		prodDescription = regCBIndividualUpdateModel.getProductDescription();
    		productsSize = regCBIndividualUpdateModel.getProductHeading();
            prodCount = regCBIndividualUpdateModel.getQuantity();            
	 	}
		mav = new ModelAndView(regConceptBoardsContributedProductEdit);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(totalProdPopUpValuesList, totalPopUpValuesList);    	
    	mav.addObject(productsPrice, prodPrice);
    	mav.addObject(productsDescription, prodDescription);
    	mav.addObject(productSize, productsSize);
    	mav.addObject(productsCount, prodCount);    	
    	mav.addObject(hidePriceGuest, hidePriceGuests);
    	mav.addObject(regConBoardPaymentStatus, conBoardPaymentStatus);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView regCBContributedSelectedProductDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        long adminRegCBFSpecsSavingId = Long.parseLong(req.getParameter(productInfoSavingInfo));
        int quantity = Integer.parseInt(req.getParameter(productQuantity));
        String regiProductHeading = req.getParameter(regProductHeading);        
        String regiProductPrice = req.getParameter(regProductPrice);
        regiProductPrice= regiProductPrice.replace(",", "");
        String regiDescription = req.getParameter(registryDescription);
        String groupGiftRefferance = req.getParameter(groupGiftRefferanceValue);
        Timestamp currentDate = currentDate();
        if((groupGiftRefferanceVal).equals(groupGiftRefferance)) {
        	registrantConceptBoardContributedInfoUpdateInDB(req, sn, adminRegCBFSpecsSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate);
        } else {
        	registrantConceptBoardIndividualInfoUpdateInDB(req, sn, adminRegCBFSpecsSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate);
        }
        mav = new ModelAndView(redirectStatus + registryOverview);
        return mav;
    }

    public String registrantConceptBoardContributedInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate) {
    	String registrantConceptBoardContributedVal = null;
        List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualDeleteModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.delete(regCBIndividualDeleteModel);        	
        }
        double regiProductPriceDb = Double.parseDouble(regiProductPrice);
        double shippingFee = (regiProductPriceDb/100)*10;
        double stateTaxFee = (regiProductPriceDb/100)*8;
        double totalTaxtFee = shippingFee + stateTaxFee;
        double contributedAmountDb = regiProductPriceDb + totalTaxtFee;
        double totalContributedAmountDb = contributedAmountDb * quantity;
		String totalContributedAmount = String.format("%.2f", totalContributedAmountDb);
		String allTaxsTotalPrice = String.format("%.2f", totalTaxtFee);
        List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	String conBoardContrRemAmount = conceptBoardContributedRemainingAmount(totalContributedAmountDb, regCBContributedUpdateModel.getContributedPrice(), regCBContributedUpdateModel.getRemainingTotalPrice());
        	regCBContributedUpdateModel.setContributedPrice(totalContributedAmount);
        	regCBContributedUpdateModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regCBContributedUpdateModel.setQuantity(quantity);
        	regCBContributedUpdateModel.setProductPrice(regiProductPrice);
        	regCBContributedUpdateModel.setProductDescription(regiDescription);
        	regCBContributedUpdateModel.setProductHeading(regiProductHeading);
        	regCBContributedUpdateModel.setUpdatedDate(currentDate);
        	regCBContributedUpdateModel.setRemainingTotalPrice(conBoardContrRemAmount);
        	registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedUpdateModel);
        } else {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedSavingModel = new RegistrantConceptBoardsContributedProductsInfoSaving();
        	regCBContributedSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regCBContributedSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(adminRegCBFSpecsSavingId);
        	regCBContributedSavingModel.setContributedPrice(totalContributedAmount);
        	regCBContributedSavingModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regCBContributedSavingModel.setQuantity(quantity);
        	regCBContributedSavingModel.setProductPrice(regiProductPrice);
        	regCBContributedSavingModel.setProductDescription(regiDescription);
        	regCBContributedSavingModel.setProductHeading(regiProductHeading);
        	regCBContributedSavingModel.setCreatedDate(currentDate);        	
        	regCBContributedSavingModel.setRemainingTotalPrice(totalContributedAmount);        	
        	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBordModel=  adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(adminRegCBFSpecsSavingId);
        	regCBContributedSavingModel.setProductName(admRegConBordModel.getProductName());
        	regCBContributedSavingModel.setProductUploadedImage(admRegConBordModel.getProductUploadedImage1());
        	registrantConceptBoardsContributedProductsInfoSavingDAO.save(regCBContributedSavingModel);
        }        
        registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        return registrantConceptBoardContributedVal;
    }

    public String registrantConceptBoardIndividualInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate) {
    	String registrantConceptBoardIndividualVal = null;
        List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedUpdateModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	registrantConceptBoardsContributedProductsInfoSavingDAO.delete(regCBContributedUpdateModel);
        }        
        List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegCBFSpecsSavingId);
        	int dbQuantity = regCBIndividualUpdateModel.getQuantity();
        	int remQuantity = quantity - dbQuantity;
        	int conBoardGiftedQuantity = 0;
        	if(null != regCBIndividualUpdateModel.getRemainingQuantity()) {
        		conBoardGiftedQuantity = regCBIndividualUpdateModel.getRemainingQuantity();
        	}
        	int giftedRemQuantity = remQuantity + conBoardGiftedQuantity;
        	regCBIndividualUpdateModel.setQuantity(quantity);
        	regCBIndividualUpdateModel.setProductPrice(regiProductPrice);
        	regCBIndividualUpdateModel.setProductDescription(regiDescription);
        	regCBIndividualUpdateModel.setProductHeading(regiProductHeading);
        	regCBIndividualUpdateModel.setUpdatedDate(currentDate);
        	regCBIndividualUpdateModel.setRemainingQuantity(giftedRemQuantity);
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualUpdateModel);
        } else {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualSavingModel = new RegistrantConceptBoardsIndividualProductsInfoSaving();
        	regCBIndividualSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regCBIndividualSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(adminRegCBFSpecsSavingId);
        	regCBIndividualSavingModel.setQuantity(quantity);
        	regCBIndividualSavingModel.setProductPrice(regiProductPrice);
        	regCBIndividualSavingModel.setProductDescription(regiDescription);
        	regCBIndividualSavingModel.setProductHeading(regiProductHeading);
        	regCBIndividualSavingModel.setCreatedDate(currentDate);
        	AdminRegistryConceptBoardsFurnitureSpecsSaving admRegConBordModel=  adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(adminRegCBFSpecsSavingId);
        	regCBIndividualSavingModel.setProductName(admRegConBordModel.getProductName());
        	regCBIndividualSavingModel.setProductUploadedImage(admRegConBordModel.getProductUploadedImage1());        	
    		regCBIndividualSavingModel.setRemainingQuantity(quantity);
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.save(regCBIndividualSavingModel);
        }        
        registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        return registrantConceptBoardIndividualVal;
    }
    
    @Override
    @Transactional
    public JSONArray jSonConceptBoardsContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn) {
    	regSelectCBContributedDataDeleteFromDB(req, sn, regCBCotributedSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }

    public String regSelectCBContributedDataDeleteFromDB(HttpServletRequest req, HttpSession sn, String regCBCotributedSavingId) {
    	String regCBContributedData = null;
    	long regiCBCotributedProductSavingId = Long.parseLong(regCBCotributedSavingId);
    	List<RegistrantConceptBoardsContributedProductsInfoSaving> regCBContributedInfoList = registrantConceptBoardsContributedProductsInfoSavingDAO.regConceptBoardsContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
        if (!regCBContributedInfoList.isEmpty()) {
        	RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedDeleteModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
        	registrantConceptBoardsContributedProductsInfoSavingDAO.delete(regCBContributedDeleteModel);
        }        
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
    		registrantConceptBoardsContributedPaymentSavingDAO.delete(regDesigenConceptBoardsModel);
    	}        
    	registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryTotalConceptBoardsContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
		return regCBContributedData;
    }

    @Override
    @Transactional
    public JSONArray jSonConceptBoardsIndividualInfoDeleteFromDB(String regCBIndividualSavingId, HttpServletRequest req, HttpSession sn) {
    	regSelectCBIndividualDataDeleteFromDB(req, sn, regCBIndividualSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }

    public String regSelectCBIndividualDataDeleteFromDB(HttpServletRequest req, HttpSession sn, String regCBIndividualSavingId) {
    	String regCBContributedData = null;
    	long cbIndividualProductSavingId = Long.parseLong(regCBIndividualSavingId);
    	List<RegistrantConceptBoardsIndividualProductsInfoSaving> regCBIndividualInfoList = registrantConceptBoardsIndividualProductsInfoSavingDAO.regConceptBoardsIndividualLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualProductSavingId);
    	if (!regCBIndividualInfoList.isEmpty()) {
        	RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualUpdateModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualProductSavingId);
        	registrantConceptBoardsIndividualProductsInfoSavingDAO.delete(regCBIndividualUpdateModel);
        }        
        List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), cbIndividualProductSavingId);
    		registrantConceptBoardsIndividualPaymentSavingDAO.delete(regDesigenConceptBoardsModel);
    	}               
    	registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryTotalConceptBoardsIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
		return regCBContributedData;
    }

    @Override
    @Transactional
    public JSONArray jSonConceptBoardsIndividualInfoAddToCartRedirection(String regCBIndividualCombVal, HttpServletRequest req, HttpSession sn) {
    	registryConBoardIndividualAddToCartDataUpdateInDB(regCBIndividualCombVal, req, sn);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);    	
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }
   
    public String registryConBoardIndividualAddToCartDataUpdateInDB(String regCBIndividualCombVal, HttpServletRequest req, HttpSession sn) {
        String regCBIndividualAddToCartData = null;
        String[] regCBIndividualCombValue = regCBIndividualCombVal.split("__");
        long regConBoardProductSavingId = Long.parseLong(regCBIndividualCombValue[0]);
        int quantity = Integer.parseInt(regCBIndividualCombValue[1]);
        Timestamp currentDate = currentDate();
        List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualProductList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regConBoardProductSavingId);
    	if (!regCBIndividualProductList.isEmpty()) {
    		RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualProductModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regConBoardProductSavingId);
    		regCBIndividualProductModel.setGiftedQuantity(quantity);
    		regCBIndividualProductModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regCBIndividualProductModel);
    	} else {
    		RegistrantConceptBoardsIndividualPaymentSaving regConBoardIndividualPaymentModel = new RegistrantConceptBoardsIndividualPaymentSaving();
    		regConBoardIndividualPaymentModel.setRegistrantConceptBoardsIndividualProductsInfoSavingId(regConBoardProductSavingId);
    		regConBoardIndividualPaymentModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regConBoardIndividualPaymentModel.setGiftedQuantity(quantity);
    		regConBoardIndividualPaymentModel.setCreatedDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.save(regConBoardIndividualPaymentModel);
        }
    	registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryTotalConceptBoardsIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	return regCBIndividualAddToCartData;
    }

    @Override
    @Transactional
    public ModelAndView registrantConceptBoardContributedInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView("regConceptBoardsContributedInfoDisplay");
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regCBCotributedProductSavingId, req.getParameter(regCBCotributedProductSavingId));    	
    	mav.addObject(regCBCotributedPrice, req.getParameter(regCBCotributedPrice));    	
    	mav.addObject(regCBCotributedProductImage, req.getParameter(regCBCotributedProductImage));
    	mav.addObject(regCBCotributedProductName, req.getParameter(regCBCotributedProductName));
    	mav.addObject(regCBCotributedRemainingPrice, req.getParameter(regCBCotributedRemainingPrice));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantConceptBoardContributedDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        long regiCBCotributedProductSavingId = Long.parseLong(req.getParameter(regCBCotributedProductSavingId));        
        Timestamp currentDate = currentDate();
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
    	if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regiCBCotributedProductSavingId);
    		regDesigenConceptBoardsModel.setContributedPrice(req.getParameter(regCBCotributedPrice));
    		regDesigenConceptBoardsModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsContributedPaymentSavingDAO.merge(regDesigenConceptBoardsModel);
    	} else {
    		RegistrantConceptBoardsContributedPaymentSaving regConBoardContributedPaymentModel = new RegistrantConceptBoardsContributedPaymentSaving();
    		regConBoardContributedPaymentModel.setRegistrantConceptBoardsContributedProductsInfoSavingId(regiCBCotributedProductSavingId);
    		regConBoardContributedPaymentModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regConBoardContributedPaymentModel.setContributedPrice(req.getParameter(regCBCotributedPrice));
    		regConBoardContributedPaymentModel.setCreatedDate(currentDate);
    		registrantConceptBoardsContributedPaymentSavingDAO.save(regConBoardContributedPaymentModel);
    	}
    	registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	registryTotalConceptBoardsContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryTotalFundsCombCartCounts(sn);
        mav = new ModelAndView(redirectStatus + registryOverview);        
        return mav;
    }
    
    @Override
    @Transactional
    public String registrantCBContributedAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn) {
        String regiConceptBoardsRef = null;
        List cbContributedPaymentSavingIdList = new ArrayList();
        List cbContributedAddCartImageList = new ArrayList();
		List cbContributedAddCartNameList = new ArrayList();
		List cbContributedAddCartPriceList = new ArrayList();
		List cbContributedNeedPriceList = new ArrayList();
		List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedSavingList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCBContributedSavingList.isEmpty()) {		
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedSavingModel : regCBContributedSavingList) {
    			cbContributedPaymentSavingIdList.add(regCBContributedSavingModel.getRegistrantConceptBoardsContributedPaymentSavingId());
    			cbContributedAddCartPriceList.add(regCBContributedSavingModel.getContributedPrice());
    			RegistrantConceptBoardsContributedProductsInfoSaving cbContributedProductsInfoSavingModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			cbContributedAddCartNameList.add(cbContributedProductsInfoSavingModel.getProductName());    			    			
    			cbContributedAddCartImageList.add(cbContributedProductsInfoSavingModel.getProductUploadedImage());
    			cbContributedNeedPriceList.add(cbContributedProductsInfoSavingModel.getRemainingTotalPrice());
    		}
    		sn.setAttribute(cbContributedPaymentSavingIdListInSn, cbContributedPaymentSavingIdList);
	 		sn.setAttribute(cbContributedAddCartImageListInSn, cbContributedAddCartImageList);
	 		sn.setAttribute(cbContributedAddCartNameListInSn, cbContributedAddCartNameList);
	 		sn.setAttribute(cbContributedAddCartPriceListInSn, cbContributedAddCartPriceList);
	 		sn.setAttribute(cbContributedNeedPriceListInSn, cbContributedNeedPriceList);
    	} else {
    		sn.setAttribute(cbContributedPaymentSavingIdListInSn, null);
	 		sn.setAttribute(cbContributedAddCartImageListInSn, null);
	 		sn.setAttribute(cbContributedAddCartNameListInSn, null);
	 		sn.setAttribute(cbContributedAddCartPriceListInSn, null);
	 		sn.setAttribute(cbContributedNeedPriceListInSn, null);
    	}
        return regiConceptBoardsRef;
    }

    @Override
    @Transactional
    public String registrantCBIndividualAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn) {
        String regiConceptBoardsRef = null;
        List cbIndividualPaymentSavingIdList = new ArrayList();
        List cbIndividualAddCartImageList = new ArrayList();
		List cbIndividualAddCartNameList = new ArrayList();
		List cbIndividualAddCartPriceList = new ArrayList();
		List cbIndividualAddCartQuantityList = new ArrayList();
		List cbIndividualNeedQuantityList = new ArrayList();
		List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCBIndividualSavingList.isEmpty()) {		
    		for (RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualSavingModel : regCBIndividualSavingList) {
    			cbIndividualPaymentSavingIdList.add(regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualPaymentSavingId());
    			cbIndividualAddCartQuantityList.add(regCBIndividualSavingModel.getGiftedQuantity());
    			RegistrantConceptBoardsIndividualProductsInfoSaving cbIndividualProductsInfoSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			cbIndividualAddCartNameList.add(cbIndividualProductsInfoSavingModel.getProductName());    			    			
    			cbIndividualAddCartImageList.add(cbIndividualProductsInfoSavingModel.getProductUploadedImage());
    			cbIndividualAddCartPriceList.add(cbIndividualProductsInfoSavingModel.getProductPrice());
    			cbIndividualNeedQuantityList.add(cbIndividualProductsInfoSavingModel.getRemainingQuantity());
    		}
    		sn.setAttribute(cbIndividualPaymentSavingIdListInSn, cbIndividualPaymentSavingIdList);
	 		sn.setAttribute(cbIndividualAddCartImageListInSn, cbIndividualAddCartImageList);
	 		sn.setAttribute(cbIndividualAddCartNameListInSn, cbIndividualAddCartNameList);
	 		sn.setAttribute(cbIndividualAddCartPriceListInSn, cbIndividualAddCartPriceList);
	 		sn.setAttribute(cbIndividualAddCartQuantityListInSn, cbIndividualAddCartQuantityList);
	 		sn.setAttribute(cbIndividualNeedQuantityListInSn, cbIndividualNeedQuantityList);
    	} else {
    		sn.setAttribute(cbIndividualPaymentSavingIdListInSn, null);
	 		sn.setAttribute(cbIndividualAddCartImageListInSn, null);
	 		sn.setAttribute(cbIndividualAddCartNameListInSn, null);
	 		sn.setAttribute(cbIndividualAddCartPriceListInSn, null);
	 		sn.setAttribute(cbIndividualAddCartQuantityListInSn, null);
	 		sn.setAttribute(cbIndividualNeedQuantityListInSn, null);
    	}
        return regiConceptBoardsRef;
    }

    @Override
    @Transactional
    public JSONArray jSonAddCartCBContributedValueUpdateInDB(String cbContributedInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] cbContributedInfoValueSt = cbContributedInfoValue.split("__");
    	registrantCBContributedAddCartJSonValueUpdateInDB(sn, req, cbContributedInfoValueSt[0], cbContributedInfoValueSt[1]);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, cbContributedInfoValueSt[1]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBContributedAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String cbContributedPaymentSavingId, String regNewContributedPriceValue) {
    	String cbContributedAddCartValue = null;
        long regCBContributedPaymentSavingId = Long.parseLong(cbContributedPaymentSavingId);
        Timestamp currentDate = currentDate();
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBContributedAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedPaymentSavingId);
        if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryCBContributedAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedPaymentSavingId);
    		regDesigenConceptBoardsModel.setContributedPrice(regNewContributedPriceValue);
    		regDesigenConceptBoardsModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsContributedPaymentSavingDAO.merge(regDesigenConceptBoardsModel);
    	} 
    	registrantCBContributedAddToCartInfoDisplay(req, sn);
    	registrantCBContributedAddCartTotalPrice(req, sn);
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return cbContributedAddCartValue;
    }    

    @Override
    @Transactional
    public double registrantCBContributedAddCartTotalPrice(HttpServletRequest req, HttpSession sn) {
    	double regCBContributedTotalPrice = 0;
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedSavingList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));    	
        if (!regCBContributedSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedSavingModel : regCBContributedSavingList) {
    			double regCBContributedPriceDb = Double.parseDouble(regCBContributedSavingModel.getContributedPrice());    			
    			regCBContributedTotalPrice = regCBContributedTotalPrice + regCBContributedPriceDb;
        	}    		
    	}     
        sn.setAttribute(cbContributedAddCartPriceInSn, regCBContributedTotalPrice);
        return regCBContributedTotalPrice;
    }

    @Override
    @Transactional
    public double registrantCBIndividualAddCartTotalPrice(HttpServletRequest req, HttpSession sn) {
    	double regCBIndividualTotalPrice = 0;
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regCBIndividualSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualSavingModel : regCBIndividualSavingList) {
    			int giftedQuantity = regCBIndividualSavingModel.getGiftedQuantity();
    			RegistrantConceptBoardsIndividualProductsInfoSaving cbIndividualProductsInfoSavingModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			double productPriceInDb = Double.parseDouble(cbIndividualProductsInfoSavingModel.getProductPrice());
    			double productPriceWithQty = productPriceInDb * giftedQuantity;
    			regCBIndividualTotalPrice = regCBIndividualTotalPrice + productPriceWithQty;
        	}    		
    	}
        sn.setAttribute(cbIndividualAddCartPriceInSn, regCBIndividualTotalPrice);
        return regCBIndividualTotalPrice;
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
    public JSONArray jSonAddCartCBIndividualValueUpdateInDB(String cbIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] cbIndividualInfoValueSt = cbIndividualInfoValue.split("__");
    	registrantCBIndividualAddCartJSonValueUpdateInDB(sn, req, cbIndividualInfoValueSt[0], cbIndividualInfoValueSt[1]);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, cbIndividualInfoValueSt[1]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBIndividualAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String cbIndividualPaymentSavingId, String regNewIndividualQuantity) {
    	String cbIndividualAddCartValue = null;
        long regCBIndividualPaymentSavingId = Long.parseLong(cbIndividualPaymentSavingId);
        int newIndividualQuantity = Integer.parseInt(regNewIndividualQuantity);
        Timestamp currentDate = currentDate();
        List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBIndividualAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingId);
        if (!regDesigenConceptBoardsList.isEmpty()) {
        	RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBIndividualAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingId);
    		regDesigenConceptBoardsModel.setGiftedQuantity(newIndividualQuantity);
    		regDesigenConceptBoardsModel.setUpdatedDate(currentDate);
    		registrantConceptBoardsIndividualPaymentSavingDAO.merge(regDesigenConceptBoardsModel);
    	} 
        registrantCBIndividualAddToCartInfoDisplay(req, sn);
        registrantCBIndividualAddCartTotalPrice(req, sn);
        registryTotalConceptBoardsIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return cbIndividualAddCartValue;
    }    

    @Override
    @Transactional
    public JSONArray jSonCBContributedInfoDeleteFromDB(String regiCBContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantCBContributedAddCartJSonValueDeleteFromDB(sn, req, regiCBContributedPaymentSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);    	
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBContributedAddCartJSonValueDeleteFromDB(HttpSession sn, HttpServletRequest req, String regiCBContributedPaymentSavingId) {
    	String cbContributedAddCartValue = null;
        long regCBContributedPaymentSavingId = Long.parseLong(regiCBContributedPaymentSavingId);
        List<RegistrantConceptBoardsContributedPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsContributedPaymentSavingDAO.registryCBContributedAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedPaymentSavingId);
        if (!regDesigenConceptBoardsList.isEmpty()) {
    		RegistrantConceptBoardsContributedPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsContributedPaymentSavingDAO.registryCBContributedAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedPaymentSavingId);
    		registrantConceptBoardsContributedPaymentSavingDAO.delete(regDesigenConceptBoardsModel);
    	} 
    	registrantCBContributedAddToCartInfoDisplay(req, sn);
    	registrantCBContributedAddCartTotalPrice(req, sn);
    	registryTotalConceptBoardsContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryConceptBoardsContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return cbContributedAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonCBIndividualInfoDeleteFromDB(String regiCBIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantCBIndividualAddCartJSonValueUpdateInDB(sn, req, regiCBIndividualPaymentSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantCBIndividualAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String regiCBIndividualPaymentSavingId) {
    	String cbIndividualAddCartValue = null;
        long regCBIndividualPaymentSavingId = Long.parseLong(regiCBIndividualPaymentSavingId);
        List<RegistrantConceptBoardsIndividualPaymentSaving> regDesigenConceptBoardsList = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBIndividualAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingId);
        if (!regDesigenConceptBoardsList.isEmpty()) {
        	RegistrantConceptBoardsIndividualPaymentSaving regDesigenConceptBoardsModel = registrantConceptBoardsIndividualPaymentSavingDAO.registryCBIndividualAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingId);
    		registrantConceptBoardsIndividualPaymentSavingDAO.delete(regDesigenConceptBoardsModel);
    	} 
        registrantCBIndividualAddToCartInfoDisplay(req, sn);
        registrantCBIndividualAddCartTotalPrice(req, sn);
        registryTotalConceptBoardsIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryConceptBoardsIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);    	
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return cbIndividualAddCartValue;
    }

    @Override
    @Transactional
    public String registrantConceptBoardsPaymentInfoUpdateInDB(HttpSession sn, HttpServletRequest req, long registrantUserId, String paymentStatus, long regiPaymentInfoSavingId) {
    	String cbPaymentInfoValue = null;
    	Timestamp currentDate = currentDate();
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentSavingList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedTotalCartCount(registrantUserId);
        if (!regCBContributedPaymentSavingList.isEmpty()) {
        	regCBContributedProductsInfoUpdateInTable(req, sn, registrantUserId);
        	registrantConceptBoardsContributedPaymentSavingDAO.regConceptBoardsContributedPaymentInfoUpdateInDB(registrantUserId, regiPaymentInfoSavingId, paymentStatus, currentDate);
    	} 
        
        List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualPaymentSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualTotalCartCount(registrantUserId);
        if (!regCBIndividualPaymentSavingList.isEmpty()) {
        	regCBIndividualProductsInfoUpdateInTable(req, sn, registrantUserId);
        	registrantConceptBoardsIndividualPaymentSavingDAO.regConceptBoardsIndividualPaymentInfoUpdateInDB(registrantUserId, regiPaymentInfoSavingId, paymentStatus, currentDate);
    	}        
    	return cbPaymentInfoValue;
    }

    public String regCBContributedProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String cbContributedPriceValue = null;
    	Timestamp currentDate = currentDate();
    	List<RegistrantConceptBoardsContributedPaymentSaving> regCBContributedPaymentSavingList = registrantConceptBoardsContributedPaymentSavingDAO.registryConceptBoardsContributedTotalCartCount(registrantUserId);
        if (!regCBContributedPaymentSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsContributedPaymentSaving regCBContributedPaymentSavingModel : regCBContributedPaymentSavingList) {
    			RegistrantConceptBoardsContributedProductsInfoSaving regCBContributedProductsInfoModel = registrantConceptBoardsContributedProductsInfoSavingDAO.registryConceptBoardsContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBContributedPaymentSavingModel.getRegistrantConceptBoardsContributedProductsInfoSavingId());
    			double cbContributedRemaingPriceDb = 0;
    			if(null != regCBContributedProductsInfoModel.getRemainingTotalPrice()) {
    				cbContributedRemaingPriceDb = Double.parseDouble(regCBContributedProductsInfoModel.getRemainingTotalPrice());
    			}
    			double regCBContributedAmountDb = Double.parseDouble(regCBContributedPaymentSavingModel.getContributedPrice());
    			double totalRemaingPriceDb = cbContributedRemaingPriceDb - regCBContributedAmountDb;
    			String totalRemaingPriceSt = String.format("%.2f", totalRemaingPriceDb);
    			regCBContributedProductsInfoModel.setRemainingTotalPrice(totalRemaingPriceSt);
    			regCBContributedProductsInfoModel.setUpdatedDate(currentDate);
    			String noActionStatusSt = regCBContributedProductsInfoModel.getContributedStatus();
    			if(null == noActionStatusSt) {
    				regCBContributedProductsInfoModel.setContributedStatus(noActionStatus);
    			}
    			registrantConceptBoardsContributedProductsInfoSavingDAO.merge(regCBContributedProductsInfoModel);
        	}        	    		
        }
    	return cbContributedPriceValue;
    }

    public String regCBIndividualProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String cbIndividualQuantity = null;
    	Timestamp currentDate = currentDate();
    	List<RegistrantConceptBoardsIndividualPaymentSaving> regCBIndividualPaymentSavingList = registrantConceptBoardsIndividualPaymentSavingDAO.registryConceptBoardsIndividualTotalCartCount(registrantUserId);
        if (!regCBIndividualPaymentSavingList.isEmpty()) {
    		for (RegistrantConceptBoardsIndividualPaymentSaving regCBIndividualPaymentSavingModel : regCBIndividualPaymentSavingList) {
    			RegistrantConceptBoardsIndividualProductsInfoSaving regCBIndividualProductsInfoModel = registrantConceptBoardsIndividualProductsInfoSavingDAO.registryConceptBoardsIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regCBIndividualPaymentSavingModel.getRegistrantConceptBoardsIndividualProductsInfoSavingId());
    			int cbIndividualPaymentQuantity = regCBIndividualPaymentSavingModel.getGiftedQuantity();
    			int cbIndividualRemainingQuantity = regCBIndividualProductsInfoModel.getRemainingQuantity();
    			int totalIndividualRemainingQuantity = cbIndividualRemainingQuantity - cbIndividualPaymentQuantity;
    			regCBIndividualProductsInfoModel.setRemainingQuantity(totalIndividualRemainingQuantity);
    			regCBIndividualProductsInfoModel.setUpdatedDate(currentDate);
    			registrantConceptBoardsIndividualProductsInfoSavingDAO.merge(regCBIndividualProductsInfoModel);
        	}        	    		
        }
    	return cbIndividualQuantity;
    }
    
	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
