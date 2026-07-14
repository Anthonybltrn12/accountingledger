package com.yearup.SkillsSprint_accountingledger.Service;

import com.yearup.SkillsSprint_accountingledger.Repository.TransactionRepository;
import com.yearup.SkillsSprint_accountingledger.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Transaction getTransactionById(int id){
        return transactionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public List<Transaction> searchByVendor(String vendor){
        return transactionRepository.findAll().stream()
                .filter(t ->t.getVendor().toLowerCase().contains(vendor.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Transaction> searchByDateRange(LocalDateTime start, LocalDateTime end){
        return transactionRepository.findAll().stream()
                .filter(t -> t.getTransactionDate().isAfter(start) && t.getTransactionDate().isBefore(end))
                .collect(Collectors.toList());
    }

    public Transaction updateTransaction(int id, Transaction updatedTransaction){
        Transaction existing = getTransactionById(id);
        existing.setDescription(updatedTransaction.getDescription());
        existing.setVendor(updatedTransaction.getVendor());
        existing.setAmount(updatedTransaction.getAmount());
        return transactionRepository.save(existing);
    }

    public void deleteTransaction(int id){
        transactionRepository.deleteById(id);
    }

}
