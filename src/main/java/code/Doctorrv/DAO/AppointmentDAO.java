package code.Doctorrv.DAO;

import code.Doctorrv.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/doctorrv";
    private static final String USER = "root";
    private static final String PASSWORD = "anique001";
    private static final String SELECT_ID_USERS= "SELECT patient_id FROM users";
    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointments";
    private static final String INSERT_APP_SQL = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, motif) VALUES (?, ?, ?, ?)";

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
}
