package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface AdminInfoSavingService {
	
	public ModelAndView designProcessAndRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminNewClientsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView newClientsInfoSharingRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView newClientsDirectoryInfoUpdateInDB(HttpServletRequest req, HttpSession sn, long clientInfoId);
	public ModelAndView newGiftCardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView sentGiftCardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAssignedNewClientMailSentToDesigner(HttpServletRequest req, HttpSession sn, long designerInfoId);
	public ModelAndView giftCardInfoSharingRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView viewGiftCardInfoToJSP(HttpServletRequest req, HttpSession sn, long giftCardID);
	public ModelAndView amnPurchasesInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminPurchasedArchiveInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView amnClientDirectoryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView amnAssignedNewDesignerForClientsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAssignedNewDesignerInfoSavingRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAssignedNewDesignerForClientEmailSending(HttpServletRequest req, HttpSession sn, long clientInfoId);
	public ModelAndView amnDesignerDirectoryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView admInactiveDesignersRedirection(HttpServletRequest req, HttpSession sn);
	public String amnDesignerDirectoryNewStatusDsp(HttpServletRequest req, HttpSession sn);
	public ModelAndView amnAccountsInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView purchasesViewInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView purchasesViewOrderInfoDisplay(HttpServletRequest req, HttpSession sn, long shopCartPaymentRef);
	public ModelAndView adminPurchasedArchiveData(HttpServletRequest req, HttpSession sn, long shopCartPaymentRef);
	public ModelAndView purchasesViewClientInfoDisplay(HttpServletRequest req, HttpSession sn, long shopCartPaymentRef);
	public ModelAndView orderInfoMarkAsDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminArchiveDataUpdateInDatabase(HttpServletRequest req, HttpSession sn);
	public ModelAndView markAsOrderUpdateRedirection(HttpServletRequest req, HttpSession sn, long productInfoIdRef);
	public ModelAndView markAsDeliveryUpdateRedirection(HttpServletRequest req, HttpSession sn, long productInfoIdRef);
	public ModelAndView addNewDesignerRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView newDesignerDataSavingInDB(HttpServletRequest req, HttpSession sn);	
	public String customerNameFromDB(long userId);	
	public String designerNameTakeFromDB(long designerId);	
	public ModelAndView designerDirectoryForClientsRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView viewDesignerDirectoryForClientsInAdmin(HttpServletRequest req, HttpSession sn, long designersInfoSavingId);	
	public ModelAndView designerDirectoryClientInfoDisplayRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView viewUploadconceptsAnd3DRenderingRedirection(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);	
	public ModelAndView adminApprovedConceptsAndRenderingsRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView clientRoomsInformationInAdmin(HttpServletRequest req, HttpSession sn);	
	public ModelAndView desClientDirBackMoveRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView giftCouponSendToUserRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView desnUploadedConcept1ViewProductsRe(HttpServletRequest req, HttpSession sn);	
	public ModelAndView cdesnUploadedConcept2ViewProductsRe(HttpServletRequest req, HttpSession sn);	
	public ModelAndView desnUploadedRoomRenderingViewProductsRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnUploadedRevisedRenderingViewProductsRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnUploaded2ndRenderingViewProductsRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAllConceptsProductBackMove(HttpServletRequest req, HttpSession sn);	
	public ModelAndView adminSideClientAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView adminMessageSendToDesignerRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminOneTimeMessageMailSentToDesigner(HttpServletRequest req, HttpSession sn, long designerInfoId);
	public ModelAndView adminAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn);
	public String designerNewUploadStatusFromDB(long designInfoId);
	public String adminAllocatedClientToDesignerStatusFromDB(long designInfoId);
	public int designerMessagesCountInAdminSideTakeFromDB(long designInfoId);
	public String todayDateGettingFromCurrentDate();
	public String timeGettingFromCurrentDate();
	public Timestamp currentDate();
	public ModelAndView promoCodeDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView promoCodeDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView promoCodeManagementDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView promoCodeManagementModification(HttpServletRequest req, HttpSession sn);
	public ModelAndView newPromoCodeDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView amnViewClientInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView editDesignerProfileInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId);
	public ModelAndView inactiveDesignerStatusInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId);
	public ModelAndView editDesignerDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnChangePasswordInDbTable(HttpServletRequest req, HttpSession sn);
	public ModelAndView inactiveDesignersDirectoryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView activeDesignerStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId);
	public ModelAndView inactiveDesignersProfileInDB(HttpServletRequest req, HttpSession sn, long designersInfoSavingId);
	public ModelAndView designerDirectoryQuestionairreBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView accPackageViewUploadConceptsAndFinalConcepts(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	public ModelAndView fullRoomViewUploadConceptsAndRenderings(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	public ModelAndView designerFileUploadStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	public String conceptRevisedRenderingLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	public ModelAndView adminApprovedForConcepts1Redirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedForConcepts2Redirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedForRenderingsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedForRevisedRenderingsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedFor2ndRenderingsRedirection(HttpServletRequest req, HttpSession sn);
	public String concept3DRenderingLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	public ModelAndView adminApprovedForAccConcepts1Redirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedForAccConcepts2Redirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedForFinalConceptsRedRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnUploadedAccConcept1ViewProductsRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView cdesnUploadedAccConcept2ViewProductsRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnUploadedFinalConceptsViewProductsRe(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAccConceptsProductBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminApprovedAllDesignsMailSentToDesigner(HttpServletRequest req, HttpSession sn, long designerInfoId);
	
	public ModelAndView newGiftCardsForAccRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView sentGiftCardsForAccRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView viewGiftCardInfoForAccRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminPackagePaymentForAccRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminSecRenderingPaymentForAccRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminPurchasesInfoForAccRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminChangePasswordRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminChangePasswordSavingInDBTable(HttpServletRequest req, HttpSession sn);
	public ModelAndView createSubAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView createSubAdminDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView subAdminsListDisplayRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView subAdminDeleteFromDBTable(HttpServletRequest req, HttpSession sn);
	public ModelAndView createNewSubAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allGiftCardsDailyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allGiftCardsWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allGiftCardsMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allGiftCardsQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allGiftCardsYearlyReportsRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView allPackageDailyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allPackageWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allPackageMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allPackageQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allPackageYearlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allRenderingDailyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allRenderingWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allRenderingMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allRenderingQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allRenderingYearlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allShoppingCartDailyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allShoppingCartWeeklyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allShoppingCartMonthlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allShoppingCartQuarterlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView allShoppingCartYearlyReportsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignAndRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminPRHomeRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryUserPaymentRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminViewRegistryUserPaymentRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGuestUserPaymentRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminViewGuestUserPaymentRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView deleteNewClientDataInAdmin(HttpServletRequest req, HttpSession sn);
	public ModelAndView createGiftCardsForAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftCardDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminManageGiftCardInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftCardSendRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedAdminGiftCardSendDataCreation(HttpServletRequest req, HttpSession sn, long giftCardID);
	public ModelAndView adminSendGiftCardDataSavingInDB(HttpServletRequest req, HttpSession sn);
}
