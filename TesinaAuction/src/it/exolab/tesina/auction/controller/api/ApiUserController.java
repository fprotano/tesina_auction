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
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.UserService;

@CrossOrigin
@Controller
@RequestMapping(value="api/user")
public class ApiUserController extends BaseController {
	
	private UserService userService;
  
	@Autowired(required = true)
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<User> doRegister(@RequestBody User model) {
		System.out.println(model);
		userService.save(model);
		return (HttpResponse<User>) sendSuccess(model);  //ritorno in http ogg
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<User> doLogin(@RequestBody User model) {
	
		User modelNew = userService.findByEmailAndPassword(model.getEmail(), model.getPassword());

		return (HttpResponse<User>) sendSuccess(modelNew);
	}
}
