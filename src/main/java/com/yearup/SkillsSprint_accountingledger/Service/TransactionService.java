package com.yearup.SkillsSprint_accountingledger.Service;

import com.yearup.SkillsSprint_accountingledger.Repository.TransactionRepository;
import com.yearup.SkillsSprint_accountingledger.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Integer id){
        return transactionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public List<Transaction> listByCategoryId(int categoryId) {
        return transactionRepository.findByCategoryId(categoryId);
    }

    public List<Transaction> getDeposits(){
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction> deposits = new ArrayList<>();
        for(Transaction transaction : transactions){
            if(transaction.getAmount() > 0){
                deposits.add(transaction);
            }
        }
        return deposits;
    }

    public List<Transaction> getPayments(){
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction> payments = new ArrayList<>();
        for(Transaction transaction : transactions){
            if(transaction.getAmount() % 2 < 0){
                payments.add(transaction);
            }
        }
        return payments;
    }

    public List<Transaction> searchByVendor(String vendor){
        return transactionRepository.findAll().stream()
                .filter(t ->t.getVendor().toLowerCase().contains(vendor.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Transaction> searchByDateRange(LocalDateTime start, LocalDateTime end){
        return transactionRepository.findAll().stream()
                .filter(t -> t.getDate().isAfter(start) && t.getDate().isBefore(end))
                .collect(Collectors.toList());
    }

    public Transaction updateTransaction(Integer id, Transaction updatedTransaction){
        Transaction existing = getTransactionById(id);
        existing.setDescription(updatedTransaction.getDescription());
        existing.setVendor(updatedTransaction.getVendor());
        existing.setAmount(updatedTransaction.getAmount());
        existing.setDate(updatedTransaction.getDate());
        return transactionRepository.save(existing);
    }

    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);

    }

    public void deleteTransaction(Integer id){
        transactionRepository.deleteById(id);
    }

}
