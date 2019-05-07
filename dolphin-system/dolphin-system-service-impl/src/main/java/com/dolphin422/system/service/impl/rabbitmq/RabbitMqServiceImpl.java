package com.dolphin422.system.service.impl.rabbitmq;

import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.common.enumeration.statuscode.business.BusinessExceptionEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.util.UUIDGenerator;
import com.dolphin422.system.service.api.rabbitmq.IRabbitMqService;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DamonJT WIN
 * @description 测试RabbitMQ消息实现类
 * @createDate 2019.04.26 15:10
 */
@Service
@Transactional
public class RabbitMqServiceImpl extends BaseServiceImpl implements IRabbitMqService {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(RabbitMqServiceImpl.class);

    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendStringMessage(String exchangeName, String queueName, String message) {
        if (StringUtils.isEmpty(exchangeName)) {
            logger.debug("向MQ中发送消息,传入交换机名称为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "向MQ中发送消息,传入交换机名称为空");
        }
        if (StringUtils.isEmpty(queueName)) {
            logger.debug("向MQ中发送消息,传入队列名称为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "向MQ中发送消息,传入队列名称为空");
        }
        if (StringUtils.isEmpty(message)) {
            logger.debug("向MQ中发送消息,传入消息为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "向MQ中发送消息,传入消息为空");
        }
        String projectQueueName = "mqProjectAndResultQueueAdd";
        String uuid = UUIDGenerator.getUUID();
        logger.debug("--before--{}----", message);
        if (projectQueueName.equals(queueName)) {
            message = "{\"project\":{\"id\":\"aaaaaaaaaaaa\",\"projectCode\":\"0"+uuid+"6\"," +
                "\"projectName\":\"测试项目\",\"planId\":\"123AAAA\",\"projectType\":\"0\",\"bidopenDate\":\"2019-04-26 01:22:32\",\"bidopenPlace\":\"北京怀柔\",\"budgetMoney\":\"201000\",\"dataSource\":\"bidding\",\"regionCode\":\"110000\"},\"agency\":[{\"id\":\"F174BCDE16234F07A355B5F4F12DEA48\",\"agencyName\":\"\",\"agencyCode\":\"320030903\"}],\"buyman\":[{\"orgGuid\":\"F174BCDE16234F07A355B5F4F12DEA48\",\"orgPGuid\":\"2\",\"regionGuid\":\"110000\",\"regionCode\":\"110000\",\"regionName\":\"110000\",\"orgCode\":\"320030903\",\"orgName\":\"320030903\"}],\"supplier\":[{\"id\":\"F174BCDE16234F07A355B5F4F12DEA48\",\"orgCode\":\"320030903\",\"supplyCn\":\"供应商名称示例\"}],\"expert\":[{\"id\":\"F1747A355B5F4F12DEA48\",\"expertName\":\"张三\",\"idCode\":\"51250119720303XXXX\"}]}";
            logger.debug("--after--{}----", message);
        }
        amqpTemplate.convertAndSend(exchangeName, queueName, message);
    }

}
