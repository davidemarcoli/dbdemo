package de.davidemarcoli.dbdemo.Transaction;

import de.davidemarcoli.dbdemo.jpa.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction/")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    @PostMapping("")
    public void makeTransaction(@RequestBody Transaction transaction) {
       transactionService.makeTransaction(transaction);
    }
}
