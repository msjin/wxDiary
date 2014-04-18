package com.bean;

import java.util.Date;

import com.bean.weixin.WxUser;

public class User extends WxUser{

	private String id;
	private String pass;
	private Date createTime;
	private ActiveStatus activeStatus;
	private String ip;
	private Date loginTime;
	private int loginNum;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ActiveStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public int getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", createTime="
				+ createTime + ", activeStatus=" + activeStatus + ", ip=" + ip
				+ ", loginTime=" + loginTime + ", loginNum=" + loginNum
				+ ", getSubscribe()=" + getSubscribe() + ", getOpenid()="
				+ getOpenid() + ", getNickname()=" + getNickname()
				+ ", getSex()=" + getSex() + ", getCity()=" + getCity()
				+ ", getCountry()=" + getCountry() + ", getProvince()="
				+ getProvince() + ", getLanguage()=" + getLanguage()
				+ ", getHeadimgurl()=" + getHeadimgurl()
				+ ", getSubscribe_time()=" + getSubscribe_time()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}



	public enum ActiveStatus{
		y,
		n,
	}
	
	public enum sex {
	    M("男"), // 男
	    F("女"), // 女
	    BOTH(""), // 都是，有的地方男女都适用时，使用该选项
	    DEFALT("");// 不希望选择，而是适用默认值时，使用该选项

	    private String desc;

	    sex(String desc) {
	        this.desc = desc;
	    }

	    @Override
	    public String toString() {
	        return this.name();
	    }

	    public String getDesc() {
	        return desc;
	    }
	}
}
