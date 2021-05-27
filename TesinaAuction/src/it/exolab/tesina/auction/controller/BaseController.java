package it.exolab.tesina.auction.controller;

import it.exolab.tesina.auction.api.model.HttpResponse;


public class BaseController {
	public static final String ERR_001 = "001";//
	public static final String ERR_002 = "002";
	
	protected HttpResponse sendSuccess(Object data) {
		return new HttpResponse(data);
		
	}
	
	protected HttpResponse sendErr(String err,String err_code) {
		return new HttpResponse(err,err_code);
		
	}
}
