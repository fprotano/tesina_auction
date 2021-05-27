package it.exolab.tesina.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="fake")
public class FakeController {

	@RequestMapping(value="fake-get")
	public String fake() {
		return "fake";
	}
}
