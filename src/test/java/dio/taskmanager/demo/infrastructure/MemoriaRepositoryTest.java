package dio.taskmanager.demo.infrastructure;


import dio.taskmanager.demo.domain.TarefaRepository;
import dio.taskmanager.demo.domain.TarefaRepositoryTest;
import org.junit.jupiter.api.BeforeEach;


class MemoriaRepositoryTest  extends TarefaRepositoryTest {



    @Override
    protected  TarefaRepository criarRepository(){
        return new MemoriaRepository();
    }




}