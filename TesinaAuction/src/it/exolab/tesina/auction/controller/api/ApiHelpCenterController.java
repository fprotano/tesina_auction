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
import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.service.api.HelpCenterService;
import it.exolab.tesina.auction.service.api.HelpCenterThreadService;
import it.exolab.tesina.auction.service.api.StaffService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/helpCenter")
public class ApiHelpCenterController extends BaseController<HelpCenter>{
	
	private HelpCenterService helpCenterService;
	

	
	@Autowired(required = true)
	public void setHelpCenterService(HelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<HelpCenter> doInsert(@RequestBody HelpCenter model) {
		
		System.out.println("dentro help Ceter insert, helpCenter > "+model);
		StaffService ss = new StaffService();
		model.setAssignedToId(ss.findHelpDeskWithLessWork().getId());
		helpCenterService.save(model);
		
		HelpCenterThread helpCenterThread = new HelpCenterThread();
		helpCenterThread.setQuestion(model.getQuestion());
		helpCenterThread.setHelpCenterId(model.getId());
		
		HelpCenterThreadService helpCenterThreadService = new HelpCenterThreadService();
		helpCenterThreadService.save(helpCenterThread);
		
		return sendSuccess(model);
	}

}
