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
	
	@RequestMapping("/myaccount")
	public String allAccounts(Model model) {
		List<Account> listMyAccounts = service.listAll();
		model.addAttribute("listMyAccounts", listMyAccounts);
		return "account";
	}
	
}