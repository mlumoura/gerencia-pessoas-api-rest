package one.digitalinnovation.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonCpfNotFoundException extends Exception {
    public PersonCpfNotFoundException(String cpf) {
        super(String.format("Person with cpf %s not found!", cpf));
    }
}