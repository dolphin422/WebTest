package com.dolphin422.business.common.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.07.30 16:49
 */
public class CollectionTest {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(CollectionTest.class);

    @Test
    public void mapForEachTest() {
        Map<String, String> items = new HashMap<>();
        items.put("A", "10");
        items.put("B", "20");
        items.put("C", "30");
        items.put("D", "40");
        items.put("E", "50");
        items.put("F", "60");
        items.forEach((key, value) -> logger.info(key + ":" + value));
        for (Map.Entry<String, String> entry : items.entrySet()) {
            entry.setValue(entry.getKey() + entry.getValue());
        }
        logger.info("--------------------------------------");
        // 使用Java 8 forEach()
        items.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                logger.info(key + ":" + value);
            }
        });
        items.forEach((key, value) -> {
            logger.info(key + ":" + value);
            if ("E".equals(key)) {
                logger.info("---------this is e -----");
            }
        });
    }
}
