package com.spring.subject.dao;

import java.util.List;

import com.spring.subject.vo.SubjectVO;

public interface SubjectMapper {

	public List<SubjectVO> listSubject(SubjectVO param);

}
