package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.StaffDTO;

import it.exolab.tesina.auction.repository.StaffRepo;


public class StaffService {
	
	private StaffRepo staffRepo;
	
	@Autowired(required = true)
	public void setStaffRepo(StaffRepo staffRepo) {
		this.staffRepo = staffRepo;
	}
	
	public StaffDTO find(int id) {
		return staffRepo.findOne(id);
	}

	public List<StaffDTO> findAll() {
		return (List<StaffDTO>) staffRepo.findAll();
	}

	public void save(StaffDTO model) {
		this.staffRepo.save(model);
	}

	public void delete(int id) {
		staffRepo.delete(id);
	}
	
}
