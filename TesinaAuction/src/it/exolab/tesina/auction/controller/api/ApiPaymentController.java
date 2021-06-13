package it.exolab.tesina.auction.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.Payment;

@CrossOrigin
@Controller
@RequestMapping(value = "api/payment")
public class ApiPaymentController extends BaseController<Payment> {
	

	@RequestMapping(value = "AuctionOrderPayment", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void doAuctionOrderPayment(@RequestBody Payment model, HttpServletResponse httpServletResponse) throws IOException {
		
		System.out.println("nel doAuctionOrderPayment, Payment > " + model);
		String projectUrl = "http://localhost:8080/TesinaMyBank/payment/inserisci";

		Gson gson = new Gson();
		String json = gson.toJson(model);
		URL url = new URL(projectUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);

		
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		connection.setRequestProperty("Accept", "application/json" );
		connection.setRequestProperty("Content-Type", "application/json" + "UTF-8");

	    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

	    writer.write(json);
	    writer.flush();
	    String line;

	    
	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    while ((line = reader.readLine()) != null) {
	      System.out.println(line);
	    }
	    writer.close();
	    reader.close();
		connection.connect();
		
		

		System.out.println("prima del ret > " + connection);

	}
	

	
	

}
