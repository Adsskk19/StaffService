package com.flmhospitals.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flmhospitals.model.DoctorSchedule;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {

	List<DoctorSchedule> findByStaff_StaffId(String staffId);

}
