<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập Admin</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light gray background */
            color: #495057; /* Dark gray text color */
        }
        .container {
            max-width: 400px; /* Adjust max-width as needed */
            margin-top: 100px; /* Top margin for spacing */
            padding: 30px; /* Padding inside container */
            border: 1px solid #e9ecef; /* Light border */
            border-radius: 5px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Shadow for depth */
        }
        .form-control {
            border: 1px solid #ced4da; /* Gray border */
            border-radius: .25rem; /* Rounded corners */
            background-color: #ffffff; /* White background */
            color: #495057; /* Dark gray text color */
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out; /* Smooth transition on focus/hover */
        }
        .form-control:focus {
            border-color: #80bdff; /* Blue border on focus */
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25); /* Light blue shadow on focus */
        }
        .btn-primary {
            background-color: #007bff; /* Blue background */
            border-color: #007bff; /* Blue border */
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="mb-4">Đăng nhập Admin</h2>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="mb-3">
            <label for="username" class="form-label">Tên đăng nhập:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </form>
</div>
</body>
</html>
