package dio.taskmanager.demo.infrastructure.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dio.taskmanager.demo.application.output.TarefaOutput;
import dio.taskmanager.demo.domain.Tarefa;


@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TarefaResponse(String id, String titulo, String descricao, String status) {

    public static TarefaResponse from(TarefaOutput output){
        return new TarefaResponse(output.id(),
                output.titulo(),
                output.descricao().orElse(null),
                output.status() );
    }
}
