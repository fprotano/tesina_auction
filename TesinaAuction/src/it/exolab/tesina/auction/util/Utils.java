package it.exolab.tesina.auction.util;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils{
	

	
	public boolean afterDate(Timestamp date, String now) {
		if(date == null || date.after(Timestamp.valueOf(now)))
			return true;
			
			return false;
	}
	
	public boolean afterDate(Timestamp date) {
		
		return this.afterDate(date, new Timestamp(System.currentTimeMillis()));
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
	
	public boolean beforeDate(Timestamp date, String now) {
		if(date == null || date.before(Timestamp.valueOf(now)))
			return true;
			
			return false;
	}
	
	public boolean beforeDate(Timestamp date) {
		
		return this.beforeDate(date, new Timestamp(System.currentTimeMillis()));
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
		Timestamp ret= Timestamp.valueOf(baseDate);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ret);
		cal.add(Calendar.MINUTE, minutes);
		ret.setTime(cal.getTime().getTime());
//		ret = new Timestamp(cal.getTime().getTime());
		
		return ret;
	}
	
	public Timestamp addDaysToDate(String baseDate, int days) {
		Timestamp ret= Timestamp.valueOf(baseDate);
		
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
	
	
	


}
