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

import com.nookandcove.service.RegistryShopService;

@Controller
public class RegistryShopController {
	
	@Autowired
	private RegistryShopService registryShopService;	

	

	@RequestMapping(method = RequestMethod.GET, value = "/registryShop")
	@ResponseBody
	public ModelAndView registryShop(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.registryShopRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registryShopSelectedRoom")
	@ResponseBody
	public ModelAndView registryShopSelectedRoom(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.shopSelectedRoomConceptBoardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/previousShopCBProductsDisplay")
	@ResponseBody
	public ModelAndView previousShopCBProductsDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.previousShopCBProductsDisplayFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/nextShopCBProductsDisplay")
	@ResponseBody
	public ModelAndView nextShopCBProductsDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.nextShopCBProductsDisplayFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/shopViewAllDesignsConcepts")
	@ResponseBody
	public ModelAndView shopViewAllDesignsConcepts(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopViewAllDesignsConceptBoards(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewShopDesignSelectedConcepts")
	@ResponseBody
	public ModelAndView viewShopDesignSelectedConcepts(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.viewShopDesignSelectedConceptBoards(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopSelectedCBProductsAddToCart")
	@ResponseBody
	public ModelAndView shopSelectedCBProductsAddToCart(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.shopSelectedCBProductsAddToShoppingCart(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/redirectShopSelectedConceptBoards")
	@ResponseBody
	public ModelAndView redirectShopSelectedConceptBoards(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.redirectShopSelectedProductConceptBoards(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/shopShoppingCartInfoDisplay")
	@ResponseBody
	public ModelAndView shopShoppingCartInfoDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.shopShoppingCartInfoDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartShopCBProductsValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartShopCBProductsValueUpdate(@RequestParam("shopCBProductInfoValue") String shopCBProductsInfoValue, HttpSession sn, HttpServletRequest req) {
		return registryShopService.jSonAddCartShopCBProductsValueUpdateInSn(shopCBProductsInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonShopCBProductsInfoDelete")
	@ResponseBody
	public JSONArray jSonShopCBProductsInfoDelete(@RequestParam("shopCBProductsSavingId") String shopCBProductSavingId, HttpSession sn, HttpServletRequest req) {
		return registryShopService.jSonShopCBProductsInfoDeleteFromSn(shopCBProductSavingId, sn, req);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/shopCheckoutBillShippInfo")
	@ResponseBody
	public ModelAndView shopCheckoutBillShippInfo(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopCheckoutBillingAndShippingInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopBillAndShipInfoSaving")
	@ResponseBody
	public ModelAndView shopBillAndShipInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopBillAndShipInfoSavingInSn(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopCheckoutPaymentInfo")
	@ResponseBody
	public ModelAndView shopCheckoutPaymentInfo(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopCheckoutPaymentInfoRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/shopGiftOrPromoCodePaymentInfo")
	@ResponseBody
	public ModelAndView shopGiftOrPromoCodePaymentInfo(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopGiftOrPromoCodePaymentInfoRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopCartPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView shopCartPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopCartPaymentPurchaseToGatewayRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/shopPaymentSuccess")
	@ResponseBody
	public ModelAndView shopPaymentSuccess(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopPaymentSuccessRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopCartPaymentPurchaseToGatewayWithCC")
	@ResponseBody
	public ModelAndView shopCartPaymentPurchaseToGatewayWithCC(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopCartPaymentPurchaseToGatewayWithCCRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopCouponZeroPaymentPurchaseToGateway")
	@ResponseBody
	public ModelAndView shopCouponZeroPaymentPurchaseToGateway(HttpServletRequest req, HttpSession sn) {
		return registryShopService.shopCouponZeroPaymentPurchaseToGatewayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/shopTermsPopupDisplay")
	@ResponseBody
	public ModelAndView shopTermsPopupDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.shopTermsPopupDisplayDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/shopPrivacyPolicyPopup")
	@ResponseBody
	public ModelAndView shopPrivacyPolicyPopup(HttpServletRequest req, HttpSession sn) {		
		return registryShopService.shopPrivacyPolicyPopupDisplay(req, sn);
	}
	

	
}
