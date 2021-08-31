package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.easynotes.model.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long> {
	// @Query("select p from position p where p.satelite_id_satelite=?")
	@Query(value = "SELECT * FROM position WHERE satelite_id_satelite = ?1", nativeQuery = true)
	public Position findByidSatelite(long idsatelite);

}
