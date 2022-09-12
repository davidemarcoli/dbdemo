package de.davidemarcoli.dbdemo.Person;

import de.davidemarcoli.dbdemo.jpa.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Integer id) {
        return personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }


    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
