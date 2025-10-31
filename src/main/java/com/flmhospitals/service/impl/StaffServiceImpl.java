package com.flmhospitals.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flmhospitals.builder.StaffDtoBuilder;
import com.flmhospitals.dao.StaffRepository;
import com.flmhospitals.dto.StaffDetailsDto;
import com.flmhospitals.exception.StaffNotFoundException;
import com.flmhospitals.model.Staff;
import com.flmhospitals.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;

	public StaffServiceImpl(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	@Override
	public ResponseEntity<List<StaffDetailsDto>> searchByStaffFirstNameOrLastName(String firstName, String lastName) {

		List<Staff> staffs = staffRepository.findByFirstNameLikeOrLastNameLike("%" + firstName + "%",
				"%" + lastName + "%");

		List<StaffDetailsDto> staffDetailsDtoList = new ArrayList<>();

		if (staffs.isEmpty()) {
			throw new StaffNotFoundException("No staff found with name : " + firstName + " or " + lastName);
		}

		for (Staff staff : staffs) {
			staffDetailsDtoList.add(StaffDtoBuilder.buildStaffDetailsDto(staff));
		}

		return ResponseEntity.ok(staffDetailsDtoList);
	}

}
