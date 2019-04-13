package com.dolphin422.test;

import com.dolphin422.vo.TestVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: com.bosssoft.parb.page
 * Description： TODO
 * Author: peng
 * Date: Created in 2019/4/8 19:17
 * Company: 博思软件
 * Modified By:  peng
 */
public class EsTransportTest {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(EsTransportTest.class);

    /**
     * 162 服务器外网IP
     */
    private final static String HOST = "1.119.162.242";

    /**
     * 162服务器  28920    28930
     * 默认 //http请求的端口是9200，客户端是9300
     */
    private final static int PORT = 28930;

    private TransportClient client = null;

    /**
     * 获取客户端连接信息
     *
     * @return void
     * @throws UnknownHostException
     * @Title: getConnect
     * @author sunt
     * @date 2017年11月23日
     */
    @SuppressWarnings({ "resource", "unchecked" })
    @Before
    public void getConnect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
            new TransportAddress(InetAddress.getByName(HOST), PORT));
        logger.info("连接信息:" + client.toString());
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
        if (null != client) {
            logger.info("执行关闭连接操作...");
            client.close();
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
        IndexResponse response = client.prepareIndex("msg", "tweet", "1")
            .setSource(xContentBuilder).get();

        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
            + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.toString());
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
    public void addIndex2() {
        String jsonStr = "{" +
            "\"userName\":\"张三\"," +
            "\"sendDate\":\"2017-11-30\"," +
            "\"msg\":\"你好李四\"" +
            "}";
        IndexResponse response = client.prepareIndex("weixin", "tweet").setSource(jsonStr, XContentType.JSON)
            .get();
        logger.info("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
            + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.toString());

    }
    /*
     19:33:45.840 INFO  com.bosssoft.parb.page.test - 连接信息:org.elasticsearch.transport.client.PreBuiltTransportClient@715d6168
     19:33:46.079 INFO  com.bosssoft.parb.page.test - json索引名称:weixin
     json类型:tweet
     json文档ID:kYHgAWoBBArPgIfXGKKh
     当前实例json状态:IndexResponse[index=weixin,type=tweet,id=kYHgAWoBBArPgIfXGKKh,version=1,result=created,seqNo=0,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
     19:33:46.079 INFO  com.bosssoft.parb.page.test - 执行关闭连接操作...
     */

    /**
     * 创建索引-传入json
     *
     * @return void
     * @Title: addIndex3
     * @author sunt
     * @date 2017年11月23日
     */
    @Test
    public void addIndex3() {
        TestVo testVo = new TestVo();
        testVo.setValue("测试Vo转JSON");
        testVo.setTitle("标题Vo");
        testVo.setDate(new Date());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String josnStr = gson.toJson(testVo);
        IndexResponse response =
            client.prepareIndex("momo", "tweet").setSource(josnStr, XContentType.JSON).get();

        logger.info("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
            + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.toString());
    }
    /*
     * 17:43:42.836 INFO  com.bosssoft.parb.page.test - 连接信息:org.elasticsearch.transport.client.PreBuiltTransportClient@715d6168
     * 17:43:43.080 INFO  com.bosssoft.parb.page.test - map索引名称:momo
     *  map类型:tweet
     *  map文档ID:l4GhBmoBBArPgIfXr6IZ
     * 当前实例map状态:IndexResponse[index=momo,type=tweet,id=l4GhBmoBBArPgIfXr6IZ,version=1,result=created,seqNo=1,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
     * 17:43:43.081 INFO  com.bosssoft.parb.page.test - 执行关闭连接操作...
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

        IndexResponse response = client.prepareIndex("momo", "tweet").setSource(map).get();

        logger.info("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
            + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.toString());
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
    public void getData1() {
        GetResponse getResponse = client.prepareGet("law", "lawtype", "6066D949EBF14CDC8767FCF766965443").get();
        logger.info("索引库的数据:" + getResponse.getSourceAsString());
    }
    /*
     * 17:45:50.932 INFO  com.bosssoft.parb.page.test - 连接信息:org.elasticsearch.transport.client.PreBuiltTransportClient@715d6168
     * 17:45:51.051 INFO  com.bosssoft.parb.page.test - 索引库的数据:{"title":"标题Vo","value":200,"remark":"测试Vo转JSON"}
     * 17:45:51.051 INFO  com.bosssoft.parb.page.test - 执行关闭连接操作...
     */
}
