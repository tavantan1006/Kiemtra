package service;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    boolean add(Product product);
    boolean update(int id,Product product);
    boolean delete(int id);
    List<Product> getByName(String name);
    List<Category> getAllCategory();
    Category findById(int id);
    Product getById(int id);

}
