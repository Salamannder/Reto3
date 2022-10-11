package com.usa.ciclo3.reto3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> obtenerCategory() {
        return categoryService.obtenerCategory();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category salvarCategory(@RequestBody Category Category) {
        return categoryService.salvarCategory(Category);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category actualizaCategory(@RequestBody Category category) {
        return categoryService.actualizaCategory(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarCategory(@PathVariable("id") int categoryId) {
        return categoryService.borrarCategory(categoryId);

    }

}
