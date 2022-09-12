package de.davidemarcoli.dbdemo.Person;

import de.davidemarcoli.dbdemo.jpa.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @GetMapping("all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("{id}")
    public Person getPersonById(@RequestParam("id") Integer id) {
        return personService.getById(id);
    }

    @PostMapping("")
    public Person savePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @DeleteMapping("")
    public void deletePerson(@RequestBody Integer id) {
        personService.delete(id);
    }

}
