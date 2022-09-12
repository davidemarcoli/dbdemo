package de.davidemarcoli.dbdemo.Person;

import de.davidemarcoli.dbdemo.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    // make a query that lists all persons with more than 10000$ in their account
    @Query("SELECT p FROM Person p WHERE p.money > 10000")
    List<Person> findAllRichPeople();

    List<Person> findByMoneyGreaterThanEqual(double money);


}
