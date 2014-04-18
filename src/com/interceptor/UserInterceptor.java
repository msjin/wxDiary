package com.interceptor;

import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserSessionContext;
import com.config.StrStatic;

public class UserInterceptor implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		return true;
//		UserSessionContext session = (UserSessionContext)req.getSession().getAttribute(StrStatic.userSessionKEY);
//		if(session != null){
//			return true;
//		}else{
//			PrintWriter out = resp.getWriter();
//			out.print(false);
//			return false;
//		}
	}
	
	public static void main(String[] args) {
		String outTradeNo = UUID.randomUUID().toString().replace("-", "");
		System.out.println(outTradeNo.length());
	}

}
