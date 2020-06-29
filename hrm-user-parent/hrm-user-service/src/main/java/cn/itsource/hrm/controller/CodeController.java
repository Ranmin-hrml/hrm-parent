package cn.itsource.hrm.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.itsource.hrm.client.CacheClient;
import cn.itsource.hrm.controller.vo.SMSCodeVo;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.SMSUtil;
import cn.itsource.hrm.util.StrUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private CacheClient cacheClient;

    /**
     * 图片验证码
     * @param uuid
     * @return
     */
    @GetMapping("/loadImageCode")
    public String loadImageCode(@RequestParam("uuid") String uuid){
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha ( 200, 100 );

        String code = lineCaptcha.getCode ();

        String imageBase64 = lineCaptcha.getImageBase64();

        //保存到redis
        String key = "CODE:IMAGECODE:"+uuid;
        AjaxResult ajaxResult = cacheClient.setex(key, 300, code);
        return imageBase64;

    }

    /**
     * 发送短信
     * @param vo
     * @return
     */
    @GetMapping("/loadSMSCode")
    public AjaxResult loadSMSCode(@RequestBody SMSCodeVo vo){

        try {
            //判断手机号码和验证码不为空
            if(StringUtils.isEmpty(vo.getPhoneNum())){
                return AjaxResult.me().setSuccess(false).setMessage("手机号码不能为空!");
            }
            if(StringUtils.isEmpty(vo.getCode())){
                return AjaxResult.me().setSuccess(false).setMessage("请输入图形验证码!");
            }
            if(StringUtils.isEmpty(vo.getUuid())){
                return AjaxResult.me().setSuccess(false).setMessage("前端标识不能为空!");
            }

            //判断图形验证码是否正确
            String redisKey = "CODE:IMAGE:"+vo.getUuid();
            AjaxResult validateCode = cacheClient.get(redisKey);
            if(!(vo.getCode().equals(validateCode))){
                return AjaxResult.me().setSuccess(false).setMessage("图形验证码错误!");
            }

            //从redis中获取短信验证码
            redisKey = "CODE:SMS:"+vo.getPhoneNum();
            //value = {验证码},{超时时间}
            AjaxResult redisValue = cacheClient.get(redisKey);

            String code = null;
            Long lastSendTime = null;

            if(StringUtils.isNotEmpty( String.valueOf ( redisValue ) )){
                String[] split = redisValue.split(",");
                code = split[0];
                lastSendTime = Long.valueOf(split[1]);

                //判断是否过了重发时间   20秒后可以重新发送
                if(System.currentTimeMillis()-lastSendTime<=20000){
                    //非法请求
                    return AjaxResult.me().setSuccess(false).setMessage("非法请求!");
                }
            }else{
                //之前没有发送过
                code = StrUtils.getRandomString(6);
            }

            lastSendTime = System.currentTimeMillis();
            //保存redis
            //redisValue = code+","+lastSendTime;
            //重发时间为20S，超时时间为5分钟
            //cacheClient.setex(redisKey,redisValue,5*60);


            //发送短信
            //SMSUtil.sendSMS(vo.getPhoneNum(),code);

            return AjaxResult.me().setSuccess(true).setMessage("发送成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("发送失败!"+e.getMessage());
        }
    }
}
