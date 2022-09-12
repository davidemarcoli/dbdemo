package de.davidemarcoli.dbdemo.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Transaction {
    private Integer fromId;
    private Integer toId;
    private double amount;
    private boolean doesFail = false;
}
