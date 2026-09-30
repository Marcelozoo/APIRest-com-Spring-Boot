package dio.taskmanager.demo.domain;

import org.springframework.util.Assert;

import java.util.Optional;

public class Tarefa {

    private TarefaId id;
    private String titulo;
    private Optional<String> descricao;
    private TarefaStatus status;



    public Tarefa(String titulo, Optional<String> descricao){
        Assert.notNull(titulo, "Propriedade Título não pode ser null!");

        this.titulo = titulo;
        this.descricao = descricao;
        this.status = TarefaStatus.PENDENTE;
    }


}
