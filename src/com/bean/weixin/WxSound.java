package com.bean.weixin;

public class WxSound extends WxMsgBase{

	private String mediaId;//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。 
	private String thumbMediaId;//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。 
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	@Override
	public String toString() {
		return "WxMedia [mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId
				+ ", getToUserName()=" + getToUserName()
				+ ", getFromUserName()=" + getFromUserName()
				+ ", getCreateTime()=" + getCreateTime() + ", getMsgType()="
				+ getMsgType() + ", getMsgId()=" + getMsgId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
