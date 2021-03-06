package com.xgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.UserNativeQuery;
import com.xgj.redpository.UserRespository;
import com.xgj.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public List<UserNativeQuery> getUserList(){
		return userRespository.findAll();
	}
	@GetMapping("/query")
	public List<UserNativeQuery> getUserByCondition(@RequestParam String name,int age){
		return userService.findByNameOrAge(name, age);
	}
	
	@GetMapping("/list/detail")
	public Object getUserListDetail(@RequestParam long id){
		return userService.getUserWithAddrByid(id);
	}
	
	@GetMapping("/list/detail2")
	public UserNativeQuery getUserListDetail2(@RequestParam int id) {
		return userRespository.getUserWithAddrByid(id);
	}
	
}
