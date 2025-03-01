<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
    <div class="w-full max-w-3xl p-8 bg-white rounded-lg shadow-lg flex flex-col space-y-8">

        <!-- Formulaire de connexion Patient -->
        <div class="p-6 border-b border-gray-300">
            <h2 class="text-2xl font-semibold text-center text-blue-600 mb-6">Connexion Patient</h2>
            <form action="LoginServlet" method="post" class="space-y-4">
                <input type="hidden" name="userType" value="user">
                <div>
                    <label class="block text-sm font-medium text-gray-700">Email</label>
                    <input type="email" name="email" required class="w-full p-3 border rounded-lg focus:ring focus:ring-blue-300">
                </div>
                <div>
                    <label class="block text-sm font-medium text-gray-700">Mot de passe</label>
                    <input type="password" name="password" required class="w-full p-3 border rounded-lg focus:ring focus:ring-blue-300">
                </div>
                <button type="submit" class="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition duration-300">Se connecter</button>
            </form>
            <p class="text-center text-sm mt-4">
                Pas encore de compte ? <a href="RegistreUser.jsp" class="text-blue-500">Créer un compte</a>
            </p>
        </div>

        <!-- Formulaire de connexion Médecin -->
        <div class="p-6">
            <h2 class="text-2xl font-semibold text-center text-green-600 mb-6">Connexion Médecin</h2>
            <form action="LoginDocServlet" method="post" class="space-y-4">
                <input type="hidden" name="userType" value="user">
                <div>
                    <label class="block text-sm font-medium text-gray-700">Email</label>
                    <input type="email" name="email" required class="w-full p-3 border rounded-lg focus:ring focus:ring-green-300">
                </div>
                <div>
                    <label class="block text-sm font-medium text-gray-700">Mot de passe</label>
                    <input type="password" name="password" required class="w-full p-3 border rounded-lg focus:ring focus:ring-green-300">
                </div>
                <button type="submit" class="w-full bg-green-600 text-white p-3 rounded-lg hover:bg-green-700 transition duration-300">Se connecter</button>
            </form>
            <p class="text-center text-sm mt-4">
                Pas encore de compte ? <a href="RegistreDoc.jsp" class="text-green-500">Créer un compte</a>
            </p>
        </div>
    </div>
</body>
</html>
