package me.zhengjie.repository;

import me.zhengjie.domain.MtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:19
 * Description:
 */
public interface MtUserRepository extends JpaRepository<MtUser, Long>, JpaSpecificationExecutor<MtUser> {
    List<MtUser> findByNameLike(@NonNull String name);

    List<MtUser> findByIdIn(Set<Long> ids);

    void deleteByIdIn(Set<Long> ids);
}
