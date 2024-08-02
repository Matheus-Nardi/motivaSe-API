package com.mafn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mafn.dto.ResponseFraseDTO;
import com.mafn.models.Frase;
import com.mafn.service.FrasesService;

@Controller
@RequestMapping(value = "/frases")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FrasesController {

    private FrasesService frasesService;

    @Autowired
    public FrasesController(FrasesService frasesService) {
        this.frasesService = frasesService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Frase> salvarFrase(@RequestBody Frase frase) {
        Frase fraseSalva = frasesService.salvarFrase(frase);
        return ResponseEntity.ok(fraseSalva);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<ResponseFraseDTO> obterFrasePorId(@PathVariable Integer id) {
        Optional<Frase> fraseByIdOptional = frasesService.obterFrasePorId(id);
        if (!fraseByIdOptional.isEmpty()) {
            Frase frase = fraseByIdOptional.get();
            ResponseFraseDTO fraseDTO = new ResponseFraseDTO(frase);
            return ResponseEntity.ok(fraseDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Frase> deletarFrase(@PathVariable Integer id) {
        boolean sucessoAoDeletar = frasesService.deletarFrase(id);
        if (sucessoAoDeletar) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Frase> atualizarFrase(@PathVariable Integer id, @RequestBody Frase fraseUpdate) {
        Optional<Frase> fraseOptional = frasesService.atualizarFrase(id, fraseUpdate);
        if (!fraseOptional.isEmpty()) {
            return ResponseEntity.ok(fraseOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
