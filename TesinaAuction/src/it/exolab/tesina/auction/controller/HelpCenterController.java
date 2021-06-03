package it.exolab.tesina.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.service.api.HelpCenterService;

@CrossOrigin
@Controller
@RequestMapping(value = "helpCenter")
public class HelpCenterController extends BaseController<HelpCenter> {

	private HelpCenterService helpCenterService;

	@Autowired(required = true)
	public void setHelpCenterService(HelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}

	@RequestMapping(value = "findHelpCenter", method = RequestMethod.POST)

	public ModelAndView dofindbyAssignedIdAndClosed(@ModelAttribute HelpCenter model) {
		System.out.println("findbyAssignedIdAndClosed jsp " + model);
		ModelAndView ret = new ModelAndView("admin/homeAdmin");
		helpCenterService.findbyAssignedIdAndClosed(model.getAssignedToId());

		return ret;

	}

}
