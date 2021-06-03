package it.exolab.tesina.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	public  ModelAndView  doStaffInsertUpdate(@ModelAttribute Staff model ) {
		System.out.println("nel StaffInsert  jsp " + model);
		ModelAndView ret =new ModelAndView("admin/homeAdmin");
		staffService.save(model);
	
		
		return ret ;
	    
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)    //Login

	public ModelAndView doStaffFindByEmailAndPassword(@ModelAttribute Staff model) {    
		System.out.println("nel StaffFind jsp  " + model);
		Staff staff = staffService.findByEmailAndPassword(model.getEmail(), model.getPassword());
		ModelAndView ret =new ModelAndView("admin/homeAdmin");
		ret.addObject(staff);
		return ret;
	}
	@RequestMapping(value = "doStaffFindBySurname", method = RequestMethod.POST)

	public ModelAndView doStaffFindBySurname(@ModelAttribute Staff model     ) {
		System.out.println("nel doStaffFindBySurname jsp  " + model);
		staffService.FindBySurname(model.getSurname());
		ModelAndView ret =new ModelAndView("admin/homeAdmin");
		return ret;
	}
	
	
	
}
