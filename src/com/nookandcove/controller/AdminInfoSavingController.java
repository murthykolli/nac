package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.AdminInfoSavingService;

@Controller
public class AdminInfoSavingController {
	
	@Autowired
	private AdminInfoSavingService adminInfoSavingService;

	@RequestMapping(method = RequestMethod.GET, value = "/admDesnAndRegistryHome")
	@ResponseBody
	public ModelAndView admDesnAndRegistryHome(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.designProcessAndRegistryRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admNewClients")
	@ResponseBody
	public ModelAndView admNewClients(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminNewClientsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/amnGiftCards")
	@ResponseBody
	public ModelAndView amnGiftCards(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newGiftCardsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/newGiftCards")
	@ResponseBody
	public ModelAndView newGiftCards(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newGiftCardsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sentGiftCards")
	@ResponseBody
	public ModelAndView sentGiftCards(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.sentGiftCardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/giftCardInfoSharing")
	@ResponseBody
	public ModelAndView giftCardInfoSharing(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.giftCardInfoSharingRe(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/giftBoxBackMove")
	@ResponseBody
	public ModelAndView giftBoxBackMove(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newGiftCardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admnPurchases")
	@ResponseBody
	public ModelAndView admnPurchases(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.amnPurchasesInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminPurchasedArchiveInfo")
	@ResponseBody
	public ModelAndView adminPurchasedArchiveInfo(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminPurchasedArchiveInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/archivePurchaseDataUpdate")
	@ResponseBody
	public ModelAndView archivePurchaseDataUpdate(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminArchiveDataUpdateInDatabase(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/purchasesViewInfoRed")
	@ResponseBody
	public ModelAndView purchasesViewInfoRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.purchasesViewInfoRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admClientDirectory")
	@ResponseBody
	public ModelAndView admClientDirectory(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.amnClientDirectoryRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admAssignNewDesignerForClients")
	@ResponseBody
	public ModelAndView admAssignNewDesignerForClients(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.amnAssignedNewDesignerForClientsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminAssignedNewDesignerInfoSaving")
	@ResponseBody
	public ModelAndView adminAssignedNewDesignerInfoSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminAssignedNewDesignerInfoSavingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientDirectorySaving")
	@ResponseBody
	public ModelAndView clientDirectorySaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.amnViewClientInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orderInfoMarkAsDataUpdateInDB")
	@ResponseBody
	public ModelAndView orderInfoMarkAsDataUpdateInDB(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.orderInfoMarkAsDataUpdateInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/addNewDesigner")
	@ResponseBody
	public ModelAndView addNewDesigner(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.addNewDesignerRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/newDesignerDataSaving")
	@ResponseBody
	public ModelAndView newDesignerDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newDesignerDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admDesnDirectory")
	@ResponseBody
	public ModelAndView admDesnDirectory(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.amnDesignerDirectoryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/admInactiveDesigners")
	@ResponseBody
	public ModelAndView admInactiveDesigners(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.admInactiveDesignersRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerDirectoryForClients")
	@ResponseBody
	public ModelAndView designerDirectoryForClients(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.designerDirectoryForClientsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/inactiveDesignersDirectory")
	@ResponseBody
	public ModelAndView inactiveDesignersDirectory(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.inactiveDesignersDirectoryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/desDirQuestionairreBack")
	@ResponseBody
	public ModelAndView desDirQuestionairreBack(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.designerDirectoryQuestionairreBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editDesignerDataSaving")
	@ResponseBody
	public ModelAndView editDesignerDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.editDesignerDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/desnChangePasswordInDb")
	@ResponseBody
	public ModelAndView changePasswordInDb(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnChangePasswordInDbTable(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admnAccounts")
	@ResponseBody
	public ModelAndView admnAccounts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.amnAccountsInfoRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/newClientsInfoSharing")
	@ResponseBody
	public ModelAndView newClientsInfoSharing(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newClientsInfoSharingRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/designerDirectoryClientInfoDisplay")
	@ResponseBody
	public ModelAndView designerDirectoryClientInfoDisplay(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.designerDirectoryClientInfoDisplayRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedConceptsAndRenderings")
	@ResponseBody
	public ModelAndView adminApprovedConceptsAndRenderings(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedConceptsAndRenderingsRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForAccConcepts1Red")
	@ResponseBody
	public ModelAndView adminApprovedForAccConcepts1Red(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForAccConcepts1Redirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForAccConcepts2Red")
	@ResponseBody
	public ModelAndView adminApprovedForAccConcepts2Red(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForAccConcepts2Redirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForFinalConceptsRed")
	@ResponseBody
	public ModelAndView adminApprovedForFinalConceptsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForFinalConceptsRedRedirection(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForConcepts1Red")
	@ResponseBody
	public ModelAndView adminApprovedForConcepts1Red(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForConcepts1Redirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForConcepts2Red")
	@ResponseBody
	public ModelAndView adminApprovedForConcepts2Red(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForConcepts2Redirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForRenderingsRed")
	@ResponseBody
	public ModelAndView adminApprovedForRenderingsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForRenderingsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedForRevisedRenderingsRed")
	@ResponseBody
	public ModelAndView adminApprovedForRevisedRenderingsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedForRevisedRenderingsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminApprovedFor2ndRenderingsRed")
	@ResponseBody
	public ModelAndView adminApprovedFor2ndRenderingsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminApprovedFor2ndRenderingsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/desClientDirBackMove")
	@ResponseBody
	public ModelAndView desClientDirBackMove(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desClientDirBackMoveRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/giftCouponSendToUser")
	@ResponseBody
	public ModelAndView giftCuponSendToUser(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.giftCouponSendToUserRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedAccConcept1ViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedAccConcept1ViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnUploadedAccConcept1ViewProductsRe(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedAccConcept2ViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedAccConcept2ViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.cdesnUploadedAccConcept2ViewProductsRe(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedFinalConceptsViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedFinalConceptsViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnUploadedFinalConceptsViewProductsRe(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedConcept1ViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedConcept1ViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnUploadedConcept1ViewProductsRe(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedConcept2ViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedConcept2ViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.cdesnUploadedConcept2ViewProductsRe(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedRmRenderingViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedRmRenderingViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnUploadedRoomRenderingViewProductsRe(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadedRevRenderingViewProducts")
	@ResponseBody
	public ModelAndView desnUploadedRevRenderingViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnUploadedRevisedRenderingViewProductsRe(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/desnUploaded2ndRenderingViewProducts")
	@ResponseBody
	public ModelAndView desnUploaded2ndRenderingViewProducts(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.desnUploaded2ndRenderingViewProductsRe(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminAccConceptsProductBackMove")
	@ResponseBody
	public ModelAndView adminAccConceptsProductBackMove(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminAccConceptsProductBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminConceptsProductBackMove")
	@ResponseBody
	public ModelAndView concept1ProductBackMove(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminAllConceptsProductBackMove(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/adminMessageSendToDesigner")
	@ResponseBody
	public ModelAndView adminMessageSendToDesigner(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminMessageSendToDesignerRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirAdminAndDesignerMes")
	@ResponseBody
	public ModelAndView reDirAdminAndDesignerMes(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminAndDesignerMessageInfoRedirection(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/promoCodeDisplay")
	@ResponseBody
	public ModelAndView promoCodeDisplay(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.promoCodeDisplayRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/newPromoCodeDisplay")
	@ResponseBody
	public ModelAndView newPromoCodeDisplay(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newPromoCodeDisplayRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/promoCodeDataSaving")
	@ResponseBody
	public ModelAndView promoCodeDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.promoCodeDataSavingInDB(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/reDirPromoCodeDisp")
	@ResponseBody
	public ModelAndView reDirPromoCodeDisp(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.promoCodeManagementDisplay(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/promoCodeManagementRed")
	@ResponseBody
	public ModelAndView promoCodeManagementRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.promoCodeManagementModification(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/newGiftCardsForAcc")
	@ResponseBody
	public ModelAndView newGiftCardsForAcc(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.newGiftCardsForAccRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sentGiftCardsForAcc")
	@ResponseBody
	public ModelAndView sentGiftCardsForAcc(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.sentGiftCardsForAccRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewGiftCardInfoForAcc")
	@ResponseBody
	public ModelAndView viewGiftCardInfoForAcc(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.viewGiftCardInfoForAccRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/packagePaymentForAcc")
	@ResponseBody
	public ModelAndView packagePaymentForAcc(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminPackagePaymentForAccRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/secRenderingPaymentForAcc")
	@ResponseBody
	public ModelAndView secRenderingPaymentForAcc(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminSecRenderingPaymentForAccRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminPurchasesForAcc")
	@ResponseBody
	public ModelAndView adminPurchasesForAcc(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminPurchasesInfoForAccRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminChangePassword")
	@ResponseBody
	public ModelAndView adminChangePassword(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminChangePasswordRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminChangePasswordSavingInDB")
	@ResponseBody
	public ModelAndView adminChangePasswordSavingInDB(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminChangePasswordSavingInDBTable(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/createSubAdmin")
	@ResponseBody
	public ModelAndView createSubAdmin(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.createSubAdminRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createSubAdminDataSaving")
	@ResponseBody
	public ModelAndView registrationDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.createSubAdminDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/subAdminsListDsp")
	@ResponseBody
	public ModelAndView subAdminsListDsp(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.subAdminsListDisplayRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/subAdminDeleteFromDB")
	@ResponseBody
	public ModelAndView subAdminDeleteFromDB(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.subAdminDeleteFromDBTable(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allGiftCardsDailyReportsRed")
	@ResponseBody
	public ModelAndView allGiftCardsDailyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allGiftCardsDailyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allGiftCardsWeeklyReportsRed")
	@ResponseBody
	public ModelAndView allGiftCardsWeeklyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allGiftCardsWeeklyReportsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allGiftCardsMonthlyReportsRed")
	@ResponseBody
	public ModelAndView allGiftCardsMonthlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allGiftCardsMonthlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allGiftCardsQuarterlyReportsRed")
	@ResponseBody
	public ModelAndView allGiftCardsQuarterlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allGiftCardsQuarterlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allGiftCardsYearlyReportsRed")
	@ResponseBody
	public ModelAndView allGiftCardsYearlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allGiftCardsYearlyReportsRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/allPackageDailyReportsRed")
	@ResponseBody
	public ModelAndView allPackageDailyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allPackageDailyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allPackageWeeklyReportsRed")
	@ResponseBody
	public ModelAndView allPackageWeeklyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allPackageWeeklyReportsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allPackageMonthlyReportsRed")
	@ResponseBody
	public ModelAndView allPackageMonthlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allPackageMonthlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allPackageQuarterlyReportsRed")
	@ResponseBody
	public ModelAndView allPackageQuarterlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allPackageQuarterlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allPackageYearlyReportsRed")
	@ResponseBody
	public ModelAndView allPackageYearlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allPackageYearlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allRenderingDailyReportsRed")
	@ResponseBody
	public ModelAndView allRenderingDailyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allRenderingDailyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allRenderingWeeklyReportsRed")
	@ResponseBody
	public ModelAndView allRenderingWeeklyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allRenderingWeeklyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allRenderingMonthlyReportsRed")
	@ResponseBody
	public ModelAndView allRenderingMonthlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allRenderingMonthlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allRenderingQuarterlyReportsRed")
	@ResponseBody
	public ModelAndView allRenderingQuarterlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allRenderingQuarterlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allRenderingYearlyReportsRed")
	@ResponseBody
	public ModelAndView allRenderingYearlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allRenderingYearlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allShoppingCartDailyReportsRed")
	@ResponseBody
	public ModelAndView allShoppingCartDailyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allShoppingCartDailyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allShoppingCartWeeklyReportsRed")
	@ResponseBody
	public ModelAndView allShoppingCartWeeklyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allShoppingCartWeeklyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allShoppingCartMonthlyReportsRed")
	@ResponseBody
	public ModelAndView allShoppingCartMonthlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allShoppingCartMonthlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allShoppingCartQuarterlyReportsRed")
	@ResponseBody
	public ModelAndView allShoppingCartQuarterlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allShoppingCartQuarterlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allShoppingCartYearlyReportsRed")
	@ResponseBody
	public ModelAndView allShoppingCartYearlyReportsRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.allShoppingCartYearlyReportsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminPRHome")
	@ResponseBody
	public ModelAndView adminDesignAndRegistryHome(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminDesignAndRegistryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminPackageReg")
	@ResponseBody
	public ModelAndView adminPackageReg(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminPRHomeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryRed")
	@ResponseBody
	public ModelAndView adminRegistryRed(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminRegistryRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryUserPayment")
	@ResponseBody
	public ModelAndView adminRegistryUserPayment(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminRegistryUserPaymentRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminViewRegistryUserPayment")
	@ResponseBody
	public ModelAndView adminViewRegistryUserPayment(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminViewRegistryUserPaymentRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGuestUserPayment")
	@ResponseBody
	public ModelAndView adminGuestUserPayment(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminGuestUserPaymentRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminViewGuestUserPayment")
	@ResponseBody
	public ModelAndView adminViewGuestUserPayment(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminViewGuestUserPaymentRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteNewClientInAdmin")
	@ResponseBody
	public ModelAndView deleteNewClientInAdmin(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.deleteNewClientDataInAdmin(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/createGiftCards")
	@ResponseBody
	public ModelAndView createGiftCards(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.createGiftCardsForAdminRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminGiftCardDataSaving")
	@ResponseBody
	public ModelAndView adminGiftCardDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminGiftCardDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/manageGiftCards")
	@ResponseBody
	public ModelAndView manageGiftCards(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminManageGiftCardInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftCardSend")
	@ResponseBody
	public ModelAndView adminGiftCardSend(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminGiftCardSendRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminSendGiftCardDataSaving")
	@ResponseBody
	public ModelAndView adminSendGiftCardDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminInfoSavingService.adminSendGiftCardDataSavingInDB(req, sn);
	}
	
}
