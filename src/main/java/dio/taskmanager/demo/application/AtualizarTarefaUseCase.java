package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.input.AtualizarTarefaInput;
import dio.taskmanager.demo.application.input.CriarTarefaInput;
import dio.taskmanager.demo.application.output.TarefaOutput;
import dio.taskmanager.demo.domain.TarefaId;
import dio.taskmanager.demo.domain.TarefaNaoEncontradaException;
import dio.taskmanager.demo.domain.TarefaRepository;
import org.springframework.stereotype.Service;


@Service
public class AtualizarTarefaUseCase {

    private final TarefaRepository repository;

    public AtualizarTarefaUseCase (TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaOutput execute(TarefaId id, AtualizarTarefaInput input){
        var tarefa = repository.buscarPorId(id).orElseThrow(() -> new TarefaNaoEncontradaException(id));
        tarefa.atualizar(input.titulo(), input.descricao(), input.status());
        repository.salvar(tarefa);
        return TarefaOutput.from(tarefa);

    }
}
