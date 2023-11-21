package com.example.springbootintro;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    //Set up the string response and allow the GET request to fill in part of the string
    private static final String template = "Hello, %s!";

    //Increment the RequestCount
    private final AtomicLong counter = new AtomicLong();

    //a response will be given at localhost:8080/response and localhost:8080
    @GetMapping({"/response","/"})
    //@RequestParam gets the value of the name parameter from the request
    //and binds it to the name parameter of the response() method
    public Response response(@RequestParam(value = "name", defaultValue = "Friend") String name) {
        //Create and return a new Response object sending the incremented requestCount
        //and a string based on the input parameter and the template defined above
        return new Response(counter.incrementAndGet(),String.format(template,name));
    }
}

