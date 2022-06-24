/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.domain.hair.MtUser;
import me.zhengjie.repository.MtUserRepository;
import me.zhengjie.service.MtUserService;
import me.zhengjie.service.dfo.MtUserDto;
import me.zhengjie.service.dfo.MtUserQueryCriteria;
import me.zhengjie.service.mapstruct.MtUserMapper;
import me.zhengjie.utils.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Service
@RequiredArgsConstructor
public class MtUserServiceImpl implements MtUserService {

    private final MtUserRepository mtUserRepository;
    private final MtUserMapper mtUserMapper;

    @Override
    public Map<String, Object> queryAll(MtUserQueryCriteria mtUser, Pageable pageable){
        Page<MtUser> page = mtUserRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, mtUser, cb), pageable);
        return PageUtil.toPage(page.map(mtUserMapper::toDto));
    }

    @Override
    public List<MtUserDto> queryAll(MtUserQueryCriteria mtUser) {
        List<MtUser> list = mtUserRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, mtUser, cb));
        return mtUserMapper.toDto(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(MtUser resources) {
        mtUserRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MtUser resources) {
        MtUser mtUser = mtUserRepository.findById(resources.getId()).orElseGet(MtUser::new);
        ValidationUtil.isNull( mtUser.getId(),"MtUser","id",resources.getId());
        mtUser.setName(resources.getName());
        mtUser.setRemark(resources.getRemark());
        mtUserRepository.save(mtUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        // 清理缓存
        List<MtUser> mtUsers = mtUserRepository.findByIdIn(ids);
        mtUserRepository.deleteByIdIn(ids);
    }

    @Override
    public void download(List<MtUserDto> mtUserDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (MtUserDto mtUserDTO : mtUserDtos) {

        }
        FileUtil.downloadExcel(list, response);
    }
}