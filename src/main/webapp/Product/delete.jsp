<%--
  Created by IntelliJ IDEA.
  User: Dang Hoa
  Date: 10/4/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded navbar-padding-0" style="height: 50px" aria-label="Eleventh navbar example">
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="https://getbootstrap.com/" target="_blank">
                        <img src="/img/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Bootstrap
                    </a>
                </div>
            </nav>

            <div class="collapse navbar-collapse" id="navbarsExample09">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                </ul>
                <form>
                    <div class="row">
                        <div class="col">
                            <input class="form-control mt-3" style="size: 200px" type="text" placeholder="Search" aria-label="Search">
                        </div>
                        <div class="col">
                            <button type="submit" class="btn btn-outline-primary mt-3">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </nav>
    <div class="row mt-3" style="min-height: 80%">
        <div class="col-2" >
            <div class="card" style="min-height: 100%">
                <div class="position-sticky pt-3">
                    <ul class="nav flex-column">

                        <li class="nav-item">
                            <a class="nav-link" href="/ProductServlet">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart" aria-hidden="true"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                Products
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-10">
            <button><a style="text-decoration: none;" href="/ProductServlet">Return</a></button>

            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col" style="text-align: center">
                            <h3 >Product Update</h3>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form method="post">
                        <div class="mb-3">
                            <label for="id_banner" class="form-label">Product Id</label>
                            <input type="text" name="id" class="form-control" id="id_banner"  value="${product.id}" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="name" class="form-label">name</label>
                            <input type="text" name="name" class="form-control" id="name"  value="${product.name}" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">price</label>
                            <input type="text" name="price" class="form-control"  value="${product.price}" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">quantity</label>
                            <input type="text" name="quantity" class="form-control" value="${product.quantity}" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">color</label>
                            <input type="text" name="color" class="form-control" value="${product.color}" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">description</label>
                            <input type="text" name="description" class="form-control" value="${product.description}" readonly>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Category</label>
                            <select class="form-select" aria-label="Default select example" name="id_Category">
                                <c:forEach items="${categories}" var="category">
                                    <c:choose>
                                        <c:when test="${category.id == product.id_Category}">
                                            <option value="${category.id}" selected>${category.name}</option readonly>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>

                </div>
                <div class="card-footer">
                </div>
            </div>
        </div>

    </div>
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-2 my-3 border-top">
        <p class="col-md-4 mb-0 text-muted">© 2021 Company, Inc</p>
        <ul class="nav col-md-4 justify-content-end">
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
        </ul>
    </footer><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</div>
</body>
</html>

