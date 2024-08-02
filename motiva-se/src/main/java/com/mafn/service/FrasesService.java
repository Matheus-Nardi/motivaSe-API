package com.mafn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mafn.models.Frase;
import com.mafn.repository.AutoresRepository;
import com.mafn.repository.FrasesRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FrasesService {

    private FrasesRepository frasesRepository;

    private AutoresRepository autoresRepository;

    @Autowired
    public FrasesService(FrasesRepository frasesRepository, AutoresRepository autoresRepository) {
        this.frasesRepository = frasesRepository;
        this.autoresRepository = autoresRepository;
    }

    public Frase salvarFrase(Frase frase) {
        log.info("Salvando frase [{}]", frase.getTexto());
        autoresRepository.save(frase.getAutor());
        return frasesRepository.save(frase);
    }

    public Optional<Frase> obterFrasePorId(Integer id) {
        log.info("Obtendo a frase de id [{}]", id);
        return frasesRepository.findById(id);
    }

    public boolean deletarFrase(Integer id) {
        Optional<Frase> fraseOptional = this.obterFrasePorId(id);
        if (!fraseOptional.isEmpty()) {
            log.info("Frase de id [{}] deletada", id);
            frasesRepository.delete(fraseOptional.get());
            return true;
        }
        log.info("Frase de id [{}] não encontrada", id);
        return false;
    }

    public Optional<Frase> atualizarFrase(Integer id, Frase fraseUpdate) {
        Optional<Frase> fraseOptional = this.obterFrasePorId(id);
        if (!fraseOptional.isEmpty()) {
            log.info("Frase de id [{}] encontrada e será atualizada", id);
            Frase fraseFromDb = fraseOptional.get();

            if (fraseUpdate.getTexto() != null) {
                fraseFromDb.setTexto(fraseUpdate.getTexto());
            }
            if (fraseUpdate.getAutor() != null) {
                fraseFromDb.setAutor(fraseUpdate.getAutor());
            }

            frasesRepository.save(fraseFromDb);
            return Optional.of(fraseFromDb);
        }
        return Optional.empty();
    }

}
