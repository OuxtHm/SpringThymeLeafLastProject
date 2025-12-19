package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.CommentMapper;
import com.sist.web.vo.CommentVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	// 필요한 객체를 스프링으로부터 가지고 온다 => @Autowired / getBean()
	// private 변수에 접근이 가능(OOP를 무시)
	// 리플렉션 Class.forName()
	private final CommentMapper mapper;
	
	@Override
	public List<CommentVO> commentListData(int cno, int type) {
		return mapper.commentListData(cno, type);
	}
	
	@Override
	public void commentInsert(CommentVO vo) {
		mapper.commentInsert(vo);
	}
	
	@Override
	public void commentDelete(int no) {
		mapper.commentDelete(no);
	}
	
	@Override
	public void commentUpdate(int no, String msg) {
		mapper.commentUpdate(no, msg);
	}
}
