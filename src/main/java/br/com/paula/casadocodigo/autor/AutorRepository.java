package br.com.paula.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByEmail(String email);

    @Query("SELECT * FROM AUTHOR WHERE nome LIKE ':nome%'")
    List<Autor> findAuthorsByName(@Param("nome") String nome);

    List<Autor> findByNomeContains(@Param("nome") String nome);
}
