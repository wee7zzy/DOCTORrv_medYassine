<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer un compte</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
    <div class="w-full max-w-md p-8 bg-white rounded-lg shadow-lg">
        <h2 class="text-2xl font-semibold text-center text-gray-700 mb-6">Inscription patient </h2>
        <form action="RegisterPatientServlet" method="post" class="space-y-4">
            <div>
                <label class="block text-sm font-medium text-gray-700">Nom</label>
                <input type="text" name="name" required class="w-full p-3 border rounded-lg focus:ring focus:ring-blue-300">
            </div>
            <div>
                <label class="block text-sm font-medium text-gray-700">Email</label>
                <input type="email" name="email" required class="w-full p-3 border rounded-lg focus:ring focus:ring-blue-300">
            </div>
            <div>
                <label class="block text-sm font-medium text-gray-700">Téléphone</label>
                <input type="tel" name="phone" required class="w-full p-3 border rounded-lg focus:ring focus:ring-blue-300">
            </div>
            <div>
                <label class="block text-sm font-medium text-gray-700">Mot de passe</label>
                <input type="password" name="password" required class="w-full p-3 border rounded-lg focus:ring focus:ring-blue-300">
            </div>
            <button type="submit" class="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition duration-300">S inscrire </button>
        </form>
        <p class="text-center text-sm mt-4">
            Déjà un compte ? <a href="index.jsp" class="text-blue-500">Se connecter</a>
        </p>
    </div>
</body>
</html>
