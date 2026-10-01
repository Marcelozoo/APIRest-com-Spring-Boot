package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.output.TarefaOutput;
import dio.taskmanager.demo.domain.TarefaId;
import dio.taskmanager.demo.domain.TarefaNaoEncontradaException;
import dio.taskmanager.demo.domain.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObterTodasTarefaUseCase {

    private final TarefaRepository repository;

    public ObterTodasTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<TarefaOutput> execute(){
        return repository.listarTodos().stream().map(TarefaOutput::from).toList();
    }
}
