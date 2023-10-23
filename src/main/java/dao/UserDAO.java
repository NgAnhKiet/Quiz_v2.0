package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO implements IUserDAO{
    public class DatabaseConnection {
        private String jdbcUrl = "jdbc:mysql://localhost:3306/quizizz";

        //Nhớ chỉnh lại mật khẩu với user name để đảm bảo đúng với tài khoản trong máy
        private String userName = "root";
        private String password = "1234";

        protected Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcUrl, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
