package com.nhnacademy.aiot;

public enum FunctionCode {

    READ_HOLDING_REGISTERS(0x03), //
    READ_INPUT_REGISTER(0x04), //
    WRITE_SINGLE_REGISTER(0x06), //
    WRITE_MULTIPLE_REGISTER(0x10);

    private byte code;

    private FunctionCode(int code) {
        this.code = (byte) code;
    }

    public byte get() {
        return code;
    }
}
