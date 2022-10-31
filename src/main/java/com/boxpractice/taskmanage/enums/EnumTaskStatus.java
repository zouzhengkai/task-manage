
package com.boxpractice.taskmanage.enums;


public enum EnumTaskStatus {

    OPEN("1", "打开"),

    FAILURE("2", "失败"),

    COMPILE("3", "完成"),
    ;
    private String code;
    private String desc;

    EnumTaskStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
