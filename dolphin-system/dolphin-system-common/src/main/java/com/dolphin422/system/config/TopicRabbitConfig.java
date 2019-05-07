package com.dolphin422.system.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DamonJT WIN
 * @description topic模式RabbitMQ配置类
 * @createDate 2019.04.26 14:35
 */
@Configuration
@ConditionalOnProperty(name = "spring.rabbitmq.enable", havingValue = "true")
public class TopicRabbitConfig {
    @Value("${mq.topicExchangeName}")
    private String topicExchangeName;

    /**
     * 注册交换机
     *
     * @return
     */
    @Bean(name = "${mq.topicExchangeName}")
    TopicExchange gpcmsTopicExchange() {
        return new TopicExchange(topicExchangeName);
    }

    /**
     * 队列
     * durable = false  不持久化
     *
     * @return
     */
    @Bean
    Queue mqAgencyQueueAdd() {
        return new Queue("mqAgencyQueueAdd", false);
    }

    /**
     * 绑定
     *
     * @param mqAgencyQueueAdd
     * @param gpcmsTopicExchange
     * @return
     */
    @Bean
    Binding mqAgencyQueueAddBinding(Queue mqAgencyQueueAdd, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqAgencyQueueAdd).to(gpcmsTopicExchange).with("mqAgencyQueueAdd");
    }

    /**
     * 注册队列
     *
     * @return
     */
    @Bean
    Queue mqAgencyQueueUpdate() {
        return new Queue("mqAgencyQueueUpdate", false);
    }

    /**
     * 绑定
     *
     * @param mqAgencyQueueUpdate
     * @param gpcmsTopicExchange
     * @return
     */
    @Bean
    Binding mqAgencyQueueUpdateBinding(Queue mqAgencyQueueUpdate, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqAgencyQueueUpdate).to(gpcmsTopicExchange).with("mqAgencyQueueUpdate");
    }

    @Bean
    Queue mqExpertQueueAdd() {
        return new Queue("mqExpertQueueAdd", false);
    }

    @Bean
    Binding mqExpertQueueAddBinding(Queue mqExpertQueueAdd, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqExpertQueueAdd).to(gpcmsTopicExchange).with("mqExpertQueueAdd");
    }

    @Bean
    Queue mqExpertQueueUpdate() {
        return new Queue("mqExpertQueueUpdate", false);
    }

    @Bean
    Binding mqExpertQueueUpdateBinding(Queue mqExpertQueueUpdate, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqExpertQueueUpdate).to(gpcmsTopicExchange).with("mqExpertQueueUpdate");
    }

    @Bean
    Queue mqPurchaserQueueAdd() {
        return new Queue("mqPurchaserQueueAdd", false);
    }

    @Bean
    Binding mqPurchaserQueueAddBinding(Queue mqPurchaserQueueAdd, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqPurchaserQueueAdd).to(gpcmsTopicExchange).with("mqPurchaserQueueAdd");
    }

    @Bean
    Queue mqPurchaserQueueUpdate() {
        return new Queue("mqPurchaserQueueUpdate", false);
    }

    @Bean
    Binding mqPurchaserQueueUpdateBinding(Queue mqPurchaserQueueUpdate, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqPurchaserQueueUpdate).to(gpcmsTopicExchange)
            .with("mqPurchaserQueueUpdate");
    }

    @Bean
    Queue mqSupplyQueueAdd() {
        return new Queue("mqSupplyQueueAdd", false);
    }

    @Bean
    Binding mqSupplyQueueAddBinding(Queue mqSupplyQueueAdd, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqSupplyQueueAdd).to(gpcmsTopicExchange).with("mqSupplyQueueAdd");
    }

    @Bean
    Queue mqSupplyQueueUpdate() {
        return new Queue("mqSupplyQueueUpdate", false);
    }

    @Bean
    Binding mqSupplyQueueUpdateBinding(Queue mqSupplyQueueUpdate, TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqSupplyQueueUpdate).to(gpcmsTopicExchange).with("mqSupplyQueueUpdate");
    }

    @Bean
    Queue mqProjectAndResultQueueAdd() {
        return new Queue("mqProjectAndResultQueueAdd", false);
    }

    @Bean
    Binding mqProjectAndResultQueueAddBinding(Queue mqProjectAndResultQueueAdd,
        TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqProjectAndResultQueueAdd).to(gpcmsTopicExchange)
            .with("mqProjectAndResultQueueAdd");
    }

    @Bean
    Queue mqProjectAndResultQueueUpdate() {
        return new Queue("mqProjectAndResultQueueUpdate", false);
    }

    @Bean
    Binding mqProjectAndResultQueueUpdateBinding(Queue mqProjectAndResultQueueUpdate,
        TopicExchange gpcmsTopicExchange) {
        return BindingBuilder.bind(mqProjectAndResultQueueUpdate).to(gpcmsTopicExchange)
            .with("mqProjectAndResultQueueUpdate");
    }

    @Bean(name = "mqTestQueueTest")
    Queue mqTestQueueTest() {
        return new Queue("mqTestQueueTest", false);
    }

    /**
     * 绑定到交换机,并指定路由键为"routingKey.#"
     * 即:此Exchange中
     *
     * @date 2018年7月19日 上午12:20:09
     */
    @Bean
    Binding mqTestQueueTestBinding(Queue mqTestQueueTest, TopicExchange gpcmsTopicExchange) {
        Binding testQueueTest = BindingBuilder.bind(mqTestQueueTest).to(gpcmsTopicExchange)
            .with("mqTestQueueTest");
        return testQueueTest;
    }

}
