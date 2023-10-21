package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class AmountFilter implements TransactionFilter{

    double amount;
    public AmountFilter(double amount){
        this.amount =amount;
    }

   public List <Integer> filter(List<Transaction> transactions){

        List <Integer> fileTransactions=new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {

            if(transactions.get(i).getAmount()==amount){
                fileTransactions.add(i);
            }

        }

        return fileTransactions;
    }
}
