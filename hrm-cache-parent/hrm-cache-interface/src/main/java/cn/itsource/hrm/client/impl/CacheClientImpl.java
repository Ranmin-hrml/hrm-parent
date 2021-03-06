package cn.itsource.hrm.client.impl;

import cn.itsource.hrm.client.CacheClient;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.stereotype.Component;


@Component
public class CacheClientImpl implements CacheClient{

    @Override
    public AjaxResult set(String key, String value) {
        return AjaxResult.me().setSuccess(false).setMessage("系统异常!");
    }

    @Override
    public AjaxResult get(String key) {
        return AjaxResult.me().setSuccess(false).setMessage("系统异常!");
    }

    @Override
    public AjaxResult setex(String key, Integer seconds, String value) {
        return AjaxResult.me().setSuccess(false).setMessage("系统异常!");
    }

    @Override
    public AjaxResult setnx(String key, String value) {
        return AjaxResult.me().setSuccess(false).setMessage("系统异常!");
    }

    @Override
    public AjaxResult deleteKey(String key) {
        return AjaxResult.me().setSuccess(false).setMessage("系统异常!");
    }
}
