package com.evolusound.sudomusic.controller;

import static com.evolusound.sudomusic.constant.AlertConstants.REGISTER_SUCCESSFUL;
import static com.evolusound.sudomusic.constant.AlertConstants.REGISTER_DEFAULT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evolusound.sudomusic.data_transfer.CustomerDTO;
import com.evolusound.sudomusic.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired RegisterService registerService;

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView getPage() {
		return new ModelAndView("register", "message", REGISTER_DEFAULT);
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerSubmit(@ModelAttribute CustomerDTO customer) {
		Errors errors = registerService.validateCustomer(customer);
		if (!errors.hasErrors()) {
			registerService.addCustomerAndPassword(customer);
			return new ModelAndView("register", "message", REGISTER_SUCCESSFUL);
		} else {
			return new ModelAndView("register", "message", "mandatoryFieldEmpty.name.error"/*errors.getAllErrors()*/); //TODO use errors strategy
		}
	}	
}
