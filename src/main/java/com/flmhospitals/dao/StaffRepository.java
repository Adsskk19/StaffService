package com.flmhospitals.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flmhospitals.model.Staff;

public interface StaffRepository extends JpaRepository<Staff,String>{
	
	@Query(value="SELECT staff_id from staff ORDER BY DESC Limit 1",nativeQuery=true)
	String findLastStaffId();

}
