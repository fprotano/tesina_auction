package it.exolab.tesina.auction.controller;

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
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public ModelAndView doLogin(@ModelAttribute Staff model, HttpSession session){
//		ModelAndView ret = new ModelAndView("home");
//		Staff staff = staffService.findByEmailAndPassword(model.getEmail(), model.getPassword());
//		session.setAttribute("staff", staff);
//		ret.addObject("staff", staff);
//		return ret;
//	}
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public ModelAndView doLogin(Model model){
//		model.addAttribute("staff", new Staff());
//		return model;
//	}
	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("staff") Staff model)
//    {
//		ModelAndView ret;
//		Staff loggedStaff = staffService.findByEmailAndPassword(model.getEmail(), model.getPassword());
//		if(loggedStaff.getSurname() !=null)
//            {
//                System.out.println("User Login Successful");
//                request.setAttribute("loggedStaff", loggedStaff);
//                ret = new ModelAndView("home");
//            }
//            else
//            {
//                ret = new ModelAndView("login");
//                	ret.addObject("loggedStaff", loggedStaff);
//                	request.setAttribute("message", "Credenziali non valide");
//            }
// 
//       
// 
//        return ret;
//    }
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	   public String index(@ModelAttribute Staff staff) {
	      return "admin/login";
	   }
	
	
	 @RequestMapping(value="login", method=RequestMethod.POST)
	 public ModelAndView login(Staff staff, HttpSession session) {
		 ModelAndView ret = new ModelAndView("redirect:/staff/home");
		 //
		 	System.out.println(staff.getEmail()+" "+staff.getPassword());
		 //
		 	Staff model = null;
		 	model = staffService.findByEmailAndPassword(staff.getEmail(), staff.getPassword());
			if(model!=null) {
		 	ret.addObject("staff", model);
		 	session.setAttribute("staff", model);
			return ret;
			} else {
				ModelAndView ret2 = new ModelAndView("login");
				ret2.addObject("messaggio", "Credenziali errate");
					return ret2;
			}
		}
	 @RequestMapping(value="home", method=RequestMethod.GET)
		public String home(HttpSession session,Model model) {
			model.addAttribute("staff",(Staff)session.getAttribute("staff"));
			return "admin/homeAdmin";
		}


	/*
	@RequestMapping(value = "login", method = RequestMethod.POST)    //Login

	public ModelAndView doStaffFindByEmailAndPassword(@ModelAttribute Staff model) {    
		System.out.println("nel StaffFind jsp  " + model);
		Staff staff = staffService.findByEmailAndPassword(model.getEmail(), model.getPassword());
		ModelAndView ret =new ModelAndView("admin/homeAdmin");
		ret.addObject(staff);
		return ret;
	}
	*/
	@RequestMapping(value = "doStaffFindBySurname", method = RequestMethod.POST)

	public ModelAndView doStaffFindBySurname(@ModelAttribute Staff model     ) {
		System.out.println("nel doStaffFindBySurname jsp  " + model);
		staffService.FindBySurname(model.getSurname());
		ModelAndView ret =new ModelAndView("admin/homeAdmin");
		return ret;
	}
	
	
	
}
