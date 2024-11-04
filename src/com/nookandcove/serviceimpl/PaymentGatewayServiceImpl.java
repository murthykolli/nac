package com.nookandcove.serviceimpl;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.ClientPackageAndRenderingPaymentInfoSavingDAO;
import com.nookandcove.dao.ShoppingCartPaymentInfoSavingDAO;
import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.model.ClientPackageAndRenderingPaymentInfoSaving;
import com.nookandcove.model.ShoppingCartPaymentInfoSaving;
import com.nookandcove.model.UserInformation;
import com.nookandcove.service.PaymentGatewayService;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author MurthyK
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentGatewayServiceImpl.class);
	
	private String userIdInSn = "userIdInSn";
	private String clientInfoSavingIdInSn = "clientInfoSavingIdInSn";
	private String returnTypeInSn = "returnTypeInSn";
	private String paymentInfoSavingIdInSn = "paymentInfoSavingIdInSn";
	

    @Autowired
    private ShoppingCartPaymentInfoSavingDAO shoppingCartPaymentInfoSavingDAO;

    @Autowired
    private ClientPackageAndRenderingPaymentInfoSavingDAO clientPackageAndRenderingPaymentInfoSavingDAO;

    @Autowired
    private UserInformationDAO userInformationDAO;
      
// 	Payment Request and Response For Package Payment Service Implementation
	@Override
    @Transactional
    public ModelAndView packagePaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard, String totalAmount, String giftAmount, String promoCodePrice) {
    	ModelAndView mav;
        String returnType = "";
        long paymentInfoSavingId = 0;
        
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
        String userName = userInformation.getUserName();
                
        String  jSONObject = "{\"createTransactionRequest\": { \"merchantAuthentication\": { \"name\": "+"\""+apiLoginId+"\""+", \"transactionKey\": "+"\""+transactionKey+"\""+" }, " +
    			"\"refId\": \"\", \"transactionRequest\": { \"transactionType\": \"authCaptureTransaction\", \"amount\": "+"\""+amount+"\""+", \"payment\": { \"creditCard\": { \"cardNumber\": "+"\""+cardNumber+"\""+", \"expirationDate\": "+"\""+expirationDate+"\""+", \"cardCode\": "+"\""+cardCode+"\""+" } }, " +
    			"\"customer\": { \"email\": "+"\""+userName+"\""+" } } } }";
        
//  Payment GateWay Code
       	JSONObject jSonResObject1 = new JSONObject();
       	JSONObject jSonResObject2 = new JSONObject();                      
        String authorizationCode = null;
        String description = null;           
        long transactionNumber = 0;
        
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
        	//String accountNumber = (String) jSonResObject1.get("accountNumber");
        	String accountType = (String) jSonResObject1.get("accountType");
        	authorizationCode = (String) jSonResObject1.get("authCode");
        	String transId = (String) jSonResObject1.get("transId");
        	if(null != transId) {
	      		transactionNumber = Long.parseLong(transId);
	    	}           
        	description = (String) jSonResObject2.get("description");
        	
        	Timestamp currentDate = currentDate(); 
        	ClientPackageAndRenderingPaymentInfoSaving clPackAndSecRendModel = new ClientPackageAndRenderingPaymentInfoSaving();
        	clPackAndSecRendModel.setUserId((Long) sn.getAttribute(userIdInSn));
        	clPackAndSecRendModel.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
        	String accCardNumber = Long.toString(cardNumber);
        	clPackAndSecRendModel.setPayCardNumber(accCardNumber);
        	clPackAndSecRendModel.setAccountType(accountType);
        	clPackAndSecRendModel.setPayExpDate(expirationDate);
        	clPackAndSecRendModel.setPayCvvNumber("****");
        	clPackAndSecRendModel.setPaymentStatus(description);
        	clPackAndSecRendModel.setNameOnCard(nameOnCard);
        	clPackAndSecRendModel.setEstimatedAmount(totalAmount);
        	clPackAndSecRendModel.setGiftAmount(giftAmount);
        	clPackAndSecRendModel.setPromoAmount(promoCodePrice);
        	clPackAndSecRendModel.setAuthorizationCode(authorizationCode);
        	clPackAndSecRendModel.setTransactionNumber(transactionNumber);
        	clPackAndSecRendModel.setTypeOfPayment("Package Payment");
        	clPackAndSecRendModel.setTotalPaybleAmount(amount);
        	clPackAndSecRendModel.setCreatedDate(currentDate);
        	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        	clPackAndSecRendModel.setCreatedDateInSt(todayDate);
        	clientPackageAndRenderingPaymentInfoSavingDAO.save(clPackAndSecRendModel);
        	paymentInfoSavingId = clPackAndSecRendModel.getClientPackageAndRenderingPaymentInfoSavingId();
        	returnType = description;
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
        sn.setAttribute(paymentInfoSavingIdInSn, paymentInfoSavingId);
        mav = new ModelAndView();           		     
        return mav;
    }	
	  
//	Payment Request and Response For 2nd Rendering Payment Service Implementation
	@Override
	@Transactional
	public ModelAndView secRenderingPaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard, String totalAmount, String giftAmount) {
		LOGGER.debug("secRenderingPaymentGatewayRedirectionDisplay...Service");        
		ModelAndView mav;
		String returnType = "";
		long paymentInfoSavingId = 0;
      
		UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
		String userName = userInformation.getUserName();
              
		String  jSONObject = "{\"createTransactionRequest\": { \"merchantAuthentication\": { \"name\": "+"\""+apiLoginId+"\""+", \"transactionKey\": "+"\""+transactionKey+"\""+" }, " +
  			"\"refId\": \"\", \"transactionRequest\": { \"transactionType\": \"authCaptureTransaction\", \"amount\": "+"\""+amount+"\""+", \"payment\": { \"creditCard\": { \"cardNumber\": "+"\""+cardNumber+"\""+", \"expirationDate\": "+"\""+expirationDate+"\""+", \"cardCode\": "+"\""+cardCode+"\""+" } }, " +
  			"\"customer\": { \"email\": "+"\""+userName+"\""+" } } } }";
      
//Payment GateWay Code
     	JSONObject jSonResObject1 = new JSONObject();
     	JSONObject jSonResObject2 = new JSONObject();                      
     	String authorizationCode = null;
     	String description = null;           
     	long transactionNumber = 0;
      
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
	      	String accountType = (String) jSonResObject1.get("accountType");
	      	authorizationCode = (String) jSonResObject1.get("authCode");
	      	String transId = (String) jSonResObject1.get("transId");
	      	if(null != transId) {
	      		transactionNumber = Long.parseLong(transId);
	    	}
	      	description = (String) jSonResObject2.get("description");
	      	
	      	Timestamp currentDate = currentDate(); 
	      	ClientPackageAndRenderingPaymentInfoSaving clPackAndSecRendModel = new ClientPackageAndRenderingPaymentInfoSaving();
	      	clPackAndSecRendModel.setUserId((Long) sn.getAttribute(userIdInSn));
	      	clPackAndSecRendModel.setClientInfoSavingId((Long) sn.getAttribute(clientInfoSavingIdInSn));
	      	String accCardNumber = Long.toString(cardNumber);
	      	clPackAndSecRendModel.setPayCardNumber(accCardNumber);
	      	clPackAndSecRendModel.setAccountType(accountType);
	      	clPackAndSecRendModel.setPayExpDate(expirationDate);
	      	clPackAndSecRendModel.setPayCvvNumber("****");
	      	clPackAndSecRendModel.setPaymentStatus(description);
	      	clPackAndSecRendModel.setNameOnCard(nameOnCard);
	      	clPackAndSecRendModel.setEstimatedAmount(totalAmount);
	      	clPackAndSecRendModel.setGiftAmount(giftAmount);
	      	clPackAndSecRendModel.setAuthorizationCode(authorizationCode);
	      	clPackAndSecRendModel.setTransactionNumber(transactionNumber);
	      	clPackAndSecRendModel.setTypeOfPayment("Rendering Payment");
	      	clPackAndSecRendModel.setTotalPaybleAmount(amount);
	      	clPackAndSecRendModel.setCreatedDate(currentDate);
	      	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        	clPackAndSecRendModel.setCreatedDateInSt(todayDate);
	      	clientPackageAndRenderingPaymentInfoSavingDAO.save(clPackAndSecRendModel);
	      	paymentInfoSavingId = clPackAndSecRendModel.getClientPackageAndRenderingPaymentInfoSavingId();
	      	returnType = description;
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
      sn.setAttribute(paymentInfoSavingIdInSn, paymentInfoSavingId);
      mav = new ModelAndView();           		     
      return mav;
  }

	  
// 	Payment Request and Response For Cart Checkout Payment Service Implementation
	@Override
    @Transactional
    public ModelAndView catCheckoutPaymentGatewayRedirectionDisplay(HttpServletRequest req, HttpSession sn, long cardNumber, String expirationDate, int cardCode, String apiLoginId, String transactionKey, String amount, String nameOnCard) {
    	LOGGER.debug("catCheckoutPaymentGatewayRedirectionDisplay...Service");        
        ModelAndView mav;
        String returnType = "";
//        long paymentInfoSavingId = 0;
        
        UserInformation userInformation = userInformationDAO.updatedRowIdVerification((Long) sn.getAttribute(userIdInSn));
        String userName = userInformation.getUserName();
        
        ShoppingCartPaymentInfoSaving shCartPaySavingModel = shoppingCartPaymentInfoSavingDAO.updatedShoppingCartPaymentRowInDB((Long) sn.getAttribute(userIdInSn));
		String shipingAddress = shCartPaySavingModel.getShipAddress1() + "" + shCartPaySavingModel.getShipAddress2();
		String billingAddress = shCartPaySavingModel.getBillAddress1() + "" + shCartPaySavingModel.getBillAddress2();
		String giftCdAmount = shCartPaySavingModel.getCartGiftAmount();
        
        String  jSONObject = "{\"createTransactionRequest\": { \"merchantAuthentication\": { \"name\": "+"\""+apiLoginId+"\""+", \"transactionKey\": "+"\""+transactionKey+"\""+" }, " +
    			"\"refId\": \"\", \"transactionRequest\": { \"transactionType\": \"authCaptureTransaction\", \"amount\": "+"\""+ amount +"\""+", \"payment\": { \"creditCard\": { \"cardNumber\": "+"\""+ cardNumber +"\""+", \"expirationDate\": "+"\""+ expirationDate +"\""+", \"cardCode\": "+"\""+ cardCode +"\""+" } }, " +
    			"\"customer\": { \"email\": "+"\""+userName+"\""+" },"+
    			"\"billTo\": { \"firstName\": "+"\""+ shCartPaySavingModel.getBillFullName() +"\""+", \"address\": "+"\""+ billingAddress +"\""+", \"city\": "+"\""+ shCartPaySavingModel.getBillCity() +"\""+", \"state\": "+"\""+ shCartPaySavingModel.getBillState() +"\""+", \"zip\": "+"\""+ shCartPaySavingModel.getBillZip() +"\""+", \"country\": \"USA\" }, " +
    			"\"shipTo\": { \"firstName\": "+"\""+ shCartPaySavingModel.getShipFullName() +"\""+", \"address\": "+"\""+ shipingAddress +"\""+", \"city\": "+"\""+ shCartPaySavingModel.getShipCity() +"\""+", \"state\": "+"\""+ shCartPaySavingModel.getShipState() +"\""+", \"zip\": "+"\""+ shCartPaySavingModel.getShipZip() +"\""+", \"country\": \"USA\" } } } }";
        
//  Payment GateWay Code
       	JSONObject jSonResObject1 = new JSONObject();
       	JSONObject jSonResObject2 = new JSONObject();                      
        String authorizationCode = null;
        String description = null;           
        long transactionNumber = 0;
        
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
        	//String accountNumber = (String) jSonResObject1.get("accountNumber");
        	String accountType = (String) jSonResObject1.get("accountType");
        	authorizationCode = (String) jSonResObject1.get("authCode");
        	String transId = (String) jSonResObject1.get("transId");
        	if(null != transId) {
	      		transactionNumber = Long.parseLong(transId);
	    	}           
        	description = (String) jSonResObject2.get("description");
        	
        	Timestamp currentDate = currentDate(); 
        	
        	String accCardNumber = Long.toString(cardNumber);
        	shCartPaySavingModel.setPayCardNumber(accCardNumber);
        	shCartPaySavingModel.setAccountType(accountType);
        	shCartPaySavingModel.setPayExpDate(expirationDate);
        	String cvvNum = Integer.toString(cardCode);
        	shCartPaySavingModel.setPayCvvNumber(cvvNum);
        	shCartPaySavingModel.setCheckoutPaymentStatus(description);
        	shCartPaySavingModel.setNameOnCard(nameOnCard);
        	shCartPaySavingModel.setGiftAmount(giftCdAmount);
        	shCartPaySavingModel.setAuthorizationCode(authorizationCode);
        	shCartPaySavingModel.setTransactionNumber(transactionNumber);
        	shCartPaySavingModel.setTotalPaybleAmount(amount);
        	shCartPaySavingModel.setGiftCouponCodes(null);
        	shCartPaySavingModel.setCartGiftAmount(null);
        	shCartPaySavingModel.setOrderedStatus("NO");
        	shCartPaySavingModel.setDeliveredStatus("NO");
        	shCartPaySavingModel.setUpdatedDate(currentDate);
        	String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        	shCartPaySavingModel.setCreatedDateInSt(todayDate);
        	shoppingCartPaymentInfoSavingDAO.merge(shCartPaySavingModel);
//        	paymentInfoSavingId = shCartPaySavingModel.getShoppingCartPaymentInfoSavingId();
        	returnType = description;
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
//        sn.setAttribute(paymentInfoSavingIdInSn, paymentInfoSavingId);
        mav = new ModelAndView();           		     
        return mav;
    }
	
//	Convert From String Value To JSON Format
	@Override
	@Transactional
	public String resBodyFromAPIToApplication(String jSONObject) {
	    LOGGER.debug("resBodyFromAPIToApplication...Service");
	    String responseBody = null;
	    try {
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(jSONObject, headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> result = template.exchange("https://api.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);
//        ResponseEntity<String> result = template.exchange("https://apitest.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);        
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
