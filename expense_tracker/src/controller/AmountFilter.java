package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class AmountFilter implements TransactionFilter{
    double amount;
    AmountFilter(double amount){
        this.amount =amount;
    }
   public List<Transaction> filter(List<Transaction> transactions){

        List<Transaction> fileTransactions=new ArrayList<>();

        for(Transaction t: transactions){
            if(t.getAmount()==amount){
                fileTransactions.add(t);
            }
        }
        return fileTransactions;
    }
}
