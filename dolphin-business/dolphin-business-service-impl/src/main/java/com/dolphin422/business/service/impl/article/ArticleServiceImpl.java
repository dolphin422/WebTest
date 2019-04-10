package com.dolphin422.business.service.impl.article;

import com.dolphin422.business.dao.article.IArticleDao;
import com.dolphin422.business.model.article.ArticleModel;
import com.dolphin422.business.service.api.article.IArticleService;
import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.system.service.api.user.ISysUserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 博文业务实现类
 * @author: DamonJT WIN
 * @createDate: 2018.12.10 16:21
 */
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl implements IArticleService {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ISysUserService userservice;

    @Autowired
    private IArticleDao articleDao;

    @Override
    public List<ArticleModel> selectAll() {
        List<ArticleModel> modelList = articleDao.selectAll();
        return modelList;
    }
}
