package com.boxpractice.taskmanage.convert;


import com.boxpractice.taskmanage.bean.dto.EmployeeDto;
import com.boxpractice.taskmanage.bean.po.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeConvertor {

    /**
     * po对象转dto对象
     * @param employee
     * @return
     */
    EmployeeDto toDto(Employee employee);

    /**
     * dto对象转po对象
     * @param employeeDto
     * @return
     */
    Employee toPo(EmployeeDto employeeDto);

}

