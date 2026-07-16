// Declares the package where this controller class is located.
package com.yearup.SkillsSprint_accountingledger.Controller;

// Imports the TransactionService so the controller can use its methods.
import com.yearup.SkillsSprint_accountingledger.Service.TransactionService;

// Imports the Transaction model returned by the endpoints.
import com.yearup.SkillsSprint_accountingledger.model.Transaction;

// Allows the controller to return HTTP responses.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Imports the Spring annotations used to create the API endpoints.
import org.springframework.web.bind.annotation.*;

// Imports List because some endpoints return multiple transactions.
import java.util.List;


// Tells Spring that this class handles REST API requests.
@RestController

// Sets "/transactions" as the starting URL for every endpoint in this controller.
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:5192")
public class TransactionController {

    // Stores the TransactionService used by this controller.
    private final TransactionService transactionService;


    // Constructor injection gives the controller access to TransactionService.
    public TransactionController(TransactionService transactionService) {
        // Saves the provided service in the transactionService field.
        this.transactionService = transactionService;
    }


    // Handles GET requests sent to:
    // http://localhost:8080/transactions
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {

        // Calls the service to retrieve every transaction.
        List<Transaction> transactions =
                transactionService.getAllTransactions();

        // Returns the transactions with HTTP status 200 OK.
        return ResponseEntity.ok(transactions);
    }


    // Handles GET requests sent to:
    // http://localhost:8080/transactions/deposits
    @GetMapping("/deposits")
    public ResponseEntity<List<Transaction>> getDeposits() {

        // Calls the service to retrieve transactions with positive amounts.
        List<Transaction> deposits =
                transactionService.getDeposits();

        // Returns the deposits with HTTP status 200 OK.
        return ResponseEntity.ok(deposits);
    }


    // Handles GET requests sent to:
    // http://localhost:8080/transactions/payments
    @GetMapping("/payments")
    public ResponseEntity<List<Transaction>> getPayments() {

        // Calls the service to retrieve transactions with negative amounts.
        List<Transaction> payments =
                transactionService.getPayments();

        // Returns the payments with HTTP status 200 OK.
        return ResponseEntity.ok(payments);
    }


    // Handles GET requests containing a transaction ID, such as:
    // http://localhost:8080/transactions/1
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(
            @PathVariable int id) {

        // Calls the service to find the transaction matching the ID.
        Transaction transaction =
                transactionService.getTransactionById(id);

        // Returns the matching transaction with HTTP status 200 OK.
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/balance")
    public ResponseEntity<Integer> getBalance() {
        return ResponseEntity.ok(transactionService.liveBalance());
    }

    @PostMapping("")
    public ResponseEntity<List<Transaction>> addNewTransaction(@RequestBody List<Transaction> transaction){
        List<Transaction> created = transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable Integer userId){
         transactionService.deleteTransaction(userId);
         return ResponseEntity.noContent().build();
    }
}
