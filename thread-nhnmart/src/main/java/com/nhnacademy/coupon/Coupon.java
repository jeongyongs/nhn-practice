package com.nhnacademy.coupon;

/**
 * 쿠폰 클래스입니다.
 */
public class Coupon {

    private static long count = 0;

    private final long couponId;
    private final long amount;
    private final CouponType couponType;

    private Coupon(long amount, CouponType couponType) {
        couponId = ++count;
        this.amount = amount;
        this.couponType = couponType;
    }

    /**
     * 할인 쿠폰을 생성합니다
     * 
     * @param amount 할인율입니다.
     * @return 할인율이 <code>amount</code>인 할인 쿠폰을 반환합니다.
     */
    public static Coupon ofDiscount(long amount) {
        return new Coupon(amount, CouponType.DISCOUNT);
    }

    @Override
    public String toString() {
        return "Coupon [couponId=" + couponId + ", amount=" + amount + ", couponType=" + couponType
                + "]";
    }
}
