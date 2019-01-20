package com.dolphin422.system.vo.jsontest;

import com.dolphin422.common.base.BaseVo;
import com.dolphin422.system.model.user.SysUserModel;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2018/12/25 22:16
 */
public class JsonTestVo extends BaseVo {


    private static final long serialVersionUID = 1663020002566698532L;

    private SysUserModel sysUserModel;

    private String code;

    private String message;

    private Integer num;

    private int intNum;

    private String[] names;

    private List<String> codes;

    private List<SysUserModel> userModelList;

    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public int getIntNum() {
        return intNum;
    }

    public void setIntNum(int intNum) {
        this.intNum = intNum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SysUserModel getSysUserModel() {
        return sysUserModel;
    }

    public void setSysUserModel(SysUserModel sysUserModel) {
        this.sysUserModel = sysUserModel;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public List<SysUserModel> getUserModelList() {
        return userModelList;
    }

    public void setUserModelList(List<SysUserModel> userModelList) {
        this.userModelList = userModelList;
    }

}
