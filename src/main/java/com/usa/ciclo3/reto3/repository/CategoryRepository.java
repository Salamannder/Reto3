package com.usa.ciclo3.reto3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.CRUD.CategoryCrudRepositoryInterfaz;

@Repository
public class CategoryRepository {

    @Autowired
    public CategoryCrudRepositoryInterfaz categoryCrudRepositoryInterfaz;

    public List<Category> obtenerCategory() {
        return (List<Category>) categoryCrudRepositoryInterfaz.findAll();
    }

    public Category salvarcategory(Category category) {
        return categoryCrudRepositoryInterfaz.save(category);
    }

}
