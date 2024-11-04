package com.nookandcove.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface RegistrantCashFundsService {
	
	public ModelAndView registryCharityFundRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regTopCashFundsInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView regTopCashFundsInfoUpdatingInDB(HttpServletRequest req, HttpSession sn);	
//	public ModelAndView regCashFundContributeInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCashFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView registryEditCashFundRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView registryEditACustomFundRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCashFundBackRedirection(HttpServletRequest req, HttpSession sn);
	public JSONArray jSonCashFundLandingContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn);
		  
//	Custom Fund Coding
	  
	public ModelAndView registryCreateACustomFundRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCustomCashFundsInfoSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCustomCashFundsInfoUpdatingInDB(HttpServletRequest req, HttpSession sn);	
	public ModelAndView uploadCustomCashFundImageInDB(MultipartFile cashFundUploadImg, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView registryEditCustomFundRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCustomFundBackRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCustomCashFundDataEditingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView landingEditImageUploadCustomFundInDB(MultipartFile cashFundUploadImg, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView registryEditUploadedCustomFundRedirection(HttpServletRequest req, HttpSession sn, long regCustomFundsId);
	public JSONArray jSonCustomFundLandingContributedInfoDeleteFromDB(String regCBCotributedSavingId, HttpServletRequest req, HttpSession sn);
//	public ModelAndView regCustomFundContributeInfoRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regCustomFundInfoAddToCartRedirection(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();	
}
