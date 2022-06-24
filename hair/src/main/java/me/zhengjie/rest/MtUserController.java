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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.Log;
import me.zhengjie.domain.hair.MtUser;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.service.MtUserService;
import me.zhengjie.service.dfo.MtUserQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@RestController
@RequiredArgsConstructor
@Api(tags = "系统：会员管理")
@RequestMapping("/api/mtUser")
public class MtUserController {

    private final MtUserService mtUserService;
    private static final String ENTITY_NAME = "mtUser";

    @ApiOperation("导出会员数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('mtUser:list')")
    public void exportMtUser(HttpServletResponse response, MtUserQueryCriteria criteria) throws IOException {
        mtUserService.download(mtUserService.queryAll(criteria), response);
    }

    @ApiOperation("查询会员")
    @GetMapping(value = "/all")
    @PreAuthorize("@el.check('mtUser:list')")
    public ResponseEntity<Object> queryAllMtUser(){
        return new ResponseEntity<>(mtUserService.queryAll(new MtUserQueryCriteria()),HttpStatus.OK);
    }

    @ApiOperation("查询会员")
    @GetMapping
    @PreAuthorize("@el.check('mtUser:list')")
    public ResponseEntity<Object> queryMtUser(MtUserQueryCriteria resources, Pageable pageable){
        return new ResponseEntity<>(mtUserService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增会员")
    @ApiOperation("新增会员")
    @PostMapping
    @PreAuthorize("@el.check('mtUser:add')")
    public ResponseEntity<Object> createMtUser(@Validated @RequestBody MtUser resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        mtUserService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改会员")
    @ApiOperation("修改会员")
    @PutMapping
    @PreAuthorize("@el.check('mtUser:edit')")
    public ResponseEntity<Object> updateMtUser(@Validated(MtUser.Update.class) @RequestBody MtUser resources){
        mtUserService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除会员")
    @ApiOperation("删除会员")
    @DeleteMapping
    @PreAuthorize("@el.check('mtUser:del')")
    public ResponseEntity<Object> deleteMtUser(@RequestBody Set<Long> ids){
        mtUserService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}