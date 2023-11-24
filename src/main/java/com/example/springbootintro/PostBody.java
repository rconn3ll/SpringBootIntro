package com.example.springbootintro;

//This is the object that stores the data in the body of the post request
public class PostBody {
    private String name;

    public String toString() {
        return "Hello " + this.name;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
}
