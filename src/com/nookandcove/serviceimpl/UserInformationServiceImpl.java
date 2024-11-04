package com.nookandcove.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.dao.ClientInfoSavingDAO;
import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.model.UserInformation;
import com.nookandcove.service.AdminInfoSavingService;
import com.nookandcove.service.ClientInfoSavingService;
import com.nookandcove.service.DesignerInfoSavingService;
import com.nookandcove.service.RegistryInfoSavingService;
import com.nookandcove.service.UserInformationService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class UserInformationServiceImpl implements UserInformationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInformationServiceImpl.class);
		
	private String firstName = "firstName";
	private String lastName = "lastName";
	private String firstNamesInSn = "firstNameInSn";
	private String userName = "userName";
	private String userNameInSn = "userNameInSn";
	private String userIdInSn = "userIdInSn";
	private String createPassword = "createPassword";
	private String password = "password";
	private String registrationRedirection = "registrationRedirection";
	private String logInRedirection = "logInRedirection";
	private String securityPinInSn = "securityPinInSn";
	private String flName = "flName";
	private String seqUserIdInSn = "seqUserIdInSn";
	private String typeOfSpaceInSn = "typeOfSpaceInSn";
	private String packagePriceInSn = "packagePriceInSn";
	private String packagePrice = "packagePrice";
	private String designPackageInSn = "designPackageInSn";
	private String quesPaymentRedirection = "quesPaymentRedirection";
	private String totalCheckoutAmountInSn = "totalCheckoutAmountInSn";
	private String forgotPasswordRedirection = "forgotPasswordRedirection";
	private String securityPinRedirection = "securityPinRedirection";
	private String changePassword = "changePassword";
	private String packagePaymentRedirection = "packagePaymentRedirection";
	private String loginRedirectRef = "loginRedirectRef";
	private String totalCartItemsCountInSN = "totalCartItemsCountInSN";
	private String totalCartItemsCount = "totalCartItemsCount";
	private String registrantUserIdInSn = "registrantUserIdInSn";
	private String homeRedirectionBL = "homeRedirectionBL";
	private String alreadyHaveAccInSn = "alreadyHaveAccInSn";
	private String packagePriceFm = "packagePriceFm";
	private String clientMailSendReffInSn = "clientMailSendReffInSn";
	private String clientMailSendAdmReffInSn = "clientMailSendAdmReffInSn";
	private String conceptBoardsSavingIdInSn = "conceptBoardsSavingIdInSn";	
	
	@Autowired
    private UserInformationDAO userInformationDAO;
	
	@Autowired
    private ClientInfoSavingDAO clientInfoSavingDAO;
	
	@Autowired
    private DesignerInfoSavingService designerInfoSavingService;
	
	@Autowired
	private AdminInfoSavingService adminInfoSavingService;
	
	@Autowired
	private ClientInfoSavingService clientInfoSavingService;
	
	@Autowired
	private RegistryInfoSavingService registryInfoSavingService;
	
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
    public ModelAndView designHomeRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;    	
    	if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("homeRedirectionAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else{
        	mav = new ModelAndView(homeRedirectionBL);
        } 
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registrationRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav = new ModelAndView(registrationRedirection);            
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView registredDataSavingInDB(HttpServletRequest req, HttpSession sn) {
    	String fName = req.getParameter(firstName);
    	String lName = req.getParameter(lastName);
        String uName = req.getParameter(userName);
        String uPassword = req.getParameter(createPassword);        
        List regDataVal = userInformationDAO.findByUserName(uName);
        ModelAndView mav;
        if (!regDataVal.isEmpty()) {
            mav = new ModelAndView(registrationRedirection);
            mav.addObject("regErrorPage", " E-mail already exists!");
        } else {
            String encrypPassword = mD5Encrypt(uPassword);
            String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
            String passwordSalt = mD5Encrypt(encrypPassword + salt);
            Timestamp currentDate = currentDate();
            UserInformation uiModel = new UserInformation();
            uiModel.setFirstName(fName);
            uiModel.setLastName(lName);
            uiModel.setUserName(uName);
            uiModel.setPassword(encrypPassword);
            uiModel.setPasswordSalt(passwordSalt);            
            uiModel.setTypeOfUser("U");
            uiModel.setCreatedDate(currentDate);
            userInformationDAO.save(uiModel);
            Long userId = uiModel.getUserId();            
            sn.setAttribute(userNameInSn, uName);            
            String lastSingleName = String.valueOf(lName.charAt(0)).toUpperCase();
            String fCapName = fName.substring(0, 1).toUpperCase() + fName.substring(1);            
            String fullName = fCapName +" "+lastSingleName;           
            sn.setAttribute(firstNamesInSn, fullName);            
	        sn.setAttribute(userIdInSn, userId);
	        sn.setAttribute(totalCheckoutAmountInSn, sn.getAttribute(packagePriceInSn));
            mav = new ModelAndView(quesPaymentRedirection);            
            mav.addObject("flName", fullName);
            mav.addObject(packagePrice, sn.getAttribute(packagePriceInSn));
            String packPriceFormate = String.format("%1$.2f", Double.parseDouble((String) sn.getAttribute(packagePriceInSn)));
            mav.addObject(packagePriceFm, packPriceFormate);
        }
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView packagePaymentRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;        
        mav = new ModelAndView(packagePaymentRedirection);            
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView loginRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(logInRedirection);
    	sn.setAttribute(userNameInSn, null);
        sn.setAttribute(userIdInSn, null);						        
        sn.setAttribute(firstNamesInSn, null);
        sn.setAttribute(totalCartItemsCountInSN, null);
        sn.setAttribute(registrantUserIdInSn, null);        
        sn.setAttribute(typeOfSpaceInSn, null);
        sn.setAttribute(designPackageInSn, null);
        sn.setAttribute(alreadyHaveAccInSn, null);
        sn.setAttribute(clientMailSendReffInSn, null);
        sn.setAttribute(clientMailSendAdmReffInSn, null);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView twoLoginPagesRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	String uName = req.getParameter(userName);
        String uPassword = req.getParameter(password);
        String loginRedRef = req.getParameter(loginRedirectRef);
        if(("My Design Process").equals(loginRedRef)) {
        	mav = userDetailsVerificationFromDB(req, sn, uName, uPassword);
        } else if(("My Registry").equals(loginRedRef)) {
        	mav = registryInfoSavingService.registrantHomeLandingPageRedirection(req, sn, uName, uPassword);
        } else {
        	mav = loginRedirection(req, sn);
        }
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView userDetailsVerificationFromDB(HttpServletRequest req, HttpSession sn, String uName, String uPassword) {
    	String encrypPassword = mD5Encrypt(uPassword);
        String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String passwordSalt = mD5Encrypt(encrypPassword + salt);
        List<UserInformation> userDataList = userInformationDAO.findByUserInfoProperty(uName, passwordSalt);
        ModelAndView mav;
        if (!userDataList.isEmpty()) {
            long uID = 0;
            String usrName = null;
            String firstName = null;
            String lastName = null;
            String typeOfUser = null;
            for (UserInformation userInformation : userDataList) {
                uID = userInformation.getUserId();
                usrName = userInformation.getUserName();
                firstName = userInformation.getFirstName();
                lastName = userInformation.getLastName();
                typeOfUser = userInformation.getTypeOfUser(); 
            }
            String lastSingleName = String.valueOf(lastName.charAt(0)).toUpperCase();
            String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            String fullName = fCapName +" "+lastSingleName;            
            sn.setAttribute(userIdInSn, uID);
            sn.setAttribute(firstNamesInSn, fullName);
            sn.setAttribute(userNameInSn, usrName);            
            mav = userTypeVerificationInDB(req, sn, typeOfUser, uID);            
            mav.addObject("flName", fullName);           
        } else {
            mav = new ModelAndView(logInRedirection);
            mav.addObject("errorPage", "Invalid ID or Password.");
        }        
        return mav;
    } 

    @Override
    @Transactional
    public ModelAndView userDetailsVerificationForRegFromDB(HttpServletRequest req, HttpSession sn, String uName, String uPassword) {
    	String encrypPassword = mD5Encrypt(uPassword);
        String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String passwordSalt = mD5Encrypt(encrypPassword + salt);
        List<UserInformation> userDataList = userInformationDAO.findByUserInfoProperty(uName, passwordSalt);
        ModelAndView mav;
        if (!userDataList.isEmpty()) {
            long uID = 0;
            String usrName = null;
            String firstName = null;
            String lastName = null;
            String typeOfUser = null;
            for (UserInformation userInformation : userDataList) {
                uID = userInformation.getUserId();
                usrName = userInformation.getUserName();
                firstName = userInformation.getFirstName();
                lastName = userInformation.getLastName();
                typeOfUser = userInformation.getTypeOfUser(); 
            }
            String lastSingleName = String.valueOf(lastName.charAt(0)).toUpperCase();
            String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            String fullName = fCapName +" "+lastSingleName;            
            sn.setAttribute(userIdInSn, uID);
            sn.setAttribute(firstNamesInSn, fullName);
            sn.setAttribute(userNameInSn, usrName);            
            mav = userTypeVerificationInDB(req, sn, typeOfUser, uID);            
            mav.addObject("flName", fullName);           
        } else {
            mav = registryInfoSavingService.registryLoginRedirection(req, sn);
            mav.addObject("errorPage", "Invalid ID or Password.");
        }        
        return mav;
    } 

    @Override
    @Transactional
    public ModelAndView userTypeVerificationInDB(HttpServletRequest req, HttpSession sn, String typeOfUser, long uID) {
    	ModelAndView mav;    	
    	if("U".equals(typeOfUser)) {
    		if(null != sn.getAttribute(alreadyHaveAccInSn) && null != sn.getAttribute(typeOfSpaceInSn) && null != sn.getAttribute(designPackageInSn)) {
    			mav =  accountRedirectionToPayment(req, sn, uID);
    		} else {
    			mav =  userLoginDetailsRedirection(req, sn, uID);
    		}
        } else if("D".equals(typeOfUser)) {            	
        	mav =  designerLoginDetailsRedirection(req, sn, uID);
        } else if("A".equals(typeOfUser)) {            	
        	mav =  adminLoginDetailsRedirection(req, sn, uID);
        } else if("S".equals(typeOfUser)) {            	
        	mav =  adminLoginDetailsRedirection(req, sn, uID);
        } else{
        	mav = new ModelAndView(logInRedirection);
        }              
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView alreadyHaveAnAccountRedirection(HttpServletRequest req, HttpSession sn) {
    	sn.setAttribute(alreadyHaveAccInSn, "Already Have Account");
    	ModelAndView mav = new ModelAndView(logInRedirection);    	        
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView accountRedirectionToPayment(HttpServletRequest req, HttpSession sn, long uID) {
    	ModelAndView mav;    	
    	sn.setAttribute(userIdInSn, uID);
    	sn.setAttribute(totalCheckoutAmountInSn, sn.getAttribute(packagePriceInSn));
    	mav = new ModelAndView(quesPaymentRedirection);
    	mav.addObject(packagePrice, sn.getAttribute(packagePriceInSn));
    	String packPriceFormate = String.format("%1$.2f", Double.parseDouble((String) sn.getAttribute(packagePriceInSn)));
        mav.addObject(packagePriceFm, packPriceFormate);
    	return mav;
    }
     
    @Override
    @Transactional
    public ModelAndView userLoginDetailsRedirection(HttpServletRequest req, HttpSession sn, long uID) {
    	ModelAndView mav;
        List selectedRowIdList = clientInfoSavingDAO.clientManagementRowCheckingInDB(uID);        	
        if(!selectedRowIdList.isEmpty()){           	
        	mav = clientInfoSavingService.clientsInformationDisplayRedirection(req, sn);	
        } else {
        	mav = clientInfoSavingService.startTheBusiness(req, sn);
        }        	
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView designerLoginDetailsRedirection(HttpServletRequest req, HttpSession sn, long uID) {
    	ModelAndView mav;    	
            mav = designerInfoSavingService.designerClientsRedirection(req, sn);
    	return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView adminLoginDetailsRedirection(HttpServletRequest req, HttpSession sn, long uID) {
    	ModelAndView mav;    	
    	mav = adminInfoSavingService.designProcessAndRegistryRedirection(req, sn);
    	return mav;
    }

    @Override
    @Transactional
    public ModelAndView forgotPasswordRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(forgotPasswordRedirection);            
    	return mav;
    }

    @Override
    @Transactional    
    public ModelAndView forgotPasswordSentToMail(HttpServletRequest req, HttpSession sn) {
    	String userName = req.getParameter("userName");
        List userDataVal = userInformationDAO.findByUserName(userName);        
        ModelAndView mav;
        if (!userDataVal.isEmpty()) {
            UserInformation userData = userInformationDAO.findByUserInfoFromDB(userName);            
            long userId = userData.getUserId();
            String firstName = userData.getFirstName();                       
            String alphaNumerics = "ab1cde2fgh3ijk4mnp5qrs6tuv7wxy8zAB9CDEFGHIJKLMNPQRST0UVWXYZ";
            String t = "";
            for (int i = 0; i < 8; i++) {
                t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
            }
            String securityPin = t;
            Timestamp currentDate = currentDate();            
            UserInformation userInformation = userInformationDAO.updatedRowIdVerification(userId);            
            userInformation.setSecurityPin(securityPin);           
            userInformation.setEmailSentDate(currentDate);
            userInformationDAO.merge(userInformation);
            mav = forgotPasswordPinSendToUserEmail(req, sn, securityPin, userName, firstName);                       
            mav = new ModelAndView(securityPinRedirection);
            sn.setAttribute(userNameInSn, null);
            sn.setAttribute(seqUserIdInSn, userId);
            sn.setAttribute(securityPinInSn, securityPin);            
            mav.addObject("secPinMessage", " A Security Pin has been sent to your e-mail");
        } else {
            mav = new ModelAndView(forgotPasswordRedirection);
            mav.addObject("forPassErrorPage", " E-Mail ID not found.");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView forgotPasswordPinSendToUserEmail(HttpServletRequest req, HttpSession sn, String securityPin, String userName, String firstName) {
    	ModelAndView mav;    	
    	String fCapName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    	String subject = "Nook + Cove Reset Password";
    	String type = "text/html";       
    	EmailSending userEmail = new EmailSending();
    	String fromAdd = "info@nookandcove.com";              
        String body = "<body>" 
                    + "<div style='padding: 30px; width: 800px; height: 300px; font: 0.98em/1.26em sans-serif; color: black; text-align: left;'>"
                    + "<p style='padding-top: 5px;'>Hello &nbsp;" + fCapName + ", </p> <br/>"
                    + "<p style='padding-top: 5px;'>Please use the Security Pin below to create a new password.</p>"
                    + "<p style='padding-top: 5px;'>SECURITY PIN: <b>" + securityPin + "</b></p> <br/><br/>"
                    + "<p style='padding-top: 5px;'>-The Nook+Cove Team</p> <br/>"
                    + "</div>"
                    + "</body> ";         
        try {
        	userEmail.sendEmail(userName, subject, body, type, fromAdd);
        } catch (Exception ex) {
        	LOGGER.error("Forgot Password Pin Send To User Email" + ex);
        }       
        mav = new ModelAndView();
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView forgetPasswordSecurityPinVerification(HttpServletRequest req, HttpSession sn) {
    	String snSecPin = (String) sn.getAttribute(securityPinInSn);
        long snUserId = (Long) sn.getAttribute(seqUserIdInSn);
        String secPin = req.getParameter("securityPin");
        String newPassword = req.getParameter("newPassword");
        ModelAndView mav;
        if (snSecPin.equals(secPin)) {        	
            String encrypPassword = mD5Encrypt(newPassword);
            String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
            String passwordSalt = mD5Encrypt(encrypPassword + salt);
            Timestamp currentDate = currentDate();
            UserInformation userInformation = userInformationDAO.updatedRowIdVerification(snUserId);
            userInformation.setPassword(encrypPassword);
            userInformation.setPasswordSalt(passwordSalt);
            userInformation.setLastPasswordChangedDate(currentDate);
            userInformationDAO.merge(userInformation);
            mav = new ModelAndView(logInRedirection);
        } else {
        	mav = new ModelAndView(securityPinRedirection);
            mav.addObject("forPassSeqPinErrorPage", " Please enter the correct Security Pin.");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView howItWorksRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("howItWorksRedirectionAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else {
    		mav = new ModelAndView("howItWorksRedirectionBL");
    	}
    	return mav;
    }
  
    @Override
    @Transactional
    public ModelAndView logOutRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(homeRedirectionBL);
    	mav.addObject("logOutMessage", "You have been successfully logged out.");
    	sn.setAttribute(userNameInSn, null);
        sn.setAttribute(userIdInSn, null);
        sn.removeAttribute(userNameInSn);
        sn.removeAttribute(userIdInSn);
        sn.setAttribute(firstNamesInSn, null);
        sn.setAttribute(totalCartItemsCountInSN, null);
        sn.setAttribute(registrantUserIdInSn, null);
        sn.setAttribute(typeOfSpaceInSn, null);
        sn.setAttribute(designPackageInSn, null);
        sn.setAttribute(alreadyHaveAccInSn, null);
        sn.setAttribute(conceptBoardsSavingIdInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView userSessionTimeOutRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav = new ModelAndView(logInRedirection);
        mav.addObject("logOutMessage", "Your session has expired. Please sign in again.");
        sn.setAttribute(userNameInSn, null);
        sn.setAttribute(userIdInSn, null);
        sn.removeAttribute(userNameInSn);
        sn.removeAttribute(userIdInSn);
        sn.setAttribute(firstNamesInSn, null);
        sn.setAttribute(totalCartItemsCountInSN, null);
        sn.setAttribute(registrantUserIdInSn, null);
        sn.setAttribute(typeOfSpaceInSn, null);
        sn.setAttribute(designPackageInSn, null);
        sn.setAttribute(alreadyHaveAccInSn, null);
        sn.setAttribute(conceptBoardsSavingIdInSn, null);
        return mav;
    }
    
    public ModelAndView changePasswordInDB(HttpServletRequest req, HttpSession sn) {
    	String userName = (String) sn.getAttribute(userNameInSn);
        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String encrypCurPassword = mD5Encrypt(currentPassword);
        String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
        String encrypNewPassword = mD5Encrypt(newPassword);
        String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);
        UserInformation userData = userInformationDAO.findByUserInfoFromDB(userName);
        String oldPassSalt = userData.getPasswordSalt();
        ModelAndView mav;
        if (currentPasswordSalt.equals(oldPassSalt)) {
        	UserInformation userInfoModel = userInformationDAO.findByUserInfoFromDB(userName);
        	userInfoModel.setPassword(encrypNewPassword);
        	userInfoModel.setPasswordSalt(newPasswordSalt);
            userInformationDAO.merge(userInfoModel);
            mav = new ModelAndView(changePassword);
            mav.addObject("passMessage", "Password");
        } else {
            mav = new ModelAndView(changePassword);
            mav.addObject("changePasswordError", " Invalid Current Password");            
        }        
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView designRegistryRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("desnRegistryInfoRedAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else{
        	mav = new ModelAndView("desnRegistryInfoRedBL");
        } 
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView frequentlyAskedQuestionsRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("frequentlyAskedQuestionsRedAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else{
        	mav = new ModelAndView("frequentlyAskedQuestionsRedBL");
        } 
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView termsRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("termsRedirectionAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else{
        	mav = new ModelAndView("termsRedirectionBL");
        } 
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView privacyPolicyRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("privacyPolicyRedirectionAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else{
        	mav = new ModelAndView("privacyPolicyRedirectionBL");
        } 
        return mav;
    }
    
    @Override
    @Transactional
    public ModelAndView regTermsPopupDisplayRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        mav = new ModelAndView("regTermsPopupDisplayRed");    	
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView regPrivacyPolicyPopupDisplayRedirection(HttpServletRequest req, HttpSession sn) {
        ModelAndView mav;
        mav = new ModelAndView("regPrivacyPolicyPopupDisplay");    	
        return mav;
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