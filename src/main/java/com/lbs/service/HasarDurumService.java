package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.HasarDurum;
import com.lbs.repository.HasarDurumRepository;

@Service
public class HasarDurumService {
	@Autowired
	HasarDurumRepository	hasarDurumRepository;
	
	public	List<HasarDurum>	findAll(){
		return	(List<HasarDurum>)hasarDurumRepository.findAll();
	}

}
