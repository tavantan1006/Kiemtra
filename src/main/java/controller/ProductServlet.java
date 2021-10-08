package controller;

import model.Category;
import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":{
                ShowBannerDetail(request,response);
                break;
            }
            case "create":{
                ShowProductCreate(request,response);
                break;
            }
            case "delete": {
                ShowProductDelete(request, response);
                break;
            }
            default: {
                ShowProductList(request, response);
                break;
            }
        }
    }

    private void ShowBannerDetail(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getById(id);
        List<Category> categories = productService.getAllCategory();
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("Product/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Product/detail.jsp");
            request.setAttribute("product",product);
            request.setAttribute("categories",categories);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowProductCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/create.jsp");
        List<Category> categories = productService.getAllCategory();
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowProductDelete(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getById(id);
        List<Category> categories = productService.getAllCategory();
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("Product/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Product/delete.jsp");
            request.setAttribute("product",product);
            request.setAttribute("categories", categories);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowProductList(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> products;
        List<Category> categories;
        if (search == null || search.equals("")) {
            products = productService.getAll();
            categories = productService.getAllCategory();
        } else {
            products = productService.getByName(search);
            categories = productService.getAllCategory();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/list.jsp");
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete": {
                DeleteProduct(request, response);
                break;
            }
            case "detail": {
                UpdateProduct(request, response);
                break;
            }
            case "create": {
                createProduct(request, response);
                break;
            }
            default:
                ShowProductList(request,response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_Category = Integer.parseInt(request.getParameter("id_Category"));
        Product product = new Product(name,price,quantity,color,description,id_Category);
        boolean isCreated = productService.add(product);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_Category = Integer.parseInt(request.getParameter("id_Category"));
        Product product = new Product(id,name,price,quantity,color,description,id_Category);
        productService.update(id,product);
        response.sendRedirect("/ProductServlet");
    }

    private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/ProductServlet");
    }
}
