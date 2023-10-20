package controller;

import view.ExpenseTrackerView;

import java.util.ArrayList;
import java.util.List;



import model.ExpenseTrackerModel;
import model.Transaction;
public class ExpenseTrackerController {
  
  private  ExpenseTrackerModel model;
  private ExpenseTrackerView view;
  InputValidation inputValidation;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view, InputValidation in) {
    this.model = model;
    this.view = view;
    inputValidation=in;

    // Set up view event handlers
  }
 

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }
  public void filterByTheAmountandCategory(double amount, String cat){
    if(inputValidation.isValidAmount(amount) && inputValidation.isValidCategory(cat)){
      //Call the filter for amount and category
    }
    else if(inputValidation.isValidAmount(amount)){
      AmountFilter am=new AmountFilter(amount);
     List<Transaction> t1= am.filter(model.getTransactions());
     System.out.println(t1.size());
     //paintt1
     
    }
    else{
       CategoryFilter am=new CategoryFilter(cat);
       List<Transaction>t2=am.filter(model.getTransactions());
       //paintt1
    }

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }
  
  // Other controller methods
}