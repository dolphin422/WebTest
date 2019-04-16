package com.dolphin422.vo;

import com.dolphin422.common.base.BaseVo;
import java.util.Date;

/**
 * @author DamonJT WIN
 * @description:
 * @createDate: 2019.04.11 11:37
 */
public class TestVo extends BaseVo {
    private static final long serialVersionUID = -644355050054107194L;

    private String id;

    private String title;

    private String value;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
