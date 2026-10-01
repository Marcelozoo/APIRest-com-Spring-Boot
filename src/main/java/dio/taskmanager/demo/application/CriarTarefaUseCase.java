package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.input.CriarTarefaInput;
import dio.taskmanager.demo.application.output.TarefaOutput;

import dio.taskmanager.demo.domain.Tarefa;
import dio.taskmanager.demo.domain.TarefaRepository;
import org.springframework.stereotype.Service;


@Service
public class CriarTarefaUseCase {

    private final TarefaRepository repository;


    public CriarTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    TarefaOutput execute(CriarTarefaInput input){
        var tarefa = new Tarefa(input.titulo(), input.descricao());
        var tarefaSalva = repository.salvar(tarefa);

        return TarefaOutput.from(tarefaSalva);

    }
}
