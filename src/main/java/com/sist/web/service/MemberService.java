package com.sist.web.service;

import org.apache.ibatis.annotations.Select;

import com.sist.web.vo.MemberVO;

public interface MemberService {
	public MemberVO memberLogin(String id, String pwd);

}
