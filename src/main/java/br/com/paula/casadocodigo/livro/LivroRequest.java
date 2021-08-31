package br.com.paula.casadocodigo.livro;

import br.com.paula.casadocodigo.autor.Autor;
import br.com.paula.casadocodigo.categoria.Categoria;
import br.com.paula.casadocodigo.commons.validation.Unique;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @Unique(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @DecimalMin(value = "20")
    private BigDecimal preco;

    @NotNull
    @Size(min = 100)
    private int paginas;

    @NotNull
    @Unique(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @FutureOrPresent
    private LocalDate publicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public Livro toModel(EntityManager manager){
        Autor autor = manager.find(Autor.class, "id" );
        Categoria categoria = manager.find(Categoria.class, "id" );

        Assert.notNull(categoria, "Categoria inexistente");
        Assert.notNull(autor, "Autor inexistente");

        return new Livro(this.titulo, this.resumo, this.sumario,
                this.preco, this.paginas, this.isbn, this.publicacao,
                categoria, autor);
    }


}
