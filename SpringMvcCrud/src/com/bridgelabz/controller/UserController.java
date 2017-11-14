package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

@Controller
public class UserController {

	
	private UserService userservice;
	@Autowired(required=true)
	@Qualifier(value="userservice")
	public void setUserService(UserService userservice) {
		this.userservice=userservice;
	}
	@ModelAttribute
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String listUser(Model model){
		model.addAttribute("listUsers", this.userservice.displayList());
	return	"user";
	}
	
	@RequestMapping(value="user/add",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user){
		if(user.getId()==0){
			this.userservice.addUser(user);
			
		}
		else{
			this.userservice.updateUser(user);
		}
		return "redirect:/users";
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.userservice.deleteuser(id);
        return "redirect:/persons";
    }
	
	
	
	
}
