package it.exolab.tesina.auction.api.model;

import org.springframework.http.HttpStatus;

public class HttpResponse<T> {

	
	private boolean success;
	private String err;
	private String err_code;
	private T data;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public HttpResponse(boolean success, String err, String err_code, T data) {
		super();
		this.success = success;
		this.err = err;
		this.err_code = err_code;
		this.data = data;
	}
	public HttpResponse(T data) {
		this(true,null,null,data);
	}
	public HttpResponse(String err, String err_code) {
		this(false,err,err_code,null);
	}
	public HttpResponse() {
		
	}
	public HttpResponse(HttpStatus ok, String string) {
		
	}
	
}
