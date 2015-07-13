package com.kiki.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("brands")
public class BrandEntity {
	@Id
	private String id;
	private String icon;
	private String ename;
	private String name;
	private String keyTags; // 关键标签，shop需要.
	private String categories_tags;// 品类
	private String description;// 品牌描述
	private String tags;// 品牌标签

	public String getIcon() {
		return icon;
	}

	public String getEname() {
		return ename;
	}

	public String getName() {
		return name;
	}

	public String getKeyTags() {
		return keyTags;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKeyTags(String keyTags) {
		this.keyTags = keyTags;
	}

	public String getFullIcon() {
		return "http://rongyi.b0.upaiyun.com/system/brand/icon/" + id + "/" + icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategories_tags() {
		return categories_tags;
	}

	public void setCategories_tags(String categories_tags) {
		this.categories_tags = categories_tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
