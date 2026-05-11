package com.sisifront;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "SaleServlet", value = "/SaleServlet")
public class SaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: sale").append(request.getContextPath());
        PrintWriter writer = response.getWriter();

        try{
            addSale(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //if comprobación de botón
        /**
        if(request.getParameter("saveButton") != null) {
            addSale(request, response);
        }**/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void addSale(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Sale sale = new Sale();
        sale.setOrderNumber(request.getParameter("orderNumber"));
        sale.setAmount(request.getParameter("amount"));
        sale.setService(request.getParameter("service"));
        sale.setDiscount(request.getParameter("discount"));
        response.sendRedirect(request.getContextPath() + "/sale.jsp");
        int respuesta = 0;
        try {
            respuesta = SaleJSON.postJSON(sale);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Agregado!");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
