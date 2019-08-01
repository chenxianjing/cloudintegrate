package org.cc.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.cc.mybatis.entity.UserLaud;

/**
 * 
 * 用户获赞信息
 * 
 * @author chenxianjing
 * @date 2018-2-12 00:38
 * @since 1.0.0
 */
public interface UserLaudMapper {

	/**
	 * 根据用户uid获取点赞全部信息
	 * 
	 * @param uid
	 * @return
	 */
	UserLaud getUserLaudAll(@Param("uid") Long uid);

}