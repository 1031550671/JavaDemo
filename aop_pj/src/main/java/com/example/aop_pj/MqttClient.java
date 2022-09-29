package com.example.aop_pj;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

@Slf4j
public class MqttClient {
    public static org.eclipse.paho.client.mqttv3.MqttClient mqttClient = null;
    private static MemoryPersistence memoryPersistence = null;
    private static MqttConnectOptions mqttConnectOptions = null;
    private static MqttClient instance = null;
    private static String password = "admin";

    public static MqttClient getInstance() throws Exception {
        if (instance == null) {
            synchronized (MqttClient.class) {
                if (instance == null) {
                    instance = new MqttClient();
                }
            }
        }
        return instance;
    }


    public MqttClient() throws MqttException {
        init("mqttx_22b545c0");
    }

    public void init(String clientId) throws MqttException {
        //初始化连接设置对象
        mqttConnectOptions = new MqttConnectOptions();
        //初始化MqttClient
        if(null != mqttConnectOptions) {
//            true可以安全地使用内存持久性作为客户端断开连接时清除的所有状态
            mqttConnectOptions.setCleanSession(true);
//            设置连接超时
            mqttConnectOptions.setConnectionTimeout(30);
            //心跳
            mqttConnectOptions.setKeepAliveInterval(60);
            //重连
            mqttConnectOptions.setAutomaticReconnect(true);
            mqttConnectOptions.setUserName("woxu");
            mqttConnectOptions.setPassword(password.toCharArray());
//            设置持久化方式
            memoryPersistence = new MemoryPersistence();
            if(null != memoryPersistence && null != clientId) {
                try {
                    mqttClient = new org.eclipse.paho.client.mqttv3.MqttClient("tcp://127.0.0.1:1883", clientId,memoryPersistence);
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {

            }
        }else {
            log.error("mqttConnectOptions对象为空");
        }
        //设置连接和回调
        if(null != mqttClient) {
            if(!mqttClient.isConnected()) {
                try {
                    log.info("创建连接:" + mqttClient.isConnected());
                    mqttClient.connect(mqttConnectOptions);
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }else {
            log.error("mqttClient为空");
        }

    }



    //    关闭连接
    public void closeConnect() {
        //关闭存储方式
        if(null != memoryPersistence) {
            try {
                memoryPersistence.close();
            } catch (MqttPersistenceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("memoryPersistence is null");
        }

//        关闭连接
        if(null != mqttClient) {
            if(mqttClient.isConnected()) {
                try {
                    mqttClient.disconnect();
                    mqttClient.close();
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {
                log.error("mqttClient is not connect");
            }
        }else {
            log.error("mqttClient is null");
        }
    }

    //    发布消息
    public void publishMessage(String pubTopic,String message,int qos) throws MqttException {
        if(null != mqttClient&& mqttClient.isConnected()) {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(message.getBytes());
            MqttTopic topic = mqttClient.getTopic(pubTopic);
            if(null != topic) {
                try {
                    MqttDeliveryToken publish = topic.publish(mqttMessage);
                    if(!publish.isComplete()) {
                        log.info("消息发布成功");
                    }
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }else {
            reConnect();
        }

    }
    //    重新连接
    public  void reConnect() throws MqttException {
        if(null != mqttClient) {
            if(!mqttClient.isConnected()) {
                if(null != mqttConnectOptions) {
                    try {
                        mqttClient.connect(mqttConnectOptions);
                    } catch (MqttException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else {
                    log.error("mqttConnectOptions is null");
                }
            }else {
                log.error("mqttClient is null or connect");
            }
        }else {
            init("admin");
        }

    }
    //    订阅主题
    public void subTopic(String topic) {
        if(null != mqttClient&& mqttClient.isConnected()) {
            try {
                mqttClient.subscribe(topic, 1);
                log.info("成功订阅");

                mqttClient.setCallback(new MqttCallback() {
                    @Override
                    public void messageArrived(String topic, MqttMessage message) throws Exception {
                        String context = new String(message.getPayload());
                        System.out.println(context);
                    }

                    @Override
                    public void deliveryComplete(IMqttDeliveryToken token) {
                        // T

                    }
                    @Override
                    public void connectionLost(Throwable cause) {
                        // TODO
                        System.out.println("connect  lost");

                    }

                });

            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("mqttClient is error");
        }
    }


    //    清空主题
    public void cleanTopic(String topic) {
        if(null != mqttClient&& !mqttClient.isConnected()) {
            try {
                mqttClient.unsubscribe(topic);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("mqttClient is error");
        }
    }


}
