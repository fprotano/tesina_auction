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
import it.exolab.tesina.auction.api.model.dto.UserDTO;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.UserService;

@CrossOrigin
@Controller
@RequestMapping(value="api/user")
public class ApiUserController extends BaseController {
	
	private UserService userService;
  
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserDTO> doInsert(@RequestBody UserDTO model) {
		System.out.println(model);
		userService.save(model);
		return (HttpResponse<UserDTO>) sendSuccess(model);
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserDTO> doLogin(@RequestBody UserDTO model) {
		System.out.println(model);
		UserDTO modelDTO = userService.findByEmailAndPassword(model.getEmail(), model.getPassword());
		System.out.println(modelDTO);
		return (HttpResponse<UserDTO>) sendSuccess(modelDTO);
	}
}
