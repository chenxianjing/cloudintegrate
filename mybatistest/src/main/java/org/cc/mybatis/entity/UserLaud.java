package org.cc.mybatis.entity;

import java.io.Serializable;

/**
 * 
 * 用户获赞信息
 * 
 * @author chenxianjing
 * @date 2018-2-12 00:38
 * @since 1.0.0
 */
public class UserLaud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7029741015360469261L;

	private Long laudId;

	/**
	 * 用户id
	 */
	private Long uid;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 头像
	 */
	private String headPortrait;

	/**
	 * 收货点赞数量
	 */
	private Integer laudAmount;

	/**
	 * 客资id
	 */
	private Long dreamId;

	/**
	 * 许愿目的地
	 */
	private String destination;

	/**
	 * 版本号
	 */
	private Integer version;

	public Long getLaudId() {
		return laudId;
	}

	public void setLaudId(Long laudId) {
		this.laudId = laudId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Integer getLaudAmount() {
		return laudAmount;
	}

	public void setLaudAmount(Integer laudAmount) {
		this.laudAmount = laudAmount;
	}

	public Long getDreamId() {
		return dreamId;
	}

	public void setDreamId(Long dreamId) {
		this.dreamId = dreamId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}