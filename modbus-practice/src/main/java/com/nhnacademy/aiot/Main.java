package com.nhnacademy.aiot;

public class Main {

    public static void main(String[] args) {
        ModbusServer modbusServer = new ModbusServer();
        modbusServer.start();
        ModbusClient modbusClient = new ModbusClient();
        modbusClient.request(0x03, 0x0000, 0x000a, 0x01, 0x010a);
    }
}
