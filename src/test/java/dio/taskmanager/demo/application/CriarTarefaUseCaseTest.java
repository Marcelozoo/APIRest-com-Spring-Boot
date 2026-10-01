package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.input.CriarTarefaInput;
import dio.taskmanager.demo.domain.Tarefa;
import dio.taskmanager.demo.domain.TarefaRepository;
import dio.taskmanager.demo.infrastructure.MemoriaRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CriarTarefaUseCaseTest {


    @InjectMocks
    CriarTarefaUseCase useCase;
    @Mock
    TarefaRepository repository;

//    injecao de dependencia manual sem o spring
//    @BeforeEach
//    void setUp(){
//        useCase = new CriarTarefaUseCase(new MemoriaRepository());
//    }

    @Test
    void deveCriarTarefaComSucesso(){
        var input = new CriarTarefaInput("Tarefa 1", Optional.of("Descricao tarefa 1"));

        Mockito.when(repository.salvar(ArgumentMatchers.any(Tarefa.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var output = useCase.execute(input);


        Assertions.assertNotNull(output);
        Assertions.assertNotNull(output);
        Assertions.assertNotNull(output.id());
        Assertions.assertEquals("Tarefa 1", output.titulo());
        Assertions.assertEquals(Optional.of("Descricao tarefa 1"), output.descricao());

        Mockito.verify(repository, Mockito.timeout(1)).salvar(ArgumentMatchers.any(Tarefa.class));

    }

}