package it.exolab.tesina.auction.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.api.model.dto.FakeDTO;
import it.exolab.tesina.auction.service.api.FakeService;
@Controller
public class ApiFakeController extends BaseController {

	private FakeService fakeService;
	 
	
	
	@Autowired
	public void setFakeService(FakeService fakeService) {
		this.fakeService = fakeService;
	}

	@RequestMapping(value="insert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FakeDTO insert(@RequestBody FakeDTO model) {
		fakeService.insert(model);
		return model;
		
	}
	
	@RequestMapping(value="fake/find", method=RequestMethod.GET)
	@ResponseBody
	public  FakeDTO find() {
		return fakeService.find();
		
	}
}
