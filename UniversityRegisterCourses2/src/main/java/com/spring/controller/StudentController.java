package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.studentservice.StudentService;
import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	private static final String CONTEXT_PATH = "student";
	
	@Autowired
	private StudentService studentService;
	
	// 학생 전체 조회
	@RequestMapping("/listStudent")
	public ModelAndView listStudent(@ModelAttribute StudentVO param) {
		List<StudentVO> list = studentService.listStudent(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("studentList", list);
		mav.setViewName(CONTEXT_PATH + "/student");
		
		return mav;
	}
	
	// 학생정보 팝업창
	@RequestMapping("/selectStudent")
	public ModelAndView selectStudent(@ModelAttribute SubjectVO param, @RequestParam("no") int no) {
		
		// 학과 번호 조회
		List<SubjectVO> numList = studentService.selectSubjectNum(param);
		
		ModelAndView mav = new ModelAndView();
		
		if(no == 0) {	// 등록 버튼 클릭시
			mav.addObject("mode", "insert");
			mav.addObject("subjectNum", numList);	// 학과번호
		} else {
			mav.addObject("mode", "update");
			mav.addObject("StudentVO", studentService.selectStudent(no));
		}
		
		mav.setViewName(CONTEXT_PATH + "/student_pop");
		
		return mav;
	}
	
	// 학생 등록
	@RequestMapping("/insertStudent")
	public ModelAndView insertStudent(@ModelAttribute StudentVO param) {
		String resultStr = "";
		int result = studentService.insertStudent(param);
		
		if(result > 0) {
			resultStr = "학생 등록이 완료 되었습니다.";
		} else {
			resultStr = "학생 동록이 실패 하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
}
