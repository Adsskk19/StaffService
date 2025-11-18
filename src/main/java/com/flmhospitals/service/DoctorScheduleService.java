package com.flmhospitals.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

public interface DoctorScheduleService {

	public ResponseEntity<String> isDoctorAvailable(String staffId, LocalDate date);
}
