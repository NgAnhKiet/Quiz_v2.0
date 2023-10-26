package com.example.quizwebsite.controller;

import com.example.quizwebsite.model.User;
import com.example.quizwebsite.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Khởi tạo UserDAO trong phương thức init() của Servlet
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang đăng ký người dùng khi gửi yêu cầu GET
        request.getRequestDispatcher("/sign-up/sign-up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin người dùng từ các tham số gửi lên
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        int permission = Integer.parseInt(request.getParameter("permission"));

        // Kiểm tra các thông tin người dùng
        if (username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
            // Thiếu thông tin - chuyển hướng đến trang lỗi
            response.sendRedirect("error.jsp");
            return;
        }

        // Kiểm tra định dạng email
        if (!isValidEmail(email)) {
            // Định dạng email không hợp lệ - chuyển hướng đến trang lỗi
            response.sendRedirect("error.jsp");
            return;
        }

        // Kiểm tra độ dài mật khẩu
        if (password.length() < 6) {
            // Mật khẩu quá ngắn - chuyển hướng đến trang lỗi
            response.sendRedirect("error.jsp");
            return;
        }

        // Kiểm tra mật khẩu và xác nhận mật khẩu khớp nhau
        if (!password.equals(confirmPassword)) {
            // Mật khẩu và xác nhận mật khẩu không khớp - chuyển hướng đến trang lỗi
            response.sendRedirect("error.jsp");
            return;
        }

        // Tạo đối tượng User từ thông tin người dùng
        User user = new User(username, email, password, permission);

        // Thêm người dùng vào cơ sở dữ liệu
        userDAO.addUser(user);

        // Chuyển hướng người dùng đến trang thành công
        response.sendRedirect("success.jsp");
    }

    // Phương thức kiểm tra định dạng email
    private boolean isValidEmail(String email) {
        // Triển khai kiểm tra định dạng email tùy theo yêu cầu của bạn
        // Ví dụ đơn giản: kiểm tra xem email có chứa ký tự @ hay không
        return email.contains("@");
    }
}
