package code.Doctorrv.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        if (patientId == null) {
            response.sendRedirect("bookAppointment.jsp?error=1"); // Redirection si l'ID du patient est absent
            return;
        }

        String doctor_id = request.getParameter("doctor_id");
        String appointment_date = request.getParameter("appointment_date");
        String motif = request.getParameter("motif");

        String INSERT_APP_SQL = "INSERT INTO appointments (patient_id,patient_nom, doctor_id, appointment_date, motif) VALUES (?,?, ?, ?, ?)";

        try (Connection conn = DBcnx.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_APP_SQL)) {

            stmt.setInt(1, patientId);
            stmt.setString(2, patientNom);
            stmt.setString(3, doctor_id);
            stmt.setString(4, appointment_date);
            stmt.setString(5, motif);

            int result = stmt.executeUpdate();
            if (result > 0) {
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
