package com.flmhospitals.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.flmhospitals.dao.DoctorScheduleRepository;
import com.flmhospitals.model.DoctorSchedule;
import com.flmhospitals.model.Staff;
import com.flmhospitals.service.DoctorScheduleService;
import com.flmhospitals.service.StaffService;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

	private final DoctorScheduleRepository doctorScheduleRepository;
	private final StaffService staffService;

	public DoctorScheduleServiceImpl(DoctorScheduleRepository doctorScheduleRepository, StaffService staffService) {
		this.doctorScheduleRepository = doctorScheduleRepository;
		this.staffService = staffService;
	}

	@Override
	public ResponseEntity<String> markDoctorAvailable(String staffId, List<LocalDate> dates) {

		LocalDate today = LocalDate.now();
		for(LocalDate date : dates) {
			if(date.isBefore(today)) {
				return ResponseEntity.ok("Date "+date+" is earlier than current date, please provide the valid date");
			}
		}
		
		List<DoctorSchedule> unavailableDoctorslList = doctorScheduleRepository.findByStaff_StaffId(staffId);
		List<DoctorSchedule> unavailableList = new ArrayList<>(); 
		if (!unavailableDoctorslList.isEmpty()) {
			for (DoctorSchedule list : unavailableDoctorslList) {
				if (dates.contains(list.getUnavailableDate()))
					unavailableList.add(list);
			}
		} else {
			return ResponseEntity.ok("Invalid StaffId");
		}

		if (unavailableList.isEmpty()) {
			return ResponseEntity.ok("Doctor is already available on all selected dates.");
		}

		doctorScheduleRepository.deleteAll(unavailableList);

		return ResponseEntity.ok("Doctor marked available on selected dates successfully.");
	}

	@Override
	public boolean isDoctorAvailable(String staffId, LocalDate date) {
		Staff staff = staffService.getStaffByStaffId(staffId);
		boolean isAvailable = !doctorScheduleRepository.existsByStaff_StaffIdAndUnavailableDate(staffId, date);
		return isAvailable;
	}

}
