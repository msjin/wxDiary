package com.type;

public enum CommandType {
	h("帮助"),
	pass("输入密码"),
	exit("退出"),
	
	cx("查询"),
	jt("今天"),
	zt("昨天"),
	qt("前天"),
	bz("本周"),
	sz("上周"),
	jy("今月"),
	sgy("上个月"),
	qb("全部");

	private String detail;
	private CommandType(String detail){
		this.detail = detail;
	}
	
	public String getDetail(){
		return detail;
	}
	
	
}
