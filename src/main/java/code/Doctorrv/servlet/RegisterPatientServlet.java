package code.Doctorrv.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.Doctorrv.DAO.DBcnx;

@WebServlet("/RegisterPatientServlet")
public class RegisterPatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        String INSERT_USER_SQL = "INSERT INTO users (name, email, phone, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBcnx.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, password); // Pense à hasher le mot de passe

            int result = stmt.executeUpdate();

            if (result > 0) {
                // Récupérer l'ID généré
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int patientId = generatedKeys.getInt(1);
                    String patientNom = request.getParameter("name");

                    // Stocker l'ID dans la session pour le récupérer plus tard
                    HttpSession session = request.getSession();
                    session.setAttribute("patient_id", patientId);
                    session.setAttribute("name",patientNom);
                }

                response.sendRedirect("bookAppointment.jsp?success=1");
            } else {
                response.sendRedirect("RegistreUser.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("RegistreUser.jsp?error=1");
        }
    }
}
