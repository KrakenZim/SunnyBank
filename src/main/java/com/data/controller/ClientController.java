package com.data.controller;

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

import com.data.model.Client;
import com.data.service.ClientService;


@Controller
@RequestMapping("/")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/new")
	public String newClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "registration";
	}
	
	@PostMapping("/save")
	public String processRegister(@Valid Client client, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		if(service.getByEmail(client.getEmail()) != null) {
			return "registration";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(client.getPassword());
		client.setPassword(encodedPassword);
		service.save(client);
		return "register_success";
	}
	
	@GetMapping("/client/login")
    public String viewClientLoginPage() {
        return "client_login";
    }
	
	@GetMapping("/client/welcome")
	public String linkToLists() {
		return "welcome";
	}
	
	@PostMapping("/client/profile")
	public String processEdit(@Valid Client client, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "profile";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(client.getPassword());
		client.setPassword(encodedPassword);
		service.save(client);
		return "redirect:/client/welcome";
	}
	
	@RequestMapping("/client/edit/{id}")
	public ModelAndView editClient(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("profile");
		Client client = service.get(id);
		mav.addObject("client", client);
		return mav;
	}
}