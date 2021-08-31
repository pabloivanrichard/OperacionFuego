package com.example.easynotes.service;

import java.util.List;
import com.example.easynotes.model.Satelite;


public interface ISateliteService {
	public List<Satelite> findAll();

	public Satelite findByName_Satelite(String idsatelite);
}
