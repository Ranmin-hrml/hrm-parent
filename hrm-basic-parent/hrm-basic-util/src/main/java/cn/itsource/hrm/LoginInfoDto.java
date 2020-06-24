package cn.itsource.hrm;

public class LoginInfoDto {
    //机构id
    private Long tenantId;
    //机构名字
    private String tenantName;
    //创建用户的id
    private Long userId;
    //创建用户的名字
    private String username;

    public LoginInfoDto() {
    }

    public LoginInfoDto(Long tenantId, String tenantName, Long userId, String username) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.userId = userId;
        this.username = username;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
