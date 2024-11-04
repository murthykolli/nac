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

import com.nookandcove.service.RegistryConceptBoardsService;

@Controller
public class RegistryConceptBoardsController {
	
	@Autowired
	private RegistryConceptBoardsService registryConceptBoardsService;	

	

	@RequestMapping(method = RequestMethod.GET, value = "/designCuratedConceptsBoards")
	@ResponseBody
	public ModelAndView designCuratedConceptsBoards(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.designCuratedConceptsBoardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/regCuratedSelectedRoom")
	@ResponseBody
	public ModelAndView regCuratedSelectedRoom(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.registrySelectedConceptBoardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/previousCBProductsDisplay")
	@ResponseBody
	public ModelAndView previousCBProductsDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.registryPreviousCBProductsDisplay(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/nextCBProductsDisplay")
	@ResponseBody
	public ModelAndView nextCBProductsDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.registryNextCBProductsDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registryViewAllDesigns")
	@ResponseBody
	public ModelAndView registryViewAllDesigns(HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.registryViewAllDesignsConceptBoards(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/viewDesignSelectedConcepts")
	@ResponseBody
	public ModelAndView viewDesignSelectedConcepts(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.viewDesignSelectedConceptBoards(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/registrySelectedCBdInfoSaving")
	@ResponseBody
	public ModelAndView registrySelectedCBdInfoSaving(HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.registrantConceptBoardInfoSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/redirectRegistrySelectedConceptBoards")
	@ResponseBody
	public ModelAndView redirectRegistrySelectedConceptBoards(HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.redirectRegistrySelectedConceptBoardsData(req, sn);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/regCuratedSelectedRoom")
//	@ResponseBody
//	public ModelAndView regCuratedSelectedRoom(HttpServletRequest req, HttpSession sn) {		
//		return registryConceptBoardsService.regCuratedSelectedRoomRedirection(req, sn);
//	}

//	@RequestMapping(method = RequestMethod.POST, value = "/registrySelectedRoomOnlyRed")
//	@ResponseBody
//	public ModelAndView registrySelectedRoomOnlyRed(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.registrySelectedRoomOnlyRedirection(req, sn);
//	}

//	@RequestMapping(method = RequestMethod.POST, value = "/registrySelectedStyleAndRoomBothRed")
//	@ResponseBody
//	public ModelAndView registrySelectedStyleAndRoomBothRed(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.registrySelectedStyleAndRoomBothRedirection(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/registrySelectedStyleRoomAndPriceRed")
//	@ResponseBody
//	public ModelAndView registrySelectedStyleRoomAndPriceRed(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.registrySelectedStyleRoomAndPriceRedirection(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/registryUnCheckStyleAndPriceBoxesRed")
//	@ResponseBody
//	public ModelAndView registryUnCheckStyleAndPriceBoxesRed(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.registryUnCheckStyleAndPriceBoxesRedirection(req, sn);
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/viewRegDesnCuratedConceptBoards")
//	@ResponseBody
//	public ModelAndView viewRegDesnCuratedConceptBoards(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.viewRegistryDesignCuratedConceptBoards(req, sn);
//	}

//	@RequestMapping(method = RequestMethod.GET, value = "/redirectViewRegDesnCuratedConceptBoards")
//	@ResponseBody
//	public ModelAndView redirectViewRegDesnCuratedConceptBoards(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.redirectViewRegistryDesignCuratedConceptBoards(req, sn);
//	}

	
//	@RequestMapping(method = RequestMethod.POST, value = "/registrantConceptBoardInfoSaving")
//	@ResponseBody
//	public ModelAndView registrantConceptBoardInfoSaving(HttpServletRequest req, HttpSession sn) {
//		return registryConceptBoardsService.registrantConceptBoardInfoSavingInDB(req, sn);
//	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/registrantConBoardProductInfoDeleteFromCart")
//	@ResponseBody
//	public ModelAndView registrantConBoardProductInfoDeleteFromCart(HttpServletRequest req, HttpSession sn) {		
//		return registryConceptBoardsService.registrantConBoardProductInfoDeleteFromCartDB(req, sn);
//	}

//	@RequestMapping(method = RequestMethod.GET, value = "/registrantSelectedConBoardQuantityUpdateIntoCart")
//	@ResponseBody
//	public ModelAndView registrantSelectedConBoardQuantityUpdateIntoCart(HttpServletRequest req, HttpSession sn) {		
//		return registryConceptBoardsService.registrantSelectedConBoardQuantityUpdateIntoCartInDB(req, sn);
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/regCBContributedSelectedProductEdit")
	@ResponseBody
	public ModelAndView registrantConBoardProductsInfoEdit(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.registrantCBContributedSelectedProductEditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regCBIndividualSelectedProductEdit")
	@ResponseBody
	public ModelAndView regCBIndividualSelectedProductEdit(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.registrantCBIndividualSelectedProductEditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regCBContributedSelectedProductDataUpdate")
	@ResponseBody
	public ModelAndView registrantSelectedConBoardProductsDataSaving(HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.regCBContributedSelectedProductDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonConceptBoardsContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonConceptBoardsContributedInfoDelete(@RequestParam("regCBCotributedSavingId") String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.jSonConceptBoardsContributedInfoDeleteFromDB(regCBCotributedSavingId, req, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonConceptBoardsIndividualInfoDelete")
	@ResponseBody
	public JSONArray jSonConceptBoardsIndividualInfoDelete(@RequestParam("regCBIndividualSavingId") String regCBIndividualSavingId, HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.jSonConceptBoardsIndividualInfoDeleteFromDB(regCBIndividualSavingId, req, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonConceptBoardsIndividualInfoAddToCart")
	@ResponseBody
	public JSONArray jSonConceptBoardsIndividualInfoAddToCart(@RequestParam("regCBIndividualCombVal") String regCBIndividualCombVal, HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.jSonConceptBoardsIndividualInfoAddToCartRedirection(regCBIndividualCombVal, req, sn);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regConceptBoardContributedInfoDisplay")
	@ResponseBody
	public ModelAndView regConceptBoardContributedInfoDisplay(HttpServletRequest req, HttpSession sn) {		
		return registryConceptBoardsService.registrantConceptBoardContributedInfoDisplay(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regConBoardContributedDataUpdate")
	@ResponseBody
	public ModelAndView regConBoardContributedDataUpdate(HttpServletRequest req, HttpSession sn) {
		return registryConceptBoardsService.registrantConceptBoardContributedDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartCBContributedValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartCBContributedValueUpdate(@RequestParam("cbContributedInfoValue") String cbContributedInfoValue, HttpSession sn, HttpServletRequest req) {
		return registryConceptBoardsService.jSonAddCartCBContributedValueUpdateInDB(cbContributedInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonAddCartCBIndividualValueUpdate")
	@ResponseBody
	public JSONArray jSonAddCartCBIndividualValueUpdate(@RequestParam("cbIndividualInfoValue") String cbIndividualInfoValue, HttpSession sn, HttpServletRequest req) {
		return registryConceptBoardsService.jSonAddCartCBIndividualValueUpdateInDB(cbIndividualInfoValue, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCBContributedInfoDelete")
	@ResponseBody
	public JSONArray jSonCBContributedInfoDelete(@RequestParam("regCBContributedPaymentSavingId") String regCBContributedPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return registryConceptBoardsService.jSonCBContributedInfoDeleteFromDB(regCBContributedPaymentSavingId, sn, req);		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jSonCBIndividualInfoDelete")
	@ResponseBody
	public JSONArray jSonCBIndividualInfoDelete(@RequestParam("regCBIndividualPaymentSavingId") String regCBIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req) {
		return registryConceptBoardsService.jSonCBIndividualInfoDeleteFromDB(regCBIndividualPaymentSavingId, sn, req);		
	}


	
}
