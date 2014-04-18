package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bean.Diary;

public class DiaryDao extends BaseDaoImpl<Diary, String> {

	public Diary getDiaryByUserId(String userId){
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		Sort sort = new Sort(Direction.DESC, "createTime");
		query.with(sort);
		return this.mongoTemplate.findOne(query, Diary.class);
	}
	
	public Diary getDiaryByOpenId(String openId){
		Query query = new Query();
		query.addCriteria(Criteria.where("toUserName").is(openId));
		Sort sort = new Sort(Direction.DESC, "createTime");
		query.with(sort);
		return this.mongoTemplate.findOne(query, Diary.class);
	}
	
	/**
	 * 按时间查询
	 * @param starTime
	 * @param endTime
	 * @return
	 */
	public List<Diary> getDiaryList(Date starTime, Date endTime, String openId){
		Query query = new Query();
		
		query.addCriteria(Criteria.where("fromUserName").is(openId));
		if(starTime !=null){
			query.addCriteria(Criteria.where("createTimeFormat").gte(starTime));
		}
		 
		if(endTime !=null){
			query.addCriteria(Criteria.where("createTimeFormat").lte(endTime));
		}
		
		return this.mongoTemplate.find(query, Diary.class);
	}
}
