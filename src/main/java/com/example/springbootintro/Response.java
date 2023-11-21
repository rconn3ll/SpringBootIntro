package com.example.springbootintro;

//This is the object to be returned to the ResponseController class.
//it defines the names and data types of the variables in the response.
public record Response(long requestNumber, String content){
}5
