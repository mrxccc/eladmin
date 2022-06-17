package me.zhengjie.domain.maotai;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Author:   caijc
 * Date:     2022/6/16 14:28
 * Description:
 */
@Getter
@Setter
@Entity
@Table(name = "maotai_plan")
public class MaotaiPlan extends BaseEntity implements Serializable {

    @Id
    @NotNull(groups = {Update.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 计划任务名称
    private String planName;

    // 状态
    private String status;
}
