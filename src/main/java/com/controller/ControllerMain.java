package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.domain.FormInputtedDomain;
import com.service.MainService;

@Controller
public class ControllerMain {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = { "/" , "/home"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		FormInputtedDomain form = new FormInputtedDomain();
		model.addAttribute("formSubmitted", form);
		return "home";
	}

	@RequestMapping(value = "/saveForm", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute("formSubmitted") FormInputtedDomain form, BindingResult result, Model model,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			return "home";
		} else {
			String error = mainService.checkFormInputted(form);
			request.getSession().setAttribute("error", error);
			return "redirect:/home";
		}
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public String invalidURL(HttpServletRequest request) {
		return "redirect:/";
	}
}
