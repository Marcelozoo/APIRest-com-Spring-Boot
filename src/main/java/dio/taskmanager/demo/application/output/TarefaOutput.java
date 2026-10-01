package dio.taskmanager.demo.application.output;

import dio.taskmanager.demo.domain.Tarefa;

import java.util.Optional;

public record TarefaOutput(String id, String titulo, Optional<String> descricao, String status) {

    public static TarefaOutput from(Tarefa tarefa){

        return new TarefaOutput(tarefa.getId().id().toString(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus().name());

    }
}
