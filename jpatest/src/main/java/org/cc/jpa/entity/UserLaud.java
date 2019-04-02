/*
 * Copyright (c) 2018, Jiehun.com.cn Inc. All Rights Reserved
 */
package org.cc.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 用户获赞信息
 * 
 * @author chenxianjing
 * @date 2018-2-12 00:38
 * @since 1.0.0
 */
@Entity
@Getter
@Setter
public class UserLaud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -812230085268168414L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long laudId;

	/**
	 * 用户id
	 */
	@Column
	private Long uid;

	/**
	 * 昵称
	 */
	@Column
	private String nickName;

	/**
	 * 头像
	 */
	@Column
	private String headPortrait;

	/**
	 * 收货点赞数量
	 */
	@Column
	private Integer laudAmount;

	/**
	 * 客资id
	 */
	@Column
	private Long dreamId;

	/**
	 * 许愿目的地
	 */
	@Column
	private String destination;

	/**
	 * 版本号
	 */
	@Column
	private Integer version;

}