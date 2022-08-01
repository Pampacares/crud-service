package com.unipampa.crudservice.repository;

import com.unipampa.crudservice.model.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SintomaRespository extends JpaRepository<Sintoma, Long> {
}
