<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 24/10/2023
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng nhập</title>
  <link rel="stylesheet" type="text/css" href="../login/style.css">
  <audio id="myAudio" autoplay loop>
    <source src="/music/cute-music-26476.mp3" type="audio/mp3">
  </audio>
</head>
<body>
<div class="container">
  <form id="login-form">
    <h2>Đăng nhập</h2>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="password">Mật khẩu</label>
      <input type="password" id="password" name="password" required>
    </div>
    <button type="submit" id="submit-btn">Đăng nhập</button>
  </form>
</div>
</body>
<script src="../login/script.js"></script>
</html>
