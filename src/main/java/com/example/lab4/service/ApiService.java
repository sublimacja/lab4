package com.example.lab4.service;


import com.example.lab4.StringHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@Service
public class ApiService {

    private static final String URI = "http://localhost:8081/api/ppkwu/lab3/";

    public String txtToJson(String string, String zad3Format) {
        String result = getResFromEx3(string, zad3Format);
        String[] str = cutString(result);
        HashMap<String, String> map = new HashMap<>();
        map.put(str[0].replaceAll(":", ""), str[1]);
        map.put(str[2].replaceAll(":", ""), str[3]);
        map.put(str[4].replaceAll(":", ""), str[5]);
        map.put(str[6].replaceAll(":", ""), str[7]);
        map.put(str[8].replaceAll(":", ""), str[9]);
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public String csvToJson(String string, String zad3Format) {
        String result = getResFromEx3(string, zad3Format);
        result = result.replaceAll("\\n", ",");
        String[] str = result.split(",");
        HashMap<String, String> map = new HashMap<>();
        map.put(str[0].replaceAll(":", ""), str[5]);
        map.put(str[1].replaceAll(":", ""), str[6]);
        map.put(str[2].replaceAll(":", ""), str[7]);
        map.put(str[3].replaceAll(":", ""), str[8]);
        map.put(str[4].replaceAll(":", ""), str[9]);
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String xmlToJson(String string, String zad3Format) {
        String result = getResFromEx3(string, zad3Format);
        JSONObject xmlJSONObj = XML.toJSONObject(result);
        return xmlJSONObj.toString(2);

    }

    public String getResFromEx3(String string, String typeEx3) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URI + string + "/" + typeEx3, String.class);
    }

    private String[] cutString(String result) {
        return result.split("\\s+");
    }


    public String txtToXml(String string, String zad3Format) {
        String result = getResFromEx3(string, zad3Format);
        String[] str = cutString(result);
        StringHelper stringHelper = new StringHelper(str[1], str[3], str[5], str[7], str[9]);
        JSONObject json = new JSONObject(stringHelper);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><stringHelper>" + XML.toString(json) + "</stringHelper>";
    }

    public String jsonToXml(String string, String zad3Format) {
        String result = getResFromEx3(string, zad3Format);
        JSONObject json = new JSONObject(result);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><stringHelper>" + XML.toString(json) + "</stringHelper>";
    }

    public String csvToXml(String string, String zad3Format) {
        return null;
    }
}
