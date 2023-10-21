package controller;
import view.ExpenseTrackerView;
import java.util.ArrayList;
import java.util.List;
import model.ExpenseTrackerModel;
import model.Transaction;


public class ExpenseTrackerController {
  
  private  ExpenseTrackerModel model;
  private ExpenseTrackerView view;
  private TransactionFilter tr_filter;


  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }
 
  public void setFilterStrategy(TransactionFilter tf){

    this.tr_filter = tf;
    
  }


  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }
  public void applyFilter(List <Transaction> li){

    List <Integer> ret_li = tr_filter.filter(li);
    view.showFilter(ret_li);
    refresh();

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