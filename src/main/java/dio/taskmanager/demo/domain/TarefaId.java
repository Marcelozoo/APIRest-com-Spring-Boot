package dio.taskmanager.demo.domain;


import org.springframework.util.Assert;

import java.util.UUID;

// uso do record e bom pq ele é imuutável
public record TarefaId(UUID id) {


    public TarefaId {
        Assert.notNull(id,"ID não pode ser null!");
    }

    public TarefaId (){
        this(UUID.randomUUID());
    }

}
