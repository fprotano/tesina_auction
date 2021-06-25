package it.exolab.tesina.auction.controller.api;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.UserService;
import it.exolab.tesina.auction.util.OTP;

@CrossOrigin
@Controller
@RequestMapping(value="api/user")
public class ApiUserController extends BaseController<User> {
	
	private UserService userService;
  
	@Autowired(required = true)
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<User> doRegister(@RequestBody User model) {
		System.out.println("nel register, model il ingresso > " + model);
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		model.setCreateAt(currentTime);
		OTP<User, UserService> otp = new OTP<User, UserService>();
		otp.setNewOtpExp(model, userService);
		userService.save(model);
		return sendSuccess(model);  //ritorno in http ogg
	}
	
	@RequestMapping(value="checkOtp", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<User> doCheckOpt(@RequestBody User model) {
		
		System.out.println("nel checkOtp, model il ingresso > " + model);
		
		User modelNew = userService.findByEmailAndPassword(model.getEmail(), model.getPassword());
		if(modelNew == null) {
			return sendErr("credenziali errate", "err001");
		}
		OTP<User, UserService> otp = new OTP<User, UserService>();
		if(otp.checkIfOtpIsNeeded(modelNew, userService)) {
			return sendSuccess(new User(model.getEmail(), model.getOtpCode()));
		}
		return sendSuccess(modelNew);
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<User> doLogin(@RequestBody User user) {
		
		System.out.println("nel login, model il ingresso > " + user);
		User logingUser = userService.findByOtpCodeAndEmail(user.getOtpCode(), user.getEmail());
		if(logingUser == null) {
			return sendErr("credenziali errate", "err001");
		}
		
		return sendSuccess(logingUser);
	}
}
