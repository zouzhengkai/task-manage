package com.boxpractice.taskmanage.controller;

import com.boxpractice.taskmanage.bean.dto.HospitalDto;
import com.boxpractice.taskmanage.service.HospitalService;
import com.boxpractice.taskmanage.web.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@Api(tags = "医院管理")
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Resource
    private HospitalService hospitalService;

    /**
     * 医院注册
     * @param hospitalDto
     * @return
     */
    @ApiOperation("注册医院")
    @PostMapping(value = "/register")
    public ApiResponse<Integer> register(@RequestBody @Valid HospitalDto hospitalDto) {
        return ApiResponse.success(hospitalService.registerHospital(hospitalDto));
    }

}
