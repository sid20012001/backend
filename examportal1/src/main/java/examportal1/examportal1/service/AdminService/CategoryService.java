package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.structure.exam.Category;

import java.util.Set;

public interface CategoryService {

    public void addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long id);
    public void deleteCategory(Long id);
}
