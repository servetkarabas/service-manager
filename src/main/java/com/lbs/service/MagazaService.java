package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.Magaza;
import com.lbs.repository.MagazaRepository;

@Service
public class MagazaService {
	
	@Autowired
	private	MagazaRepository	magazaRepository;
	
	public List<Magaza> findAll(){
		return (List<Magaza>) magazaRepository.findAll();
	}
}
