package com.acc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.ProgressEntity;

@Repository
public interface ProgressDAO extends CrudRepository<ProgressEntity, Integer> {

	public List<ProgressEntity> findByActive(String str);
	
	@Query(name="query10.findProgressByPriorityId")
	public ProgressEntity findProgressByPriorityId(@Param("val1") int uid);
	
}
