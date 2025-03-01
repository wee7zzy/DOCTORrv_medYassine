package code.Doctorrv.DAO;

import code.Doctorrv.model.Doctor;
import code.Doctorrv.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/doctorrv";
    private static final String USER = "root";
    private static final String PASSWORD = "anique001";
    private static final String SELECT_ALL_DOCS = "SELECT * FROM medecins";
    private static final String INSERT_DOC_SQL = "INSERT INTO users (name,specialite, email phone, password) VALUES (?,?, ?, ?, ?)";

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
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOCS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String specialite = resultSet.getString("specialite");
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
    public void addDoc(Doctor doc) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOC_SQL)) {
            preparedStatement.setString(1, doc.getName());
            preparedStatement.setString(2, doc.getSpecialite());
            preparedStatement.setString(3, doc.getEmail());
            preparedStatement.setString(4, doc.getPhone());
            preparedStatement.setString(5, doc.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
