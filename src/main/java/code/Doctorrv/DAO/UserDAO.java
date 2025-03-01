package code.Doctorrv.DAO;

import code.Doctorrv.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/doctorrv";
    private static final String USER = "root";
    private static final String PASSWORD = "anique001";
    private static final String SELECT_ALL_PATIENTS = "SELECT * FROM users";
    private static final String INSERT_PATIENT_SQL = "INSERT INTO users (name, email, phone, password) VALUES (?, ?, ?, ?)";

    // Méthode pour obtenir la connexion à la base de données
    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode pour récupérer tous les patients
    public List<User> getAllPatients() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                users.add(new User(name, email, phone, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Méthode pour ajouter un patient
    public void addPatient(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
