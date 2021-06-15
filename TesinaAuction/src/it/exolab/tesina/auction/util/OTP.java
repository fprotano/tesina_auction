package it.exolab.tesina.auction.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.mail.MessagingException;

import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.StaffService;
import it.exolab.tesina.auction.service.api.UserService;

public class OTP <T, S>{
	
	public ModelAndView checkNewOtp(T model,S service, ModelAndView modelAndView) {
		String now = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().getTime());
		ModelAndView ret = modelAndView;
		
		if(model instanceof Staff) {
			Staff staff = (Staff) model;
			
			if(staff.getOtpCode() == null || staff.getNextOtpCodeAfterDate()== null || this.afterDate(staff.getNextOtpCodeAfterDate(), now)) {
				if(this.afterDate(staff.getOtpCodeExpiresAt(), now)) {
					staff.setOtpCode(String.valueOf((Math.random() * (9999 - 1)) + 1));
					staff.setOtpCodeExpiresAt(addMinutesToDate(now, 10));
					
					StaffService staffService = (StaffService) service;
					staffService.updateOTP(staff.getId(), staff.getOtpCode(), 
												staff.getOtpCodeExpiresAt());
					try {
						GoogleMail.Send("exolabCorso2021", "e2021!tesina",staff.getEmail() , "nuovo OTP", "salve! Le inviamo il nuovo codice OTP : "+staff.getOtpCode());
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ret= new ModelAndView("home");
				ret.addObject("userOTP", staff);
				ret.addObject("action", "askOTP");
				return ret;
			}
			
		}
		else if(model instanceof User) {
			User user = (User) model;
			
			if(user.getOtpCode() == null || user.getNextOtpCodeAfterDate()== null || this.afterDate(user.getNextOtpCodeAfterDate(), now)) {
				if(this.afterDate(user.getOtpCodeExpiresAt(), now)) {
					user.setOtpCode(String.valueOf((Math.random() * (9999 - 1)) + 1));
					user.setOtpCodeExpiresAt(addMinutesToDate(now, 10));
					
					UserService userService = (UserService) service;
					userService.updateOTP(user.getId(), user.getOtpCode(), 
												user.getOtpCodeExpiresAt());
					try {
						GoogleMail.Send("exolabCorso2021", "e2021!tesina",user.getEmail() , "nuovo OTP", "salve! Le inviamo il nuovo codice OTP, con scadenza "+user.getOtpCodeExpiresAt()+" da inserire al prossimo login : "+user.getOtpCode());
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ret= new ModelAndView("home");
				ret.addObject("userOTP", user);
				ret.addObject("action", "askOTP");
				return ret;
			}
			
			
		}

		return ret;
		
	}
	
	private boolean afterDate(Timestamp date, String now) {
		
		if( date.after(Timestamp.valueOf(now)))
			return true;
			
			return false;
		
	}
	
	private Timestamp addMinutesToDate(String baseDate, int minutes) {
		Timestamp ret= Timestamp.valueOf(baseDate);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ret);
		cal.add(Calendar.MINUTE, minutes);
		ret.setTime(cal.getTime().getTime());
//		ret = new Timestamp(cal.getTime().getTime());
		
		return ret;
	}
	
	private Timestamp addDaysToDate(String baseDate, int days) {
		Timestamp ret= Timestamp.valueOf(baseDate);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ret);
		cal.add(Calendar.DAY_OF_WEEK, days);
		ret.setTime(cal.getTime().getTime());
//		ret = new Timestamp(cal.getTime().getTime());
		
		return ret;
	}

}
