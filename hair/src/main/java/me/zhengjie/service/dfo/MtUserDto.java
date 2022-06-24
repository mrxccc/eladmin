package me.zhengjie.service.dfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:05
 * Description: 会员
 */
@Getter
@Setter
public class MtUserDto extends BaseDTO implements Serializable {
    /**
     * 会员ID
     */
    @ApiModelProperty("会员ID")
    private Integer id;

    /**
     * 会员号
     */
    @ApiModelProperty("会员号")
    private String userNo;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 称呼
     */
    @ApiModelProperty("称呼")
    private String name;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    private String gradeId;


    /**
     * 性别 0男；1女
     */
    @ApiModelProperty("性别 0男；1女")
    private Integer sex;

    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private String birthday;

    /**
     * 车牌号
     */
    @ApiModelProperty("车牌号")
    private String carNo;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 余额
     */
    @ApiModelProperty("余额")
    private BigDecimal balance;

    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer point;

    /**
     * 剪发次数
     */
    @ApiModelProperty("剪发次数")
    private Integer cutHairCount;

    /**
     * 洗发次数
     */
    @ApiModelProperty("洗发次数")
    private Integer washHairCount;

    /**
     * 消费记录
     */
    @ApiModelProperty("消费记录")
    private List<MtConsumeRecordsDto> consumeRecords;

    /**
     * 状态，A：激活；N：禁用；D：删除
     */
    @ApiModelProperty("状态，A：激活；N：禁用；D：删除")
    private String status;

    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String remark;
}

