package com.yearup.SkillsSprint_accountingledger.Service;


import com.yearup.SkillsSprint_accountingledger.Repository.CategoryRepository;
import com.yearup.SkillsSprint_accountingledger.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories()
    {
        // get all categories
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(int categoryId)
    {
        // get category by id
        return categoryRepository.findById(categoryId);
    }

    public Category create(Category category) {
        // create a new category
        category.setName(category.getName());
        return categoryRepository.save(category);
    }
}
