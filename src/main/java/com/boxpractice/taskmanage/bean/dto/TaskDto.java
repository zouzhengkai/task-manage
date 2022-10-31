package com.boxpractice.taskmanage.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(description = "任务实体DTO对象")
public class TaskDto {

    @ApiModelProperty(value = "任务id")
    private Integer id;

    @ApiModelProperty(value = "任务标题")
    @NotEmpty(message = "任务标题不能为空")
    private String title;

    @ApiModelProperty(value = "任务描述")
    private String remark;

    @ApiModelProperty(value = "任务优先级")
    @NotEmpty(message = "任务优先级不能为空")
    private String priority;

    @ApiModelProperty(value = "任务归属医院id")
    private Integer hospitalId;

    @ApiModelProperty(value = "任务指派的员工id")
    private Integer employeeId;

    @ApiModelProperty(value = "任务状态")
    private Integer status;
}
