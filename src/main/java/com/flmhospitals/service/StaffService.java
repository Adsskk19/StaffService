package com.flmhospitals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flmhospitals.dao.StaffRepository;
import com.flmhospitals.model.Staff;

@Service
public interface StaffService {
	
	Staff getStaffByStaffId(String staffId);
}
