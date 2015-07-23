package com.chinesedreamer.runner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20152:18:04 PM
 * @version beta
 */
@Controller
public class IndexController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model){
		System.out.println("----> login");
		return "login";
	}
}
