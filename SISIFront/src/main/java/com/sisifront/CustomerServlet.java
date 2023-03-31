package com.sisifront;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter writer = response.getWriter();

        if(request.getParameter("saveButton") != null) {
            addCustomer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = new Customer();
        customer.setId(request.getParameter("id"));
        customer.setTradeName(request.getParameter("tradeName"));
        customer.setCustomerName(request.getParameter("customerName"));
        customer.setBusinessName(request.getParameter("businessName"));
        customer.setTaxpayerType(request.getParameter("taxpayerType"));
        customer.setCiiu(request.getParameter("ciiu"));
        customer.setPhone(request.getParameter("phone"));
        customer.setContactEmail(request.getParameter("contactEmail"));
        customer.setBillingEmail(request.getParameter("billingEmail"));
        customer.setAddress(request.getParameter("address"));
        customer.setCity(request.getParameter("city"));
        customer.setDepartment(request.getParameter("department"));
        int respuesta = 0;
        try {
            respuesta = CustomerJSON.postJSON(customer);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Agregado!");
                response.sendRedirect(request.getContextPath() + "/customer.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
}
