package cn.itsource.hrm.query;


public class BaseQuery {

    //最大价格
    private Float priceMax;
    //最小价格
    private Float priceMin;
    //课程类型
    private Long productType;

    private Integer pageNum;

    private Integer pageSize;

    private String keyword;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
