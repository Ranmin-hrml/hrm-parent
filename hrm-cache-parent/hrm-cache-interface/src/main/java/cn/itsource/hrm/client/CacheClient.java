package cn.itsource.hrm.client;

import cn.itsource.hrm.client.impl.CacheClientImpl;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cache-service",fallback = CacheClientImpl.class)
@Component
public interface CacheClient {

    /**
     * 设置字符值
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/setStr")
    AjaxResult set(
            @RequestParam("key") String key, @RequestParam("value") String value);


    /**
     * 获取字符值
     * @param key
     * @return
     */
    @GetMapping("/getStr")
    AjaxResult get(@RequestParam("key")String key);

    /**
     * 时间有效性
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    @GetMapping("/setex")
    AjaxResult setex(
            @RequestParam("key") String key,
            @RequestParam("seconds")Integer seconds,
            @RequestParam("value") String value);

    /**
     * 加锁
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/setnx")
    AjaxResult setnx(
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    @GetMapping("/deleteKey")
    AjaxResult deleteKey(
            @RequestParam("key") String key);
}
