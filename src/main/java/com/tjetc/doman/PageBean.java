package com.tjetc.doman;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {
    private Integer nowpage;
    private Integer count;
    private Integer eachpage;
    private Integer totalpage;
    private String  url;
    private List<T> lists;

    @Override
    public String toString() {
        return "PageBean{" +
                "nowpage=" + nowpage +
                ", count=" + count +
                ", eachpage=" + eachpage +
                ", totalpage=" + totalpage +
                ", url='" + url + '\'' +
                ", lists=" + lists +
                '}';
    }

    public PageBean() {
    }

    public PageBean(Integer nowpage, Integer count, Integer eachpage, Integer totalpage, String url, List<T> lists) {
        this.nowpage = nowpage;
        this.count = count;
        this.eachpage = eachpage;
        this.totalpage = totalpage;
        this.url = url;
        this.lists = lists;
    }

    public Integer getNowpage() {
        return nowpage;
    }

    public void setNowpage(Integer nowpage) {
        this.nowpage = nowpage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getEachpage() {
        return eachpage;
    }

    public void setEachpage(Integer eachpage) {
        this.eachpage = eachpage;
    }

    public Integer getTotalpage() {
        return count%eachpage==0?count/eachpage:count/eachpage+1;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
