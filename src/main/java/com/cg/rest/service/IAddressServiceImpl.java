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

	@Override
	public Address save(Address address) {
		return adRepo.save(address);

	}

	@Override
	public void delete(Long addressId) throws ResourceNotFoundException {
		Address add = adRepo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("No Address Found with this id : " + addressId));
    	adRepo.delete(add);
	}

	@Override
	public Address findById(Long addressId) throws ResourceNotFoundException {
		return (adRepo.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("No Address found with this Address Id :"+ addressId)));
	}
	

}
