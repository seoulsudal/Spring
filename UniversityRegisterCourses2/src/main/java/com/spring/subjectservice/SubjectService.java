package com.spring.subjectservice;

import java.util.List;

import com.spring.subjectvo.SubjectVO;

public interface SubjectService {

	public List<SubjectVO> listSubject(SubjectVO param);
	public int insertSubject(SubjectVO param);
	public Object selectSubject(int no);
	public int updateSubject(SubjectVO param);
	public int deleteSubject(SubjectVO param);

}
