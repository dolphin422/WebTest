package com.dolphin422.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Description: Json转换工具类
 * @author: DamonJT MAC
 * @createDate: 2018/12/24 23:42
 */
public class GsonUtil {
    /**
     * 默认GSON
     * 时间格式为： yyyy-MM-dd HH:mm:ss
     *
     * @return 默认GSON
     */
    public static Gson defaultGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(DateUtil.DEFAULT_FORMAT_DATE_TIME);
        return gsonBuilder.create();
    }

}
