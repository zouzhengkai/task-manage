package com.boxpractice.taskmanage.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "员工实体DTO对象")
public class EmployeeDto {

    @ApiModelProperty(value = "员工id")
    private Integer id;

    @ApiModelProperty(value = "员工名称")
    @NotEmpty(message = "员工名称不能为空")
    private String name;

    @ApiModelProperty(value = "所属医院")
    @NotNull(message = "所属医院不能为空")
    private Integer hospitalId;
}
