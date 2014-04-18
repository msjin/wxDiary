package com.service;

import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.config.WxConfig;
import com.type.CommandType;
import com.util.DateFormatUtil;

public class CommandService {

	private DiaryService diaryService;
	
	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	public String commandTodo(CommandType command, String openId){

		String result= null;
		switch (command) {
		case h:
			result = typeToStr();
			break;
		
		case pass:
			result = "请输入密码";
			break;
			
		case exit:
			result = userExit(openId);
			break;
			
		case cx:
			result = typeToStr("cx");
			break;
			
		case jt:
			result = getDiaryContent(DateFormatUtil.getDayClockZero(0), new Date(), openId);
			break;
			
		case zt:
			result = getDiaryContent(DateFormatUtil.getDayClockZero(-1), DateFormatUtil.getDayClockZero(0), openId);
			break;
			
		case qt:
			result = getDiaryContent(DateFormatUtil.getDayClockZero(-2), new Date(), openId);
			break;
			
		case bz:
			result = getDiaryContent(DateFormatUtil.getWeekFirstDayClockZero(0), new Date(), openId);
			break;
			
		case sz:
			result = getDiaryContent(DateFormatUtil.getWeekFirstDayClockZero(-1), DateFormatUtil.getWeekFirstDayClockZero(0), openId);
			break;
			
		case jy:
			result = getDiaryContent(DateFormatUtil.getMonthFirstDay(0), new Date(), openId);
			break;
			
		case sgy:
			result = getDiaryContent(DateFormatUtil.getMonthFirstDay(-1), DateFormatUtil.getDayClockZero(0), openId);
			break;
			
		case qb:
			result = getDiaryContent(null,null, openId);
			break;

		default:
			break;
		}
		
		result = buildWxPostXML(result, openId);
		return result;
		
	}
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("xml");
		element.addElement("ToUserName").addCDATA("hello");
		element.addElement("FromUserName").addText("");
		element.addElement("CreateTime").addText("");
		element.addElement("MsgType").addText("");
		element.addElement("Content").addText("");
		
		System.out.println(document.asXML());
	}
	
	private String getDiaryContent(Date starTime, Date endTime, String openId){
		String content = diaryService.getDiary(starTime, endTime, openId);
		return content;
	}
	
	private String buildWxPostXML(String content, String openId){
		
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("xml");
		element.addElement("ToUserName").addCDATA(openId);
		element.addElement("FromUserName").addCDATA(WxConfig.wxid_born);
		element.addElement("CreateTime").addText(String.valueOf(new Date().getTime()));
		element.addElement("MsgType").addCDATA("text");
		element.addElement("Content").addCDATA(content);
		
		return document.asXML();
	}
	
	public String typeToStr(){
		StringBuffer result = new StringBuffer();
		for(CommandType type : CommandType.values()){
			result = result.append(type.name()).append(":").append(type.getDetail()).append("\n");
		}
		
		return result.toString();
		
	}
	
	public String typeToStr(String cx){
		StringBuffer result = new StringBuffer();
		for(CommandType type : CommandType.values()){
			if(type.name().equals(CommandType.h.name()) || type.name().equals(CommandType.pass.name()) ||
					type.name().equals(CommandType.exit.name()) || type.name().equals(CommandType.cx.name())){
				continue;
			}
			result = result.append(type.name()).append(":").append(type.getDetail()).append("\n");
		}
		
		return result.toString();
		
	}
	
	private String userExit(String userId){
		//TODO
		return null;
	}
	
	
	
}
