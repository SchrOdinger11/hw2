# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.


## Features

### Add Transaction

Enter a value in the ```amount``` field and the ```category``` field. <br>
The amount should be between 0 and 1000. <br>
Category should be from food, travel, bills, entertainment or other. <br>
Click the ```Add Transaction``` button to add the transaction to the table.  


### Apply Filter 
Applies filter to the displayed transaction table. <br>
To this end, the input from ```amount``` field and the ```category``` field is taken to apply filter on the transactions.<br>
Care to be taken that both amount and category are not entered for applying filter. Only one of the two fields must be entered.<br>
The filtered transactions is higlighted in green and displayed to the user.

