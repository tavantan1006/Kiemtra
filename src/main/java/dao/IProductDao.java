package dao;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAll();
    boolean add(Product product);
    boolean update(int id,Product product);
    boolean delete(int id);
    List<Product> getByName(String name);
    Product getById(int id);
    List<Category> getAllCategory();
    Category findById(int id);
}
