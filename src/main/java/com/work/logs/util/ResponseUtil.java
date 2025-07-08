package com.work.logs.util;

import com.work.logs.constant.ResponseConst;
import org.json.JSONObject;

/**
 * 请求响应内容的构建工具类
 */
public class ResponseUtil {

    /**
     * 自定义的响应CODE
     */
    public static final String CUSTOM_CODE = "code";

    /**
     * 自定义的响应消息
     */
    public static final String CUSTOM_MESSAGE = "message";

    /**
     * 响应内容
     */
    public static final String CUSTOM_DATA = "data";

    /**
     * 创建成功响应内容
     * @param data 响应内容
     * @return JSONObject
     */
    public static JSONObject success(Object data) {
        JSONObject response = new JSONObject();
        response.put(CUSTOM_CODE, ResponseConst.CODE_SUCCESS);
        response.put(CUSTOM_MESSAGE, ResponseConst.MESSAGE_SUCCESS);
        response.put(CUSTOM_DATA, data);
        return response;
    }

    /**
     * 创建成功响应内容
     * @param code 自定义响应CODE
     * @param data 响应内容
     * @return JSONObject
     */
    public static JSONObject success(String code, Object data) {
        JSONObject response = new JSONObject();
        response.put(CUSTOM_CODE, code);
        response.put(CUSTOM_MESSAGE, ResponseConst.MESSAGE_SUCCESS);
        response.put(CUSTOM_DATA, data);
        return response;
    }

    /**
     * 创建成功响应内容
     * @param code 自定义响应CODE
     * @param message 自定义响应消息
     * @param data 响应内容
     * @return JSONObject
     */
    public static JSONObject success(String code, String message, Object data) {
        JSONObject response = new JSONObject();
        response.put(CUSTOM_CODE, code);
        response.put(CUSTOM_MESSAGE, message);
        response.put(CUSTOM_DATA, data);
        return response;
    }
}
