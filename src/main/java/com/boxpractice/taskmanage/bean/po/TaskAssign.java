package com.boxpractice.taskmanage.bean.po;

import java.util.Date;

public class TaskAssign {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.task_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.employee_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private Integer employeeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.hospital_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private Integer hospitalId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.create_user
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.create_time
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.update_user
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_assign.update_time
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.id
     *
     * @return the value of task_assign.id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.id
     *
     * @param id the value for task_assign.id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.task_id
     *
     * @return the value of task_assign.task_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.task_id
     *
     * @param taskId the value for task_assign.task_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.employee_id
     *
     * @return the value of task_assign.employee_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.employee_id
     *
     * @param employeeId the value for task_assign.employee_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.hospital_id
     *
     * @return the value of task_assign.hospital_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.hospital_id
     *
     * @param hospitalId the value for task_assign.hospital_id
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.create_user
     *
     * @return the value of task_assign.create_user
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.create_user
     *
     * @param createUser the value for task_assign.create_user
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.create_time
     *
     * @return the value of task_assign.create_time
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.create_time
     *
     * @param createTime the value for task_assign.create_time
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.update_user
     *
     * @return the value of task_assign.update_user
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.update_user
     *
     * @param updateUser the value for task_assign.update_user
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_assign.update_time
     *
     * @return the value of task_assign.update_time
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_assign.update_time
     *
     * @param updateTime the value for task_assign.update_time
     *
     * @mbg.generated Fri Oct 28 21:06:02 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}