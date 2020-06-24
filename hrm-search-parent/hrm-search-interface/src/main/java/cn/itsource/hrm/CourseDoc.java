package cn.itsource.hrm;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "hrm1",type = "course")

public class CourseDoc {

    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    // @id 文档id
    @Id
    private Long id;
    /**
     * 课程名称
     */
    @Field(type =FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String name;
    /**
     * 适用人群
     */
    private String users;
    /**
     * 课程大分类
     */
    private Long courseTypeId;
    /**
     * 课程等级
     */
    private Long gradeId;
    private String gradeName;
    /**
     * 教育机构
     */
    private Long tenantId;
    private String tenantName;
    /**
     * 课程的开始时间
     */
    private Date startTime;
    private Date endTime;
    /**
     * 封面
     */
    private String pic;
    /**
     * 收费规则，0免费 ， 1收费
     */
    private Integer charge;
    //价格
    private Float price;
    private Float priceOld;
    /**
     * 简介
     */
    @Field(type =FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String description;
    //上线时间
    private Date onlineTime = new Date();
    //购买数量
    private Integer buyNumber = 0;
    //浏览数量
    private Integer browseNumber = 0;
    //评论数
    private Integer commentNumber = 0;

    @Override
    public String toString() {
        return "CourseDoc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gradeId=" + gradeId +
                ", price=" + price +
                '}';
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Long getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Long courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Float getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(Float priceOld) {
        this.priceOld = priceOld;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Integer getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
}
