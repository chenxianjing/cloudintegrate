package org.cc.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.cc.mybatis.entity.UserLaud;

public interface UserLaudMapper {

	/**
	 * 根据用户uid获取点赞全部信息
	 * 
	 * @param uid
	 * @return
	 */
	UserLaud getUserLaudAll(@Param("uid") Long uid);

}