package com.spring.client.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.client.board.dao.BoardDAO;
import com.spring.client.board.vo.BoardVO;
import com.spring.client.reply.dao.ReplyDAO;
import com.spring.client.reply.vo.ReplyVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	// 글목록 구현
	@Override
	public List<BoardVO> boardList(BoardVO bvo) {
		List<BoardVO> myList = null;
		
		// 정렬에 대한 기본값 설정
		if(bvo.getOrder_by() == null) {
			bvo.setOrder_by("b_num");
		}
		if(bvo.getOrder_sc() == null) {
			bvo.setOrder_sc("DESC");
		}
		
		myList = boardDAO.boardList(bvo);
		return myList;
	}
	
	// 전체 레코드 수 구현
	@Override
	public int boardListCnt(BoardVO bvo) {
		return boardDAO.boardListCnt(bvo);
	}

	// 글입력 구현
	@Override
	public int boardInsert(BoardVO bvo) {
		int result = 0;
		
		try {
			result = boardDAO.boardInsert(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글상세 구현
	@Override
	public BoardVO boardDetail(BoardVO bvo) {
		BoardVO detail = null;
		detail = boardDAO.boardDetail(bvo);
		return detail;
	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(BoardVO bvo) {
		int result = 0;
		result = boardDAO.pwdConfirm(bvo);
		return result;
	}

	// 글수정 구현
	@Override
	public int boardUpdate(BoardVO bvo) {
		int result = 0;
		try {
			result = boardDAO.boardUpdate(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글 삭제 구현
	@Override
	public int boardDelete(int b_num) {
		int result = 0;
		try {
			result = boardDAO.boardDelete(b_num);
		} catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	// 해당 게시물의 댓글 존재 여부 확인
	// 댓글이 존재하면 댓글수를 반환하고 존재하지 않으면 0을 반환
	@Override
	public int replyCnt(int b_num) {
		int result = 0;
		List<ReplyVO> list = replyDAO.replyList(b_num);
		if(!list.isEmpty()) {
			result = list.size();
		} else {
			result = 0;
		}
		return result;
	}

}
