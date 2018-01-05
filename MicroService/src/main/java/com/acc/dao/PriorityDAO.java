package com.acc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.PriorityEntity;

@Repository
public interface PriorityDAO extends CrudRepository<PriorityEntity, Integer> {

	public PriorityEntity findByPid(int uid);

	@Query(name = "query12.findByStatus")
	public PriorityEntity findByStatus(@Param("val2") int id);
	
	@Query(name = "query12.getPriorityById")
    public PriorityEntity findPriorityByEmpId(@Param("val1") int empId);
}
