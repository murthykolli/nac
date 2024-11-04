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

import com.nookandcove.dao.AdminRegistryFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesContributedPaymentSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesContributedProductsInfoSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesIndividualPaymentSavingDAO;
import com.nookandcove.dao.RegistrantFinishingTouchesIndividualProductsInfoSavingDAO;
import com.nookandcove.model.AdminRegistryFinishingTouchesProductsInfoSaving;
import com.nookandcove.model.RegistrantFinishingTouchesContributedPaymentSaving;
import com.nookandcove.model.RegistrantFinishingTouchesContributedProductsInfoSaving;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualProductsInfoSaving;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualPaymentSaving;
import com.nookandcove.service.RegistryFinishingTouchesService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class RegistryFinishingTouchesServiceImpl implements RegistryFinishingTouchesService {

	private String registrantUserIdInSn = "registrantUserIdInSn";
//	private String registrySelectedFinishingTouches = "registrySelectedFinishingTouches";
	private String regViewSelectedFinTouchesProducts = "regViewSelectedFinTouchesProducts";
	private String regFTSelectedCategory = "regFTSelectedCategory";
	private String regFirstNames = "regFirstNames";
	private String regFirstNamesInSn = "regFirstNamesInSn";
	private String regTotalCartItems = "regTotalCartItems";
	private String regiCartCountInSn = "regiCartCountInSn";
	
	private String regFTProductIdsListInSn = "regFTProductIdsListInSn";	
	private String regFTProductNameListInSn = "regFTProductNameListInSn";
	private String regFTProductStoreNameListInSn = "regFTProductStoreNameListInSn";
	private String regFTProductPriceListInSn = "regFTProductPriceListInSn";
	private String regFTProductPopUpValuesListInSn = "regFTProductPopUpValuesListInSn";
	private String regFTProductImage1ListInSn = "regFTProductImage1ListInSn";
	private String regFTProductImage2ListInSn = "regFTProductImage2ListInSn";
	private String regFTProductImage3ListInSn = "regFTProductImage3ListInSn";
	private String regFTProductImage4ListInSn = "regFTProductImage4ListInSn";
	private String ftProductsInfoSavingId = "ftProductsInfoSavingId";
	private String productQuantity = "productQuantity";
	private String productHeading = "productHeading";
	private String productPrice = "productPrice";
	private String productDescription = "productDescription";
	private String groupGiftRefferanceValue = "groupGiftRefferanceValue";
	private String groupGiftRefferanceVal = "Enable Group Gift";
	private String redirectStatus = "redirect:";
	private String redirectRegistrySelectedFinishingTouches = "redirectRegistrySelectedFinishingTouches";
	
	private String ftContributedProductSavingIdListInSn = "ftContributedProductSavingIdListInSn";
	private String ftContributedProductImageListInSn = "ftContributedProductImageListInSn";
	private String ftContributedProductNameListInSn = "ftContributedProductNameListInSn";
	private String ftContributedProductPriceListInSn = "ftContributedProductPriceListInSn";
	private String ftContributedProductQuantityListInSn = "ftContributedProductQuantityListInSn";
	private String ftContributedRemainingAmountListInSn = "ftContributedRemainingAmountListInSn";
	private String ftContributedAmountListInSn = "ftContributedAmountListInSn";
	private String ftContributedPaymentStatusListInSn = "ftContributedPaymentStatusListInSn";
	private String ftIndividualProductSavingIdListInSn = "ftIndividualProductSavingIdListInSn";
	private String ftIndividualProductImageListInSn = "ftIndividualProductImageListInSn";
	private String ftIndividualProductNameListInSn = "ftIndividualProductNameListInSn";
	private String ftIndividualProductPriceListInSn = "ftIndividualProductPriceListInSn";
	private String ftIndividualProductQuantityListInSn = "ftIndividualProductQuantityListInSn";
	private String ftIndividualRemainingQuantityListInSn = "ftIndividualRemainingQuantityListInSn";
	private String ftIndividualGivenQuantityListInSn = "ftIndividualGivenQuantityListInSn";
	private String ftIndividualPaymentStatusListInSn = "ftIndividualPaymentStatusListInSn";
	private String regFTContributedCartCountInSn = "regFTContributedCartCountInSn";
	private String regFTIndividualCartCountInSn = "regFTIndividualCartCountInSn";
	private String editFinishingTouchesSelectedProducts = "editFinishingTouchesSelectedProducts";
	private String finishingTouchesContributedProductAddToCart = "finishingTouchesContributedProductAddToCart";
	
	private String regFTCotributedProductSavingId = "regFTCotributedProductSavingId";
	private String regFTCotributedPrice = "regFTCotributedPrice";
	private String regFTCotributedProductImage = "regFTCotributedProductImage";
	private String regFTCotributedProductName = "regFTCotributedProductName";
	private String regFTCotributedRemainingPrice = "regFTCotributedRemainingPrice";
	private String regFTIndividualProductSavingId = "regFTIndividualProductSavingId";
	
	private String totalProdPopUpValuesList = "totalProdPopUpValuesList";
	private String productsPrice = "productsPrice";
	private String productsDescription = "productsDescription";
	private String productSize = "productSize";
	private String productsCount = "productsCount";
	private String hidePriceGuest = "hidePriceGuest";
	private String regFinishingTouchesPaymentStatus = "regFinishingTouchesPaymentStatus";
	private String registryOverview = "registryOverview";
	private String jSonObject = "JSonObj";
	private String regCBContributedCartCountInSn = "regCBContributedCartCountInSn";
	private String regCBIndividualCountInSn = "regCBIndividualCountInSn";
	private String ftContributedPaymentSavingIdListInSn = "ftContributedPaymentSavingIdListInSn";
	private String ftContributedAddCartImageListInSn = "ftContributedAddCartImageListInSn";
	private String ftContributedAddCartNameListInSn = "ftContributedAddCartNameListInSn";
	private String ftContributedAddCartPriceListInSn = "ftContributedAddCartPriceListInSn";
	private String ftContributedNeedPriceListInSn = "ftContributedNeedPriceListInSn";
	private String ftIndividualPaymentSavingIdListInSn = "ftIndividualPaymentSavingIdListInSn";
	private String ftIndividualAddCartImageListInSn = "ftIndividualAddCartImageListInSn";
	private String ftIndividualAddCartNameListInSn = "ftIndividualAddCartNameListInSn";
	private String ftIndividualAddCartPriceListInSn = "ftIndividualAddCartPriceListInSn";
	private String ftIndividualAddCartQuantityListInSn = "ftIndividualAddCartQuantityListInSn";
	private String ftIndividualNeedQuantityListInSn = "ftIndividualNeedQuantityListInSn";
	private String cbContributedAddCartPriceInSn = "cbContributedAddCartPriceInSn";
	private String cbIndividualAddCartPriceInSn = "cbIndividualAddCartPriceInSn";
	private String ftContributedAddCartPriceInSn = "ftContributedAddCartPriceInSn";
	private String ftIndividualAddCartPriceInSn = "ftIndividualAddCartPriceInSn";
	private String shoppingCartTotalAmountInSn = "shoppingCartTotalAmountInSn";
	private String noActionStatus = "No Action";
	
	
	
	
	
	
	@Autowired
    private AdminRegistryFinishingTouchesProductsInfoSavingDAO adminRegistryFinishingTouchesProductsInfoSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesContributedProductsInfoSavingDAO registrantFinishingTouchesContributedProductsInfoSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesIndividualProductsInfoSavingDAO registrantFinishingTouchesIndividualProductsInfoSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesContributedPaymentSavingDAO registrantFinishingTouchesContributedPaymentSavingDAO;

	@Autowired
    private RegistrantFinishingTouchesIndividualPaymentSavingDAO registrantFinishingTouchesIndividualPaymentSavingDAO;
	
	
	
	
    @Override
    @Transactional
    public ModelAndView registrySelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regFTCatNameRef = "Curtains";
    	registryFinishingTouchesSelectedProductValuesList(req, sn, regFTCatNameRef);    	
    	mav = new ModelAndView(regViewSelectedFinTouchesProducts);
        mav.addObject(regFTSelectedCategory, regFTCatNameRef);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView regFinishingTouchesSelectedProductsTakeFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav; 
    	registryFinishingTouchesSelectedProductValuesList(req, sn, req.getParameter(regFTSelectedCategory));    	
    	mav = new ModelAndView(regViewSelectedFinTouchesProducts);
        mav.addObject(regFTSelectedCategory, req.getParameter(regFTSelectedCategory));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }

    public int registryFinishingTouchesSelectedProductValuesList(HttpServletRequest req, HttpSession sn, String regFTSelectedCategory) {
    	int allProductsTotalPrice = 0;        
        List regFTProductSavingIdList = new ArrayList();        
		List regFTProductNameList = new ArrayList();
		List furnSpecStoreNameList = new ArrayList();
		List regFTProductPriceList = new ArrayList();
		List furnSpecPopUpValuesList = new ArrayList();
		List regFTProductImage1List = new ArrayList();
		List regFTProductImage2List = new ArrayList();
		List regFTProductImage3List = new ArrayList();
		List regFTProductImage4List = new ArrayList();		
		List <AdminRegistryFinishingTouchesProductsInfoSaving> regFinTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesSelectedProductsListFromDB(regFTSelectedCategory);
    	if (!regFinTouchesProductsList.isEmpty()) {
    		for (AdminRegistryFinishingTouchesProductsInfoSaving regFinTouchesProdSavingModel : regFinTouchesProductsList) {    			
	 			regFTProductSavingIdList.add(regFinTouchesProdSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());
    			long finishingTouchesProductsId = regFinTouchesProdSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId();
    			String conBoardContributedStatus = registrantAllFinishingTouchesContributedStatus(req, sn, finishingTouchesProductsId);
    			String conBoardPaymentStatus = registrantAllFinishingTouchesProductPaymentStatus(req, sn, finishingTouchesProductsId);
	 			String prodCombValues =  regFinTouchesProdSavingModel.getProductSize1() + "_,_" + regFinTouchesProdSavingModel.getProductPrice1() + "_,_" + regFinTouchesProdSavingModel.getProductSize2() + "_,_" + regFinTouchesProdSavingModel.getProductPrice2() + "_,_" + regFinTouchesProdSavingModel.getProductSize3() + "_,_" + regFinTouchesProdSavingModel.getProductPrice3() + "_,_" + regFinTouchesProdSavingModel.getProductSize4() + "_,_" + regFinTouchesProdSavingModel.getProductPrice4() + "_,_" + regFinTouchesProdSavingModel.getProductSize5() + "_,_" + regFinTouchesProdSavingModel.getProductPrice5() + "_,_" + regFinTouchesProdSavingModel.getProductDescription1();
    			String totalPopUpValuesList = regFinTouchesProdSavingModel.getProductName() + "_,_" + regFinTouchesProdSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regFinTouchesProdSavingModel.getStoreName();    			
	 			regFTProductNameList.add(regFinTouchesProdSavingModel.getProductName());
	 			furnSpecStoreNameList.add(regFinTouchesProdSavingModel.getStoreName());
	 			regFTProductPriceList.add(regFinTouchesProdSavingModel.getProductPrice1());
	 			furnSpecPopUpValuesList.add(totalPopUpValuesList);
	 			regFTProductImage1List.add(regFinTouchesProdSavingModel.getProductUploadedImage1());
	 			regFTProductImage2List.add(regFinTouchesProdSavingModel.getProductUploadedImage2());
	 			regFTProductImage3List.add(regFinTouchesProdSavingModel.getProductUploadedImage3());
	 			regFTProductImage4List.add(regFinTouchesProdSavingModel.getProductUploadedImage4());	 			
	 		}	 		
	 		sn.setAttribute(regFTProductIdsListInSn, regFTProductSavingIdList);	 		
	 		sn.setAttribute(regFTProductNameListInSn, regFTProductNameList);
	 		sn.setAttribute(regFTProductStoreNameListInSn, furnSpecStoreNameList);
	 		sn.setAttribute(regFTProductPriceListInSn, regFTProductPriceList);
	 		sn.setAttribute(regFTProductPopUpValuesListInSn, furnSpecPopUpValuesList);
	 		sn.setAttribute(regFTProductImage1ListInSn, regFTProductImage1List);
	 		sn.setAttribute(regFTProductImage2ListInSn, regFTProductImage2List);
	 		sn.setAttribute(regFTProductImage3ListInSn, regFTProductImage3List);
	 		sn.setAttribute(regFTProductImage4ListInSn, regFTProductImage4List);
 		} else {
 			sn.setAttribute(regFTProductIdsListInSn, null);	 		
	 		sn.setAttribute(regFTProductNameListInSn, null);
	 		sn.setAttribute(regFTProductStoreNameListInSn, null);
	 		sn.setAttribute(regFTProductPriceListInSn, null);
	 		sn.setAttribute(regFTProductPopUpValuesListInSn, null);
	 		sn.setAttribute(regFTProductImage1ListInSn, null);
	 		sn.setAttribute(regFTProductImage2ListInSn, null);
	 		sn.setAttribute(regFTProductImage3ListInSn, null);
	 		sn.setAttribute(regFTProductImage4ListInSn, null);
 		}    	
        return allProductsTotalPrice;
    }

    public String registrantAllFinishingTouchesContributedStatus(HttpServletRequest req, HttpSession sn, long adminRegFTProductSavingId) {
    	String conBoardContributedStatus = null;
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
    	List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
    	if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        	double contributedQuantityCount = registrantFinTouchesContributedQuantityCountFromDB(req, sn, regFTContributedUpdateModel.getContributedPrice(), regFTContributedUpdateModel.getRemainingTotalPrice(), regFTContributedUpdateModel.getQuantity());
        	conBoardContributedStatus = "Contributed" + "_,_" + regFTContributedUpdateModel.getQuantity() + "_,_" + contributedQuantityCount;
        } else if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualDeleteModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);        	
        	int giftedQuantity = regFTIndividualDeleteModel.getQuantity() - regFTIndividualDeleteModel.getRemainingQuantity();
        	conBoardContributedStatus = "Individual" + "_,_" + regFTIndividualDeleteModel.getQuantity() + "_,_" + giftedQuantity;
        } else {
        	conBoardContributedStatus = "No Payment" + "_,_" + 1 + "_,_" + 0;
        }
        return conBoardContributedStatus;
    }

    public double registrantFinTouchesContributedQuantityCountFromDB(HttpServletRequest req, HttpSession sn, String requestedTotalPrice, String remainingTotalPrice, int quantity) {
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

    public String registrantAllFinishingTouchesProductPaymentStatus(HttpServletRequest req, HttpSession sn, long adminRegFinTouchesProductSavingId) {
    	String conBoardPaymentStatus = null;
    	String conBoardContPaymentStatus = registrantFinTouchesProductContributedPaymentStatus(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), adminRegFinTouchesProductSavingId);
    	String conBoardIndPaymentStatus = registrantFinTouchesProductIndividualPaymentStatus(req, sn, (Long) sn.getAttribute(registrantUserIdInSn), adminRegFinTouchesProductSavingId);
    	if(null != conBoardContPaymentStatus) {
    		conBoardPaymentStatus = conBoardContPaymentStatus;
    	} else if(null != conBoardIndPaymentStatus) {
    		conBoardPaymentStatus = conBoardIndPaymentStatus;
    	}    	
    	return conBoardPaymentStatus;
    }

    public String registrantFinTouchesProductContributedPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long adminRegFinTouchesProductSavingId) {
    	String conBoardContPaymentStatus = null;
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataCheckInDB(registrantUserId, adminRegFinTouchesProductSavingId);
    	long conBoardsProductSavingId = 0;
    	if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataTakeFromDB(registrantUserId, adminRegFinTouchesProductSavingId);
        	conBoardsProductSavingId = regFTContributedUpdateModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId();
    	}
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesPaymentDataCheckInDB(registrantUserId, conBoardsProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesPaymentDataTakeFromDB(registrantUserId, conBoardsProductSavingId);
    		conBoardContPaymentStatus = regDesigenFinishingTouchesModel.getCheckoutPaymentStatus();
    	}    	
    	return conBoardContPaymentStatus;
    }
    
    public String registrantFinTouchesProductIndividualPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long adminRegFinTouchesProductSavingId) {
    	String conBoardIndPaymentStatus = null;    	
    	List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataCheckInDB(registrantUserId, adminRegFinTouchesProductSavingId);
    	long conBoardsIndProductSavingId = 0;
    	if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualDeleteModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataTakeFromDB(registrantUserId, adminRegFinTouchesProductSavingId);
        	conBoardsIndProductSavingId = regFTIndividualDeleteModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId();
        }
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenConceptIndBoardsList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPaymentStatusCheck(registrantUserId, conBoardsIndProductSavingId);
    	if (!regDesigenConceptIndBoardsList.isEmpty()) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regDesigenConceptIndBoardsModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPaymentStatusValue(registrantUserId, conBoardsIndProductSavingId);
    		conBoardIndPaymentStatus = regDesigenConceptIndBoardsModel.getCheckoutPaymentStatus();
    	}
    	return conBoardIndPaymentStatus;
    }
    
    @Override
    @Transactional
    public ModelAndView registrantFinTouchesSelectedProdInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        long adminRegFTProductSavingId = Long.parseLong(req.getParameter(ftProductsInfoSavingId));
        int quantity = Integer.parseInt(req.getParameter(productQuantity));
        String regiProductHeading = req.getParameter(productHeading);
        String regiProductPrice = req.getParameter(productPrice);
        regiProductPrice= regiProductPrice.replace(",", "");
        String regiDescription = req.getParameter(productDescription);
        String groupGiftRefferance = req.getParameter(groupGiftRefferanceValue);        
        Timestamp currentDate = currentDate();
        if((groupGiftRefferanceVal).equals(groupGiftRefferance)) {
        	mav = registrantFinTouchesContributedProductInfoSavingInDB(req, sn, adminRegFTProductSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate, req.getParameter(regFTSelectedCategory));
        } else {
        	mav = registrantFinTouchesIndividualProductInfoSavingInDB(req, sn, adminRegFTProductSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate, req.getParameter(regFTSelectedCategory));
        }
        sn.setAttribute(regFTSelectedCategory, req.getParameter(regFTSelectedCategory));
//        sn.setAttribute(regViewProductsInSn, req.getParameter(registryViewProducts));              
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrantFinTouchesContributedProductInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegFTProductSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate, String regiFTSelectedCategory) {
        ModelAndView mav;        
        List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualDeleteModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.delete(regFTIndividualDeleteModel);        	
        }
        double regiProductPriceDb = Double.parseDouble(regiProductPrice);
        double shippingFee = (regiProductPriceDb/100)*10;
        double stateTaxFee = (regiProductPriceDb/100)*8;
        double totalTaxtFee = shippingFee + stateTaxFee;
        double contributedAmountDb = regiProductPriceDb + totalTaxtFee;
        double totalContributedAmountDb = contributedAmountDb * quantity;
		String totalContributedAmount = String.format("%.2f", totalContributedAmountDb);
		String allTaxsTotalPrice = String.format("%.2f", totalTaxtFee);
        List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        	String conBoardContrRemAmount = conceptBoardContributedRemainingAmount(totalContributedAmountDb, regFTContributedUpdateModel.getContributedPrice(), regFTContributedUpdateModel.getRemainingTotalPrice());
        	regFTContributedUpdateModel.setContributedPrice(totalContributedAmount);
        	regFTContributedUpdateModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regFTContributedUpdateModel.setQuantity(quantity);
        	regFTContributedUpdateModel.setProductPrice(regiProductPrice);
        	regFTContributedUpdateModel.setProductDescription(regiDescription);
        	regFTContributedUpdateModel.setProductHeading(regiProductHeading);
        	regFTContributedUpdateModel.setUpdatedDate(currentDate);
        	regFTContributedUpdateModel.setRemainingTotalPrice(conBoardContrRemAmount);
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedUpdateModel);
        } else {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = new RegistrantFinishingTouchesContributedProductsInfoSaving();
        	regFTContributedSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regFTContributedSavingModel.setAdminRegistryFinishingTouchesFurnitureSpecsSavingId(adminRegFTProductSavingId);
        	regFTContributedSavingModel.setContributedPrice(totalContributedAmount);
        	regFTContributedSavingModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regFTContributedSavingModel.setQuantity(quantity);
        	regFTContributedSavingModel.setProductPrice(regiProductPrice);
        	regFTContributedSavingModel.setProductDescription(regiDescription);
        	regFTContributedSavingModel.setProductHeading(regiProductHeading);
        	regFTContributedSavingModel.setCreatedDate(currentDate);        	
        	regFTContributedSavingModel.setRemainingTotalPrice(totalContributedAmount);
        	AdminRegistryFinishingTouchesProductsInfoSaving regFinTouchesProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFTProductSavingId);
        	regFTContributedSavingModel.setProductName(regFinTouchesProductsModel.getProductName());
        	regFTContributedSavingModel.setProductUploadedImage(regFinTouchesProductsModel.getProductUploadedImage1());
        	regFTContributedSavingModel.setStoreName(regFinTouchesProductsModel.getStoreName());
        	regFTContributedSavingModel.setStoreUrl(regFinTouchesProductsModel.getStoreUrl());
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.save(regFTContributedSavingModel);
        }        
        registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        mav = new ModelAndView(redirectStatus + redirectRegistrySelectedFinishingTouches);
        mav.addObject(regFTSelectedCategory, regiFTSelectedCategory);
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
    public ModelAndView registrantFinTouchesIndividualProductInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegFTProductSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate, String regiFTSelectedCategory) {
        ModelAndView mav;
        List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.delete(regFTContributedUpdateModel);
        }        
        List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);
        if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTProductSavingId);        	
        	int dbQuantity = regFTIndividualUpdateModel.getQuantity();
        	int remQuantity = quantity - dbQuantity;
        	int conBoardGiftedQuantity = 0;
        	if(null != regFTIndividualUpdateModel.getRemainingQuantity()) {
        		conBoardGiftedQuantity = regFTIndividualUpdateModel.getRemainingQuantity();
        	}
        	int giftedRemQuantity = remQuantity + conBoardGiftedQuantity;
        	regFTIndividualUpdateModel.setQuantity(quantity);
        	regFTIndividualUpdateModel.setProductPrice(regiProductPrice);
        	regFTIndividualUpdateModel.setProductDescription(regiDescription);
        	regFTIndividualUpdateModel.setProductHeading(regiProductHeading);
        	regFTIndividualUpdateModel.setUpdatedDate(currentDate);
        	regFTIndividualUpdateModel.setRemainingQuantity(giftedRemQuantity);
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualUpdateModel);
        } else {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualSavingModel = new RegistrantFinishingTouchesIndividualProductsInfoSaving();
        	regFTIndividualSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regFTIndividualSavingModel.setAdminRegistryFinishingTouchesFurnitureSpecsSavingId(adminRegFTProductSavingId);
        	regFTIndividualSavingModel.setQuantity(quantity);
        	regFTIndividualSavingModel.setProductPrice(regiProductPrice);
        	regFTIndividualSavingModel.setProductDescription(regiDescription);
        	regFTIndividualSavingModel.setProductHeading(regiProductHeading);
        	regFTIndividualSavingModel.setCreatedDate(currentDate);
        	AdminRegistryFinishingTouchesProductsInfoSaving regFinTouchesProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFTProductSavingId);
        	regFTIndividualSavingModel.setProductName(regFinTouchesProductsModel.getProductName());
        	regFTIndividualSavingModel.setProductUploadedImage(regFinTouchesProductsModel.getProductUploadedImage1());        	
    		regFTIndividualSavingModel.setRemainingQuantity(quantity);
    		regFTIndividualSavingModel.setStoreName(regFinTouchesProductsModel.getStoreName());
    		regFTIndividualSavingModel.setStoreUrl(regFinTouchesProductsModel.getStoreUrl());
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.save(regFTIndividualSavingModel);
        }        
        registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        mav = new ModelAndView(redirectStatus + redirectRegistrySelectedFinishingTouches);
        mav.addObject(regFTSelectedCategory, regiFTSelectedCategory);
        return mav;
    }

    @Override
    @Transactional
    public String registryFinishingTouchesContributedProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regFinishingTouchessContributedRef = null;
        List ftContributedProductSavingIdList = new ArrayList();
        List ftContributedProductImageList = new ArrayList();
		List ftContributedProductNameList = new ArrayList();
		List ftContributedProductPriceList = new ArrayList();
		List ftContributedProductQuantityList = new ArrayList();
		List ftContributedRemainingAmountList = new ArrayList();
		List ftContributedAmountList = new ArrayList();	
		List ftContributedPaymentStatusList = new ArrayList();
		List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedTotalInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedTotalDataTakeFromDB(registrantUserId);
		if (!regFTContributedTotalInfoList.isEmpty()) {
    		for (RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel : regFTContributedTotalInfoList) {
    			ftContributedProductSavingIdList.add(regFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			ftContributedProductImageList.add(regFTContributedSavingModel.getProductUploadedImage());    			
    			ftContributedProductNameList.add(regFTContributedSavingModel.getProductName());
    			double totalWithTaxValue = 0;
    			if(null != regFTContributedSavingModel.getProductPrice()) {
    				double totalRegConProductPrice = Double.parseDouble(regFTContributedSavingModel.getProductPrice());
    				totalWithTaxValue = totalRegConProductPrice + (totalRegConProductPrice/100)*18;
    			}
    			ftContributedProductPriceList.add(totalWithTaxValue);
    			ftContributedProductQuantityList.add(regFTContributedSavingModel.getQuantity()); 
    			ftContributedRemainingAmountList.add(regFTContributedSavingModel.getRemainingTotalPrice());
    			String regFTContributedPrice = registryFinishingTouchesContributedPrice(req, sn, registrantUserId, regFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			ftContributedAmountList.add(regFTContributedPrice);
    			String regFTContributedPaymentStatus = registryFinishingTouchesContributedPaymentStatus(req, sn, registrantUserId, regFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			ftContributedPaymentStatusList.add(regFTContributedPaymentStatus);
        	}
    		sn.setAttribute(ftContributedProductSavingIdListInSn, ftContributedProductSavingIdList);
	 		sn.setAttribute(ftContributedProductImageListInSn, ftContributedProductImageList);
	 		sn.setAttribute(ftContributedProductNameListInSn, ftContributedProductNameList);
	 		sn.setAttribute(ftContributedProductPriceListInSn, ftContributedProductPriceList);
	 		sn.setAttribute(ftContributedProductQuantityListInSn, ftContributedProductQuantityList);
	 		sn.setAttribute(ftContributedRemainingAmountListInSn, ftContributedRemainingAmountList);
	 		sn.setAttribute(ftContributedAmountListInSn, ftContributedAmountList);
	 		sn.setAttribute(ftContributedPaymentStatusListInSn, ftContributedPaymentStatusList);
    	} else {
    		sn.setAttribute(ftContributedProductSavingIdListInSn, null);
	 		sn.setAttribute(ftContributedProductImageListInSn, null);
	 		sn.setAttribute(ftContributedProductNameListInSn, null);
	 		sn.setAttribute(ftContributedProductPriceListInSn, null);
	 		sn.setAttribute(ftContributedProductQuantityListInSn, null);
	 		sn.setAttribute(ftContributedRemainingAmountListInSn, null);
	 		sn.setAttribute(ftContributedAmountListInSn, null);
	 		sn.setAttribute(ftContributedPaymentStatusListInSn, null);
    	}
        return regFinishingTouchessContributedRef;
    }
    
    public String registryFinishingTouchesContributedPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftContributedProductSavingId) {
        String regFTContributedPrice = null;
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceCheckInDB(registrantUserId, ftContributedProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceTakeFromDB(registrantUserId, ftContributedProductSavingId);
    		regFTContributedPrice = regDesigenFinishingTouchesModel.getContributedPrice();
    	}
        return regFTContributedPrice;
    }

    public String registryFinishingTouchesContributedPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftContributedProductSavingId) {
        String regFTContributedPaymentStatus = null;
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusCheckInDB(registrantUserId, ftContributedProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPaymentStatusTakeFromDB(registrantUserId, ftContributedProductSavingId);
    		regFTContributedPaymentStatus = "Contibuted Payment";
    	}
        return regFTContributedPaymentStatus;
    }

    @Override
    @Transactional
    public String registryFinishingTouchesIndividualProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String regFinishingTouchessIndividualRef = null;
        List ftIndividualProductSavingIdList = new ArrayList();
        List ftIndividualProductImageList = new ArrayList();
		List ftIndividualProductNameList = new ArrayList();
		List ftIndividualProductPriceList = new ArrayList();
		List ftIndividualProductQuantityList = new ArrayList();
		List ftIndividualRemainingQuantityList = new ArrayList();
		List ftIndividualGivenQuantityList = new ArrayList();
		List ftIndividualPaymentStatusList = new ArrayList();
		List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualTotalInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualTotalDataTakeFromDB(registrantUserId);
		if (!regFTIndividualTotalInfoList.isEmpty()) {
    		for (RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualSavingModel : regFTIndividualTotalInfoList) {
    			ftIndividualProductSavingIdList.add(regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			ftIndividualProductImageList.add(regFTIndividualSavingModel.getProductUploadedImage());    			
    			ftIndividualProductNameList.add(regFTIndividualSavingModel.getProductName());
    			ftIndividualProductPriceList.add(regFTIndividualSavingModel.getProductPrice());
    			ftIndividualProductQuantityList.add(regFTIndividualSavingModel.getQuantity()); 
    			ftIndividualRemainingQuantityList.add(regFTIndividualSavingModel.getRemainingQuantity());
    			int regFTIndividualGivenQuantity = registryFinishingTouchesIndividualPrice(req, sn, registrantUserId, regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			ftIndividualGivenQuantityList.add(regFTIndividualGivenQuantity);
    			String regFTIndividualPaymentStatus = registryFinishingTouchesIndividualPaymentStatus(req, sn, registrantUserId, regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			ftIndividualPaymentStatusList.add(regFTIndividualPaymentStatus);
        	}
    		sn.setAttribute(ftIndividualProductSavingIdListInSn, ftIndividualProductSavingIdList);
	 		sn.setAttribute(ftIndividualProductImageListInSn, ftIndividualProductImageList);
	 		sn.setAttribute(ftIndividualProductNameListInSn, ftIndividualProductNameList);
	 		sn.setAttribute(ftIndividualProductPriceListInSn, ftIndividualProductPriceList);
	 		sn.setAttribute(ftIndividualProductQuantityListInSn, ftIndividualProductQuantityList);
	 		sn.setAttribute(ftIndividualRemainingQuantityListInSn, ftIndividualRemainingQuantityList);
	 		sn.setAttribute(ftIndividualGivenQuantityListInSn, ftIndividualGivenQuantityList);
	 		sn.setAttribute(ftIndividualPaymentStatusListInSn, ftIndividualPaymentStatusList);
    	} else {
    		sn.setAttribute(ftIndividualProductSavingIdListInSn, null);
	 		sn.setAttribute(ftIndividualProductImageListInSn, null);
	 		sn.setAttribute(ftIndividualProductNameListInSn, null);
	 		sn.setAttribute(ftIndividualProductPriceListInSn, null);
	 		sn.setAttribute(ftIndividualProductQuantityListInSn, null);
	 		sn.setAttribute(ftIndividualRemainingQuantityListInSn, null);
	 		sn.setAttribute(ftIndividualGivenQuantityListInSn, null);
	 		sn.setAttribute(ftIndividualPaymentStatusListInSn, null);
    	}
        return regFinishingTouchessIndividualRef;
    }

    public Integer registryFinishingTouchesIndividualPrice(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualProductSavingId) {
        int regFTIndividualGivenQuantity = 0;
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceCheckInDB(registrantUserId, ftIndividualProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceTakeFromDB(registrantUserId, ftIndividualProductSavingId);
    		regFTIndividualGivenQuantity = regDesigenFinishingTouchesModel.getGiftedQuantity();
    	}
        return regFTIndividualGivenQuantity;
    }

    public String registryFinishingTouchesIndividualPaymentStatus(HttpServletRequest req, HttpSession sn, long registrantUserId, long ftIndividualProductSavingId) {
    	String regFTIndividualPaymentStatus = null;
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPaymentStatusCheckInDB(registrantUserId, ftIndividualProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPaymentStatusTakeFromDB(registrantUserId, ftIndividualProductSavingId);
    		regFTIndividualPaymentStatus = "Individual Payment";
    	}
        return regFTIndividualPaymentStatus;
    }

    @Override
    @Transactional
    public ModelAndView redirectRegistrySelectedFinishingTouchesData(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	registryFinishingTouchesSelectedProductValuesList(req, sn, req.getParameter(regFTSelectedCategory));    	
    	mav = new ModelAndView(regViewSelectedFinTouchesProducts);
        mav.addObject(regFTSelectedCategory, req.getParameter(regFTSelectedCategory));
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        return mav;
    }

    @Override
    @Transactional
    public int registryTotalFinishingTouchesContributedCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int registryFinishingTouchesContCount = 0;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedTotalCartCount(registrantUserId);
        registryFinishingTouchesContCount = regDesigenFinishingTouchesList.size();        		
        sn.setAttribute(regFTContributedCartCountInSn, registryFinishingTouchesContCount);
        return registryFinishingTouchesContCount;
    }

    @Override
    @Transactional
    public int registryTotalFinishingTouchesIndividualCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int registryFinishingTouchesContCount = 0;    	
	    List<RegistrantFinishingTouchesIndividualPaymentSaving> regFinishingTouchesIndividualList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
	    if (!regFinishingTouchesIndividualList.isEmpty()) {
	    	for (RegistrantFinishingTouchesIndividualPaymentSaving regDesigenFinishingTouchesModel : regFinishingTouchesIndividualList) {
	    		registryFinishingTouchesContCount = registryFinishingTouchesContCount + regDesigenFinishingTouchesModel.getGiftedQuantity();        		
	    	}	        
	    }
	    sn.setAttribute(regFTIndividualCartCountInSn, registryFinishingTouchesContCount);
	    return registryFinishingTouchesContCount;    	
    }

    @Override
    @Transactional
    public ModelAndView editFinishingTouchesContributedProductsInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String totalPopUpValuesList = null;
    	long regiFTCotributedProductSavingId = Long.parseLong(req.getParameter(regFTCotributedProductSavingId));    	
        String prodPrice = null;
        String prodDescription = null;
        String productsSize = null;
        int prodCount = 0;
        String hidePriceGuests = null;
        RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
        long admRegFinishingTouchesProductId = regFTContributedUpdateModel.getAdminRegistryFinishingTouchesFurnitureSpecsSavingId();
        String conBoardContributedStatus = registrantAllFinishingTouchesContributedStatus(req, sn, admRegFinishingTouchesProductId);
		String conBoardPaymentStatus = registrantAllFinishingTouchesProductPaymentStatus(req, sn, admRegFinishingTouchesProductId);		
        List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.registrantAdminRegFinishingTouchesEditProductsInDB(admRegFinishingTouchesProductId);
		if (!totalFurSpecsProductsList.isEmpty()) {
			AdminRegistryFinishingTouchesProductsInfoSaving totalFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.registrantAdminRegFinishingTouchesEditProductsDataTakeFromDB(admRegFinishingTouchesProductId);
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
    		
    		totalPopUpValuesList = regFTContributedUpdateModel.getProductName() + "_,_" + furSpecProdImage + "_,_" + productImage2 + "_,_" + productImage3 + "_,_" + productImage4 + "_,_" + totalFurSpecsProductsModel.getAdminRegistryFinishingTouchesProductsInfoSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regFTContributedUpdateModel.getStoreName();   		
    		prodPrice = regFTContributedUpdateModel.getProductPrice();
    		prodDescription = regFTContributedUpdateModel.getProductDescription();
    		productsSize = regFTContributedUpdateModel.getProductHeading();
            prodCount = regFTContributedUpdateModel.getQuantity();            
	 	} else {	 		 
	 		String prodCombValues =  regFTContributedUpdateModel.getProductHeading() + "_,_" + regFTContributedUpdateModel.getProductPrice() + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + regFTContributedUpdateModel.getProductDescription();
	 		String furSpecProdcImage = null;
    		if(null != regFTContributedUpdateModel.getProductUploadedImage()) {
    	    	byte[] fsProdImageFromDB = regFTContributedUpdateModel.getProductUploadedImage();
    	    	furSpecProdcImage = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB);
        	}
    		totalPopUpValuesList = regFTContributedUpdateModel.getProductName() + "_,_" + furSpecProdcImage + "_,_" + null + "_,_" + null + "_,_" + null + "_,_" + regFTContributedUpdateModel.getAdminRegistryFinishingTouchesFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regFTContributedUpdateModel.getStoreName(); 
    		prodPrice = regFTContributedUpdateModel.getProductPrice();
    		prodDescription = regFTContributedUpdateModel.getProductDescription();
    		productsSize = regFTContributedUpdateModel.getProductHeading();
            prodCount = regFTContributedUpdateModel.getQuantity();            
	 	}
		mav = new ModelAndView(editFinishingTouchesSelectedProducts);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(totalProdPopUpValuesList, totalPopUpValuesList);    	
    	mav.addObject(productsPrice, prodPrice);
    	mav.addObject(productsDescription, prodDescription);
    	mav.addObject(productSize, productsSize);
    	mav.addObject(productsCount, prodCount);    	
    	mav.addObject(hidePriceGuest, hidePriceGuests);
    	mav.addObject(regFinishingTouchesPaymentStatus, conBoardPaymentStatus);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView editFinishingTouchesIndividualProductsInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String totalPopUpValuesList = null;
    	long regiFTIndividualProductSavingId = Long.parseLong(req.getParameter(regFTIndividualProductSavingId));
    	String prodPrice = null;
        String prodDescription = null;
        String productsSize = null;
        int prodCount = 0;
        String hidePriceGuests = null;
        RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTIndividualProductSavingId);
        long admRegFinishingTouchesProductId = regFTIndividualUpdateModel.getAdminRegistryFinishingTouchesFurnitureSpecsSavingId();
        String conBoardContributedStatus = registrantAllFinishingTouchesContributedStatus(req, sn, admRegFinishingTouchesProductId);
		String conBoardPaymentStatus = registrantAllFinishingTouchesProductPaymentStatus(req, sn, admRegFinishingTouchesProductId);		
        List<AdminRegistryFinishingTouchesProductsInfoSaving> totalFurSpecsProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.registrantAdminRegFinishingTouchesEditProductsInDB(admRegFinishingTouchesProductId);
        if (!totalFurSpecsProductsList.isEmpty()) {
        	AdminRegistryFinishingTouchesProductsInfoSaving totalFurSpecsProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.registrantAdminRegFinishingTouchesEditProductsDataTakeFromDB(admRegFinishingTouchesProductId);
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
    		
    		totalPopUpValuesList = regFTIndividualUpdateModel.getProductName() + "_,_" + furSpecProdImage + "_,_" + productImage2 + "_,_" + productImage3 + "_,_" + productImage4 + "_,_" + totalFurSpecsProductsModel.getAdminRegistryFinishingTouchesProductsInfoSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regFTIndividualUpdateModel.getStoreName();  		
    		prodPrice = regFTIndividualUpdateModel.getProductPrice();
    		prodDescription = regFTIndividualUpdateModel.getProductDescription();
    		productsSize = regFTIndividualUpdateModel.getProductHeading();
            prodCount = regFTIndividualUpdateModel.getQuantity();            
	 	} else {	 		 
	 		String prodCombValues =  regFTIndividualUpdateModel.getProductHeading() + "_,_" + regFTIndividualUpdateModel.getProductPrice() + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + "" + "_,_" + regFTIndividualUpdateModel.getProductDescription();
	 		String furSpecProdcImage = null;
    		if(null != regFTIndividualUpdateModel.getProductUploadedImage()) {
    	    	byte[] fsProdImageFromDB = regFTIndividualUpdateModel.getProductUploadedImage();
    	    	furSpecProdcImage = javax.xml.bind.DatatypeConverter.printBase64Binary(fsProdImageFromDB);
        	}
    		totalPopUpValuesList = regFTIndividualUpdateModel.getProductName() + "_,_" + furSpecProdcImage + "_,_" + null + "_,_" + null + "_,_" + null + "_,_" + regFTIndividualUpdateModel.getAdminRegistryFinishingTouchesFurnitureSpecsSavingId() + "_,_" + prodCombValues + "_,_" + conBoardPaymentStatus + "_,_" + conBoardContributedStatus + "_,_" + regFTIndividualUpdateModel.getStoreName();
    		prodPrice = regFTIndividualUpdateModel.getProductPrice();
    		prodDescription = regFTIndividualUpdateModel.getProductDescription();
    		productsSize = regFTIndividualUpdateModel.getProductHeading();
            prodCount = regFTIndividualUpdateModel.getQuantity();            
	 	}
		mav = new ModelAndView(editFinishingTouchesSelectedProducts);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        mav.addObject(totalProdPopUpValuesList, totalPopUpValuesList);    	
    	mav.addObject(productsPrice, prodPrice);
    	mav.addObject(productsDescription, prodDescription);
    	mav.addObject(productSize, productsSize);
    	mav.addObject(productsCount, prodCount);    	
    	mav.addObject(hidePriceGuest, hidePriceGuests);
    	mav.addObject(regFinishingTouchesPaymentStatus, conBoardPaymentStatus);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView finishingTouchesContributedProductsAddToCart(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView(finishingTouchesContributedProductAddToCart);
        mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regFTCotributedProductSavingId, req.getParameter(regFTCotributedProductSavingId));    	
    	mav.addObject(regFTCotributedPrice, req.getParameter(regFTCotributedPrice));    	
    	mav.addObject(regFTCotributedProductImage, req.getParameter(regFTCotributedProductImage));
    	mav.addObject(regFTCotributedProductName, req.getParameter(regFTCotributedProductName));
    	mav.addObject(regFTCotributedRemainingPrice, req.getParameter(regFTCotributedRemainingPrice));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView finTouchesContributedProductDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        long regiFTCotributedProductSavingId = Long.parseLong(req.getParameter(regFTCotributedProductSavingId));        
        Timestamp currentDate = currentDate();
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
    		regDesigenFinishingTouchesModel.setContributedPrice(req.getParameter(regFTCotributedPrice));
    		regDesigenFinishingTouchesModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesContributedPaymentSavingDAO.merge(regDesigenFinishingTouchesModel);
    	} else {
    		RegistrantFinishingTouchesContributedPaymentSaving regFinTouchesContributedPaymentModel = new RegistrantFinishingTouchesContributedPaymentSaving();
    		regFinTouchesContributedPaymentModel.setRegistrantFinishingTouchesContributedProductsInfoSavingId(regiFTCotributedProductSavingId);
    		regFinTouchesContributedPaymentModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regFinTouchesContributedPaymentModel.setContributedPrice(req.getParameter(regFTCotributedPrice));
    		regFinTouchesContributedPaymentModel.setCreatedDate(currentDate);
    		registrantFinishingTouchesContributedPaymentSavingDAO.save(regFinTouchesContributedPaymentModel);
    	}
    	registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	registryTotalFinishingTouchesContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryTotalFundsCombCartCounts(sn);
        mav = new ModelAndView(redirectStatus + registryOverview);        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView finishingTouchesSelectedProductDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        long adminRegFTFSpecsSavingId = Long.parseLong(req.getParameter(ftProductsInfoSavingId));
        int quantity = Integer.parseInt(req.getParameter(productQuantity));
        String regiProductHeading = req.getParameter(productHeading);        
        String regiProductPrice = req.getParameter(productPrice);
        regiProductPrice= regiProductPrice.replace(",", "");
        String regiDescription = req.getParameter(productDescription);
        String groupGiftRefferance = req.getParameter(groupGiftRefferanceValue);
        Timestamp currentDate = currentDate();
        if((groupGiftRefferanceVal).equals(groupGiftRefferance)) {
        	registrantConceptBoardContributedInfoUpdateInDB(req, sn, adminRegFTFSpecsSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate);
        } else {
        	registrantConceptBoardIndividualInfoUpdateInDB(req, sn, adminRegFTFSpecsSavingId, groupGiftRefferance, quantity, regiProductPrice, regiDescription, regiProductHeading, currentDate);
        }
        mav = new ModelAndView(redirectStatus + registryOverview);
        return mav;
    }

    public String registrantConceptBoardContributedInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFTFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate) {
    	String registrantConceptBoardContributedVal = null;
        List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualDeleteModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.delete(regFTIndividualDeleteModel);        	
        }
        double regiProductPriceDb = Double.parseDouble(regiProductPrice);
        double shippingFee = (regiProductPriceDb/100)*10;
        double stateTaxFee = (regiProductPriceDb/100)*8;
        double totalTaxtFee = shippingFee + stateTaxFee;
        double contributedAmountDb = regiProductPriceDb + totalTaxtFee;
        double totalContributedAmountDb = contributedAmountDb * quantity;
		String totalContributedAmount = String.format("%.2f", totalContributedAmountDb);
		String allTaxsTotalPrice = String.format("%.2f", totalTaxtFee);
        List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        	String conBoardContrRemAmount = conceptBoardContributedRemainingAmount(totalContributedAmountDb, regFTContributedUpdateModel.getContributedPrice(), regFTContributedUpdateModel.getRemainingTotalPrice());
        	regFTContributedUpdateModel.setContributedPrice(totalContributedAmount);
        	regFTContributedUpdateModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regFTContributedUpdateModel.setQuantity(quantity);
        	regFTContributedUpdateModel.setProductPrice(regiProductPrice);
        	regFTContributedUpdateModel.setProductDescription(regiDescription);
        	regFTContributedUpdateModel.setProductHeading(regiProductHeading);
        	regFTContributedUpdateModel.setUpdatedDate(currentDate);
        	regFTContributedUpdateModel.setRemainingTotalPrice(conBoardContrRemAmount);
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedUpdateModel);
        } else {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedSavingModel = new RegistrantFinishingTouchesContributedProductsInfoSaving();
        	regFTContributedSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regFTContributedSavingModel.setAdminRegistryFinishingTouchesFurnitureSpecsSavingId(adminRegFTFSpecsSavingId);
        	regFTContributedSavingModel.setContributedPrice(totalContributedAmount);
        	regFTContributedSavingModel.setAllTaxsTotalPrice(allTaxsTotalPrice);
        	regFTContributedSavingModel.setQuantity(quantity);
        	regFTContributedSavingModel.setProductPrice(regiProductPrice);
        	regFTContributedSavingModel.setProductDescription(regiDescription);
        	regFTContributedSavingModel.setProductHeading(regiProductHeading);
        	regFTContributedSavingModel.setCreatedDate(currentDate);        	
        	regFTContributedSavingModel.setRemainingTotalPrice(totalContributedAmount);
        	AdminRegistryFinishingTouchesProductsInfoSaving regFinTouchesProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFTFSpecsSavingId);
        	regFTContributedSavingModel.setProductName(regFinTouchesProductsModel.getProductName());
        	regFTContributedSavingModel.setProductUploadedImage(regFinTouchesProductsModel.getProductUploadedImage1());
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.save(regFTContributedSavingModel);
        }        
        registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        return registrantConceptBoardContributedVal;
    }

    public String registrantConceptBoardIndividualInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFTFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate) {
    	String registrantConceptBoardIndividualVal = null;
        List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedUpdateModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.delete(regFTContributedUpdateModel);
        }        
        List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), adminRegFTFSpecsSavingId);
        	int dbQuantity = regFTIndividualUpdateModel.getQuantity();
        	int remQuantity = quantity - dbQuantity;
        	int conBoardGiftedQuantity = 0;
        	if(null != regFTIndividualUpdateModel.getRemainingQuantity()) {
        		conBoardGiftedQuantity = regFTIndividualUpdateModel.getRemainingQuantity();
        	}
        	int giftedRemQuantity = remQuantity + conBoardGiftedQuantity;
        	regFTIndividualUpdateModel.setQuantity(quantity);
        	regFTIndividualUpdateModel.setProductPrice(regiProductPrice);
        	regFTIndividualUpdateModel.setProductDescription(regiDescription);
        	regFTIndividualUpdateModel.setProductHeading(regiProductHeading);
        	regFTIndividualUpdateModel.setUpdatedDate(currentDate);
        	regFTIndividualUpdateModel.setRemainingQuantity(giftedRemQuantity);
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualUpdateModel);
        } else {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualSavingModel = new RegistrantFinishingTouchesIndividualProductsInfoSaving();
        	regFTIndividualSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
        	regFTIndividualSavingModel.setAdminRegistryFinishingTouchesFurnitureSpecsSavingId(adminRegFTFSpecsSavingId);
        	regFTIndividualSavingModel.setQuantity(quantity);
        	regFTIndividualSavingModel.setProductPrice(regiProductPrice);
        	regFTIndividualSavingModel.setProductDescription(regiDescription);
        	regFTIndividualSavingModel.setProductHeading(regiProductHeading);
        	regFTIndividualSavingModel.setCreatedDate(currentDate);
        	AdminRegistryFinishingTouchesProductsInfoSaving regFinTouchesProductsModel = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesEditProductsDataTakeFromDB(adminRegFTFSpecsSavingId);
        	regFTIndividualSavingModel.setProductName(regFinTouchesProductsModel.getProductName());
        	regFTIndividualSavingModel.setProductUploadedImage(regFinTouchesProductsModel.getProductUploadedImage1());        	
    		regFTIndividualSavingModel.setRemainingQuantity(quantity);
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.save(regFTIndividualSavingModel);
        }        
        registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        return registrantConceptBoardIndividualVal;
    }

    @Override
    @Transactional
    public JSONArray jSonFinishingTouchesContributedInfoDeleteFromDB(String regFTCotributedSavingId, HttpServletRequest req, HttpSession sn) {
    	regSelectFTContributedDataDeleteFromDB(req, sn, regFTCotributedSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray finishingTouchesJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        finishingTouchesJson.add(jsonObj);
        return finishingTouchesJson;
    }

    public String regSelectFTContributedDataDeleteFromDB(HttpServletRequest req, HttpSession sn, String regFTCotributedSavingId) {
    	String regFTContributedData = null;
    	long regiFTCotributedProductSavingId = Long.parseLong(regFTCotributedSavingId);
    	List<RegistrantFinishingTouchesContributedProductsInfoSaving> regFTContributedInfoList = registrantFinishingTouchesContributedProductsInfoSavingDAO.regFinishingTouchesContributedLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
        if (!regFTContributedInfoList.isEmpty()) {
        	RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedDeleteModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
        	registrantFinishingTouchesContributedProductsInfoSavingDAO.delete(regFTContributedDeleteModel);
        }        
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regiFTCotributedProductSavingId);
    		registrantFinishingTouchesContributedPaymentSavingDAO.delete(regDesigenFinishingTouchesModel);
    	}        
    	registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryTotalFinishingTouchesContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
		return regFTContributedData;
    }

    public int registryTotalFundsCombCartCounts(HttpSession sn) {
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
    public JSONArray jSonFinishingTouchesIndividualInfoDeleteFromDB(String regFTIndividualSavingId, HttpServletRequest req, HttpSession sn) {
    	regSelectFTIndividualDataDeleteFromDB(req, sn, regFTIndividualSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray finishingTouchesJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        finishingTouchesJson.add(jsonObj);
        return finishingTouchesJson;
    }

    public String regSelectFTIndividualDataDeleteFromDB(HttpServletRequest req, HttpSession sn, String regFTIndividualSavingId) {
    	String regFTContributedData = null;
    	long ftIndividualProductSavingId = Long.parseLong(regFTIndividualSavingId);
    	List<RegistrantFinishingTouchesIndividualProductsInfoSaving> regFTIndividualInfoList = registrantFinishingTouchesIndividualProductsInfoSavingDAO.regFinishingTouchesIndividualLandingDeleteDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualProductSavingId);
    	if (!regFTIndividualInfoList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualUpdateModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualProductSavingId);
        	registrantFinishingTouchesIndividualProductsInfoSavingDAO.delete(regFTIndividualUpdateModel);
        }        
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualProductSavingId);
    	if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), ftIndividualProductSavingId);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.delete(regDesigenFinishingTouchesModel);
    	}               
    	registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryTotalFinishingTouchesIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
		return regFTContributedData;
    }

    @Override
    @Transactional
    public JSONArray jSonFinishingTouchesIndividualInfoAddToCartRedirection(String regFTIndividualCombVal, HttpServletRequest req, HttpSession sn) {
    	registryFinTouchesIndividualAddToCartDataUpdateInDB(regFTIndividualCombVal, req, sn);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);    	
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray finishingTouchesJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        finishingTouchesJson.add(jsonObj);
        return finishingTouchesJson;
    }
   
    public String registryFinTouchesIndividualAddToCartDataUpdateInDB(String regFTIndividualCombVal, HttpServletRequest req, HttpSession sn) {
        String regFTIndividualAddToCartData = null;
        String[] regFTIndividualCombValue = regFTIndividualCombVal.split("__");
        long regFinTouchesProductSavingId = Long.parseLong(regFTIndividualCombValue[0]);
        int quantity = Integer.parseInt(regFTIndividualCombValue[1]);
        Timestamp currentDate = currentDate();
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualProductList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFinTouchesProductSavingId);
    	if (!regFTIndividualProductList.isEmpty()) {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualProductModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualPriceTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFinTouchesProductSavingId);
    		regFTIndividualProductModel.setGiftedQuantity(quantity);
    		regFTIndividualProductModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regFTIndividualProductModel);
    	} else {
    		RegistrantFinishingTouchesIndividualPaymentSaving regFinTouchesIndividualPaymentModel = new RegistrantFinishingTouchesIndividualPaymentSaving();
    		regFinTouchesIndividualPaymentModel.setRegistrantFinishingTouchesIndividualProductsInfoSavingId(regFinTouchesProductSavingId);
    		regFinTouchesIndividualPaymentModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regFinTouchesIndividualPaymentModel.setGiftedQuantity(quantity);
    		regFinTouchesIndividualPaymentModel.setCreatedDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.save(regFinTouchesIndividualPaymentModel);
        }
    	registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryTotalFinishingTouchesIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));    	
    	return regFTIndividualAddToCartData;
    }

    @Override
    @Transactional
    public String registrantFTContributedAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn) {
        String regiFinishingTouchesRef = null;
        List ftContributedPaymentSavingIdList = new ArrayList();
        List ftContributedAddCartImageList = new ArrayList();
		List ftContributedAddCartNameList = new ArrayList();
		List ftContributedAddCartPriceList = new ArrayList();
		List ftContributedNeedPriceList = new ArrayList();
		List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedSavingList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regFTContributedSavingList.isEmpty()) {		
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedSavingModel : regFTContributedSavingList) {
    			ftContributedPaymentSavingIdList.add(regFTContributedSavingModel.getRegistrantFinishingTouchesContributedPaymentSavingId());
    			ftContributedAddCartPriceList.add(regFTContributedSavingModel.getContributedPrice());
    			RegistrantFinishingTouchesContributedProductsInfoSaving ftContributedProductsInfoSavingModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			ftContributedAddCartNameList.add(ftContributedProductsInfoSavingModel.getProductName());    			    			
    			ftContributedAddCartImageList.add(ftContributedProductsInfoSavingModel.getProductUploadedImage());
    			ftContributedNeedPriceList.add(ftContributedProductsInfoSavingModel.getRemainingTotalPrice());
    		}
    		sn.setAttribute(ftContributedPaymentSavingIdListInSn, ftContributedPaymentSavingIdList);
	 		sn.setAttribute(ftContributedAddCartImageListInSn, ftContributedAddCartImageList);
	 		sn.setAttribute(ftContributedAddCartNameListInSn, ftContributedAddCartNameList);
	 		sn.setAttribute(ftContributedAddCartPriceListInSn, ftContributedAddCartPriceList);
	 		sn.setAttribute(ftContributedNeedPriceListInSn, ftContributedNeedPriceList);
    	} else {
    		sn.setAttribute(ftContributedPaymentSavingIdListInSn, null);
	 		sn.setAttribute(ftContributedAddCartImageListInSn, null);
	 		sn.setAttribute(ftContributedAddCartNameListInSn, null);
	 		sn.setAttribute(ftContributedAddCartPriceListInSn, null);
	 		sn.setAttribute(ftContributedNeedPriceListInSn, null);
    	}
        return regiFinishingTouchesRef;
    }

    @Override
    @Transactional
    public String registrantFTIndividualAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn) {
        String regiFinishingTouchesRef = null;
        List ftIndividualPaymentSavingIdList = new ArrayList();
        List ftIndividualAddCartImageList = new ArrayList();
		List ftIndividualAddCartNameList = new ArrayList();
		List ftIndividualAddCartPriceList = new ArrayList();
		List ftIndividualAddCartQuantityList = new ArrayList();
		List ftIndividualNeedQuantityList = new ArrayList();
		List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regFTIndividualSavingList.isEmpty()) {		
    		for (RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualSavingModel : regFTIndividualSavingList) {
    			ftIndividualPaymentSavingIdList.add(regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualPaymentSavingId());
    			ftIndividualAddCartQuantityList.add(regFTIndividualSavingModel.getGiftedQuantity());
    			RegistrantFinishingTouchesIndividualProductsInfoSaving ftIndividualProductsInfoSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			ftIndividualAddCartNameList.add(ftIndividualProductsInfoSavingModel.getProductName());    			    			
    			ftIndividualAddCartImageList.add(ftIndividualProductsInfoSavingModel.getProductUploadedImage());
    			ftIndividualAddCartPriceList.add(ftIndividualProductsInfoSavingModel.getProductPrice());
    			ftIndividualNeedQuantityList.add(ftIndividualProductsInfoSavingModel.getRemainingQuantity());
    		}
    		sn.setAttribute(ftIndividualPaymentSavingIdListInSn, ftIndividualPaymentSavingIdList);
	 		sn.setAttribute(ftIndividualAddCartImageListInSn, ftIndividualAddCartImageList);
	 		sn.setAttribute(ftIndividualAddCartNameListInSn, ftIndividualAddCartNameList);
	 		sn.setAttribute(ftIndividualAddCartPriceListInSn, ftIndividualAddCartPriceList);
	 		sn.setAttribute(ftIndividualAddCartQuantityListInSn, ftIndividualAddCartQuantityList);
	 		sn.setAttribute(ftIndividualNeedQuantityListInSn, ftIndividualNeedQuantityList);
    	} else {
    		sn.setAttribute(ftIndividualPaymentSavingIdListInSn, null);
	 		sn.setAttribute(ftIndividualAddCartImageListInSn, null);
	 		sn.setAttribute(ftIndividualAddCartNameListInSn, null);
	 		sn.setAttribute(ftIndividualAddCartPriceListInSn, null);
	 		sn.setAttribute(ftIndividualAddCartQuantityListInSn, null);
	 		sn.setAttribute(ftIndividualNeedQuantityListInSn, null);
    	}
        return regiFinishingTouchesRef;
    }

    @Override
    @Transactional
    public double registrantFTContributedAddCartTotalPrice(HttpServletRequest req, HttpSession sn) {
    	double regFTContributedTotalPrice = 0;
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedSavingList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));    	
        if (!regFTContributedSavingList.isEmpty()) {
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedSavingModel : regFTContributedSavingList) {
    			double regFTContributedPriceDb = Double.parseDouble(regFTContributedSavingModel.getContributedPrice());    			
    			regFTContributedTotalPrice = regFTContributedTotalPrice + regFTContributedPriceDb;
        	}    		
    	}     
        sn.setAttribute(ftContributedAddCartPriceInSn, regFTContributedTotalPrice);
        return regFTContributedTotalPrice;
    }

    @Override
    @Transactional
    public double registrantFTIndividualAddCartTotalPrice(HttpServletRequest req, HttpSession sn) {
    	double regFTIndividualTotalPrice = 0;
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualTotalCartCount((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!regFTIndividualSavingList.isEmpty()) {
    		for (RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualSavingModel : regFTIndividualSavingList) {
    			int giftedQuantity = regFTIndividualSavingModel.getGiftedQuantity();
    			RegistrantFinishingTouchesIndividualProductsInfoSaving ftIndividualProductsInfoSavingModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			double productPriceInDb = Double.parseDouble(ftIndividualProductsInfoSavingModel.getProductPrice());
    			double productPriceWithQty = productPriceInDb * giftedQuantity;
    			regFTIndividualTotalPrice = regFTIndividualTotalPrice + productPriceWithQty;
        	}    		
    	}
        sn.setAttribute(ftIndividualAddCartPriceInSn, regFTIndividualTotalPrice);
        return regFTIndividualTotalPrice;
    }

    @Override
    @Transactional
    public JSONArray jSonAddCartFTContributedValueUpdateInDB(String ftContributedInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] ftContributedInfoValueSt = ftContributedInfoValue.split("__");
    	registrantFTContributedAddCartJSonValueUpdateInDB(sn, req, ftContributedInfoValueSt[0], ftContributedInfoValueSt[1]);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, ftContributedInfoValueSt[1]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTContributedAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String ftContributedPaymentSavingId, String regNewContributedPriceValue) {
    	String ftContributedAddCartValue = null;
        long regFTContributedPaymentSavingId = Long.parseLong(ftContributedPaymentSavingId);
        Timestamp currentDate = currentDate();
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTContributedAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedPaymentSavingId);
        if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTContributedAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedPaymentSavingId);
    		regDesigenFinishingTouchesModel.setContributedPrice(regNewContributedPriceValue);
    		regDesigenFinishingTouchesModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesContributedPaymentSavingDAO.merge(regDesigenFinishingTouchesModel);
    	} 
    	registrantFTContributedAddToCartInfoDisplay(req, sn);
    	registrantFTContributedAddCartTotalPrice(req, sn);
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return ftContributedAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonAddCartFTIndividualValueUpdateInDB(String ftIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] ftIndividualInfoValueSt = ftIndividualInfoValue.split("__");
    	registrantFTIndividualAddCartJSonValueUpdateInDB(sn, req, ftIndividualInfoValueSt[0], ftIndividualInfoValueSt[1]);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, ftIndividualInfoValueSt[1]);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTIndividualAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String ftIndividualPaymentSavingId, String regNewIndividualQuantity) {
    	String ftIndividualAddCartValue = null;
        long regFTIndividualPaymentSavingId = Long.parseLong(ftIndividualPaymentSavingId);
        int newIndividualQuantity = Integer.parseInt(regNewIndividualQuantity);
        Timestamp currentDate = currentDate();
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTIndividualAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingId);
        if (!regDesigenFinishingTouchesList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTIndividualAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingId);
    		regDesigenFinishingTouchesModel.setGiftedQuantity(newIndividualQuantity);
    		regDesigenFinishingTouchesModel.setUpdatedDate(currentDate);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.merge(regDesigenFinishingTouchesModel);
    	} 
        registrantFTIndividualAddToCartInfoDisplay(req, sn);
        registrantFTIndividualAddCartTotalPrice(req, sn);
        registryTotalFinishingTouchesIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return ftIndividualAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonFTContributedInfoDeleteFromDB(String regiFTContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantFTContributedAddCartJSonValueDeleteFromDB(sn, req, regiFTContributedPaymentSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTContributedAddCartJSonValueDeleteFromDB(HttpSession sn, HttpServletRequest req, String regiFTContributedPaymentSavingId) {
    	String ftContributedAddCartValue = null;
        long regFTContributedPaymentSavingId = Long.parseLong(regiFTContributedPaymentSavingId);
        List<RegistrantFinishingTouchesContributedPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTContributedAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedPaymentSavingId);
        if (!regDesigenFinishingTouchesList.isEmpty()) {
    		RegistrantFinishingTouchesContributedPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesContributedPaymentSavingDAO.registryFTContributedAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedPaymentSavingId);
    		registrantFinishingTouchesContributedPaymentSavingDAO.delete(regDesigenFinishingTouchesModel);
    	} 
    	registrantFTContributedAddToCartInfoDisplay(req, sn);
    	registrantFTContributedAddCartTotalPrice(req, sn);
    	registryTotalFinishingTouchesContributedCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryFinishingTouchesContributedProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return ftContributedAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonFTIndividualInfoDeleteFromDB(String regiFTIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
    	registrantFTIndividualAddCartJSonValueUpdateInDB(sn, req, regiFTIndividualPaymentSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String registrantFTIndividualAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String regiFTIndividualPaymentSavingId) {
    	String ftIndividualAddCartValue = null;
        long regFTIndividualPaymentSavingId = Long.parseLong(regiFTIndividualPaymentSavingId);
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regDesigenFinishingTouchesList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTIndividualAddCartPaymentDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingId);
        if (!regDesigenFinishingTouchesList.isEmpty()) {
        	RegistrantFinishingTouchesIndividualPaymentSaving regDesigenFinishingTouchesModel = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFTIndividualAddCartPaymentDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingId);
    		registrantFinishingTouchesIndividualPaymentSavingDAO.delete(regDesigenFinishingTouchesModel);
    	} 
        registrantFTIndividualAddToCartInfoDisplay(req, sn);
        registrantFTIndividualAddCartTotalPrice(req, sn);
        registryTotalFinishingTouchesIndividualCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
        registryFinishingTouchesIndividualProductsDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	double allShoppingCartTotalAmount = registrantShoppingCartTotalAmountDisplay(sn, req);
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", allShoppingCartTotalAmount);    	
    	sn.setAttribute(shoppingCartTotalAmountInSn, allShoppingCartTotalAmountSt);
    	return ftIndividualAddCartValue;
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
    public String registrantFinishingTouchesPaymentInfoUpdateInDB(HttpSession sn, HttpServletRequest req, long registrantUserId, String paymentStatus, long regiPaymentInfoSavingId) {
    	String ftPaymentInfoValue = null;
    	Timestamp currentDate = currentDate();
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentSavingList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedTotalCartCount(registrantUserId);
        if (!regFTContributedPaymentSavingList.isEmpty()) {
        	regFTContributedProductsInfoUpdateInTable(req, sn, registrantUserId);
        	registrantFinishingTouchesContributedPaymentSavingDAO.regFinishingTouchesContributedPaymentInfoUpdateInDB(registrantUserId, regiPaymentInfoSavingId, paymentStatus, currentDate);
    	} 
        
        List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualPaymentSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualTotalCartCount(registrantUserId);
        if (!regFTIndividualPaymentSavingList.isEmpty()) {
        	regFTIndividualProductsInfoUpdateInTable(req, sn, registrantUserId);
        	registrantFinishingTouchesIndividualPaymentSavingDAO.regFinishingTouchesIndividualPaymentInfoUpdateInDB(registrantUserId, regiPaymentInfoSavingId, paymentStatus, currentDate);
    	}        
    	return ftPaymentInfoValue;
    }

    public String regFTContributedProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String ftContributedPriceValue = null;
    	Timestamp currentDate = currentDate();
    	List<RegistrantFinishingTouchesContributedPaymentSaving> regFTContributedPaymentSavingList = registrantFinishingTouchesContributedPaymentSavingDAO.registryFinishingTouchesContributedTotalCartCount(registrantUserId);
        if (!regFTContributedPaymentSavingList.isEmpty()) {
    		for (RegistrantFinishingTouchesContributedPaymentSaving regFTContributedPaymentSavingModel : regFTContributedPaymentSavingList) {
    			RegistrantFinishingTouchesContributedProductsInfoSaving regFTContributedProductsInfoModel = registrantFinishingTouchesContributedProductsInfoSavingDAO.registryFinishingTouchesContributedDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTContributedPaymentSavingModel.getRegistrantFinishingTouchesContributedProductsInfoSavingId());
    			double ftContributedRemaingPriceDb = 0;
    			if(null != regFTContributedProductsInfoModel.getRemainingTotalPrice()) {
    				ftContributedRemaingPriceDb = Double.parseDouble(regFTContributedProductsInfoModel.getRemainingTotalPrice());
    			}
    			double regFTContributedAmountDb = Double.parseDouble(regFTContributedPaymentSavingModel.getContributedPrice());
    			double totalRemaingPriceDb = ftContributedRemaingPriceDb - regFTContributedAmountDb;
    			String totalRemaingPriceSt = String.format("%.2f", totalRemaingPriceDb);
    			regFTContributedProductsInfoModel.setRemainingTotalPrice(totalRemaingPriceSt);
    			regFTContributedProductsInfoModel.setUpdatedDate(currentDate);
    			String noActionStatusSt = regFTContributedProductsInfoModel.getContributedStatus();
    			if(null == noActionStatusSt) {
    				regFTContributedProductsInfoModel.setContributedStatus(noActionStatus);
    			}
    			registrantFinishingTouchesContributedProductsInfoSavingDAO.merge(regFTContributedProductsInfoModel);
        	}        	    		
        }
    	return ftContributedPriceValue;
    }

    public String regFTIndividualProductsInfoUpdateInTable(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	String ftIndividualQuantity = null;
    	Timestamp currentDate = currentDate();
    	List<RegistrantFinishingTouchesIndividualPaymentSaving> regFTIndividualPaymentSavingList = registrantFinishingTouchesIndividualPaymentSavingDAO.registryFinishingTouchesIndividualTotalCartCount(registrantUserId);
        if (!regFTIndividualPaymentSavingList.isEmpty()) {
    		for (RegistrantFinishingTouchesIndividualPaymentSaving regFTIndividualPaymentSavingModel : regFTIndividualPaymentSavingList) {
    			RegistrantFinishingTouchesIndividualProductsInfoSaving regFTIndividualProductsInfoModel = registrantFinishingTouchesIndividualProductsInfoSavingDAO.registryFinishingTouchesIndividualDataEditInDB((Long) sn.getAttribute(registrantUserIdInSn), regFTIndividualPaymentSavingModel.getRegistrantFinishingTouchesIndividualProductsInfoSavingId());
    			int ftIndividualPaymentQuantity = regFTIndividualPaymentSavingModel.getGiftedQuantity();
    			int ftIndividualRemainingQuantity = regFTIndividualProductsInfoModel.getRemainingQuantity();
    			int totalIndividualRemainingQuantity = ftIndividualRemainingQuantity - ftIndividualPaymentQuantity;
    			regFTIndividualProductsInfoModel.setRemainingQuantity(totalIndividualRemainingQuantity);
    			regFTIndividualProductsInfoModel.setUpdatedDate(currentDate);
    			registrantFinishingTouchesIndividualProductsInfoSavingDAO.merge(regFTIndividualProductsInfoModel);
        	}        	    		
        }
    	return ftIndividualQuantity;
    }
    
    
    
	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
