package com.basic.basicproject;

import com.basic.basicproject.member.Grade;
import com.basic.basicproject.member.Member;
import com.basic.basicproject.member.MemberService;
import com.basic.basicproject.member.MemberServiceImpl;
import com.basic.basicproject.order.Order;
import com.basic.basicproject.order.OrderService;
import com.basic.basicproject.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // appconfig에서 모두 결정
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
