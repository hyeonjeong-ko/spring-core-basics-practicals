package com.basic.basicproject;

import com.basic.basicproject.member.Grade;
import com.basic.basicproject.member.Member;
import com.basic.basicproject.member.MemberService;
import com.basic.basicproject.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(memberRepository);


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
