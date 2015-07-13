package com.kiki.entity;

import java.io.Serializable;

public class Equipment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6012890113620622279L;

	private Integer id;

    private String name;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}