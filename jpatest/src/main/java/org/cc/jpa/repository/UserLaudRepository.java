package org.cc.jpa.repository;

import org.cc.jpa.entity.UserLaud;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserLaudRepository extends CrudRepository<UserLaud, Long> {

	@Query(value = "SELECT * FROM user_laud", nativeQuery = true)
	UserLaud getUserLaud();

	@Modifying
	@Query("UPDATE UserLaud p SET p.laudId = :laudId WHERE p.nickName < :nickName")
	int updatePersonById(Integer laudId, String nickName);
}
