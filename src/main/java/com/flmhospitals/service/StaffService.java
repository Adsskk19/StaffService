package com.flmhospitals.service;


import java.util.List;
import org.springframework.http.ResponseEntity;
import com.flmhospitals.dto.RegisterStaffDto;
import com.flmhospitals.dto.StaffDetailsDto;

public interface StaffService {

	public ResponseEntity<List<StaffDetailsDto>> searchByStaffFirstNameOrLastName(String name);

	StaffDetailsDto registerStaffDeatils(RegisterStaffDto registerStaffDto);

}
