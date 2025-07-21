package com.omarehab.appointment_booking.SayHelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, What are you learning today?";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        return "Hello, What are you learning today?";
    }
}