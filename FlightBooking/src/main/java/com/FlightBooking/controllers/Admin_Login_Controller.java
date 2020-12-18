package com.FlightBooking.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.FlightBooking.services.Admin_Login_Services;

@Controller
public class Admin_Login_Controller {
	@RequestMapping(value="/admin-login", method=RequestMethod.GET)
	
	public ModelAndView adminLogin(HttpServletRequest req, HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String password=req.getParameter("password");
	
	    ModelAndView mv=new ModelAndView();
		if(new Admin_Login_Services().check(name, password))
		{
			mv.addObject("name",name);
			mv.setViewName("Welcome.jsp");
		}else {
			mv.setViewName("adminlogin.jsp");
		}
	    
	    return mv;
