package com.example.shop_detail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_detail.model.User;

/**
 * (User)
 *
 * @author makejava
 * @since 2021-10-28 15:38:38
 */
public interface UserService extends IService<User> {

    /**
     * 通过账号查询用户
     *
     * @param username 账号
     * @return 用户
     */
    User findByUsername(String username);

}