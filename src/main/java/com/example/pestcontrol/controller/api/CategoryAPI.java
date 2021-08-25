package com.example.pestcontrol.controller.api;

import com.example.pestcontrol.model.Category;
import com.example.pestcontrol.service.Category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/category")
@RequiredArgsConstructor
public class CategoryAPI {
    private final ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Iterable<Category>> getAllCategory(){
        Iterable<Category> categories = categoryService.findAll();
        if(categories == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            categoryService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
