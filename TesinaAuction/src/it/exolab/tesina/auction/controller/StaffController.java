package it.exolab.tesina.auction.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.exolab.tesina.auction.model.Role;
import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.service.api.HelpCenterService;
import it.exolab.tesina.auction.service.api.RoleService;
import it.exolab.tesina.auction.service.api.StaffService;
import it.exolab.tesina.auction.util.OTP;
import it.exolab.tesina.auction.util.Utils;

@CrossOrigin
@Controller
@RequestMapping(value = "staff")
public class StaffController extends BaseController<Staff> {
	private StaffService staffService;
	private RoleService roleService;
	private HelpCenterService helpSer;
	
	@Autowired(required = true)
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@Autowired(required = true)
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@Autowired(required = true)
	public void setHelpCenterService(HelpCenterService helpSer) {
		this.helpSer = helpSer;
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
				return ret;
			} 
//		 	SendEmailController sendEmailController = new SendEmailController();
//		 	sendEmailController.sendMail(staff.getEmail(), "exolabcorso2021@gmail.com", "prova", "otp farlocco 123456789");
		 	
		 	OTP<Staff, StaffService> otp = new OTP<Staff, StaffService>();
		 	if(otp.checkIfOtpIsNeeded(staff, staffService)) {
		 		staff.setOtpCode(null);
		 		ret.addObject("accountAskOTP", staff);
		 		ret.addObject("action", "askOTP");
		 		return ret;
		 	}
		 	
		 	session.setAttribute("staff", staff);
		 	
		 	if(staff.getStaffRole().getTitle().equals("Help Desk")) {
		 		
		 		return ret = new ModelAndView("redirect:/helpCenter/HelpCenterToAnswer");
		 		
		 	}
		 	System.out.println(ret);
			return ret;
		}
	 
	 @RequestMapping(value = "login-OTP", method = RequestMethod.POST)
	 public ModelAndView loginCheckInsertedOTP(Staff accountAskOTP, HttpSession session) {
		 ModelAndView ret = new ModelAndView("home");
		 Staff staff = staffService.findByEmailAndPasswordAndOtpCode(accountAskOTP.getEmail(), accountAskOTP.getPassword(), accountAskOTP.getOtpCode());
		 if(staff == null) {
			 ret.addObject("message", "codice OTP errato");
			 ret.addObject("accountAskOTP", accountAskOTP);
			 ret.addObject("action", "askOTP");
			 return ret;
		 }
		 Utils util = new Utils();
		 OTP<Staff, StaffService> otp = new OTP<Staff, StaffService>();
			
		 if(util.beforeDate(staff.getOtpCodeExpiresAt())) {
			otp.createNewOTP(staff, staffService);
			
			ret.addObject("message", "OTP scaduto, ti abbiamo inviato un nuovo codice per email");
	 		ret.addObject("accountAskOTP", accountAskOTP);
	 		ret.addObject("action", "askOTP");
	 		return ret;
		 }
		 
		 otp.setNewOtpExp(staff, staffService);
		 staffService.save(staff);
		 
		 session.setAttribute("staff", staff);
		 return ret;
	 }
	
	@RequestMapping(value = "admin-insert", method = RequestMethod.GET)
	public ModelAndView redirectInsertStaff(HttpSession session, 
			  @ModelAttribute("flashAttribute") String flashAttribute) {
		
		ModelAndView ret = new ModelAndView("home");
		ret.addObject("action", "insert");
		
		List<Role> roles = roleService.findAll();
		ret.addObject("roles", roles);
		
		Staff model= new Staff();
		ret.addObject("insertStaff", model);
		
		if(flashAttribute != null)
			ret.addObject("message", flashAttribute);

		return ret;
		
	}
	
	@RequestMapping(value = "admin-insert", method = RequestMethod.POST)
	public String doInsertStaff(HttpSession session, Staff insertStaff, RedirectAttributes attributes) {
		
//		ModelAndView ret = new ModelAndView("home");
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		insertStaff.setCreateAt(currentTime);
		insertStaff.setPassword("pass."+insertStaff.getEmail());
		
		OTP<Staff, StaffService> otp = new OTP<Staff, StaffService>(); 
		otp.setNewOtpExp(insertStaff, staffService);
		
		staffService.save(insertStaff);
//		ret.addObject("message", "registrazione effettuata con successo");
//		System.out.println(ret);
//		return ret;
		
		attributes.addFlashAttribute("flashAttribute", "registrazione effettuata con successo");
	    return"redirect:/staff/admin-insert";
		
	}
	
	@RequestMapping(value="list-helpDesk", method = RequestMethod.GET)
	public ModelAndView getListHelpDesk() {
		
		ModelAndView ret = new ModelAndView("home");
		ret.addObject("action", "listStaff");
		
		List<Staff> listStaff = staffService.findByRoleTitle("Help Desk");
		ret.addObject("listStaff", listStaff);

		return ret;
		
		
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("staff");
		return "redirect:/staff/home";
	}


	@RequestMapping(value = "doStaffFindBySurname", method = RequestMethod.POST)

	public ModelAndView doStaffFindBySurname(@ModelAttribute Staff model     ) {
		System.out.println("nel doStaffFindBySurname jsp  " + model);
		staffService.FindBySurname(model.getSurname());
		ModelAndView ret =new ModelAndView("admin/homeAdmin");
		return ret;
	}
	
	
	
}