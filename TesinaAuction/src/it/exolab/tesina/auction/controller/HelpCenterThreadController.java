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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.service.api.HelpCenterService;
import it.exolab.tesina.auction.service.api.HelpCenterThreadService;
import it.exolab.tesina.auction.util.Utils;

@CrossOrigin
@Controller
@RequestMapping(value = "helpCenterThread")
public class HelpCenterThreadController  extends BaseController<HelpCenter> {
	
	private HelpCenterThreadService helpCenterThreadService;
	private HelpCenterService helpCenterService;
	
	@Autowired(required = true)
	public void setHelpCenterThreadService(HelpCenterThreadService helpCenterThreadService) {
		this.helpCenterThreadService = helpCenterThreadService;
	}
	
	@Autowired(required = true)
	public void setHelpCenterService(HelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}

	@RequestMapping(value = "thread", method = RequestMethod.POST)
	public ModelAndView dofindbyAssignedIdAndClosed(@ModelAttribute HelpCenter model) {

		ModelAndView ret = new ModelAndView("home");
		List<HelpCenterThread> threads = helpCenterThreadService.getThreadsByHelpCenterId(model.getId());
		ret.addObject("threads", threads);
		ret.addObject("action", "thread");
		model= this.helpCenterService.find(model.getId());
		ret.addObject("currentThread", model);
		ret.addObject("threadToAnswer", new HelpCenterThread());

		return ret;

	}

	@RequestMapping(value = "thread", method = RequestMethod.GET)
	public ModelAndView dofindbyAssignedIdAndClosed(@ModelAttribute HelpCenterThread model, @ModelAttribute("redir") HelpCenterThread redir) {

		ModelAndView ret = new ModelAndView("home");
		if(redir!=null) {
			model=this.helpCenterThreadService.find(redir.getHelpCenterId());
		}
		List<HelpCenterThread> threads = helpCenterThreadService.getThreadsByHelpCenterId(model.getHelpCenterId());
		ret.addObject("threads", threads);
		ret.addObject("action", "thread");
		ret.addObject("threadToAnswer", new HelpCenterThread());

		return ret;

	}
	
	@RequestMapping(value="answer", method = RequestMethod.POST)
	public ModelAndView answerQuestion(@ModelAttribute HelpCenterThread threadToAnswer, RedirectAttributes redir) {
		ModelAndView ret = new ModelAndView("redirect:/helpCenterThread/thread");
		HelpCenterThread model = this.helpCenterThreadService.find(threadToAnswer.getId());
		model.setAnswer(threadToAnswer.getAnswer());
		this.helpCenterThreadService.save(model);
		
		HelpCenter hp = this.helpCenterService.find(model.getHelpCenterId());
		this.helpCenterService.save(hp);
		
		redir.addFlashAttribute("redir",model);
		
		return ret;
	}	
	
//	@RequestMapping(value = "close", method = RequestMethod.POST)
//	public ModelAndView closeHelpCenter(@ModelAttribute HelpCenterThread threadToAnswer, HttpSession session, RedirectAttributes redirectAttributes) {
//		ModelAndView ret = new ModelAndView("redirect:/helpCenter/close");
//		threadToAnswer=this.helpCenterThreadService.find(threadToAnswer.getId());
//		redirectAttributes.addFlashAttribute("redirectAttributes", threadToAnswer);
//		
//		return ret;
//	}
	

}
