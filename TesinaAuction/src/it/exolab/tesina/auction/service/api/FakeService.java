package it.exolab.tesina.auction.service.api;

import it.exolab.tesina.auction.api.model.dto.FakeDTO;

public class FakeService {

	
	public void insert(FakeDTO model) {
		
		
	}
	public FakeDTO find() {
		FakeDTO ret = new FakeDTO();
		ret.setParam1("ciao");
		ret.setParam2("hello");
		return ret;
		
	}
}
