package me.zhengjie;

import me.zhengjie.domain.MtConsumeRecords;
import me.zhengjie.domain.MtUser;
import me.zhengjie.repository.MtConsumeRecordsRepository;
import me.zhengjie.repository.MtUserRepository;
import me.zhengjie.service.MtUserService;
import me.zhengjie.service.dto.MtUserDto;
import me.zhengjie.service.dto.MtUserQueryCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MtConsumeRecordsServiceImplTest {

    @Resource
    MtConsumeRecordsRepository repository;

    @Test
    @Transactional(readOnly = true)
    void queryAll() {
        List<MtConsumeRecords> dtos = repository.findByMtUser_IdEquals(3L, Pageable.ofSize(10));
        dtos.stream().forEach(System.out::println);
    }

}