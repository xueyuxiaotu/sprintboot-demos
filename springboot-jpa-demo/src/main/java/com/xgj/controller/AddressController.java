package com.xgj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.Address;
import com.xgj.service.AddressService;

@RestController
@RequestMapping(value="/address")
public class AddressController {
 
	@Autowired
	private AddressService addressService;
		
	@PostMapping(value="/save")
	public String save(@RequestBody Address address){
		address.setVersion(0);
		address.setIsValid(1);
		address.setGmtCreate(new Date());
		address.setGmtModified(new Date());
		Address address2 = addressService.save(address);
		System.out.println(address2);
		if(address2!=null) 
			return "success";
		return "fail";
	}
	
	@PostMapping(value="/findAll")
	public Page<Address> findAll(@RequestBody Address address,@PageableDefault Pageable pageable){
		System.out.println(address.toString());
		return addressService.findAll(address,pageable);
	}
}