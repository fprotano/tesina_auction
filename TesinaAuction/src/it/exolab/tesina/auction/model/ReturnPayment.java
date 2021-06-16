package it.exolab.tesina.auction.model;

import java.util.Arrays;

public class ReturnPayment {
	
	private String [] pn;
	private String [] pv;
	
	public ReturnPayment() {

	}

	public ReturnPayment(String[] pn, String[] pv) {
		super();
		this.pn = pn;
		this.pv = pv;
	}

	public String[] getPn() {
		return pn;
	}

	public void setPn(String[] pn) {
		this.pn = pn;
	}

	public String[] getPv() {
		return pv;
	}

	public void setPv(String[] pv) {
		this.pv = pv;
	}

	@Override
	public String toString() {
		return "ReturnPayment [pn=" + Arrays.toString(pn) + ", pv=" + Arrays.toString(pv) + "]";
	}
}
