package com.nookandcove.serviceimpl;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import com.nookandcove.service.RegistryPaymentGatewayService;

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
public class RegistryPaymentGatewayServiceImpl implements RegistryPaymentGatewayService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryPaymentGatewayServiceImpl.class);
	
// 	Sandbox KEY and ID info        
	
//	String apiLoginId = "4xKZ87uLb4q5";
//	String transactionKey = "5bt2wK786bER9Q65";
	
// 	Production KEY and ID info
	
	String apiLoginId = "8ZRdf85ukH";
	String transactionKey = "4TJf59933hfGv6wF";
	
	private String transactionNumberInSn = "transactionNumberInSn";
	private String accountTypeInSn = "accountTypeInSn";
	private String authorizationCodeInSn = "authorizationCodeInSn";
	
	@Override
    @Transactional
    public String totalPaymentInfoSendToAuthorizeNetGateway(HttpServletRequest req, HttpSession sn, String amount, long cardNumber, String expirationDate, Integer cardCode, String fullName, String emailAddress, String fullAddress, String cityName, String stateName, String zipCode) {
		String paymentReturnTypeReff = "";		
		String  jSONObject = "{\"createTransactionRequest\": { \"merchantAuthentication\": { \"name\": "+"\""+apiLoginId+"\""+", \"transactionKey\": "+"\""+transactionKey+"\""+" }, " +
    			"\"refId\": \"\", \"transactionRequest\": { \"transactionType\": \"authCaptureTransaction\", \"amount\": "+"\""+ amount +"\""+", \"payment\": { \"creditCard\": { \"cardNumber\": "+"\""+ cardNumber +"\""+", \"expirationDate\": "+"\""+ expirationDate +"\""+", \"cardCode\": "+"\""+ cardCode +"\""+" } }, " +
    			"\"customer\": { \"email\": "+"\""+emailAddress+"\""+" },"+
    			"\"billTo\": { \"firstName\": "+"\""+ fullName +"\""+", \"address\": "+"\""+ fullAddress +"\""+", \"city\": "+"\""+ cityName +"\""+", \"state\": "+"\""+ stateName +"\""+", \"zip\": "+"\""+ zipCode +"\""+", \"country\": \"USA\" } } } }";        

//  Payment GateWay Code
       	JSONObject jSonResObject1 = new JSONObject();
       	JSONObject jSonResObject2 = new JSONObject();                      
        String authorizationCode = null;
        String description = null;           
        long transactionNumber = 0;
        String accountType = null;
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
        	accountType = (String) jSonResObject1.get("accountType");
        	authorizationCode = (String) jSonResObject1.get("authCode");
        	String transId = (String) jSonResObject1.get("transId");
        	if(null != transId) {
	      		transactionNumber = Long.parseLong(transId);
	    	}           
        	description = (String) jSonResObject2.get("description");
        	paymentReturnTypeReff = description;        	
        } else{
        	String jSonRes1 = jSonStrObj[0].replace(":{", ":\"\",");
        	if(jSonRes1.length() > 300 && jSonRes1.length() < 315){        		
        		paymentReturnTypeReff = "Card Code is invalid.";
        	} else{
        		jSonRes1 = jSonRes1.replace("}", "");
            	jSonRes1 = jSonRes1.replace(",{", ",");
            	jSonRes1 = jSonRes1+"}";
            	jSonRes1 = jSonRes1.replace("﻿", "");
            	
//	Formation From String to JSON
            	jSonResObject1 = convertFromStringToJSONFormat(jSonRes1);             
            	String errorText = (String) jSonResObject1.get("errorText");
            	paymentReturnTypeReff = errorText;
        	}        	 
        }
        sn.setAttribute(transactionNumberInSn, transactionNumber);
        sn.setAttribute(accountTypeInSn, accountType);
        sn.setAttribute(authorizationCodeInSn, authorizationCode);
        return paymentReturnTypeReff;
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
//        ResponseEntity<String> result = template.exchange("https://apitest.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);
        ResponseEntity<String> result = template.exchange("https://api.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);                
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
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
