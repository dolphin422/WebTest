package com.dolphin422.business.service.impl.articlecontent;

import com.dolphin422.business.dao.articlecontent.IArticleContentDao;
import com.dolphin422.business.model.articlecontent.ArticleContentModel;
import com.dolphin422.business.service.api.articlecontent.IArticleContentService;
import com.dolphin422.common.base.BaseServiceImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 博文内容业务实现类
 * @author: DamonJT WIN
 * @createDate: 2018.12.10 16:26
 */
@Service
@Transactional
public class ArticleContentServiceImpl extends BaseServiceImpl implements IArticleContentService {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ArticleContentServiceImpl.class);

    @Autowired
    private IArticleContentDao articleContentDao;

    public List<ArticleContentModel> selectAll() {
        List<ArticleContentModel> articleContentModelList = articleContentDao.selectAll();
        return articleContentModelList;
    }
}
