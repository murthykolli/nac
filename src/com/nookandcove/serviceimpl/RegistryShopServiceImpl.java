package com.nookandcove.serviceimpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.nookandcove.dao.AdminRegistryConceptBoardsFurnitureSpecsSavingDAO;
import com.nookandcove.dao.AdminRegistryConceptBoardsSavingDAO;
import com.nookandcove.dao.AdminRegistryFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.dao.ReferralCustomGiftCardsInfoSavingDAO;
import com.nookandcove.dao.ShopConceptBoardsProductsInfoSavingDAO;
import com.nookandcove.dao.ShopUserPaymentInfoSavingDAO;
import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;
import com.nookandcove.model.AdminRegistryConceptBoardsSaving;
import com.nookandcove.model.AdminRegistryFinishingTouchesProductsInfoSaving;
import com.nookandcove.model.ReferralCustomGiftCardsInfoSaving;
import com.nookandcove.model.ShopConceptBoardsProductsInfoSaving;
import com.nookandcove.model.ShopUserPaymentInfoSaving;
import com.nookandcove.service.RegistryPaymentGatewayService;
import com.nookandcove.service.RegistryShopService;
import com.nookandcove.service.ShopFinishingTouchesService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class RegistryShopServiceImpl implements RegistryShopService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryShopServiceImpl.class);
	
	private String registryShopHome = "registryShopHome";
	private String selectedShopRoomName = "selectedShopRoomName";
	private String selectedShopRoomNameInSn = "selectedShopRoomNameInSn";
	private String shopSelectedConceptBoards = "shopSelectedConceptBoards";
	private String shopSelectedRoomIdsListInSn = "shopSelectedRoomIdsListInSn";
	private String shopSelectedRoomsCount = "shopSelectedRoomsCount";
	private String shopCBRoomsCount = "shopCBRoomsCount";
	private String shopCBRoomsCountInSn = "shopCBRoomsCountInSn";
	private String totalShopCBProductsCountInSn = "totalShopCBProductsCountInSn";
	private String totalShopCBProductsCount = "totalShopCBProductsCount";
	private String shopViewDesignsCBIdsListInSn = "shopViewDesignsCBIdsListInSn";
	private String shopViewDesignsCBImagesListInSn = "shopViewDesignsCBImagesListInSn";
	private String redirectStatus = "redirect:";
	private String redirectShopSelectedConceptBoards = "redirectShopSelectedConceptBoards";
	private String shopShoppingCartInfoDisplay = "shopShoppingCartInfoDisplay";
	private String jSonObject = "JSonObj";
	private String shopCBPCartTotalPriceInDbInSn = "shopCBPCartTotalPriceInDbInSn";
	private String shopFTPCartTotalPriceInDbInSn = "shopFTPCartTotalPriceInDbInSn";
	private String shopCheckoutBillShippInfoDisplay = "shopCheckoutBillShippInfoDisplay";
	private String shopCBStateTaxAmountInSn = "shopCBStateTaxAmountInSn";
	private String shopCBShippingAmountInSn = "shopCBShippingAmountInSn";
	private String shopCartTotalPayableDbAmountInSn = "shopCartTotalPayableDbAmountInSn";
	private String shopCartTotalPayableStAmountInSn = "shopCartTotalPayableStAmountInSn";
	private String shopCBStateTaxDbAmountInSn = "shopCBStateTaxDbAmountInSn";
	private String shopCBShippingDbAmountInSn = "shopCBShippingDbAmountInSn";
	private String shopFTStateTaxDbAmountInSn = "shopFTStateTaxDbAmountInSn";
	private String shopFTShippingDbAmountInSn = "shopFTShippingDbAmountInSn";
	private String shopCartTotalProductDbAmountInSn = "shopCartTotalProductDbAmountInSn";
	private String shopCartTotalProductStAmountInSn = "shopCartTotalProductStAmountInSn";
	private String shoppingCartStateTaxStAmountInSn = "shoppingCartStateTaxStAmountInSn";
	private String shoppingCartStateTaxDbAmountInSn = "shoppingCartStateTaxDbAmountInSn";
	private String shoppingCartShippingStAmountInSn = "shoppingCartShippingStAmountInSn";
	private String shoppingCartShippingDbAmountInSn = "shoppingCartShippingDbAmountInSn";
	
	private String shopTotalAmountStFormInSn = "shopTotalAmountStFormInSn";
	private String totalShopProductPriceDbInSn = "totalShopProductPriceDbInSn";
	private String totalShopProductPriceStInSn = "totalShopProductPriceStInSn";
	private String defaultCouponPriceInSn = "defaultCouponPriceInSn";
	
	private String shopBillingAndShippingInfoInSn = "shopBillingAndShippingInfoInSn";
	private String shopBillingFullName = "shopBillingFullName";
	private String shopBillingAddress1 = "shopBillingAddress1";
	private String shopBillingAddress2 = "shopBillingAddress2";
	private String shopBillingCity = "shopBillingCity";
	private String shopBillingState = "shopBillingState";
	private String shopBillingZip = "shopBillingZip";
	private String shopCheckBoxStatus = "shopCheckBoxStatus";
	private String shopShippingFullName = "shopShippingFullName";
	private String shopShippingAddress1 = "shopShippingAddress1";
	private String shopShippingAddress2 = "shopShippingAddress2";
	private String shopShippingCity = "shopShippingCity";
	private String shopShippingState = "shopShippingState";
	private String shopShippingZip = "shopShippingZip";
	private String shopUserFullName = "shopUserFullName";
	private String shopUserEmail = "shopUserEmail";
	private String shopUserPhNumber = "shopUserPhNumber";
	private String countryName = "UNITED STATES";
	private String shopPaymentErrorStatus = "shopPaymentErrorStatus";
	private String shopPaymentReturnStatus = "shopPaymentReturnStatus";
	private String shopCartDelCountInSn = "shopCartDelCountInSn";
	private String shopFTProductCartValueListInSn = "shopFTProductCartValueListInSn";
	private String shopPaymentSuccess = "shopPaymentSuccess";
	
	private String nameOnCard = "nameOnCard";
	private String payCardNumber = "payCardNumber";
	private String payExpMonth = "payExpMonth";
	private String payExpYear = "payExpYear";
	private String payCvvNumber = "payCvvNumber";	
	
	private String shopPaymentOrderNumber = "shopPaymentOrderNumber";
	private String shopPaymentOrderNumberInSn = "shopPaymentOrderNumberInSn";
	
	private String shopTermsPopupDisplayDisplay = "shopTermsPopupDisplayDisplay";
	private String shopPrivacyPolicyPopupDisplay = "shopPrivacyPolicyPopupDisplay";
	
	private String viewShopAllDesignConceptsDisplay = "viewShopAllDesignConceptsDisplay";
	private String shopConceptBoardsBigImageInSn = "shopConceptBoardsBigImageInSn";
	private String shopMostPopularStatusInSn = "shopMostPopularStatusInSn";
	private String shopReviewAndPlaceOrderDisplay = "shopReviewAndPlaceOrderDisplay";
	private String shopCheckoutPaymentInfoDisplay = "shopCheckoutPaymentInfoDisplay";
	private String shopPaymentSuccessDisplay = "shopPaymentSuccessDisplay";
	
	private String shopProductSavingIdsListInSn = "shopProductSavingIdsListInSn";
	private String shopProductImages1ListInSn = "shopProductImages1ListInSn";
	private String shopProductNamesListInSn = "shopProductNamesListInSn";
	private String shopProductStoreNamesListInSn = "shopProductStoreNamesListInSn";
	private String shopProductPricesListInSn = "shopProductPricesListInSn";
	private String shopProductImages2ListInSn = "shopProductImages2ListInSn";
	private String shopProductImages3ListInSn = "shopProductImages3ListInSn";
	private String shopProductImages4ListInSn = "shopProductImages4ListInSn";
	private String shopProductPopUpValuesListInSn = "shopProductPopUpValuesListInSn";

	private String shopCBProductsSavingId = "shopCBProductsSavingId";
	private String productQuantity = "productQuantity";
	private String shopCBProductCartValueListInSn = "shopCBProductCartValueListInSn";
	private String shopCartCountInSn = "shopCartCountInSn";
	private String shopCBCartCountInSn = "shopCBCartCountInSn";
	private String shopFTCartCountInSn = "shopFTCartCountInSn";
	private String shopCBPCartTotalPriceInSn = "shopCBPCartTotalPriceInSn";
	private String shopProductPrice = "shopProductPrice";
	private String shopProductName = "shopProductName";
	private String shopProductImage = "shopProductImage";
	
	private String purchasesStatus = "Purchases";
	private String couponCodeStatus = "couponCodeStatus";
	private String shopCouponCode = "shopCouponCode";
	private String shopCouponCode5Off = "5OFF";
	private String shopCouponCode7Off = "7OFF";
	private String shopCouponCode10Off = "10OFF";
	private String shopCouponCodeDbPriceInSn = "shopCouponCodeDbPriceInSn";
	private String shopCouponCodeStPriceInSn = "shopCouponCodeStPriceInSn";
//	private String originalCBTotalPriceInSn = "originalCBTotalPriceInSn";
	private String shopPaymentWithCouponInfoDisplay = "shopPaymentWithCouponInfoDisplay";
	private String totalPaybleAmountForEmailInSn = "totalPaybleAmountForEmailInSn";
	private String shopTotalPriceAmountInSt = "shopTotalPriceAmountInSt";	
	private String shopPercentageValue = "shopPercentageValue";
	private String shopDiscountPrice = "shopDiscountPrice";
	private String shopCouponCodeRef = "shopCouponCodeRef";
	private String shopTotalAmountWithAllTaxesInSn = "shopTotalAmountWithAllTaxesInSn";
	private String referralUserDisplayReff = "referralUserDisplayReff";
	private String shopPaymentWithZeroCouponInfoDisplay = "shopPaymentWithZeroCouponInfoDisplay";
	private String referralUserRefName = "Refferral User";
	
	private String transactionNumberInSn = "transactionNumberInSn";
	private String accountTypeInSn = "accountTypeInSn";
	private String authorizationCodeInSn = "authorizationCodeInSn";
	
	

	@Autowired
	private ShopFinishingTouchesService shopFinishingTouchesService;
	
	@Autowired
    private AdminRegistryConceptBoardsSavingDAO adminRegistryConceptBoardsSavingDAO;

	@Autowired
    private AdminRegistryConceptBoardsFurnitureSpecsSavingDAO adminRegistryConceptBoardsFurnitureSpecsSavingDAO;

	@Autowired
    private ShopUserPaymentInfoSavingDAO shopUserPaymentInfoSavingDAO;

	@Autowired
    private ShopConceptBoardsProductsInfoSavingDAO shopConceptBoardsProductsInfoSavingDAO;

	@Autowired
    private ReferralCustomGiftCardsInfoSavingDAO referralCustomGiftCardsInfoSavingDAO;

	@Autowired
    private RegistryPaymentGatewayService registryPaymentGatewayService;

	@Autowired
    private AdminRegistryFinishingTouchesProductsInfoSavingDAO adminRegistryFinishingTouchesProductsInfoSavingDAO;

    @Override
    @Transactional
    public ModelAndView registryShopRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
        mav = new ModelAndView(registryShopHome);           	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopSelectedRoomConceptBoardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
	  	List registryConBdRoomIdsList = new ArrayList();
	  	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(selectedShopRoomName));  	
	  	if (!registryConBdRoomsList.isEmpty()) {
	  		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
	  			registryConBdRoomIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
	   	   }
	  	}
	  	int shopsCBRoomCount = Integer.parseInt(req.getParameter(shopCBRoomsCount));
    	Long shopConceptBoardsId = (Long) registryConBdRoomIdsList.get(shopsCBRoomCount);
    	sn.setAttribute(totalShopCBProductsCountInSn, registryConBdRoomsList.size());
    	shopSelectedConceptBoardsProductsList(req, sn, shopConceptBoardsId);
    	mav = new ModelAndView(shopSelectedConceptBoards);
	  	mav.addObject(shopSelectedRoomsCount, registryConBdRoomsList.size());
	  	mav.addObject(selectedShopRoomName, req.getParameter(selectedShopRoomName));
	  	sn.setAttribute(shopCBRoomsCountInSn, shopsCBRoomCount);
	  	return mav;
    }
      
    public String shopSelectedConceptBoardsProductsList(HttpServletRequest req, HttpSession sn, Long shopConceptBoardsId) {
    	String allShopProductsinfo = null;
    	byte[] conBoardsImageFromDB = null;
    	List shopProductSavingIdList = new ArrayList();
    	List shopProductImage1List = new ArrayList();
		List shopProductNameList = new ArrayList();
		List shopProductStoreNameList = new ArrayList();
		List shopProductPriceList = new ArrayList();		
		List shopProductImage2List = new ArrayList();
		List shopProductImage3List = new ArrayList();
		List shopProductImage4List = new ArrayList();
		List shopProductPopUpValueList = new ArrayList();
		String shopMostPopularStatus = null;
		List <AdminRegistryConceptBoardsSaving> registryConBdRoomStyleList = adminRegistryConceptBoardsSavingDAO.registrantConceptBoardsSelRoomAndStyleListTakeFromDB(shopConceptBoardsId);
		if (!registryConBdRoomStyleList.isEmpty()) {
			AdminRegistryConceptBoardsSaving registryConBdRoomModel = adminRegistryConceptBoardsSavingDAO.registrantConceptBoardsSelRoomDataTakeFromDB(shopConceptBoardsId);
			conBoardsImageFromDB = registryConBdRoomModel.getConceptBoardsImage();
			shopMostPopularStatus = registryConBdRoomModel.getMostPopularCB();
		}
		List<AdminRegistryConceptBoardsFurnitureSpecsSaving> totalFurSpecsProductsList = adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecCount(shopConceptBoardsId);
		if (!totalFurSpecsProductsList.isEmpty()) {        	
	 		for (AdminRegistryConceptBoardsFurnitureSpecsSaving furnSpecsProductsSavingModel : totalFurSpecsProductsList) {
	 			shopProductSavingIdList.add(furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId());	 			
	 			String prodCombValues =  furnSpecsProductsSavingModel.getProductSize1() + "_,_" + furnSpecsProductsSavingModel.getProductPrice1() + "_,_" + furnSpecsProductsSavingModel.getProductSize2() + "_,_" + furnSpecsProductsSavingModel.getProductPrice2() + "_,_" + furnSpecsProductsSavingModel.getProductSize3() + "_,_" + furnSpecsProductsSavingModel.getProductPrice3() + "_,_" + furnSpecsProductsSavingModel.getProductSize4() + "_,_" + furnSpecsProductsSavingModel.getProductPrice4() + "_,_" + furnSpecsProductsSavingModel.getProductSize5() + "_,_" + furnSpecsProductsSavingModel.getProductPrice5() + "_,_" + furnSpecsProductsSavingModel.getProductDescription1();
	 			String totalPopUpValuesList = furnSpecsProductsSavingModel.getProductName() + "_,_" + furnSpecsProductsSavingModel.getAdminRegistryConceptBoardsFurnitureSpecsSavingId() + "_,_" + prodCombValues  + "_,_" + furnSpecsProductsSavingModel.getStoreName(); 
	 			shopProductImage1List.add(furnSpecsProductsSavingModel.getProductUploadedImage1());
	 			shopProductNameList.add(furnSpecsProductsSavingModel.getProductName());
	 			shopProductStoreNameList.add(furnSpecsProductsSavingModel.getStoreName());
	 			shopProductPriceList.add(furnSpecsProductsSavingModel.getProductPrice1());
	 			shopProductPopUpValueList.add(totalPopUpValuesList);
	 			shopProductImage2List.add(furnSpecsProductsSavingModel.getProductUploadedImage2());
	 			shopProductImage3List.add(furnSpecsProductsSavingModel.getProductUploadedImage3());
	 			shopProductImage4List.add(furnSpecsProductsSavingModel.getProductUploadedImage4());
	 		}	 		
	 		sn.setAttribute(shopProductSavingIdsListInSn, shopProductSavingIdList);
	 		sn.setAttribute(shopProductImages1ListInSn, shopProductImage1List);
	 		sn.setAttribute(shopProductNamesListInSn, shopProductNameList);
	 		sn.setAttribute(shopProductStoreNamesListInSn, shopProductStoreNameList);
	 		sn.setAttribute(shopProductPricesListInSn, shopProductPriceList);	 		
	 		sn.setAttribute(shopProductImages2ListInSn, shopProductImage2List);
	 		sn.setAttribute(shopProductImages3ListInSn, shopProductImage3List);
	 		sn.setAttribute(shopProductImages4ListInSn, shopProductImage4List);
	 		sn.setAttribute(shopProductPopUpValuesListInSn, shopProductPopUpValueList);
		}
		sn.setAttribute(shopConceptBoardsBigImageInSn, conBoardsImageFromDB);
		sn.setAttribute(shopMostPopularStatusInSn, shopMostPopularStatus);
  		return allShopProductsinfo;
    }
  
    @Override
    @Transactional
    public ModelAndView previousShopCBProductsDisplayFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List shopConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> shopConBoardsRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(selectedShopRoomName));  	
    	if (!shopConBoardsRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : shopConBoardsRoomsList) {
    			shopConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}    	
    	int shopsCBRoomCount = Integer.parseInt(req.getParameter(shopCBRoomsCount)) - 1;
    	Long shopConceptBoardsId = (Long) shopConceptBoardsIdsList.get(shopsCBRoomCount);
    	shopSelectedConceptBoardsProductsList(req, sn, shopConceptBoardsId);
    	sn.setAttribute(totalShopCBProductsCountInSn, shopConBoardsRoomsList.size());
    	mav = new ModelAndView(shopSelectedConceptBoards);
    	sn.setAttribute(shopSelectedRoomIdsListInSn, shopConceptBoardsIdsList);        
        mav.addObject(totalShopCBProductsCount, shopConBoardsRoomsList.size());
        mav.addObject(selectedShopRoomName, req.getParameter(selectedShopRoomName));        
    	sn.setAttribute(shopCBRoomsCountInSn, shopsCBRoomCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nextShopCBProductsDisplayFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List shopConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> registryConBdRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(selectedShopRoomName));  	
    	if (!registryConBdRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : registryConBdRoomsList) {
    			shopConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}    	
    	int shopsCBRoomCount = Integer.parseInt(req.getParameter(shopCBRoomsCount)) + 1;
    	Long shopConceptBoardsId = (Long) shopConceptBoardsIdsList.get(shopsCBRoomCount);
    	shopSelectedConceptBoardsProductsList(req, sn, shopConceptBoardsId);
    	sn.setAttribute(totalShopCBProductsCountInSn, registryConBdRoomsList.size());
    	sn.setAttribute(shopSelectedRoomIdsListInSn, shopConceptBoardsIdsList);
    	mav = new ModelAndView(shopSelectedConceptBoards);    	        
        mav.addObject(totalShopCBProductsCount, registryConBdRoomsList.size());
        mav.addObject(selectedShopRoomName, req.getParameter(selectedShopRoomName));
        sn.setAttribute(shopCBRoomsCountInSn, shopsCBRoomCount);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopViewAllDesignsConceptBoards(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List shopConBdRoomIdsList = new ArrayList();
    	List shopConBdRoomImagesList = new ArrayList();
    	List <AdminRegistryConceptBoardsSaving> shopConBoardsRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(selectedShopRoomName));  	
    	if (!shopConBoardsRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : shopConBoardsRoomsList) {
    			shopConBdRoomIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());
    			shopConBdRoomImagesList.add(registryConBdSavingModel.getConceptBoardsImage());
     	   }
    	}
    	mav = new ModelAndView(viewShopAllDesignConceptsDisplay);
    	sn.setAttribute(shopViewDesignsCBIdsListInSn, shopConBdRoomIdsList);
        sn.setAttribute(shopViewDesignsCBImagesListInSn, shopConBdRoomImagesList);
        mav.addObject(totalShopCBProductsCount, shopConBoardsRoomsList.size());
        mav.addObject(selectedShopRoomName, req.getParameter(selectedShopRoomName));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView viewShopDesignSelectedConceptBoards(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List shopConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> shopConBoardsRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB(req.getParameter(selectedShopRoomName));  	
    	if (!shopConBoardsRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : shopConBoardsRoomsList) {
    			shopConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int shopCBRoomCounts = Integer.parseInt(req.getParameter(shopCBRoomsCount));    	
    	Long shopConceptBoardsId = (Long) shopConceptBoardsIdsList.get(shopCBRoomCounts);    	
    	shopSelectedConceptBoardsProductsList(req, sn, shopConceptBoardsId);
    	sn.setAttribute(totalShopCBProductsCountInSn, shopConBoardsRoomsList.size());
    	mav = new ModelAndView(shopSelectedConceptBoards);
    	sn.setAttribute(shopSelectedRoomIdsListInSn, shopConceptBoardsIdsList);        
        mav.addObject(totalShopCBProductsCount, shopConBoardsRoomsList.size());
        mav.addObject(selectedShopRoomName, req.getParameter(selectedShopRoomName));        
    	sn.setAttribute(shopCBRoomsCountInSn, shopCBRoomCounts);
    	return mav;
    }

//  Concept Boards Products Add to Cart
    
    @Override
    @Transactional
    public ModelAndView shopSelectedCBProductsAddToShoppingCart(HttpServletRequest req, HttpSession sn) {    
    	ModelAndView mav;               
    	String shopConceptBoardsSnValue = null;
    	int totalCBCartCount = 0;
    	String shopsProductPrice = req.getParameter(shopProductPrice);
    	shopsProductPrice= shopsProductPrice.replace(",", "");    	
    	String shopConceptBoardsCombVal = req.getParameter(shopCBProductsSavingId) + "_,_" + req.getParameter(productQuantity) + "_,_" + shopsProductPrice + "_,_" + req.getParameter(shopProductName) + "_,_" + req.getParameter(shopProductImage);
    	if(null != sn.getAttribute(shopCBProductCartValueListInSn)) {
    		shopConceptBoardsSnValue = shopSelectedCBProductsValuesUpdateInCartSn(sn, (String) sn.getAttribute(shopCBProductCartValueListInSn), req.getParameter(shopCBProductsSavingId), req.getParameter(productQuantity), shopsProductPrice, req.getParameter(shopProductName), req.getParameter(shopProductImage));
          	totalCBCartCount = (int) sn.getAttribute(shopCBCartCountInSn);
    	} else {
          	shopConceptBoardsSnValue = shopConceptBoardsCombVal;
          	totalCBCartCount = Integer.parseInt(req.getParameter(productQuantity));          	
          	double totalCBProductPriceDb = Double.parseDouble(shopsProductPrice);          	
          	double totalCBProductPrice = totalCBProductPriceDb * totalCBCartCount;
          	String totalCBProductPriceSt = String.format("%,.2f", totalCBProductPrice);
          	sn.setAttribute(shopCBPCartTotalPriceInSn, totalCBProductPriceSt);
          	sn.setAttribute(shopCBPCartTotalPriceInDbInSn, totalCBProductPrice);
    	}    	
    	sn.setAttribute(shopCBCartCountInSn, totalCBCartCount);
    	sn.setAttribute(shopCBProductCartValueListInSn, shopConceptBoardsSnValue);
    	totalShoppingCartCount(req, sn);
    	mav = new ModelAndView(redirectStatus + redirectShopSelectedConceptBoards);
    	mav.addObject("guestAddCartReff", "Add To Cart");
    	sn.setAttribute(selectedShopRoomNameInSn, req.getParameter(selectedShopRoomName));
    	return mav;
    }
        
    public String shopSelectedCBProductsValuesUpdateInCartSn(HttpSession sn, String shopCBProductCartValues, String shopCBProductsSavingId, String productQuantity, String productPrice, String productName, String productImage) {
    	String shopConceptBoardsSnValue = null;
      	String prodIdCheckStatus = null;
      	double totalCBProductPriceDB = 0;
      	String[] shopCBProductCartValuesInSt = shopCBProductCartValues.split("__");
      	int totalShopCBCartCount = 0;
      	for(int i=0; i<shopCBProductCartValuesInSt.length; i++) {
      		String[] shopConceptBoardProdIdSt = shopCBProductCartValuesInSt[i].split("_,_");    		
      		if(shopCBProductsSavingId.equals(shopConceptBoardProdIdSt[0])) {
      			int shopQuantityInt = Integer.parseInt(productQuantity);
  				String totalProdQuantity = Integer.toString(shopQuantityInt);
  				String totalGuestProdComb = shopCBProductsSavingId + "_,_" + totalProdQuantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage;
  				prodIdCheckStatus = "Done";
  				shopConceptBoardsSnValue = shopConceptBoardsSnValue + "__" + totalGuestProdComb;
  				totalShopCBCartCount = totalShopCBCartCount + shopQuantityInt;
  				double totalCBProductPriceDb = Double.parseDouble(productPrice);
  	        	double totalCBProductPrice = totalCBProductPriceDb * shopQuantityInt;
  	        	totalCBProductPriceDB = totalCBProductPriceDB + totalCBProductPrice;
      		} else {
      			shopConceptBoardsSnValue = shopConceptBoardsSnValue + "__" + shopCBProductCartValuesInSt[i];
      			int shopSelQuantityCount = Integer.parseInt(shopConceptBoardProdIdSt[1]);
      			totalShopCBCartCount = totalShopCBCartCount + shopSelQuantityCount;
      			double totalCBProductPriceDb = Double.parseDouble(shopConceptBoardProdIdSt[2]);
  	        	double totalCBProductPrice = totalCBProductPriceDb * shopSelQuantityCount;
  	        	totalCBProductPriceDB = totalCBProductPriceDB + totalCBProductPrice;
      		}
      		shopConceptBoardsSnValue = shopConceptBoardsSnValue.replaceFirst("null__", "");    		
      	}
      	if(prodIdCheckStatus == null) {
      		String shopConceptBoardsInputVal = shopCBProductsSavingId + "_,_" + productQuantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage;
      		shopConceptBoardsSnValue = shopConceptBoardsSnValue + "__" + shopConceptBoardsInputVal;
      		int shopSelQuantityCount = Integer.parseInt(productQuantity);
      		totalShopCBCartCount = totalShopCBCartCount + shopSelQuantityCount;
      		double totalCBProductPriceDb = Double.parseDouble(productPrice);
          	double totalCBProductPrice = totalCBProductPriceDb * shopSelQuantityCount;
          	totalCBProductPriceDB = totalCBProductPriceDB + totalCBProductPrice;
      	}
      	String totalCBProductPriceSt = String.format("%,.2f", totalCBProductPriceDB);
      	sn.setAttribute(shopCBPCartTotalPriceInSn, totalCBProductPriceSt);
      	sn.setAttribute(shopCBPCartTotalPriceInDbInSn, totalCBProductPriceDB);
      	sn.setAttribute(shopCBCartCountInSn, totalShopCBCartCount);
      	return shopConceptBoardsSnValue;
    }

    @Override
    @Transactional
    public ModelAndView redirectShopSelectedProductConceptBoards(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List shopConceptBoardsIdsList = new ArrayList();    	
    	List <AdminRegistryConceptBoardsSaving> shopConBoardsRoomsList = adminRegistryConceptBoardsSavingDAO.registrantAdminConceptBoardsAllRoomListTakeFromDB((String) sn.getAttribute(selectedShopRoomNameInSn));  	
    	if (!shopConBoardsRoomsList.isEmpty()) {
    		for (AdminRegistryConceptBoardsSaving registryConBdSavingModel : shopConBoardsRoomsList) {
    			shopConceptBoardsIdsList.add(registryConBdSavingModel.getAdminRegistryConceptBoardsSavingId());    			
     	   }
    	}
    	int shopCBRoomCounts = (int) sn.getAttribute(shopCBRoomsCountInSn);
    	Long shopConceptBoardsId = (Long) shopConceptBoardsIdsList.get(shopCBRoomCounts);    	
    	shopSelectedConceptBoardsProductsList(req, sn, shopConceptBoardsId);
    	sn.setAttribute(totalShopCBProductsCountInSn, shopConBoardsRoomsList.size());
    	mav = new ModelAndView(shopSelectedConceptBoards);
    	sn.setAttribute(shopSelectedRoomIdsListInSn, shopConceptBoardsIdsList);        
        mav.addObject(totalShopCBProductsCount, shopConBoardsRoomsList.size());
        mav.addObject(selectedShopRoomName, (String) sn.getAttribute(selectedShopRoomNameInSn));
        sn.setAttribute(shopCBRoomsCountInSn, shopCBRoomCounts);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopShoppingCartInfoDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	int totalShoppingCartCount = totalShoppingCartCount(req,sn);
    	if(totalShoppingCartCount > 0) {
    		totalShoppingCartPrice(req, sn);
    		mav = new ModelAndView(shopShoppingCartInfoDisplay);    	
    		mav.addObject(selectedShopRoomName, (String) sn.getAttribute(selectedShopRoomNameInSn));
    	} else {
    		mav = registryShopRedirection(req, sn);
    	}
    	return mav;
    }
    
    public double totalShoppingCartPrice(HttpServletRequest req, HttpSession sn) {
    	double totalShopCBProductPriceDb = 0;
    	if(null != sn.getAttribute(shopCBPCartTotalPriceInDbInSn)) {
    		totalShopCBProductPriceDb = (double) sn.getAttribute(shopCBPCartTotalPriceInDbInSn);	
    	}
    	double totalShopFTProductPriceDb = 0;
    	if(null != sn.getAttribute(shopFTPCartTotalPriceInDbInSn)) {
    		totalShopFTProductPriceDb = (double) sn.getAttribute(shopFTPCartTotalPriceInDbInSn);	
    	}
    	double totalShopProductPriceDb = totalShopCBProductPriceDb + totalShopFTProductPriceDb;
    	sn.setAttribute(totalShopProductPriceDbInSn, totalShopProductPriceDb);
		String totalShopProductPriceSt = String.format("%,.2f", totalShopProductPriceDb);
		sn.setAttribute(totalShopProductPriceStInSn, totalShopProductPriceSt);
    	return totalShopProductPriceDb;
    }

    public int totalShoppingCartCount(HttpServletRequest req, HttpSession sn) {
    	int shopCBCartCountInt = 0;
    	if(null != sn.getAttribute(shopCBCartCountInSn)) {
    		shopCBCartCountInt = (int) sn.getAttribute(shopCBCartCountInSn);	
    	}
    	int shopFTCartCountInt = 0;
    	if(null != sn.getAttribute(shopFTCartCountInSn)) {
    		shopFTCartCountInt = (int) sn.getAttribute(shopFTCartCountInSn);	
    	}
    	int totalShoppingCartCount = shopCBCartCountInt + shopFTCartCountInt;
    	sn.setAttribute(shopCartCountInSn, totalShoppingCartCount);
		return totalShoppingCartCount;
    }

    @Override
    @Transactional
    public JSONArray jSonAddCartShopCBProductsValueUpdateInSn(String shopCBProductsInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] shopCBProductsInfoValueSt = shopCBProductsInfoValue.split("__");
    	shopCBProductsAddCartJSonValueUpdateInDB(sn, req, shopCBProductsInfoValueSt[0], shopCBProductsInfoValueSt[1], shopCBProductsInfoValueSt[2], shopCBProductsInfoValueSt[3]);
    	int totalShopCBCartCount = (int) sn.getAttribute(shopCartCountInSn);
    	sn.setAttribute(shopCartCountInSn, totalShopCBCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalShopCBCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String shopCBProductsAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String shopCBProductSavingsId, String shopCBProductGivenQuantity, String shopCBProductOldQuantity, String shopCBProductsPrice) {
    	String shopCBProductAddCartValue = null;
        int shopCBProductGivenQuantityInt = Integer.parseInt(shopCBProductGivenQuantity);
        int shopCBProductOldQuantityInt = Integer.parseInt(shopCBProductOldQuantity);
        double shopCBProductsPriceDb = Double.parseDouble(shopCBProductsPrice);        
        String shopCBProductCartValueSnValue = (String) sn.getAttribute(shopCBProductCartValueListInSn);
        String[] shopCBProductCartSnValueInSt = shopCBProductCartValueSnValue.split("__");
    	String shopCBProductCartValueSnValuesList = null;
    	for(int i = 0; i < shopCBProductCartSnValueInSt.length; i++) {
    		String[] checkShopCBProductCartSnValueSt = shopCBProductCartSnValueInSt[i].split("_,_");
    		if((shopCBProductSavingsId).equals(checkShopCBProductCartSnValueSt[0])) {
    			String newCBContributedValuesList = checkShopCBProductCartSnValueSt[0] + "_,_" + shopCBProductGivenQuantity + "_,_" + checkShopCBProductCartSnValueSt[2] + "_,_" + checkShopCBProductCartSnValueSt[3] + "_,_" + checkShopCBProductCartSnValueSt[4];
    			shopCBProductCartValueSnValuesList = shopCBProductCartValueSnValuesList + "__" + newCBContributedValuesList;
    		} else {
    			shopCBProductCartValueSnValuesList = shopCBProductCartValueSnValuesList + "__" + shopCBProductCartSnValueInSt[i];
    		}
    	}
    	if(shopCBProductCartSnValueInSt.length > 0) {
    		shopCBProductCartValueSnValuesList = shopCBProductCartValueSnValuesList.replaceFirst("null__", "");
    	}
    	int totalSnShopCBCartCount = (int) sn.getAttribute(shopCartCountInSn);
    	int totalShopCBCartCount = (totalSnShopCBCartCount - shopCBProductOldQuantityInt) + shopCBProductGivenQuantityInt;
    	int shopCBCartCount = (int) sn.getAttribute(shopCBCartCountInSn);
    	int remShopCBCartCount = (shopCBCartCount - shopCBProductOldQuantityInt) + shopCBProductGivenQuantityInt;
    	sn.setAttribute(shopCBCartCountInSn, remShopCBCartCount);
    	sn.setAttribute(shopCartCountInSn, totalShopCBCartCount);    	
    	sn.setAttribute(shopCBProductCartValueListInSn, shopCBProductCartValueSnValuesList);    	
    	double totalShopCBProductsPriceSn = (double) sn.getAttribute(shopCBPCartTotalPriceInDbInSn);
    	double shopCBProductOldAmountDb = shopCBProductsPriceDb * shopCBProductOldQuantityInt;
    	double shopCBProductNewAmountDb = shopCBProductsPriceDb * shopCBProductGivenQuantityInt;    	
    	double totalShopCBProductsPriceDb = (totalShopCBProductsPriceSn - shopCBProductOldAmountDb) + shopCBProductNewAmountDb;
    	sn.setAttribute(shopCBPCartTotalPriceInDbInSn, totalShopCBProductsPriceDb);    	
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", totalShopCBProductsPriceDb);
    	sn.setAttribute(shopCBPCartTotalPriceInSn, allShoppingCartTotalAmountSt);        
    	return shopCBProductAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonShopCBProductsInfoDeleteFromSn(String shopCBProductSavingId, HttpSession sn, HttpServletRequest req) {
    	shopCBProductsAddCartJSonValueDeleteFromDB(sn, req, shopCBProductSavingId);
    	int totalShopCBCartCount = (int) sn.getAttribute(shopCartDelCountInSn);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalShopCBCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String shopCBProductsAddCartJSonValueDeleteFromDB(HttpSession sn, HttpServletRequest req, String shopCBProductSavingId) {
    	String shopCBProductAddCartValue = null;               
        String shopCBProductCartValueSnValue = (String) sn.getAttribute(shopCBProductCartValueListInSn);
        String[] shopCBProductCartSnValueInSt = shopCBProductCartValueSnValue.split("__");
    	String shopCBProductCartValueSnValuesList = null;
    	int snShopQuantity = 0;
    	double shopCBProductSnPriceDb = 0;
    	for(int i = 0; i < shopCBProductCartSnValueInSt.length; i++) {
    		String[] checkShopCBProductCartSnValueSt = shopCBProductCartSnValueInSt[i].split("_,_");
    		if((shopCBProductSavingId).equals(checkShopCBProductCartSnValueSt[0])) {
    			snShopQuantity = Integer.parseInt(checkShopCBProductCartSnValueSt[1]);
    			double cbShopProductSnPriceDb = Double.parseDouble(checkShopCBProductCartSnValueSt[2]);
    			shopCBProductSnPriceDb = cbShopProductSnPriceDb * snShopQuantity;
    		} else {
    			shopCBProductCartValueSnValuesList = shopCBProductCartValueSnValuesList + "__" + shopCBProductCartSnValueInSt[i];
    		}
    	}
    	if(null != shopCBProductCartValueSnValuesList) {
    		shopCBProductCartValueSnValuesList = shopCBProductCartValueSnValuesList.replaceFirst("null__", "");
    	}    	
    	shopCBProductsCartCount(sn, req, snShopQuantity);
    	sn.setAttribute(shopCBProductCartValueListInSn, shopCBProductCartValueSnValuesList);
    	double totalShopCBProductsPriceSn = (double) sn.getAttribute(shopCBPCartTotalPriceInDbInSn);
    	double totalShopCBProductsPriceDb = totalShopCBProductsPriceSn - shopCBProductSnPriceDb;
    	sn.setAttribute(shopCBPCartTotalPriceInDbInSn, totalShopCBProductsPriceDb);    	
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", totalShopCBProductsPriceDb);
    	sn.setAttribute(shopCBPCartTotalPriceInSn, allShoppingCartTotalAmountSt);
    	return shopCBProductAddCartValue;
    }
    
    public int shopCBProductsCartCount(HttpSession sn, HttpServletRequest req, int snShopQuantity) {
    	int shopCBProductCartCount = 0;
    	int totalSnShopCBCartCount = (int) sn.getAttribute(shopCartCountInSn);
    	int shopCBCartCount = (int) sn.getAttribute(shopCBCartCountInSn);
    	int totalShopCBCartCount = totalSnShopCBCartCount - snShopQuantity;
    	int remShopCBCartCount = shopCBCartCount - snShopQuantity;
    	sn.setAttribute(shopCBCartCountInSn, remShopCBCartCount);
    	sn.setAttribute(shopCartDelCountInSn, totalShopCBCartCount);    	
    	if(totalShopCBCartCount > 0) {
    		sn.setAttribute(shopCartCountInSn, totalShopCBCartCount);
    		shopCBProductCartCount = totalShopCBCartCount;
    	} else {
    		sn.setAttribute(shopCartCountInSn, null);
    	}
    	return shopCBProductCartCount;
    }

    @Override
    @Transactional
    public ModelAndView shopCheckoutBillingAndShippingInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	shoppingCatProductsShippingAndTaxFees(req, sn);
    	String shopBillingAndShippingInfo = (String) sn.getAttribute(shopBillingAndShippingInfoInSn);
    	String shopBillingAndShippingInfo1 = null;
    	String shopBillingAndShippingInfo2 = null;
    	String shopBillingAndShippingInfo3 = null;
    	String shopBillingAndShippingInfo4 = null;    	
    	String shopBillingAndShippingInfo5 = null;
    	String shopBillingAndShippingInfo6 = null;
    	String shopBillingAndShippingInfo7 = null;
    	String shopBillingAndShippingInfo8 = null;
    	String shopBillingAndShippingInfo9 = null;
    	String shopBillingAndShippingInfo10 = null;
    	String shopBillingAndShippingInfo11 = null;
    	String shopBillingAndShippingInfo12 = null;
    	String shopBillingAndShippingInfo13 = null;
    	String shopBillingAndShippingInfo14 = null;
    	String shopBillingAndShippingInfo15 = null;
    	String shopBillingAndShippingInfo16 = null;
    	if(null != shopBillingAndShippingInfo) {
    		String shopBillingAndShippingInfoSt[] = shopBillingAndShippingInfo.split("__");
    		shopBillingAndShippingInfo1 = shopBillingAndShippingInfoSt[0];
    		shopBillingAndShippingInfo2 = shopBillingAndShippingInfoSt[1];
    		shopBillingAndShippingInfo3 = shopBillingAndShippingInfoSt[2];
    		shopBillingAndShippingInfo4 = shopBillingAndShippingInfoSt[3];
    		shopBillingAndShippingInfo5 = shopBillingAndShippingInfoSt[4];
    		shopBillingAndShippingInfo6 = shopBillingAndShippingInfoSt[5];
    		shopBillingAndShippingInfo7 = shopBillingAndShippingInfoSt[6];
    		shopBillingAndShippingInfo8 = shopBillingAndShippingInfoSt[7];
    		shopBillingAndShippingInfo9 = shopBillingAndShippingInfoSt[8];
    		shopBillingAndShippingInfo10 = shopBillingAndShippingInfoSt[9];
    		shopBillingAndShippingInfo11 = shopBillingAndShippingInfoSt[10];
    		shopBillingAndShippingInfo12 = shopBillingAndShippingInfoSt[11];
    		shopBillingAndShippingInfo13 = shopBillingAndShippingInfoSt[12];
    		shopBillingAndShippingInfo14 = shopBillingAndShippingInfoSt[13];
    		shopBillingAndShippingInfo15 = shopBillingAndShippingInfoSt[14];
    		shopBillingAndShippingInfo16 = shopBillingAndShippingInfoSt[15];
    	}
    	mav = new ModelAndView(shopCheckoutBillShippInfoDisplay);
    	mav.addObject(shopBillingFullName, shopBillingAndShippingInfo1);
    	mav.addObject(shopBillingAddress1, shopBillingAndShippingInfo2);
    	mav.addObject(shopBillingAddress2, shopBillingAndShippingInfo3);
    	mav.addObject(shopBillingCity, shopBillingAndShippingInfo4);
    	mav.addObject(shopBillingState, shopBillingAndShippingInfo5);
    	mav.addObject(shopBillingZip, shopBillingAndShippingInfo6);
    	mav.addObject(shopShippingFullName, shopBillingAndShippingInfo7);
    	mav.addObject(shopShippingAddress1, shopBillingAndShippingInfo8);
    	mav.addObject(shopShippingAddress2, shopBillingAndShippingInfo9);
    	mav.addObject(shopShippingCity, shopBillingAndShippingInfo10);
    	mav.addObject(shopShippingState, shopBillingAndShippingInfo11);
    	mav.addObject(shopShippingZip, shopBillingAndShippingInfo12);    	
    	mav.addObject(shopUserFullName, shopBillingAndShippingInfo13);
    	mav.addObject(shopUserEmail, shopBillingAndShippingInfo14);
    	mav.addObject(shopUserPhNumber, shopBillingAndShippingInfo15);
    	mav.addObject(shopCheckBoxStatus, shopBillingAndShippingInfo16);
    	return mav;
    }

    public String shoppingCatProductsShippingAndTaxFees(HttpServletRequest req, HttpSession sn) {    	
    	String shopShippingAndTaxFee = null;
    	double shoppingCartStateTaxDbAmount = 0;
    	double shoppingCartShippingDbAmount = 0;
    	double shopCartTotalProductDbAmount = 0;
    	double shopCartTotalPayableDbAmount = 0;
    	double dsnAndFinTOuTotaldbAmount = 0;
    	if(null != sn.getAttribute(shopCBPCartTotalPriceInDbInSn)) {
    		double totalShopCBProductsPriceSn = (double) sn.getAttribute(shopCBPCartTotalPriceInDbInSn);
    		dsnAndFinTOuTotaldbAmount = dsnAndFinTOuTotaldbAmount + totalShopCBProductsPriceSn;
//    		double shopCBStateTaxAmountDb = (totalShopCBProductsPriceSn/100)*8;
    		double shopCBStateTaxAmountDb = 0;
    		shoppingCartStateTaxDbAmount = shoppingCartStateTaxDbAmount + shopCBStateTaxAmountDb;
    		String shopCBStateTaxDbAmount = String.format("%.2f", shopCBStateTaxAmountDb);
        	sn.setAttribute(shopCBStateTaxDbAmountInSn, shopCBStateTaxDbAmount);
//    		double shopCBShippingAmountDb = (totalShopCBProductsPriceSn/100)*10;
        	double shopCBShippingAmountDb = 0;
    		shoppingCartShippingDbAmount = shoppingCartShippingDbAmount + shopCBShippingAmountDb;
    		String shopCBShippingDbAmount = String.format("%.2f", shopCBShippingAmountDb);
        	sn.setAttribute(shopCBShippingDbAmountInSn, shopCBShippingDbAmount);
    		shopCartTotalProductDbAmount = shopCartTotalProductDbAmount + totalShopCBProductsPriceSn;
    		shopCartTotalPayableDbAmount = shopCartTotalPayableDbAmount + totalShopCBProductsPriceSn + shopCBStateTaxAmountDb + shopCBShippingAmountDb;    		
    	}
    	if(null != sn.getAttribute(shopFTPCartTotalPriceInDbInSn)) {
    		double totalShopFTProductsPriceSn = (double) sn.getAttribute(shopFTPCartTotalPriceInDbInSn);
    		dsnAndFinTOuTotaldbAmount = dsnAndFinTOuTotaldbAmount + totalShopFTProductsPriceSn;
//    		double shopFTStateTaxAmountDb = (totalShopFTProductsPriceSn/100)*8;
    		double shopFTStateTaxAmountDb = 0;
    		shoppingCartStateTaxDbAmount = shoppingCartStateTaxDbAmount + shopFTStateTaxAmountDb;
    		String shopFTStateTaxDbAmount = String.format("%.2f", shopFTStateTaxAmountDb);
        	sn.setAttribute(shopFTStateTaxDbAmountInSn, shopFTStateTaxDbAmount);
//    		double shopFTShippingAmountDb = (totalShopFTProductsPriceSn/100)*10;
        	double shopFTShippingAmountDb = 0;
    		shoppingCartShippingDbAmount = shoppingCartShippingDbAmount + shopFTShippingAmountDb;
    		String shopFTShippingDbAmount = String.format("%.2f", shopFTShippingAmountDb);
        	sn.setAttribute(shopFTShippingDbAmountInSn, shopFTShippingDbAmount);
    		shopCartTotalProductDbAmount = shopCartTotalProductDbAmount + totalShopFTProductsPriceSn;
    		shopCartTotalPayableDbAmount = shopCartTotalPayableDbAmount + totalShopFTProductsPriceSn + shopFTStateTaxAmountDb + shopFTShippingAmountDb;
    	}    	
    	double shopCartTotalPayableWCDbAmount = defaultCouponCodeFee(req, sn, dsnAndFinTOuTotaldbAmount, shopCartTotalPayableDbAmount);
    	String shopCartTotalProductDblAmount = String.format("%.2f", shopCartTotalProductDbAmount);
    	sn.setAttribute(shopCartTotalProductDbAmountInSn, shopCartTotalProductDblAmount);    	
    	String shopCartTotalProductStAmount = String.format("%,.2f", shopCartTotalProductDbAmount);
    	sn.setAttribute(shopCartTotalProductStAmountInSn, shopCartTotalProductStAmount);    	
    	String shoppingCartStateTaxStAmount = String.format("%,.2f", shoppingCartStateTaxDbAmount);
    	sn.setAttribute(shoppingCartStateTaxStAmountInSn, shoppingCartStateTaxStAmount);
    	String shoppingCartStateTaxAmountSt = String.format("%.2f", shoppingCartStateTaxDbAmount);
    	sn.setAttribute(shoppingCartStateTaxDbAmountInSn, shoppingCartStateTaxAmountSt);
    	String shoppingCartShippingStAmount = String.format("%,.2f", shoppingCartShippingDbAmount);
    	sn.setAttribute(shoppingCartShippingStAmountInSn, shoppingCartShippingStAmount);
    	String shoppingCartShippingAmountSt = String.format("%.2f", shoppingCartShippingDbAmount);
    	sn.setAttribute(shoppingCartShippingDbAmountInSn, shoppingCartShippingAmountSt);
    	String shopCartTotalAmountWithTaxsDb = String.format("%.2f", shopCartTotalPayableWCDbAmount);
    	sn.setAttribute(shopCartTotalPayableDbAmountInSn, shopCartTotalAmountWithTaxsDb);
    	String shopCartTotalAmountWithTaxsSt = String.format("%,.2f", shopCartTotalPayableWCDbAmount);
    	sn.setAttribute(shopCartTotalPayableStAmountInSn, shopCartTotalAmountWithTaxsSt);
    	return shopShippingAndTaxFee;
    }
    
    public double defaultCouponCodeFee(HttpServletRequest req, HttpSession sn, double dsnAndFinTOuTotaldbAmount, double shopCartTotalPayableDbAmount) {
    	double defaultCouponPrice = 0;
    	if(shopCartTotalPayableDbAmount > 0) {
    		double defaultCouponPriceDb = (dsnAndFinTOuTotaldbAmount/100)*5;
    		String defaultCouponPriceSt = String.format("%,.2f", defaultCouponPriceDb);
    		sn.setAttribute(defaultCouponPriceInSn, defaultCouponPriceSt);
    		defaultCouponPrice = shopCartTotalPayableDbAmount - defaultCouponPriceDb;
    	}
    	return defaultCouponPrice;
    }
    
    @Override
    @Transactional
    public ModelAndView shopBillAndShipInfoSavingInSn(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String shopBillingAndShippingInfo = req.getParameter(shopBillingFullName) + "__" + req.getParameter(shopBillingAddress1) + "__" + req.getParameter(shopBillingAddress2) + "__" + req.getParameter(shopBillingCity) + "__" + req.getParameter(shopBillingState) + "__" + req.getParameter(shopBillingZip) + "__" + req.getParameter(shopShippingFullName) + "__" + req.getParameter(shopShippingAddress1) + "__" + req.getParameter(shopShippingAddress2) + "__" + req.getParameter(shopShippingCity) + "__" + req.getParameter(shopShippingState) + "__" + req.getParameter(shopShippingZip) + "__" + req.getParameter(shopUserFullName) + "__" + req.getParameter(shopUserEmail) + "__" + req.getParameter(shopUserPhNumber) + "__" + req.getParameter(shopCheckBoxStatus);
    	sn.setAttribute(shopBillingAndShippingInfoInSn, shopBillingAndShippingInfo);
    	mav = new ModelAndView(shopReviewAndPlaceOrderDisplay);
    	mav.addObject(shopBillingFullName, req.getParameter(shopBillingFullName));
    	mav.addObject(shopBillingAddress1, req.getParameter(shopBillingAddress1));
    	mav.addObject(shopBillingAddress2, req.getParameter(shopBillingAddress2));
    	mav.addObject(shopBillingCity, req.getParameter(shopBillingCity));
    	mav.addObject(shopBillingState, req.getParameter(shopBillingState));
    	mav.addObject(shopBillingZip, req.getParameter(shopBillingZip));
    	mav.addObject(shopShippingFullName, req.getParameter(shopShippingFullName));
    	mav.addObject(shopShippingAddress1, req.getParameter(shopShippingAddress1));
    	mav.addObject(shopShippingAddress2, req.getParameter(shopShippingAddress2));
    	mav.addObject(shopShippingCity, req.getParameter(shopShippingCity));
    	mav.addObject(shopShippingState, req.getParameter(shopShippingState));
    	mav.addObject(shopShippingZip, req.getParameter(shopShippingZip));    	
    	mav.addObject(shopUserFullName, req.getParameter(shopUserFullName));
    	mav.addObject(shopUserEmail, req.getParameter(shopUserEmail));
    	mav.addObject(shopUserPhNumber, req.getParameter(shopUserPhNumber));
    	mav.addObject(shopCheckBoxStatus, req.getParameter(shopCheckBoxStatus));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopCheckoutPaymentInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	mav = new ModelAndView(shopCheckoutPaymentInfoDisplay);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopGiftOrPromoCodePaymentInfoRedirection(HttpServletRequest req, HttpSession sn) {  	
    	ModelAndView mav;
    	List<ReferralCustomGiftCardsInfoSaving> refCustomGiftCardsInfoList = referralCustomGiftCardsInfoSavingDAO.referralCustomGiftCardCodeCheckInDB(req.getParameter(shopCouponCode));
		if (!refCustomGiftCardsInfoList.isEmpty()) {
			mav = shopReferralCustomGiftCardPaymentInfoOnly(req, sn, req.getParameter(nameOnCard), req.getParameter(payCardNumber), req.getParameter(payExpMonth), req.getParameter(payExpYear), req.getParameter(payCvvNumber));
		} else {
			mav = shopUserGiftPromoCodePaymentInfoOnly(req, sn, req.getParameter(nameOnCard), req.getParameter(payCardNumber), req.getParameter(payExpMonth), req.getParameter(payExpYear), req.getParameter(payCvvNumber));
		}    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopReferralCustomGiftCardPaymentInfoOnly(HttpServletRequest req, HttpSession sn, String shNameOnCard, String shPayCardNumber, String shPayExpMonth, String shPayExpYear, String shPayCvvNumber) {  	
    	ModelAndView mav;
    	String shopCouponCodeDbPrice = null;
    	String shopCouponCodeStPrice = null;
    	String shopCartTotalPayableAmountDb = (String) sn.getAttribute(shopCartTotalPayableDbAmountInSn);
    	double shopCartTotalPayableDbAmount = Double.parseDouble(shopCartTotalPayableAmountDb);
    	ReferralCustomGiftCardsInfoSaving refCustomGiftCardModel = referralCustomGiftCardsInfoSavingDAO.referralCustomGiftCardCodeInfoTakeFromDB(req.getParameter(shopCouponCode));
    	sn.setAttribute(shopCartTotalProductStAmountInSn, sn.getAttribute(shopCartTotalPayableStAmountInSn));
    	double shopTotalPableAmount = 0;
		double totalCouponCodePriceDb = 0;
		if(shopCartTotalPayableDbAmount > refCustomGiftCardModel.getRemainingCredit()) {
			shopTotalPableAmount = shopCartTotalPayableDbAmount - refCustomGiftCardModel.getRemainingCredit();
			totalCouponCodePriceDb = refCustomGiftCardModel.getRemainingCredit();
			shopCouponCodeDbPrice = String.format("%.2f", totalCouponCodePriceDb);
    		shopCouponCodeStPrice = String.format("%,.2f", totalCouponCodePriceDb);
			mav = new ModelAndView(shopPaymentWithCouponInfoDisplay);
		} else {
			shopTotalPableAmount = 0.00;
			totalCouponCodePriceDb = shopCartTotalPayableDbAmount;
			shopCouponCodeDbPrice = String.format("%.2f", totalCouponCodePriceDb);
    		shopCouponCodeStPrice = String.format("%,.2f", totalCouponCodePriceDb);
			mav = new ModelAndView(shopPaymentWithZeroCouponInfoDisplay);
		}
		sn.setAttribute(shopCouponCodeDbPriceInSn, shopCouponCodeDbPrice);
    	sn.setAttribute(shopCouponCodeStPriceInSn, shopCouponCodeStPrice);		
		String shopCartTotalAmountWithTaxsDb = String.format("%.2f", shopTotalPableAmount);
    	sn.setAttribute(shopCartTotalPayableDbAmountInSn, shopCartTotalAmountWithTaxsDb);
    	String shopCartTotalAmountWithTaxsSt = String.format("%,.2f", shopTotalPableAmount);
    	sn.setAttribute(shopCartTotalPayableStAmountInSn, shopCartTotalAmountWithTaxsSt);
    	String shopTotalPriceAmountSt = String.format("%.2f", shopCartTotalPayableDbAmount);
    	sn.setAttribute(shopTotalPriceAmountInSt, shopTotalPriceAmountSt);    	
    	mav.addObject(referralUserDisplayReff, referralUserRefName);
    	mav.addObject(nameOnCard, shNameOnCard);
    	mav.addObject(payCardNumber, shPayCardNumber);
        mav.addObject(payExpMonth, shPayExpMonth);
        mav.addObject(payExpYear, shPayExpYear);        
        mav.addObject(payCvvNumber, shPayCvvNumber);
        mav.addObject(shopCouponCodeRef, req.getParameter(shopCouponCode));
        mav.addObject(shopDiscountPrice, shopCouponCodeDbPrice);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopUserGiftPromoCodePaymentInfoOnly(HttpServletRequest req, HttpSession sn, String shNameOnCard, String shPayCardNumber, String shPayExpMonth, String shPayExpYear, String shPayCvvNumber) {  	
    	ModelAndView mav;
    	String shopCartTotalProductDbAmount = (String) sn.getAttribute(shopCartTotalProductDbAmountInSn);
    	double shopCartTotalPayableDbAmount = Double.parseDouble(shopCartTotalProductDbAmount);
    	String couponCodeStatusReff = null;
    	String shopCouponCodeDbPrice = null;
    	String shopCouponCodeStPrice = null;
    	String shopPercentageReff = null;
    	String shopCouponReff = null;
    	if(((shopCouponCode5Off).equals(req.getParameter(shopCouponCode))) && (shopCartTotalPayableDbAmount >= 1000 && shopCartTotalPayableDbAmount < 1999)) {
    		double couponCodePriceDb = (shopCartTotalPayableDbAmount/100)*5;
    		double totalShopCartWithPromoPrice = shopCartTotalPayableDbAmount - couponCodePriceDb;
    		shopCartShippingAndTaxFeeWithPromoCode(req, sn, totalShopCartWithPromoPrice, shopCartTotalPayableDbAmount);
    		shopCouponCodeDbPrice = String.format("%.2f", couponCodePriceDb);
    		shopCouponCodeStPrice = String.format("%,.2f", couponCodePriceDb);
    		shopPercentageReff = "5%";
    		shopCouponReff = shopCouponCode5Off;
    		mav = new ModelAndView(shopPaymentWithCouponInfoDisplay);
    	} else if(((shopCouponCode7Off).equals(req.getParameter(shopCouponCode))) && (shopCartTotalPayableDbAmount >= 2000 && shopCartTotalPayableDbAmount < 2999)) {
    		double couponCodePriceDb = (shopCartTotalPayableDbAmount/100)*7;
    		double totalShopCartWithPromoPrice = shopCartTotalPayableDbAmount - couponCodePriceDb;
    		shopCartShippingAndTaxFeeWithPromoCode(req, sn, totalShopCartWithPromoPrice, shopCartTotalPayableDbAmount);
    		shopCouponCodeDbPrice = String.format("%.2f", couponCodePriceDb);
    		shopCouponCodeStPrice = String.format("%,.2f", couponCodePriceDb);
    		shopPercentageReff = "7%";
    		shopCouponReff = shopCouponCode7Off;
    		mav = new ModelAndView(shopPaymentWithCouponInfoDisplay);
    	} else if(((shopCouponCode10Off).equals(req.getParameter(shopCouponCode))) && shopCartTotalPayableDbAmount >= 3000) {
    		double couponCodePriceDb = (shopCartTotalPayableDbAmount/100)*10;
    		double totalShopCartWithPromoPrice = shopCartTotalPayableDbAmount - couponCodePriceDb;
    		shopCartShippingAndTaxFeeWithPromoCode(req, sn, totalShopCartWithPromoPrice, shopCartTotalPayableDbAmount);
    		shopCouponCodeDbPrice = String.format("%.2f", couponCodePriceDb);
    		shopCouponCodeStPrice = String.format("%,.2f", couponCodePriceDb);
    		shopPercentageReff = "10%";
    		shopCouponReff = shopCouponCode10Off;
    		mav = new ModelAndView(shopPaymentWithCouponInfoDisplay);
    	} else {
    		shopPercentageReff = null;
    		couponCodeStatusReff = "Wrong Code";
        	shoppingCatProductsShippingAndTaxFees(req, sn);
        	mav = new ModelAndView(shopCheckoutPaymentInfoDisplay);
        	mav.addObject(couponCodeStatus, couponCodeStatusReff);
    	}    	    	
    	sn.setAttribute(shopCouponCodeDbPriceInSn, shopCouponCodeDbPrice);
    	sn.setAttribute(shopCouponCodeStPriceInSn, shopCouponCodeStPrice);
    	mav.addObject(referralUserDisplayReff, null);
    	mav.addObject(nameOnCard, shNameOnCard);
    	mav.addObject(payCardNumber, shPayCardNumber);
        mav.addObject(payExpMonth, shPayExpMonth);
        mav.addObject(payExpYear, shPayExpYear);        
        mav.addObject(payCvvNumber, shPayCvvNumber);        
        mav.addObject(shopPercentageValue, shopPercentageReff);
        mav.addObject(shopDiscountPrice, shopCouponCodeDbPrice);
        mav.addObject(shopCouponCodeRef, shopCouponReff);
        sn.setAttribute(shopTotalAmountWithAllTaxesInSn, null);
        return mav;
    }

    public String shopCartShippingAndTaxFeeWithPromoCode(HttpServletRequest req, HttpSession sn, double totalShopCartWithPromoPrice, double totalShopCartProductsPrice) {    	
    	String shopShippingAndTaxFee = null;
//    	double shoppingCartStateTaxDbAmount = (totalShopCartWithPromoPrice/100)*8;
    	double shoppingCartStateTaxDbAmount = 0;
    	String shoppingCartStateTaxStAmount = String.format("%,.2f", shoppingCartStateTaxDbAmount);
    	sn.setAttribute(shoppingCartStateTaxStAmountInSn, shoppingCartStateTaxStAmount);
    	String shoppingCartStateTaxAmountSt = String.format("%.2f", shoppingCartStateTaxDbAmount);
    	sn.setAttribute(shoppingCartStateTaxDbAmountInSn, shoppingCartStateTaxAmountSt);
//    	double shoppingCartShippingDbAmount = (totalShopCartProductsPrice/100)*10;
    	double shoppingCartShippingDbAmount = 0;
    	double shopCartTotalProductDbAmount = totalShopCartProductsPrice + shoppingCartStateTaxDbAmount + shoppingCartShippingDbAmount;    	
    	String shopCartTotalProductStAmount = String.format("%.2f", shopCartTotalProductDbAmount);
    	sn.setAttribute(shopCartTotalProductStAmountInSn, shopCartTotalProductStAmount);
    	double shopCartTotalPayableDbAmount = totalShopCartWithPromoPrice + shoppingCartStateTaxDbAmount + shoppingCartShippingDbAmount;    	
    	String shopCartTotalAmountWithTaxsDb = String.format("%.2f", shopCartTotalPayableDbAmount);
    	sn.setAttribute(shopCartTotalPayableDbAmountInSn, shopCartTotalAmountWithTaxsDb);
    	String shopCartTotalAmountWithTaxsSt = String.format("%,.2f", shopCartTotalPayableDbAmount);
    	sn.setAttribute(shopCartTotalPayableStAmountInSn, shopCartTotalAmountWithTaxsSt);    	
    	return shopShippingAndTaxFee;
    }

	@Override
    @Transactional
    public ModelAndView shopCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
		String nameOnCard1 = req.getParameter(nameOnCard);    	  	  	
    	long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
    	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear);
    	Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
    	String amount = (String) sn.getAttribute(shopCartTotalPayableDbAmountInSn);
    	String shopBillingAndShippingInfo = (String) sn.getAttribute(shopBillingAndShippingInfoInSn);
    	String shopBillingAndShippingInfoSt[] = shopBillingAndShippingInfo.split("__");
    	String fullName = shopBillingAndShippingInfoSt[0];    	
    	String cityName = shopBillingAndShippingInfoSt[3];
    	String stateName = shopBillingAndShippingInfoSt[4];
    	String zipCode = shopBillingAndShippingInfoSt[5];
    	String emailAddress = shopBillingAndShippingInfoSt[13];
    	String fullAddress = shopBillingAndShippingInfoSt[1] + " " + shopBillingAndShippingInfoSt[2];        
        String paymentReturnTypeReff = registryPaymentGatewayService.totalPaymentInfoSendToAuthorizeNetGateway(req, sn, amount, cardNumber, expirationDate, cardCode, fullName, emailAddress, fullAddress, cityName, stateName, zipCode);        
        long transactionNumber = (Long) sn.getAttribute(transactionNumberInSn);
        String accountType = (String) sn.getAttribute(accountTypeInSn);
        String authorizationCode = (String) sn.getAttribute(authorizationCodeInSn);        
        if(("This transaction has been approved.").equals(paymentReturnTypeReff)) {
    		Timestamp currentDate = currentDate();
    		shopUserPaymentInformationUpdateInDB(req, sn, cardNumber, accountType, expirationDate, cardCode, paymentReturnTypeReff, nameOnCard1, shopBillingAndShippingInfo, authorizationCode, transactionNumber, amount, currentDate);
    		sn.setAttribute(shopPaymentOrderNumberInSn, transactionNumber);
    		sn.setAttribute(totalPaybleAmountForEmailInSn, sn.getAttribute(shopCartTotalPayableDbAmountInSn));
    		mav = new ModelAndView(redirectStatus + shopPaymentSuccess);    		
    	} else {    		
    		mav = new ModelAndView(shopCheckoutPaymentInfoDisplay);    		
		    mav.addObject(payCardNumber, req.getParameter(payCardNumber));
		    mav.addObject(payExpMonth, req.getParameter(payExpMonth));
		    mav.addObject(payExpYear, req.getParameter(payExpYear));
		    mav.addObject(nameOnCard, req.getParameter(nameOnCard));
		    mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
		    mav.addObject(shopPaymentErrorStatus, "Payment Fail");
		    mav.addObject(shopPaymentReturnStatus, paymentReturnTypeReff);
    	}
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopPaymentSuccessRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;                
        mav = new ModelAndView(shopPaymentSuccessDisplay);
        mav.addObject(shopPaymentOrderNumber, sn.getAttribute(shopPaymentOrderNumberInSn));
        shopCartAllSessionValuesGoingToNull(req, sn);
        return mav;
    }

//	Shop Concept Boards Payment Info Saving	
    public String shopUserPaymentInformationUpdateInDB(HttpServletRequest req, HttpSession sn, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String shopBillingAndShippingInfo, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate) {    	
    	String shopPaymentReffVal = null;        
    	ShopUserPaymentInfoSaving shopUserPaymentSavingModel = new ShopUserPaymentInfoSaving();
        String shopBillingAndShippingInfoSt[] = shopBillingAndShippingInfo.split("__");        
        shopUserPaymentSavingModel.setBillFullName(shopBillingAndShippingInfoSt[0]);
        shopUserPaymentSavingModel.setBillAddress1(shopBillingAndShippingInfoSt[1]);
        shopUserPaymentSavingModel.setBillAddress2(shopBillingAndShippingInfoSt[2]);
        shopUserPaymentSavingModel.setBillCity(shopBillingAndShippingInfoSt[3]);
        shopUserPaymentSavingModel.setBillState(shopBillingAndShippingInfoSt[4]);
        shopUserPaymentSavingModel.setBillZip(shopBillingAndShippingInfoSt[5]);
        shopUserPaymentSavingModel.setBillCountry(countryName);
        shopUserPaymentSavingModel.setShipFullName(shopBillingAndShippingInfoSt[6]);
        shopUserPaymentSavingModel.setShipAddress1(shopBillingAndShippingInfoSt[7]);
        shopUserPaymentSavingModel.setShipAddress2(shopBillingAndShippingInfoSt[8]);
        shopUserPaymentSavingModel.setShipCity(shopBillingAndShippingInfoSt[9]);
        shopUserPaymentSavingModel.setShipState(shopBillingAndShippingInfoSt[10]);
        shopUserPaymentSavingModel.setShipZip(shopBillingAndShippingInfoSt[11]);
        shopUserPaymentSavingModel.setShipCountry(countryName);
        shopUserPaymentSavingModel.setShopUserEmail(shopBillingAndShippingInfoSt[13]);
        shopUserPaymentSavingModel.setShopUserPhoneNumber(shopBillingAndShippingInfoSt[14]);
        shopUserPaymentSavingModel.setCheckboxStatus(shopBillingAndShippingInfoSt[15]);
        String accCardNumber = Long.toString(cardNumber);
        shopUserPaymentSavingModel.setPayCardNumber(accCardNumber);
        shopUserPaymentSavingModel.setAccountType(accountType);
        shopUserPaymentSavingModel.setPayExpDate(expirationDate);
    	String cvvNum = Integer.toString(cardCode);
    	shopUserPaymentSavingModel.setPayCvvNumber(cvvNum);
    	shopUserPaymentSavingModel.setCheckoutPaymentStatus(returnType);
    	shopUserPaymentSavingModel.setNameOnCard(nameOnCard1);
    	shopUserPaymentSavingModel.setAuthorizationCode(authorizationCode);
    	shopUserPaymentSavingModel.setTransactionNumber(transactionNumber);
    	shopUserPaymentSavingModel.setEstimatedAmount((String) sn.getAttribute(shopCartTotalProductDbAmountInSn));
    	shopUserPaymentSavingModel.setStateTaxAmount((String) sn.getAttribute(shoppingCartStateTaxDbAmountInSn));
    	shopUserPaymentSavingModel.setShippingAmount((String) sn.getAttribute(shoppingCartShippingDbAmountInSn));
    	shopUserPaymentSavingModel.setTotalPaybleAmount((String) sn.getAttribute(shopCartTotalPayableDbAmountInSn));
    	shopUserPaymentSavingModel.setDefaultCouponPrice((String) sn.getAttribute(defaultCouponPriceInSn));
    	shopUserPaymentSavingModel.setCreatedDate(currentDate);
    	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    	shopUserPaymentSavingModel.setCreatedDateInSt(todayDate);    	
    	shopUserPaymentInfoSavingDAO.save(shopUserPaymentSavingModel);
    	shopConceptBoardsInfoSavingInDB(req, sn, shopUserPaymentSavingModel.getShopUserPaymentInfoSavingId(), returnType, currentDate, transactionNumber);
    	shopFinishingTouchesService.shopFinishingTouchesInfoSavingInDB(req, sn, shopUserPaymentSavingModel.getShopUserPaymentInfoSavingId(), returnType, currentDate, transactionNumber);
    	shopCartPaymentPurchaseToTheUser(req, sn, shopBillingAndShippingInfoSt[13], shopBillingAndShippingInfoSt[6], transactionNumber, (String) sn.getAttribute(shoppingCartShippingStAmountInSn), (String) sn.getAttribute(shoppingCartStateTaxStAmountInSn), (String) sn.getAttribute(shopCartTotalPayableStAmountInSn), (String) sn.getAttribute(shopCBProductCartValueListInSn), (String) sn.getAttribute(shopFTProductCartValueListInSn));
        return shopPaymentReffVal;
    }

	@Override
    @Transactional
    public ModelAndView shopCartPaymentPurchaseToGatewayWithCCRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;		
    	String nameOnCard1 = req.getParameter(nameOnCard);    	  	  	
    	long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
    	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear);
    	Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
    	String amount = (String) sn.getAttribute(shopCartTotalPayableDbAmountInSn);
    	String shopBillingAndShippingInfo = (String) sn.getAttribute(shopBillingAndShippingInfoInSn);
    	String shopBillingAndShippingInfoSt[] = shopBillingAndShippingInfo.split("__");
    	String fullName = shopBillingAndShippingInfoSt[0];    	
    	String cityName = shopBillingAndShippingInfoSt[3];
    	String stateName = shopBillingAndShippingInfoSt[4];
    	String zipCode = shopBillingAndShippingInfoSt[5];
    	String emailAddress = shopBillingAndShippingInfoSt[13];
    	String fullAddress = shopBillingAndShippingInfoSt[1] + " " + shopBillingAndShippingInfoSt[2];        
        String paymentReturnTypeReff = registryPaymentGatewayService.totalPaymentInfoSendToAuthorizeNetGateway(req, sn, amount, cardNumber, expirationDate, cardCode, fullName, emailAddress, fullAddress, cityName, stateName, zipCode);        
        long transactionNumber = (Long) sn.getAttribute(transactionNumberInSn);
        String accountType = (String) sn.getAttribute(accountTypeInSn);
        String authorizationCode = (String) sn.getAttribute(authorizationCodeInSn);        
        if(("This transaction has been approved.").equals(paymentReturnTypeReff)) {
    		Timestamp currentDate = currentDate();    		
    		shopUserPaymentInformationWithCCUpdateInDB(req, sn, cardNumber, accountType, expirationDate, cardCode, paymentReturnTypeReff, nameOnCard1, shopBillingAndShippingInfo, authorizationCode, transactionNumber, amount, currentDate, req.getParameter(shopPercentageValue), req.getParameter(shopDiscountPrice), req.getParameter(shopCouponCodeRef), req.getParameter(referralUserDisplayReff));    		
    		sn.setAttribute(shopPaymentOrderNumberInSn, transactionNumber);
    		sn.setAttribute(totalPaybleAmountForEmailInSn, sn.getAttribute(shopCartTotalPayableDbAmountInSn));
    		mav = new ModelAndView(redirectStatus + shopPaymentSuccess);
    	} else {    		
    		mav = new ModelAndView(shopPaymentWithCouponInfoDisplay);
    		mav.addObject(shopPercentageValue, req.getParameter(shopPercentageValue));
    	    mav.addObject(shopDiscountPrice, req.getParameter(shopDiscountPrice));
    	    mav.addObject(shopCouponCodeRef, req.getParameter(shopCouponCodeRef));    		
		    mav.addObject(payCardNumber, req.getParameter(payCardNumber));
		    mav.addObject(payExpMonth, req.getParameter(payExpMonth));
		    mav.addObject(payExpYear, req.getParameter(payExpYear));
		    mav.addObject(nameOnCard, req.getParameter(nameOnCard));
		    mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
		    mav.addObject(shopPaymentErrorStatus, "Payment Fail");
		    mav.addObject(shopPaymentReturnStatus, paymentReturnTypeReff);
    	}
        return mav;
    }

//	100% Referral Coupon Code used with Zero Payment value
	@Override
    @Transactional
    public ModelAndView shopCouponZeroPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn) {
		ModelAndView mav;
		String amount = (String) sn.getAttribute(shopCartTotalPayableDbAmountInSn);
    	String shopBillingAndShippingInfo = (String) sn.getAttribute(shopBillingAndShippingInfoInSn);
    	Timestamp currentDate = currentDate();
    	String returnType = "This transaction is zero.";
    	long orderNumber = shopPaymentOrderNumberGenerate(req, sn);
    	shopUserPaymentInformationWithCCUpdateInDB(req, sn, 0, null, null, 0, returnType, null, shopBillingAndShippingInfo, null, orderNumber, amount, currentDate, req.getParameter(shopPercentageValue), req.getParameter(shopDiscountPrice), req.getParameter(shopCouponCodeRef), req.getParameter(referralUserDisplayReff));    		
    	sn.setAttribute(shopPaymentOrderNumberInSn, orderNumber);
    	sn.setAttribute(totalPaybleAmountForEmailInSn, sn.getAttribute(shopCartTotalPayableDbAmountInSn));
    	mav = new ModelAndView(redirectStatus + shopPaymentSuccess);
        return mav;
    }

    public Long shopPaymentOrderNumberGenerate(HttpServletRequest req, HttpSession sn) {
	    String alphaNumerics = "1234567890";
	    long orderNumber = 0;
	    String t = "";
	    for (int i = 0; i < 10; i++) {
	        t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }
	    orderNumber = Long.parseLong(t);
	    return orderNumber;
    }

//	Shop Concept Boards Payment Info Saving	
    public String shopUserPaymentInformationWithCCUpdateInDB(HttpServletRequest req, HttpSession sn, long cardNumber, String accountType, String expirationDate, Integer cardCode, String returnType, String nameOnCard1, String shopBillingAndShippingInfo, String authorizationCode, long transactionNumber, String amount, Timestamp currentDate, String shopsPercentageValue, String shopsDiscountPrice, String shopsCouponCodeRef, String referralUserDisplayRef) {    	
    	String shopPaymentReffVal = null;        
    	ShopUserPaymentInfoSaving shopUserPaymentSavingModel = new ShopUserPaymentInfoSaving();
    	String shopBillingAndShippingInfoSt[] = shopBillingAndShippingInfo.split("__");        
        shopUserPaymentSavingModel.setBillFullName(shopBillingAndShippingInfoSt[0]);
        shopUserPaymentSavingModel.setBillAddress1(shopBillingAndShippingInfoSt[1]);
        shopUserPaymentSavingModel.setBillAddress2(shopBillingAndShippingInfoSt[2]);
        shopUserPaymentSavingModel.setBillCity(shopBillingAndShippingInfoSt[3]);
        shopUserPaymentSavingModel.setBillState(shopBillingAndShippingInfoSt[4]);
        shopUserPaymentSavingModel.setBillZip(shopBillingAndShippingInfoSt[5]);
        shopUserPaymentSavingModel.setBillCountry(countryName);
        shopUserPaymentSavingModel.setShipFullName(shopBillingAndShippingInfoSt[6]);
        shopUserPaymentSavingModel.setShipAddress1(shopBillingAndShippingInfoSt[7]);
        shopUserPaymentSavingModel.setShipAddress2(shopBillingAndShippingInfoSt[8]);
        shopUserPaymentSavingModel.setShipCity(shopBillingAndShippingInfoSt[9]);
        shopUserPaymentSavingModel.setShipState(shopBillingAndShippingInfoSt[10]);
        shopUserPaymentSavingModel.setShipZip(shopBillingAndShippingInfoSt[11]);
        shopUserPaymentSavingModel.setShipCountry(countryName);
        shopUserPaymentSavingModel.setShopUserEmail(shopBillingAndShippingInfoSt[13]);
        shopUserPaymentSavingModel.setShopUserPhoneNumber(shopBillingAndShippingInfoSt[14]);
        shopUserPaymentSavingModel.setCheckboxStatus(shopBillingAndShippingInfoSt[15]);
        String accCardNumber = Long.toString(cardNumber);
        shopUserPaymentSavingModel.setPayCardNumber(accCardNumber);
        shopUserPaymentSavingModel.setAccountType(accountType);
        shopUserPaymentSavingModel.setPayExpDate(expirationDate);
    	String cvvNum = Integer.toString(cardCode);
    	shopUserPaymentSavingModel.setPayCvvNumber(cvvNum);
    	shopUserPaymentSavingModel.setCheckoutPaymentStatus(returnType);
    	shopUserPaymentSavingModel.setNameOnCard(nameOnCard1);
    	shopUserPaymentSavingModel.setAuthorizationCode(authorizationCode);
    	shopUserPaymentSavingModel.setTransactionNumber(transactionNumber);
    	shopUserPaymentSavingModel.setEstimatedAmount((String) sn.getAttribute(shopCartTotalProductDbAmountInSn));
    	shopUserPaymentSavingModel.setStateTaxAmount((String) sn.getAttribute(shoppingCartStateTaxDbAmountInSn));
    	shopUserPaymentSavingModel.setShippingAmount((String) sn.getAttribute(shoppingCartShippingDbAmountInSn));
    	shopUserPaymentSavingModel.setTotalPaybleAmount((String) sn.getAttribute(shopCartTotalPayableDbAmountInSn));
    	shopUserPaymentSavingModel.setShopCouponCode(shopsCouponCodeRef);
    	shopUserPaymentSavingModel.setShopDiscountAmount(shopsDiscountPrice);
    	shopUserPaymentSavingModel.setShopDiscountPercentage(shopsPercentageValue);
    	if((referralUserRefName).equals(referralUserDisplayRef)) {
    		shopUserPaymentSavingModel.setReferralUserReferance(referralUserDisplayRef);
    		shopReferralCouponCodeInfoUpdateInDB(req, sn, shopsCouponCodeRef, shopsDiscountPrice);
    	}
    	shopUserPaymentSavingModel.setCreatedDate(currentDate);
    	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    	shopUserPaymentSavingModel.setCreatedDateInSt(todayDate);    	
    	shopUserPaymentInfoSavingDAO.save(shopUserPaymentSavingModel);
    	shopConceptBoardsInfoSavingInDB(req, sn, shopUserPaymentSavingModel.getShopUserPaymentInfoSavingId(), returnType, currentDate, transactionNumber);
    	shopFinishingTouchesService.shopFinishingTouchesInfoSavingInDB(req, sn, shopUserPaymentSavingModel.getShopUserPaymentInfoSavingId(), returnType, currentDate, transactionNumber);
    	shopCartPaymentPurchaseToTheUser(req, sn, shopBillingAndShippingInfoSt[13], shopBillingAndShippingInfoSt[6], transactionNumber, (String) sn.getAttribute(shoppingCartShippingStAmountInSn), (String) sn.getAttribute(shoppingCartStateTaxStAmountInSn), (String) sn.getAttribute(shopCartTotalPayableStAmountInSn), (String) sn.getAttribute(shopCBProductCartValueListInSn), (String) sn.getAttribute(shopFTProductCartValueListInSn));
        return shopPaymentReffVal;
    }

//	Shop Referral User Coupon Code table update	
    public String shopReferralCouponCodeInfoUpdateInDB(HttpServletRequest req, HttpSession sn, String shopRefrCouponCode, String shopsDiscountPrice) {    	
    	String shopeferralCouponReffVal = null;        
    	ReferralCustomGiftCardsInfoSaving refCustomGiftCardModel = referralCustomGiftCardsInfoSavingDAO.referralCustomGiftCardCodeInfoTakeFromDB(shopRefrCouponCode);
    	double shopsDiscountPriceDb = Double.parseDouble(shopsDiscountPrice);
    	double totalUsedCreditDb = shopsDiscountPriceDb + refCustomGiftCardModel.getUsedCredit();
    	double remnTotalCreditDb = refCustomGiftCardModel.getRemainingCredit() - shopsDiscountPriceDb;
    	refCustomGiftCardModel.setUsedCredit(totalUsedCreditDb);
    	refCustomGiftCardModel.setRemainingCredit(remnTotalCreditDb);
    	referralCustomGiftCardsInfoSavingDAO.merge(refCustomGiftCardModel);
        return shopeferralCouponReffVal;
    }

    public String shopCartPaymentPurchaseToTheUser(HttpServletRequest req, HttpSession sn, String shopUserEmail, String userFullName, long transactionNumber, String shoppingCartShippingStAmount, String shoppingCartStateTaxStAmount, String shopCartTotalPayableStAmount, String shopCBProductCartValueList, String shopFTProductCartValueList) {
    	String shopCartPaymentReff = null;
    	String[] emailList = {shopUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
    	String subject = "Thank You For Your Order!";            
    	String type = "text/html";           
    	EmailSending userEmail = new EmailSending();
    	String fromAdd = "info@nookandcove.com";              
    	String body1 = "<body>"    				
                    + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                    + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>Thank you for your order!</p>"
                    + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                    + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>We are excited that you found something that you like! As soon as your package is on its way, we will send you an email with a tracking link.</p>"                    
                    + "<p style='margin-top: 40px; font: bold 1.05em/1em sans-serif;'>Order Number: " + transactionNumber + "</p>"
                    + "</div>"
                    + "</body> ";    	
    	String body2 = "";
    	if(null != shopCBProductCartValueList) {
	        String[] shopCBProductCartValuesInSt = shopCBProductCartValueList.split("__");
			for(int i=0; i<shopCBProductCartValuesInSt.length; i++) {
				String[] shopConceptBoardProdIdSt = shopCBProductCartValuesInSt[i].split("_,_");
				long shopConceptBoardProdId = Long.parseLong(shopConceptBoardProdIdSt[0]);
	      		AdminRegistryConceptBoardsFurnitureSpecsSaving adminRegCBFurnitureSpecsModel =  adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecGiftReceivedData(shopConceptBoardProdId);      		
		        String bodyLoop = "<body>"
		        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
		        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + adminRegCBFurnitureSpecsModel.getProductName() + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + adminRegCBFurnitureSpecsModel.getProductSize1() + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>Quantity: " + shopConceptBoardProdIdSt[1] + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + shopConceptBoardProdIdSt[2] + "</p>"
		        		+ "</div>"
		        		+ "</body> ";
		        body2 = body2 + bodyLoop;
			}
		}
    	if(null != shopFTProductCartValueList) {
	        String[] shopFTProductCartValuesInSt = shopFTProductCartValueList.split("__");
			for(int i=0; i<shopFTProductCartValuesInSt.length; i++) {
				String[] shopConceptBoardProdIdSt = shopFTProductCartValuesInSt[i].split("_,_");
				long shopConceptBoardProdId = Long.parseLong(shopConceptBoardProdIdSt[0]);
				AdminRegistryFinishingTouchesProductsInfoSaving adminRegFTFurnitureSpecsModel =  adminRegistryFinishingTouchesProductsInfoSavingDAO.adminShopRegFinishingTouchesProductsDataTakeFromDB(shopConceptBoardProdId);      		
		        String bodyLoop = "<body>"
		        		+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
		        		+ "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + adminRegFTFurnitureSpecsModel.getProductName() + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'> " + adminRegFTFurnitureSpecsModel.getProductSize1() + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>Quantity: " + shopConceptBoardProdIdSt[1] + "</p>"
		        		+ "<p style='font: 1.05em/1em sans-serif;'>$" + shopConceptBoardProdIdSt[2] + "</p>"
		        		+ "</div>"
		        		+ "</body> ";
		        body2 = body2 + bodyLoop;
			}
		}
		String body3 = "<body>"
					+ "<div style='margin-left: 30px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
					+ "<div style='margin-top: 10px; border-top: 1px solid black; width: 300px;'></div>"
					+ "<p style='margin-top: 15px; font: 1.05em/1em sans-serif;'>Shipping: $" + shoppingCartShippingStAmount + "</p>"
					+ "<p style='font: 1.05em/1em sans-serif;'>Tax: $" + shoppingCartStateTaxStAmount + "</p>"
					+ "<p style='margin-top: 10px; font: bold 1.05em/1.25em sans-serif;'>Total: $" + shopCartTotalPayableStAmount + "</p>"					
					+ "<p style='margin-top: 40px; font: 1.05em/1.5em sans-serif;'>If you have any questions regarding this order, please reply to this email and we will get back to you as soon as possible.</p>"
					+ "<p style='margin-top: 20px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>We are always adding new products and designs to our store so come back and visit us soon!</p>"
					+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
					+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
                    + "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                    + "</div>"
                    + "</body> ";
		String body =  body1 + body2 + body3;
    	try {
    		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
    	} catch (Exception ex) {
    		LOGGER.error("Shop cart payment purchase mail failed " + ex);
    	}       
    	return shopCartPaymentReff;
    }

//	Concept Boards Info Add to That Tables	
    public String shopConceptBoardsInfoSavingInDB(HttpServletRequest req, HttpSession sn, long shopCartPaymentInfoSavingId, String returnType, Timestamp currentDate, long transactionNumber) {
        String shopConceptBoardsReffVal = null;        
        String shopCBProductCartValueList = (String) sn.getAttribute(shopCBProductCartValueListInSn);
        if(null != shopCBProductCartValueList) {
	        String[] shopCBProductCartValuesInSt = shopCBProductCartValueList.split("__");
	        for(int i=0; i<shopCBProductCartValuesInSt.length; i++) {
	      		String[] shopConceptBoardProdIdSt = shopCBProductCartValuesInSt[i].split("_,_");
	      		long shopConceptBoardProdId = Long.parseLong(shopConceptBoardProdIdSt[0]);
	      		int quantity = Integer.parseInt(shopConceptBoardProdIdSt[1]);
	      		AdminRegistryConceptBoardsFurnitureSpecsSaving adminRegCBFurnitureSpecsModel =  adminRegistryConceptBoardsFurnitureSpecsSavingDAO.registrantAdminRegFurnitureSpecGiftReceivedData(shopConceptBoardProdId);
	      		ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = new ShopConceptBoardsProductsInfoSaving();
	      		shopCBProductsSavingModel.setAdminRegistryConceptBoardsFurnitureSpecsSavingId(shopConceptBoardProdId);
	      		shopCBProductsSavingModel.setProductName(adminRegCBFurnitureSpecsModel.getProductName());
	      		shopCBProductsSavingModel.setProductUploadedImage(adminRegCBFurnitureSpecsModel.getProductUploadedImage1());
	      		shopCBProductsSavingModel.setProductPrice(shopConceptBoardProdIdSt[2]);
	      		shopCBProductsSavingModel.setProductDescription(adminRegCBFurnitureSpecsModel.getProductDescription1());
	      		shopCBProductsSavingModel.setProductSize(adminRegCBFurnitureSpecsModel.getProductSize1());
	      		shopCBProductsSavingModel.setStoreName(adminRegCBFurnitureSpecsModel.getStoreName());
	      		shopCBProductsSavingModel.setStoreUrl(adminRegCBFurnitureSpecsModel.getStoreUrl());
	      		shopCBProductsSavingModel.setQuantity(quantity);
	      		shopCBProductsSavingModel.setShopUserPaymentInfoSavingId(shopCartPaymentInfoSavingId);
	      		shopCBProductsSavingModel.setCheckoutPaymentStatus(returnType);
	      		shopCBProductsSavingModel.setShopProductStatus(purchasesStatus);
	      		int orderNumber = shopCBOrderNumberGenerate(req, sn);
	      		shopCBProductsSavingModel.setOrderNumber(orderNumber);
	      		shopCBProductsSavingModel.setTransactionNumber(transactionNumber);
	      		shopCBProductsSavingModel.setRefferanceDate(currentDate);
	      		shopCBProductsSavingModel.setCreatedDate(currentDate);      		
	      		shopConceptBoardsProductsInfoSavingDAO.save(shopCBProductsSavingModel);
	        }
        }
        return shopConceptBoardsReffVal;
    }
    
    public Integer shopCBOrderNumberGenerate(HttpServletRequest req, HttpSession sn) {
	    String alphaNumerics = "1234567890";
	    int orderNumber = 0;
	    String t = "";
	    for (int i = 0; i < 8; i++) {
	        t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }
	    orderNumber = Integer.parseInt(t);
	    return orderNumber;
    }

//	All Session Values Going to NUll	
    public String shopCartAllSessionValuesGoingToNull(HttpServletRequest req, HttpSession sn) {
        String shopAllSessionValuesGoingToNull = null;        
        sn.setAttribute(shopCartCountInSn, null);
        sn.setAttribute(shopCBRoomsCountInSn, null);        
        sn.setAttribute(shopCBPCartTotalPriceInDbInSn, null);
        sn.setAttribute(shopFTPCartTotalPriceInDbInSn, null);
        sn.setAttribute(shopTotalAmountWithAllTaxesInSn, null);
        sn.setAttribute(shopCBStateTaxAmountInSn, null);
        sn.setAttribute(shopCBShippingAmountInSn, null);
        sn.setAttribute(shopCartTotalPayableDbAmountInSn, null);
        sn.setAttribute(defaultCouponPriceInSn, null);
        sn.setAttribute(shopCartTotalPayableStAmountInSn, null);
        sn.setAttribute(shopCBStateTaxDbAmountInSn, null);
        sn.setAttribute(shopCBShippingDbAmountInSn, null);
        sn.setAttribute(shopFTStateTaxDbAmountInSn, null);
        sn.setAttribute(shopFTShippingDbAmountInSn, null);
        sn.setAttribute(shopCartTotalProductDbAmountInSn, null);
        sn.setAttribute(shopCartTotalProductStAmountInSn, null);
        sn.setAttribute(shoppingCartStateTaxStAmountInSn, null);
        sn.setAttribute(shoppingCartStateTaxDbAmountInSn, null);
        sn.setAttribute(shoppingCartShippingStAmountInSn, null);
        sn.setAttribute(shoppingCartShippingDbAmountInSn, null);
        sn.setAttribute(shopFTProductCartValueListInSn, null);
        sn.setAttribute(shopCBProductCartValueListInSn, null);        
        sn.setAttribute(shopTotalAmountStFormInSn, null);
        sn.setAttribute(shopCBPCartTotalPriceInSn, null);
        sn.setAttribute(shopTotalPriceAmountInSt, null);
        sn.setAttribute(transactionNumberInSn, null);
        sn.setAttribute(accountTypeInSn, null);
        sn.setAttribute(authorizationCodeInSn, null);
        sn.setAttribute(shopFTCartCountInSn, null);
        sn.setAttribute(shopCBCartCountInSn, null);
        sn.setAttribute(shopPaymentOrderNumberInSn, null);
        return shopAllSessionValuesGoingToNull;
    }

    @Override
    @Transactional
    public ModelAndView shopTermsPopupDisplayDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;                
        mav = new ModelAndView(shopTermsPopupDisplayDisplay);           	
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView shopPrivacyPolicyPopupDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;                
        mav = new ModelAndView(shopPrivacyPolicyPopupDisplay);           	
        return mav;
    }
	 
    

	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
