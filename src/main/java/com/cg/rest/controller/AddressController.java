package com.cg.rest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Address;
import com.cg.rest.service.IAddressServiceImpl;

@RestController
public class AddressController {
	
	@Autowired
	private IAddressServiceImpl adSer;
	
	@PostMapping("/address/new")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) {
		return ResponseEntity.ok(adSer.save(address));
	}
	
	@GetMapping("/address/getbyaddressid/{id}")
	public ResponseEntity<Address> viewAddressById(@PathVariable(value="id")Long addressId)throws ResourceNotFoundException{
		Address ad=adSer.findById(addressId);
		return ResponseEntity.ok().body(ad);
	}
	
	@DeleteMapping("/address/delete/{addressId}")
	public Map<String, Boolean> deleteById(@PathVariable(value="addressId")Long addressId)throws ResourceNotFoundException{
		adSer.delete(addressId);
		Map<String, Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/address/update/{addressId}")
	public ResponseEntity<Address> updateAddress(@PathVariable(value="addressId")Long addressId, @RequestBody Address addressDetails)throws ResourceNotFoundException{
		Address ad=adSer.findById(addressId);
		
		ad.setCity(addressDetails.getCity());
		ad.setDistrict(addressDetails.getDistrict());
		ad.setState(addressDetails.getState());
		ad.setCountry(addressDetails.getCountry());
		ad.setZipcode(addressDetails.getZipcode());
		ad.setLandmark(addressDetails.getLandmark());
		
		Address updatedAddress =adSer.save(ad);
		return ResponseEntity.ok(updatedAddress);
	}
	
	
}
