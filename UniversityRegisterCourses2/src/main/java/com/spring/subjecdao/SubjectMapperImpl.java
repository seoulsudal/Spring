package com.spring.subjecdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.subjectvo.SubjectVO;

@Repository
public class SubjectMapperImpl implements SubjectMapper {

	@Autowired
	SqlSession sqlSession;
	
	private static final String namespace = "com.spring.subjectdao.SubjectMapper";
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {

		return sqlSession.selectList(namespace + ".listSubject", param);
		
	}

}
