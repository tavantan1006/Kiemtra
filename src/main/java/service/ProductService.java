package service;

import dao.IProductDao;
import dao.ProductDao;
import model.Category;
import model.Product;

import java.util.List;

public class ProductService implements IProductService{
    private IProductDao productDao = new ProductDao();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean add(Product product) {
        return productDao.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id,product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public List<Product> getByName(String name) {
        return productDao.getByName(name);
    }

    @Override
    public List<Category> getAllCategory() {
        return productDao.getAllCategory();
    }

    @Override
    public Category findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }
}
