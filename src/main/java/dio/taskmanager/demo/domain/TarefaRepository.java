package dio.taskmanager.demo.domain;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository {

    Tarefa salvar(Tarefa tarefa);
    List<Tarefa> listarTodos();
    Optional<Tarefa> buscarPorId(TarefaId id);
    void deletar(TarefaId id);



}
