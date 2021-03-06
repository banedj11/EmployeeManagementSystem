package com.baka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baka.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);
}
