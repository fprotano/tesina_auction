package it.exolab.tesina.auction.util;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;

import it.exolab.tesina.auction.service.api.InvoiceService;

public class Utils{
	

	
	public boolean afterDate(Timestamp baseDate, String dateToCmopare) {
		return this.afterDate(baseDate, Timestamp.valueOf(dateToCmopare));
	}
	
	public boolean afterDate(Timestamp baseDate) {
		
		return this.afterDate(baseDate, new Timestamp(System.currentTimeMillis()));
	}
	
	public boolean afterDate(Timestamp baseDate, Timestamp dateToCompare) {
		
		if(dateToCompare == null) {
			// lancia exception
			return false;
		}
		
		else if(baseDate == null || baseDate.after(dateToCompare))
			return true;
			
			return false;
	}
	
	public boolean beforeDate(Timestamp baseDate, String dateToCompare) {
		return this.beforeDate(baseDate, Timestamp.valueOf(dateToCompare));
	}
	
	public boolean beforeDate(Timestamp baseDate) {
		
		return this.beforeDate(baseDate, new Timestamp(System.currentTimeMillis()));
	}
	
	public boolean beforeDate(Timestamp baseDate, Timestamp dateToCompare) {
		
		if(dateToCompare == null) {
			// lancia exception
			return false;
		}
		
		else if(baseDate == null || baseDate.before(dateToCompare))
			return true;
			
			return false;
	}
	
	public Timestamp addMinutesToDate(String baseDate, int minutes) {
		return this.addMinutesToDate(Timestamp.valueOf(baseDate), minutes);
	}	
	
	public Timestamp addMinutesToDate(int minutes) {
		return this.addMinutesToDate(new Timestamp(System.currentTimeMillis()), minutes);
		
	}
	
	public Timestamp addMinutesToDate(Timestamp baseDate, int minutes) {
		Timestamp ret= baseDate;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ret);
		cal.add(Calendar.MINUTE, minutes);
		ret.setTime(cal.getTime().getTime());
//		ret = new Timestamp(cal.getTime().getTime());
		
		return ret;
	}
	
	public Timestamp addDaysToDate(String baseDate, int days) {
		return this.addDaysToDate(Timestamp.valueOf(baseDate), days);
	}
	
	public Timestamp addDaysToDate(int days) {
		return this.addDaysToDate(new Timestamp(System.currentTimeMillis()), days);
	}
	
	public Timestamp addDaysToDate(Timestamp baseDate, int days) {
		Timestamp ret= baseDate;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ret);
		cal.add(Calendar.DAY_OF_WEEK, days);
		ret.setTime(cal.getTime().getTime());
//		ret = new Timestamp(cal.getTime().getTime());
		
		return ret;
	}
	
	public String generateRandomString(int len) {
		
		int length = len;
	    boolean useLetters = true;
	    boolean useNumbers = true;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);	    
	    
	    return generatedString;
	}
	
	
	public static Timestamp getNow() {
		return new Timestamp(System.currentTimeMillis());
	}
	


}
