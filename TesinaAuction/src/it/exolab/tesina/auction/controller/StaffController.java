package it.exolab.tesina.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.service.api.StaffService;

@CrossOrigin
@Controller
@RequestMapping(value = "staff")
public class StaffController extends BaseController<Staff> {
	private StaffService staffService;

	@Autowired(required = true)
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	@RequestMapping(value = "staffInsertUpdate", method = RequestMethod.POST)

	public  ModelAndView  doStaffInsertUpdate(Staff model) {
		//System.out.println("nel StaffInsert, auction > " + model);
		staffService.save(model);
		
		return null;
	    
	}

	@RequestMapping(value = "findById", method = RequestMethod.POST)
	@ResponseBody
	public HttpResponse<Staff> doStaffFindBy(@RequestBody int id) {
		System.out.println("nel StaffInsert, auction > " + id);
		Staff staff = staffService.find(id);
		return sendSuccess(staff);
	}
}
