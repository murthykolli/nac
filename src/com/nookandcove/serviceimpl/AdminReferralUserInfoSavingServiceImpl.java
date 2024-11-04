package com.nookandcove.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import com.nookandcove.dao.GuestUserPaymentInfoSavingDAO;
import com.nookandcove.dao.ReferralNookAndCoveStoreCreditInfoSavingDAO;
import com.nookandcove.dao.ReferralVisaCustomGiftCardInfoSavingDAO;
import com.nookandcove.dao.ReferralVisaGiftCardsInfoSavingDAO;
import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.dao.RegistrantPaymentInfoSavingDAO;
import com.nookandcove.dao.ShopReferralUsersInfoSavingDAO;
import com.nookandcove.model.GuestUserPaymentInfoSaving;
import com.nookandcove.model.ReferralNookAndCoveStoreCreditInfoSaving;
import com.nookandcove.model.ReferralVisaCustomGiftCardInfoSaving;
import com.nookandcove.model.ReferralVisaGiftCardsInfoSaving;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.RegistrantPaymentInfoSaving;
import com.nookandcove.model.ShopReferralUsersInfoSaving;
import com.nookandcove.service.AdminReferralUserInfoSavingService;

//@SuppressWarnings({"rawtypes", "unchecked"})
@SuppressWarnings({"unchecked"})
@Service
public class AdminReferralUserInfoSavingServiceImpl implements AdminReferralUserInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminReferralUserInfoSavingServiceImpl.class);	
	
	private String firstNamesInSn = "firstNameInSn";
	private String flName = "flName";	
	private String refVisibleStatus = "Data Visible";
	private String refrDataVisibleStatus = "refrDataVisibleStatus";
	private String adminNewApplicantsCount = "adminNewApplicantsCount";
	private String adminCurrentVendorsCount = "adminCurrentVendorsCount";
	private String adminVisaGiftCardsCount = "adminVisaGiftCardsCount";
	private String referralUserId = "referralUserId";
	private String redirectStatus = "redirect:";
	
	private String referralFirstName = "referralFirstName";
	private String referralLastName = "referralLastName";
	private String referralBusinessName = "referralBusinessName";
	private String referralWebsite = "referralWebsite";
	private String referralSocialMediaInfo = "referralSocialMediaInfo";
	private String referralUserEmail = "referralUserEmail";
	private String referralPhoneNumber = "referralPhoneNumber";
	private String vendorCategory = "vendorCategory";
	private String otherCategory = "otherCategory";
	private String passwordSaltFormat = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
	private String adminReferralNote = "adminReferralNote";
	private String currentApplicantsRef = "currentApplicantsRef";
	
	private String adminNewApplicantsDataDisplay = "adminNewApplicantsDataDisplay";
	private String adminCurrentVendorsDataDisplay = "adminCurrentVendorsDataDisplay";
	private String adminViewNewApplicantsInfoDisplay = "adminViewNewApplicantsInfoDisplay";
	private String adminVisaGiftCardsDisplay = "adminVisaGiftCardsDisplay";
	private String adminIssuedVisaGiftCardsDisplay = "adminIssuedVisaGiftCardsDisplay";
	private String adminNewVisaGiftCardsCount = "adminNewVisaGiftCardsCount";
	private String adminIssuedVisaGiftCardsCount = "adminIssuedVisaGiftCardsCount";
	private String refIssuedReff = "Issued";
	
	

	@Autowired
    private ShopReferralUsersInfoSavingDAO shopReferralUsersInfoSavingDAO;

	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;

	@Autowired
    private ReferralNookAndCoveStoreCreditInfoSavingDAO referralNookAndCoveStoreCreditInfoSavingDAO;

	@Autowired
    private ReferralVisaGiftCardsInfoSavingDAO referralVisaGiftCardsInfoSavingDAO;

    @Autowired
    private RegistrantPaymentInfoSavingDAO registrantPaymentInfoSavingDAO;

	@Autowired
    private GuestUserPaymentInfoSavingDAO guestUserPaymentInfoSavingDAO;

	@Autowired
    private ReferralVisaCustomGiftCardInfoSavingDAO referralVisaCustomGiftCardInfoSavingDAO;
	
	
			
	public String mD5Encrypt(String password) {
    	String forPassword = password;
        try {        	
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            forPassword = sb.toString();
        } catch (NoSuchAlgorithmException exception) {
        	LOGGER.error("mD5Encrypt " + exception);
        }
        return forPassword;
    }

    @Override
    @Transactional
    public ModelAndView adminNewApplicantsDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ShopReferralUsersInfoSaving> adminRefNewApplicantsList = shopReferralUsersInfoSavingDAO.adminReferralNewApplicantsDataCheckInDB();    	
    	List<ReferralVisaCustomGiftCardInfoSaving> referralVisaTotalCountList = referralVisaCustomGiftCardInfoSavingDAO.adminReferralGiftCardsTotalCountDisplay();
    	List<ShopReferralUsersInfoSaving> adminRefCurrVendorsList = shopReferralUsersInfoSavingDAO.adminReferralCurrentVendorsDataCheckInDB();
    	if (!adminRefNewApplicantsList.isEmpty()) {        	
            List<ShopReferralUsersInfoSaving> shopReferralUsersInfoSavingList = new ArrayList<ShopReferralUsersInfoSaving>();
            for (ShopReferralUsersInfoSaving shopReferralUsersInfoLoop : adminRefNewApplicantsList) {
            	ShopReferralUsersInfoSaving shopReferralInfoSavingModel = new ShopReferralUsersInfoSaving();
            	String fullRefName = shopReferralUsersInfoLoop.getReferralFirstName() + " " + shopReferralUsersInfoLoop.getReferralLastName();
            	shopReferralInfoSavingModel.setReferralUserId(shopReferralUsersInfoLoop.getReferralUserId());
            	shopReferralInfoSavingModel.setCreatedDate(shopReferralUsersInfoLoop.getCreatedDate());
            	shopReferralInfoSavingModel.setReferralFirstName(fullRefName);            	            	
            	shopReferralUsersInfoSavingList.add(shopReferralInfoSavingModel);
            }            
            mav = new ModelAndView(adminNewApplicantsDataDisplay);
            mav.addObject("adminNewApplicantsInfoSavingList", shopReferralUsersInfoSavingList);            
            mav.addObject(refrDataVisibleStatus, refVisibleStatus);
        } else{
        	mav = new ModelAndView(adminNewApplicantsDataDisplay);            
        }    	
    	mav.addObject(adminNewApplicantsCount, adminRefNewApplicantsList.size());
    	mav.addObject(adminCurrentVendorsCount, adminRefCurrVendorsList.size());
    	mav.addObject(adminVisaGiftCardsCount, referralVisaTotalCountList.size());
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewNewApplicantsInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);    	            
        mav = new ModelAndView(adminViewNewApplicantsInfoDisplay);        
        mav.addObject(referralUserEmail, shopReferralUsersInfoModel.getReferralUserEmail());
        mav.addObject(referralFirstName, shopReferralUsersInfoModel.getReferralFirstName());
        mav.addObject(referralLastName, shopReferralUsersInfoModel.getReferralLastName());
        mav.addObject(referralBusinessName, shopReferralUsersInfoModel.getReferralBusinessName());
        mav.addObject(referralWebsite, shopReferralUsersInfoModel.getReferralWebsite());
        mav.addObject(referralSocialMediaInfo, shopReferralUsersInfoModel.getReferralSocialMediaInfo());            
        mav.addObject(referralPhoneNumber, shopReferralUsersInfoModel.getReferralPhoneNumber());
        mav.addObject(vendorCategory, shopReferralUsersInfoModel.getVendorCategory());
        mav.addObject(otherCategory, shopReferralUsersInfoModel.getOtherCategory());
        mav.addObject(adminReferralNote, shopReferralUsersInfoModel.getAdminReferralNote());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(referralUserId, req.getParameter(referralUserId));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminApproveToReferralUserAccountAccess(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	String generatedPassword = systemGenarateUniqueRefferalPassword();
    	String referralFullName = shopReferralUsersInfoModel.getReferralFirstName() + " " + shopReferralUsersInfoModel.getReferralLastName();
        String encrypPassword = mD5Encrypt(generatedPassword);
        String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
        shopReferralUsersInfoModel.setReferralPassword(encrypPassword);
        shopReferralUsersInfoModel.setPasswordSalt(passwordSalt);
        shopReferralUsersInfoModel.setLastPasswordChangedDate(currentDate);
        shopReferralUsersInfoModel.setUpdatedDate(currentDate);
        shopReferralUsersInfoSavingDAO.merge(shopReferralUsersInfoModel);        
        adminSentPasswordToRefferalUserEmail(generatedPassword, referralFullName, shopReferralUsersInfoModel.getReferralUserEmail());
    	mav = new ModelAndView(adminViewNewApplicantsInfoDisplay);
        mav.addObject(referralUserEmail, shopReferralUsersInfoModel.getReferralUserEmail());
        mav.addObject(referralFirstName, shopReferralUsersInfoModel.getReferralFirstName());
        mav.addObject(referralLastName, shopReferralUsersInfoModel.getReferralLastName());
        mav.addObject(referralBusinessName, shopReferralUsersInfoModel.getReferralBusinessName());
        mav.addObject(referralWebsite, shopReferralUsersInfoModel.getReferralWebsite());
        mav.addObject(referralSocialMediaInfo, shopReferralUsersInfoModel.getReferralSocialMediaInfo());            
        mav.addObject(referralPhoneNumber, shopReferralUsersInfoModel.getReferralPhoneNumber());
        mav.addObject(vendorCategory, shopReferralUsersInfoModel.getVendorCategory());
        mav.addObject(otherCategory, shopReferralUsersInfoModel.getOtherCategory());
        mav.addObject(adminReferralNote, shopReferralUsersInfoModel.getAdminReferralNote());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(referralUserId, req.getParameter(referralUserId));
        mav.addObject("adminApprovalRef", "Admin Approved");
    	return mav;
    }    
   
    public String adminSentPasswordToRefferalUserEmail(String generatedPassword, String referralFullName, String referralUsersEmail) {
    	String emailSendToRefUser = null;
    	EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";                    
        String aTo = referralUsersEmail;
        String aSubject = "Welcome to the Nook+Cove Referral Program!";
        String type = "text/html";
        String body = "<body>" 
                    + "<div style='padding: 10px; min-width: 200px; width: auto; min-height: 300px; height: auto; letter-spacing: 0px; font: 1.15em/1.5em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 15px;'>Hello &nbsp;" + referralFullName + ", </p>"
                    + "<p style='padding-top: 15px;'>Welcome to the Nook+Cove Referral Program! We are excited to have you as a part of our innovative and fast-growing program!</p>"
                    + "<p style='padding-top: 15px;'>As a member of our referral program, you can now access your vendor account on the website, by logging in with your email and password. Please use the email you entered in your application and the temporary password provided below to login to your account. You will be able to change your password once you login. You can login to your Referral Program Account by clicking on the 'Referral Program' tab found in the footer of the website at <a href='#' style='color: black; cursor: auto; text-decoration: none;'>www.nookandcove.com</a> or by clicking <a href='https://nookandcove.com/referralUserLogin' style='color: #0070c0; cursor: pointer; text-decoration: underline;'>here.</a></p>"
                    + "<p style='padding-top: 15px; font-weight: bold;'>Temporary Password: <font style='color: #0070c0;'>" + generatedPassword + "</p>"
                    + "<p style='padding-top: 15px;'>We will be sending out a welcome package to you shortly. As a part of the package, you will receive cards for you to distribute to your clients with information regarding Nook+Cove’s Registry. Before giving the card to a client please fill out the back of the card with your unique referral code so that your client can enter it when they register with us, enabling you to track their registry progress via your account. Once you log in to your account, you can find your unique referral code in the My Account dashboard under the 'My Referral Code' tab.</p>"
                    + "<p style='padding-top: 15px;'>Please reach out to us at <a href='#' style='color: black; cursor: auto; text-decoration: none;'>hello@nookandcove.com</a> with any questions that you may have about the referral program or if you would like to schedule a quick informative virtual session regarding the program.</p>"
                    + "<p style='padding-top: 15px;'>We look forward to working with you and growing together!</p>"                    
                    + "<p style='padding-top: 15px;'>Sincerely,</p>"
                    + "<p style='padding-top: 10px;'>The Nook+Cove Team</p> <br/>"
                    + "</div>"
                    + "</body> "; 
        try {
        	userEmail.sendEmail(aTo, aSubject, body, type, fromAdd);
        } catch (Exception ex) {
          	LOGGER.error("genarated password to access account " + ex);
        }           
        return emailSendToRefUser;
    }
    
    public String systemGenarateUniqueRefferalPassword() {
	    String alphaNumerics = "ab1c!de2fgh3$ijk4mn5&pq6#rst7*uv8wx9yz0";
	    String uniqueRefferalPassword = "";
	    for (int i = 0; i < 9; i++) {
	    	uniqueRefferalPassword += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }
	    return uniqueRefferalPassword;
    }

    @Override
    @Transactional
    public ModelAndView adminDonotApproveToReferralUserAccountAccess(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
//    	Timestamp currentDate = currentDate();
//    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
//    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);    	
//        shopReferralUsersInfoModel.setReferralPassword(null);
//        shopReferralUsersInfoModel.setPasswordSalt(null);
//        shopReferralUsersInfoModel.setLastPasswordChangedDate(currentDate);
//        shopReferralUsersInfoModel.setUpdatedDate(currentDate);
//        shopReferralUsersInfoSavingDAO.merge(shopReferralUsersInfoModel);
    	mav = new ModelAndView("adminNoteInfoPageDisplay");        
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(referralUserId, req.getParameter(referralUserId));        
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminNoteInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	String adminRefNote = req.getParameter(adminReferralNote);    	
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	if(!("").equals(adminRefNote) && null != adminRefNote) {
    		String adminRefrNote = adminRefNote.replaceAll("[\n\r]", " ");
    		shopReferralUsersInfoModel.setAdminReferralNote(adminRefrNote);
    		shopReferralUsersInfoModel.setUpdatedDate(currentDate);
            shopReferralUsersInfoSavingDAO.merge(shopReferralUsersInfoModel);
    	}                
        mav = new ModelAndView(adminViewNewApplicantsInfoDisplay);
        mav.addObject(referralUserEmail, shopReferralUsersInfoModel.getReferralUserEmail());
        mav.addObject(referralFirstName, shopReferralUsersInfoModel.getReferralFirstName());
        mav.addObject(referralLastName, shopReferralUsersInfoModel.getReferralLastName());
        mav.addObject(referralBusinessName, shopReferralUsersInfoModel.getReferralBusinessName());
        mav.addObject(referralWebsite, shopReferralUsersInfoModel.getReferralWebsite());
        mav.addObject(referralSocialMediaInfo, shopReferralUsersInfoModel.getReferralSocialMediaInfo());            
        mav.addObject(referralPhoneNumber, shopReferralUsersInfoModel.getReferralPhoneNumber());
        mav.addObject(vendorCategory, shopReferralUsersInfoModel.getVendorCategory());
        mav.addObject(otherCategory, shopReferralUsersInfoModel.getOtherCategory());
        mav.addObject(adminReferralNote, shopReferralUsersInfoModel.getAdminReferralNote());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(referralUserId, req.getParameter(referralUserId));
        mav.addObject("adminDonotApprovalRef", "Admin Donot Approved");
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewNoteReferralInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);    	              
        mav = new ModelAndView("adminViewNoteInfoDisplay");
        mav.addObject(adminReferralNote, shopReferralUsersInfoModel.getAdminReferralNote());        
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(referralUserId, req.getParameter(referralUserId));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminDeleteReferralUserInfoDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	shopReferralUsersInfoSavingDAO.delete(shopReferralUsersInfoModel);
    	mav = new ModelAndView(redirectStatus + "adminNewApplicants");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewNoteInfoBackMoveRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	mav = new ModelAndView(adminViewNewApplicantsInfoDisplay);
        mav.addObject(referralUserEmail, shopReferralUsersInfoModel.getReferralUserEmail());
        mav.addObject(referralFirstName, shopReferralUsersInfoModel.getReferralFirstName());
        mav.addObject(referralLastName, shopReferralUsersInfoModel.getReferralLastName());
        mav.addObject(referralBusinessName, shopReferralUsersInfoModel.getReferralBusinessName());
        mav.addObject(referralWebsite, shopReferralUsersInfoModel.getReferralWebsite());
        mav.addObject(referralSocialMediaInfo, shopReferralUsersInfoModel.getReferralSocialMediaInfo());            
        mav.addObject(referralPhoneNumber, shopReferralUsersInfoModel.getReferralPhoneNumber());
        mav.addObject(vendorCategory, shopReferralUsersInfoModel.getVendorCategory());
        mav.addObject(otherCategory, shopReferralUsersInfoModel.getOtherCategory());
        mav.addObject(adminReferralNote, shopReferralUsersInfoModel.getAdminReferralNote());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));
        mav.addObject(referralUserId, req.getParameter(referralUserId));
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminCurrentVendorsDataDisplay(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ShopReferralUsersInfoSaving> adminRefNewApplicantsList = shopReferralUsersInfoSavingDAO.adminReferralNewApplicantsDataCheckInDB();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralVisaTotalCountList = referralVisaCustomGiftCardInfoSavingDAO.adminReferralGiftCardsTotalCountDisplay();
    	List<ShopReferralUsersInfoSaving> adminRefCurrVendorsList = shopReferralUsersInfoSavingDAO.adminReferralCurrentVendorsDataCheckInDB();
    	if (!adminRefCurrVendorsList.isEmpty()) {        	
            List<ShopReferralUsersInfoSaving> shopReferralUsersInfoSavingList = new ArrayList<ShopReferralUsersInfoSaving>();
            for (ShopReferralUsersInfoSaving shopReferralUsersInfoLoop : adminRefCurrVendorsList) {
            	ShopReferralUsersInfoSaving shopReferralInfoSavingModel = new ShopReferralUsersInfoSaving();
            	String fullRefName = shopReferralUsersInfoLoop.getReferralFirstName() + " " + shopReferralUsersInfoLoop.getReferralLastName();
            	shopReferralInfoSavingModel.setReferralUserId(shopReferralUsersInfoLoop.getReferralUserId());
            	shopReferralInfoSavingModel.setCreatedDate(shopReferralUsersInfoLoop.getCreatedDate());
            	shopReferralInfoSavingModel.setReferralFirstName(fullRefName);
            	shopReferralInfoSavingModel.setReferralCouponCode(shopReferralUsersInfoLoop.getReferralCouponCode());
            	shopReferralInfoSavingModel.setWpStatus(shopReferralUsersInfoLoop.getWpStatus());
            	String referralCodeSt = shopReferralUsersInfoLoop.getReferralCouponCode();
            	String refNumberOfClients = adminReferralNumberOfClients(referralCodeSt);
            	shopReferralInfoSavingModel.setReferralLastName(refNumberOfClients);
            	shopReferralUsersInfoSavingList.add(shopReferralInfoSavingModel);
            }            
            mav = new ModelAndView(adminCurrentVendorsDataDisplay);
            mav.addObject("adminCurrentVendorsInfoSavingList", shopReferralUsersInfoSavingList);            
            mav.addObject(refrDataVisibleStatus, refVisibleStatus);
        } else{
        	mav = new ModelAndView(adminCurrentVendorsDataDisplay);            
        }
    	mav.addObject(adminNewApplicantsCount, adminRefNewApplicantsList.size());
    	mav.addObject(adminCurrentVendorsCount, adminRefCurrVendorsList.size());
    	mav.addObject(adminVisaGiftCardsCount, referralVisaTotalCountList.size());
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
    
    public String adminReferralNumberOfClients(String uniqueRefCode) {
    	String refNumberOfClients = "0";
    	List<RegistrantInformationSaving> registrantUserInfoList = registrantInformationSavingDAO.registrantUserIdsListCheckUsingUniqueRefCode(uniqueRefCode);
    	if (!registrantUserInfoList.isEmpty()) {
    		int clientsCount = registrantUserInfoList.size();
    		refNumberOfClients = Integer.toString(clientsCount);
    	}
    	return refNumberOfClients;    	
    }

    @Override
    @Transactional
    public ModelAndView adminCurrentApplicantsInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long adminReferralUsersId = Long.parseLong(req.getParameter(referralUserId));
    	if(("View Vendor Details").equals(req.getParameter(currentApplicantsRef))) {
    		mav = adminViewVendorDetailsDisplayRedirection(req, sn, adminReferralUsersId);
    	} else if(("View WP Sent").equals(req.getParameter(currentApplicantsRef))) {
    		mav = adminViewWPSentDetailsRedirection(req, sn, adminReferralUsersId);
    	} else {
			mav = adminViewVendorClientsDetailsRedirection(req, sn, adminReferralUsersId);
		}
    	mav.addObject(referralUserId, req.getParameter(referralUserId));
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminViewVendorDetailsDisplayRedirection(HttpServletRequest req, HttpSession sn, long adminReferralUsersId) {
    	ModelAndView mav;
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	mav = new ModelAndView("adminViewVendorDetailsDisplay");
        mav.addObject(referralUserEmail, shopReferralUsersInfoModel.getReferralUserEmail());
        mav.addObject(referralFirstName, shopReferralUsersInfoModel.getReferralFirstName());
        mav.addObject(referralLastName, shopReferralUsersInfoModel.getReferralLastName());
        mav.addObject(referralBusinessName, shopReferralUsersInfoModel.getReferralBusinessName());
        mav.addObject(referralWebsite, shopReferralUsersInfoModel.getReferralWebsite());
        mav.addObject(referralSocialMediaInfo, shopReferralUsersInfoModel.getReferralSocialMediaInfo());            
        mav.addObject(referralPhoneNumber, shopReferralUsersInfoModel.getReferralPhoneNumber());
        mav.addObject(vendorCategory, shopReferralUsersInfoModel.getVendorCategory());
        mav.addObject(otherCategory, shopReferralUsersInfoModel.getOtherCategory());
        mav.addObject(adminReferralNote, shopReferralUsersInfoModel.getAdminReferralNote());
        mav.addObject(flName, sn.getAttribute(firstNamesInSn));        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewWPSentDetailsRedirection(HttpServletRequest req, HttpSession sn, long adminReferralUsersId) {
    	ModelAndView mav;
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	shopReferralUsersInfoModel.setWpStatus("Yes");
    	shopReferralUsersInfoSavingDAO.merge(shopReferralUsersInfoModel);
    	mav = adminCurrentVendorsDataDisplay(req, sn);
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView adminViewVendorClientsDetailsRedirection(HttpServletRequest req, HttpSession sn, long adminReferralUsersId) {
    	ModelAndView mav;
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(adminReferralUsersId);
    	String totalNookAndCovePrice = totalNookAndCovePrice(shopReferralUsersInfoModel.getReferralUserId());
    	String totalVisaCardPrice = totalVisaCardPrice(shopReferralUsersInfoModel.getReferralUserId());
    	String referralUserName = shopReferralUsersInfoModel.getReferralFirstName() + " " + shopReferralUsersInfoModel.getReferralLastName();
    	List<RegistrantInformationSaving> registrantUserInfoList = registrantInformationSavingDAO.registrantUserIdsListCheckUsingUniqueRefCode(shopReferralUsersInfoModel.getReferralCouponCode());
    	if (!registrantUserInfoList.isEmpty()) {        	
            List<RegistrantInformationSaving> regInformationSavingList = new ArrayList<RegistrantInformationSaving>();
            for (RegistrantInformationSaving shopReferralUsersInfoLoop : registrantUserInfoList) {
            	RegistrantInformationSaving registrantInformationModel = new RegistrantInformationSaving();
            	String registrantFullName = shopReferralUsersInfoLoop.getRegFirstName() + " " + shopReferralUsersInfoLoop.getRegLastName();
            	registrantInformationModel.setRegFirstName(registrantFullName);
            	registrantInformationModel.setCreatedDate(shopReferralUsersInfoLoop.getCreatedDate());
            	registrantInformationModel.setRegistrantUserId(shopReferralUsersInfoLoop.getRegistrantUserId());
            	String refTypeOfRewardName = typeOfReferralRewardInfo(shopReferralUsersInfoModel.getReferralUserId(), shopReferralUsersInfoLoop.getRegistrantUserId());
            	registrantInformationModel.setCoRegFirstName(refTypeOfRewardName);
            	regInformationSavingList.add(registrantInformationModel);
            }           
            mav = new ModelAndView("adminViewVendorClientsDisplay");
            mav.addObject("adminViewVendorClientsInfoSavingList", regInformationSavingList);
            mav.addObject("adminViewVendorClientsCount", registrantUserInfoList.size());
            mav.addObject(refrDataVisibleStatus, refVisibleStatus);
            mav.addObject("totalNookAndCoveAmount", totalNookAndCovePrice);
            mav.addObject("totalVisaCardAmount", totalVisaCardPrice);
            mav.addObject("referralUserFullName", referralUserName);
        } else{
        	mav = adminCurrentVendorsDataDisplay(req, sn);
        	mav.addObject("vendorClientsRef", "Vendor Clients");
        }
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    public String typeOfReferralRewardInfo(long referralUsersId, long registrantUsersId) {
    	String refTypeOfRewardName = null;
    	List<ReferralNookAndCoveStoreCreditInfoSaving> referralRewardClientsInfoList = referralNookAndCoveStoreCreditInfoSavingDAO.selectedReferralRewardClientsInfoVerification(referralUsersId, registrantUsersId);
    	List<ReferralVisaGiftCardsInfoSaving> referralVisaGiftCardsInfoList = referralVisaGiftCardsInfoSavingDAO.selectedReferralVisaGiftCardsInfoVerification(referralUsersId, registrantUsersId);
    	double registrantUserPrice = registrantUserTotalPrice(registrantUsersId);
		double guestUserPrice = guestUserTotalPrice(registrantUsersId);
		double totalrefferalPrice = registrantUserPrice + guestUserPrice;
    	if ((!referralRewardClientsInfoList.isEmpty()) && (referralVisaGiftCardsInfoList.isEmpty())) {    		
    		refTypeOfRewardName = "N+C Credit";
    	} else if ((referralRewardClientsInfoList.isEmpty()) && (!referralVisaGiftCardsInfoList.isEmpty())) { 
    		refTypeOfRewardName = "Visa";
    	} else {
    		if(totalrefferalPrice >= 3500) {
    			refTypeOfRewardName = "Not Selected";
    		} else {
    			refTypeOfRewardName = "Disabled";
    		}
    	}
	    return refTypeOfRewardName;
    }

    public double registrantUserTotalPrice(long registrantUserId) {
    	double registrantUserPrice = 0;
    	List<RegistrantPaymentInfoSaving> registrantPaymentInfoList = registrantPaymentInfoSavingDAO.registrantUserPaymentCheckUsingUniqueRefCode(registrantUserId);
    	if (!registrantPaymentInfoList.isEmpty()) {    		
    		for (RegistrantPaymentInfoSaving regPaymentInfoSavingModel : registrantPaymentInfoList) {
    			if(null != regPaymentInfoSavingModel.getConceptBoardsPrice()) {
    				double registrantCBPriceDb = Double.parseDouble(regPaymentInfoSavingModel.getConceptBoardsPrice());
    				registrantUserPrice = registrantUserPrice + registrantCBPriceDb;
    			}
    		}
    	}    		
	    return registrantUserPrice;
    }

    public double guestUserTotalPrice(long registrantUserId) {
    	double guestUserPrice = 0;
    	List<GuestUserPaymentInfoSaving> guestPaymentInfoList = guestUserPaymentInfoSavingDAO.guestUserPaymentCheckUsingUniqueRefCode(registrantUserId);
    	if (!guestPaymentInfoList.isEmpty()) {    		
    		for (GuestUserPaymentInfoSaving guestPaymentInfoSavingModel : guestPaymentInfoList) {
    			if(null != guestPaymentInfoSavingModel.getConceptBoardsPrice()) {
    				double guestCBPriceDb = Double.parseDouble(guestPaymentInfoSavingModel.getConceptBoardsPrice());
    				guestUserPrice = guestUserPrice + guestCBPriceDb;
    			}
    			if(null != guestPaymentInfoSavingModel.getRoomFundsPrice()) {
    				double guestRoomFundPriceDb = Double.parseDouble(guestPaymentInfoSavingModel.getRoomFundsPrice());
    				guestUserPrice = guestUserPrice + guestRoomFundPriceDb;
    			}
    		}
    	}    		
	    return guestUserPrice;
    }

    public String totalNookAndCovePrice(long referralUsersId) {
    	String totalNookAndCovePrice = null;
    	List<ReferralNookAndCoveStoreCreditInfoSaving> referralRewardClientsInfoList = referralNookAndCoveStoreCreditInfoSavingDAO.selectedReferralRewardNookAndCoveCreditWithId(referralUsersId);
    	double totalNookAndCovePriceDb = 0;
    	if (!referralRewardClientsInfoList.isEmpty()) {    		
    		for (ReferralNookAndCoveStoreCreditInfoSaving refRewardClientsSavingModel : referralRewardClientsInfoList) {
    			totalNookAndCovePriceDb = totalNookAndCovePriceDb + refRewardClientsSavingModel.getRewardAmount();
    		}
    		totalNookAndCovePrice = String.format("%,.2f", totalNookAndCovePriceDb);
    	}
	    return totalNookAndCovePrice;
    }

    public String totalVisaCardPrice(long referralUsersId) {
    	String totalVisaCardPrice = null;
    	List<ReferralNookAndCoveStoreCreditInfoSaving> referralRewardClientsInfoList = referralNookAndCoveStoreCreditInfoSavingDAO.selectedReferralRewardVisaGiftCard(referralUsersId);
    	double totalVisaCardPriceDb = 0;
    	if (!referralRewardClientsInfoList.isEmpty()) {    		
    		for (ReferralNookAndCoveStoreCreditInfoSaving refRewardClientsSavingModel : referralRewardClientsInfoList) {
    			totalVisaCardPriceDb = totalVisaCardPriceDb + refRewardClientsSavingModel.getRewardAmount();
    		}
    		totalVisaCardPrice = String.format("%,.2f", totalVisaCardPriceDb);
    	}
	    return totalVisaCardPrice;
    }

    @Override
    @Transactional
    public ModelAndView adminNewVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ShopReferralUsersInfoSaving> adminRefNewApplicantsList = shopReferralUsersInfoSavingDAO.adminReferralNewApplicantsDataCheckInDB();
    	List<ShopReferralUsersInfoSaving> adminRefCurrVendorsList = shopReferralUsersInfoSavingDAO.adminReferralCurrentVendorsDataCheckInDB();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralVisaTotalCountList = referralVisaCustomGiftCardInfoSavingDAO.adminReferralGiftCardsTotalCountDisplay();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralRewardVisaClientsList = referralVisaCustomGiftCardInfoSavingDAO.adminReferralVisaCustomGiftCardsInfoDisplay();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralIssuedVisaClientsList = referralVisaCustomGiftCardInfoSavingDAO.adminIssuedReferralVisaCustomGiftCardsInfoDisplay();    	
    	if (!referralRewardVisaClientsList.isEmpty()) {
    		List<ReferralVisaCustomGiftCardInfoSaving> refVisaGiftCardsInfoSavingList = new ArrayList<ReferralVisaCustomGiftCardInfoSaving>();
    		for (ReferralVisaCustomGiftCardInfoSaving refVisaGiftCardsInfoLoop : referralRewardVisaClientsList) {
    			ReferralVisaCustomGiftCardInfoSaving refVisaGiftCardsSavingModel = new ReferralVisaCustomGiftCardInfoSaving();
	    		refVisaGiftCardsSavingModel.setReferralVisaCustomGiftCardInfoSavingId(refVisaGiftCardsInfoLoop.getReferralVisaCustomGiftCardInfoSavingId());
	    		refVisaGiftCardsSavingModel.setCreatedDate(refVisaGiftCardsInfoLoop.getCreatedDate());
	    		refVisaGiftCardsSavingModel.setReferralUserFullName(refVisaGiftCardsInfoLoop.getReferralUserFullName());
	    		refVisaGiftCardsSavingModel.setReferralUserEmail(refVisaGiftCardsInfoLoop.getReferralUserEmail());
	        	String totalVisaCardGiftAmount = "$" + String.format("%,.2f", refVisaGiftCardsInfoLoop.getRewardAmount());	        	
	        	refVisaGiftCardsSavingModel.setStatus(totalVisaCardGiftAmount);
	        	refVisaGiftCardsInfoSavingList.add(refVisaGiftCardsSavingModel);
	    	}
	    	mav = new ModelAndView(adminVisaGiftCardsDisplay);
            mav.addObject("adminVisaGiftCardsInfoSavingList", refVisaGiftCardsInfoSavingList);            
        	mav.addObject(refrDataVisibleStatus, refVisibleStatus);
    	} else {
    		mav = new ModelAndView(redirectStatus + "adminIssuedVisaGiftCards");
    		mav.addObject("vendorClientsRef", "Visa Gift Cards");
        }
    	mav.addObject(adminNewApplicantsCount, adminRefNewApplicantsList.size());
    	mav.addObject(adminCurrentVendorsCount, adminRefCurrVendorsList.size());
    	mav.addObject(adminVisaGiftCardsCount, referralVisaTotalCountList.size());
    	mav.addObject(adminNewVisaGiftCardsCount, referralRewardVisaClientsList.size());
    	mav.addObject(adminIssuedVisaGiftCardsCount, referralIssuedVisaClientsList.size());
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminIssuedVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ShopReferralUsersInfoSaving> adminRefNewApplicantsList = shopReferralUsersInfoSavingDAO.adminReferralNewApplicantsDataCheckInDB();
    	List<ShopReferralUsersInfoSaving> adminRefCurrVendorsList = shopReferralUsersInfoSavingDAO.adminReferralCurrentVendorsDataCheckInDB();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralVisaTotalCountList = referralVisaCustomGiftCardInfoSavingDAO.adminReferralGiftCardsTotalCountDisplay();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralRewardVisaClientsList = referralVisaCustomGiftCardInfoSavingDAO.adminReferralVisaCustomGiftCardsInfoDisplay();
    	List<ReferralVisaCustomGiftCardInfoSaving> referralIssuedVisaClientsList = referralVisaCustomGiftCardInfoSavingDAO.adminIssuedReferralVisaCustomGiftCardsInfoDisplay();
    	if (!referralIssuedVisaClientsList.isEmpty()) {
    		List<ReferralVisaCustomGiftCardInfoSaving> refVisaGiftCardsInfoSavingList = new ArrayList<ReferralVisaCustomGiftCardInfoSaving>();
    		for (ReferralVisaCustomGiftCardInfoSaving refVisaGiftCardsInfoLoop : referralIssuedVisaClientsList) {
    			ReferralVisaCustomGiftCardInfoSaving refVisaGiftCardsSavingModel = new ReferralVisaCustomGiftCardInfoSaving();
	    		refVisaGiftCardsSavingModel.setReferralVisaCustomGiftCardInfoSavingId(refVisaGiftCardsInfoLoop.getReferralVisaCustomGiftCardInfoSavingId());
	    		refVisaGiftCardsSavingModel.setCreatedDate(refVisaGiftCardsInfoLoop.getCreatedDate());
	    		refVisaGiftCardsSavingModel.setReferralUserFullName(refVisaGiftCardsInfoLoop.getReferralUserFullName());
	    		refVisaGiftCardsSavingModel.setReferralUserEmail(refVisaGiftCardsInfoLoop.getReferralUserEmail());
	        	String totalVisaCardGiftAmount = "$" + String.format("%,.2f", refVisaGiftCardsInfoLoop.getRewardAmount());	        	
	        	refVisaGiftCardsSavingModel.setStatus(totalVisaCardGiftAmount);
	        	refVisaGiftCardsSavingModel.setIssuedDate(refVisaGiftCardsInfoLoop.getIssuedDate());
	        	refVisaGiftCardsInfoSavingList.add(refVisaGiftCardsSavingModel);
	    	}    		
	    	mav = new ModelAndView(adminIssuedVisaGiftCardsDisplay);
            mav.addObject("adminIssuedVisaGiftCardsInfoSavingList", refVisaGiftCardsInfoSavingList);            
        	mav.addObject(refrDataVisibleStatus, refVisibleStatus);
    	} else {
    		mav = new ModelAndView(adminIssuedVisaGiftCardsDisplay);
    		mav.addObject("vendorClientsRef", "Issued Gift Cards");
        }
    	mav.addObject(adminNewApplicantsCount, adminRefNewApplicantsList.size());
    	mav.addObject(adminCurrentVendorsCount, adminRefCurrVendorsList.size());
    	mav.addObject(adminVisaGiftCardsCount, referralVisaTotalCountList.size());
    	mav.addObject(adminNewVisaGiftCardsCount, referralRewardVisaClientsList.size());
    	mav.addObject(adminIssuedVisaGiftCardsCount, referralIssuedVisaClientsList.size());
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }
        
    @Override
    @Transactional
    public ModelAndView adminIssuedVisaGiftCardsInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	long referralVisaGiftCardsInfoSavingId = Long.parseLong(req.getParameter(referralUserId));
    	Timestamp currentDate = currentDate();    	
    	ReferralVisaCustomGiftCardInfoSaving refVisaGiftCardsModel = referralVisaCustomGiftCardInfoSavingDAO.adminRefIssuedVisaCustomGiftCardsUpdatedInDB(referralVisaGiftCardsInfoSavingId);
    	referralVisaGiftCardInfoUpdateInDBTable(refVisaGiftCardsModel.getVisaGiftCardIdsList(), currentDate);
    	refVisaGiftCardsModel.setVisaGiftCardStatus(refIssuedReff);
    	refVisaGiftCardsModel.setIssuedDate(currentDate);
    	referralVisaCustomGiftCardInfoSavingDAO.merge(refVisaGiftCardsModel);
    	mav = new ModelAndView(redirectStatus + "adminIssuedVisaGiftCards"); 
    	mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    	return mav;
    }

    public String referralVisaGiftCardInfoUpdateInDBTable(String refVisaGiftCardIdsList, Timestamp currentDate) {
    	String refVisaGiftCardIds = null;
    	String[] refVisaGiftCardIdsListSt = refVisaGiftCardIdsList.split("_,_");
    	for(int i = 0; i < refVisaGiftCardIdsListSt.length; i++) {    		
    		long refVisaGiftCardsSavingId = Long.parseLong(refVisaGiftCardIdsListSt[i]);
    		ReferralVisaGiftCardsInfoSaving referralVisaGiftCardsModel = referralVisaGiftCardsInfoSavingDAO.referralVisaGiftCardsInfoUpdateinDB(refVisaGiftCardsSavingId);
    		referralVisaGiftCardsModel.setVisaGiftCardStatus(refIssuedReff);
    		referralVisaGiftCardsModel.setUpdatedDate(currentDate);
    		referralVisaGiftCardsInfoSavingDAO.merge(referralVisaGiftCardsModel);
    	}
	    return refVisaGiftCardIds;
    }
    


	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
