package it.exolab.tesina.auction.controller.api;

import java.util.List;

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
import it.exolab.tesina.auction.model.UserItem;
import it.exolab.tesina.auction.service.api.UserItemService;

@CrossOrigin
@Controller
@RequestMapping(value="api/userItem")
public class ApiUserItemController extends BaseController {
	
	private UserItemService userItemService;
	
	@Autowired(required = true)
	public void setUserItemService(UserItemService userItemService) {
		this.userItemService = userItemService;
	}
	
	@RequestMapping(value="userItemInsert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserItem> doauctionInsert(@RequestBody UserItem model) {
		System.out.println(model);
		userItemService.save(model);
		return sendSuccess(model); 
	}
	
	@RequestMapping(value="findUserItemByUser", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserItem> dofindUserItemByUserId(@RequestBody String userId) {
		System.out.println("nell findUserItemByUserId, user id > " + userId);
		List<UserItem> userItemList = userItemService.findUserItemByUserId(Integer.parseInt(userId));
		System.out.println("nell findUserItemByUserId, risposta del db > " + userItemList);
		return sendSuccess(userItemList);
	}
	
	

}
