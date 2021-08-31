package br.com.paula.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroResponse {

    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private int paginas;

    private String isbn;

    private LocalDate publicacao;

    private Long idCategoria;

    private Long idAutor;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.publicacao = livro.getPublicacao();
        this.idCategoria = livro.getCategoria().getId();
        this.idAutor = livro.getAutor().getId();
    }
}
