package com.boxpractice.taskmanage.convert;


import com.boxpractice.taskmanage.bean.dto.TaskDto;
import com.boxpractice.taskmanage.bean.po.Task;
import com.boxpractice.taskmanage.bean.vo.TaskVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskConvertor {

    /**
     * dto对象列表转vo对象列表
     * @param taskDtoList
     * @return
     */
    List<TaskVo> toVoList(List<TaskDto> taskDtoList);

    /**
     * po对象转do对象
     * @param task
     * @return
     */
    TaskDto toDto(Task task);

    /**
     * dto对象转po对象
     * @param taskDto
     * @return
     */
    Task toPo(TaskDto taskDto);

}

