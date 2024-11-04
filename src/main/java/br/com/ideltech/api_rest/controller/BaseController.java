package br.com.ideltech.api_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.http.HttpResponse;

@Controller
public class BaseController {

    @GetMapping("/")
    ResponseEntity<String> hello() {
        var msg = "Deploy da API na nuvem Railway";
        return new ResponseEntity<>("<p>Hello World! </p><strong>"+msg+"</strong>", HttpStatus.OK);
    }
}
