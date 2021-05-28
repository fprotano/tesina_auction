package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.repository.StaffRepo;


public class StaffService {
	
	private StaffRepo staffRepo;
	
	@Autowired(required = true)
	public void setStaffRepo(StaffRepo staffRepo) {
		this.staffRepo = staffRepo;
	}
	
	public Staff find(int id) {
		return staffRepo.findOne(id);
	}

	public List<Staff> findAll() {
		return (List<Staff>) staffRepo.findAll();
	}

	public void save(Staff model) {
		this.staffRepo.save(model);
	}

	public void delete(int id) {
		staffRepo.delete(id);
	}
}
