package com.kiki.core.framework.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.kiki.core.framework.mybatis.dao.BaseDao;
import com.kiki.core.framework.mybatis.service.BaseService;

public class BaseServiceImpl implements BaseService {

  @Autowired(required = false)
  @Qualifier(value = "baseDao")
  private BaseDao baseDao;

  @Override
  public BaseDao getBaseDao() {
    return this.baseDao;
  }
}
