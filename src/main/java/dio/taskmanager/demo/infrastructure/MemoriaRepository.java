package dio.taskmanager.demo.infrastructure;

import dio.taskmanager.demo.domain.Tarefa;
import dio.taskmanager.demo.domain.TarefaId;
import dio.taskmanager.demo.domain.TarefaRepository;

import java.util.*;

public class MemoriaRepository implements TarefaRepository {
    private final Map<TarefaId, Tarefa> armazenamento = new HashMap<>();

    @Override
    public Tarefa salvar(Tarefa tarefa) {
        armazenamento.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    @Override
    public List<Tarefa> listarTodos() {
        return new ArrayList<>(armazenamento.values());
    }

    @Override
    public Optional<Tarefa> buscarPorId(TarefaId id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    @Override
    public void deletar(TarefaId id) {
        armazenamento.remove(id);

    }
}
