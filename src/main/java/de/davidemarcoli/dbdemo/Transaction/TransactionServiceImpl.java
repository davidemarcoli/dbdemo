package de.davidemarcoli.dbdemo.Transaction;

import de.davidemarcoli.dbdemo.Person.PersonServiceImpl;
import de.davidemarcoli.dbdemo.jpa.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final PersonServiceImpl personService;


    @Override
    @Transactional
    public void makeTransaction(Transaction transaction) {
        Person personFrom = personService.getById(transaction.getFromId());
        Person personTo = personService.getById(transaction.getToId());

        if (personFrom.getMoney() < transaction.getAmount()) {
            throw new RuntimeException(personFrom.getName() + " has less than $" + transaction.getAmount() + " in their bank account. Transaction not possible!");
        }

        personFrom.setMoney(personFrom.getMoney() - transaction.getAmount());
        personService.save(personFrom);

        if (transaction.isDoesFail()) throw new RuntimeException("Error in transaction!");

        personTo.setMoney(personTo.getMoney() + transaction.getAmount());
        personService.save(personTo);
    }
}
