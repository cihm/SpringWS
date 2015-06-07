package com.cihm.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cihm.pojo.Person;

//Return json data type directluy

@RestController
@RequestMapping(value = "/ws")
public class ReturnJsonController {
	 
	
	//Get method
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public List<Person> insertUsert(@RequestParam String name,
			 @RequestParam int age 
			) {
		
		System.out.println("======" + name  + age);
		List<Person> listP = new ArrayList<Person>();
		Person p1 = new Person(age,name);
		Person p2 = new Person(age,name);
		listP.add(p1);
		listP.add(p2);
		return listP;
	}
	
	
	//Let url path as var
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ArrayList<String> getUser(@PathVariable int id) {
		System.out.print("i m  in :" + id);
		return new ArrayList<String>();
	}
	
	
	//Get method
	@RequestMapping(value = "/testGet/", method = RequestMethod.GET)
	public ArrayList<String> testGet(
			@RequestParam(
			value = "keyword", required = false, defaultValue = "World") 
			String keyword) {

		System.out.print("i m  in :" + keyword);
		ArrayList<String> result = new ArrayList<String>();
		result.add(keyword);
		result.add(keyword + "2");
		result.add(keyword + "3");
		return result;
	}
	
	
	//Post method
	@RequestMapping(value = "/testPost/", method = RequestMethod.POST)
	public ArrayList<String> testPost(
			@RequestParam(
			value = "keyword", required = false, defaultValue = "World") 
			String keyword) {

		System.out.print("i m  in :" + keyword);
		ArrayList<String> result = new ArrayList<String>();
		result.add(keyword);
		result.add(keyword + ":post");
		result.add(keyword + ":postt");
		return result;
	}
	
	
}
