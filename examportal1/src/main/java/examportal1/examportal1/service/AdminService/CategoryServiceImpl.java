package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.repo.CategoryRepo;
import examportal1.examportal1.structure.exam.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;
    @Override
    public void addCategory(Category category) {
        this.categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(this.categoryRepo.findAll());
    }

    @Override
    public Category getCategory(Long id) {
        return this.categoryRepo.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {

        this.categoryRepo.deleteById(id);

    }
}
