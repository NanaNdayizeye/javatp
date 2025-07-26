<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Formulaire</title>
</head>
<body>
    <h2>Formulaire Utilisateur</h2>
    <form action="save" method="post">
        <input type="hidden" name="id" value="${id}" />
        <label>Nom: <input type="text" name="nom" value="${nom}" required /></label><br>
        <label>Prénom: <input type="text" name="prenom" value="${prenom}" required /></label><br>
        <label>Âge: <input type="number" name="age" value="${age}" required /></label><br>
        <button type="submit">✅ Enregistrer</button>
        <a href="users">↩ Retour</a>
    </form>
</body>
</html>
