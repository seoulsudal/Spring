package com.spring.subjectdao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.subjectvo.SubjectVO;

@Repository
public class SubjectMapperImpl implements SubjectMapper {

	// 자동으로 인스턴스
	@Inject
	// root-context에서 mybatis 셋팅에 한 id명
	private SqlSession sqlSession;
	
	// 파일 주소 명
	private static final String namespace = "com.spring.subjectdao.SubjectMapper";
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		return sqlSession.selectList(namespace + ".listSubject", param);
	}

	@Override
	public int insertSubject(SubjectVO param) {
		return sqlSession.insert(namespace + ".insertSubject", param);
	}

	@Override
	public SubjectVO selectSubject(int no) {
		return sqlSession.selectOne(namespace + ".selectSubject", no);
	}

	@Override
	public int updateSubject(SubjectVO param) {
		return sqlSession.update(namespace + ".updateSubject", param);
	}

	@Override
	public int deleteSubject(SubjectVO param) {
		return sqlSession.delete(namespace + ".deleteSubject", param);
	}

}
