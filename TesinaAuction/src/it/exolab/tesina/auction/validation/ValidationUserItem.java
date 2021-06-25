package it.exolab.tesina.auction.validation;

import java.time.LocalDateTime;

import it.exolab.tesina.auction.model.UserItem;

public class ValidationUserItem {
	
	
	public static boolean validationItem (UserItem userItem) {
		boolean flag=true;
		if(userItem.getPicture1()==null&&userItem.getPicture2()==null&&userItem.getPicture3()==null&&userItem.getPicture4()==null&&userItem.getPicture5()==null) {
			flag=false;
		}
		if(userItem.getCreatedAt().toLocalDateTime().isBefore(LocalDateTime.now())) {
			flag=false;
		}
		if(userItem.getTitle()==null || userItem.getTitle().equals("")) {
			flag=false;
		}
		if(userItem.getDescription().length()<1) {
			flag=false;
		}
		if(userItem.getNotes().length()<1) {
			flag=false;
		}
		
		
		return flag;
		
	}
	
	

}
