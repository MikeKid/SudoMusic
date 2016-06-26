package com.evolusound.sudomusic.controller;

import static com.evolusound.sudomusic.constant.AlertConstants.LOGIN_FAILED;
import static com.evolusound.sudomusic.constant.AlertConstants.WELCOME_GREETING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evolusound.sudomusic.command.LoginCommand;
import com.evolusound.sudomusic.data_transfer.CustomerDTO;
import com.evolusound.sudomusic.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getPage() {
		return new ModelAndView("login", "command", new LoginCommand());
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginSubmit(@ModelAttribute LoginCommand cmd) {
		CustomerDTO customerDTO = loginService.checkEmailAndPassword(cmd.getEmail(), cmd.getPassword());
		if (customerDTO == null) {
			ModelAndView modelAndView = new ModelAndView("login", "command", new CustomerDTO());
			modelAndView.addObject("message", LOGIN_FAILED);
			return modelAndView;
		} else {
			return new ModelAndView("home", "message", WELCOME_GREETING);
		}
	}
	
}
