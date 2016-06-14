package com.evolusound.sudomusic.controller;
 
import static com.evolusound.sudomusic.constant.AlertConstants.DEFAULT_GREETING;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
 
	@RequestMapping("/welcome")
	public ModelAndView getPage() {
		return new ModelAndView("welcome", "message", DEFAULT_GREETING);
	}
}