package com.controller;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.service.CommandService;
import com.service.DiaryService;
import com.type.CommandType;

public class IndexController extends BaseController {
	
	private CommandService commandService;
	private DiaryService diaryService;

	public void setCommandService(CommandService commandService) {
		this.commandService = commandService;
	}

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}


	//未认证,只有这个入口
	public ModelAndView vertifyToten(HttpServletRequest request, HttpServletResponse response){
		try{
			
			Map<String, String> map = getMapByreqXML(request);
			if(map ==null) return null;
			
			String openId = map.get("FromUserName");
			String msg = map.get("Content");
			
			//判断msg是否是命令
			CommandType[] types = CommandType.values();
			String[] typeStrs = new String[types.length];
			for(int i=0; i<types.length; i++){
				typeStrs[i]=types[i].name();
			}
			List<String> typeList = Arrays.asList(typeStrs);
			
			PrintWriter out = response.getWriter();
			if(typeList.contains(msg)){
				
				CommandType type = CommandType.valueOf(msg);
				String result = commandService.commandTodo(type, openId);
				
				out.print(result);
				out.flush();
				out.close();
				
			}else{
				diaryService.saveDiary(map);
				out.print("");
				out.flush();
				out.close();
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		out.print(echostr);
		System.out.println("return echostr:"+echostr);
		return null;
	 */
	
	
	
	
	
}
