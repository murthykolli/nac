package com.nookandcove.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface AdminRegistryDataDisplayService {
	
	public ModelAndView registryLiveStatusRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryArchiveStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryArchiveStatusRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryLiveStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryDataDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryStockCheckRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryStockCheckSelectedRoom(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminRegistrySCProdPrice1UpdateInDB(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminRegistrySCProdPrice2UpdateInDB(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminRegistrySCProdPrice3UpdateInDB(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminRegistrySCProdPrice4UpdateInDB(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminRegistrySCProdPrice5UpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryAllSCRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminRegistrySCStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonStockCheckItemStatusUpdateInDB(String scItemCombValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonStockCheckPrice1UpdateInDB(String stPrice1UpdateCombValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonStockCheckPrice2UpdateInDB(String stPrice2UpdateCombValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonStockCheckPrice3UpdateInDB(String stPrice3UpdateCombValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonStockCheckPrice4UpdateInDB(String stPrice4UpdateCombValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonStockCheckPrice5UpdateInDB(String stPrice5UpdateCombValue, HttpSession sn, HttpServletRequest req);
	
	public ModelAndView registrantRoomFundsForStoreCreditDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public ModelAndView registrantAndGuestStoreCreditDataDisplay(HttpServletRequest req, HttpSession sn, String storeCredRoomFunds);
	public ModelAndView adminRegistryCashFundsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminPendingCashFundsRequestSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminCashFundClearedNotRequestedRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryTransferRequestedCashFunds(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminTransferCompleteCashFundsRedirect(HttpServletRequest req, HttpSession sn);
	public ModelAndView regiCashFundsBankAccountsRedirection(HttpServletRequest req, HttpSession sn, long registrantUserId, long registryCashFundSavingId, String typeOfCashFund);
	public ModelAndView cashFundTransferCompletedStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryTransferCompletedCashFunds(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView adminGiftsReceivedNoActionData(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftsReceivedConvertedToCreditData(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftsReceivedShipNowData(HttpServletRequest req, HttpSession sn);
	public ModelAndView giftReceivedShipNowSelectedOrderRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView grConBoardsShipNowSelectedOrderInfo(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef);
	public ModelAndView grFinTouchesShipNowSelectedOrderInfo(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGROrderPlaceStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGROrderPlaceConBoardsStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGROrderPlaceFinTouchesStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGiftsReceivedOrderedDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftReceivedTrackingDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftReceivedTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef, String adminTrackingLinkURL);
	public ModelAndView adminGRFinTouchesTrackingLinkUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef, String adminTrackingLinkURL);
	public ModelAndView adminGiftsReceivedTrackingDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftReceivedOrderedDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsOrderedDataUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef);
	public ModelAndView adminGRFinTouchesOrderedDataUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGiftsReceivedDeliveredDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRBackOrderedDateDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef, String admnGRBackOrderedDate);
	public ModelAndView adminGRFinTouchesBackOrderedDateUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef, String admnGRBackOrderedDate);
	public ModelAndView adminGiftsReceivedBackOrderedDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftReceivedBackOrderViewDetails(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsBackOrderViewDetails(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardRef);
	public ModelAndView adminGRFinTouchesBackOrderViewDetails(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGRBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef);
	public ModelAndView adminGRFinTouchesBackInStockStatusUpdateInDB(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGiftsReceivedOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftsReceivedConBoardsOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef);
	public ModelAndView adminGiftsReceivedFinTouchesOutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGiftsReceivedOutOfStockDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGiftReceivedOutOfStockViewDetails(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsOutOfStockViewDetails(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef);
	public ModelAndView adminGRFinTouchesOutOfStockViewDetails(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGRBackOrderModifyDateDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminGRConBoardsBackOrderModifyDateDisplay(HttpServletRequest req, HttpSession sn, long cbIndividualPaymentSavingId, String typeOfConBoardsRef);
	public ModelAndView adminGRFinTouchesBackOrderModifyDateDisplay(HttpServletRequest req, HttpSession sn, long ftIndividualPaymentSavingId, String typeOfFinTouchesRef);
	public ModelAndView adminGRBackOrderTextUpdateDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRoomFundsRedirection(HttpServletRequest req, HttpSession sn);
	
	
		
	public Timestamp currentDate();
	
}
