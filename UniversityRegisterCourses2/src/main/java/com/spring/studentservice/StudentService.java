package com.spring.studentservice;

import java.util.List;

import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

public interface StudentService {

	public List<StudentVO> listStudent(StudentVO param);
	public int insertStudent(StudentVO param);
	
	public StudentVO selectStudent(int no);
	public List<SubjectVO> selectSubjectNum(SubjectVO param);
	
}
