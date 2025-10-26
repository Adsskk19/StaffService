package com.flmhospitals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flmhospitals.model.Staff;

public interface StaffRepository extends JpaRepository<Staff,String>{
	
    @Query(value = "SELECT staff_id FROM staff ORDER BY staff_id DESC LIMIT 1", nativeQuery = true)
	String findLastStaffId();

}
