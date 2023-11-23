package com.manager.backend.infraestructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.backend.infraestructure.adapter.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findByEmail (String email);
	
}
