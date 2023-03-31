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

public class ItemJSON {

    private static URL url;
    private static String site = "http//localhost:5000/";

    public static ArrayList<Item> parsingItem(String json) throws net.minidev.json.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Item> list = new ArrayList<Item>();
        JSONArray item = (JSONArray) jsonParser.parse(json);
        Iterator i = item.iterator();
        while(i.hasNext()){
            JSONObject innerObj =(JSONObject) i.next();
            Item item1 = new Item();
            item1.setId(innerObj.get("id").toString());
            item1.setName(innerObj.get("name").toString());
            item1.setModel(innerObj.get("model").toString());
            item1.setBrand(innerObj.get("brand").toString());

        }
        return list;
    }

    public static ArrayList<Item> getJSON() throws IOException, ParseException {
        url = new URL(site+"item/list");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json");
        InputStream response = http.getInputStream();
        byte[] inp = response.readAllBytes();
        String json = "";
        for (int i = 0; i< inp.length; i++){
            json += (char)inp[i];
        }

        ArrayList<Item> list = new ArrayList<Item>();
        list = parsingItem(json);
        http.disconnect();
        return list;

    }

    public static int postJSON(Item item) throws IOException{
        url = new URL(site+"item/save");
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
                +"\"id\":\""+ item.getId()
                +"\"name\":\""+ item.getName()
                +"\"model\":\""+ item.getModel()
                +"\"brand\":\""+ item.getBrand()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }

    public static int deleteJSON(String id) throws IOException{
        url = new URL(site+"item/delete/"+id);
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

    public static int updateJSON(Item item)throws IOException{
        url = new URL(site+"item/update");
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
                +"\"id\":\""+ item.getId()
                +"\"name\":\""+ item.getName()
                +"\"model\":\""+ item.getModel()
                +"\"brand\":\""+ item.getBrand()
                + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        int response = http.getResponseCode();
        http.disconnect();
        return response;
    }

}
