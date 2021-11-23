package com.spring.subjectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.subjectdao.SubjectMapper;
import com.spring.subjectvo.SubjectVO;

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

	@Override
	public int insertSubject(SubjectVO param) {
		return subjectMapper.insertSubject(param);
	}

	@Override
	public SubjectVO selectSubject(int no) {
		return subjectMapper.selectSubject(no);
	}

	@Override
	public int updateSubject(SubjectVO param) {
		return subjectMapper.updateSubject(param);
	}

	@Override
	public int deleteSubject(SubjectVO param) {
		return subjectMapper.deleteSubject(param);
	}

}
