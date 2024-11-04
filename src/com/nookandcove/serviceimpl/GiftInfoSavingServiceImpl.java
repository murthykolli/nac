package com.nookandcove.serviceimpl;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.GiftInfoSavingDAO;
import com.nookandcove.dao.PromoCodeInfoSavingDAO;
import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.model.GiftInfoSaving;
import com.nookandcove.model.PromoCodeInfoSaving;
import com.nookandcove.model.UserInformation;
import com.nookandcove.service.GiftInfoSavingService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class GiftInfoSavingServiceImpl implements GiftInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GiftInfoSavingServiceImpl.class);
	
	private String typeOfPackage = "typeOfPackage";
	private String packagePrice = "packagePrice";
	private String merchandiseCredit = "merchandiseCredit";
	private String typeOfGiftcard = "typeOfGiftcard";	
	private String typeOfDelivery = "typeOfDelivery";	
	private String giftRecipientName = "giftRecipientName";
	private String giftRecipientAddress = "giftRecipientAddress";
	private String giftRecipientCity = "giftRecipientCity";
	private String giftRecipientState = "giftRecipientState";
	private String giftRecipientZipCode = "giftRecipientZipCode";
	private String recEmailarName = "recEmailarName";
	private String recEmailarAddress = "recEmailarAddress";	
	private String yourName = "yourName";
	private String yourEmail = "yourEmail";
	private String giftMessage = "giftMessage";
	private String deliveryDate = "deliveryDate";	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";
	private String userIdInSn = "userIdInSn";
	private String totalGiftCardPrice = "totalGiftCardPrice";
	private String totalPrice = "totalPrice";
	private String payPromoCode = "payPromoCode";
	private String promoStatus = "promoStatus";
	private String promoCodePrice = "promoCodePrice";	
	private String payCardNumber = "payCardNumber";
	private String payExpMonth = "payExpMonth";
	private String payExpYear = "payExpYear";
	private String payCvvNumber = "payCvvNumber";
	private String nameOnCard = "nameOnCard";
	private String returnTypeInSn = "returnTypeInSn";	
	private String apiLoginId = "apiLoginId";
	private String transactionKey = "transactionKey";
	private String amount = "amount";
	private String paymentReturnStatus = "paymentReturnStatus";
	private String totalCheckoutAmountInSn = "totalCheckoutAmountInSn";
	private String transIdInSn = "transIdInSn";
	private String authorizationCodeInSn = "authorizationCodeInSn";
	private String accountTypeInSn = "accountTypeInSn";	
	private String totalCartItemsCountInSN = "totalCartItemsCountInSN";
	private String totalCartItemsCount = "totalCartItemsCount";
	private String giftCardRedirectionAL = "giftCardRedirectionAL";
	private String giftCardRedirectionBL = "giftCardRedirectionBL";
	private String giftCardPaymentRedirectionAL = "giftCardPaymentRedirectionAL";
	private String giftCardPaymentRedirectionBL = "giftCardPaymentRedirectionBL";	
	
	@Autowired
    private GiftInfoSavingDAO giftInfoSavingDAO;	

    @Autowired
    private PromoCodeInfoSavingDAO promoCodeInfoSavingDAO;
    
    @Autowired
    private UserInformationDAO userInformationDAO;
   
    @Override
    @Transactional
    public ModelAndView giftRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView(giftCardRedirectionAL);
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else {
    		mav = new ModelAndView(giftCardRedirectionBL);
    	}
    	return mav;
    }    
  
    @Override
    @Transactional
    public ModelAndView giftDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	double packagePriceInDB = 0;
    	double merchandiseCreditInDB = 0;
    	double totalGiftCardPriceInDB = 0;
    	if (null != req.getParameter(packagePrice)) {
    		packagePriceInDB = Double.parseDouble(req.getParameter(packagePrice));
        }
    	if (null != req.getParameter(merchandiseCredit)) {
    		merchandiseCreditInDB = Double.parseDouble(req.getParameter(merchandiseCredit));
        }
    	totalGiftCardPriceInDB = packagePriceInDB + merchandiseCreditInDB;
    	String totalGiftCardPriceInSt = String.format("%.2f", totalGiftCardPriceInDB);    	
        if(null != sn.getAttribute(userIdInSn)) {
           	mav = new ModelAndView(giftCardPaymentRedirectionAL);
           	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
           	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else {
           	mav = new ModelAndView(giftCardPaymentRedirectionBL);
        }            
        mav.addObject(typeOfPackage, req.getParameter(typeOfPackage));
        mav.addObject(packagePrice, req.getParameter(packagePrice));
        mav.addObject(merchandiseCredit, req.getParameter(merchandiseCredit));
        mav.addObject(typeOfGiftcard, req.getParameter(typeOfGiftcard));        
        mav.addObject(typeOfDelivery, req.getParameter(typeOfDelivery));
        mav.addObject(giftRecipientName, req.getParameter(giftRecipientName));
        mav.addObject(giftRecipientAddress, req.getParameter(giftRecipientAddress));
        mav.addObject(giftRecipientCity, req.getParameter(giftRecipientCity));
        mav.addObject(giftRecipientState, req.getParameter(giftRecipientState));
        mav.addObject(giftRecipientZipCode, req.getParameter(giftRecipientZipCode));
        mav.addObject(recEmailarName, req.getParameter(recEmailarName));
        mav.addObject(recEmailarAddress, req.getParameter(recEmailarAddress));
        mav.addObject(yourName, req.getParameter(yourName));
        mav.addObject(yourEmail, req.getParameter(yourEmail));
        mav.addObject(giftMessage, req.getParameter(giftMessage));
        mav.addObject(deliveryDate, req.getParameter(deliveryDate));
        mav.addObject(totalGiftCardPrice, totalGiftCardPriceInSt);
        mav.addObject(totalPrice, totalGiftCardPriceInSt);
        sn.setAttribute(totalCheckoutAmountInSn, totalGiftCardPriceInSt);                
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView promoCodePayInGiftCardRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav; 	   
 	    String disCountPrice = null;
 	    String disCount = null;
 	    String promoStatus1 = null;
 	    String totalGiftCardPriceInSt = null; 	    
 	    double totalGiftCardPriceInDB = 0;
 	    double packagePriceInDB = 0;
 	   	double merchandiseCreditInDB = 0;
 	    if ("" != req.getParameter(totalPrice)) {
 	    	totalGiftCardPriceInDB = Double.parseDouble(req.getParameter(totalPrice));
 	 	} 	   
 	    if (null != req.getParameter(packagePrice)) {
 	    	packagePriceInDB = Double.parseDouble(req.getParameter(packagePrice));
 	    }
 	    if (null != req.getParameter(merchandiseCredit)) {
 	    	merchandiseCreditInDB = Double.parseDouble(req.getParameter(merchandiseCredit));
 	    }   	
 	    List<PromoCodeInfoSaving> promoCodeInfoSavingList = promoCodeInfoSavingDAO.selectedPromoCodeChecking(req.getParameter(payPromoCode));
 	    if(!promoCodeInfoSavingList.isEmpty()){
 	    	PromoCodeInfoSaving promoCodeInfoSavingModel = promoCodeInfoSavingDAO.selectedPromoCodeUpdateInDB(req.getParameter(payPromoCode));
 	    	disCount = promoCodeInfoSavingModel.getDiscount(); 	    	   
	 	    if (null != disCount) {         		
	 	    	int disCountAmount = Integer.parseInt(disCount); 	    	
	 	    	double withDisCountAmount = packagePriceInDB*((double)disCountAmount)*0.01;
	 	    	double promoGiftCardPrice = (packagePriceInDB - withDisCountAmount) + merchandiseCreditInDB;	 	    	
	 	    	disCountPrice = String.format("%.2f", withDisCountAmount);
	 	    	totalGiftCardPriceInSt = String.format("%.2f", promoGiftCardPrice);
	 	    } 
 	    } else { 	    	
 	    	promoStatus1 = "Wrong Code";
 	    	totalGiftCardPriceInSt = String.format("%.2f", totalGiftCardPriceInDB); 	    	
 	    } 	     	   
        if(null != sn.getAttribute(userIdInSn)) {
        	if(("0.00").equals(totalGiftCardPriceInSt)) {
        		mav = new ModelAndView("promoCodePaymentRedirectionAL");
        	} else {
        		mav = new ModelAndView(giftCardPaymentRedirectionAL);
        	}
           	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
           	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
        } else {
        	if(("0.00").equals(totalGiftCardPriceInSt)) {
        		mav = new ModelAndView("promoCodePaymentRedirectionBL");
        	} else {
        		mav = new ModelAndView(giftCardPaymentRedirectionBL);
        	}
        }        
        mav.addObject(typeOfPackage, req.getParameter(typeOfPackage));
        mav.addObject(packagePrice, req.getParameter(packagePrice));
        mav.addObject(merchandiseCredit, req.getParameter(merchandiseCredit));
        mav.addObject(typeOfGiftcard, req.getParameter(typeOfGiftcard));        
        mav.addObject(typeOfDelivery, req.getParameter(typeOfDelivery));
        mav.addObject(giftRecipientName, req.getParameter(giftRecipientName));
        mav.addObject(giftRecipientAddress, req.getParameter(giftRecipientAddress));
        mav.addObject(giftRecipientCity, req.getParameter(giftRecipientCity));
        mav.addObject(giftRecipientState, req.getParameter(giftRecipientState));
        mav.addObject(giftRecipientZipCode, req.getParameter(giftRecipientZipCode));
        mav.addObject(recEmailarName, req.getParameter(recEmailarName));
        mav.addObject(recEmailarAddress, req.getParameter(recEmailarAddress));
        mav.addObject(yourName, req.getParameter(yourName));
        mav.addObject(yourEmail, req.getParameter(yourEmail));
        mav.addObject(giftMessage, req.getParameter(giftMessage));
        mav.addObject(deliveryDate, req.getParameter(deliveryDate));
        mav.addObject(totalGiftCardPrice, totalGiftCardPriceInSt);
        mav.addObject(totalPrice, req.getParameter(totalPrice));
        mav.addObject(promoStatus, promoStatus1);
        mav.addObject(promoCodePrice, disCountPrice);
        sn.setAttribute(totalCheckoutAmountInSn, totalGiftCardPriceInSt);        
        mav.addObject(payCardNumber, req.getParameter(payCardNumber));
        mav.addObject(payExpMonth, req.getParameter(payExpMonth));
        mav.addObject(payExpYear, req.getParameter(payExpYear));
        mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
        mav.addObject(nameOnCard, req.getParameter(nameOnCard));
 	    return mav;
    }
   
    @Override
    @Transactional
    public ModelAndView giftCardPromoCodePaymentInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String amount1 = req.getParameter(amount);
    	Timestamp currentDate = currentDate();
	    String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	    GiftInfoSaving gisModel = new GiftInfoSaving();
	    gisModel.setTypeOfPackage(req.getParameter(typeOfPackage));
	    gisModel.setPackagePrice(req.getParameter(packagePrice));
	    gisModel.setMerchandiseCredit(req.getParameter(merchandiseCredit));
	    gisModel.setTypeOfGiftcard(req.getParameter(typeOfGiftcard));
	    if(("Gift Box").equals(req.getParameter(typeOfDelivery))) {
	    	gisModel.setGiftRecipientName(req.getParameter(giftRecipientName));
	    	gisModel.setGiftRecipientAddress(req.getParameter(giftRecipientAddress));
	    	gisModel.setGiftRecipientCity(req.getParameter(giftRecipientCity));
	    	gisModel.setGiftRecipientState(req.getParameter(giftRecipientState));
	    	gisModel.setGiftRecipientZipCode(req.getParameter(giftRecipientZipCode));
	    } else {
	    	gisModel.setRecEmailarName(req.getParameter(recEmailarName));
	    	gisModel.setRecEmailarAddress(req.getParameter(recEmailarAddress));
	    }
	    gisModel.setTypeOfDeliveryMethod(req.getParameter(typeOfDelivery));
	    gisModel.setYourName(req.getParameter(yourName));
	    gisModel.setYourEmail(req.getParameter(yourEmail));
	    gisModel.setGiftMessage(req.getParameter(giftMessage));
	    gisModel.setDeliveryDate(req.getParameter(deliveryDate)); 
	    String alphaNumerics = "1234567890abcdefghijklmnopqrstuvwxyz";
	    String t = "";
	    for (int i = 0; i < 8; i++) {
	    	t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }    	
	    gisModel.setGiftCardCouponCode(t);
	    gisModel.setStatus("NEW");
	    gisModel.setCouponCodeUsedStatus("NO");
	    gisModel.setTotalPrice(amount1);
	    gisModel.setPromoAmount(req.getParameter(promoCodePrice));
	    gisModel.setRemainingGiftPrice(req.getParameter(totalPrice));
	    gisModel.setUsedGiftStatus("NO USED");    	
	    gisModel.setPaymentStatus("This transaction has been approved.");
	    gisModel.setCreatedDate(currentDate);
	    gisModel.setCreatedDateInSt(todayDate);
	    giftInfoSavingDAO.save(gisModel);	        
	    mav = clientGiftCardSentMailToAdmin(req, sn);	        
	    if(null != sn.getAttribute(userIdInSn)) {
	    	mav = new ModelAndView("giftInfoDisplayAL");
	        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	        mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	    } else {
	    	mav = new ModelAndView("giftInfoDisplayBL");
	    }
	    return mav;
    }
   
    @Override
    @Transactional
    public ModelAndView giftCardPaymentInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	long transactionNumber = 0;
    	long cardNumber = Long.parseLong(req.getParameter(payCardNumber));
    	String expirationDate = req.getParameter(payExpMonth) + "" + req.getParameter(payExpYear) ;
        Integer cardCode = Integer.parseInt(req.getParameter(payCvvNumber));
        String apiLoginId1 = req.getParameter(apiLoginId);
        String transactionKey1 = req.getParameter(transactionKey);
        String amount1 = req.getParameter(amount);        
        mav = giftCardPaymentGatewayRedirectionDisplay(req, sn, cardNumber, expirationDate, cardCode, apiLoginId1, transactionKey1, amount1, req.getParameter(yourEmail));
    	String returnVal = (String) sn.getAttribute(returnTypeInSn);        
    	if(("This transaction has been approved.").equals(returnVal)) {    	
	    	Timestamp currentDate = currentDate();
	    	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	    	GiftInfoSaving gisModel = new GiftInfoSaving();
	    	gisModel.setTypeOfPackage(req.getParameter(typeOfPackage));
	    	gisModel.setPackagePrice(req.getParameter(packagePrice));
	    	gisModel.setMerchandiseCredit(req.getParameter(merchandiseCredit));
	    	gisModel.setTypeOfGiftcard(req.getParameter(typeOfGiftcard));	    	
	    	if(("Gift Box").equals(req.getParameter(typeOfDelivery))) {
	    		gisModel.setGiftRecipientName(req.getParameter(giftRecipientName));
	    		gisModel.setGiftRecipientAddress(req.getParameter(giftRecipientAddress));
	    		gisModel.setGiftRecipientCity(req.getParameter(giftRecipientCity));
	    		gisModel.setGiftRecipientState(req.getParameter(giftRecipientState));
	    		gisModel.setGiftRecipientZipCode(req.getParameter(giftRecipientZipCode));
	    	} else {
	    		gisModel.setRecEmailarName(req.getParameter(recEmailarName));
	    		gisModel.setRecEmailarAddress(req.getParameter(recEmailarAddress));
	    	}	    	    	
	    	gisModel.setTypeOfDeliveryMethod(req.getParameter(typeOfDelivery));
	    	gisModel.setYourName(req.getParameter(yourName));
	    	gisModel.setYourEmail(req.getParameter(yourEmail));
	    	gisModel.setGiftMessage(req.getParameter(giftMessage));
	    	gisModel.setDeliveryDate(req.getParameter(deliveryDate));    	
	    	String alphaNumerics = "1234567890abcdefghijklmnopqrstuvwxyz";
	        String t = "";
	        for (int i = 0; i < 8; i++) {
	        t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	        }    	
	    	gisModel.setGiftCardCouponCode(t);
	    	gisModel.setStatus("NEW");
	    	gisModel.setCouponCodeUsedStatus("NO");
	    	gisModel.setTotalPrice(amount1);
	    	gisModel.setPromoAmount(req.getParameter(promoCodePrice));
	    	gisModel.setRemainingGiftPrice(req.getParameter(totalPrice));
	    	gisModel.setUsedGiftStatus("NO USED");
	    	gisModel.setPayCardNumber(req.getParameter(payCardNumber));
	    	gisModel.setAccountType((String) sn.getAttribute(accountTypeInSn));
	    	gisModel.setPayExpDate(expirationDate);
	    	gisModel.setNameOnCard(req.getParameter(nameOnCard));
	    	if(null != sn.getAttribute(transIdInSn)) {
	    		transactionNumber = Long.parseLong((String) sn.getAttribute(transIdInSn));
	    	}
	    	gisModel.setTransactionNumber(transactionNumber);
	    	gisModel.setAuthorizationCode((String) sn.getAttribute(authorizationCodeInSn));
	    	gisModel.setPaymentStatus(returnVal);
	    	gisModel.setCreatedDate(currentDate);
	    	gisModel.setCreatedDateInSt(todayDate);
	        giftInfoSavingDAO.save(gisModel);	        
	        mav = clientGiftCardSentMailToAdmin(req, sn);	        
	        if(null != sn.getAttribute(userIdInSn)) {
	           	mav = new ModelAndView("giftInfoDisplayAL");
	           	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
	           	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
	        } else {
	           	mav = new ModelAndView("giftInfoDisplayBL");
	        }
    	} else {
    		if(null != sn.getAttribute(userIdInSn)) {
               	mav = new ModelAndView(giftCardPaymentRedirectionAL);
               	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
               	mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
            } else {
               	mav = new ModelAndView(giftCardPaymentRedirectionBL);
            }
    		mav.addObject(paymentReturnStatus, returnVal);
	        mav.addObject(typeOfPackage, req.getParameter(typeOfPackage));
	        mav.addObject(packagePrice, req.getParameter(packagePrice));
	        mav.addObject(merchandiseCredit, req.getParameter(merchandiseCredit));
	        mav.addObject(typeOfGiftcard, req.getParameter(typeOfGiftcard));        
	        mav.addObject(typeOfDelivery, req.getParameter(typeOfDelivery));
	        mav.addObject(giftRecipientName, req.getParameter(giftRecipientName));
	        mav.addObject(giftRecipientAddress, req.getParameter(giftRecipientAddress));
	        mav.addObject(giftRecipientCity, req.getParameter(giftRecipientCity));
	        mav.addObject(giftRecipientState, req.getParameter(giftRecipientState));
	        mav.addObject(giftRecipientZipCode, req.getParameter(giftRecipientZipCode));
	        mav.addObject(recEmailarName, req.getParameter(recEmailarName));
	        mav.addObject(recEmailarAddress, req.getParameter(recEmailarAddress));
	        mav.addObject(yourName, req.getParameter(yourName));
	        mav.addObject(yourEmail, req.getParameter(yourEmail));
	        mav.addObject(giftMessage, req.getParameter(giftMessage));
	        mav.addObject(deliveryDate, req.getParameter(deliveryDate));
	        mav.addObject(payCardNumber, req.getParameter(payCardNumber));
	        mav.addObject(payExpMonth, req.getParameter(payExpMonth));
	        mav.addObject(payExpYear, req.getParameter(payExpYear));
	        mav.addObject(payCvvNumber, req.getParameter(payCvvNumber));
	        mav.addObject(nameOnCard, req.getParameter(nameOnCard));
	        mav.addObject(totalGiftCardPrice, amount1);
	        mav.addObject(totalPrice, req.getParameter(totalPrice));
	        mav.addObject(promoCodePrice, req.getParameter(promoCodePrice));
	        sn.setAttribute(totalCheckoutAmountInSn, amount1);
    	}
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView clientGiftCardSentMailToAdmin(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
        long adminUserId = 1;
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification(adminUserId);        		
        String userID1 = userInformation.getUserName();
        String userID2 = "brennan.rachman@madwire.com ";
        String userID3 = "marketing360+m24951@bcc.mad360.net";
        String[] emailList = {userID1, userID2, userID3};
        String firstName = userInformation.getFirstName();
        String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String subject = "A gift card has been purchased.";            
        String type = "text/html";           
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";              
        String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> "
                    + "<p style='padding-top: 5px;'>A gift card has been purchased. Need to send out gift card according to instructions.</p>"
                    + "<p style='padding-top: 5px;'><a href='https://nookandcove.com/nookandcove/login'>www.nookandcove.com/login</a></p>"
                    + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                    + "</div>"
                    + "</body> ";            
        try {
        	userEmail.sendEmail(emailList, subject, body, type, fromAdd);         	
        } catch (Exception ex) {
        	LOGGER.error("client Gift Card Sent Mail To Admin failed " + ex);
        }       
        mav = new ModelAndView();
        return mav;
    }
	
    @Override
    @Transactional
    public ModelAndView giftCardPaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String userName) {
    	ModelAndView mav;
    	String returnType = "";    	  
    	String  jSONObject = "{\"createTransactionRequest\": { \"merchantAuthentication\": { \"name\": "+"\""+apiLoginId+"\""+", \"transactionKey\": "+"\""+transactionKey+"\""+" }, " +
    						 "\"refId\": \"\", \"transactionRequest\": { \"transactionType\": \"authCaptureTransaction\", \"amount\": "+"\""+amount+"\""+", \"payment\": { \"creditCard\": { \"cardNumber\": "+"\""+cardNumber+"\""+", \"expirationDate\": "+"\""+expirationDate+"\""+", \"cardCode\": "+"\""+cardCode+"\""+" } }, " +
    						 "\"customer\": { \"email\": "+"\""+userName+"\""+" } } } }";
      
//Payment GateWay Code
    	JSONObject jSonResObject1 = new JSONObject();
    	JSONObject jSonResObject2 = new JSONObject();                      
    	String authorizationCode = null;
    	String description = null;      
//	API Rest Service Redirection   
    	String responseBody = resBodyFromAPIToApplication(jSONObject);         
    	responseBody = responseBody.replace("[", "");
    	String responseBody1 = responseBody.replace("]", "");        
    	String[] jSonStrObj = responseBody1.split(",\"messages\":");      
    	if(jSonStrObj.length > 2) {
	      	String jSonRes1 = jSonStrObj[0].replace(":{", ":\"\",");
	      	jSonRes1 = jSonRes1+"}";
	      	jSonRes1 = jSonRes1.replace("﻿", "");           
	      	String jSonRes2 = jSonStrObj[1].replace("}", "");
	      	jSonRes2 = jSonRes2+"}";
	      	jSonRes2 = jSonRes2.replace("﻿", "");	      	
	//	Formation From String to JSON           
	      	jSonResObject1 = convertFromStringToJSONFormat(jSonRes1);
	      	jSonResObject2 = convertFromStringToJSONFormat(jSonRes2);       
//	      	String accountNumber = (String) jSonResObject1.get("accountNumber");
	      	String accountType = (String) jSonResObject1.get("accountType");
	      	authorizationCode = (String) jSonResObject1.get("authCode");
	      	String transId = (String) jSonResObject1.get("transId");
	      	description = (String) jSonResObject2.get("description");	      	
	      	returnType = description;
	      	sn.setAttribute(transIdInSn, transId);
	      	sn.setAttribute(authorizationCodeInSn, authorizationCode);
	      	sn.setAttribute(accountTypeInSn, accountType);	      		      	
    	} else{
	      	String jSonRes1 = jSonStrObj[0].replace(":{", ":\"\",");
	      	if(jSonRes1.length() > 300 && jSonRes1.length() < 315){        		
	      		returnType = "Card Code is invalid.";
	      	} else{
	      		jSonRes1 = jSonRes1.replace("}", "");
	          	jSonRes1 = jSonRes1.replace(",{", ",");
	          	jSonRes1 = jSonRes1+"}";
	          	jSonRes1 = jSonRes1.replace("﻿", "");	          	
	//	Formation From String to JSON
	          	jSonResObject1 = convertFromStringToJSONFormat(jSonRes1);             
	          	String errorText = (String) jSonResObject1.get("errorText");
	          	returnType = errorText;
	      	}        	 
      }
      sn.setAttribute(returnTypeInSn, returnType);
      mav = new ModelAndView();           		     
      return mav;
    }	 
	
//	Convert From String Value To JSON Format
	@Override
	@Transactional
	public String resBodyFromAPIToApplication(String jSONObject) {
		String responseBody = null;
	    try {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	    	HttpEntity entity = new HttpEntity(jSONObject, headers);
	    	RestTemplate template = new RestTemplate();
	    	ResponseEntity<String> result = template.exchange("https://api.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);
//	    	ResponseEntity<String> result = template.exchange("https://apitest.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);
	    	responseBody = result.getBody();
	    } catch (Exception exception) {
	    	LOGGER.error("SaveArrangements" + exception);
	    }
	    return responseBody;
	} 
	
//	Convert From String Value To JSON Format
	@Override
	@Transactional
	public JSONObject convertFromStringToJSONFormat(String jSonResponse) {
		JSONParser parser = new JSONParser();
		JSONObject jSONResObject = new JSONObject();
		try {		
		    jSONResObject = (JSONObject) parser.parse(jSonResponse);
		} catch (ParseException e) {
		    LOGGER.error("Convert String To Json Format is Fail " + e);
		}
		return jSONResObject;
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
