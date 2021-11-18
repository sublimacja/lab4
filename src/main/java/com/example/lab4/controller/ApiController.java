package com.example.lab4.controller;


import com.example.lab4.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ppkwu")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/lab4/{string}/{zad3Format}/json")
    public String getJson(@PathVariable("string") String string, @PathVariable("zad3Format") String zad3Format) {
        if (zad3Format.equals("txt"))
            return apiService.txtToJson(string, zad3Format);
        else if (zad3Format.equals("csv"))
            return apiService.csvToJson(string, zad3Format);
        else if (zad3Format.equals("xml"))
            return apiService.xmlToJson(string, zad3Format);
        else
            return apiService.getResFromEx3(string, zad3Format);

    }

    @GetMapping(value = "/lab4/{string}/{zad3Format}/xml", produces = {"application/xml", "text/xml"})
    public String getXml(@PathVariable("string") String string, @PathVariable("zad3Format") String zad3Format) {
        if (zad3Format.equals("txt"))
            return apiService.txtToXml(string, zad3Format);
        else if (zad3Format.equals("csv"))
            return apiService.csvToXml(string, zad3Format);
        else if (zad3Format.equals("json"))
            return apiService.jsonToXml(string, zad3Format);
        else
            return apiService.getResFromEx3(string, zad3Format);
    }

    @GetMapping("/lab4/{string}/csv")
    public String getCsv(@PathVariable("string") String string, @PathVariable("zad3Format") String zad3Format) {
        return null;
    }

    @GetMapping("/lab4/{string}/txt")
    public String getTxt(@PathVariable("string") String string, @PathVariable("zad3Format") String zad3Format) {
        return null;

    }
}
