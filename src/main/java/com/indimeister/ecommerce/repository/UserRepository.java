package com.indimeister.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indimeister.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail (String email);
	

}
