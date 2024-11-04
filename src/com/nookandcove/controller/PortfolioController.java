package com.nookandcove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.PortfolioService;

@Controller
public class PortfolioController {
	
	@Autowired
	private PortfolioService portfolioService;	
	
	@RequestMapping(method = RequestMethod.GET, value = "/portfolio")
	@ResponseBody
	public ModelAndView portfolio(HttpServletRequest req, HttpSession sn) {
		return portfolioService.portfolioRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pricing")
	@ResponseBody
	public ModelAndView pricing(HttpServletRequest req, HttpSession sn) {
		return portfolioService.pricingRedirection(req, sn);
	}
	
	
}
