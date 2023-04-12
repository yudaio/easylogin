package com.example.easylogin.model.dao;
import com.example.easylogin.model.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUserNameAndPassword(String userName, String password);
	
}
