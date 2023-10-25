<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 24/10/2023
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Đăng ký</title>
    <link rel="stylesheet" type="text/css" href="../sign-up/style.css">
    <audio id="myAudio" autoplay loop>
        <source src="/music/cute-music-26476.mp3" type="audio/mp3">
    </audio>
</head>
<body>
<div class="container">
    <form id="register-form" method="post" action="/signup">
        <h2>Đăng ký</h2>
        <div class="form-group">
            <label for="display-name">Tên hiển thị</label>
            <input type="text" id="display-name" name="display-name" required>
        </div>
        <div class="form-group">
            <label for="email">Email *</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu *</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirm-password">Nhập lại mật khẩu *</label>
            <input type="password" id="confirm-password" name="confirm-password" required>
        </div>
        <div class="form-group">
            <label for="permission">Phân quyền *</label>
            <select id="permission" name="permission" required>
                <option value="">Chọn quyền hạn</option>
                <option value="1">Giáo viên</option>
                <option value="2">Học sinh</option>
                <option value="3">Admin</option>
            </select>
        </div>
        <button type="submit" id="submit-btn">Đăng ký</button>
    </form>
</div>
<script src="../sign-up/script.js"></script>
</body>
</html>