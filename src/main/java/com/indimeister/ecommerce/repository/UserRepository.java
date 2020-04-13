package com.indimeister.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indimeister.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String name);
}
