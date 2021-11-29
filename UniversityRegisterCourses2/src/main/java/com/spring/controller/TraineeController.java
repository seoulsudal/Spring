package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/trainee")
public class TraineeController {
	private static final String CONTEXT_PATH = "trainee";
	
	@Autowired
	private TraineeService traineeService;
	
	// 수강 신청 전체 목록
}
