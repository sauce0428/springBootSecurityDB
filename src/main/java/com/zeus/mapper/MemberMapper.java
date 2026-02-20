package com.zeus.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zeus.domain.Member;

@Mapper
public interface MemberMapper {
	public Member read(String userId);
}
