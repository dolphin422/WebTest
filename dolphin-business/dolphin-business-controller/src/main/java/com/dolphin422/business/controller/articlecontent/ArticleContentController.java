package com.dolphin422.business.controller.articlecontent;

import com.dolphin422.business.model.articlecontent.ArticleContentModel;
import com.dolphin422.business.service.api.articlecontent.IArticleContentService;
import com.dolphin422.common.base.BaseController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 博文内容Controller层
 * @author: DamonJT
 * @createDate: 2018.12.09 16:17
 */
@Controller
@RequestMapping("/articleContent")
public class ArticleContentController extends BaseController {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ArticleContentController.class);

    @Autowired
    private IArticleContentService articleContentService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<ArticleContentModel> selectAll() {
        List<ArticleContentModel> modelList = articleContentService.selectAll();
        return modelList;
    }
}
