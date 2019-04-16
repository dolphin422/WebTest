package com.dolphin422.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author DamonJT WIN
 * @description:
 * @createDate: 2019.04.16 17:19
 */
public class CustomParameterizedType implements ParameterizedType {

    private final Class raw;

    private final Type[] args;

    public CustomParameterizedType(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
