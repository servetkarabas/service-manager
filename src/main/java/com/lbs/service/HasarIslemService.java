package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.HasarIslem;
import com.lbs.repository.HasarIslemRepository;

@Service
public class HasarIslemService {
	
	@Autowired
	HasarIslemRepository	hasarIslemRepository;
	
	public	List<HasarIslem>	findAll(){
		return	(List<HasarIslem>) hasarIslemRepository.findAll();
	}
	
	public	void save(HasarIslem hasarIslem){
		hasarIslemRepository.saveAndFlush(hasarIslem);
	}
}
