package com.bean.weixin;

public enum WxMsgType {

	text("文本"),
	image("图片"),
	voice("语音"),
	video("视频"),
	location("地理位置"),
	link("连接");
	
	private String detail;
	
	private WxMsgType(String name) {
		this.detail = name;
	}
	
	public String getDetail() {
		return this.detail;
	}
	
	
}
