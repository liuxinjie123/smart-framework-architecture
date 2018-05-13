package com.smart.util;

import com.smart.config.BeanHelper;
import com.smart.config.ClassHelper;
import com.smart.config.ControllerHelper;
import com.smart.config.IocHelper;

public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
