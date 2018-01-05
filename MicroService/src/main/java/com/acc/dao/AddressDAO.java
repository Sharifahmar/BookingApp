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
	
	 /**
     * This method is used to get the address details by uniqueid
     * @param uid
     * @return
     */
	
    @Query(name = "query1.findAllByUniqueId")
    public AddressEntity findId(@Param("val1") int uid);
    
    /**
     * This method is used to get the address details by userid
     * @param id
     * @return
     */
    @Query(name = "query6.findAllByUserId")
    public AddressEntity findAddressbyUserId(@Param("val2") int id);
   
    /**
     * This method is used to get the address details by addressid
     * @param addressId
     * @return
     */

    @Query(name = "query9.getAddressDetailsById")
    public AddressEntity findByAddressId(@Param("val1") int addressId);
    
    /**
     * This method is used to get the address details by status
     * @param addressId
     *
     */

    public List<AddressEntity> findByStat(String str);
}
