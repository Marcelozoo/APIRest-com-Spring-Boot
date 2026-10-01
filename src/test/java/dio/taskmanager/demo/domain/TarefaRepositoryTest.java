package dio.taskmanager.demo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public abstract class TarefaRepositoryTest {

    TarefaRepository repository;

    protected abstract TarefaRepository criarRepository();

    @BeforeEach
    public void setUp() {
        this.repository = criarRepository();

    }


    @Test
    void deveSalvarERetornarTarefaPeloId(){
        var tarefa1 = new Tarefa("Tarefa 1", Optional.empty());


        var salvada = repository.salvar(tarefa1);
        Optional<Tarefa> resultado = repository.buscarPorId(salvada.getId());


        Assertions.assertThat(resultado).isPresent();
        Assertions.assertThat(resultado.get().getId()).isEqualTo(tarefa1.getId());
        Assertions.assertThat(resultado.get().getDescricao()).isEqualTo(tarefa1.getDescricao());
        Assertions.assertThat(resultado.get().getStatus()).isEqualTo(tarefa1.getStatus());



    }

    @Test
    void deveRetornarTodasAsTarefasPersistidas() {

        //give
        var tarefa1 = new Tarefa("Tarefa 1", Optional.of("A tarefa 1 do teste"));
        var tarefa2 = new Tarefa("Tarefa 2", Optional.of("A tarefa 2 do teste"));



        repository.salvar(tarefa1);
        repository.salvar(tarefa2);

        //when
        List<Tarefa> tarefas = repository.listarTodos();

        //then

        Assertions.assertThat(tarefas).hasSize(2);
        Assertions.assertThat(tarefas).extracting(Tarefa::getId).containsExactlyInAnyOrder(tarefa1.getId(), tarefa2.getId());


    }



    @Test
    void deveDeletarTarefaPeloId(){
        var tarefa1 = new Tarefa("Tarefa 1", null);

        repository.deletar(tarefa1.getId());


        Optional<Tarefa> resultado = repository.buscarPorId(tarefa1.getId());
        Assertions.assertThat(resultado).isEmpty();

    }

    @Test
    void deveRetornarVazioParaBuscaDeTarefaInexistente(){
        var nExisteId = new TarefaId();


        Optional<Tarefa> resultado = repository.buscarPorId(nExisteId);


        Assertions.assertThat(resultado).isEmpty();

    }

    @Test
    void deveAtualizarStatusDaTarefa(){
        var tarefa1 = new Tarefa("Tarefa 1", Optional.of("Descricao da Tarefa 1"));

        tarefa1.setStatus(TarefaStatus.EM_PROGRESSO);


        repository.salvar(tarefa1);

        Optional<Tarefa> resultado = repository.buscarPorId(tarefa1.getId());


        Assertions.assertThat(resultado).isPresent();
        Assertions.assertThat(resultado.get().getDescricao()).isEqualTo(tarefa1.getDescricao());
        Assertions.assertThat(resultado.get().getStatus()).isEqualTo(tarefa1.getStatus());



    }
}