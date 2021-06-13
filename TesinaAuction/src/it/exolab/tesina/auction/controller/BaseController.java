package it.exolab.tesina.auction.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
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
	private String url = "http://localhost:8080/TesinaMyBank/payment/inserisci";
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
	
	protected void sendPost(String data) throws IOException {
		URL obj = new URL(this.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(data.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			
		
		}
	}
	
	
}
	

