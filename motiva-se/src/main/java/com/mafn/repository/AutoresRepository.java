package com.mafn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafn.models.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Integer> {

}
