package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonCpfNotFoundException;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")

public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // BUSCA POR ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    //@RequestMapping(value = "/cpf/cpf}", method = RequestMethod.GET)
    // mesmo assim erro de Ambiguous handler methods mapped for HTTP path
    // Mas a opção está operacional
    // BUSCA POR CPF
    /*
    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> findByCpf(@PathVariable String cpf) throws PersonCpfNotFoundException {
        return personService.findByCpf(cpf);
    }
*/
    // BUSCA ALL
    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    // INSERE PESSOA
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    // DELETA PESSOA
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}




