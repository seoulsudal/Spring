package com.spring.client.reply.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.client.reply.dao.ReplyDAO;
import com.spring.client.reply.vo.ReplyVO;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	private Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	// 글 목록 구현
	@Override
	public List<ReplyVO> replyList(Integer b_num) {
		List<ReplyVO> myList = null;
		myList = replyDAO.replyList(b_num);
		return myList;
	}

	// 글 입력 구현
	@Override
	public int replyInsert(ReplyVO rvo) {
		int result = 0;
		
		try {
			result = replyDAO.replyInsert(rvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글 비밀번호 구현
	@Override
	public int pwdConfirm(ReplyVO rvo) {
		int result = 0;
		result = replyDAO.pwdConfirm(rvo);
		return result;
	}

	// 글 수정 구현
	@Override
	public int replyUpdate(ReplyVO rvo) {
		int result = 0;
		
		try {
			result = replyDAO.replyUpdate(rvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글 삭제 구현
	@Override
	public int replyDelete(int r_num) {
		int result = 0;
		
		try {
			result = replyDAO.replyDelete(r_num);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
