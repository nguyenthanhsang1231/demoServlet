package service;

import database.Database;
import model.Class;
import model.Student;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentService implements IStudent<Student> {
    private Connection connection = Database.getConnection();
    ClassService classService = new ClassService();

    ArrayList<Student> list = new ArrayList<>();

    @Override
    public void add(Student student) {
        String sql = "insert into student(name, age, classId) values (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getClazz().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Student student) {
        String sql = "update student set name = ?, age = ? , classId = ? where id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getClazz().getId());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from student;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int classId = resultSet.getInt("classId");
                Class clazz = classService.findById(classId);
                students.add(new Student(id, name, age, clazz));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        String sql = "select * from student where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameE = resultSet.getString("name");
                int ageE = resultSet.getInt("age");
                int classIdE = resultSet.getInt("classId");
                Class clazz = classService.findById(classIdE);
                student = new Student(id, nameE, ageE, clazz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from student where name like ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameS = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int classId = resultSet.getInt("classId");
                Class clazz = classService.findById(classId);
                students.add(new Student(id, nameS, age, clazz));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.getAge()-o2.getAge());
    }
}
