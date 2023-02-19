package com.luna.mybatis.test;

import com.luna.mybatis.mapper.UserMapper;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession:代表java程序与数据库之间的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口对象 返回一个接口对应的实现类的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 测试功能
        int result = mapper.insertUser();
        // 提交事务
        sqlSession.commit();
        // 返回受影响的函数
        System.out.println("result:" + result);
    }
}
