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
import com.data.model.Admin;
import com.data.model.Client;
import com.data.service.AccountService;
import com.data.service.AdminService;
import com.data.service.ClientService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ClientService service;
	
	@Autowired
	private AccountService serviceA;
	
	@GetMapping("/login")
    public String viewAdminLoginPage() {
        return "admin_login";
    }
	
	@GetMapping("/welcomeadmin")
	public String linkToLists() {
		return "welcomeadmin";
	}
	
	
	// clients
	
	@GetMapping("/clients")
	public String listClients(Model model) {
		List <Client> listClients = service.listAll();
		model.addAttribute("listClients", listClients);
		
		return "clients";
	}
	
	
	@GetMapping("/new_client")
	public String newClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "new_client";
	}
	
	@PostMapping("/save_new_client")
	public String processRegister(@Valid Client client, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "new_client";
		}
		if(service.getByEmail(client.getEmail()) != null) {
			return "new_client";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(client.getPassword());
		client.setPassword(encodedPassword);
		service.save(client);
		return "redirect:/admin/clients";
	}
	
	@PostMapping("/update_client")
	public String editClient(@Valid Client client, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "editclient";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(client.getPassword());
		client.setPassword(encodedPassword);
		service.save(client);
		return "redirect:/admin/clients";
	}
	
	@RequestMapping("/editclient/{id}")
	public ModelAndView editClient(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editclient");
		Client client = service.get(id);
		mav.addObject("client", client);
		return mav;
	}
	
	@RequestMapping("/deleteclient/{id}")
	public String deleteClient(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/admin/clients"; 
	} 
	
	// accounts
	
	@GetMapping("/accounts")
	public String listAccounts(Model model) {
		List <Account> listAccounts = serviceA.listAll();
		model.addAttribute("listAccounts", listAccounts);
		
		return "accounts";
	}
	
	@PostMapping("/update_account")
	public String editAccount(@Valid Account account, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "editaccount";
		}
		serviceA.save(account);
		return "redirect:/admin/accounts";
	}
	
	@RequestMapping("/editaccount/{id}")
	public ModelAndView editAccount(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editaccount");
		Account account = serviceA.get(id);
		mav.addObject("account", account);
		return mav;
	}
	
	@RequestMapping("/deleteaccount/{id}")
	public String deleteAccount(@PathVariable(name = "id") int id) {
		serviceA.delete(id);
		return "redirect:/admin/accounts"; 
	} 
}
