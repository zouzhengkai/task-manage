package com.boxpractice.taskmanage.controller;

import com.boxpractice.taskmanage.bean.dto.EmployeeDto;
import com.boxpractice.taskmanage.service.EmployeeService;
import com.boxpractice.taskmanage.web.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@Api(tags = "员工管理")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 员工注册
     * @param employeeDto
     * @return
     */
    @ApiOperation("注册员工")
    @PostMapping(value = "/register")
    public ApiResponse<Integer> register(@RequestBody @Valid EmployeeDto employeeDto) {
        return ApiResponse.success(employeeService.registerEmployee(employeeDto));
    }

}
