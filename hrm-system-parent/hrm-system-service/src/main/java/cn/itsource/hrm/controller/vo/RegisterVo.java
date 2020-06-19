package cn.itsource.hrm.controller.vo;

import lombok.Data;

@Data
public class RegisterVo {
    private String companyName;
    private String companyNum;
    private Long tenantType;
    private Long registerTime;
    private String address;
    private String logo;
    private Integer state = 1;
    private String username;
    private String password;
    private Long mealId;
}
