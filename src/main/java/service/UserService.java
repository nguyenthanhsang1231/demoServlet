    package service;

    import database.Database;
    import model.User;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class UserService implements IUser<User>{
        Connection connection = Database.getConnection();

        @Override
        public void add(User user) {
            String sql = "insert into user(userName, passWord) VALUES (?, ?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassWord());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean checkUser(String passWord) {
            String sql = "select * from user where passWord = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, passWord);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
