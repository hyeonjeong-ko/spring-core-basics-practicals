package com.basic.basicproject.discount;

import com.basic.basicproject.annotation.MainDiscountPolicy;
import com.basic.basicproject.member.Grade;
import com.basic.basicproject.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else{
            return 0;
        }
    }
}
