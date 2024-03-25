package com.basic.basicproject.order;

import com.basic.basicproject.discount.DiscountPolicy;
import com.basic.basicproject.member.Member;
import com.basic.basicproject.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 최종 할인 가격

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
