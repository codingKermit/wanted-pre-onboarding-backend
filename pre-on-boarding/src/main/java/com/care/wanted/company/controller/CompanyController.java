package com.care.wanted.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care.wanted.common.service.impl.CommonServiceImpl;
import com.care.wanted.company.service.impl.CompanyServiceImpl;
import com.care.wanted.dtos.CompanyDto;
import com.care.wanted.dtos.PostDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyServiceImpl service;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CommonServiceImpl common;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(CompanyDto dto) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.login(dto);
		if(result) {
			mv.setViewName("company/company");
		} else {
			String message = "로그인에 실패했습니다";
			mv.setViewName("company/companyLogin");
			mv.addObject("msg", message);
		}
		return mv;
	}

	@RequestMapping( value = "/insert",  method = RequestMethod.POST)
	public ModelAndView insert(PostDto dto) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.insert(dto);
		String msg = "";
		if(result) {
			msg = "저장 성공";
		} else {
			msg = "저장 실패";
		}
		mv.addObject("msg",msg);
		mv.setViewName("company/insert");
		return mv;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String inserView(PostDto dto) {
		return "company/insert";
	}
	
	@RequestMapping( value = "/update", method = RequestMethod.POST)
	public ModelAndView update(PostDto dto) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.update(dto);
		mv.addObject("post", dto);
		mv.setViewName("company/updateForm");
		return mv;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateView(Model model) {
		
		List<PostDto> posts = common.recommand();
		model.addAttribute("posts", posts);
		return "company/update";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateForm(Model model, @PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("company/updateForm");
		PostDto dto = common.getDetail(id);
		mv.addObject("post", dto);
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("postNum") String[] postNum) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.delete(postNum);

		String message = "";
		if(result) {
			message = "성공적으로 삭제했습니다";
		} else {
			message = "삭제에 실패했습니다";
		}
		List<PostDto> posts = common.recommand();
		mv.addObject("posts", posts);
		mv.addObject("msg", message);
		mv.setViewName("company/delete");
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteView() {
		ModelAndView mv = new ModelAndView();
		List<PostDto> posts = common.recommand();
		mv.addObject("posts", posts);
		mv.setViewName("company/delete");
		return mv;
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<PostDto> posts = common.getList();
		mv.addObject("posts", posts);
		mv.setViewName("company/list");
		return mv;
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public ModelAndView post(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		PostDto post = common.getDetail(id);
		mv.addObject("post", post);
		mv.setViewName("company/post");
		return mv;
	}
}
