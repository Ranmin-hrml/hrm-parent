package cn.itsource.hrm.util;

import cn.itsource.hrm.LoginInfoDto;

//用户的上下文对象 ，用来把登录信息存储到session，和从session中获取
public class UserContext {

    //把登录信息存储到session
    public static void setLoginInfo(LoginInfoDto loginInfoDto){
        //把LoginInfoDto放到session
    }

    //从session中获取登录信息
    public static LoginInfoDto getLoginInfo(){
        return new LoginInfoDto(26L,"源码时代" , 42L,"yhptest1");
    }

}
