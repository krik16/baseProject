package com.kiki.core.common;

public class Page {
  protected int pageNo = 1;// 第几页
  protected int pageSize = 20;// 默认是10
  protected int totalCount = -1;// 总条数

  public Page() {}

  public Page(int pageSize) {
    this.pageSize = pageSize;
  }

  public Page(int pageNo, int pageSize) {
    if (pageNo > 0) {
      this.pageNo = pageNo;
    }
    if (pageSize > 0)
      this.pageSize = pageSize;
  }


  public int getPageNo() {
    return this.pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;

    if (pageNo < 1)
      this.pageNo = 1;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getStartIndex()// 查询起点
  {
    return (this.pageNo - 1) * this.pageSize;
  }

  public int getTotalCount() {
    return this.totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }


  /**
   * 获取总页数
   */
  public int getTotalPages() {
    if (this.totalCount < 0) {
      return -1;
    }

    int totalPages = this.totalCount / this.pageSize;

    if (this.totalCount % this.pageSize > 0) {
      totalPages++;
    }

    return totalPages;
  }

  /**
   * 判断是否有下一页
   */
  public boolean isHasNext() {
    return this.pageNo + 1 <= getTotalPages();
  }

  /**
   * 获取下一页
   */
  public int getNextPage() {
    if (isHasNext()) {
      return this.pageNo + 1;
    }
    return this.pageNo;
  }

  /**
   * 判断是否是第一页
   */
  public boolean isHasPre() {
    return this.pageNo - 1 >= 1;
  }

  /**
   * 获取前一页
   */
  public int getPrePage() {
    if (isHasPre()) {
      return this.pageNo - 1;
    }
    return this.pageNo;
  }

  @Override
  public String toString() {
    return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + "]";
  }


}
