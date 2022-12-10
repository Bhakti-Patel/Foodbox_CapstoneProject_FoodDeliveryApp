package com.simplilearn.fooddelivery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.fooddelivery.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	
	@Query("select admin from Admin admin where admin.email=?1 and admin.password=?2")
	public Admin validateAdmin(String email,String Password);

}
