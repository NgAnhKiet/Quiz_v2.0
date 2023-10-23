package dao;

import model.Student;

public interface IUserDAO {
    void insert_StudentMember(Student student);
    Student select_Users(boolean role);
}
