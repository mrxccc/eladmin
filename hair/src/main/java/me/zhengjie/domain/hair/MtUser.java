package me.zhengjie.domain.hair;

import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * mt_user 会员实体类
 */
@Entity
@Table(name = "mt_user")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class MtUser extends BaseEntity{
    /**
     * 会员ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    private Long id;

    /**
     * 会员号
     */
    @Column(name = "user_no", length = 30)
    private String userNo;

    /**
     * 头像
     */
    @Column(name = "avatar", length = 100)
    private String avatar;

    /**
     * 称呼
     */
    @Column(name = "name", length = 30)
    private String name;

    /**
     * 手机号码
     */
    @Column(name = "mobile", length = 20)
    private String mobile;

    /**
     * 等级
     */
    @Column(name = "grade_id", length = 10)
    private String gradeId;

    /**
     * 性别 0男；1女
     */
    @Column(name = "sex", length = 1)
    private Integer sex;

    /**
     * 出生日期
     */
    @Column(name = "birthday", length = 20)
    private String birthday;

    /**
     * 车牌号
     */
    @Column(name = "car_no", length = 10)
    private String carNo;

    /**
     * 密码
     */
    @Column(name = "password", length = 32)
    private String password;

    /**
     * 地址
     */
    @Column(name = "address", length = 100)
    private String address;

    /**
     * 余额
     */
    @Column(name = "balance", length = 10)
    private BigDecimal balance;

    /**
     * 积分
     */
    @Column(name = "point", length = 10)
    private Integer point;

    /**
     * 剪发次数
     */
    @Column(name = "cut_hair_count", length = 10)
    private Integer cutHairCount;

    /**
     * 洗发次数
     */
    @Column(name = "wash_hair_count", length = 10)
    private Integer washHairCount;

    /**
     * 消费记录
     */
    @OneToMany(mappedBy = "mtUser",cascade={CascadeType.PERSIST})
    private List<MtConsumeRecords> consumeRecords;

    /**
     * 状态，A：激活；N：禁用；D：删除
     */
    @Column(name = "status", length = 1)
    private String status;

    /**
     * 备注信息
     */
    @Column(name = "remark", length = 255)
    private String remark;
}

