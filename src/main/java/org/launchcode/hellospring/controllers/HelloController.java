package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
public class HelloController {


    // Handle requests of the form /hello?name=LaunchCode
    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("English")) {
            greeting = "Hello";
        }
        else if (l.equals("French")) {
            greeting = "Bonjour";
        }
        else if (l.equals("Italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("German")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }


    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language'>" +
                "<option>English</option>" +
                "<option>French</option>" +
                "<option>Italian</option>" +
                "<option>Spanish</option>" +
                "<option>German</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}