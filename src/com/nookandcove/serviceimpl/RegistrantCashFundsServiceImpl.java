package com.nookandcove.serviceimpl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Timestamp;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.RegistryCashFundsInfoSavingDAO;
import com.nookandcove.dao.RegistryCashFundsPaymentInfoSavingDAO;
import com.nookandcove.model.RegistryCashFundsInfoSaving;
import com.nookandcove.model.RegistryCashFundsPaymentInfoSaving;
import com.nookandcove.service.RegistrantCashFundsService;


@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class RegistrantCashFundsServiceImpl implements RegistrantCashFundsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantCashFundsServiceImpl.class);
	
	private String regFirstNames = "regFirstNames";
	private String regFirstNamesInSn = "regFirstNamesInSn";	
	private String regTotalCartItems = "regTotalCartItems";
	private String regiCartCountInSn = "regiCartCountInSn";
	
	private String cashFundsImagePath = "cashFundsImagePath";
	private String cashFundName = "cashFundName";
	private String cashFundsName = "cashFundsName";
	private String cashFundNewName = "cashFundNewName";
	private String cashFundSmallImageUrl = "resources/images/cash_fund_images/small/";
	private String cashFundBigImageUrl = "resources/images/cash_fund_images/big/";
	private String registrantUserIdInSn = "registrantUserIdInSn";
	private String uploadImgPath = "/var/www/html/data/nookandcoveimages/";
	private String cashFundImagePath = "cashFundImagePath";
	private String cashFundsImgPathDsp = "cashFundsImgPathDsp";
	private String registryRoomFundsCountInSn = "registryRoomFundsCountInSn";
	private String registryCashFundsCountInSn = "registryCashFundsCountInSn";
	private String registryCustomFundsCountInSn = "registryCustomFundsCountInSn";
	private String regCBIndividualCountInSn = "regCBIndividualCountInSn";
	private String regCBContributedCartCountInSn = "regCBContributedCartCountInSn";
	private String jSonObject = "JSonObj";
	
	private String cashFundReqAmount = "cashFundReqAmount";
	private String cashFundReqMessage = "cashFundReqMessage";
	private String cashFundsAmount = "cashFundsAmount";
	private String cashFundsMessage = "cashFundsMessage";
	private String cashFundsImageName = "cashFundsImageName";
//	private String cfContributeAmount = "cfContributeAmount";
	private String customFundOldName = "customFundOldName";
	private String customFundName = "customFundName";
	
	private String registryCashFundsCreation = "registryCashFundsCreation";
	private String registryCashFundsUpdation = "registryCashFundsUpdation";
	private String registryCustomFundsCreation = "registryCustomFundsCreation";
	private String registryCustomFundsUpdation = "registryCustomFundsUpdation";
	private String registryCustomFundsEditing = "registryCustomFundsEditing";
	private String registryOverview = "registryOverview";
	
	private String redirectStatus = "redirect:";
	private String createCashFunds = "createCashFunds";
	
	private String registryCashFundsId = "registryCashFundsId";
	private String contributeAmount = "contributeAmount";
	private String landingBackRef = "landingBackRef";
	private String landingBackRefInSn = "landingBackRefInSn";
	private String landingCFBackRef = "landingCFBackRef";
	private String landingCFBackRefInSn = "landingCFBackRefInSn";
	
	private String regCashFundsIdListInSn = "regCashFundsIdListInSn";
	private String regCashFundsImageListInSn = "regCashFundsImageListInSn";	
	private String regCashFundsNameListInSn = "regCashFundsNameListInSn";
	private String regCashFundsPriceListInSn = "regCashFundsPriceListInSn";
	private String regCashFundsContAmountListInSn = "regCashFundsContAmountListInSn";
	private String regCashFundsRemAmountListInSn = "regCashFundsRemAmountListInSn";
	private String regCashFundsMessagesListInSn = "regCashFundsMessagesListInSn";	
	private String regCustomFundsIdListInSn = "regCustomFundsIdListInSn";
	private String regCustomFundsImageListInSn = "regCustomFundsImageListInSn";	
	private String regCustomFundsNameListInSn = "regCustomFundsNameListInSn";
	private String regCustomFundsPriceListInSn = "regCustomFundsPriceListInSn";
	private String regCustomFundsContAmountListInSn = "regCustomFundsContAmountListInSn";
	private String regCustomFundsRemAmountListInSn = "regCustomFundsRemAmountListInSn";
	private String regCustomFundsMessagesListInSn = "regCustomFundsMessagesListInSn";
	private String regCustomFundId = "regCustomFundId";
	
	private String regCustomFundRef = "Custom Fund";
	private String regCashFundOnlyRef = "Cash Fund Only";
	private String regCustomFundOnlyRef = "Custom Fund Only";
	private String dbCustomNameRef = "Have Custom Name In DB";
	private String regCustomFundError = "regCustomFundError";
	private String regCashFundBackRef = "Cash Fund Back";
	private String regCustomFundBackRef = "Custom Fund Back";
	
	

	@Autowired
	private RegistryCashFundsInfoSavingDAO registryCashFundsInfoSavingDAO;

	@Autowired
	private RegistryCashFundsPaymentInfoSavingDAO registryCashFundsPaymentInfoSavingDAO;
	
	
    @Override
    @Transactional
    public ModelAndView registryCharityFundRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String cashFundImgPath = cashFundSmallImageUrl + req.getParameter(cashFundImagePath);
    	List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCashFundsDataCheckUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(cashFundsName));
    	if (!registryCashFundsInfoList.isEmpty()) {
    		RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(cashFundsName));
    		mav = new ModelAndView(registryCashFundsUpdation);
    		mav.addObject(cashFundsMessage, registryCashFundsInfoModel.getCashFundMessage());
    		mav.addObject(cashFundsAmount, registryCashFundsInfoModel.getCashFundReqAmount());    		
    	} else {
    		mav = new ModelAndView(registryCashFundsCreation);
    	}
    	mav.addObject(cashFundName, req.getParameter(cashFundsName));
    	mav.addObject(cashFundsImagePath, req.getParameter(cashFundImagePath));
    	mav.addObject(cashFundsImgPathDsp, cashFundImgPath);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }
	    
//	Cash Funds Data Saving and Updating in Data Base Tables
    @Override
    @Transactional
    public ModelAndView regTopCashFundsInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	RegistryCashFundsInfoSaving regCashFundsInfoSavingModel = new RegistryCashFundsInfoSaving();
    	String regCFReqMessage = req.getParameter(cashFundReqMessage);
    	regCFReqMessage = regCFReqMessage.replaceAll("[\n\r]", " ");
    	regCashFundsInfoSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    	regCashFundsInfoSavingModel.setCashFundName(req.getParameter(cashFundsName));
    	regCashFundsInfoSavingModel.setCashFundMessage(regCFReqMessage);
    	regCashFundsInfoSavingModel.setCashFundImageUrl(req.getParameter(cashFundsImageName));
    	regCashFundsInfoSavingModel.setCashFundReqAmount(req.getParameter(cashFundReqAmount));
    	regCashFundsInfoSavingModel.setCashFundNewName(regCashFundOnlyRef);
    	regCashFundsInfoSavingModel.setCreatedDate(currentDate);
    	registryCashFundsInfoSavingDAO.save(regCashFundsInfoSavingModel);
    	registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	return mav;
    }

    public String registryCashFundInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String cashFundInfo = null;       
        List regCashFundsIdList = new ArrayList();
        List regCashFundsImageList = new ArrayList();
        List regCashFundsNameList = new ArrayList();
		List regCashFundsPriceList = new ArrayList();
		List regCashFundsContAmountList = new ArrayList();
		List regCashFundsRemAmountList = new ArrayList();
		List regCashFundsMessagesList = new ArrayList();
		List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCashFundsDataCheckInDB(registrantUserId);
        if (!registryCashFundsInfoList.isEmpty()) {
    		for (RegistryCashFundsInfoSaving registryCashFundsInfoModel : registryCashFundsInfoList) {
	    		regCashFundsIdList.add(registryCashFundsInfoModel.getRegistryCashFundsInfoSavingId());
	    		regCashFundsImageList.add(registryCashFundsInfoModel.getCashFundImageUrl());
	            regCashFundsNameList.add(registryCashFundsInfoModel.getCashFundName());
	            regCashFundsPriceList.add(registryCashFundsInfoModel.getCashFundReqAmount());
	            regCashFundsContAmountList.add(registryCashFundsInfoModel.getTotalContributedAmount());
	            regCashFundsRemAmountList.add(registryCashFundsInfoModel.getRemainingAmount());
	            regCashFundsMessagesList.add(registryCashFundsInfoModel.getCashFundMessage());	            
	    	}
    	}    	   	
    	sn.setAttribute(regCashFundsIdListInSn, regCashFundsIdList);    	
    	sn.setAttribute(regCashFundsImageListInSn, regCashFundsImageList);
    	sn.setAttribute(regCashFundsNameListInSn, regCashFundsNameList);
    	sn.setAttribute(regCashFundsPriceListInSn, regCashFundsPriceList);
    	sn.setAttribute(regCashFundsContAmountListInSn, regCashFundsContAmountList);
    	sn.setAttribute(regCashFundsRemAmountListInSn, regCashFundsRemAmountList);
    	sn.setAttribute(regCashFundsMessagesListInSn, regCashFundsMessagesList);
        return cashFundInfo;
    }
    
    @Override
    @Transactional
    public ModelAndView regTopCashFundsInfoUpdatingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	RegistryCashFundsInfoSaving regCashFundsInfoSavingModel = registryCashFundsInfoSavingDAO.registryCashFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(cashFundsName));
    	String cashFundRemAmount = cashFundRemainingAmount(req.getParameter(cashFundReqAmount), regCashFundsInfoSavingModel.getTotalContributedAmount());
    	String regCFReqMessage = req.getParameter(cashFundReqMessage);
    	regCFReqMessage = regCFReqMessage.replaceAll("[\n\r]", " ");
    	regCashFundsInfoSavingModel.setCashFundMessage(regCFReqMessage);
    	regCashFundsInfoSavingModel.setCashFundReqAmount(req.getParameter(cashFundReqAmount));
    	regCashFundsInfoSavingModel.setUpdatedDate(currentDate);
    	if(null != cashFundRemAmount) {
    		regCashFundsInfoSavingModel.setRemainingAmount(cashFundRemAmount);
    	}
    	registryCashFundsInfoSavingDAO.merge(regCashFundsInfoSavingModel);
    	registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	return mav;
    }
    
    public String cashFundRemainingAmount(String cashFundReqAmount, String cashFundContAmount) {
    	String cashFundRemAmount = null;
    	double cashFundContAmountDb = 0;
    	if(null != cashFundContAmount) {
    		cashFundContAmountDb = Double.parseDouble(cashFundContAmount);
    	}
    	double cashFundReqAmountDb = 0;
    	if(null != cashFundReqAmount) {
    		cashFundReqAmountDb = Double.parseDouble(cashFundReqAmount);
    	}
    	double cashFundRemAmountDb = cashFundReqAmountDb - cashFundContAmountDb;
    	cashFundRemAmount = String.format("%.2f", cashFundRemAmountDb);
    	return cashFundRemAmount;
    }
    
    @Override
    @Transactional
    public ModelAndView regCashFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	    	
    	Timestamp currentDate = currentDate();
    	long regCashFundsInfoSavingId = Long.parseLong(req.getParameter(registryCashFundsId));
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsAddToCartInfoRowCheckingInDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    	if (!regCashFundAddCartRowList.isEmpty()) { 
    		RegistryCashFundsPaymentInfoSaving regCashFundAddCartModel = registryCashFundsPaymentInfoSavingDAO.registryCashFundsAddCartDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    		regCashFundAddCartModel.setContributedCashFundPrice(req.getParameter(contributeAmount));
    		regCashFundAddCartModel.setUpdatedDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.merge(regCashFundAddCartModel);
    	} else {
    		RegistryCashFundsPaymentInfoSaving registryCashFundsPaymentModel = new RegistryCashFundsPaymentInfoSaving();
    		registryCashFundsPaymentModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		registryCashFundsPaymentModel.setRegistryCashFundsInfoSavingId(regCashFundsInfoSavingId);
    		registryCashFundsPaymentModel.setCashFundName(req.getParameter(cashFundsName));
    		registryCashFundsPaymentModel.setContributedCashFundPrice(req.getParameter(contributeAmount));
    		registryCashFundsPaymentModel.setStatus(regCashFundOnlyRef);
    		registryCashFundsPaymentModel.setCreatedDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.save(registryCashFundsPaymentModel);    		
    	}
    	registryTotalCashFundsCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }
    
    public int registryTotalCashFundsCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int registryCashFundsCount = 0;
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsAddCartRowCheckingInDB(registrantUserId);
    	registryCashFundsCount = regCashFundAddCartRowList.size();
        sn.setAttribute(registryCashFundsCountInSn, registryCashFundsCount);        
        return registryCashFundsCount;
    }

    @Override
    @Transactional
    public ModelAndView registryEditCashFundRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(cashFundsName));
    	sn.setAttribute(landingBackRefInSn, req.getParameter(landingBackRef));
    	String imageUrl = cashFundSmallImageUrl + registryCashFundsInfoModel.getCashFundImageUrl();
    	mav = new ModelAndView(registryCashFundsUpdation);
    	mav.addObject(cashFundsMessage, registryCashFundsInfoModel.getCashFundMessage());
    	mav.addObject(cashFundsAmount, registryCashFundsInfoModel.getCashFundReqAmount());   	
    	mav.addObject(cashFundName, req.getParameter(cashFundsName));
    	mav.addObject(cashFundsImgPathDsp, imageUrl);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }
	
    @Override
    @Transactional
    public ModelAndView registryEditACustomFundRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String custCashFundImg = null;
    	String cashFundNames = null;
    	RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(cashFundsName));
    	sn.setAttribute(landingBackRefInSn, req.getParameter(landingBackRef));
    	cashFundNames = registryCashFundsInfoModel.getCashFundName();    	
    	mav = new ModelAndView(registryCustomFundsUpdation);
    	mav.addObject(cashFundsMessage, registryCashFundsInfoModel.getCashFundMessage());
    	mav.addObject(cashFundsAmount, registryCashFundsInfoModel.getCashFundReqAmount());
    	mav.addObject(cashFundNewName, registryCashFundsInfoModel.getCashFundNewName());
    	if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
    		byte[] regUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
    		String custmCashFundImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
    		custCashFundImg = "data:image/jpg;base64," + custmCashFundImg;
    	} else {
    		custCashFundImg = cashFundSmallImageUrl + "10_custom_fund_img.png";
    	}    	
    	mav.addObject(cashFundName, cashFundNames);    	
    	mav.addObject(cashFundsImagePath, custCashFundImg);
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView regCashFundBackRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if((regCashFundBackRef).equals(sn.getAttribute(landingBackRefInSn))) {
    		mav = new ModelAndView(redirectStatus + registryOverview);
    	} else {
    		mav = new ModelAndView(redirectStatus + createCashFunds);
    	}    	
    	return mav;
    }

    @Override
    @Transactional
    public JSONArray jSonCashFundLandingContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn) {
    	regSelectCashFundLandingContributedDataDeleteFromDB(req, sn, regCBCotributedSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }

    public String regSelectCashFundLandingContributedDataDeleteFromDB(HttpServletRequest req, HttpSession sn, String registryCashFundsInfoSavingId) {
    	String regCFContributedData = null;
    	long regCashFundsInfoSavingId = Long.parseLong(registryCashFundsInfoSavingId);
    	List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCashFundsLandingDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    	if (!registryCashFundsInfoList.isEmpty()) {
    		RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsLandingUpdateTableInDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    		registryCashFundsInfoSavingDAO.delete(registryCashFundsInfoModel);
    	}
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCashFundsAddCartInfoCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    	if (!regCashFundAddCartRowList.isEmpty()) { 
    		RegistryCashFundsPaymentInfoSaving regCashFundAddCartModel = registryCashFundsPaymentInfoSavingDAO.registryCashFundsAddCartInfoDeleteFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    		registryCashFundsPaymentInfoSavingDAO.delete(regCashFundAddCartModel);
    	}
    	registryTotalCashFundsCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryCashFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	return regCFContributedData;
    }

    public int registryTotalFundsCombCartCounts(HttpSession sn) {
    	int regTotalFundsCombCount = 0;
    	int registryRoomFundsCount = 0;
    	int registryCashFundCount = 0;
    	int registryCustomFundCount = 0;
    	int regCBContributedCount = 0;
    	int regCBIndividualCount = 0;    	
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
    	regTotalFundsCombCount = registryRoomFundsCount + registryCashFundCount + registryCustomFundCount + regCBContributedCount + regCBIndividualCount;    	
    	return regTotalFundsCombCount;
    }
    
//	Custom Fund Coding
    
    @Override
    @Transactional
    public ModelAndView registryCreateACustomFundRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String cashFundImgPath = null;
    	List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCustomCashFundsDataCheckUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn));
    	if (!registryCashFundsInfoList.isEmpty()) { 
    		RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCustomCashFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn));
    		if(null != registryCashFundsInfoModel.getCashFundName() && (regCustomFundRef).equals(registryCashFundsInfoModel.getCashFundName())) {
    			if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
        			byte[] regUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
        			String custmCashFundImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
        			cashFundImgPath = "data:image/jpg;base64," + custmCashFundImg;
        		} else {
        			cashFundImgPath = cashFundSmallImageUrl + req.getParameter(cashFundImagePath);
        		}        		
        		mav = new ModelAndView(registryCustomFundsUpdation);
        		mav.addObject(cashFundsMessage, registryCashFundsInfoModel.getCashFundMessage());
        		mav.addObject(cashFundsAmount, registryCashFundsInfoModel.getCashFundReqAmount());
        		mav.addObject(customFundName, registryCashFundsInfoModel.getCashFundName());
    		} else {
    			mav = new ModelAndView(registryCustomFundsCreation);
    	    	cashFundImgPath = cashFundSmallImageUrl + req.getParameter(cashFundImagePath);
    	    	mav.addObject(customFundName, req.getParameter(customFundName));
    		}
    	} else {
    		mav = new ModelAndView(registryCustomFundsCreation);
    		cashFundImgPath = cashFundSmallImageUrl + req.getParameter(cashFundImagePath);
    		mav.addObject(customFundName, req.getParameter(customFundName));
    	}
    	mav.addObject(cashFundsImagePath, req.getParameter(cashFundImagePath));
    	mav.addObject(cashFundsImgPathDsp, cashFundImgPath);    	
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	return mav;
    }
     
    @Override
    @Transactional
    public ModelAndView regCustomCashFundsInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	String dnCustomFundName = regCustomFundsNameCheckInDB(req, sn, req.getParameter(customFundName));
    	if((dbCustomNameRef).equals(dnCustomFundName)) {
    		String cashFundImgPath = cashFundSmallImageUrl + req.getParameter(cashFundsImageName);
    		mav = new ModelAndView(registryCustomFundsCreation);
    		mav.addObject(cashFundsImagePath, req.getParameter(cashFundsImageName));
        	mav.addObject(cashFundsImgPathDsp, cashFundImgPath);
        	mav.addObject(customFundName, req.getParameter(customFundOldName));
        	mav.addObject(cashFundsMessage, req.getParameter(cashFundReqMessage));
    		mav.addObject(cashFundsAmount, req.getParameter(cashFundReqAmount));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regCustomFundError, dbCustomNameRef);
    	} else {
	    	RegistryCashFundsInfoSaving regCashFundsInfoSavingModel = new RegistryCashFundsInfoSaving();
	    	String regCFReqMessage = req.getParameter(cashFundReqMessage);
	    	regCFReqMessage = regCFReqMessage.replaceAll("[\n\r]", " ");
	    	regCashFundsInfoSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
	    	regCashFundsInfoSavingModel.setCashFundName(req.getParameter(customFundName));
	    	if(!(regCustomFundRef).equals(req.getParameter(customFundName))) {
	    		regCashFundsInfoSavingModel.setCashFundNewName(regCustomFundOnlyRef);
	    	}
	    	regCashFundsInfoSavingModel.setCashFundMessage(regCFReqMessage);
	    	regCashFundsInfoSavingModel.setCashFundImageUrl(req.getParameter(cashFundsImageName));
	    	regCashFundsInfoSavingModel.setCashFundReqAmount(req.getParameter(cashFundReqAmount));
	    	regCashFundsInfoSavingModel.setCreatedDate(currentDate);
	    	registryCashFundsInfoSavingDAO.save(regCashFundsInfoSavingModel);
	    	registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	mav = new ModelAndView(redirectStatus + registryOverview);
    	}
    	return mav;
    }
    
    public String regCustomFundsNameCheckInDB(HttpServletRequest req, HttpSession sn, String customFundName) {
    	String dnCustomFundName = null;
    	if(!(regCustomFundRef).equals(customFundName)) {
    		List<RegistryCashFundsInfoSaving> registryCashFundsNameList = registryCashFundsInfoSavingDAO.registryCustomCashFundsNameInDB((Long) sn.getAttribute(registrantUserIdInSn), customFundName);
    		if (!registryCashFundsNameList.isEmpty()) {
	    		dnCustomFundName = dbCustomNameRef;
	    	}
    	}
    	return dnCustomFundName;
    }

    @Override
    @Transactional
    public ModelAndView regCustomCashFundsInfoUpdatingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	String dnCustomFundName = regCustomFundsModificatedNameCheckInDB(req, sn, req.getParameter(customFundName), req.getParameter(customFundOldName));    	
    	if((dbCustomNameRef).equals(dnCustomFundName)) {
    		mav = new ModelAndView(registryCustomFundsUpdation);
    		mav.addObject(cashFundsImagePath, req.getParameter(cashFundImagePath));
        	mav.addObject(cashFundsImgPathDsp, req.getParameter(cashFundsImgPathDsp));
        	mav.addObject(customFundName, req.getParameter(customFundOldName));
        	mav.addObject(cashFundsMessage, req.getParameter(cashFundReqMessage));
    		mav.addObject(cashFundsAmount, req.getParameter(cashFundReqAmount));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regCustomFundError, dbCustomNameRef);
    	} else {
	    	RegistryCashFundsInfoSaving regCashFundsInfoSavingModel = registryCashFundsInfoSavingDAO.registryCustomFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(customFundOldName));
	    	String customFundRemAmount = customFundRemainingAmount(req.getParameter(cashFundReqAmount), regCashFundsInfoSavingModel.getTotalContributedAmount());
	    	String regCFReqMessage = req.getParameter(cashFundReqMessage);
	    	regCFReqMessage = regCFReqMessage.replaceAll("[\n\r]", " ");
	    	regCashFundsInfoSavingModel.setCashFundName(req.getParameter(customFundName));
	    	if(!(regCustomFundRef).equals(req.getParameter(customFundName))) {
	    		regCashFundsInfoSavingModel.setCashFundNewName(regCustomFundOnlyRef);
	    	}
	    	if(null != customFundRemAmount) {
	    		regCashFundsInfoSavingModel.setRemainingAmount(customFundRemAmount);
	    	}
	    	regCashFundsInfoSavingModel.setCashFundMessage(regCFReqMessage);
	    	regCashFundsInfoSavingModel.setCashFundReqAmount(req.getParameter(cashFundReqAmount));
	    	regCashFundsInfoSavingModel.setUpdatedDate(currentDate);
	    	registryCashFundsInfoSavingDAO.merge(regCashFundsInfoSavingModel);
	    	registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	mav = new ModelAndView(redirectStatus + registryOverview);
    	}
    	return mav;
    }

    public String customFundRemainingAmount(String customFundsReqAmount, String customFundContAmount) {
    	String customFundRemAmount = null;
    	double customFundContAmountDb = 0;
    	if(null != customFundContAmount) {
    		customFundContAmountDb = Double.parseDouble(customFundContAmount);
    	}
    	double customFundReqAmountDb = 0;
    	if(null != customFundsReqAmount) {
    		customFundReqAmountDb = Double.parseDouble(customFundsReqAmount);
    	}
    	double customFundRemAmountDb = customFundReqAmountDb - customFundContAmountDb;
    	customFundRemAmount = String.format("%.2f", customFundRemAmountDb);
    	return customFundRemAmount;
    }

    public String regCustomFundsModificatedNameCheckInDB(HttpServletRequest req, HttpSession sn, String customFundName, String oldCustomFundName) {
    	String dnCustomFundName = null;
    	if((!(regCustomFundRef).equals(customFundName)) && (!(oldCustomFundName).equals(customFundName))) {    		
    		List<RegistryCashFundsInfoSaving> registryCashFundsNameList = registryCashFundsInfoSavingDAO.registryCustomCashFundsNameInDB((Long) sn.getAttribute(registrantUserIdInSn), customFundName);
    		if (!registryCashFundsNameList.isEmpty()) {	    		
	    		dnCustomFundName = dbCustomNameRef;
	    	}
    	}
    	return dnCustomFundName;
    }
        
    @Override
    @Transactional
    public ModelAndView uploadCustomCashFundImageInDB(MultipartFile cashFundUploadImg, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;
    	String fileName = cashFundUploadImg.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
    	conFile.mkdir();        
        cashFundUploadImg.transferTo(conFile);
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
        List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCustomFundsDataCheckUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(customFundOldName));
    	if (!registryCashFundsInfoList.isEmpty()) {
    		RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCustomFundsUpdateTableUsingFundNameInDB((Long) sn.getAttribute(registrantUserIdInSn), req.getParameter(customFundOldName));    		
    		registryCashFundsInfoModel.setCashFundUploadImage(bFile);
    		registryCashFundsInfoModel.setUpdatedDate(currentDate);
    		registryCashFundsInfoSavingDAO.merge(registryCashFundsInfoModel);
    	} else {
    		RegistryCashFundsInfoSaving regCashFundsInfoSavingModel = new RegistryCashFundsInfoSaving();
    		regCashFundsInfoSavingModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		regCashFundsInfoSavingModel.setCashFundName(req.getParameter(customFundOldName));
    		regCashFundsInfoSavingModel.setCashFundUploadImage(bFile);
    		regCashFundsInfoSavingModel.setCreatedDate(currentDate);
    		registryCashFundsInfoSavingDAO.save(regCashFundsInfoSavingModel);
    	}
    	registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = registryCreateACustomFundRedirection(req, sn);
    	return mav;
    }

    public String registryCustomFundInfoDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId) {
        String cashFundInfo = null;       
        List regCustomFundsIdList = new ArrayList();
        List regCustomFundsImageList = new ArrayList();
        List regCustomFundsNameList = new ArrayList();
		List regCustomFundsPriceList = new ArrayList();
		List regCustomFundsContAmountList = new ArrayList();
		List regCustomFundsRemAmountList = new ArrayList();
		List regCustomFundsMessagesList = new ArrayList();
		List<RegistryCashFundsInfoSaving> registryCashFundsInfoList = registryCashFundsInfoSavingDAO.registryCustomFundsDataTakeFromDB(registrantUserId);
        if (!registryCashFundsInfoList.isEmpty()) {
    		for (RegistryCashFundsInfoSaving registryCashFundsInfoModel : registryCashFundsInfoList) {
	    		regCustomFundsIdList.add(registryCashFundsInfoModel.getRegistryCashFundsInfoSavingId());
	    		String cashFundDBImage = null;
	    		if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
	            	byte[] regCFUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
	            	String cashFundUplImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regCFUploadedImg);
	            	cashFundDBImage = "data:image/jpg;base64," + cashFundUplImg;
	            } else {
	            	cashFundDBImage = cashFundBigImageUrl + registryCashFundsInfoModel.getCashFundImageUrl();
	            }
	    		regCustomFundsImageList.add(cashFundDBImage);
	            regCustomFundsNameList.add(registryCashFundsInfoModel.getCashFundName());
	            regCustomFundsPriceList.add(registryCashFundsInfoModel.getCashFundReqAmount());
	            regCustomFundsContAmountList.add(registryCashFundsInfoModel.getTotalContributedAmount());
	            regCustomFundsRemAmountList.add(registryCashFundsInfoModel.getRemainingAmount());
	            regCustomFundsMessagesList.add(registryCashFundsInfoModel.getCashFundMessage());	            
	    	}
    	}    	   	
    	sn.setAttribute(regCustomFundsIdListInSn, regCustomFundsIdList);    	
    	sn.setAttribute(regCustomFundsImageListInSn, regCustomFundsImageList);
    	sn.setAttribute(regCustomFundsNameListInSn, regCustomFundsNameList);
    	sn.setAttribute(regCustomFundsPriceListInSn, regCustomFundsPriceList);
    	sn.setAttribute(regCustomFundsContAmountListInSn, regCustomFundsContAmountList);
    	sn.setAttribute(regCustomFundsRemAmountListInSn, regCustomFundsRemAmountList);
    	sn.setAttribute(regCustomFundsMessagesListInSn, regCustomFundsMessagesList);
        return cashFundInfo;
    }

    @Override
    @Transactional
    public ModelAndView registryEditCustomFundRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long regCustomFundsId = Long.parseLong(req.getParameter(regCustomFundId));
    	RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsEditedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsId);
    	sn.setAttribute(landingCFBackRefInSn, req.getParameter(landingCFBackRef));
    	String cashFundImgPath = null;
    	if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
			byte[] regUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
			String custmCashFundImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
			cashFundImgPath = "data:image/jpg;base64," + custmCashFundImg;
		} else {
			cashFundImgPath = cashFundSmallImageUrl + registryCashFundsInfoModel.getCashFundImageUrl();
		} 
    	mav = new ModelAndView(registryCustomFundsEditing);
    	mav.addObject(cashFundsImagePath, registryCashFundsInfoModel.getCashFundImageUrl());
    	mav.addObject(cashFundsImgPathDsp, cashFundImgPath);
    	mav.addObject(customFundName, registryCashFundsInfoModel.getCashFundName());
    	mav.addObject(cashFundsMessage, registryCashFundsInfoModel.getCashFundMessage());
		mav.addObject(cashFundsAmount, registryCashFundsInfoModel.getCashFundReqAmount());    	
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regCustomFundId, req.getParameter(regCustomFundId));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView regCustomFundBackRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if((regCustomFundBackRef).equals(sn.getAttribute(landingCFBackRefInSn))) {
    		mav = new ModelAndView(redirectStatus + registryOverview);
    	} else {
    		mav = new ModelAndView(redirectStatus + createCashFunds);
    	}    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView regCustomCashFundDataEditingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long regCustomFundsId = Long.parseLong(req.getParameter(regCustomFundId));
    	String dnCustomFundName = regCustomFundsNameEditCheckInDB(req, sn, req.getParameter(customFundName), req.getParameter(customFundOldName)); 
    	if((dbCustomNameRef).equals(dnCustomFundName)) {
    		mav = new ModelAndView(registryCustomFundsEditing);
    		mav.addObject(cashFundsImagePath, req.getParameter(cashFundImagePath));
        	mav.addObject(cashFundsImgPathDsp, req.getParameter(cashFundsImgPathDsp));
        	mav.addObject(customFundName, req.getParameter(customFundOldName));
        	mav.addObject(cashFundsMessage, req.getParameter(cashFundReqMessage));
    		mav.addObject(cashFundsAmount, req.getParameter(cashFundReqAmount));
        	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
        	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
        	mav.addObject(regCustomFundId, req.getParameter(regCustomFundId));
        	mav.addObject(regCustomFundError, dbCustomNameRef);
    	} else {
    		RegistryCashFundsInfoSaving regCashFundsInfoSavingModel = registryCashFundsInfoSavingDAO.registryCashFundsEditedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsId);
    		String customFundRemAmount = customFundRemainingAmount(req.getParameter(cashFundReqAmount), regCashFundsInfoSavingModel.getTotalContributedAmount());
	    	String regCFReqMessage = req.getParameter(cashFundReqMessage);
	    	regCFReqMessage = regCFReqMessage.replaceAll("[\n\r]", " ");
	    	regCashFundsInfoSavingModel.setCashFundName(req.getParameter(customFundName));
	    	if(!(regCustomFundRef).equals(req.getParameter(customFundName))) {
	    		regCashFundsInfoSavingModel.setCashFundNewName(regCustomFundOnlyRef);
	    	}
	    	if(null != customFundRemAmount) {
	    		regCashFundsInfoSavingModel.setRemainingAmount(customFundRemAmount);
	    	}
	    	regCashFundsInfoSavingModel.setCashFundMessage(regCFReqMessage);
	    	regCashFundsInfoSavingModel.setCashFundReqAmount(req.getParameter(cashFundReqAmount));
	    	regCashFundsInfoSavingModel.setUpdatedDate(currentDate);
	    	registryCashFundsInfoSavingDAO.merge(regCashFundsInfoSavingModel);
	    	registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
	    	mav = new ModelAndView(redirectStatus + registryOverview);
    	}
    	return mav;
    }

    public String regCustomFundsNameEditCheckInDB(HttpServletRequest req, HttpSession sn, String customFundName, String oldCustomFundName) {
    	String dnCustomFundName = null;
    	if(!(oldCustomFundName).equals(customFundName)) {    		
    		List<RegistryCashFundsInfoSaving> registryCashFundsNameList = registryCashFundsInfoSavingDAO.registryCustomCashFundsNameInDB((Long) sn.getAttribute(registrantUserIdInSn), customFundName);
    		if (!registryCashFundsNameList.isEmpty()) {	    		
	    		dnCustomFundName = dbCustomNameRef;
	    	}
    	}
    	return dnCustomFundName;
    }
    
    @Override
    @Transactional
    public ModelAndView landingEditImageUploadCustomFundInDB(MultipartFile cashFundUploadImg, HttpServletRequest req, HttpSession sn) throws Exception {
    	ModelAndView mav;
    	long regCustomFundsId = Long.parseLong(req.getParameter(regCustomFundId));
    	String fileName = cashFundUploadImg.getOriginalFilename();
    	String filepath = uploadImgPath + fileName;
    	File conFile = new File(filepath);
    	conFile.mkdir();        
        cashFundUploadImg.transferTo(conFile);
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
        RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsEditedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsId);    		
    	registryCashFundsInfoModel.setCashFundUploadImage(bFile);
    	registryCashFundsInfoModel.setUpdatedDate(currentDate);
    	registryCashFundsInfoSavingDAO.merge(registryCashFundsInfoModel);
    	registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = registryEditUploadedCustomFundRedirection(req, sn, regCustomFundsId);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView registryEditUploadedCustomFundRedirection(HttpServletRequest req, HttpSession sn, long regCustomFundsId) {
    	ModelAndView mav;
    	RegistryCashFundsInfoSaving registryCashFundsInfoModel = registryCashFundsInfoSavingDAO.registryCashFundsEditedDataTakeFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsId);
    	String cashFundImgPath = null;
    	if(null != registryCashFundsInfoModel.getCashFundUploadImage()) {
			byte[] regUploadedImg = registryCashFundsInfoModel.getCashFundUploadImage();
			String custmCashFundImg = javax.xml.bind.DatatypeConverter.printBase64Binary(regUploadedImg);
			cashFundImgPath = "data:image/jpg;base64," + custmCashFundImg;
		} else {
			cashFundImgPath = cashFundSmallImageUrl + registryCashFundsInfoModel.getCashFundImageUrl();
		} 
    	mav = new ModelAndView(registryCustomFundsEditing);
    	mav.addObject(cashFundsImagePath, registryCashFundsInfoModel.getCashFundImageUrl());
    	mav.addObject(cashFundsImgPathDsp, cashFundImgPath);
    	mav.addObject(customFundName, registryCashFundsInfoModel.getCashFundName());
    	mav.addObject(cashFundsMessage, registryCashFundsInfoModel.getCashFundMessage());
		mav.addObject(cashFundsAmount, registryCashFundsInfoModel.getCashFundReqAmount());    	
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regCustomFundId, req.getParameter(regCustomFundId));
    	return mav;
    }

    @Override
    @Transactional
    public JSONArray jSonCustomFundLandingContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn) {
    	regSelectCustomFundLandingContributedDataDeleteFromDB(req, sn, regCBCotributedSavingId);
    	int regTotalCartCount = registryTotalFundsCombCartCounts(sn);
    	sn.setAttribute(regiCartCountInSn, regTotalCartCount);
    	sn.setAttribute(regTotalCartItems, regTotalCartCount);
    	JSONArray coneptBoardJson = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, regTotalCartCount);
        coneptBoardJson.add(jsonObj);
        return coneptBoardJson;
    }

    public String regSelectCustomFundLandingContributedDataDeleteFromDB(HttpServletRequest req, HttpSession sn, String registryCustomFundsInfoSavingId) {
    	String regCFContributedData = null;
    	long regCustomFundsInfoSavingId = Long.parseLong(registryCustomFundsInfoSavingId);
    	List<RegistryCashFundsInfoSaving> registryCustomFundsInfoList = registryCashFundsInfoSavingDAO.registryCustomFundsLandingDataCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsInfoSavingId);
    	if (!registryCustomFundsInfoList.isEmpty()) {
    		RegistryCashFundsInfoSaving registryCustomFundsInfoModel = registryCashFundsInfoSavingDAO.registryCustomFundsLandingUpdateTableInDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsInfoSavingId);
    		registryCashFundsInfoSavingDAO.delete(registryCustomFundsInfoModel);
    	}
    	List<RegistryCashFundsPaymentInfoSaving> regCustomFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCustomFundsAddCartInfoCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsInfoSavingId);
    	if (!regCustomFundAddCartRowList.isEmpty()) { 
    		RegistryCashFundsPaymentInfoSaving regCustomFundAddCartModel = registryCashFundsPaymentInfoSavingDAO.registryCustomFundsAddCartInfoDeleteFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCustomFundsInfoSavingId);
    		registryCashFundsPaymentInfoSavingDAO.delete(regCustomFundAddCartModel);
    	}
    	registryTotalCustomFundsCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	registryCustomFundInfoDisplay(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	return regCFContributedData;
    }

    @Override
    @Transactional
    public ModelAndView regCustomFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	    	
    	Timestamp currentDate = currentDate();
    	long regCashFundsInfoSavingId = Long.parseLong(req.getParameter(registryCashFundsId));
    	List<RegistryCashFundsPaymentInfoSaving> regCashFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCustomFundsAddCartInfoCheckInDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);    	
    	if (!regCashFundAddCartRowList.isEmpty()) { 
    		RegistryCashFundsPaymentInfoSaving regCashFundAddCartModel = registryCashFundsPaymentInfoSavingDAO.registryCustomFundsAddCartInfoDeleteFromDB((Long) sn.getAttribute(registrantUserIdInSn), regCashFundsInfoSavingId);
    		regCashFundAddCartModel.setContributedCashFundPrice(req.getParameter(contributeAmount));
    		regCashFundAddCartModel.setUpdatedDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.merge(regCashFundAddCartModel);
    	} else {
    		RegistryCashFundsPaymentInfoSaving registryCashFundsPaymentModel = new RegistryCashFundsPaymentInfoSaving();
    		registryCashFundsPaymentModel.setRegistrantUserId((Long) sn.getAttribute(registrantUserIdInSn));
    		registryCashFundsPaymentModel.setRegistryCashFundsInfoSavingId(regCashFundsInfoSavingId);
    		registryCashFundsPaymentModel.setCashFundName(req.getParameter(cashFundsName));
    		registryCashFundsPaymentModel.setContributedCashFundPrice(req.getParameter(contributeAmount));
    		registryCashFundsPaymentModel.setStatus(regCustomFundOnlyRef);
    		registryCashFundsPaymentModel.setCreatedDate(currentDate);
    		registryCashFundsPaymentInfoSavingDAO.save(registryCashFundsPaymentModel);    		
    	}
    	registryTotalCustomFundsCartCount(req, sn, (Long) sn.getAttribute(registrantUserIdInSn));
    	mav = new ModelAndView(redirectStatus + registryOverview);
    	mav.addObject(regTotalCartItems, sn.getAttribute(regiCartCountInSn));
    	mav.addObject(regFirstNames, sn.getAttribute(regFirstNamesInSn));
    	return mav;
    }

    public int registryTotalCustomFundsCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId) {
    	int registryCustomFundsCount = 0;
    	List<RegistryCashFundsPaymentInfoSaving> regCustomFundAddCartRowList = registryCashFundsPaymentInfoSavingDAO.registryCustomFundsAddCartRowCheckingInDB(registrantUserId);
    	registryCustomFundsCount = regCustomFundAddCartRowList.size();
        sn.setAttribute(registryCustomFundsCountInSn, registryCustomFundsCount);        
        return registryCustomFundsCount;
    }
   

	@Override
	@Transactional
	public Timestamp currentDate() { 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}

}