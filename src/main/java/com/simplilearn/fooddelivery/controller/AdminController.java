package com.simplilearn.fooddelivery.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.fooddelivery.entity.Admin;
import com.simplilearn.fooddelivery.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {
	
	@Autowired
	private AdminService service; 
	
	Logger log = Logger.getAnonymousLogger();

	
	@PostMapping("/addAdmin")
	public boolean addAdmin(@RequestBody Admin a) {
		
		return service.addAdmin(a);
		
	}
	
	@PutMapping("/editAdmin")
	public Admin editAdmin(@RequestBody Admin adminDetails) {
		
		return service.editAdmin(adminDetails);
		
	}
	
	@DeleteMapping("/deleteAdmin/{adminId}")
	public boolean deleteAdmin(@PathVariable Long adminId) {
		
		return service.deleteAdmin(adminId);
		
	}
	
	
	
	@GetMapping("/getAllAdmins")
	public List<Admin>getAllAdmins(){
		return service.getAllAdmins();
		
	}	
	
	
	
	
	

	
	

}
