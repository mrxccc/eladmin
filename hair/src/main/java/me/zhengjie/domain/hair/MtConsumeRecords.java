package me.zhengjie.domain.hair;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:05
 * Description: 消费记录
 */
@Entity
@Table(name = "mt_consume_records")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class MtConsumeRecords extends BaseEntity{
    /**
     * 消费记录ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    private Integer id;

    /**
     * 关联会员
     */
    @JoinColumn(name = "mt_user_id")
    @ManyToOne(fetch=FetchType.LAZY)
    @ApiModelProperty(value = "会员", hidden = true)
    private MtUser mtUser;

    /**
     * 消费明细
     */
    @OneToMany(mappedBy = "record",cascade={CascadeType.PERSIST})
    private List<MtConsumeItem> consumeItem;

    /**
     * 消费总金额
     */
    @Column(name = "amount", length = 10)
    private BigDecimal amount;

    /**
     * 折扣
     */
    @Column(name = "discount")
    private BigDecimal discount;


    /**
     * 备注
     */
    @Column(name = "remark", length = 100)
    private String remark;
}
