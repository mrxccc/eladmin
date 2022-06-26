package me.zhengjie.repository;


import me.zhengjie.domain.MtConsumeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:36
 * Description:
 */
public interface MtConsumeItemRepository extends JpaRepository<MtConsumeItem, Long>, JpaSpecificationExecutor<MtConsumeItem> {
}
