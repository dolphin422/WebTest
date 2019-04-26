package com.dolphin422.system.service.api.rabbitmq;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.04.26 15:10
 */
public interface IRabbitMqService {
    /**
     * 发送消息
     *
     * @param exchangeName
     * @param queueName
     * @param message
     */
    void sendStringMessage(String exchangeName, String queueName, String message);

}
