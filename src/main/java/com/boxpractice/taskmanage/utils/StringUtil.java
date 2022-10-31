package com.boxpractice.taskmanage.utils;

import java.util.Arrays;

public class StringUtil {
    public static String join(Object[] strings, String separator) {
        if (strings == null) {
            return "";
        }
        return join(Arrays.asList(strings), separator);
    }

    public static String join(Iterable strings, String separator) {
        if (separator == null) {
            separator = " ";
        }
        StringBuilder sb = new StringBuilder();
        for (Object s : strings) {
            sb.append(s);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }


    /**
     * camel case (FooBar) to snake case (foo_bar)
     *
     * @param str
     * @return
     */
    public static String camelToSnake(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }



}
