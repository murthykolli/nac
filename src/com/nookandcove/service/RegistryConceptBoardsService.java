package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface RegistryConceptBoardsService {
	
	public ModelAndView designCuratedConceptsBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrySelectedConceptBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryPreviousCBProductsDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryNextCBProductsDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView registryViewAllDesignsConceptBoards(HttpServletRequest req, HttpSession sn);
	public ModelAndView viewDesignSelectedConceptBoards(HttpServletRequest req, HttpSession sn);
	public ModelAndView redirectRegistrySelectedConceptBoardsData(HttpServletRequest req, HttpSession sn);
	
//	public ModelAndView regCuratedSelectedRoomRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView registrySelectedRoomOnlyRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView registrySelectedStyleAndRoomBothRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView registrySelectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView registryUnCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView viewRegistryDesignCuratedConceptBoards(HttpServletRequest req, HttpSession sn);
//	public ModelAndView redirectViewRegistryDesignCuratedConceptBoards(HttpServletRequest req, HttpSession sn);
		
	public ModelAndView registrantConceptBoardInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantConceptBoardContributedInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate);
	public ModelAndView registrantConceptBoardIndividualInfoSavingInDB(HttpServletRequest req, HttpSession sn, long adminRegCBFSpecsSavingId, String groupGiftRefferance, int quantity, String regiProductPrice, String regiDescription, String regiProductHeading, Timestamp currentDate);
	public String registryConceptBoardsContributedProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public String registryConceptBoardsIndividualProductsDisplay(HttpServletRequest req, HttpSession sn, long registrantUserId);
	
	
//	public ModelAndView registrantConBoardProductInfoDeleteFromCartDB(HttpServletRequest req, HttpSession sn);
//	public ModelAndView registrantSelectedConBoardQuantityUpdateIntoCartInDB(HttpServletRequest req, HttpSession sn);
	public int registryTotalConceptBoardsIndividualCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId);
	public int registryTotalConceptBoardsContributedCartCount(HttpServletRequest req, HttpSession sn, long registrantUserId);
	
	public ModelAndView registrantCBContributedSelectedProductEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantCBIndividualSelectedProductEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCBContributedSelectedProductDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonConceptBoardsContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn);
	public JSONArray jSonConceptBoardsIndividualInfoDeleteFromDB(String regCBIndividualSavingId, HttpServletRequest req, HttpSession sn);
	public JSONArray jSonConceptBoardsIndividualInfoAddToCartRedirection(String regCBIndividualCombVal, HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantConceptBoardContributedInfoDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView registrantConceptBoardContributedDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public String registrantCBContributedAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn);
	public String registrantCBIndividualAddToCartInfoDisplay(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonAddCartCBContributedValueUpdateInDB(String cbContributedInfoValue, HttpSession sn, HttpServletRequest req);
	public double registrantCBContributedAddCartTotalPrice(HttpServletRequest req, HttpSession sn);
	public double registrantCBIndividualAddCartTotalPrice(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonAddCartCBIndividualValueUpdateInDB(String cbIndividualInfoValue, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonCBContributedInfoDeleteFromDB(String regiCBContributedPaymentSavingId, HttpSession sn, HttpServletRequest req);
	public JSONArray jSonCBIndividualInfoDeleteFromDB(String regiCBIndividualPaymentSavingId, HttpSession sn, HttpServletRequest req);
	public String registrantConceptBoardsPaymentInfoUpdateInDB(HttpSession sn, HttpServletRequest req, long registrantUserId, String paymentStatus, long regiPaymentInfoSavingId);

	public Timestamp currentDate();
}