package com.cihm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HellowWorldController {
 
	private static final Logger logger = LoggerFactory.getLogger(HellowWorldController.class);
 
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView welcome(@PathVariable("name") String name) {
 
		logger.debug("welcome() - name {}", name);
 
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);
 
		return model;
 
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getdata() {
 
		List<String> list = getList();
 
		//return back to index.jsp
		ModelAndView model = new ModelAndView();
		model.setViewName("list");
		model.addObject("lists", list);
 
		return model;
 
	}
 
	private List<String> getList() {
 
		List<String> list = new ArrayList<String>();
		list.add("List lewis");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");
 
		return list;
 
	}
 
}