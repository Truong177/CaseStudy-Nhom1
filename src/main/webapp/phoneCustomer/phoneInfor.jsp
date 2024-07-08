<%--
  Created by IntelliJ IDEA.
  User: WIN 10
  Date: 07/07/2024
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Sản Phẩm</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styleCustomer.css">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top navbar-red">
    <div class="container-fluid">
        <a class="navbar-brand" href="/phoneCustomer"><img src="/img/logo1.png" height="40"> Trang Chủ</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link" href="#">Điện Thoại Mới</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Bán Chạy</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Giới Thiệu</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Liên Hệ</a></li>
            </ul>
            <form class="form-inline my-2 my-lg-0 mr-3">
                <input class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Tìm kiếm</button>
            </form>
            <a class="nav-link text-white" href="#">
                <img src="/img/cart.png" height="42">
            </a>
        </div>
    </div>
</nav>
<div class="container product-detail">
    <div class="row">
        <div class="col-md-4">
            <img src="${phone.img}" class="img-fluid">
        </div>
        <div class="col-md-8">
            <div class="product-title">${phone.name}</div>
            <div class="product-info"><span>Hãng sản xuất:</span>${phone.manufacture}</div>
            <div class="product-info"><span>Giá:</span> ${phone.price} VNĐ</div>
            <div class="product-info"><span>Tình trạng:</span> Còn ${phone.quantity} sản phẩm</div>
            <button class="btn btn-buy">Thêm vào giỏ hàng</button>
            <button class="btn btn-buy">Đặt hàng</button>
        </div>
    </div>

    <ul class="nav nav-tabs mt-4" id="myTab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="details-tab" data-toggle="tab" href="#details" role="tab"
               aria-controls="details" aria-selected="true">Chi tiết sản phẩm</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="comments-tab" data-toggle="tab" href="#comments" role="tab" aria-controls="comments"
               aria-selected="false">Bình luận sản phẩm</a>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="details" role="tabpanel" aria-labelledby="details-tab">
            <table class="table mt-3">
                <tr>
                    <th>Kích thước</th>
                    <td>${phone.size} inch</td>
                </tr>
                <tr>
                    <th>Màu sắc</th>
                    <td>${phone.color}</td>
                </tr>
                <tr>
                    <th>Ram</th>
                    <td>${phone.ram}GB</td>
                </tr>
                <tr>
                    <th>Pin</th>
                    <td>${phone.battery}mAh</td>
                </tr>
            </table>
        </div>
        <div class="tab-pane fade" id="comments" role="tabpanel" aria-labelledby="comments-tab">

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

