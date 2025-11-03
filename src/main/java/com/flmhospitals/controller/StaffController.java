package com.flmhospitals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.model.Staff;
import com.flmhospitals.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	private final StaffService staffService;

	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@GetMapping("/{staffId}")
	public Staff getStaffByStaffId(@PathVariable String staffId) {
		return staffService.getStaffByStaffId(staffId);
	}

}
