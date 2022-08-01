package com.unipampa.crudservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unipampa.crudservice.model.AmostraSintoma;
import com.unipampa.crudservice.model.AmostraSintomaId;

@Repository
public interface AmostraSintomaRepository extends JpaRepository<AmostraSintoma, AmostraSintomaId> {

    public List<AmostraSintoma> findByAmostraId(Long id);

}