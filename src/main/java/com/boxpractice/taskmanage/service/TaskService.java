package com.boxpractice.taskmanage.service;

import com.boxpractice.taskmanage.bean.dto.EmployeeDto;
import com.boxpractice.taskmanage.bean.dto.HospitalDto;
import com.boxpractice.taskmanage.bean.dto.TaskAssignDto;
import com.boxpractice.taskmanage.bean.dto.TaskDto;
import com.boxpractice.taskmanage.bean.po.Task;
import com.boxpractice.taskmanage.convert.TaskConvertor;
import com.boxpractice.taskmanage.enums.EnumTaskStatus;
import com.boxpractice.taskmanage.exception.BusinessException;
import com.boxpractice.taskmanage.mapper.TaskMapper;
import com.boxpractice.taskmanage.mapper.ext.TaskMapperExt;
import com.boxpractice.taskmanage.web.ApiCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 任务服务接口
 */
@Service
public class TaskService {

    @Resource
    private HospitalService hospitalService;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private TaskAssignService taskAssignService;

    @Resource
    private TaskConvertor taskConvertor;

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskMapperExt taskMapperExt;

    /**
     * 任务创建或更新
     * @param taskDto
     * @return
     */
    @Transactional
    public int saveOrUpdate(TaskDto taskDto){
        if(Objects.isNull(taskDto)){
            new BusinessException(ApiCode.BIZ_ERROR,"参数不合法");
        }
        Integer taskId = taskDto.getId();

        Task task = taskConvertor.toPo(taskDto);
        if(Objects.isNull(taskId)){
            task.setStatus(EnumTaskStatus.OPEN.getCode());
            taskMapper.insert(task);
        }else{
            Task curTask = taskMapper.selectByPrimaryKey(taskId);
            Optional.ofNullable(curTask).orElseThrow(()->new BusinessException(ApiCode.BIZ_ERROR,"任务不存在"));
            if(!Objects.equals(curTask.getHospitalId(),taskDto.getHospitalId())){
                throw new BusinessException(ApiCode.BIZ_ERROR,"不能修改其他医院任务");
            }
            String status = curTask.getStatus();
            if(EnumTaskStatus.FAILURE.getCode().equals(status) && !EnumTaskStatus.FAILURE.getCode().equals(task.getStatus())){
                throw new BusinessException(ApiCode.BIZ_ERROR,"当前任务是失败状态，不允许修改");
            }
            taskMapper.updateByPrimaryKeySelective(task);
        }
        //任务指派
        TaskAssignDto taskAssignDto = new TaskAssignDto();
        taskAssignDto.setTaskId(task.getId());
        taskAssignDto.setHospitalId(taskDto.getHospitalId());
        taskAssignDto.setEmployeeId(taskDto.getEmployeeId());
        taskAssignService.assign(taskAssignDto);

        return task.getId();
    }

    /**
     * 查询指定员工任务列表
     * @param employeeId
     * @return
     */
    public List<TaskDto> findTaskLissByEmployeeId(Integer employeeId){
       return taskMapperExt.queryTask(employeeId,null);
    }

    /**
     * 查找指定医院任务列表
     * @param hospitalId
     * @return
     */
    public List<TaskDto> findTaskLissByHospitalId(Integer hospitalId){
        return taskMapperExt.queryTask(null,hospitalId);
    }
}
