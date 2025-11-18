package com.flmhospitals.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flmhospitals.dao.DoctorScheduleRepository;
import com.flmhospitals.model.DoctorSchedule;
import com.flmhospitals.service.DoctorScheduleService;
import com.flmhospitals.service.StaffService;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

	private final DoctorScheduleRepository doctorScheduleRepository;

	public DoctorScheduleServiceImpl(DoctorScheduleRepository doctorScheduleRepository) {
		this.doctorScheduleRepository = doctorScheduleRepository;
	}

	@Override
	 public ResponseEntity<String> markDoctorAvailable(String staffId, List<LocalDate> dates) {
	  
	  List<DoctorSchedule> unavailableList = doctorScheduleRepository.findByStaff_StaffIdAndUnavailableDateIn(staffId,dates);

	  if (unavailableList.isEmpty()) {
	   return ResponseEntity.ok("Doctor is already available on all selected dates.");
	  }

	  doctorScheduleRepository.deleteAll(unavailableList);

	  return ResponseEntity.ok("Doctor marked available on selected dates successfully.");
	 }



}
