package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.subject.service.SubjectService;
import com.spring.subject.vo.SubjectVO;

@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	// 뷰 밑에 있는 폴더명
	private String CONTEXT_PATH = "subject";
	
	/* 학과 전체 목록 조회 */
	@RequestMapping(value = "/listSubject")
	public ModelAndView listSubject(@ModelAttribute SubjectVO param) {
		
		List<SubjectVO> list = subjectService.listSubject(param);
		
		ModelAndView mav = new ModelAndView();
		
		// jsp에서 읽는 객체명
		mav.addObject("subjectList", list);
		// 폴더 밑에 있는 jsp 명
		mav.setViewName(CONTEXT_PATH + "/subject");
		
		return mav;
	}
}
