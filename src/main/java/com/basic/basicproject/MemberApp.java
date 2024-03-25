package com.basic.basicproject;

import com.basic.basicproject.member.Grade;
import com.basic.basicproject.member.Member;
import com.basic.basicproject.member.MemberService;
import com.basic.basicproject.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // appconfig에서 모두 결정

        //MemberService memberService = new MemberServiceImpl(memberRepository);
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
