package com.example.lab4.service;


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

    public String txtToJson(String string, String typeEx3) {
        String result = getResFromEx3(string, typeEx3);
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


    public String csvToJson(String string, String typeEx3) {
        String result = getResFromEx3(string, typeEx3);
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

    public String xmlToJson(String string, String typeEx3) {
        String result = getResFromEx3(string, typeEx3);
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


}
