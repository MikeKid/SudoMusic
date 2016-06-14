package com.evolusound.sudomusic.controller;

import static com.evolusound.sudomusic.constant.AlertConstants.CONTACT_FORM_SENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evolusound.sudomusic.command.ContactFormCommand;
import com.evolusound.sudomusic.service.ContactFormService;

@Controller
public class ContactFormController {

	@Autowired
	ContactFormService contactFormService;
	
	@RequestMapping("/contactForm")
	public ModelAndView getPage() {
		return new ModelAndView("contactForm");
	}
	
	@RequestMapping(value="/contactForm", method=RequestMethod.POST)
	public ModelAndView registerSubmit(@ModelAttribute ContactFormCommand cmd) {
		Errors errors = contactFormService.validateContactForm(cmd);
		if (!errors.hasErrors()) {
			contactFormService.sendForm(cmd);
			ModelAndView modelAndView = new ModelAndView("contactForm");
			modelAndView.addObject("infoMessage", CONTACT_FORM_SENT);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("contactForm");
			modelAndView.addObject("errors", errors.getFieldErrors());
			modelAndView.addAllObjects(cmd.toMap());
			return modelAndView;
		}
	}
	
}
