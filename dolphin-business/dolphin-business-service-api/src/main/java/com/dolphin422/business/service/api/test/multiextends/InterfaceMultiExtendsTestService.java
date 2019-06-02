package com.dolphin422.business.service.api.test.multiextends;

import com.dolphin422.business.service.api.article.IArticleService;

/**
 * @Description: 测试接口多继承
 * @author: DamonJT MAC
 * @createDate: 2019/6/2 10:23
 */
public interface InterfaceMultiExtendsTestService extends InterfaceExtendsTestService, IArticleService {

    /**
     * 校验
     */
    void checkMultiExtends();
}