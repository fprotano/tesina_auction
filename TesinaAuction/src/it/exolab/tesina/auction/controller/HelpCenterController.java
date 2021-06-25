package it.exolab.tesina.auction.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.service.api.HelpCenterService;
import it.exolab.tesina.auction.util.Utils;

@CrossOrigin
@Controller
@RequestMapping(value = "helpCenter")
public class HelpCenterController extends BaseController<HelpCenter> {

	private HelpCenterService helpCenterService;

	@Autowired(required = true)
	public void setHelpCenterService(HelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}

	@RequestMapping(value = "HelpCenterToAnswer", method = RequestMethod.GET)
	public ModelAndView dofindbyAssignedIdAndWaitingAnswer(@ModelAttribute HelpCenter model, HttpSession session) {
		ModelAndView ret = new ModelAndView("home");
		Staff s = (Staff) session.getAttribute("staff");
		List<HelpCenter> listHelpCenter = helpCenterService.findOpenHelpCenterAndWaitingAnswer(s.getId());
		ret.addObject("listHelpCenter", listHelpCenter);
		ret.addObject("goToThread", new HelpCenter());
		ret.addObject("typeOfSelectedHelpCenter", "in attesa di risposte");

		return ret;

	}
	
	@RequestMapping(value="HelpCenterOpenPosts", method = RequestMethod.GET)
	public ModelAndView doFindOpenPosts (@ModelAttribute HelpCenter model, HttpSession session) {
		ModelAndView ret = new ModelAndView("home");
		Staff s = (Staff) session.getAttribute("staff");
		List<HelpCenter> listHelpCenter = helpCenterService.findbyAssignedIdAndOpen(s.getId());
		
		ret.addObject("listOpenPosts", listHelpCenter);
		ret.addObject("goToThread", new HelpCenter());
		ret.addObject("typeOfSelectedHelpCenter", "ancora aperto");
		return ret;
	}
	

//	@RequestMapping(value = "close", method = RequestMethod.GET)
//	public ModelAndView closeHelpCenter( RedirectAttributes redirectAttributes, HttpSession session) {
//		ModelAndView ret = new ModelAndView("redirect:/helpCenter/HelpCenterToAnswer");
//		HelpCenter model = this.helpCenterService.find(((HelpCenterThread) redirectAttributes).getId());
//		model.setClosedAt(Utils.getNow());
//		helpCenterService.save(model);
//
//		return ret;
//
//	}
	

	@RequestMapping(value = "close", method = RequestMethod.POST)
	public ModelAndView closeHelpCenter( @ModelAttribute HelpCenterThread threadToAnswer, HttpSession session) {
		ModelAndView ret = new ModelAndView("redirect:/helpCenter/HelpCenterOpenPosts");
		HelpCenter model = this.helpCenterService.find(threadToAnswer.getHelpCenterId());
		model.setClosedAt(Utils.getNow());
		helpCenterService.save(model);

		return ret;

	}

	@RequestMapping(value = "allPostsByHelpCenterId", method = RequestMethod.GET)
	public ModelAndView findAllPostsByHelpCenterId (@ModelAttribute HelpCenter model, HttpSession session) {
		ModelAndView ret = new ModelAndView("home");
		Staff s = (Staff) session.getAttribute("staff");
		List<HelpCenter> listHelpCenter = helpCenterService.findByAssignedToId(s.getId());
		ret.addObject("listHelpCenter", listHelpCenter);
		ret.addObject("goToThread", new HelpCenter());
//		ret.addObject("listHelpCenter", helpCenterService.findOpenHelpCenterAndWaitingAnswer(s.getId()));

		return ret;

	}

	@RequestMapping(value = "findHelpCenter", method = RequestMethod.POST)
	public ModelAndView dofindbyAssignedIdAndClosed(@ModelAttribute HelpCenter model) {

		ModelAndView ret = new ModelAndView("admin/homeAdmin");
		helpCenterService.findbyAssignedIdAndOpen(model.getAssignedToId());

		return ret;

	}

}
