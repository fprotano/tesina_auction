package it.exolab.tesina.auction.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.controller.SendEmailController;
import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.StaffService;
import it.exolab.tesina.auction.service.api.UserService;

public class OTP <M, S>{
		
//	String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
	Utils util = new Utils();
	
	
	public boolean checkIfOtpIsNeeded(M model, S service) {
		boolean ret = false;
		
		//if-else per distinguere l'istanza
		if(model instanceof Staff) {
			Staff staff = (Staff) model;
			StaffService staffService = (StaffService) service;
			
			//controllo se richiedere OTP e se devo anche generarlo
			ret = this.checkOTP(staff, staffService);
			return ret;
		}
		
		else if(model instanceof User) {
			User user = (User) model;
			UserService userService = (UserService) service;
			
			//controllo se richiedere OTP e se devo anche generarlo
			ret = this.checkOTP(user, userService);
			return ret;
		}
		
		//ricorda di attivare l'exception exception
		
		return ret;
		
	}
	
	private boolean checkOTP(Staff staff, StaffService service) {
		
		//se OTP è nullo, va direttamente alla sua generazione
//		if(staff.getOtpCode()==null) {
//			createNewOTP(staff, service);
//			return true;
//		}
		
		//controlla se  l'OTP ha una scadenza e se la ha superata
		if( util.beforeDate(staff.getNextOtpCodeAfterDate())) {
			
			//se entra, vuol dire che l'OTP è da chiedere alla login o da generare
			
			
			//controlla se bisogna generare un nuovo OTP
			if(checkGenerateNewOtp(staff.getOtpCodeExpiresAt()))
				createNewOTP(staff, service);
				
			return true;
		}
		
		return false;
	}
	

	private boolean checkOTP(User user, UserService service) {
		//se OTP è nullo, va direttamente alla sua generazione
//				if(user.getOtpCode()==null) {
//					createNewOTP(user, service);
//					return true;
//				}
				
				//controlla se  l'OTP ha una scadenza e se la ha superata
//				else if(user.getNextOtpCodeAfterDate()== null || util.afterDate(user.getNextOtpCodeAfterDate(), now)) {
				if(util.beforeDate(user.getNextOtpCodeAfterDate())) {
			
					//se entra, vuol dire che l'OTP è da chiedere alla login o da generare
					
					
					//controlla se bisogna generare un nuovo OTP
					if(checkGenerateNewOtp(user.getOtpCodeExpiresAt()))
						createNewOTP(user, service);
						
					return true;
				}
				
				return false;
	}
	
	private boolean checkGenerateNewOtp(Timestamp expOTP) {
//		if(expOTP==null || util.afterDate(expOTP, now))
		if(util.beforeDate(expOTP))
			return true;
		
		return false;
	}
	
	public void createNewOTP(Staff staff, StaffService service) {
		staff.setOtpCode(this.util.generateRandomString(10));
		staff.setOtpCodeExpiresAt(this.util.addMinutesToDate(10));
		
		SendEmailController sendEmailController = new SendEmailController();
	 	sendEmailController.sendMail(staff.getEmail(), "exolabcorso2021@gmail.com", "nuovo OTP", "salve, le inviamo il codice otp : \" "+staff.getOtpCode()+" \" necessario per effettuare il login e con scadenza "+staff.getOtpCodeExpiresAt());
		
//	 	service.updateOTP(staff.getId(), staff.getOtpCode(), staff.getOtpCodeExpiresAt());
	 	service.save(staff);
	}
	
	public void createNewOTP(User user, UserService service) {
		user.setOtpCode(this.util.generateRandomString(10));
		user.setOtpCodeExpiresAt(this.util.addMinutesToDate(10));
		
		SendEmailController sendEmailController = new SendEmailController();
	 	sendEmailController.sendMail(user.getEmail(), "exolabcorso2021@gmail.com", "nuovo OTP", "salve, le inviamo il codice otp : \" "+user.getOtpCode()+" \" necessario per effettuare il login e con scadenza "+user.getOtpCodeExpiresAt());
		
//		service.updateOTP(user.getId(), user.getOtpCode(), user.getOtpCodeExpiresAt());
	 	service.save(user);
	}
	
	
	public Staff setNewOtpExp(Staff model, StaffService service) {
		model.setNextOtpCodeAfterDate(util.addDaysToDate(14));
//		service.save(model);
		
		return model;
	}
	
	public void setNewOtpExp(User model, UserService service) {
		model.setNextOtpCodeAfterDate(util.addDaysToDate(14));
//		service.save(model);
	}

}
