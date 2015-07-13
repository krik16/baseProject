package com.kiki.entity;

public class BaseEntity {

    public Class<?> getEntityMapperClass() {
        throw new RuntimeException(this.getClass().getName() + "not implement getEntityMapperClass method!");
    }
    
}
