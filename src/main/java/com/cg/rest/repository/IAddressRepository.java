package com.cg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long>{

}
