package examportal1.examportal1.controller;

import examportal1.examportal1.service.AdminService.CategoryService;
import examportal1.examportal1.service.AdminService.CategoryServiceImpl;
import examportal1.examportal1.structure.exam.Category;
import jakarta.persistence.UniqueConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    public CategoryServiceImpl categoryService;

    @PostMapping("/")
    public String addCategory(@RequestBody Category category){
       this.categoryService.addCategory(category);
       return "category added successfully";

    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable ("id") Long id){
        Category category= this.categoryService.getCategory(id);
        return category;
    }
    @GetMapping("/")
    public Set<Category> getAllCategory(){
        return this.categoryService.getCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable ("id") Long id){

        this.categoryService.deleteCategory(id);

    }
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category){
        this.categoryService.updateCategory(category);
        return category;
    }
}
