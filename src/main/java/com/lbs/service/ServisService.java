package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.Servis;
import com.lbs.repository.ServisRepository;

@Service
public class ServisService {
	
	@Autowired
	ServisRepository	servisRepository;
	
	public	List<Servis>	findAll(){
		return	(List<Servis>) servisRepository.findAll();
	}
}
