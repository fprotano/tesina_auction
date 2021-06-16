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
		
	String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
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
		if( util.afterDate(staff.getNextOtpCodeAfterDate(), now)) {
			
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
				if(util.afterDate(user.getNextOtpCodeAfterDate(), now)) {
			
					//se entra, vuol dire che l'OTP è da chiedere alla login o da generare
					
					
					//controlla se bisogna generare un nuovo OTP
					if(checkGenerateNewOtp(user.getOtpCodeExpiresAt()))
						createNewOTP(user, service);
						
					return true;
				}
				
				return false;
	}
	
	private boolean checkGenerateNewOtp(Timestamp expOTP) {
		if(expOTP==null || util.afterDate(expOTP, now))
			return true;
		
		return false;
	}
	
	public void createNewOTP(Staff staff, StaffService service) {
		staff.setOtpCode(this.util.generateRandomString(10));
		staff.setOtpCodeExpiresAt(this.util.addMinutesToDate(now, 10));
		
		SendEmailController sendEmailController = new SendEmailController();
	 	sendEmailController.sendMail(staff.getEmail(), "exolabcorso2021@gmail.com", "nuovo OTP", "salve, le inviamo il codice otp : \" "+staff.getOtpCode()+" \" necessario per effettuare il login e con scadenza "+staff.getOtpCodeExpiresAt());
		
//	 	service.updateOTP(staff.getId(), staff.getOtpCode(), staff.getOtpCodeExpiresAt());
	 	service.save(staff);
	}
	
	public void createNewOTP(User user, UserService service) {
		user.setOtpCode(this.util.generateRandomString(10));
		user.setOtpCodeExpiresAt(this.util.addMinutesToDate(now, 10));
		
		SendEmailController sendEmailController = new SendEmailController();
	 	sendEmailController.sendMail(user.getEmail(), "exolabcorso2021@gmail.com", "nuovo OTP", "salve, le inviamo il codice otp : \" "+user.getOtpCode()+" \" necessario per effettuare il login e con scadenza "+user.getOtpCodeExpiresAt());
		
//		service.updateOTP(user.getId(), user.getOtpCode(), user.getOtpCodeExpiresAt());
	 	service.save(user);
	}
//	
//	private boolean afterDate(Timestamp date, String now) {
//		if(date == null || date.after(Timestamp.valueOf(now)))
//			return true;
//			
//			return false;
//	}
//	
//	private Timestamp addMinutesToDate(String baseDate, int minutes) {
//		Timestamp ret= Timestamp.valueOf(baseDate);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(ret);
//		cal.add(Calendar.MINUTE, minutes);
//		ret.setTime(cal.getTime().getTime());
////		ret = new Timestamp(cal.getTime().getTime());
//		
//		return ret;
//	}
//	
//	private Timestamp addDaysToDate(String baseDate, int days) {
//		Timestamp ret= Timestamp.valueOf(baseDate);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(ret);
//		cal.add(Calendar.DAY_OF_WEEK, days);
//		ret.setTime(cal.getTime().getTime());
////		ret = new Timestamp(cal.getTime().getTime());
//		
//		return ret;
//	}
//	
//	public String generateRandomString(int len) {
//		
//		int length = len;
//	    boolean useLetters = true;
//	    boolean useNumbers = true;
//	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);	    
//	    
//	    return generatedString;
//	}
	
	

	
	/*
	 * if(staff.getOtpCode() == null || staff.getNextOtpCodeAfterDate()== null || this.afterDate(staff.getNextOtpCodeAfterDate(), now)) {
			if(staff.getOtpCodeExpiresAt()== null || this.afterDate(staff.getOtpCodeExpiresAt(), now)) {
//				staff.setOtpCode(String.valueOf((Math.random() * (9999 - 1)) + 1));
				staff.setOtpCode(this.generateRandomString());
				staff.setOtpCodeExpiresAt(addMinutesToDate(now, 10));
				
				StaffService staffService = (StaffService) service;
				try {
//					GoogleMail.Send("exolabCorso2021", "e2021!tesina",staff.getEmail() , "nuovo OTP", "salve! Le inviamo il nuovo codice OTP : "+staff.getOtpCode());
					GoogleMail gm = new GoogleMail();
					gm.sendMail(staff.getEmail(), "nuovo codice otp", "salve, le inviamo il nuovo codice otp : ' "+staff.getOtpCode()+" ' con scadenza il "+staff.getOtpCodeExpiresAt());

					staffService.updateOTP(staff.getId(), staff.getOtpCode(), 
												staff.getOtpCodeExpiresAt());
				} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
	 */
	
	public Staff setNewOtpExp(Staff model, StaffService service) {
		model.setNextOtpCodeAfterDate(util.addDaysToDate(now, 14));
//		service.save(model);
		
		return model;
	}
	
	public void setNewOtpExp(User model, UserService service) {
		model.setNextOtpCodeAfterDate(util.addDaysToDate(now, 14));
//		service.save(model);
	}

}
