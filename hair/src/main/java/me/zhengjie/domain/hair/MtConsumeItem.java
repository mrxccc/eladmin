package me.zhengjie.domain.hair;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class MtConsumeItem extends BaseEntity {
    /**
     * 消费记录明细ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mt_consume_item", nullable = false, length = 10)
    private Integer id;

    /**
     * 关联消费记录
     */
    @JoinColumn(name = "mt_record_id")
    @ManyToOne(fetch=FetchType.LAZY)
    @ApiModelProperty(value = "消费记录", hidden = true)
    private MtConsumeRecords record;

    /**
     * 消费类型
     */
    @Column(name = "consume_type", length = 100)
    private String consumeType;

    /**
     * 消费金额
     */
    @Column(name = "amount", length = 10)
    private BigDecimal amount;

    /**
     * 备注
     */
    @Column(name = "remark", length = 100)
    private String remark;
}
