package com.nookandcove.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface RegistrantMyAccountService {
	public ModelAndView registryMyAccountRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantAccountInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryPasswordChangeRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantPasswordInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryEventInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantEventInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryURLInfoChangeRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantURLInfoUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryPrivacyInfoChangeRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regGiveVisibleToGuestRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regGiveNotVisibleToGuestRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantShippingInfoDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantShippingInfoSavingInDataBaseTable(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantMyOrderDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView conceptBoardsGiftsReceivedDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantRoomFundsDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantCashFundsDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regiCashFundsBankAccountsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantStoreCreditDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView cashFundBankAccountInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestTransferRequestUpdateInDataBase(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryTransferRequestUpdateInDataBase(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView registryCBIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestCBIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestMACBIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryMACBIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView registryMACBContributedConToStoreCredit(HttpServletRequest req, HttpSession sn);
	public ModelAndView regMACBContributedConToStoreCreditInBOTD(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryMACBContributedShopNowRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView guestMAFTIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView guestFTIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryMAFTIndividualShopNowRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryFTIndividualConvertedtoStoreCredit(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryMAFTContributedConToStoreCredit(HttpServletRequest req, HttpSession sn);
	public ModelAndView regMAFTContributedConToStoreCreditInBOTD(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryMAFTContributedShopNowRedirection(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();
}