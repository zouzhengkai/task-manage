package com.boxpractice.taskmanage.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "任务指派实体DTO对象")
public class TaskAssignDto {

    @ApiModelProperty(value = "任务id")
    @NotNull(message = "任务编号不能为空")
    private Integer taskId;

    @ApiModelProperty(value = "指派员工id")
    @NotNull(message = "员工编号不能为空")
    private Integer employeeId;

    @ApiModelProperty(value = "医院id")
    @NotNull(message = "所属医院不能为空")
    private Integer hospitalId;
}
