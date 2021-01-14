package com.blog.utils;

import java.util.HashMap;

/**
 * 结果
 *
 * @author guoyanan
 * @date:2019年5月27日
 */
public class R extends HashMap<String, Object> {

    public R(int code, String msg) {
        super.put("code", code);
        super.put("msg", msg);
    }

    public static R ok() {
        return ok(200, "success");
    }

    public static R ok(int code) {
        return new R(code, "success");
    }

    public static R ok(String msg) {
        return ok(200, msg);
    }

    public static R ok(int code, String msg) {
        return new R(code, msg);
    }

    public static R error() {
        return new R(500, "failure");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        return new R(code, msg);
    }

    public static R blankParams() {
        return new R(10001, "数据不能为空");
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}