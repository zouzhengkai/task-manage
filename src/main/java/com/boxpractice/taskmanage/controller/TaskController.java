package com.boxpractice.taskmanage.controller;

import com.boxpractice.taskmanage.bean.dto.TaskAssignDto;
import com.boxpractice.taskmanage.bean.dto.TaskDto;
import com.boxpractice.taskmanage.bean.vo.TaskVo;
import com.boxpractice.taskmanage.convert.TaskConvertor;
import com.boxpractice.taskmanage.service.TaskAssignService;
import com.boxpractice.taskmanage.service.TaskService;
import com.boxpractice.taskmanage.web.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@Api(tags = "任务管理")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @Resource
    private TaskAssignService taskAssignService;

    @Resource
    private TaskConvertor taskConvertor;

    /**
     * 任务创建
     * @param taskDto
     * @return
     */
    @ApiOperation("任务创建")
    @PostMapping(value = "/create")
    public ApiResponse<Integer> create(@RequestBody @Valid TaskDto taskDto) {
        return ApiResponse.success(taskService.saveOrUpdate(taskDto));
    }

    /**
     * 任务修改
     * @param taskDto
     * @return
     */
    @ApiOperation("任务更新")
    @PutMapping(value = "/update")
    public ApiResponse<Integer> update(@RequestBody @Valid TaskDto taskDto) {
        return ApiResponse.success(taskService.saveOrUpdate(taskDto));
    }

    /**
     * 任务指派
     * @param taskAssignDto
     * @return
     */
    @PutMapping(value = "/assign")
    @ApiOperation("任务指派")
    public ApiResponse<Void> assign(@RequestBody @Valid TaskAssignDto taskAssignDto) {
        taskAssignService.assign(taskAssignDto);
        return ApiResponse.success();
    }

    /**
     * 查询员工所有任务列表
     * @param employeeId
     * @return
     */
    @GetMapping(value = "/list/employee/{employeeId}")
    @ApiOperation("查询指定员工任务列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "员工id",required=true,paramType = "Integer", dataType = "Object")
    })
    public ApiResponse<List<TaskVo>> queryTaskListByEmployeeId(@PathVariable("employeeId") Integer employeeId) {
        List<TaskDto> taskDtoList = taskService.findTaskLissByEmployeeId(employeeId);
        return ApiResponse.success(taskConvertor.toVoList(taskDtoList));
    }

    /**
     * 查询医院所有任务列表
     * @param hospitalId
     * @return
     */
    @GetMapping(value = "/list/hostital/{hospitalId}")
    @ApiOperation("查询指定医院任务列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "员工id",required=true,paramType = "Integer", dataType = "Object")
    })
    public ApiResponse<List<TaskVo>> queryTaskListByHospitalId(@PathVariable("hospitalId") Integer hospitalId) {
        List<TaskDto> taskDtoList = taskService.findTaskLissByHospitalId(hospitalId);
        return ApiResponse.success(taskConvertor.toVoList(taskDtoList));
    }

}
