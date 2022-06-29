package me.zhengjie.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
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
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class MtConsumeRecords extends BaseEntity{
    /**
     * 消费记录ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    private Long id;

    /**
     * 关联会员
     */
    @JoinColumn(name = "mt_user_id")
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    private MtUser mtUser;

    /**
     * 消费明细
     */
    @OneToMany(mappedBy = "record",cascade={CascadeType.PERSIST})
    private List<MtConsumeItem> consumeItem;

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
     * 折扣
     */
    @Column(name = "discount")
    private BigDecimal discount;


    /**
     * 备注
     */
    @Column(name = "remark", length = 100)
    private String remark;

    public void copy(MtConsumeRecords source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
