package me.zhengjie.service.dfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;
import me.zhengjie.domain.hair.MtConsumeRecords;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:25
 * Description: 消费记录明细
 */
@Getter
@Setter
public class MtConsumeItemDto extends BaseDTO implements Serializable {
    /**
     * 消费记录明细ID
     */
    @ApiModelProperty("消费记录明细ID")
    private Integer id;

    /**
     * 关联消费记录
     */
    @ApiModelProperty("关联消费记录")
    private MtConsumeRecords record;

    /**
     * 消费类型
     */
    @ApiModelProperty("消费类型")
    private String consumeType;

    /**
     * 消费金额
     */
    @ApiModelProperty("消费金额")
    private BigDecimal amount;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
