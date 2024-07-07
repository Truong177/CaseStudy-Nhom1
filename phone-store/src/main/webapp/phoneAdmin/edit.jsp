<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Phone</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #ffffff;
            color: #000000;
        }
        .btn-primary {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-primary:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
        .text-danger {
            color: #dc3545;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Edit Phone</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="text-danger">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/phone" class="btn btn-secondary">Back to phone list</a>
    </p>
    <form method="post" action="${pageContext.request.contextPath}/phone">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${phone.id}">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${phone.name}" required>
        </div>
        <div class="mb-3">
            <label for="img" class="form-label">Image URL</label>
            <input type="text" class="form-control" id="img" name="image" value="${phone.img}" required>
        </div>
        <div class="mb-3">
            <label for="manufacture" class="form-label">Manufacturer</label>
            <input type="text" class="form-control" id="manufacture" name="manufacture" value="${phone.manufacture}" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" class="form-control" id="price" name="price" value="${phone.price}" min="0" required>
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="number" class="form-control" id="quantity" name="quantity" value="${phone.quantity}" min="0" required>
        </div>
        <div class="mb-3">
            <label for="size" class="form-label">Size (inches)</label>
            <input type="number" class="form-control" id="size" name="size" value="${phone.size}" min="0" required>
        </div>
        <div class="mb-3">
            <label for="color" class="form-label">Color</label>
            <input type="text" class="form-control" id="color" name="color" value="${phone.color}" required>
        </div>
        <div class="mb-3">
            <label for="ram" class="form-label">RAM (GB)</label>
            <input type="number" class="form-control" id="ram" name="ram" value="${phone.ram}" min="0" required>
        </div>
        <div class="mb-3">
            <label for="batery" class="form-label">Battery (mAh)</label>
            <input type="number" class="form-control" id="batery" name="batery" value="${phone.batery}" min="0" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Phone</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
