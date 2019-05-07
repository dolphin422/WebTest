package com.dolphin422.system.service.impl.rabbitmqlistener;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.04.26 15:41
 */
@Service
public class RabbitMqListener {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    /**
     * 测试队列
     *
     * @param s
     */
   // @RabbitListener(queues = "mqTestQueueTest")
    public void gpcmsKeyMisconductAdd(String s) {
        logger.debug("------{}-----获取到的信息为:{}", new Date(), s);
    }
}
