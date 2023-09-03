package com.example.demo.сontroller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;

@RestController
public class testContoller {
    public String rrResponse;
    long secondsToSleep = 1;
    @PostConstruct
    public void init() throws Throwable

    {
        File file = new File("C:\\Users\\Евгений\\Downloads\\demo\\demo\\src\\main\\resources\\rr.json");
        rrResponse = new String(Files.readAllBytes(file.toPath()));
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<String> CheckMappingRR() throws InterruptedException
    {
        return ResponseEntity.ok().header("application/json").body(rrResponse);
    }
    @PostMapping (value = "/tester")
    public ResponseEntity<String> CheckMappingPost() throws InterruptedException

    {
        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return ResponseEntity.ok().header("application/json").body(rrResponse);
    }

}

