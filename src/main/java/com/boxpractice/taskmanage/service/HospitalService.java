package com.boxpractice.taskmanage.service;

import com.boxpractice.taskmanage.bean.dto.HospitalDto;
import com.boxpractice.taskmanage.bean.po.Hospital;
import com.boxpractice.taskmanage.bean.po.HospitalExample;
import com.boxpractice.taskmanage.convert.HospitalConvertor;
import com.boxpractice.taskmanage.exception.BusinessException;
import com.boxpractice.taskmanage.mapper.HospitalMapper;
import com.boxpractice.taskmanage.web.ApiCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * 医院服务接口
 */
@Service
public class HospitalService {

    @Resource
    private HospitalConvertor hospitalConvertor;

    @Resource
    private HospitalMapper hospitalMapper;

    /**
     * 注册医院
     * @param hospitalDto
     * @return
     */
    public int registerHospital(HospitalDto hospitalDto){
        if(Objects.isNull(hospitalDto)){
            new BusinessException(ApiCode.BIZ_ERROR,"参数不合法");
        }
        checkExists(hospitalDto);
        Hospital hospital = hospitalConvertor.toPo(hospitalDto);
        hospitalMapper.insert(hospital);
        return hospital.getId();
    }

    /**
     * 根据医院id获取医院信息
     * @param hospitalId
     * @return
     */
    public HospitalDto findHospitalById(Integer hospitalId){
        Hospital hospital = hospitalMapper.selectByPrimaryKey(hospitalId);
        return Optional.ofNullable(hospital).map(v->{
            HospitalDto result = hospitalConvertor.toDto(v);
            return result;
        }).orElse(null);
    }

    /**
     * 校验是否已经存在同名医院
     * @param hospitalDto
     */
    private void checkExists(HospitalDto hospitalDto){
        HospitalExample example = new HospitalExample();
        example.createCriteria().andNameEqualTo(hospitalDto.getName());
        long count = hospitalMapper.countByExample(example);
        Optional.ofNullable(count).filter(v->v==0).orElseThrow(()->new BusinessException(ApiCode.BIZ_ERROR,"医院已注册过"));
    }
}
