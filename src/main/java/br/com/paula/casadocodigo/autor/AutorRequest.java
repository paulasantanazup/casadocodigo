package br.com.paula.casadocodigo.autor;

import br.com.paula.casadocodigo.commons.validation.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank(message = "O Campo nome é obrigatório")
    private String nome;

    @Email(message = "Formato de e-mail inválido")
    @NotBlank(message = "O campo e-mail é obrigatório")
    @Unique(fieldName = "email", domainClass = Autor.class)
    private String email;

    @NotBlank(message = "O campo descricao é obrigatório")
    @Size(max = 400, message = "A descrição não pode exceder 400 caracteres")
    private String descricao;


    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(){
        return new Autor(this.nome,this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
