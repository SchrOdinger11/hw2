import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.AmountFilter;
import controller.CategoryFilter;
import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
import model.Transaction;
import controller.InputValidation;
import java.util.List;


public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });



    //add Transaction button
    view.getFilterBtn().addActionListener(e ->{
      double amount = view.getAmountField();
      String category = view.getCategoryField();

      // set the relevant strategy object here

      if(InputValidation.isValidAmount(amount) && InputValidation.isValidCategory(category)){
        //Call the filter for amount and category
      }
      else if(InputValidation.isValidAmount(amount)){
        AmountFilter am = new AmountFilter(amount);
        controller.setFilterStrategy(am);
      }
      else{
        CategoryFilter am = new CategoryFilter(category);
        controller.setFilterStrategy(am);
      
      }

      // execute the strategy method

      List<Integer> t1 = controller.run_filter(model.getTransactions());
      // System.out.println(t1.size());
      view.showFilter(t1);
      

    });

  }

}