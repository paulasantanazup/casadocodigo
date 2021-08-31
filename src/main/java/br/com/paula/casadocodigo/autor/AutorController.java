package br.com.paula.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository repository;

    @PostMapping
    public AutorResponse incluir(@RequestBody @Valid AutorRequest request){

        Autor autor = request.toModel();

        autor = repository.save(autor);

        return new AutorResponse(autor);
    }

}
