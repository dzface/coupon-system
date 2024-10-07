package com.inflearn.api.service;

import com.inflearn.api.domain.Coupon;
import com.inflearn.api.repository.CouponCountRepository;
import com.inflearn.api.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }




    // 쿠폰 발급 로직
    public void apply(Long userId) {
        Long count = couponCountRepository.increment();
        // 발급된 쿠폰 수량이 100개 초과면 발급 중지
        if(count > 100) {
            return;
        }
        couponRepository.save(new Coupon(userId));
    }
}
