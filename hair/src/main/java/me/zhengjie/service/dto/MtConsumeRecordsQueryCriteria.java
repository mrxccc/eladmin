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
package me.zhengjie.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import me.zhengjie.annotation.Query;
import me.zhengjie.domain.MtUser;

/**
* @website https://el-admin.vip
* @author mrxccc
* @date 2022-06-25
**/
@Data
public class MtConsumeRecordsQueryCriteria{

    /** 精确 */
    @Query
    private Long id;

    /** 精确 */
    @Query
    private Long mtUserId;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;
}