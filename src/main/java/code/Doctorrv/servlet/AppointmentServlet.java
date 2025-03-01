package code.Doctorrv.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.Doctorrv.DAO.DBcnx;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer patientId = (Integer) session.getAttribute("patient_id");// Récupérer l'ID depuis la session
        String patientNom = (String) session.getAttribute("name");// Récupérer le nom depuis la session

        // Récupérer l'ID du médecin choisi
        String doctorIdParam = request.getParameter("doctor_id");
        if (doctorIdParam == null || doctorIdParam.isEmpty()) {
            response.sendRedirect("bookAppointment.jsp?error=missing_doctor");
            return;
        }

        int docId = Integer.parseInt(doctorIdParam); // ✅ Maintenant, on est sûr que doctorIdParam n'est pas null



        String docNom=null;
        // Récupérer le nom du médecin depuis la base de données
        String GET_DOC_NAME_SQL = "SELECT name FROM medecins WHERE id = ?";
        try (Connection conn = DBcnx.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_DOC_NAME_SQL)) {
            stmt.setInt(1, docId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                docNom = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (docNom == null) {
            response.sendRedirect("bookAppointment.jsp?error=2");
            return;
        }


        String appointment_date = request.getParameter("appointment_date");
        String motif = request.getParameter("motif");

        String INSERT_APP_SQL = "INSERT INTO appointments (patient_id,patient_nom, doctor_id,doctor_nom, appointment_date, motif) VALUES (?,?, ?,?, ?, ?)";

        try (Connection conn = DBcnx.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_APP_SQL)) {

            stmt.setInt(1, patientId);
            stmt.setString(2, patientNom);
            stmt.setInt(3, docId);
            stmt.setString(4, docNom);
            stmt.setString(5, appointment_date);
            stmt.setString(6, motif);

            int result = stmt.executeUpdate();
            if (result > 0) {

                System.out.println("doctor_id reçu: " + doctorIdParam);

                response.sendRedirect("ConsultAppointment.jsp?success=1");
            } else {
                response.sendRedirect("bookAppointment.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("bookAppointment.jsp?error=1");
        }
    }
}
