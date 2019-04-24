package org.cc.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.cc.jpa.entity.UserLaud;
import org.springframework.stereotype.Repository;

@Repository
public class UserLaudRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 动态条件更新
	 * 
	 * @param userLaud
	 */
	@Transactional
	public void save(UserLaud userLaud) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		// create update
		CriteriaUpdate<UserLaud> update = cb.createCriteriaUpdate(UserLaud.class);
		// set the root class
		Root<UserLaud> a = update.from(UserLaud.class);
		// set update and where clause
		update.set(a.get("dreamId"), 1l);
		// perform update
		update.where(cb.equal(a.get("laudId"), 0l));
		Query q = this.em.createQuery(update);
		q.executeUpdate();
	}

}
