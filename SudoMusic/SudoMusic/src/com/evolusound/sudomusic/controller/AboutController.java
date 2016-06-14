package com.evolusound.sudomusic.controller;

import static com.evolusound.sudomusic.constant.SystemConstants.LONG_DESCRIPION;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

	@RequestMapping(value="/about", method=RequestMethod.GET)
	public ModelAndView getPage() {
		return new ModelAndView("about", "aboutUsText", LONG_DESCRIPION);
	}
	
}
