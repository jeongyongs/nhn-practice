package com.nhnacademy.aiot;

import java.io.IOException;
import java.net.Socket;

public class ModbusClient {

    private static final String DEFAULT_HOST = "localhost";
    private static final int MODBUS_DEFAULT_PORT = 502;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(DEFAULT_HOST, MODBUS_DEFAULT_PORT);

    }

    public void request() {}
}
