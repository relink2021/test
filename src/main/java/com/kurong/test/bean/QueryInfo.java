package com.kurong.test.bean;

public class QueryInfo {
    private String query; // 查询信息 username
    private String type;  // 当前种类 sub_kind
    private int pageNum = 1; // 当前页
    private int pageSize = 10; // 每页最大数

    public QueryInfo() {
    }

    public QueryInfo(String query, String type, int pageNum, int pageSize) {
        this.query = query;
        this.type = type;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "query='" + query + '\'' +
                ", type='" + type + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
