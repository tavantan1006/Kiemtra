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

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
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
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("Product/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Product/detail.jsp");
            request.setAttribute("product",product);
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
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("Product/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Product/delete.jsp");
            request.setAttribute("product",product);
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

    }
}
