package com.example.quizwebsite.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LoginServlet", value="/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang đăng nhập
        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Kiểm tra xem email và mật khẩu có hợp lệ hay không (ví dụ: không được để trống)
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            // Xử lý lỗi - email hoặc mật khẩu không hợp lệ
            response.sendRedirect("login.jsp?error=invalid");
            return;
        }

        // Kiểm tra xác thực đăng nhập trong cơ sở dữ liệu
        boolean authenticated = false; // Biến này sẽ được thay đổi sau khi kiểm tra trong cơ sở dữ liệu

        if (authenticated) {
            // Lấy giá trị trường "permission" từ cơ sở dữ liệu
            int permission = 0; // Giá trị này sẽ được lấy từ cơ sở dữ liệu

            // Phân biệt giáo viên và sinh viên dựa trên trường "permission"
            if (permission == 1) {
                // Đăng nhập thành công cho giáo viên
                response.sendRedirect("teacher_home.jsp");
            } else if (permission == 2) {
                // Đăng nhập thành công cho sinh viên
                response.sendRedirect("student_home.jsp");
            } else {
                // Nếu giá trị permission không phù hợp, xử lý lỗi
                response.sendRedirect("login.jsp?error=permission");
            }
        } else {
            // Xử lý lỗi - email hoặc mật khẩu không chính xác
            response.sendRedirect("login.jsp?error=auth");
        }
    }
}
