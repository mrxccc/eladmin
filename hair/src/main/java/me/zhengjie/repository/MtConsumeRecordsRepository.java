package me.zhengjie.repository;

import me.zhengjie.domain.hair.MtConsumeRecords;
import me.zhengjie.domain.hair.MtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:19
 * Description:
 */
public interface MtConsumeRecordsRepository extends JpaRepository<MtConsumeRecords, Long>, JpaSpecificationExecutor<MtConsumeRecords> {

}
