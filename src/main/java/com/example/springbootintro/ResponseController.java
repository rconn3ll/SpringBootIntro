package com.example.springbootintro;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    //Set up the string response and allow the GET request to fill in part of the string
    private static final String template = "Hello, %s!";

    //Increment the RequestCount
    private final AtomicLong counter = new AtomicLong();

    //a response will be given at localhost:8080/getresponse and localhost:8080
    @GetMapping({"/getresponse","/"})
    //@RequestParam gets the value of the name parameter from the request
    //and binds it to the name parameter of the response() method
    public GetResponse getresponse(@RequestParam(value = "name", defaultValue = "Friend") String name) {
        //Create and return a new Response object sending the incremented requestCount
        //and a string based on the input parameter and the template defined above
        return new GetResponse(counter.incrementAndGet(),String.format(template,name));
    }

    //a response will be given at localhost:8080/postresponse
    @PostMapping({"/postresponse"})
    //@RequestBody gets the value of the request body
    //We can save the body and assign its values to variables in an object
    public PostResponse postresponse(@RequestBody PostBody input) {
        //Create and return a new Response object sending the incremented requestCount
        //and a string that had an operation performed on it by the PostBody object
        return new PostResponse(counter.incrementAndGet(),input.toString());
    }
}

