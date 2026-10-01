package dio.taskmanager.demo.domain;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(TarefaId id) {
        super(" Tarefa com \t" + id.id() + "\t não encontrada!");
    }
}
