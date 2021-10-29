package com.example.shop_detail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shop_detail.model.User;
import com.example.shop_detail.mapper.UserMapper;
import com.example.shop_detail.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)
 *
 * @author makejava
 * @since 2021-10-28 15:38:36
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public User findByUsername(String username) {
        return this.lambdaQuery()
                .eq(User::getUserName, username)
                .one();
    }

}