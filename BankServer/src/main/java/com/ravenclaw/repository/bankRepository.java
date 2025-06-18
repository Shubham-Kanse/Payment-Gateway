package com.ravenclaw.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravenclaw.model.bankEntity;


public interface bankRepository extends JpaRepository<bankEntity, String> {

	public bankEntity findByid(int value);
	
	public bankEntity findByname(String value);
	
	public bankEntity findBycardNumber(BigInteger value);
}
