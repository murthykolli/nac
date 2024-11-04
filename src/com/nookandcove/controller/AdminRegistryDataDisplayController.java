package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.AdminRegistryDataDisplayService;

@Controller
public class AdminRegistryDataDisplayController {
	
	@Autowired
	private AdminRegistryDataDisplayService adminRegistryDataDisplayService;

	@RequestMapping(method = RequestMethod.GET, value = "/registryLiveStatusRed")
	@ResponseBody
	public ModelAndView registryLiveStatusRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.registryLiveStatusRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryArchiveStatusUpdate")
	@ResponseBody
	public ModelAndView adminRegistryArchiveStatusUpdate(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.adminRegistryArchiveStatusUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryArchiveStatusRed")
	@ResponseBody
	public ModelAndView registryArchiveStatusRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.registryArchiveStatusRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryLiveStatusUpdate")
	@ResponseBody
	public ModelAndView adminRegistryLiveStatusUpdate(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.adminRegistryLiveStatusUpdateInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryDataDsp")
	@ResponseBody
	public ModelAndView adminRegistryDataDsp(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.adminRegistryDataDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryStockCheck")
	@ResponseBody
	public ModelAndView adminRegistryStockCheck(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.adminRegistryStockCheckRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegSCSelectedRoom")
	@ResponseBody
	public ModelAndView adminRegSCSelectedRoom(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.adminRegistryStockCheckSelectedRoom(req, sn);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistrySCProdPrice1Update")
//	@ResponseBody
//	public ModelAndView adminRegistrySCProdPrice1Update(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryDataDisplayService.adminRegistrySCProdPrice1UpdateInDB(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistrySCProdPrice2Update")
//	@ResponseBody
//	public ModelAndView adminRegistrySCProdPrice2Update(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryDataDisplayService.adminRegistrySCProdPrice2UpdateInDB(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistrySCProdPrice3Update")
//	@ResponseBody
//	public ModelAndView adminRegistrySCProdPrice3Update(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryDataDisplayService.adminRegistrySCProdPrice3UpdateInDB(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistrySCProdPrice4Update")
//	@ResponseBody
//	public ModelAndView adminRegistrySCProdPrice4Update(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryDataDisplayService.adminRegistrySCProdPrice4UpdateInDB(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistrySCProdPrice5Update")
//	@ResponseBody
//	public ModelAndView adminRegistrySCProdPrice5Update(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryDataDisplayService.adminRegistrySCProdPrice5UpdateInDB(req, sn);
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistryAllSCRed")
	@ResponseBody
	public ModelAndView adminRegistryAllSCRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryDataDisplayService.adminRegistryAllSCRedirection(req, sn);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/adminRegistrySCStatusUpdate")
//	@ResponseBody
//	public ModelAndView adminRegistrySCStatusUpdate(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryDataDisplayService.adminRegistrySCStatusUpdateInDB(req, sn);
//	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonStockCheckItemStatusUpdate")
	@ResponseBody
	public JSONArray jSonStockCheckItemStatusUpdate(@RequestParam("scItemCombVal") String scItemCombValue, HttpSession sn, HttpServletRequest req) {
		return adminRegistryDataDisplayService.jSonStockCheckItemStatusUpdateInDB(scItemCombValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonStockCheckPrice1Update")
	@ResponseBody
	public JSONArray jSonStockCheckPrice1Update(@RequestParam("stPrice1UpdateCombVal") String stPrice1UpdateCombValue, HttpSession sn, HttpServletRequest req) {
		return adminRegistryDataDisplayService.jSonStockCheckPrice1UpdateInDB(stPrice1UpdateCombValue, sn, req);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonStockCheckPrice2Update")
	@ResponseBody
	public JSONArray jSonStockCheckPrice2Update(@RequestParam("stPrice2UpdateCombVal") String stPrice2UpdateCombValue, HttpSession sn, HttpServletRequest req) {
		return adminRegistryDataDisplayService.jSonStockCheckPrice2UpdateInDB(stPrice2UpdateCombValue, sn, req);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonStockCheckPrice3Update")
	@ResponseBody
	public JSONArray jSonStockCheckPrice3Update(@RequestParam("stPrice3UpdateCombVal") String stPrice3UpdateCombValue, HttpSession sn, HttpServletRequest req) {
		return adminRegistryDataDisplayService.jSonStockCheckPrice3UpdateInDB(stPrice3UpdateCombValue, sn, req);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonStockCheckPrice4Update")
	@ResponseBody
	public JSONArray jSonStockCheckPrice4Update(@RequestParam("stPrice4UpdateCombVal") String stPrice4UpdateCombValue, HttpSession sn, HttpServletRequest req) {
		return adminRegistryDataDisplayService.jSonStockCheckPrice4UpdateInDB(stPrice4UpdateCombValue, sn, req);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonStockCheckPrice5Update")
	@ResponseBody
	public JSONArray jSonStockCheckPrice5Update(@RequestParam("stPrice5UpdateCombVal") String stPrice5UpdateCombValue, HttpSession sn, HttpServletRequest req) {
		return adminRegistryDataDisplayService.jSonStockCheckPrice5UpdateInDB(stPrice5UpdateCombValue, sn, req);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminCashFunds")
	@ResponseBody
	public ModelAndView adminCashFunds(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminRegistryCashFundsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminPendingCashFundsRequestSaving")
	@ResponseBody
	public ModelAndView adminPendingCashFundsRequestSaving(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminPendingCashFundsRequestSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminCashFundClearedNotRequested")
	@ResponseBody
	public ModelAndView adminCashFundClearedNotRequested(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminCashFundClearedNotRequestedRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminCashFundTransferRequested")
	@ResponseBody
	public ModelAndView adminCashFundTransferRequested(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminRegistryTransferRequestedCashFunds(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminTransferCompleteCashFunds")
	@ResponseBody
	public ModelAndView adminTransferCompleteCashFunds(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminTransferCompleteCashFundsRedirect(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cashFundTransferCompletedStatusUpdate")
	@ResponseBody
	public ModelAndView cashFundTransferCompletedStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.cashFundTransferCompletedStatusUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminCashFundTransferComplete")
	@ResponseBody
	public ModelAndView adminCashFundTransferComplete(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminRegistryTransferCompletedCashFunds(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceived")
	@ResponseBody
	public ModelAndView adminGiftsReceived(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedNoActionData(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRConvertedToCredit")
	@ResponseBody
	public ModelAndView adminGRConvertedToCredit(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedConvertedToCreditData(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceivedShipNow")
	@ResponseBody
	public ModelAndView adminGiftsReceivedShipNow(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedShipNowData(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/giftReceivedShipNowSelectedOrder")
	@ResponseBody
	public ModelAndView giftReceivedShipNowSelectedOrder(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.giftReceivedShipNowSelectedOrderRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGROrderPlaceStatusUpdate")
	@ResponseBody
	public ModelAndView adminGROrderPlaceStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGROrderPlaceStatusUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceivedOrdered")
	@ResponseBody
	public ModelAndView adminGiftsReceivedOrdered(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedOrderedDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftReceivedTrackingData")
	@ResponseBody
	public ModelAndView adminGiftReceivedTrackingData(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftReceivedTrackingDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRTrackingLinkUpdate")
	@ResponseBody
	public ModelAndView adminGRTrackingLinkUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftReceivedTrackingLinkUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceivedTracking")
	@ResponseBody
	public ModelAndView adminGiftsReceivedTracking(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedTrackingDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftReceivedOrderedDataUpdate")
	@ResponseBody
	public ModelAndView adminGiftReceivedOrderedDataUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftReceivedOrderedDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceivedDelivered")
	@ResponseBody
	public ModelAndView adminGiftsReceivedDelivered(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedDeliveredDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRBackOrderedDateDisplay")
	@ResponseBody
	public ModelAndView adminGRBackOrderedDateDisplay(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGRBackOrderedDateDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRBackOrderedDateUpdate")
	@ResponseBody
	public ModelAndView adminGRBackOrderedDateUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGRBackOrderedDateUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceivedBackOrdered")
	@ResponseBody
	public ModelAndView adminGiftsReceivedBackOrdered(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedBackOrderedDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/giftReceivedBackOrderViewDetails")
	@ResponseBody
	public ModelAndView giftReceivedBackOrderViewDetails(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftReceivedBackOrderViewDetails(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRBackInStockStatusUpdate")
	@ResponseBody
	public ModelAndView adminGRBackInStockStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGRBackInStockStatusUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGROutOfStockStatusUpdate")
	@ResponseBody
	public ModelAndView adminGROutOfStockStatusUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedOutOfStockStatusUpdate(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGiftsReceivedOutOfStock")
	@ResponseBody
	public ModelAndView adminGiftsReceivedOutOfStock(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftsReceivedOutOfStockDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/giftReceivedOutOfStockViewDetails")
	@ResponseBody
	public ModelAndView giftReceivedOutOfStockViewDetails(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGiftReceivedOutOfStockViewDetails(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRBackOrderModifyDate")
	@ResponseBody
	public ModelAndView adminGRBackOrderModifyDate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGRBackOrderModifyDateDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminGRBackOrderTextUpdate")
	@ResponseBody
	public ModelAndView adminGRBackOrderTextUpdate(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminGRBackOrderTextUpdateDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRoomFunds")
	@ResponseBody
	public ModelAndView adminRoomFunds(HttpServletRequest req, HttpSession sn) {		
		return adminRegistryDataDisplayService.adminRoomFundsRedirection(req, sn);
	}
	
	
}
