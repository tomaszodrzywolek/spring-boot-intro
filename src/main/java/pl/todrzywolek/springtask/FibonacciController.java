package pl.todrzywolek.springtask;

import org.springframework.web.bind.annotation.*;

@RestController
public class FibonacciController {

    @RequestMapping("/isFibbo")
    public String noNumber() {
        return  "You have to provide a number.";
    }

    @RequestMapping("/isFibbo/{number}")
    public Fibonacci checkIfNumberIsFibonacci(
            @PathVariable(value = "number", required = true) int number) {

        Fibonacci fibonacci = new Fibonacci(number);

        return fibonacci;
    }
}