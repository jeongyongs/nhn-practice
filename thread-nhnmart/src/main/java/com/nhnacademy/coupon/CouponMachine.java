package com.nhnacademy.coupon;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;

/**
 * 쿠폰 발급기 클래스입니다.
 */
@Slf4j
public class CouponMachine {

    private long maxCount;
    private long count;

    /**
     * 쿠폰 발급기를 생성합니다.
     */
    public CouponMachine(long maxCount) {
        this.maxCount = maxCount;
        count = 0;
    }

    /**
     * 쿠폰을 발급합니다.
     * 
     * @exception NoSuchElementException 쿠폰이 모두 소진된 경우
     */
    public synchronized Coupon createCoupon() {
        if (++count > maxCount) {
            log.info("쿠폰이 소진되었습니다.");
            throw new NoSuchElementException("쿠폰이 소진되었습니다.");
        }
        log.info("쿠폰이 발급되었습니다. (쿠폰: {})", count);
        return Coupon.ofDiscount(50);
    }
}
