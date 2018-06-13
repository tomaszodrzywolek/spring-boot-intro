package pl.todrzywolek.springtask.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "Type /isFibbo/{number} in URL to check" +
                "if number is Fibonacci number./n" +
                "You have to be a user to see that.";
    }
}
