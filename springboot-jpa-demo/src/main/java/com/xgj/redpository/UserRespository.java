package com.xgj.redpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xgj.entity.UserNativeQuery;

public interface UserRespository extends JpaRepository<UserNativeQuery, Integer> {
	
	public List<UserNativeQuery> findByName(String username);
	
	@Query(value="select * from user where name= ?1 or age= ?2",nativeQuery=true)
	public List<UserNativeQuery> findByNameOrAge(String username,int age);
	
}
