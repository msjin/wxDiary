package com.bean;

import java.util.Date;

import com.bean.weixin.WxLink;
import com.bean.weixin.WxLocation;
import com.bean.weixin.WxImage;
import com.bean.weixin.WxMsgType;
import com.bean.weixin.WxSound;
import com.bean.weixin.WxText;
import com.bean.weixin.WxVideo;

public class Diary{
	
	private String id;
	private WxText text;
	private WxVideo video;
	private WxSound sound;
	private WxLink link;
	private WxLocation location;
	private WxImage image;
	private WxMsgType msgType;
	private Date createTimeFormat;
	
	public WxMsgType getMsgType() {
		return msgType;
	}
	public void setMsgType(WxMsgType msgType) {
		this.msgType = msgType;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateTimeFormat() {
		return createTimeFormat;
	}
	public void setCreateTimeFormat(Date createTimeFormat) {
		this.createTimeFormat = createTimeFormat;
	}
	public WxText getText() {
		return text;
	}
	public void setText(WxText text) {
		this.text = text;
	}
	public WxVideo getVideo() {
		return video;
	}
	public void setVideo(WxVideo video) {
		this.video = video;
	}
	public WxSound getSound() {
		return sound;
	}
	public void setSound(WxSound sound) {
		this.sound = sound;
	}
	public WxLink getLink() {
		return link;
	}
	public void setLink(WxLink link) {
		this.link = link;
	}
	public WxLocation getLocation() {
		return location;
	}
	public void setLocation(WxLocation location) {
		this.location = location;
	}
	public WxImage getImage() {
		return image;
	}
	public void setImage(WxImage image) {
		this.image = image;
	}

}
