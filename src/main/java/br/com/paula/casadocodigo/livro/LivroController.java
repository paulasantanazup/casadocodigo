package br.com.paula.casadocodigo.livro;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    LivroRepository repository;

    @PostMapping
    public LivroResponse incluir(@RequestBody @Valid LivroRequest request){
        Livro livro = request.toModel(entityManager);

        livro = repository.save(livro);

        return new LivroResponse(livro);
    }

    @GetMapping
    public List<LivroResponseLista> lista( @PageableDefault(page = 0, size = 10) Pageable page){

        List<Livro> livros = repository.findAll(page).getContent();

        return livros.stream()
                .map(l -> new LivroResponseLista(l.getId(), l.getTitulo()))
                .collect(Collectors.toList());
    }
}
