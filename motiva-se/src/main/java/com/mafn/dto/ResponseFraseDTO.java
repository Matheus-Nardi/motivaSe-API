package com.mafn.dto;

import com.mafn.models.Frase;

import lombok.Data;

@Data
public class ResponseFraseDTO {
    private String texto;
    private String autor;

    public ResponseFraseDTO(Frase frase){
        this.texto = frase.getTexto();
        this.autor = frase.getAutor().getNome();
    }
}
