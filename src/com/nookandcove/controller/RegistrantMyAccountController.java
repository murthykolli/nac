package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.RegistrantMyAccountService;

@Controller
public class RegistrantMyAccountController {
	
	@Autowired
	private RegistrantMyAccountService registrantMyAccountService;

	@RequestMapping(method = RequestMethod.GET, value = "/registryMyAccount")
	@ResponseBody
	public ModelAndView registryMyAccount(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMyAccountRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantAccountInfoUpdate")
	@ResponseBody
	public ModelAndView registrantAccountInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantAccountInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryPasswordChange")
	@ResponseBody
	public ModelAndView registryPasswordChange(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryPasswordChangeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantPasswordInfoUpdate")
	@ResponseBody
	public ModelAndView registrantPasswordInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantPasswordInfoUpdateInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registryEventInfoChange")
	@ResponseBody
	public ModelAndView registryEventInfoChange(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryEventInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantEventInfoUpdate")
	@ResponseBody
	public ModelAndView registrantEventInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantEventInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryURLInfoChange")
	@ResponseBody
	public ModelAndView registryURLInfoChange(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryURLInfoChangeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrantURLInfoUpdate")
	@ResponseBody
	public ModelAndView registrantURLInfoUpdate(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantURLInfoUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryPrivacyInfoChange")
	@ResponseBody
	public ModelAndView registryPrivacyInfoChange(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryPrivacyInfoChangeRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regGiveVisibleToGuest")
	@ResponseBody
	public ModelAndView regGiveVisibleToGuest(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.regGiveVisibleToGuestRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regNotGiveVisibleToGuest")
	@ResponseBody
	public ModelAndView regNotGiveVisibleToGuest(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.regGiveNotVisibleToGuestRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiShippingInfoDsp")
	@ResponseBody
	public ModelAndView regiShippingInfoDsp(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantShippingInfoDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registrantShippingInfoSaving")
	@ResponseBody
	public ModelAndView registrantShippingInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantShippingInfoSavingInDataBaseTable(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiMyOrderDsp")
	@ResponseBody
	public ModelAndView regiMyOrderDsp(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantMyOrderDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiGiftsReceivedDsp")
	@ResponseBody
	public ModelAndView regiGiftsReceivedDsp(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.conceptBoardsGiftsReceivedDataDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiRoomFundsDsp")
	@ResponseBody
	public ModelAndView regiRoomFundsDsp(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantRoomFundsDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiCashFundsDsp")
	@ResponseBody
	public ModelAndView regiCashFundsDsp(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantCashFundsDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiCashFundsBankAccounts")
	@ResponseBody
	public ModelAndView regiCashFundsBankAccounts(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.regiCashFundsBankAccountsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regiStoreCreditDsp")
	@ResponseBody
	public ModelAndView regiStoreCreditDsp(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registrantStoreCreditDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cashFundBankAccountInfoSaving")
	@ResponseBody
	public ModelAndView cashFundBankAccountInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.cashFundBankAccountInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestTransferRequestUpdate")
	@ResponseBody
	public ModelAndView guestTransferRequestUpdate(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.guestTransferRequestUpdateInDataBase(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryTransferRequestUpdate")
	@ResponseBody
	public ModelAndView registryTransferRequestUpdate(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryTransferRequestUpdateInDataBase(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMACBIndividualConToStoreCredit")
	@ResponseBody
	public ModelAndView regMACBIndividualConToStoreCredit(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryCBIndividualConvertedtoStoreCredit(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestMACBIndividualConToStoreCredit")
	@ResponseBody
	public ModelAndView guestMACBIndividualConToStoreCredit(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.guestCBIndividualConvertedtoStoreCredit(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestMACBIndividualShopNow")
	@ResponseBody
	public ModelAndView myAccountGuestCBShopNowRed(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.guestMACBIndividualShopNowRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryMACBIndividualShopNow")
	@ResponseBody
	public ModelAndView registryMACBIndividualShopNow(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMACBIndividualShopNowRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMACBContributedConToStoreCredit")
	@ResponseBody
	public ModelAndView regMACBContributedConToStoreCredit(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMACBContributedConToStoreCredit(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMACBContributedConToStoreCreditInBOTD")
	@ResponseBody
	public ModelAndView regMACBContributedConToStoreCreditInBOTD(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.regMACBContributedConToStoreCreditInBOTD(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMACBContributedShopNow")
	@ResponseBody
	public ModelAndView regMACBContributedShopNow(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMACBContributedShopNowRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestMAFTIndividualShopNow")
	@ResponseBody
	public ModelAndView guestMAFTIndividualShopNow(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.guestMAFTIndividualShopNowRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestMAFTIndividualConToStoreCredit")
	@ResponseBody
	public ModelAndView guestMAFTIndividualConToStoreCredit(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.guestFTIndividualConvertedtoStoreCredit(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryMAFTIndividualShopNow")
	@ResponseBody
	public ModelAndView registryMAFTIndividualShopNow(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMAFTIndividualShopNowRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMAFTIndividualConToStoreCredit")
	@ResponseBody
	public ModelAndView regMAFTIndividualConToStoreCredit(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryFTIndividualConvertedtoStoreCredit(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMAFTContributedConToStoreCredit")
	@ResponseBody
	public ModelAndView regMAFTContributedConToStoreCredit(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMAFTContributedConToStoreCredit(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMAFTContributedConToStoreCreditInBOTD")
	@ResponseBody
	public ModelAndView regMAFTContributedConToStoreCreditInBOTD(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.regMAFTContributedConToStoreCreditInBOTD(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regMAFTContributedShopNow")
	@ResponseBody
	public ModelAndView regMAFTContributedShopNow(HttpServletRequest req, HttpSession sn) {
		return registrantMyAccountService.registryMAFTContributedShopNowRedirection(req, sn);
	}
	
}
