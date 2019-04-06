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
import javax.persistence.Table;

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
@Getter
@Setter
@Entity
@Table(name = "user_laud")
public class UserLaud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -812230085268168414L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "laud_id")
	private Long laudId;

	/**
	 * 用户id
	 */
	@Column(name = "uid")
	private Long uid;

	/**
	 * 昵称
	 */
	@Column(name = "nick_name")
	private String nickName;

	/**
	 * 头像
	 */
	@Column(name = "head_portait")
	private String headPortrait;

	/**
	 * 收货点赞数量
	 */
	@Column(name = "laud_amount")
	private Integer laudAmount;

	/**
	 * 客资id
	 */
	@Column(name = "dream_id")
	private Long dreamId;

	/**
	 * 许愿目的地
	 */
	@Column(name = "destination")
	private String destination;

	/**
	 * 版本号
	 */
	@Column(name = "version")
	private Integer version;

}