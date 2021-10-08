<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<style>
    table th,tr,td {
        text-align: center;
    }
</style>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded navbar-padding-0" style="height: 50px"
         aria-label="Eleventh navbar example">
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="https://getbootstrap.com/" target="_blank">
                        <img src="/img/bootstrap-logo.svg" alt="" width="30" height="24"
                             class="d-inline-block align-text-top">
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
                <form action="/ProductServlet">
                    <div class="row">
                        <div class="col">
                            <input name="search" class="form-control mt-3" style="size: 200px" type="text" placeholder="Search"
                                   aria-label="Search">
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
        <div class="col-2">
            <div class="card" style="min-height: 100%">
                <div class="position-sticky pt-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-home" aria-hidden="true">
                                    <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                    <polyline points="9 22 9 12 15 12 15 22"></polyline>
                                </svg>
                                Dashboard
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Product">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-file" aria-hidden="true">
                                    <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                    <polyline points="13 2 13 9 20 9"></polyline>
                                </svg>
                                Product
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-10">
            <div class="card">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Quản Lý Sản Phẩm
                </button>

                <!-- Modal -->
                <div class="card-header">
                    <div class="row">
                        <div class="col">
                            <h5 class="mt-2">Banner</h5>
                        </div>
                        <div class="col">
                            <button type="button" class="btn btn-outline-primary float-end">
                                <a href="/ProductServlet?action=create" style="text-decoration: none">
                                    Add New
                                </a>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <h1>${messege}</h1>
                        <tr>
                            <th>#</th>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Color</th>
                            <th>Category</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>${product.color}</td>
                                <td>${product.description}</td>
                                <c:forEach items="${categories}" var="category">
                                    <c:choose>
                                        <c:when test="${category.id == product.id_Category}">
                                            <td>${category.name}</td>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <td><button type="button" class="btn btn-success btn-sm">
                                    <a style=" text-decoration: none;color: white" href="/ProductServlet?action=detail&id=${product.id}">Edit</a>
                                </button></td>
                                <td><button type="button" class="btn btn-danger btn-sm">
                                    <a style=" text-decoration: none;color: white" href="/ProductServlet?action=delete&id=${product.id}">Delete</a>
                                </button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="card-footer">
                    Phan trang o day
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
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
            crossorigin="anonymous"></script>


</div>
</body>
