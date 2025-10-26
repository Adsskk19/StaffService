package com.flmhospitals.model.utility;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.flmhospitals.repository.StaffRepository;

@Component
public class StaffIdGenerator {

   
    private final StaffRepository staffRepository;
       
    public StaffIdGenerator(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}



	public  String generateNextStaffId() {
        String lastId = staffRepository.findLastStaffId();
        int nextNumber = 1;

        if (lastId != null && lastId.startsWith("FLM-")) {
            String numberPart = lastId.substring(4);
            nextNumber = Integer.parseInt(numberPart) + 1;
        }

        return String.format("FLM-%05d", nextNumber);
    }
}
