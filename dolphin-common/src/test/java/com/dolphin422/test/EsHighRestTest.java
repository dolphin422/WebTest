package com.dolphin422.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DamonJT WIN
 * @description:
 * @createDate: 2019.04.11 10:27
 */
public class EsHighRestTest {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(EsHighRestTest.class);

    /**
     * 162 服务器外网IP
     */
    private final static String HTTP_HOST = "";

    /**
     * 162服务器  9200    9300
     * 默认 //http请求的端口是 9200，客户端是9300
     */
    private final static int HTTP_PORT = 9200;

    /**
     * es连接方式 http
     */
    private static final String ES_SCHEMA = "http";

    private RestHighLevelClient restHighLevelClient = null;

    /**
     * 获取客户端连接信息
     *
     * @return void
     * @throws
     * @Title: getConnect
     * @author sunt
     * @date 2017年11月23日
     */
    @SuppressWarnings({ "resource", "unchecked" })
    @Before
    public void getConnect() {
        try {
            restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                    new HttpHost(HTTP_HOST, HTTP_PORT, ES_SCHEMA)));
        } catch (Exception ex) {
            logger.debug("get elasticsearch restHighLevelClient failed");
            ex.printStackTrace();
        }
        logger.info("连接信息:" + restHighLevelClient.toString());
    }

    /**
     * 关闭连接
     *
     * @return void
     * @Title: closeConnect
     * @author sunt
     * @date 2017年11月23日
     */
    @After
    public void closeConnect() {
        if (null != restHighLevelClient) {
            try {
                restHighLevelClient.close();
            } catch (IOException e) {
                logger.info(" elasticsearch restHighLevelClient close failed");
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建索引库
     *
     * @return void
     * 需求:创建一个索引库为：msg消息队列,类型为：tweet,id为1
     * 索引库的名称必须为小写
     * @throws IOException
     * @Title: addIndex1
     * @author sunt
     * @date 2017年11月23日
     */
    @Test
    public void addIndex1() throws IOException {
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            .startObject().field("userName", "张三")
            .field("sendDate", new Date())
            .field("msg", "你好李四")
            .endObject();


       /* logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
            + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.toString());*/
    }

    /**
     * 添加索引:传入json字符串
     *
     * @return void
     * @Title: addIndex2
     * @author sunt
     * @date 2017年11月23日
     */
    @Test
    public void addIndexByJsonStr() throws IOException {
        IndexRequest request = new IndexRequest(
            "law",
            "lawtype",
            "2");
        String jsonStr = "{" +
            "\"user\":\"kimchy\"," +
            "\"postDate\":\"2013-01-30\"," +
            "\"message\":\"trying out Elasticsearch\"" +
            "}";
        request.source(jsonStr, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        logger.info("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
            + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.toString());
    }
    /*
     19:33:45.840 INFO  com.bosssoft.parb.page.test - 连接信息:org.elasticsearch.transport.client.PreBuiltTransportClient@715d6168
     11:03:23.864 INFO  c.parb.platform.common.test.EsTest - json索引名称:posts
json类型:doc
json文档ID:1
当前实例json状态:IndexResponse[index=posts,type=doc,id=1,version=1,result=created,seqNo=0,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
19:33:46.079 INFO  com.bosssoft.parb.page.test - 执行关闭连接操作...
     */

    /**
     * 创建索引-传入Map对象
     *
     * @return void
     * @Title: addIndex4
     * @author sunt
     * @date 2017年11月23日
     */
    @Test
    public void addIndex4() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "张三");
        map.put("sendDate", new Date());
        map.put("msg", "你好李四");

      /*  IndexResponse response = client.prepareIndex("momo", "tweet").setSource(map).get();

        logger.info("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
            + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.toString());*/
    }
    /*
     * 19:34:37.544 INFO  com.bosssoft.parb.page.test - 连接信息:org.elasticsearch.transport.client.PreBuiltTransportClient@6428591a
     * 19:34:37.825 INFO  com.bosssoft.parb.page.test - map索引名称:momo
     *  map类型:tweet
     *  map文档ID:koHgAWoBBArPgIfX4qLF
     * 当前实例map状态:IndexResponse[index=momo,type=tweet,id=koHgAWoBBArPgIfX4qLF,version=1,result=created,seqNo=0,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
     * 19:34:37.825 INFO  com.bosssoft.parb.page.test - 执行关闭连接操作...
     */

    /**
     * 从索引库获取数据
     *
     * @return void
     * @Title: getData1
     * @author sunt
     * @date 2017年11月23日
     */
    @Test
    public void getData1() throws IOException {
        GetRequest getRequest = new GetRequest(
            "law",
            "lawType",
            "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        String index = getResponse.getIndex();
        String type = getResponse.getType();
        String id = getResponse.getId();
        if (getResponse.isExists()) {
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
            logger.info("------------------version:{}", version);
            logger.info("------------------索引库的数据:{}", sourceAsString);
            logger.info("------------------sourceAsMap:{}", sourceAsMap);
            logger.info("------------------sourceAsBytes:{}", sourceAsBytes);
        } else {

        }
        logger.info("----------------index:{}", index);
        logger.info("----------------type:{}", type);
        logger.info("----------------id:{}", id);
    }
    /*
     * 17:45:50.932 INFO  com.bosssoft.parb.page.test - 连接信息:org.elasticsearch.transport.client.PreBuiltTransportClient@715d6168
     * 17:45:51.051 INFO  com.bosssoft.parb.page.test - 索引库的数据:{"title":"标题Vo","value":200,"remark":"测试Vo转JSON"}
     * 17:45:51.051 INFO  com.bosssoft.parb.page.test - 执行关闭连接操作...
     */

    @Test
    public void learnTest() {



    }
}
