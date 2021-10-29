package com.example.shop_detail.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-10-28 15:38:36
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -78526761103952546L;
    /**
    * 用户Id
    */
        @TableId
        private Long userId;
    /**
    * 用户名
    */
        private String userName;
    /**
    * 密码
    */
        private String password;

}