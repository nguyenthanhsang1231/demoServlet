package service;

import database.Database;
import model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassService implements IClass<Class>{
    private Connection connection = Database.getConnection();
    ArrayList<ClassService> list = new ArrayList<>();


    @Override
    public void add(Class aClass) {

    }

    @Override
    public void update(int id, Class aClass) {

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public ArrayList<Class> findAll() {
        ArrayList<Class> classes1 = new ArrayList<>();
        String sql = "select * from class;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Class classe = new Class(id, name);
                classes1.add(classe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classes1;
    }

    @Override
    public Class findById(int id) {
        Class clazz = new Class();
        String sql = "select * from class where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idClass = resultSet.getInt("id");
                String name = resultSet.getString("name");
                clazz = new Class(idClass, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clazz;
    }
}
