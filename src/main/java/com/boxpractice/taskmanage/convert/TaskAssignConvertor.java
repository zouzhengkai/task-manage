package com.boxpractice.taskmanage.convert;


import com.boxpractice.taskmanage.bean.dto.TaskAssignDto;
import com.boxpractice.taskmanage.bean.po.TaskAssign;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskAssignConvertor {

    /**
     * dto对象转po对象
     * @param taskAssignDto
     * @return
     */
    TaskAssign toPo(TaskAssignDto taskAssignDto);

}

