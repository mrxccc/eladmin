package me.zhengjie.domain.maotai;

import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Author:   caijc
 * Date:     2022/6/16 16:30
 * Description:
 */
@Getter
@Setter
@Entity
@Table(name = "maotai_plan")
public class MaotaiConfig extends BaseEntity implements Serializable {
    @Id
    @NotNull(groups = {Update.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 配置名称
    private String configName;

    // 手机号
    private String phoneNo;

    // 姓名
    private String phoneName;

    // cookie
    private String cookie;

    // 业务类型
    private String bizType;
}
