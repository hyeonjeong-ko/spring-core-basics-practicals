package com.basic.basicproject.order;

import com.basic.basicproject.discount.DiscountPolicy;
import com.basic.basicproject.discount.FixDiscountPolicy;
import com.basic.basicproject.discount.RateDiscountPolicy;
import com.basic.basicproject.member.Member;
import com.basic.basicproject.member.MemberRepository;
import com.basic.basicproject.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 최종 할인 가격

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
