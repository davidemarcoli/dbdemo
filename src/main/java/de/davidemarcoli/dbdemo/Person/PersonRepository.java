package de.davidemarcoli.dbdemo.Person;

import de.davidemarcoli.dbdemo.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
