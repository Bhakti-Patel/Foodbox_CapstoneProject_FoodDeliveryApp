/**
 * 
 */
package com.simplilearn.fooddelivery.service;

import java.util.List;

import com.simplilearn.fooddelivery.entity.User;

/**
 * @author Bhakti
 *
 */
public interface UserService {
	
	public boolean addUser(User adminDto);

	public List<User> getAllUsers();

}
