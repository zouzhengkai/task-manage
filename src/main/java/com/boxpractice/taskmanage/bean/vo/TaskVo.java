package com.boxpractice.taskmanage.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "任务VO对象")
public class TaskVo {

    @ApiModelProperty(value = "任务id")
    private Integer id;

    @ApiModelProperty(value = "任务标题")
    private String title;

    @ApiModelProperty(value = "任务描述")
    private String remark;

    @ApiModelProperty(value = "任务优先级")
    private String priority;

    @ApiModelProperty(value = "任务归属医院id")
    private Integer hospitalId;

    @ApiModelProperty(value = "任务指派的员工id")
    private Integer employeeId;
}
