package com.kiki.core.common;

import java.io.Serializable;
import java.util.List;


public class PageList<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<T> list;// 查询结果

  private int total;// 总条数

  private Page page;

  public PageList(List<T> list, Page page) {
    this.list = list;
    this.page = page;
    this.total = page.getTotalCount();
  }

  public List<T> getList() {
    return this.list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  public Page getPage() {
    return this.page;
  }

  public void setPage(Page page) {
    this.page = page;
    this.total = page.getTotalCount();
  }

  public String toString() {
    return "PageList [list=" + this.list + ", page=" + this.page + "]";
  }

  /**
   * 
   * 前端分页
   * 
   * @author bdq.bao
   * @date 2014年9月5日 下午3:28:56
   */
  public List<T> getObjects(int pageNo) {
    int pageEndRow = 0;
    if (pageNo == 0)
      page.setPageNo(pageNo);
    else
      page.setPageNo(pageNo);
    if (page.isHasNext()) {// 判断是否为最后一页
      pageEndRow = pageNo * page.getPageSize();
    } else {
      pageEndRow = page.getTotalCount();
    }

    List<T> objects = null;
    if (!list.isEmpty()) {
      objects = list.subList(page.getStartIndex(), pageEndRow);
    }
    return objects;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

}
