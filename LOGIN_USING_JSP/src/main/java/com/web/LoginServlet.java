package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Debugging: Print the username and password
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDB", "root", "Naveen@123");

            PreparedStatement ps = con.prepareStatement("SELECT username FROM users WHERE email=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                out.print("Invalid username or password");
                request.getRequestDispatcher("login.html").include(request, response);
            }

        } catch (Exception e2) {
            out.println("Error: " + e2.getMessage());
        }

        out.close();
    }
}
