package com.flmhospitals.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flmhospitals.model.DoctorSchedule;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {

}
