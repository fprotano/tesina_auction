package it.exolab.tesina.auction.util;

import it.exolab.tesina.auction.api.model.dto.FakeDTO;
import it.exolab.tesina.auction.model.Fake;

public class Factory {

	private static Factory instance=null;
	
	public static Factory getInstance() {
		if(instance==null) {
			instance= new Factory();
		}
		return instance;
	}
	
	private Factory() {
		
	}
	
	
	public FakeDTO makeFake(Fake model) {
		FakeDTO ret = new FakeDTO();
		ret.setParam1(model.getParam1());
		return ret;
	}
}
