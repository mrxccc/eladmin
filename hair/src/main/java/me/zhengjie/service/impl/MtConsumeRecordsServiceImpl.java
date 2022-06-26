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

import me.zhengjie.domain.MtConsumeRecords;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.repository.MtConsumeRecordsRepository;
import me.zhengjie.service.MtConsumeRecordsService;
import me.zhengjie.service.dto.MtConsumeRecordsDto;
import me.zhengjie.service.dto.MtConsumeRecordsQueryCriteria;
import me.zhengjie.service.mapstruct.MtConsumeRecordsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @website https://el-admin.vip
 * @description 服务实现
 * @author mrxccc
 * @date 2022-06-25
 **/
@Service
@RequiredArgsConstructor
public class MtConsumeRecordsServiceImpl implements MtConsumeRecordsService {

    private final MtConsumeRecordsRepository mtConsumeRecordsRepository;
    private final MtConsumeRecordsMapper mtConsumeRecordsMapper;

    @Override
    public Map<String,Object> queryAll(MtConsumeRecordsQueryCriteria criteria, Pageable pageable){
        Page<MtConsumeRecords> page = mtConsumeRecordsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(mtConsumeRecordsMapper::toDto));
    }

    @Override
    public List<MtConsumeRecordsDto> queryAll(MtConsumeRecordsQueryCriteria criteria){
        return mtConsumeRecordsMapper.toDto(mtConsumeRecordsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public MtConsumeRecordsDto findById(Long id) {
        MtConsumeRecords mtConsumeRecords = mtConsumeRecordsRepository.findById(id).orElseGet(MtConsumeRecords::new);
        ValidationUtil.isNull(mtConsumeRecords.getId(),"MtConsumeRecords","id",id);
        return mtConsumeRecordsMapper.toDto(mtConsumeRecords);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MtConsumeRecordsDto create(MtConsumeRecords resources) {
        return mtConsumeRecordsMapper.toDto(mtConsumeRecordsRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MtConsumeRecords resources) {
        MtConsumeRecords mtConsumeRecords = mtConsumeRecordsRepository.findById(resources.getId()).orElseGet(MtConsumeRecords::new);
        ValidationUtil.isNull( mtConsumeRecords.getId(),"MtConsumeRecords","id",resources.getId());
        mtConsumeRecords.copy(resources);
        mtConsumeRecordsRepository.save(mtConsumeRecords);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            mtConsumeRecordsRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<MtConsumeRecordsDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (MtConsumeRecordsDto mtConsumeRecords : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put(" createBy",  mtConsumeRecords.getCreateBy());
            map.put(" createTime",  mtConsumeRecords.getCreateTime());
            map.put(" updateBy",  mtConsumeRecords.getUpdateBy());
            map.put(" updateTime",  mtConsumeRecords.getUpdateTime());
            map.put(" receivable",  mtConsumeRecords.getReceivable());
            map.put(" actualAmount",  mtConsumeRecords.getActualAmount());
            map.put(" discount",  mtConsumeRecords.getDiscount());
            map.put(" remark",  mtConsumeRecords.getRemark());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}