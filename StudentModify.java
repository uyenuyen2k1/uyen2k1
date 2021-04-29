/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
package studentmananger;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentModify {

    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Statement statement = null;

        // Lay tat ca danh sach sinh vien
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            // tao truy van query
            String sql = "select * from student";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("studentcode"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("phone_number"), resultSet.getInt("age"));
                studentList.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }

    public static void insert(Student std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");

            //query
            String sql = "insert into student(fullname, studentcode, age, gender, email, address, phone_number) values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getStudentCode());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getGender());
            statement.setString(5, std.getEmail());
            statement.setString(6, std.getAddress());
            statement.setString(7, std.getPhoneNumber());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Student student) {
        PreparedStatement statement = null;

        // Lay tat ca danh sach sinh vien
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            String sql = "update student set fullname = ?, studentcode = ?, age = ?, gender = ?, email = ?, address = ?, phone_number = ? where id = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, student.getFullname());
            statement.setString(2, student.getStudentCode());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhoneNumber());
            statement.setInt(8, student.getId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
            // tao truy van query

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public static void delete(int id) {
        PreparedStatement statement = null;

        // Lay tat ca danh sach sinh vien
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            // tao truy van query
            String sql = "delete from student where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public static List<Student> findByStudentCode(String studentCode) {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement statement = null;

        // Lay tat ca danh sach sinh vien
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            // tao truy van query
            String sql = "select * from student where studentcode like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + studentCode + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("studentcode"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("phone_number"), resultSet.getInt("age"));
                studentList.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
}
