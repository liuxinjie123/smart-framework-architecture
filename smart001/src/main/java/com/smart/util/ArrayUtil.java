package com.smart.util;

import org.apache.commons.lang3.ArrayUtils;

public final class ArrayUtil {
    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isNotEmpty(array);
    }

    /**
     * 判断数据是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
