package me.zhengjie.service.dfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;
import me.zhengjie.domain.hair.MtConsumeItem;
import me.zhengjie.domain.hair.MtUser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:05
 * Description: 消费记录
 */
@Getter
@Setter
public class MtConsumeRecordsDto extends BaseDTO implements Serializable {
    /**
     * 消费记录ID
     */
    @ApiModelProperty("消费记录ID")
    private Integer id;

    /**
     * 关联会员
     */
    @ApiModelProperty("关联会员")
    private MtUser mtUser;

    /**
     * 消费明细
     */
    @ApiModelProperty("消费明细")
    private List<MtConsumeItem> consumeItem;

    /**
     * 消费总金额
     */
    @ApiModelProperty("消费总金额")
    private BigDecimal amount;

    /**
     * 折扣
     */
    @ApiModelProperty("折扣")
    private BigDecimal discount;


    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
