package com.cg.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Address;
import com.cg.rest.repository.IAddressRepository;

@Component
public class IAddressServiceImpl implements IAddressService
{

	@Autowired
	private IAddressRepository adRepo;
	
	public Address save(Address address) {
		return adRepo.save(address);
	}

	public void delete(Long addressId)throws ResourceNotFoundException {
		Address py = adRepo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("No Address Found with this id : " + addressId));
    	adRepo.delete(py);
	}

	public boolean updateAddressById(Address address) {
		return false;
	}

	public Address findById(Long addressId) throws ResourceNotFoundException {
		return (adRepo.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("No Address found with this Address Id :"+ addressId)));

	}
	

}
