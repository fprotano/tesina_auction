package it.exolab.tesina.auction.model;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SuperModel {
	
	public SuperModel() {
	
	}
	
	protected Object conversionTimeRetobj(Object a) { // metodo conversione data-format return obj
		Field[] fields = a.getClass().getDeclaredFields();
		Object convert = null;
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getType().getTypeName().contains("Timestamp")); //
			if (fields[i].getType().getTypeName().contains("Timestamp")) {

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fields[i].get(a).toString());
					System.out.println(date);
					fields[i].set(date, "DateForClient"+i); //importante 
					convert = fields;
					

				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	  return convert;

	}

}
