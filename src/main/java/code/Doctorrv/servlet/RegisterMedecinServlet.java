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

import code.Doctorrv.DAO.DBcnx;

@WebServlet("/RegisterMedecinServlet")
public class RegisterMedecinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String specialite = request.getParameter("specialite");
        String email = request.getParameter("email");

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        String INSERT_DOC_SQL = "INSERT INTO medecins (name,specialite, email, phone, password) VALUES (?,?, ?, ?, ?)";

        try (Connection conn = DBcnx.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_DOC_SQL)) {

            stmt.setString(1, name);
            stmt.setString(2, specialite);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, password); // ⚠️ Plus tard, il faudra hasher le mot de passe avec BCrypt !

            int result = stmt.executeUpdate();
            if (result > 0) {
                response.sendRedirect("dashbordDOC.jsp?success=1");
            } else {
                response.sendRedirect("RegistreDoc.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("RegistreDoc.jsp?error=1");
        }
    }
}
