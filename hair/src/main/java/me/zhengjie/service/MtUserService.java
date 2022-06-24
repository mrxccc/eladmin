package me.zhengjie.service;

import cn.hutool.core.lang.Dict;
import me.zhengjie.domain.hair.MtUser;
import me.zhengjie.service.dfo.MtUserDto;
import me.zhengjie.service.dfo.MtUserQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:   caijc
 * Date:     2022/6/24 15:49
 * Description:
 */
public interface MtUserService {
    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return
     */
    Map<String,Object> queryAll(MtUserQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     * @param dict
     * @return
     */
    List<MtUserDto> queryAll(MtUserQueryCriteria dict);

    /**
     * 创建
     * @param resources
     * @return
     */
    void create(MtUser resources);

    /**
     * 编辑
     * @param resources
     */
    void update(MtUser resources);

    /**
     * 删除
     * @param ids
     */
    void delete(Set<Long> ids);

    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response
     * @throws IOException
     */
    void download(List<MtUserDto> queryAll, HttpServletResponse response) throws IOException;
}
