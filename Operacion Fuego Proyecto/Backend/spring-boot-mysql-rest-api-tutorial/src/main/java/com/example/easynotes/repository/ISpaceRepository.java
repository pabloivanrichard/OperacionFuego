package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.easynotes.model.Space;

@Repository
public interface ISpaceRepository extends JpaRepository<Space, Long> {

}
