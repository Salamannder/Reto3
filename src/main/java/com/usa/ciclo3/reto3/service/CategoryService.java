package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Category;

import com.usa.ciclo3.reto3.repository.CategoryRepository;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> obtenerCategory() {
        return categoryRepository.obtenerCategory();
    }

    public Category salvarCategory(Category category) {
        if (category.getId() == null) {
            return categoryRepository.salvarcategory(category);
        } else {
            return category;
        }
    }

    public Category actualizaCategory(Category category) {
        if (category.getId() != null) {
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if (!e.isEmpty()) {
                if (category.getDescription() != null) {
                    e.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    e.get().setName(category.getName());
                }
                categoryRepository.salvarcategory(e.get());
                return e.get();

            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean borrarCategory(int categoryId) {
        boolean flag = false;
        Optional<Category> c = categoryRepository.getCategory(categoryId);
        if (c.isPresent()) {
            categoryRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}
