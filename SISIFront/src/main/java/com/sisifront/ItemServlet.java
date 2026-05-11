package com.sisifront;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "ItemServlet", value = "/ItemServlet")
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*"); // Saltar politica CORS
        response.getWriter().append("Served at: item").append(request.getContextPath());
        PrintWriter writer = response.getWriter();

        try{
            addItem(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //método if para comprobar uso del botón
        /**if(request.getParameter("saveButton") != null) {
            addItem(request, response);
            System.out.println("if funcional");
        }**/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Item item = new Item();
        item.setId(request.getParameter("id"));
        item.setName(request.getParameter("name"));
        item.setModel(request.getParameter("model"));
        item.setBrand(request.getParameter("brand"));
        item.setService(request.getParameter("service"));
        item.setServiceNumber(request.getParameter("serviceNumber"));
        item.setCustomerId(request.getParameter("customerId"));
        item.setDate(request.getParameter("date"));
        item.setCustomerName(request.getParameter("customerName"));
        item.setPhone(request.getParameter("phone"));
        item.setComment(request.getParameter("comment"));
        System.out.println("item creado" + item.getComment());
        int respuesta = 0;
        try {
            response.sendRedirect(request.getContextPath() + "/item.jsp");
            respuesta = ItemJSON.postJSON(item);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Agregado!");
                System.out.println("registro agregado " + item);
                //response.sendRedirect(request.getContextPath() + "/item.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        //response.sendRedirect(request.getContextPath() + "/item.jsp");

    }


}
