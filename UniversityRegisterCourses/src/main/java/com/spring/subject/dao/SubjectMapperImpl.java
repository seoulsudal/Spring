package com.spring.subject.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.subject.vo.SubjectVO;

@Repository
public class SubjectMapperImpl implements SubjectMapper {

	// 자동으로 인스턴스
	@Inject
	// root-context에서 mybatis 셋팅에 한 id명
	private SqlSession sqlSession;
	
	// 파일 주소 명
	private static final String namespace = "com.spring.subject.dao.SubjectMapper";
			
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
				
		return sqlSession.selectList(namespace + ".listSubject", param);
		
	}

}
