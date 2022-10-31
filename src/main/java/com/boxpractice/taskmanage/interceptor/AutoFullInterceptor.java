package com.boxpractice.taskmanage.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

@Slf4j
@Component
@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class AutoFullInterceptor implements Interceptor {

    /**
     * 创建用户
     */
    public static final String FIELD_CREATE_USER = "createUser";

    /**
     * 创建时间
     */
    public static final String FIELD_CREATE_TIME = "createTime";

    /**
     * 修改用户
     */
    public static final String FIELD_UPDATE_USER = "updateUser";

    /**
     * 修改时间
     */
    public static final String FIELD_UPDATE_TIME = "updateTime";


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try{
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
            Object parameter = invocation.getArgs()[1];
            createOfUpdate(parameter, sqlCommandType);
        }catch (Exception e){
            // Do nothing
        }
        return invocation.proceed();
    }

    /**
     * 新增活修改语句参数值自动填充
     * @param parameter
     * @param commandType
     */
    private void createOfUpdate(Object parameter, SqlCommandType commandType) {

        if (!(SqlCommandType.INSERT.equals(commandType)
                || SqlCommandType.UPDATE.equals(commandType))) {
            return;
        }
        if (parameter instanceof Map) {
            ((Map) parameter).forEach((k,v)->createOfUpdate(v, commandType));
        } else if (parameter instanceof Collection) {
            ((Collection) parameter).stream().forEach(v->createOfUpdate(v, commandType));
        }else{
            if(SqlCommandType.INSERT.equals(commandType)){
                executeInsert(parameter);
            }else {
                executeUpdate(parameter);
            }
        }
    }

    /**
     * insert 自动填充字段值
     * @param parameter
     */
    private void executeInsert(Object parameter){
        for (Field field : getAllField(parameter.getClass())) {
            ReflectionUtils.makeAccessible(field);
            String filedName = field.getName();
            Object currentValue = ReflectionUtils.getField(field,parameter);
            Object defaultValue = null;
            try{
                if(Objects.isNull(currentValue) && (Objects.equals(filedName,FIELD_CREATE_USER)
                        || Objects.equals(filedName,FIELD_UPDATE_USER))){
                    defaultValue = "admin";
                    ReflectionUtils.setField(field,parameter,defaultValue);
                }else if(Objects.isNull(currentValue) && (Objects.equals(filedName,FIELD_CREATE_TIME)
                        || Objects.equals(filedName,FIELD_UPDATE_TIME))){
                    defaultValue = new Date();
                    ReflectionUtils.setField(field,parameter,defaultValue);
                }

            }catch (Exception e){
                // Do nothing
            }
        }
    }


    /**
     * update 自动填充字段值
     * @param parameter
     */
    private void executeUpdate(Object parameter){
        for (Field field : getAllField(parameter.getClass())) {
            ReflectionUtils.makeAccessible(field);
            String filedName = field.getName();
            Object currentValue = ReflectionUtils.getField(field,parameter);
            Object defaultValue = null;
            try{
                if(Objects.isNull(currentValue) && (Objects.equals(filedName,FIELD_CREATE_TIME)
                        || Objects.equals(filedName,FIELD_UPDATE_TIME))){
                    defaultValue = new Date();
                    ReflectionUtils.setField(field,parameter,defaultValue);
                }
            }catch (Exception e){
                // Do nothing
            }

        }
    }

    /**
     * 反射获取对象字段列表
     * @param clz
     * @return
     */
    public static Field[] getAllField(Class<?> clz){
        List<Field> fieldList = new ArrayList<>() ;
        while (clz !=null && !clz.getName().toLowerCase().equals("java.lang.object") ){
            fieldList.addAll(Arrays.asList(clz.getDeclaredFields()));
            clz = clz.getSuperclass();
        }
        return fieldList.toArray(new Field[fieldList.size()]);
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // Do nothing
    }
}
