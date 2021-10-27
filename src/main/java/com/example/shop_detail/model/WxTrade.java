package com.example.shop_detail.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * wx订单表(WxTrade)实体类
 *
 * @author makejava
 * @since 2021-10-21 15:02:11
 */
@Data
public class WxTrade implements Serializable {
    private static final long serialVersionUID = -86225563715618867L;
    /**
    * 主键id
    */
        @TableId
        private Integer tradeId;
    /**
    * 微信小商店app_id

    */
        private String appId;
    /**
    * 本条数据创建时间
    */
        private Date created;
    /**
    * 本条数据同步时间
    */
        private Date syncTime;
    /**
    * 是否本地发货，0:不是本地发货，1:本地发货
    */
        private Integer localPlatformSend;
    /**
    * 订单类型
    */
        private String tradeType;
    /**
    * 订单发货类型；WX_DELIVERY_SEND：微信正常流程发货，NO_DELIVERY_SEND：无物流发货，CONTACT_DELIVERY_SEND：自己联系物流发货

    */
        private String tradeSendType;
    /**
    * 一条订单中不同SKU_ID商品数
    */
        private Integer tradeItemNum;
    /**
    * 发货快递名称
    */
        private String deliveryName;
    /**
    * 合并状态
    */
        private String mergeStatus;
    /**
    * 母订单/ 原单号
    */
        private String mergeOrderId;
    /**
    * 合并时间
    */
        private Date mergeTime;
    /**
    * 取消合并的时间
    */
        private Date cancelMergeTime;
    /**
    * 本地打印的快递单号
    */
        private String selfWaybillId;
    /**
    * 本地打印的快递公司英文简称
    */
        private String selfDeliveryId;
    /**
    * 本地打印的快递公司名称
    */
        private String selfDeliveryName;
    /**
    * 本地打印的打印类型
    */
        private String selfWaybillType;
    /**
    * 【微信小商店】订单id
    */
        private String orderId;
    /**
    * 【微信小商店】订单创建时间
    */
        private Date createTime;
    /**
    * 【微信小商店】订单更新时间
    */
        private Date updateTime;
    /**
    * 【微信小商店】订单状态:10(待付款)，20(待发货)，30(待收货)，100(完成)，200(全部商品售后之后，订单取消),250(用户主动取消或待付款超时取消)
    */
        private String status;
    /**
    * 【微信小商店】用户备注
    */
        private String customerNotes;
    /**
    * 【微信小商店】商家备注
    */
        private String merchantNotes;
    /**
    * 【微信小商店】用户的openid，用于物流助手接口
    */
        private String openid;
    /**
    * 【微信小商店】付款时间
    */
        private Date payTime;
    /**
    * 【微信小商店】运费（单位：分）
    */
        private Long freight;
    /**
    * 【微信小商店】订单金额，包含运费（单位：分）
    */
        private Long orderPrice;
    /**
    * 【微信小商店】商品金额（单位：分）
    */
        private Long productPrice;
    /**
    * 【微信小商店】是否有优惠
    */
        private Integer isDiscounted;
    /**
    * 【微信小商店】优惠金额
    */
        private Long discountedPrice;
    /**
    * 【微信小商店】收货人姓名
    */
        private String userName;
    /**
    * 【微信小商店】邮编
    */
        private String postalCode;
    /**
    * 【微信小商店】国标收货地址第一级地址(省)
    */
        private String provinceName;
    /**
    * 【微信小商店】国标收货地址第二级地址(市)
    */
        private String cityName;
    /**
    * 【微信小商店】国标收货地址第三级地址(区)
    */
        private String countyName;
    /**
    * 【微信小商店】详细收货地址信息
    */
        private String detailInfo;
    /**
    * 【微信小商店】收货地址国家码
    */
        private String nationalCode;
    /**
    * 【微信小商店】收货人手机号码
    */
        private String telNumber;
    /**
    * 【微信小商店】快递方式（目前只有"快递"）
    */
        private String deliveryMethod;
    /**
    * 【微信小商店】快递公司编号
    */
        private String deliveryId;
    /**
    * 【微信小商店】快递单号
    */
        private String waybillId;
    /**
    * 【微信小商店】线下自提、同城配送距离（单位：米）
    */
        private Long distance;
    /**
    * 【微信小商店】线下配送时间
    */
        private Date offlineDeliveryTime;
    /**
    * 【微信小商店】线下自提时间
    */
        private Date offlinePickupTime;
    /**
    * 【微信小商店】自提商家联系人
    */
        private String pickupUserName;
    /**
    * 【微信小商店】自提地址国标第一级地址（自提订单才有该信息）
    */
        private String pickupProvinceName;
    /**
    * 【微信小商店】自提地址国标第二级地址（自提订单才有该信息）
    */
        private String pickupCityName;
    /**
    * 【微信小商店】自提地址国标第三级地址（自提订单才有该信息）
    */
        private String pickupCountyName;
    /**
    * 【微信小商店】自提地址详细信息（自提订单才有该信息）
    */
        private String pickupDetailInfo;
    /**
    * 【微信小商店】自提地址门牌号（自提订单才有该信息，可能为空）
    */
        private String pickupHouseNumber;
    /**
    * 【微信小商店】自提商家联系号码（自提订单才有该信息）
    */
        private String pickupTelNumber;
    /**
    * 【微信小商店】所有商品改的价钱
    */
        private Long changeDownPrice;
    /**
    * 合并条件的加密md5数据待发货状态（用户名，电话，地址，是否退款）
    */
        private String mergeEncryptInfo;
    /**
    * 退款，0有退款，1没有退款
    */
        private Object refund;
    /**
    * 小票打印标识
    */
        private String receiptMark;
    /**
    * 小票打印时间
    */
        private Date receiptPrintTime;
    /**
    * 标签打印标识
    */
        private String labelMark;
    /**
    * 标签打印时间
    */
        private Date labelPrintTime;

}