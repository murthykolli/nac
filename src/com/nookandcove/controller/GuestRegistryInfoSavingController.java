package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.GuestRegistryInfoSavingService;

@Controller
public class GuestRegistryInfoSavingController {
	
	@Autowired
	private GuestRegistryInfoSavingService guestRgistryInfoSavingService;
	

	@RequestMapping(method = RequestMethod.GET, value = "/findRegistry")
	@ResponseBody
	public ModelAndView findRegistry(HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.findRegistryRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registry/{guestAddress}")
	@ResponseBody
	public ModelAndView guestAddress(@PathVariable String guestAddress, HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.guestSelectByGiftInfo(guestAddress, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirGuestSelectedGiftInfo")
	@ResponseBody
	public ModelAndView reDirGuestSelectedGiftInfo(HttpServletRequest req, HttpSession sn) {
		String regAddressVal = req.getParameter("regAddress");
		return guestRgistryInfoSavingService.reDirGuestSelectedGiftInfoFromDB(regAddressVal, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestRegistryMyAccount")
	@ResponseBody
	public ModelAndView guestRegistryMyAccount(HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.guestSelectedMyAccountInfoFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/spaceContributeInfoRed")
	@ResponseBody
	public ModelAndView spaceContributeInfoRed(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.spaceContributeInfoRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/guestCashFundContributeInfoRed")
	@ResponseBody
	public ModelAndView guestCashFundContributeInfoRed(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestCashFundContributeInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestCustomFundContributeInfoRed")
	@ResponseBody
	public ModelAndView guestCustomFundContributeInfoRed(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestCustomFundContributeInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestCashFundInfoAddToCart")
	@ResponseBody
	public ModelAndView guestCashFundInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestCashFundInfoAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestCustomFundInfoAddToCart")
	@ResponseBody
	public ModelAndView guestCustomFundInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestCustomFundInfoAddToCartRedirection(req, sn);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/cashFundContributeEditInfoRed")
//	@ResponseBody
//	public ModelAndView cashFundContributeEditInfoRed(HttpServletRequest req, HttpSession sn) {
//		return guestRgistryInfoSavingService.cashFundContributeEditInfoRedirection(req, sn);
//	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestConceptBoardContributedInfoDisplay")
	@ResponseBody
	public ModelAndView guestConceptBoardsContributePrice(HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.guestConceptBoardContributedInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestFinishingTouchesContributedInfoDisplay")
	@ResponseBody
	public ModelAndView guestFinishingTouchessContributePrice(HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.guestFinishingTouchesContributedInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regSpacePriceInfoAddToCart")
	@ResponseBody
	public ModelAndView regSpacePriceInfoAddToCart(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.regSpacePriceInfoAddToCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regGuestMyShoppingCart")
	@ResponseBody
	public ModelAndView regGuestMyShoppingCart(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.regGuestMyShoppingCartRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/guestFundsCheckOutNow")
	@ResponseBody
	public ModelAndView guestFundsCheckOutNow(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestFundsCheckOutNowRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regGuestBillingInfoSaving")
	@ResponseBody
	public ModelAndView regGuestBillingInfoSaving(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.regGuestBillingInfoSavingRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regGuestPaymentInfoRed")
	@ResponseBody
	public ModelAndView regGuestPaymentInfoRed(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.regGuestPaymentInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestCartPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView guestCartPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestCartPaymentPurchaseToGatewayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestConceptBoardIndividualInfoDisplay")
	@ResponseBody
	public ModelAndView guestConceptBoardIndividualInfoDisplay(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestConceptBoardIndividualInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestFinishingTouchesIndividualInfoDisplay")
	@ResponseBody
	public ModelAndView guestFinishingTouchesIndividualInfoDisplay(HttpServletRequest req, HttpSession sn) {
		return guestRgistryInfoSavingService.guestFinishingTouchesIndividualInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestConBoardContributedDataUpdate")
	@ResponseBody
	public ModelAndView guestConBoardContributedDataUpdate(HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.guestConBoardContributedDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/guestFinTouchesContributedDataUpdate")
	@ResponseBody
	public ModelAndView guestFinTouchesContributedDataUpdate(HttpServletRequest req, HttpSession sn) {		
		return guestRgistryInfoSavingService.guestFinTouchesContributedDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCashFundContributeValueUpdate")
	@ResponseBody
	public JSONArray jSonCashFundContributeValueUpdate(@RequestParam("cashFundName") String cashFundName, HttpSession sn) {
		return guestRgistryInfoSavingService.jSonCashFundContributeValueUpdateInDB(cashFundName, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCustomFundContributeValueUpdate")
	@ResponseBody
	public JSONArray jSonCustomFundContributeValueUpdate(@RequestParam("cashFundName") String cashFundName, HttpSession sn) {
		return guestRgistryInfoSavingService.jSonCustomFundContributeValueUpdateInDB(cashFundName, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCashFundContributeInfoDelete")
	@ResponseBody
	public JSONArray jSonCashFundContributeInfoDelete(@RequestParam("cashFundName") String cashFundName, HttpSession sn) {
		return guestRgistryInfoSavingService.jSonCashFundContributeInfoDeleteInDB(cashFundName, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCustomFundContributeInfoDelete")
	@ResponseBody
	public JSONArray jSonCustomFundContributeInfoDelete(@RequestParam("cashFundName") String cashFundName, HttpSession sn) {
		return guestRgistryInfoSavingService.jSonCustomFundContributeInfoDeleteInDB(cashFundName, sn);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonRoomFundContributeValueUpdate")
	@ResponseBody
	public JSONArray jSonRoomFundContributeValueUpdate(@RequestParam("roomFundsName") String roomFundsName, HttpSession sn) {
		return guestRgistryInfoSavingService.jSonRoomFundContributeValueUpdateInDB(roomFundsName, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonRoomFundContributeInfoDelete")
	@ResponseBody
	public JSONArray jSonRoomFundContributeInfoDelete(@RequestParam("roomFundsName") String roomFundsName, HttpSession sn) {
		return guestRgistryInfoSavingService.jSonRoomFundContributeInfoDeleteInDB(roomFundsName, sn);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartGuestCBContributedValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartGuestCBContributedValueUpdate(@RequestParam("cbContributedInfoValue") String cbContributedInfoValue, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonAddCartGuestCBContributedValueUpdateInDB(cbContributedInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartGuestCBIndividualValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartGuestCBIndividualValueUpdate(@RequestParam("cbIndividualInfoValue") String cbIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonAddCartGuestCBIndividualValueUpdateInDB(cbIndividualInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonGuestCBContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonGuestCBContributedInfoDelete(@RequestParam("regCBContributedPaymentSavingId") String regCBContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonGuestCBContributedInfoDeleteFromDB(regCBContributedPaymentSavingId, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonGuestCBIndividualInfoDelete")
	@ResponseBody
	public JSONArray jSonGuestCBIndividualInfoDelete(@RequestParam("regCBIndividualPaymentSavingId") String regCBIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonGuestCBIndividualInfoDeleteFromDB(regCBIndividualPaymentSavingId, sn, req);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartGuestFTContributedValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartGuestFTContributedValueUpdate(@RequestParam("ftContributedInfoValue") String ftContributedInfoValue, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonAddCartGuestFTContributedValueUpdateInDB(ftContributedInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartGuestFTIndividualValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartGuestFTIndividualValueUpdate(@RequestParam("ftIndividualInfoValue") String ftIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonAddCartGuestFTIndividualValueUpdateInDB(ftIndividualInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonGuestFTContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonGuestFTContributedInfoDelete(@RequestParam("regFTContributedPaymentSavingId") String regFTContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonGuestFTContributedInfoDeleteFromDB(regFTContributedPaymentSavingId, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonGuestFTIndividualInfoDelete")
	@ResponseBody
	public JSONArray jSonGuestFTIndividualInfoDelete(@RequestParam("regFTIndividualPaymentSavingId") String regFTIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return guestRgistryInfoSavingService.jSonGuestFTIndividualInfoDeleteFromDB(regFTIndividualPaymentSavingId, sn, req);		
	}
	
	


	
	
}
