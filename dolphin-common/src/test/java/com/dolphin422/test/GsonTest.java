package com.dolphin422.test;

import com.dolphin422.common.util.CustomParameterizedType;
import com.dolphin422.common.util.GsonUtil;
import com.dolphin422.vo.GsonVo;
import com.dolphin422.vo.TestVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DamonJT WIN
 * @description:
 * @createDate: 2019.04.16 16:01
 */
public class GsonTest {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(GsonTest.class);

    private Object Class;

    @Test
    public void genericTest1() {
        Gson gson = GsonUtil.defaultGson();
        GsonVo<TestVo> gsonObject = this.getGsonObject();
        String gsonStr = gson.toJson(gsonObject);
        Type type = new TypeToken<GsonVo<TestVo>>() {
        }.getType();
        GsonVo<TestVo> object = gson.fromJson(gsonStr, type);
        logger.info("-----------------{}--object值为---->{}", System.currentTimeMillis(), object);
    }

    @Test
    public void genericTest2() {
        Gson gson = GsonUtil.defaultGson();
        GsonVo<TestVo> gsonObject = this.getGsonObject();
        String gsonStr = gson.toJson(gsonObject);
        Class<TestVo> testVoClass = TestVo.class;
        GsonVo<TestVo> gsonVo = this.getGsonVo(gsonStr, testVoClass);
        logger.info("-----------------{}--object值为---->{}", System.currentTimeMillis(), gsonVo);
    }

    @Test
    public void genericTest3() {
        Gson gson = GsonUtil.defaultGson();
        GsonVo<List<TestVo>> gsonListObject = this.getGsonListObject();
        String gsonStr = gson.toJson(gsonListObject);
        Class<TestVo> testVoClass = TestVo.class;
        GsonVo<List<TestVo>> gsonListVo = this.getGsonListVo(gsonStr, testVoClass);
        logger.info("-----------------{}--object值为---->{}", System.currentTimeMillis(), gsonListVo);
    }

    /**
     * 获取对象
     *
     * @param <T>
     * @return
     */
    private <T> GsonVo<T> getGsonVo(String gsonStr, Class<T> clazz) {
        Gson gson = GsonUtil.defaultGson();
        Type type = new CustomParameterizedType(GsonVo.class,
            new Class[] { clazz });
        GsonVo<T> object = gson.fromJson(gsonStr, type);
        logger.info("-----------------{}--object值为---->{}", System.currentTimeMillis(), object);
        return object;
    }

    /**
     * 获取List<对象>
     *
     * @param <T>
     * @return
     */
    private <T> GsonVo<List<T>> getGsonListVo(String gsonStr, Class<T> clazz) {
        Gson gson = GsonUtil.defaultGson();
        // 生成List<T> 中的 List<T>
        Type listType = new CustomParameterizedType(List.class,
            new Class[] { clazz });
        // 根据List<T>生成完整的Result<List<T>>
        Type type = new CustomParameterizedType(GsonVo.class, new Type[] { listType });
        GsonVo<List<T>> object = gson.fromJson(gsonStr, type);
        logger.info("-----------------{}--object值为---->{}", System.currentTimeMillis(), object);
        return object;
    }

    /**
     * 获取Object
     *
     * @return
     */
    private GsonVo<TestVo> getGsonObject() {
        GsonVo<TestVo> gsonVo = new GsonVo<>();
        TestVo testVo = new TestVo();
        testVo.setId("1234567");
        testVo.setDate(new Date());
        testVo.setValue("value is good");
        testVo.setTitle("title is  good good");
        gsonVo.setTitle("gsonVo Title");
        gsonVo.setT(testVo);
        return gsonVo;
    }

    /**
     * 获取Object
     *
     * @return
     */
    private GsonVo<List<TestVo>> getGsonListObject() {
        //VO
        GsonVo<List<TestVo>> gsonVo = new GsonVo<>();
        // List<>
        List<TestVo> testVoList = new ArrayList<>(2);
        //testVo 1
        TestVo testVo1 = new TestVo();
        testVo1.setId("1234567");
        testVo1.setDate(new Date());
        testVo1.setValue("value is good");
        testVo1.setTitle("title is  good good");
        testVoList.add(testVo1);
        //testVo 2
        TestVo testVo2 = new TestVo();
        testVo2.setId("8901234");
        testVo2.setDate(new Date());
        testVo2.setValue("value is 22 good");
        testVo2.setTitle("title is 222  good good");
        testVoList.add(testVo2);
        //组装
        gsonVo.setTitle("gsonVo Title");
        gsonVo.setT(testVoList);
        return gsonVo;
    }
}
