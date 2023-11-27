package com.nhnacademy.aiot;

import java.util.UUID;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Main {

    public static void main(String[] args) {
        try (IMqttClient client =
                new MqttClient("tcp://localhost:1883", UUID.randomUUID().toString())) {

            process(client);

        } catch (MqttException ignore) {
            // ignore
        }
    }

    private static void process(IMqttClient client) throws MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setWill("test/alert", "close".getBytes(), 2, false);

        client.connect(options);

        client.publish("test/topic", new MqttMessage("Hello, World!".getBytes()));
        client.subscribe("#", (topic, msg) -> System.out.println(topic));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }

        client.disconnect();
    }
}
