package com.evolusound.sudomusic.controller;
 
import static com.evolusound.sudomusic.constant.AlertConstants.DEFAULT_GREETING;
import static com.evolusound.sudomusic.constant.AlertConstants.WELCOME_GREETING;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evolusound.sudomusic.data_transfer.CustomerDTO;

@Controller
public class HomeController {
 
	@RequestMapping("/home")
	public ModelAndView getPage() {
		ModelAndView modelAndView;
		Boolean customerLoggedIn = true; //TODO retrieve from session cookie
		if (customerLoggedIn) {
			modelAndView = new ModelAndView("home", "message", WELCOME_GREETING);
			CustomerDTO dummyCustomer = new CustomerDTO(); //TODO retrieve from session cookie
			modelAndView.addObject("customer", dummyCustomer);
		} else {
			modelAndView = new ModelAndView("home", "message", DEFAULT_GREETING);
		}
		return modelAndView;
	}
}