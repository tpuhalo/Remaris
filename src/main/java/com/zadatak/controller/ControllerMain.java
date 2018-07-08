package com.zadatak.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.service.MainService;

@Controller
public class ControllerMain {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = { "/" })
	public String listUsers(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactList(Model model, HttpServletRequest request) throws IOException {
		List<Contact> contact = (List<Contact>) mainService.getContacts();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("contact", contact);
		model.addAttribute("error", error);
		return "info/contactInfo";
	}

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String addressList(Model model, HttpServletRequest request) throws IOException {
		List<Address> address = mainService.getAddresses();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("address", address);
		model.addAttribute("error", error);
		return "info/addressInfo";
	}

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String cityList(Model model, HttpServletRequest request) throws IOException {
		List<City> city = mainService.getCities();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("city", city);
		model.addAttribute("error", error);
		return "info/cityInfo";
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public String countryList(Model model, HttpServletRequest request) throws IOException {
		List<Country> country = mainService.getCountry();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("country", country);
		model.addAttribute("error", error);
		return "info/countryInfo";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String invalidURL(HttpServletRequest request) {
		return "redirect:/";
	}
}
