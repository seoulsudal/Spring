package com.spring.studentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.studentdao.StudentMapper;
import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public List<StudentVO> listStudent(StudentVO param) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = studentMapper.listStudent(param);
		
		return list;
	}

	@Override
	public int insertStudent(StudentVO param) {
		return studentMapper.insertStudent(param);
	}

	@Override
	public StudentVO selectStudent(int no) {
		return studentMapper.selectStudent(no);
	}

	@Override
	public List<SubjectVO> selectSubjectNum(SubjectVO param) {
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		list = studentMapper.selectSubjectNum();
		
		return list;
	}

}
