package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.input.CriarTarefaInput;
import dio.taskmanager.demo.infrastructure.MemoriaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CriarTarefaUseCaseTest {
    @Autowired
    CriarTarefaUseCase useCase;

// injecao de dependencia manual sem o spring
//    @BeforeEach
//    void setUp(){
//        useCase = new CriarTarefaUseCase(new MemoriaRepository());
//    }

    @Test
    void deveCriarTarefaComSucesso(){
        var input = new CriarTarefaInput("Tarefa 1", Optional.of("Descricao tarefa 1"));


        var output = useCase.execute(input);


        Assert.assertNotNull(output);
        Assert.assertNotNull(output.id());
        Assert.assertEquals("Tarefa 1", output.titulo());
        Assert.assertEquals(Optional.of("Descricao tarefa 1"), output.descricao());

    }

}