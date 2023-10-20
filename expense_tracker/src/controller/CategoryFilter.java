package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class CategoryFilter {
        String cat;
    CategoryFilter(String cat){
        this.cat =cat;
    }
   public List<Transaction> filter(List<Transaction> transactions){

        List<Transaction> fileTransactions=new ArrayList<>(null);

        for(Transaction t: transactions){
            if(t.getCategory().equals(cat)){
                fileTransactions.add(t);
            }
        }
        return fileTransactions;
    }
}


