package dio.taskmanager.demo.infrastructure.http.request;

import dio.taskmanager.demo.application.input.AtualizarTarefaInput;
import dio.taskmanager.demo.domain.TarefaStatus;

import java.util.Optional;

public record AtualizaTarefaRequest(
        Optional<String> titulo,
        Optional<String> descricao,
        Optional<String> status) {

    public AtualizarTarefaInput toInput(){
        return new AtualizarTarefaInput(titulo, descricao, status.map(TarefaStatus::valueOf));
    }
}
