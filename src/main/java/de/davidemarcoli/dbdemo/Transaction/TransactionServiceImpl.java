package de.davidemarcoli.dbdemo.Transaction;

import de.davidemarcoli.dbdemo.Person.PersonServiceImpl;
import de.davidemarcoli.dbdemo.jpa.Person;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;

@Service
@RequiredArgsConstructor
@Log
public class TransactionServiceImpl implements TransactionService{

    private final PersonServiceImpl personService;


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void makeTransaction(Transaction transaction) {

        Person personFrom = personService.getById(transaction.getFromId());
        Person personTo = personService.getById(transaction.getToId());

        log.info("Transaction started");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (personFrom.getMoney() < transaction.getAmount()) {
            throw new RuntimeException(personFrom.getName() + " has less than $" + transaction.getAmount() + " in their bank account. Transaction not possible!");
        }

        // the transaction is processing
//        if (transaction.getAmount() == 2.0) {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        personFrom.setMoney(personFrom.getMoney() - transaction.getAmount());
        personService.save(personFrom);

        if (transaction.isDoesFail()) throw new RuntimeException("Error in transaction!");

        personTo.setMoney(personTo.getMoney() + transaction.getAmount());
        personService.save(personTo);

        log.info("Transaction finished");
    }
}
