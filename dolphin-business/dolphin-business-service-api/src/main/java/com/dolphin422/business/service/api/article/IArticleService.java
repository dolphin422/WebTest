package com.dolphin422.business.service.api.article;

import com.dolphin422.business.model.article.ArticleModel;
import java.util.List;

/**
 * @Description: 博文业务层
 * @author: DamonJT WIN
 * @createDate: 2018.12.09 16:19
 */
public interface IArticleService {
    /**
     * 查询所有
     * @return
     */
    List<ArticleModel> selectAll();
}
