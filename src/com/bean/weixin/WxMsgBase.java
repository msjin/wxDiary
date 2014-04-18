package com.bean.weixin;

public class WxMsgBase {

	private String toUserName; //接收方微信号 
	private String fromUserName;//发送方微信号，若为普通用户，则是一个OpenID 
	private String createTime;//消息创建时间 
	private String msgType;//消息类型
	private String msgId;//消息id，64位整型 
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
