package com.example.demo.сontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resources;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.Files;

@RestController
public class PostConstructContoller {
    private String rrResponse;
    @PostConstruct
    public void init() throws IOException
    {
        File file = new File("rr.json");
        rrResponse = new String(Files.readAllBytes(file.toPath()));
    }
    @PostMapping("/test")
    public ResponseEntity<String> CheckMapping() throws InterruptedException
    {
        if (rrResponse == null) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка такая то");
        }
        return ResponseEntity.ok(rrResponse);
    }

}

