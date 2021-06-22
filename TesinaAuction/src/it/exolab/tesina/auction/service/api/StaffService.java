package it.exolab.tesina.auction.service.api;

import java.sql.Timestamp;
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
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		this.staffRepo.save(model);
	}

	public void delete(int id) {
		staffRepo.delete(id);
	}
	public Staff findByEmailAndPassword(String email,String pass) {
		return staffRepo.findByEmailAndPassword(email, pass);
	}
	public Staff  FindBySurname(String surname) {
		return staffRepo.findBySurname(surname);
	}
	public List<Staff> findByRoleTitle(String role){
		return staffRepo.findByRoleTitle(role);
	}
	
	public void updateOTP(Integer id, String otp, Timestamp otpExpiresAt) {
		this.staffRepo.updateOTP(id, otp, otpExpiresAt);
		
	}
	
	public Staff findByEmailAndPasswordAndOtpCode(String email, String password, String otp) {
		return this.staffRepo.findByEmailAndPasswordAndOtpCode(email,  password,  otp);
		
	}
	
	public Staff findHelpDeskWithLessWork() {
		return this.findHelpDeskWithLessWork();
	}
}
