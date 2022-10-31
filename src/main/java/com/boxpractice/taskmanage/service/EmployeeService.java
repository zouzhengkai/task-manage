package com.boxpractice.taskmanage.service;

import com.boxpractice.taskmanage.bean.dto.EmployeeDto;
import com.boxpractice.taskmanage.bean.dto.HospitalDto;
import com.boxpractice.taskmanage.bean.po.Employee;
import com.boxpractice.taskmanage.convert.EmployeeConvertor;
import com.boxpractice.taskmanage.exception.BusinessException;
import com.boxpractice.taskmanage.mapper.EmployeeMapper;
import com.boxpractice.taskmanage.web.ApiCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * 员工服务接口
 */
@Service
public class EmployeeService {

    @Resource
    private HospitalService hospitalService;

    @Resource
    private EmployeeConvertor employeeConvertor;

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 员工注册
     * @param employeeDto
     * @return
     */
    public int registerEmployee(EmployeeDto employeeDto){
        if(Objects.isNull(employeeDto)){
            new BusinessException(ApiCode.BIZ_ERROR,"参数不合法");
        }
        HospitalDto hospitalDto = hospitalService.findHospitalById(employeeDto.getHospitalId());
        Optional.ofNullable(hospitalDto).orElseThrow(()->new BusinessException(ApiCode.BIZ_ERROR,"员工所属医院不存在"));
        Employee employee = employeeConvertor.toPo(employeeDto);
        employeeMapper.insert(employee);
        return employee.getId();
    }

    /**
     * 根据医院id获取医院信息
     * @param employeeId
     * @return
     */
    public EmployeeDto findEmployeeById(Integer employeeId){
        Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
        return Optional.ofNullable(employee).map(v->{
            EmployeeDto result = employeeConvertor.toDto(v);
            return result;
        }).orElse(null);
    }

}
