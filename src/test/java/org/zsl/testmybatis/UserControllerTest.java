package org.zsl.testmybatis;

import com.alibaba.fastjson.JSON;
import com.cn.xm.controller.UserController;
import com.cn.xm.pojo.User;
import com.cn.xm.service.IUserService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class UserControllerTest {
    private static Logger logger = Logger.getLogger(UserControllerTest.class);
    // private ApplicationContext ac = null;
    @Resource
    private IUserService userService = null;

    @Resource
    private UserController userController;

    // @Before
    // public void before() {
    // ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    // userService = (IUserService) ac.getBean("userService");
    // }

    @Test
    public void test1() {
        System.out.println("tst");
        // userService.deleteUserById(1);
        User user = new User();
        user.setUserName("qiuwenming");
        user.setAge(20);
        // user.setId(4);
        user.setPassword("helll");
        userService.insertUser(user);
        User user1 = userService.getUserById(2);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user1));

    }
}
