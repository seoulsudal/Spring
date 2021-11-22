package com.spring.subjectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.subjecdao.SubjectMapper;
import com.spring.subjectvo.SubjectVO;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectMapper subjectMapper;
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		
		list = subjectMapper.listSubject(param);
		
		return list;
	}

}
