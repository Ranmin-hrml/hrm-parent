package cn.itsource.hrm.controller.vo;

import lombok.Data;

@Data
public class SMSCodeVo {
    /**
     * 手机号码
     */
    private String phoneNum;
    /**
     * 前端的uuid
     */
    private String uuid;
    /**
     * 图形验证码
     */
    private String code;
}
