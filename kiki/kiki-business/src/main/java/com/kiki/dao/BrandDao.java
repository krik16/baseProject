/**
 * 
 */
package com.kiki.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kiki.entity.BrandEntity;

/**
 * @author kejun
 *
 */
@Repository
public class BrandDao extends BasicDAO<BrandEntity,ObjectId>{

	
	@Autowired
	Datastore datastore;
	
	@Autowired
	public BrandDao(Datastore ds) {
		super(ds);
	}

	public String getMGCategoriesTags(ObjectId mongoId){
		BrandEntity MGbrand = super.get(mongoId);
		String categoriesTags = MGbrand.getCategories_tags();
		return categoriesTags;
	}
	
	public List<BrandEntity> getBrandList(List<Object> idList){
		Query<BrandEntity> query = datastore.createQuery(BrandEntity.class);
		query.filter("id in", idList);
		return query.asList();
		
	}
}
