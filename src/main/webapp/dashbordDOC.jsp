<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mes Rendez-vous</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">
    <div class="max-w-3xl mx-auto bg-white p-4 rounded shadow">
        <h2 class="text-xl font-semibold text-gray-700 mb-4">dashboardDOC-Mes Rendez-vous</h2>
        <table class="w-full border border-gray-300">
            <thead>
                <tr class="bg-gray-200">
                    <th class="border border-gray-300 px-3 py-2">Patient</th>
                    <th class="border border-gray-300 px-3 py-2">Date</th>

                    <th class="border border-gray-300 px-3 py-2">Motif</th>
                </tr>
            </thead>
            <tbody>
                <%@ page import="java.sql.*" %>
                <%
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorrv", "root", "anique001");
                         PreparedStatement stmt = conn.prepareStatement("SELECT users.nom, appointments.date, appointments.motif FROM appointments INNER JOIN users ON appointments.patient_id = users.id");
                         ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                %>
                <tr>
                    <td class="border border-gray-300 px-3 py-2"><%= rs.getString("nom") %></td>
                    <td class="border border-gray-300 px-3 py-2"><%= rs.getDate("date") %></td>

                    <td class="border border-gray-300 px-3 py-2"><%= rs.getString("motif") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
