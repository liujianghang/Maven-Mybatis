package com.luna.mybatis.mapper;

public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名保持一致
     * 2.映射文件中SQL语句的id要和mapper接口中的方法名一直
     */
    /*
        添加用户信息
     */
    int insertUser();


}
