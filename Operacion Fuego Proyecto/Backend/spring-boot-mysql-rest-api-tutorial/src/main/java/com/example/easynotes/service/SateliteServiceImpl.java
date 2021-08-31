package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.model.Satelite;
import com.example.easynotes.repository.ISateliteRepository;

@Service
public class SateliteServiceImpl implements ISateliteService {

	@Autowired
	private ISateliteRepository sateliteRepository;

	@Override
	@Transactional
	public List<Satelite> findAll() {
		// TODO Auto-generated method stub
		return (List<Satelite>) sateliteRepository.findAll();
	}

	public Satelite findByName_Satelite(String idsatelite) {

		return sateliteRepository.findByName_Satelite(idsatelite);
	}

}
