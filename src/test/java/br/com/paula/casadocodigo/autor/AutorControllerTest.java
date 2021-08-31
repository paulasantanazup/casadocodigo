package br.com.paula.casadocodigo.autor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class AutorControllerTest {

    @Mock
    AutorRepository repository;

    @InjectMocks
    AutorController autorController;


    @Test
    public void quandoIncluirAutorCorretamenteDeveRetornarComIdEDataDeCriacao(){
        //Arrange

        Long id = 123L;

        AutorRequest request =
                new AutorRequest(
                        "Paulo Coelho",
                        "paulo@paulocoelho.com",
                        "Escritor famoso");

        Autor autorBanco = new Autor(request.getNome(), request.getEmail(), request.getDescricao(),id );

        LocalDate dataAtual = LocalDate.now();

        Mockito.when(repository.save(Mockito.any(Autor.class))).thenReturn(autorBanco);

        //Act
        AutorResponse response =  autorController.incluir(request);

        //Assert
        Assert.hasText(response.getNome(),"Paulo Coelho");
        Assertions.assertThat(response.getCriacao()).isNotNull();
        Assertions.assertThat(response.getCriacao()).isEqualTo(dataAtual);
        Assertions.assertThat(response.getId()).isNotNull();
        Assertions.assertThat(response.getId()).isEqualTo(id);

    }
}
