package com.mafn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafn.models.Frase;

public interface FrasesRepository extends JpaRepository<Frase,Integer> {


}
