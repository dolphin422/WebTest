package com.dolphin422.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description: UUID生成工具
 * @author: jiatai
 * @createDate: 2018.11.23 0:13
 */
public class UUIDGenerator {
    /**
     * 获得一个UUID
     *
     * @return String UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    /**
     * 获得指定数目的UUID
     *
     * @param number int 需要获得的UUID数量
     * @return String[] UUID数组
     */
    public static List<String> getUUIDList(int number) {
        if (number < 1) {
            return null;
        }
        List<String> uuidList = new ArrayList<String>(number);
        for (int i = 0; i < number; i++) {
            uuidList.add(getUUID());
        }
        return uuidList;
    }


}
