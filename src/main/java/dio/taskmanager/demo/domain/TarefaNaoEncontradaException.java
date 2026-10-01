package dio.taskmanager.demo.domain;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(TarefaId id) {
        super("Tarefa com " + id + "não encontrada!");
    }
}
