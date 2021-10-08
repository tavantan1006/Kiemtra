package dao;

import config.DBConnection;
import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String descripton = resultSet.getString("description");
                int id_Category = resultSet.getInt("id_Category");
                Product product = new Product(id,name,price,quantity,color,descripton,id_Category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        Boolean isAdd =  false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call insertProduct(?,?,?,?,?,?)");
            callableStatement.setString(1,product.getName());
            callableStatement.setFloat(2,product.getPrice());
            callableStatement.setInt(3,product.getQuantity());
            callableStatement.setString(4,product.getColor());
            callableStatement.setString(5,product.getDescription());
            callableStatement.setInt(6,product.getId_Category());
            isAdd = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdd;
    }

    @Override
    public boolean update(int id, Product product) {
        Boolean isUpdate =  false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call updateProduct(?,?,?,?,?,?,?)");
            callableStatement.setInt(1,id);
            callableStatement.setString(2,product.getName());
            callableStatement.setFloat(3,product.getPrice());
            callableStatement.setInt(4,product.getQuantity());
            callableStatement.setString(5,product.getColor());
            callableStatement.setString(6,product.getDescription());
            callableStatement.setInt(7,product.getId_Category());
            isUpdate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(int id) {
        Boolean isDelete = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call deleteProduct(?)");
            callableStatement.setInt(1,id);
            isDelete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDelete;
    }

    @Override
    public List<Product> getByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE name like ?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String descripton = resultSet.getString("description");
                int id_Category = resultSet.getInt("id_Category");
                Product product = new Product(id,name1,price,quantity,color,descripton,id_Category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name1 = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String descripton = resultSet.getString("description");
                int id_Category = resultSet.getInt("id_Category");
                product = new Product(id,name1,price,quantity,color,descripton,id_Category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Category");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean status = resultSet.getBoolean("status");
                Category category = new Category(id,name,status);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Category WHERE id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                boolean status = resultSet.getBoolean("status");
                category = new Category(id,name,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
