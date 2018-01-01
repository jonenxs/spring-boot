package com.nxs.service;

public interface UserService {

    /**
     * 创建用户表
     */
    void init();

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 删除表User
     */
    void destroy();
}
