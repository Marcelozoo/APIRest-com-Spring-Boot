package dio.taskmanager.demo.application;

import dio.taskmanager.demo.application.output.TarefaOutput;
import dio.taskmanager.demo.domain.TarefaId;
import dio.taskmanager.demo.domain.TarefaNaoEncontradaException;
import dio.taskmanager.demo.domain.TarefaRepository;
import org.springframework.stereotype.Service;


@Service
public class ObterTarefaPeloIdUseCase {

    private final TarefaRepository repository;

    public ObterTarefaPeloIdUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaOutput execute(TarefaId id){
        return repository.buscarPorId(id).map(TarefaOutput::from).orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }
}
