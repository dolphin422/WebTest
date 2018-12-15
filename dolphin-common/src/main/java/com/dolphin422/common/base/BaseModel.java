package com.dolphin422.common.base;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description: Model类基类
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:22
 */
public class BaseModel implements Serializable {
    private static final long serialVersionUID = -8710424821693874504L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
