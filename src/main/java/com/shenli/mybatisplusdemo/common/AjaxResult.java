package com.shenli.mybatisplusdemo.common;

import java.util.HashMap;

/**
 * AjaxResult
 * 用于统一返回格式 / Unified response format
 */
public class AjaxResult extends HashMap<String, Object> {

    public AjaxResult() {}

    // 成功（无数据）/ success without data
    public static AjaxResult success() {
        AjaxResult r = new AjaxResult();
        r.put("code", 200);
        r.put("msg", "success");
        return r;
    }

    // 成功（带数据）/ success with data
    public static AjaxResult success(Object data) {
        AjaxResult r = new AjaxResult();
        r.put("code", 200);
        r.put("msg", "success");
        r.put("data", data);
        return r;
    }

    // 错误 / error
    public static AjaxResult error(String msg) {
        AjaxResult r = new AjaxResult();
        r.put("code", 500);
        r.put("msg", msg);
        return r;
    }
}
