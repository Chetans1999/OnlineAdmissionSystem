package com.cg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.rest.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
