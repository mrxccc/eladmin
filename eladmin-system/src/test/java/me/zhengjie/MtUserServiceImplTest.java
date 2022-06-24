package me.zhengjie;

import me.zhengjie.domain.hair.MtUser;
import me.zhengjie.repository.MtUserRepository;
import me.zhengjie.service.MtUserService;
import me.zhengjie.service.dfo.MtUserDto;
import me.zhengjie.service.dfo.MtUserQueryCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MtUserServiceImplTest {
    @Resource
    MtUserService mtUserService;

    @Resource
    MtUserRepository mtUserRepository;

    @Test
    @Transactional(readOnly = true)
    void queryAll() {
        List<MtUserDto> mtUserDtos = mtUserService.queryAll(new MtUserQueryCriteria());
        mtUserDtos.stream().forEach(System.out::println);
    }

    @Test
    @Transactional
    void create() {
        MtUser mtUser = new MtUser();
        mtUser.setUserNo("123");
        mtUser.setName("test");
        mtUser.setBalance(BigDecimal.valueOf(100D));
        mtUserService.create(mtUser);
    }

    @Test
    void testQueryAll() {
    }

    @Test
    @Transactional
    void update() {
        MtUser user = mtUserRepository.getById(1L);
        System.out.println(user);
    }

    @Test
    @Transactional
    void delete() {
        mtUserRepository.deleteById(1L);
    }

    @Test
    void download() {
    }
}