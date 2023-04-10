package com.data.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.data.model.Account;
import com.data.service.AccountService;



@Controller
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/client/myaccount")
	public String processEdit(@Valid Account account, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "myaccount";
		}
		service.save(account);
		return "redirect:/client/welcome";
	}
	
	@RequestMapping("/client/editAccount/{id}")
	public ModelAndView editAccount(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("myaccount");
		Account account = service.get(id);
		mav.addObject("account", account);
		return mav;
	}
	
}