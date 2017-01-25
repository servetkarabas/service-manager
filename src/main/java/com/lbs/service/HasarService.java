package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.Hasar;
import com.lbs.repository.HasarRepository;

@Service
public class HasarService {

	@Autowired
	private HasarRepository hasarRepository;
	
	public List<Hasar> findAll(){
		return (List<Hasar>) hasarRepository.findAll();
	}
	
	public void saveHasar(Hasar hasar){
		hasarRepository.saveAndFlush(hasar);
	}

	public void removeHasar(Hasar hasar) {
		hasarRepository.delete(hasar);
	}
	

}
