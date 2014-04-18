package com.dao;

import org.springframework.data.mongodb.core.MongoTemplate;

public class DBsource {

	public MongoTemplate mongoTemplate;


	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	
}
