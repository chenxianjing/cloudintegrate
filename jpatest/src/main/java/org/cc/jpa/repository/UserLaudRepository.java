package org.cc.jpa.repository;

import org.cc.jpa.entity.UserLaud;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserLaudRepository extends CrudRepository<UserLaud, Long> {

	/**
	 * 查询，使用sql
	 * 
	 * @return
	 */
	@Query(value = "SELECT * FROM user_laud", nativeQuery = true)
	UserLaud getUserLaud();

	/**
	 * 修改
	 * 
	 * @param laudId
	 * @param nickName
	 * @return
	 */
	@Modifying
	@Query("UPDATE UserLaud p SET p.laudId = :laudId WHERE p.nickName < :nickName")
	int updatePersonById(Integer laudId, String nickName);

	@Query("select p from UserLaud p where p.laudId = :laudId AND p.uid = 1234")
	UserLaud getUserLaudByUid(@Param("laudId") Long laudId);

	UserLaud save(UserLaud userLaud);
}
