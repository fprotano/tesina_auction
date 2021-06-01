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
import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.service.api.StaffService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/staff")
public class ApiControllerStaff extends BaseController<Staff> {
	private StaffService staffService;

	@Autowired(required = true)
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	@RequestMapping(value = "staffInsertUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Staff> doStaffInsertUpdate(@RequestBody Staff model) {
		System.out.println("nel StaffInsert, auction > " + model);
		staffService.save(model);
		return sendSuccess(model);
	}

	@RequestMapping(value = "findById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Staff> doStaffFindBy(@RequestBody int id) {
		System.out.println("nel StaffInsert, auction > " + id);
		Staff staff = staffService.find(id);
		return sendSuccess(staff);
	}
}
