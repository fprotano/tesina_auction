package it.exolab.tesina.auction.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.api.model.dto.HelpCenterDTO;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.service.api.HelpCenterService;
import it.exolab.tesina.auction.service.api.HelpCenterThreadService;
import it.exolab.tesina.auction.service.api.StaffService;
import it.exolab.tesina.auction.util.Utils;

@CrossOrigin
@Controller
@RequestMapping(value = "api/helpCenter")
public class ApiHelpCenterController extends BaseController<HelpCenter>{
	
	private HelpCenterService helpCenterService;
	private HelpCenterThreadService helpCenterThreadService;
	private StaffService staffService;

	
	@Autowired(required = true)
	public void setHelpCenterService(HelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}
	
	@Autowired(required = true)
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@Autowired(required = true)
	public void setHelpCenterThreadService(HelpCenterThreadService helpCenterThreadService) {
		this.helpCenterThreadService = helpCenterThreadService;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<HelpCenter> doInsert(@RequestBody HelpCenter model) {
		model.setAssignedToId(staffService.findHelpDeskWithLessWork().getId());
		model.setCreatedAt(Utils.getNow());
		helpCenterService.save(model);
		
		HelpCenterThread helpCenterThread = new HelpCenterThread();
		helpCenterThread.setCreatedAt(model.getCreatedAt());
		helpCenterThread.setQuestion(model.getQuestion());
		helpCenterThread.setHelpCenterId(model.getId());
		
		helpCenterThreadService.save(helpCenterThread);
		
		return sendSuccess(model);
	}
	
	@RequestMapping (value="fAOfUs/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public HttpResponse<HelpCenter> findAllOfUser(@PathVariable Integer userId){

		List <HelpCenter> listHelpCenter = this.helpCenterService.findbyUserId(userId);
		List <HelpCenterDTO> listHelpCenterToSend = new ArrayList<HelpCenterDTO>();
		for (HelpCenter hc : listHelpCenter) {
			listHelpCenterToSend.add(new HelpCenterDTO(hc));
		}
		return sendSuccess(listHelpCenterToSend);
		
	}

}
