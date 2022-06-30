package me.zhengjie.repository;


import me.zhengjie.domain.MtConsumeRecords;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:19
 * Description:
 */
public interface MtConsumeRecordsRepository extends JpaRepository<MtConsumeRecords, Long>, JpaSpecificationExecutor<MtConsumeRecords> {
    @Query("select m from MtConsumeRecords m where m.mtUser.id = ?1")
    List<MtConsumeRecords> findByMtUser_IdEquals(Long id, Pageable pageable);


}
