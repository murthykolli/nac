package com.nookandcove.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface PortfolioService {
	
	public ModelAndView portfolioRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView pricingRedirection(HttpServletRequest req, HttpSession sn);		
	public Timestamp currentDate();	
}
