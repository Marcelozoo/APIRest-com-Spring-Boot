package dio.taskmanager.demo.infrastructure.http;

import dio.taskmanager.demo.domain.TarefaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTarefaNaoEncontrada(TarefaNaoEncontradaException ex){
        return ex.getMessage();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidacaoException(MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();


        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String campoNome = ((FieldError) objectError).getField();
            String erroMensagem = objectError.getDefaultMessage();
            erros.put(campoNome, erroMensagem);
        });

        return erros;
    }


}
