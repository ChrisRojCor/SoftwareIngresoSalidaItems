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

public class SaleJSON {

    private static URL url;
    private static String site = "http//localhost:5000/";

    public static ArrayList<Sale> parsingSale(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Sale> list = new ArrayList<Sale>();
        JSONArray sale = (JSONArray) jsonParser.parse(json);
        Iterator i = sale.iterator();
        while(i.hasNext()){
            JSONObject innerObj =(JSONObject) i.next();
            Sale sale1 = new Sale();
            sale1.setOrderNumber(innerObj.get("orderNumber").toString());
            sale1.setAmount(innerObj.get("amount").toString());
            sale1.setService(innerObj.get("service").toString());
            sale1.setDiscount(innerObj.get("discount").toString());

        }
        return list;
    }

    public static ArrayList<Sale> getJSON() throws IOException, ParseException {
        url = new URL(site+"sale/list");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json");
        InputStream response = http.getInputStream();
        byte[] inp = response.readAllBytes();
        String json = "";
        for (int i = 0; i< inp.length; i++){
            json += (char)inp[i];
        }

        ArrayList<Sale> list = new ArrayList<Sale>();
        list = parsingSale(json);
        http.disconnect();
        return list;

    }

    public static int postJSON(Sale sale) throws IOException{
        url = new URL(site+"sale/save");
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
                +"\"orderNumber\":\""+ sale.getOrderNumber()
                +"\"amount\":\""+ sale.getAmount()
                +"\"service\":\""+ sale.getService()
                +"\"discount\":\""+ sale.getDiscount()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }

    public static int deleteJSON(String orderNumber) throws IOException{
        url = new URL(site+"sale/delete/"+orderNumber);
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

    public static int updateJSON(Sale sale)throws IOException{
        url = new URL(site+"sale/update");
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
                +"\"orderNumber\":\""+ sale.getOrderNumber()
                +"\"amount\":\""+ sale.getAmount()
                +"\"service\":\""+ sale.getService()
                +"\"discount\":\""+ sale.getDiscount()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }
    
}
