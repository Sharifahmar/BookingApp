package com.acc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.ProgressEntity;
/**
 * This is ProgressDAO
 * @author ahmar.akhtar.sharif
 *
 */
@Repository
public interface ProgressDAO extends CrudRepository<ProgressEntity, Integer> {

	/**
	 * This method is used to get list progressentity by status
	 * @param str
	 * @return
	 */
	public List<ProgressEntity> findByActive(String str);
	/**
	 * This method is used to get ProgressID
	 * @param uid
	 * @return
	 */
	
	@Query(name="query10.findProgressByPriorityId")
	public ProgressEntity findProgressByPriorityId(@Param("val1") int uid);
	
}
