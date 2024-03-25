package com.basic.basicproject;

import com.basic.basicproject.discount.FixDiscountPolicy;
import com.basic.basicproject.member.MemberService;
import com.basic.basicproject.member.MemberServiceImpl;
import com.basic.basicproject.member.MemoryMemberRepository;
import com.basic.basicproject.order.OrderService;
import com.basic.basicproject.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
