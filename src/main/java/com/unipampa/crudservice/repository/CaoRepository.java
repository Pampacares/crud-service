package com.unipampa.crudservice.repository;

import com.unipampa.crudservice.model.Cao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaoRepository extends JpaRepository<Cao, Long> {
}
