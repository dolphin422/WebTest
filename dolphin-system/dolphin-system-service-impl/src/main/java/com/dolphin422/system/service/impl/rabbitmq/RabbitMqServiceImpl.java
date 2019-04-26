package com.dolphin422.system.service.impl.rabbitmq;

import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.common.enumeration.statuscode.business.BusinessExceptionEnum;
import com.dolphin422.common.exception.BusinessException;
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
        logger.debug("---");
        amqpTemplate.convertAndSend(exchangeName, queueName, message);
    }

}
