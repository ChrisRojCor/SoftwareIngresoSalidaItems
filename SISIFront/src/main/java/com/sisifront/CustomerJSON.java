package com.sisifront;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomerJSON {

    private static URL url;
    private static String site = "http//localhost:5000/";

    public static ArrayList<Customer> parsingCustomer(String json) throws net.minidev.json.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Customer> list = new ArrayList<Customer>();
        JSONArray customer = (JSONArray) jsonParser.parse(json);
        Iterator i = customer.iterator();
        while(i.hasNext()){
            JSONObject innerObj =(JSONObject) i.next();
            Customer customer1 = new Customer();
            customer1.setId(innerObj.get("id").toString());
            customer1.setTradeName(innerObj.get("tradeName").toString());
            customer1.setCustomerName(innerObj.get("customerName").toString());
            customer1.setBusinessName(innerObj.get("businessName").toString());
            customer1.setTaxpayerType(innerObj.get("taxpayerType").toString());
            customer1.setCiiu(innerObj.get("ciiu").toString());
            customer1.setPhone(innerObj.get("phone").toString());
            customer1.setContactEmail(innerObj.get("contactEmail").toString());
            customer1.setBillingEmail(innerObj.get("billingEmail").toString());
            customer1.setAddress(innerObj.get("address").toString());
            customer1.setCity(innerObj.get("city").toString());
            customer1.setDepartment(innerObj.get("department").toString());

        }
        return list;
    }

    public static ArrayList<Customer> getJSON() throws IOException, ParseException {
        url = new URL(site+"customer/list");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json");
        InputStream response = http.getInputStream();
        byte[] inp = response.readAllBytes();
        String json = "";
        for (int i = 0; i< inp.length; i++){
            json += (char)inp[i];
        }

        ArrayList<Customer> list = new ArrayList<Customer>();
        list = parsingCustomer(json);
        http.disconnect();
        return list;

    }

    public static int postJSON(Customer customer) throws IOException{
        url = new URL(site+"customer/save");
        HttpURLConnection http;
        http = (HttpURLConnection) url.openConnection();
        try{
            http.setRequestMethod("POST");
        }catch (ProtocolException e){
            e.printStackTrace();
        }
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "applicatio/json");
        http.setRequestProperty("Content-Type", "applicario/json");

        String data = "{"
                +"\"id\":\""+ customer.getId()
                +"\"tradeName\":\""+ customer.getTradeName()
                +"\"customerName\":\""+ customer.getId()
                +"\"businessName\":\""+ customer.getBusinessName()
                +"\"taxpayerType\":\""+ customer.getTaxpayerType()
                +"\"ciiu\":\""+ customer.getCiiu()
                +"\"phone\":\""+ customer.getPhone()
                +"\"contactEmail\":\""+ customer.getContactEmail()
                +"\"billingEmail\":\""+ customer.getBillingEmail()
                +"\"address\":\""+ customer.getAddress()
                +"\"city\":\""+ customer.getCity()
                +"\"department\":\""+ customer.getDepartment()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }

    public static int deleteJSON(String id) throws IOException{
        url = new URL(site+"customer/delete/"+id);
        HttpURLConnection http;
        http=(HttpURLConnection) url.openConnection();
        try{
            http.setRequestMethod("DELETE");
        }catch (ProtocolException e){
            e.printStackTrace();
        }
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }

    public static int updateJSON(Customer customer)throws IOException{
        url = new URL(site+"customer/update");
        HttpURLConnection http;
        http =(HttpURLConnection)url.openConnection();
        try{
            http.setRequestMethod("PUT");
        }catch (ProtocolException e){
            e.printStackTrace();
        }
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");
        String data = "{"
                +"\"id\":\""+ customer.getId()
                +"\"tradeName\":\""+ customer.getTradeName()
                +"\"customerName\":\""+ customer.getId()
                +"\"businessName\":\""+ customer.getBusinessName()
                +"\"taxpayerType\":\""+ customer.getTaxpayerType()
                +"\"ciiu\":\""+ customer.getCiiu()
                +"\"phone\":\""+ customer.getPhone()
                +"\"contactEmail\":\""+ customer.getContactEmail()
                +"\"billingEmail\":\""+ customer.getBillingEmail()
                +"\"address\":\""+ customer.getAddress()
                +"\"city\":\""+ customer.getCity()
                +"\"department\":\""+ customer.getDepartment()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }
}
