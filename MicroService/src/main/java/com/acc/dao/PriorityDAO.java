package com.acc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.PriorityEntity;
/**
 * 
 * @author ahmar.akhtar.sharif
 * This is PriorityDAO
 *
 */
@Repository
public interface PriorityDAO extends CrudRepository<PriorityEntity, Integer> {
	/**
	 * This method is used to find progress Id
	 * 
	 * @param uid
	 * @return
	 */
	public PriorityEntity findByPid(int uid);

	/**
	 * This method is used to find status of progress
	 * 
	 * @param id
	 * @return
	 */

	@Query(name = "query12.findByStatus")
	public PriorityEntity findByStatus(@Param("val2") int id);

	/**
	 * This method is used to get priorityID
	 * 
	 * @param empId
	 * @return
	 */
	@Query(name = "query12.getPriorityById")
	public PriorityEntity findPriorityByEmpId(@Param("val1") int empId);
}
