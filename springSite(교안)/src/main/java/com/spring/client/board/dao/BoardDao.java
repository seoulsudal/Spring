package com.spring.client.board.dao;

import java.util.List;

import com.spring.client.board.vo.BoardVO;

public interface BoardDao {
	public List<BoardVO> boardList(BoardVO bvo);
	//public List<BoardVO> boardList();
	public int boardInsert(BoardVO bvo);
	public BoardVO boardDetail(BoardVO bvo);
	public int pwdConfirm(BoardVO bvo);
	public int boardUpdate(BoardVO bvo);
	public int boardDelete(int b_num);
	public int boardListCnt(BoardVO bvo);
}
