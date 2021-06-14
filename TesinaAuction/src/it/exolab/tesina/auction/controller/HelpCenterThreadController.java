package it.exolab.tesina.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.service.api.HelpCenterThreadService;

@CrossOrigin
@Controller
@RequestMapping(value = "helpCenterThread")
public class HelpCenterThreadController  extends BaseController<HelpCenter> {
	
	private HelpCenterThreadService helpCenterThreadService;

	@Autowired(required = true)
	public void setHelpCenterThreadService(HelpCenterThreadService helpCenterThreadService) {
		this.helpCenterThreadService = helpCenterThreadService;
	}

	@RequestMapping(value = "thread", method = RequestMethod.POST)
	public ModelAndView dofindbyAssignedIdAndClosed(@ModelAttribute HelpCenter model) {

		ModelAndView ret = new ModelAndView("home");
		List<HelpCenterThread> threads = helpCenterThreadService.getThreadsByHelpCenterId(model.getId());
		ret.addObject("threads", threads);
		ret.addObject("action", "thread");
		ret.addObject("threadToAnswer", new HelpCenterThread());

		return ret;

	}
	
	@RequestMapping(value="answer", method = RequestMethod.POST)
	public ModelAndView answerQuestion(@ModelAttribute HelpCenterThread model) {
		ModelAndView ret = new ModelAndView("redirect:/helpCenter/HelpCenterToAnswer");
		this.helpCenterThreadService.updateAnswerThread(model.getId(), model.getAnswer());
		return ret;
		
	}
	

}
