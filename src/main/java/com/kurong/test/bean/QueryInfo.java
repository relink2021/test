package com.kurong.test.bean;

public class QueryInfo {
    private String query; // 查询信息 username
    private String type;  // 当前种类 sub_kind
    private int pageNum = 1; // 当前页
    private int pageSize = 10; // 每页最大数
    private int filter = 0;  // 筛选条件 0表示按商品名称排序
    private String buyername;
    private String owner;
    private int edit;

    public QueryInfo() {
    }

    public QueryInfo(String query, String type, int pageNum, int pageSize, int filter, String buyername, String owner, int edit) {
        this.query = query;
        this.type = type;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.filter = filter;
        this.buyername = buyername;
        this.owner = owner;
        this.edit = edit;
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

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "query='" + query + '\'' +
                ", type='" + type + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", filter=" + filter +
                ", buyername='" + buyername + '\'' +
                ", owner='" + owner + '\'' +
                ", edit=" + edit +
                '}';
    }
}
