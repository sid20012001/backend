package examportal1.examportal1.controller;
import examportal1.examportal1.service.AdminService.CategoryService;
import examportal1.examportal1.service.AdminService.CategoryServiceImpl;
import examportal1.examportal1.structure.exam.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;


    //add Category

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }


    // get category
    @GetMapping("/{categoryId}")
    public Category getCategory (@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }


    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

    //delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
    }
}
