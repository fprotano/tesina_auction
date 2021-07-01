package it.exolab.tesina.auction.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.service.api.HelpCenterService;
import it.exolab.tesina.auction.service.api.HelpCenterThreadService;
import it.exolab.tesina.auction.util.Utils;

@CrossOrigin
@Controller
@RequestMapping(value="api/helpCenterThread")
public class ApiHelpCenterThreadController  extends BaseController<HelpCenterThread>{
	
	private HelpCenterThreadService helpCenterThreadService;
	private HelpCenterService helpCenterService;
	
	@Autowired(required=true)
	public void setServices(HelpCenterThreadService helpCenterThreadService, 
							HelpCenterService helpCenterService) {
		this.helpCenterThreadService = helpCenterThreadService;
		this.helpCenterService = helpCenterService;
	}
	
	@RequestMapping(value="insertThread", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<HelpCenterThread> doInsert(@RequestBody HelpCenterThread model) {
		model.setCreatedAt(Utils.getNow());
		helpCenterThreadService.save(model);

		this.helpCenterService.save(this.helpCenterService.find(model.getHelpCenterId()));
		
		return sendSuccess(model);
	}

}
