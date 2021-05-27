package it.exolab.tesina.auction.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.api.exception.EntityNotFoundError;
import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.api.model.dto.FakeDTO;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.service.api.FakeService;



@CrossOrigin
@Controller
@RequestMapping(value="api/fake")
public class ApiFakeController extends BaseController {

	private FakeService    fakeService;
	 
	
	
	@Autowired
	public void setFakeService(FakeService fakeService) {
		this.fakeService = fakeService;
	}

	@RequestMapping(value="insert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse insert(@RequestBody FakeDTO model) {
		fakeService.insert(model);
		return sendSuccess(model);
		
	}
	
	@RequestMapping(value="find", method=RequestMethod.GET)
	@ResponseBody
	public HttpResponse find() {
		try {
			return sendSuccess(fakeService.find());
		} catch (EntityNotFoundError e) {
			return sendErr(e.getMessage(),BaseController.ERR_001);
		}
		
	}
}
