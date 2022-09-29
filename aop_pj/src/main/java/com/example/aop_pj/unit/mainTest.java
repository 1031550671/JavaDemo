package com.example.aop_pj.unit;

import com.example.aop_pj.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class mainTest {

    public static void main(String[] args) throws MqttException {

        MqttClient mqttClient = new MqttClient();
        for (int i=1; i<2;i++)
        {
            mqttClient.publishMessage("topicTest01", "{\n" +
                    "\t\"InsChnName\": \"1-1-1\",\n" +
                    "\t\"SampleDatas\": [{\n" +
                    "\t\t\"SampleTime\": \"2022-06-13T10:25:41\",\n" +
                    "\t\t\"SampleValue\": -152.588\n" +
                    "\t}, {\n" +
                    "\t\t\"SampleTime\": \"2022-06-13T10:26:05\",\n" +
                    "\t\t\"SampleValue\": 152.588\n" +
                    "\t}]\n" +
                    "\t}", 1);

            try  {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        mqttClient.subTopic("topicTest01");




    }

}
