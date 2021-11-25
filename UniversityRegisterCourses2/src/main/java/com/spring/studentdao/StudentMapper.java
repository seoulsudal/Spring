package com.spring.studentdao;

import java.util.List;

import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

public interface StudentMapper {

	public List<StudentVO> listStudent(StudentVO param);
	public int insertStudent(StudentVO param);
	public StudentVO selectStudent(int no);
	public List<SubjectVO> selectSubjectNum();
	public int updateStudent(StudentVO param);
	public int deleteStudent(StudentVO param);
	public String studentCount(String s_num);
	public StudentVO idCheck(String id);
	public int pwcheck(String sd_passwd, int no);

}
