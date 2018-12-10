package com.dolphin422.business.service.api.articlecontent;

import com.dolphin422.business.model.articlecontent.ArticleContentModel;
import java.util.List;

/**
 * @Description:
 * @author: DamonJT WIN
 * @createDate: 2018.12.09 16:20
 */
public interface IArticleContentService {
    /**
     * 查询所有
     * @return
     */
    List<ArticleContentModel> selectAll();

}
