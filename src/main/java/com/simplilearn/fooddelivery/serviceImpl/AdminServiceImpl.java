/**
 * 
 */
package com.simplilearn.fooddelivery.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.entity.Admin;
import com.simplilearn.fooddelivery.repository.AdminRepository;
import com.simplilearn.fooddelivery.service.AdminService;

/**
 * @author Bhakti
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repo;
	
	boolean status;

	@Override
	public boolean addAdmin(Admin adminDetails) {
		boolean status=false;
		// TODO Auto-generated method stub
		repo.save(adminDetails);
		status=true;
		return status;
	}

	@Override
	public Admin editAdmin(Admin adminDetails) {
		
		Admin a = repo.getById(adminDetails.getId());
		
		a.setEmail(adminDetails.getEmail());
		a.setPassword(adminDetails.getPassword());
		
		return repo.save(a);
	}

	@Override
	public boolean deleteAdmin(Long adminId) {
		status = false;
		
		repo.deleteById(adminId);
		
		status=true;
		return status;
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Admin validateAdmin(Admin adminData) {
		// TODO Auto-generated method stub
		String email = adminData.getEmail();
		String password = adminData.getPassword();
		return repo.validateAdmin(email,password);
	}
	
	
	

}
