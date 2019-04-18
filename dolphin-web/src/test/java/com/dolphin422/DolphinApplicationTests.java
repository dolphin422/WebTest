package com.dolphin422;

import com.dolphin422.system.model.user.SysUserModel;
import com.dolphin422.system.service.api.user.ISysUserService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DolphinApplicationTests {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(DolphinApplicationTests.class);

    @Autowired
    private ISysUserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSpringTest() {
        List<SysUserModel> userModelList = userService.searchListByPage();
        logger.info("---------------------{}",userModelList.toString());
    }
}
