package org.example;

import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String getHello(){
        return "Hello HOW'S GOING? ";
    }

    @RequestMapping("/time")
    public String getTime(){
        String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(pattern, new Locale("en", "US"));

        String date = simpleDateFormat.format(new Date());
        return date;
        //return new Date().toString();
    }

    @RequestMapping("/myfirstpage")
    public String getMorning(){
        return "<h1>Good Morning</h1> " +
                "<p style=\"color:red;\"> ... </p>";
    }

    @RequestMapping("/myfirstpage/{username}")
    public String getMorning2(@PathVariable String username){
        return "<h1 style=\"text-align:center;\" >Good Morning</h1> " +
                "<p style=\"text-align:center;\"> " +username+" </p>";
    }



    @RequestMapping(path = "/myfirstpage/postik", method = RequestMethod.POST)
    public String postMorning3(@RequestBody String name){
        return "<h1 style=\"text-align:center;\" >Good Morning</h1> " +
                "<p style=\"text-align:center;\"> " +name+" </p>";
    }


}
