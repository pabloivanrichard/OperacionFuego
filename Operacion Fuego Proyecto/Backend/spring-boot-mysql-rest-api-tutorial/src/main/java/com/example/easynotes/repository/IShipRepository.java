package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.easynotes.model.Ship;

@Repository
public interface IShipRepository extends JpaRepository<Ship, Long> {

}
