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

/**
 * Main controller for Spring.
 * 
 * @author Tihomir Puhalo
 */

@Controller
public class ControllerMain {

	@Autowired
	private MainService mainService;

	/**
	 * Default class for fetching home page. In model we adding FormInputtedDomain
	 * which is default class for inputs.
	 * 
	 * 
	 * @param model
	 * @return view name
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		FormInputtedDomain form = new FormInputtedDomain();
		model.addAttribute("formSubmitted", form);
		return "home";
	}

	/**
	 * Class for handling POST request. If result have errors we return it home, if
	 * not we are handling inputed data.
	 * 
	 * 
	 * @param form
	 * @param result
	 * @param model
	 * @param request
	 * @return views
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveForm", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute("formSubmitted") FormInputtedDomain form, BindingResult result,
			Model model, HttpServletRequest request) throws IOException {
/**
 * for checking when is last updated database and preventing to submit for 1h
 */
	//	boolean getUpdatedTime = mainService.getUpdatedTime();
		String error;

		if (result.hasErrors() ) {
			error = "You have some errors.";
			request.getSession().setAttribute("error", error);
			return "home";
		} else {
			error = mainService.checkFormInputted(form);
			request.getSession().setAttribute("error", error);
			return "redirect:/home";
		}
	}

	/**
	 * If user type wrong URL we redirect him to home page.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String invalidURL(HttpServletRequest request) {
		return "redirect:/";
	}
}
