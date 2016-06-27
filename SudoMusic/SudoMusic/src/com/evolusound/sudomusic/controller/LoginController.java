package com.evolusound.sudomusic.controller;

import static com.evolusound.sudomusic.constant.AlertConstants.LOGIN_FAILED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String loginSubmit(@ModelAttribute LoginCommand cmd, Model model) {
		CustomerDTO customerDTO = loginService.checkEmailAndPassword(cmd.getEmail(), cmd.getPassword());
		if (customerDTO == null) {
			model.addAttribute("command", new CustomerDTO());
			model.addAttribute("message", LOGIN_FAILED);
			return "login";
		} else {
			return "redirect:/home";
		}
	}
	
}
