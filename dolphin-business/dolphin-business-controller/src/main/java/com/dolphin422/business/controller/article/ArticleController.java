package com.dolphin422.business.controller.article;

import com.dolphin422.business.model.article.ArticleModel;
import com.dolphin422.business.service.api.article.IArticleService;
import com.dolphin422.common.base.BaseController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 博文Controller层
 * @author: DamonJT WIN
 * @createDate: 2018.12.09 16:05
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private IArticleService articleService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<ArticleModel> selectAll() {
        List<ArticleModel> modelList = articleService.selectAll();
        return modelList;
    }

}
