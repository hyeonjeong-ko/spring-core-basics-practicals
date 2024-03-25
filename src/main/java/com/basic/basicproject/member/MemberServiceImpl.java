package com.basic.basicproject.member;

public class MemberServiceImpl implements MemberService { // 구현체 하나일땐 관례상 Impl 많이씀...

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
