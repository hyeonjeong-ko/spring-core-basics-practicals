package com.basic.basicproject;

import com.basic.basicproject.discount.DiscountPolicy;
import com.basic.basicproject.discount.FixDiscountPolicy;
import com.basic.basicproject.discount.RateDiscountPolicy;
import com.basic.basicproject.member.MemberRepository;
import com.basic.basicproject.member.MemberService;
import com.basic.basicproject.member.MemberServiceImpl;
import com.basic.basicproject.member.MemoryMemberRepository;
import com.basic.basicproject.order.OrderService;
import com.basic.basicproject.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
