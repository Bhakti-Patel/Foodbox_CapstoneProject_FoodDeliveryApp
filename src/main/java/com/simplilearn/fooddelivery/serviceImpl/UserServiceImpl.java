package com.simplilearn.fooddelivery.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.entity.User;
import com.simplilearn.fooddelivery.repository.UserRepository;
import com.simplilearn.fooddelivery.service.UserService;

/**
 * @author Bhakti
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	boolean status;

	@Override
	public boolean addUser(User user) {
		
		status=false;
		repo.save(user);
		status = true;
		return status;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
