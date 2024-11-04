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
import com.nookandcove.dao.ShopFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.model.AdminRegistryFinishingTouchesProductsInfoSaving;
import com.nookandcove.model.ShopFinishingTouchesProductsInfoSaving;
import com.nookandcove.service.ShopFinishingTouchesService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class ShopFinishingTouchesServiceImpl implements ShopFinishingTouchesService {

	private String shopViewSelectedFinTouchesProducts = "shopViewSelectedFinTouchesProducts";
	private String shopFTSelectedCategory = "shopFTSelectedCategory";
	private String shopFTProductSavingIdsListInSn = "shopFTProductSavingIdsListInSn";
	private String shopFTProductImages1ListInSn = "shopFTProductImages1ListInSn";
	private String shopFTProductNamesListInSn = "shopFTProductNamesListInSn";
	private String shopFTProductStoreNamesListInSn = "shopFTProductStoreNamesListInSn";
	private String shopFTProductPricesListInSn = "shopFTProductPricesListInSn";
	private String shopFTProductImages2ListInSn = "shopFTProductImages2ListInSn";
	private String shopFTProductImages3ListInSn = "shopFTProductImages3ListInSn";
	private String shopFTProductImages4ListInSn = "shopFTProductImages4ListInSn";
	private String shopFTProductPopUpValuesListInSn = "shopFTProductPopUpValuesListInSn";
	private String redirectStatus = "redirect:";
	private String jSonObject = "JSonObj";
	private String shopCartDelCountInSn = "shopCartDelCountInSn";
	private String purchasesStatus = "Purchases";
	
	private String shopFTProductPrice = "shopFTProductPrice";
	private String shopFTProductsSavingId = "shopFTProductsSavingId";
	private String productQuantity = "productQuantity";
	private String shopFTProductName = "shopFTProductName";
	private String shopFTProductImage = "shopFTProductImage";
	private String shopFTProductCartValueListInSn = "shopFTProductCartValueListInSn";
	private String shopCartCountInSn = "shopCartCountInSn";
	private String shopCBCartCountInSn = "shopCBCartCountInSn";
	private String shopFTCartCountInSn = "shopFTCartCountInSn";
	private String shopFTSelectedCategoryInSn = "shopFTSelectedCategoryInSn";
	private String redirectShopSelectedFinishingTouches = "redirectShopSelectedFinishingTouches";
	private String shopFTPCartTotalPriceInSn = "shopFTPCartTotalPriceInSn";
	private String shopFTPCartTotalPriceInDbInSn = "shopFTPCartTotalPriceInDbInSn";
	
	

	@Autowired
    private AdminRegistryFinishingTouchesProductsInfoSavingDAO adminRegistryFinishingTouchesProductsInfoSavingDAO;

	@Autowired
    private ShopFinishingTouchesProductsInfoSavingDAO shopFinishingTouchesProductsInfoSavingDAO;
	
	@Override
    @Transactional
    public ModelAndView shopSelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String regFTCatNameRef = "Curtains";
    	shopFinishingTouchesSelectedProductValuesList(req, sn, regFTCatNameRef);
    	mav = new ModelAndView(shopViewSelectedFinTouchesProducts);    	
    	mav.addObject(shopFTSelectedCategory, regFTCatNameRef);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView shopViewSelectedFinTouchesProductsFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	shopFinishingTouchesSelectedProductValuesList(req, sn, req.getParameter(shopFTSelectedCategory));
    	mav = new ModelAndView(shopViewSelectedFinTouchesProducts);
    	mav.addObject(shopFTSelectedCategory, req.getParameter(shopFTSelectedCategory));
    	return mav;
    }

    public String shopFinishingTouchesSelectedProductValuesList(HttpServletRequest req, HttpSession sn, String shopFTSelectedCategory) {
    	String allShopProductsinfo = null;
    	List shopFTProductSavingIdList = new ArrayList();
    	List shopFTProductImage1List = new ArrayList();
		List shopFTProductNameList = new ArrayList();
		List shopFTProductStoreNameList = new ArrayList();
		List shopFTProductPriceList = new ArrayList();		
		List shopFTProductImage2List = new ArrayList();
		List shopFTProductImage3List = new ArrayList();
		List shopFTProductImage4List = new ArrayList();
		List shopFTProductPopUpValueList = new ArrayList();
		List <AdminRegistryFinishingTouchesProductsInfoSaving> shopFinTouchesProductsList = adminRegistryFinishingTouchesProductsInfoSavingDAO.adminRegFinishingTouchesSelectedProductsListFromDB(shopFTSelectedCategory);
		if (!shopFinTouchesProductsList.isEmpty()) {
    		for (AdminRegistryFinishingTouchesProductsInfoSaving shopFinTouchesProdSavingModel : shopFinTouchesProductsList) {
    			shopFTProductSavingIdList.add(shopFinTouchesProdSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId());    				 			
	 			String prodCombValues =  shopFinTouchesProdSavingModel.getProductSize1() + "_,_" + shopFinTouchesProdSavingModel.getProductPrice1() + "_,_" + shopFinTouchesProdSavingModel.getProductSize2() + "_,_" + shopFinTouchesProdSavingModel.getProductPrice2() + "_,_" + shopFinTouchesProdSavingModel.getProductSize3() + "_,_" + shopFinTouchesProdSavingModel.getProductPrice3() + "_,_" + shopFinTouchesProdSavingModel.getProductSize4() + "_,_" + shopFinTouchesProdSavingModel.getProductPrice4() + "_,_" + shopFinTouchesProdSavingModel.getProductSize5() + "_,_" + shopFinTouchesProdSavingModel.getProductPrice5() + "_,_" + shopFinTouchesProdSavingModel.getProductDescription1();
	 			String totalPopUpValuesList = shopFinTouchesProdSavingModel.getProductName() + "_,_" + shopFinTouchesProdSavingModel.getAdminRegistryFinishingTouchesProductsInfoSavingId() + "_,_" + prodCombValues  + "_,_" + shopFinTouchesProdSavingModel.getStoreName(); 
	 			shopFTProductImage1List.add(shopFinTouchesProdSavingModel.getProductUploadedImage1());
	 			shopFTProductNameList.add(shopFinTouchesProdSavingModel.getProductName());
	 			shopFTProductStoreNameList.add(shopFinTouchesProdSavingModel.getStoreName());
	 			shopFTProductPriceList.add(shopFinTouchesProdSavingModel.getProductPrice1());
	 			shopFTProductPopUpValueList.add(totalPopUpValuesList);
	 			shopFTProductImage2List.add(shopFinTouchesProdSavingModel.getProductUploadedImage2());
	 			shopFTProductImage3List.add(shopFinTouchesProdSavingModel.getProductUploadedImage3());
	 			shopFTProductImage4List.add(shopFinTouchesProdSavingModel.getProductUploadedImage4());
	 		}	 		
	 		sn.setAttribute(shopFTProductSavingIdsListInSn, shopFTProductSavingIdList);
	 		sn.setAttribute(shopFTProductImages1ListInSn, shopFTProductImage1List);
	 		sn.setAttribute(shopFTProductNamesListInSn, shopFTProductNameList);
	 		sn.setAttribute(shopFTProductStoreNamesListInSn, shopFTProductStoreNameList);
	 		sn.setAttribute(shopFTProductPricesListInSn, shopFTProductPriceList);	 		
	 		sn.setAttribute(shopFTProductImages2ListInSn, shopFTProductImage2List);
	 		sn.setAttribute(shopFTProductImages3ListInSn, shopFTProductImage3List);
	 		sn.setAttribute(shopFTProductImages4ListInSn, shopFTProductImage4List);
	 		sn.setAttribute(shopFTProductPopUpValuesListInSn, shopFTProductPopUpValueList);
		} else {
			sn.setAttribute(shopFTProductSavingIdsListInSn, null);
	 		sn.setAttribute(shopFTProductImages1ListInSn, null);
	 		sn.setAttribute(shopFTProductNamesListInSn, null);
	 		sn.setAttribute(shopFTProductStoreNamesListInSn, null);
	 		sn.setAttribute(shopFTProductPricesListInSn, null);	 		
	 		sn.setAttribute(shopFTProductImages2ListInSn, null);
	 		sn.setAttribute(shopFTProductImages3ListInSn, null);
	 		sn.setAttribute(shopFTProductImages4ListInSn, null);
	 		sn.setAttribute(shopFTProductPopUpValuesListInSn, null);
		}
  		return allShopProductsinfo;
    }

    @Override
    @Transactional
    public ModelAndView shopSelectedFTProductsAddToShoppingCart(HttpServletRequest req, HttpSession sn) {    
    	ModelAndView mav;               
    	String shopFinishingTouchessSnValue = null;
    	int totalFTCartCount = 0;
    	String shopsProductPrice = req.getParameter(shopFTProductPrice);
    	shopsProductPrice= shopsProductPrice.replace(",", "");
    	String shopFinishingTouchessCombVal = req.getParameter(shopFTProductsSavingId) + "_,_" + req.getParameter(productQuantity) + "_,_" + shopsProductPrice + "_,_" + req.getParameter(shopFTProductName) + "_,_" + req.getParameter(shopFTProductImage);
    	if(null != sn.getAttribute(shopFTProductCartValueListInSn)) {
    		shopFinishingTouchessSnValue = shopSelectedFTProductsValuesUpdateInCartSn(sn, (String) sn.getAttribute(shopFTProductCartValueListInSn), req.getParameter(shopFTProductsSavingId), req.getParameter(productQuantity), shopsProductPrice, req.getParameter(shopFTProductName), req.getParameter(shopFTProductImage));
          	totalFTCartCount = (int) sn.getAttribute(shopFTCartCountInSn);
    	} else {
          	shopFinishingTouchessSnValue = shopFinishingTouchessCombVal;
          	totalFTCartCount = Integer.parseInt(req.getParameter(productQuantity));          	
          	double totalFTProductPriceDb = Double.parseDouble(shopsProductPrice);          	
          	double totalFTProductPrice = totalFTProductPriceDb * totalFTCartCount;
          	String totalFTProductPriceSt = String.format("%,.2f", totalFTProductPrice);
          	sn.setAttribute(shopFTPCartTotalPriceInSn, totalFTProductPriceSt);
          	sn.setAttribute(shopFTPCartTotalPriceInDbInSn, totalFTProductPrice);
    	}    	
    	sn.setAttribute(shopFTCartCountInSn, totalFTCartCount);
    	sn.setAttribute(shopFTProductCartValueListInSn, shopFinishingTouchessSnValue);
    	sn.setAttribute(shopFTSelectedCategoryInSn, req.getParameter(shopFTSelectedCategory));
    	totalShoppingCartCount(req, sn);
    	mav = new ModelAndView(redirectStatus + redirectShopSelectedFinishingTouches);
    	mav.addObject("finTouchesAddCartReff", "Add To Cart");    	
    	return mav;
    }

    public String shopSelectedFTProductsValuesUpdateInCartSn(HttpSession sn, String shopFTProductCartValues, String shopFTProductsSavingId, String productQuantity, String productPrice, String productName, String productImage) {
    	String shopFinishingTouchessSnValue = null;
      	String prodIdCheckStatus = null;
      	double totalFTProductPriceDB = 0;
      	String[] shopFTProductCartValuesInSt = shopFTProductCartValues.split("__");
      	int totalShopFTCartCount = 0;
      	for(int i=0; i<shopFTProductCartValuesInSt.length; i++) {
      		String[] shopFinishingTouchesProdIdSt = shopFTProductCartValuesInSt[i].split("_,_");
      		if(shopFTProductsSavingId.equals(shopFinishingTouchesProdIdSt[0])) {
      			int shopQuantityInt = Integer.parseInt(productQuantity);
  				String totalProdQuantity = Integer.toString(shopQuantityInt);
  				String totalGuestProdComb = shopFTProductsSavingId + "_,_" + totalProdQuantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage;
  				prodIdCheckStatus = "Done";
  				shopFinishingTouchessSnValue = shopFinishingTouchessSnValue + "__" + totalGuestProdComb;
  				totalShopFTCartCount = totalShopFTCartCount + shopQuantityInt;
  				double totalFTProductPriceDb = Double.parseDouble(productPrice);
  	        	double totalFTProductPrice = totalFTProductPriceDb * shopQuantityInt;
  	        	totalFTProductPriceDB = totalFTProductPriceDB + totalFTProductPrice;
      		} else {
      			shopFinishingTouchessSnValue = shopFinishingTouchessSnValue + "__" + shopFTProductCartValuesInSt[i];
      			int shopSelQuantityCount = Integer.parseInt(shopFinishingTouchesProdIdSt[1]);
      			totalShopFTCartCount = totalShopFTCartCount + shopSelQuantityCount;
      			double totalFTProductPriceDb = Double.parseDouble(shopFinishingTouchesProdIdSt[2]);
  	        	double totalFTProductPrice = totalFTProductPriceDb * shopSelQuantityCount;
  	        	totalFTProductPriceDB = totalFTProductPriceDB + totalFTProductPrice;
      		}
      		shopFinishingTouchessSnValue = shopFinishingTouchessSnValue.replaceFirst("null__", "");    		
      	}
      	if(prodIdCheckStatus == null) {
      		String shopFinishingTouchessInputVal = shopFTProductsSavingId + "_,_" + productQuantity + "_,_" + productPrice + "_,_" + productName + "_,_" + productImage;
      		shopFinishingTouchessSnValue = shopFinishingTouchessSnValue + "__" + shopFinishingTouchessInputVal;
      		int shopSelQuantityCount = Integer.parseInt(productQuantity);
      		totalShopFTCartCount = totalShopFTCartCount + shopSelQuantityCount;
      		double totalFTProductPriceDb = Double.parseDouble(productPrice);
          	double totalFTProductPrice = totalFTProductPriceDb * shopSelQuantityCount;
          	totalFTProductPriceDB = totalFTProductPriceDB + totalFTProductPrice;
      	}
      	String totalFTProductPriceSt = String.format("%,.2f", totalFTProductPriceDB);
      	sn.setAttribute(shopFTPCartTotalPriceInSn, totalFTProductPriceSt);
      	sn.setAttribute(shopFTPCartTotalPriceInDbInSn, totalFTProductPriceDB);
      	sn.setAttribute(shopFTCartCountInSn, totalShopFTCartCount);
      	return shopFinishingTouchessSnValue;
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
    public ModelAndView redirectShopSelectedFinishingTouchesProducts(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	shopFinishingTouchesSelectedProductValuesList(req, sn, (String) sn.getAttribute(shopFTSelectedCategoryInSn));
    	mav = new ModelAndView(shopViewSelectedFinTouchesProducts);
    	mav.addObject(shopFTSelectedCategory, (String) sn.getAttribute(shopFTSelectedCategoryInSn));
    	return mav;
    }

    @Override
    @Transactional
    public JSONArray jSonAddCartShopFTProductsValueUpdateInSn(String shopFTProductsInfoValue, HttpSession sn, HttpServletRequest req) {
    	String[] shopFTProductsInfoValueSt = shopFTProductsInfoValue.split("__");
    	shopFTProductsAddCartJSonValueUpdateInDB(sn, req, shopFTProductsInfoValueSt[0], shopFTProductsInfoValueSt[1], shopFTProductsInfoValueSt[2], shopFTProductsInfoValueSt[3]);
    	int totalShopFTCartCount = (int) sn.getAttribute(shopCartCountInSn);
    	sn.setAttribute(shopCartCountInSn, totalShopFTCartCount);
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalShopFTCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String shopFTProductsAddCartJSonValueUpdateInDB(HttpSession sn, HttpServletRequest req, String shopFTProductSavingsId, String shopFTProductGivenQuantity, String shopFTProductOldQuantity, String shopFTProductsPrice) {
    	String shopFTProductAddCartValue = null;
        int shopFTProductGivenQuantityInt = Integer.parseInt(shopFTProductGivenQuantity);
        int shopFTProductOldQuantityInt = Integer.parseInt(shopFTProductOldQuantity);
        double shopFTProductsPriceDb = Double.parseDouble(shopFTProductsPrice);        
        String shopFTProductCartValueSnValue = (String) sn.getAttribute(shopFTProductCartValueListInSn);
        String[] shopFTProductCartSnValueInSt = shopFTProductCartValueSnValue.split("__");
    	String shopFTProductCartValueSnValuesList = null;
    	for(int i = 0; i < shopFTProductCartSnValueInSt.length; i++) {
    		String[] checkShopFTProductCartSnValueSt = shopFTProductCartSnValueInSt[i].split("_,_");
    		if((shopFTProductSavingsId).equals(checkShopFTProductCartSnValueSt[0])) {
    			String newFTContributedValuesList = checkShopFTProductCartSnValueSt[0] + "_,_" + shopFTProductGivenQuantity + "_,_" + checkShopFTProductCartSnValueSt[2] + "_,_" + checkShopFTProductCartSnValueSt[3] + "_,_" + checkShopFTProductCartSnValueSt[4];
    			shopFTProductCartValueSnValuesList = shopFTProductCartValueSnValuesList + "__" + newFTContributedValuesList;
    		} else {
    			shopFTProductCartValueSnValuesList = shopFTProductCartValueSnValuesList + "__" + shopFTProductCartSnValueInSt[i];
    		}
    	}
    	if(shopFTProductCartSnValueInSt.length > 0) {
    		shopFTProductCartValueSnValuesList = shopFTProductCartValueSnValuesList.replaceFirst("null__", "");
    	}
    	int totalSnShopFTCartCount = (int) sn.getAttribute(shopCartCountInSn);
    	int totalShopFTCartCount = (totalSnShopFTCartCount - shopFTProductOldQuantityInt) + shopFTProductGivenQuantityInt;
    	int shopFTCartCount = (int) sn.getAttribute(shopFTCartCountInSn);
    	int remShopFTCartCount = (shopFTCartCount - shopFTProductOldQuantityInt) + shopFTProductGivenQuantityInt;
    	sn.setAttribute(shopFTCartCountInSn, remShopFTCartCount);
    	sn.setAttribute(shopCartCountInSn, totalShopFTCartCount);    	
    	sn.setAttribute(shopFTProductCartValueListInSn, shopFTProductCartValueSnValuesList);    	
    	double totalShopFTProductsPriceSn = (double) sn.getAttribute(shopFTPCartTotalPriceInDbInSn);
    	double shopFTProductOldAmountDb = shopFTProductsPriceDb * shopFTProductOldQuantityInt;
    	double shopFTProductNewAmountDb = shopFTProductsPriceDb * shopFTProductGivenQuantityInt;    	
    	double totalShopFTProductsPriceDb = (totalShopFTProductsPriceSn - shopFTProductOldAmountDb) + shopFTProductNewAmountDb;
    	sn.setAttribute(shopFTPCartTotalPriceInDbInSn, totalShopFTProductsPriceDb);    	
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", totalShopFTProductsPriceDb);
    	sn.setAttribute(shopFTPCartTotalPriceInSn, allShoppingCartTotalAmountSt);        
    	return shopFTProductAddCartValue;
    }

    @Override
    @Transactional
    public JSONArray jSonShopFTProductsInfoDeleteFromSn(String shopFTProductSavingId, HttpSession sn, HttpServletRequest req) {
    	shopFTProductsAddCartJSonValueDeleteFromDB(sn, req, shopFTProductSavingId);
    	int totalShopFTCartCount = (int) sn.getAttribute(shopCartDelCountInSn);    	
    	JSONArray cashFundJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, totalShopFTCartCount);
        cashFundJson.add(jsonObj);
        return cashFundJson;
    }

    public String shopFTProductsAddCartJSonValueDeleteFromDB(HttpSession sn, HttpServletRequest req, String shopFTProductSavingId) {
    	String shopFTProductAddCartValue = null;               
        String shopFTProductCartValueSnValue = (String) sn.getAttribute(shopFTProductCartValueListInSn);
        String[] shopFTProductCartSnValueInSt = shopFTProductCartValueSnValue.split("__");
    	String shopFTProductCartValueSnValuesList = null;
    	int snShopQuantity = 0;
    	double shopFTProductSnPriceDb = 0;
    	for(int i = 0; i < shopFTProductCartSnValueInSt.length; i++) {
    		String[] checkShopFTProductCartSnValueSt = shopFTProductCartSnValueInSt[i].split("_,_");
    		if((shopFTProductSavingId).equals(checkShopFTProductCartSnValueSt[0])) {
    			snShopQuantity = Integer.parseInt(checkShopFTProductCartSnValueSt[1]);
    			double ftShopProductSnPriceDb = Double.parseDouble(checkShopFTProductCartSnValueSt[2]);
    			shopFTProductSnPriceDb = ftShopProductSnPriceDb * snShopQuantity;
    		} else {
    			shopFTProductCartValueSnValuesList = shopFTProductCartValueSnValuesList + "__" + shopFTProductCartSnValueInSt[i];
    		}
    	}
    	if(null != shopFTProductCartValueSnValuesList) {
    		shopFTProductCartValueSnValuesList = shopFTProductCartValueSnValuesList.replaceFirst("null__", "");
    	}    	
    	shopFTProductsCartCount(sn, req, snShopQuantity);
    	sn.setAttribute(shopFTProductCartValueListInSn, shopFTProductCartValueSnValuesList);
    	double totalShopFTProductsPriceSn = (double) sn.getAttribute(shopFTPCartTotalPriceInDbInSn);
    	double totalShopFTProductsPriceDb = totalShopFTProductsPriceSn - shopFTProductSnPriceDb;
    	sn.setAttribute(shopFTPCartTotalPriceInDbInSn, totalShopFTProductsPriceDb);    	
    	String allShoppingCartTotalAmountSt = String.format("%,.2f", totalShopFTProductsPriceDb);
    	sn.setAttribute(shopFTPCartTotalPriceInSn, allShoppingCartTotalAmountSt);
    	return shopFTProductAddCartValue;
    }
    
    public int shopFTProductsCartCount(HttpSession sn, HttpServletRequest req, int snShopQuantity) {
    	int shopFTProductCartCount = 0;
    	int totalSnShopFTCartCount = (int) sn.getAttribute(shopCartCountInSn);
    	int shopFTCartCount = (int) sn.getAttribute(shopFTCartCountInSn);
    	int totalShopFTCartCount = totalSnShopFTCartCount - snShopQuantity;
    	int remShopFTCartCount = shopFTCartCount - snShopQuantity;
    	sn.setAttribute(shopFTCartCountInSn, remShopFTCartCount);
    	sn.setAttribute(shopCartDelCountInSn, totalShopFTCartCount);    	
    	if(totalShopFTCartCount > 0) {
    		sn.setAttribute(shopCartCountInSn, totalShopFTCartCount);
    		shopFTProductCartCount = totalShopFTCartCount;
    	} else {
    		sn.setAttribute(shopCartCountInSn, null);
    	}
    	return shopFTProductCartCount;
    }

//	Finishing Touches Info Add to That Tables
    @Override
    @Transactional
    public String shopFinishingTouchesInfoSavingInDB(HttpServletRequest req, HttpSession sn, long shopCartPaymentInfoSavingId, String returnType, Timestamp currentDate, long transactionNumber) {
        String shopFinishingTouchesReffVal = null;        
        String shopFTProductCartValueList = (String) sn.getAttribute(shopFTProductCartValueListInSn);
        if(null != shopFTProductCartValueList) {
	        String[] shopFTProductCartValuesInSt = shopFTProductCartValueList.split("__");
	        for(int i=0; i<shopFTProductCartValuesInSt.length; i++) {
	      		String[] shopFinishingTouchesProdIdSt = shopFTProductCartValuesInSt[i].split("_,_");
	      		long shopFinishingTouchesProdId = Long.parseLong(shopFinishingTouchesProdIdSt[0]);
	      		int quantity = Integer.parseInt(shopFinishingTouchesProdIdSt[1]);
	      		AdminRegistryFinishingTouchesProductsInfoSaving adminRegFTFurnitureSpecsModel =  adminRegistryFinishingTouchesProductsInfoSavingDAO.adminShopRegFinishingTouchesProductsDataTakeFromDB(shopFinishingTouchesProdId);
	      		ShopFinishingTouchesProductsInfoSaving shopFTProductsSavingModel = new ShopFinishingTouchesProductsInfoSaving();
	      		shopFTProductsSavingModel.setAdminRegistryFinishingTouchesSavingId(shopFinishingTouchesProdId);
	      		shopFTProductsSavingModel.setProductName(adminRegFTFurnitureSpecsModel.getProductName());
	      		shopFTProductsSavingModel.setProductUploadedImage(adminRegFTFurnitureSpecsModel.getProductUploadedImage1());
	      		shopFTProductsSavingModel.setProductPrice(shopFinishingTouchesProdIdSt[2]);
	      		shopFTProductsSavingModel.setProductDescription(adminRegFTFurnitureSpecsModel.getProductDescription1());
	      		shopFTProductsSavingModel.setProductSize(adminRegFTFurnitureSpecsModel.getProductSize1());
	      		shopFTProductsSavingModel.setStoreName(adminRegFTFurnitureSpecsModel.getStoreName());
	      		shopFTProductsSavingModel.setStoreUrl(adminRegFTFurnitureSpecsModel.getStoreUrl());
	      		shopFTProductsSavingModel.setQuantity(quantity);
	      		shopFTProductsSavingModel.setShopUserPaymentInfoSavingId(shopCartPaymentInfoSavingId);
	      		shopFTProductsSavingModel.setCheckoutPaymentStatus(returnType);
	      		shopFTProductsSavingModel.setShopProductStatus(purchasesStatus);
	      		int orderNumber = shopFTOrderNumberGenerate(req, sn);
	      		shopFTProductsSavingModel.setOrderNumber(orderNumber);
	      		shopFTProductsSavingModel.setTransactionNumber(transactionNumber);
	      		shopFTProductsSavingModel.setRefferanceDate(currentDate);
	      		shopFTProductsSavingModel.setCreatedDate(currentDate);      		
	      		shopFinishingTouchesProductsInfoSavingDAO.save(shopFTProductsSavingModel);
	        }
        }
        return shopFinishingTouchesReffVal;
    }
    
    public Integer shopFTOrderNumberGenerate(HttpServletRequest req, HttpSession sn) {
	    String alphaNumerics = "1234567890";
	    int orderNumber = 0;
	    String t = "";
	    for (int i = 0; i < 8; i++) {
	        t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }
	    orderNumber = Integer.parseInt(t);
	    return orderNumber;
    }


    
    
	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
