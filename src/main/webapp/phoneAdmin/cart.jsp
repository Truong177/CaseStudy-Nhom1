<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cửa hàng điện thoại</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <style>
        .navbar-red {
            background-color: red;
        }

        .navbar-brand {
            color: white;
            font-family: 'Pacifico', cursive;
            font-size: 24px;
        }

        .nav-link {
            color: white;
            font-weight: bold;
            margin-right: 15px;
        }

        .nav-link:hover {
            color: lightgray;
        }

        .btn-outline-light {
            color: white;
            border-color: white;
        }

        .btn-outline-light:hover {
            color: red;
            background-color: white;
        }

        .modal-body {
            color: black;
        }

        .modal-footer {
            justify-content: space-between;
        }

        .search-input {
            width: 200px;
        }

        .add-phone-btn {
            margin-bottom: 20px;
        }

        table.table-bordered tbody tr td, table.table-bordered thead tr th {
            border: 1px solid #dee2e6;
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-red">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="/img/logo1.png" alt="logo" width="50" height="50">
            Cửa hàng điện thoại
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/phone?action=list">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Danh mục</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Khuyến mãi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Liên hệ</a>
                </li>
            </ul>
            <form class="d-flex" action="phone" method="post">
                <input class="form-control me-2 search-input" type="search" placeholder="Tìm kiếm" aria-label="Search" name="search">
                <input type="hidden" name="action" value="search">
                <button class="btn btn-outline-light" type="submit">Tìm kiếm</button>
            </form>
        </div>
    </div>
</nav>

</body>