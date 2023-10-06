package com.care.wanted;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.wanted.common.service.impl.CommonServiceImpl;
import com.care.wanted.dtos.PostDto;

@Controller
public class HomeController {
	
	@Autowired
	CommonServiceImpl common;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value =  "/company",  method = RequestMethod.GET)
	public String company() {
		return "company/company";
	}
	
	@RequestMapping( value = "/company/login",  method = RequestMethod.GET)
	public String companyLogin() {
		return "company/companyLogin";
	}
	
	@RequestMapping( value =  "/user",  method = RequestMethod.GET)
	public String user() {
		return "user/user";
	}
	
	@RequestMapping( value = "/user/login",  method = RequestMethod.GET)
	public String userLogin() {
		return "user/userLogin";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<PostDto> posts = common.getList();
		model.addAttribute("posts", posts);
		return "user/list";
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String post(Model model, @PathVariable("id")Integer id) {
		PostDto post = common.getDetail(id);
		model.addAttribute("post", post);
		return "user/post";
	}
}
