package com.nhnacademy.employee;

import java.util.NoSuchElementException;
import com.nhnacademy.coupon.CouponMachine;
import com.nhnacademy.customer.Customer;
import com.nhnacademy.mart.Mart;
import lombok.extern.slf4j.Slf4j;

/**
 * 직원 클래스입니다.
 */
@Slf4j
public class Employee implements Runnable {

    private static long count = 0;

    private final long employeeId;
    private final String name;
    private Thread thread;
    private CouponMachine couponMachine;
    private Mart mart;

    private Employee(String name) {
        employeeId = ++count;
        this.name = name;
        thread = new Thread(this);
    }

    /**
     * 직원을 생성합니다.
     * 
     * @param name 직원의 이름입니다.
     * @return 이름이 <code>name</code>인 직원 객체를 반환합니다.
     */
    public static Employee of(String name) {
        return new Employee(name);
    }

    /**
     * 출근할 마트를 선택합니다.
     * 
     * @param mart 출근할 마트입니다.
     */
    public void workIn(Mart mart) {
        this.mart = mart;
    }

    /**
     * 직원을 동작합니다.
     */
    public void start() {
        thread.start();
    }

    /**
     * 사용할 쿠폰 발급기를 선택합니다.
     * 
     * @param couponMachine 사용할 쿠폰 발급기입니다.
     */
    public void setCouponMachine(CouponMachine couponMachine) {
        this.couponMachine = couponMachine;
    }

    @Override
    @SuppressWarnings("all")
    public void run() {
        while (!Thread.interrupted()) {
            try {
                process();
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void process() throws InterruptedException {
        Customer nextCustomer = mart.nextCustomer();
        try {
            couponMachine.createCoupon();
        } catch (NoSuchElementException ignore) {
            Thread.currentThread().interrupt();
            return;
        }
        log.info(toString() + " → " + nextCustomer + "님에게 쿠폰을 전달했습니다.");
        Thread.sleep(3000);
    }

    @Override
    public String toString() {
        return "Employee" + employeeId;
    }
}
