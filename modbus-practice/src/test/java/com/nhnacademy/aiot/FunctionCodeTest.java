package com.nhnacademy.aiot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FunctionCodeTest {

    @Test
    void getTest() {
        // given
        FunctionCode readHoldingRegisters = FunctionCode.READ_HOLDING_REGISTERS;

        // when
        int actual = readHoldingRegisters.get();

        // then
        assertEquals(3, actual);
    }
}
