package com.springmybatis.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springmybatis.board.vo.BoardVO;
import com.springmybatis.util.SqlSessionFactoryBean;

public class BoardDAO {

	private SqlSession mybatis;
	
	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		// board-mapper.xml 파일의 namespace명.id명
		mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		// board-mapper.xml 파일의 namespace명.id명
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
}
