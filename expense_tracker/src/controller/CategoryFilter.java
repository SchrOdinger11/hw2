package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class CategoryFilter implements TransactionFilter{
        
    String cat;
    public CategoryFilter(String cat){
        this.cat =cat;
    }

    public List <Integer> filter(List<Transaction> transactions){

        List <Integer> fileTransactions=new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {

            if(transactions.get(i).getCategory().equals(cat)){
                fileTransactions.add(i);
            }

        }

        return fileTransactions;
    }

}


