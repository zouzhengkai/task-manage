package com.boxpractice.taskmanage.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(description = "医院实体DTO对象")
public class HospitalDto {

    @ApiModelProperty(value = "医院id")
    private Integer id;

    @ApiModelProperty(value = "医院名称")
    @NotEmpty(message = "医院名称不能为空")
    private String name;
}
