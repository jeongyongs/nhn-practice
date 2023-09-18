package com.nhnacademy.mart;

import java.util.LinkedList;
import java.util.stream.IntStream;
import com.nhnacademy.coupon.CouponMachine;
import com.nhnacademy.customer.Customer;
import com.nhnacademy.employee.Employee;
import lombok.extern.slf4j.Slf4j;

/**
 * 마트 클래스입니다.
 */
@Slf4j
public class Mart {

    private static final int MAX_COUPON_COUNT = 50;

    private final CouponMachine couponMachine;
    private final LinkedList<Customer> waitingList;

    /**
     * 마트를 생성합니다.
     */
    public Mart() {
        couponMachine = new CouponMachine(MAX_COUPON_COUNT);
        waitingList = new LinkedList<>();
    }

    /**
     * 방문한 손님을 대기열에 추가합니다.
     * 
     * @param customer 방문한 손님입니다.
     */
    public void accept(Customer customer) {
        synchronized (this) {
            waitingList.add(customer);
            log.info(customer + "님이 대기열에 추가되었습니다.");
            notifyAll();
        }
    }

    /**
     * 마트 오픈 전 준비를 합니다.
     */
    public void prepareBeforeOpen() {
        IntStream.range(0, 3).forEach(this::hireEmployee);
    }

    private void hireEmployee(int i) {
        Employee employee = Employee.of("employee" + i);
        employee.workIn(this);
        employee.setCouponMachine(couponMachine);
        employee.start();
    }

    /**
     * 대기열에 있는 손님을 불러옵니다.
     * 
     * @throws InterruptedException
     */
    public synchronized Customer nextCustomer() throws InterruptedException {
        while (waitingList.isEmpty()) {
            wait();
        }
        return waitingList.poll();
    }
}
