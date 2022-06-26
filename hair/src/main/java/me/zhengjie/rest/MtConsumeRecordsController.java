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
package me.zhengjie.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.domain.MtConsumeRecords;
import me.zhengjie.service.MtConsumeRecordsService;
import me.zhengjie.service.dto.MtConsumeRecordsQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author mrxccc
* @date 2022-06-25
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "MtConsumeRecordsController管理")
@RequestMapping("/api/mtConsumeRecords")
public class MtConsumeRecordsController {

    private final MtConsumeRecordsService mtConsumeRecordsService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('mtConsumeRecords:list')")
    public void exportMtConsumeRecords(HttpServletResponse response, MtConsumeRecordsQueryCriteria criteria) throws IOException {
        mtConsumeRecordsService.download(mtConsumeRecordsService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询")
    @ApiOperation("查询")
    @PreAuthorize("@el.check('mtConsumeRecords:list')")
    public ResponseEntity<Object> queryMtConsumeRecords(MtConsumeRecordsQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(mtConsumeRecordsService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增")
    @ApiOperation("新增")
    @PreAuthorize("@el.check('mtConsumeRecords:add')")
    public ResponseEntity<Object> createMtConsumeRecords(@Validated @RequestBody MtConsumeRecords resources){
        return new ResponseEntity<>(mtConsumeRecordsService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改")
    @ApiOperation("修改")
    @PreAuthorize("@el.check('mtConsumeRecords:edit')")
    public ResponseEntity<Object> updateMtConsumeRecords(@Validated @RequestBody MtConsumeRecords resources){
        mtConsumeRecordsService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除")
    @ApiOperation("删除")
    @PreAuthorize("@el.check('mtConsumeRecords:del')")
    public ResponseEntity<Object> deleteMtConsumeRecords(@RequestBody Long[] ids) {
        mtConsumeRecordsService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}