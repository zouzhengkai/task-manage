package com.boxpractice.taskmanage.mapper.ext;


import com.boxpractice.taskmanage.bean.dto.TaskDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TaskMapperExt {

    /**
     * 查询任务列表
     * @param employeeId
     * @param hospitalId
     * @return
     */
    List<TaskDto> queryTask(@Param("employeeId") Integer employeeId,
                            @Param("hospitalId") Integer hospitalId);

}
