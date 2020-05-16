package controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/abc")
    public Animal setname(){
        return new Animal("shaoyue", 18);
    }
}
