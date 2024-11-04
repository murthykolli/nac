package com.nookandcove.serviceimpl;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.PortfolioService;

//@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class PortfolioServiceImpl implements PortfolioService {
	
	private String firstNamesInSn = "firstNameInSn";
	private String userIdInSn = "userIdInSn";
	private String flName = "flName";
	private String totalCartItemsCountInSN = "totalCartItemsCountInSN";
	private String totalCartItemsCount = "totalCartItemsCount";
		
    @Override
    @Transactional
    public ModelAndView portfolioRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("portfolioRedirectionAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else {
    		mav = new ModelAndView("portfolioRedirectionBL");
    	}
    	return mav;
    }    
	
    @Override
    @Transactional
    public ModelAndView pricingRedirection(HttpServletRequest req, HttpSession sn) {
    	ModelAndView mav;
    	if(null != sn.getAttribute(userIdInSn)) {
    		mav = new ModelAndView("priceRedirectionAL");
    		mav.addObject(flName, sn.getAttribute(firstNamesInSn));
    		mav.addObject(totalCartItemsCount, sn.getAttribute(totalCartItemsCountInSN));
    	} else {
    		mav = new ModelAndView("priceRedirectionBL");
    	}
    	return mav;
    }

	@Override
	@Transactional
	public Timestamp currentDate() {
//		Date date= new Date();
//		long time = date.getTime();
//		Timestamp currentDate = new Timestamp(time);		 
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		return currentDate;
	}

}