package br.com.paula.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository repository;

    @PostMapping
    public CategoriaResponse inncluir(@RequestBody @Valid CategoriaRequest request){

        Categoria categoria = request.toModel();

        categoria = repository.save(categoria);

        return new CategoriaResponse(categoria);
    }






}
