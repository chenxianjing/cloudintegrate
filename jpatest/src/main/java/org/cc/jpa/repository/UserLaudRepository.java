package org.cc.jpa.repository;

import org.cc.jpa.entity.UserLaud;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserLaudRepository extends CrudRepository<UserLaud, Long> {

	@Query(value = "SELECT * FROM user_laud", nativeQuery = true)
	UserLaud testSubquery();

	@Modifying
	@Query("UPDATE Person p SET p.name = :name WHERE p.id < :id")
	int updatePersonById(Integer id, String updateName);
}
