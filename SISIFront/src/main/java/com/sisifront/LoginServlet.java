package com.sisifront;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: login").append(request.getContextPath());
        String usuario = request.getParameter("user");
        String contraseña = request.getParameter("password");

        try {
            ArrayList<User> user = UserJSON.getJSON();
            boolean userRegistered = user.stream().anyMatch(dbUsuario -> dbUsuario.getUser().equals(usuario) && dbUsuario.getPassword().equals(contraseña));

            if(userRegistered){
                response.sendRedirect(request.getContextPath() + "/customer.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }

        } catch (Exception e) {
            response.getWriter().append("User error" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
