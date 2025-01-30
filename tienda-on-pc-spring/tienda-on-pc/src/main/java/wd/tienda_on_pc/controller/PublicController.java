package wd.tienda_on_pc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {

    //EndPoint que no requiere autenticacion
    @GetMapping("/home")
    public String home(){
        return "Public Home";
    }
}
