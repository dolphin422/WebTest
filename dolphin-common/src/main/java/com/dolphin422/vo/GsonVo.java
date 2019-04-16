package com.dolphin422.vo;

import com.dolphin422.common.base.BaseVo;

/**
 * @author DamonJT WIN
 * @description:
 * @createDate: 2019.04.16 15:59
 */
public class GsonVo<T> extends BaseVo {
    private static final long serialVersionUID = 7416202463974777747L;

    private String title;

    private T t;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "GsonVo{" +
            "title='" + title + '\'' +
            ", t=" + t +
            '}';
    }
}
