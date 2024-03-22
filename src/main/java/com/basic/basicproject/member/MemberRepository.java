package com.basic.basicproject.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
