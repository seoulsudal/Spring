package com.spring.subject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.subject.dao.SubjectMapper;
import com.spring.subject.vo.SubjectVO;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	// 자동으로 인스턴스 선언
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		
		// List를 선언해서 값을 저장
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		list = subjectMapper.listSubject(param);
		
		return list;
	}

}
