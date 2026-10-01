package dio.taskmanager.demo.infrastructure.http;


import dio.taskmanager.demo.application.*;
import dio.taskmanager.demo.domain.TarefaId;
import dio.taskmanager.demo.infrastructure.http.request.AtualizaTarefaRequest;
import dio.taskmanager.demo.infrastructure.http.request.CriarTarefaRequest;
import dio.taskmanager.demo.infrastructure.http.response.TarefaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final CriarTarefaUseCase criarTarefaUseCase;
    private final ObterTodasTarefaUseCase obterTodasTarefaUseCase;
    private final ObterTarefaPeloIdUseCase obterTarefaPeloIdUseCase;
    private final DeletarTarefaUseCase deletarTarefaUseCase;
    private final AtualizarTarefaUseCase atualizarTarefaUseCase;

    public TarefaController(CriarTarefaUseCase useCase,
                            ObterTodasTarefaUseCase obterTodasTarefaUseCase,
                            ObterTarefaPeloIdUseCase obterTarefaPeloIdUseCase,
                            DeletarTarefaUseCase deletarTarefaUseCase,
                            AtualizarTarefaUseCase atualizarTarefaUseCase) {

        this.criarTarefaUseCase = useCase;
        this.obterTodasTarefaUseCase = obterTodasTarefaUseCase;
        this.obterTarefaPeloIdUseCase = obterTarefaPeloIdUseCase;
        this.deletarTarefaUseCase = deletarTarefaUseCase;
        this.atualizarTarefaUseCase = atualizarTarefaUseCase;
    }

    @PostMapping
    TarefaResponse criar(@RequestBody @Valid CriarTarefaRequest requisicao){
        var input = requisicao.toInput();
        var output = criarTarefaUseCase.execute(input);

        return TarefaResponse.from(output);

    }

    @GetMapping
    List<TarefaResponse> obter(){
        return obterTodasTarefaUseCase.execute().stream().map(TarefaResponse::from).toList();
    }

    @GetMapping("/{id}")
    TarefaResponse obterPeloId(@PathVariable UUID id){
        var output = obterTarefaPeloIdUseCase.execute(new TarefaId(id));
        return TarefaResponse.from(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletar(@PathVariable UUID id){
        deletarTarefaUseCase.execute(new TarefaId(id));

    }

    @PatchMapping("/{id}")
    TarefaResponse atualizar(@PathVariable UUID id, @RequestBody AtualizaTarefaRequest requisicao){

        var input = requisicao.toInput();
        var output = atualizarTarefaUseCase.execute(new TarefaId(id), input);

        return TarefaResponse.from(output);

    }

}
