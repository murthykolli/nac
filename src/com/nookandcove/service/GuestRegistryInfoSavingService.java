package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface GuestRegistryInfoSavingService {

	public ModelAndView findRegistryRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestUserNullValuesDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestSelectByGiftInfo(String guestAddress, HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirGuestSelectedGiftInfoFromDB(String regiAddress, HttpServletRequest req, HttpSession sn);
	public ModelAndView guestSelectedMyAccountInfoFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView spaceContributeInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestCashFundContributeInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestCustomFundContributeInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestCashFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestCustomFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestConceptBoardContributedInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestFinishingTouchesContributedInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView regSpacePriceInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regGuestMyShoppingCartRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestFundsCheckOutNowRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regGuestBillingInfoSavingRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regGuestPaymentInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestCartPaymentPurchaseToGatewayRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView guestConceptBoardIndividualInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestFinishingTouchesIndividualInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestConBoardContributedDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestFinTouchesContributedDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonCashFundContributeValueUpdateInDB(String cashFundName, HttpSession sn);
	public JSONArray jSonCustomFundContributeValueUpdateInDB(String cashFundName, HttpSession sn);
	public JSONArray jSonCashFundContributeInfoDeleteInDB(String cashFundsId, HttpSession sn);
	public JSONArray jSonCustomFundContributeInfoDeleteInDB(String customFundName, HttpSession sn);
	public JSONArray jSonRoomFundContributeValueUpdateInDB(String roomFundsName, HttpSession sn);
	public JSONArray jSonRoomFundContributeInfoDeleteInDB(String roomFundsName, HttpSession sn);
	
	public JSONArray jSonAddCartGuestCBContributedValueUpdateInDB(String cbContributedInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonAddCartGuestCBIndividualValueUpdateInDB(String cbContributedInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonGuestCBContributedInfoDeleteFromDB(String regiCBContributedPaymentSavingId, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonGuestCBIndividualInfoDeleteFromDB(String regiCBIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req);
	
	public JSONArray jSonAddCartGuestFTContributedValueUpdateInDB(String ftContributedInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonAddCartGuestFTIndividualValueUpdateInDB(String ftIndividualInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonGuestFTContributedInfoDeleteFromDB(String regiFTContributedPaymentSavingId, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonGuestFTIndividualInfoDeleteFromDB(String regiFTIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req);
	
	public Timestamp currentDate();
}