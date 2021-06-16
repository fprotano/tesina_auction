package it.exolab.tesina.auction.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.Payment;
import it.exolab.tesina.auction.service.api.AuctionOrderService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/payment")
public class ApiPaymentController extends BaseController<Payment> {
	
	
	private AuctionOrderService  auctionOrderService;
	
	@Autowired(required = true)
	public void setAuctionOrderService(AuctionOrderService  auctionOrderService) {
		this.auctionOrderService = auctionOrderService;
	}
	
	@RequestMapping(value = "paymentNotify", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public void doPaymentNotify(@ModelAttribute Payment payment) {
		
		System.out.println("nel payment notify > " + payment);
		//String numOrder = payment.getCustomCode().substring(17);
		AuctionOrder auctionOrder = auctionOrderService.findByOrderNo(payment.getCustomCode());
		auctionOrder.setTransactionId(payment.getTransactionId());
		auctionOrder.setAuctionOrderStatusId(3);
		auctionOrderService.save(auctionOrder);
		System.out.println("nel payment notify > " + auctionOrder);
	}
	
	
//	@RequestMapping(value = "paymentNotify", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
//	@ResponseBody
//	public void doPaymentNotify(@ModelAttribute OotlBank ootlBank) {
//		
//		AuctionOrderTransactionLog aotl = new AuctionOrderTransactionLog();
//		Field[] fields = aotl.getClass().getDeclaredFields();
//		System.out.println(fields);
//		for(int i=0; i<ootlBank.getPn().length; i++) {
//			//if() comparazione nome con parameter
//			
//		}
//	}
//	

//	@RequestMapping(value = "AuctionOrderPayment", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
//	@ResponseBody
//	public void doAuctionOrderPayment(@RequestBody Payment model, HttpServletResponse httpServletResponse) throws IOException {
//		
//		System.out.println("nel doAuctionOrderPayment, Payment > " + model);
//		String projectUrl = "http://localhost:8080/TesinaMyBank/payment/inserisci";
//
//		Gson gson = new Gson();
//		String json = gson.toJson(model);
//	
//		System.out.println(json);
//		URL url = new URL(projectUrl);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
//		connection.setRequestMethod("POST");
//		connection.setDoOutput(true);
//
//		
//		connection.setRequestProperty("Accept-Charset", "UTF-8");
//		connection.setRequestProperty("Accept", "application/json" );
//		connection.setRequestProperty("Content-Type", "application/json" + "UTF-8");
//
//	    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
//
//	    writer.write(json);
//	    writer.flush();
//	    String line;
//
//	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	    while ((line = reader.readLine()) != null) {
//	      System.out.println(line);
//	    }
//	    writer.close();
//	    reader.close();
//		connection.connect();
//
//		System.out.println("prima del ret > " + connection);
//	}

}
