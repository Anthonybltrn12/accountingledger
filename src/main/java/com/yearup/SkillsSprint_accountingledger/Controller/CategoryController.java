package com.yearup.SkillsSprint_accountingledger.Controller;


import com.yearup.SkillsSprint_accountingledger.Service.CategoryService;
import com.yearup.SkillsSprint_accountingledger.Service.TransactionService;
import com.yearup.SkillsSprint_accountingledger.model.Category;
import com.yearup.SkillsSprint_accountingledger.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;
    private final TransactionService transactionService;

    public CategoryController(CategoryService categoryService,TransactionService transactionService) {
        this.categoryService = categoryService;
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        // find and return all categories
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Category> getById(@PathVariable Integer id) {
        // get the category by id
        return categoryService.getById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        // insert the category and return it with status 201 Created
        Category saved = categoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("{categoryId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionByCategoryId(@PathVariable Integer categoryId)
    {
        // get a list of product by categoryId
        return ResponseEntity.ok(transactionService.listByCategoryId(categoryId));
    }
}
