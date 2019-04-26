package com.dolphin422.system.controller.rabbitmq;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.returnvo.ReturnVo;
import com.dolphin422.system.service.api.rabbitmq.IRabbitMqService;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.04.26 15:08
 */
@RestController
@RequestMapping("/v1/rabbitmq")
public class RabbitMqController extends BaseController {

    @Resource
    private IRabbitMqService rabbitMqService;

    @Value("${mq.topicExchangeName}")
    private String topicExchangeName;

    @ApiOperation(value = "发送消息到RabbitMQ", notes = "发送消息到RabbitMQ")
    @RequestMapping(value = "/{queueName}/{message}", method = RequestMethod.GET)
    public ReturnVo sendStringMessage(@PathVariable String queueName, @PathVariable String message)
        throws BusinessException {
        rabbitMqService.sendStringMessage(topicExchangeName, queueName, message);
        return ReturnVo.successVo();    }

}
