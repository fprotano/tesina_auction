package it.exolab.tesina.auction.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.exolab.tesina.auction.api.model.HttpResponse;


public class BaseController<T> {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	public static final String ERR_001 = "001";//
	public static final String ERR_002 = "002";
	protected Gson gson = new Gson();
	
	protected HttpResponse sendSuccess(Object data) {
		return new HttpResponse(data);
		
	}
	
	protected HttpResponse sendErr(String err,String err_code) {
		return new HttpResponse(err,err_code);
		
	}
	
	public T makeFromRequest(HttpServletRequest request, Class<T> arg) {
		T ret=null;

			try {
				String line = "";
				 StringBuffer jb = new StringBuffer();
				BufferedReader reader = request.getReader();
				 while ((line = reader.readLine()) != null) {
					 jb.append(line);
				 }
				 System.out.println(jb);
				 ret = new Gson().fromJson(jb.toString(), arg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;	
	}
	
	public Object conversionTimeRetobj(Object a) { // metodo conversione data-format return obj
		Field[] fields = a.getClass().getDeclaredFields();
		Object convert = null;
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getType().getTypeName().contains("Timestamp")); //
			if (fields[i].getType().getTypeName().contains("Timestamp")) {

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fields[i].get(a).toString());
					System.out.println(date);
					fields[i].set(date, "DateForClient"+i);
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
	

