/**
 * 
 */
package com.simplilearn.fooddelivery.service;

import java.util.List;

import com.simplilearn.fooddelivery.entity.Admin;

/**
 * @author Bhakti
 *
 */

public interface AdminService {

	public boolean addAdmin(Admin adminDetails);
	
	public Admin editAdmin(Admin adminDetails);

	public boolean deleteAdmin(Long adminId);

	public List<Admin> getAllAdmins();
	
	public Admin validateAdmin(Admin adminData);	
	

}
