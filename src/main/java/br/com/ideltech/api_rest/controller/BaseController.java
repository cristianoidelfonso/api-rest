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
        var msg = "Provisionando Postegres e criando perfil de Produção";
        return new ResponseEntity<>("Hello World! "+msg, HttpStatus.OK);
    }
}
