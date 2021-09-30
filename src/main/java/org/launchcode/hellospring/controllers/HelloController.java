package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handle requests of the form /hello?name=LaunchCode
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //Handle requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // lives at /hello/form now
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + //submit a request to /hello, by default that method is a GET request
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet Me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
