package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bean.UserSessionContext;
import com.config.StrStatic;
import com.util.XMLConvertUtil;

public class BaseController extends MultiActionController {
	
	public UserSessionContext getUserSession(HttpServletRequest request){
		return (UserSessionContext)request.getSession().getAttribute(StrStatic.userSessionKEY);
	}
	
	public void setUserSession(HttpServletRequest request, UserSessionContext userSession){
		request.getSession().setAttribute(StrStatic.userSessionKEY, userSession);
	}
	
	
	public Map<String, String> getMapByreqXML(HttpServletRequest request) throws IOException, DocumentException{
		String xml = getXMLfromReq(request);
		return XMLConvertUtil.xmltoMap(xml);
	}
	
	private String getXMLfromReq(HttpServletRequest request) throws IOException, DocumentException{
		
		StringBuffer bufferStr = new StringBuffer();
		
		ServletInputStream stream = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String inputLine = "";
        while ((inputLine = reader.readLine()) != null) {
        	bufferStr.append(inputLine + "\n");
		}
        
        String result = URLDecoder.decode(bufferStr.toString(), "gbk");
        
        return result;
	}
	
}
