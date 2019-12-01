package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BekerController {
	@RequestMapping(value =  {"/beker"})
	   public String index() {
	      return "beker";
	   }
}
