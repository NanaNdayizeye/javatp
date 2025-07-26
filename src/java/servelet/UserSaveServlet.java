/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import config.DBUtil;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/save")
public class UserSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String ageStr = request.getParameter("age");

        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps;

            if (id != null && !id.isEmpty()) {
                ps = conn.prepareStatement("UPDATE users SET nom=?, prenom=?, age=? WHERE id=?");
                ps.setString(1, nom);
                ps.setString(2, prenom);
                ps.setInt(3, Integer.parseInt(ageStr));
                ps.setInt(4, Integer.parseInt(id));
            } else {
                ps = conn.prepareStatement("INSERT INTO users (nom, prenom, age) VALUES (?, ?, ?)");
                ps.setString(1, nom);
                ps.setString(2, prenom);
                ps.setInt(3, Integer.parseInt(ageStr));
            }

            ps.executeUpdate();
        } catch (Exception e) {
            throw new ServletException(e);
        }

        response.sendRedirect("users");
    }
}
