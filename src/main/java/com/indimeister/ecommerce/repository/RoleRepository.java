package com.indimeister.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indimeister.ecommerce.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
