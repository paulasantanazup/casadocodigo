package br.com.paula.casadocodigo.livro;

import br.com.paula.casadocodigo.autor.Autor;
import br.com.paula.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private int paginas;

    private String isbn;

    private LocalDate publicacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;


    public Livro(String titulo, String resumo, String sumario,
                 BigDecimal preco, int paginas, String isbn,
                 LocalDate publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
