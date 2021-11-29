package com.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.lessonservice.lessonService;
import com.spring.lessonvo.LessonVO;

@Controller
@RequestMapping(value = "/lesson")
public class LessonController {
	private static final String CONTECT_PATH = "lesson";
	
	@Autowired
	private lessonService lessonService;
	
	// 과목 전체 조회
	@RequestMapping("/listLesson")
	public ModelAndView listLesson(@ModelAttribute LessonVO param) {
		List<LessonVO> list = lessonService.listLesson(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lessonList", list);
		mav.setViewName(CONTECT_PATH + "/lesson");
		
		return mav;
	}
	
	// 과목 정보 보기
	@RequestMapping("/selectLesson")
	public ModelAndView selectLesson(@RequestParam("no") int no) {
		ModelAndView mav = new ModelAndView();
		
		if(no == 0 ) {
			mav.addObject("mode", "insert");
		} else {
			mav.addObject("mode", "update");
			mav.addObject("lessonVO", lessonService.selectLesson(no));
		}
		
		mav.setViewName(CONTECT_PATH + "/lesson_pop");
		return mav;
	}
	
	// 과목 정보 추가
	@RequestMapping("/insertLesson")
	public ModelAndView insertLesson(@ModelAttribute LessonVO param) {
		String resultStr = "";
		int result = lessonService.insertLesson(param);
		
		if(result > 0) {
			resultStr = "과목 등록이 완료 되었습니다.";
		} else {
			resultStr = "과목 등록이 실패 하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
	// 과목 정보 수정
	@RequestMapping("/updateLesson")
	public ModelAndView updateLesson(@ModelAttribute LessonVO param) {
		String resultStr = "";
		int result = lessonService.updateLesson(param);
		
		if(result > 0) {
			resultStr = "과목 수정이 완료 되었습니다.";
		} else {
			resultStr = "과목 수정이 실패 하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
	// 과목 정보 삭제
	@RequestMapping("deleteLesson")
	public ModelAndView deleteLesson(@RequestParam("no") int no) {
		String resultStr = "";
		int result = lessonService.deleteLesson(no);
		
		if(result > 0) {
			resultStr = "과목 삭제가 완료 되었습니다.";
		} else {
			resultStr = "과목 삭제가 실패 하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
}
