package com.hotelBooking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";

		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			model.put("message", this.message);
			return "welcome";
		}

		
		@RequestMapping("/welcome")
		public String login(Map<String, Object> model) {
			model.put("message", this.message);
			return "index";
		}
}
