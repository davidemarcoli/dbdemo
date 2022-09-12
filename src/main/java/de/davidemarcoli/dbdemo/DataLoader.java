package de.davidemarcoli.dbdemo;

import de.davidemarcoli.dbdemo.Person.PersonRepository;
import de.davidemarcoli.dbdemo.jpa.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final PersonRepository personRepository;

    public void run(ApplicationArguments args) {
        if (personRepository.findAll().isEmpty()) {
            personRepository.save(new Person(0, "Lazar Petrovic", 1, false));
            personRepository.save(new Person(0, "Davide Marcoli", 100.6, true));
        }
    }
}