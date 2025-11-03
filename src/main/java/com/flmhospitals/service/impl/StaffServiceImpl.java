package com.flmhospitals.service.impl;

import java.util.Optional;

import com.flmhospitals.dao.StaffRepository;
import com.flmhospitals.exception.StaffNotFoundException;
import com.flmhospitals.model.Staff;
import com.flmhospitals.service.StaffService;

public class StaffServiceImpl implements StaffService {
	
	private final StaffRepository staffRepository;

	public StaffServiceImpl(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}
	

	@Override
	public Staff getStaffByStaffId(String staffId) {
		return staffRepository.findById(staffId)
				.orElseThrow(() -> new StaffNotFoundException("Staff with ID :"+ staffId+" not found"));
	}

}
