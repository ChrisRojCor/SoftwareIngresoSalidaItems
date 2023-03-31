package com.sisifront;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class UserJSON {

    private static URL url;
    private static String sitio = "http://localhost:5000/";

    public static ArrayList<User> parsingUser(String json) throws net.minidev.json.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<User> lista = new ArrayList<User>();
        JSONArray user = (JSONArray) jsonParser.parse(json);
        Iterator i = user.iterator();
        while(i.hasNext()){
            JSONObject innerObj = (JSONObject) i.next();
            User usuario = new User();
            usuario.setId(innerObj.get("userId").toString());
            usuario.setUserEmail(innerObj.get("userEmail").toString());
            usuario.setUserName(innerObj.get("userName").toString());
            usuario.setPassword(innerObj.get("password").toString());
            lista.add(usuario);
        }
        return lista;
    }

    public static ArrayList<User> getJSON() throws IOException, net.minidev.json.parser.ParseException {
        url = new URL(sitio+"user/list");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json");
        InputStream respuesta = http.getInputStream();
        byte[] inp = respuesta.readAllBytes();
        String json = "";
        for (int i = 0; i<inp.length ; i++) {
            json += (char)inp[i];
        }
        ArrayList<User> lista = new ArrayList<User>();
        lista = parsingUser(json);
        http.disconnect();
        return lista;
    }
    
}
