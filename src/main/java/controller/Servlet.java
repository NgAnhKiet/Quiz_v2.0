package controller;

import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Servlet extends HttpServlet {

    private UsersDAO usersDAO;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username"); // Tài khoản người dùng nhập vào
        String password = request.getParameter("password"); // Mật khẩu người dùng nhập vào

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Thiết lập kết nối đến cơ sở dữ liệu
            Connection conn = connection;
            // Chuẩn bị câu truy vấn SQL
            String sql = "SELECT * FROM users WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // Thực thi câu truy vấn
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals(password)) {
                    // Đăng nhập thành công
                    out.println("Đăng nhập thành công!");
                } else {
                    // Sai mật khẩu
                    out.println("Sai mật khẩu!");
                }
            } else {
                // Tài khoản không tồn tại
                out.println("Tài khoản không tồn tại!");
            }
        } catch (Exception ex) {
            out.println("Lỗi: " + ex.getMessage());
        }
    }
}
