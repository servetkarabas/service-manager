package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.DosyaDurum;
import com.lbs.model.Hasar;
import com.lbs.repository.DurumRepository;

@Service
public class DurumService {
	
	@Autowired
	private DurumRepository	durumRepository;
	
	
	public List<DosyaDurum> findAll(){
		return (List<DosyaDurum>) durumRepository.findAll();
	}
}
