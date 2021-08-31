package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.easynotes.model.Satelite;

@Repository
public interface ISateliteRepository extends JpaRepository<Satelite, Long> {

	@Query(value = "SELECT * FROM satelite WHERE name = ?1", nativeQuery = true)
	public Satelite findByName_Satelite(String idsatelite);

}
