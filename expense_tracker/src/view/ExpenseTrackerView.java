package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableModel;

import controller.ExpenseTrackerController;
import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;
import model.ExpenseTrackerModel;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;


public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  JButton applyFilterBtn;
  private JFormattedTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  
private String selectedAmountFilter = "All";
private String selectedCategoryFilter = "All";
JComboBox<String> categoryFilterComboBox;
 JComboBox<String> amountFilterComboBox;

//List<Transaction> transactions = model.getTransactions();

  public ExpenseTrackerView() {
    
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
   // System.out.println("Size of transaction is "+transactions.size());

    String[] columnNames = {"serial", "Amount", "Category", "Date"};
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);

    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    // Create table
    transactionsTable = new JTable(model);

    
  // Create a button to apply the filter
    applyFilterBtn = new JButton("Apply Filter");
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
   

  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
    buttonPanel.add(applyFilterBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);


    //filter by amount and category:

    // Add combo boxes for filter selection



  // Add action listeners to the combo boxes and button
// amountFilterComboBox.addActionListener(e -> handleAmountFilterSelection((String) amountFilterComboBox.getSelectedItem()));
// categoryFilterComboBox.addActionListener(e -> handleCategoryFilterSelection((String) categoryFilterComboBox.getSelectedItem()));
// applyFilterBtn.addActionListener(e -> applyFilter(transactions,selectedAmountFilter,selectedCategoryFilter));

    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }






// Handle the selection of the category filter


  public void refreshTable(List<Transaction> transactions) {
      // Clear existing rows
      model.setRowCount(0);
      // Get row count
      int rowNum = model.getRowCount();
      double totalCost=0;
      // Calculate total cost
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()}); 
      }
        // Add total row
        Object[] totalRow = {"Total", null, null, totalCost};
        model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  
  
 public void applyFilter(List<Transaction> transactions, String amountFilter, String categoryFilter) {
    List<Transaction> filteredTransactions = filterTransactions(transactions, amountFilter, categoryFilter);
   
    
   refreshTable(filteredTransactions);
}
private List<Transaction> filterTransactions(List<Transaction> transactions, String amountFilter, String categoryFilter) {
    List<Transaction> filteredTransactions = new ArrayList<>();

    for (Transaction transaction : transactions) {
       System.out.println("bhaaa yaar");
        if (isAmountFilterMatch(transaction, amountFilter) && isCategoryFilterMatch(transaction, categoryFilter)) {
         
            filteredTransactions.add(transaction);
        }
    }

    return filteredTransactions;
}

private boolean isAmountFilterMatch(Transaction transaction, String amountFilter) {
  
   System.out.println("bhaiiii yaar");
    if ("All".equals(amountFilter)) {
        System.out.println("bhaiiii");
        return true;
    } else if ("Less than 100".equals(amountFilter) && transaction.getAmount() < 100) {
        System.out.println("bhaiiii "+transaction.getAmount());
        return true;
    } else if ("More than 100".equals(amountFilter) && transaction.getAmount() > 100) {
        System.out.println("bhaiiii");
        return true;
    }

    return false;
}

private boolean isCategoryFilterMatch(Transaction transaction, String categoryFilter) {
    return "All".equals(categoryFilter) || transaction.getCategory().equals(categoryFilter);
}




  
  
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }
    public JButton getFilterBtn() {
    return applyFilterBtn;
  }
  public DefaultTableModel getTableModel() {
    return model;
  }
  // Other view methods
    public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  
  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }
}
