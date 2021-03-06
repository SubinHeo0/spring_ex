package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 해당 객체가 서비스동작을 수행하는 객체다. 라는 의미
@Service
public class MemberServiceImpl implements MemberService {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// DAO 객체 필요
	@Inject
	private MemberDAO dao;
	
	@Override
	public void memberInsert(MemberVO vo) {
		log.info(" 컨트롤러 호출 ");
		log.info(" memberInsert(vo) 호출 ");
		
		dao.insertMember(vo);
		
		log.info(" DAO 처리 완료 -> 컨트롤러 이동");
		
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		
		log.info("loginCheck(vo) 호출 ");
		
		// DAO객체 메서드 호출
		MemberVO loginResultVO = dao.loginMember(vo);
		
		log.info(loginResultVO+"");
		
		return loginResultVO;
	}

	@Override
	public MemberVO getMember(String userid) {
		
		log.info("getMember(userid) 호출 ");
		
		// DAO객체 메서드 호출
		MemberVO vo = dao.getMember(userid);
		
		return vo;
	}

	@Override
	public Integer updateMember(MemberVO vo) {

		log.info("updateMember(vo) 호출 ");
		
		// DAO객체 메서드 호출
		int resultCnt = dao.updateMember(vo);
		
		return resultCnt;
		
	}

	@Override
	public void deleteMember(MemberVO vo) {

		log.info(" deleteMember(vo) 호출 ");
		
		dao.deleteMember(vo);
		
	}

	@Override
	public List<MemberVO> getMemberList(String userid) {
		
		log.info("getMemberList(String userid) 호출 ");

		return dao.getMemberList(userid);
	}

	
	
	
	

}
