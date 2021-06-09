package it.exolab.tesina.auction.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.model.Role;
import it.exolab.tesina.auction.service.api.RoleService;
import it.exolab.tesina.auction.service.api.StaffService;

@CrossOrigin
@Controller
@RequestMapping(value = "staff")
public class StaffController extends BaseController<Staff> {
	private StaffService staffService;
	private RoleService roleService;
	
	@Autowired(required = true)
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@Autowired(required = true)
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public ModelAndView redirectHome(Staff model, HttpSession session, ModelAndView getModelView) {
		ModelAndView ret = new ModelAndView("home");
		
		ret.addObject("title", "home");
		System.out.println("dentro  controller/staff/home "+ret);
		return ret;
	}
		
	 @RequestMapping(value="login", method=RequestMethod.POST)
	 public ModelAndView login(Staff model, HttpSession session) {
			ModelAndView ret = new ModelAndView("home");
		 	Staff staff = staffService.findByEmailAndPassword(model.getEmail(), model.getPassword());
			if(staff==null) {
				ret.addObject("message", "Credenziali errate");
				ret.addObject("datiLogin", model);
				System.out.println("dentro controller/staff/login errore "+ret);
				return ret;
			} 
//		 	ret.addObject("staff",staff);
		 	session.setAttribute("staff", staff);
			System.out.println("dentro controller/staff/login "+ret);
			return ret;
		}
	
	@RequestMapping(value = "admin-insert", method = RequestMethod.GET)
	public ModelAndView redirectInsertStaff(HttpSession session) {
		
		System.out.println("dentro admin-insert.GET");
		
		ModelAndView ret = new ModelAndView("home");
		ret.addObject("action", "insert");
		List<Role> roles = roleService.findAll();
		ret.addObject("roles", roles);
		Staff model= new Staff();
		ret.addObject("insertStaff", model);
		System.out.println(ret);
		return ret;
		
	}
	
	@RequestMapping(value = "admin-insert", method = RequestMethod.POST)
	public ModelAndView doInsertStaff(HttpSession session, Staff insertStaff) {
		
		System.out.println("dentro admin-insert.POST");
		
		ModelAndView ret = new ModelAndView("home");
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		insertStaff.setCreateAt(currentTime);
		System.out.println("modello: "+insertStaff);
		staffService.save(insertStaff);
		ret.addObject("message", "registrazione effettuata con successo");
		System.out.println(ret);
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
