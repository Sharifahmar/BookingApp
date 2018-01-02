package com.acc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.AddressEntity;

@Repository
public interface AddressDAO
    extends CrudRepository<AddressEntity, Integer> {

    @Query(name = "query1.findAllByUniqueId")
    public AddressEntity findId(@Param("val1") int uid);

    @Query(name = "query6.findAllByUserId")
    public AddressEntity findAddressbyUserId(@Param("val2") int id);

    @Query(name = "query9.getAddressDetailsById")
    public AddressEntity findByAddressId(@Param("val1") int addressId);

    public List<AddressEntity> findByStat(String str);
}
