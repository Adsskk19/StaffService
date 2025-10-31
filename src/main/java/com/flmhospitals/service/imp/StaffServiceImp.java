package com.flmhospitals.service.imp;

import org.springframework.stereotype.Service;

import com.flmhospitals.builder.StaffBuilder;
import com.flmhospitals.builder.StaffDtoBuilder;
import com.flmhospitals.dao.StaffRepository;
import com.flmhospitals.dto.RegisterStaffDto;
import com.flmhospitals.dto.StaffDetailsDto;
import com.flmhospitals.enums.StaffType;
import com.flmhospitals.model.Staff;
import com.flmhospitals.service.StaffService;
import com.flmhospitals.utils.StaffIdGenerator;

@Service
public class StaffServiceImp implements StaffService {
	
	private final StaffRepository staffRepository;
	private final StaffIdGenerator staffIdGenerator;

	public StaffServiceImp(StaffRepository staffRepository, StaffIdGenerator staffIdGenerator) {
		this.staffRepository = staffRepository;
		this.staffIdGenerator = staffIdGenerator;
	}
	

	@Override
	public StaffDetailsDto registerStaffDeatils(RegisterStaffDto registerStaffDto) {
		// TODO Auto-generated method stub
		
		Staff staff =  StaffBuilder.buildStaffFromRegisterStaffDto(registerStaffDto);
//		System.out.println("staff = "+staff+" registerStaffDto.getStaffType = "+registerStaffDto.getStaffType());
//		System.out.println("flag check = "+registerStaffDto.getStaffType().equals("DOCTOR"));
		boolean roleFlag = registerStaffDto.getStaffType().equals(StaffType.DOCTOR);//
		if (roleFlag) {
			staff.setRole("Admin");
			staff.setCanLogin(true);
		}
		else {
			staff.setRole("Non-Admin");
		}
		staff.setEmployeeActive(true);
		
		 Staff registerdStaff =  staffRepository.save(staff);
		 
		return StaffDtoBuilder.buildStaffDetailsDto(registerdStaff);
	}
	

}
