package com.acc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.AddressEntity;
import com.acc.entity.MeetingEntity;

@Repository
public interface MeetingDAO
    extends CrudRepository<MeetingEntity, Integer> {

    @Query(name = "query2.findAllByUniqueId")
    public AddressEntity findId(@Param("val1") int uid);

    @Query(name = "query3.findAllByUserId")
    public MeetingEntity findMeetingId(@Param("val1") int uid);

    @Query(name = "query8.getMeetingDetailsById")
    public MeetingEntity findByDateId(@Param("val1") int dateId);

}
