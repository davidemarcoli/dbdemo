package de.davidemarcoli.dbdemo.Person;

import de.davidemarcoli.dbdemo.jpa.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getById(Integer id);
    Person save(Person person);
    void delete(Integer id);
}
