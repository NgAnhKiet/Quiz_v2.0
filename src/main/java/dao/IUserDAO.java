package dao;

import model.Student;

import java.sql.SQLException;

public interface IUserDAO {
    void editPasswordUser(int id, String newPassword) throws SQLException, ClassNotFoundException;
    void insert_StudentMember(Student student);
    Student select_Users(boolean role);
}
