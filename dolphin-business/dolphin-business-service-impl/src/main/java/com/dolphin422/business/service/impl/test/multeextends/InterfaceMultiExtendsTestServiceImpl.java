package com.dolphin422.business.service.impl.test.multeextends;

import com.dolphin422.business.model.article.ArticleModel;

import java.util.List;

/**
 * @Description: 测试接口可以多继承
 * @author: DamonJT MAC
 * @createDate: 2019/6/2 10:26
 */
public class InterfaceMultiExtendsTestServiceImpl implements com.dolphin422.business.service.api.test.multiextends.InterfaceMultiExtendsTestService {
    @Override
    public List<ArticleModel> selectAll() {
        return null;
    }

    @Override
    public void checkMultiExtends() {

    }


    @Override
    public String checkInterfaceExtends(String name) throws Exception {
        return null;
    }
}
