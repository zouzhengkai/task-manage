package com.boxpractice.taskmanage.mapper;

import com.boxpractice.taskmanage.bean.po.TaskAssign;
import com.boxpractice.taskmanage.bean.po.TaskAssignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskAssignMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    long countByExample(TaskAssignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int deleteByExample(TaskAssignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int insert(TaskAssign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int insertSelective(TaskAssign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    List<TaskAssign> selectByExample(TaskAssignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    TaskAssign selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int updateByExampleSelective(@Param("record") TaskAssign record, @Param("example") TaskAssignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int updateByExample(@Param("record") TaskAssign record, @Param("example") TaskAssignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int updateByPrimaryKeySelective(TaskAssign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_assign
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    int updateByPrimaryKey(TaskAssign record);
}