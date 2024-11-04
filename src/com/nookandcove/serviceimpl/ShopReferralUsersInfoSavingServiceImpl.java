package com.nookandcove.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.nookandcove.dao.ReferralCustomGiftCardsInfoSavingDAO;
import com.nookandcove.dao.ReferralNookAndCoveStoreCreditInfoSavingDAO;
import com.nookandcove.dao.ReferralVisaCustomGiftCardInfoSavingDAO;
import com.nookandcove.dao.ReferralVisaGiftCardsInfoSavingDAO;
import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.dao.RegistrantPaymentInfoSavingDAO;
import com.nookandcove.dao.ShopReferralUsersInfoSavingDAO;
import com.nookandcove.dao.ShopUserPaymentInfoSavingDAO;
import com.nookandcove.model.GuestUserPaymentInfoSaving;
import com.nookandcove.model.ReferralCustomGiftCardsInfoSaving;
import com.nookandcove.model.ReferralNookAndCoveStoreCreditInfoSaving;
import com.nookandcove.model.ReferralVisaCustomGiftCardInfoSaving;
import com.nookandcove.model.ReferralVisaGiftCardsInfoSaving;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.RegistrantPaymentInfoSaving;
import com.nookandcove.model.ShopReferralUsersInfoSaving;
import com.nookandcove.model.ShopUserPaymentInfoSaving;
import com.nookandcove.service.ShopReferralUsersInfoSavingService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class ShopReferralUsersInfoSavingServiceImpl implements ShopReferralUsersInfoSavingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShopReferralUsersInfoSavingServiceImpl.class);	
	
	private String referralFormCreation = "referralFormCreation";
	private String refferalSecurityPinRed = "refferalSecurityPinRed";
	private String refferalForgotPassword = "refferalForgotPassword";
	private String referralLanding = "referralLanding";
	private String redirectStatus = "redirect:";
	private String referralUserLoginRed = "referralUserLoginRed";
	private String referralMyAccountRed = "referralMyAccountRed";
	private String referralShippingInfoRed = "referralShippingInfoRed";
	private String activeReferralsInfoRed = "activeReferralsInfoRed";
	private String referralNookAndCoveStoreCreditRed = "referralNookAndCoveStoreCreditRed";
	private String referralVisaGiftCardsRed = "referralVisaGiftCardsRed";
	
	private String refErrorPage = "refErrorPage";
	private String referralFirstName = "referralFirstName";
	private String referralLastName = "referralLastName";
	private String referralBusinessName = "referralBusinessName";
	private String referralWebsite = "referralWebsite";
	private String referralSocialMediaInfo = "referralSocialMediaInfo";
	private String referralUserEmail = "referralUserEmail";
	private String referralPassword = "referralPassword";
	private String referralPhoneNumber = "referralPhoneNumber";
	private String referralSeqUserIdInSn = "referralSeqUserIdInSn";
	private String referralSecurityPinInSn = "referralSecurityPinInSn";
	private String passwordSaltFormat = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
	private String vendorCategory = "vendorCategory";
	private String otherCategory = "otherCategory";
	private String referralSocialMedia = "referralSocialMedia";
	private String referralStreetAddress = "referralStreetAddress";
	private String referralStreetLine = "referralStreetLine";
	private String referralCityName = "referralCityName";
	private String referralStateName = "referralStateName";
	private String referralZipCode = "referralZipCode";
	private String referralUserIdInSn = "referralUserIdInSn";
	private String referralFirstNameInSn = "referralFirstNameInSn";
	private String refEmailExistReff = "This e-mail already exists!";
	private String refDataSuccSavedReff = "refDataSuccSavedReff";
	private String refAccountSavedRef = "Account Data Saved";
	private String refOtherRef = "Other";
	private String referralPasswordInfoRed = "referralPasswordInfoRed";
	private String uniqueRefferalCode = "uniqueRefferalCode";
	private String referralDataReff = "referralDataReff";
	private String referralOrderStatus = "Referral Orders";
	private String activeReferralUserInfoDataInSn = "activeReferralUserInfoDataInSn";
	private String registrantUserId = "registrantUserId";
	private String registrantFullName = "registrantFullName";
	private Double rewardPrice = 100.00;
	private String referralNookAndCoveStoreCreditInfoInSn = "referralNookAndCoveStoreCreditInfoInSn";
	private String totalRewardPriceInSt = "totalRewardPriceInSt";
	private String nookAndCoveReff = "Nook and Cove Credit";
	private String referralVisaGiftCardsInfoInSn = "referralVisaGiftCardsInfoInSn";
	private String referralVisaCustomGiftCardsInfoInSn = "referralVisaCustomGiftCardsInfoInSn";
	private String visaGiftCardReff = "Visa Gift Card";
	private String referralCustomGiftCard = "referralCustomGiftCard";
	private String totalCreditAmount = "totalCreditAmount";
	private String remainingCreditAmount = "remainingCreditAmount";
	private String referralShopPaymentInfoValueInSn = "referralShopPaymentInfoValueInSn";
	private String refVisaGiftCardsIdsList = "refVisaGiftCardsIdsList";
	private String refRequestReff = "Requested";
	
	
	@Autowired
    private ShopReferralUsersInfoSavingDAO shopReferralUsersInfoSavingDAO;

	@Autowired
    private RegistrantInformationSavingDAO registrantInformationSavingDAO;

    @Autowired
    private RegistrantPaymentInfoSavingDAO registrantPaymentInfoSavingDAO;

	@Autowired
    private GuestUserPaymentInfoSavingDAO guestUserPaymentInfoSavingDAO;

	@Autowired
    private ReferralNookAndCoveStoreCreditInfoSavingDAO referralNookAndCoveStoreCreditInfoSavingDAO;

	@Autowired
    private ReferralVisaGiftCardsInfoSavingDAO referralVisaGiftCardsInfoSavingDAO;

	@Autowired
    private ReferralCustomGiftCardsInfoSavingDAO referralCustomGiftCardsInfoSavingDAO;

	@Autowired
    private ReferralVisaCustomGiftCardInfoSavingDAO referralVisaCustomGiftCardInfoSavingDAO;

	@Autowired
    private ShopUserPaymentInfoSavingDAO shopUserPaymentInfoSavingDAO;
	
		
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
    public ModelAndView referralUserLoginRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(referralUserLoginRed);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralLearnMoreRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView("referralLearnMoreRed");
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralFormCreationRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(referralFormCreation);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralFormInfoSavingInDB(HttpServletRequest req, HttpSession sn) {
    	List shopReferralUsersInfoVal = shopReferralUsersInfoSavingDAO.findByUserName(req.getParameter(referralUserEmail));
    	ModelAndView mav;
        if (!shopReferralUsersInfoVal.isEmpty()) {
            mav = new ModelAndView(referralFormCreation);
            mav.addObject(refErrorPage, refEmailExistReff);
            mav.addObject(referralUserEmail, req.getParameter(referralUserEmail));
            mav.addObject(referralFirstName, req.getParameter(referralFirstName));
            mav.addObject(referralLastName, req.getParameter(referralLastName));
            mav.addObject(referralBusinessName, req.getParameter(referralBusinessName));
            mav.addObject(referralWebsite, req.getParameter(referralWebsite));
            mav.addObject(referralSocialMediaInfo, req.getParameter(referralSocialMediaInfo));            
            mav.addObject(referralPhoneNumber, req.getParameter(referralPhoneNumber));
            mav.addObject(vendorCategory, req.getParameter(vendorCategory));
            mav.addObject(otherCategory, req.getParameter(otherCategory));            
            mav.addObject(referralSocialMedia, req.getParameter(referralSocialMedia));
            mav.addObject(referralStreetAddress, req.getParameter(referralStreetAddress));
            mav.addObject(referralStreetLine, req.getParameter(referralStreetLine));
            mav.addObject(referralCityName, req.getParameter(referralCityName));
            mav.addObject(referralStateName, req.getParameter(referralStateName));
            mav.addObject(referralZipCode, req.getParameter(referralZipCode));
        } else {
        	Timestamp currentDate = currentDate();
        	ShopReferralUsersInfoSaving ShopRefInfoSavingModel = new ShopReferralUsersInfoSaving();
        	String refFirstNameName = req.getParameter(referralFirstName).substring(0, 1).toUpperCase() + req.getParameter(referralFirstName).substring(1);
        	String refLastNameName = req.getParameter(referralLastName).substring(0, 1).toUpperCase() + req.getParameter(referralLastName).substring(1);
        	ShopRefInfoSavingModel.setReferralUserEmail(req.getParameter(referralUserEmail));
        	ShopRefInfoSavingModel.setReferralFirstName(refFirstNameName);
        	ShopRefInfoSavingModel.setReferralLastName(refLastNameName);
        	ShopRefInfoSavingModel.setReferralBusinessName(req.getParameter(referralBusinessName));
        	ShopRefInfoSavingModel.setVendorCategory(req.getParameter(vendorCategory));
        	ShopRefInfoSavingModel.setOtherCategory(req.getParameter(otherCategory));
        	ShopRefInfoSavingModel.setReferralWebsite(req.getParameter(referralWebsite));
        	ShopRefInfoSavingModel.setReferralSocialMediaInfo(req.getParameter(referralSocialMediaInfo));
        	ShopRefInfoSavingModel.setReferralPhoneNumber(req.getParameter(referralPhoneNumber));
        	String uniqueRefferalCode = systemGenarateUniqueRefferalCode(req, sn);
        	String refCustomGiftCode = systemGenarateUniqueReferralCustomGiftCode(req, sn);
        	ShopRefInfoSavingModel.setReferralCustomGiftCard(refCustomGiftCode);
        	ShopRefInfoSavingModel.setReferralCouponCode(uniqueRefferalCode);
        	ShopRefInfoSavingModel.setCreatedDate(currentDate);
        	ShopRefInfoSavingModel.setWpStatus("No");        	
        	ShopRefInfoSavingModel.setReferralSocialMedia(req.getParameter(referralSocialMedia));
        	ShopRefInfoSavingModel.setReferralStreetAddress(req.getParameter(referralStreetAddress));
        	ShopRefInfoSavingModel.setReferralStreetLine(req.getParameter(referralStreetLine));
        	ShopRefInfoSavingModel.setReferralCityName(req.getParameter(referralCityName));
        	ShopRefInfoSavingModel.setReferralStateName(req.getParameter(referralStateName));
        	ShopRefInfoSavingModel.setReferralZipCode(req.getParameter(referralZipCode));
        	shopReferralUsersInfoSavingDAO.save(ShopRefInfoSavingModel);
        	mav = new ModelAndView("referralFormSuccess");
        }    	
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView refferalForgotPasswordRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(refferalForgotPassword);
    	return mav;
    }

    @Override
    @Transactional    
    public ModelAndView refferalForgotPasswordSentToMail(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	EmailSending userEmail = new EmailSending();
        String fromAdd = "info@nookandcove.com";
        List shopReferralUsersInfoVal = shopReferralUsersInfoSavingDAO.shopReferralUsersEmailInfoCheckInDB(req.getParameter(referralUserEmail));        
        if (!shopReferralUsersInfoVal.isEmpty()) {
        	ShopReferralUsersInfoSaving regInfoData = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(req.getParameter(referralUserEmail));            
            long referralUsersId = regInfoData.getReferralUserId();            
            String fullName = regInfoData.getReferralFirstName() + " " + regInfoData.getReferralLastName();
            String securityPin = systemGenarateUniqueRefferalCode(req, sn);
            Timestamp currentDate = currentDate();            
            ShopReferralUsersInfoSaving refUsersInfoSavingModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(referralUsersId);            
            refUsersInfoSavingModel.setSecurityPin(securityPin);           
            refUsersInfoSavingModel.setEmailSentDate(currentDate);
            shopReferralUsersInfoSavingDAO.merge(refUsersInfoSavingModel);            
            String aTo = req.getParameter(referralUserEmail);
            String aSubject = "Nook + Cove Reset Password";
            String spin = securityPin;
            String type = "text/html";
            String body = "<body>" 
                        + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                        + "<p style='padding-top: 5px;'>Hello &nbsp;" + fullName + ", </p> <br/>"
                        + "<p style='padding-top: 5px;'>Please use the Security Pin below to create a new password.</p>"
                        + "<p style='padding-top: 5px;'>SECURITY PIN: <b>" + spin + "</b></p> <br/><br/>"
                        + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                        + "</div>"
                        + "</body> "; 
            try {
                userEmail.sendEmail(aTo, aSubject, body, type, fromAdd);
            } catch (Exception ex) {
            	LOGGER.error("forgetPasswordWithEmailChecking " + ex);
            }
            mav = new ModelAndView(refferalSecurityPinRed);            
            sn.setAttribute(referralSeqUserIdInSn, referralUsersId);
            sn.setAttribute(referralSecurityPinInSn, securityPin);            
            mav.addObject("secPinMessage", " A Security Pin has been sent to your e-mail");
        } else {
            mav = new ModelAndView(refferalForgotPassword);
            mav.addObject("forPassErrorPage", " E-mail ID not found!");
        }
        return mav;
    }
    
    public String systemGenarateUniqueRefferalCode(HttpServletRequest req, HttpSession sn) {
	    String alphaNumerics = "ab1cde2fgh3ijk4mnp5qrs6tuv7wxy8zAB9CDEFGHIJKLMNPQRST0UVWXYZ";
	    String uniqueRefferalCode = "";
	    for (int i = 0; i < 8; i++) {
	    	uniqueRefferalCode += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }
	    return uniqueRefferalCode;
    }

    public String systemGenarateUniqueReferralCustomGiftCode(HttpServletRequest req, HttpSession sn) {
	    String alphaNumerics = "A1B2CD3EFG4HIJ5KL6MNO7PQ8RSTW9XY0Z";
	    String uniqueRefferalCode = "";
	    for (int i = 0; i < 7; i++) {
	    	uniqueRefferalCode += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	    }
	    return uniqueRefferalCode;
    }

    @Override
    @Transactional
    public ModelAndView refferalForgotPassSecPinCheVerification(HttpServletRequest req, HttpSession sn) {
    	String referralSnSecPin = (String) sn.getAttribute(referralSecurityPinInSn);
        long referralSnUserId = (Long) sn.getAttribute(referralSeqUserIdInSn);
        String refSecurityPin = req.getParameter("securityPin");
        String newPassword = req.getParameter("newPassword");
        ModelAndView mav;
        if (referralSnSecPin.equals(refSecurityPin)) {
        	String encrypPassword = mD5Encrypt(newPassword);
            String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
            Timestamp currentDate = currentDate();
            ShopReferralUsersInfoSaving regInformation = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB(referralSnUserId);            
            regInformation.setReferralPassword(encrypPassword);
            regInformation.setPasswordSalt(passwordSalt);
            regInformation.setLastPasswordChangedDate(currentDate);
            shopReferralUsersInfoSavingDAO.merge(regInformation);
            mav = referralUserLoginRedirection(req, sn);                
        } else {
        	mav = new ModelAndView(refferalSecurityPinRed);
            mav.addObject("forPassSeqPinErrorPage", " Please enter correct Security Pin!");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralLoginVerificationRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String encrypPassword = mD5Encrypt(req.getParameter(referralPassword));
        String passwordSalt = mD5Encrypt(encrypPassword + passwordSaltFormat);
        List<ShopReferralUsersInfoSaving> userDataList = shopReferralUsersInfoSavingDAO.referralUserInfoCheckingInDB(req.getParameter(referralUserEmail), passwordSalt);        
        if (!userDataList.isEmpty()) {
        	ShopReferralUsersInfoSaving regInfoSavingModel = shopReferralUsersInfoSavingDAO.referralUserInfoDataTakeFromDB(req.getParameter(referralUserEmail), passwordSalt);
            long referralUserId = regInfoSavingModel.getReferralUserId();
            String referralFirstName = regInfoSavingModel.getReferralFirstName();
            sn.setAttribute(referralUserIdInSn, referralUserId);
            sn.setAttribute(referralFirstNameInSn, referralFirstName);
            mav = new ModelAndView(redirectStatus + referralLanding);            
        } else {
            mav = new ModelAndView(referralUserLoginRed);
            mav.addObject("referralErrorStatus", "Invalid ID or Password.");
        }        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralLandingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ShopReferralUsersInfoSaving> shopReferralUsersInfoList = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoCheckingInDB((Long) sn.getAttribute(referralUserIdInSn));        
        if (!shopReferralUsersInfoList.isEmpty()) {
        	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        	mav = new ModelAndView(referralMyAccountRed);
        	mav.addObject(referralUserEmail, shopReferralUsersInfoModel.getReferralUserEmail());
            mav.addObject(referralFirstName, shopReferralUsersInfoModel.getReferralFirstName());
            mav.addObject(referralLastName, shopReferralUsersInfoModel.getReferralLastName());
            mav.addObject(referralBusinessName, shopReferralUsersInfoModel.getReferralBusinessName());
            mav.addObject(referralWebsite, shopReferralUsersInfoModel.getReferralWebsite());
            mav.addObject(referralSocialMediaInfo, shopReferralUsersInfoModel.getReferralSocialMediaInfo());            
            mav.addObject(referralPhoneNumber, shopReferralUsersInfoModel.getReferralPhoneNumber());
            mav.addObject(vendorCategory, shopReferralUsersInfoModel.getVendorCategory());
            mav.addObject(otherCategory, shopReferralUsersInfoModel.getOtherCategory());
            mav.addObject(referralSocialMedia, shopReferralUsersInfoModel.getReferralSocialMedia());
        } else {
        	mav = new ModelAndView(referralUserLoginRed);
        }
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView referralLogOutRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(referralUserLoginRed);
    	mav.addObject("logOutMessage", "You have been successfully logged out.");
        sn.setAttribute(referralUserIdInSn, null);
        sn.setAttribute(referralFirstNameInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralContactInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	ShopReferralUsersInfoSaving ShopRefInfoSavingModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
    	String refFirstNameName = req.getParameter(referralFirstName).substring(0, 1).toUpperCase() + req.getParameter(referralFirstName).substring(1);
    	String refLastNameName = req.getParameter(referralLastName).substring(0, 1).toUpperCase() + req.getParameter(referralLastName).substring(1);
    	String referralDBUserEmail = ShopRefInfoSavingModel.getReferralUserEmail();
    	ShopRefInfoSavingModel.setReferralFirstName(refFirstNameName);
    	ShopRefInfoSavingModel.setReferralLastName(refLastNameName);
    	ShopRefInfoSavingModel.setReferralBusinessName(req.getParameter(referralBusinessName));
    	ShopRefInfoSavingModel.setReferralSocialMedia(req.getParameter(referralSocialMedia));
    	ShopRefInfoSavingModel.setVendorCategory(req.getParameter(vendorCategory));
    	if((refOtherRef).equals(req.getParameter(vendorCategory))) {
    		ShopRefInfoSavingModel.setOtherCategory(req.getParameter(otherCategory));
    	} else {
    		ShopRefInfoSavingModel.setOtherCategory(null);
    	}
    	ShopRefInfoSavingModel.setReferralWebsite(req.getParameter(referralWebsite));
    	ShopRefInfoSavingModel.setReferralSocialMediaInfo(req.getParameter(referralSocialMediaInfo));
    	ShopRefInfoSavingModel.setReferralPhoneNumber(req.getParameter(referralPhoneNumber));
    	ShopRefInfoSavingModel.setUpdatedDate(currentDate);
    	shopReferralUsersInfoSavingDAO.merge(ShopRefInfoSavingModel);
    	sn.setAttribute(referralFirstNameInSn, refFirstNameName);
    	List shopReferralUsersInfoVal = shopReferralUsersInfoSavingDAO.findByUserName(req.getParameter(referralUserEmail));
    	if (!shopReferralUsersInfoVal.isEmpty() && ("null" != req.getParameter(referralUserEmail) && !(referralDBUserEmail).equals(req.getParameter(referralUserEmail)))) {
    		mav = new ModelAndView(referralMyAccountRed);
    		mav.addObject(refErrorPage, refEmailExistReff);
    	} else {
    		ShopRefInfoSavingModel.setReferralUserEmail(req.getParameter(referralUserEmail));
    		shopReferralUsersInfoSavingDAO.merge(ShopRefInfoSavingModel);
    		mav = new ModelAndView(referralMyAccountRed);
    		mav.addObject(refDataSuccSavedReff, refAccountSavedRef);
    	}
    	mav.addObject(referralUserEmail, req.getParameter(referralUserEmail));
        mav.addObject(referralFirstName, refFirstNameName);
        mav.addObject(referralLastName, refLastNameName);
        mav.addObject(referralBusinessName, req.getParameter(referralBusinessName));
        mav.addObject(referralWebsite, req.getParameter(referralWebsite));
        mav.addObject(referralSocialMediaInfo, req.getParameter(referralSocialMediaInfo));            
        mav.addObject(referralPhoneNumber, req.getParameter(referralPhoneNumber));
        mav.addObject(vendorCategory, req.getParameter(vendorCategory));
        mav.addObject(otherCategory, req.getParameter(otherCategory));
        mav.addObject(referralSocialMedia, req.getParameter(referralSocialMedia));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralShippingInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	List<ShopReferralUsersInfoSaving> shopReferralUsersInfoList = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoCheckingInDB((Long) sn.getAttribute(referralUserIdInSn));        
        if (!shopReferralUsersInfoList.isEmpty()) {
        	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        	mav = new ModelAndView(referralShippingInfoRed);
        	mav.addObject(referralStreetAddress, shopReferralUsersInfoModel.getReferralStreetAddress());
            mav.addObject(referralStreetLine, shopReferralUsersInfoModel.getReferralStreetLine());
            mav.addObject(referralCityName, shopReferralUsersInfoModel.getReferralCityName());
            mav.addObject(referralStateName, shopReferralUsersInfoModel.getReferralStateName());
            mav.addObject(referralZipCode, shopReferralUsersInfoModel.getReferralZipCode());
        } else {
        	mav = new ModelAndView(referralUserLoginRed);
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralShippingInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	ShopReferralUsersInfoSaving ShopRefInfoSavingModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));    	
    	ShopRefInfoSavingModel.setReferralStreetAddress(req.getParameter(referralStreetAddress));
    	ShopRefInfoSavingModel.setReferralStreetLine(req.getParameter(referralStreetLine));
    	ShopRefInfoSavingModel.setReferralCityName(req.getParameter(referralCityName));
    	ShopRefInfoSavingModel.setReferralStateName(req.getParameter(referralStateName));
    	ShopRefInfoSavingModel.setReferralZipCode(req.getParameter(referralZipCode));
    	ShopRefInfoSavingModel.setUpdatedDate(currentDate);
    	shopReferralUsersInfoSavingDAO.merge(ShopRefInfoSavingModel);
    	mav = new ModelAndView(referralShippingInfoRed);
    	mav.addObject(refDataSuccSavedReff, refAccountSavedRef);
    	mav.addObject(referralStreetAddress, req.getParameter(referralStreetAddress));
        mav.addObject(referralStreetLine, req.getParameter(referralStreetLine));
        mav.addObject(referralCityName, req.getParameter(referralCityName));            
        mav.addObject(referralStateName, req.getParameter(referralStateName));
        mav.addObject(referralZipCode, req.getParameter(referralZipCode));
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralPasswordInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(referralPasswordInfoRed);    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralPasswordInfoUpdateInDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String currentRefPassword = req.getParameter("currentReferralPassword");
        String newRefPassword = req.getParameter("newReferralPassword");
        String encrypCurPassword = mD5Encrypt(currentRefPassword);
        String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
        String encrypNewPassword = mD5Encrypt(newRefPassword);
        String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);
        Timestamp currentDate = currentDate();
        ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        String oldPassSalt = shopReferralUsersInfoModel.getPasswordSalt();
        if (currentPasswordSalt.equals(oldPassSalt)) {
        	shopReferralUsersInfoModel.setReferralPassword(encrypNewPassword);
        	shopReferralUsersInfoModel.setPasswordSalt(newPasswordSalt);
        	shopReferralUsersInfoModel.setLastPasswordChangedDate(currentDate);
        	shopReferralUsersInfoSavingDAO.merge(shopReferralUsersInfoModel);
        	mav = new ModelAndView(referralPasswordInfoRed);
        	mav.addObject(refDataSuccSavedReff, refAccountSavedRef);
        } else {
        	mav = new ModelAndView(referralPasswordInfoRed);
            req.setAttribute("changePasswordError", "Invalid Current Password");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView myReferralCodeInfoTakeFromDB(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
        ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        String uniqueRefCode = shopReferralUsersInfoModel.getReferralCouponCode();
        mav = new ModelAndView("myReferralCodeInfoRed");
        mav.addObject(uniqueRefferalCode, uniqueRefCode);	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView activeReferralsInfoRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
        ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        String uniqueRefCode = shopReferralUsersInfoModel.getReferralCouponCode();
        List<RegistrantInformationSaving> registrantUserInfoList = registrantInformationSavingDAO.registrantUserIdsListCheckUsingUniqueRefCode(uniqueRefCode);
        String activeReferralUserInfoData = null;
        if (!registrantUserInfoList.isEmpty()) {	    	
	    	for (RegistrantInformationSaving registrantUserInfoModel : registrantUserInfoList) {
	    		double registrantUserPrice = registrantUserTotalPrice(registrantUserInfoModel.getRegistrantUserId());
	    		double guestUserPrice = guestUserTotalPrice(registrantUserInfoModel.getRegistrantUserId());
	    		double totalrefferalPrice = registrantUserPrice + guestUserPrice;	    		
	    		String clientFullName = registrantUserInfoModel.getRegFirstName() + " " + registrantUserInfoModel.getRegLastName();
	    		Timestamp createdDate = registrantUserInfoModel.getCreatedDate();
	    		Date dateCon = new Date();
	    		dateCon.setTime(createdDate.getTime());
    	    	String createdDateSt = new SimpleDateFormat("MM/dd/yyyy").format(dateCon);
    	    	String referralPriceStatus = null;
    	    	String refTypeOfRewardName = referralTypeOfRewardName((Long) sn.getAttribute(referralUserIdInSn), registrantUserInfoModel.getRegistrantUserId());
    	    	if((totalrefferalPrice >= 3500) && (null != refTypeOfRewardName)) {
	    			referralPriceStatus = refTypeOfRewardName;
	    		} else if((totalrefferalPrice >= 3500) && (null == refTypeOfRewardName)) {
	    			referralPriceStatus = "READY TO BYE";
	    		} else {
	    			referralPriceStatus = "NOT YET";
	    		}
	    		String activeReferralUserDataInSt = registrantUserInfoModel.getRegistrantUserId() + ",_," + clientFullName + ",_," + createdDateSt + ",_," + referralPriceStatus;
	    		activeReferralUserInfoData = activeReferralUserInfoData + "__" + activeReferralUserDataInSt;
	    	}
	    	activeReferralUserInfoData = activeReferralUserInfoData.replaceFirst("null__", "");
	    	sn.setAttribute(activeReferralUserInfoDataInSn, activeReferralUserInfoData);
	    	mav = new ModelAndView(activeReferralsInfoRed);
	    } else {
        	mav = new ModelAndView(activeReferralsInfoRed);
        	mav.addObject(referralDataReff, referralOrderStatus);
        }       	
        return mav;
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

    public String referralTypeOfRewardName(long referralUsersId, long registrantUsersId) {
    	String refTypeOfRewardName = null;
    	List<ReferralNookAndCoveStoreCreditInfoSaving> referralRewardClientsInfoList = referralNookAndCoveStoreCreditInfoSavingDAO.selectedReferralRewardClientsInfoVerification(referralUsersId, registrantUsersId);
    	if (!referralRewardClientsInfoList.isEmpty()) {    		
    		ReferralNookAndCoveStoreCreditInfoSaving referralRewardClientModel = referralNookAndCoveStoreCreditInfoSavingDAO.updatedReferralRewardClientsInfoInDataBasa(referralUsersId, registrantUsersId);
    		refTypeOfRewardName = referralRewardClientModel.getTypeOfCreditName();
    	} 
    	List<ReferralVisaGiftCardsInfoSaving> referralVisaGiftCardsInfoList = referralVisaGiftCardsInfoSavingDAO.selectedReferralVisaGiftCardsInfoVerification(referralUsersId, registrantUsersId);
    	if (!referralVisaGiftCardsInfoList.isEmpty()) {    		
    		ReferralVisaGiftCardsInfoSaving referralVisaGiftCardsInfoModel = referralVisaGiftCardsInfoSavingDAO.updatedReferralVisaGiftCardsInfoInDataBasa(referralUsersId, registrantUsersId);
    		refTypeOfRewardName = referralVisaGiftCardsInfoModel.getTypeOfCreditName();
    	} 
	    return refTypeOfRewardName;
    }

    @Override
    @Transactional
    public ModelAndView rewardsNookAndCoveCreditRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long registrantsUserId = Long.parseLong(req.getParameter(registrantUserId));
    	ReferralNookAndCoveStoreCreditInfoSaving refRewardClientsInfoModel = new ReferralNookAndCoveStoreCreditInfoSaving();
    	refRewardClientsInfoModel.setReferralUserId((Long) sn.getAttribute(referralUserIdInSn));
    	ShopReferralUsersInfoSaving refUsersInfoSavingModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
    	refRewardClientsInfoModel.setRegistrantUserId(registrantsUserId);
    	refRewardClientsInfoModel.setRegistrantFullName(req.getParameter(registrantFullName));
    	String refUserFullName = refUsersInfoSavingModel.getReferralFirstName() + " " + refUsersInfoSavingModel.getReferralLastName();
    	refRewardClientsInfoModel.setReferralUserFullName(refUserFullName);
    	refRewardClientsInfoModel.setReferralUserEmail(refUsersInfoSavingModel.getReferralUserEmail());
    	refRewardClientsInfoModel.setRewardAmount(rewardPrice);
    	refRewardClientsInfoModel.setTypeOfCreditName(nookAndCoveReff);
    	refRewardClientsInfoModel.setCreatedDate(currentDate);
    	refRewardClientsInfoModel.setReferralCreatedDate(refUsersInfoSavingModel.getCreatedDate());
    	referralNookAndCoveStoreCreditInfoSavingDAO.save(refRewardClientsInfoModel);
    	referralCustomGiftCardRedirection(req, sn, currentDate);
    	activeReferralsInfoDataMaintain(req, sn);
    	mav = new ModelAndView(redirectStatus + "nookAndCoveStoreCredit");	
        return mav;
    }
    
    public String activeReferralsInfoDataMaintain(HttpServletRequest req, HttpSession sn) {
    	String activeReferralsInfoReff = null;    	
        ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        String uniqueRefCode = shopReferralUsersInfoModel.getReferralCouponCode();
        List<RegistrantInformationSaving> registrantUserInfoList = registrantInformationSavingDAO.registrantUserIdsListCheckUsingUniqueRefCode(uniqueRefCode);
        String activeReferralUserInfoData = null;
        if (!registrantUserInfoList.isEmpty()) {	    	
	    	for (RegistrantInformationSaving registrantUserInfoModel : registrantUserInfoList) {
	    		double registrantUserPrice = registrantUserTotalPrice(registrantUserInfoModel.getRegistrantUserId());
	    		double guestUserPrice = guestUserTotalPrice(registrantUserInfoModel.getRegistrantUserId());
	    		double totalrefferalPrice = registrantUserPrice + guestUserPrice;
	    		String clientFullName = registrantUserInfoModel.getRegFirstName() + " " + registrantUserInfoModel.getRegLastName();
	    		Timestamp createdDate = registrantUserInfoModel.getCreatedDate();
	    		Date dateCon = new Date();
	    		dateCon.setTime(createdDate.getTime());
    	    	String createdDateSt = new SimpleDateFormat("MM/dd/yyyy").format(dateCon);
    	    	String referralPriceStatus = null;
    	    	String refTypeOfRewardName = referralTypeOfRewardName((Long) sn.getAttribute(referralUserIdInSn), registrantUserInfoModel.getRegistrantUserId());
    	    	if((totalrefferalPrice >= 3500) && (null != refTypeOfRewardName)) {
	    			referralPriceStatus = refTypeOfRewardName;
	    		} else if((totalrefferalPrice >= 3500) && (null == refTypeOfRewardName)) {
	    			referralPriceStatus = "READY TO BYE";
	    		} else {
	    			referralPriceStatus = "NOT YET";
	    		}
	    		String activeReferralUserDataInSt = registrantUserInfoModel.getRegistrantUserId() + ",_," + clientFullName + ",_," + createdDateSt + ",_," + referralPriceStatus;
	    		activeReferralUserInfoData = activeReferralUserInfoData + "__" + activeReferralUserDataInSt;
	    	}
	    	activeReferralUserInfoData = activeReferralUserInfoData.replaceFirst("null__", "");
	    	sn.setAttribute(activeReferralUserInfoDataInSn, activeReferralUserInfoData);
        }
	    return activeReferralsInfoReff;
    }

    public String referralCustomGiftCardRedirection(HttpServletRequest req, HttpSession sn, Timestamp currentDate) {
    	String referralCustomGiftCard = null;
    	List<ReferralCustomGiftCardsInfoSaving> refCustomGiftCardsInfoList = referralCustomGiftCardsInfoSavingDAO.referralCustomGiftCardInfoVerification((Long) sn.getAttribute(referralUserIdInSn));
    	if (!refCustomGiftCardsInfoList.isEmpty()) {
    		ReferralCustomGiftCardsInfoSaving refCustomGiftCardsInfoModel = referralCustomGiftCardsInfoSavingDAO.updatedReferralCustomGiftCardInfoInDataBasa((Long) sn.getAttribute(referralUserIdInSn));
    		double totalCreditPrice = refCustomGiftCardsInfoModel.getTotalCredit() + rewardPrice;
    		double remainingCreditPrice = refCustomGiftCardsInfoModel.getRemainingCredit() + rewardPrice;
    		refCustomGiftCardsInfoModel.setTotalCredit(totalCreditPrice);
    		refCustomGiftCardsInfoModel.setRemainingCredit(remainingCreditPrice);
    		referralCustomGiftCardsInfoSavingDAO.merge(refCustomGiftCardsInfoModel);    		
    	} else {
    		ReferralCustomGiftCardsInfoSaving refCustomGiftCardsInfoModel = new ReferralCustomGiftCardsInfoSaving();
    		refCustomGiftCardsInfoModel.setReferralUserId((Long) sn.getAttribute(referralUserIdInSn));
    		refCustomGiftCardsInfoModel.setTypeOfCreditName(nookAndCoveReff);
    		ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
    		refCustomGiftCardsInfoModel.setReferralCustomGiftCard(shopReferralUsersInfoModel.getReferralCustomGiftCard());
    		refCustomGiftCardsInfoModel.setTotalCredit(rewardPrice);
    		refCustomGiftCardsInfoModel.setRemainingCredit(rewardPrice);
    		refCustomGiftCardsInfoModel.setUsedCredit(0.00);
    		refCustomGiftCardsInfoModel.setCreatedDate(currentDate);
    		referralCustomGiftCardsInfoSavingDAO.save(refCustomGiftCardsInfoModel);
    	}    	
	    return referralCustomGiftCard;
    }

    @Override
    @Transactional
    public ModelAndView referralNookAndCoveStoreCreditRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	List<ReferralNookAndCoveStoreCreditInfoSaving> referralRewardClientsInfoList = referralNookAndCoveStoreCreditInfoSavingDAO.selectedReferralRewardNookAndCoveCreditWithId((Long) sn.getAttribute(referralUserIdInSn));
        String referralNookAndCoveStoreCreditInfo = null;
        double totalRewardPrice = 0;
        if (!referralRewardClientsInfoList.isEmpty()) {
        	for (ReferralNookAndCoveStoreCreditInfoSaving referralRewardClientsModel : referralRewardClientsInfoList) {
	    		totalRewardPrice = totalRewardPrice + referralRewardClientsModel.getRewardAmount();
	    		String rewardPriceSt = String.format("%,.2f", referralRewardClientsModel.getRewardAmount());
	    		String referralNookAndCoveStoreCreditDataInSt = referralRewardClientsModel.getRegistrantFullName() + ",_," + rewardPriceSt;
	    		referralNookAndCoveStoreCreditInfo = referralNookAndCoveStoreCreditInfo + "__" + referralNookAndCoveStoreCreditDataInSt;
	    	}
	    	referralNookAndCoveStoreCreditInfo = referralNookAndCoveStoreCreditInfo.replaceFirst("null__", "");
	    	sn.setAttribute(referralNookAndCoveStoreCreditInfoInSn, referralNookAndCoveStoreCreditInfo);
	    	String totalRewardPriceSt = String.format("%,.2f", totalRewardPrice);
	    	ReferralCustomGiftCardsInfoSaving refCustomGiftCardsInfoModel = referralCustomGiftCardsInfoSavingDAO.updatedReferralCustomGiftCardInfoInDataBasa((Long) sn.getAttribute(referralUserIdInSn));
	    	shopReferralNookAndCoveStoreCreditRedirection(req, sn);
	    	mav = new ModelAndView(referralNookAndCoveStoreCreditRed);
	    	mav.addObject(totalRewardPriceInSt, totalRewardPriceSt);
	    	mav.addObject(referralCustomGiftCard, refCustomGiftCardsInfoModel.getReferralCustomGiftCard());
	    	String totalCreditPrice = String.format("%,.2f", refCustomGiftCardsInfoModel.getTotalCredit());
	    	String remainingCreditPrice = String.format("%,.2f", refCustomGiftCardsInfoModel.getRemainingCredit());
	    	mav.addObject(totalCreditAmount, totalCreditPrice);
	    	mav.addObject(remainingCreditAmount, remainingCreditPrice);
	    } else {
        	mav = new ModelAndView(referralNookAndCoveStoreCreditRed);
        	mav.addObject(referralDataReff, referralOrderStatus);
        	sn.setAttribute(referralNookAndCoveStoreCreditInfoInSn, null);
        	sn.setAttribute(referralShopPaymentInfoValueInSn, null);
        }       	
        return mav;
    }
    
    public String shopReferralNookAndCoveStoreCreditRedirection(HttpServletRequest req, HttpSession sn) {
    	String referralShopPaymentInfo = null;
    	ShopReferralUsersInfoSaving shopReferralUsersInfoModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
        String uniqueRefCode = shopReferralUsersInfoModel.getReferralCustomGiftCard();
        List<ShopUserPaymentInfoSaving> referralShopPaymentList = shopUserPaymentInfoSavingDAO.shopUserReferralCouponPaymenListFromDB(uniqueRefCode);
    	String referralShopPaymentInfoValue = null;
        if (!referralShopPaymentList.isEmpty()) {
        	for (ShopUserPaymentInfoSaving referralShopPaymentModel : referralShopPaymentList) {
        		Timestamp createdDate = referralShopPaymentModel.getCreatedDate();
	    		Date dateCon = new Date();
	    		dateCon.setTime(createdDate.getTime());
    	    	String createdDateSt = new SimpleDateFormat("MM/dd/yyyy").format(dateCon);
//	    		String rewardPriceSt = String.format("%,.2f", referralShopPaymentModel.getShopDiscountAmount());
	    		String referralShopPaymentInfoInSt = createdDateSt + ",_," + referralShopPaymentModel.getShopDiscountAmount();
	    		referralShopPaymentInfoValue = referralShopPaymentInfoValue + "__" + referralShopPaymentInfoInSt;
	    	}
        	referralShopPaymentInfoValue = referralShopPaymentInfoValue.replaceFirst("null__", "");
	    	sn.setAttribute(referralShopPaymentInfoValueInSn, referralShopPaymentInfoValue);	    	
	    }       	
        return referralShopPaymentInfo;
    }
    
    @Override
    @Transactional
    public ModelAndView rewardsVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	long registrantsUserId = Long.parseLong(req.getParameter(registrantUserId));
    	ReferralVisaGiftCardsInfoSaving refRewardClientsInfoModel = new ReferralVisaGiftCardsInfoSaving();
    	ShopReferralUsersInfoSaving refUsersInfoSavingModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
    	refRewardClientsInfoModel.setReferralUserId((Long) sn.getAttribute(referralUserIdInSn));
    	refRewardClientsInfoModel.setRegistrantUserId(registrantsUserId);
    	refRewardClientsInfoModel.setRegistrantFullName(req.getParameter(registrantFullName));
    	String refUserFullName = refUsersInfoSavingModel.getReferralFirstName() + " " + refUsersInfoSavingModel.getReferralLastName();
    	refRewardClientsInfoModel.setReferralUserFullName(refUserFullName);
    	refRewardClientsInfoModel.setReferralUserEmail(refUsersInfoSavingModel.getReferralUserEmail());
    	refRewardClientsInfoModel.setRewardAmount(rewardPrice);
    	refRewardClientsInfoModel.setTypeOfCreditName(visaGiftCardReff);
    	refRewardClientsInfoModel.setVisaGiftCardStatus("Pending");
    	refRewardClientsInfoModel.setCreatedDate(currentDate);
    	refRewardClientsInfoModel.setReferralCreatedDate(refUsersInfoSavingModel.getCreatedDate());
    	referralVisaGiftCardsInfoSavingDAO.save(refRewardClientsInfoModel);
    	activeReferralsInfoDataMaintain(req, sn);
    	mav = new ModelAndView(redirectStatus + "visaGiftCards");	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView referralVisaGiftCardsRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
		List<ReferralVisaGiftCardsInfoSaving> referralVisaGiftCardsInfoList = referralVisaGiftCardsInfoSavingDAO.selectedReferralVisaGiftCardsInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
	    String referralVisaGiftCardsInfo = null;
	    double totalRewardPrice = 0;
	    String refeVisaGiftCardsIdsList = null;
	    String referralVisaCustomGiftCardsInfo = referralVisaCustomGiftCardsDataTakeFromDB(req, sn);
	    sn.setAttribute(referralVisaCustomGiftCardsInfoInSn, referralVisaCustomGiftCardsInfo);
	    if (!referralVisaGiftCardsInfoList.isEmpty()) {	    	
	    	for (ReferralVisaGiftCardsInfoSaving referralVisaGiftCardsInfoModel : referralVisaGiftCardsInfoList) {
	    		totalRewardPrice = totalRewardPrice + referralVisaGiftCardsInfoModel.getRewardAmount();
	    		String rewardPriceSt = String.format("%,.2f", referralVisaGiftCardsInfoModel.getRewardAmount());
	    		String referralVisaGiftCardsDataInSt = referralVisaGiftCardsInfoModel.getRegistrantFullName() + ",_," + rewardPriceSt;
	    		referralVisaGiftCardsInfo = referralVisaGiftCardsInfo + "__" + referralVisaGiftCardsDataInSt;
	    		refeVisaGiftCardsIdsList = refeVisaGiftCardsIdsList  + "_,_" + referralVisaGiftCardsInfoModel.getReferralVisaGiftCardsInfoSavingId();
	    	}
	    	referralVisaGiftCardsInfo = referralVisaGiftCardsInfo.replaceFirst("null__", "");
	    	refeVisaGiftCardsIdsList = refeVisaGiftCardsIdsList.replaceFirst("null_,_", "");
	    	sn.setAttribute(referralVisaGiftCardsInfoInSn, referralVisaGiftCardsInfo);
	    	String totalRewardPriceSt = String.format("%,.2f", totalRewardPrice);	    	
	    	mav = new ModelAndView(referralVisaGiftCardsRed);
	    	mav.addObject(totalRewardPriceInSt, totalRewardPriceSt);
	    	mav.addObject(refVisaGiftCardsIdsList, refeVisaGiftCardsIdsList);
	    } else {
	    	mav = new ModelAndView(referralVisaGiftCardsRed);
	    	mav.addObject(referralDataReff, referralOrderStatus);
	    	sn.setAttribute(referralVisaGiftCardsInfoInSn, null);
	    }       	
	    return mav;
	}

    public String referralVisaCustomGiftCardsDataTakeFromDB(HttpServletRequest req, HttpSession sn) {
    	String referralVisaCustomGiftCardsInfo = null;    	
    	List<ReferralVisaGiftCardsInfoSaving> refVisaCustomGiftCardsList = referralVisaGiftCardsInfoSavingDAO.selectedReferralVisaGiftCardsInfoDisplay((Long) sn.getAttribute(referralUserIdInSn));
    	if (!refVisaCustomGiftCardsList.isEmpty()) {	    	
	    	for (ReferralVisaGiftCardsInfoSaving refVisaCustomGiftCardsModel : refVisaCustomGiftCardsList) {
	    		String rewardPriceSt = String.format("%,.2f", refVisaCustomGiftCardsModel.getRewardAmount());
	    		Timestamp createdDate = refVisaCustomGiftCardsModel.getUpdatedDate();
	    		Date dateCon = new Date();
	    		dateCon.setTime(createdDate.getTime());
    	    	String createdDateSt = new SimpleDateFormat("MM/dd/yyyy").format(dateCon);
	    		String referralVisaGiftCardsDataInSt = refVisaCustomGiftCardsModel.getRegistrantFullName() + ",_," + rewardPriceSt + ",_," + refVisaCustomGiftCardsModel.getVisaGiftCardStatus() + ",_," + createdDateSt;
	    		referralVisaCustomGiftCardsInfo = referralVisaCustomGiftCardsInfo + "__" + referralVisaGiftCardsDataInSt;
	    	}	    	
	    	referralVisaCustomGiftCardsInfo = referralVisaCustomGiftCardsInfo.replaceFirst("null__", "");	    	
	    }      	
        return referralVisaCustomGiftCardsInfo;
    }

    @Override
    @Transactional
    public ModelAndView visaGiftCardsRequestForAdminRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	Timestamp currentDate = currentDate();
    	String[] refVisaGiftCardsIdsListSt = req.getParameter(refVisaGiftCardsIdsList).split("_,_");
    	double totalRewardAmount = 0;
    	for(int i = 0; i < refVisaGiftCardsIdsListSt.length; i++) {    		
    		long refVisaGiftCardsSavingId = Long.parseLong(refVisaGiftCardsIdsListSt[i]);
    		ReferralVisaGiftCardsInfoSaving referralVisaGiftCardsModel = referralVisaGiftCardsInfoSavingDAO.referralVisaGiftCardsInfoUpdateinDB(refVisaGiftCardsSavingId);
    		totalRewardAmount = totalRewardAmount + referralVisaGiftCardsModel.getRewardAmount();
    		referralVisaGiftCardsModel.setVisaGiftCardStatus(refRequestReff);
    		referralVisaGiftCardsModel.setUpdatedDate(currentDate);
    		referralVisaGiftCardsInfoSavingDAO.merge(referralVisaGiftCardsModel);
    	}    	
    	ReferralVisaCustomGiftCardInfoSaving refVisaCustomGCInfoModel = new ReferralVisaCustomGiftCardInfoSaving();
    	ShopReferralUsersInfoSaving refUsersInfoSavingModel = shopReferralUsersInfoSavingDAO.shopReferralUsersInfoTakeFromDB((Long) sn.getAttribute(referralUserIdInSn));
    	refVisaCustomGCInfoModel.setReferralUserId((Long) sn.getAttribute(referralUserIdInSn));
    	String refUserFullName = refUsersInfoSavingModel.getReferralFirstName() + " " + refUsersInfoSavingModel.getReferralLastName();
    	refVisaCustomGCInfoModel.setReferralUserFullName(refUserFullName);
    	refVisaCustomGCInfoModel.setReferralUserEmail(refUsersInfoSavingModel.getReferralUserEmail());
    	refVisaCustomGCInfoModel.setRewardAmount(totalRewardAmount);
    	refVisaCustomGCInfoModel.setVisaGiftCardStatus(refRequestReff);
    	refVisaCustomGCInfoModel.setCreatedDate(currentDate);
    	refVisaCustomGCInfoModel.setVisaGiftCardIdsList(req.getParameter(refVisaGiftCardsIdsList));
    	refVisaCustomGCInfoModel.setReferralCreatedDate(refUsersInfoSavingModel.getCreatedDate());
    	referralVisaCustomGiftCardInfoSavingDAO.save(refVisaCustomGCInfoModel);    	
    	mav = new ModelAndView(redirectStatus + "visaGiftCards");       	
	    return mav;
	}

	@Override
	@Transactional
	public Timestamp currentDate() {				 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}
}
