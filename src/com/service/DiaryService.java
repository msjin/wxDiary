package com.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Diary;
import com.bean.weixin.WxImage;
import com.bean.weixin.WxLink;
import com.bean.weixin.WxLocation;
import com.bean.weixin.WxMsgType;
import com.bean.weixin.WxSound;
import com.bean.weixin.WxText;
import com.bean.weixin.WxVideo;
import com.dao.DiaryDao;
import com.util.DateFormatUtil;
import com.util.MapToBeanUtil;

public class DiaryService {

	private DiaryDao diaryDao;
	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}
	
	public void saveDiary(Map<String, String> map){
		WxMsgType msgType = WxMsgType.valueOf(map.get("MsgType"));
		switch (msgType) {
		case text:
			saveDiaryText(map);
			break;
			
		case image:
			saveDiaryImage(map);
			break;
					
		case voice:
			saveDiarySound(map);
			break;
		
		case video:
			saveDiaryVideo(map);	
			break;
		case location:
			saveDiaryLocation(map);
			break;

		default:
			break;
		}
	}
	
	public String getDiary(Date starTime, Date endTime, String openId){
		
		List<Diary> list = diaryDao.getDiaryList(starTime, endTime, openId);
		StringBuffer result = new StringBuffer();
		String content = null;
		for(Diary diary:list){
			switch (diary.getMsgType()) {
				case text:
					content = getDiaryText(diary);
					break;
					
				case image:
					content = getDiaryImage(diary);
					break;
							
				case voice:
					content = getDiarySound(diary);
					break;
				
				case video:
					content = getDiaryVideo(diary);	
					break;
					
				case location:
					content = getDiaryLocation(diary);
					break;
					
				case link:
					content = getDiaryLink(diary);
					break;
	
				default:
					break;
			}
			
			result.append(content);
		}
		return result.toString();
	}
	
	//---------------------------save---------------------------------
	public void saveDiaryText(Map<String, String> map){
		Diary diary = new Diary();
		WxText text =  new WxText();
		text = (WxText) MapToBeanUtil.convert2Bean(map, text);
		diary.setText(text);
		try {
			diary.setCreateTimeFormat(DateFormatUtil.strToDate(text.getCreateTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		diaryDao.save(diary);
	}
	
	public void saveDiaryImage(Map<String, String> map){
		Diary diary = new Diary();
		WxImage val =  new WxImage();
		val = (WxImage) MapToBeanUtil.convert2Bean(map, val);
		diary.setImage(val);
		diary.setMsgType(WxMsgType.valueOf(val.getMsgType()));
		diaryDao.save(diary);
	}
	
	public void saveDiarySound(Map<String, String> map){
		Diary diary = new Diary();
		WxSound val =  new WxSound();
		val = (WxSound) MapToBeanUtil.convert2Bean(map, val);
		diary.setSound(val);
		diary.setMsgType(WxMsgType.valueOf(val.getMsgType()));
		diaryDao.save(diary);
	}
	
	public void saveDiaryVideo(Map<String, String> map){
		Diary diary = new Diary();
		WxVideo val =  new WxVideo();
		val = (WxVideo) MapToBeanUtil.convert2Bean(map, val);
		diary.setVideo(val);
		diary.setMsgType(WxMsgType.valueOf(val.getMsgType()));
		diaryDao.save(diary);
	}
	
	public void saveDiaryLocation(Map<String, String> map){
		Diary diary = new Diary();
		WxLocation val =  new WxLocation();
		val = (WxLocation) MapToBeanUtil.convert2Bean(map, val);
		diary.setLocation(val);
		diary.setMsgType(WxMsgType.valueOf(val.getMsgType()));
		diaryDao.save(diary);
	}
	
	public void saveDiaryLink(Map<String, String> map){
		Diary diary = new Diary();
		WxLink val =  new WxLink();
		val = (WxLink) MapToBeanUtil.convert2Bean(map, val);
		diary.setLink(val);
		diary.setMsgType(WxMsgType.valueOf(val.getMsgType()));
		diaryDao.save(diary);
	}
	

	//---------------------------get---------------------------------
	
	public String getDiaryText(Diary diary){
		StringBuffer result = new StringBuffer();
		String time = DateFormatUtil.dateToTime(diary.getCreateTimeFormat());
		result.append(time).append("\n").append(diary.getText().getContent()).append("\n");
		
		return result.toString();
	}
	
	public String getDiaryImage(Diary diary){
		return null;
	}
	
	public String getDiarySound(Diary diary){
		return null;
	}
	
	public String getDiaryVideo(Diary diary){
		return null;
	}
	
	public String getDiaryLocation(Diary diary){
		return null;
	}
	
	public String getDiaryLink(Diary diary){
		return null;
	}
	
	
	public static void main(String[] args) throws ParseException {
		System.out.println(System.currentTimeMillis());
		Date d = DateFormatUtil.shortStrToDate("1397406888");
		System.out.println(DateFormatUtil.dateToTime(d));
	}
	
	
}
