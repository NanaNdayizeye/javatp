<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h1>Liste des Utilisateurs</h1>
    <a href="form">➕ Ajouter</a>
    <table>
        <tr>
            <th>ID</th><th>Nom</th><th>Prénom</th><th>Âge</th><th>Actions</th>
        </tr>
        <%
            List<String[]> users = (List<String[]>) request.getAttribute("users");
            for (String[] user : users) {
        %>
        <tr>
            <td><%= user[0] %></td>
            <td><%= user[1] %></td>
            <td><%= user[2] %></td>
            <td><%= user[3] %></td>
            <td>
                <a href="form?id=<%= user[0] %>">✏️</a>
                <a href="delete?id=<%= user[0] %>" onclick="return confirm('Supprimer ?')">🗑️</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
