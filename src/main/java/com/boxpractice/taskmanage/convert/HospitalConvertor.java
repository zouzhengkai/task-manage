package com.boxpractice.taskmanage.convert;


import com.boxpractice.taskmanage.bean.dto.HospitalDto;
import com.boxpractice.taskmanage.bean.po.Hospital;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalConvertor {

    /**
     * po对象转dto对象
     * @param hospital
     * @return
     */
    HospitalDto toDto(Hospital hospital);

    /**
     * dto对象转po对象
     * @param hospitalDto
     * @return
     */
    Hospital toPo(HospitalDto hospitalDto);

}

