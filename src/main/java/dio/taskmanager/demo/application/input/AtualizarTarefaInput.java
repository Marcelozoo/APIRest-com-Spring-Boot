package dio.taskmanager.demo.application.input;

import dio.taskmanager.demo.domain.TarefaStatus;

import java.util.Optional;

public record AtualizarTarefaInput (Optional<String> titulo,
                                    Optional<String> descricao,
                                    Optional<TarefaStatus> status){

}
