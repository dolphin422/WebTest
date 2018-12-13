package com.dolphin422.common.vo.returndata;

import com.dolphin422.common.base.BaseVo;
import com.dolphin422.common.enumeration.statuscode.StatusCodeEnum;
import com.dolphin422.common.util.DateUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Description: 返回信息VO
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:18
 */
public class ReturnVo<T> extends BaseVo {

    private static final long serialVersionUID = -3303508331314859002L;

    /**
     * 状态码
     * 200 成功  其他均为失败
     */
    private String statusCode;

    /**
     * 状态描述
     */
    private String description;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 业务数据
     * JSON格式字符串
     */
    private T data;

    /**
     * 成功状态 ReturnVo
     * 无返回 业务数据
     *
     * @return ReturnVo statusCode :200 message : 操作成功
     */
    public static ReturnVo<String> successVo() {
        return new ReturnVo<String>(StatusCodeEnum.SUCCESS.getStatusCode(),
            StatusCodeEnum.SUCCESS.getDescription());
    }

    /**
     * 失败状态 ReturnVo
     * Enum<? extends ICustomStatusEnum> customStatusEnum
     *
     * @return ReturnVo statusCode :600 message : 操作失败
     */
    public static ReturnVo<String> failVo(StatusCodeEnum customStatusEnum) {
        return new ReturnVo<String>(customStatusEnum.getStatusCode(), customStatusEnum.getDescription());
    }

    /**
     * 成功状态 ReturnVo
     * 返回 业务数据(转化为JSON格式字符串)
     * 其中的日期格式为:yyyy-MM-dd,若业务数据本身为String 不转化
     *
     * @param data 业务数据
     * @return ReturnVo statusCode :200,message : 操作成功 ,data:JSON格式业务数据
     */
    public static ReturnVo<String> successVo(Object data) {
        ReturnVo<String> jsonDataReturnVo = new ReturnVo<String>(StatusCodeEnum.SUCCESS.getStatusCode(),
            StatusCodeEnum.SUCCESS.getDescription());
        if (null == data) {
            return jsonDataReturnVo;
        }
        if (data instanceof String) {
            jsonDataReturnVo.setData((String) data);
            return jsonDataReturnVo;
        }
        Gson gsonSource = new GsonBuilder().setDateFormat(DateUtil.FORMAT_YYYY_MM_DD).create();
        String dataJson = gsonSource.toJson(data);
        jsonDataReturnVo.setData(dataJson);
        return jsonDataReturnVo;
    }

    /**
     * 成功状态 ReturnVo
     * 返回原始业务数据 (不转化为JSON格式)
     *
     * @param data 业务数据
     * @param <T>  原始业务数据类型
     * @return ReturnVo statusCode :200,message : 操作成功 , data:原始业务数据
     */
    public static <T> ReturnVo<T> successVoWithOriginalData(T data) {
        ReturnVo<T> originalDataReturnVo = new ReturnVo<T>();
        originalDataReturnVo.setData(data);
        return originalDataReturnVo;
    }

    /**
     * 构造函数 (一)
     */
    private ReturnVo() {
    }

    /**
     * 构造函数 (二)
     */
    private ReturnVo(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    /**
     * 信息  公有
     * @param message 信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * setter 私有
     *
     * @param statusCode 状态码
     */
    private void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * setter 私有
     *
     * @param description 描述
     */
    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * setter 私有
     *
     * @param data 业务数据
     */
    private void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnVo{" +
            "statusCode='" + statusCode + '\'' +
            ", description='" + description + '\'' +
            ", message='" + message + '\'' +
            ", data=" + data.toString() +
            '}';
    }
}
