package com.paymentdemo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentdemo.entity.datalogged;

public interface repository extends JpaRepository<datalogged, Integer> {

	boolean existsByUname(String uname);
	
	datalogged findByUnameAndPass(String uname,String pass);
}
