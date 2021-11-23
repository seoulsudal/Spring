package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.subjectservice.SubjectService;
import com.spring.subjectvo.SubjectVO;

@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	// 뷰 밑에 있는 폴더명
	private static final String CONTEXT_PATH = "subject";
	
	// 학과 목록 전체 조회
	@RequestMapping(value = "/listSubject")
	// vo와 view를 한번에 묶어서 보냄(ModelAndView를 사용하고 @ModelAttribute로 넘김)
	public ModelAndView listSubject(@ModelAttribute SubjectVO param) {
		List<SubjectVO> list = subjectService.listSubject(param);
		
		ModelAndView mav = new ModelAndView();
		// jsp에서 읽는 객체명
		mav.addObject("subjectList", list);
		// 폴더 밑에 있는 jsp 명
		mav.setViewName(CONTEXT_PATH + "/subject");
		
		return mav;
	}
	
	// 학과 팝업 창 띄우기
	@RequestMapping(value = "/selectSubject")
	// 데이터를 넘기지 않기 때문에 ModelAttribute는 사용하지 않음
								// 팝업 페이지에서 넘기는 no를 int no에 저장
	public ModelAndView selectSubject(@RequestParam("no") int no) {
		ModelAndView mav = new ModelAndView();
		
		// 학과 등록 버튼 클릭 시
		if(no == 0) {
			mav.addObject("mode", "insert");
			// 폴더 밑에 있는 jsp 명
			mav.setViewName(CONTEXT_PATH + "/subject_pop");
		} // 수정/삭제 버튼 클릭시
		  else {
			mav.addObject("mode", "update");
			mav.addObject("svo", subjectService.selectSubject(no));
			// 폴더 밑에 있는 jsp 명
			mav.setViewName(CONTEXT_PATH + "/subject_pop");
		}
				
		return mav;
	}
	
	// 학과 등록
	@RequestMapping(value = "/insertSubject")
	// vo와 view를 한번에 묶어서 보냄(ModelAndView를 사용하고 @ModelAttribute로 넘김)
	public ModelAndView insertSubject(@ModelAttribute SubjectVO param) {
		int result;
		String resultStr; 
		
		result = subjectService.insertSubject(param);
		
		ModelAndView mav = new ModelAndView();
		
		if(result == 1) {
			resultStr = "학과 등록 완료";
		} else {
			resultStr = "학과 등록 실패";
		}
		
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
	// 학과 수정
	@RequestMapping(value = "/updateSubject")
	public ModelAndView updateSubject(@ModelAttribute SubjectVO param) {
		int result;
		String resultStr; 
		
		result = subjectService.updateSubject(param);
		
		ModelAndView mav = new ModelAndView();
		
		if(result == 1) {
			resultStr = "학과 수정 완료";
		} else {
			resultStr = "학과 수정 실패";
		}
		
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
	// 학과 삭제
	@RequestMapping(value = "/deleteSubject")
	public ModelAndView deleteSubject(@ModelAttribute SubjectVO param) {
		int result;
		String resultStr; 
		
		result = subjectService.deleteSubject(param);
		
		ModelAndView mav = new ModelAndView();
		
		if(result == 1) {
			resultStr = "학과 삭제 완료";
		} else {
			resultStr = "학과 삭제 실패";
		}
		
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
}
