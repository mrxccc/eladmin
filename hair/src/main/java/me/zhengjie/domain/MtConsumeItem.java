package me.zhengjie.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.zhengjie.base.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:25
 * Description: 消费记录明细
 */
@Entity
@Table(name = "mt_consume_item")
@Data
@EntityListeners(AuditingEntityListener.class)
public class MtConsumeItem extends BaseEntity {
    /**
     * 消费记录明细ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mt_consume_item", nullable = false, length = 10)
    private Long id;

    /**
     * 关联消费记录
     */
    @JoinColumn(name = "mt_record_id")
    @ManyToOne(fetch=FetchType.LAZY)
    @ApiModelProperty(value = "消费记录", hidden = true)
    private MtConsumeRecords record;

    /**
     * 消费类别
     */
    @Column(name = "consume_type", length = 100)
    private String consumeType;

    /**
     * 实收
     */
    @Column(name = "actual_amount", length = 10, scale = 2)
    private BigDecimal actualAmount;

    /**
     * 应收
     */
    @Column(name = "receivable", length = 10, scale = 2)
    private BigDecimal receivable;

    /**
     * 备注
     */
    @Column(name = "remark", length = 100)
    private String remark;
}
