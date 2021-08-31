package br.com.paula.casadocodigo.livro;

public class LivroResponseLista {

    private Long id;

    private String titulo;

    public LivroResponseLista(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
