<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DoctorRV - Réservation de Rendez-vous</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-cover bg-center flex" style="background-image: url('./images/pexels-n-voitkevich-7526022.jpg')">
    <div class="flex gap-10 mx-auto p-6">

        <div class="mt-6 bg-white p-6 rounded-lg shadow-md opacity-80 w-[500px]">
            <h2 class="text-xl font-semibold mb-4">Réserver un Rendez-vous</h2>
            <form action="AppointmentServlet" method="post" class="space-y-4">

                <div>
                    <label class="block text-gray-700">Date</label>
                    <input type="date" name="appointment_date" required class="w-full p-2 border rounded-md">
                </div>
                <div>
                    <label class="block text-gray-700">Motif</label>
                    <textarea name="motif" required class="w-full p-2 border rounded-md"></textarea>
                </div>
                <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded-md">Réserver</button>
            </form>
        </div>
    </div>
</body>
</html>
