package com.dao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bean.User;

public class UserDao extends BaseDaoImpl<User, String> {

	public User getUserByWxid(String wxId){
		Query query = new Query();
		query.addCriteria(Criteria.where("wxId").is(wxId));
		return this.mongoTemplate.findOne(query, User.class);
	}
}
