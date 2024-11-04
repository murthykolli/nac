package com.nookandcove.serviceimpl;

import java.sql.Timestamp;
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

import com.nookandcove.dao.ShopConceptBoardsProductsInfoSavingDAO;
import com.nookandcove.dao.ShopUserPaymentInfoSavingDAO;
import com.nookandcove.model.ShopConceptBoardsProductsInfoSaving;
import com.nookandcove.model.ShopUserPaymentInfoSaving;
import com.nookandcove.service.AdminShopDataDisplayService;

@SuppressWarnings({"unchecked"})
@Service
public class AdminShopDataDisplayServiceImpl implements AdminShopDataDisplayService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminShopDataDisplayServiceImpl.class);
	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
	private String shopCBProductInfoSavingList = "shopCBProductInfoSavingList";
	private String shopPurchasesCount = "shopPurchasesCount";
	private String shopOrderedCount = "shopOrderedCount";
	private String shopTrackingCount = "shopTrackingCount";
	private String shopDeliveredCount = "shopDeliveredCount";
	private String shopBackOrderedCount = "shopBackOrderedCount";
	private String shopOutOfStockCount = "shopOutOfStockCount";
	private String shopDataVisibleStatus = "shopDataVisibleStatus";
	private String adminShopTrackingLinkURL = "adminShopTrackingLinkURL";
	private String shopVisibleStatus = "Data Visible";
	private String shopCBProductsManagementId = "shopCBProductsManagementId";
	private String adminShopBackOrderedDate = "adminShopBackOrderedDate";
	
	private String adminShopPurchasesRed = "adminShopPurchasesRed";
	private String adminShopPlaceOrderRed = "adminShopPlaceOrderRed";
	private String adminShopOrderedRed = "adminShopOrderedRed";
	private String adminShopTrackingLinkUpdate = "adminShopTrackingLinkUpdate";
	private String adminShopTrackingRed = "adminShopTrackingRed";
	private String adminShopDeliveredRed = "adminShopDeliveredRed";
	private String adminShopBackOrderedDateDisplay = "adminShopBackOrderedDateDisplay";
	private String adminShopBackOrderedRed = "adminShopBackOrderedRed";
	private String adminShopBackOrderedViewDetails = "adminShopBackOrderedViewDetails";
	private String adminShopBackOrderedModifyDate = "adminShopBackOrderedModifyDate";
	private String adminShopOutOfStockRed = "adminShopOutOfStockRed";
	private String adminShopOutOfStockViewDisplay = "adminShopOutOfStockViewDisplay";
		
	private String purchasesStatusRef = "Purchases";
	private String orderedStatusRef = "Ordered";
	private String trackingStatusRef = "Tracking";
	private String deliveredStatusRef = "Delivered";
	private String backOrderedStatusRef = "Back Ordered";
	private String outOfStockStatusRef = "Out of Stock";
	
	private String shopProductName = "shopProductName";
	private String shopStoreName = "shopStoreName";
	private String shopProductSize = "shopProductSize";
	private String shopQuantity = "shopQuantity";
	private String shopProductPrice = "shopProductPrice";
	private String shopStoreUrl = "shopStoreUrl";
	private String shopBackOrderedText = "shopBackOrderedText";
	private String shopShipFullName = "shopShipFullName";
	private String shopShippingAddress = "shopShippingAddress";
	private String shopUserPhoneNumber = "shopUserPhoneNumber";
	private String shopUserEmail = "shopUserEmail";
	private String shopProductImage = "shopProductImage";
	
	

	@Autowired
    private ShopUserPaymentInfoSavingDAO shopUserPaymentInfoSavingDAO;

	@Autowired
    private ShopConceptBoardsProductsInfoSavingDAO shopConceptBoardsProductsInfoSavingDAO;
	

    @Override
    @Transactional
    public ModelAndView adminShopPurchasesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(purchasesStatusRef);
    	if (!shopConceptBoardsProductsList.isEmpty()) {        	
            List<ShopConceptBoardsProductsInfoSaving> ShopCBProductsInfoSavingList = new ArrayList<ShopConceptBoardsProductsInfoSaving>();
            for (ShopConceptBoardsProductsInfoSaving ShopCBProductsInfoLoop : shopConceptBoardsProductsList) {
            	ShopConceptBoardsProductsInfoSaving shopCBProductsInfoSavingModel = new ShopConceptBoardsProductsInfoSaving();
            	shopCBProductsInfoSavingModel.setShopConceptBoardsProductsInfoSavingId(ShopCBProductsInfoLoop.getShopConceptBoardsProductsInfoSavingId());
            	shopCBProductsInfoSavingModel.setCreatedDate(ShopCBProductsInfoLoop.getRefferanceDate());
            	String shopUserFullName = shopUserFullNameTakeFromDB(req, sn, ShopCBProductsInfoLoop.getShopUserPaymentInfoSavingId());            	
            	shopCBProductsInfoSavingModel.setStoreName(shopUserFullName);
            	shopCBProductsInfoSavingModel.setProductName(ShopCBProductsInfoLoop.getProductName());
            	String priceDsp = "$"+ShopCBProductsInfoLoop.getProductPrice();
            	shopCBProductsInfoSavingModel.setProductPrice(priceDsp);
            	shopCBProductsInfoSavingModel.setTransactionNumber(ShopCBProductsInfoLoop.getTransactionNumber());            	
            	ShopCBProductsInfoSavingList.add(shopCBProductsInfoSavingModel);
            }            
            mav = new ModelAndView(adminShopPurchasesRed);
            mav.addObject(shopCBProductInfoSavingList, ShopCBProductsInfoSavingList);            
            mav.addObject(shopDataVisibleStatus, shopVisibleStatus);
        } else{
        	mav = new ModelAndView(adminShopPurchasesRed);            
        }        
    	int spOrderedCount = adminShopOrderedCount(req, sn);
		int spTrackingCount = adminShopTrackingCount(req, sn);
		int spDeliveredCount = adminShopDeliveredCount(req, sn);
		int spBackOrderedCount = adminShopBackOrderedCount(req, sn);
		int spOutOfStockCount = adminShopOutOfStockCount(req, sn);
		mav.addObject(shopPurchasesCount, shopConceptBoardsProductsList.size());
    	mav.addObject(shopOrderedCount, spOrderedCount);
		mav.addObject(shopTrackingCount, spTrackingCount);
		mav.addObject(shopDeliveredCount, spDeliveredCount);
		mav.addObject(shopBackOrderedCount, spBackOrderedCount);
		mav.addObject(shopOutOfStockCount, spOutOfStockCount);		
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    public String shopUserFullNameTakeFromDB(HttpServletRequest req, HttpSession sn, long shopUserPaymentInfoSavingId) {
    	String shopUserFullName = null;
    	List <ShopUserPaymentInfoSaving> shopUserPaymentInfoList = shopUserPaymentInfoSavingDAO.shopUserFullNameCheckInDataBase(shopUserPaymentInfoSavingId);
    	if (!shopUserPaymentInfoList.isEmpty()) { 
    		ShopUserPaymentInfoSaving shopUserPaymentInfoSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopUserPaymentInfoSavingId);
    		shopUserFullName = shopUserPaymentInfoSavingModel.getShipFullName();
    	}
    	return shopUserFullName;
    }

    public int adminShopPurchasesCount(HttpServletRequest req, HttpSession sn) {
    	int shopPurchasesCount = 0;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(purchasesStatusRef);
    	shopPurchasesCount = shopConceptBoardsProductsList.size();
    	return shopPurchasesCount;
    }

    public int adminShopOrderedCount(HttpServletRequest req, HttpSession sn) {
    	int shopOrderedCount = 0;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(orderedStatusRef);
    	shopOrderedCount = shopConceptBoardsProductsList.size();
    	return shopOrderedCount;
    }

    public int adminShopTrackingCount(HttpServletRequest req, HttpSession sn) {
    	int shopTrackingCount = 0;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(trackingStatusRef);
    	shopTrackingCount = shopConceptBoardsProductsList.size();
    	return shopTrackingCount;
    }

    public int adminShopDeliveredCount(HttpServletRequest req, HttpSession sn) {
    	int shopDeliveredCount = 0;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(deliveredStatusRef);
    	shopDeliveredCount = shopConceptBoardsProductsList.size();
    	return shopDeliveredCount;
    }

    public int adminShopBackOrderedCount(HttpServletRequest req, HttpSession sn) {
    	int shopBackOrderedCount = 0;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(backOrderedStatusRef);
    	shopBackOrderedCount = shopConceptBoardsProductsList.size();
    	return shopBackOrderedCount;
    }

    public int adminShopOutOfStockCount(HttpServletRequest req, HttpSession sn) {
    	int shopOutOfStockCount = 0;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(outOfStockStatusRef);
    	shopOutOfStockCount = shopConceptBoardsProductsList.size();
    	return shopOutOfStockCount;
    }

    @Override
    @Transactional
    public ModelAndView adminShopPlaceOrderDataRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	ShopUserPaymentInfoSaving shopPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());        
    	String productName = shopCBProductsSavingModel.getProductName();
		String storeName = shopCBProductsSavingModel.getStoreName();
		String productSize = shopCBProductsSavingModel.getProductSize();
		int quantity = shopCBProductsSavingModel.getQuantity();
		String productPrice = "$" + shopCBProductsSavingModel.getProductPrice();
		String storeUrl = shopCBProductsSavingModel.getStoreUrl();		
		String shipFullName = shopPaymentSavingModel.getShipFullName();
		String shipAddress = null;
		if(null != shopPaymentSavingModel.getShipAddress2()) {
			shipAddress = shopPaymentSavingModel.getShipAddress1() + " " + shopPaymentSavingModel.getShipAddress2();
		} else {
			shipAddress = shopPaymentSavingModel.getShipAddress1();
		}
		String totalShippingAddress = shipAddress + ", " + shopPaymentSavingModel.getShipCity() + ", " + shopPaymentSavingModel.getShipState() + ", " + shopPaymentSavingModel.getShipZip() + ".";
		String phoneNumber = shopPaymentSavingModel.getShopUserPhoneNumber();
		String email = shopPaymentSavingModel.getShopUserEmail();
		String productImage = null;
		if(null != shopCBProductsSavingModel.getProductUploadedImage()) {
	    	byte[] shopProdImageFromDB = shopCBProductsSavingModel.getProductUploadedImage();
	    	productImage = javax.xml.bind.DatatypeConverter.printBase64Binary(shopProdImageFromDB);
    	}
    	mav = new ModelAndView(adminShopPlaceOrderRed);    	
    	mav.addObject(shopProductName, productName);
    	mav.addObject(shopStoreName, storeName);
    	mav.addObject(shopProductSize, productSize);
    	mav.addObject(shopQuantity, quantity);
    	mav.addObject(shopProductPrice, productPrice);
    	mav.addObject(shopStoreUrl, storeUrl);
    	mav.addObject(shopShipFullName, shipFullName);
    	mav.addObject(shopShippingAddress, totalShippingAddress);
    	mav.addObject(shopUserPhoneNumber, phoneNumber);
    	mav.addObject(shopUserEmail, email);
    	mav.addObject(shopProductImage, productImage);
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopOrderedStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setShopProductStatus(orderedStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);    	
    	mav = adminShopOrderedRedirection(req, sn);    	
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopOrderedRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(orderedStatusRef);
    	if (!shopConceptBoardsProductsList.isEmpty()) {        	
            List<ShopConceptBoardsProductsInfoSaving> ShopCBProductsInfoSavingList = new ArrayList<ShopConceptBoardsProductsInfoSaving>();
            for (ShopConceptBoardsProductsInfoSaving ShopCBProductsInfoLoop : shopConceptBoardsProductsList) {
            	ShopConceptBoardsProductsInfoSaving shopCBProductsInfoSavingModel = new ShopConceptBoardsProductsInfoSaving();
            	shopCBProductsInfoSavingModel.setShopConceptBoardsProductsInfoSavingId(ShopCBProductsInfoLoop.getShopConceptBoardsProductsInfoSavingId());
            	shopCBProductsInfoSavingModel.setCreatedDate(ShopCBProductsInfoLoop.getRefferanceDate());
            	String shopUserFullName = shopUserFullNameTakeFromDB(req, sn, ShopCBProductsInfoLoop.getShopUserPaymentInfoSavingId());            	
            	shopCBProductsInfoSavingModel.setStoreName(shopUserFullName);
            	shopCBProductsInfoSavingModel.setProductName(ShopCBProductsInfoLoop.getProductName());
            	String priceDsp = "$"+ShopCBProductsInfoLoop.getProductPrice();
            	shopCBProductsInfoSavingModel.setProductPrice(priceDsp);
            	shopCBProductsInfoSavingModel.setTransactionNumber(ShopCBProductsInfoLoop.getTransactionNumber());            	
            	ShopCBProductsInfoSavingList.add(shopCBProductsInfoSavingModel);
            }            
            mav = new ModelAndView(adminShopOrderedRed);
            mav.addObject(shopCBProductInfoSavingList, ShopCBProductsInfoSavingList);            
            mav.addObject(shopDataVisibleStatus, shopVisibleStatus);
        } else{
        	mav = new ModelAndView(adminShopOrderedRed);            
        }        
    	int spPurchasesCount = adminShopPurchasesCount(req, sn);
		int spTrackingCount = adminShopTrackingCount(req, sn);
		int spDeliveredCount = adminShopDeliveredCount(req, sn);
		int spBackOrderedCount = adminShopBackOrderedCount(req, sn);
		int spOutOfStockCount = adminShopOutOfStockCount(req, sn);
		mav.addObject(shopOrderedCount, shopConceptBoardsProductsList.size());
    	mav.addObject(shopPurchasesCount, spPurchasesCount);
		mav.addObject(shopTrackingCount, spTrackingCount);
		mav.addObject(shopDeliveredCount, spDeliveredCount);
		mav.addObject(shopBackOrderedCount, spBackOrderedCount);
		mav.addObject(shopOutOfStockCount, spOutOfStockCount);		
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopTrackingLinkRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView(adminShopTrackingLinkUpdate);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String admShopTrackingLinkURL = req.getParameter(adminShopTrackingLinkURL);
    	String shopTrackingLinkURL = admShopTrackingLinkURL.replaceAll("[\n\r]", " ");
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setTrackingLink(shopTrackingLinkURL);
    	shopCBProductsSavingModel.setShopProductStatus(trackingStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
    	ShopUserPaymentInfoSaving shopUserPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());
    	adminShopTrackingLinkSendToTheUser(req, sn, shopUserPaymentSavingModel.getShopUserEmail(), shopUserPaymentSavingModel.getShipFullName(), shopCBProductsSavingModel.getTransactionNumber(), shopCBProductsSavingModel.getProductName(), shopCBProductsSavingModel.getProductSize(), shopCBProductsSavingModel.getQuantity(), shopCBProductsSavingModel.getProductPrice(), shopCBProductsSavingModel.getTrackingLink());
    	mav = adminShopTrackingRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

	public String adminShopTrackingLinkSendToTheUser(HttpServletRequest req, HttpSession sn, String shopUserEmail, String userFullName, long orderNumber, String productName, String productSize, Integer quantity, String productPrice, String trackingLink) {
	  	String shopCartPaymentReff = null;
	  	String[] emailList = {shopUserEmail};
        String fCapName = userFullName.substring(0, 1).toUpperCase() + userFullName.substring(1);
	  	String subject = "Here's Your Tracking Link";            
	  	String type = "text/html";           
	  	EmailSending userEmail = new EmailSending();
	  	String fromAdd = "info@nookandcove.com";              
	  	String body = "<body>"    				
                + "<div style='margin-left: 30px; margin-top: 10px; width: 600px; height: auto; letter-spacing: 0px; color: black; text-align: left;'>"
                + "<p style='margin-top: 0px; font: bold 1.5em/1.25em sans-serif;'>Hip Hip Hooray!</p>"
                + "<p style='font: 1.05em/1.25em sans-serif;'>Hi " + fCapName + ", </p> "
                + "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Your purchase is on its way!</p>"                
				+ "<p style='margin-top: 25px; font: 1.05em/1.5em sans-serif;'>Here is your <font  style='font: bold 1.05em/1em sans-serif;'>TRACKING LINK: </font><font style='font: 1.1em/1.25em sans-serif;'><a href=" + trackingLink + "> click here </a></font></p>"                
                + "<p style='margin-top: 40px; font: bold 1.05em/1em sans-serif;'>Order Number: " + orderNumber + "</p>"                
                + "<div style='margin-top: 0px; border-top: 1px solid black; width: 300px;'></div>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productName + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'> " + productSize + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'>Quantity: " + quantity + "</p>"
	        	+ "<p style='font: 1.05em/1em sans-serif;'>$ " + productPrice + "</p>"	        		
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
	  		LOGGER.error("Admin shop tracking link mail failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

    @Override
    @Transactional
    public ModelAndView adminShopTrackingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(trackingStatusRef);
    	if (!shopConceptBoardsProductsList.isEmpty()) {        	
            List<ShopConceptBoardsProductsInfoSaving> ShopCBProductsInfoSavingList = new ArrayList<ShopConceptBoardsProductsInfoSaving>();
            for (ShopConceptBoardsProductsInfoSaving ShopCBProductsInfoLoop : shopConceptBoardsProductsList) {
            	ShopConceptBoardsProductsInfoSaving shopCBProductsInfoSavingModel = new ShopConceptBoardsProductsInfoSaving();
            	shopCBProductsInfoSavingModel.setShopConceptBoardsProductsInfoSavingId(ShopCBProductsInfoLoop.getShopConceptBoardsProductsInfoSavingId());
            	shopCBProductsInfoSavingModel.setCreatedDate(ShopCBProductsInfoLoop.getRefferanceDate());
            	String shopUserFullName = shopUserFullNameTakeFromDB(req, sn, ShopCBProductsInfoLoop.getShopUserPaymentInfoSavingId());            	
            	shopCBProductsInfoSavingModel.setStoreName(shopUserFullName);
            	shopCBProductsInfoSavingModel.setProductName(ShopCBProductsInfoLoop.getProductName());
            	String priceDsp = "$"+ShopCBProductsInfoLoop.getProductPrice();
            	shopCBProductsInfoSavingModel.setProductPrice(priceDsp);
            	shopCBProductsInfoSavingModel.setTransactionNumber(ShopCBProductsInfoLoop.getTransactionNumber());
            	String trackLinkUrl = "<a  target='_blank' class='track_link_cl' href=" + ShopCBProductsInfoLoop.getTrackingLink() + "> Track</a>";
            	shopCBProductsInfoSavingModel.setTrackingLink(trackLinkUrl);
            	ShopCBProductsInfoSavingList.add(shopCBProductsInfoSavingModel);
            }            
            mav = new ModelAndView(adminShopTrackingRed);
            mav.addObject(shopCBProductInfoSavingList, ShopCBProductsInfoSavingList);            
            mav.addObject(shopDataVisibleStatus, shopVisibleStatus);
        } else{
        	mav = new ModelAndView(adminShopTrackingRed);            
        }        
    	int spPurchasesCount = adminShopPurchasesCount(req, sn);
		int spOrderedCount = adminShopOrderedCount(req, sn);
		int spDeliveredCount = adminShopDeliveredCount(req, sn);
		int spBackOrderedCount = adminShopBackOrderedCount(req, sn);
		int spOutOfStockCount = adminShopOutOfStockCount(req, sn);
		mav.addObject(shopTrackingCount, shopConceptBoardsProductsList.size());
    	mav.addObject(shopPurchasesCount, spPurchasesCount);
		mav.addObject(shopOrderedCount, spOrderedCount);
		mav.addObject(shopDeliveredCount, spDeliveredCount);
		mav.addObject(shopBackOrderedCount, spBackOrderedCount);
		mav.addObject(shopOutOfStockCount, spOutOfStockCount);		
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopDeliveredDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setShopProductStatus(deliveredStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
    	mav = adminShopDeliveredRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopDeliveredRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(deliveredStatusRef);
    	int count = 0;
    	if (!shopConceptBoardsProductsList.isEmpty()) {        	
            List<ShopConceptBoardsProductsInfoSaving> ShopCBProductsInfoSavingList = new ArrayList<ShopConceptBoardsProductsInfoSaving>();
            for (ShopConceptBoardsProductsInfoSaving ShopCBProductsInfoLoop : shopConceptBoardsProductsList) {
            	count = count + 1;
            	ShopConceptBoardsProductsInfoSaving shopCBProductsInfoSavingModel = new ShopConceptBoardsProductsInfoSaving();
            	shopCBProductsInfoSavingModel.setQuantity(count);
            	shopCBProductsInfoSavingModel.setShopConceptBoardsProductsInfoSavingId(ShopCBProductsInfoLoop.getShopConceptBoardsProductsInfoSavingId());
            	shopCBProductsInfoSavingModel.setCreatedDate(ShopCBProductsInfoLoop.getRefferanceDate());
            	String shopUserFullName = shopUserFullNameTakeFromDB(req, sn, ShopCBProductsInfoLoop.getShopUserPaymentInfoSavingId());            	
            	shopCBProductsInfoSavingModel.setStoreName(shopUserFullName);
            	shopCBProductsInfoSavingModel.setProductName(ShopCBProductsInfoLoop.getProductName());
            	String priceDsp = "$"+ShopCBProductsInfoLoop.getProductPrice();
            	shopCBProductsInfoSavingModel.setProductPrice(priceDsp);
            	shopCBProductsInfoSavingModel.setTransactionNumber(ShopCBProductsInfoLoop.getTransactionNumber());
            	ShopCBProductsInfoSavingList.add(shopCBProductsInfoSavingModel);
            }            
            mav = new ModelAndView(adminShopDeliveredRed);
            mav.addObject(shopCBProductInfoSavingList, ShopCBProductsInfoSavingList);            
            mav.addObject(shopDataVisibleStatus, shopVisibleStatus);
        } else{
        	mav = new ModelAndView(adminShopDeliveredRed);            
        }        
    	int spPurchasesCount = adminShopPurchasesCount(req, sn);
		int spOrderedCount = adminShopOrderedCount(req, sn);
		int spTrackingCount = adminShopTrackingCount(req, sn);
		int spBackOrderedCount = adminShopBackOrderedCount(req, sn);
		int spOutOfStockCount = adminShopOutOfStockCount(req, sn);
		mav.addObject(shopDeliveredCount, shopConceptBoardsProductsList.size());
    	mav.addObject(shopPurchasesCount, spPurchasesCount);
		mav.addObject(shopOrderedCount, spOrderedCount);
		mav.addObject(shopTrackingCount, spTrackingCount);
		mav.addObject(shopBackOrderedCount, spBackOrderedCount);
		mav.addObject(shopOutOfStockCount, spOutOfStockCount);		
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopBackOrderedDateDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	mav = new ModelAndView(adminShopBackOrderedDateDisplay);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setBackOrderedDate(req.getParameter(adminShopBackOrderedDate));
    	shopCBProductsSavingModel.setShopProductStatus(backOrderedStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
    	ShopUserPaymentInfoSaving shopUserPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());
    	adminShopBackOrderedDateSendToTheUser(req, sn, shopUserPaymentSavingModel.getShopUserEmail(), shopUserPaymentSavingModel.getShipFullName(), shopCBProductsSavingModel.getTransactionNumber(), shopCBProductsSavingModel.getProductName(), shopCBProductsSavingModel.getBackOrderedDate());
    	mav = adminShopBackOrderedRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;    	
    }

	public String adminShopBackOrderedDateSendToTheUser(HttpServletRequest req, HttpSession sn, String shopUserEmail, String userFullName, long orderNumber, String productName, String backOrderedDate) {
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
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We have been notified by our vendor that the <b>" + productName + "</b> from Order Number: <b>" + orderNumber + "</b> is currently back-ordered till <b>" + backOrderedDate + "</b>.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We apologize for any inconvenience this delay has caused. If you wish to keep your order as is, we will let you know as soon as it becomes available and provide you with the tracking info once it ships. If you wish to cancel your order, please reply to this email letting us know of your request for cancelation.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>Please note that for any back-ordered or out-of-stock products, our designers are always on the hunt for great replacements and are constantly updating our design boards! You can always visit us at <a href='https://nookandcove.com'>Nook+Cove</a> for design updates and product replacements!</p>"
                + "<p style='margin-top: 30px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>We appreciate and thank you for your patience on this matter.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin shop back ordered date mail failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}

    @Override
    @Transactional
    public ModelAndView adminShopBackOrderedRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(backOrderedStatusRef);
    	if (!shopConceptBoardsProductsList.isEmpty()) {        	
            List<ShopConceptBoardsProductsInfoSaving> ShopCBProductsInfoSavingList = new ArrayList<ShopConceptBoardsProductsInfoSaving>();
            for (ShopConceptBoardsProductsInfoSaving ShopCBProductsInfoLoop : shopConceptBoardsProductsList) {
            	ShopConceptBoardsProductsInfoSaving shopCBProductsInfoSavingModel = new ShopConceptBoardsProductsInfoSaving();
            	shopCBProductsInfoSavingModel.setShopConceptBoardsProductsInfoSavingId(ShopCBProductsInfoLoop.getShopConceptBoardsProductsInfoSavingId());
            	shopCBProductsInfoSavingModel.setCreatedDate(ShopCBProductsInfoLoop.getRefferanceDate());
            	String shopUserFullName = shopUserFullNameTakeFromDB(req, sn, ShopCBProductsInfoLoop.getShopUserPaymentInfoSavingId());            	
            	shopCBProductsInfoSavingModel.setStoreName(shopUserFullName);
            	shopCBProductsInfoSavingModel.setProductName(ShopCBProductsInfoLoop.getProductName());
            	String priceDsp = "$"+ShopCBProductsInfoLoop.getProductPrice();
            	shopCBProductsInfoSavingModel.setProductPrice(priceDsp);
            	shopCBProductsInfoSavingModel.setTransactionNumber(ShopCBProductsInfoLoop.getTransactionNumber());
            	ShopCBProductsInfoSavingList.add(shopCBProductsInfoSavingModel);
            }            
            mav = new ModelAndView(adminShopBackOrderedRed);
            mav.addObject(shopCBProductInfoSavingList, ShopCBProductsInfoSavingList);            
            mav.addObject(shopDataVisibleStatus, shopVisibleStatus);
        } else{
        	mav = new ModelAndView(adminShopBackOrderedRed);            
        }        
    	int spPurchasesCount = adminShopPurchasesCount(req, sn);
		int spOrderedCount = adminShopOrderedCount(req, sn);
		int spTrackingCount = adminShopTrackingCount(req, sn);
		int spDeliveredCount = adminShopDeliveredCount(req, sn);
		int spOutOfStockCount = adminShopOutOfStockCount(req, sn);
		mav.addObject(shopBackOrderedCount, shopConceptBoardsProductsList.size());
    	mav.addObject(shopPurchasesCount, spPurchasesCount);
		mav.addObject(shopOrderedCount, spOrderedCount);
		mav.addObject(shopTrackingCount, spTrackingCount);
		mav.addObject(shopDeliveredCount, spDeliveredCount);
		mav.addObject(shopOutOfStockCount, spOutOfStockCount);		
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView dminShopBackOrderedViewDetailsDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	String productName = shopCBProductsSavingModel.getProductName();
		String storeName = shopCBProductsSavingModel.getStoreName();
		String productSize = shopCBProductsSavingModel.getProductSize();
		int quantity = shopCBProductsSavingModel.getQuantity();
		String productPrice = "$" + shopCBProductsSavingModel.getProductPrice();
		String storeUrl = shopCBProductsSavingModel.getStoreUrl();
		String backOrderedText = shopCBProductsSavingModel.getBackOrderedText();		
    	mav = new ModelAndView(adminShopBackOrderedViewDetails);    	
    	mav.addObject(shopProductName, productName);
    	mav.addObject(shopStoreName, storeName);
    	mav.addObject(shopProductSize, productSize);
    	mav.addObject(shopQuantity, quantity);
    	mav.addObject(shopProductPrice, productPrice);
    	mav.addObject(shopStoreUrl, storeUrl);
    	mav.addObject(shopBackOrderedText, backOrderedText);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopBackOrderedTextUpdateDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	String admnBackOrderedText = req.getParameter(shopBackOrderedText);
    	String admnBackOrderedTextSt = admnBackOrderedText.replaceAll("[\n\r]", " ");
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);    		
    	shopCBProductsSavingModel.setBackOrderedText(admnBackOrderedTextSt);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);   	
    	mav = dminShopBackOrderedViewDetailsDisplay(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopBackOrderedModifyDateDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String backOrderDate = null;
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	backOrderDate = shopCBProductsSavingModel.getBackOrderedDate();    	
    	mav = new ModelAndView(adminShopBackOrderedModifyDate);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(adminShopBackOrderedDate, backOrderDate);
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopBackOrderedDateModificationInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setBackOrderedDate(req.getParameter(adminShopBackOrderedDate));
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
    	ShopUserPaymentInfoSaving shopUserPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());
    	adminShopBackOrderedDateSendToTheUser(req, sn, shopUserPaymentSavingModel.getShopUserEmail(), shopUserPaymentSavingModel.getShipFullName(), shopCBProductsSavingModel.getTransactionNumber(), shopCBProductsSavingModel.getProductName(), shopCBProductsSavingModel.getBackOrderedDate());
    	mav = adminShopBackOrderedRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;    	
    }

    @Override
    @Transactional
    public ModelAndView adminShopBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setBackOrderedDate(null);
    	shopCBProductsSavingModel.setShopProductStatus(purchasesStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
    	mav = adminShopBackOrderedRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopOutOfStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setShopProductStatus(outOfStockStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
		shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
		ShopUserPaymentInfoSaving shopUserPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());
    	adminShopOutOfStockSendToTheUser(req, sn, shopUserPaymentSavingModel.getShopUserEmail(), shopUserPaymentSavingModel.getShipFullName(), shopCBProductsSavingModel.getTransactionNumber(), shopCBProductsSavingModel.getProductName());
		mav = adminShopBackOrderedRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopOutOfStockDataDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	shopCBProductsSavingModel.setShopProductStatus(outOfStockStatusRef);
    	shopCBProductsSavingModel.setRefferanceDate(currentDate);
    	shopConceptBoardsProductsInfoSavingDAO.merge(shopCBProductsSavingModel);
    	ShopUserPaymentInfoSaving shopUserPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());
    	adminShopOutOfStockSendToTheUser(req, sn, shopUserPaymentSavingModel.getShopUserEmail(), shopUserPaymentSavingModel.getShipFullName(), shopCBProductsSavingModel.getTransactionNumber(), shopCBProductsSavingModel.getProductName());
    	mav = adminShopOutOfStockRedirection(req, sn);    	
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;    	
    }

	public String adminShopOutOfStockSendToTheUser(HttpServletRequest req, HttpSession sn, String shopUserEmail, String userFullName, long orderNumber, String productName) {
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
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We have been notified by our vendor that the <b>" + productName + "</b> from Order Number: <b>" + orderNumber + "</b> is out-of-stock.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>We will be refunding the total amount for this product to your card which includes any tax and shipping charges. You will receive a follow-up email shortly as we process the refund on our end. It may take 5-10 business days for the refund to be reflected on your statement based on your banking services.</p>"                
                + "<p style='margin-top: 30px; font: 1.05em/1.5em sans-serif;'>Please note that for any out-of-stock products, our designers are always on the hunt for great replacements and are constantly updating our design boards! You can always visit us at <a href='https://nookandcove.com'>Nook+Cove</a> for design updates and product replacements!</p>"
                + "<p style='margin-top: 30px; margin-bottom: 35px; font: 1.05em/1.5em sans-serif;'>We appreciate and thank you for your patience and understanding on this matter.</p>"														
				+ "<img src=\"https://www.nookandcove.com/resources/images/maillogo.png\">"					
				+ "<p style='margin-top: 5px; font: italic 1.05em/1.25em sans-serif;'>The Perfect Registry For Life's Next Chapter...</p>"
				+ "<p style='margin-top: 5px; font: 1.05em/1.25em sans-serif;'><a href='https://nookandcove.com'>www.nookandcove.com</a></p>"
                + "</div>"
                + "</body> ";            
	  	try {
	  		userEmail.sendEmail(emailList, subject, body, type, fromAdd);
	  	} catch (Exception ex) {
	  		LOGGER.error("Admin shop out of stock mail failed " + ex);
	  	}       
	  	return shopCartPaymentReff;
	}
    
    @Override
    @Transactional
    public ModelAndView adminShopOutOfStockRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List <ShopConceptBoardsProductsInfoSaving> shopConceptBoardsProductsList = shopConceptBoardsProductsInfoSavingDAO.adminShopConceptBoardsDataTakeFromDB(outOfStockStatusRef);
    	if (!shopConceptBoardsProductsList.isEmpty()) {        	
            List<ShopConceptBoardsProductsInfoSaving> ShopCBProductsInfoSavingList = new ArrayList<ShopConceptBoardsProductsInfoSaving>();
            for (ShopConceptBoardsProductsInfoSaving ShopCBProductsInfoLoop : shopConceptBoardsProductsList) {
            	ShopConceptBoardsProductsInfoSaving shopCBProductsInfoSavingModel = new ShopConceptBoardsProductsInfoSaving();
            	shopCBProductsInfoSavingModel.setShopConceptBoardsProductsInfoSavingId(ShopCBProductsInfoLoop.getShopConceptBoardsProductsInfoSavingId());
            	shopCBProductsInfoSavingModel.setCreatedDate(ShopCBProductsInfoLoop.getRefferanceDate());
            	String shopUserFullName = shopUserFullNameTakeFromDB(req, sn, ShopCBProductsInfoLoop.getShopUserPaymentInfoSavingId());            	
            	shopCBProductsInfoSavingModel.setStoreName(shopUserFullName);
            	shopCBProductsInfoSavingModel.setProductName(ShopCBProductsInfoLoop.getProductName());
            	String priceDsp = "$"+ShopCBProductsInfoLoop.getProductPrice();
            	shopCBProductsInfoSavingModel.setProductPrice(priceDsp);
            	shopCBProductsInfoSavingModel.setTransactionNumber(ShopCBProductsInfoLoop.getTransactionNumber());
            	ShopCBProductsInfoSavingList.add(shopCBProductsInfoSavingModel);
            }            
            mav = new ModelAndView(adminShopOutOfStockRed);
            mav.addObject(shopCBProductInfoSavingList, ShopCBProductsInfoSavingList);            
            mav.addObject(shopDataVisibleStatus, shopVisibleStatus);
        } else{
        	mav = new ModelAndView(adminShopOutOfStockRed);            
        }        
    	int spPurchasesCount = adminShopPurchasesCount(req, sn);
		int spOrderedCount = adminShopOrderedCount(req, sn);
		int spTrackingCount = adminShopTrackingCount(req, sn);
		int spDeliveredCount = adminShopDeliveredCount(req, sn);
		int spBackOrderedCount = adminShopBackOrderedCount(req, sn);
		mav.addObject(shopOutOfStockCount, shopConceptBoardsProductsList.size());
		mav.addObject(shopPurchasesCount, spPurchasesCount);		
		mav.addObject(shopOrderedCount, spOrderedCount);
		mav.addObject(shopTrackingCount, spTrackingCount);
		mav.addObject(shopDeliveredCount, spDeliveredCount);
		mav.addObject(shopBackOrderedCount, spBackOrderedCount);
		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminShopOutOfStockViewDisplayRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long shopCBProductManagementId = Long.parseLong(req.getParameter(shopCBProductsManagementId));
    	ShopConceptBoardsProductsInfoSaving shopCBProductsSavingModel = shopConceptBoardsProductsInfoSavingDAO.adminShopPlaceOrderDataTakeFromDB(shopCBProductManagementId);
    	ShopUserPaymentInfoSaving shopPaymentSavingModel = shopUserPaymentInfoSavingDAO.shopUserFullNameTakeFromDataBase(shopCBProductsSavingModel.getShopUserPaymentInfoSavingId());        
    	String productName = shopCBProductsSavingModel.getProductName();
		String storeName = shopCBProductsSavingModel.getStoreName();
		String productSize = shopCBProductsSavingModel.getProductSize();
		int quantity = shopCBProductsSavingModel.getQuantity();
		String productPrice = "$" + shopCBProductsSavingModel.getProductPrice();
		String storeUrl = shopCBProductsSavingModel.getStoreUrl();		
		String shipFullName = shopPaymentSavingModel.getShipFullName();
		String shipAddress = null;
		if(null != shopPaymentSavingModel.getShipAddress2()) {
			shipAddress = shopPaymentSavingModel.getShipAddress1() + " " + shopPaymentSavingModel.getShipAddress2();
		} else {
			shipAddress = shopPaymentSavingModel.getShipAddress1();
		}
		String totalShippingAddress = shipAddress + ", " + shopPaymentSavingModel.getShipCity() + ", " + shopPaymentSavingModel.getShipState() + ", " + shopPaymentSavingModel.getShipZip() + ".";
		String phoneNumber = shopPaymentSavingModel.getShopUserPhoneNumber();
		String email = shopPaymentSavingModel.getShopUserEmail();
		String productImage = null;
		if(null != shopCBProductsSavingModel.getProductUploadedImage()) {
	    	byte[] shopProdImageFromDB = shopCBProductsSavingModel.getProductUploadedImage();
	    	productImage = javax.xml.bind.DatatypeConverter.printBase64Binary(shopProdImageFromDB);
    	}
    	mav = new ModelAndView(adminShopOutOfStockViewDisplay);    	
    	mav.addObject(shopProductName, productName);
    	mav.addObject(shopStoreName, storeName);
    	mav.addObject(shopProductSize, productSize);
    	mav.addObject(shopQuantity, quantity);
    	mav.addObject(shopProductPrice, productPrice);
    	mav.addObject(shopStoreUrl, storeUrl);
    	mav.addObject(shopShipFullName, shipFullName);
    	mav.addObject(shopShippingAddress, totalShippingAddress);
    	mav.addObject(shopUserPhoneNumber, phoneNumber);
    	mav.addObject(shopUserEmail, email);
    	mav.addObject(shopProductImage, productImage);
    	mav.addObject(shopCBProductsManagementId, req.getParameter(shopCBProductsManagementId));
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
