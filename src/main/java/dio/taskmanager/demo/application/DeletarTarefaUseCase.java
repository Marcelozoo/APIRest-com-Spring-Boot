package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.input.CriarTarefaInput;
import dio.taskmanager.demo.domain.TarefaId;
import dio.taskmanager.demo.domain.TarefaNaoEncontradaException;
import dio.taskmanager.demo.domain.TarefaRepository;
import org.springframework.stereotype.Service;


@Service
public class DeletarTarefaUseCase {

    private final TarefaRepository repository;

    public DeletarTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public void execute(TarefaId id){
        if (repository.buscarPorId(id).isEmpty()) {
            throw new TarefaNaoEncontradaException(id);
        }

        repository.deletar(id);

    }
}
