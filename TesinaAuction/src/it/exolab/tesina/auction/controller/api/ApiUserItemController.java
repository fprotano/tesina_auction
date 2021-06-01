package it.exolab.tesina.auction.controller.api;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.controller.BaseController;

import it.exolab.tesina.auction.model.UserItem;
import it.exolab.tesina.auction.service.api.UserItemService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/userItem")
public class ApiUserItemController extends BaseController<UserItem> {

	private UserItemService userItemService;

	@Autowired(required = true)
	public void setUserItemService(UserItemService userItemService) {
		this.userItemService = userItemService;
	}
	

	
	@RequestMapping(value = "userItemInsert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserItem> doUserItemInsert(@RequestBody UserItem model) {
		System.out.println("nel userItemInsert, model il ingresso > " + model);
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		model.setCreatedAt(currentTime);
		userItemService.save(model);
		System.out.println(model);
		return sendSuccess(model);
	}

	@RequestMapping(value = "findUserItemByUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserItem> dofindUserItemByUserId(@RequestBody String userId) {
		System.out.println("nell findUserItemByUserId, user id > " + userId);
		List<UserItem> userItemList = userItemService.findUserItemByUserId(Integer.parseInt(userId));
		System.out.println("nell findUserItemByUserId, risposta del db > " + userItemList);
		return sendSuccess(userItemList);
	}
	

	@RequestMapping(value="findAllItems", method=RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<UserItem> doFindAllItems() {
		
		System.out.println("sono nel findAllItems");
		List<UserItem> itemList = userItemService.findAll();
		
		System.out.println("stampa dei ptodotti > " + itemList);
		return sendSuccess(itemList);
	
	}
	

}
