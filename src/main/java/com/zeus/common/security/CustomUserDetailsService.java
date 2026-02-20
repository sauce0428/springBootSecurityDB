package com.zeus.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zeus.common.security.domain.CustomUser;
import com.zeus.domain.Member;
import com.zeus.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
	log.info("Load User By UserName : " + userName); 
	 
	// userName은 사용자명이 아니라 화면에서 userName으로 입력된 값이다. 
	Member member = memberMapper.read(userName); 
	log.info("queried by member mapper: " + member); 
	 
	return member == null ? null : new CustomUser(member); 
	}


}
