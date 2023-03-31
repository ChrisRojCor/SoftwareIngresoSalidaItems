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

public class ServiceJSON {

    private static URL url;
    private static String site = "http//localhost:5000/";

    public static ArrayList<Service> parsingService(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Service> list = new ArrayList<Service>();
        JSONArray service = (JSONArray) jsonParser.parse(json);
        Iterator i = service.iterator();
        while(i.hasNext()){
            JSONObject innerObj =(JSONObject) i.next();
            Service service1 = new Service();
            service1.setServiceNumber(innerObj.get("serviceNumber").toString());
            service1.setDate(innerObj.get("date").toString());
            service1.setItemId(innerObj.get("itemId").toString());

        }
        return list;
    }

    public static ArrayList<Service> getJSON() throws IOException, ParseException {
        url = new URL(site+"service/list");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json");
        InputStream response = http.getInputStream();
        byte[] inp = response.readAllBytes();
        String json = "";
        for (int i = 0; i< inp.length; i++){
            json += (char)inp[i];
        }

        ArrayList<Service> list = new ArrayList<Service>();
        list = parsingService(json);
        http.disconnect();
        return list;

    }

    public static int postJSON(Service service) throws IOException{
        url = new URL(site+"service/save");
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
                +"\"serviceNumber\":\""+ service.getServiceNumber()
                +"\"date\":\""+ service.getDate()
                +"\"itemId\":\""+ service.getItemId()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }

    public static int deleteJSON(String serviceNumber) throws IOException{
        url = new URL(site+"service/delete/"+serviceNumber);
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

    public static int updateJSON(Service service)throws IOException{
        url = new URL(site+"service/update");
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
                +"\"serviceNumber\":\""+ service.getServiceNumber()
                +"\"date\":\""+ service.getDate()
                +"\"itemId\":\""+ service.getItemId()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }


}

