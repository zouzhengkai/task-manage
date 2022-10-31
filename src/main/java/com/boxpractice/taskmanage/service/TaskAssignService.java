package com.boxpractice.taskmanage.service;

import com.boxpractice.taskmanage.bean.dto.EmployeeDto;
import com.boxpractice.taskmanage.bean.dto.HospitalDto;
import com.boxpractice.taskmanage.bean.dto.TaskAssignDto;
import com.boxpractice.taskmanage.bean.po.Task;
import com.boxpractice.taskmanage.bean.po.TaskAssign;
import com.boxpractice.taskmanage.bean.po.TaskAssignExample;
import com.boxpractice.taskmanage.convert.TaskAssignConvertor;
import com.boxpractice.taskmanage.exception.BusinessException;
import com.boxpractice.taskmanage.mapper.TaskAssignMapper;
import com.boxpractice.taskmanage.mapper.TaskMapper;
import com.boxpractice.taskmanage.web.ApiCode;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 任务指派服务接口
 */
@Service
public class TaskAssignService {

    @Resource
    private TaskAssignConvertor taskAssignConvertor;

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskAssignMapper taskAssignMapper;

    @Resource
    private HospitalService hospitalService;

    @Resource
    private EmployeeService employeeService;

    /**
     * 任务指派
     * @param taskAssignDto
     * @return
     */
    public void assign(TaskAssignDto taskAssignDto){
        Task curTask = taskMapper.selectByPrimaryKey(taskAssignDto.getTaskId());
        Optional.ofNullable(curTask).orElseThrow(()->new BusinessException(ApiCode.BIZ_ERROR,"任务不存在"));

        HospitalDto hospitalDto = hospitalService.findHospitalById(taskAssignDto.getHospitalId());
        Optional.ofNullable(hospitalDto).orElseThrow(()->new BusinessException(ApiCode.BIZ_ERROR,"员工所属医院不存在"));

        EmployeeDto employeeDto = employeeService.findEmployeeById(taskAssignDto.getEmployeeId());
        Optional.ofNullable(employeeDto).orElseThrow(()->new BusinessException(ApiCode.BIZ_ERROR,"任务分配的员工不存在"));

        if(!Objects.equals(curTask.getHospitalId(),hospitalDto.getId())){
            throw new BusinessException(ApiCode.BIZ_ERROR,"指派任务不属于当前医院");
        }
        if(!Objects.equals(employeeDto.getHospitalId(),hospitalDto.getId())){
            throw new BusinessException(ApiCode.BIZ_ERROR,"任务指派员工不属于当前医院");
        }

        TaskAssignExample example = new TaskAssignExample();
        example.createCriteria().andTaskIdEqualTo(taskAssignDto.getTaskId())
                .andHospitalIdEqualTo(taskAssignDto.getHospitalId());
        List<TaskAssign> taskAssignList = taskAssignMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(taskAssignList)){
            TaskAssign taskAssign = taskAssignList.get(0);
            Optional.ofNullable(taskAssign).filter(v->!Objects.equals(taskAssignDto.getEmployeeId(),v.getEmployeeId()))
                    .ifPresent(v->{
                        TaskAssign upTaskAssign = new TaskAssign();
                        upTaskAssign.setId(taskAssign.getId());
                        upTaskAssign.setEmployeeId(taskAssignDto.getEmployeeId());
                        taskAssignMapper.updateByExampleSelective(upTaskAssign,example);
                    });
        }else{
            new TaskAssign();
            TaskAssign taskAssign =  taskAssignConvertor.toPo(taskAssignDto);
            taskAssignMapper.insert(taskAssign);
        }
    }


}
