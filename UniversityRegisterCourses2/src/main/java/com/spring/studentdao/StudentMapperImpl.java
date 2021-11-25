package com.spring.studentdao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

@Repository
public class StudentMapperImpl implements StudentMapper {
	private static final String nameSpace = "com.spring.studentdao.StudentMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<StudentVO> listStudent(StudentVO param) {
		return sqlSession.selectList(nameSpace + ".listStudent", param);
	}

	@Override
	public int insertStudent(StudentVO param) {
		return sqlSession.insert(nameSpace + ".insertStudent", param);
	}

	@Override
	public StudentVO selectStudent(int no) {
		return sqlSession.selectOne(nameSpace + ".selectStudent", no);
	}

	@Override
	public List<SubjectVO> selectSubjectNum() {
		return sqlSession.selectList(nameSpace + ".selectSubjectNum");
	}

	@Override
	public int updateStudent(StudentVO param) {
		return sqlSession.update(nameSpace + ".updateStudent", param);
	}

	@Override
	public int deleteStudent(StudentVO param) {
		return sqlSession.delete(nameSpace + ".deleteStudent", param);
	}

	@Override
	public String studentCount(String s_num) {
		return sqlSession.selectOne(nameSpace + ".studentCount", s_num);
	}

	@Override
	public StudentVO idCheck(String id) {
		return sqlSession.selectOne(nameSpace + ".idCheck", id);
	}

	@Override
	public int pwcheck(String sd_passwd, int no) {
		StudentVO svo = new StudentVO(no, sd_passwd);
		return sqlSession.selectOne(nameSpace + ".pwcheck", svo);
	}

}
