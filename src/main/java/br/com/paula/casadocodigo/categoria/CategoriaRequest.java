package br.com.paula.casadocodigo.categoria;

import br.com.paula.casadocodigo.commons.validation.Unique;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @Unique(fieldName = "nome", domainClass = Categoria.class)
    private String nome;

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
