package com.evolusound.sudomusic.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
 
	@RequestMapping("/error")
	public ModelAndView getPage() {
		return new ModelAndView("error");
	}
}