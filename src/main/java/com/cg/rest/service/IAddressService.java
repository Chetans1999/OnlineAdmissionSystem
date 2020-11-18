package com.cg.rest.service;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Address;

public interface IAddressService
{
	public Address save(Address address);
	public void delete(Long addressId) throws ResourceNotFoundException;
	public boolean updateAddressById(Address address);
	public Address findById(Long addressId) throws ResourceNotFoundException;	

}
